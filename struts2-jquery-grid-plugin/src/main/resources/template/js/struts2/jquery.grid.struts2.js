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

/*global $, jQuery, s2jlog, publishTopic, pubCom, pubErr, escId  */
/*jslint evil: true */

( function($) {
	
	/**
	 * Bind jqGrid to Struts2 Component
	 */
	$.struts2_jquery_grid = {

	grid : function($elem, options) {
		s2jlog('grid for : '+options.id);
		$.require("i18n/grid.locale-"+$.struts2_jquery.gridLocal+".js", function() {
			$.jgrid.no_legacy_api = true;
			$.jgrid.useJSON = true;
		});
		if (!$.struts2_jquery.loadAtOnce) {
			$.require(["js/base/jquery-ui"+$.struts2_jquery.minSuffix+".js","js/plugins/jquery.jqGrid.js"]);
		}
		else {
			$.require("js/plugins/jquery.jqGrid.js");
		}
		$.requireCss("themes/ui.jqgrid.css");
		var params = {};
		$.extend(params, options);
		if (options.onselectrowtopics || options.editurl) {
			params.onSelectRow = function(id) {
				var data = {};
				data.id = id;

				publishTopic($elem, options.onalwaystopics, data);
				publishTopic($elem, options.onselectrowtopics, data);
				if (options.editurl && options.editinline === true) {
					if (id && id !== $.struts2_jquery.lastselectedrow) {
						$elem.jqGrid('restoreRow', $.struts2_jquery.lastselectedrow);
						$elem.jqGrid('editRow', id, true);
						$.struts2_jquery.lastselectedrow = id;
					}
				}
			};
		}

		params.loadBeforeSend = function(xhr) {

			var orginal = {};
			orginal.xhr = xhr;

			publishTopic($elem, options.onalwaystopics, orginal);
			publishTopic($elem, options.onbeforetopics, orginal);
		};

		params.onPaging = function(pgButton) {

			var orginal = {};
			orginal.pgButton = pgButton;

			publishTopic($elem, options.onalwaystopics, orginal);
			publishTopic($elem, options.onpagingtopics, orginal);
		};

		params.onSortCol = function(index, iCol, sortorder) {

			var orginal = {};
			orginal.index = index;
			orginal.iCol = iCol;
			orginal.sortorder = sortorder;

			publishTopic($elem, options.onalwaystopics, orginal);
			publishTopic($elem, options.onsortcoltopics, orginal);
		};

		params.onCellSelect = function(rowid, iCol, cellcontent, e) {

			var orginal = {};
			orginal.rowid = rowid;
			orginal.iCol = iCol;
			orginal.cellcontent = cellcontent;
			orginal.e = e;

			publishTopic($elem, options.onalwaystopics, orginal);
			publishTopic($elem, options.oncellselecttopics, orginal);
		};

		params.gridComplete = function() {

			var orginal = {};

			publishTopic($elem, options.onalwaystopics, orginal);
			publishTopic($elem, options.ongridcompletetopics, orginal);
		};

		params.loadComplete = pubCom($elem, options.onalwaystopics, options.oncompletetopics, null, null, options);
		params.loadError = pubErr($elem, options.onalwaystopics, options.onerrortopics, options.errortext);

		if (options.subgrid) {
			params.subGrid = true;

			// gridview can't be true when using the subgrid feature
			params.gridview = false;
			params.subGridRowExpanded = function(subgrid_id, row_id) {
				var subgrid_table_id = subgrid_id + "_table";
				var subgrid = $(escId(subgrid_id));
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
				$(escId(subgrid_table_id)).jqGrid(options.subgridoptions);
			};
		}
		else {
			params.gridview = true;
		}

		$elem.jqGrid(params);
		if (options.navigator) {
			var navparams = {};
			navparams.add = options.navigatoradd;
			navparams.del = options.navigatordel;
			navparams.edit = options.navigatoredit;
			navparams.refresh = options.navigatorrefresh;
			navparams.search = options.navigatorsearch;
			navparams.view = options.navigatorview;
			$elem.jqGrid('navGrid', escId(options.pager), navparams, options.navigatoreditoptions, options.navigatoraddoptions, options.navigatordeleteoptions, options.navigatorsearchoptions, options.navigatorviewoptions);
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
