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

package com.jgeppert.struts2.jquery.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.components.GridColumn;
import com.opensymphony.xwork2.util.ValueStack;

public class GridColumnTag extends AbstractRemoteTag {

  private static final long serialVersionUID = 7618322146696075561L;
  protected String          name;
  protected String          title;
  protected String          index;
  protected String          width;
  protected String          editable;
  protected String          editoptions;
  protected String          edittype;
  protected String          editrules;
  protected String          formatter;
  protected String          formatoptions;
  protected String          sortable;
  protected String          resizable;
  protected String          key;
  protected String          search;
  protected String          searchoptions;
  protected String          hidden;
  protected String          hidedlg;
  protected String          align;
  protected String          formoptions;
  protected String          defval;
  protected String          surl;

  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new GridColumn(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();

    GridColumn gc = (GridColumn) component;
    gc.setName(name);
    gc.setTitle(title);
    gc.setIndex(index);
    gc.setWidth(width);
    gc.setEditable(editable);
    gc.setEditoptions(editoptions);
    gc.setEdittype(edittype);
    gc.setEditrules(editrules);
    gc.setFormatter(formatter);
    gc.setFormatoptions(formatoptions);
    gc.setSortable(sortable);
    gc.setResizable(resizable);
    gc.setKey(key);
    gc.setSearch(search);
    gc.setSearchoptions(searchoptions);
    gc.setHidden(hidden);
    gc.setHidedlg(hidedlg);
    gc.setAlign(align);
    gc.setFormoptions(formoptions);
    gc.setDefval(defval);
    gc.setSurl(surl);
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setIndex(String index)
  {
    this.index = index;
  }

  public void setWidth(String width)
  {
    this.width = width;
  }

  public void setEditable(String editable)
  {
    this.editable = editable;
  }

  public void setEditoptions(String editoptions)
  {
    this.editoptions = editoptions;
  }

  public void setEdittype(String edittype)
  {
    this.edittype = edittype;
  }

  public void setEditrules(String editrules)
  {
    this.editrules = editrules;
  }

  public void setFormatter(String formatter)
  {
    this.formatter = formatter;
  }

  public void setFormatoptions(String formatoptions)
  {
    this.formatoptions = formatoptions;
  }

  public void setSortable(String sortable)
  {
    this.sortable = sortable;
  }

  public void setResizable(String resizable)
  {
    this.resizable = resizable;
  }

  public void setKey(String key)
  {
    this.key = key;
  }

  public void setSearch(String search)
  {
    this.search = search;
  }

  public void setSearchoptions(String searchoptions)
  {
    this.searchoptions = searchoptions;
  }

  public void setHidden(String hidden)
  {
    this.hidden = hidden;
  }

  public void setHidedlg(String hidedlg)
  {
    this.hidedlg = hidedlg;
  }

  public void setAlign(String align)
  {
    this.align = align;
  }

  public void setFormoptions(String formoptions)
  {
    this.formoptions = formoptions;
  }

  public void setDefval(String defval)
  {
    this.defval = defval;
  }

  public void setSurl(String surl)
  {
    this.surl = surl;
  }

}
