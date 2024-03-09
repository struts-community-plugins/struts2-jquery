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
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.components.Form;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Renders a submit button that can submit a form asynchronously. The submit can
 * have three different types of rendering:
 * </p>
 * <ul>
 * <li>input: renders as html &lt;input type="submit"...&gt;</li>
 * <li>image: renders as html &lt;input type="image"...&gt;</li>
 * <li>button: renders as html &lt;button type="submit"...&gt;</li>
 * </ul>
 * <p>
 * Please note that the button type has advantages by adding the possibility to
 * separate the submitted value from the text shown on the button face, but has
 * issues with Microsoft Internet Explorer at least up to 6.0
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <pre>
 * &lt;sj:submit value=&quot;%{'Submit'}&quot; /&gt;
 * </pre>
 * <!-- END SNIPPET: example1 -->
 * <!-- START SNIPPET: example2 -->
 * <pre>
 * &lt;sj:submit type=&quot;image&quot; value=&quot;%{'Submit'}&quot; label=&quot;Submit the form&quot; src=&quot;submit.gif&quot;/&gt;
 * </pre>
 * <!-- END SNIPPET: example2 -->
 * <!-- START SNIPPET: example3 -->
 * <pre>
 * &lt;sj:submit type=&quot;button&quot; value=&quot;%{'Submit'}&quot; label=&quot;Submit the form&quot;/&gt;
 * </pre>
 * <!-- END SNIPPET: example3 -->
 * <!-- START SNIPPET: example4 -->
 * <pre>
 * &lt;div id=&quot;div1&quot;&gt;Div 1&lt;/div&gt;
 * &lt;s:url id=&quot;ajaxTest&quot; value=&quot;/AjaxTest.action&quot;/&gt;
 * &lt;sj:submit id=&quot;link1&quot; href=&quot;%{ajaxTest}&quot; target=&quot;div1&quot; /&gt;
 * </pre>
 * <!-- END SNIPPET: example4 -->
 * <!-- START SNIPPET: example5 -->
 * <pre>
 * &lt;s:form id=&quot;form&quot; action=&quot;AjaxTest&quot;&gt;
 * &lt;input type=&quot;textbox&quot; name=&quot;data&quot;&gt; &lt;sj:submit /&gt;
 * &lt;/s:form&gt;
 * </pre>
 * <!-- END SNIPPET: example5 -->
 * <!-- START SNIPPET: example6 -->
 * <pre>
 * &lt;s:form id=&quot;form&quot; action=&quot;AjaxTest&quot;&gt;
 * &lt;input type=&quot;textbox&quot; name=&quot;data&quot;&gt;
 * &lt;/s:form&gt;
 *
 * &lt;sj:submit formId=&quot;form&quot; /&gt;
 * </pre>
 * <!-- END SNIPPET: example6 -->
 * <!-- START SNIPPET: example7 -->
 * <pre>
 * &lt;script type=&quot;text/javascript&quot;&gt;
 * function before(event){ alert('before request'); };
 * function complete(event){ alert('after request'); };
 * &lt;/script&gt;
 *
 * &lt;sj:submit beforeSend=&quot;before()&quot; complete=&quot;complete()&quot; /&gt;
 * </pre>
 * <!-- END SNIPPET: example7 -->
 * <!-- START SNIPPET: example8 -->
 * <pre>
 * &lt;sj:submit value&quot;AJAX Submit with effect&quot;
 * effect=&quot;highlight&quot; effectOptions=&quot;color : '#222222'&quot;
 * effectDuration=&quot;3600&quot;&gt; href=&quot;%{#ajaxTest}&quot; /&gt;
 * </pre>
 * <!-- END SNIPPET: example8 -->
 *
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "submit", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.SubmitTag", description = "Render a submit button", allowDynamicAttributes = true)
public class Submit extends AbstractRemoteBean implements ButtonBean {

    public static final String TEMPLATE = "submit";
    public static final String TEMPLATE_CLOSE = "submit-close";
    public static final String JQUERYACTION = "button";
    public static final String COMPONENT_NAME = Submit.class.getName();

    private static final String PARAM_TYPE = "type";
    private static final String PARAM_SRC = "src";
    private static final String PARAM_CLEAR_FORM = "clearForm";
    private static final String PARAM_RESET_FORM = "resetForm";
    private static final String PARAM_IFRAME = "iframe";
    private static final String PARAM_ON_CLICK_TOPICS = "onClickTopics";
    private static final String PARAM_OPEN_DIALOG = "openDialog";
    private static final String PARAM_OPEN_DIALOG_TITLE = "openDialogTitle";
    private static final String PARAM_BUTTON = "button";
    private static final String PARAM_BUTTON_ICON = "buttonIcon";
    private static final String PARAM_BUTTON_ICON_SECONDARY = "buttonIconSecondary";
    private static final String PARAM_BUTTON_TEXT = "buttonText";
    private static final String PARAM_VALIDATE = "validate";
    private static final String PARAM_VALIDATE_FUNCTION = "validateFunction";
    private static final String PARAM_FORM_FILTER = "formFilter";
    private static final String PARAM_REPLACE_TARGET = "replaceTarget";
    private static final String PARAM_PARENT_THEME = "parentTheme";
    private static final String PARAM_FORM_IDS = "formIds";
    private static final String PARAM_BODY = "body";

    private static final String ID_PREFIX_SUBMIT = "submit_";

    protected String src;
    protected String type;
    protected String clearForm;
    protected String resetForm;
    protected String iframe;
    protected String onClickTopics;
    protected String openDialog;
    protected String openDialogTitle;
    protected String parentTheme;
    protected String button;
    protected String buttonIcon;
    protected String buttonIconSecondary;
    protected String buttonText;
    protected String validate;
    protected String validateFunction;
    protected String formFilter;
    protected String replaceTarget;

    public Submit(ValueStack stack, HttpServletRequest request,
                  HttpServletResponse response) {
        super(stack, request, response);
    }

    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    public String getComponentName() {
        return COMPONENT_NAME;
    }

    public void evaluateParams() {
        super.evaluateExtraParams();
        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        if ((key == null) && (value == null)) {
            value = "Submit";
        }

        if (((key != null)) && (value == null)) {
            this.value = "%{getText('" + key + "')}";
        }

        super.evaluateParams();
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameterIfPresent(PARAM_TYPE, this.type);
        addParameterIfPresent(PARAM_SRC, this.src);
        addParameterIfPresent(PARAM_CLEAR_FORM, this.clearForm, Boolean.class);
        addParameterIfPresent(PARAM_RESET_FORM, this.resetForm, Boolean.class);
        addParameterIfPresent(PARAM_IFRAME, this.iframe, Boolean.class);
        addParameterIfPresent(PARAM_ON_CLICK_TOPICS, this.onClickTopics);
        addParameterIfPresent(PARAM_OPEN_DIALOG, this.openDialog);
        addParameterIfPresent(PARAM_OPEN_DIALOG_TITLE, this.openDialogTitle);
        addParameterIfPresent(PARAM_BUTTON, this.button, Boolean.class);
        addParameterIfPresent(PARAM_BUTTON_ICON, this.buttonIcon);
        addParameterIfPresent(PARAM_BUTTON_ICON_SECONDARY, this.buttonIconSecondary);
        addParameterIfPresent(PARAM_BUTTON_TEXT, this.buttonText, Boolean.class);
        addParameterIfPresent(PARAM_VALIDATE, this.validate, Boolean.class);
        addParameterIfPresent(PARAM_VALIDATE_FUNCTION, this.validateFunction);
        addParameterIfPresent(PARAM_FORM_FILTER, this.formFilter);
        addParameterIfPresent(PARAM_REPLACE_TARGET, this.replaceTarget, Boolean.class);

        addGeneratedIdParam(ID_PREFIX_SUBMIT);

        Form form = (Form) findAncestor(Form.class);
        if (parentTheme != null) {
            addParameter(PARAM_PARENT_THEME, findString(parentTheme));
        } else if (form != null) {
            addParameter(PARAM_PARENT_THEME, form.getTheme());
        } else {
            addParameter(PARAM_PARENT_THEME, "simple");
        }

        if (form != null && StringUtils.isBlank(formIds)) {
            if (form.getId() != null) {
                addParameter(PARAM_FORM_IDS, form.getParameters().get("id"));
            } else {
                addParameter(PARAM_FORM_IDS, null);
            }
        }
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

    /**
     * Indicate whether the concrete button supports the type "image".
     *
     * @return <code>true</code> to indicate type image is supported.
     */
    protected boolean supportsImageType() {
        return true;
    }

    /**
     * Overrides to be able to render body in a template rather than always
     * before the template
     */
    public boolean end(Writer writer, String body) {
        evaluateParams();
        try {
            addParameter(PARAM_BODY, body);
            mergeTemplate(writer, buildTemplateName(template, getDefaultTemplate()));
        } catch (Exception e) {
            // error when rendering
        } finally {
            popComponentStack();
        }

        return false;
    }

    @StrutsTagAttribute(description = "The type of submit to use. Valid values are <i>input</i>, "
            + "<i>button</i> and <i>image</i>.", defaultValue = "input")
    public void setType(String type) {
        this.type = type;
    }

    @StrutsTagAttribute(description = "Supply an image src for <i>image</i> type submit button. Will have no effect for types <i>input</i> and <i>button</i>.")
    public void setSrc(String src) {
        this.src = src;
    }

    @StrutsTagAttribute(description = "Clear all form fields after successful submit. Default: false", type = "Boolean")
    public void setClearForm(String clearForm) {
        this.clearForm = clearForm;
    }

    @StrutsTagAttribute(description = "Reset the form after successful submit. Default: false", type = "Boolean")
    public void setResetForm(String resetForm) {
        this.resetForm = resetForm;
    }

    @StrutsTagAttribute(description = "Boolean flag indicating whether the form should always target the server response to an iframe. This is useful in conjuction with file uploads. Default: false", type = "Boolean")
    public void setIframe(String iframe) {
        this.iframe = iframe;
    }

    @StrutsTagAttribute(name = "onClickTopics", description = "A comma delimited list of topics that published when the element is clicked")
    public void setOnClickTopics(String onClickTopics) {
        this.onClickTopics = onClickTopics;
    }

    @StrutsTagAttribute(description = "id of dialog that will be opened when clicked.")
    public void setOpenDialog(String openDialog) {
        this.openDialog = openDialog;
    }

    @StrutsTagAttribute(description = "Set the title of a dialog opened by openDialog or openDialogTopics")
    public void setOpenDialogTitle(String openDialogTitle) {
        this.openDialogTitle = openDialogTitle;
    }

    @StrutsTagAttribute(description = "The parent theme. Default: value of parent form tag or simple if no parent form tag is available")
    public void setParentTheme(String parentTheme) {
        this.parentTheme = parentTheme;
    }

    @StrutsTagAttribute(description = "jQuery UI Button", defaultValue = "false", type = "Boolean")
    public void setButton(String button) {
        this.button = button;
    }

    @StrutsTagAttribute(description = "Icons to display. The primary icon is displayed on the left of the label text. Value must be a classname (String), eg. ui-icon-gear.")
    public void setButtonIcon(String buttonIcon) {
        this.buttonIcon = buttonIcon;
    }

    @StrutsTagAttribute(description = "Icons to display. The secondary icon is displayed on the right of the label text. Value must be a classname (String), eg. ui-icon-gear.")
    public void setButtonIconSecondary(String buttonIconSecondary) {
        this.buttonIconSecondary = buttonIconSecondary;
    }

    @StrutsTagAttribute(description = "Whether to show any text - when set to false (display no text), icons (see icons option) must be enabled, otherwise it'll be ignored.", defaultValue = "true", type = "Boolean")
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    @StrutsTagAttribute(description = "A function that handle the client validation result. eg.: myValidation(form, errors)")
    public void setValidateFunction(String validateFunction) {
        this.validateFunction = validateFunction;
    }

    @StrutsTagAttribute(description = "Enable client AJAX validation", defaultValue = "false", type = "Boolean")
    public void setValidate(String validate) {
        this.validate = validate;
    }

    @StrutsTagAttribute(description = "Function name used to filter the fields of the form.")
    public void setFormFilter(String formFilter) {
        this.formFilter = formFilter;
    }

    @StrutsTagAttribute(description = "Set to true if the target should be replaced or false if only the target contents should be replaced.", defaultValue = "false", type = "Boolean")
    public void setReplaceTarget(String replaceTarget) {
        this.replaceTarget = replaceTarget;
    }
}
