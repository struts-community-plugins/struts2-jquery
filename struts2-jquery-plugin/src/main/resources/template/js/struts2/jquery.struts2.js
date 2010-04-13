/*
 * jquery.struts2.js
 *
 * Integration of jquery and jquery ui with struts 2 
 * for ajax, widget and interactions support in struts 2
 *
 * Requires use of jQuery and jQuery UI optional. 
 * Tested with jQuery 1.4.2 and jQuery UI 1.8
 *
 * Copyright (c) 2008 Eric Chijioke (obinna a-t g mail dot c o m)
 * Copyright (c) 2010 Johannes Geppert http://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global $, jQuery,  document, window, StrutsUtils  */
/*jslint evil: true */

// helper fn for console logging
// set $.fn.ajaxSubmit.debug to true to enable debug logging
function s2jlog() {
	if ($.struts2_jquery.debug) {
		var msg = '[struts2_jquery] ' + Array.prototype.join.call(arguments,'');
		if (window.console && window.console.log) {
			window.console.log(msg);
		}
		else if (window.opera && window.opera.postError) {
			window.opera.postError(msg);
		}
	}
}

function escId(id) {
	return '#' + id.replace(/(:|\.)/g, '\\$1');
}

function hideIndicator(indi) {
	if (indi) {
		$(escId(indi)).hide();
	}
	if ($.struts2_jquery.defaultIndicator != '') {
		$(escId($.struts2_jquery.defaultIndicator)).hide();
	}
}

function showIndicator(indi) {
	if (indi) {
		$(escId(indi)).show();
	}
	if ($.struts2_jquery.defaultIndicator != '') {
		$(escId($.struts2_jquery.defaultIndicator)).show();
	}
}

function publishTopic(elem, topics, data) {
	if (topics) {
		$.each(topics.split(','), function(i, to) { 
			s2jlog('publish topic : '+to);
			elem.publish(to, elem, data);
		});
	}
}

/** Publish UI topics */
function pubTops($elem, always, topics) {

	if (topics) {
		return function(event, ui) {
			var data = {};
			data.event = event;
			data.ui = ui;

			publishTopic($elem, topics, data);
			publishTopic($elem, always, data);
		};
	}
	else {
		return null;
	}
}

/** Publish Success topics */
function pubSuc(cid, always, stopics, indi, modus, options) {
	var container = $(cid);
	return function(data, status, request) {
		var orginal = {};
		orginal.data = data;
		orginal.status = status;
		orginal.request = request;

		if (modus == 'html' && !$.isArray(data) && !$.isPlainObject(data)) { container.html(data); }
		else if (modus == 'value') { container.val(data); }
		else if (modus == 'select') {
			container[0].length = 0;

			if (typeof (data) == "object" || $.isArray(data)) {
				var i = -1;
				var eopt = document.createElement("option");
				if (options.headerkey && options.headervalue) {
					var option = eopt.cloneNode(true);
					option.value = options.headerkey;
					option.text = options.headervalue;

					if (options.value == options.headervalue) {
						option.selected = true;
					}

					container[0].options[++i] = option;
				}

				if (options.emptyoption) {
					container[0].options[++i] = eopt.cloneNode(true);
				}

				var o = 0;
				if (data[options.list] !== null) {
					$.each(data[options.list], function(j, val) {
						var option = eopt.cloneNode(true);
						if (data[options.list][o] === undefined) {
							option.value = j;
							option.text = val;
						}
						else {
							if (options.listkey !== undefined && options.listvalue !== undefined) {
								option.value = val[options.listkey];
								option.text = val[options.listvalue];
							}
							else {
								option.value = data[options.list][o];
								option.text = data[options.list][o];
							}
						}

						if (options.value == option.value) {
							option.selected = true;
						}

						container[0].options[++i] = option;
						o++;
					});
				}
			}
		}

		publishTopic(container, stopics, orginal);
		publishTopic(container, always, orginal);

		// Use BBQ for Ajaxhistory
		if ($.struts2_jquery.ajaxhistory) {
			var ahparams = {};
			ahparams.cid = cid;
			ahparams.options = options;

			$(window).bind('hashchange', ahparams, function(e) {
				var topic = e.getState(e.data.cid.id) || '';
				if (e.type === topic || topic == '' || topic == $.struts2_jquery.lasttopic) { return; }
				$.struts2_jquery.lasttopic = topic;
				$.publish(topic, e.data.options);
			});
		}
	};
}

/** Publish Complete topics */
function pubCom(cid, always, ctopics, targets, indi, options) {
	var container = $(cid);
	return function(request, status) {
		var orginal = {};
		orginal.request = request;
		orginal.status = status;

		hideIndicator(indi);

		publishTopic(container, ctopics, orginal);
		publishTopic(container, always, orginal);

		var ec = targets;
		if (!ec) { ec = options.id; }
		if (ec) {
			var divEffectTopic = '_sj_div_effect_';
			$.each(ec.split(','), function(i, target) { 
				var effect_elem = $(escId(target));
				effect_elem.publish(divEffectTopic + target, effect_elem);
			});
		}
		if (options.resizable) {
			if (!$.struts2_jquery.loadAtOnce) {
				$.require(
					[
					 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.resizable"+$.struts2_jquery.minSuffix+".js"
					 ]);
			}
			var ros = options.resizableoptions;
			var ro = window[ros];
			if (!ro) {
				ro = eval("( " + ros + " )");
			}
			else {
				ro = {};
			}
			ro.start = pubTops(container, options.onalwaystopics, options.resizableonstarttopics);
			ro.stop = pubTops(container, options.onalwaystopics, options.resizableonstoptopics);
			ro.resize = pubTops(container, options.onalwaystopics, options.resizableonresizetopics);
			container.resizable(ro);
		}
	};
}

/** Publish Error topics */
function pubErr(cid, always, etopics, etext) {
	var container = $(cid);
	if (etopics || etext) {
		return function(request, status, error) {
			var orginal = {};
			orginal.request = request;
			orginal.status = status;
			orginal.error = error;

			if (etext) {
				container.html(etext);
			}

			publishTopic(container, etopics, orginal);
			publishTopic(container, always, orginal);
		};
	}
	else {
		return null;
	}
}

( function($) {
	
	/**
	 * Load required JavaScript Resourcess
	 */
	$.require = function(files, callBack, basePath) {

		var successFunction = callBack || function() {};
		if (!$.require.libCache) { $.require.libCache = {}; }
		var path = basePath || null;
		if ( path === null && !$.scriptPath ) {
			path = '';
		}
		else if( path === null && $.scriptPath ) {
			path = $.scriptPath;
		}
		
		if (typeof files === "string") {
			files = new Array(files);
		}
		$.each(files, function(i, file) { 
			if (!$.require.libCache[file]) {
				s2jlog('load require javascript '+(path + file));
				$.ajax( {
				type : "GET",
				url : path + file,
				success : successFunction,
				dataType : "script",
				cache : true,
				async : false
				});
				$.require.libCache[file] = true;
			}
		});
		return $;
	};
	
	/**
	 * Load required CSS Files
	 */
	$.requireCss = function(cssFile, basePath) {
		if (!$.requireCss.styleCache) { $.requireCss.styleCache = {}; }

		if (!$.requireCss.styleCache[cssFile]) {
			var path = basePath || null;
			if ( path === null && !$.scriptPath ) {
				path = '';
			}
			else if( path === null && $.scriptPath ) {
				path = $.scriptPath;
			}
			s2jlog('load require css '+(path + cssFile));
	
			var cssref=document.createElement("link");
		  cssref.setAttribute("rel", "stylesheet");
		  cssref.setAttribute("type", "text/css");
		  cssref.setAttribute("href", (path + cssFile));
		  document.getElementsByTagName("head")[0].appendChild(cssref);
			$.requireCss.styleCache[cssFile] = true;
		}
	  return $;
	};
	
	/**
	 * Bind Struts2 Components for jQuery AJAX and UI functions
	 */
	$.struts2_jquery = {

	debug :false,
	ajaxhistory :false,
	loadAtOnce :false,
	local : "en",
	gridLocal : "en",
	minSuffix : ".min",
	historyelements : {},
	forms : {},
	defaultIndicator :'',
	lasttopic :'',
	lastselectedrow :'',

	// pre-binding function of the type function(element){}. called before binding the element
	// returning false will prevent the binding of this element
	preBind :null,

	// post-binding function of the type function(element){}. called before binding the element
	postBind :null,

	bind : function(el, options) {

		if (el) {
			var $el = $(el);
			el = $el[0];

			var tag = el.tagName.toLowerCase();
			options.tagname = tag;

			// extension point to allow custom pre-binding processing
			if (typeof ($.struts2_jquery.preBind) != "function" || $.struts2_jquery.preBind($el)) {

				if (!options.jqueryaction) { options.jqueryaction = tag; }

				s2jlog('bind '+options.jqueryaction+' on '+options.id);
				this[options.jqueryaction]($el, options);

				// extension point to allow custom post-binding processing
				if ($.struts2_jquery.postBind && (typeof ($.struts2_jquery.postBind) == "function")) { return $.struts2_jquery.postBind(el); }
			}

		}
	},

	// register a jquery action
	jqueryaction : function(name, binder) {

		if (name && binder) {
			this[name] = binder;
		}
	},

	opendialog : function($elem, options) {
		s2jlog('open dialog : '+options.opendialog);

		if (options.opendialog) {
			var dialog = $(escId(options.opendialog));
			$elem.bind('click', function(event) {
				if (options.href && options.href != '#') {
					options.targets = options.opendialog;
					var loadHandler = '_s2j_container_load';
					var divTopic = '_s2j_dialog_load_' + options.id;
					dialog.subscribe(divTopic, loadHandler);
					dialog.publish(divTopic, options);
				}

				dialog.dialog('open');
				return false;
			});
		}
	},
	action : function($elem, options, loadHandler, type) {

		// bind event to onClick topics
		if (options.onclicktopics) {
			$.each(options.onclicktopics.split(','), function(i, topic) { 
				$elem.createTopic(topic);
				var params = {};
				params.topic = topic;
				$elem.bind('click', params, function(event) {
					var target = $(this);

					if (!target.disabled || target.disabled !== true) {

						var publishOptions = event.data || {};
						publishOptions.disabled = false;

						target.publish(event.data.topic, publishOptions, event);
					}
					return false;
				});
			});
		}
		var actionTopic = '_sj_action_' + options.id;

		var href = options.href;

		if (href === null || href == "") {
			href = "#";
			options.href = href;
		}

		var effectTopic = '_sj_div_effect_';
		var effect = {};
		effect.effect = options.effect;
		effect.effectoptions = options.effectoptions;
		effect.effectduration = options.effectduration;

		// subscribe all targets to this action's custom execute topic
		if (options.targets) {

			// target subscription needs to be done after document load in case element exists in the dom AFTER the current action object
			$( function() {
				$.each(options.targets.split(','), function(i, target) { 
					effect.targets = target;
					var tarelem = $(escId(target));

					if (tarelem.isSubscribed(actionTopic)) { tarelem.unsubscribe(actionTopic); }
					if (tarelem.isSubscribed(effectTopic + target)) { tarelem.unsubscribe(effectTopic + target); }

					tarelem.subscribe(actionTopic, loadHandler, options);
					tarelem.subscribe(effectTopic + target, '_s2j_effects', effect);

					if (options.listentopics) {
						$.each(options.listentopics.split(','), function(i, lt) { 
							if (tarelem.isSubscribed(lt)) { tarelem.unsubscribe(lt); }

							tarelem.subscribe(lt, loadHandler, options);
							tarelem.subscribe(lt, '_s2j_effects', effect);
						});
					}
					if ($.struts2_jquery.ajaxhistory) {
						var params = {};
						params.target = target;
						params.topic = actionTopic;
						$elem.bind('click', params, function(event) {
							$.struts2_jquery.historyelements[event.data.target] = event.data.topic;
							$.bbq.pushState($.struts2_jquery.historyelements);
							return false;
						});
					}
				});
			});

		}
		else { // if no targets, then the action can still execute ajax request and will handle itself (no loading result into container

			effect.targets = options.id;
			$(escId(options.id)).subscribe(effectTopic + options.id, '_s2j_effects', effect);

			// bind event topic listeners
			if (options.onbeforetopics || options.oncompletetopics || options.onsuccesstopics || options.onerrortopics) {
				if ($elem.isSubscribed(actionTopic)) { $elem.unsubscribe(actionTopic); }

				$elem.subscribe(actionTopic, loadHandler, options);
			}
		}

		if (type == "a") {
			$elem.publishOnEvent('click', actionTopic); // bind custom action topic to click event
		}

	},

	container : function($elem, options) {
		s2jlog('container : '+options.id);
		var loadHandler = '_s2j_container_load', effectHandler = '_s2j_effects';

		this.action($elem, options, loadHandler, 'div');

		// load div using ajax only when href is specified or form is defined
		if ((options.formids && !options.type) || (options.href && options.href != '#')) {
			if (options.href != '#') {

				if (options.reloadtopics) {
					$.each(options.reloadtopics.split(','), function(i, rt) { 
						if ($elem.isSubscribed(rt)) { $elem.unsubscribe(rt); }

						$elem.subscribe(rt, loadHandler, options);
					});
				}
				if (options.listentopics) {
					$.each(options.listentopics.split(','), function(i, lt) { 
						if ($elem.isSubscribed(lt)) { $elem.unsubscribe(lt); }

						$elem.subscribe(lt, loadHandler, options);
					});
				}

				// publishing not triggering to prevent event propagation issues
				var divTopic = '_s2j_div_load_' + options.id;
				if ($elem.isSubscribed(divTopic)) { $elem.unsubscribe(divTopic); }

				$elem.subscribe(divTopic, loadHandler);

				if (options.bindon) {
					var $bindElement = $('#' + options.bindon);
					if (options.events) {
						$.each(options.events.split(','), function(i, event) { 
							$bindElement.publishOnEvent(event, divTopic);
						});
					}
					else {
						$bindElement.publishOnEvent('click', divTopic);
					}
				}
				else {
					$elem.publish(divTopic, options);
				}

			}
			else if (options.formids) {
				if (!$.struts2_jquery.loadAtOnce) {
					$.require("js/plugins/jquery.form"+$.struts2_jquery.minSuffix+".js");
				}
				options.targets = options.id;
				var formTopic = '_s2j_form_topic_' + options.id;
				this.formsubmit($elem, options, formTopic);
				$elem.publish(formTopic, options);
			}
		}
		else {

			var divEffectTopic = '_s2j_div_effect_' + options.id;
			if (options.id && options.effect) {
				var effect = {};
				effect.targets = options.id;
				effect.effect = options.effect;
				effect.effectoptions = options.effectoptions;
				effect.effectduration = options.effectduration;
				if (!$elem.isSubscribed(divEffectTopic)) { $elem.subscribe(divEffectTopic, effectHandler, effect); }
			}

			if (options.events || options.bindon) {

				var bindel = $elem;
				var eventsStr = 'click';
				if (options.bindon) { bindel = $(escId(options.bindon)); }
				if (options.events) {
					eventsStr = options.events;
				}

				$.each(eventsStr.split(','), function(i, event) { 
					if (options.onbeforetopics) {
						$.each(options.onbeforetopics.split(','), function(i, btopic) { 
							bindel.publishOnEvent(event, btopic);
						});
					}
					bindel.publishOnEvent(event, divEffectTopic);
					if (options.oncompletetopics) {
						$.each(options.oncompletetopics.split(','), function(i, ctopic) { 
							bindel.publishOnEvent(event, ctopic);
						});
					}
				});
			}
			else {
				if (options.onbeforetopics) {
					$.each(options.onbeforetopics.split(','), function(i, bts) { 
						$elem.publish(bts, $elem);
					});
				}
				$elem.publish(divEffectTopic, $elem);
				if (options.oncompletetopics) {
					$.each(options.oncompletetopics.split(','), function(i, cts) { 
						$elem.publish(cts, $elem);
					});
				}
			}

			if (options.resizable) {
				if (!$.struts2_jquery.loadAtOnce) {
					$.require(
						[
						 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
						 "js/base/jquery.ui.mouse"+$.struts2_jquery.minSuffix+".js",
						 "js/base/jquery.ui.resizable"+$.struts2_jquery.minSuffix+".js"
						 ]);
				}
				var ros = options.resizableoptions;
				var ro = window[ros];
				if (!ro) {
					ro = eval("( " + ros + " )");
				}
				else {
					ro = {};
				}
				ro.start = pubTops($elem, options.onalwaystopics, options.resizableonstarttopics);
				ro.stop = pubTops($elem, options.onalwaystopics, options.resizableonstoptopics);
				ro.resize = pubTops($elem, options.onalwaystopics, options.resizableonresizetopics);
				$elem.resizable(ro);
			}
		}

		if (options.draggable) {
			s2jlog('draggable : '+options.id);
			if (!$.struts2_jquery.loadAtOnce) {
				$.require(
					[
					 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.draggable"+$.struts2_jquery.minSuffix+".js"
					 ]);
			}
			var daos = options.draggableoptions;
			var dao = window[daos];
			if (!dao) {
				dao = eval("( " + daos + " )");
			}
			else {
				dao = {};
			}
			dao.start = pubTops($elem, options.onalwaystopics, options.draggableonstarttopics);
			dao.stop = pubTops($elem, options.onalwaystopics, options.draggableonstoptopics);
			dao.drap = pubTops($elem, options.onalwaystopics, options.draggableondragtopics);
			$elem.draggable(dao);
		}

		if (options.droppable) {
			s2jlog('droppable : '+options.id);
			if (!$.struts2_jquery.loadAtOnce) {
				$.require(
					[
					 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.draggable"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.droppable"+$.struts2_jquery.minSuffix+".js"
					 ]);
			}
			var doos = options.droppableoptions;
			var doo = window[doos];
			if (!doo) {
				doo = eval("( " + doos + " )");
			}
			else {
				doo = {};
			}
			doo.activate = pubTops($elem, options.onalwaystopics, options.droppableonactivatetopics);
			doo.deactivate = pubTops($elem, options.onalwaystopics, options.droppableondeactivatetopics);
			doo.start = pubTops($elem, options.onalwaystopics, options.droppableonstarttopics);
			doo.stop = pubTops($elem, options.onalwaystopics, options.droppableonstoptopics);
			doo.drop = pubTops($elem, options.onalwaystopics, options.droppableondroptopics);
			$elem.droppable(doo);
		}

		if (options.selectable) {
			s2jlog('selectable : '+options.id);
			if (!$.struts2_jquery.loadAtOnce) {
				$.require(
					[
					 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.selectable"+$.struts2_jquery.minSuffix+".js"
					 ]);
			}
			var seos = options.selectableoptions;
			var seo = window[seos];
			if (!seo) {
				seo = eval("( " + seos + " )");
			}
			else {
				seo = {};
			}
			seo.selected = pubTops($elem, options.onalwaystopics, options.selectableonselectedtopics);
			seo.selecting = pubTops($elem, options.onalwaystopics, options.selectableonselectingtopics);
			seo.start = pubTops($elem, options.onalwaystopics, options.selectableonstarttopics);
			seo.stop = pubTops($elem, options.onalwaystopics, options.selectableonstoptopics);
			seo.unselected = pubTops($elem, options.onalwaystopics, options.selectableonunselectedtopics);
			seo.unselecting = pubTops($elem, options.onalwaystopics, options.selectableonunselectingtopics);
			$elem.selectable(seo);
		}

		if (options.sortable) {
			s2jlog('sortable : '+options.id);
			if (!$.struts2_jquery.loadAtOnce) {
				$.require(
					[
					 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+$.struts2_jquery.minSuffix+".js",
					 "js/base/jquery.ui.sortable"+$.struts2_jquery.minSuffix+".js"
					 ]);
			}
			var soos = options.sortableoptions;
			var soo = window[soos];
			if (!soo) {
				soo = eval("( " + soos + " )");
			}
			else {
				soo = {};
			}
			soo.beforeStop = pubTops($elem, options.onalwaystopics, options.sortableonbeforestoptopics);
			soo.stop = pubTops($elem, options.onalwaystopics, options.sortableonstoptopics);
			soo.start = pubTops($elem, options.onalwaystopics, options.sortableonstarttopics);
			soo.sort = pubTops($elem, options.onalwaystopics, options.sortableonsorttopics);
			soo.activate = pubTops($elem, options.onalwaystopics, options.sortableonactivatetopics);
			soo.deactivate = pubTops($elem, options.onalwaystopics, options.sortableondeactivatetopics);
			soo.over = pubTops($elem, options.onalwaystopics, options.sortableonovertopics);
			soo.out = pubTops($elem, options.onalwaystopics, options.sortableonouttopics);
			soo.remove = pubTops($elem, options.onalwaystopics, options.sortableonremovetopics);
			soo.receive = pubTops($elem, options.onalwaystopics, options.sortableonreceivetopics);
			soo.change = pubTops($elem, options.onalwaystopics, options.sortableonchangetopics);
			soo.update = pubTops($elem, options.onalwaystopics, options.sortableonupdatetopics);
			$elem.sortable(soo);
		}
		
		if (options.onchangetopics) {
			if (options.type) {
				if(options.type == 'text') {
					$elem.keyup(function() {
						publishTopic($elem, options.onchangetopics, {});
					});
				}
				else if (options.type == 'select') {
					$elem.change(function() {
						publishTopic($elem, options.onchangetopics, {});
					});
				}
			}
		}
	},

	anchor : function($elem, options) {
		s2jlog('anchor : '+options.id);
		var loadHandler = '_s2j_container_load';

		if(options.opendialog) { this.opendialog($elem, options); }
		if(options.button) { this.jquerybutton($elem, options); }

		if (options.formids) {
			var formTopic = '_s2j_form_topic_' + options.id;
			this.formsubmit($elem, options, formTopic);
			$elem.publishOnEvent('click', formTopic);
		}
		else {
			this.action($elem, options, loadHandler, 'a');
		}
	},

	select : function($elem, options) {
		s2jlog('select : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require("js/plugins/jquery.form"+$.struts2_jquery.minSuffix+".js");
		}
		var handler = '_s2j_container_load';
		var selectTopic = '_s2j_topic_load_' + options.id;

		if (options.href && options.href != '#') {

			if (options.reloadtopics) {
				$.each(options.reloadtopics.split(','), function(i, rts) { 
					$elem.subscribe(rts, handler, options);
				});
			}
			if (options.listentopics) {
				$.each(options.listentopics.split(','), function(i, lts) { 
					$elem.subscribe(lts, handler, options);
				});
			}

			$elem.subscribe(selectTopic, handler);
			$elem.publish(selectTopic, options);
		}
		if (options.onchangetopics) {
			$.each(options.onchangetopics.split(','), function(i, cts) { 
				$elem.publishOnEvent('change', cts);
			});
		}
	},

	button : function($elem, options) {
		var formTopic = '_s2j_form_topic_' + options.id;

		if(options.opendialog) { this.opendialog($elem, options); }
		if(options.button) { this.jquerybutton($elem, options); }

		if (options.formids !== undefined) {
			this.formsubmit($elem, options, formTopic);
		}
		else {
			var cform = $elem.parents('form:first')[0];
			if (cform !== undefined) {
				var cf = $(cform);
				var formid = cf.attr("id");
				if (formid !== undefined) {
					options.formids = formid;
				}
				else {
					var randomid = 's2jqform' + Math.floor(Math.random() * 10000);
					cf.attr('id', randomid);
					options.formids = randomid;
				}
				this.formsubmit($elem, options, formTopic);
			}
			else {
				this.action($elem, options, '_s2j_container_load', 'a');
			}
		}
		$elem.publishOnEvent('click', formTopic);
		$elem.removeAttr('name');
	},
	formsubmit : function($elem, options, topic) {
		s2jlog('formsubmit : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require("js/plugins/jquery.form"+$.struts2_jquery.minSuffix+".js");
		}
		var formHandler = '_s2j_form_submit';

		if (options.reloadtopics) {
			$.each(options.reloadtopics.split(','), function(i, rts) { 
				$elem.subscribe(rts, formHandler, options);
			});
		}
		if (options.listentopics) {
			$.each(options.listentopics.split(','), function(i, lt) { 
				$elem.subscribe(lt, formHandler, options);
			});
		}

		$elem.subscribe(topic, formHandler, options);
		if (options.targets) {
			$.each(options.targets.split(','), function(i, target) { 
				$(escId(target)).subscribe(topic, '_s2j_effects', options);
				if ($.struts2_jquery.ajaxhistory) {
					var params = {};
					params.target = target;
					params.topic = topic;
					$elem.bind('click', params, function(event) {
						$.struts2_jquery.historyelements[event.data.target] = event.data.topic;
						$.bbq.pushState($.struts2_jquery.historyelements);
						return false;
					});
				}
			});
		}
	},

	dialog : function($elem, options) {
		s2jlog('dialog : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require(
				[
				 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.button"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.draggable"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.mouse"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.position"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.resizable"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.bgiframe"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.dialog"+$.struts2_jquery.minSuffix+".js"
				 ]);
		}
		var params = {};
		$.extend(params, options);
		params.bgiframe = true;
		if (options.hide) {
			if (!$.struts2_jquery.loadAtOnce) {
				$.require(["js/base/jquery.effects.core"+$.struts2_jquery.minSuffix+".js","js/base/jquery.effects."+options.hide+""+$.struts2_jquery.minSuffix+".js"]);
			}
			params.hide = options.hide;
		}
		if (options.show) {
			if (!$.struts2_jquery.loadAtOnce) {
				$.require(["js/base/jquery.effects.core"+$.struts2_jquery.minSuffix+".js","js/base/jquery.effects."+options.show+""+$.struts2_jquery.minSuffix+".js"]);
			}
			params.show = options.show;
		}
		params.open = function(event, ui) {
			var data = {};
			data.event = event;
			data.ui = ui;

			if (options.href && options.href != '#') {
				var loadHandler = '_s2j_container_load';
				var divTopic = '_s2j_topic_load_' + options.id;
				$elem.subscribe(divTopic, loadHandler);
				$elem.publish(divTopic, options);
			}

			publishTopic($elem, options.onalwaystopics, data);
			publishTopic($elem, options.onbeforetopics, data);
			publishTopic($elem, options.onopentopics, data);
		};
		params.close = pubTops($elem, options.onalwaystopics, options.onclosetopics);
		params.focus = pubTops($elem, options.onalwaystopics, options.onfocustopics);
		params.beforeclose = pubTops($elem, options.onalwaystopics, options.onbeforeclosetopics);
		params.drag = pubTops($elem, options.onalwaystopics, options.onchangetopics);
		$elem.dialog(params);
	},

	tabbedpanel : function($elem, options) {
		s2jlog('tabbedpanel : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require(
				[
				 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.tabs"+$.struts2_jquery.minSuffix+".js"
				 ]);
		}
		if (!options) {
			options = {};
		}
		var para = {};

		if (options.disabledtabs && options.disabledtabs != 'false') {
			var disabledtabsStr = options.disabledtabs;
			var disabledtabs = window[disabledtabsStr];
			if (!disabledtabs) {
				para.disabled = eval("( " + disabledtabsStr + " )");
			}
		}
		if (options.cache) { para.cache = true; }
		if (options.animate) { 
			if (!$.struts2_jquery.loadAtOnce) {
				$.require("js/base/jquery.effects.core"+$.struts2_jquery.minSuffix+".js");
			}
			para.fx = {	opacity :'toggle'	};
		}
		if (options.cookie) { 
			if (!$.struts2_jquery.loadAtOnce) {
				$.require("js/plugins/jquery.cookie"+$.struts2_jquery.minSuffix+".js");
			}
			para.cookie = {
			expires :30
		};}
		if (options.collapsible) { para.collapsible = true; }
		if (options.openonmouseover) { para.event = 'mouseover'; }
		if (options.orientation) { para.orientation = options.orientation; }
		if (options.spinner !== 'undefined') { para.spinner = options.spinner; }
		if (options.selectedtab) { para.selected = options.selectedtab; }
		if (options.oncompletetopics) { para.ajaxOptions = {
		dataType :'html',
		complete :pubCom(options.id, options.onalwaystopics, options.oncompletetopics, null, null, {})
		};}
		else { para.ajaxOptions = {
			dataType :'html'
		};}
		if (options.onbeforetopics) { para.show = pubTops($elem, options.onalwaystopics, options.onbeforetopics); }
		if (options.onchangetopics) { para.select = pubTops($elem, options.onalwaystopics, options.onchangetopics); }
		if (options.onenabletopics) { para.enable = pubTops($elem, options.onalwaystopics, options.onenabletopics); }
		if (options.ondisabletopics) { para.disable = pubTops($elem, options.onalwaystopics, options.ondisabletopics); }
		if (options.onaddtopics) { para.add = pubTops($elem, options.onalwaystopics, options.onaddtopics); }
		if (options.onremovetopics) { para.remove = pubTops($elem, options.onalwaystopics, options.onremovetopics); }

		if (options.tabs) {
			var tabStr = "";
			for ( var l = 0; l < options.tabs.length; l++) {
				var tab = options.tabs[l];
				tabStr += "<li ";
				if (tab.id) { tabStr += "id='" + tab.id + "' "; }
				if (tab.cssstyle) { tabStr += "style='" + tab.cssstyle + "' "; }
				if (tab.cssclass) { tabStr += "class='" + tab.cssclass + "' "; }
				tabStr += "><a href='" + tab.href + "' ";
				if (tab.label) { tabStr += "title='" + tab.label + "' "; }
				tabStr += "><span>";
				if (tab.label) { tabStr += tab.label; }
				tabStr += "</span></a></li>";
			}
			$(escId(options.id) + ' ul').html(tabStr);
		}

		$elem.tabs(para);

		// History and Bookmarking for Tabs
		if ($.struts2_jquery.ajaxhistory) {
			var ahp = {};
			ahp.id = options.id;
			$elem.find('ul.ui-tabs-nav a').bind('click', ahp, function(e) {
				var idx = $(escId(e.data.id)).tabs('option', 'selected');
				$.struts2_jquery.historyelements[e.data.id] = idx;
				$.bbq.pushState($.struts2_jquery.historyelements);
				return false;
			});

			$(window).bind('hashchange', ahp, function(e) {
				var idx = e.getState(e.data.id, true) || 0;
				$(escId(e.data.id)).tabs('select', idx);
			});
		}
	},

	datepicker : function($elem, options) {
		s2jlog('datepicker : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
		$.require(
				[
				 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.datepicker"+$.struts2_jquery.minSuffix+".js"
				 ]);
		}
		if ($.struts2_jquery.local != "en") {
			$.require("i18n/jquery.ui.datepicker-"+$.struts2_jquery.local+".min.js");
		}
		var params = {};

		if (options) {

			var oat = options.onalwaystopics;

			if (options.onbeforetopics) {
				params.beforeShow = function(input, inst) {
					var $input = $(input);
					var data = {};
					data.input = input;
					data.inst = inst;
					publishTopic($input, options.onbeforetopics, data);
					publishTopic($input, oat, data);
				};
			}

			if (options.onbeforeshowdaytopics) {
				params.beforeShowDay = function(date) {
					var data = {};
					data.date = date;
					publishTopic($elem, options.onbeforeshowdaytopics, data);
					publishTopic($elem, oat, data);
				};
			}

			if (options.onchangemonthyeartopics) {
				params.onChangeMonthYear = function(year, month, inst) {
					var data = {};
					data.year = year;
					data.month = month;
					data.inst = inst;
					var $inst = $(inst);
					publishTopic($inst, options.onchangemonthyeartopics, data);
					publishTopic($inst, oat, data);
				};
			}

			if (options.onchangetopics) {
				params.onSelect = function(dateText, inst) {
					var $inst = $(inst);
					var data = {};
					data.dateText = dateText;
					publishTopic($inst, options.onchangetopics, data);
					publishTopic($inst, oat, data);
				};
			}

			if (options.oncompletetopics) {
				params.onClose = function(dateText, inst) {
					var $inst = $(inst);
					var data = {};
					data.dateText = dateText;
					publishTopic($inst, options.oncompletetopics, data);
					publishTopic($inst, oat, data);
				};
			}

			if (options.changemonth) { params.changeMonth = true; }
			if (options.changeyear) { params.changeYear = true; }
			if (options.showbuttonpanel) { params.showButtonPanel = true; }
			if (options.buttonimageonly) { params.buttonImageOnly = true; }
			if (options.displayformat){  params.dateFormat = options.displayformat; }
			else { params.dateFormat = $.datepicker._defaults.dateFormat; }
			params.buttonImage = options.buttonimage;
			params.showOn = options.showon;
			params.buttonText = options.buttontext;
			
			if (options.showanim){
				if (!$.struts2_jquery.loadAtOnce) {
					$.require("js/base/jquery.effects.core"+$.struts2_jquery.minSuffix+".js");
				}
				params.showAnim = options.showanim;
			}
			
			params.firstDay = options.firstday;
			params.yearRange = options.yearrange;
			params.duration = options.duration;
			params.appendText = options.appendtext;
			params.maxDate = options.maxdate;
			params.minDate = options.mindate;

			if (options.numberofmonths) {
				var numberofmonthsStr = options.numberofmonths;
				var numberofmonths = window[numberofmonthsStr];
				if (!numberofmonths) {
					params.numberOfMonths = eval("( " + numberofmonthsStr + " )");
				}
			}

			if (options.showoptions) {
				var userOptionsStr = options.showoptions;
				var userOptions = window[userOptionsStr];
				if (!userOptions) {
					params.showOptions = eval("( " + userOptionsStr + " )");
				}
			}
		}

		$elem.datepicker(params);

		if (options.year && options.month && options.day) {
			$elem.val($.datepicker.formatDate(params.dateFormat, new Date(options.year, options.month, options.day)));
		}
		if (options.zindex) {
			$('#ui-datepicker-div').css("z-index", options.zindex);
		}
	},
	slider : function($elem, options) {
		s2jlog('slider : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require(
				[
				 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.mouse"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.slider"+$.struts2_jquery.minSuffix+".js"
				 ]);
		}

		var params = {};
		if (options) {

			params.start = pubTops($elem, options.onalwaystopics, options.onbeforetopics);
			params.change = pubTops($elem, options.onalwaystopics, options.onchangetopics);
			params.stop = pubTops($elem, options.onalwaystopics, options.oncompletetopics);

			params.slide = function(event, ui) {
				$(escId(options.hiddenid)).val(ui.value);
				if (options.displayvalueelement) {
					$(escId(options.displayvalueelement)).html(ui.value);
				}
			};

			if (options.animate) { params.animate = true; }
			var value = options.value;
			if (value > 0) { params.value = value; }
			else { params.value = 0; }
			if (options.max) { params.max = options.max; }
			if (options.min) { params.min = options.min; }
			if (options.orientation) { params.orientation = options.orientation; }
			if (options.step) { params.step = options.step; }

			if (options.range) {
				if (options.range == 'true') {
					params.range = true;
				}
				else {
					params.range = options.range;
				}
			}
		}

		$elem.slider(params);
	},
	progressbar : function($elem, options) {
		s2jlog('progressbar : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require(
				[
				 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.progressbar"+$.struts2_jquery.minSuffix+".js"
				 ]);
		}
		var params = {};
		if (options) {

			params.change = pubTops($elem, options.onalwaystopics, options.onchangetopics);

			var value = options.value;
			if (value > 0) { params.value = value; }
			else { params.value = 0; }
		}
		$elem.progressbar(params);
	},
	accordion : function($elem, options) {
		s2jlog('accordion : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require(
				[
				 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.accordion"+$.struts2_jquery.minSuffix+".js"
				 ]);
		}
		var params = {};
		var active = true;
		if (options) {

			if (options.fillspace) { params.fillSpace = true; }
			if (options.collapsible) { params.collapsible = true; }
			if (options.clearstyle) { params.clearStyle = true; }
			if (options.autoheight) { params.autoHeight = true; }
			if (options.event) { params.event = options.event; }
			if (options.header) { params.header = options.header; }
			else { params.header = 'h3'; }
			if (options.animated) {
				if (options.animated == 'true') { params.animated = true; }
				else if (options.animated === false) { params.animated = false; }
				else { params.animated = options.animated; }
			}

			if (options.active) {
				if (options.active == 'true') {
					params.active = true;
				}
				else if (options.active == 'false') {
					params.active = false;
					active = false;
				}
				else {
					params.active = parseInt(options.active, 10);
				}
			}

			var onAlwaysTopics = options.onalwaystopics;
			params.changestart = function(event, ui) {
				if (options.href) {
					if (typeof $(ui.newHeader).find('a').attr('paramkeys') != "undefined") {
						var keys = $(ui.newHeader).find('a').attr('paramkeys').split(',');
						var values = $(ui.newHeader).find('a').attr('paramvalues').split(',');
						var valueparams = {};
						$.each(keys, function(i, val) {
							valueparams[val] = values[i];
						});
						ui.newContent.load(options.href, valueparams, function() {
						});
					}
				}
				if (options.onbeforetopics) {
					var data = {};
					data.event = event;
					data.ui = ui;

					publishTopic($elem, onAlwaysTopics, data);
					publishTopic($elem, options.onbeforetopics, data);
				}
			};

			params.change = pubTops($elem, options.onalwaystopics, options.onchangetopics);
		}
		$elem.accordion(params);
		if (options.href && active === true) {
			var aktiv = $(escId(options.id) + " li " + params.header).filter('.ui-accordion-header').filter('.ui-state-active').find('a');
			if (typeof $(aktiv).attr('paramkeys') != "undefined") {
				var keys = $(aktiv).attr('paramkeys').split(',');
				var values = $(aktiv).attr('paramvalues').split(',');
				var valueparams = {};
				$.each(keys, function(i, val) {
					valueparams[val] = values[i];
				});
				$(escId(options.id) + " li div").filter('.ui-accordion-content-active').load(options.href, valueparams, function() {
				});
			}
		}
	},
	autocompleter : function($elem, options) {
		s2jlog('autocompleter for : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require(
				[
				 "js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.position"+$.struts2_jquery.minSuffix+".js",
				 "js/base/jquery.ui.autocomplete"+$.struts2_jquery.minSuffix+".js"
				 ]);
		}
		var params = {};
		if (options.href && options.href != '#') {
			params.source = options.href;
			if (options.hrefparameter) {
				params.source = params.source + '?' + options.hrefparameter;
			}
		}
		else if (options.list && options.selectBox === false) {
			params.source = options.list;
		}
		if (options.delay) {
			params.delay = options.delay;
		}
		if (options.minimum) {
			params.minLength = options.minimum;
		}

		if (options.onsuccesstopics) { params.open = pubTops($elem, options.onalwaystopics, options.onsuccesstopics); }
		if (options.onchangetopics) { params.change = pubTops($elem, options.onalwaystopics, options.onchangetopics); }
		if (options.oncompletetopics) { params.close = pubTops($elem, options.onalwaystopics, options.oncompletetopics); }
		if (options.onsearchtopics) { params.search = pubTops($elem, options.onalwaystopics, options.onsearchtopics); }
		if (options.onfocustopics) { params.focus = pubTops($elem, options.onalwaystopics, options.onfocustopics); }
		if (options.onselecttopics) { params.select = pubTops($elem, options.onalwaystopics, options.onselecttopics); }

		if (options.selectBox === false) { $elem.autocomplete(params); }
		else { 
			$.require("js/plugins/jquery.combobox"+$.struts2_jquery.minSuffix+".js");
			$elem.combobox(params); 
		}
	},
	jquerybutton : function($elem, options) {
		s2jlog('button for : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require(["js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js","js/base/jquery.ui.button"+$.struts2_jquery.minSuffix+".js"]);
		}
		if (options.button) {
			var params = {};
			params.icons = {};
			if (options.buttonIcon) {
				params.icons.primary = options.buttonIcon;
			}
			if (options.buttonIconSecondary) {
				params.icons.secondary = options.buttonIconSecondary;
			}
			$elem.button(params);
		}
	},
	buttonset : function($elem, options) {
		s2jlog('buttonset for : '+options.id);
		if (!$.struts2_jquery.loadAtOnce) {
			$.require(["js/base/jquery.ui.widget"+$.struts2_jquery.minSuffix+".js","js/base/jquery.ui.button"+$.struts2_jquery.minSuffix+".js"]);
		}
		$elem.buttonset(options);
	}
	};

	/** Container logic */
	// Register handler to load a container
	$.subscribeHandler('_s2j_container_load', function(event, data) {

		var container = $(event.target);
		var options = {};
		if (data) { $.extend(options, data); }
		if (event.data) { $.extend(options, event.data); }

		var isDisabled = false;
		isDisabled = options.disabled === null ? isDisabled : options.disabled;
		isDisabled = container.attr('disabled') === null ? isDisabled : container.attr('disabled');
		if (event.originalEvent) { // means that container load is being triggered by other action (link button/link click) need to see if that button/link is disabled
			isDisabled = $(event.originalEvent.currentTarget).attr("disabled") === null ? isDisabled : $(event.originalEvent.currentTarget).attr("disabled");
		}

		if (isDisabled !== true && isDisabled != 'true') {

			// Show indicator element (if any)
			if (options) {

				var indi = options.indicatorid;
				showIndicator(options.indicatorid);
				var onAlwaysTopics = options.onalwaystopics;

				// publish all 'before' and 'always' topics
				publishTopic(container, onAlwaysTopics, options);
				publishTopic(container, options.onbeforetopics, options);

				// Set pre-loading text (if any)
				if (options.loadingtext) {
					container.html(options.loadingtext);
				}

				var modus = 'html';
				if (options.type) {
					if (options.type == 'text') { modus = 'value'; }
					else if (options.type == 'select') { modus = 'select'; }
				}

				var params = {};

				params.success = pubSuc(event.target, onAlwaysTopics, options.onsuccesstopics, indi, modus, options);
				params.complete = pubCom(event.target, onAlwaysTopics, options.oncompletetopics, options.targets, indi, options);
				params.error = pubErr(event.target, onAlwaysTopics, options.onerrortopics, options.errortext);

				// load container using ajax
				if (options.href) {
					params.type = "POST";
					params.url = options.href;
					params.data = '';
					if (options.hrefparameter) {
						params.data = options.hrefparameter;
					}

					if (options.formids) {
						if (!$.struts2_jquery.loadAtOnce) {
							$.require("js/plugins/jquery.form"+$.struts2_jquery.minSuffix+".js");
						}
						$.each(options.formids.split(','), function(i, fid) {
							var query = $(escId(fid)).formSerialize();
							if (params.data != '') { params.data = params.data + '&' + query; }
							else { params.data = query; }
						});
					}

					if (options.datatype) {params.dataType = options.datatype; }
					else { params.dataType = 'html'; }

					// fix 'issue' wherein IIS will reject post without data
					if (!params.data) { params.data = {};	} 

					// Execute Ajax Request
					$.ajax(params);
				}
			}
		}
	});

	/** Form logic */
	// Handler to submit a form with jquery.form.js plugin
	$.subscribeHandler('_s2j_form_submit', function(event, data) {
		var container = $(event.target);
		var elem = container;

		// need to also make use of original attributes registered with the container (such as onCompleteTopics)
		var options = {};
		if (data) { $.extend(options, data); }
		if (event.data) { $.extend(options, event.data); }

		var params = {};
		if (options.href && options.href != '#') {
			params.url = options.href;
			if (options.hrefparameter) {
				params.url = params.url + '?' + options.hrefparameter;
			}
		}
		if (options.clearform) { params.clearForm = true; }
		if (options.iframe) { params.iframe = true; }
		if (options.resetform) { params.resetForm = true; }
		if (options.replaceTarget) { params.replaceTarget = true; }
		if (options.timeout) { params.timeout = parseInt(options.timeout, 10); }
		if (options.datatype) { params.dataType = options.datatype; }
		else { params.dataType = null; }

		params.target = '';
		if (options.targets) {
			$.each(options.targets.split(','), function(i, target) { 
				elem = $(escId(target));
				if (params.target == '') {
					params.target = escId(target);
				}
				else {
					params.target = params.target + ',#' + escId(target);
				}

				// Set pre-loading text (if any)
				if (options.loadingtext) {
					$(escId(target)).html(options.loadingtext);
				}
			});
		}

		var indi = options.indicatorid;
		showIndicator(indi);


		params.beforeSubmit = function(formData, form, formoptions) {

			var orginal = {};
			orginal.formData = formData;
			orginal.form = form;
			orginal.options = formoptions;
			orginal.options.submit = true;

			publishTopic(container, options.onalwaystopics, orginal);

			if (options.onbeforetopics) {
				$.each(options.onbeforetopics.split(','), function(i, topic) { 
					elem.publish(topic, elem, orginal);
					var submitForm = orginal.options.submit;
					// cancel form submission
					if (!submitForm) {
						hideIndicator(options.indicatorid);
						if (options.loadingtext) {
							$.each(options.targets.split(','), function(i, target) { 
								$(escId(target)).html(options.loadingtext);
							});
						}
					}
				});
			}

			if (options.validate) {
				var valParams = {};
				valParams.type = "POST";
				if (options.href && options.href != '#') { valParams.url = options.href; }
				else { valParams.url = form[0].action; }

				valParams.data = '';
				if (options.hrefparameter) {
					valParams.data = options.hrefparameter;
				}

				var query = form.formSerialize();
				query = query + '&struts.enableJSONValidation=true&struts.validateOnly=true';
				if (valParams.data != '') { valParams.data = valParams.data + '&amp;' + query; }
				else { valParams.data = query; }

				valParams.complete = function(request, status) {
					var f = $(form[0]);
					if ($.isFunction(options.validateFunction)) {
						var et = request.responseText;
						if (et && et.length > 10) {
							orginal.options.submit = false;
							var errors = $.parseJSON(et.substring(2, et.length - 2));
							options.validateFunction(f, errors);
						}
					}
					else if (StrutsUtils !== undefined) {
						StrutsUtils.clearValidationErrors(form[0]);

						// get errors from response
						var text = request.responseText;
						var errorsObject = StrutsUtils.getValidationErrors(text);

						// show errors, if any
						if (errorsObject.fieldErrors) {
							StrutsUtils.showValidationErrors(form[0], errorsObject);
							orginal.options.submit = false;
						}
					}
					s2jlog('form validation : '+orginal.options.submit);
				};
				$.ajax(valParams);
			}
			if (!orginal.options.submit) {
				hideIndicator(options.indicatorid);
			}
			return orginal.options.submit;
		};

		params.success = pubSuc(elem, options.onalwaystopics, options.onsuccesstopics, indi, 'form', options);
		params.complete = pubCom(elem, options.onalwaystopics, options.oncompletetopics, options.targets, indi, options);
		params.error = pubErr(elem, options.onalwaystopics, options.onerrortopics, options.errortext);

		$.each(options.formids.split(','), function(i, fid) { 
			s2jlog('submit form : '+fid);
			$(escId(fid)).ajaxSubmit(params);
		});

		return false;
	});

	/** Effects */
	// Register handler for effects
	$.subscribeHandler('_s2j_effects', function(event, data) {
		var options = {};
		$.extend(options, event.data);
		if (options.targets && options.effect) {
			var eo = {};
			var duration = 2000;
			if (options.effectoptions) {
				eo = options.effectoptions;
			}
			if (options.effectduration) {
				duration = options.effectduration;
			}
			if (!$.struts2_jquery.loadAtOnce) {
				$.require(["js/base/jquery.effects.core"+$.struts2_jquery.minSuffix+".js","js/base/jquery.effects."+options.effect+""+$.struts2_jquery.minSuffix+".js"]);
			}
			s2jlog('effect '+options.effect+' for '+options.targets);
			$(escId(options.targets)).effect(options.effect, eo, duration);
		}
	});

})(jQuery);
