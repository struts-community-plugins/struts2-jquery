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

/*global $, jQuery, window, CKEDITOR */
( function($) {
	

	/**
	 * Bind a Richtext Editor to Struts2 Component
	 */
	$.struts2_jquery_richtext = {

			editors : [],
			
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
			ckeditor : function($elem, options) {
				this.log('ckeditor for : '+options.id);
				this.require("js/ckeditor/ckeditor.js");
				this.require("js/ckeditor/adapters/jquery.js");
				
				var inst = CKEDITOR.instances[options.id];
				if(inst) {
				   CKEDITOR.remove(inst);
				}
				
				this.clean($elem);
				
				var callbackFunction = function() {
					$.struts2_jquery_richtext.editors[$.struts2_jquery_richtext.editors.length] = options.id;
					if (options.onEditorReadyTopics) {
						var data = {};
						$.struts2_jquery.publishTopic($elem, options.onEditorReadyTopics, data);
						$.struts2_jquery.publishTopic($elem, options.options.onalwaystopics, data);
					}
				};
				
				if (options.editorLocal) {
					options.language = options.editorLocal;
				}
				else{
					options.language = this.local;
				}

				if(options.href && options.href != '#')
				{
					var ckeditorTopic = 's2j_ckeditor_'+options.id;
					
					// If Topic already subscribed, then remove it and subscribe it again
					if ($elem.isSubscribed(ckeditorTopic)) { $elem.unsubscribe(ckeditorTopic); }
					
					// Init CKEditor after AJAX Content is loaded.
					$elem.subscribe(ckeditorTopic, function(event,data) {
							$elem.ckeditor(callbackFunction, options);
					});
					if(options.oncompletetopics && options.oncompletetopics != '') {
						options.oncompletetopics = ckeditorTopic;
					}
					else {
						options.oncompletetopics = ckeditorTopic;
					}
					
					this.container($elem, options);
				}
				else {
					this.container($elem, options);
					$elem.ckeditor(callbackFunction, options);
				}
			}
	};

	// Extend it from orginal plugin
	$.extend($.struts2_jquery_richtext, $.struts2_jquery);

})(jQuery);