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

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Renders a Dialog with local or remote content
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <pre>
 * &lt;sj:dialog id=&quot;mydialog1&quot; title=&quot;Local Dialog&quot;&gt;
 * Mauris mauris ante, blandit et, ultrices a, suscipit
 * eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in,
 * condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin
 * viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante
 * scelerisque vulputate.
 * &lt;/sj:dialog&gt;
 * </pre>
 * <!-- END SNIPPET: example1 -->
 * <!-- START SNIPPET: example2 -->
 * <pre>
 * &lt;s:url id=&quot;remoteurl&quot; action=&quot;myremoteaction&quot;/&gt;
 * &lt;sj:dialog id=&quot;mydialog2&quot; href=&quot;%{remoteurl}&quot; title=&quot;Remote Dialog&quot;/&gt;
 * </pre>
 * <!-- END SNIPPET: example2 -->
 * <!-- START SNIPPET: example3 -->
 * <pre>
 * &lt;s:url id=&quot;remoteurl&quot; action=&quot;myremoteaction&quot;/&gt;
 * &lt;sj:dialog id=&quot;mydialog3&quot; href=&quot;%{remoteurl}&quot; title=&quot;Modal Remote Dialog with Effects&quot; modal=&quot;true&quot; showEffect=&quot;slide&quot; hideEffect=&quot;explode&quot;/&gt;
 * </pre>
 * <!-- END SNIPPET: example3 -->
 * <!-- START SNIPPET: example4 -->
 * <pre>
 * &lt;s:url id=&quot;remoteurl&quot; action=&quot;myremoteaction&quot;/&gt; &lt;sj:dialog id=&quot;mydialog5&quot; href=&quot;%{remoteurl}&quot; title=&quot;Remote Dialog open on Click&quot; autoOpen=&quot;false&quot; modal=&quot;true&quot;/&gt;
 * &lt;sj:a openDialog=&quot;mydialog5&quot;&gt;Open Dialog&lt;/sj:a&gt;
 * </pre>
 * <!-- END SNIPPET: example4 -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "dialog", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.DialogTag", description = "Render a Dialog")
public class Dialog extends AbstractRemoteBean {

    public static final String JQUERYACTION = "dialog";
    public static final String TEMPLATE = "dialog";
    public static final String TEMPLATE_CLOSE = "dialog-close";
    public static final String COMPONENT_NAME = Dialog.class.getName();

    private static final String PARAM_APPEND_TO = "appendTo";
    private static final String PARAM_BUTTONS = "buttons";
    private static final String PARAM_DRAGGABLE = "draggable";
    private static final String PARAM_DIALOG_CLASS = "dialogClass";
    private static final String PARAM_HEIGHT = "height";
    private static final String PARAM_MODAL = "modal";
    private static final String PARAM_POSITION = "position";
    private static final String PARAM_RESIZABLE = "resizable";
    private static final String PARAM_TITLE = "title";
    private static final String PARAM_WIDTH = "width";
    private static final String PARAM_AUTO_OPEN = "autoOpen";
    private static final String PARAM_SHOW_EFFECT = "showEffect";
    private static final String PARAM_HIDE_EFFECT = "hideEffect";
    private static final String PARAM_MAX_HEIGHT = "maxHeight";
    private static final String PARAM_MAX_WIDTH = "maxWidth";
    private static final String PARAM_MIN_HEIGHT = "minHeight";
    private static final String PARAM_MIN_WIDTH = "minWidth";
    private static final String PARAM_CLOSE_ON_ESCAPE = "closeOnEscape";
    private static final String PARAM_ON_BEFORE_CLOSE_TOPICS = "onBeforeCloseTopics";
    private static final String PARAM_ON_CLOSE_TOPICS = "onCloseTopics";
    private static final String PARAM_ON_OPEN_TOPICS = "onOpenTopics";
    private static final String PARAM_ON_FOCUS_TOPICS = "onFocusTopics";
    private static final String PARAM_OPEN_TOPICS = "openTopics";
    private static final String PARAM_CLOSE_TOPICS = "closeTopics";
    private static final String PARAM_DESTROY_TOPICS = "destroyTopics";

    private static final String ID_PREFIX_DIALOG = "dialog_";

    protected String appendTo;
    protected String buttons;
    protected String draggable;
    protected String dialogClass;
    protected String height;
    protected String modal;
    protected String position;
    protected String resizable;
    protected String title;
    protected String width;
    protected String autoOpen;
    protected String showEffect;
    protected String hideEffect;
    protected String overlayColor;
    protected String overlayOpacity;
    protected String maxHeight;
    protected String maxWidth;
    protected String minHeight;
    protected String minWidth;
    protected String closeOnEscape;
    protected String onOpenTopics;
    protected String onCloseTopics;
    protected String onFocusTopics;
    protected String onBeforeCloseTopics;
    protected String openTopics;
    protected String closeTopics;
    protected String destroyTopics;

    public Dialog(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_APPEND_TO, this.appendTo);
        addParameterIfPresent(PARAM_BUTTONS, this.buttons);
        addParameterIfPresent(PARAM_DRAGGABLE, this.draggable, Boolean.class);
        addParameterIfPresent(PARAM_DIALOG_CLASS, this.dialogClass);
        addParameterIfPresent(PARAM_MODAL, this.modal);
        addParameterIfPresent(PARAM_POSITION, this.position);
        addParameterIfPresent(PARAM_RESIZABLE, this.resizable, Boolean.class);
        addParameterIfPresent(PARAM_TITLE, this.title);
        addParameterIfPresent(PARAM_AUTO_OPEN, this.autoOpen, Boolean.class);
        addParameterIfPresent(PARAM_SHOW_EFFECT, this.showEffect);
        addParameterIfPresent(PARAM_HIDE_EFFECT, this.hideEffect);
        addParameterIfPresent(PARAM_HEIGHT, this.height);
        addParameterIfPresent(PARAM_WIDTH, this.width);
        addParameterIfPresent(PARAM_MAX_HEIGHT, this.maxHeight);
        addParameterIfPresent(PARAM_MAX_WIDTH, this.maxWidth);
        addParameterIfPresent(PARAM_MIN_HEIGHT, this.minHeight);
        addParameterIfPresent(PARAM_MIN_WIDTH, this.minWidth);
        addParameterIfPresent(PARAM_CLOSE_ON_ESCAPE, this.closeOnEscape, Boolean.class);
        addParameterIfPresent(PARAM_ON_BEFORE_CLOSE_TOPICS, this.onBeforeCloseTopics);
        addParameterIfPresent(PARAM_ON_CLOSE_TOPICS, this.onCloseTopics);
        addParameterIfPresent(PARAM_ON_OPEN_TOPICS, this.onOpenTopics);
        addParameterIfPresent(PARAM_ON_FOCUS_TOPICS, this.onFocusTopics);
        addParameterIfPresent(PARAM_OPEN_TOPICS, this.openTopics);
        addParameterIfPresent(PARAM_CLOSE_TOPICS, this.closeTopics);
        addParameterIfPresent(PARAM_DESTROY_TOPICS, this.destroyTopics);

        addGeneratedIdParam(ID_PREFIX_DIALOG);
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

    @StrutsTagAttribute(description = "Which element the dialog should be appended to. Regardless of the value set, the overlay for modal dialogs will always be appended to the body and cover the entire window.", defaultValue = "body")
    public void setAppendTo(String appendTo) {
        this.appendTo = appendTo;
    }

    @StrutsTagAttribute(description = "Specifies which buttons should be displayed on the dialog. The property key is the text of the button. The value is the callback function for when the button is clicked.")
    public void setButtons(String buttons) {
        this.buttons = buttons;
    }

    @StrutsTagAttribute(description = "If set to true, the dialog will be draggable will be draggable by the titlebar.", defaultValue = "true", type = "Boolean")
    public void setDraggable(String draggable) {
        this.draggable = draggable;
    }

    @StrutsTagAttribute(description = "The specified class name(s) will be added to the dialog, for additional theming.")
    public void setDialogClass(String dialogClass) {
        this.dialogClass = dialogClass;
    }

    @StrutsTagAttribute(description = "The height of the dialog, in pixels.")
    public void setHeight(String height) {
        this.height = height;
    }

    @StrutsTagAttribute(description = "If set to true, the dialog will have modal behavior; other items on the page will be disabled (i.e. cannot be interacted with). Modal dialogs create an overlay below the dialog but above other page elements. Default: false")
    public void setModal(String modal) {
        this.modal = modal;
    }

    @StrutsTagAttribute(description = "Specifies where the dialog should be displayed. Possible values: 'center', 'left', 'right', 'top', 'bottom', or an array containing a coordinate pair (in pixel offset from top left of viewport) or the possible string values (e.g. ['right','top'] for top right corner). Default: 'center'", defaultValue = "center")
    public void setPosition(String position) {
        this.position = position;
    }

    @StrutsTagAttribute(description = "If set to true, the dialog will be resizeable.", defaultValue = "true", type = "Boolean")
    public void setResizable(String resizable) {
        this.resizable = resizable;
    }

    @StrutsTagAttribute(description = "Specifies the title of the dialog. The title can also be specified by the title attribute on the dialog source element.")
    public void setTitle(String title) {
        this.title = title;
    }

    @StrutsTagAttribute(description = "The width of the dialog, in pixels.")
    public void setWidth(String width) {
        this.width = width;
    }

    @StrutsTagAttribute(description = "When autoOpen is true the dialog will open automatically when dialog is called. If false it will stay hidden until .dialog('open') is called on it.", defaultValue = "true", type = "Boolean")
    public void setAutoOpen(String autoOpen) {
        this.autoOpen = autoOpen;
    }

    @StrutsTagAttribute(description = "The effect to be used when the dialog is opened. Values are slide, scale, blind, clip, puff, explode, fold and drop. Default: none")
    public void setShowEffect(String showEffect) {
        this.showEffect = showEffect;
    }

    @StrutsTagAttribute(description = "The effect to be used when the dialog is closed. Values are slide, scale, blind, clip, puff, explode, fold and drop. Default: none")
    public void setHideEffect(String hideEffect) {
        this.hideEffect = hideEffect;
    }

    @StrutsTagAttribute(description = "The maximum height to which the dialog can be resized, in pixels.")
    public void setMaxHeight(String maxHeight) {
        this.maxHeight = maxHeight;
    }

    @StrutsTagAttribute(description = "The maximum width to which the dialog can be resized, in pixels.")
    public void setMaxWidth(String maxWidth) {
        this.maxWidth = maxWidth;
    }

    @StrutsTagAttribute(description = "The minimum height to which the dialog can be resized, in pixels.")
    public void setMinHeight(String minHeight) {
        this.minHeight = minHeight;
    }

    @StrutsTagAttribute(description = "The minimum width to which the dialog can be resized, in pixels.")
    public void setMinWidth(String minWidth) {
        this.minWidth = minWidth;
    }

    @StrutsTagAttribute(description = "Specifies whether the dialog should close when it has focus and the user presses the esacpe (ESC) key.", defaultValue = "true", type = "Boolean")
    public void setCloseOnEscape(String closeOnEscape) {
        this.closeOnEscape = closeOnEscape;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when dialog is opened.")
    public void setOnOpenTopics(String onOpenTopics) {
        this.onOpenTopics = onOpenTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when dialog is closed.")
    public void setOnCloseTopics(String onCloseTopics) {
        this.onCloseTopics = onCloseTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when dialog is focused.")
    public void setOnFocusTopics(String onFocusTopics) {
        this.onFocusTopics = onFocusTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published befor dialog is closed.")
    public void setOnBeforeCloseTopics(String onBeforeCloseTopics) {
        this.onBeforeCloseTopics = onBeforeCloseTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics to open the dialog.")
    public void setOpenTopics(String openTopics) {
        this.openTopics = openTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics to close the dialog.")
    public void setCloseTopics(String closeTopics) {
        this.closeTopics = closeTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics to destroy the dialog.")
    public void setDestroyTopics(String destroyTopics) {
        this.destroyTopics = destroyTopics;
    }
}
