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

import com.jgeppert.struts2.jquery.components.Anchor;
import com.jgeppert.struts2.jquery.components.Grid;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see Anchor
 */
public class GridTag extends AbstractRemoteTag {

  private static final long serialVersionUID = 2134613468009192567L;

  protected String          width;
  protected String          height;
  protected String          pager;
  protected String          rowNum;
  protected String          sortname;
  protected String          viewrecords;
  protected String          sortorder;
  protected String          loadonce;
  protected String          multiselect;
  protected String          editurl;
  protected String          editinline;
  protected String          caption;
  protected String          shrinkToFit;
  protected String          gridModel;
  protected String          rowList;
  protected String          scroll;
  protected String          navigator;
  protected String          navigatorEditOptions;
  protected String          navigatorAddOptions;
  protected String          navigatorDeleteOptions;
  protected String          navigatorSearchOptions;
  protected String          navigatorViewOptions;
  protected String          navigatorAdd;
  protected String          navigatorDelete;
  protected String          navigatorEdit;
  protected String          navigatorRefresh;
  protected String          navigatorSearch;
  protected String          navigatorView;
  protected String          autoencode;
  protected String          cellEdit;
  protected String          cellurl;
  protected String          footerrow;
  protected String          hiddengrid;
  protected String          hidegrid;
  protected String          hoverrows;
  protected String          rownumbers;
  protected String          multiselectWidth;
  protected String          page;
  protected String          scrollrows;
  protected String          filter;
  protected String          subGridWidth;
  protected String          subGridUrl;
  protected String          userDataOnFooter;
  protected String          filterOptions;

  protected String          onSelectRowTopics;
  protected String          onPagingTopics;
  protected String          onSortColTopics;
  protected String          onCellSelectTopics;
  protected String          onGridCompleteTopics;

  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new Grid(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();

    Grid grid = (Grid) component;
    grid.setWidth(width);
    grid.setHeight(height);
    grid.setPager(pager);
    grid.setRowNum(rowNum);
    grid.setSortname(sortname);
    grid.setViewrecords(viewrecords);
    grid.setSortorder(sortorder);
    grid.setLoadonce(loadonce);
    grid.setMultiselect(multiselect);
    grid.setEditurl(editurl);
    grid.setEditinline(editinline);
    grid.setCaption(caption);
    grid.setGridModel(gridModel);
    grid.setShrinkToFit(shrinkToFit);
    grid.setRowList(rowList);
    grid.setScroll(scroll);
    grid.setNavigator(navigator);
    grid.setNavigatorAddOptions(navigatorAddOptions);
    grid.setNavigatorEditOptions(navigatorEditOptions);
    grid.setNavigatorDeleteOptions(navigatorDeleteOptions);
    grid.setNavigatorViewOptions(navigatorViewOptions);
    grid.setNavigatorSearchOptions(navigatorSearchOptions);
    grid.setNavigatorAdd(navigatorAdd);
    grid.setNavigatorEdit(navigatorEdit);
    grid.setNavigatorDelete(navigatorDelete);
    grid.setNavigatorView(navigatorView);
    grid.setNavigatorSearch(navigatorSearch);
    grid.setNavigatorRefresh(navigatorRefresh);
    grid.setAutoencode(autoencode);
    grid.setCellEdit(cellEdit);
    grid.setCellurl(cellurl);
    grid.setFooterrow(footerrow);
    grid.setHiddengrid(hiddengrid);
    grid.setHidegrid(hidegrid);
    grid.setHoverrows(hoverrows);
    grid.setRownumbers(rownumbers);
    grid.setMultiselectWidth(multiselectWidth);
    grid.setPage(page);
    grid.setScrollrows(scrollrows);
    grid.setFilter(filter);
    grid.setOnSelectRowTopics(onSelectRowTopics);
    grid.setOnSortColTopics(onSortColTopics);
    grid.setOnPagingTopics(onPagingTopics);
    grid.setOnGridCompleteTopics(onGridCompleteTopics);
    grid.setOnCellSelectTopics(onCellSelectTopics);
    grid.setSubGridUrl(subGridUrl);
    grid.setSubGridWidth(subGridWidth);
    grid.setUserDataOnFooter(userDataOnFooter);
    grid.setFilterOptions(filterOptions);
  }

  public void setWidth(String width)
  {
    this.width = width;
  }

  public void setHeight(String height)
  {
    this.height = height;
  }

  public void setPager(String pager)
  {
    this.pager = pager;
  }

  public void setRowNum(String rowNum)
  {
    this.rowNum = rowNum;
  }

  public void setSortname(String sortname)
  {
    this.sortname = sortname;
  }

  public void setViewrecords(String viewrecords)
  {
    this.viewrecords = viewrecords;
  }

  public void setSortorder(String sortorder)
  {
    this.sortorder = sortorder;
  }

  public void setLoadonce(String loadonce)
  {
    this.loadonce = loadonce;
  }

  public void setMultiselect(String multiselect)
  {
    this.multiselect = multiselect;
  }

  public void setEditurl(String editurl)
  {
    this.editurl = editurl;
  }

  public void setCaption(String caption)
  {
    this.caption = caption;
  }

  public void setShrinkToFit(String shrinkToFit)
  {
    this.shrinkToFit = shrinkToFit;
  }

  public void setGridModel(String gridModel)
  {
    this.gridModel = gridModel;
  }

  public void setRowList(String rowList)
  {
    this.rowList = rowList;
  }

  public void setScroll(String scroll)
  {
    this.scroll = scroll;
  }

  public void setNavigator(String navigator)
  {
    this.navigator = navigator;
  }

  public void setNavigatorEditOptions(String navigatorEditOptions)
  {
    this.navigatorEditOptions = navigatorEditOptions;
  }

  public void setNavigatorAddOptions(String navigatorAddOptions)
  {
    this.navigatorAddOptions = navigatorAddOptions;
  }

  public void setNavigatorDeleteOptions(String navigatorDeleteOptions)
  {
    this.navigatorDeleteOptions = navigatorDeleteOptions;
  }

  public void setNavigatorSearchOptions(String navigatorSearchOptions)
  {
    this.navigatorSearchOptions = navigatorSearchOptions;
  }

  public void setNavigatorViewOptions(String navigatorViewOptions)
  {
    this.navigatorViewOptions = navigatorViewOptions;
  }

  public void setAutoencode(String autoencode)
  {
    this.autoencode = autoencode;
  }

  public void setCellEdit(String cellEdit)
  {
    this.cellEdit = cellEdit;
  }

  public void setCellurl(String cellurl)
  {
    this.cellurl = cellurl;
  }

  public void setFooterrow(String footerrow)
  {
    this.footerrow = footerrow;
  }

  public void setHiddengrid(String hiddengrid)
  {
    this.hiddengrid = hiddengrid;
  }

  public void setHidegrid(String hidegrid)
  {
    this.hidegrid = hidegrid;
  }

  public void setHoverrows(String hoverrows)
  {
    this.hoverrows = hoverrows;
  }

  public void setRownumbers(String rownumbers)
  {
    this.rownumbers = rownumbers;
  }

  public void setMultiselectWidth(String multiselectWidth)
  {
    this.multiselectWidth = multiselectWidth;
  }

  public void setPage(String page)
  {
    this.page = page;
  }

  public void setScrollrows(String scrollrows)
  {
    this.scrollrows = scrollrows;
  }

  public void setNavigatorAdd(String navigatorAdd)
  {
    this.navigatorAdd = navigatorAdd;
  }

  public void setNavigatorDelete(String navigatorDelete)
  {
    this.navigatorDelete = navigatorDelete;
  }

  public void setNavigatorEdit(String navigatorEdit)
  {
    this.navigatorEdit = navigatorEdit;
  }

  public void setNavigatorRefresh(String navigatorRefresh)
  {
    this.navigatorRefresh = navigatorRefresh;
  }

  public void setNavigatorSearch(String navigatorSearch)
  {
    this.navigatorSearch = navigatorSearch;
  }

  public void setNavigatorView(String navigatorView)
  {
    this.navigatorView = navigatorView;
  }

  public void setFilter(String filter)
  {
    this.filter = filter;
  }

  public void setOnSelectRowTopics(String onSelectRowTopics)
  {
    this.onSelectRowTopics = onSelectRowTopics;
  }

  public void setOnPagingTopics(String onPagingTopics)
  {
    this.onPagingTopics = onPagingTopics;
  }

  public void setOnSortColTopics(String onSortColTopics)
  {
    this.onSortColTopics = onSortColTopics;
  }

  public void setOnCellSelectTopics(String onCellSelectTopics)
  {
    this.onCellSelectTopics = onCellSelectTopics;
  }

  public void setOnGridCompleteTopics(String onGridCompleteTopics)
  {
    this.onGridCompleteTopics = onGridCompleteTopics;
  }

  public void setEditinline(String editinline)
  {
    this.editinline = editinline;
  }

  public void setSubGridWidth(String subGridWidth)
  {
    this.subGridWidth = subGridWidth;
  }

  public void setSubGridUrl(String subGridUrl)
  {
    this.subGridUrl = subGridUrl;
  }

  public void setUserDataOnFooter(String userDataOnFooter)
  {
    this.userDataOnFooter = userDataOnFooter;
  }

  public void setFilterOptions(String filterOptions)
  {
    this.filterOptions = filterOptions;
  }
}
