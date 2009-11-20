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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc --> Renders a column for the grid <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 */
@StrutsTag(name = "gridColumn", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.GridColumnTag", description = "Renders a column for the grid")
public class GridColumn extends AbstractRemoteBean {

  public static final String TEMPLATE       = "gridcolumn";
  public static final String TEMPLATE_CLOSE = "gridcolumn-close";
  public static final String COMPONENT_NAME = GridColumn.class.getName();

  protected String           name;
  protected String           title;
  protected String           index;
  protected String           width;
  protected String           editable;
  protected String           editoptions;

  public GridColumn(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

    if (name != null) addParameter("name", findString(name));
    if (title != null) addParameter("title", findString(title));
    if (index != null) addParameter("index", findString(index));
    if (width != null) addParameter("width", findString(width));
    if (editable != null) addParameter("editable", findValue(this.editable, Boolean.class));
    if (editoptions != null) addParameter("editoptions", findString(editoptions));
    
    Grid grid = (Grid) findAncestor(Grid.class);
    if (grid != null)
    {
      if (grid != null) addParameter("grid", grid.getId());
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

  @StrutsTagAttribute(description = "", required=true)
  public void setName(String name)
  {
    this.name = name;
  }

  @StrutsTagAttribute(description = "")
  public void setTitle(String title)
  {
    this.title = title;
  }

  @StrutsTagAttribute(description = "")
  public void setIndex(String index)
  {
    this.index = index;
  }

  @StrutsTagAttribute(description = "")
  public void setWidth(String width)
  {
    this.width = width;
  }

  @StrutsTagAttribute(description = "", defaultValue = "false", type = "Boolean")
  public void setEditable(String editable)
  {
    this.editable = editable;
  }

  @StrutsTagAttribute(description = "")
  public void setEditoptions(String editoptions)
  {
    this.editoptions = editoptions;
  }

}
