/*
 * jquery.richtext.struts2.js
 *
 * Integration of richtext editor with struts 2 
 *
 * Requires use of  jquery.struts2.js
 *
 * Copyright (c) 2010 Johannes Geppert http://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global $, jQuery, s2jlog  */
( function($) {
	
	/**
	 * Bind a Richtext Editor to Struts2 Component
	 */
	$.struts2_jquery_richtext = {
			
			// Handle CKEditor
			ckeditor : function($elem, options) {
				s2jlog('ckeditor for : '+options.id);
				$.require("js/plugins/jquery.MetaData"+$.struts2_jquery.minSuffix+".js");
				$.require("js/plugins/jquery.CKEditor"+$.struts2_jquery.minSuffix+".js");
				

				if(options.href && options.href != '#')
				{
					var ckeditorTopic = 's2j_ckeditor_'+options.id;
					
					// If Topic already subscribed, then remove it and subscribe it again
					if ($elem.isSubscribed(ckeditorTopic)) { $elem.unsubscribe(ckeditorTopic); }
					
					// Init CKEditor after AJAX Content is loaded.
					$elem.subscribe(ckeditorTopic, function(event,data) {
							$elem.ckeditor(options);
						});
					options.oncompletetopics = ckeditorTopic;
					this.container($elem, options);
				}
				else {
					this.container($elem, options);
					$elem.ckeditor(options);
				}
			}
	};

	$.extend($.struts2_jquery_richtext, $.struts2_jquery);

})(jQuery);