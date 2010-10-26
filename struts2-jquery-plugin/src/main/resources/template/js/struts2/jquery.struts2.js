/*!
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

/*global jQuery, document, window, StrutsUtils  */
/*jslint evil: true */

( function($) {

	/**
	 * Bind Struts2 Components for jQuery AJAX and UI functions
	 */
	$.struts2_jquery = {

	debug :false,
	debugPrefix :'[struts2_jquery] ',
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
		var self = this;
		if (self.debug) {
			var msg = self.debugPrefix + message;
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
		var self = this;
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
			if (!self.scriptCache[file]) {
				self.log('load require script ' + (path + file));
				$.ajax( {
				type :"GET",
				url :path + file,
				success :successFunction,
				dataType :"script",
				cache :true,
				async :false
				});
				self.scriptCache[file] = true;
			}
		});
	},

	/** Load required CSS Files */
	requireCss : function(cssFile, basePath) {
		var self = this;
		if (!self.styleCache[cssFile]) {
			var path, cssref;

			path = basePath || null;
			if (path === null && !$.scriptPath) {
				path = '';
			}
			else if (path === null && $.scriptPath) {
				path = $.scriptPath;
			}
			self.log('load require css ' + (path + cssFile));

			cssref = document.createElement("link");
			cssref.setAttribute("rel", "stylesheet");
			cssref.setAttribute("type", "text/css");
			cssref.setAttribute("href", (path + cssFile));
			document.getElementsByTagName("head")[0].appendChild(cssref);
			self.styleCache[cssFile] = true;
		}
	},

	/** Helper function to hide indicator */
	hideIndicator : function(indi) {
		var self = this;
		if (indi) {
			$(self.escId(indi)).hide();
		}
		if (self.defaults.indicator !== '') {
			$(self.escId(self.defaults.indicator)).hide();
		}
	},

	/** Helper function to show indicator */
	showIndicator : function(indi) {
		var self = this;
		if (indi) {
			$(self.escId(indi)).show();
		}
		if (self.defaults.indicator !== '') {
			$(self.escId(self.defaults.indicator)).show();
		}
	},

	/** Helper function to publish UI topics */
	pubTops : function($elem, always, topics) {
		var self = this;
		if (topics) {
			return function(event, ui) {
				var data = {};
				data.event = event;
				data.ui = ui;

				self.publishTopic($elem, topics, data);
				self.publishTopic($elem, always, data);
			};
		}
		else {
			return null;
		}
	},

	/** Helper function to subscribe topics */
	subscribeTopics : function(elem, topics, handler, o) {
		var self = this;
		if (topics && elem) {
			$.each(topics.split(','), function(i, t) {
				self.log('subscribe topic : ' + t);
				if (elem.isSubscribed(t)) {
					elem.unsubscribe(t);
				}
				elem.subscribe(t, handler, o);
			});
		}
	},

	/** Helper function to publish topics */
	publishTopic : function(elem, topics, data) {
		var self = this;
		if (topics) {
			$.each(topics.split(','), function(i, to) {
				self.log('publish topic : ' + to);
				elem.publish(to, elem, data);
			});
		}
	},

	/** publish Success topics
	 * handle AJAX result, insert it into container or build select box, radiobutton, checkboxes etc.
	 * */
	pubSuc : function(cid, always, stopics, indi, modus, o) {
		var self = this;
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
				self.publishTopic(c, stopics, orginal);
				self.publishTopic(c, always, orginal);
			}

			// Use BBQ for Ajaxhistory
			if (self.ajaxhistory) {
				var ahparams = {};
				ahparams.cid = cid;
				ahparams.options = o;

				$(window).bind('hashchange', ahparams, function(e) {
					var topic = e.getState(e.data.cid.id) || '';
					if (e.type === topic || topic === '' || topic == self.lasttopic) { return; }
					self.lasttopic = topic;
					$.publish(topic, e.data.options);
				});
			}
		};
	},

	/** publish complete topics */
	pubCom : function(cid, always, ctopics, targets, indi, o) {
		var self = this;
		var c = $(cid);
		return function(request, status) {
			var orginal = {};
			orginal.request = request;
			orginal.status = status;

			self.hideIndicator(indi);

			self.publishTopic(c, ctopics, orginal);
			self.publishTopic(c, always, orginal);

			var ec = targets;
			if (!ec) {
				ec = o.id;
			}
			if (ec) {
				var divEffectTopic = '_sj_div_effect_';
				$.each(ec.split(','), function(i, target) {
					var effect_elem = $(self.escId(target));
					effect_elem.publish(divEffectTopic + target + o.id, o);
				});
			}
			if (o.resizable) {
				if (!self.loadAtOnce) {
					self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.resizable" + self.minSuffix + ".js" ]);
				}
				var ros = o.resizableoptions;
				var ro = window[ros];
				if (!ro) {
					ro = eval("( " + ros + " )");
				}
				else {
					ro = {};
				}
				ro.start = self.pubTops(c, o.onalw, o.resizableonstarttopics);
				ro.stop = self.pubTops(c, o.onalw, o.resizableonstoptopics);
				ro.resize = self.pubTops(c, o.onalw, o.resizableonresizetopics);
				c.resizable(ro);
			}
		};
	},

	/** publish error topics */
	pubErr : function(cid, always, etopics, etext, modus) {
		var self = this;
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
					else if (self.defaults.errorText !== null) {
						c.html(self.defaults.errorText);
					}
				}

				self.publishTopic(c, etopics, orginal);
				self.publishTopic(c, always, orginal);
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
		var self = this;

		if (el) {
			var $el = $(el);
			el = $el[0];

			var tag = el.tagName.toLowerCase();
			o.tagname = tag;

			// extension point to allow custom pre-binding processing
			if (typeof (self.preBind) != "function" || self.preBind($el)) {

				if (!o.jqueryaction) {
					o.jqueryaction = tag;
				}

				self.log('bind ' + o.jqueryaction + ' on ' + o.id);
				self[o.jqueryaction]($el, o);

				// extension point to allow custom post-binding processing
				if (self.postBind && (typeof (self.postBind) == "function")) { return self.postBind(el); }
			}

		}
	},

	/** register a specific struts2 jquery action */
	jqueryaction : function(name, binder) {
		var self = this;
		if (name && binder) {
			self[name] = binder;
		}
	},

	/** opens a dialog if attribute openDialog in Anchor or Submit Tag is set to true */
	opendialog : function($elem, o) {
		var self = this;
		self.log('open dialog : ' + o.opendialog);

		if (o.opendialog) {
			var dialog = $(self.escId(o.opendialog));
			$elem.bind('click', function(event) {
				if (o.href && o.href != '#') {
					o.targets = o.opendialog;
					var divTopic = '_s2j_dialog_load_' + o.id;
					self.subscribeTopics(dialog, divTopic, self.handler.load, o);
					dialog.publish(divTopic, o);
				}

				dialog.dialog('open');
				return false;
			});
		}
	},

	/** Handles remote and effect actions */
	action : function($elem, o, loadHandler, type) {
		var self = this;
		var actionTopic = '_sj_action_' + o.id;
		var href = o.href;

		if (href === null || href === "") {
			href = "#";
			o.href = href;
		}

		var effectTopic = '_sj_div_effect_';
		var effect = {};
		effect.effect = o.effect;
		effect.effectoptions = o.effectoptions;
		effect.effectmode = o.effectmode;
		effect.oneffect = o.oneffect;
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
				var tarelem = $(self.escId(target));

				//when no target is found (e.g. a json call)
				// the action was subscribed to the publisher
				if(tarelem.length === 0){
					tarelem = $elem;
				}

				self.subscribeTopics(tarelem, actionTopic, loadHandler, o);
				self.subscribeTopics(tarelem, effectTopic + target + o.id, self.handler.effect, effect);

				if (self.ajaxhistory) {
					var params = {};
					params.target = target;
					params.topic = actionTopic;
					$elem.bind('click', params, function(event) {
						self.historyelements[event.data.target] = event.data.topic;
						$.bbq.pushState(self.historyelements);
						return false;
					});
				}
			});
		}
		else { // if no targets, then the action can still execute ajax request and will handle itself (no loading result into container

			effect.targets = o.id;
			self.subscribeTopics($(self.escId(o.id)), effectTopic + o.id + o.id, self.handler.effect, effect);

			// bind event topic listeners
			if (o.onbef || o.oncom || o.onsuc || o.onerr) {
				self.subscribeTopics($elem, actionTopic, loadHandler, o);
			}
		}

		if (type == "a") {
			$elem.publishOnEvent('click', actionTopic); // bind custom action topic to click event
		}

	},

	/** Handle all Container Elements Divs, Textarea, Textfield */
	container : function($elem, o) {
		var self = this;
		self.log('container : ' + o.id);
		self.action($elem, o, self.handler.load, 'div');
		var divTopic = '_s2j_div_load_' + o.id;
		var divEffectTopic = '_s2j_div_effect_' + o.id;

		// load div using ajax only when href is specified or form is defined
		if ((o.formids && !o.type) || (o.href && o.href != '#')) {
			if (o.href != '#') {
				self.subscribeTopics($elem, o.reloadtopics, self.handler.load, o);
				self.subscribeTopics($elem, o.listentopics, self.handler.load, o);
				// publishing not triggering to prevent event propagation issues
				self.subscribeTopics($elem, divTopic, self.handler.load, o);

				if (o.bindon) {
					var $bindElement = $('#' + o.bindon);
					if (o.events) {
						$.each(o.events.split(','), function(i, event) {
							$bindElement.publishOnEvent(event, divTopic, o);
						});
					}
					else {
						$bindElement.publishOnEvent('click', divTopic, o);
					}
				}
				else if (!o.deferredloading) {
					$elem.publish(divTopic, o);
				}

			}
			else if (o.formids) {
				if (!self.loadAtOnce) {
					self.require("js/plugins/jquery.form" + self.minSuffix + ".js");
				}
				o.targets = o.id;
				self.formsubmit($elem, o, divTopic);
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
				self.subscribeTopics($elem, divEffectTopic + o.id + o.id, self.handler.effect, effect);
			}

			if (o.events || o.bindon) {

				var bindel = $elem;
				var eventsStr = 'click';
				if (o.bindon) {
					bindel = $(self.escId(o.bindon));
				}
				if (o.events) {
					eventsStr = o.events;
				}

				$.each(eventsStr.split(','), function(i, event) {
					if (o.onbef) {
						$.each(o.onbef.split(','), function(i, btopic) {
							bindel.publishOnEvent(event, btopic);
						});
					}
					bindel.publishOnEvent(event, divEffectTopic + o.id + o.id, o);
					if (o.oncom) {
						$.each(o.oncom.split(','), function(i, ctopic) {
							bindel.publishOnEvent(event, ctopic);
						});
					}
				});
			}
			else {
				if (o.onbef) {
					$.each(o.onbef.split(','), function(i, bts) {
						$elem.publish(bts, o);
					});
				}
				$elem.publish(divEffectTopic + o.id + o.id, o);
				if (o.oncom) {
					$.each(o.oncom.split(','), function(i, cts) {
						$elem.publish(cts, o);
					});
				}
			}

			if (o.resizable) {
				if (!self.loadAtOnce) {
					self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.resizable" + self.minSuffix + ".js" ]);
				}
				var ros = o.resizableoptions;
				var ro = window[ros];
				if (!ro) {
					ro = eval("( " + ros + " )");
				}
				else {
					ro = {};
				}
				ro.start = self.pubTops($elem, o.onalw, o.resizableonstarttopics);
				ro.stop = self.pubTops($elem, o.onalw, o.resizableonstoptopics);
				ro.resize = self.pubTops($elem, o.onalw, o.resizableonresizetopics);
				$elem.resizable(ro);
			}
		}

		if (o.draggable) {
			self.log('draggable : ' + o.id);
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js" ]);
			}
			var daos = o.draggableoptions;
			var dao = window[daos];
			if (!dao) {
				dao = eval("( " + daos + " )");
			}
			else {
				dao = {};
			}
			dao.start = self.pubTops($elem, o.onalw, o.draggableonstarttopics);
			dao.stop = self.pubTops($elem, o.onalw, o.draggableonstoptopics);
			dao.drap = self.pubTops($elem, o.onalw, o.draggableondragtopics);
			$elem.draggable(dao);
		}

		if (o.droppable) {
			self.log('droppable : ' + o.id);
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js", "js/base/jquery.ui.droppable" + self.minSuffix + ".js" ]);
			}
			var doos = o.droppableoptions;
			var doo = window[doos];
			if (!doo) {
				doo = eval("( " + doos + " )");
			}
			else {
				doo = {};
			}
			doo.activate = self.pubTops($elem, o.onalw, o.droppableonactivatetopics);
			doo.deactivate = self.pubTops($elem, o.onalw, o.droppableondeactivatetopics);
			doo.start = self.pubTops($elem, o.onalw, o.droppableonstarttopics);
			doo.stop = self.pubTops($elem, o.onalw, o.droppableonstoptopics);
			doo.drop = self.pubTops($elem, o.onalw, o.droppableondroptopics);
			$elem.droppable(doo);
		}

		if (o.selectable) {
			self.log('selectable : ' + o.id);
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.selectable" + self.minSuffix + ".js" ]);
			}
			var seos = o.selectableoptions;
			var seo = window[seos];
			if (!seo) {
				seo = eval("( " + seos + " )");
			}
			else {
				seo = {};
			}
			seo.selected = self.pubTops($elem, o.onalw, o.selectableonselectedtopics);
			seo.selecting = self.pubTops($elem, o.onalw, o.selectableonselectingtopics);
			seo.start = self.pubTops($elem, o.onalw, o.selectableonstarttopics);
			seo.stop = self.pubTops($elem, o.onalw, o.selectableonstoptopics);
			seo.unselected = self.pubTops($elem, o.onalw, o.selectableonunselectedtopics);
			seo.unselecting = self.pubTops($elem, o.onalw, o.selectableonunselectingtopics);
			$elem.selectable(seo);
		}

		if (o.sortable) {
			self.log('sortable : ' + o.id);
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.sortable" + self.minSuffix + ".js" ]);
			}
			var soos = o.sortableoptions;
			var soo = window[soos];
			if (!soo) {
				soo = eval("( " + soos + " )");
			}
			else {
				soo = {};
			}
			soo.beforeStop = self.pubTops($elem, o.onalw, o.sortableonbeforestoptopics);
			soo.stop = self.pubTops($elem, o.onalw, o.sortableonstoptopics);
			soo.start = self.pubTops($elem, o.onalw, o.sortableonstarttopics);
			soo.sort = self.pubTops($elem, o.onalw, o.sortableonsorttopics);
			soo.activate = self.pubTops($elem, o.onalw, o.sortableonactivatetopics);
			soo.deactivate = self.pubTops($elem, o.onalw, o.sortableondeactivatetopics);
			soo.over = self.pubTops($elem, o.onalw, o.sortableonovertopics);
			soo.out = self.pubTops($elem, o.onalw, o.sortableonouttopics);
			soo.remove = self.pubTops($elem, o.onalw, o.sortableonremovetopics);
			soo.receive = self.pubTops($elem, o.onalw, o.sortableonreceivetopics);
			soo.change = self.pubTops($elem, o.onalw, o.sortableonchangetopics);
			soo.update = self.pubTops($elem, o.onalw, o.sortableonupdatetopics);
			$elem.sortable(soo);
		}

		if (o.oncha) {
			if (o.type) {
				if (o.type == 'text') {
					$elem.keyup( function() {
						self.publishTopic($elem, o.oncha, {});
					});
				}
				else if (o.type == 'select') {
					$elem.change( function() {
						self.publishTopic($elem, o.oncha, {});
					});
				}
			}
		}
	},

	/** Handle the Anchor Element */
	anchor : function($elem, o) {
		var self = this;
		self.log('anchor : ' + o.id);

		if (o.onclick) {
			$.each(o.onclick.split(','), function(i, topic) {
				$elem.publishOnEvent('click', topic);
			});
		}

		if (o.opendialog) {
			self.opendialog($elem, o);
		}
		if (o.button) {
			self.jquerybutton($elem, o);
		}

		if (o.formids) {
			var formTopic = '_s2j_form_topic_' + o.id;
			self.formsubmit($elem, o, formTopic);
			$elem.publishOnEvent('click', formTopic);
		}
		else {

			self.action($elem, o, self.handler.load, 'a');
			if(o.targets && (o.reloadtopic || o.listentopics)) {
				$.each(o.targets.split(','), function(i, t) {
					var te = $(self.escId(t));
					self.subscribeTopics(te, o.reloadtopics, self.handler.load, o);
					self.subscribeTopics(te, o.listentopics, self.handler.load, o);
				});
			}
		}
	},

	/** Handle dynamic Select Boxes */
	select : function($elem, o) {
		var self = this;
		self.log('select : ' + o.id);
		if (!self.loadAtOnce) {
			self.require("js/plugins/jquery.form" + self.minSuffix + ".js");
		}
		var selectTopic = '_s2j_topic_load_' + o.id;

		if (o.href && o.href != '#') {

			self.subscribeTopics($elem, o.reloadtopics, self.handler.load, o);
			self.subscribeTopics($elem, o.listentopics, self.handler.load, o);
			self.subscribeTopics($elem, selectTopic, self.handler.load, o);
			if (!o.deferredloading) {
				$elem.publish(selectTopic, o);
			}
		}
		if (o.oncha) {
			$.each(o.oncha.split(','), function(i, cts) {
				$elem.publishOnEvent('change', cts);
			});
		}
		if (o.autocomplete) {
			self.require("js/plugins/jquery.combobox" + self.minSuffix + ".js");
			$elem.combobox(o);
		}
	},

	/** Handle the Submit Button */
	button : function($elem, o) {
		var self = this;
		var formTopic = '_s2j_form_topic_' + o.id;

		if (o.opendialog) {
			self.opendialog($elem, o);
		}
		if (o.button) {
			self.jquerybutton($elem, o);
		}

		if (o.formids !== undefined) {
			self.formsubmit($elem, o, formTopic);
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
				self.formsubmit($elem, o, formTopic);
			}
			else {
				self.action($elem, o, self.handler.load, 'a');
			}
		}
		if (o.onclick) {
			$.each(o.onclick.split(','), function(i, topic) {
				$elem.publishOnEvent('click', topic);
			});
		}
		$elem.publishOnEvent('click', formTopic);
		$elem.removeAttr('name');
	},

	/** Handle all AJAX Forms submitted from Anchor or Submit Button */
	formsubmit : function($elem, o, topic) {
		var self = this;
		self.log('formsubmit : ' + o.id);
		if (!self.loadAtOnce) {
			self.require("js/plugins/jquery.form" + self.minSuffix + ".js");
		}

		self.subscribeTopics($elem, o.reloadtopics, self.handler.form, o);
		self.subscribeTopics($elem, o.listentopics, self.handler.form, o);

		if (o.targets) {
			self.subscribeTopics($elem, topic, self.handler.form, o);
			$.each(o.targets.split(','), function(i, target) {
				$(self.escId(target)).subscribe(topic, self.handler.effect, o);
				if (self.ajaxhistory) {
					var params = {};
					params.target = target;
					params.topic = topic;
					$elem.bind('click', params, function(event) {
						self.historyelements[event.data.target] = event.data.topic;
						$.bbq.pushState(self.historyelements);
						return false;
					});
				}
			});
		}
		else {
			// Submit Forms without AJAX
			$elem.click( function() {
				$(self.escId(o.formids)).submit();
				return false;
			});
		}
	},

	/** Handle the Dialog Widget */
	dialog : function($elem, o) {
		var self = this;
		self.log('dialog : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.position" + self.minSuffix + ".js", "js/base/jquery.ui.resizable" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js", "js/base/jquery.bgiframe" + self.minSuffix + ".js", "js/base/jquery.ui.dialog" + self.minSuffix + ".js" ]);
		}
		var params = {};
		$.extend(params, o);
		params.bgiframe = true;
		if (o.hide) {
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.effects.core" + self.minSuffix + ".js", "js/base/jquery.effects." + o.hide + "" + self.minSuffix + ".js" ]);
			}
			params.hide = o.hide;
		}
		if (o.show) {
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.effects.core" + self.minSuffix + ".js", "js/base/jquery.effects." + o.show + "" + self.minSuffix + ".js" ]);
			}
			params.show = o.show;
		}
		params.open = function(event, ui) {
			var data = {};
			data.event = event;
			data.ui = ui;

			if (o.href && o.href != '#') {
				var divTopic = '_s2j_topic_load_' + o.id;
				self.subscribeTopics($elem, divTopic, self.handler.load, o);
				$elem.publish(divTopic);
			}

			self.publishTopic($elem, o.onalw, data);
			self.publishTopic($elem, o.onbef, data);
			self.publishTopic($elem, o.onopentopics, data);
		};
		params.close = self.pubTops($elem, o.onalw, o.onclosetopics);
		params.focus = self.pubTops($elem, o.onalw, o.onfocustopics);
		params.beforeclose = self.pubTops($elem, o.onalw, o.onbeforeclosetopics);
		params.drag = self.pubTops($elem, o.onalw, o.oncha);
		$elem.dialog(params);
	},

	/** Handle the TabbedPanel Widget */
	tabbedpanel : function($elem, o) {
		var self = this;
		self.log('tabbedpanel : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.tabs" + self.minSuffix + ".js" ]);
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
			if (!self.loadAtOnce) {
				self.require("js/base/jquery.effects.core" + self.minSuffix + ".js");
			}
			para.fx = {
				opacity :'toggle'
			};
		}
		if (o.cookie) {
			if (!self.loadAtOnce) {
				self.require("js/base/jquery.cookie" + self.minSuffix + ".js");
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
		else if (self.defaults.loadingText !== null) {
			para.spinner = self.defaults.loadingText;
		}

		if (o.selectedtab) {
			para.selected = o.selectedtab;
		}
		if (o.oncom) {
			para.ajaxOptions = {
			dataType :'html',
			complete :self.pubCom(o.id, o.onalw, o.oncom, null, null, {})
			};
		}
		else {
			para.ajaxOptions = {
				dataType :'html'
			};
		}
		if (o.onbef) {
			para.show = self.pubTops($elem, o.onalw, o.onbef);
		}
		if (o.oncha) {
			para.select = self.pubTops($elem, o.onalw, o.oncha);
		}
		if (o.onenabletopics) {
			para.enable = self.pubTops($elem, o.onalw, o.onenabletopics);
		}
		if (o.ondisabletopics) {
			para.disable = self.pubTops($elem, o.onalw, o.ondisabletopics);
		}
		if (o.onaddtopics) {
			para.add = self.pubTops($elem, o.onalw, o.onaddtopics);
		}
		if (o.onremovetopics) {
			para.remove = self.pubTops($elem, o.onalw, o.onremovetopics);
		}
		if (o.oncom) {
			para.load = self.pubTops($elem, o.onalw, o.onremovetopics);
		}

		var tabs = $elem.data('taboptions');
		var closable = false;
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
				tabStr += "</span></a>";
				if (tab.closable) {
					tabStr += "<span class='ui-icon ui-icon-close s2j-tab-closable' style='float: left; margin: 0.4em 0.2em 0 0; cursor: pointer;'>&nbsp;</span>";
					closable = true;
				}
				tabStr += "</li>";
			}
			$(self.escId(o.id) + ' > ul').html(tabStr);
		}

		$elem.tabs(para);

		if (o.sortable) {
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.sortable" + self.minSuffix + ".js" ]);
			}
			$elem.find(".ui-tabs-nav").sortable({axis:'x'});
		}

		if (closable) {
			$("#"+o.id+" span.s2j-tab-closable").live('click', function() {
				var index = $('li',$elem).index($(this).parent());
				$elem.tabs('remove', index);
			});
		}
		// History and Bookmarking for Tabs
		if (self.ajaxhistory) {
			var ahp = {};
			ahp.id = o.id;
			$elem.find('ul.ui-tabs-nav a').bind('click', ahp, function(e) {
				var idx = $(self.escId(e.data.id)).tabs('option', 'selected');
				self.historyelements[e.data.id] = idx;
				$.bbq.pushState(self.historyelements);
				return false;
			});

			$(window).bind('hashchange', ahp, function(e) {
				var idx = e.getState(e.data.id, true) || 0;
				$(self.escId(e.data.id)).tabs('select', idx);
			});
		}
	},

	/** Handle the Datepicker Widget */
	datepicker : function($elem, o) {
		var self = this;
		self.log('datepicker : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.datepicker" + self.minSuffix + ".js" ]);
		}
		if (self.local != "en") {
			self.require("i18n/jquery.ui.datepicker-" + self.local + ".min.js");
		}
		var params = {};

		if (o) {

			var oat = o.onalw;

			if (o.onbef) {
				params.beforeShow = function(input, inst) {
					var $input = $(input);
					var data = {};
					data.input = input;
					data.inst = inst;
					self.publishTopic($input, o.onbef, data);
					self.publishTopic($input, oat, data);
				};
			}

			if (o.onbeforeshowdaytopics) {
				params.beforeShowDay = function(date) {
					var data = {};
					data.date = date;
					self.publishTopic($elem, o.onbeforeshowdaytopics, data);
					self.publishTopic($elem, oat, data);
				};
			}

			if (o.onchangemonthyeartopics) {
				params.onChangeMonthYear = function(year, month, inst) {
					var data = {};
					data.year = year;
					data.month = month;
					data.inst = inst;
					self.publishTopic($elem, o.onchangemonthyeartopics, data);
					self.publishTopic($elem, oat, data);
				};
			}

			if (o.oncha) {
				params.onSelect = function(dateText, inst) {
					var data = {};
					data.dateText = dateText;
					data.inst = inst;
					self.publishTopic($elem, o.oncha, data);
					self.publishTopic($elem, oat, data);
				};
			}

			if (o.oncom) {
				params.onClose = function(dateText, inst) {
					var data = {};
					data.dateText = dateText;
					data.inst = inst;
					self.publishTopic($elem, o.oncom, data);
					self.publishTopic($elem, oat, data);
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
				if (!self.loadAtOnce) {
					self.require("js/base/jquery.effects.core" + self.minSuffix + ".js");
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
		var self = this;
		self.log('slider : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.slider" + self.minSuffix + ".js" ]);
		}

		var params = {};
		if (o) {

			params.start = self.pubTops($elem, o.onalw, o.onbef);
			params.change = self.pubTops($elem, o.onalw, o.oncha);
			params.stop = self.pubTops($elem, o.onalw, o.oncom);

			params.slide = function(event, ui) {
				if (o.hiddenid) {
					$(self.escId(o.hiddenid)).val(ui.value);
				}
				if (o.displayvalueelement) {
					$(self.escId(o.displayvalueelement)).html(ui.value);
				}
				if (o.onslidetopics) {
					var data = {};
					data.event = event;
					data.ui = ui;

					self.publishTopic($elem, o.onalw, data);
					self.publishTopic($elem, o.onslidetopics, data);
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

	/** Handle the Spinner Widget */
	spinner : function($elem, o) {
		var self = this;
		self.log('spinner : ' + o.id);
		self.container($elem, o);
		if (!self.loadAtOnce) {
			self.require("js/base/jquery.ui.widget" + self.minSuffix + ".js");
			if (o.mouseWheel) {
				self.require("js/base/jquery.ui.mouse" + self.minSuffix + ".js");
			}
		}
		self.require("js/plugins/jquery.ui.spinner" + self.minSuffix + ".js");
		self.requireCss("themes/ui.spinner.css");

		if (o.oncha) {
			o.change = self.pubTops($elem, o.onalw, o.oncha);
		}

		$elem.spinner(o);
	},

	/** Handle the Progressbar Widget */
	progressbar : function($elem, o) {
		var self = this;
		self.log('progressbar : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.progressbar" + self.minSuffix + ".js" ]);
		}
		var params = {};
		if (o) {

			params.change = self.pubTops($elem, o.onalw, o.oncha);

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
		var self = this;
		self.log('accordion : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.accordion" + self.minSuffix + ".js" ]);
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

			var onAlwaysTopics = o.onalw;
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
				if (o.onbef) {
					var data = {};
					data.event = event;
					data.ui = ui;

					self.publishTopic($elem, onAlwaysTopics, data);
					self.publishTopic($elem, o.onbef, data);
				}
			};

			params.change = self.pubTops($elem, o.onalw, o.oncha);
		}
		$elem.accordion(params);
		if (o.href && active === true) {
			var aktiv = $(self.escId(o.id) + " li " + params.header).filter('.ui-accordion-header').filter('.ui-state-active').find('a');
			if (typeof $(aktiv).attr('paramkeys') != "undefined") {
				var keys = $(aktiv).attr('paramkeys').split(',');
				var values = $(aktiv).attr('paramvalues').split(',');
				var valueparams = {};
				$.each(keys, function(i, val) {
					valueparams[val] = values[i];
				});
				$(self.escId(o.id) + " li div").filter('.ui-accordion-content-active').load(o.href, valueparams, function() {
				});
			}
		}
	},

	/** Handle the Autocompleter Widget */
	autocompleter : function($elem, o) {
		var self = this;
		self.log('autocompleter for : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.position" + self.minSuffix + ".js", "js/base/jquery.ui.autocomplete" + self.minSuffix + ".js" ]);
		}
		var params = {};
		var url = '';
		if (o.href && o.href != '#') {
			url = o.href;
			if (o.hrefparameter) {
				url = url + '?' + o.hrefparameter;
			}
		}
		if(url !== '') {
			if(o.list) {
				params.source = function(request, response) {

					jQuery.ui.autocomplete.prototype._renderItem = function( ul, item ) {
					  return $( "<li></li>" )
					    .data( "item.autocomplete", item )
					    .append( "<a>" + item.label + "</a>" )
					    .appendTo( ul );
					};

					$.ajax({
						url: url,
						dataType: "json",
						data: {
						term: request.term
						},
						success: function(data) {
							var x = 0;
							if (data[o.list] !== null) {
								var isMap = false;
								if (!$.isArray(data[o.list])) {
									isMap = true;
								}
								var result = [];
								$.each(data[o.list], function(j, val) {
									if (isMap) {
										result.push({
											label: val.replace(
													new RegExp(
															"(?![^&;]+;)(?!<[^<>]*)(" +
															$.ui.autocomplete.escapeRegex(request.term) +
															")(?![^<>]*>)(?![^&;]+;)", "gi"
														), "<strong>$1</strong>" ),
											value: j
										});
									}
									else {
										if (o.listkey !== undefined && o.listvalue !== undefined) {
											result.push({
												label: val[o.listvalue].replace(
														new RegExp(
																"(?![^&;]+;)(?!<[^<>]*)(" +
																$.ui.autocomplete.escapeRegex(request.term) +
																")(?![^<>]*>)(?![^&;]+;)", "gi"
															), "<strong>$1</strong>" ),
												value: val[o.listkey]
											});
										}
										else {
											result.push({
												label: data[o.list][x].replace(
														new RegExp(
																"(?![^&;]+;)(?!<[^<>]*)(" +
																$.ui.autocomplete.escapeRegex(request.term) +
																")(?![^<>]*>)(?![^&;]+;)", "gi"
															), "<strong>$1</strong>" ),
												value: data[o.list][x]
											});
										}
									}
									x++;
								});
								response(result);
							}
						}
					});
				};
			}
			else {
				params.source = url;
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

		if (o.onsuc) {
			params.open = self.pubTops($elem, o.onalw, o.onsuc);
		}
		if (o.oncha) {
			params.change = self.pubTops($elem, o.onalw, o.oncha);
		}
		if (o.oncom) {
			params.close = self.pubTops($elem, o.onalw, o.oncom);
		}
		if (o.onsearchtopics) {
			params.search = self.pubTops($elem, o.onalw, o.onsearchtopics);
		}
		if (o.onfocustopics) {
			params.focus = self.pubTops($elem, o.onalw, o.onfocustopics);
		}
		if (o.onselecttopics) {
			params.select = self.pubTops($elem, o.onalw, o.onselecttopics);
		}

		if (o.selectBox === false) {
			$elem.autocomplete(params);
		}
		else {
			self.require("js/plugins/jquery.combobox" + self.minSuffix + ".js");
			if (o.selectBoxIcon) {
				params.icon = true;
			}
			else {
				params.icon = false;
			}
			$elem.combobox(params);
		}
	},

	/** Handle the Button Widget for Anchor or Submit Tag*/
	jquerybutton : function($elem, o) {
		var self = this;
		self.log('button for : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js" ]);
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
		var self = this;
		self.log('buttonset for : ' + o.id);
		if (!self.loadAtOnce) {
			self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js" ]);
		}
		var buttonsetLoadTopic = '_s2j_topic_load_' + o.id;

		if (o.href && o.href != '#') {

			var buttonsetTopic = 's2j_butonset_' + o.id;

			if ($elem.isSubscribed(buttonsetTopic)) {
				$elem.unsubscribe(buttonsetTopic);
			}

			// Init Buttonset after elements loaded via AJAX.
			$elem.subscribe(buttonsetTopic, function(event, data) {
				if (o.oncha) {
					var selectString = self.escId(o.id) + " > input";
					var elements = $(selectString);

					if ($.browser.msie && o.type == 'radio') {
						elements.click( function() {
							this.blur();
							this.focus();
							$.each(o.oncha.split(','), function(i, cts) {
								$elem.publish(cts);
							});
						});
					}
					else {
						elements.change( function() {
							$.each(o.oncha.split(','), function(i, cts) {
								$elem.publish(cts);
							});
						});
					}
				}

				if(o.buttonset) {
					$elem.buttonset(o);
				}
			});
			if (o.onsuc && o.onsuc !== '') {
				o.onsuc = buttonsetTopic;
			}
			else {
				o.onsuc = buttonsetTopic;
			}

			self.subscribeTopics($elem, o.reloadtopics, self.handler.load, o);
			self.subscribeTopics($elem, o.listentopics, self.handler.load, o);

			$elem.subscribe(buttonsetLoadTopic, self.handler.load);
			$elem.publish(buttonsetLoadTopic, o);
		}
		else {
			if (o.oncha) {
				$(self.escId(o.id) + " > input").change( function() {
					$.each(o.oncha.split(','), function(i, cts) {
						$elem.publish(cts);
					});
				});
			}

			if(o.buttonset) {
				$elem.buttonset(o);
			}
		}
	}
	};

	/**
	 * Container logic
	 * Register handler to load a container
	 * */
	$.subscribeHandler($.struts2_jquery.handler.load, function(event, data) {

		var _s2j = $.struts2_jquery;

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
				var onAlwaysTopics = o.onalw;

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

				params.success = _s2j.pubSuc(event.target, onAlwaysTopics, o.onsuc, indi, modus, o);
				params.complete = _s2j.pubCom(event.target, onAlwaysTopics, o.oncom, o.targets, indi, o);
				params.error = _s2j.pubErr(event.target, onAlwaysTopics, o.onerr, o.errortext, modus);

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

					if (o.formids && params.data === '') {
						if (!_s2j.loadAtOnce) {
							_s2j.require("js/plugins/jquery.form" + _s2j.minSuffix + ".js");
						}
						$.each(o.formids.split(','), function(i, fid) {
							var query = $(_s2j.escId(fid)).formSerialize();
							if (params.data !== '') {
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
					_s2j.publishTopic(container, o.onbef, o);

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
	$.subscribeHandler($.struts2_jquery.handler.form, function(event, data) {
		var _s2j = $.struts2_jquery;

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
				if (params.target === '') {
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

			_s2j.publishTopic(container, o.onalw, orginal);

			if (o.onbef) {
				$.each(o.onbef.split(','), function(i, topic) {
					elem.publish(topic, elem, orginal);
					var submitForm = orginal.options.submit;
					// cancel form submission
					if (!submitForm) {
						_s2j.hideIndicator(o.indicatorid);
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
				if (valParams.data !== '') {
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

		params.success = _s2j.pubSuc(elem, o.onalw, o.onsuc, indi, 'form', o);
		params.complete = _s2j.pubCom(elem, o.onalw, o.oncom, o.targets, indi, o);
		params.error = _s2j.pubErr(elem, o.onalw, o.onerr, o.errortext, 'html');

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
	$.subscribeHandler($.struts2_jquery.handler.effect, function(event, data) {
		var _s2j = $.struts2_jquery;

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

			var callback;
			var tar = $(_s2j.escId(o.targets));
			if(o.oneffect) {

				$.subscribe(tar, o.oneffect, o);

				callback = function () {
					_s2j.publishTopic(tar, o.oneffect, o);
				};
			}

			if (!_s2j.loadAtOnce) {
				_s2j.require( [ "js/base/jquery.effects.core" + _s2j.minSuffix + ".js", "js/base/jquery.effects." + o.effect + "" + _s2j.minSuffix + ".js" ]);
			}
			_s2j.log('effect ' + o.effect + ' for ' + o.targets);
			if(!o.effectmode || o.effectmode == 'none' ) {
				tar.effect(o.effect, eo, duration, callback);
			}
			else if (o.effectmode == 'show') {
				tar.show(o.effect, eo, duration, callback);
			}
			else if (o.effectmode == 'hide') {
				tar.hide(o.effect, eo, duration, callback);
			}
			else if (o.effectmode == 'toggle') {
				tar.toggle(o.effect, eo, duration, callback);
			}
		}
	});

})(jQuery);
