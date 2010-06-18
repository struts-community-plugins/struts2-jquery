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
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Renders a Dialog with local or remote content
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * &lt;sj:dialog id=&quot;mydialog1&quot; title=&quot;Local Dialog&quot;&gt; 
 * Mauris mauris ante, blandit et, ultrices a, suscipit
 * eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in,
 * condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin
 * viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante
 * scelerisque vulputate. 
 * &lt;/sj:dialog&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <pre>
 * &lt;s:url id=&quot;remoteurl&quot; action=&quot;myremoteaction&quot;/&gt; 
 * &lt;sj:dialog id=&quot;mydialog2&quot; href=&quot;%{remoteurl}&quot; title=&quot;Remote Dialog&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 -->
 * 
 * <pre>
 * &lt;s:url id=&quot;remoteurl&quot; action=&quot;myremoteaction&quot;/&gt;
 * &lt;sj:dialog id=&quot;mydialog3&quot; href=&quot;%{remoteurl}&quot; title=&quot;Modal Remote Dialog with Effects&quot; modal=&quot;true&quot; showEffect=&quot;slide&quot; hideEffect=&quot;explode&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example3 -->
 * 
 * <!-- START SNIPPET: example4 -->
 * 
 * <pre>
 * &lt;s:url id=&quot;remoteurl&quot; action=&quot;myremoteaction&quot;/&gt; &lt;sj:dialog id=&quot;mydialog5&quot; href=&quot;%{remoteurl}&quot; title=&quot;Remote Dialog open on Click&quot; autoOpen=&quot;false&quot; modal=&quot;true&quot;/&gt;
 * &lt;sj:a openDialog=&quot;mydialog5&quot;&gt;Open Dialog&lt;/sj:a&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example4 -->
 */
@StrutsTag(name = "dialog", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.DialogTag", description = "Render a Dialog")
public class Dialog extends AbstractRemoteBean {

  public static final String           JQUERYACTION   = "dialog";
  public static final String           TEMPLATE       = "dialog";
  public static final String           TEMPLATE_CLOSE = "dialog-close";
  public static final String           COMPONENT_NAME = Dialog.class.getName();
  public static final transient Random RANDOM         = new Random();

  protected String                     buttons;
  protected String                     draggable;
  protected String                     dialogClass;
  protected String                     height;
  protected String                     modal;
  protected String                     position;
  protected String                     resizable;
  protected String                     title;
  protected String                     width;
  protected String                     zindex;
  protected String                     autoOpen;
  protected String                     showEffect;
  protected String                     hideEffect;
  protected String                     overlayColor;
  protected String                     overlayOpacity;
  protected String                     maxHeight;
  protected String                     maxWidth;
  protected String                     minHeight;
  protected String                     minWidth;
  protected String                     onOpenTopics;
  protected String                     onCloseTopics;
  protected String                     onFocusTopics;
  protected String                     onBeforeCloseTopics;

  public Dialog(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

    if (buttons != null) addParameter("buttons", findString(buttons));
    if (draggable != null) addParameter("draggable", findValue(draggable, Boolean.class));
    if (dialogClass != null) addParameter("dialogClass", findString(dialogClass));
    if (height != null) addParameter("height", findString(height));
    if (modal != null) addParameter("modal", findString(modal));
    if (position != null) addParameter("position", findString(position));
    if (resizable != null) addParameter("resizable", findValue(resizable, Boolean.class));
    if (title != null) addParameter("title", findString(title));
    if (width != null) addParameter("width", findString(width));
    if (zindex != null) addParameter("zindex", findString(zindex));
    if (autoOpen != null) addParameter("autoOpen", findValue(autoOpen, Boolean.class));
    if (showEffect != null) addParameter("showEffect", findString(showEffect));
    if (hideEffect != null) addParameter("hideEffect", findString(hideEffect));
    if (overlayColor != null) addParameter("overlayColor", findString(overlayColor));
    if (overlayOpacity != null) addParameter("overlayOpacity", findString(overlayOpacity));
    if (maxHeight != null) addParameter("maxHeight", findString(maxHeight));
    if (maxWidth != null) addParameter("maxWidth", findString(maxWidth));
    if (minHeight != null) addParameter("minHeight", findString(minHeight));
    if (minWidth != null) addParameter("minWidth", findString(minWidth));
    if (onBeforeCloseTopics != null) addParameter("onBeforeCloseTopics", findString(onBeforeCloseTopics));
    if (onCloseTopics != null) addParameter("onCloseTopics", findString(onCloseTopics));
    if (onOpenTopics != null) addParameter("onOpenTopics", findString(onOpenTopics));
    if (onFocusTopics != null) addParameter("onFocusTopics", findString(onFocusTopics));
    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "dialog_" + String.valueOf(nextInt);
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

  @StrutsTagAttribute(description = "Specifies which buttons should be displayed on the dialog. The property key is the text of the button. The value is the callback function for when the button is clicked.")
  public void setButtons(String buttons)
  {
    this.buttons = buttons;
  }

  @StrutsTagAttribute(description = "If set to true, the dialog will be draggable will be draggable by the titlebar.", defaultValue = "true", type = "Boolean")
  public void setDraggable(String draggable)
  {
    this.draggable = draggable;
  }

  @StrutsTagAttribute(description = "The specified class name(s) will be added to the dialog, for additional theming.")
  public void setDialogClass(String dialogClass)
  {
    this.dialogClass = dialogClass;
  }

  @StrutsTagAttribute(description = "The height of the dialog, in pixels.")
  public void setHeight(String height)
  {
    this.height = height;
  }

  @StrutsTagAttribute(description = "If set to true, the dialog will have modal behavior; other items on the page will be disabled (i.e. cannot be interacted with). Modal dialogs create an overlay below the dialog but above other page elements. Default: false")
  public void setModal(String modal)
  {
    this.modal = modal;
  }

  @StrutsTagAttribute(description = "Specifies where the dialog should be displayed. Possible values: 'center', 'left', 'right', 'top', 'bottom', or an array containing a coordinate pair (in pixel offset from top left of viewport) or the possible string values (e.g. ['right','top'] for top right corner). Default: 'center'", defaultValue = "center")
  public void setPosition(String position)
  {
    this.position = position;
  }

  @StrutsTagAttribute(description = "If set to true, the dialog will be resizeable.", defaultValue = "true", type = "Boolean")
  public void setResizable(String resizable)
  {
    this.resizable = resizable;
  }

  @StrutsTagAttribute(description = "Specifies the title of the dialog. The title can also be specified by the title attribute on the dialog source element.")
  public void setTitle(String title)
  {
    this.title = title;
  }

  @StrutsTagAttribute(description = "The width of the dialog, in pixels.")
  public void setWidth(String width)
  {
    this.width = width;
  }

  @StrutsTagAttribute(description = "The starting z-index for the dialog. Default: 1000")
  public void setZindex(String zindex)
  {
    this.zindex = zindex;
  }

  @StrutsTagAttribute(description = "When autoOpen is true the dialog will open automatically when dialog is called. If false it will stay hidden until .dialog('open') is called on it.", defaultValue = "true", type = "Boolean")
  public void setAutoOpen(String autoOpen)
  {
    this.autoOpen = autoOpen;
  }

  @StrutsTagAttribute(description = "The effect to be used when the dialog is opened. Values are slide, scale, blind, clip, puff, explode, fold and drop. Default: none")
  public void setShowEffect(String showEffect)
  {
    this.showEffect = showEffect;
  }

  @StrutsTagAttribute(description = "The effect to be used when the dialog is closed. Values are slide, scale, blind, clip, puff, explode, fold and drop. Default: none")
  public void setHideEffect(String hideEffect)
  {
    this.hideEffect = hideEffect;
  }

  @StrutsTagAttribute(description = "Overlay color when modal is true. e.g. #000")
  public void setOverlayColor(String overlayColor)
  {
    this.overlayColor = overlayColor;
  }

  @StrutsTagAttribute(description = "Overlay opacity when modal is true. e.g. 0.7")
  public void setOverlayOpacity(String overlayOpacity)
  {
    this.overlayOpacity = overlayOpacity;
  }

  @StrutsTagAttribute(description = "The maximum height to which the dialog can be resized, in pixels.")
  public void setMaxHeight(String maxHeight)
  {
    this.maxHeight = maxHeight;
  }

  @StrutsTagAttribute(description = "The maximum width to which the dialog can be resized, in pixels.")
  public void setMaxWidth(String maxWidth)
  {
    this.maxWidth = maxWidth;
  }

  @StrutsTagAttribute(description = "The minimum height to which the dialog can be resized, in pixels.")
  public void setMinHeight(String minHeight)
  {
    this.minHeight = minHeight;
  }

  @StrutsTagAttribute(description = "The minimum width to which the dialog can be resized, in pixels.")
  public void setMinWidth(String minWidth)
  {
    this.minWidth = minWidth;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when dialog is opened.")
  public void setOnOpenTopics(String onOpenTopics)
  {
    this.onOpenTopics = onOpenTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when dialog is closed.")
  public void setOnCloseTopics(String onCloseTopics)
  {
    this.onCloseTopics = onCloseTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when dialog is focused.")
  public void setOnFocusTopics(String onFocusTopics)
  {
    this.onFocusTopics = onFocusTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published befor dialog is closed.")
  public void setOnBeforeCloseTopics(String onBeforeCloseTopics)
  {
    this.onBeforeCloseTopics = onBeforeCloseTopics;
  }
}
