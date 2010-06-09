/*
 * jquery.grid.struts2.js
 *
 * Integration of jqGrid with struts 2 
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

/*global $, jQuery, window  */
/*jslint evil: true */

( function($) {
	
	/**
	 * Bind jqGrid to Struts2 Component
	 */
	$.struts2_jquery_grid = {

	lastselectedrow :'',

	grid : function($elem, options) {
		var self = this;
		self.log('grid for : '+options.id);
		self.require("i18n/grid.locale-"+self.gridLocal+".js", function() {
			$.jgrid.no_legacy_api = true;
			$.jgrid.useJSON = true;
		});
		if (!self.loadAtOnce) {
			self.require(
					[
					 "js/base/jquery.ui.widget"+self.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+self.minSuffix+".js",
					 "js/base/jquery.ui.position"+self.minSuffix+".js",
					 "js/base/jquery.ui.button"+self.minSuffix+".js",
					 "js/base/jquery.ui.draggable"+self.minSuffix+".js",
					 "js/base/jquery.ui.droppable"+self.minSuffix+".js",
					 "js/base/jquery.ui.sortable"+self.minSuffix+".js",
					 "js/base/jquery.ui.selectable"+self.minSuffix+".js",
					 "js/base/jquery.ui.resizable"+self.minSuffix+".js",
					 "js/base/jquery.bgiframe"+self.minSuffix+".js",
					 "js/base/jquery.effects.core"+self.minSuffix+".js",
					 "js/base/jquery.effects.scale"+self.minSuffix+".js",
					 "js/base/jquery.effects.drop"+self.minSuffix+".js",
					 "js/base/jquery.ui.dialog"+self.minSuffix+".js",
					 "js/plugins/jquery.jqGrid.js"
					 ]);
		}
		else {
			self.require("js/plugins/jquery.jqGrid.js");
		}
		self.requireCss("themes/ui.jqgrid.css");
		var params = {};
		$.extend(params, options);
		
		if(options.url && options.formids) {
			var data = '';
			if (options.formids) {
				if (!self.loadAtOnce) {
					self.require("js/plugins/jquery.form"+self.minSuffix+".js");
				}
				$.each(options.formids.split(','), function(i, fid) {
					var query = $(self.escId(fid)).formSerialize();
					if (data != '') { data = data + '&' + query; }
					else { data = query; }
				});
			}
			if (options.url.lastIndexOf('?') > 0) {
				options.url = options.url + '&amp;' + data;
			}
			else {
				options.url = options.url + '?' + data;
			}
		}
		
		if (options.onselectrowtopics || (options.editurl && options.editinline === true)) {
			params.onSelectRow = function(id, status) {
				var data = {};
				data.id = id;
				data.status = status;
				data.grid = $(self);

				self.publishTopic($elem, options.onalwaystopics, data);
				$.struts2_jquery.publishTopic($elem, options.onselectrowtopics, data);
				if (options.editurl && options.editinline === true) {
					if ($.sruts2_jquery_grid.lastselectedrow) {
						$(self).jqGrid('restoreRow', $.struts2_jquery_grid.lastselectedrow);
						$.struts2_jquery_grid.lastselectedrow = id;
					}
					$(self).jqGrid('editRow', id, true);
				}
			};
		}

		if (options.onselectalltopics) {
			params.onSelectAll = function(ids, status) {
				var data = {};
				data.ids = ids;
				data.status = status;
				data.grid = $(self);

				self.publishTopic($elem, options.onalwaystopics, data);
				self.publishTopic($elem, options.onselectalltopics, data);
			};
		}

		if(options.onbeforetopics) {
			params.loadBeforeSend = function(xhr) {
	
				var orginal = {};
				orginal.xhr = xhr;
	
				self.publishTopic($elem, options.onalwaystopics, orginal);
				self.publishTopic($elem, options.onbeforetopics, orginal);
			};
		}
		
		if(options.onpagingtopics) {
			params.onPaging = function(pgButton) {
	
				var orginal = {};
				orginal.pgButton = pgButton;
	
				self.publishTopic($elem, options.onalwaystopics, orginal);
				self.publishTopic($elem, options.onpagingtopics, orginal);
			};
		}
		
		if(options.onsortcoltopics) {
			params.onSortCol = function(index, iCol, sortorder) {
	
				var orginal = {};
				orginal.index = index;
				orginal.iCol = iCol;
				orginal.sortorder = sortorder;
	
				self.publishTopic($elem, options.onalwaystopics, orginal);
				self.publishTopic($elem, options.onsortcoltopics, orginal);
			};
		}

		if(options.oncellselecttopics) {
			params.onCellSelect = function(rowid, iCol, cellcontent, e) {
	
				var orginal = {};
				orginal.rowid = rowid;
				orginal.iCol = iCol;
				orginal.cellcontent = cellcontent;
				orginal.e = e;
	
				self.publishTopic($elem, options.onalwaystopics, orginal);
				self.publishTopic($elem, options.oncellselecttopics, orginal);
			};
		}
		
		if(options.ongridcompletetopics) {
			params.gridComplete = function() {
	
				var orginal = {};
	
				self.publishTopic($elem, options.onalwaystopics, orginal);
				self.publishTopic($elem, options.ongridcompletetopics, orginal);
			};
		}
		
		if(options.onfocustopics) {
			params.beforeSelectRow = function(rowid, e) {
	
				var orginal = {};
				orginal.rowid = rowid;
				orginal.e = e;
	
				self.publishTopic($elem, options.onalwaystopics, orginal);
				self.publishTopic($elem, options.onfocustopics, orginal);
			};
		}
		
		
		if (options.reloadtopics) {
			$.each(options.reloadtopics.split(','), function(i, rts) { 
				$elem.subscribe(rts, '_s2j_reloadgrid', options);
			});
		}

		if (!params.loadtext && self.defaults.loadingText !== null) {
			params.loadtext = self.defaults.loadingText;
		}
		
		params.loadComplete = self.pubCom($elem, options.onalwaystopics, options.oncompletetopics, null, null, options);
		params.loadError = self.pubErr($elem, options.onalwaystopics, options.onerrortopics, options.errortext);

		if (options.subgrid) {
			params.subGrid = true;

			// gridview can't be true when using the subgrid feature
			params.gridview = false;
			params.subGridRowExpanded = function(subgrid_id, row_id) {
				var subgrid_table_id = subgrid_id + "_table";
				var subgrid = $(self.escId(subgrid_id));
				var subgridhtml = "<table id='" + subgrid_table_id + "' class='scroll'></table>";
				if (options.subgridoptions.pager && options.subgridoptions.pager != "") {
					subgridhtml = subgridhtml + "<div id='" + subgrid_id + "_pager'></div>";
					options.subgridoptions.pager = subgrid_id + "_pager";
				}
				if (options.subgridoptions.navigator && options.subgridoptions.navigator != "") {
					subgridhtml = subgridhtml + "<div id='" + subgrid_id + "_navigator'></div>";
					options.subgridoptions.navigator = subgrid_id + "_navigator";
				}

				subgrid.html(subgridhtml);

				if (options.subgridoptions.url) {
					var to = options.subgridoptions.url.indexOf('?');
					if (to > 0) { options.subgridoptions.url = options.subgridoptions.url.substring(0, to); }
					options.subgridoptions.url = options.subgridoptions.url + "?id=" + row_id;
				}
				$(self.escId(subgrid_table_id)).jqGrid(options.subgridoptions);
			};
		}
		else {
			params.gridview = true;
		}
		
		$elem.jqGrid(params);
		

		if (options.resizable) {
			var ros = options.resizableoptions;
			var ro = window[ros];
			if (!ro) {
				ro = eval("( " + ros + " )");
			}
			else {
				ro = {};
			}
			ro.start = self.pubTops($elem, options.onalwaystopics, options.resizableonstarttopics);
			ro.stop = self.pubTops($elem, options.onalwaystopics, options.resizableonstoptopics);
			ro.resize = self.pubTops($elem, options.onalwaystopics, options.resizableonresizetopics);
			$elem.jqGrid('gridResize', ro);
		}

		if (options.draggable && options.droppable) {
			self.log('drag and drop for grid : '+options.id);
			var daos = options.draggableoptions;
			var dao = window[daos];
			if (!dao) {
				dao = eval("( " + daos + " )");
			}
			else {
				dao = {};
			}
			dao.drap = self.pubTops($elem, options.onalwaystopics, options.draggableondragtopics);

			var doos = options.droppableoptions;
			var doo = window[doos];
			if (!doo) {
				doo = eval("( " + doos + " )");
			}
			else {
				doo = {};
			}
			doo.activate = self.pubTops($elem, options.onalwaystopics, options.droppableonactivatetopics);
			doo.deactivate = self.pubTops($elem, options.onalwaystopics, options.droppableondeactivatetopics);
			doo.start = self.pubTops($elem, options.onalwaystopics, options.droppableonstarttopics);
			doo.stop = self.pubTops($elem, options.onalwaystopics, options.droppableonstoptopics);

			var ddo = {};
			ddo.drag_opts = dao;
			ddo.drop_opts = doo;
			ddo.connectWith = options.connectWith;
			ddo.onstart = self.pubTops($elem, options.onalwaystopics, options.draggableonstarttopics);
			ddo.onstop = self.pubTops($elem, options.onalwaystopics, options.draggableonstoptopics);
			ddo.ondrop = self.pubTops($elem, options.onalwaystopics, options.droppableondroptopics);
			$elem.jqGrid('gridDnD', ddo);
		}

		if (options.sortable) {
			self.log('sortable : '+options.id);
			var soos = options.sortableoptions;
			var soo = window[soos];
			if (!soo) {
				soo = eval("( " + soos + " )");
			}
			else {
				soo = {};
			}
			soo.beforeStop = self.pubTops($elem, options.onalwaystopics, options.sortableonbeforestoptopics);
			soo.stop = self.pubTops($elem, options.onalwaystopics, options.sortableonstoptopics);
			soo.start = self.pubTops($elem, options.onalwaystopics, options.sortableonstarttopics);
			soo.sort = self.pubTops($elem, options.onalwaystopics, options.sortableonsorttopics);
			soo.activate = self.pubTops($elem, options.onalwaystopics, options.sortableonactivatetopics);
			soo.deactivate = self.pubTops($elem, options.onalwaystopics, options.sortableondeactivatetopics);
			soo.over = self.pubTops($elem, options.onalwaystopics, options.sortableonovertopics);
			soo.out = self.pubTops($elem, options.onalwaystopics, options.sortableonouttopics);
			soo.remove = self.pubTops($elem, options.onalwaystopics, options.sortableonremovetopics);
			soo.receive = self.pubTops($elem, options.onalwaystopics, options.sortableonreceivetopics);
			soo.change = self.pubTops($elem, options.onalwaystopics, options.sortableonchangetopics);
			soo.update = self.pubTops($elem, options.onalwaystopics, options.sortableonupdatetopics);
			$elem.jqGrid('sortableRows', soo);
		}

		if (options.navigator) {
			var navparams = {};
			navparams.add = options.navigatoradd;
			navparams.del = options.navigatordel;
			navparams.edit = options.navigatoredit;
			navparams.refresh = options.navigatorrefresh;
			navparams.search = options.navigatorsearch;
			navparams.view = options.navigatorview;
			$elem.jqGrid('navGrid', self.escId(options.pager), navparams, options.navigatoreditoptions, options.navigatoraddoptions, options.navigatordeleteoptions, options.navigatorsearchoptions, options.navigatorviewoptions);
		}
		if (options.filter) {
			var fpara = {};
			if (options.filteroptions) { fpara = options.filteroptions; }
			$elem.jqGrid('filterToolbar', fpara);
		}
	}
	};
	
	// Extend it from orginal plugin
	$.extend($.struts2_jquery_grid, $.struts2_jquery);
	
	// Register handler for reloading grid
	$.subscribeHandler('_s2j_reloadgrid', function(event, data) {
		var options = {};
		$.extend(options, event.data);
		if (options.id) {

			if(options.url && options.formids) {
				var formdata = '';
				if (options.formids) {
					if (!$.struts2_jquery.loadAtOnce) {
						$.struts2_jquery.require("js/plugins/jquery.form"+$.struts2_jquery.minSuffix+".js");
					}
					$.each(options.formids.split(','), function(i, fid) {
						var query = $($.struts2_jquery.escId(fid)).formSerialize();
						if (formdata != '') { formdata = formdata + '&' + query; }
						else { formdata = query; }
					});
				}
				if (options.url.lastIndexOf('?') > 0) {
					options.url = options.url + '&amp;' + formdata;
				}
				else {
					options.url = options.url + '?' + formdata;
				}
			}
			$($.struts2_jquery.escId(options.id)).setGridParam({url:options.url}); 

			$.struts2_jquery.log('reload grid '+options.id);
			$($.struts2_jquery.escId(options.id)).trigger("reloadGrid");  
		}
	});

})(jQuery);
