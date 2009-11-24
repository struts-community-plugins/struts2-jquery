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
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 */
@StrutsTag(name = "grid", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.GridTag", description = "Render an grid from a List.")
public class Grid extends AbstractRemoteBean {

  final private static transient Random RANDOM         = new Random();
  public static final String            JQUERYACTION   = "grid";
  public static final String            TEMPLATE       = "grid";
  public static final String            TEMPLATE_CLOSE = "grid-close";
  public static final String            COMPONENT_NAME = Grid.class.getName();

  protected String                      width;
  protected String                      height;
  protected String                      pager;
  protected String                      rowNum;
  protected String                      sortname;
  protected String                      viewrecords;
  protected String                      sortable;
  protected String                      sortorder;
  protected String                      loadonce;
  protected String                      multiselect;
  protected String                      editurl;
  protected String                      caption;
  protected String                      shrinkToFit;
  protected String                      gridModel;

  public Grid(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  public String getDefaultOpenTemplate()
  {
    return TEMPLATE;
  }

  protected String getDefaultTemplate()
  {
    return TEMPLATE_CLOSE;
  }

  public void evaluateExtraParams()
  {
    super.evaluateExtraParams();

    addParameter("jqueryaction", JQUERYACTION);

    if (width != null) addParameter("width", findString(width));
    if (height != null) addParameter("height", findString(height));
    if (pager != null) addParameter("pager", findString(pager));
    if (rowNum != null) addParameter("rowNum", findString(rowNum));
    if (sortable != null) addParameter("sortable", findValue(this.sortable, Boolean.class));
    if (sortname != null) addParameter("sortname", findString(sortname));
    if (viewrecords != null) addParameter("viewrecords", findValue(this.viewrecords, Boolean.class));
    if (sortorder != null) addParameter("sortorder", findString(sortorder));
    if (loadonce != null) addParameter("loadonce", findValue(this.loadonce, Boolean.class));
    if (multiselect != null) addParameter("multiselect", findValue(this.multiselect, Boolean.class));
    if (editurl != null) addParameter("editurl", findString(editurl));
    if (caption != null) addParameter("caption", findString(caption));
    if (shrinkToFit != null) addParameter("shrinkToFit", findValue(this.shrinkToFit, Boolean.class));
    if (gridModel != null) addParameter("gridModel", findString(gridModel));

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "grid_" + String.valueOf(nextInt);
      addParameter("id", this.id);
    }
  }

  @Override
  @StrutsTagSkipInheritance
  public void setTheme(String theme)
  {
    super.setTheme(theme);
  }

  @Override
  public String getTheme()
  {
    return "jquery";
  }

  @StrutsTagAttribute(description = "If this option is not set, the width of the grid is a sum of the widths of the columns defined in the colModel (in pixels). If this option is set, the initial width of each column is set according to the value of shrinkToFit option.")
  public void setWidth(String width)
  {
    this.width = width;
  }

  @StrutsTagAttribute(description = "The height of the grid. Can be set as number e.g. 400. Default: auto")
  public void setHeight(String height)
  {
    this.height = height;
  }

  @StrutsTagAttribute(description = "Defines that we want to use a pager bar to navigate through the records. This must be a valid html element; in our example we gave the div the id of pager. Note that the Navigation layer (the pager div) can be positioned anywhere you want, determined by your html.")
  public void setPager(String pager)
  {
    this.pager = pager;
  }

  @StrutsTagAttribute(description = "Sets how many records we want to view in the grid. This parameter is passed to the url for use by the server routine retrieving the data. Note that if you set this parameter to 10 (i.e. retrieve 10 records) and your server return 15 then only 10 records will be loaded. Set this parameter to -1 (unlimited) to disable this checking. Default: 20")
  public void setRowNum(String rowNum)
  {
    this.rowNum = rowNum;
  }

  @StrutsTagAttribute(description = "The initial sorting name. This parameter is added to the url. If set and the index (name) match the name from colModel then to this column by default is added a image sorting icon, according to the parameter sortorder (below).")
  public void setSortname(String sortname)
  {
    this.sortname = sortname;
  }

  @StrutsTagAttribute(description = "Defines whether we want to display the number of total records from the query in the pager bar.", defaultValue = "false", type = "Boolean")
  public void setViewrecords(String viewrecords)
  {
    this.viewrecords = viewrecords;
  }

  @StrutsTagAttribute(description = "The initial sorting order.This parameter is added to the url - see prnNames. Two possible values - asc or desc. Default asc")
  public void setSortorder(String sortorder)
  {
    this.sortorder = sortorder;
  }

  @StrutsTagAttribute(description = "If this flag is set to true, the grid loads the data from the server only once. After the first request all further manipulations are done on the client side. The functions of the pager (if present) are disabled.", defaultValue = "false", type = "Boolean")
  public void setLoadonce(String loadonce)
  {
    this.loadonce = loadonce;
  }

  @StrutsTagAttribute(description = "If this flag is set to true a multi selection of rows is enabled. A new column at left side is added.", defaultValue = "false", type = "Boolean")
  public void setMultiselect(String multiselect)
  {
    this.multiselect = multiselect;
  }

  @StrutsTagAttribute(description = "Defines the url for inline and form editing.")
  public void setEditurl(String editurl)
  {
    this.editurl = editurl;
  }

  @StrutsTagAttribute(description = "Defines the Caption layer for the grid. This caption appear above the Header layer. If the string is empty the caption does not appear.")
  public void setCaption(String caption)
  {
    this.caption = caption;
  }

  @StrutsTagAttribute(description = "When enabled this option allow column reordering with mouse.", defaultValue = "false", type = "Boolean")
  public void setSortable(String sortable) 
  {
	this.sortable = sortable;
  }

  @StrutsTagAttribute(description = "This option describes the type of calculation of the initial width of each column against with the width of the grid. If the value is true and the value in width option is set then: Every column width is scaled according to the defined option width.", defaultValue = "true", type = "Boolean")
  public void setShrinkToFit(String shrinkToFit) {
	this.shrinkToFit = shrinkToFit;
  }

  @StrutsTagAttribute(description = "Name of you grid model. Must be a JqueryGridModel", required=true)
  public void setGridModel(String gridModel) {
	this.gridModel = gridModel;
  }
}
