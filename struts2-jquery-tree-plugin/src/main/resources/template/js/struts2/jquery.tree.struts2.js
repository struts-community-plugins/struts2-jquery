/**
 * @preserve
 * jquery.tree.struts2.js
 *
 * Integration of trees with struts 2
 *
 * Requires use of jquery.struts2.js
 *
 * Copyright (c) 2010 Johannes Geppert https://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global jQuery, window,  */
"use strict";
(function ($) {

	/**
	 * Bind a Tree to Struts2 Component
	 */
	$.struts2_jquery_tree = {
			
        handler : {
            show_checkboxes:'_s2j_show_checkboxes',
            hide_checkboxes:'_s2j_hide_checkboxes',
            check_checkboxes: '_s2j_check_checkboxes',
            uncheck_checkboxes: '_s2j_uncheck_checkboxes',
            toggle_checkboxes:'_s2j_toggle_all',
            search:'_s2j_tree_search',
            clear_search:'_s2j_tree_clear_search'
        },

		// Render a Tree
		tree : function ($elem, o) {
			var self = this, path = null;
			if (!self.loadAtOnce) {
				self.require("js/base/jquery.cookie" + self.minSuffix + ".js");
			}
			if (!$.scriptPath) {
				path = '';
			} else { 
				path = $.scriptPath;
			}
			self.require("js/jstree/jquery.jstree" + self.minSuffix + ".js",
                function() {
                    $.jstree.defaults.core.themes.url = true;
                    $.jstree.defaults.core.themes.dir = path + "js/jstree/themes";
                });
			o.plugins = $.jstree.defaults.plugins != null ? $.jstree.defaults.plugins.slice() : [];
            o.core = {};
			if (o.treetheme) {
				o.core.themes = {};
				o.core.themes.name = o.treetheme;			
                o.core.themes.dots = o.dots;
                o.core.themes.icons = o.icons;
                if (o.treethemeVariant){
                	o.core.themes.variant = o.treethemeVariant;
                }
                if (o.treethemeResponsive){
                	o.core.themes.responsive = o.treethemeResponsive;
                }
			}	else {
				o.plugins.push("themeroller"); 
			}
			if (o.contextmenu) {
                o.core.check_callback = true;
				o.plugins.push("contextmenu");
			}
			if (o.types) {
				o.plugins.push("types");
			}
			if (o.checkbox) {
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

                $elem.on('changed.jstree', function (e, data) {
                    $(self.escId(o.id+'_hidden')).val( $elem.jstree("get_checked", false) );
                });
                $(self.escId(o.id+'_hidden')).val( $elem.jstree("get_checked", false) );
			}
			if (o.searchTopic && o.searchElementId){				
				o.search = {};
				o.plugins.push('search');
				self.subscribeTopics($elem, o.searchTopic, self.handler.search, o);
				if (o.searchClearTopic){
					self.subscribeTopics($elem, o.searchClearTopic, self.handler.clear_search, o);
				}
			}	
			if (o.pluginsconf){
				//We permit overriding other plugins conf. Possible to modify this behaviour here
				$.each(o.pluginsconf,function(plugin,conf){
					if (o.plugins.indexOf(plugin) === -1){
						o.plugins.push(plugin);
					}
					o[plugin] = conf || {};
				});
			}
			if(o.toogleAllTopics) {
				self.subscribeTopics($elem, o.toogleAllTopics, self.handler.toggle_checkboxes, o);
			}
			if(o.checkShowTopics) {
				self.subscribeTopics($elem, o.checkShowTopics, self.handler.show_checkboxes, o);
			}
			if(o.checkHideTopics) {
				self.subscribeTopics($elem, o.checkHideTopics, self.handler.hide_checkboxes, o);
			}
            if(o.checkAllTopics) {
                self.subscribeTopics($elem, o.checkAllTopics, self.handler.check_checkboxes, o);
            }
            if(o.uncheckAllTopics) {
                self.subscribeTopics($elem, o.uncheckAllTopics, self.handler.uncheck_checkboxes, o);
            }
            

            if (o.url){
				o.core.data = {};
				o.core.data.url = o.url;
				o.core.data.data = function (n) {
					return { id : n.id === '#' ? '' : n.id };
				};
				if (o.onsuc) {
					o.core.data.success  =  function(data, status, request) {
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
					o.core.data.complete  =  function(request, status) {
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
					o.core.data.error  =  function(request, status, error) {
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
			}
            
			
			$elem.on('select_node.jstree', function (event, data){
                var orginal = {};
                orginal.data = data;
                orginal.event = event;
                if(o.onclick) {
                    self.publishTopic($elem, o.onclick, orginal);
                }
		        if(data.node.a_attr.href  && data.node.a_attr.href !== 'javascript:void(0)' && data.node.a_attr.href !== '#'){
                        // Handle Normal Requests
                        window.open(data.node.a_attr.href,'_blank');
                } else {
                    var aId = data.node.a_attr.id,
                        link = $(self.escId(aId)),
                        targets = link.data("targets");
                    if(targets === undefined){
                        targets = o.nodeTargets;
                    }
                    if(targets) {
                        $.each(targets.split(','), function (i, target) {
							if($(self.escId(target)).isSubscribed("_sj_action_" + aId + target)) {
								link.publish("_sj_action_" + aId + target);
							} else {
								var url = o.nodeHref;
								if(o.nodeHrefParamName) {
									url = self.addParam(url, o.nodeHrefParamName+'='+aId);
								}
								$(self.escId(target)).load(url);
							}
                            return false;
                        });
                    }
               }
		    });
			if (o.onSearchCompleteTopics){
				$elem.on('search.jstree', function (event, data){
					 var orginal = {'data':data, 'event':event};	               
		              self.publishTopic($elem, o.onSearchCompleteTopics, orginal);	                
				});
			}
			if (o.onSearchClearTopics){
				$elem.on('clear_search.jstree', function (event, data){
					 var orginal = {'data':data, 'event':event};	               
		              self.publishTopic($elem, o.onSearchClearTopics, orginal);	                
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
	 * handler to toggle checkboxes for all tree nodes
	 */
	$.subscribeHandler($.struts2_jquery_tree.handler.toggle_checkboxes, function(event, data) {
		$(this).jstree("toggle_checkboxes");
	});

    /**
     * handler to check all checkboxes for all tree nodes
     */
    $.subscribeHandler($.struts2_jquery_tree.handler.check_checkboxes, function(event, data) {
        $(this).jstree("check_all");
    });

    /**
     * handler to uncheck all checkboxes for all tree nodes
     */
    $.subscribeHandler($.struts2_jquery_tree.handler.uncheck_checkboxes, function(event, data) {
        $(this).jstree("uncheck_all");
    });
    
    /**
     * handler to trigger tree search
     */
    $.subscribeHandler($.struts2_jquery_tree.handler.search, function(event, data) {
       $(this).jstree("search",$($.struts2_jquery.escId(event.data.searchElementId)).val());
    });
    
    /**
     * handler to trigger tree clear search
     */
    $.subscribeHandler($.struts2_jquery_tree.handler.clear_search, function(event, data) {
       $(this).jstree("clear_search");
    });

	// Extend it from orginal plugin
	$.extend(true, $.struts2_jquery_tree, $.struts2_jquery);
	$.struts2_jquery_tree.debugPrefix = "[struts2_jquery_tree] ";

})(jQuery);
