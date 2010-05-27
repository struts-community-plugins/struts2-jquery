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
		this.log('grid for : '+options.id);
		this.require("i18n/grid.locale-"+this.gridLocal+".js", function() {
			$.jgrid.no_legacy_api = true;
			$.jgrid.useJSON = true;
		});
		if (!this.loadAtOnce) {
			this.require(
					[
					 "js/base/jquery.ui.widget"+this.minSuffix+".js",
					 "js/base/jquery.ui.mouse"+this.minSuffix+".js",
					 "js/base/jquery.ui.position"+this.minSuffix+".js",
					 "js/base/jquery.ui.button"+this.minSuffix+".js",
					 "js/base/jquery.ui.draggable"+this.minSuffix+".js",
					 "js/base/jquery.ui.droppable"+this.minSuffix+".js",
					 "js/base/jquery.ui.sortable"+this.minSuffix+".js",
					 "js/base/jquery.ui.selectable"+this.minSuffix+".js",
					 "js/base/jquery.ui.resizable"+this.minSuffix+".js",
					 "js/base/jquery.bgiframe"+this.minSuffix+".js",
					 "js/base/jquery.effects.core"+this.minSuffix+".js",
					 "js/base/jquery.effects.scale"+this.minSuffix+".js",
					 "js/base/jquery.effects.drop"+this.minSuffix+".js",
					 "js/base/jquery.ui.dialog"+this.minSuffix+".js",
					 "js/plugins/jquery.jqGrid.js"
					 ]);
		}
		else {
			this.require("js/plugins/jquery.jqGrid.js");
		}
		this.requireCss("themes/ui.jqgrid.css");
		var params = {};
		$.extend(params, options);
		if (options.onselectrowtopics || (options.editurl && options.editinline === true)) {
			params.onSelectRow = function(id, status) {
				var data = {};
				data.id = id;
				data.status = status;
				data.grid = $(this);

				$.struts2_jquery.publishTopic($elem, options.onalwaystopics, data);
				$.struts2_jquery.publishTopic($elem, options.onselectrowtopics, data);
				if (options.editurl && options.editinline === true) {
					if (id && id !== $.struts2_jquery_grid.lastselectedrow) {
						$(this).jqGrid('restoreRow', $.struts2_jquery_grid.lastselectedrow);
						$.struts2_jquery_grid.lastselectedrow = id;
					}
					$(this).jqGrid('editRow', id, true);
				}
			};
		}

		if (options.onselectalltopics) {
			params.onSelectAll = function(ids, status) {
				var data = {};
				data.ids = ids;
				data.status = status;
				data.grid = $(this);

				$.struts2_jquery.publishTopic($elem, options.onalwaystopics, data);
				$.struts2_jquery.publishTopic($elem, options.onselectalltopics, data);
			};
		}

		if(options.onbeforetopics) {
			params.loadBeforeSend = function(xhr) {
	
				var orginal = {};
				orginal.xhr = xhr;
	
				$.struts2_jquery.publishTopic($elem, options.onalwaystopics, orginal);
				$.struts2_jquery.publishTopic($elem, options.onbeforetopics, orginal);
			};
		}
		
		if(options.onpagingtopics) {
			params.onPaging = function(pgButton) {
	
				var orginal = {};
				orginal.pgButton = pgButton;
	
				$.struts2_jquery.publishTopic($elem, options.onalwaystopics, orginal);
				$.struts2_jquery.publishTopic($elem, options.onpagingtopics, orginal);
			};
		}
		
		if(options.onsortcoltopics) {
			params.onSortCol = function(index, iCol, sortorder) {
	
				var orginal = {};
				orginal.index = index;
				orginal.iCol = iCol;
				orginal.sortorder = sortorder;
	
				$.struts2_jquery.publishTopic($elem, options.onalwaystopics, orginal);
				$.struts2_jquery.publishTopic($elem, options.onsortcoltopics, orginal);
			};
		}

		if(options.oncellselecttopics) {
			params.onCellSelect = function(rowid, iCol, cellcontent, e) {
	
				var orginal = {};
				orginal.rowid = rowid;
				orginal.iCol = iCol;
				orginal.cellcontent = cellcontent;
				orginal.e = e;
	
				$.struts2_jquery.publishTopic($elem, options.onalwaystopics, orginal);
				$.struts2_jquery.publishTopic($elem, options.oncellselecttopics, orginal);
			};
		}
		
		if(options.ongridcompletetopics) {
			params.gridComplete = function() {
	
				var orginal = {};
	
				$.struts2_jquery.publishTopic($elem, options.onalwaystopics, orginal);
				$.struts2_jquery.publishTopic($elem, options.ongridcompletetopics, orginal);
			};
		}
		
		
		if (!params.loadtext && this.defaultLoadingText !== null) {
			params.loadtext = this.defaultLoadingText;
		}
		
		params.loadComplete = this.pubCom($elem, options.onalwaystopics, options.oncompletetopics, null, null, options);
		params.loadError = this.pubErr($elem, options.onalwaystopics, options.onerrortopics, options.errortext);

		if (options.subgrid) {
			params.subGrid = true;

			// gridview can't be true when using the subgrid feature
			params.gridview = false;
			params.subGridRowExpanded = function(subgrid_id, row_id) {
				var subgrid_table_id = subgrid_id + "_table";
				var subgrid = $($.struts2_jquery.escId(subgrid_id));
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
				$($.struts2_jquery.escId(subgrid_table_id)).jqGrid(options.subgridoptions);
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
			ro.start = this.pubTops($elem, options.onalwaystopics, options.resizableonstarttopics);
			ro.stop = this.pubTops($elem, options.onalwaystopics, options.resizableonstoptopics);
			ro.resize = this.pubTops($elem, options.onalwaystopics, options.resizableonresizetopics);
			$elem.jqGrid('gridResize', ro);
		}

		if (options.draggable && options.droppable) {
			this.log('drag and drop for grid : '+options.id);
			var daos = options.draggableoptions;
			var dao = window[daos];
			if (!dao) {
				dao = eval("( " + daos + " )");
			}
			else {
				dao = {};
			}
			dao.drap = this.pubTops($elem, options.onalwaystopics, options.draggableondragtopics);

			var doos = options.droppableoptions;
			var doo = window[doos];
			if (!doo) {
				doo = eval("( " + doos + " )");
			}
			else {
				doo = {};
			}
			doo.activate = this.pubTops($elem, options.onalwaystopics, options.droppableonactivatetopics);
			doo.deactivate = this.pubTops($elem, options.onalwaystopics, options.droppableondeactivatetopics);
			doo.start = this.pubTops($elem, options.onalwaystopics, options.droppableonstarttopics);
			doo.stop = this.pubTops($elem, options.onalwaystopics, options.droppableonstoptopics);

			var ddo = {};
			ddo.drag_opts = dao;
			ddo.drop_opts = doo;
			ddo.connectWith = options.connectWith;
			ddo.onstart = this.pubTops($elem, options.onalwaystopics, options.draggableonstarttopics);
			ddo.onstop = this.pubTops($elem, options.onalwaystopics, options.draggableonstoptopics);
			ddo.ondrop = this.pubTops($elem, options.onalwaystopics, options.droppableondroptopics);
			$elem.jqGrid('gridDnD', ddo);
		}

		if (options.sortable) {
			this.log('sortable : '+options.id);
			var soos = options.sortableoptions;
			var soo = window[soos];
			if (!soo) {
				soo = eval("( " + soos + " )");
			}
			else {
				soo = {};
			}
			soo.beforeStop = this.pubTops($elem, options.onalwaystopics, options.sortableonbeforestoptopics);
			soo.stop = this.pubTops($elem, options.onalwaystopics, options.sortableonstoptopics);
			soo.start = this.pubTops($elem, options.onalwaystopics, options.sortableonstarttopics);
			soo.sort = this.pubTops($elem, options.onalwaystopics, options.sortableonsorttopics);
			soo.activate = this.pubTops($elem, options.onalwaystopics, options.sortableonactivatetopics);
			soo.deactivate = this.pubTops($elem, options.onalwaystopics, options.sortableondeactivatetopics);
			soo.over = this.pubTops($elem, options.onalwaystopics, options.sortableonovertopics);
			soo.out = this.pubTops($elem, options.onalwaystopics, options.sortableonouttopics);
			soo.remove = this.pubTops($elem, options.onalwaystopics, options.sortableonremovetopics);
			soo.receive = this.pubTops($elem, options.onalwaystopics, options.sortableonreceivetopics);
			soo.change = this.pubTops($elem, options.onalwaystopics, options.sortableonchangetopics);
			soo.update = this.pubTops($elem, options.onalwaystopics, options.sortableonupdatetopics);
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
			$elem.jqGrid('navGrid', this.escId(options.pager), navparams, options.navigatoreditoptions, options.navigatoraddoptions, options.navigatordeleteoptions, options.navigatorsearchoptions, options.navigatorviewoptions);
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
})(jQuery);
