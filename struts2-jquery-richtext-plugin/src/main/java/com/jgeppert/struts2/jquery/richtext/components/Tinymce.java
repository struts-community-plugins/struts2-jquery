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
 * Render a Richtext Element based on Tinymce
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "tinymce", tldTagClass = "com.jgeppert.struts2.jquery.richtext.views.jsp.ui.TinymceTag", description = "A Richtext Element based on Tinymce", allowDynamicAttributes = true)
public class Tinymce extends Textarea {

    public static final String TEMPLATE = "tinymce";
    public static final String TEMPLATE_CLOSE = "tinymce-close";
    public static final String COMPONENT_NAME = Tinymce.class.getName();
    public static final String JQUERYACTION = "tinymceEditor";

    private static final String PARAM_HEIGHT = "height";
    private static final String PARAM_WIDTH = "width";
    private static final String PARAM_EDITOR_LOCAL = "editorLocal";
    private static final String PARAM_EDITOR_SKIN = "editorSkin";
    private static final String PARAM_EDITOR_SKIN_VARIANT = "editorSkinVariant";
    private static final String PARAM_EDITOR_THEME = "editorTheme";
    private static final String PARAM_TOOLBAR_ALIGN = "toolbarAlign";
    private static final String PARAM_TOOLBAR_LOCATION = "toolbarLocation";
    private static final String PARAM_STATUSBAR_LOCATION = "statusbarLocation";
    private static final String PARAM_EDITOR_RESIZABLE = "editorResizable";
    private static final String PARAM_PLUGINS = "plugins";
    private static final String PARAM_TOOLBAR_BUTTONS_ROW_1 = "toolbarButtonsRow1";
    private static final String PARAM_TOOLBAR_BUTTONS_ROW_2 = "toolbarButtonsRow2";
    private static final String PARAM_TOOLBAR_BUTTONS_ROW_3 = "toolbarButtonsRow3";
    private static final String PARAM_TOOLBAR_BUTTONS_ROW_4 = "toolbarButtonsRow4";
    private static final String PARAM_ENTITY_ENCODING = "entityEncoding";
    private static final String PARAM_CONTENT_CSS = "contentCss";
    private static final String PARAM_PASTEPLAIN = "pasteplain";
    private static final String PARAM_REMOVE_LINEBREAKS = "removeLinebreaks";
    private static final String PARAM_REMOVE_REDUNDANT_BRS = "removeRedundantBrs";
    private static final String PARAM_ON_SAVE_TOPICS = "onSaveTopics";
    private static final String PARAM_ON_EVENT_TOPICS = "onEventTopics";
    private static final String ID_PREFIX_TINYMCE = "tinymce_";

    protected String width;
    protected String height;
    protected String editorLocal;
    protected String editorTheme;
    protected String editorSkin;
    protected String editorSkinVariant;
    protected String toolbarLocation;
    protected String toolbarAlign;
    protected String statusbarLocation;
    protected String plugins;
    protected String toolbarButtonsRow1;
    protected String toolbarButtonsRow2;
    protected String toolbarButtonsRow3;
    protected String toolbarButtonsRow4;
    protected String entityEncoding;
    protected String contentCss;
    protected String pastePlainText;
    protected String removeLinebreaks;
    protected String removeRedundantBrs;
    protected String onSaveTopics;
    protected String onEventTopics;

    public Tinymce(ValueStack stack, HttpServletRequest request,
                   HttpServletResponse response) {
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

        addParameterIfPresent(PARAM_HEIGHT, this.height, Integer.class);
        addParameterIfPresent(PARAM_WIDTH, this.width, Integer.class);
        addParameterIfPresent(PARAM_EDITOR_LOCAL, this.editorLocal);
        addParameterIfPresent(PARAM_EDITOR_SKIN, this.editorSkin);
        addParameterIfPresent(PARAM_EDITOR_SKIN_VARIANT, this.editorSkinVariant);
        addParameterIfPresent(PARAM_EDITOR_THEME, this.editorTheme);
        addParameterIfPresent(PARAM_TOOLBAR_ALIGN, this.toolbarAlign);
        addParameterIfPresent(PARAM_TOOLBAR_LOCATION, this.toolbarLocation);
        addParameterIfPresent(PARAM_STATUSBAR_LOCATION, this.statusbarLocation);
        addParameterIfPresent(PARAM_EDITOR_RESIZABLE, this.resizable, Boolean.class);
        addParameterIfPresent(PARAM_PLUGINS, this.plugins);
        addParameterIfPresent(PARAM_TOOLBAR_BUTTONS_ROW_1, this.toolbarButtonsRow1);
        addParameterIfPresent(PARAM_TOOLBAR_BUTTONS_ROW_2, this.toolbarButtonsRow2);
        addParameterIfPresent(PARAM_TOOLBAR_BUTTONS_ROW_3, this.toolbarButtonsRow3);
        addParameterIfPresent(PARAM_TOOLBAR_BUTTONS_ROW_4, this.toolbarButtonsRow4);
        addParameterIfPresent(PARAM_ENTITY_ENCODING, this.entityEncoding);
        addParameterIfPresent(PARAM_CONTENT_CSS, this.contentCss);
        addParameterIfPresent(PARAM_PASTEPLAIN, this.pastePlainText, Boolean.class);
        addParameterIfPresent(PARAM_REMOVE_LINEBREAKS, this.removeLinebreaks, Boolean.class);
        addParameterIfPresent(PARAM_REMOVE_REDUNDANT_BRS, this.removeRedundantBrs, Boolean.class);
        addParameterIfPresent(PARAM_ON_SAVE_TOPICS, this.onSaveTopics);
        addParameterIfPresent(PARAM_ON_EVENT_TOPICS, this.onEventTopics);

        addGeneratedIdParam(ID_PREFIX_TINYMCE);
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

    @StrutsTagAttribute(description = "This option enables you to specify what theme to use when rendering the TinyMCE WYSIWYG editor instances. e.g simple or advanced", defaultValue = "advanced")
    public void setEditorTheme(String editorTheme) {
        this.editorTheme = editorTheme;
    }

    @StrutsTagAttribute(description = "This option enables you to specify what skin you want to use with your theme. A skin is basically a CSS file that gets loaded from the skins directory inside the theme. The advanced theme that TinyMCE comes with has two skins these are called default and o2k7.", defaultValue = "default")
    public void setEditorSkin(String editorSkin) {
        this.editorSkin = editorSkin;
    }

    @StrutsTagAttribute(description = "This option enables you to specify what skin variant you want to use with your theme. e.g. you can use editorSkin=o2k7 and editorSkinVariant=silver or editorSkinVariant=black")
    public void setEditorSkinVariant(String editorSkinVariant) {
        this.editorSkinVariant = editorSkinVariant;
    }

    @StrutsTagAttribute(description = "This option enables you to specify where the toolbar should be located. This option can be set to top or bottom or external. This option can only be used when theme is set to advanced and when the theme_advanced_layout_manager  option is set to the default value of SimpleLayout. Choosing the external location adds the toolbar to a DIV element and sets the class of this DIV to mceExternalToolbar. This enables you to freely specify the location of the toolbar.", defaultValue = "bottom")
    public void setToolbarLocation(String toolbarLocation) {
        this.toolbarLocation = toolbarLocation;
    }

    @StrutsTagAttribute(description = "This option enables you to specify the alignment of the toolbar, this value can be left, right or center. This option can only be used when theme is set to advanced and when the theme_advanced_layout_manager  option is set to the default value of SimpleLayout. ", defaultValue = "center")
    public void setToolbarAlign(String toolbarAlign) {
        this.toolbarAlign = toolbarAlign;
    }

    @StrutsTagAttribute(description = "This option enables you to specify where the element statusbar with the path and resize tool should be located. This option can be set to top, bottom or none. The default value is set to bottom.", defaultValue = "bottom")
    public void setStatusbarLocation(String statusbarLocation) {
        this.statusbarLocation = statusbarLocation;
    }

    @StrutsTagAttribute(description = "This option gives you the ability to enable/disable the resizing button.", defaultValue = "false", type = "Boolean")
    public void setResizable(String resizable) {
        this.resizable = resizable;
    }

    @StrutsTagAttribute(description = "This option should contain a comma separated list of plugins. TinyMCE is shipped with some core plugins; these are described in greater detail in the Plugins reference. http://wiki.moxiecode.com/index.php/TinyMCE:Plugins e.g. table,contextmenu,paste")
    public void setPlugins(String plugins) {
        this.plugins = plugins;
    }

    @StrutsTagAttribute(description = "This option should contain a comma separated list of button/control names to insert into the toolbar. his option can only be used when theme is set to advanced. Since these rows have items in them by default you need to set them to SPACE \' \' if you want to completely remove rows. A complete reference of all built in buttons and controls can be found in the button/control reference page. http://wiki.moxiecode.com/index.php/TinyMCE:Control_reference e.g. separator,insertdate,inserttime,preview,zoom,separator,forecolor,backcolor")
    public void setToolbarButtonsRow1(String toolbarButtonsRow1) {
        this.toolbarButtonsRow1 = toolbarButtonsRow1;
    }

    @StrutsTagAttribute(description = "This option should contain a comma separated list of button/control names to insert into the toolbar. his option can only be used when theme is set to advanced. Since these rows have items in them by default you need to set them to SPACE \' \' if you want to completely remove rows. A complete reference of all built in buttons and controls can be found in the button/control reference page. http://wiki.moxiecode.com/index.php/TinyMCE:Control_reference e.g. bullist,numlist,separator,outdent,indent,separator,undo,redo,separator")
    public void setToolbarButtonsRow2(String toolbarButtonsRow2) {
        this.toolbarButtonsRow2 = toolbarButtonsRow2;
    }

    @StrutsTagAttribute(description = "This option should contain a comma separated list of button/control names to insert into the toolbar. his option can only be used when theme is set to advanced. Since these rows have items in them by default you need to set them to SPACE \' \' if you want to completely remove rows. A complete reference of all built in buttons and controls can be found in the button/control reference page. http://wiki.moxiecode.com/index.php/TinyMCE:Control_reference e.g. hr,removeformat,visualaid,separator,sub,sup,separator,charmap")
    public void setToolbarButtonsRow3(String toolbarButtonsRow3) {
        this.toolbarButtonsRow3 = toolbarButtonsRow3;
    }

    @StrutsTagAttribute(description = "This option should contain a comma separated list of button/control names to insert into the toolbar. his option can only be used when theme is set to advanced. Since these rows have items in them by default you need to set them to SPACE \' \' if you want to completely remove rows. A complete reference of all built in buttons and controls can be found in the button/control reference page. http://wiki.moxiecode.com/index.php/TinyMCE:Control_reference e.g. emotions,fullpage,fullscreen")
    public void setToolbarButtonsRow4(String toolbarButtonsRow4) {
        this.toolbarButtonsRow4 = toolbarButtonsRow4;
    }

    @StrutsTagAttribute(description = "This option controls how entities/characters get processed by TinyMCE. http://wiki.moxiecode.com/index.php/TinyMCE:Configuration/entity_encoding e.g. named or numeric or raw")
    public void setEntityEncoding(String entityEncoding) {
        this.entityEncoding = entityEncoding;
    }

    @StrutsTagAttribute(description = "This option enables you to specify a custom CSS file that extends the theme content CSS. This CSS file is the one used within the editor (the editable area). This option can also be a comma separated list of URLs. e.g. css/custom_content.css")
    public void setContentCss(String contentCss) {
        this.contentCss = contentCss;
    }

    @StrutsTagAttribute(description = "Always paste as plaintext.‎", type = "Boolean", defaultValue = "false")
    public void setPastePlainText(String pastePlainText) {
        this.pastePlainText = pastePlainText;
    }

    @StrutsTagAttribute(description = "This option controls whether line break characters should be removed from output HTML.‎", type = "Boolean", defaultValue = "true")
    public void setRemoveLinebreaks(String removeLinebreaks) {
        this.removeLinebreaks = removeLinebreaks;
    }

    @StrutsTagAttribute(description = "This option is enabled by default and will control the output of trailing BR elements at the end of block elements.‎", type = "Boolean", defaultValue = "true")
    public void setRemoveRedundantBrs(String removeRedundantBrs) {
        this.removeRedundantBrs = removeRedundantBrs;
    }

    @StrutsTagAttribute(description = "Topics that are published when user press the save button")
    public void setOnSaveTopics(String onSaveTopics) {
        this.onSaveTopics = onSaveTopics;
    }

    @StrutsTagAttribute(description = "Topics that are published on event such as keydown, mousedown and so forth")
    public void setOnEventTopics(String onEventTopics) {
        this.onEventTopics = onEventTopics;
    }
}
