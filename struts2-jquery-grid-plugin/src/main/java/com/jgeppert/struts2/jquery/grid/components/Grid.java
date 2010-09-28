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

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.AbstractRemoteBean;
import com.jgeppert.struts2.jquery.components.DraggableBean;
import com.jgeppert.struts2.jquery.components.DroppableBean;
import com.jgeppert.struts2.jquery.components.ResizableBean;
import com.jgeppert.struts2.jquery.components.SortableBean;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render an grid from a JSON Result.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples:
 * </p>
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "grid", tldTagClass = "com.jgeppert.struts2.jquery.grid.views.jsp.ui.GridTag", description = "Render an grid from a JSON Result.")
public class Grid extends AbstractRemoteBean implements ResizableBean, DroppableBean, DraggableBean, SortableBean {

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
  protected String                      multiboxonly;
  protected String                      editurl;
  protected String                      editinline;
  protected String                      caption;
  protected String                      shrinkToFit;
  protected String                      gridModel;
  protected String                      rowList;
  protected String                      scroll;
  protected String                      navigator;
  protected String                      navigatorEditOptions;
  protected String                      navigatorAddOptions;
  protected String                      navigatorDeleteOptions;
  protected String                      navigatorSearchOptions;
  protected String                      navigatorViewOptions;
  protected String                      navigatorAdd;
  protected String                      navigatorDelete;
  protected String                      navigatorEdit;
  protected String                      navigatorRefresh;
  protected String                      navigatorSearch;
  protected String                      navigatorView;
  protected String                      autoencode;
  protected String                      cellEdit;
  protected String                      cellurl;
  protected String                      footerrow;
  protected String                      hiddengrid;
  protected String                      hidegrid;
  protected String                      hoverrows;
  protected String                      rownumbers;
  protected String                      multiselectWidth;
  protected String                      page;
  protected String                      scrollrows;
  protected String                      filter;
  protected String                      subGridWidth;
  protected String                      subGridUrl;
  protected String                      userDataOnFooter;
  protected String                      filterOptions;
  protected String                      altClass;
  protected String                      altRows;
  protected String                      prmNames;
  protected String                      direction;
  protected String                      recordpos;
  protected String                      rowTotal;

  protected String                      onSelectRowTopics;
  protected String                      onSelectAllTopics;
  protected String                      onPagingTopics;
  protected String                      onSortColTopics;
  protected String                      onCellSelectTopics;
  protected String                      onGridCompleteTopics;
  protected String                      reloadTopics;

  protected String                      resizable;
  protected String                      resizableAnimate;
  protected String                      resizableAnimateDuration;
  protected String                      resizableAnimateEasing;
  protected String                      resizableAspectRatio;
  protected String                      resizableAutoHide;
  protected String                      resizableContainment;
  protected String                      resizableDelay;
  protected String                      resizableDistance;
  protected String                      resizableGhost;
  protected String                      resizableHelper;
  protected String                      resizableMaxHeight;
  protected String                      resizableMaxWidth;
  protected String                      resizableMinHeight;
  protected String                      resizableMinWidth;
  protected String                      resizableHandles;
  protected String                      resizableOnResizeTopics;
  protected String                      resizableOnStartTopics;
  protected String                      resizableOnStopTopics;

  protected String                      droppable;
  protected String                      droppableAccept;
  protected String                      droppableActiveClass;
  protected String                      droppableAddClasses;
  protected String                      droppableGreedy;
  protected String                      droppableHoverClass;
  protected String                      droppableScope;
  protected String                      droppableTolerance;

  protected String                      droppableOnActivateTopics;
  protected String                      droppableOnDeactivateTopics;
  protected String                      droppableOnDropTopics;
  protected String                      droppableOnOutTopics;
  protected String                      droppableOnOverTopics;

  protected String                      draggable;
  protected String                      draggableAppendTo;
  protected String                      draggableAxis;
  protected String                      draggableCancel;
  protected String                      draggableCursor;
  protected String                      draggableContainment;
  protected String                      draggableDelay;
  protected String                      draggableDistance;
  protected String                      draggableHandle;
  protected String                      draggableHelper;
  protected String                      draggableIframeFix;
  protected String                      draggableOpacity;
  protected String                      draggableRefreshPositions;
  protected String                      draggableRevert;
  protected String                      draggableRevertDuration;
  protected String                      draggableScope;
  protected String                      draggableScroll;
  protected String                      draggableScrollSensitivity;
  protected String                      draggableScrollSpeed;
  protected String                      draggableSnap;
  protected String                      draggableSnapMode;
  protected String                      draggableSnapTolerance;
  protected String                      draggableZindex;
  protected String                      draggableAddClasses;

  protected String                      draggableOnDragTopics;
  protected String                      draggableOnStartTopics;
  protected String                      draggableOnStopTopics;

  protected String                      sortableZindex;
  protected String                      sortableTolerance;
  protected String                      sortableScrollSpeed;
  protected String                      sortableScrollSensitivity;
  protected String                      sortableScroll;
  protected String                      sortableRevert;
  protected String                      sortablePlaceholder;
  protected String                      sortableOpacity;
  protected String                      sortableItems;
  protected String                      sortableHelper;
  protected String                      sortableHandle;
  protected String                      sortableGrid;
  protected String                      sortableForcePlaceholderSize;
  protected String                      sortableForceHelperSize;
  protected String                      sortableDropOnEmpty;
  protected String                      sortableDistance;
  protected String                      sortableDelay;
  protected String                      sortableCursorAt;
  protected String                      sortableCursor;
  protected String                      sortableContainment;
  protected String                      sortableConnectWith;
  protected String                      sortableCancel;
  protected String                      sortableAxis;
  protected String                      sortableAppendTo;
  protected String                      sortable;
  protected String                      sortableOnBeforeStopTopics;
  protected String                      sortableOnStopTopics;
  protected String                      sortableOnStartTopics;
  protected String                      sortableOnSortTopics;
  protected String                      sortableOnActivateTopics;
  protected String                      sortableOnDeactivateTopics;
  protected String                      sortableOnOverTopics;
  protected String                      sortableOnOutTopics;
  protected String                      sortableOnRemoveTopics;
  protected String                      sortableOnReceiveTopics;
  protected String                      sortableOnChangeTopics;
  protected String                      sortableOnUpdateTopics;

  protected String                      connectWith;

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
    if (sortname != null) addParameter("sortname", findString(sortname));
    if (viewrecords != null) addParameter("viewrecords", findValue(this.viewrecords, Boolean.class));
    if (sortorder != null) addParameter("sortorder", findString(sortorder));
    if (loadonce != null) addParameter("loadonce", findValue(this.loadonce, Boolean.class));
    if (multiselect != null) addParameter("multiselect", findValue(this.multiselect, Boolean.class));
    if (multiboxonly != null) addParameter("multiboxonly", findValue(this.multiboxonly, Boolean.class));
    if (editurl != null) addParameter("editurl", findString(editurl));
    if (editinline != null) addParameter("editinline", findValue(this.editinline, Boolean.class));
    if (caption != null) addParameter("caption", findString(caption));
    if (shrinkToFit != null) addParameter("shrinkToFit", findValue(this.shrinkToFit, Boolean.class));
    if (gridModel != null) addParameter("gridModel", findString(gridModel));
    if (scroll != null) addParameter("scroll", findString(scroll));
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
    if (prmNames != null) addParameter("prmNames", findString(prmNames));
    if (direction != null) addParameter("direction", findString(direction));
    if (recordpos != null) addParameter("recordpos", findString(recordpos));
    if (rowTotal != null) addParameter("rowTotal", findValue(this.rowTotal, Integer.class));

    if (onSelectRowTopics != null) addParameter("onSelectRowTopics", findString(onSelectRowTopics));
    if (onSelectAllTopics != null) addParameter("onSelectAllTopics", findString(onSelectAllTopics));
    if (onCellSelectTopics != null) addParameter("onCellSelectTopics", findString(onCellSelectTopics));
    if (onPagingTopics != null) addParameter("onPagingTopics", findString(onPagingTopics));
    if (onSortColTopics != null) addParameter("onSortColTopics", findString(onSortColTopics));
    if (onGridCompleteTopics != null) addParameter("onGridCompleteTopics", findString(onGridCompleteTopics));
    if (reloadTopics != null) addParameter("reloadTopics", findString(reloadTopics));

    if (connectWith != null) addParameter("connectWith", findString(connectWith));

    if (resizable != null)
    {
      String resizableValue = findString(resizable);
      if (resizableValue != null && resizableValue.equalsIgnoreCase("true")) ;
      {
        addParameter("resizable", Boolean.TRUE);
        StringBuilder resizableBuilder = new StringBuilder();
        resizableBuilder.append("{");
        if (resizableAnimate != null)
        {
          resizableBuilder.append(", animate: ");
          resizableBuilder.append(findString(resizableAnimate));
        };
        if (resizableAspectRatio != null)
        {
          resizableBuilder.append(", aspectRatio: ");
          resizableBuilder.append(findString(resizableAspectRatio));
        };
        if (resizableAutoHide != null)
        {
          resizableBuilder.append(", autoHide: ");
          resizableBuilder.append(findString(resizableAutoHide));
        };
        if (resizableGhost != null)
        {
          resizableBuilder.append(", ghost: ");
          resizableBuilder.append(findString(resizableGhost));
        };

        if (resizableAnimateDuration != null)
        {
          resizableBuilder.append(", animateDuration: ");
          resizableBuilder.append(findString(resizableAnimateDuration));
        };
        if (resizableDelay != null)
        {
          resizableBuilder.append(", delay: ");
          resizableBuilder.append(findString(resizableDelay));
        };
        if (resizableDistance != null)
        {
          resizableBuilder.append(", distance: ");
          resizableBuilder.append(findString(resizableDistance));
        };
        if (resizableMaxHeight != null)
        {
          resizableBuilder.append(", maxHeight: ");
          resizableBuilder.append(findString(resizableMaxHeight));
        };
        if (resizableMaxWidth != null)
        {
          resizableBuilder.append(", maxWidth: ");
          resizableBuilder.append(findString(resizableMaxWidth));
        };
        if (resizableMinHeight != null)
        {
          resizableBuilder.append(", minHeight: ");
          resizableBuilder.append(findString(resizableMinHeight));
        };
        if (resizableMinWidth != null)
        {
          resizableBuilder.append(", minWidth: ");
          resizableBuilder.append(findString(resizableMinWidth));
        };

        if (resizableAnimateEasing != null)
        {
          resizableBuilder.append(", animateEasing: '");
          resizableBuilder.append(findString(resizableAnimateEasing));
          resizableBuilder.append("' ");
        }
        if (resizableHelper != null)
        {
          resizableBuilder.append(", helper: '");
          resizableBuilder.append(findString(resizableHelper));
          resizableBuilder.append("' ");
        }
        if (resizableHandles != null)
        {
          resizableBuilder.append(", handles: '");
          resizableBuilder.append(findString(resizableHandles));
          resizableBuilder.append("' ");
        }

        if (resizableContainment != null)
        {
          resizableBuilder.append(", containment: '");
          String containmentValue = findString(resizableContainment);

          if (containmentValue.equalsIgnoreCase("parent") || containmentValue.equalsIgnoreCase("document"))
          {
            resizableBuilder.append("'");
            resizableBuilder.append(containmentValue);
          }
          else
          {
            resizableBuilder.append("'#");
            resizableBuilder.append(containmentValue);
          }
          resizableBuilder.append("'");
        }

        resizableBuilder.append(" }");
        if (resizableBuilder.charAt(1) == ',') resizableBuilder.deleteCharAt(1);

        addParameter("resizableOptions", resizableBuilder.toString());
        if (resizableOnResizeTopics != null) addParameter("resizableOnResizeTopics", findString(resizableOnResizeTopics));
        if (resizableOnStartTopics != null) addParameter("resizableOnStartTopics", findString(resizableOnStartTopics));
        if (resizableOnStopTopics != null) addParameter("resizableOnStopTopics", findString(resizableOnStopTopics));
      }
    }

    if (droppable != null && draggable != null)
    {
      String droppableValue = findString(droppable);
      if (droppableValue != null) ;
      {
        addParameter("droppable", Boolean.TRUE);
        addParameter("droppableValue", droppableValue);
        StringBuilder droppableBuilder = new StringBuilder();
        droppableBuilder.append("{");
        if (droppableAccept != null)
        {
          droppableBuilder.append(", accept: '");
          droppableBuilder.append(findString(droppableAccept));
          droppableBuilder.append("' ");
        }
        if (droppableActiveClass != null)
        {
          droppableBuilder.append(", activeClass: '");
          droppableBuilder.append(findString(droppableActiveClass));
          droppableBuilder.append("' ");
        }
        if (droppableAddClasses != null)
        {
          droppableBuilder.append(", addClasses: ");
          droppableBuilder.append(findString(droppableAddClasses));
        };
        if (droppableGreedy != null)
        {
          droppableBuilder.append(", cancel: ");
          droppableBuilder.append(findString(droppableGreedy));
        }
        if (droppableTolerance != null)
        {
          droppableBuilder.append(", tolerance: '");
          droppableBuilder.append(findString(droppableTolerance));
          droppableBuilder.append("' ");
        }
        if (droppableScope != null)
        {
          droppableBuilder.append(", scope: '");
          droppableBuilder.append(findString(droppableScope));
          droppableBuilder.append("' ");
        }
        if (droppableHoverClass != null)
        {
          droppableBuilder.append(", hoverClass: '");
          droppableBuilder.append(findString(droppableHoverClass));
          droppableBuilder.append("' ");
        }

        droppableBuilder.append(" }");
        if (droppableBuilder.charAt(1) == ',') droppableBuilder.deleteCharAt(1);
        addParameter("droppableOptions", droppableBuilder.toString());

        if (droppableOnActivateTopics != null) addParameter("droppableOnActivateTopics", findString(droppableOnActivateTopics));
        if (droppableOnDeactivateTopics != null) addParameter("droppableOnDeactivateTopics", findString(droppableOnDeactivateTopics));
        if (droppableOnOverTopics != null) addParameter("droppableOnOverTopics", findString(droppableOnOverTopics));
        if (droppableOnOutTopics != null) addParameter("droppableOnOutTopics", findString(droppableOnOutTopics));
        if (droppableOnDropTopics != null) addParameter("droppableOnDropTopics", findString(droppableOnDropTopics));
      }

      String draggableValue = findString(draggable);
      if (draggableValue != null) ;
      {
        addParameter("draggable", Boolean.TRUE);
        addParameter("draggableValue", draggableValue);
        StringBuilder draggableBuilder = new StringBuilder();
        draggableBuilder.append("{");
        if (draggableAddClasses != null)
        {
          draggableBuilder.append(", addClasses: ");
          draggableBuilder.append(findString(draggableAddClasses));
        };
        if (draggableAppendTo != null)
        {
          draggableBuilder.append(", appendTo: '");
          draggableBuilder.append(findString(draggableAppendTo));
          draggableBuilder.append("' ");
        }
        if (draggableAxis != null)
        {
          draggableBuilder.append(", axis: '");
          draggableBuilder.append(findString(draggableAxis));
          draggableBuilder.append("' ");
        }
        if (draggableCancel != null)
        {
          draggableBuilder.append(", cancel: '");
          draggableBuilder.append(findString(draggableCancel));
          draggableBuilder.append("' ");
        }
        if (draggableCursor != null)
        {
          draggableBuilder.append(", cursor: '");
          draggableBuilder.append(findString(draggableCursor));
          draggableBuilder.append("' ");
        }
        if (draggableDelay != null)
        {
          draggableBuilder.append(", delay: ");
          draggableBuilder.append(findString(draggableDelay));
        }
        if (draggableDistance != null)
        {
          draggableBuilder.append(", distance: ");
          draggableBuilder.append(findString(draggableDistance));
        }
        if (draggableHandle != null)
        {
          draggableBuilder.append(", handle: '");
          draggableBuilder.append(findString(draggableHandle));
          draggableBuilder.append("' ");
        }
        if (draggableHelper != null)
        {
          draggableBuilder.append(", helper: '");
          draggableBuilder.append(findString(draggableHelper));
          draggableBuilder.append("' ");
        }
        if (draggableIframeFix != null)
        {
          draggableBuilder.append(", iframeFix: ");
          draggableBuilder.append(findString(draggableIframeFix));
        }
        if (draggableOpacity != null)
        {
          draggableBuilder.append(", opacity: '");
          draggableBuilder.append(findString(draggableOpacity));
          draggableBuilder.append("' ");
        }
        if (draggableRefreshPositions != null)
        {
          draggableBuilder.append(", refreshPositions: ");
          draggableBuilder.append(findString(draggableRefreshPositions));
        }
        if (draggableRevertDuration != null)
        {
          draggableBuilder.append(", revertDuration: ");
          draggableBuilder.append(findString(draggableRevertDuration));
        }
        if (draggableScope != null)
        {
          draggableBuilder.append(", scope: '");
          draggableBuilder.append(findString(draggableScope));
          draggableBuilder.append("' ");
        }
        if (draggableScroll != null)
        {
          draggableBuilder.append(", scroll: ");
          draggableBuilder.append(findString(draggableScroll));
        }
        if (draggableScrollSensitivity != null)
        {
          draggableBuilder.append(", sensitivity: ");
          draggableBuilder.append(findString(draggableScrollSensitivity));
        }
        if (draggableScrollSpeed != null)
        {
          draggableBuilder.append(", scrollSpeed: true");
          draggableBuilder.append(findString(draggableScrollSpeed));
        }
        if (draggableSnap != null)
        {
          draggableBuilder.append(", snap: ");
          draggableBuilder.append(findString(draggableSnap));
        }
        if (draggableSnapMode != null)
        {
          draggableBuilder.append(", snapMode: '");
          draggableBuilder.append(findString(draggableSnapMode));
          draggableBuilder.append("' ");
        }
        if (draggableSnapTolerance != null)
        {
          draggableBuilder.append(", snapTolerance: ");
          draggableBuilder.append(findString(draggableSnapTolerance));
        }
        if (draggableZindex != null)
        {
          draggableBuilder.append(", zIndex: ");
          draggableBuilder.append(findString(draggableZindex));
        }

        if (draggableRevert != null)
        {
          draggableBuilder.append(", revert: ");
          String revertValue = findString(draggableRevert);

          if (revertValue.equalsIgnoreCase("true") || revertValue.equalsIgnoreCase("false"))
          {
            draggableBuilder.append(revertValue);
          }
          else
          {
            draggableBuilder.append("'");
            draggableBuilder.append(revertValue);
            draggableBuilder.append("'");
          }
        }
        if (draggableContainment != null)
        {
          draggableBuilder.append(", containment: '");
          String containmentValue = findString(draggableContainment);

          if (containmentValue.equalsIgnoreCase("parent") || containmentValue.equalsIgnoreCase("document") || containmentValue.equalsIgnoreCase("window"))
          {
            draggableBuilder.append(containmentValue);
          }
          else
          {
            draggableBuilder.append("#");
            draggableBuilder.append(containmentValue);
          }
          draggableBuilder.append("'");
        }

        draggableBuilder.append(" }");
        if (draggableBuilder.charAt(1) == ',') draggableBuilder.deleteCharAt(1);
        addParameter("draggableOptions", draggableBuilder.toString());

        if (draggableOnDragTopics != null) addParameter("draggableOnDragTopics", findString(draggableOnDragTopics));
        if (draggableOnStartTopics != null) addParameter("draggableOnStartTopics", findString(draggableOnStartTopics));
        if (draggableOnStopTopics != null) addParameter("draggableOnStopTopics", findString(draggableOnStopTopics));

      }
    }

    if (sortable != null)
    {
      String sortableValue = findString(sortable);
      if (sortableValue != null && sortableValue.equalsIgnoreCase("true")) ;
      {
        addParameter("sortable", Boolean.TRUE);
        StringBuilder sortableBuilder = new StringBuilder();
        sortableBuilder.append("{");
        if (sortableDropOnEmpty != null)
        {
          sortableBuilder.append(", dropOnEmpty: ");
          sortableBuilder.append(findString(sortableDropOnEmpty));
        }
        if (sortableForceHelperSize != null)
        {
          sortableBuilder.append(", forceHelperSize: ");
          sortableBuilder.append(findString(sortableForceHelperSize));
        }
        if (sortableForcePlaceholderSize != null)
        {
          sortableBuilder.append(", forcePlaceholderSize: ");
          sortableBuilder.append(findString(sortableForcePlaceholderSize));
        }
        if (sortableRevert != null)
        {
          sortableBuilder.append(", revert: ");
          sortableBuilder.append(findString(sortableRevert));
        }
        if (sortableScroll != null)
        {
          sortableBuilder.append(", scroll: ");
          sortableBuilder.append(findString(sortableScroll));
        }

        if (sortableZindex != null)
        {
          sortableBuilder.append(", zIndex: ");
          sortableBuilder.append(findString(sortableZindex));
        }
        if (sortableDelay != null)
        {
          sortableBuilder.append(", delay: ");
          sortableBuilder.append(findString(sortableDelay));
        }
        if (sortableScrollSensitivity != null)
        {
          sortableBuilder.append(", scrollSensitivity: ");
          sortableBuilder.append(findString(sortableScrollSensitivity));
        }
        if (sortableScrollSpeed != null)
        {
          sortableBuilder.append(", scrollSpeed: ");
          sortableBuilder.append(findString(sortableScrollSpeed));
        }
        if (sortableDistance != null)
        {
          sortableBuilder.append(", distance: ");
          sortableBuilder.append(findString(sortableDistance));
        }

        if (sortableTolerance != null)
        {
          sortableBuilder.append(", tolerance: '");
          sortableBuilder.append(findString(sortableTolerance));
          sortableBuilder.append("' ");
        }
        if (sortablePlaceholder != null)
        {
          sortableBuilder.append(", placeholder: '");
          sortableBuilder.append(findString(sortablePlaceholder));
          sortableBuilder.append("' ");
        }
        if (sortableOpacity != null)
        {
          sortableBuilder.append(", opacity: '");
          sortableBuilder.append(findString(sortableOpacity));
          sortableBuilder.append("' ");
        }
        if (sortableItems != null)
        {
          sortableBuilder.append(", items: '");
          sortableBuilder.append(findString(sortableItems));
          sortableBuilder.append("' ");
        }
        if (sortableHandle != null)
        {
          sortableBuilder.append(", handle: '");
          sortableBuilder.append(findString(sortableHandle));
          sortableBuilder.append("' ");
        }
        if (sortableGrid != null)
        {
          sortableBuilder.append(", grid: '");
          sortableBuilder.append(findString(sortableGrid));
          sortableBuilder.append("' ");
        }
        if (sortableCursorAt != null)
        {
          sortableBuilder.append(", cursorAt: '");
          sortableBuilder.append(findString(sortableCursorAt));
          sortableBuilder.append("' ");
        }
        if (sortableCursor != null)
        {
          sortableBuilder.append(", cursor: '");
          sortableBuilder.append(findString(sortableCursor));
          sortableBuilder.append("' ");
        }
        if (sortableConnectWith != null)
        {
          sortableBuilder.append(", connectWith: '");
          sortableBuilder.append(findString(sortableConnectWith));
          sortableBuilder.append("' ");
        }
        if (sortableAxis != null)
        {
          sortableBuilder.append(", axis: '");
          sortableBuilder.append(findString(sortableAxis));
          sortableBuilder.append("' ");
        }
        if (sortableAppendTo != null)
        {
          sortableBuilder.append(", appendTo: '");
          sortableBuilder.append(findString(sortableAppendTo));
          sortableBuilder.append("' ");
        }
        if (sortableCancel != null)
        {
          sortableBuilder.append(", cancel: '");
          sortableBuilder.append(findString(sortableCancel));
          sortableBuilder.append("' ");
        }

        if (sortableContainment != null)
        {
          sortableBuilder.append(", containment: '");
          String containmentValue = findString(sortableContainment);

          if (containmentValue.equalsIgnoreCase("parent") || containmentValue.equalsIgnoreCase("document") || containmentValue.equalsIgnoreCase("window"))
          {
            sortableBuilder.append("'");
            sortableBuilder.append(containmentValue);
          }
          else
          {
            sortableBuilder.append("'#");
            sortableBuilder.append(containmentValue);
          }
          sortableBuilder.append("'");
        }

        sortableBuilder.append(" }");
        if (sortableBuilder.charAt(1) == ',') sortableBuilder.deleteCharAt(1);
        addParameter("sortableOptions", sortableBuilder.toString());

        if (sortableOnActivateTopics != null) addParameter("sortableOnActivateTopics", findString(sortableOnActivateTopics));
        if (sortableOnUpdateTopics != null) addParameter("sortableOnUpdateTopics", findString(sortableOnUpdateTopics));
        if (sortableOnStopTopics != null) addParameter("sortableOnStopTopics", findString(sortableOnStopTopics));
        if (sortableOnStartTopics != null) addParameter("sortableOnStartTopics", findString(sortableOnStartTopics));
        if (sortableOnSortTopics != null) addParameter("sortableOnSortTopics", findString(sortableOnSortTopics));
        if (sortableOnRemoveTopics != null) addParameter("sortableOnRemoveTopics", findString(sortableOnRemoveTopics));
        if (sortableOnReceiveTopics != null) addParameter("sortableOnReceiveTopics", findString(sortableOnReceiveTopics));
        if (sortableOnOverTopics != null) addParameter("sortableOnOverTopics", findString(sortableOnOverTopics));
        if (sortableOnOutTopics != null) addParameter("sortableOnOutTopics", findString(sortableOnOutTopics));
        if (sortableOnDeactivateTopics != null) addParameter("sortableOnDeactivateTopics", findString(sortableOnDeactivateTopics));
        if (sortableOnChangeTopics != null) addParameter("sortableOnChangeTopics", findString(sortableOnChangeTopics));
        if (sortableOnBeforeStopTopics != null) addParameter("sortableOnBeforeStopTopics", findString(sortableOnBeforeStopTopics));
      }
    }

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

  @StrutsTagAttribute(description = "Defines that we want to use a pager bar to navigate through the records. This must be a true or false.", defaultValue = "false", type = "Boolean")
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

  @StrutsTagAttribute(description = "This option works only when multiselect = true. When multiselect is set to true, clicking anywhere on a row selects that row; when multiboxonly is also set to true, the multiselection is done only when the checkbox is clicked (Yahoo style). Clicking in any other row (suppose the checkbox is not clicked) deselects all rows and the current row is selected.", defaultValue = "false", type = "Boolean")
  public void setMultiboxonly(String multiboxonly)
  {
    this.multiboxonly = multiboxonly;
  }

  @StrutsTagAttribute(description = "Defines the url for inline and form editing.")
  public void setEditurl(String editurl)
  {
    this.editurl = editurl;
  }

  @StrutsTagAttribute(description = "Enable editing inline. Default: false", defaultValue = "false", type = "Boolean")
  public void setEditinline(String editinline)
  {
    this.editinline = editinline;
  }

  @StrutsTagAttribute(description = "Defines the Caption layer for the grid. This caption appear above the Header layer. If the string is empty the caption does not appear.")
  public void setCaption(String caption)
  {
    this.caption = caption;
  }

  @StrutsTagAttribute(description = "This option describes the type of calculation of the initial width of each column against with the width of the grid. If the value is true and the value in width option is set then: Every column width is scaled according to the defined option width.", defaultValue = "true", type = "Boolean")
  public void setShrinkToFit(String shrinkToFit)
  {
    this.shrinkToFit = shrinkToFit;
  }

  @StrutsTagAttribute(description = "Name of you grid model. Must be a Collection", required = true)
  public void setGridModel(String gridModel)
  {
    this.gridModel = gridModel;
  }

  @StrutsTagAttribute(description = "An array to construct a select box element in the pager in which we can change the number of the visible rows. e.g. 10,15,20")
  public void setRowList(String rowList)
  {
    this.rowList = rowList;
  }

  @StrutsTagAttribute(description = "Creates dynamic scrolling grids. When enabled, the pager elements are disabled and we can use the vertical scrollbar to load data. When set to true the grid will always hold all the items from the start through to the latest point ever visited.", defaultValue = "false")
  public void setScroll(String scroll)
  {
    this.scroll = scroll;
  }

  @StrutsTagAttribute(description = "Navigator is a method that can add predefined actions like editing, adding, deleting, and searching. This must be a true or false.", defaultValue = "false", type = "Boolean")
  public void setNavigator(String navigator)
  {
    this.navigator = navigator;
  }

  @StrutsTagAttribute(description = "Edit Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
  public void setNavigatorEditOptions(String navigatorEditOptions)
  {
    this.navigatorEditOptions = navigatorEditOptions;
  }

  @StrutsTagAttribute(description = "Add Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
  public void setNavigatorAddOptions(String navigatorAddOptions)
  {
    this.navigatorAddOptions = navigatorAddOptions;
  }

  @StrutsTagAttribute(description = "Delete Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
  public void setNavigatorDeleteOptions(String navigatorDeleteOptions)
  {
    this.navigatorDeleteOptions = navigatorDeleteOptions;
  }

  @StrutsTagAttribute(description = "Search Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
  public void setNavigatorSearchOptions(String navigatorSearchOptions)
  {
    this.navigatorSearchOptions = navigatorSearchOptions;
  }

  @StrutsTagAttribute(description = "View Options for Navigator. e.g. {sopt:['cn','bw','eq','ne','lt','gt','ew']},")
  public void setNavigatorViewOptions(String navigatorViewOptions)
  {
    this.navigatorViewOptions = navigatorViewOptions;
  }

  @StrutsTagAttribute(description = "When set to true encodes (html encode) the incoming (from server) and posted data (from editing modules). By example < will be converted to &lt;", defaultValue = "true", type = "Boolean")
  public void setAutoencode(String autoencode)
  {
    this.autoencode = autoencode;
  }

  @StrutsTagAttribute(description = "Enables (disables) cell editing. See Cell Editing for more details", defaultValue = "false", type = "Boolean")
  public void setCellEdit(String cellEdit)
  {
    this.cellEdit = cellEdit;
  }

  @StrutsTagAttribute(description = "the url where the cell is to be saved.", defaultValue = "false", type = "Boolean")
  public void setCellurl(String cellurl)
  {
    this.cellurl = cellurl;
  }

  @StrutsTagAttribute(description = "If set to true this will place a footer table with one row below the gird records and above the pager.", defaultValue = "false", type = "Boolean")
  public void setFooterrow(String footerrow)
  {
    this.footerrow = footerrow;
  }

  @StrutsTagAttribute(description = "If set to true the grid initially is hidden. The data is not loaded (no request is sent) and only the caption layer is shown. When the show/hide button is clicked the first time to show grid, the request is sent to the server, the data is loaded, and grid is shown. From this point we have a regular grid.", defaultValue = "false", type = "Boolean")
  public void setHiddengrid(String hiddengrid)
  {
    this.hiddengrid = hiddengrid;
  }

  @StrutsTagAttribute(description = "Enables or disables the show/hide grid button, which appears on the right side of the Caption layer. Takes effect only if the caption property is not an empty string.", defaultValue = "false", type = "Boolean")
  public void setHidegrid(String hidegrid)
  {
    this.hidegrid = hidegrid;
  }

  @StrutsTagAttribute(description = "When set to false the mouse hovering is disabled in the grid data rows.", defaultValue = "false", type = "Boolean")
  public void setHoverrows(String hoverrows)
  {
    this.hoverrows = hoverrows;
  }

  @StrutsTagAttribute(description = "If this option is set to true, a new column at left of the grid is added. The purpose of this column is to count the number of available rows, beginning from 1. In this case colModel is extended automatically with new element with name - 'rn'. Also, be careful not to use the name 'rn' in gridModel", defaultValue = "false", type = "Boolean")
  public void setRownumbers(String rownumbers)
  {
    this.rownumbers = rownumbers;
  }

  @StrutsTagAttribute(description = "etermines the width of the multiselect column if multiselect is set to true.")
  public void setMultiselectWidth(String multiselectWidth)
  {
    this.multiselectWidth = multiselectWidth;
  }

  @StrutsTagAttribute(description = "Set the initial number of page when we make the request.This parameter is passed to the url for use by the server routine retrieving the data", defaultValue = "1")
  public void setPage(String page)
  {
    this.page = page;
  }

  @StrutsTagAttribute(description = "When enabled, selecting a row with setSelection scrolls the grid so that the selected row is visible.", defaultValue = "false", type = "Boolean")
  public void setScrollrows(String scrollrows)
  {
    this.scrollrows = scrollrows;
  }

  @StrutsTagAttribute(description = "Enables or disables the add action in the navigator. When the button is clicked a editGridRow with parameter new method is executed", defaultValue = "true", type = "Boolean")
  public void setNavigatorAdd(String navigatorAdd)
  {
    this.navigatorAdd = navigatorAdd;
  }

  @StrutsTagAttribute(description = "Enables or disables the delete action in the navigator. When the button is clicked a delGridRow method is executed.", defaultValue = "true", type = "Boolean")
  public void setNavigatorDelete(String navigatorDelete)
  {
    this.navigatorDelete = navigatorDelete;
  }

  @StrutsTagAttribute(description = "Enables or disables the edit action in the navigator. When the button is clicked a editGridRow method is executed with parameter the - current selected row", defaultValue = "true", type = "Boolean")
  public void setNavigatorEdit(String navigatorEdit)
  {
    this.navigatorEdit = navigatorEdit;
  }

  @StrutsTagAttribute(description = "Enables or disables the refresh button in the pager. When the button is clicked a trigger(reloadGrid) is executed and the search parameters are cleared", defaultValue = "true", type = "Boolean")
  public void setNavigatorRefresh(String navigatorRefresh)
  {
    this.navigatorRefresh = navigatorRefresh;
  }

  @StrutsTagAttribute(description = "Enables or disables the search button in the pager.When the button is clicked a searchGrid method is executed", defaultValue = "true", type = "Boolean")
  public void setNavigatorSearch(String navigatorSearch)
  {
    this.navigatorSearch = navigatorSearch;
  }

  @StrutsTagAttribute(description = "Enables or disables the view button in the pager. When the button is clicked a viewGridRow method is executed", defaultValue = "false", type = "Boolean")
  public void setNavigatorView(String navigatorView)
  {
    this.navigatorView = navigatorView;
  }

  @StrutsTagAttribute(description = "This method construct searching creating input elements just below the header elements of the grid.", defaultValue = "false", type = "Boolean")
  public void setFilter(String filter)
  {
    this.filter = filter;
  }

  @StrutsTagAttribute(description = "Determines the width of the subGrid column if subgrid is enabled.")
  public void setSubGridWidth(String subGridWidth)
  {
    this.subGridWidth = subGridWidth;
  }

  @StrutsTagAttribute(description = "This option has effect only if subGrid option is set to true. This option points to the file from which we get the data for the subgrid. jqGrid adds the id of the row to this url as parameter.")
  public void setSubGridUrl(String subGridUrl)
  {
    this.subGridUrl = subGridUrl;
  }

  @StrutsTagAttribute(description = "When set to true we directly place the user data array userData at footer. The rules are as follow: If the userData array contain name which is equal to those of colModel then the value is placed in that column.If there are no such values nothing is palced. Note that if this option is used we use the current formatter options (if available) for that column.")
  public void setUserDataOnFooter(String userDataOnFooter)
  {
    this.userDataOnFooter = userDataOnFooter;
  }

  @StrutsTagAttribute(description = "Options for Filter Settings as JavaScript Object. e.g. { autosearch : false, formtype : vertical }")
  public void setFilterOptions(String filterOptions)
  {
    this.filterOptions = filterOptions;
  }

  @StrutsTagAttribute(description = "The class that is used for alternate rows. You can construct your own class and replace this value. This option is valid only if altRows options is set to true", defaultValue = "ui-priority-secondary")
  public void setAltClass(String altClass)
  {
    this.altClass = altClass;
  }

  @StrutsTagAttribute(description = "Set a zebra-striped grid", defaultValue = "false", type = "Boolean")
  public void setAltRows(String altRows)
  {
    this.altRows = altRows;
  }

  @StrutsTagAttribute(description = "Customizes names of the fields sent to the server on a Post. When some parameter is set to null they will be not sended to the server.", defaultValue = "{page:\"page\",rows:\"rows\", sort: \"sidx\",order: \"sord\", search:\"_search\", nd:\"nd\", id:\"id\",oper:\"oper\",editoper:\"edit\",addoper:\"add\",deloper:\"del\"}")
  public void setPrmNames(String prmNames)
  {
    this.prmNames = prmNames;
  }

  @StrutsTagAttribute(description = "Determines the language direction in grid. The default is 'ltr' (Left To Right language). When set to 'rtl' (Right To Left) the grid automatically do the needed.", defaultValue = "ltr")
  public void setDirection(String direction)
  {
    this.direction = direction;
  }

  @StrutsTagAttribute(description = "Determines the position of the record information in the pager. Can be left, center, right", defaultValue = "right")
  public void setRecordpos(String recordpos)
  {
    this.recordpos = recordpos;
  }

  @StrutsTagAttribute(description = "When set this parameter can instruct the server to load the total number of rows needed to work on. Note that rowNum determines the total records displayed in the grid, while rowTotal the total rows on which we operate. When this parameter is set we send a additional parameter to server named totalrows. You can check for this parameter and if it is available you can replace the rows parameter with this one. Mostly this parameter can be combined wit loadonce parameter set to true.", defaultValue = "null", type = "Integer")
  public void setRowTotal(String rowTotal)
  {
    this.rowTotal = rowTotal;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when a row is selected")
  public void setOnSelectRowTopics(String onSelectRowTopics)
  {
    this.onSelectRowTopics = onSelectRowTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when multiselect option is true and you click on the header checkbox.")
  public void setOnSelectAllTopics(String onSelectAllTopics)
  {
    this.onSelectAllTopics = onSelectAllTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published after click on page button and before populating the data. Parameter: pgButton")
  public void setOnPagingTopics(String onPagingTopics)
  {
    this.onPagingTopics = onPagingTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published immediately after sortable column was clicked and before sorting the data. Parameters: index is the index name from colModel, iCol is the index of column, sortorder is the new sorting order - can be 'asc' or 'desc'")
  public void setOnSortColTopics(String onSortColTopics)
  {
    this.onSortColTopics = onSortColTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when we click on particular cell in the grid. Parameters: rowid is the id of the row, iCol is the index of the cell, cellcontent is the content of the cell, e is the event object element where we click.")
  public void setOnCellSelectTopics(String onCellSelectTopics)
  {
    this.onCellSelectTopics = onCellSelectTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published after all the data is loaded into the grid and all other processes are complete.")
  public void setOnGridCompleteTopics(String onGridCompleteTopics)
  {
    this.onGridCompleteTopics = onGridCompleteTopics;
  }

  @StrutsTagAttribute(name = "reloadTopics", description = "A comma delimited list of topics that will cause this grid to reload", type = "String", defaultValue = "")
  public void setReloadTopics(String reloadTopics)
  {
    this.reloadTopics = reloadTopics;
  }

  @StrutsTagAttribute(description = "Enable this div element to be resizable. With the cursor grab the right or bottom border and drag to the desired width or height.", type = "Boolean")
  public void setResizable(String resizable)
  {
    this.resizable = resizable;
  }

  @StrutsTagAttribute(description = "Animates to the final size after resizing. Default: false", type = "Boolean")
  public void setResizableAnimate(String animate)
  {
    this.resizableAnimate = animate;
  }

  @StrutsTagAttribute(description = "Duration time for animating, in milliseconds.")
  public void setResizableAnimateDuration(String animateDuration)
  {
    this.resizableAnimateDuration = animateDuration;
  }

  @StrutsTagAttribute(description = "Easing effect for animating. Default: swing")
  public void setResizableAnimateEasing(String animateEasing)
  {
    this.resizableAnimateEasing = animateEasing;
  }

  @StrutsTagAttribute(description = "If set to true, resizing is constrained by the original aspect ratio. Default: false", type = "Boolean")
  public void setResizableAspectRatio(String aspectRatio)
  {
    this.resizableAspectRatio = aspectRatio;
  }

  @StrutsTagAttribute(description = "If set to true, automatically hides the handles except when the mouse hovers over the element. Default: false", type = "Boolean")
  public void setResizableAutoHide(String autoHide)
  {
    this.resizableAutoHide = autoHide;
  }

  @StrutsTagAttribute(description = "Constrains resizing to within the bounds of the specified element. Possible values: 'parent', 'document' or an id")
  public void setResizableContainment(String containment)
  {
    this.resizableContainment = containment;
  }

  @StrutsTagAttribute(description = "Tolerance, in milliseconds, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond duration. This can help prevent unintended resizing when clicking on an element.")
  public void setResizableDelay(String delay)
  {
    this.resizableDelay = delay;
  }

  @StrutsTagAttribute(description = "Tolerance, in pixels, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond distance. This can help prevent unintended resizing when clicking on an element.")
  public void setResizableDistance(String distance)
  {
    this.resizableDistance = distance;
  }

  @StrutsTagAttribute(description = "If set to true, a semi-transparent helper element is shown for resizing. Default: false", type = "Boolean")
  public void setResizableGhost(String ghost)
  {
    this.resizableGhost = ghost;
  }

  @StrutsTagAttribute(description = "This is the css class that will be added to a proxy element to outline the resize during the drag of the resize handle. Once the resize is complete, the original element is sized. e.g. ui-state-highlight")
  public void setResizableHelper(String helper)
  {
    this.resizableHelper = helper;
  }

  @StrutsTagAttribute(description = "This is the maximum height the resizable should be allowed to resize to.")
  public void setResizableMaxHeight(String maxHeight)
  {
    this.resizableMaxHeight = maxHeight;
  }

  @StrutsTagAttribute(description = "This is the maximum width the resizable should be allowed to resize to.")
  public void setResizableMaxWidth(String maxWidth)
  {
    this.resizableMaxWidth = maxWidth;
  }

  @StrutsTagAttribute(description = "This is the minimum height the resizable should be allowed to resize to.")
  public void setResizableMinHeight(String minHeight)
  {
    this.resizableMinHeight = minHeight;
  }

  @StrutsTagAttribute(description = "This is the minimum width the resizable should be allowed to resize to.")
  public void setResizableMinWidth(String minWidth)
  {
    this.resizableMinWidth = minWidth;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered during the resize, on the drag of the resize handler.")
  public void setResizableOnResizeTopics(String resizableOnResizeTopics)
  {
    this.resizableOnResizeTopics = resizableOnResizeTopics;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered at the start of a resize operation.")
  public void setResizableOnStartTopics(String resizableOnStartTopics)
  {
    this.resizableOnStartTopics = resizableOnStartTopics;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered at the end of a resize operation.")
  public void setResizableOnStopTopics(String resizableOnStopTopics)
  {
    this.resizableOnStopTopics = resizableOnStopTopics;
  }

  @StrutsTagAttribute(description = "If specified as a string, should be a comma-split list of any of the following: 'n, e, s, w, ne, se, sw, nw, all'. Default: e, s, se")
  public void setResizableHandles(String handles)
  {
    this.resizableHandles = handles;
  }

  @StrutsTagAttribute(description = "Enable any DIV element to be droppable, a target for draggable elements.")
  public void setDroppable(String droppable)
  {
    this.droppable = droppable;
  }

  @StrutsTagAttribute(description = "All draggables that match the jQuery selector will be accepted. e.g. #myid or .myclass")
  public void setDroppableAccept(String droppableAccept)
  {
    this.droppableAccept = droppableAccept;
  }

  @StrutsTagAttribute(description = "If specified, the class will be added to the droppable while an acceptable draggable is being dragged.")
  public void setDroppableActiveClass(String droppableActiveClass)
  {
    this.droppableActiveClass = droppableActiveClass;
  }

  @StrutsTagAttribute(description = "If set to false, will prevent the ui-droppable class from being added. This may be desired as a performance optimization when calling droppable init on many hundreds of elements. Default: true", defaultValue = "true")
  public void setDroppableAddClasses(String droppableAddClasses)
  {
    this.droppableAddClasses = droppableAddClasses;
  }

  @StrutsTagAttribute(description = "If true, will prevent event propagation on nested droppables. Default: false", defaultValue = "false")
  public void setDroppableGreedy(String droppableGreedy)
  {
    this.droppableGreedy = droppableGreedy;
  }

  @StrutsTagAttribute(description = "If specified, the class will be added to the droppable while an acceptable draggable is being hovered.")
  public void setDroppableHoverClass(String droppableHoverClass)
  {
    this.droppableHoverClass = droppableHoverClass;
  }

  @StrutsTagAttribute(description = "Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted.")
  public void setDroppableScope(String droppableScope)
  {
    this.droppableScope = droppableScope;
  }

  @StrutsTagAttribute(description = "Specifies which mode to use for testing whether a draggable is over a droppable. Possible values: fit, intersect, pointer, touch. ")
  public void setDroppableTolerance(String droppableTolerance)
  {
    this.droppableTolerance = droppableTolerance;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered any time an accepted draggable starts dragging. This can be useful if you want to make the droppable 'light up' when it can be dropped on.")
  public void setDroppableOnActivateTopics(String droppableOnActivateTopics)
  {
    this.droppableOnActivateTopics = droppableOnActivateTopics;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered any time an accepted draggable stops dragging.")
  public void setDroppableOnDeactivateTopics(String droppableOnDeactivateTopics)
  {
    this.droppableOnDeactivateTopics = droppableOnDeactivateTopics;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when an accepted draggable is dropped 'over' this droppable.")
  public void setDroppableOnDropTopics(String droppableOnDropTopics)
  {
    this.droppableOnDropTopics = droppableOnDropTopics;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when an accepted draggable is dragged 'out' this droppable.")
  public void setDroppableOnOutTopics(String droppableOnOutTopics)
  {
    this.droppableOnOutTopics = droppableOnOutTopics;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered as an accepted draggable is dragged 'over' this droppable.")
  public void setDroppableOnOverTopics(String droppableOnOverTopics)
  {
    this.droppableOnOverTopics = droppableOnOverTopics;
  }

  @StrutsTagAttribute(description = "Enable draggable functionality to the DIV element. Move the draggable object by clicking on it with the mouse and dragging it anywhere within the viewport. ")
  public void setDraggable(String draggable)
  {
    this.draggable = draggable;
  }

  @StrutsTagAttribute(description = "If set to false, will prevent the ui-draggable class from being added. This may be desired as a performance optimization when calling draggable init on many hundreds of elements. Default: true", type = "Boolean")
  public void setDraggableAddClasses(String draggableAddClasses)
  {
    this.draggableAddClasses = draggableAddClasses;
  }

  @StrutsTagAttribute(description = "The element passed to or selected by the appendTo option will be used as the draggable helper's container during dragging. By default, the helper is appended to the same container as the draggable. Default: parent")
  public void setDraggableAppendTo(String draggableAppendTo)
  {
    this.draggableAppendTo = draggableAppendTo;
  }

  @StrutsTagAttribute(description = "Constrains dragging to either the horizontal (x) or vertical (y) axis. Possible values: x or y.")
  public void setDraggableAxis(String draggableAxis)
  {
    this.draggableAxis = draggableAxis;
  }

  @StrutsTagAttribute(description = "Prevents dragging from starting on specified elements.")
  public void setDraggableCancel(String draggableCancel)
  {
    this.draggableCancel = draggableCancel;
  }

  @StrutsTagAttribute(description = "The css cursor during the drag operation.")
  public void setDraggableCursor(String draggableCursor)
  {
    this.draggableCursor = draggableCursor;
  }

  @StrutsTagAttribute(description = "Constrains dragging to within the bounds of the specified element or region. Possible string values: parent, document, window, [x1, y1, x2, y2].")
  public void setDraggableContainment(String draggableContainment)
  {
    this.draggableContainment = draggableContainment;
  }

  @StrutsTagAttribute(description = "Time in milliseconds after mousedown until dragging should start. This option can be used to prevent unwanted drags when clicking on an element.")
  public void setDraggableDelay(String draggableDelay)
  {
    this.draggableDelay = draggableDelay;
  }

  @StrutsTagAttribute(description = "Distance in pixels after mousedown the mouse must move before dragging should start. This option can be used to prevent unwanted drags when clicking on an element.")
  public void setDraggableDistance(String draggableDistance)
  {
    this.draggableDistance = draggableDistance;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when the mouse is moved during the dragging.")
  public void setDraggableOnDragTopics(String draggableOnDragTopics)
  {
    this.draggableOnDragTopics = draggableOnDragTopics;
  }

  @StrutsTagAttribute(description = "If specified, restricts drag start click to the specified element(s). e.g. h2")
  public void setDraggableHandle(String draggableHandle)
  {
    this.draggableHandle = draggableHandle;
  }

  @StrutsTagAttribute(description = "Allows for a helper element to be used for dragging display. Possible values: original, clone. Default is original")
  public void setDraggableHelper(String draggableHelper)
  {
    this.draggableHelper = draggableHelper;
  }

  @StrutsTagAttribute(description = "Prevent iframes from capturing the mousemove events during a drag. Useful in combination with cursorAt, or in any case, if the mouse cursor is not over the helper. If set to true, transparent overlays will be placed over all iframes on the page. If a selector is supplied, the matched iframes will have an overlay placed over them. Default: false", type = "Boolean")
  public void setDraggableIframeFix(String draggableIframeFix)
  {
    this.draggableIframeFix = draggableIframeFix;
  }

  @StrutsTagAttribute(description = "Opacity for the helper while being dragged. e.g. 0.75")
  public void setDraggableOpacity(String draggableOpacity)
  {
    this.draggableOpacity = draggableOpacity;
  }

  @StrutsTagAttribute(description = "If set to true, all droppable positions are calculated on every mousemove. Caution: This solves issues on highly dynamic pages, but dramatically decreases performance. Default: false", type = "Boolean")
  public void setDraggableRefreshPositions(String draggableRefreshPositions)
  {
    this.draggableRefreshPositions = draggableRefreshPositions;
  }

  @StrutsTagAttribute(description = "If set to true, the element will return to its start position when dragging stops. e.g. true, valid, invalid Default: false")
  public void setDraggableRevert(String draggableRevert)
  {
    this.draggableRevert = draggableRevert;
  }

  @StrutsTagAttribute(description = "The duration of the revert animation, in milliseconds. Ignored if revert is false.")
  public void setDraggableRevertDuration(String draggableRevertDuration)
  {
    this.draggableRevertDuration = draggableRevertDuration;
  }

  @StrutsTagAttribute(description = "Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted by the droppable.")
  public void setDraggableScope(String draggableScope)
  {
    this.draggableScope = draggableScope;
  }

  @StrutsTagAttribute(description = "If set to true, container auto-scrolls while dragging.", type = "Boolean")
  public void setDraggableScroll(String draggableScroll)
  {
    this.draggableScroll = draggableScroll;
  }

  @StrutsTagAttribute(description = "Distance in pixels from the edge of the viewport after which the viewport should scroll. Distance is relative to pointer, not the draggable. Default: 20")
  public void setDraggableScrollSensitivity(String draggableScrollSensitivity)
  {
    this.draggableScrollSensitivity = draggableScrollSensitivity;
  }

  @StrutsTagAttribute(description = "The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance. Default: 20")
  public void setDraggableScrollSpeed(String draggableScrollSpeed)
  {
    this.draggableScrollSpeed = draggableScrollSpeed;
  }

  @StrutsTagAttribute(description = "If set to true, the draggable will snap to the edges of the selected elements when near an edge of the element. Default: false", type = "Boolean")
  public void setDraggableSnap(String draggableSnap)
  {
    this.draggableSnap = draggableSnap;
  }

  @StrutsTagAttribute(description = "Determines which edges of snap elements the draggable will snap to. Ignored if snap is false. Possible values: inner, outer, both. Default: both")
  public void setDraggableSnapMode(String draggableSnapMode)
  {
    this.draggableSnapMode = draggableSnapMode;
  }

  @StrutsTagAttribute(description = "The distance in pixels from the snap element edges at which snapping should occur. Ignored if snap is false. Default: 20")
  public void setDraggableSnapTolerance(String draggableSnapTolerance)
  {
    this.draggableSnapTolerance = draggableSnapTolerance;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when dragging starts.")
  public void setDraggableOnStartTopics(String draggableOnStartTopics)
  {
    this.draggableOnStartTopics = draggableOnStartTopics;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when dragging stops.")
  public void setDraggableOnStopTopics(String draggableOnStopTopics)
  {
    this.draggableOnStopTopics = draggableOnStopTopics;
  }

  @StrutsTagAttribute(description = "z-index for the helper while being dragged.")
  public void setDraggableZindex(String draggableZindex)
  {
    this.draggableZindex = draggableZindex;
  }

  @StrutsTagAttribute(description = "Enable a elements to be sortable", type = "Boolean")
  public void setSortable(String sortable)
  {
    this.sortable = sortable;
  }

  @StrutsTagAttribute(description = "Defines where the helper that moves with the mouse is being appended to during the drag. Default: 'parent'")
  public void setSortableAppendTo(String sortableAppendTo)
  {
    this.sortableAppendTo = sortableAppendTo;
  }

  @StrutsTagAttribute(description = "If defined, the items can be dragged only horizontally or vertically. Possible values:'x', 'y'.")
  public void setSortableAxis(String sortableAxis)
  {
    this.sortableAxis = sortableAxis;
  }

  @StrutsTagAttribute(description = "Prevents sorting if you start on elements matching the selector. Default: ':input,button'")
  public void setSortableCancel(String sortableCancel)
  {
    this.sortableCancel = sortableCancel;
  }

  @StrutsTagAttribute(description = "Takes a jQuery selector with items that also have sortables applied. If used, the sortable is now connected to the other one-way, so you can drag from this sortable to the other. e.g. #myothersortable or .myothersortables")
  public void setSortableConnectWith(String sortableConnectWith)
  {
    this.sortableConnectWith = sortableConnectWith;
  }

  @StrutsTagAttribute(description = "Constrains dragging to within the bounds of the specified element - can be a DOM element, 'parent', 'document', 'window', or a jQuery selector.")
  public void setSortableContainment(String sortableContainment)
  {
    this.sortableContainment = sortableContainment;
  }

  @StrutsTagAttribute(description = "Defines the cursor that is being shown while sorting.")
  public void setSortableCursor(String sortableCursor)
  {
    this.sortableCursor = sortableCursor;
  }

  @StrutsTagAttribute(description = "Moves the sorting element or helper so the cursor always appears to drag from the same position. Coordinates can be given as a hash using a combination of one or two keys: top, left, right, bottom.")
  public void setSortableCursorAt(String sortableCursorAt)
  {
    this.sortableCursorAt = sortableCursorAt;
  }

  @StrutsTagAttribute(description = "Time in milliseconds to define when the sorting should start. It helps preventing unwanted drags when clicking on an element.")
  public void setSortableDelay(String sortableDelay)
  {
    this.sortableDelay = sortableDelay;
  }

  @StrutsTagAttribute(description = "Tolerance, in pixels, for when sorting should start. If specified, sorting will not start until after mouse is dragged beyond distance. Can be used to allow for clicks on elements within a handle.")
  public void setSortableDistance(String sortableDistance)
  {
    this.sortableDistance = sortableDistance;
  }

  @StrutsTagAttribute(description = "If empty allows for an item to be dropped from a linked selectable. Default: true", type = "Boolean")
  public void setSortableDropOnEmpty(String sortableDropOnEmpty)
  {
    this.sortableDropOnEmpty = sortableDropOnEmpty;
  }

  @StrutsTagAttribute(description = "If true, forces the helper to have a size. Default: false", type = "Boolean")
  public void setSortableForceHelperSize(String sortableForceHelperSize)
  {
    this.sortableForceHelperSize = sortableForceHelperSize;
  }

  @StrutsTagAttribute(description = "If true, forces the placeholder to have a size. Default: false", type = "Boolean")
  public void setSortableForcePlaceholderSize(String sortableForcePlaceholderSize)
  {
    this.sortableForcePlaceholderSize = sortableForcePlaceholderSize;
  }

  @StrutsTagAttribute(description = "Snaps the sorting element or helper to a grid, every x and y pixels. Array values: [x, y]")
  public void setSortableGrid(String sortableGrid)
  {
    this.sortableGrid = sortableGrid;
  }

  @StrutsTagAttribute(description = "Restricts sort start click to the specified element.")
  public void setSortableHandle(String sortableHandle)
  {
    this.sortableHandle = sortableHandle;
  }

  @StrutsTagAttribute(description = "Allows for a helper element to be used for dragging display. The supplied function receives the event and the element being sorted, and should return a DOMElement to be used as a custom proxy helper. Possible values: 'original', 'clone'. Default: 'original'")
  public void setSortableHelper(String sortableHelper)
  {
    this.sortableHelper = sortableHelper;
  }

  @StrutsTagAttribute(description = "Specifies which items inside the element should be sortable. Default: '> *'")
  public void setSortableItems(String sortableItems)
  {
    this.sortableItems = sortableItems;
  }

  @StrutsTagAttribute(description = "Defines the opacity of the helper while sorting. From 0.01 to 1")
  public void setSortableOpacity(String sortableOpacity)
  {
    this.sortableOpacity = sortableOpacity;
  }

  @StrutsTagAttribute(description = "Class that gets applied to the otherwise white space.")
  public void setSortablePlaceholder(String sortablePlaceholder)
  {
    this.sortablePlaceholder = sortablePlaceholder;
  }

  @StrutsTagAttribute(description = "If set to true, the item will be reverted to its new DOM position with a smooth animation. Default: false", type = "Boolean")
  public void setSortableRevert(String sortableRevert)
  {
    this.sortableRevert = sortableRevert;
  }

  @StrutsTagAttribute(description = "If set to true, the page scrolls when coming to an edge. Default: true", type = "Boolean")
  public void setSortableScroll(String sortableScroll)
  {
    this.sortableScroll = sortableScroll;
  }

  @StrutsTagAttribute(description = "Defines how near the mouse must be to an edge to start scrolling. Default: 20")
  public void setSortableScrollSensitivity(String sortableScrollSensitivity)
  {
    this.sortableScrollSensitivity = sortableScrollSensitivity;
  }

  @StrutsTagAttribute(description = "The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance. Default: 20")
  public void setSortableScrollSpeed(String sortableScrollSpeed)
  {
    this.sortableScrollSpeed = sortableScrollSpeed;
  }

  @StrutsTagAttribute(description = "This is the way the reordering behaves during drag. Possible values: 'intersect', 'pointer'. In some setups, 'pointer' is more natural. Default: 'intersect'")
  public void setSortableTolerance(String sortableTolerance)
  {
    this.sortableTolerance = sortableTolerance;
  }

  @StrutsTagAttribute(description = "Z-index for element/helper while being sorted. Default: 1000")
  public void setSortableZindex(String sortableZindex)
  {
    this.sortableZindex = sortableZindex;
  }

  @StrutsTagAttribute(description = "This event is triggered when using connected lists, every connected list on drag start receives it.")
  public void setSortableOnActivateTopics(String sortableActivate)
  {
    this.sortableOnActivateTopics = sortableActivate;
  }

  @StrutsTagAttribute(description = "This event is triggered when sorting stops, but when the placeholder/helper is still available.")
  public void setSortableOnBeforeStopTopics(String sortableBeforeStop)
  {
    this.sortableOnBeforeStopTopics = sortableBeforeStop;
  }

  @StrutsTagAttribute(description = "This event is triggered during sorting, but only when the DOM position has changed.")
  public void setSortableOnChangeTopics(String sortableChange)
  {
    this.sortableOnChangeTopics = sortableChange;
  }

  @StrutsTagAttribute(description = "This event is triggered when sorting was stopped, is propagated to all possible connected lists.")
  public void setSortableOnDeactivateTopics(String sortableDeactivate)
  {
    this.sortableOnDeactivateTopics = sortableDeactivate;
  }

  @StrutsTagAttribute(description = "This event is triggered when a sortable item is moved away from a connected list.")
  public void setSortableOnOutTopics(String sortableOut)
  {
    this.sortableOnOutTopics = sortableOut;
  }

  @StrutsTagAttribute(description = "This event is triggered when a sortable item is moved into a connected list.")
  public void setSortableOnOverTopics(String sortableOver)
  {
    this.sortableOnOverTopics = sortableOver;
  }

  @StrutsTagAttribute(description = "This event is triggered when a connected sortable list has received an item from another list.")
  public void setSortableOnReceiveTopics(String sortableReceive)
  {
    this.sortableOnReceiveTopics = sortableReceive;
  }

  @StrutsTagAttribute(description = "This event is triggered when a sortable item has been dragged out from the list and into another.")
  public void setSortableOnRemoveTopics(String sortableRemove)
  {
    this.sortableOnRemoveTopics = sortableRemove;
  }

  @StrutsTagAttribute(description = "This event is triggered during sorting.")
  public void setSortableOnSortTopics(String sortableSort)
  {
    this.sortableOnSortTopics = sortableSort;
  }

  @StrutsTagAttribute(description = "This event is triggered when sorting starts.")
  public void setSortableOnStartTopics(String sortableStart)
  {
    this.sortableOnStartTopics = sortableStart;
  }

  @StrutsTagAttribute(description = "This event is triggered when sorting has stopped.")
  public void setSortableOnStopTopics(String sortableStop)
  {
    this.sortableOnStopTopics = sortableStop;
  }

  @StrutsTagAttribute(description = "This event is triggered when the user stopped sorting and the DOM position has changed.")
  public void setSortableOnUpdateTopics(String sortableUpdate)
  {
    this.sortableOnUpdateTopics = sortableUpdate;
  }

  @StrutsTagAttribute(description = "Determines the target grid(s) to which the row should be dropped. The option is a string. In case of more than one grid the ids should be delemited with comma - i.e #grid1, #grid2 ", defaultValue = "empty string")
  public void setConnectWith(String connectWith)
  {
    this.connectWith = connectWith;
  }
}
