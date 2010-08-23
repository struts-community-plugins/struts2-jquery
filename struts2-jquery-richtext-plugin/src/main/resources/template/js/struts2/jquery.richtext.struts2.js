/*!
 * jquery.richtext.struts2.js
 *
 * Integration of richtext editor with struts 2 
 *
 * Requires use of jquery.struts2.js
 *
 * Copyright (c) 2010 Johannes Geppert http://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global jQuery, window, CKEDITOR, tinyMCE */
( function($) {
	

	/**
	 * Bind a Richtext Editor to Struts2 Component
	 */
	$.struts2_jquery_richtext = {

			debugPrefix :'[struts2_jquery_richtext] ',
			editors : [],
			editorsTinymce : [],
			
			// clear orphan instances from memory
		  clean: function($elem){
				var self = this;
				if(!window.CKEDITOR) { return; }
				$.each(self.editors, function(i, editor) { 
					var inst = CKEDITOR.instances[editor];
					if($elem.length === 0 || !inst || inst.textarea!=$elem[0]){
						$.struts2_jquery_richtext.editors.splice(i);
						delete CKEDITOR.instances[editor];
					}
				});
			},

			// Handle CKEditor
			ckeditor : function($elem, o) {
				var self = this;
				self.log('ckeditor for : '+o.id);
				self.require("js/ckeditor/ckeditor.js");
				self.require("js/ckeditor/adapters/jquery.js");
				
				var inst = CKEDITOR.instances[o.id];
				if(inst) {
				   CKEDITOR.remove(inst);
				}
				
				self.clean($elem);
				
				var callbackFunction = function() {
					self.editors[self.editors.length] = o.id;
					if (o.onEditorReadyTopics) {
						var data = {};
						self.publishTopic($elem, o.onEditorReadyTopics, data);
						self.publishTopic($elem, o.onalw, data);
					}
				};
				
				if (o.editorLocal) {
					o.language = o.editorLocal;
				}
				else{
					o.language = self.local;
				}

				if(o.href && o.href != '#')
				{
					var ckeditorTopic = 's2j_ckeditor_'+o.id;
					
					// If Topic already subscribed, then remove it and subscribe it again
					if ($elem.isSubscribed(ckeditorTopic)) { $elem.unsubscribe(ckeditorTopic); }
					
					// Init CKEditor after AJAX Content is loaded.
					$elem.subscribe(ckeditorTopic, function(event,data) {
							$elem.ckeditor(callbackFunction, o);
					});
					if(o.oncom && o.oncom != '') {
						o.oncom = o.oncom+','+ckeditorTopic;
					}
					else {
						o.oncom = ckeditorTopic;
					}
					
					self.container($elem, o);
				}
				else {
					self.container($elem, o);
					$elem.ckeditor(callbackFunction, o);
				}
				if (o.onblurtopics) {
					CKEDITOR.instances[o.id].on('blur', function() {
						self.publishTopic($elem, o.onblurtopics, {});
						self.publishTopic($elem, o.onalw, {});
		      });
				}
				
				if (o.onfocustopics) {
					CKEDITOR.instances[o.id].on('focus', function() {
						self.publishTopic($elem, o.onfocustopics, {});
						self.publishTopic($elem, o.onalw, {});
		      });
				}
			},
			
			// Handle Tinymce
			tinymce : function($elem, o) {
				var self = this;
				self.log('tinymce for : '+o.id);
				self.require("js/tinymce/jquery.tinymce.js");
				
				//Cleanup old tinymce instances
				/*
				 * this works not right with more then one instance!
				if ($.struts2_jquery_richtext.editorsTinymce.length > 0 && tinyMCE.get(o.id)) {
					var ins = tinyMCE.get(o.id);
					if( ins !== undefined ) {
						self.log('cleanup tinymce : '+o.id);
						//delete ins;
					}
				}
				self.editorsTinymce[$.struts2_jquery_richtext.editorsTinymce.length] = o.id;
				*/
				
				//don't use jqueryui resizable
				//use the resizing from tinymce
				o.resizable = false;
				if(o.editorResizable) { o.theme_advanced_resizing = true; }
				
				self.container($elem, o);
				o.script_url = o.path+'tiny_mce.js';

				
				o.setup = function(ed) {
					ed.onInit.add(function(ed) {
						tinyMCE.execCommand('mceRepaint');
					});
					ed.onSaveContent.add(function(ed, l) {
						if (o.onsavetopics) {
							var data = {};
							data.editor = ed;
							data.content = l.content;
							self.publishTopic($elem, o.onsavetopics, data);
							self.publishTopic($elem, o.onalw, data);
						}
						return false;
					});
					ed.onChange.add(function(ed, l) {
						if (o.onchangetopics) {
							var data = {};
							data.editor = ed;
							data.content = l.content;
							self.publishTopic($elem, o.oncha, data);
							self.publishTopic($elem, o.onalw, data);
						}
					});
					if (o.pasteplain) {
						alert('only paste plain');
						ed.onKeyDown.add(function(ed, e) {
					    if (e.ctrlKey && (e.charCode == 118 || e.keyCode == 86)) {
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
				}
				else{
					o.language = self.local;
				}
				
				if(o.href && o.href != '#')
				{
					var tinymceTopic = 's2j_tinymce_'+o.id;
					
					// If Topic already subscribed, then remove it and subscribe it again
					if ($elem.isSubscribed(tinymceTopic)) { $elem.unsubscribe(tinymceTopic); }
					
					// Init Tinymce after AJAX Content is loaded.
					$elem.subscribe(tinymceTopic, function(event,data) {
						$elem.tinymce(o);
						$.each(o.formids.split(','), function(i, fid) {
							self.log('bind tinymce to form : ' + fid);
							$(self.escId(fid)).bind('form-pre-serialize', function(e) {
						    tinyMCE.triggerSave();
							});
						});
					});
					if(o.oncom && o.oncom != '') {
						o.oncom = tinymceTopic;
					}
					else {
						o.oncom = tinymceTopic;
					}
					
					self.container($elem, o);
				}
				else {
					self.container($elem, o);
					$elem.tinymce(o);
					$.each(o.formids.split(','), function(i, fid) {
						self.log('bind tinymce to form : ' + fid);
						$(self.escId(fid)).bind('form-pre-serialize', function(e) {
					    tinyMCE.triggerSave();
						});
					});
				}
			}
	};

	// Extend it from orginal plugin
	$.extend($.struts2_jquery_richtext, $.struts2_jquery);

})(jQuery);