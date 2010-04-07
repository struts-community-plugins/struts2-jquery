	var myextend = {
			myrichtextextend : function($elem, options) {
				s2jlog('richtext for : '+options.id);
				$.requireCss("jquery.wysiwyg.css", "js/jwysiwyg/");
				$.require("jquery.wysiwyg.js", null, "js/jwysiwyg/");
				$elem.wysiwyg(options.wysiwygoptions);
				$(document).wysiwyg();
			}
	};

	$.extend(myextend, $.struts2_jquery);
