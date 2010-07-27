/*
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

			editors : [],
			editorsTinymce : [],
			
			// clear orphan instances from memory
		  clean: function($elem){
				if(!window.CKEDITOR) { return; }
				$.each(this.editors, function(i, editor) { 
					var inst = CKEDITOR.instances[editor];
					if($elem.length === 0 || !inst || inst.textarea!=$elem[0]){
						$.struts2_jquery_richtext.editors.splice(i);
						delete CKEDITOR.instances[editor];
					}
				});
			},

			// Handle CKEditor
			ckeditor : function($elem, o) {
				this.log('ckeditor for : '+o.id);
				this.require("js/ckeditor/ckeditor.js");
				this.require("js/ckeditor/adapters/jquery.js");
				
				var inst = CKEDITOR.instances[o.id];
				if(inst) {
				   CKEDITOR.remove(inst);
				}
				
				this.clean($elem);
				
				var callbackFunction = function() {
					$.struts2_jquery_richtext.editors[$.struts2_jquery_richtext.editors.length] = o.id;
					if (o.onEditorReadyTopics) {
						var data = {};
						$.struts2_jquery.publishTopic($elem, o.onEditorReadyTopics, data);
						$.struts2_jquery.publishTopic($elem, o.onalw, data);
					}
				};
				
				if (o.editorLocal) {
					o.language = o.editorLocal;
				}
				else{
					o.language = this.local;
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
					
					this.container($elem, o);
				}
				else {
					this.container($elem, o);
					$elem.ckeditor(callbackFunction, o);
				}
				if (o.onblurtopics) {
					CKEDITOR.instances[o.id].on('blur', function() {
						$.struts2_jquery.publishTopic($elem, o.onblurtopics, {});
						$.struts2_jquery.publishTopic($elem, o.onalw, {});
		      });
				}
				
				if (o.onfocustopics) {
					CKEDITOR.instances[o.id].on('focus', function() {
						$.struts2_jquery.publishTopic($elem, o.onfocustopics, {});
						$.struts2_jquery.publishTopic($elem, o.onalw, {});
		      });
				}
			},
			
			// Handle Tinymce
			tinymce : function($elem, o) {
				this.log('tinymce for : '+o.id);
				this.require("js/tinymce/jquery.tinymce.js");
				
				//Cleanup old tinymce instances
				if ($.struts2_jquery_richtext.editorsTinymce.length > 0 && tinyMCE.get(o.id)) {
					var ins = tinyMCE.get(o.id);
					if( ins !== undefined ) {
						this.log('cleanup tinymce : '+o.id);
						//delete ins;
					}
				}
				$.struts2_jquery_richtext.editorsTinymce[$.struts2_jquery_richtext.editorsTinymce.length] = o.id;
				
				this.container($elem, o);
				o.script_url = o.path+'tiny_mce.js';
				o.resizable = false;
				
				o.setup = function(ed) {
					ed.onInit.add(function(ed) {
						tinyMCE.execCommand('mceRepaint');
					});
					ed.onSaveContent.add(function(ed, l) {
						if (o.onsavetopics) {
							var data = {};
							data.editor = ed;
							data.content = l.content;
							$.struts2_jquery.publishTopic($elem, o.onsavetopics, data);
							$.struts2_jquery.publishTopic($elem, o.onalw, data);
						}
						return false;
					});
					ed.onChange.add(function(ed, l) {
						if (o.onchangetopics) {
							var data = {};
							data.editor = ed;
							data.content = l.content;
							$.struts2_jquery.publishTopic($elem, o.oncha, data);
							$.struts2_jquery.publishTopic($elem, o.onalw, data);
						}
					});
				};
				
				if (o.editorLocal) {
					o.language = o.editorLocal;
				}
				else{
					o.language = this.local;
				}
				
				if(o.href && o.href != '#')
				{
					var tinymceTopic = 's2j_tinymce_'+o.id;
					
					// If Topic already subscribed, then remove it and subscribe it again
					if ($elem.isSubscribed(tinymceTopic)) { $elem.unsubscribe(tinymceTopic); }
					
					// Init Tinymce after AJAX Content is loaded.
					$elem.subscribe(tinymceTopic, function(event,data) {
						if(o.editorResizable) { o.theme_advanced_resizing = true; }
						$elem.tinymce(o);
						$.each(o.formids.split(','), function(i, fid) {
							$.struts2_jquery.log('bind tinymce to form : ' + fid);
							$($.struts2_jquery.escId(fid)).bind('form-pre-serialize', function(e) {
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
					
					this.container($elem, o);
				}
				else {
					this.container($elem, o);
					$elem.tinymce(o);
					$.each(o.formids.split(','), function(i, fid) {
						$.struts2_jquery.log('bind tinymce to form : ' + fid);
						$($.struts2_jquery.escId(fid)).bind('form-pre-serialize', function(e) {
					    tinyMCE.triggerSave();
						});
					});
				}
			}
	};

	// Extend it from orginal plugin
	$.extend($.struts2_jquery_richtext, $.struts2_jquery);

})(jQuery);