/*
 * extendplugin.js
 *
 * Requires use of  jquery.struts2.js
 *
 * Copyright (c) 2010 Johannes Geppert https://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global $, jQuery  */

( function($) {
	$.mys2jextend = {
			myrichtextextend : function($elem, options) {
				this.log('jwysiwyg for : '+options.id);
				this.requireCss("jquery.wysiwyg.css", "js/jwysiwyg/");
				this.requireCss("jquery.wysiwyg.modal.css", "js/jwysiwyg/");
				this.require("jquery.wysiwyg.js", null, "js/jwysiwyg/");
				if (!this.loadAtOnce) {
					this.require(
						[
						 "js/base/widget"+$.struts2_jquery.minSuffix+".js",
						 "js/base/mouse"+$.struts2_jquery.minSuffix+".js",
						 "js/base/position"+$.struts2_jquery.minSuffix+".js",
						 "js/base/draggable"+$.struts2_jquery.minSuffix+".js",
						 "js/base/resizable"+$.struts2_jquery.minSuffix+".js",
						 "js/base/button"+$.struts2_jquery.minSuffix+".js",
						 "js/base/dialog"+$.struts2_jquery.minSuffix+".js"
						 ]);
				}
				$elem.wysiwyg(options.wysiwygoptions);
			}
	};

	$.extend($.mys2jextend, $.struts2_jquery);

})(jQuery);