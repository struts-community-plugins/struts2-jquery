package com.jgeppert.struts2.jquery.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

public abstract class AbstractInteractive extends AbstractBase implements Interactive {

	protected String enableTopics;			//topics that will enable element
	protected String disableTopics;			//topics that will disable element
		
	public AbstractInteractive(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		
		super(stack, request, response);
	}

    public void evaluateExtraParams() {
        
        super.evaluateExtraParams();
            	
        if (enableTopics != null)
            addParameter("enableTopics", findString(enableTopics));
        if (disableTopics != null)
            addParameter("disableTopics", findString(disableTopics));
    }
    
    protected void setStack(ValueStack stack){
    	this.stack = stack;
    }

	@StrutsTagAttribute(name="enableTopics", description = "A comma delimited list of topics that will enable this element", type = "String", defaultValue = "")
    public void setEnableTopics(String enableTopics) {
		this.enableTopics = enableTopics;
	}

	@StrutsTagAttribute(name="disableTopics", description = "A comma delimited list of topics that will disable this element", type = "String", defaultValue = "")
    public void setDisableTopics(String disableTopics) {
		this.disableTopics = disableTopics;
	}
   
}
