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
(function ($) {
	"use strict";

	/**
	 * Bind a Tree to Struts2 Component
	 */
	$.struts2_jquery_tree = {
			
			handler : {
				show_checkboxes:'_s2j_show_checkboxes',
				hide_checkboxes:'_s2j_hide_checkboxes',
				check_all:'_s2j_check_all',
				uncheck_all :'_s2j_uncheck_all'
			},

		// Render a Tree
		tree : function ($elem, o) {
			var self = this, path = null;
			if (!self.loadAtOnce) {
				self.require("js/base/jquery.cookie" + self.minSuffix + ".js");
			}
			self.require("js/jstree/jquery.hotkeys" + self.minSuffix + ".js");
			self.require("js/jstree/jquery.jstree" + self.minSuffix + ".js");
			o.plugins = [];
			if (o.treetheme) {
				o.plugins.push("themes"); 
				o.themes = {};
				o.themes.theme = o.treetheme;
				if (!$.scriptPath) {
					path = '';
				} else { 
					path = $.scriptPath;
				}
                o.themes.dots = o.dots;
                o.themes.icons = o.icons;

				o.themes.url = path + "js/jstree/themes/"+o.treetheme+"/style.css";
			}	else {
				o.plugins.push("themeroller"); 
			}
			if (o.contextmenu) {
				o.plugins.push("crrm"); 
				o.plugins.push("contextmenu");

                $elem.on('delete_node.jstree', function (event, data){
                    var orginal = {};
                    orginal.data = data;
                    orginal.event = event;
                    self.publishTopic($elem, "delete_node", orginal);
                });

                $elem.on('create_node.jstree', function (event, data){
                    var orginal = {};
                    orginal.data = data;
                    orginal.event = event;
                    self.publishTopic($elem, "create_node", orginal);
                });

                $elem.on('rename_node.jstree', function (event, data){
                    var orginal = {};
                    orginal.data = data;
                    orginal.event = event;
                    self.publishTopic($elem, "rename_node", orginal);
                });

                $elem.on('move_node.jstree', function (event, data){
                    var orginal = {};
                    orginal.data = data;
                    orginal.event = event;
                    self.publishTopic($elem, "move_node", orginal);
                });

                $elem.on('copy_node.jstree', function (event, data){
                    var orginal = {};
                    orginal.data = data;
                    orginal.event = event;
                    self.publishTopic($elem, "copy_node", orginal);
                });
			}
			if (o.types) {
				o.plugins.push("types"); 
			}
			if (o.checkbox) {
				o.plugins.push("ui"); 
				o.plugins.push("checkbox");
				o.checkbox = { override_ui : true, real_checkboxes : true, real_checkboxes_names : function (n) { return [o.name, n.attr ? n.attr("id") : 0 ] }};
				if(o.two_state) { o.checkbox.two_state = true; }
				$elem.bind('loaded.jstree', function (event, data){
					$elem.find('li').each(function(i) {
						if($(this).data('checked')==true){
							$elem.jstree("check_node", $(this) );
						}
					}); 
				}); 
			}
			
			if(o.checkAllTopics) {
				self.subscribeTopics($elem, o.checkAllTopics, self.handler.check_all, o);
			}
			if(o.uncheckAllTopics) {
				self.subscribeTopics($elem, o.uncheckAllTopics, self.handler.uncheck_all, o);
			}
			if(o.checkShowTopics) {
				self.subscribeTopics($elem, o.checkShowTopics, self.handler.show_checkboxes, o);
			}
			if(o.checkHideTopics) {
				self.subscribeTopics($elem, o.checkHideTopics, self.handler.hide_checkboxes, o);
			}

			
			if (o.url){
				o.json_data = {};
				o.json_data.ajax = {};
				o.json_data.ajax.url = o.url;
				o.json_data.ajax.data = function (n) { 
					return { id : n.attr ? n.attr("id") : 0 }; 
				};
				if (o.onsuc) {
					o.json_data.ajax.complete  =  function(data, status, request) {
						$.each(o.onsuc.split(','), function(i, stopic) {
							var orginal = {};
							orginal.data = data;
							orginal.status = status;
							orginal.request = request;
	
							self.publishTopic($elem, stopic, orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					};
				}
				if (o.oncom) {
					o.json_data.ajax.complete  =  function(request, status) {
						$.each(o.oncom.split(','), function(i, ctopic) {
							var orginal = {};
							orginal.request = request;
							orginal.status = status;
	
							self.publishTopic($elem, ctopic, orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					};
				}
				if (o.onerr) {
					o.json_data.ajax.error  =  function(request, status, error) {
						$.each(o.onerr.split(','), function(i, etopic) {
							var orginal = {};
							orginal.request = request;
							orginal.status = status;
							orginal.error = error;
	
							self.publishTopic($elem, etopic, orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					};
				}
				o.plugins.push("json_data");
			}	else {
				o.plugins.push("html_data");
			}
			
			if(o.onclick || (o.url && o.nodeHref)) {
				o.plugins.push("ui"); 
				$elem.bind('select_node.jstree', function (event, data){
					var orginal = {}, url;
					orginal.data = data;
					orginal.event = event;
					self.publishTopic($elem, o.onclick, orginal);
					if(o.url && o.nodeHref){
						url = self.addParam(o.nodeHref, o.nodeHrefParamName+"="+data.rslt.obj.attr("id"));
						if(o.nodeTargets) {
							// Handle AJAX Requests
							$.each(o.nodeTargets.split(','), function(i, target) {
								$(self.escId(target)).load(url);
							});
						}
						else {
							// Handle Normal Requests
							window.location.href = url;
						}
					}
		    });
		  }
			
			if(o.openload) {
				$elem.bind('loaded.jstree', function (event, data){
					$elem.jstree('open_all'); 
				});
			}
			if(o.openrefresh) {
				$elem.bind('refresh.jstree', function (event, data){
					$elem.jstree('open_all'); 
		    });
		  }
			
		  if (o.animation) {
			  o.plugins.push("core"); 
			  o.core = {};
			  o.core.animation = o.animation;
		  }

		  $elem.jstree(o);

		},
		treeitem : function($elem, o) {
			var self = this;
			self.anchor($elem, o);
		}
	};
	
	/**
	 * handler to show checkboxes
	 */
	$.subscribeHandler($.struts2_jquery_tree.handler.show_checkboxes, function(event, data) {
		$(this).jstree("show_checkboxes");
	});
	
	/**
	 * handler to hide checkboxes
	 */
	$.subscribeHandler($.struts2_jquery_tree.handler.hide_checkboxes, function(event, data) {
		$(this).jstree("hide_checkboxes");
	});
	
	/**
	 * handler to check all tree nodes
	 */
	$.subscribeHandler($.struts2_jquery_tree.handler.check_all, function(event, data) {
		$(this).jstree("check_all");
	});
	
	/**
	 * handler to uncheck all tree nodes
	 */
	$.subscribeHandler($.struts2_jquery_tree.handler.uncheck_all, function(event, data) {
		$(this).jstree("uncheck_all");
	});

	// Extend it from orginal plugin
	$.extend(true, $.struts2_jquery_tree, $.struts2_jquery);
	$.struts2_jquery_tree.debugPrefix = "[struts2_jquery_tree] ";

})(jQuery);
