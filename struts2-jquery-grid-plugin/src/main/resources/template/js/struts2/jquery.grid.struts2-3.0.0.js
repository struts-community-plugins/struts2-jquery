/*!
 * jquery.grid.struts2.js
 *
 * Integration of jqGrid with struts 2
 *
 * Requires use of jquery.struts2.js
 *
 * Copyright (c) 2011 Johannes Geppert http://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global jQuery, window  */
/*jslint evil: true */

(function($) {

	/**
	 * Bind jqGrid to Struts2 Component
	 */
	$.struts2_jquery_grid = {

		debugPrefix : '[struts2_jquery_grid] ',
		lastselectedrow : '',
		navigatorButtons : function($elem, buttons, pager) {
			var self = this;
			$.each(buttons, function(name, options) {
				if(options.title) {
					if(options.title === "seperator"){
						$elem.jqGrid('navSeparatorAdd', pager);
					}
					else if (options.topic || options.onclick){
						var bopts = {};
						if(options.title) {
							bopts.title = options.title;
						}
						if(options.position) {
							bopts.position = options.position;
						}
						if(options.caption) {
							bopts.caption = options.caption;
						}
						else {
							bopts.caption = '';
						}
						if(options.icon) {
							bopts.buttonicon = options.icon;
						}
						else{
							bopts.buttonicon = "ui-icon-gear";
						}
						
						if(options.topic) {
							bopts.onClickButton = function() { 
								var params = {};
								params.grid = $elem;
	
								self.publishTopic($elem, options.topic, params);
							};
						}
						else if (options.onclick) {
							bopts.onClickButton = options.onclick;
						}
						
						$elem.jqGrid('navButtonAdd', pager, bopts); 
					}
				}
			});
		},
		parseGridParams : function($elem, o, params) {
			var self = this;
			if (o.onselectrowtopics || (o.editurl && o.editinline === true)) {
				params.onSelectRow = function(id, status) {
					var data = {};
					data.id = id;
					data.status = status;
					data.grid = $elem;
	
					self.publishTopic($elem, o.onalw, data);
					$.struts2_jquery.publishTopic($elem, o.onselectrowtopics,
							data);
					if (o.editurl && o.editinline === true) {
						if ($.struts2_jquery_grid.lastselectedrow !== '') {
							$elem.jqGrid('restoreRow',
									$.struts2_jquery_grid.lastselectedrow);
						}
						$.struts2_jquery_grid.lastselectedrow = id;
						var oneditbefor = null;
						var onsuccess = null;
						var onerror = null;
						var onaftersave = null;
	
						if (o.oneibefore) {
							oneditbefor = function() {
								self.publishTopic($elem, o.oneibefore, data);
							};
						}
						if (o.oneisuccess) {
							onsuccess = function(response) {
								var d = {};
								d.response = response;
								self.publishTopic($elem, o.oneisuccess, d);
								if(response.status >= 400) {
									return false;
								}
								else {
									return true;
								}
							};
						}
						if (o.oneierror) {
							onerror = function(rowid, response) {
								var d = {};
								d.rowid = rowid;
								d.response = response;
								self.publishTopic($elem, o.oneierror, d);
							};
						}
						if (o.oneisave) {
							onaftersave = function(rowid, response) {
								var d = {};
								d.rowid = rowid;
								d.response = response;
								self.publishTopic($elem, o.oneisave, d);
							};
						}
	
						//$elem.jqGrid('editRow', id, true);
						$elem.jqGrid('editRow', id, true, oneditbefor,
								onsuccess, null, null, onaftersave, onerror,
								null);
					}
				};
			}
	
			if (o.oncesuccess) {
				params.afterSaveCell = function(rowid, cellname, value, iRow, iCol) {
					var d = {};
					d.rowid = rowid;
					d.cellname = cellname;
					d.value = value;
					d.iRow = iRow;
					d.iCol = iCol;
					self.publishTopic($elem, o.oncesuccess, d);
				};
			}
	
			if (o.onceerror) {
				params.errorCell = function(response, status) {
					var d = {};
					d.response = response;
					d.status = status;
					self.publishTopic($elem, o.onceerror, d);
				};
			}
	
			if (o.onselectalltopics) {
				params.onSelectAll = function(ids, status) {
					var data = {};
					data.ids = ids;
					data.status = status;
					data.grid = $elem;
	
					self.publishTopic($elem, o.onalw, data);
					self.publishTopic($elem, o.onselectalltopics, data);
				};
			}
			if (o.onbef) {
				params.loadBeforeSend = function(xhr) {
	
					var orginal = {};
					orginal.xhr = xhr;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onbef, orginal);
				};
			}
	
			if (o.onpagingtopics) {
				params.onPaging = function(pgButton) {
	
					var orginal = {};
					orginal.pgButton = pgButton;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onpagingtopics, orginal);
				};
			}
	
			if (o.onsortcoltopics) {
				params.onSortCol = function(index, iCol, sortorder) {
	
					var orginal = {};
					orginal.index = index;
					orginal.iCol = iCol;
					orginal.sortorder = sortorder;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onsortcoltopics, orginal);
				};
			}
	
			if (o.oncellselecttopics) {
				params.onCellSelect = function(rowid, iCol, cellcontent, e) {
	
					var orginal = {};
					orginal.rowid = rowid;
					orginal.iCol = iCol;
					orginal.cellcontent = cellcontent;
					orginal.e = e;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.oncellselecttopics, orginal);
				};
			}
	
			params.gridComplete = function() {

				if(!$elem.data('_s2jg_init')) {
					$elem.data('_s2jg_init', true);
					if (o.draggable && o.droppable) {
						self.log('drag and drop for grid : ' + o.id);
						if (!self.loadAtOnce) {
							self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js", "js/base/jquery.ui.droppable" + self.minSuffix + ".js" ]);
						}
						var daos = o.draggableoptions;
						var dao = window[daos];
						if (!dao) {
							dao = eval("( " + daos + " )");
						} else {
							dao = {};
						}
						dao.drap = self.pubTops($elem, o.onalw, o.draggableondragtopics);
	
						var doos = o.droppableoptions;
						var doo = window[doos];
						if (!doo) {
							doo = eval("( " + doos + " )");
						} else {
							doo = {};
						}
						doo.activate = self.pubTops($elem, o.onalw, o.droppableonactivatetopics);
						doo.deactivate = self.pubTops($elem, o.onalw, o.droppableondeactivatetopics);
						doo.start = self.pubTops($elem, o.onalw, o.droppableonstarttopics);
						doo.stop = self.pubTops($elem, o.onalw, o.droppableonstoptopics);
	
						var ddo = {};
						ddo.drag_opts = dao;
						ddo.drop_opts = doo;
						ddo.connectWith = o.connectWith;
						ddo.onstart = self.pubTops($elem, o.onalw, o.draggableonstarttopics);
						ddo.onstop = self.pubTops($elem, o.onalw, o.draggableonstoptopics);
						ddo.ondrop = self.pubTops($elem, o.onalw, o.droppableondroptopics);
						$elem.jqGrid('gridDnD', ddo);
					}
	
					
					if (o.sortableRows) {
						self.log('sortable rows for : ' + o.id);
						
						var soos = o.sortableoptions;
						var soo = window[soos];
						if (!soo) {
							soo = eval("( " + soos + " )");
						} else {
							soo = {};
						}
						soo.beforeStop = self.pubTops($elem, o.onalw, o.sortableonbeforestoptopics);
						soo.stop = self.pubTops($elem, o.onalw, o.sortableonstoptopics);
						soo.start = self.pubTops($elem, o.onalw, o.sortableonstarttopics);
						soo.sort = self.pubTops($elem, o.onalw, o.sortableonsorttopics);
						soo.activate = self.pubTops($elem, o.onalw, o.sortableonactivatetopics);
						soo.deactivate = self.pubTops($elem, o.onalw, o.sortableondeactivatetopics);
						soo.over = self.pubTops($elem, o.onalw, o.sortableonovertopics);
						soo.out = self.pubTops($elem, o.onalw, o.sortableonouttopics);
						soo.remove = self.pubTops($elem, o.onalw, o.sortableonremovetopics);
						soo.receive = self.pubTops($elem, o.onalw, o.sortableonreceivetopics);
						soo.change = self.pubTops($elem, o.onalw, o.sortableonchangetopics);
						soo.update = self.pubTops($elem, o.onalw, o.sortableonupdatetopics);
						$elem.jqGrid('sortableRows', soo);
					}
	
					if (o.navigator) {
						var navparams = {};
						navparams.add = o.navigatoradd;
						navparams.del = o.navigatordel;
						navparams.edit = o.navigatoredit;
						navparams.refresh = o.navigatorrefresh;
						navparams.search = o.navigatorsearch;
						navparams.view = o.navigatorview;
						$elem.jqGrid('navGrid', self.escId(o.pager), navparams,
								o.navigatoreditoptions, o.navigatoraddoptions,
								o.navigatordeleteoptions, o.navigatorsearchoptions,
								o.navigatorviewoptions);
						
						if(o.navigatorextrabuttons) {
							self.navigatorButtons($elem, o.navigatorextrabuttons, self.escId(o.pager));
						}
					}
					if (o.filter) {
						var fpara = {};
						if (o.filteroptions) {
							fpara = o.filteroptions;
						}
						$elem.jqGrid('filterToolbar', fpara);
					}
					
					if (o.resizable) {
						if (!self.loadAtOnce) {
							self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.resizable" + self.minSuffix + ".js" ]);
						}
						var ros = o.resizableoptions;
						var ro = window[ros];
						if (!ro) {
							ro = eval("( " + ros + " )");
						} else {
							ro = {};
						}
						ro.start = self.pubTops($elem, o.onalw,	o.resizableonstarttopics);
						ro.stop = self.pubTops($elem, o.onalw, o.resizableonstoptopics);
						ro.resize = self.pubTops($elem, o.onalw, o.resizableonresizetopics);
						$elem.jqGrid('gridResize', ro);
					}
				}
				if (o.ongridcompletetopics) {
					self.publishTopic($elem, o.onalwaystopics, {});
					self.publishTopic($elem, o.ongridcompletetopics, {});
				}
			};
	
			if (o.onfocustopics) {
				params.beforeSelectRow = function(rowid, e) {
	
					var orginal = {};
					orginal.rowid = rowid;
					orginal.e = e;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onfocustopics, orginal);
				};
			}
	
			if (o.reloadtopics) {
				$.each(o.reloadtopics.split(','), function(i, rts) {
					$elem.subscribe(rts, '_s2j_reloadgrid', o);
				});
			}
			if (!params.loadtext && self.defaults.loadingText !== null) {
				params.loadtext = self.defaults.loadingText;
			}

			params.loadComplete = self.pubCom($elem, o.onalw, o.oncom, null,
					null, o);
			params.loadError = self
					.pubErr($elem, o.onalw, o.onerr, o.errortext);

			if (o.grouping) {
				self.require("js/plugins/grid.grouping.js");
			}

			if (o.editurl) {
				self.require("js/plugins/jquery.searchFilter.js");
				self.require("js/plugins/grid.formedit.js");
				if (o.editinline) {
					self.require("js/plugins/grid.inlinedit.js");
				}
			}

			if (o.cellurl) {
				self.require("js/plugins/grid.celledit.js");
			}

			if (o.navigator) {
				self.require("js/plugins/grid.formedit.js");
			}

			if (o.navigatorsearch) {
				self.require("js/plugins/jquery.searchFilter.js");
			}
			
			if (o.subgrid) {
				self.require("js/plugins/grid.subgrid.js");
				params.subGrid = true;

				// gridview can't be true when using the subgrid feature
				params.gridview = false;
				params.subGridRowExpanded = function(subgrid_id, row_id) {
					var so = o.subgridoptions;
					var subgridtableid = subgrid_id + "_table";
					var subgrid = $(self.escId(subgrid_id));
					var subgridhtml = "<table id='" + subgridtableid + "' class='scroll'></table>";
					if ((so.pager && so.pager !== "") || so.navigator) {
						subgridhtml = subgridhtml + "<div id='" + subgrid_id+ "_pager'></div>";
						so.pager = subgrid_id + "_pager";
					}

					subgrid.html(subgridhtml);

					if (so.url) {
						var to = so.url.indexOf('?');
						if (to > 0) {
							so.url = so.url.substring(0, to);
						}
						so.url = so.url + "?id=" + row_id;
					}
					subgrid = $(self.escId(subgridtableid));
					so = self.parseGridParams(subgrid, so, so);

					subgrid.jqGrid(so);
				};
			} else {
				params.gridview = true;
			}
			
			if (o.url && o.formids) {
				var data = '';
				if (o.formids) {
					if (!self.loadAtOnce) {
						self.require("js/plugins/jquery.form" + self.minSuffix + ".js");
					}
					$.each(o.formids.split(','), function(i, fid) {
						var query = $(self.escId(fid)).formSerialize();
						if (data !== '') {
							data = data + '&' + query;
						} else {
							data = query;
						}
					});
				}
				if (o.url.lastIndexOf('?') > 0) {
					params.url = o.url + '&amp;' + data;
				} else {
					params.url = o.url + '?' + data;
				}
			}
			
			return params;
		},
		grid : function($elem, o) {
			var self = this;
			self.log('grid for : ' + o.id);
			self.require("i18n/grid.locale-" + self.gridLocal + ".js",
					function() {
						$.jgrid.no_legacy_api = true;
						$.jgrid.useJSON = true;
					});
			self.require("js/plugins/jquery.jqGrid.js");
			self.requireCss("themes/ui.jqgrid.css");
			if(o.sortable || o.sortableRows) {
				if (!self.loadAtOnce) {
					self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.sortable" + self.minSuffix + ".js" ]);
				}
			}
			var params = {};
			$.extend(params, o);

			$elem.data('_s2jg_init', false);
			
			params = self.parseGridParams($elem, o, params);

			$elem.jqGrid(params);
		}
	};

	// Extend it from orginal plugin
	$.extend($.struts2_jquery_grid, $.struts2_jquery);

	// Register handler for reloading grid
	$.subscribeHandler('_s2j_reloadgrid', function(event, data) {
		var _s2jg = $.struts2_jquery_grid;

		var o = {};
		$.extend(o, event.data);
		if (o.id) {

			if (o.url && o.formids) {
				var formdata = '';
				if (o.formids) {
					if (!_s2jg.loadAtOnce) {
						_s2jg.require("js/plugins/jquery.form" + _s2jg.minSuffix + ".js");
					}
					$.each(o.formids.split(','), function(i, fid) {
						var query = $(_s2jg.escId(fid)).formSerialize();
						if (formdata !== '') {
							formdata = formdata + '&' + query;
						} else {
							formdata = query;
						}
					});
				}
				if (o.url.lastIndexOf('?') > 0) {
					o.url = o.url + '&amp;' + formdata;
				} else {
					o.url = o.url + '?' + formdata;
				}
			}
			var grid = $(_s2jg.escId(o.id));
			grid.jqGrid('setGridParam', {
				url : o.url
			});
			_s2jg.log('reload grid ' + o.id);
			grid.trigger("reloadGrid");
		}
	});

})(jQuery);
