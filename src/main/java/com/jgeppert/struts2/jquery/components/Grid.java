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
  protected String                      sortorder;
  protected String                      loadonce;
  protected String                      multiselect;
  protected String                      editurl;
  protected String                      caption;

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
    if (sortname != null) addParameter("sortname", findString(sortname));
    if (viewrecords != null) addParameter("viewrecords", findValue(this.viewrecords, Boolean.class));
    if (sortorder != null) addParameter("sortorder", findString(sortorder));
    if (loadonce != null) addParameter("loadonce", findValue(this.loadonce, Boolean.class));
    if (multiselect != null) addParameter("multiselect", findValue(this.multiselect, Boolean.class));
    if (editurl != null) addParameter("editurl", findString(editurl));
    if (caption != null) addParameter("caption", findString(caption));

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

  @StrutsTagAttribute(name = "onBeforeTopics", description = "Topics that are published before a load", type = "String", defaultValue = "")
  public void setOnBeforeTopics(String onBeforeTopics)
  {
    this.onBeforeTopics = onBeforeTopics;
  }

  @StrutsTagAttribute(name = "onAlwaysTopics", description = "A comma delimited list of topics that published always", type = "String", defaultValue = "")
  public void setOnAlwaysTopics(String onAlwaysTopics)
  {
    this.onAlwaysTopics = onAlwaysTopics;
  }

  @StrutsTagAttribute(name = "onChangeTopics", description = "A comma delimited list of topics that published when the element changed", type = "String", defaultValue = "")
  public void setOnChangeTopics(String onChangeTopics)
  {
    this.onChangeTopics = onChangeTopics;
  }

  @StrutsTagAttribute(description = "")
  public void setWidth(String width)
  {
    this.width = width;
  }

  @StrutsTagAttribute(description = "")
  public void setHeight(String height)
  {
    this.height = height;
  }

  @StrutsTagAttribute(description = "")
  public void setPager(String pager)
  {
    this.pager = pager;
  }

  @StrutsTagAttribute(description = "")
  public void setRowNum(String rowNum)
  {
    this.rowNum = rowNum;
  }

  @StrutsTagAttribute(description = "")
  public void setSortname(String sortname)
  {
    this.sortname = sortname;
  }

  @StrutsTagAttribute(description = "", defaultValue = "false", type = "Boolean")
  public void setViewrecords(String viewrecords)
  {
    this.viewrecords = viewrecords;
  }

  @StrutsTagAttribute(description = "")
  public void setSortorder(String sortorder)
  {
    this.sortorder = sortorder;
  }

  @StrutsTagAttribute(description = "", defaultValue = "false", type = "Boolean")
  public void setLoadonce(String loadonce)
  {
    this.loadonce = loadonce;
  }

  @StrutsTagAttribute(description = "", defaultValue = "false", type = "Boolean")
  public void setMultiselect(String multiselect)
  {
    this.multiselect = multiselect;
  }

  @StrutsTagAttribute(description = "")
  public void setEditurl(String editurl)
  {
    this.editurl = editurl;
  }

  @StrutsTagAttribute(description = "")
  public void setCaption(String caption)
  {
    this.caption = caption;
  }
}
