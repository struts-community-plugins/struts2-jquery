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

package com.jgeppert.struts2.jquery.grid.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.AbstractRemoteBean;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Renders a column for the grid
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "gridColumn", tldTagClass = "com.jgeppert.struts2.jquery.grid.views.jsp.ui.GridColumnTag", description = "Renders a column for the grid")
public class GridColumn extends AbstractRemoteBean {

	public static final String TEMPLATE = "gridcolumn";
	public static final String TEMPLATE_CLOSE = "gridcolumn-close";
	public static final String COMPONENT_NAME = GridColumn.class.getName();
	final protected static Logger LOG = LoggerFactory
			.getLogger(GridColumn.class);

	protected String name;
	protected String jsonmap;
	protected String title;
	protected String index;
	protected String width;
	protected String editable;
	protected String editoptions;
	protected String edittype;
	protected String editrules;
	protected String formatter;
	protected String formatoptions;
	protected String sortable;
	protected String sorttype;
	protected String resizable;
	protected String key;
	protected String search;
	protected String searchtype;
	protected String searchoptions;
	protected String hidden;
	protected String hidedlg;
	protected String align;
	protected String formoptions;
	protected String defval;
	protected String surl;

	public GridColumn(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
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

		if (name != null)
			addParameter("name", findString(name));
		if (jsonmap != null)
			addParameter("jsonmap", findString(jsonmap));
		if (title != null)
			addParameter("title", findString(title));
		if (index != null)
			addParameter("index", findString(index));
		if (width != null)
			addParameter("width", findString(width));
		if (editable != null)
			addParameter("editable", findValue(this.editable, Boolean.class));
		if (editoptions != null)
			addParameter("editoptions", findString(editoptions));
		if (edittype != null)
			addParameter("edittype", findString(edittype));
		if (editrules != null)
			addParameter("editrules", findString(editrules));
		if (formatter != null)
			addParameter("formatter", findString(formatter));
		if (formatoptions != null)
			addParameter("formatoptions", findString(formatoptions));
		if (sortable != null)
			addParameter("sortable", findValue(this.sortable, Boolean.class));
		if (sorttype != null)
			addParameter("sorttype", findString(sorttype));
		if (resizable != null)
			addParameter("resizable", findValue(this.resizable, Boolean.class));
		if (key != null)
			addParameter("key", findValue(this.key, Boolean.class));
		if (search != null)
			addParameter("search", findValue(this.search, Boolean.class));
		if (searchoptions != null)
			addParameter("searchoptions", findString(searchoptions));
		if (searchtype != null)
			addParameter("searchtype", findString(searchtype));
		if (hidden != null)
			addParameter("hidden", findValue(this.hidden, Boolean.class));
		if (hidedlg != null)
			addParameter("hidedlg", findValue(this.hidedlg, Boolean.class));
		if (align != null)
			addParameter("align", findString(align));
		if (formoptions != null)
			addParameter("formoptions", findString(formoptions));
		if (defval != null)
			addParameter("defval", findString(defval));
		if (surl != null)
			addParameter("surl", findString(surl));

		Grid grid = (Grid) findAncestor(Grid.class);
		if (grid != null) {
			addParameter("grid", grid.getId());
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

	@StrutsTagAttribute(description = "Set the unique name in the grid for the column. This property is required. As well as other words used as property/event names, the reserved words (which cannot be used for names) include subgrid, cb and rn.", required = true)
	public void setName(String name) {
		this.name = name;
	}

	@StrutsTagAttribute(description = "Defines the json mapping for the column in the incoming json string.", required = false)
	public void setJsonmap(String jsonmap) {
		this.jsonmap = jsonmap;
	}

	@StrutsTagAttribute(description = "Column title")
	public void setTitle(String title) {
		this.title = title;
	}

	@StrutsTagAttribute(description = "Set the index name when sorting. Passed as sidx parameter.")
	public void setIndex(String index) {
		this.index = index;
	}

	@StrutsTagAttribute(description = "Set the initial width of the column, in pixels.")
	public void setWidth(String width) {
		this.width = width;
	}

	@StrutsTagAttribute(description = "Defines if the field is editable.", defaultValue = "false", type = "Boolean")
	public void setEditable(String editable) {
		this.editable = editable;
	}

	@StrutsTagAttribute(description = "Array of allowed options (attributes) for edittype option")
	public void setEditoptions(String editoptions) {
		this.editoptions = editoptions;
	}

	@StrutsTagAttribute(description = "Defines the edit type for inline and form editing Possible values: text, textarea, select, checkbox, password, button, image and file.")
	public void setEdittype(String edittype) {
		this.edittype = edittype;
	}

	@StrutsTagAttribute(description = "sets additional rules for the editable field. e.g {number:true, required: true, minValue:10, maxValue:100}")
	public void setEditrules(String editrules) {
		this.editrules = editrules;
	}

	@StrutsTagAttribute(description = "The predefined types (string) or custom function name that controls the format of this field. e.g.: integer, currency, date, checkbox")
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	@StrutsTagAttribute(description = "Format options can be defined for particular columns, overwriting the defaults from the language file.")
	public void setFormatoptions(String formatoptions) {
		this.formatoptions = formatoptions;
	}

	@StrutsTagAttribute(description = "Defines is this can be sorted.", defaultValue = "true", type = "Boolean")
	public void setSortable(String sortable) {
		this.sortable = sortable;
	}

	@StrutsTagAttribute(description = "Used when datatype is local. Defines the type of the column for appropriate sorting.Possible values: int/integer - for sorting integer, float/number/currency - for sorting decimal numbers, date - for sorting date, text - for text sorting, function - defines a custom function for sorting.", defaultValue = "text")
	public void setSorttype(String sorttype) {
		this.sorttype = sorttype;
	}

	@StrutsTagAttribute(description = "Defines if the column can be re sized", defaultValue = "true", type = "Boolean")
	public void setResizable(String resizable) {
		this.resizable = resizable;
	}

	@StrutsTagAttribute(description = "In case if there is no id from server, this can be set as as id for the unique row id. Only one column can have this property. If there are more than one key the grid finds the first one and the second is ignored.", defaultValue = "false", type = "Boolean")
	public void setKey(String key) {
		this.key = key;
	}

	@StrutsTagAttribute(description = "When used in search modules, disables or enables searching on that column.", defaultValue = "true", type = "Boolean")
	public void setSearch(String search) {
		this.search = search;
	}

	@StrutsTagAttribute(description = "Defines the search options used searching. e.g. {sopt:['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']}")
	public void setSearchoptions(String searchoptions) {
		this.searchoptions = searchoptions;
	}

	@StrutsTagAttribute(description = "Determines the search type of the field. Can be text - also a input element with type text is created and select - a select element is created.")
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}

	@StrutsTagAttribute(description = "Defines if this column is hidden at initialization.", defaultValue = "false", type = "Boolean")
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	@StrutsTagAttribute(description = "If set to true this column will not appear in the modal dialog where users can choose which columns to show or hide.", defaultValue = "false", type = "Boolean")
	public void setHidedlg(String hidedlg) {
		this.hidedlg = hidedlg;
	}

	@StrutsTagAttribute(description = "Defines the alignment of the cell in the Body layer, not in header cell. Possible values: left, center, right., Default 'left'}")
	public void setAlign(String align) {
		this.align = align;
	}

	@StrutsTagAttribute(description = "Defines various options for form editing. e.g. { label:'My Label', elmprefix:'(*)', rowpos:1, colpos:2 }")
	public void setFormoptions(String formoptions) {
		this.formoptions = formoptions;
	}

	@StrutsTagAttribute(description = "The default value for the search field. This option is used only in Custom Searching and will be set as initial search.")
	public void setDefval(String defval) {
		this.defval = defval;
	}

	@StrutsTagAttribute(description = "Valid only in Custom Searching and edittype : 'select' and describes the url from where we can get already-constructed select element")
	public void setSurl(String surl) {
		this.surl = surl;
	}

}
