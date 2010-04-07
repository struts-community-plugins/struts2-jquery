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

	var struts2richtext = {
			ckeditor : function($elem, options) {
				s2jlog('ckeditor for : '+options.id);
				$.require("js/plugins/jquery.MetaData"+$.struts2_jquery.minSuffix+".js");
				$.require("js/plugins/jquery.CKEditor"+$.struts2_jquery.minSuffix+".js");
				$elem.ckeditor(options);
			}
	};

	$.extend(struts2richtext, $.struts2_jquery);
