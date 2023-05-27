/**
 * @preserve
 * jquery.richtext.struts2.js
 *
 * Integration of richtext editor with struts 2
 *
 * Requires use of jquery.struts2.js
 *
 * Copyright (c) 2010 - 2016 Johannes Geppert https://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global jQuery, window, CKEDITOR, tinyMCE, tinymce */
"use strict";
(function($) {
	/**
	 * Bind a Richtext Editor to Struts2 Component
	 */
	$.struts2_jquery_richtext = {

		editors : [],
		editorsTinymce : [],
		ckeditorTimer : undefined,

		// clear orphan instances from memory
		clean : function($elem) {
			var self = this;
			if (!window.CKEDITOR) {
				return;
			}
			$.each(self.editors, function(i, editor) {
				var inst = CKEDITOR.instances[editor];
				if ($elem.length === 0 || !inst || inst.textarea !== $elem[0]) {
					self.editors.splice(i);
					delete CKEDITOR.instances[editor];
				}
			});
		},

		// Handle CKEditor
		ckeditor : function($elem, o) {
			var self = this,
				inst,
				ckeditorTopic = 's2j_ckeditor_' + o.id,
				callbackFunction;
			self.log('init ckeditor with id: ' + o.id);
			self.require("js/ckeditor/ckeditor.js");
			self.require("js/ckeditor/adapters/jquery.js");

			inst = CKEDITOR.instances[o.id];
			
			if (inst) {
				CKEDITOR.remove(inst);
			}

			self.clean($elem);

			callbackFunction = function() {
				self.editors[self.editors.length] = o.id;
				if (o.onEditorReadyTopics) {
					var data = {};
					self.publishTopic($elem, o.onEditorReadyTopics, data);
					self.publishTopic($elem, o.onalw, data);
				}
			};

			if (o.editorLocal) {
				o.language = o.editorLocal;
			} else {
				o.language = self.local;
			}
			
			o.resizable = false;
			o.resize_enabled = o.editorResizable;

			if (o.href && o.href !== '#') {

				// If Topic already subscribed, then remove it and subscribe it
				// again
				if ($elem.isSubscribed(ckeditorTopic)) {
					$elem.unsubscribe(ckeditorTopic);
				}

				// Init CKEditor after AJAX Content is loaded.
				$elem.subscribe(ckeditorTopic, function(event, data) {
					$elem.ckeditor(callbackFunction, o);
				});
				if (o.oncom && o.oncom !== '') {
					o.oncom = o.oncom + ',' + ckeditorTopic;
				} else {
					o.oncom = ckeditorTopic;
				}

				self.container($elem, o);
			} else {
				self.container($elem, o);
				$elem.ckeditor(callbackFunction, o);
			}

			inst = CKEDITOR.instances[o.id];

			if (o.onblurtopics) {
				inst.on('blur', function(e) {
					var ed = $(self.escId(e.editor.element.$.id));
					self.publishTopic(ed, o.onblurtopics, {
						editor : ed
					});
					self.publishTopic(ed, o.onalw, {
						editor : ed
					});
				});
			}

			if (o.onfocustopics) {
				inst.on('focus', function(e) {
					var ed = $(self.escId(e.editor.element.$.id));
					self.publishTopic(ed, o.onfocustopics, {
						editor : ed
					});
					self.publishTopic(ed, o.onalw, {
						editor : ed
					});
				});
			}
			if (o.oncha) {
				inst.on('change', function(e) {
					var ed = $(self.escId(e.editor.element.$.id));
					self.publishTopic(ed, o.oncha, {
						editor : ed
					});
					self.publishTopic(ed, o.onalw, {
						editor : ed
					});
				});
			}
		},

		// Handle Tinymce
		tinymceEditor : function($elem, o) {
			var self = this,
				tinymceTopic = 's2j_tinymce_' + o.id;
			self.log('init tinymce with id: ' + o.id);
			self.require("js/tinymce/jquery.tinymce.min.js");
			if (window.tinymce){
				try{
					window.tinymce.remove("#"+o.id);
				}
				catch(e){
					self.log('destroyed old tinyMCE instance for: ' + o.id);
				}
			}

			// don't use jqueryui resizable
			// use the resizing from tinymce
			o.resizable = false;
			if (o.editorResizable) {
				o.theme_advanced_resizing = true;
			}

			self.container($elem, o);
			o.script_url = o.path + 'tinymce.min.js';
			if (o.oncha) {
				o.onchange_callback = function(ed) {
					if (tinyMCE.activeEditor.isDirty()) {
						var data = {};
						data.editor = ed;
						data.content = ed.getBody().innerHTML;

						self.publishTopic($elem, o.oncha, data);
						self.publishTopic($elem, o.onalw, data);
					}
				};
			}
			if (o.onsavetopics) {
				o.save_callback = function(id, html, body) {
					var data = {};
					data.editorid = id;
					data.html = html;
					data.body = body;

					self.publishTopic($elem, o.onsavetopics, data);
					self.publishTopic($elem, o.onalw, data);
					return data.html;
				};
			}
			if (o.oneventtopics) {
				o.handle_event_callback = function(event) {
					var data = {};
					data.event = event;
					data.returnvalue = true;

					self.publishTopic($elem, o.oneventtopics, data);
					self.publishTopic($elem, o.onalw, data);
					return data.returnvalue;
				};
			}

			o.setup = function(ed) {
				ed.on('init', function(args) {
					//tinyMCE.execCommand('mceRepaint');
                    tinyMCE.execCommand("mceAddEditor", true, o.id);


					var dom = ed.dom,
						doc = ed.getDoc();

					if (o.onblurtopics) {
						ed.on('blur', function(e) {
							self.publishTopic($elem, o.onblurtopics, {
								editor : ed
							});
							self.publishTopic($elem, o.onalw, {
								editor : ed
							});
						});
					}
					if (o.onfocustopics) {
						ed.on('focus', function(e) {
							self.publishTopic($elem, o.onfocustopics, {
								editor : ed
							});
							self.publishTopic($elem, o.onalw, {
								editor : ed
							});
						});
					}
				});
				ed.on('SaveContent', function(e) {
					return false;
				});

				if (o.pasteplain) {
					ed.on('change', function(e) {
						if (e.ctrlKey
								&& (e.charCode === 118 || e.keyCode === 86)) {
							ed.execCommand("mcePasteText", true);
							ed.execCommand("mceAddUndoLevel");
							return tinymce.dom.Event.cancel(e);
						}
					});
				}
			};

			if (o.pasteplain) {
				o.paste_text_sticky = true;
				o.paste_text_use_dialog = true;
			}

			if (o.editorLocal) {
				o.language = o.editorLocal;
			} else {
				o.language = self.local;
			}

			if (o.href && o.href !== '#') {

				// If Topic already subscribed, then remove it and subscribe it
				// again
				if ($elem.isSubscribed(tinymceTopic)) {
					$elem.unsubscribe(tinymceTopic);
				}

				// Init Tinymce after AJAX Content is loaded.
				$elem.subscribe(tinymceTopic, function(event, data) {
					$elem.tinymce(o);
				});

				o.oncom = tinymceTopic;

				self.container($elem, o);
			} else {
				self.container($elem, o);
				$elem.tinymce(o);
			}
		}
	};

	// Extend it from orginal plugin
	$.extend(true, $.struts2_jquery_richtext, $.struts2_jquery);
	$.struts2_jquery_richtext.debugPrefix = "[struts2_jquery_richtext] ";

})(jQuery);