/*!
 * jquery.tree.struts2.js
 *
 * Integration of trees with struts 2
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

/*global jQuery, window,  */
(function($) {

	/**
	 * Bind a Tree to Struts2 Component
	 */
	$.struts2_jquery_tree = {

		debugPrefix : '[struts2_jquery_tree] ',

		// Render a Tree
		tree : function($elem, o) {
			var self = this;
			if (!self.loadAtOnce) {
				self.require("js/base/jquery.cookie" + self.minSuffix + ".js");
			}
			self.require("js/jstree/jquery.hotkeys" + self.minSuffix + ".js");
			self.require("js/jstree/jquery.jstree" + self.minSuffix + ".js");
			o.plugins = ["ui"];
			if(o.treetheme) {
				o.plugins.push("themes"); 
				o.themes = {};
				o.themes.theme = o.treetheme;
				var path = null;
				if (!$.scriptPath) {
					path = '';
				}
				else {
					path = $.scriptPath;
				}

				o.themes.url = path + "js/jstree/themes/"+o.treetheme+"/style.css"
			}
			else {
				o.plugins.push("themeroller"); 
			}
			if(o.contextmenu) {
				o.plugins.push("crrm"); 
				o.plugins.push("contextmenu"); 
			}
			
			if(o.url){
				o.json_data = {};
				o.json_data.ajax = {};
				o.json_data.ajax.url = o.url;
				o.json_data.ajax.data = function (n) { 
					return { id : n.attr ? n.attr("id") : 0 }; 
				};
				o.plugins.push("json_data");
			}
			else {
				o.plugins.push("html_data");
			}
			
			if(o.onclick) {
				$elem.bind('select_node.jstree', function(event, data){
					var orginal = {};
					orginal.data = data;
					orginal.event = event;
					self.publishTopic($elem, o.onclick, orginal);
		         });
		  }
			if(o.openload) {
				$elem.bind('loaded.jstree', function(event, data){
					$elem.jstree('open_all'); 
		    });
		  }
			if(o.openrefresh) {
				$elem.bind('refresh.jstree', function(event, data){
					$elem.jstree('open_all'); 
		    });
		  }

			$elem.jstree(o);
		},
		treeitem : function($elem, o) {
			var self = this;
			self.anchor($elem, o);
		}
	};

	// Extend it from orginal plugin
	$.extend($.struts2_jquery_tree, $.struts2_jquery);

})(jQuery);
