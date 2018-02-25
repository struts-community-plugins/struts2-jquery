package com.jgeppert.struts2.jquery.handlebarsjs.components;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 *  Add support for handleBar JS templating engine.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "handlebars", tldTagClass = "com.jgeppert.struts2.jquery.handlebarsjs.views.jsp.ui.HandlebarsTag", description = "Handlebars js support", allowDynamicAttributes = true)
public class HandlebarsJs extends ClosingUIBean{

	private static final transient Random RANDOM = new Random();
	
    private static final String TEMPLATE = "handlebars";
    private static final String TEMPLATE_CLOSE = "handlebars-close";

    public static final String JQUERYACTION = "handlebars";

    public static final String PARAM_JQUERY_ACTION = "jqueryaction";
    private static final String PARAM_HREF = "href";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_TARGETS = "targets";
    private static final String PARAM_LISTEN_TOPICS = "listenTopics";
    private static final String PARAM_TPL_NAME = "templateName";
    static final String PARAM_ID = "id";
    
    private static final String ID_PREFIX_HANDLEBARS = "handlebars_";


    private String href;
    private String type;
    private String targets;
    private String listenTopics;
    private String templateName;



    public HandlebarsJs(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    @Override
    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    @Override
    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    protected void addParameterIfPresent(String parameterKey, String parameterValue) {
        addParameterIfPresent(parameterKey, parameterValue, null);
    }

    protected void addParameterIfPresent(String parameterKey, String parameterValue, Class<?> clazz) {
        if (parameterValue != null) {
            if (clazz != null) {
                addParameter(parameterKey, findValue(parameterValue, clazz));
            } else {
                addParameter(parameterKey, findString(parameterValue));
            }
        }
    }
    
    protected void addGeneratedIdParam(String prefix) {
        if (StringUtils.isBlank(this.id)) {
            // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
            // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
            int nextInt = RANDOM.nextInt();
            nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
            this.id = prefix + String.valueOf(nextInt);
            addParameter(PARAM_ID, this.id);
        }
    }

    @Override
    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_HREF, this.href);
        addParameterIfPresent(PARAM_TYPE, this.type);
        addParameterIfPresent(PARAM_TARGETS, this.targets);
        addParameterIfPresent(PARAM_LISTEN_TOPICS, this.listenTopics);
        addParameterIfPresent(PARAM_TPL_NAME, this.templateName);
        
        addGeneratedIdParam(ID_PREFIX_HANDLEBARS);

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
     * @param href the href to set
     */
    @StrutsTagAttribute(description = "(precompiled)-Template remote url")
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @param type the type to set
     */
    @StrutsTagAttribute(description = "Type of content : template = handlebars template, precompiled=precompiled template"
            ,defaultValue="handlebars")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param targets the targets to set
     */
    @StrutsTagAttribute(description = "Comma separated list of target containers id where the computed result will be put")
    public void setTargets(String targets) {
        this.targets = targets;
    }
    
    @StrutsTagAttribute(description = "Name of the template")
    public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
     * @param listenTopics the listenTopics to set
     */
    @StrutsTagAttribute(description = "Comma separated list of topics that trigger the computing")
    public void setListenTopics(String listenTopics) {
        this.listenTopics = listenTopics;
    }
}
