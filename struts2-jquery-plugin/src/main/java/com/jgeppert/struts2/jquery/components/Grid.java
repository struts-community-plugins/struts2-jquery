/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jgeppert.struts2.jquery.components;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc --> Renders a grid
 * 
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 */
@StrutsTag(name = "grid", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.GridTag", description = "Render an grid from a List.")
public class Grid extends AbstractRemoteBean
{

	final private static transient Random	RANDOM			= new Random();
	public static final String				JQUERYACTION	= "grid";
	public static final String				TEMPLATE		= "grid";
	public static final String				TEMPLATE_CLOSE	= "grid-close";
	public static final String				COMPONENT_NAME	= Grid.class.getName();

	protected String						width;
	protected String						height;
	protected String						pager;
	protected String						rowNum;
	protected String						sortname;
	protected String						viewrecords;
	protected String						sortable;
	protected String						sortorder;
	protected String						loadonce;
	protected String						multiselect;
	protected String						editurl;
	protected String						editinline;
	protected String						caption;
	protected String						shrinkToFit;
	protected String						gridModel;
	protected String						rowList;
	protected String						scroll;
	protected String						navigator;
	protected String						navigatorEditOptions;
	protected String						navigatorAddOptions;
	protected String						navigatorDeleteOptions;
	protected String						navigatorSearchOptions;
	protected String						navigatorViewOptions;
	protected String						navigatorAdd;
	protected String						navigatorDelete;
	protected String						navigatorEdit;
	protected String						navigatorRefresh;
	protected String						navigatorSearch;
	protected String						navigatorView;
	protected String						autoencode;
	protected String						cellEdit;
	protected String						cellurl;
	protected String						footerrow;
	protected String						hiddengrid;
	protected String						hidegrid;
	protected String						hoverrows;
	protected String						rownumbers;
	protected String						multiselectWidth;
	protected String						page;
	protected String						scrollrows;
	protected String						filter;
	protected String						subGridWidth;
	protected String						subGridUrl;
	protected String						userDataOnFooter;
	protected String						filterOptions;
	protected String						altClass;
	protected String						altRows;

	protected String						onSelectRowTopics;
	protected String						onPagingTopics;
	protected String						onSortColTopics;
	protected String						onCellSelectTopics;
	protected String						onGridCompleteTopics;

	public Grid(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
	{
		super(stack, request, response);
	}

	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();

		addParameter("jqueryaction", JQUERYACTION);

		Grid parentGrid = (Grid) findAncestor(Grid.class);
		if (parentGrid != null)
		{
			addParameter("subGrid", true);
			addParameter("parentGrid", findString(parentGrid.getId()));
			if (subGridUrl != null) addParameter("subGridUrl", findString(subGridUrl));
			if (subGridWidth != null) addParameter("subGridWidth", findString(subGridWidth));

		}
		if (width != null) addParameter("width", findString(width));
		if (height != null) addParameter("height", findString(height));
		if (pager != null) addParameter("pager", findValue(this.pager, Boolean.class));
		if (rowNum != null) addParameter("rowNum", findString(rowNum));
		if (sortable != null) addParameter("sortable", findValue(this.sortable, Boolean.class));
		if (sortname != null) addParameter("sortname", findString(sortname));
		if (viewrecords != null) addParameter("viewrecords", findValue(this.viewrecords, Boolean.class));
		if (sortorder != null) addParameter("sortorder", findString(sortorder));
		if (loadonce != null) addParameter("loadonce", findValue(this.loadonce, Boolean.class));
		if (multiselect != null) addParameter("multiselect", findValue(this.multiselect, Boolean.class));
		if (editurl != null) addParameter("editurl", findString(editurl));
		if (editinline != null) addParameter("editinline", findValue(this.editinline, Boolean.class));
		if (caption != null) addParameter("caption", findString(caption));
		if (shrinkToFit != null) addParameter("shrinkToFit", findValue(this.shrinkToFit, Boolean.class));
		if (gridModel != null) addParameter("gridModel", findString(gridModel));
		if (scroll != null) addParameter("scroll", findValue(this.scroll, Boolean.class));
		if (rowList != null) addParameter("rowList", findString(rowList));
		if (navigator != null) addParameter("navigator", findValue(this.navigator, Boolean.class));
		if (navigatorAddOptions != null) addParameter("navigatorAddOptions", findString(navigatorAddOptions));
		if (navigatorEditOptions != null) addParameter("navigatorEditOptions", findString(navigatorEditOptions));
		if (navigatorDeleteOptions != null) addParameter("navigatorDeleteOptions", findString(navigatorDeleteOptions));
		if (navigatorViewOptions != null) addParameter("navigatorViewOptions", findString(navigatorViewOptions));
		if (navigatorSearchOptions != null) addParameter("navigatorSearchOptions", findString(navigatorSearchOptions));
		if (navigatorAdd != null) addParameter("navigatorAdd", findValue(this.navigatorAdd, Boolean.class));
		if (navigatorDelete != null) addParameter("navigatorDelete", findValue(this.navigatorDelete, Boolean.class));
		if (navigatorEdit != null) addParameter("navigatorEdit", findValue(this.navigatorEdit, Boolean.class));
		if (navigatorRefresh != null) addParameter("navigatorRefresh", findValue(this.navigatorRefresh, Boolean.class));
		if (navigatorView != null) addParameter("navigatorView", findValue(this.navigatorView, Boolean.class));
		if (navigatorSearch != null) addParameter("navigatorSearch", findValue(this.navigatorSearch, Boolean.class));

		if (cellurl != null) addParameter("cellurl", findString(cellurl));
		if (multiselectWidth != null) addParameter("multiselectWidth", findString(multiselectWidth));
		if (page != null) addParameter("page", findString(page));
		if (autoencode != null) addParameter("autoencode", findValue(this.autoencode, Boolean.class));
		if (cellEdit != null) addParameter("cellEdit", findValue(this.cellEdit, Boolean.class));
		if (footerrow != null) addParameter("footerrow", findValue(this.footerrow, Boolean.class));
		if (hiddengrid != null) addParameter("hiddengrid", findValue(this.hiddengrid, Boolean.class));
		if (hidegrid != null) addParameter("hidegrid", findValue(this.hidegrid, Boolean.class));
		if (hoverrows != null) addParameter("hoverrows", findValue(this.hoverrows, Boolean.class));
		if (rownumbers != null) addParameter("rownumbers", findValue(this.rownumbers, Boolean.class));
		if (scrollrows != null) addParameter("scrollrows", findValue(this.scrollrows, Boolean.class));
		if (filter != null) addParameter("filter", findValue(this.filter, Boolean.class));
		if (filterOptions != null) addParameter("filterOptions", findString(filterOptions));
		if (userDataOnFooter != null) addParameter("userDataOnFooter", findValue(this.userDataOnFooter, Boolean.class));
		if (altClass != null) addParameter("altClass", findString(altClass));
		if (altRows != null) addParameter("altRows", findValue(this.altRows, Boolean.class));

		if (onSelectRowTopics != null) addParameter("onSelectRowTopics", findString(onSelectRowTopics));
		if (onCellSelectTopics != null) addParameter("onCellSelectTopics", findString(onCellSelectTopics));
		if (onPagingTopics != null) addParameter("onPagingTopics", findString(onPagingTopics));
		if (onSortColTopics != null) addParameter("onSortColTopics", findString(onSortColTopics));
		if (onGridCompleteTopics != null) addParameter("onGridCompleteTopics", findString(onGridCompleteTopics));

		if ((this.id == null || this.id.length() == 0))
		{
			// resolves Math.abs(Integer.MIN_VALUE) issue reported by
			// FindBugs
			// http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
			int nextInt = RANDOM.nextInt();
			nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
			this.id = "grid_" + String.valueOf(nextInt);
			addParameter("id", this.id);
		}
	}

	@Override
	@StrutsTagSkipInheritance
	public void setTheme(String theme) {
		super.setTheme(theme);
	}

	@Override
	public String getTheme() {
		return "jquery";
	}

	@StrutsTagAttribute(description = "If this option is not set, the width of the grid is a sum of the widths of the columns defined in the colModel (in pixels). If this option is set, the initial width of each column is set according to the value of shrinkToFit option.")
	public void setWidth(String width) {
		this.width = width;
	}

	@StrutsTagAttribute(description = "The height of the grid. Can be set as number e.g. 400. Default: auto")
	public void setHeight(String height) {
		this.height = height;
	}

	@StrutsTagAttribute(description = "Defines that we want to use a pager bar to navigate through the records. This must be a true or false.", defaultValue = "false", type = "Boolean")
	public void setPager(String pager) {
		this.pager = pager;
	}

	@StrutsTagAttribute(description = "Sets how many records we want to view in the grid. This parameter is passed to the url for use by the server routine retrieving the data. Note that if you set this parameter to 10 (i.e. retrieve 10 records) and your server return 15 then only 10 records will be loaded. Set this parameter to -1 (unlimited) to disable this checking. Default: 20")
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	@StrutsTagAttribute(description = "The initial sorting name. This parameter is added to the url. If set and the index (name) match the name from colModel then to this column by default is added a image sorting icon, according to the parameter sortorder (below).")
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	@StrutsTagAttribute(description = "Defines whether we want to display the number of total records from the query in the pager bar.", defaultValue = "false", type = "Boolean")
	public void setViewrecords(String viewrecords) {
		this.viewrecords = viewrecords;
	}

	@StrutsTagAttribute(description = "The initial sorting order.This parameter is added to the url - see prnNames. Two possible values - asc or desc. Default asc")
	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	@StrutsTagAttribute(description = "If this flag is set to true, the grid loads the data from the server only once. After the first request all further manipulations are done on the client side. The functions of the pager (if present) are disabled.", defaultValue = "false", type = "Boolean")
	public void setLoadonce(String loadonce) {
		this.loadonce = loadonce;
	}

	@StrutsTagAttribute(description = "If this flag is set to true a multi selection of rows is enabled. A new column at left side is added.", defaultValue = "false", type = "Boolean")
	public void setMultiselect(String multiselect) {
		this.multiselect = multiselect;
	}

	@StrutsTagAttribute(description = "Defines the url for inline and form editing.")
	public void setEditurl(String editurl) {
		this.editurl = editurl;
	}

	@StrutsTagAttribute(description = "Enable editing inline. Default: false", defaultValue = "false", type = "Boolean")
	public void setEditinline(String editinline) {
		this.editinline = editinline;
	}

	@StrutsTagAttribute(description = "Defines the Caption layer for the grid. This caption appear above the Header layer. If the string is empty the caption does not appear.")
	public void setCaption(String caption) {
		this.caption = caption;
	}

	@StrutsTagAttribute(description = "When enabled this option allow column reordering with mouse.", defaultValue = "false", type = "Boolean")
	public void setSortable(String sortable) {
		this.sortable = sortable;
	}

	@StrutsTagAttribute(description = "This option describes the type of calculation of the initial width of each column against with the width of the grid. If the value is true and the value in width option is set then: Every column width is scaled according to the defined option width.", defaultValue = "true", type = "Boolean")
	public void setShrinkToFit(String shrinkToFit) {
		this.shrinkToFit = shrinkToFit;
	}

	@StrutsTagAttribute(description = "Name of you grid model. Must be a Collection", required = true)
	public void setGridModel(String gridModel) {
		this.gridModel = gridModel;
	}

	@StrutsTagAttribute(description = "An array to construct a select box element in the pager in which we can change the number of the visible rows. e.g. 10,15,20")
	public void setRowList(String rowList) {
		this.rowList = rowList;
	}

	@StrutsTagAttribute(description = "Creates dynamic scrolling grids. When enabled, the pager elements are disabled and we can use the vertical scrollbar to load data. When set to true the grid will always hold all the items from the start through to the latest point ever visited.", defaultValue = "false", type = "Boolean")
	public void setScroll(String scroll) {
		this.scroll = scroll;
	}

	@StrutsTagAttribute(description = "Navigator is a method that can add predefined actions like editing, adding, deleting, and searching. This must be a true or false.", defaultValue = "false", type = "Boolean")
	public void setNavigator(String navigator) {
		this.navigator = navigator;
	}

	@StrutsTagAttribute(description = "Edit Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
	public void setNavigatorEditOptions(String navigatorEditOptions) {
		this.navigatorEditOptions = navigatorEditOptions;
	}

	@StrutsTagAttribute(description = "Add Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
	public void setNavigatorAddOptions(String navigatorAddOptions) {
		this.navigatorAddOptions = navigatorAddOptions;
	}

	@StrutsTagAttribute(description = "Delete Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
	public void setNavigatorDeleteOptions(String navigatorDeleteOptions) {
		this.navigatorDeleteOptions = navigatorDeleteOptions;
	}

	@StrutsTagAttribute(description = "Search Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
	public void setNavigatorSearchOptions(String navigatorSearchOptions) {
		this.navigatorSearchOptions = navigatorSearchOptions;
	}

	@StrutsTagAttribute(description = "View Options for Navigator. e.g. {sopt:['cn','bw','eq','ne','lt','gt','ew']},")
	public void setNavigatorViewOptions(String navigatorViewOptions) {
		this.navigatorViewOptions = navigatorViewOptions;
	}

	@StrutsTagAttribute(description = "When set to true encodes (html encode) the incoming (from server) and posted data (from editing modules). By example < will be converted to &lt;", defaultValue = "true", type = "Boolean")
	public void setAutoencode(String autoencode) {
		this.autoencode = autoencode;
	}

	@StrutsTagAttribute(description = "Enables (disables) cell editing. See Cell Editing for more details", defaultValue = "false", type = "Boolean")
	public void setCellEdit(String cellEdit) {
		this.cellEdit = cellEdit;
	}

	@StrutsTagAttribute(description = "the url where the cell is to be saved.", defaultValue = "false", type = "Boolean")
	public void setCellurl(String cellurl) {
		this.cellurl = cellurl;
	}

	@StrutsTagAttribute(description = "If set to true this will place a footer table with one row below the gird records and above the pager.", defaultValue = "false", type = "Boolean")
	public void setFooterrow(String footerrow) {
		this.footerrow = footerrow;
	}

	@StrutsTagAttribute(description = "If set to true the grid initially is hidden. The data is not loaded (no request is sent) and only the caption layer is shown. When the show/hide button is clicked the first time to show grid, the request is sent to the server, the data is loaded, and grid is shown. From this point we have a regular grid.", defaultValue = "false", type = "Boolean")
	public void setHiddengrid(String hiddengrid) {
		this.hiddengrid = hiddengrid;
	}

	@StrutsTagAttribute(description = "Enables or disables the show/hide grid button, which appears on the right side of the Caption layer. Takes effect only if the caption property is not an empty string.", defaultValue = "false", type = "Boolean")
	public void setHidegrid(String hidegrid) {
		this.hidegrid = hidegrid;
	}

	@StrutsTagAttribute(description = "When set to false the mouse hovering is disabled in the grid data rows.", defaultValue = "false", type = "Boolean")
	public void setHoverrows(String hoverrows) {
		this.hoverrows = hoverrows;
	}

	@StrutsTagAttribute(description = "If this option is set to true, a new column at left of the grid is added. The purpose of this column is to count the number of available rows, beginning from 1. In this case colModel is extended automatically with new element with name - 'rn'. Also, be careful not to use the name 'rn' in gridModel", defaultValue = "false", type = "Boolean")
	public void setRownumbers(String rownumbers) {
		this.rownumbers = rownumbers;
	}

	@StrutsTagAttribute(description = "etermines the width of the multiselect column if multiselect is set to true.")
	public void setMultiselectWidth(String multiselectWidth) {
		this.multiselectWidth = multiselectWidth;
	}

	@StrutsTagAttribute(description = "Set the initial number of page when we make the request.This parameter is passed to the url for use by the server routine retrieving the data", defaultValue = "1")
	public void setPage(String page) {
		this.page = page;
	}

	@StrutsTagAttribute(description = "When enabled, selecting a row with setSelection scrolls the grid so that the selected row is visible.", defaultValue = "false", type = "Boolean")
	public void setScrollrows(String scrollrows) {
		this.scrollrows = scrollrows;
	}

	@StrutsTagAttribute(description = "Enables or disables the add action in the navigator. When the button is clicked a editGridRow with parameter new method is executed", defaultValue = "true", type = "Boolean")
	public void setNavigatorAdd(String navigatorAdd) {
		this.navigatorAdd = navigatorAdd;
	}

	@StrutsTagAttribute(description = "Enables or disables the delete action in the navigator. When the button is clicked a delGridRow method is executed.", defaultValue = "true", type = "Boolean")
	public void setNavigatorDelete(String navigatorDelete) {
		this.navigatorDelete = navigatorDelete;
	}

	@StrutsTagAttribute(description = "Enables or disables the edit action in the navigator. When the button is clicked a editGridRow method is executed with parameter the - current selected row", defaultValue = "true", type = "Boolean")
	public void setNavigatorEdit(String navigatorEdit) {
		this.navigatorEdit = navigatorEdit;
	}

	@StrutsTagAttribute(description = "Enables or disables the refresh button in the pager. When the button is clicked a trigger(reloadGrid) is executed and the search parameters are cleared", defaultValue = "true", type = "Boolean")
	public void setNavigatorRefresh(String navigatorRefresh) {
		this.navigatorRefresh = navigatorRefresh;
	}

	@StrutsTagAttribute(description = "Enables or disables the search button in the pager.When the button is clicked a searchGrid method is executed", defaultValue = "true", type = "Boolean")
	public void setNavigatorSearch(String navigatorSearch) {
		this.navigatorSearch = navigatorSearch;
	}

	@StrutsTagAttribute(description = "Enables or disables the view button in the pager. When the button is clicked a viewGridRow method is executed", defaultValue = "false", type = "Boolean")
	public void setNavigatorView(String navigatorView) {
		this.navigatorView = navigatorView;
	}

	@StrutsTagAttribute(description = "This method construct searching creating input elements just below the header elements of the grid.", defaultValue = "false", type = "Boolean")
	public void setFilter(String filter) {
		this.filter = filter;
	}

	@StrutsTagAttribute(description = "Determines the width of the subGrid column if subgrid is enabled.")
	public void setSubGridWidth(String subGridWidth) {
		this.subGridWidth = subGridWidth;
	}

	@StrutsTagAttribute(description = "This option has effect only if subGrid option is set to true. This option points to the file from which we get the data for the subgrid. jqGrid adds the id of the row to this url as parameter.")
	public void setSubGridUrl(String subGridUrl) {
		this.subGridUrl = subGridUrl;
	}

	@StrutsTagAttribute(description = "When set to true we directly place the user data array userData at footer. The rules are as follow: If the userData array contain name which is equal to those of colModel then the value is placed in that column.If there are no such values nothing is palced. Note that if this option is used we use the current formatter options (if available) for that column.")
	public void setUserDataOnFooter(String userDataOnFooter) {
		this.userDataOnFooter = userDataOnFooter;
	}

	@StrutsTagAttribute(description = "Options for Filter Settings as JavaScript Object. e.g. { autosearch : false, formtype : vertical }")
	public void setFilterOptions(String filterOptions) {
		this.filterOptions = filterOptions;
	}

	@StrutsTagAttribute(description = "The class that is used for alternate rows. You can construct your own class and replace this value. This option is valid only if altRows options is set to true", defaultValue = "ui-priority-secondary")
	public void setAltClass(String altClass) {
		this.altClass = altClass;
	}

	@StrutsTagAttribute(description = "Set a zebra-striped grid", defaultValue = "false", type = "Boolean")
	public void setAltRows(String altRows) {
		this.altRows = altRows;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published when a row is selected")
	public void setOnSelectRowTopics(String onSelectRowTopics) {
		this.onSelectRowTopics = onSelectRowTopics;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published after click on page button and before populating the data. Parameter: pgButton")
	public void setOnPagingTopics(String onPagingTopics) {
		this.onPagingTopics = onPagingTopics;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published immediately after sortable column was clicked and before sorting the data. Parameters: index is the index name from colModel, iCol is the index of column, sortorder is the new sorting order - can be 'asc' or 'desc'")
	public void setOnSortColTopics(String onSortColTopics) {
		this.onSortColTopics = onSortColTopics;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published when we click on particular cell in the grid. Parameters: rowid is the id of the row, iCol is the index of the cell, cellcontent is the content of the cell, e is the event object element where we click.")
	public void setOnCellSelectTopics(String onCellSelectTopics) {
		this.onCellSelectTopics = onCellSelectTopics;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published after all the data is loaded into the grid and all other processes are complete.")
	public void setOnGridCompleteTopics(String onGridCompleteTopics) {
		this.onGridCompleteTopics = onGridCompleteTopics;
	}
}
