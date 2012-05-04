/*!
 * jquery.struts2.js
 *
 * Integration of jquery and jquery ui with struts 2
 * for ajax, widget and interactions support in struts 2
 *
 * Requires use of jQuery.
 * Tested with jQuery 1.7 and jQuery UI 1.8
 *
 * Copyright (c) 2008 Eric Chijioke (obinna a-t g mail dot c o m)
 * Copyright (c) 2012 Johannes Geppert http://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global jQuery, document, window, StrutsUtils  */
/*jslint evil: true */

(function( $, undefined ) {
	"use strict";
	
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
	timeLocal :"en",
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
	currentXhr :{},

	/**
	 * helper function for debug logging
	 * set debug to true in the head tag to enable debug logging
	 *  */
	log : function(message) {
		if (this.debug) {
			var msg = this.debugPrefix + message;
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

	/**Add Parameter to URL */
	addParam : function(url, param) {
		if (url.indexOf("?") > 0) {
			return url+"&"+param;
		}
		else {
			return url+"?"+param;
		}
	},

	/**Change Parameter Value in URL */
	changeParam : function(url, param, value) {
		var ua = url.split("?"), // split url
			pa = ua[1].split("&"), // split query 
			ia = [],
			i; 
		for (i=0; i < pa.length; i++) { 
			ia = pa[i].split("="); // split name/value 
			if (ia[0] === param) { 
				pa[i] = ia[0] + "=" + value; 
			}
		}
		return ua[0] + "?" + pa.join("&"); 
	},

	/** Load required JavaScript Resourcess */
	require : function(files, callBack, basePath) {
		var self = this, successFunction, path;
		successFunction = callBack || function() {
		};
		path = basePath || null;

		if (path === null && !$.scriptPath) {
			path = "";
		}
		else if (path === null && $.scriptPath) {
			path = $.scriptPath;
		}

		if (typeof files === "string") {
			files = files.split(",");
		}
		$.each(files, function(i, file) {
			
			file = self.addParam(file, "s2j="+$.struts2_jquery.version);
			
			if (!$.struts2_jquery.scriptCache[file]) {
				self.log('load require script ' + (path + file));
				$.ajax( {
				type :"GET",
				scriptCharset:"UTF-8",
				url :path + file,
				success :successFunction,
				dataType :"script",
				cache :true,
				async :false
				});
				$.struts2_jquery.scriptCache[file] = true;
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
		if (this.defaults.indicator !== '') {
			$(this.escId(this.defaults.indicator)).hide();
		}
	},

	/** Helper function to show indicator */
	showIndicator : function(indi) {
		if (indi) {
			$(this.escId(indi)).show();
		}
		if (this.defaults.indicator !== '') {
			$(this.escId(this.defaults.indicator)).show();
		}
	},

	/** Abort current requests */
	abortReq : function(id) {
		var xhr = this.currentXhr[id];
		if(xhr && xhr !== null){
			if(xhr.readyState < 4) {
				xhr.abort();
			}
		}
	},

	/** Helper function to validate Forms */
	validateForm : function(form, o) {
		var self = this,
			submit = true,
			params = {};

		if (!self.loadAtOnce) {
			self.require("js/plugins/jquery.form" + self.minSuffix + ".js");
		}
		
		params.type = "POST";
		params.data = {
				"struts.enableJSONValidation": true,
				"struts.validateOnly": true
		};
		if (o.href && o.href !== '#') {
			params.url = o.href;
		}
		else {
			params.url = form[0].action;
		}

		if (o.hrefparameter) {
			params.url = params.url + '?' + o.hrefparameter;
		}

		params.cache = false;
		//params.forceSync = true;
		params.async = false;

		params.complete = function(request, status) {
			var f = $(form[0]),
				et = request.responseText,
				errors;
			if ($.isFunction(o.validateFunction)) {
				if (et && et.length > 10) {
					submit = false;
					if(et.substring(0,2) === "/*") {
						// Handle Validation Errors for all Struts2 versions until 2.2.3.1
						errors = $.parseJSON(et.substring(2, et.length - 2));
					}
					else {
						errors = $.parseJSON(et);
					}
					o.validateFunction(f, errors);
				}
			}
			else if (StrutsUtils !== undefined) {
				StrutsUtils.clearValidationErrors(form[0]);

				// get errors from response
				if(et.substring(0,2) === "/*") {
					errors = StrutsUtils.getValidationErrors(et);
				}
				else {
					errors = StrutsUtils.getValidationErrors($.parseJSON(et));
				}

				// show errors, if any
				if (errors.fieldErrors || errors.errors) {
					StrutsUtils.showValidationErrors(form[0], errors);
					submit = false;
				}
			}
			self.log('form validation : ' + submit);
		};

		form.ajaxSubmit(params);

		return submit;
	},

	addForms : function(forms, url) {
		var self = this;
		if (forms) {
			if (!self.loadAtOnce) {
				self.require("js/plugins/jquery.form" + self.minSuffix + ".js");
			}
			$.each(forms.split(','), function(i, f) {
				var q = $(self.escId(f)).formSerialize();
				url = self.addParam(url, q);
			});
		}
		return url;
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
		if (topics && elem) {
			$.each(topics.split(','), function(i, t) {
				if (elem.isSubscribed(t)) {
					elem.destroyTopic(t);
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
		var self = this,
			c = $(cid),
			i,idv,element = null,
			x = 0,
			isMap = false;

		return function(data, status, request) {
			var orginal = {};
			orginal.data = data;
			orginal.status = status;
			orginal.request = request;

			// Handle HTML Result for Divs, Submit and Anchor
			if (modus === 'html' && !$.isArray(data) && !$.isPlainObject(data)) {
				c.html(data);
			}

			// Handle Text Result for Textarea or Textfield
			else if (modus === 'value') {
				c.val($.trim(data));
			}

			// Hanlde Result for Select, Radiobuttons and Checkboxes
			else if (modus === 'select' || modus === 'radio' || modus === 'checkbox') {
				if (modus === 'select') {
					c[0].length = 0;
				}
				else {
					c.children().remove();
				}

				if (typeof (data) === "object" || $.isArray(data)) {
					i = -1;

					if (modus === 'select') {
						// Header Option
						if (o.headerkey && o.headervalue) {
							element = $('<option value="' + o.headerkey + '">' + o.headervalue + '</option>');
							if (o.value === o.headervalue) {
								element.prop("selected", true);
							}
							element.appendTo(c);
						}

						// Is Empty Option set to true
						if (o.emptyoption) {
							$('<option></option>').appendTo(c);
						}
					}

					// Loop over Elements
					if (data[o.list] !== null) {
						if (!$.isArray(data[o.list])) {
							isMap = true;
						}

						$.each(data[o.list], function(j, val) {
							var option = {};
							if (modus === 'radio' || modus === 'checkbox') {
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

							if (modus === 'select') {
								element = $('<option value="' + option.value + '">' + option.text + '</option>');
								if (option.selected) {
									element.prop("selected", true);
								}
								element.appendTo(c);
							}
							else {
								idv = ++i;

								// This way is needed to avoid Bug in IE6/IE7
								if (modus === 'radio') {
									element = $('<input name="' + option.name + '" type="radio" id="' + option.name + (idv) + '" value="' + option.value + '"></input>');
								}
								else if (modus === 'checkbox') {
									element = $('<input name="' + option.name + '" type="checkbox" id="' + option.name + (idv) + '" value="' + option.value + '"></input>');
								}

								if (option.selected) {
									element.prop("checked", true);
								}

								c.append(element);
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
		};
	},

	/** publish complete topics */
	pubCom : function(cid, always, ctopics, targets, indi, o) {
		var self = this,
			ui = $.struts2_jquery_ui,
			c = $(cid);
		return function(request, status) {
			var orginal = {};
			orginal.request = request;
			orginal.status = status;

			self.hideIndicator(indi);

			self.publishTopic(c, ctopics, orginal);
			self.publishTopic(c, always, orginal);

			if (!targets) {
				targets = o.id;
			}
			if (targets) {
				$.each(targets.split(','), function(i, target) {
					var effect_elem = $(self.escId(target));
					effect_elem.publish("_sj_div_effect_" + target + o.id, o);
				});
			}
			if (ui && o.resizable) {
				ui.resizable(c, o);
			}
		};
	},

	/** publish error topics */
	pubErr : function(cid, always, etopics, etext, modus) {
		var self = this,
			c = $(cid);
		if (etopics || etext) {
			return function(request, status, error) {
				var orginal = {};
				orginal.request = request;
				orginal.status = status;
				orginal.error = error;

				if (modus === 'html' || modus === 'value') {
					if (etext && etext !== "false") {
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
		var self = this, $el, tag;

		if (el) {
			$el = $(el);
			el = $el[0];

			tag = el.tagName.toLowerCase();
			o.tagname = tag;

			// extension point to allow custom pre-binding processing
			if (typeof (self.preBind) !== "function" || self.preBind($el)) {

				if (!o.jqueryaction) {
					o.jqueryaction = tag;
				}

				self.log('bind ' + o.jqueryaction + ' on ' + o.id);
				self[o.jqueryaction]($el, o);

				// extension point to allow custom post-binding processing
				if (self.postBind && (typeof (self.postBind) === "function")) { return self.postBind(el); }
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

	/** handle ajax history */
	history : function($elem, topic, target) {
		var self = this,
			params = {};
		params.target = target;
		params.topic = topic;
		$elem.bind('click', params, function(event) {
			self.historyelements[event.data.target] = event.data.topic;
			self.lasttopic = topic;
			$.bbq.pushState(self.historyelements);
			return false;
		});

		$(window).bind('hashchange', params, function(e) {
			var topic = e.getState(e.data.target) || '';
			$.each(e.fragment.split('&'), function(i, f) {
				var fragment = f.split('='); 
				if(self.historyelements[fragment[0]] !== fragment[1] && fragment[1] !== self.lasttopic ) {
					self.lasttopic = topic;
					$.publish(fragment[1], e.data.options);
				}
			});
		});
	},

	/** Handles remote and effect actions */
	action : function($elem, o, loadHandler, type) {
		var self = this,
			actionTopic = '_sj_action_' + o.id,
			href = o.href,
			effect = {};
			
		o.actionTopic = actionTopic;

		if (href === null || href === "") {
			href = "#";
			o.href = href;
		}

		effect.effect = o.effect;
		effect.effectoptions = o.effectoptions;
		effect.effectmode = o.effectmode;
		effect.oneffect = o.oneffect;
		effect.effectduration = o.effectduration;

		// Set dummy target when datatype is json
		if(o.datatype && !o.targets) {
			if(o.datatype === "json") {
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

				self.subscribeTopics(tarelem, actionTopic + target, loadHandler, o);
				self.subscribeTopics(tarelem, "_sj_div_effect_" + target + o.id, self.handler.effect, effect);

				if (self.ajaxhistory) {
					self.history($elem, actionTopic + target, target);
				}
			});
		}
		else { // if no targets, then the action can still execute ajax request and will handle itself (no loading result into container

			effect.targets = o.id;
			self.subscribeTopics($(self.escId(o.id)), "_sj_div_effect_" + o.id + o.id, self.handler.effect, effect);

			// bind event topic listeners
			if (o.onbef || o.oncom || o.onsuc || o.onerr) {
				self.subscribeTopics($elem, actionTopic, loadHandler, o);
			}
		}

		if (type === "a") {
			$elem.click( function() {
				if(o.targets) {
					$.each(o.targets.split(','), function(i, target) {
						$elem.publish(actionTopic + target);
					});
				}
				if(o.preventAction) {
					return false;
				}
			});
		}
	},

	/** Handle all Container Elements Divs, Textarea, Textfield */
	container : function($elem, o) {
		var self = this,
			divTopic = '_s2j_div_load_' + o.id,
			divEffectTopic = '_s2j_div_effect_' + o.id,
			ui = $.struts2_jquery_ui,
			effect = {},
			bindel = $elem,
			eventsStr = 'click';
		
		self.log('container : ' + o.id);
		self.action($elem, o, self.handler.load, 'div');

		// load div using ajax only when href is specified or form is defined
		if ((o.formids && !o.type) || (o.href && o.href !== '#')) {
			if (o.href !== '#') {
				self.subscribeTopics($elem, o.reloadtopics, self.handler.load, o);
				self.subscribeTopics($elem, o.listentopics, self.handler.load, o);
				// publishing not triggering to prevent event propagation issues
				self.subscribeTopics($elem, divTopic, self.handler.load, o);

				if (o.bindon) {
					if (o.events) {
						$.each(o.events.split(','), function(i, event) {
							$('#' + o.bindon).publishOnEvent(event, divTopic, o);
						});
					}
					else {
						$('#' + o.bindon).publishOnEvent('click', divTopic, o);
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
				effect.targets = o.id;
				effect.effect = o.effect;
				effect.effectoptions = o.effectoptions;
				effect.effectduration = o.effectduration;
				self.subscribeTopics($elem, divEffectTopic + o.id + o.id, self.handler.effect, effect);
			}

			if (o.events || o.bindon) {

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
			
			if (ui && o.resizable) {
				ui.resizable($elem, o);
			}
		}
		
		if (ui && o.draggable) {
			ui.draggable($elem, o);
		}
		if (ui && o.droppable) {
			ui.droppable($elem, o);
		}
		if (ui && o.selectable) {
			ui.selectable($elem, o);
		}
		if (ui && o.sortable) {
			ui.sortable($elem, o);
		}
		
		if (o.onblurtopics) {
			$.each(o.onblurtopics.split(','), function(i, topic) {
				$elem.blur( function() {
					self.publishTopic($elem, topic, {});
				});
			});
		}

		if (o.onfocustopics) {
			$.each(o.onfocustopics.split(','), function(i, topic) {
				$elem.focus( function() {
					self.publishTopic($elem, topic, {});
				});
			});
		}

		if (o.oncha) {
			if (o.type) {
				if (o.type === 'text') {
					$elem.keyup( function() {
						self.publishTopic($elem, o.oncha, {});
					});
				}
				else if (o.type === 'select') {
					$elem.change( function() {
						self.publishTopic($elem, o.oncha, {});
					});
					$elem.select( function() {
						self.publishTopic($elem, o.onselecttopics, {});
					});
				}
			}
		}
	},

	/** Handle the Anchor Element */
	anchor : function($elem, o) {
		var self = this,
			formTopic = '_s2j_form_topic_' + o.id;
		self.log('anchor : ' + o.id);

		if (o.onclick) {
			$.each(o.onclick.split(','), function(i, topic) {
				$elem.publishOnEvent('click', topic, o);
			});
		}

		if (o.opendialog) {
			$.struts2_jquery_ui.opendialog($elem, o);
		}
		if (o.button) {
			$.struts2_jquery_ui.jquerybutton($elem, o);
		}

		if ((!o.href || o.href==='#') && o.formids) {
			self.formsubmit($elem, o, formTopic);
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
		var self = this,
			selectTopic = '_s2j_topic_load_' + o.id;
		self.log('select : ' + o.id);
		if (!self.loadAtOnce) {
			self.require("js/plugins/jquery.form" + self.minSuffix + ".js");
		}

		if (o.href && o.href !== '#') {

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
			if (!self.loadAtOnce) {
				self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.position" + self.minSuffix + ".js", "js/base/jquery.ui.button" + self.minSuffix + ".js", "js/base/jquery.ui.autocomplete" + self.minSuffix + ".js" ]);
			}
			self.require([ "js/plugins/jquery.combobox" + self.minSuffix + ".js" ]);
			$elem.combobox(o);
		}
	},

	/** Handle the Submit Button */
	button : function($elem, o) {
		var self = this,
			formTopic = '_s2j_form_topic_' + o.id,
			cform,cf,formid,randomid;

		o.preventAction = true;
		
		if (o.opendialog) {
			$.struts2_jquery_ui.opendialog($elem, o);
		}
		if (o.button) {
			$.struts2_jquery_ui.jquerybutton($elem, o);
		}

		if ((!o.href || o.href === "#") && o.formids !== undefined) {
			self.formsubmit($elem, o, formTopic);
		}
		else {
			if(o.href && o.href !== "#"){
				self.action($elem, o, self.handler.load, 'a');
				if(o.targets) {
					$.each(o.targets.split(','), function(i, t) {
						self.subscribeTopics($(self.escId(t)), o.reloadtopics, self.handler.load, o);
						self.subscribeTopics($(self.escId(t)), o.listentopics, self.handler.load, o);
					});
				}
			}
			else {
				cform = $elem.parents('form:first')[0];
				if (cform !== undefined) {
					cf = $(cform);
					formid = cf.attr("id");
					if (formid !== undefined) {
						o.formids = formid;
					}
					else {
						randomid = 's2jqform' + Math.floor(Math.random() * 10000);
						cf.attr('id', randomid);
						o.formids = randomid;
					}
					self.formsubmit($elem, o, formTopic);
				}
				else {
					self.action($elem, o, self.handler.load, 'a');
					if(o.targets) {
						$.each(o.targets.split(','), function(i, t) {
							self.subscribeTopics($(self.escId(t)), o.reloadtopics, self.handler.load, o);
							self.subscribeTopics($(self.escId(t)), o.listentopics, self.handler.load, o);
						});
					}
				}
			}
		}
		if (o.onclick) {
			$.each(o.onclick.split(','), function(i, topic) {
				$elem.publishOnEvent('click', topic);
			});
		}
		$elem.removeAttr('name');
	},

	/** Handle all AJAX Forms submitted from Anchor or Submit Button */
	formsubmit : function($elem, o, topic) {
		var self = this,
			params = {};
		o.actionTopic = topic;
		self.log('formsubmit : ' + o.id);
		if (!self.loadAtOnce) {
			self.require("js/plugins/jquery.form" + self.minSuffix + ".js");
		}

		if (o.targets) {
			self.subscribeTopics($elem, o.reloadtopics, self.handler.form, o);
			self.subscribeTopics($elem, o.listentopics, self.handler.form, o);

			self.subscribeTopics($elem, topic, self.handler.form, o);
			$.each(o.targets.split(','), function(i, target) {
				self.subscribeTopics($(self.escId(target)), "_sj_div_effect_" + target + o.id, self.handler.effect, o);
				if (self.ajaxhistory) {
					self.history($elem, topic, target);
				}
			});
			$.each(o.formids.split(','), function(i, f) {
				$(self.escId(f)).bind("submit", function(e) { 
					e.preventDefault(); 
				});
			});
			$elem.click( function() {
				$elem.publish(topic);
				return false;
			});
		}
		else {
			// Submit Forms without AJAX
			$elem.click( function(e) {
				var form = $(self.escId(o.formids)),
					orginal = {};
				orginal.formvalidate = true; 
				e.preventDefault(); 
				if (o.validate) {
					orginal.formvalidate = self.validateForm(form, o);
					if (o.onaftervalidation) {
						$.each(o.onaftervalidation.split(','), function(i, topic) { 
							$elem.publish(topic, $elem, orginal);
						});
					}  
				}
				
				if(orginal.formvalidate) {
					form.submit();
				}
				return false;
			});
			if(o.listentopics) {
				params.formids = o.formids;
				params.validate = o.validate;
				$elem.subscribe(o.listentopics, function(event) {
					var form = $(self.escId(event.data.formids)),
						orginal = {formvalidate : true};
					
					if (event.data.validate) {
						orginal.formvalidate = self.validateForm(form, o);
						$.each(o.onaftervalidation.split(','), function(i, topic) { 
							$elem.publish(topic, $elem, orginal);
						});
					}

					if(orginal.formvalidate) {
						form.submit();
					}
				}, params);
			}
		}
	}

	};

	/**
	 * Container logic
	 * Register handler to load a container
	 * */
	$.subscribeHandler($.struts2_jquery.handler.load, function(event, data) {

		var s2j = $.struts2_jquery,
			container = $(event.target),
			cid,
			o = {},
			isDisabled = false,
			indi, always,
			modus = 'html',
			params = {};
			
		if (data) {
			$.extend(o, data);
		}
		if (event.data) {
			$.extend(o, event.data);
		}
		s2j.lasttopic = o.actionTopic;
		indi = o.indicatorid;
		always = o.onalw;
		
		isDisabled = o.disabled === null ? isDisabled : o.disabled;
		isDisabled = container.prop('disabled');
		if (event.originalEvent) { // means that container load is being triggered by other action (link button/link click) need to see if that button/link is disabled
			isDisabled = $(event.originalEvent.currentTarget).prop("disabled");
		}

		if (isDisabled !== true) {

			// Show indicator element (if any)
			if (o) {

				s2j.showIndicator(indi);
				if (o.type) {
					if (o.type === 'text') {
						modus = 'value';
					}
					else if (o.type === 'select') {
						modus = 'select';
					}
					else if (o.type === 'checkbox') {
						modus = 'checkbox';
					}
					else if (o.type === 'radio') {
						modus = 'radio';
					}
				}

				if (modus === 'html' || modus === 'value') {
					// Set pre-loading text (if any)
					if(!o.datatype || o.datatype !== "json") {
						if (o.loadingtext && o.loadingtext !== "false") {
							if (modus === 'html') {
								container.html(o.loadingtext);
							}
							else {
								container.val(o.loadingtext);
							}
						}
						else if (s2j.defaults.loadingText !== null) {
							if (modus === 'html') {
								container.html(s2j.defaults.loadingText);
							}
							else {
								container.val(s2j.defaults.loadingText);
							}
						}
					}
				}

				params.success = s2j.pubSuc(event.target, always, o.onsuc, indi, modus, o);
				params.complete = s2j.pubCom(event.target, always, o.oncom, o.targets, indi, o);
				params.error = s2j.pubErr(event.target, always, o.onerr, o.errortext, modus);

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
						if (!s2j.loadAtOnce) {
							s2j.require("js/plugins/jquery.form" + s2j.minSuffix + ".js");
						}
						$.each(o.formids.split(','), function(i, fid) {
							var query = $(s2j.escId(fid)).formSerialize();
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
					o.options.submit = true;
					// publish all 'before' and 'always' topics
					s2j.publishTopic(container, always, o);
					s2j.publishTopic(container, o.onbef, o);

					// Execute Ajax Request
					if(o.options.submit){
						cid = container.attr('id');
						s2j.abortReq(container.attr('id'));
						s2j.currentXhr[cid] = $.ajax(params);
					}
				}
			}
		}
	});

	/**
	 * Form logic
	 * Handler to submit a form with jquery.form.js plugin
	 * */
	$.subscribeHandler($.struts2_jquery.handler.form, function(event, data) {
		var s2j = $.struts2_jquery,
			elem = $(event.target),
			o = {},
			params = {},
			indi,
			always;

		// need to also make use of original attributes registered with the container (such as onCompleteTopics)
		if (data) {
			$.extend(o, data);
		}
		if (event.data) {
			$.extend(o, event.data);
		}
		s2j.lasttopic = o.actionTopic;
		indi = o.indicatorid;
		always = o.onalw;

		if (o.href && o.href !== '#') {
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
				elem = $(s2j.escId(target));
				if (params.target === '') {
					params.target = s2j.escId(target);
				}
				else {
					params.target = params.target + ',#' + s2j.escId(target);
				}
			});
		}


		params.beforeSubmit = function(formData, form, formoptions) {

			var orginal = {};
			orginal.formData = formData;
			orginal.form = form;
			orginal.options = formoptions;
			orginal.options.submit = true;

			s2j.publishTopic(elem, always, orginal);

			if (o.onbef) {
				$.each(o.onbef.split(','), function(i, topic) {
					elem.publish(topic, elem, orginal);
				});
			}

			if (o.validate) {
				orginal.options.submit = s2j.validateForm(form, o);
				orginal.formvalidate = orginal.options.submit; 
				if (o.onaftervalidation) {
					$.each(o.onaftervalidation.split(','), function(i, topic) { 
						elem.publish(topic, elem, orginal);
					});
				}  
			}
			if (orginal.options.submit) {
				s2j.showIndicator(indi);
				if(!o.datatype || o.datatype !== "json") {
					if (o.loadingtext && o.loadingtext !== "false") {
						$.each(o.targets.split(','), function(i, target) {
							$(s2j.escId(target)).html(o.loadingtext);
						});
					}
					else if (s2j.defaults.loadingText !== null) {
						$.each(o.targets.split(','), function(i, target) {
							$(s2j.escId(target)).html(s2j.defaults.loadingText);
						});
					}
				}
			}
			return orginal.options.submit;
		};

		params.success = s2j.pubSuc(elem, always, o.onsuc, indi, 'form', o);
		params.complete = s2j.pubCom(elem, always, o.oncom, o.targets, indi, o);
		params.error = s2j.pubErr(elem, always, o.onerr, o.errortext, 'html');

		$.each(o.formids.split(','), function(i, fid) {
			s2j.log('submit form : ' + fid);
			$(s2j.escId(fid)).ajaxSubmit(params);
		});

		return false;
	});

	/**
	 * Effects
	 * Register handler for effects
	 * */
	$.subscribeHandler($.struts2_jquery.handler.effect, function(event, data) {
		var s2j = $.struts2_jquery,
			o = {},
			eo = {},
			duration = 2000,
			callback = null,
			tar = null;

		$.extend(o, event.data);
		if (o.targets && o.effect) {
			if (o.effectoptions) {
				eo = o.effectoptions;
			}
			if (o.effectduration) {
				duration = o.effectduration;
			}

			if(o.oneffect) {

				$.each(o.targets.split(','), function(i, target) {
					$.subscribe($(s2j.escId(target)), o.oneffect, o);
				});

				callback = function () {
					$.each(o.targets.split(','), function(i, target) {
						s2j.publishTopic($(s2j.escId(target)), o.oneffect, o);
					});
				};
			}

			if (!s2j.loadAtOnce) {
				s2j.require( [ "js/base/jquery.effects.core" + s2j.minSuffix + ".js", "js/base/jquery.effects." + o.effect + s2j.minSuffix + ".js" ]);
			}
			s2j.log('effect ' + o.effect + ' for ' + o.targets);
			$.each(o.targets.split(','), function(i, target) {
				tar = $(s2j.escId(target));
				if(!o.effectmode || o.effectmode === 'none' ) {
					tar.effect(o.effect, eo, duration, callback);
				}
				else if (o.effectmode === 'show') {
					tar.show(o.effect, eo, duration, callback);
				}
				else if (o.effectmode === 'hide') {
					tar.hide(o.effect, eo, duration, callback);
				}
				else if (o.effectmode === 'toggle') {
					tar.toggle(o.effect, eo, duration, callback);
				}
			});
		}
	});

})(jQuery);
