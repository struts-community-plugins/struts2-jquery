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

import java.io.Writer;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Form;
import org.apache.struts2.components.FormButton;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <!-- START SNIPPET: javadoc -->
 * Renders a submit button that can submit a form asynchronously.
 * The submit can have three different types of rendering:
 * <ul>
 * <li>input: renders as html &lt;input type="submit"...&gt;</li>
 * <li>image: renders as html &lt;input type="image"...&gt;</li>
 * <li>button: renders as html &lt;button type="submit"...&gt;</li>
 * </ul>
 * Please note that the button type has advantages by adding the possibility to seperate the submitted value from the
 * text shown on the button face, but has issues with Microsoft Internet Explorer at least up to 6.0
 * <!-- END SNIPPET: javadoc -->
 *
 * <p>Examples</p>
 * <!-- START SNIPPET: example1 -->
 * &lt;sj:submit value="%{'Submit'}" /&gt;
 * <!-- END SNIPPET: example1 -->
 *
 * <!-- START SNIPPET: example2 -->
 * &lt;sj:submit type="image" value="%{'Submit'}" label="Submit the form" src="submit.gif"/&gt;
 * <!-- END SNIPPET: example2 -->

 * <!-- START SNIPPET: example3 -->
 * &lt;sj:submit type="button" value="%{'Submit'}" label="Submit the form"/&gt;
 * <!-- END SNIPPET: example3 -->
 *
 * <!-- START SNIPPET: example4 -->
 * &lt;div id="div1"&gt;Div 1&lt;/div&gt;
 * &lt;s:url id="ajaxTest" value="/AjaxTest.action"/&gt;
 *
 * &lt;sj:submit id="link1" href="%{ajaxTest}" target="div1" /&gt;
 * <!-- END SNIPPET: example4 -->
 *
 * <!-- START SNIPPET: example5 -->
 * &lt;s:form id="form" action="AjaxTest"&gt;
 *      &lt;input type="textbox" name="data"&gt;
 *      &lt;sj:submit /&gt;
 * &lt;/s:form&gt;
 * <!-- END SNIPPET: example5 -->
 *
 * <!-- START SNIPPET: example6 -->
 * &lt;s:form id="form" action="AjaxTest"&gt;
 *      &lt;input type="textbox" name="data"&gt;
 * &lt;/s:form&gt;
 *
 * &lt;sj:submit formId="form" /&gt;
 * <!-- END SNIPPET: example6 -->
 *
 * <!-- START SNIPPET: example7 -->
 * &lt;script type="text/javascript"&gt;
 * function before(event){
 *     alert('before request');
 * };
 * function complete(event){
 *     alert('after request');
 * };
 * &lt;/script&gt;
 *
 * &lt;sj:submit beforeSend="before()" complete="complete()" /&gt;
 * <!-- END SNIPPET: example7 -->
 *
 * <!-- START SNIPPET: example8 -->
 * &lt;sj:submit value"AJAX Submit with effect" effect="highlight" effectOptions="color : '#222222'" effectDuration="3600"&gt; href="%{#ajaxTest}" /&gt;
 * <!-- END SNIPPET: example8 -->
 * */
@StrutsTag(name="submit", tldTagClass="ocom.jgeppert.struts2.jquery.views.jsp.ui.SubmitTag", description="Render a submit button")
public class Submit extends FormButton implements RemoteBean {

    private static final Logger LOG = LoggerFactory.getLogger(Submit.class);
    private final static transient Random RANDOM = new Random();

    final public static String OPEN_TEMPLATE = "submit";
    final public static String TEMPLATE = "submit-close";

    protected String href;
    protected String beforeSend;
    protected String complete;
    protected String error;
    protected String dataType;
    protected String formId;
    protected String indicator;
    protected String effect;
    protected String effectDuration;
    protected String effectOptions;
    protected String targets;
    protected String src;
    protected String type;
    protected String timeout;
    
    public Submit(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    @Override
    public String getDefaultOpenTemplate() {
        return OPEN_TEMPLATE;
    }

    public void evaluateParams() {
        super.evaluateExtraParams();
       if ((key == null) && (value == null)) {
            value = "Submit";
        }

        if (((key != null)) && (value == null)) {
            this.value = "%{getText('"+key +"')}";
        }

        super.evaluateParams();
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        if (href != null)
            addParameter("href", findString(href));
        if (beforeSend != null)
            addParameter("beforeSend", findString(beforeSend));
        if (complete != null)
            addParameter("complete", findString(complete));
        if (error != null)
            addParameter("error", findString(error));
        if (dataType != null)
            addParameter("dataType", findString(dataType));
        if (formId != null)
            addParameter("formId", findString(formId));
        if (indicator != null)
            addParameter("indicator", findString(indicator));
        if (effect != null)
            addParameter("effect", findString(effect));
        if (effectDuration != null)
            addParameter("effectDuration", findString(effectDuration));
        if (effectOptions != null)
            addParameter("effectOptions", findString(effectOptions));
        if (targets != null)
            addParameter("targets", findString(targets));
        if (src != null)
            addParameter("src", findString(src));
        if (timeout != null)
          addParameter("timeout", findString(timeout));

        Form form = (Form) findAncestor(Form.class);
        if (form != null)
            addParameter("parentTheme", form.getTheme());

        if ((this.id == null || this.id.length() == 0)) {
            // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
            // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
            int nextInt = RANDOM.nextInt();
            nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
            this.id = "widget_" + String.valueOf(nextInt);
            addParameter("id", this.id);
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
     * @return <tt>true</tt> to indicate type image is supported.
     */
    protected boolean supportsImageType() {
        return true;
    }

    /**
     * Overrides to be able to render body in a template rather than always before the template
     */
    public boolean end(Writer writer, String body) {
        evaluateParams();
        try {
            addParameter("body", body);

            mergeTemplate(writer, buildTemplateName(template, getDefaultTemplate()));
        } catch (Exception e) {
            LOG.error("error when rendering", e);
        }
        finally {
            popComponentStack();
        }

        return false;
    }

    @StrutsTagAttribute(description="The URL to call to obtain the content. Note: If used with ajax context, the value must be set as an url tag value.")
    public void setHref(String href) {
        this.href = href;
    }

    @StrutsTagAttribute(description="Executed javascript function befor ajax request. e.g. befor()")
    public void setBeforeSend(String beforeSend) {
        this.beforeSend = beforeSend;
    }

    @StrutsTagAttribute(description="Executed javascript function after completed ajax request. e.g. after()")
    public void setComplete(String complete) {
        this.complete = complete;
    }

    @StrutsTagAttribute(description="Executed javascript function on error. e.g. error()")
    public void setError(String error) {
        this.error = error;
    }


    @StrutsTagAttribute(description="Type of the result. e.g. html, xml, text, json, ...")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @StrutsTagAttribute(description="Form id whose fields will be serialized and passed as parameters")
    public void setFormId(String formId) {
        this.formId = formId;
    }

    @StrutsTagAttribute(description="Set indicator")
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    @StrutsTagAttribute(description="The css class to use for element")
    public void setCssClass(String cssClass) {
        super.setCssClass(cssClass);
    }

    @StrutsTagAttribute(description="The css style to use for element")
    public void setCssStyle(String cssStyle) {
        super.setCssStyle(cssStyle);
    }

    @StrutsTagAttribute(description="The id to use for the element")
    public void setId(String id) {
        super.setId(id);
    }

    @StrutsTagAttribute(description="The name to set for element")
    public void setName(String name) {
        super.setName(name);
    }

    @StrutsTagAttribute(description="The type of submit to use. Valid values are <i>input</i>, " +
        "<i>button</i> and <i>image</i>.", defaultValue="input")
    public void setType(String type) {
        super.setType(type);
    }

    @StrutsTagAttribute(description="Preset the value of input element.")
    public void setValue(String value) {
        super.setValue(value);
    }

    @StrutsTagAttribute(description="Label expression used for rendering a element specific label")
    public void setLabel(String label) {
        super.setLabel(label);
    }

    @StrutsTagAttribute(description = "Perform a effect on the elements specified in the 'targets' attribute", 
            defaultValue = "none")
        public void setEffect(String effect) {
            this.effect = effect;
        }

    @StrutsTagAttribute(description = "Duration of effect in milliseconds. Only valid if 'effect' attribute is set", 
        defaultValue = "2000", type="Integer")
    public void setEffectDuration(String effectDuration) {
        this.effectDuration = effectDuration;
    }
    
    @StrutsTagAttribute(description = "jQuery options for effect, eg 'color : #aaaaaa' for the highlight effect or 'times : 3' for the bounce effect", 
            defaultValue = "")
        public void setEffectOptions(String effectOptions) {
            this.effectOptions = effectOptions;
    }
    
    @StrutsTagAttribute(description="Comma delimited list of ids of the elements whose content will be updated")
    public void setTargets(String targets) {
        this.targets = targets;
    }

    @StrutsTagSkipInheritance
    public void setAction(String action) {
        super.setAction(action);
    }

    @StrutsTagAttribute(description="Supply an image src for <i>image</i> type submit button. Will have no effect for types <i>input</i> and <i>button</i>.")
	public void setSrc(String src) {
		this.src = src;
	}

    @StrutsTagAttribute(description = "jQuery options for timeout. Default is 3000", defaultValue = "3000", type="Integer")
    public void setTimeout(String timeout)
    {
      this.timeout = timeout;
    }

}
