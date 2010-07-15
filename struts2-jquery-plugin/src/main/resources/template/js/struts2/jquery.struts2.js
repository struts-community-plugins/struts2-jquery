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

/*global jQuery, _s2j, document, window, StrutsUtils  */
/*jslint evil: true */

( function($) {

	/**
	 * Bind Struts2 Components for jQuery AJAX and UI functions
	 */
	$.struts2_jquery = {

	debug :false,
	ajaxhistory :false,
	loadAtOnce :false,
	local :"en",
	gridLocal :"en",
	minSuffix :".min",
	historyelements : {},
	forms : {},
	scriptCache : {},
	styleCache : {},
	defaults : {
	indicator :'',
	loadingText :null,
	errorText :null
	},
	handler : {
	load :'_s2j_container_load',
	form :'_s2j_form_submit',
	effect :'_s2j_effects'
	},

	/** 
	 * helper function for debug logging
	 * set debug to true in the head tag to enable debug logging
	 *  */
	log : function(message) {
		if (this.debug) {
			var msg = '[struts2_jquery] ' + message;
			if (window.console && window.console.log) {
				window.console.log(msg);
			}
			else if (window.opera && window.opera.postError) {
				window.opera.postError(msg);
			}
		}
	},

	/** Escape Ids */
	escId : function(id) {
		return '#' + id.replace(/(:|\.)/g, '\\$1');
	},

	/** Load required JavaScript Resourcess */
	require : function(files, callBack, basePath) {

		var successFunction, path;
		successFunction = callBack || function() {
		};
		path = basePath || null;

		if (path === null && !$.scriptPath) {
			path = '';
		}
		else if (path === null && $.scriptPath) {
			path = $.scriptPath;
		}

		if (typeof files === "string") {
			files = new Array(files);
		}
		$.each(files, function(i, file) {
			if (!_s2j.scriptCache[file]) {
				_s2j.log('load require script ' + (path + file));
				$.ajax( {
				type :"GET",
				url :path + file,
				success :successFunction,
				dataType :"script",
				cache :true,
				async :false
				});
				_s2j.scriptCache[file] = true;
			}
		});
	},

	/** Load required CSS Files */
	requireCss : function(cssFile, basePath) {
		if (!this.styleCache[cssFile]) {
			var path, cssref;

			path = basePath || null;
			if (path === null && !$.scriptPath) {
				path = '';
			}
			else if (path === null && $.scriptPath) {
				path = $.scriptPath;
			}
			this.log('load require css ' + (path + cssFile));

			cssref = document.createElement("link");
			cssref.setAttribute("rel", "stylesheet");
			cssref.setAttribute("type", "text/css");
			cssref.setAttribute("href", (path + cssFile));
			document.getElementsByTagName("head")[0].appendChild(cssref);
			this.styleCache[cssFile] = true;
		}
	},

	/** Helper function to hide indicator */
	hideIndicator : function(indi) {
		if (indi) {
			$(this.escId(indi)).hide();
		}
		if (this.defaults.indicator != '') {
			$(this.escId(this.defaults.indicator)).hide();
		}
	},

	/** Helper function to show indicator */
	showIndicator : function(indi) {
		if (indi) {
			$(this.escId(indi)).show();
		}
		if (this.defaults.indicator != '') {
			$(this.escId(this.defaults.indicator)).show();
		}
	},

	/** Helper function to publish UI topics */
	pubTops : function($elem, always, topics) {

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

	/** Helper function to subscribe topics */
	subscribeTopics : function(elem, topics, handler, o) {
		if (topics && elem) {
			$.each(topics.split(','), function(i, t) {
				_s2j.log('subscribe topic : ' + t);
				if (elem.isSubscribed(t)) {
					elem.unsubscribe(t);
				}
				elem.subscribe(t, handler, o);
			});
		}
	},

	/** Helper function to publish topics */
	publishTopic : function(elem, topics, data) {
		if (topics) {
			$.each(topics.split(','), function(i, to) {
				_s2j.log('publish topic : ' + to);
				elem.publish(to, elem, data);
			});
		}
	},

	/** publish Success topics 
	 * handle AJAX result, insert it into container or build select box, radiobutton, checkboxes etc.
	 * */
	pubSuc : function(cid, always, stopics, indi, modus, o) {
		var c = $(cid);
		return function(data, status, request) {
			var orginal = {};
			orginal.data = data;
			orginal.status = status;
			orginal.request = request;

			// Handle HTML Result for Divs, Submit and Anchor
			if (modus == 'html' && !$.isArray(data) && !$.isPlainObject(data)) {
				c.html(data);
			}
			
			// Handle Text Result for Textarea or Textfield
			else if (modus == 'value') {
				c.val($.trim(data));
			}
			
			// Hanlde Result for Select, Radiobuttons and Checkboxes
			else if (modus == 'select' || modus == 'radio' || modus == 'checkbox') {
				if (modus == 'select') {
					c[0].length = 0;
				}
				else {
					c.children().remove();
				}

				if (typeof (data) == "object" || $.isArray(data)) {
					var i = -1;

					if (modus == 'select') {
						// Header Option 
						if (o.headerkey && o.headervalue) {
							var headerElement = $('<option value="' + o.headerkey + '">' + o.headervalue + '</option>');
							if (o.value == o.headervalue) {
								headerElement.attr("selected", "selected");
							}
							headerElement.appendTo(c);
						}

						// Is Empty Option set to true
						if (o.emptyoption) {
							$('<option></option>').appendTo(c);
						}
					}

					// Loop over Elements
					var x = 0;
					if (data[o.list] !== null) {
						var isMap = false;
						if (!$.isArray(data[o.list])) {
							isMap = true;
						}

						$.each(data[o.list], function(j, val) {
							var option = {};
							if (modus == 'radio' || modus == 'checkbox') {
								option.name = o.name;
							}

							if (isMap) {
								option.text = val;
								option.value = j;
							}
							else {
								if (o.listkey !== undefined && o.listvalue !== undefined) {
									option.text = val[o.listvalue];
									option.value = val[o.listkey];
								}
								else {
									option.text = data[o.list][x];
									option.value = data[o.list][x];
								}
							}

							if (o.value !== undefined && o.value == option.value) {
								option.selected = true;
							}

							if (modus == 'select') {
								var optionElement = $('<option value="' + option.value + '">' + option.text + '</option>');
								if (option.selected) {
									optionElement.attr("selected", "selected");
								}
								optionElement.appendTo(c);
							}
							else {
								var re;
								var idv = ++i;
								
								// This way is needed to avoid Bug in IE6/IE7
								if (modus == 'radio') {
									re = $('<input name="' + option.name + '" type="radio" id="' + option.name + (idv) + '" value="' + option.value + '"></input>');
								}
								else if (modus == 'checkbox') {
									re = $('<input name="' + option.name + '" type="checkbox" id="' + option.name + (idv) + '" value="' + option.value + '"></input>');
								}

								if (option.selected) {
									re.attr("checked", "checked");
								}

								c.append(re);
								c.append($('<label id="' + option.name + (idv) + 'label" for="' + option.name + (idv) + '">' + option.text + '</label>'));
							}
							x++;
						});
					}
				}
			}

			if (stopics) {
				_s2j.publishTopic(c, stopics, orginal);
				_s2j.publishTopic(c, always, orginal);
			}

			// Use BBQ for Ajaxhistory
			if (_s2j.ajaxhistory) {
				var ahparams = {};
				ahparams.cid = cid;
				ahparams.options = o;

				$(window).bind('hashchange', ahparams, function(e) {
					var topic = e.getState(e.data.cid.id) || '';
					if (e.type === topic || topic == '' || topic == _s2j.lasttopic) { return; }
					_s2j.lasttopic = topic;
					$.publish(topic, e.data.options);
				});
			}
		};
	},

	/** publish complete topics */
	pubCom : function(cid, always, ctopics, targets, indi, o) {
		var c = $(cid);
		return function(request, status) {
			var orginal = {};
			orginal.request = request;
			orginal.status = status;

			_s2j.hideIndicator(indi);

			_s2j.publishTopic(c, ctopics, orginal);
			_s2j.publishTopic(c, always, orginal);

			var ec = targets;
			if (!ec) {
				ec = o.id;
			}
			if (ec) {
				var divEffectTopic = '_sj_div_effect_';
				$.each(ec.split(','), function(i, target) {
					var effect_elem = $(_s2j.escId(target));
					effect_elem.publish(divEffectTopic + target, effect_elem);
				});
			}
			if (o.resizable) {
				if (!_s2j.loadAtOnce) {
					_s2j.require( [ "js/base/jquery.ui.widget" + _s2j.minSuffix + ".js", "js/base/jquery.ui.mouse" + _s2j.minSuffix + ".js", "js/base/jquery.ui.resizable" + _s2j.minSuffix + ".js" ]);
				}
				var ros = o.resizableoptions;
				var ro = window[ros];
				if (!ro) {
					ro = eval("( " + ros + " )");
				}
				else {
					ro = {};
				}
				ro.start = _s2j.pubTops(c, o.onalwaystopics, o.resizableonstarttopics);
				ro.stop = _s2j.pubTops(c, o.onalwaystopics, o.resizableonstoptopics);
				ro.resize = _s2j.pubTops(c, o.onalwaystopics, o.resizableonresizetopics);
				c.resizable(ro);
			}
		};
	},

	/** publish error topics */
	pubErr : function(cid, always, etopics, etext, modus) {
		var c = $(cid);
		if (etopics || etext) {
			return function(request, status, error) {
				var orginal = {};
				orginal.request = request;
				orginal.status = status;
				orginal.error = error;

				if (modus == 'html' || modus == 'value') {
					if (etext && etext != "false") {
						c.html(etext);
					}
					else if (_s2j.defaults.errorText !== null) {
						c.html(_s2j.defaults.errorText);
					}
				}

				_s2j.publishTopic(c, etopics, orginal);
				_s2j.publishTopic(c, always, orginal);
			};
		}
		else {
			return null;
		}
	},

	/** 
	 * pre-binding function of the type function(element){}. called before binding the element
	 * returning false will prevent the binding of this element
	 */
	preBind :null,

	/** post-binding function of the type function(element){}. called before binding the element */
	postBind :null,

	/** bind a html element to an struts2 jquery action */
	bind : function(el, o) {

		if (el) {
			var $el = $(el);
			el = $el[0];

			var tag = el.tagName.toLowerCase();
			o.tagname = tag;

			// extension point to allow custom pre-binding processing
			if (typeof (this.preBind) != "function" || this.preBind($el)) {

				if (!o.jqueryaction) {
					o.jqueryaction = tag;
				}

				this.log('bind ' + o.jqueryaction + ' on ' + o.id);
				this[o.jqueryaction]($el, o);

				// extension point to allow custom post-binding processing
				if (this.postBind && (typeof (this.postBind) == "function")) { return this.postBind(el); }
			}

		}
	},

	/** register a specific struts2 jquery action */
	jqueryaction : function(name, binder) {

		if (name && binder) {
			this[name] = binder;
		}
	},

	/** opens a dialog if attribute openDialog in Anchor or Submit Tag is set to true */
	opendialog : function($elem, o) {
		this.log('open dialog : ' + o.opendialog);

		if (o.opendialog) {
			var dialog = $(this.escId(o.opendialog));
			$elem.bind('click', function(event) {
				if (o.href && o.href != '#') {
					o.targets = o.opendialog;
					var divTopic = '_s2j_dialog_load_' + o.id;
					_s2j.subscribeTopics(dialog, divTopic, _s2j.handler.load, o);
					dialog.publish(divTopic, o);
				}

				dialog.dialog('open');
				return false;
			});
		}
	},
	
	/** Handles remote and effect actions */
	action : function($elem, o, loadHandler, type) {

		var actionTopic = '_sj_action_' + o.id;
		var href = o.href;

		if (href === null || href == "") {
			href = "#";
			o.href = href;
		}

		var effectTopic = '_sj_div_effect_';
		var effect = {};
		effect.effect = o.effect;
		effect.effectoptions = o.effectoptions;
		effect.effectduration = o.effectduration;

		// Set dummy target when datatype is json
		if(o.datatype && !o.targets) {
			if(o.datatype == "json") {
				o.targets = "false";
			}
		}
		
		// subscribe all targets to this action's custom execute topic
		if (o.targets) {
			$.each(o.targets.split(','), function(i, target) {
				effect.targets = target;
				var tarelem = $(_s2j.escId(target));

				//when no target is found (e.g. a json call)
				// the action was subscribed to the publisher
				if(tarelem.length === 0){
					tarelem = $elem;
				}
				
				_s2j.subscribeTopics(tarelem, actionTopic, loadHandler, o);
				_s2j.subscribeTopics(tarelem, effectTopic + target, _s2j.handler.effect, effect);

				if (_s2j.ajaxhistory) {
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

			effect.targets = o.id;
			$(this.escId(o.id)).subscribe(effectTopic + o.id, this.handler.effect, effect);

			// bind event topic listeners
			if (o.onbeforetopics || o.oncompletetopics || o.onsuccesstopics || o.onerrortopics) {
				_s2j.subscribeTopics($elem, actionTopic, loadHandler, o);
			}
		}

		if (type == "a") {
			$elem.publishOnEvent('click', actionTopic); // bind custom action topic to click event
		}

	},

	/** Handle all Container Elements Divs, Textarea, Textfield */
	container : function($elem, o) {
		this.log('container : ' + o.id);
		this.action($elem, o, this.handler.load, 'div');
		var divTopic = '_s2j_div_load_' + o.id;
		var divEffectTopic = '_s2j_div_effect_' + o.id;

		// load div using ajax only when href is specified or form is defined
		if ((o.formids && !o.type) || (o.href && o.href != '#')) {
			if (o.href != '#') {
				_s2j.subscribeTopics($elem, o.reloadtopics, _s2j.handler.load, o);
				_s2j.subscribeTopics($elem, o.listentopics, _s2j.handler.load, o);
				// publishing not triggering to prevent event propagation issues
				_s2j.subscribeTopics($elem, divTopic, _s2j.handler.load, o);

				if (o.bindon) {
					var $bindElement = $('#' + o.bindon);
					if (o.events) {
						$.each(o.events.split(','), function(i, event) {
							$bindElement.publishOnEvent(event, divTopic);
						});
					}
					else {
						$bindElement.publishOnEvent('click', divTopic);
					}
				}
				else if (!o.deferredloading) {
					$elem.publish(divTopic, o);
				}

			}
			else if (o.formids) {
				if (!this.loadAtOnce) {
					this.require("js/plugins/jquery.form" + this.minSuffix + ".js");
				}
				o.targets = o.id;
				this.formsubmit($elem, o, divTopic);
				if (!o.deferredloading) {
					$elem.publish(divTopic, o);
				}
			}
		}
		else {
			if (o.id && o.effect) {
				var effect = {};
				effect.targets = o.id;
				effect.effect = o.effect;
				effect.effectoptions = o.effectoptions;
				effect.effectduration = o.effectduration;
				_s2j.subscribeTopics($elem, divEffectTopic, _s2j.handler.effect, effect);
			}

			if (o.events || o.bindon) {

				var bindel = $elem;
				var eventsStr = 'click';
				if (o.bindon) {
					bindel = $(this.escId(o.bindon));
				}
				if (o.events) {
					eventsStr = o.events;
				}

				$.each(eventsStr.split(','), function(i, event) {
					if (o.onbeforetopics) {
						$.each(o.onbeforetopics.split(','), function(i, btopic) {
							bindel.publishOnEvent(event, btopic);
						});
					}
					bindel.publishOnEvent(event, divEffectTopic);
					if (o.oncompletetopics) {
						$.each(o.oncompletetopics.split(','), function(i, ctopic) {
							bindel.publishOnEvent(event, ctopic);
						});
					}
				});
			}
			else {
				if (o.onbeforetopics) {
					$.each(o.onbeforetopics.split(','), function(i, bts) {
						$elem.publish(bts, $elem);
					});
				}
				$elem.publish(divEffectTopic, $elem);
				if (o.oncompletetopics) {
					$.each(o.oncompletetopics.split(','), function(i, cts) {
						$elem.publish(cts, $elem);
					});
				}
			}

			if (o.resizable) {
				if (!this.loadAtOnce) {
					this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.mouse" + this.minSuffix + ".js", "js/base/jquery.ui.resizable" + this.minSuffix + ".js" ]);
				}
				var ros = o.resizableoptions;
				var ro = window[ros];
				if (!ro) {
					ro = eval("( " + ros + " )");
				}
				else {
					ro = {};
				}
				ro.start = this.pubTops($elem, o.onalwaystopics, o.resizableonstarttopics);
				ro.stop = this.pubTops($elem, o.onalwaystopics, o.resizableonstoptopics);
				ro.resize = this.pubTops($elem, o.onalwaystopics, o.resizableonresizetopics);
				$elem.resizable(ro);
			}
		}

		if (o.draggable) {
			this.log('draggable : ' + o.id);
			if (!this.loadAtOnce) {
				this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.mouse" + this.minSuffix + ".js", "js/base/jquery.ui.draggable" + this.minSuffix + ".js" ]);
			}
			var daos = o.draggableoptions;
			var dao = window[daos];
			if (!dao) {
				dao = eval("( " + daos + " )");
			}
			else {
				dao = {};
			}
			dao.start = this.pubTops($elem, o.onalwaystopics, o.draggableonstarttopics);
			dao.stop = this.pubTops($elem, o.onalwaystopics, o.draggableonstoptopics);
			dao.drap = this.pubTops($elem, o.onalwaystopics, o.draggableondragtopics);
			$elem.draggable(dao);
		}

		if (o.droppable) {
			this.log('droppable : ' + o.id);
			if (!this.loadAtOnce) {
				this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.mouse" + this.minSuffix + ".js", "js/base/jquery.ui.draggable" + this.minSuffix + ".js", "js/base/jquery.ui.droppable" + this.minSuffix + ".js" ]);
			}
			var doos = o.droppableoptions;
			var doo = window[doos];
			if (!doo) {
				doo = eval("( " + doos + " )");
			}
			else {
				doo = {};
			}
			doo.activate = this.pubTops($elem, o.onalwaystopics, o.droppableonactivatetopics);
			doo.deactivate = this.pubTops($elem, o.onalwaystopics, o.droppableondeactivatetopics);
			doo.start = this.pubTops($elem, o.onalwaystopics, o.droppableonstarttopics);
			doo.stop = this.pubTops($elem, o.onalwaystopics, o.droppableonstoptopics);
			doo.drop = this.pubTops($elem, o.onalwaystopics, o.droppableondroptopics);
			$elem.droppable(doo);
		}

		if (o.selectable) {
			this.log('selectable : ' + o.id);
			if (!this.loadAtOnce) {
				this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.mouse" + this.minSuffix + ".js", "js/base/jquery.ui.selectable" + this.minSuffix + ".js" ]);
			}
			var seos = o.selectableoptions;
			var seo = window[seos];
			if (!seo) {
				seo = eval("( " + seos + " )");
			}
			else {
				seo = {};
			}
			seo.selected = this.pubTops($elem, o.onalwaystopics, o.selectableonselectedtopics);
			seo.selecting = this.pubTops($elem, o.onalwaystopics, o.selectableonselectingtopics);
			seo.start = this.pubTops($elem, o.onalwaystopics, o.selectableonstarttopics);
			seo.stop = this.pubTops($elem, o.onalwaystopics, o.selectableonstoptopics);
			seo.unselected = this.pubTops($elem, o.onalwaystopics, o.selectableonunselectedtopics);
			seo.unselecting = this.pubTops($elem, o.onalwaystopics, o.selectableonunselectingtopics);
			$elem.selectable(seo);
		}

		if (o.sortable) {
			this.log('sortable : ' + o.id);
			if (!this.loadAtOnce) {
				this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.mouse" + this.minSuffix + ".js", "js/base/jquery.ui.sortable" + this.minSuffix + ".js" ]);
			}
			var soos = o.sortableoptions;
			var soo = window[soos];
			if (!soo) {
				soo = eval("( " + soos + " )");
			}
			else {
				soo = {};
			}
			soo.beforeStop = this.pubTops($elem, o.onalwaystopics, o.sortableonbeforestoptopics);
			soo.stop = this.pubTops($elem, o.onalwaystopics, o.sortableonstoptopics);
			soo.start = this.pubTops($elem, o.onalwaystopics, o.sortableonstarttopics);
			soo.sort = this.pubTops($elem, o.onalwaystopics, o.sortableonsorttopics);
			soo.activate = this.pubTops($elem, o.onalwaystopics, o.sortableonactivatetopics);
			soo.deactivate = this.pubTops($elem, o.onalwaystopics, o.sortableondeactivatetopics);
			soo.over = this.pubTops($elem, o.onalwaystopics, o.sortableonovertopics);
			soo.out = this.pubTops($elem, o.onalwaystopics, o.sortableonouttopics);
			soo.remove = this.pubTops($elem, o.onalwaystopics, o.sortableonremovetopics);
			soo.receive = this.pubTops($elem, o.onalwaystopics, o.sortableonreceivetopics);
			soo.change = this.pubTops($elem, o.onalwaystopics, o.sortableonchangetopics);
			soo.update = this.pubTops($elem, o.onalwaystopics, o.sortableonupdatetopics);
			$elem.sortable(soo);
		}

		if (o.onchangetopics) {
			if (o.type) {
				if (o.type == 'text') {
					$elem.keyup( function() {
						_s2j.publishTopic($elem, o.onchangetopics, {});
					});
				}
				else if (o.type == 'select') {
					$elem.change( function() {
						_s2j.publishTopic($elem, o.onchangetopics, {});
					});
				}
			}
		}
	},

	/** Handle the Anchor Element */
	anchor : function($elem, o) {
		this.log('anchor : ' + o.id);

		if (o.onclicktopics) {
			$.each(o.onclicktopics.split(','), function(i, topic) {
				$elem.publishOnEvent('click', topic);
			});
		}

		if (o.opendialog) {
			this.opendialog($elem, o);
		}
		if (o.button) {
			this.jquerybutton($elem, o);
		}

		if (o.formids) {
			var formTopic = '_s2j_form_topic_' + o.id;
			this.formsubmit($elem, o, formTopic);
			$elem.publishOnEvent('click', formTopic);
		}
		else {
			
			this.action($elem, o, this.handler.load, 'a');
			if(o.targets && (o.reloadtopic || o.listentopics)) {
				$.each(o.targets.split(','), function(i, t) {
					var te = $(_s2j.escId(t));
					_s2j.subscribeTopics(te, o.reloadtopics, _s2j.handler.load, o);
					_s2j.subscribeTopics(te, o.listentopics, _s2j.handler.load, o);
				});
			}
		}
	},

	/** Handle dynamic Select Boxes */
	select : function($elem, o) {
		this.log('select : ' + o.id);
		if (!this.loadAtOnce) {
			this.require("js/plugins/jquery.form" + this.minSuffix + ".js");
		}
		var selectTopic = '_s2j_topic_load_' + o.id;

		if (o.href && o.href != '#') {

			_s2j.subscribeTopics($elem, o.reloadtopics, _s2j.handler.load, o);
			_s2j.subscribeTopics($elem, o.listentopics, _s2j.handler.load, o);
			_s2j.subscribeTopics($elem, selectTopic, _s2j.handler.load, o);
			if (!o.deferredloading) {
				$elem.publish(selectTopic, o);
			}
		}
		if (o.onchangetopics) {
			$.each(o.onchangetopics.split(','), function(i, cts) {
				$elem.publishOnEvent('change', cts);
			});
		}
	},

	/** Handle the Submit Button */
	button : function($elem, o) {
		var formTopic = '_s2j_form_topic_' + o.id;

		if (o.opendialog) {
			this.opendialog($elem, o);
		}
		if (o.button) {
			this.jquerybutton($elem, o);
		}

		if (o.formids !== undefined) {
			this.formsubmit($elem, o, formTopic);
		}
		else {
			var cform = $elem.parents('form:first')[0];
			if (cform !== undefined) {
				var cf = $(cform);
				var formid = cf.attr("id");
				if (formid !== undefined) {
					o.formids = formid;
				}
				else {
					var randomid = 's2jqform' + Math.floor(Math.random() * 10000);
					cf.attr('id', randomid);
					o.formids = randomid;
				}
				this.formsubmit($elem, o, formTopic);
			}
			else {
				this.action($elem, o, this.handler.load, 'a');
			}
		}
		if (o.onclicktopics) {
			$.each(o.onclicktopics.split(','), function(i, topic) {
				$elem.publishOnEvent('click', topic);
			});
		}
		$elem.publishOnEvent('click', formTopic);
		$elem.removeAttr('name');
	},
	
	/** Handle all AJAX Forms submitted from Anchor or Submit Button */
	formsubmit : function($elem, o, topic) {
		this.log('formsubmit : ' + o.id);
		if (!this.loadAtOnce) {
			this.require("js/plugins/jquery.form" + this.minSuffix + ".js");
		}

		_s2j.subscribeTopics($elem, o.reloadtopics, _s2j.handler.form, o);
		_s2j.subscribeTopics($elem, o.listentopics, _s2j.handler.form, o);

		if (o.targets) {
			_s2j.subscribeTopics($elem, topic, _s2j.handler.form, o);
			$.each(o.targets.split(','), function(i, target) {
				$(_s2j.escId(target)).subscribe(topic, _s2j.handler.effect, o);
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
			// Submit Forms without AJAX
			$elem.click( function() {
				$(_s2j.escId(o.formids)).submit();
				return false;
			});
		}
	},

	/** Handle the Dialog Widget */
	dialog : function($elem, o) {
		this.log('dialog : ' + o.id);
		if (!this.loadAtOnce) {
			this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.button" + this.minSuffix + ".js", "js/base/jquery.ui.mouse" + this.minSuffix + ".js", "js/base/jquery.ui.position" + this.minSuffix + ".js", "js/base/jquery.ui.resizable" + this.minSuffix + ".js", "js/base/jquery.ui.draggable" + this.minSuffix + ".js", "js/base/jquery.bgiframe" + this.minSuffix + ".js", "js/base/jquery.ui.dialog" + this.minSuffix + ".js" ]);
		}
		var params = {};
		$.extend(params, o);
		params.bgiframe = true;
		if (o.hide) {
			if (!this.loadAtOnce) {
				this.require( [ "js/base/jquery.effects.core" + this.minSuffix + ".js", "js/base/jquery.effects." + o.hide + "" + this.minSuffix + ".js" ]);
			}
			params.hide = o.hide;
		}
		if (o.show) {
			if (!this.loadAtOnce) {
				this.require( [ "js/base/jquery.effects.core" + this.minSuffix + ".js", "js/base/jquery.effects." + o.show + "" + this.minSuffix + ".js" ]);
			}
			params.show = o.show;
		}
		params.open = function(event, ui) {
			var data = {};
			data.event = event;
			data.ui = ui;

			if (o.href && o.href != '#') {
				var divTopic = '_s2j_topic_load_' + o.id;
				_s2j.subscribeTopics($elem, divTopic, _s2j.handler.load, o);
				$elem.publish(divTopic);
			}

			_s2j.publishTopic($elem, o.onalwaystopics, data);
			_s2j.publishTopic($elem, o.onbeforetopics, data);
			_s2j.publishTopic($elem, o.onopentopics, data);
		};
		params.close = this.pubTops($elem, o.onalwaystopics, o.onclosetopics);
		params.focus = this.pubTops($elem, o.onalwaystopics, o.onfocustopics);
		params.beforeclose = this.pubTops($elem, o.onalwaystopics, o.onbeforeclosetopics);
		params.drag = this.pubTops($elem, o.onalwaystopics, o.onchangetopics);
		$elem.dialog(params);
	},

	/** Handle the TabbedPanel Widget */
	tabbedpanel : function($elem, o) {
		this.log('tabbedpanel : ' + o.id);
		if (!this.loadAtOnce) {
			this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.tabs" + this.minSuffix + ".js" ]);
		}
		if (!o) {
			o = {};
		}
		var para = {};

		if (o.disabledtabs && o.disabledtabs != 'false') {
			var disabledtabsStr = o.disabledtabs;
			var disabledtabs = window[disabledtabsStr];
			if (!disabledtabs) {
				para.disabled = eval("( " + disabledtabsStr + " )");
			}
		}
		if (o.cache) {
			para.cache = true;
		}
		if (o.animate) {
			if (!this.loadAtOnce) {
				this.require("js/base/jquery.effects.core" + this.minSuffix + ".js");
			}
			para.fx = {
				opacity :'toggle'
			};
		}
		if (o.cookie) {
			if (!this.loadAtOnce) {
				this.require("js/base/jquery.cookie" + this.minSuffix + ".js");
			}
			para.cookie = {
				expires :30
			};
		}
		if (o.collapsible) {
			para.collapsible = true;
		}
		if (o.openonmouseover) {
			para.event = 'mouseover';
		}
		if (o.orientation) {
			para.orientation = o.orientation;
		}

		if (o.spinner !== undefined) {
			para.spinner = o.spinner;
		}
		else if (_s2j.defaults.loadingText !== null) {
			para.spinner = _s2j.defaults.loadingText;
		}

		if (o.selectedtab) {
			para.selected = o.selectedtab;
		}
		if (o.oncompletetopics) {
			para.ajaxOptions = {
			dataType :'html',
			complete :this.pubCom(o.id, o.onalwaystopics, o.oncompletetopics, null, null, {})
			};
		}
		else {
			para.ajaxOptions = {
				dataType :'html'
			};
		}
		if (o.onbeforetopics) {
			para.show = this.pubTops($elem, o.onalwaystopics, o.onbeforetopics);
		}
		if (o.onchangetopics) {
			para.select = this.pubTops($elem, o.onalwaystopics, o.onchangetopics);
		}
		if (o.onenabletopics) {
			para.enable = this.pubTops($elem, o.onalwaystopics, o.onenabletopics);
		}
		if (o.ondisabletopics) {
			para.disable = this.pubTops($elem, o.onalwaystopics, o.ondisabletopics);
		}
		if (o.onaddtopics) {
			para.add = this.pubTops($elem, o.onalwaystopics, o.onaddtopics);
		}
		if (o.onremovetopics) {
			para.remove = this.pubTops($elem, o.onalwaystopics, o.onremovetopics);
		}
		if (o.oncompletetopics) {
			para.load = this.pubTops($elem, o.onalwaystopics, o.onremovetopics);
		}

		var tabs = $elem.data('taboptions');
		if (tabs) {
			var tabStr = "";
			for ( var l = 0; l < tabs.length; l++) {
				var tab = tabs[l];
				tabStr += "<li ";
				if (tab.id) {
					tabStr += "id='" + tab.id + "' ";
				}
				if (tab.cssstyle) {
					tabStr += "style='" + tab.cssstyle + "' ";
				}
				if (tab.cssclass) {
					tabStr += "class='" + tab.cssclass + "' ";
				}
				tabStr += "><a href='" + tab.href + "' ";
				if (tab.label) {
					tabStr += "title='" + tab.label + "' ";
				}
				tabStr += "><span>";
				if (tab.label) {
					tabStr += tab.label;
				}
				tabStr += "</span></a></li>";
			}
			$(this.escId(o.id) + ' > ul').html(tabStr);
		}

		$elem.tabs(para);

		// History and Bookmarking for Tabs
		if (this.ajaxhistory) {
			var ahp = {};
			ahp.id = o.id;
			$elem.find('ul.ui-tabs-nav a').bind('click', ahp, function(e) {
				var idx = $(_s2j.escId(e.data.id)).tabs('option', 'selected');
				_s2j.historyelements[e.data.id] = idx;
				$.bbq.pushState(_s2j.historyelements);
				return false;
			});

			$(window).bind('hashchange', ahp, function(e) {
				var idx = e.getState(e.data.id, true) || 0;
				$(_s2j.escId(e.data.id)).tabs('select', idx);
			});
		}
	},

	/** Handle the Datepicker Widget */
	datepicker : function($elem, o) {
		this.log('datepicker : ' + o.id);
		if (!this.loadAtOnce) {
			this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.datepicker" + this.minSuffix + ".js" ]);
		}
		if (this.local != "en") {
			this.require("i18n/jquery.ui.datepicker-" + this.local + ".min.js");
		}
		var params = {};

		if (o) {

			var oat = o.onalwaystopics;

			if (o.onbeforetopics) {
				params.beforeShow = function(input, inst) {
					var $input = $(input);
					var data = {};
					data.input = input;
					data.inst = inst;
					this.publishTopic($input, o.onbeforetopics, data);
					this.publishTopic($input, oat, data);
				};
			}

			if (o.onbeforeshowdaytopics) {
				params.beforeShowDay = function(date) {
					var data = {};
					data.date = date;
					this.publishTopic($elem, o.onbeforeshowdaytopics, data);
					this.publishTopic($elem, oat, data);
				};
			}

			if (o.onchangemonthyeartopics) {
				params.onChangeMonthYear = function(year, month, inst) {
					var data = {};
					data.year = year;
					data.month = month;
					data.inst = inst;
					this.publishTopic($elem, o.onchangemonthyeartopics, data);
					this.publishTopic($elem, oat, data);
				};
			}

			if (o.onchangetopics) {
				params.onSelect = function(dateText, inst) {
					var data = {};
					data.dateText = dateText;
					data.inst = inst;
					this.publishTopic($elem, o.onchangetopics, data);
					this.publishTopic($elem, oat, data);
				};
			}

			if (o.oncompletetopics) {
				params.onClose = function(dateText, inst) {
					var data = {};
					data.dateText = dateText;
					data.inst = inst;
					_s2j.publishTopic($elem, o.oncompletetopics, data);
					_s2j.publishTopic($elem, oat, data);
				};
			}

			if (o.changemonth) {
				params.changeMonth = true;
			}
			if (o.changeyear) {
				params.changeYear = true;
			}
			if (o.showbuttonpanel) {
				params.showButtonPanel = true;
			}
			if (o.buttonimageonly) {
				params.buttonImageOnly = true;
			}
			if (o.displayformat) {
				params.dateFormat = o.displayformat;
			}
			else {
				params.dateFormat = $.datepicker._defaults.dateFormat;
			}
			params.buttonImage = o.buttonimage;
			params.showOn = o.showon;
			params.buttonText = o.buttontext;

			if (o.showanim) {
				if (!this.loadAtOnce) {
					this.require("js/base/jquery.effects.core" + this.minSuffix + ".js");
				}
				params.showAnim = o.showanim;
			}

			params.firstDay = o.firstday;
			params.yearRange = o.yearrange;
			params.duration = o.duration;
			params.appendText = o.appendtext;
			params.maxDate = o.maxdate;
			params.minDate = o.mindate;

			if (o.numberofmonths) {
				var numberofmonthsStr = o.numberofmonths;
				var numberofmonths = window[numberofmonthsStr];
				if (!numberofmonths) {
					params.numberOfMonths = eval("( " + numberofmonthsStr + " )");
				}
			}

			if (o.showoptions) {
				var userOptionsStr = o.showoptions;
				var userOptions = window[userOptionsStr];
				if (!userOptions) {
					params.showOptions = eval("( " + userOptionsStr + " )");
				}
			}
		}

		$elem.datepicker(params);

		if (o.year && o.month && o.day) {
			$elem.val($.datepicker.formatDate(params.dateFormat, new Date(o.year, o.month, o.day)));
		}
		if (o.zindex) {
			$('#ui-datepicker-div').css("z-index", o.zindex);
		}
	},
	
	/** Handle the Slider Widget */
	slider : function($elem, o) {
		this.log('slider : ' + o.id);
		if (!this.loadAtOnce) {
			this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.mouse" + this.minSuffix + ".js", "js/base/jquery.ui.slider" + this.minSuffix + ".js" ]);
		}

		var params = {};
		if (o) {

			params.start = this.pubTops($elem, o.onalwaystopics, o.onbeforetopics);
			params.change = this.pubTops($elem, o.onalwaystopics, o.onchangetopics);
			params.stop = this.pubTops($elem, o.onalwaystopics, o.oncompletetopics);

			params.slide = function(event, ui) {
				if (o.hiddenid) {
					$(_s2j.escId(o.hiddenid)).val(ui.value);
				}
				if (o.displayvalueelement) {
					$(_s2j.escId(o.displayvalueelement)).html(ui.value);
				}
				if (o.onslidetopics) {
					var data = {};
					data.event = event;
					data.ui = ui;

					this.publishTopic($elem, o.onalwaystopics, data);
					this.publishTopic($elem, o.onslidetopics, data);
				}
			};

			if (o.animate) {
				params.animate = true;
			}
			var value = o.value;
			if (value > 0) {
				params.value = value;
			}
			else {
				params.value = 0;
			}
			if (o.max) {
				params.max = o.max;
			}
			if (o.min) {
				params.min = o.min;
			}
			if (o.orientation) {
				params.orientation = o.orientation;
			}
			if (o.step) {
				params.step = o.step;
			}

			if (o.range) {
				if (o.range == 'true') {
					params.range = true;
				}
				else {
					params.range = o.range;
				}
			}
		}

		$elem.slider(params);
	},
	
	/** Handle the Progressbar Widget */
	progressbar : function($elem, o) {
		this.log('progressbar : ' + o.id);
		if (!this.loadAtOnce) {
			this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.progressbar" + this.minSuffix + ".js" ]);
		}
		var params = {};
		if (o) {

			params.change = this.pubTops($elem, o.onalwaystopics, o.onchangetopics);

			var value = o.value;
			if (value > 0) {
				params.value = value;
			}
			else {
				params.value = 0;
			}
		}
		$elem.progressbar(params);
	},

	/** Handle the Accordion Widget */
	accordion : function($elem, o) {
		this.log('accordion : ' + o.id);
		if (!this.loadAtOnce) {
			this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.accordion" + this.minSuffix + ".js" ]);
		}
		var params = {};
		var active = true;
		if (o) {

			if (o.fillspace) {
				params.fillSpace = true;
			}
			if (o.collapsible) {
				params.collapsible = true;
			}
			if (o.clearstyle) {
				params.clearStyle = true;
			}
			if (o.autoheight !== undefined) {
				if (o.autoheight) {
					params.autoHeight = true;
				}
				else {
					params.autoHeight = false;
				}
			}
			if (o.event) {
				params.event = o.event;
			}
			if (o.header) {
				params.header = o.header;
			}
			else {
				params.header = 'h3';
			}
			if (o.animated) {
				if (o.animated == 'true') {
					params.animated = true;
				}
				else if (o.animated === false) {
					params.animated = false;
				}
				else {
					params.animated = o.animated;
				}
			}

			if (o.active) {
				if (o.active == 'true') {
					params.active = true;
				}
				else if (o.active == 'false') {
					params.active = false;
					active = false;
				}
				else {
					params.active = parseInt(o.active, 10);
				}
			}

			var onAlwaysTopics = o.onalwaystopics;
			params.changestart = function(event, ui) {
				if (o.href) {
					if (typeof $(ui.newHeader).find('a').attr('paramkeys') != "undefined") {
						var keys = $(ui.newHeader).find('a').attr('paramkeys').split(',');
						var values = $(ui.newHeader).find('a').attr('paramvalues').split(',');
						var valueparams = {};
						$.each(keys, function(i, val) {
							valueparams[val] = values[i];
						});
						ui.newContent.load(o.href, valueparams, function() {
						});
					}
				}
				if (o.onbeforetopics) {
					var data = {};
					data.event = event;
					data.ui = ui;

					this.publishTopic($elem, onAlwaysTopics, data);
					this.publishTopic($elem, o.onbeforetopics, data);
				}
			};

			params.change = this.pubTops($elem, o.onalwaystopics, o.onchangetopics);
		}
		$elem.accordion(params);
		if (o.href && active === true) {
			var aktiv = $(this.escId(o.id) + " li " + params.header).filter('.ui-accordion-header').filter('.ui-state-active').find('a');
			if (typeof $(aktiv).attr('paramkeys') != "undefined") {
				var keys = $(aktiv).attr('paramkeys').split(',');
				var values = $(aktiv).attr('paramvalues').split(',');
				var valueparams = {};
				$.each(keys, function(i, val) {
					valueparams[val] = values[i];
				});
				$(this.escId(o.id) + " li div").filter('.ui-accordion-content-active').load(o.href, valueparams, function() {
				});
			}
		}
	},
	
	/** Handle the Autocompleter Widget */
	autocompleter : function($elem, o) {
		this.log('autocompleter for : ' + o.id);
		if (!this.loadAtOnce) {
			this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.position" + this.minSuffix + ".js", "js/base/jquery.ui.autocomplete" + this.minSuffix + ".js" ]);
		}
		var params = {};
		if (o.href && o.href != '#') {
			params.source = o.href;
			if (o.hrefparameter) {
				params.source = params.source + '?' + o.hrefparameter;
			}
		}
		else if (o.list && o.selectBox === false) {
			params.source = o.list;
		}
		if (o.delay) {
			params.delay = o.delay;
		}
		if (o.minimum) {
			params.minLength = o.minimum;
		}

		if (o.onsuccesstopics) {
			params.open = this.pubTops($elem, o.onalwaystopics, o.onsuccesstopics);
		}
		if (o.onchangetopics) {
			params.change = this.pubTops($elem, o.onalwaystopics, o.onchangetopics);
		}
		if (o.oncompletetopics) {
			params.close = this.pubTops($elem, o.onalwaystopics, o.oncompletetopics);
		}
		if (o.onsearchtopics) {
			params.search = this.pubTops($elem, o.onalwaystopics, o.onsearchtopics);
		}
		if (o.onfocustopics) {
			params.focus = this.pubTops($elem, o.onalwaystopics, o.onfocustopics);
		}
		if (o.onselecttopics) {
			params.select = this.pubTops($elem, o.onalwaystopics, o.onselecttopics);
		}

		if (o.selectBox === false) {
			$elem.autocomplete(params);
		}
		else {
			this.require("js/plugins/jquery.combobox" + this.minSuffix + ".js");
			$elem.combobox(params);
		}
	},
	
	/** Handle the Button Widget for Anchor or Submit Tag*/
	jquerybutton : function($elem, o) {
		this.log('button for : ' + o.id);
		if (!this.loadAtOnce) {
			this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.button" + this.minSuffix + ".js" ]);
		}
		if (o.button) {
			var params = {};
			params.icons = {};
			if (o.buttonIcon) {
				params.icons.primary = o.buttonIcon;
			}
			if (o.buttonIconSecondary) {
				params.icons.secondary = o.buttonIconSecondary;
			}
			$elem.button(params);
		}
	},
	
	/** Handle the Buttonset Widget for Radiobuttons or Checkboxes */
	buttonset : function($elem, o) {
		this.log('buttonset for : ' + o.id);
		if (!this.loadAtOnce) {
			this.require( [ "js/base/jquery.ui.widget" + this.minSuffix + ".js", "js/base/jquery.ui.button" + this.minSuffix + ".js" ]);
		}
		var buttonsetLoadTopic = '_s2j_topic_load_' + o.id;

		if (o.href && o.href != '#') {

			var buttonsetTopic = 's2j_butonset_' + o.id;

			if ($elem.isSubscribed(buttonsetTopic)) {
				$elem.unsubscribe(buttonsetTopic);
			}

			// Init Buttonset after elements loaded via AJAX.
			$elem.subscribe(buttonsetTopic, function(event, data) {
				if (o.onchangetopics) {
					var selectString = _s2j.escId(o.id) + " > input";
					var elements = $(selectString);

					if ($.browser.msie && o.type == 'radio') {
						elements.click( function() {
							this.blur();
							this.focus();
							$.each(o.onchangetopics.split(','), function(i, cts) {
								$elem.publish(cts);
							});
						});
					}
					else {
						elements.change( function() {
							$.each(o.onchangetopics.split(','), function(i, cts) {
								$elem.publish(cts);
							});
						});
					}
				}

				$elem.buttonset(o);
			});
			if (o.onsuccesstopics && o.onsuccesstopics != '') {
				o.onsuccesstopics = buttonsetTopic;
			}
			else {
				o.onsuccesstopics = buttonsetTopic;
			}

			_s2j.subscribeTopics($elem, o.reloadtopics, _s2j.handler.load, o);
			_s2j.subscribeTopics($elem, o.listentopics, _s2j.handler.load, o);

			$elem.subscribe(buttonsetLoadTopic, _s2j.handler.load);
			$elem.publish(buttonsetLoadTopic, o);
		}
		else {
			if (o.onchangetopics) {
				$(_s2j.escId(o.id) + " > input").change( function() {
					$.each(o.onchangetopics.split(','), function(i, cts) {
						$elem.publish(cts);
					});
				});
			}

			$elem.buttonset(o);
		}
	}
	};

	/** Create a shorthand to reduce code */
	var _s2j = $.struts2_jquery;

	/** 
	 * Container logic 
	 * Register handler to load a container
	 * */
	$.subscribeHandler(_s2j.handler.load, function(event, data) {

		var container = $(event.target);
		var o = {};
		if (data) {
			$.extend(o, data);
		}
		if (event.data) {
			$.extend(o, event.data);
		}

		var isDisabled = false;
		isDisabled = o.disabled === null ? isDisabled : o.disabled;
		isDisabled = container.attr('disabled') === null ? isDisabled : container.attr('disabled');
		if (event.originalEvent) { // means that container load is being triggered by other action (link button/link click) need to see if that button/link is disabled
			isDisabled = $(event.originalEvent.currentTarget).attr("disabled") === null ? isDisabled : $(event.originalEvent.currentTarget).attr("disabled");
		}

		if (isDisabled !== true && isDisabled != 'true') {

			// Show indicator element (if any)
			if (o) {

				var indi = o.indicatorid;
				_s2j.showIndicator(o.indicatorid);
				var onAlwaysTopics = o.onalwaystopics;

				var modus = 'html';
				if (o.type) {
					if (o.type == 'text') {
						modus = 'value';
					}
					else if (o.type == 'select') {
						modus = 'select';
					}
					else if (o.type == 'checkbox') {
						modus = 'checkbox';
					}
					else if (o.type == 'radio') {
						modus = 'radio';
					}
				}

				if (modus == 'html' || modus == 'value') {
					// Set pre-loading text (if any)
					if(!o.datatype || o.datatype != "json") {
						if (o.loadingtext && o.loadingtext != "false") {
							if (modus == 'html') {
								container.html(o.loadingtext);
							}
							else {
								container.val(o.loadingtext);
							}
						}
						else if (_s2j.defaults.loadingText !== null) {
							if (modus == 'html') {
								container.html(_s2j.defaults.loadingText);
							}
							else {
								container.val(_s2j.defaults.loadingText);
							}
						}
					}
				}
				var params = {};

				params.success = _s2j.pubSuc(event.target, onAlwaysTopics, o.onsuccesstopics, indi, modus, o);
				params.complete = _s2j.pubCom(event.target, onAlwaysTopics, o.oncompletetopics, o.targets, indi, o);
				params.error = _s2j.pubErr(event.target, onAlwaysTopics, o.onerrortopics, o.errortext, modus);

				// load container using ajax
				if (o.href) {
					params.url = o.href;
					params.data = '';
					if (o.hrefparameter) {
						params.data = o.hrefparameter;
					}
					if (o.requesttype) {
						params.type = o.requesttype;
					}
					else {
						params.type = "POST";
					}

					if (o.formids && params.data == '') {
						if (!_s2j.loadAtOnce) {
							_s2j.require("js/plugins/jquery.form" + _s2j.minSuffix + ".js");
						}
						$.each(o.formids.split(','), function(i, fid) {
							var query = $(_s2j.escId(fid)).formSerialize();
							if (params.data != '') {
								params.data = params.data + '&' + query;
							}
							else {
								params.data = query;
							}
						});
					}

					if (o.datatype) {
						params.dataType = o.datatype;
					}
					else {
						params.dataType = 'html';
					}

					// fix 'issue' wherein IIS will reject post without data
					if (!params.data) {
						params.data = {};
					}

					o.options = params;
					// publish all 'before' and 'always' topics
					_s2j.publishTopic(container, onAlwaysTopics, o);
					_s2j.publishTopic(container, o.onbeforetopics, o);

					// Execute Ajax Request
					$.ajax(params);
				}
			}
		}
	});

	/** 
	 * Form logic 
	 * Handler to submit a form with jquery.form.js plugin
	 * */
	$.subscribeHandler(_s2j.handler.form, function(event, data) {
		var container = $(event.target);
		var elem = container;

		// need to also make use of original attributes registered with the container (such as onCompleteTopics)
		var o = {};
		if (data) {
			$.extend(o, data);
		}
		if (event.data) {
			$.extend(o, event.data);
		}

		var params = {};
		if (o.href && o.href != '#') {
			params.url = o.href;
			if (o.hrefparameter) {
				params.url = params.url + '?' + o.hrefparameter;
			}
		}
		if (o.clearform) {
			params.clearForm = true;
		}
		if (o.iframe) {
			params.iframe = true;
		}
		if (o.resetform) {
			params.resetForm = true;
		}
		if (o.replaceTarget) {
			params.replaceTarget = true;
		}
		if (o.timeout) {
			params.timeout = parseInt(o.timeout, 10);
		}
		if (o.datatype) {
			params.dataType = o.datatype;
		}
		else {
			params.dataType = null;
		}

		params.target = '';
		if (o.targets) {
			$.each(o.targets.split(','), function(i, target) {
				elem = $(_s2j.escId(target));
				if (params.target == '') {
					params.target = _s2j.escId(target);
				}
				else {
					params.target = params.target + ',#' + _s2j.escId(target);
				}
			});
		}

		var indi = o.indicatorid;
		_s2j.showIndicator(indi);

		params.beforeSubmit = function(formData, form, formoptions) {

			var orginal = {};
			orginal.formData = formData;
			orginal.form = form;
			orginal.options = formoptions;
			orginal.options.submit = true;

			_s2j.publishTopic(container, o.onalwaystopics, orginal);

			if (o.onbeforetopics) {
				$.each(o.onbeforetopics.split(','), function(i, topic) {
					elem.publish(topic, elem, orginal);
					var submitForm = orginal.options.submit;
					// cancel form submission
					if (!submitForm) {
						_s2j.hideIndicator(o.indicatorid);
						
						if(!o.datatype || o.datatype != "json") {
							if (o.loadingtext && o.loadingtext != "false") {
								$.each(o.targets.split(','), function(i, target) {
									$(_s2j.escId(target)).html(o.loadingtext);
								});
							}
							else if (_s2j.defaults.loadingText !== null) {
								$.each(o.targets.split(','), function(i, target) {
									$(_s2j.escId(target)).html(_s2j.defaults.loadingText);
								});
							}
						}
					}
				});
			}

			if (o.validate) {
				var valParams = {};
				valParams.type = "POST";
				if (o.href && o.href != '#') {
					valParams.url = o.href;
				}
				else {
					valParams.url = form[0].action;
				}

				valParams.data = '';
				if (o.hrefparameter) {
					valParams.data = o.hrefparameter;
				}

				var query = form.formSerialize();
				query = query + '&struts.enableJSONValidation=true&struts.validateOnly=true';
				if (valParams.data != '') {
					valParams.data = valParams.data + '&amp;' + query;
				}
				else {
					valParams.data = query;
				}
				
				valParams.cache = false;
				valParams.async = false;

				valParams.complete = function(request, status) {
					var f = $(form[0]);
					if ($.isFunction(o.validateFunction)) {
						var et = request.responseText;
						if (et && et.length > 10) {
							orginal.options.submit = false;
							var errors = $.parseJSON(et.substring(2, et.length - 2));
							o.validateFunction(f, errors);
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
					_s2j.log('form validation : ' + orginal.options.submit);
				};
				$.ajax(valParams);
			}
			if (!orginal.options.submit) {
				_s2j.hideIndicator(o.indicatorid);
			}
			return orginal.options.submit;
		};

		params.success = _s2j.pubSuc(elem, o.onalwaystopics, o.onsuccesstopics, indi, 'form', o);
		params.complete = _s2j.pubCom(elem, o.onalwaystopics, o.oncompletetopics, o.targets, indi, o);
		params.error = _s2j.pubErr(elem, o.onalwaystopics, o.onerrortopics, o.errortext, 'html');

		$.each(o.formids.split(','), function(i, fid) {
			_s2j.log('submit form : ' + fid);
			$(_s2j.escId(fid)).ajaxSubmit(params);
		});

		return false;
	});

	/** 
	 * Effects 
	 * Register handler for effects
	 * */
	$.subscribeHandler(_s2j.handler.effect, function(event, data) {
		var o = {};
		$.extend(o, event.data);
		if (o.targets && o.effect) {
			var eo = {};
			var duration = 2000;
			if (o.effectoptions) {
				eo = o.effectoptions;
			}
			if (o.effectduration) {
				duration = o.effectduration;
			}
			if (!_s2j.loadAtOnce) {
				_s2j.require( [ "js/base/jquery.effects.core" + _s2j.minSuffix + ".js", "js/base/jquery.effects." + o.effect + "" + _s2j.minSuffix + ".js" ]);
			}
			_s2j.log('effect ' + o.effect + ' for ' + o.targets);
			$(_s2j.escId(o.targets)).effect(o.effect, eo, duration);
		}
	});

})(jQuery);
