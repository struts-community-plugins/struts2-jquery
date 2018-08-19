/**
 * @preserve jquery.datatables.struts2.js
 * 
 * Integration of DataTables with struts 2
 * 
 * Requires use of jquery.struts2.js
 * 
 * Copyright (c) 2010 - 2015 Johannes Geppert http://www.jgeppert.com
 * 
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 * 
 */

/* global jQuery, window */
/* jslint evil: true */
"use strict";
(function($) {
	/**
	 * Bind DataTables to Struts2 Component
	 */
	$.struts2_jquery_datatables = {
			handler : {
				clear_datatables:'_s2j_clear_datatables',
				reload_datatables:'_s2j_ajax_reload_datatables',
				redraw_datatables:'_s2j_redraw_datatables',
				page_datatables: '_s2j_page_datatables',
				page_length_datatables: '_s2j_page_length_datatables',
				order_datatables:'_s2j_order_datatables',
	            search_datatables:'_s2j_search_datatables',
	            clear_state_datatables:'_s2j_clear_state_datatables',
	            save_state_datatables:'_s2j_save_state_datatables'
	        },
		//Function used to serialize serverSide Processing request params	
		serializeServerSideParamsWithOGNLPath : function(data){
			var params = {draw:data.draw,length:data.length,start:data.start};
			if (data.columns){
				jQuery.each(data.columns, function(i,elt){
					params['columns['+i+'].data'] = elt.data;
					params['columns['+i+'].name'] = elt.name;
					params['columns['+i+'].orderable'] = elt.orderable;
					params['columns['+i+'].searchable'] = elt.searchable;
					if (elt.search){
						params['columns['+i+'].search.regex'] = elt.search.regex;
						params['columns['+i+'].search.value'] = elt.search.value;
					}
				});
			}
			if (data.order){
				jQuery.each(data.order, function(i,elt){
					params['order['+i+'].column'] = elt.column;
					params['order['+i+'].dir'] = elt.dir;
				});
			}
			if (data.search){
				params['search.regex'] = data.search.regex;
				params['search.value'] = data.search.value;
			}
			return params;
		},

		parseDatatablesParams : function($elem, o, params) {
			if (!$elem.data('_s2jdt_init')) {
				$elem.data('_s2jdt_init', true);
				var self = this;

				if (o.autoFill) {
					self.require("js/plugins/dataTables.autoFill"
							+ self.minSuffix + ".js");
					if (o.theme !== "default") {
						self.require("themes/" + o.theme + "/js/autoFill."
								+ o.theme + self.minSuffix + ".js");
					}
					self.requireCss("themes/" + o.theme + "/css/autoFill."
							+ o.theme + self.minSuffix + ".css");
					if (o.onAutoFillTopics) {
						$elem.on("autoFill.dt", function(event, datatable,
								cells) {
							var orginal = {};
							orginal.event = event;
							orginal.datatable = datatable;
							orginal.cells = cells;
							orginal.xhr = xhr;
							self.publishTopic($elem, o.onAutoFillTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
					if (o.onBeforeAutoFillTopics) {
						$elem.on("preAutoFill.dt", function(event, datatable,
								cells) {
							var orginal = {};
							orginal.event = event;
							orginal.datatable = datatable;
							orginal.cells = cells;
							orginal.xhr = xhr;
							self.publishTopic($elem, o.onBeforeAutoFillTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
				}
				if (o.buttons) {
					self.require("js/plugins/dataTables.buttons"
							+ self.minSuffix + ".js");
					self.require("js/plugins/buttons.html5" + self.minSuffix
							+ ".js");
					self.require("js/plugins/buttons.print" + self.minSuffix
							+ ".js");
					self.require("js/plugins/buttons.colVis" + self.minSuffix
							+ ".js");
					if (o.theme !== "default") {
						self.require("themes/" + o.theme + "/js/buttons."
								+ o.theme + self.minSuffix + ".js");
					}
					self.requireCss("themes/" + o.theme + "/css/buttons."
							+ o.theme + self.minSuffix + ".css");
					if (o.onButtonActionTopics) {
						$elem.on("button-action.dt", function(event, buttonApi,
								datatable, node, config) {
							var orginal = {};
							orginal.event = event;
							orginal.buttonApi = buttonApi;
							orginal.datatable = datatable;
							orginal.node = node;
							orginal.config = config;
							self.publishTopic($elem, o.onButtonActionTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
				}
				if (o.colReorder) {
					self.require("js/plugins/dataTables.colReorder"
							+ self.minSuffix + ".js");
					self.requireCss("themes/" + o.theme + "/css/colReorder."
							+ o.theme + self.minSuffix + ".css");
					if (o.onColumnReorderTopics) {
						$elem.on("column-reorder.dt", function(event, settings,
								details) {
							var orginal = {};
							orginal.event = event;
							orginal.settings = settings;
							orginal.details = details;
							self.publishTopic($elem, o.onColumnReorderTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
				}
				if (o.fixedColumns) {
					self.require("js/plugins/dataTables.fixedColumns"
							+ self.minSuffix + ".js");
					self.requireCss("themes/" + o.theme + "/css/fixedColumns."
							+ o.theme + self.minSuffix + ".css");
				}
				if (o.fixedHeader) {
					self.require("js/plugins/dataTables.fixedHeader"
							+ self.minSuffix + ".js");
					self.requireCss("themes/" + o.theme + "/css/fixedHeader."
							+ o.theme + self.minSuffix + ".css");
				}
				if (o.keys) {
					self.require("js/plugins/dataTables.keyTable"
							+ self.minSuffix + ".js");
					self.requireCss("themes/" + o.theme + "/css/keyTable."
							+ o.theme + self.minSuffix + ".css");
					if (o.onKeyBlurTopics) {
						$elem.on("key-blur.dt",
								function(event, datatable, cell) {
									var orginal = {};
									orginal.event = event;
									orginal.datatable = datatable;
									orginal.cell = cell;
									self.publishTopic($elem, o.onKeyBlurTopics,
											orginal);
									self.publishTopic($elem, o.onalw, orginal);
								});
					}
					if (o.onKeyFocusTopics) {
						$elem.on("key-focus.dt", function(event, datatable,
								cell, originalEvent) {
							var orginal = {};
							orginal.event = event;
							orginal.datatable = datatable;
							orginal.cell = cell;
							orginal.originalEvent = originalEvent;
							self.publishTopic($elem, o.onKeyFocusTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
					if (o.onOtherKeyTopics) {
						$elem.on("key.dt", function(event, datatable, key,
								cell, originalEvent) {
							var orginal = {};
							orginal.event = event;
							orginal.key = key;
							orginal.datatable = datatable;
							orginal.cell = cell;
							orginal.originalEvent = originalEvent;
							self.publishTopic($elem, o.onOtherKeyTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
				}
				if (o.responsive) {
					self.require("js/plugins/dataTables.responsive"
							+ self.minSuffix + ".js");
					if (o.theme !== "default") {
						self.require("themes/" + o.theme + "/js/responsive."
								+ o.theme + self.minSuffix + ".js");
					}
					self.requireCss("themes/" + o.theme + "/css/responsive."
							+ o.theme + self.minSuffix + ".css");
					if (o.onResponsiveDisplayTopics) {
						$elem.on("responsive-display.dt", function(event,
								datatable, row, showHide, update) {
							var orginal = {};
							orginal.event = event;
							orginal.datatable = datatable;
							orginal.row = row;
							orginal.showHide = showHide;
							orginal.update = update;
							self.publishTopic($elem,
									o.onResponsiveDisplayTopics, orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
					if (o.onResponsiveResizeTopics) {
						$elem.on("responsive-resize.dt", function(event,
								datatable, columns) {
							var orginal = {};
							orginal.event = event;
							orginal.datatable = datatable;
							orginal.columns;
							self.publishTopic($elem,
									o.onResponsiveResizeTopics, orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
				}
				if (o.rowReorder) {
					self.require("js/plugins/dataTables.rowReorder"
							+ self.minSuffix + ".js");
					self.requireCss("themes/" + o.theme + "/css/rowReorder."
							+ o.theme + self.minSuffix + ".css");
					if (o.onRowReorderTopics) {
						$elem.on("row-reorder.dt",
								function(event, detail, edit) {
									var orginal = {};
									orginal.event = event;
									orginal.details = detail;
									orginal.edit = edit;
									self.publishTopic($elem,
											o.onRowReorderTopics, orginal);
									self.publishTopic($elem, o.onalw, orginal);
								});
					}
					if (o.onRowReorderedTopics) {
						$elem.on("row-reordered.dt", function(event, detail,
								edit) {
							var orginal = {};
							orginal.event = event;
							orginal.details = detail;
							orginal.edit = edit;
							self.publishTopic($elem, o.onRowReorderedTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
				}
				if (o.rowGroup) {
					self.require("js/plugins/dataTables.rowGroup"
							+ self.minSuffix + ".js");
					self.requireCss("themes/" + o.theme + "/css/rowGroup."
							+ o.theme + self.minSuffix + ".css");
					if (o.onRowGroupPointChangedTopics) {
						$elem.on("rowgroup-datasrc.dt", function ( event, datatable, val ) {
							var orginal = {};
							orginal.event = event;
							orginal.datatable = datatable;
							orginal.val = val;
							self.publishTopic($elem, o.onRowReorderedTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
				}
				if (o.scroller) {
					self.require("js/plugins/dataTables.scroller"
							+ self.minSuffix + ".js");
					self.requireCss("themes/" + o.theme + "/css/scroller."
							+ o.theme + self.minSuffix + ".css");
				}
				if (o.select) {
					self.require("js/plugins/dataTables.select"
							+ self.minSuffix + ".js");
					self.requireCss("themes/" + o.theme + "/css/select."
							+ o.theme + self.minSuffix + ".css");
					if (o.onDeselectTopics) {
						$elem.on("deselect.dt", function(event, dt, type,
								indexes) {
							var orginal = {};
							orginal.event = event;
							orginal.dt = dt;
							orginal.type = type;
							orginal.indexes = indexes;
							self.publishTopic($elem, o.onDeselectTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
					if (o.onSelectTopics) {
						$elem.on("select.dt",
								function(event, dt, type, indexes) {
									var orginal = {};
									orginal.event = event;
									orginal.dt = dt;
									orginal.type = type;
									orginal.indexes = indexes;
									self.publishTopic($elem, o.onSelectTopics,
											orginal);
									self.publishTopic($elem, o.onalw, orginal);
								});
					}
					if (o.onSelectItemsTopics) {
						$elem.on("selectItems.dt", function(event, dt, items) {
							var orginal = {};
							orginal.event = event;
							orginal.dt = dt;
							orginal.items = items;
							self.publishTopic($elem, o.onSelectItemsTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
					if (o.onSelectStyleTopics) {
						$elem.on("selectStyle.dt", function(event, dt, style) {
							var orginal = {};
							orginal.event = event;
							orginal.dt = dt;
							orginal.style = style;
							self.publishTopic($elem, o.onSelectStyleTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
					if (o.onUserSelectTopics) {
						$elem.on("user-select.dt", function(event, dt, type,
								cell, originalEvent) {
							var orginal = {};
							orginal.event = event;
							orginal.dt = dt;
							orginal.type = type;
							orginal.cell = cell;
							orginal.originalEvent = originalEvent;
							self.publishTopic($elem, o.onUserSelectTopics,
									orginal);
							self.publishTopic($elem, o.onalw, orginal);
						});
					}
				}
				if (o.onbef) {
					$elem.on("preXhr.dt", function(event, settings, data) {
						var orginal = {};
						orginal.event = event;
						orginal.settings = settings;
						orginal.data = data;
						self.publishTopic($elem, ctopic, orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.ajax) {
					$elem.on("xhr.dt", function(event, settings, json, xhr) {
						if (o.oncom) {
							var orginal = {};
							orginal.event = event;
							orginal.settings = settings;
							orginal.json = json;
							orginal.xhr = xhr;
							self.publishTopic($elem, o.oncom, orginal);
							self.publishTopic($elem, o.onalw, orginal);
						}
						// if error, json is null
						if (json != null) {
							if (o.onsuc) {
								var orginal = {};
								orginal.event = event;
								orginal.json = json;
								orginal.settings = settings;
								orginal.xhr = xhr;
								self.publishTopic($elem, o.onsuc, orginal);
								self.publishTopic($elem, o.onalw, orginal);
							}
						} else {
							if (o.onerr) {
								var orginal = {};
								orginal.event = event;
								orginal.json = json;
								orginal.settings = settings;
								orginal.xhr = xhr;
								self.publishTopic($elem, onerr, orginal);
								self.publishTopic($elem, o.onalw, orginal);
								// return true to avoid triggering
								// datables'error.dt event
								return true;
							}
						}
					});

				}
				if (o.serverSide){
					//Force disabling jQuery.ajaxSettings.traditional = true for dataTables request for deep objects serialization if not using json payload
					if (typeof o.ajax === 'string'){
						var u = o.ajax.slice(0);
						params.ajax = {url:u};
					}
					if (typeof params.ajax === 'object' && (!params.ajax.contentType || params.ajax.contentType.indexOf('json') == -1)){
						if (params.ajax.data && typeof params.ajax.data =='function'){
							var origFunc = params.ajax.data;
							params.ajax.data = function(d){
								var fixedSSPrequest = self.serializeServerSideParamsWithOGNLPath(d);
								var data = origFunc(fixedSSPrequest);
								data = data ? data : fixedSSPrequest;
								if (!params.ajax.type || o.ajax.type === 'GET'){
									params.ajax.processData = false;
								}
								return  data;
							};
						}
						else{							
							params.ajax.data = function(d){
								if (!params.ajax.type || params.ajax.type === 'GET'){
									params.ajax.processData = false;
								}
								return self.serializeServerSideParamsWithOGNLPath(d);
							}; 
						}
					}	
					// if typeof ajax =='function', this function has to do itself the stuff!
				}
				if (o.onColumnSizingTopics) {
					$elem.on("column-sizing.dt", function(event, settings) {
						var orginal = {};
						orginal.event = event;
						orginal.settings = settings;
						self.publishTopic($elem, o.onColumnSizingTopics,
								orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onColumnVisibilityTopics) {
					$elem.on("column-visibility.dt", function(event, settings,
							column, state) {
						var orginal = {};
						orginal.event = event;
						orginal.column = column;
						orginal.settings = settings;
						orginal.state = state;
						self.publishTopic($elem, o.onColumnVisibilityTopics,
								orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onDestroyTopics) {
					$elem.on("destroy.dt", function(event, settings) {
						var orginal = {};
						orginal.event = event;
						orginal.settings = settings;
						self.publishTopic($elem, o.onDestroyTopics, orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onDrawTopics) {
					$elem.on("draw.dt", function(event, settings) {
						var orginal = {};
						orginal.event = event;
						orginal.settings = settings;
						self.publishTopic($elem, o.onDrawTopics, orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onProcessingErrorTopics) {
					$elem.on("error.dt", function(event, settings, techNote,
							message) {
						var orginal = {};
						orginal.event = event;
						orginal.techNote = techNote;
						orginal.settings = settings;
						orginal.message = message;
						self.publishTopic($elem, o.onProcessingErrorTopics,
								orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onInitCompleteTopics) {					
					$elem.on("init.dt", function(event, settings, json) {
						var orginal = {};
						orginal.event = event;
						orginal.json = json;
						orginal.settings = settings;
						self.publishTopic($elem, o.onInitCompleteTopics,
								orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onPageLengthChangeTopics) {
					$elem.on("length.dt", function(event, settings, len) {
						var orginal = {};
						orginal.event = event;
						orginal.len = len;
						orginal.settings = settings;
						self.publishTopic($elem, o.onPageLengthChangeTopics,
								orginal);
						self.publishTopic($elem, o.onalw, orginal);

					});
				}
				if (o.onOrderTopics) {
					$elem.on("order.dt", function(event, settings) {
						var orginal = {};
						orginal.event = event;
						orginal.settings = settings;
						self.publishTopic($elem, o.onOrderTopics, orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onPageChangeTopics) {
					$elem.on("page.dt",
							function(event, settings, json, xhr) {
								var orginal = {};
								orginal.event = event;
								orginal.settings = settings;
								self.publishTopic($elem, o.onPageChangeTopics,
										orginal);
								self.publishTopic($elem, o.onalw, orginal);
							});
				}
				if (o.onInitStartTopics) {
					$elem.on("preInit.dt", function(event, settings) {
						var orginal = {};
						orginal.event = event;
						orginal.settings = settings;
						self.publishTopic($elem, o.onInitStartTopics, orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onProcessingTopics) {
					$elem.on("processing.dt",
							function(event, settings, processing) {
								var orginal = {};
								orginal.event = event;
								orginal.processing
								orginal.settings = settings;
								self.publishTopic($elem, o.onProcessingTopics,
										orginal);
								self.publishTopic($elem, o.onalw, orginal);
							});
				}
				if (o.onSearchTopics) {
					$elem.on("search.dt", function(event, settings, json, xhr) {
						var orginal = {};
						orginal.event = event;
						orginal.settings = settings;
						self.publishTopic($elem, o.onSearchTopics, orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onStateLoadedTopics) {
					$elem.on("stateLoaded.dt", function(event, settings, json) {
						var orginal = {};
						orginal.event = event;
						orginal.json = json;
						orginal.settings = settings;
						self.publishTopic($elem, o.onStateLoadedTopics,
										orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onStateLoadingTopics) {
					$elem.on("stateLoadParams.dt", function(event, settings,
							json) {
						var orginal = {};
						orginal.event = event;
						orginal.json = json;
						orginal.settings = settings;
						self.publishTopic($elem, o.onStateLoadingTopics,
								orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
				if (o.onStateSavingTopics) {
					$elem.on("stateSaveParams.dt", function(event, settings,
							data) {
						var orginal = {};
						orginal.event = event;
						orginal.data = data;
						orginal.settings = settings;
						self.publishTopic($elem, o.onStateSavingTopics,
										orginal);
						self.publishTopic($elem, o.onalw, orginal);
					});
				}
			}
			return params;
		},
		datatables : function($elem, o) {
			var self = this, path = null, params = {};
			self.log('datatables for : ' + o.id);
			if (!$.scriptPath) {
				path = '';
			} else {
				path = $.scriptPath;
			}
			if (self.datatablesLocal !== 'en') {
				params.language = {
					url : path + "i18n/datatables.locale-"
							+ self.datatablesLocal + ".json"
				};
			}
			
			self.requireCss("themes/" + o.theme + "/css/dataTables." + o.theme
					+ self.minSuffix + ".css");
			if (o.theme !== "default") {
				self.require("themes/" + o.theme + "/js/dataTables." + o.theme
						+ self.minSuffix + ".js");
			}
			$.extend(params, o);
			$elem.data('_s2jdt_init', false);
			params = self.parseDatatablesParams($elem, o, params);			
			if(o.clearTableTopics) {
				self.subscribeTopics($elem, o.clearTableTopics, self.clear_datatables, o);
			}
			if(o.ajax && o.ajaxReloadTopics) {
				self.subscribeTopics($elem, o.ajaxReloadTopics, self.handler.reload_datatables, o);
			}
			if(o.redrawTopics) {
				self.subscribeTopics($elem, o.redrawTopics, self.handler.redraw_datatables, o);
			}
			if(o.orderTopics) {
				self.subscribeTopics($elem, o.orderTopics, self.handler.order_datatables, o);
			}
			if(o.pageTopics) {
				self.subscribeTopics($elem, o.pageTopics, self.handler.page_datatables, o);
			}
			if(o.pageLengthTopics) {
				self.subscribeTopics($elem, o.pageLengthTopics, self.handler.page_length_datatables, o);
			}
			if(o.searchTopics) {
				self.subscribeTopics($elem, o.searchTopics, self.handler.search_datatables, o);
			}
			if(o.stateClearTopics) {
				self.subscribeTopics($elem, o.stateClearTopics, self.handler.clear_state_datatables, o);
			}
			if(o.stateSaveTopics) {
				self.subscribeTopics($elem, o.stateSaveTopics, self.handler.save_state_datatables, o);
			}			
			$elem.DataTable(params);
		}
	};

	// Extend it from orginal plugin
	$.extend(true, $.struts2_jquery_datatables, $.struts2_jquery);
	$.struts2_jquery_datatables.debugPrefix = "[struts2_jquery_datatables] ";
	
	/**
     * handler to trigger tables clear
     */
    $.subscribeHandler($.struts2_jquery_datatables.handler.clear_datatables, function(event, data) {
       $(this).DataTable().clear();
    });
    /**
     * handler to trigger table AJAX reload
     */
    $.subscribeHandler($.struts2_jquery_datatables.handler.reload_datatables, function(event, data) {
    	$(this).DataTable().ajax.reload();
    });
    /**
     * handler to trigger table redraw
     */
    $.subscribeHandler($.struts2_jquery_datatables.handler.redraw_datatables, function(event, data) {
    	$(this).DataTable().draw();
    });
    /**
     * handler to trigger table page change
     */
    $.subscribeHandler($.struts2_jquery_datatables.handler.page_datatables, function(event, data) {
    	$(this).DataTable().page(data).draw(false);
    });
    /**
     * handler to trigger page length change
     */
    $.subscribeHandler($.struts2_jquery_datatables.handler.page_length_datatables, function(event, data) {
    	$(this).DataTable().page.len(data).draw();
    });
    /**
     * handler to trigger table ordering
     */
    $.subscribeHandler($.struts2_jquery_datatables.handler.order_datatables, function(event, data) {
    	$(this).DataTable().order(data).draw();
    });
    /**
     * handler to trigger datatables search
     */
    $.subscribeHandler($.struts2_jquery_datatables.handler.search_datatables, function(event, data) {
    	$(this).DataTable().search(data).draw();
    });
    /**
     * handler to trigger datatables clear state
     */
    $.subscribeHandler($.struts2_jquery_datatables.handler.clear_state_datatables, function(event, data) {
    	$(this).DataTable().state.clear();
    });
    /**
     * handler to trigger datatables save state
     */
    $.subscribeHandler($.struts2_jquery_datatables.handler.save_state_datatables, function(event, data) {
    	$(this).DataTable().state.save();
    });
    
	
})(jQuery);
