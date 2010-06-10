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

/*global $, jQuery, _s2j, document, window, StrutsUtils  */
/*jslint evil: true */

( function($) {
	
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
	scriptCache : {},
	styleCache : {},
	defaults : {
		indicator :'',
		loadingText : null,
		errorText : null
	},
	handler : {
		load : '_s2j_container_load',
		form : '_s2j_form_submit',
		effect : '_s2j_effects'
	},


	//helper function for debug logging
	//set debug to true in the head tag to enable debug logging
	log : function(message) {
		if (this.debug) {
			var msg = '[struts2_jquery] '+message;
			if (window.console && window.console.log) {
				window.console.log(msg);
			}
			else if (window.opera && window.opera.postError) {
				window.opera.postError(msg);
			}
		}
	},
	
	/*
	 * Escape Ids
	 */
	escId : function (id) {
		return '#' + id.replace(/(:|\.)/g, '\\$1');
	},
	
	/*
	 * Load required JavaScript Resourcess
	 */
	require : function(files, callBack, basePath) {

		var successFunction = callBack || function() {};
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
			if (!_s2j.scriptCache[file]) {
				_s2j.log('load require script '+(path + file));
				$.ajax( {
				type : "GET",
				url : path + file,
				success : successFunction,
				dataType : "script",
				cache : true,
				async : false
				});
				_s2j.scriptCache[file] = true;
			}
		});
	},

	/*
	 * Load required CSS Files
	 */
	requireCss : function(cssFile, basePath) {
		if (!this.styleCache[cssFile]) {
			var path = basePath || null;
			if ( path === null && !$.scriptPath ) {
				path = '';
			}
			else if( path === null && $.scriptPath ) {
				path = $.scriptPath;
			}
			this.log('load require css '+(path + cssFile));
	
			var cssref=document.createElement("link");
		  cssref.setAttribute("rel", "stylesheet");
		  cssref.setAttribute("type", "text/css");
		  cssref.setAttribute("href", (path + cssFile));
		  document.getElementsByTagName("head")[0].appendChild(cssref);
			this.styleCache[cssFile] = true;
		}
	},
	
	// helper function to hide indicator
	hideIndicator : function (indi) {
		if (indi) {
			$(this.escId(indi)).hide();
		}
		if (this.defaults.indicator != '') {
			$(this.escId(this.defaults.indicator)).hide();
		}
	},

	// helper function to show indicator
	showIndicator : function (indi) {
		if (indi) {
			$(this.escId(indi)).show();
		}
		if (this.defaults.indicator != '') {
			$(this.escId(this.defaults.indicator)).show();
		}
	},
	
	// Helper function to publish UI topics
	pubTops : function ($elem, always, topics) {

		if (topics) {
			return function(event, ui) {
				var data = {};
				data.event = event;
				data.ui = ui;

				_s2j.publishTopic($elem, topics, data);
				_s2j.publishTopic($elem, always, data);
			};
		}
		else {
			return null;
		}
	},

	// Helper function to publish topics
	publishTopic : function (elem, topics, data) {
		if (topics) {
			$.each(topics.split(','), function(i, to) { 
				_s2j.log('publish topic : '+to);
				elem.publish(to, elem, data);
			});
		}
	},

	/** Publish Success topics */
	pubSuc : function (cid, always, stopics, indi, modus, options) {
		var container = $(cid);
		return function(data, status, request) {
			var orginal = {};
			orginal.data = data;
			orginal.status = status;
			orginal.request = request;

			if (modus == 'html' && !$.isArray(data) && !$.isPlainObject(data)) { container.html(data); }
			else if (modus == 'value') { 
				var tData = $.trim(data); 
				container.val(tData); 
			}
			else if (modus == 'select' || modus == 'radio' || modus == 'checkbox') {
				container[0].length = 0;
				
				if (typeof (data) == "object" || $.isArray(data)) {
					var i = -1;
					var eopt;
					if (modus == 'radio') {
						eopt = document.createElement("input");
						eopt.name=options.name;
						eopt.type='radio';
					}
					else if (modus == 'checkbox') {
						eopt = document.createElement("input");
						eopt.name=options.name;
						eopt.type='checkbox';
					}
					else{
						eopt = document.createElement("option");
					}
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

							if (modus == 'select') {
								container[0].options[++i] = option;
							}
							else {
								
								option.id=options.name+(++i);
								container.append($(option));
								container.append(
										$('<label id="'+option.id+'label" for="'+option.id+'">'+option.text+'</label>')
								);
							}
							o++;
						});
					}
				}
			}

			_s2j.publishTopic(container, stopics, orginal);
			_s2j.publishTopic(container, always, orginal);

			// Use BBQ for Ajaxhistory
			if (_s2j.ajaxhistory) {
				var ahparams = {};
				ahparams.cid = cid;
				ahparams.options = options;

				$(window).bind('hashchange', ahparams, function(e) {
					var topic = e.getState(e.data.cid.id) || '';
					if (e.type === topic || topic == '' || topic == _s2j.lasttopic) { return; }
					_s2j.lasttopic = topic;
					$.publish(topic, e.data.options);
				});
			}
		};
	},

	/** Publish Complete topics */
	pubCom : function (cid, always, ctopics, targets, indi, options) {
		var container = $(cid);
		return function(request, status) {
			var orginal = {};
			orginal.request = request;
			orginal.status = status;

			_s2j.hideIndicator(indi);

			_s2j.publishTopic(container, ctopics, orginal);
			_s2j.publishTopic(container, always, orginal);

			var ec = targets;
			if (!ec) { ec = options.id; }
			if (ec) {
				var divEffectTopic = '_sj_div_effect_';
				$.each(ec.split(','), function(i, target) { 
					var effect_elem = $(_s2j.escId(target));
					effect_elem.publish(divEffectTopic + target, effect_elem);
				});
			}
			if (options.resizable) {
				if (!_s2j.loadAtOnce) {
					_s2j.require(
						[
						 "js/base/jquery.ui.widget"+_s2j.minSuffix+".js",
						 "js/base/jquery.ui.mouse"+_s2j.minSuffix+".js",
						 "js/base/jquery.ui.resizable"+_s2j.minSuffix+".js"
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
				ro.start = _s2j.pubTops(container, options.onalwaystopics, options.resizableonstarttopics);
				ro.stop = _s2j.pubTops(container, options.onalwaystopics, options.resizableonstoptopics);
				ro.resize = _s2j.pubTops(container, options.onalwaystopics, options.resizableonresizetopics);
				container.resizable(ro);
			}
		};
	},

	// publish error topics
	pubErr : function (cid, always, etopics, etext, modus) {
		var container = $(cid);
		if (etopics || etext) {
			return function(request, status, error) {
				var orginal = {};
				orginal.request = request;
				orginal.status = status;
				orginal.error = error;

				if (modus == 'html' || modus == 'value') {
					if (etext && etext != "false") {
						container.html(etext);
					}
					else if (_s2j.defaults.errorText !== null) {
						container.html(_s2j.defaults.errorText);
					}
				}

				_s2j.publishTopic(container, etopics, orginal);
				_s2j.publishTopic(container, always, orginal);
			};
		}
		else {
			return null;
		}
	},

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
			if (typeof (this.preBind) != "function" || this.preBind($el)) {

				if (!options.jqueryaction) { options.jqueryaction = tag; }

				this.log('bind '+options.jqueryaction+' on '+options.id);
				this[options.jqueryaction]($el, options);

				// extension point to allow custom post-binding processing
				if (this.postBind && (typeof (this.postBind) == "function")) { return this.postBind(el); }
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
		this.log('open dialog : '+options.opendialog);

		if (options.opendialog) {
			var dialog = $(this.escId(options.opendialog));
			$elem.bind('click', function(event) {
				if (options.href && options.href != '#') {
					options.targets = options.opendialog;
					var divTopic = '_s2j_dialog_load_' + options.id;
					if (!dialog.isSubscribed(divTopic)) { dialog.subscribe(divTopic, _s2j.handler.load); }
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
				$.each(options.targets.split(','), function(i, target) { 
					effect.targets = target;
					var tarelem = $(_s2j.escId(target));

					if (tarelem.isSubscribed(actionTopic)) { tarelem.unsubscribe(actionTopic); }
					if (tarelem.isSubscribed(effectTopic + target)) { tarelem.unsubscribe(effectTopic + target); }

					tarelem.subscribe(actionTopic, loadHandler, options);
					tarelem.subscribe(effectTopic + target, _s2j.handler.effect, effect);

					if (options.listentopics) {
						$.each(options.listentopics.split(','), function(i, lt) { 
							if (tarelem.isSubscribed(lt)) { tarelem.unsubscribe(lt); }

							tarelem.subscribe(lt, loadHandler, options);
							tarelem.subscribe(lt, _s2j.handler.effect, effect);
						});
					}
					if (this.ajaxhistory) {
						var params = {};
						params.target = target;
						params.topic = actionTopic;
						$elem.bind('click', params, function(event) {
							_s2j.historyelements[event.data.target] = event.data.topic;
							$.bbq.pushState(_s2j.historyelements);
							return false;
						});
					}
				});
		}
		else { // if no targets, then the action can still execute ajax request and will handle itself (no loading result into container

			effect.targets = options.id;
			$(this.escId(options.id)).subscribe(effectTopic + options.id, this.handler.effect, effect);

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
		this.log('container : '+options.id);
		this.action($elem, options, this.handler.load, 'div');

		// load div using ajax only when href is specified or form is defined
		if ((options.formids && !options.type) || (options.href && options.href != '#')) {
			if (options.href != '#') {

				if (options.reloadtopics) {
					$.each(options.reloadtopics.split(','), function(i, rt) { 
						if ($elem.isSubscribed(rt)) { $elem.unsubscribe(rt); }

						$elem.subscribe(rt, _s2j.handler.load, options);
					});
				}
				if (options.listentopics) {
					$.each(options.listentopics.split(','), function(i, lt) { 
						if ($elem.isSubscribed(lt)) { $elem.unsubscribe(lt); }

						$elem.subscribe(lt, _s2j.handler.load, options);
					});
				}

				// publishing not triggering to prevent event propagation issues
				var divTopic = '_s2j_div_load_' + options.id;
				if ($elem.isSubscribed(divTopic)) { $elem.unsubscribe(divTopic); }

				$elem.subscribe(divTopic, _s2j.handler.load);

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
                else if (! options.deferredloading) {
					$elem.publish(divTopic, options);
				}

			}
			else if (options.formids) {
				if (!this.loadAtOnce) {
					this.require("js/plugins/jquery.form"+this.minSuffix+".js");
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
				if (!$elem.isSubscribed(divEffectTopic)) { $elem.subscribe(divEffectTopic, this.handler.effect, effect); }
			}

			if (options.events || options.bindon) {

				var bindel = $elem;
				var eventsStr = 'click';
				if (options.bindon) { bindel = $(this.escId(options.bindon)); }
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
				if (!this.loadAtOnce) {
					this.require(
						[
						 "js/base/jquery.ui.widget"+this.minSuffix+".js",
						 "js/base/jquery.ui.mouse"+this.minSuffix+".js",
						 "js/base/jquery.ui.resizable"+this.minSuffix+".js"
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
				ro.start = this.pubTops($elem, options.onalwaystopics, options.resizableonstarttopics);
				ro.stop = this.pubTops($elem, options.onalwaystopics, options.resizableonstoptopics);
				ro.resize = this.pubTops($elem, options.onalwaystopics, options.resizableonresizetopics);
				$elem.resizable(ro);
			}
		}

		if (options.draggable) {
			this.log('draggable : '+options.id);
			if (!this.loadAtOnce) {
				this.require(
					[
					 "js/base/jquery.ui.widget"+this.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+this.minSuffix+".js",
					 "js/base/jquery.ui.draggable"+this.minSuffix+".js"
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
			dao.start = this.pubTops($elem, options.onalwaystopics, options.draggableonstarttopics);
			dao.stop = this.pubTops($elem, options.onalwaystopics, options.draggableonstoptopics);
			dao.drap = this.pubTops($elem, options.onalwaystopics, options.draggableondragtopics);
			$elem.draggable(dao);
		}

		if (options.droppable) {
			this.log('droppable : '+options.id);
			if (!this.loadAtOnce) {
				this.require(
					[
					 "js/base/jquery.ui.widget"+this.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+this.minSuffix+".js",
					 "js/base/jquery.ui.draggable"+this.minSuffix+".js",
					 "js/base/jquery.ui.droppable"+this.minSuffix+".js"
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
			doo.activate = this.pubTops($elem, options.onalwaystopics, options.droppableonactivatetopics);
			doo.deactivate = this.pubTops($elem, options.onalwaystopics, options.droppableondeactivatetopics);
			doo.start = this.pubTops($elem, options.onalwaystopics, options.droppableonstarttopics);
			doo.stop = this.pubTops($elem, options.onalwaystopics, options.droppableonstoptopics);
			doo.drop = this.pubTops($elem, options.onalwaystopics, options.droppableondroptopics);
			$elem.droppable(doo);
		}

		if (options.selectable) {
			this.log('selectable : '+options.id);
			if (!this.loadAtOnce) {
				this.require(
					[
					 "js/base/jquery.ui.widget"+this.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+this.minSuffix+".js",
					 "js/base/jquery.ui.selectable"+this.minSuffix+".js"
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
			seo.selected = this.pubTops($elem, options.onalwaystopics, options.selectableonselectedtopics);
			seo.selecting = this.pubTops($elem, options.onalwaystopics, options.selectableonselectingtopics);
			seo.start = this.pubTops($elem, options.onalwaystopics, options.selectableonstarttopics);
			seo.stop = this.pubTops($elem, options.onalwaystopics, options.selectableonstoptopics);
			seo.unselected = this.pubTops($elem, options.onalwaystopics, options.selectableonunselectedtopics);
			seo.unselecting = this.pubTops($elem, options.onalwaystopics, options.selectableonunselectingtopics);
			$elem.selectable(seo);
		}

		if (options.sortable) {
			this.log('sortable : '+options.id);
			if (!this.loadAtOnce) {
				this.require(
					[
					 "js/base/jquery.ui.widget"+this.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+this.minSuffix+".js",
					 "js/base/jquery.ui.sortable"+this.minSuffix+".js"
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
			soo.beforeStop = this.pubTops($elem, options.onalwaystopics, options.sortableonbeforestoptopics);
			soo.stop = this.pubTops($elem, options.onalwaystopics, options.sortableonstoptopics);
			soo.start = this.pubTops($elem, options.onalwaystopics, options.sortableonstarttopics);
			soo.sort = this.pubTops($elem, options.onalwaystopics, options.sortableonsorttopics);
			soo.activate = this.pubTops($elem, options.onalwaystopics, options.sortableonactivatetopics);
			soo.deactivate = this.pubTops($elem, options.onalwaystopics, options.sortableondeactivatetopics);
			soo.over = this.pubTops($elem, options.onalwaystopics, options.sortableonovertopics);
			soo.out = this.pubTops($elem, options.onalwaystopics, options.sortableonouttopics);
			soo.remove = this.pubTops($elem, options.onalwaystopics, options.sortableonremovetopics);
			soo.receive = this.pubTops($elem, options.onalwaystopics, options.sortableonreceivetopics);
			soo.change = this.pubTops($elem, options.onalwaystopics, options.sortableonchangetopics);
			soo.update = this.pubTops($elem, options.onalwaystopics, options.sortableonupdatetopics);
			$elem.sortable(soo);
		}
		
		if (options.onchangetopics) {
			if (options.type) {
				if(options.type == 'text') {
					$elem.keyup(function() {
						_s2j.publishTopic($elem, options.onchangetopics, {});
					});
				}
				else if (options.type == 'select') {
					$elem.change(function() {
						_s2j.publishTopic($elem, options.onchangetopics, {});
					});
				}
			}
		}
	},

	anchor : function($elem, options) {
		this.log('anchor : '+options.id);

		if(options.opendialog) { this.opendialog($elem, options); }
		if(options.button) { this.jquerybutton($elem, options); }

		if (options.formids) {
			var formTopic = '_s2j_form_topic_' + options.id;
			this.formsubmit($elem, options, formTopic);
			$elem.publishOnEvent('click', formTopic);
		}
		else {
			this.action($elem, options, this.handler.load, 'a');
		}
	},

	select : function($elem, options) {
		this.log('select : '+options.id);
		if (!this.loadAtOnce) {
			this.require("js/plugins/jquery.form"+this.minSuffix+".js");
		}
		var selectTopic = '_s2j_topic_load_' + options.id;

		if (options.href && options.href != '#') {

			if (options.reloadtopics) {
				$.each(options.reloadtopics.split(','), function(i, rts) { 
					if (!$elem.isSubscribed(rts)) { $elem.subscribe(rts, _s2j.handler.load, options); }
				});
			}
			if (options.listentopics) {
				$.each(options.listentopics.split(','), function(i, lts) { 
					if (!$elem.isSubscribed(lts)) { $elem.subscribe(lts, _s2j.handler.load, options); }
				});
			}

			if ($elem.isSubscribed(selectTopic)) { $elem.unsubscribe(selectTopic); }
			$elem.subscribe(selectTopic, _s2j.handler.load);
            if (! options.deferredloading) {
			    $elem.publish(selectTopic, options);
			}
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
				this.action($elem, options, this.handler.load, 'a');
			}
		}
		$elem.publishOnEvent('click', formTopic);
		$elem.removeAttr('name');
	},
	formsubmit : function($elem, options, topic) {
		this.log('formsubmit : '+options.id);
		if (!this.loadAtOnce) {
			this.require("js/plugins/jquery.form"+this.minSuffix+".js");
		}

		if (options.reloadtopics) {
			$.each(options.reloadtopics.split(','), function(i, rts) { 
				$elem.subscribe(rts, _s2j.handler.form, options);
			});
		}
		if (options.listentopics) {
			$.each(options.listentopics.split(','), function(i, lt) { 
				$elem.subscribe(lt, _s2j.handler.form, options);
			});
		}

		$elem.subscribe(topic, _s2j.handler.form, options);
		if (options.targets) {
			$.each(options.targets.split(','), function(i, target) { 
				$(_s2j.escId(target)).subscribe(topic, _s2j.handler.effect, options);
				if (_s2j.ajaxhistory) {
					var params = {};
					params.target = target;
					params.topic = topic;
					$elem.bind('click', params, function(event) {
						_s2j.historyelements[event.data.target] = event.data.topic;
						$.bbq.pushState(_s2j.historyelements);
						return false;
					});
				}
			});
		}
		else {
			//Submit Forms without AJAX 
			$elem.click( function(){
				$(_s2j.escId(options.formids)).submit();
			});
		}
	},

	dialog : function($elem, options) {
		this.log('dialog : '+options.id);
		if (!this.loadAtOnce) {
			this.require(
				[
				 "js/base/jquery.ui.widget"+this.minSuffix+".js",
				 "js/base/jquery.ui.button"+this.minSuffix+".js",
				 "js/base/jquery.ui.mouse"+this.minSuffix+".js",
				 "js/base/jquery.ui.position"+this.minSuffix+".js",
				 "js/base/jquery.ui.resizable"+this.minSuffix+".js",
				 "js/base/jquery.ui.draggable"+this.minSuffix+".js",
				 "js/base/jquery.bgiframe"+this.minSuffix+".js",
				 "js/base/jquery.ui.dialog"+this.minSuffix+".js"
				 ]);
		}
		var params = {};
		$.extend(params, options);
		params.bgiframe = true;
		if (options.hide) {
			if (!this.loadAtOnce) {
				this.require(["js/base/jquery.effects.core"+this.minSuffix+".js","js/base/jquery.effects."+options.hide+""+this.minSuffix+".js"]);
			}
			params.hide = options.hide;
		}
		if (options.show) {
			if (!this.loadAtOnce) {
				this.require(["js/base/jquery.effects.core"+this.minSuffix+".js","js/base/jquery.effects."+options.show+""+this.minSuffix+".js"]);
			}
			params.show = options.show;
		}
		params.open = function(event, ui) {
			var data = {};
			data.event = event;
			data.ui = ui;

			if (options.href && options.href != '#') {
				var divTopic = '_s2j_topic_load_' + options.id;
				if (!$elem.isSubscribed(divTopic)) { $elem.subscribe(divTopic, _s2j.handler.load); }
				$elem.publish(divTopic, options);
			}

			_s2j.publishTopic($elem, options.onalwaystopics, data);
			_s2j.publishTopic($elem, options.onbeforetopics, data);
			_s2j.publishTopic($elem, options.onopentopics, data);
		};
		params.close = this.pubTops($elem, options.onalwaystopics, options.onclosetopics);
		params.focus = this.pubTops($elem, options.onalwaystopics, options.onfocustopics);
		params.beforeclose = this.pubTops($elem, options.onalwaystopics, options.onbeforeclosetopics);
		params.drag = this.pubTops($elem, options.onalwaystopics, options.onchangetopics);
		$elem.dialog(params);
	},

	tabbedpanel : function($elem, options) {
		this.log('tabbedpanel : '+options.id);
		if (!this.loadAtOnce) {
			this.require(
				[
				 "js/base/jquery.ui.widget"+this.minSuffix+".js",
				 "js/base/jquery.ui.tabs"+this.minSuffix+".js"
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
			if (!this.loadAtOnce) {
				this.require("js/base/jquery.effects.core"+this.minSuffix+".js");
			}
			para.fx = {	opacity :'toggle'	};
		}
		if (options.cookie) { 
			if (!this.loadAtOnce) {
				this.require("js/base/jquery.cookie"+this.minSuffix+".js");
			}
			para.cookie = {
			expires :30
		};}
		if (options.collapsible) { para.collapsible = true; }
		if (options.openonmouseover) { para.event = 'mouseover'; }
		if (options.orientation) { para.orientation = options.orientation; }
		
		if (options.spinner !== undefined) { para.spinner = options.spinner; }
		else if (_s2j.defaults.loadingText !== null) { para.spinner = _s2j.defaults.loadingText; }
		
		if (options.selectedtab) { para.selected = options.selectedtab; }
		if (options.oncompletetopics) { para.ajaxOptions = {
		dataType :'html',
		complete :this.pubCom(options.id, options.onalwaystopics, options.oncompletetopics, null, null, {})
		};}
		else { para.ajaxOptions = {
			dataType :'html'
		};}
		if (options.onbeforetopics) { para.show = this.pubTops($elem, options.onalwaystopics, options.onbeforetopics); }
		if (options.onchangetopics) { para.select = this.pubTops($elem, options.onalwaystopics, options.onchangetopics); }
		if (options.onenabletopics) { para.enable = this.pubTops($elem, options.onalwaystopics, options.onenabletopics); }
		if (options.ondisabletopics) { para.disable = this.pubTops($elem, options.onalwaystopics, options.ondisabletopics); }
		if (options.onaddtopics) { para.add = this.pubTops($elem, options.onalwaystopics, options.onaddtopics); }
		if (options.onremovetopics) { para.remove = this.pubTops($elem, options.onalwaystopics, options.onremovetopics); }

		var tabs = $elem.data('taboptions');
		if (tabs) {
			var tabStr = "";
			for ( var l = 0; l < tabs.length; l++) {
				var tab = tabs[l];
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
			$(this.escId(options.id) + ' > ul').html(tabStr);
		}

		$elem.tabs(para);

		// History and Bookmarking for Tabs
		if (this.ajaxhistory) {
			var ahp = {};
			ahp.id = options.id;
			$elem.find('ul.ui-tabs-nav a').bind('click', ahp, function(e) {
				var idx = $(this.escId(e.data.id)).tabs('option', 'selected');
				_s2j.historyelements[e.data.id] = idx;
				$.bbq.pushState(_s2j.historyelements);
				return false;
			});

			$(window).bind('hashchange', ahp, function(e) {
				var idx = e.getState(e.data.id, true) || 0;
				$(this.escId(e.data.id)).tabs('select', idx);
			});
		}
	},

	datepicker : function($elem, options) {
		this.log('datepicker : '+options.id);
		if (!this.loadAtOnce) {
		this.require(
				[
				 "js/base/jquery.ui.widget"+this.minSuffix+".js",
				 "js/base/jquery.ui.datepicker"+this.minSuffix+".js"
				 ]);
		}
		if (this.local != "en") {
			this.require("i18n/jquery.ui.datepicker-"+this.local+".min.js");
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
					this.publishTopic($input, options.onbeforetopics, data);
					this.publishTopic($input, oat, data);
				};
			}

			if (options.onbeforeshowdaytopics) {
				params.beforeShowDay = function(date) {
					var data = {};
					data.date = date;
					this.publishTopic($elem, options.onbeforeshowdaytopics, data);
					this.publishTopic($elem, oat, data);
				};
			}

			if (options.onchangemonthyeartopics) {
				params.onChangeMonthYear = function(year, month, inst) {
					var data = {};
					data.year = year;
					data.month = month;
					data.inst = inst;
					this.publishTopic($inst, options.onchangemonthyeartopics, data);
					this.publishTopic($inst, oat, data);
				};
			}

			if (options.onchangetopics) {
				params.onSelect = function(dateText, inst) {
					var data = {};
					data.dateText = dateText;
					data.inst = inst;
					this.publishTopic($inst, options.onchangetopics, data);
					this.publishTopic($inst, oat, data);
				};
			}

			if (options.oncompletetopics) {
				params.onClose = function(dateText, inst) {
					var data = {};
					data.dateText = dateText;
					data.inst = inst;
					_s2j.publishTopic($inst, options.oncompletetopics, data);
					_s2j.publishTopic($inst, oat, data);
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
				if (!this.loadAtOnce) {
					this.require("js/base/jquery.effects.core"+this.minSuffix+".js");
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
		this.log('slider : '+options.id);
		if (!this.loadAtOnce) {
			this.require(
				[
				 "js/base/jquery.ui.widget"+this.minSuffix+".js",
				 "js/base/jquery.ui.mouse"+this.minSuffix+".js",
				 "js/base/jquery.ui.slider"+this.minSuffix+".js"
				 ]);
		}

		var params = {};
		if (options) {

			params.start = this.pubTops($elem, options.onalwaystopics, options.onbeforetopics);
			params.change = this.pubTops($elem, options.onalwaystopics, options.onchangetopics);
			params.stop = this.pubTops($elem, options.onalwaystopics, options.oncompletetopics);

			params.slide = function(event, ui) {
				if (options.hiddenid) {
					$(_s2j.escId(options.hiddenid)).val(ui.value);
				}
				if (options.displayvalueelement) {
					$(_s2j.escId(options.displayvalueelement)).html(ui.value);
				}
				if (options.onslidetopics) {
					var data = {};
					data.event = event;
					data.ui = ui;

					this.publishTopic($elem, options.onalwaystopics, data);
					this.publishTopic($elem, options.onslidetopics, data);
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
		this.log('progressbar : '+options.id);
		if (!this.loadAtOnce) {
			this.require(
				[
				 "js/base/jquery.ui.widget"+this.minSuffix+".js",
				 "js/base/jquery.ui.progressbar"+this.minSuffix+".js"
				 ]);
		}
		var params = {};
		if (options) {

			params.change = this.pubTops($elem, options.onalwaystopics, options.onchangetopics);

			var value = options.value;
			if (value > 0) { params.value = value; }
			else { params.value = 0; }
		}
		$elem.progressbar(params);
	},
	accordion : function($elem, options) {
		this.log('accordion : '+options.id);
		if (!this.loadAtOnce) {
			this.require(
				[
				 "js/base/jquery.ui.widget"+this.minSuffix+".js",
				 "js/base/jquery.ui.accordion"+this.minSuffix+".js"
				 ]);
		}
		var params = {};
		var active = true;
		if (options) {

			if (options.fillspace) { params.fillSpace = true; }
			if (options.collapsible) { params.collapsible = true; }
			if (options.clearstyle) { params.clearStyle = true; }
			if (options.autoheight !== undefined) {
				if (options.autoheight) {
					params.autoHeight = true;
				}
				else {
					params.autoHeight = false;
				}
			}
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

					this.publishTopic($elem, onAlwaysTopics, data);
					this.publishTopic($elem, options.onbeforetopics, data);
				}
			};

			params.change = this.pubTops($elem, options.onalwaystopics, options.onchangetopics);
		}
		$elem.accordion(params);
		if (options.href && active === true) {
			var aktiv = $(this.escId(options.id) + " li " + params.header).filter('.ui-accordion-header').filter('.ui-state-active').find('a');
			if (typeof $(aktiv).attr('paramkeys') != "undefined") {
				var keys = $(aktiv).attr('paramkeys').split(',');
				var values = $(aktiv).attr('paramvalues').split(',');
				var valueparams = {};
				$.each(keys, function(i, val) {
					valueparams[val] = values[i];
				});
				$(this.escId(options.id) + " li div").filter('.ui-accordion-content-active').load(options.href, valueparams, function() {
				});
			}
		}
	},
	autocompleter : function($elem, options) {
		this.log('autocompleter for : '+options.id);
		if (!this.loadAtOnce) {
			this.require(
				[
				 "js/base/jquery.ui.widget"+this.minSuffix+".js",
				 "js/base/jquery.ui.position"+this.minSuffix+".js",
				 "js/base/jquery.ui.autocomplete"+this.minSuffix+".js"
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

		if (options.onsuccesstopics) { params.open = this.pubTops($elem, options.onalwaystopics, options.onsuccesstopics); }
		if (options.onchangetopics) { params.change = this.pubTops($elem, options.onalwaystopics, options.onchangetopics); }
		if (options.oncompletetopics) { params.close = this.pubTops($elem, options.onalwaystopics, options.oncompletetopics); }
		if (options.onsearchtopics) { params.search = this.pubTops($elem, options.onalwaystopics, options.onsearchtopics); }
		if (options.onfocustopics) { params.focus = this.pubTops($elem, options.onalwaystopics, options.onfocustopics); }
		if (options.onselecttopics) { params.select = this.pubTops($elem, options.onalwaystopics, options.onselecttopics); }

		if (options.selectBox === false) { $elem.autocomplete(params); }
		else { 
			this.require("js/plugins/jquery.combobox"+this.minSuffix+".js");
			$elem.combobox(params); 
		}
	},
	jquerybutton : function($elem, options) {
		this.log('button for : '+options.id);
		if (!this.loadAtOnce) {
			this.require(["js/base/jquery.ui.widget"+this.minSuffix+".js","js/base/jquery.ui.button"+this.minSuffix+".js"]);
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
		this.log('buttonset for : '+options.id);
		if (!this.loadAtOnce) {
			this.require(["js/base/jquery.ui.widget"+this.minSuffix+".js","js/base/jquery.ui.button"+this.minSuffix+".js"]);
		}
		var buttonsetLoadTopic = '_s2j_topic_load_' + options.id;

		if (options.href && options.href != '#') {

			var buttonsetTopic = 's2j_butonset_'+options.id;
			
			if ($elem.isSubscribed(buttonsetTopic)) { $elem.unsubscribe(buttonsetTopic); }
			
			// Init Buttonset after elements loaded via AJAX.
			$elem.subscribe(buttonsetTopic, function(event,data) {
				if (options.onchangetopics) {
					$(_s2j.escId(options.id)+" > input").change(function() {
						$.each(options.onchangetopics.split(','), function(i, cts) { 
							$elem.publish(cts);
						});
					});
				}

				$elem.buttonset(options);
			});
			if(options.oncompletetopics && options.oncompletetopics != '') {
				options.oncompletetopics = buttonsetTopic;
			}
			else {
				options.oncompletetopics = buttonsetTopic;
			}

			if (options.reloadtopics) {
				$.each(options.reloadtopics.split(','), function(i, rts) { 
					$elem.subscribe(rts, _s2j.handler.load, options);
				});
			}
			if (options.listentopics) {
				$.each(options.listentopics.split(','), function(i, lts) { 
					$elem.subscribe(lts, _s2j.handler.load, options);
				});
			}

			$elem.subscribe(buttonsetLoadTopic, _s2j.handler.load);
			$elem.publish(buttonsetLoadTopic, options);
		}
		else {
			if (options.onchangetopics) {
				$(_s2j.escId(options.id)+" > input").change(function() {
					$.each(options.onchangetopics.split(','), function(i, cts) { 
						$elem.publish(cts);
					});
				});
			}

			$elem.buttonset(options);
		}
	}
	};

	/** Create a shorthand to reduce code */
	var _s2j = $.struts2_jquery;
	
	/** Container logic */
	// Register handler to load a container
	$.subscribeHandler(_s2j.handler.load, function(event, data) {

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
				_s2j.showIndicator(options.indicatorid);
				var onAlwaysTopics = options.onalwaystopics;

				var modus = 'html';
				if (options.type) {
					if (options.type == 'text') { modus = 'value'; }
					else if (options.type == 'select') { modus = 'select'; }
					else if (options.type == 'checkbox') { modus = 'checkbox'; }
					else if (options.type == 'radio') { modus = 'radio'; }
				}

				if (modus == 'html' || modus == 'value') {
					// Set pre-loading text (if any)
					if (options.loadingtext && options.loadingtext != "false") {
						if(modus == 'html') {
							container.html(options.loadingtext);
						}
						else{
							container.val(options.loadingtext);
						}
					}
					else if (_s2j.defaults.loadingText !== null) {
						if(modus == 'html') {
							container.html(_s2j.defaults.loadingText);
						}
						else{
							container.val(_s2j.defaults.loadingText);
						}
					}
				}
				var params = {};

				params.success = _s2j.pubSuc(event.target, onAlwaysTopics, options.onsuccesstopics, indi, modus, options);
				params.complete = _s2j.pubCom(event.target, onAlwaysTopics, options.oncompletetopics, options.targets, indi, options);
				params.error = _s2j.pubErr(event.target, onAlwaysTopics, options.onerrortopics, options.errortext, modus);

				// load container using ajax
				if (options.href) {
					params.type = "POST";
					params.url = options.href;
					params.data = '';
					if (options.hrefparameter) {
						params.data = options.hrefparameter;
					}

					if (options.formids && params.data == '') {
						if (!_s2j.loadAtOnce) {
							_s2j.require("js/plugins/jquery.form"+_s2j.minSuffix+".js");
						}
						$.each(options.formids.split(','), function(i, fid) {
							var query = $(_s2j.escId(fid)).formSerialize();
							if (params.data != '') {
									params.data = params.data + '&' + query;
							}
							else { 
								params.data = query; 
							}
						});
					}

					if (options.datatype) {params.dataType = options.datatype; }
					else { params.dataType = 'html'; }

					// fix 'issue' wherein IIS will reject post without data
					if (!params.data) { params.data = {};	} 

					options.options = params;
					// publish all 'before' and 'always' topics
					_s2j.publishTopic(container, onAlwaysTopics, options);
					_s2j.publishTopic(container, options.onbeforetopics, options);

					// Execute Ajax Request
					$.ajax(params);
				}
			}
		}
	});

	/** Form logic */
	// Handler to submit a form with jquery.form.js plugin
	$.subscribeHandler(_s2j.handler.form, function(event, data) {
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
				elem = $(_s2j.escId(target));
				if (params.target == '') {
					params.target = _s2j.escId(target);
				}
				else {
					params.target = params.target + ',#' + _s2j.escId(target);
				}
			});
		}

		var indi = options.indicatorid;
		_s2j.showIndicator(indi);


		params.beforeSubmit = function(formData, form, formoptions) {

			var orginal = {};
			orginal.formData = formData;
			orginal.form = form;
			orginal.options = formoptions;
			orginal.options.submit = true;

			_s2j.publishTopic(container, options.onalwaystopics, orginal);

			if (options.onbeforetopics) {
				$.each(options.onbeforetopics.split(','), function(i, topic) { 
					elem.publish(topic, elem, orginal);
					var submitForm = orginal.options.submit;
					// cancel form submission
					if (!submitForm) {
						_s2j.hideIndicator(options.indicatorid);
						if (options.loadingtext && options.loadingtext != "false") {
							$.each(options.targets.split(','), function(i, target) { 
								$(_s2j.escId(target)).html(options.loadingtext);
							});
						}
						else if (_s2j.defaults.loadingText !== null) {
							$.each(options.targets.split(','), function(i, target) { 
								$(_s2j.escId(target)).html(_s2j.defaults.loadingText);
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
					_s2j.log('form validation : '+orginal.options.submit);
				};
				$.ajax(valParams);
			}
			if (!orginal.options.submit) {
				_s2j.hideIndicator(options.indicatorid);
			}
			return orginal.options.submit;
		};

		params.success = _s2j.pubSuc(elem, options.onalwaystopics, options.onsuccesstopics, indi, 'form', options);
		params.complete = _s2j.pubCom(elem, options.onalwaystopics, options.oncompletetopics, options.targets, indi, options);
		params.error = _s2j.pubErr(elem, options.onalwaystopics, options.onerrortopics, options.errortext, 'html');

		$.each(options.formids.split(','), function(i, fid) { 
			_s2j.log('submit form : '+fid);
			$(_s2j.escId(fid)).ajaxSubmit(params);
		});

		return false;
	});

	/** Effects */
	// Register handler for effects
	$.subscribeHandler(_s2j.handler.effect, function(event, data) {
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
			if (!_s2j.loadAtOnce) {
				_s2j.require(["js/base/jquery.effects.core"+_s2j.minSuffix+".js","js/base/jquery.effects."+options.effect+""+_s2j.minSuffix+".js"]);
			}
			_s2j.log('effect '+options.effect+' for '+options.targets);
			$(_s2j.escId(options.targets)).effect(options.effect, eo, duration);
		}
	});

	
})(jQuery);
