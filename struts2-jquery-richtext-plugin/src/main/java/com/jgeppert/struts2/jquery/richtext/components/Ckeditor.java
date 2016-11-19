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

package com.jgeppert.struts2.jquery.richtext.components;

import com.jgeppert.struts2.jquery.components.Textarea;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render a Richtext Element based on Ckeditor
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "ckeditor", tldTagClass = "com.jgeppert.struts2.jquery.richtext.views.jsp.ui.CkeditorTag", description = "A Richtext Element based on Ckeditor", allowDynamicAttributes = true)
public class Ckeditor extends Textarea {

    public static final String TEMPLATE = "ckeditor";
    public static final String TEMPLATE_CLOSE = "ckeditor-close";
    public static final String COMPONENT_NAME = Ckeditor.class.getName();
    private static final String JQUERYACTION = "ckeditor";

    private static final String PARAM_SKIN = "skin";
    private static final String PARAM_TOOLBAR = "toolbar";
    private static final String PARAM_HEIGHT = "height";
    private static final String PARAM_WIDTH = "width";
    private static final String PARAM_EDITOR_LOCAL = "editorLocal";
    private static final String PARAM_CUSTOM_CONFIG = "customConfig";
    private static final String PARAM_ON_EDITOR_READY_TOPICS = "onEditorReadyTopics";
    private static final String PARAM_UPLOADS = "uploads";
    private static final String PARAM_UPLOAD_HREF = "uploadHref";
    private static final String PARAM_EDITOR_RESIZABLE = "editorResizable";

    private static final String ID_PREFIX_CKEDITOR = "ckeditor_";

    protected String skin;
    protected String toolbar;
    protected String width;
    protected String height;
    protected String editorLocal;
    protected String customConfig;
    protected String onEditorReadyTopics;
    protected String uploads;
    protected String uploadHref;

    public Ckeditor(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

        addParameterIfPresent(PARAM_SKIN, this.skin);
        addParameterIfPresent(PARAM_TOOLBAR, this.toolbar);
        addParameterIfPresent(PARAM_HEIGHT, this.height, Integer.class);
        addParameterIfPresent(PARAM_WIDTH, this.width, Integer.class);
        addParameterIfPresent(PARAM_EDITOR_LOCAL, this.editorLocal);
        addParameterIfPresent(PARAM_CUSTOM_CONFIG, this.customConfig);
        addParameterIfPresent(PARAM_ON_EDITOR_READY_TOPICS, this.onEditorReadyTopics);
        addParameterIfPresent(PARAM_UPLOADS, this.uploads, Boolean.class);
        addParameterIfPresent(PARAM_UPLOAD_HREF, this.uploadHref);
        addParameterIfPresent(PARAM_EDITOR_RESIZABLE, this.resizable, Boolean.class);

        addGeneratedIdParam(ID_PREFIX_CKEDITOR);
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

    @StrutsTagAttribute(description = "the richtext skin. e.g kama, office2003, v2")
    public void setSkin(String skin) {
        this.skin = skin;
    }

    @StrutsTagAttribute(description = "Toolbar Configuration. e.g. Basic or Full")
    public void setToolbar(String toolbar) {
        this.toolbar = toolbar;
    }

    @StrutsTagAttribute(description = "width attribute", type = "Integer")
    public void setWidth(String width) {
        this.width = width;
    }

    @StrutsTagAttribute(description = "height attribute", type = "Integer")
    public void setHeight(String height) {
        this.height = height;
    }

    @StrutsTagAttribute(description = "the editor local", defaultValue = "en")
    public void setEditorLocal(String editorLocal) {
        this.editorLocal = editorLocal;
    }

    @StrutsTagAttribute(description = "path to custom config file")
    public void setCustomConfig(String customConfig) {
        this.customConfig = customConfig;
    }

    @StrutsTagAttribute(description = "Topics that are published when editor instance is ready")
    public void setOnEditorReadyTopics(String onEditorReadyTopics) {
        this.onEditorReadyTopics = onEditorReadyTopics;
    }

    @StrutsTagAttribute(description = "Enable Uploads for this Editor Instance.", type = "Boolean", defaultValue = "false")
    public void setUploads(String uploads) {
        this.uploads = uploads;
    }

    @StrutsTagAttribute(description = "Use a custom Upload URL")
    public void setUploadHref(String uploadHref) {
        this.uploadHref = uploadHref;
    }

    @StrutsTagAttribute(description = "This option gives you the ability to enable/disable the resizing of the ckeditor instance.", defaultValue = "false", type = "Boolean")
    public void setResizable(String resizable) {
        this.resizable = resizable;
    }

}
