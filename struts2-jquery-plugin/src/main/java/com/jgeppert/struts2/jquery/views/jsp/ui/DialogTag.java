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

import com.jgeppert.struts2.jquery.components.Dialog;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @see Dialog
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class DialogTag extends AbstractRemoteTag {

  private static final long serialVersionUID = -2044616578492431113L;

  protected String          buttons;
  protected String          draggable;
  protected String          dialogClass;
  protected String          height;
  protected String          modal;
  protected String          position;
  protected String          resizable;
  protected String          title;
  protected String          width;
  protected String          zindex;
  protected String          autoOpen;
  protected String          showEffect;
  protected String          hideEffect;
  protected String          overlayColor;
  protected String          overlayOpacity;
  protected String          onOpenTopics;
  protected String          onCloseTopics;
  protected String          onFocusTopics;
  protected String          onBeforeCloseTopics;
  protected String          maxHeight;
  protected String          maxWidth;
  protected String          minHeight;
  protected String          minWidth;
  protected String          closeOnEscape;
  protected String          openTopics;
  protected String          closeTopics;
  protected String          destroyTopics;

  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new Dialog(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();

    Dialog dialog = (Dialog) component;
    dialog.setButtons(buttons);
    dialog.setDraggable(draggable);
    dialog.setDialogClass(dialogClass);
    dialog.setHeight(height);
    dialog.setModal(modal);
    dialog.setPosition(position);
    dialog.setResizable(resizable);
    dialog.setTitle(title);
    dialog.setWidth(width);
    dialog.setHeight(height);
    dialog.setAutoOpen(autoOpen);
    dialog.setShowEffect(showEffect);
    dialog.setHideEffect(hideEffect);
    dialog.setOverlayColor(overlayColor);
    dialog.setOverlayOpacity(overlayOpacity);
    dialog.setMaxHeight(maxHeight);
    dialog.setMaxWidth(maxWidth);
    dialog.setMinHeight(minHeight);
    dialog.setMinWidth(minWidth);
    dialog.setCloseOnEscape(closeOnEscape);
    dialog.setOnBeforeCloseTopics(onBeforeCloseTopics);
    dialog.setOnCloseTopics(onCloseTopics);
    dialog.setOnOpenTopics(onOpenTopics);
    dialog.setOnFocusTopics(onFocusTopics);
    dialog.setOpenTopics(openTopics);
    dialog.setCloseTopics(closeTopics);
    dialog.setDestroyTopics(destroyTopics);
  }

  public void setButtons(String buttons)
  {
    this.buttons = buttons;
  }

  public void setDraggable(String draggable)
  {
    this.draggable = draggable;
  }

  public void setDialogClass(String dialogClass)
  {
    this.dialogClass = dialogClass;
  }

  public void setHeight(String height)
  {
    this.height = height;
  }

  public void setModal(String modal)
  {
    this.modal = modal;
  }

  public void setPosition(String position)
  {
    this.position = position;
  }

  public void setResizable(String resizable)
  {
    this.resizable = resizable;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setWidth(String width)
  {
    this.width = width;
  }

  public void setZindex(String zindex)
  {
    this.zindex = zindex;
  }

  public void setAutoOpen(String autoOpen)
  {
    this.autoOpen = autoOpen;
  }

  public void setShowEffect(String showEffect)
  {
    this.showEffect = showEffect;
  }

  public void setHideEffect(String hideEffect)
  {
    this.hideEffect = hideEffect;
  }

  public void setOverlayColor(String overlayColor)
  {
    this.overlayColor = overlayColor;
  }

  public void setOverlayOpacity(String overlayOpacity)
  {
    this.overlayOpacity = overlayOpacity;
  }

  public void setMaxHeight(String maxHeight)
  {
    this.maxHeight = maxHeight;
  }

  public void setMaxWidth(String maxWidth)
  {
    this.maxWidth = maxWidth;
  }

  public void setMinHeight(String minHeight)
  {
    this.minHeight = minHeight;
  }

  public void setMinWidth(String minWidth)
  {
    this.minWidth = minWidth;
  }

  public void setOnOpenTopics(String onOpenTopics)
  {
    this.onOpenTopics = onOpenTopics;
  }

  public void setOnCloseTopics(String onCloseTopics)
  {
    this.onCloseTopics = onCloseTopics;
  }

  public void setOnFocusTopics(String onFocusTopics)
  {
    this.onFocusTopics = onFocusTopics;
  }

  public void setOnBeforeCloseTopics(String onBeforeCloseTopics)
  {
    this.onBeforeCloseTopics = onBeforeCloseTopics;
  }

  public void setCloseOnEscape(String closeOnEscape)
  {
    this.closeOnEscape = closeOnEscape;
  }

  public void setOpenTopics(String openTopics)
  {
    this.openTopics = openTopics;
  }

  public void setCloseTopics(String closeTopics)
  {
    this.closeTopics = closeTopics;
  }

  public void setDestroyTopics(String destroyTopics)
  {
    this.destroyTopics = destroyTopics;
  }
}
