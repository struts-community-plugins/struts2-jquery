package com.jgeppert.struts2.jquery.components;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

public abstract class AbstractBase extends ClosingUIBean implements Base {

    final private static transient Random RANDOM = new Random(); 
    
	public AbstractBase(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
	}

	protected String hideTopics;
	protected String showTopics;
	protected String removeTopics;


	@Override
    public void evaluateParams() {
        
        if (id == null || id.toString().length() == 0) {
         
            int nextInt = RANDOM.nextInt();
            nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);  
            id = "_struts2_jquery_" + Math.abs(nextInt);
        }
        
        addParameter("id", id);
        
        super.evaluateParams();
	}
	
	@Override
    public void evaluateExtraParams() {
    	
        if (hideTopics != null)
            addParameter("hideTopics", findString(hideTopics));
        if (showTopics != null)
            addParameter("showTopics", findString(showTopics));
        if (removeTopics != null)
            addParameter("removeTopics", findString(removeTopics));
    }
	
        
	//FIXME: should be retrieving constant from above
	@Override
    public String getTheme() {
    	return "jquery";
    }
    
    protected void setStack(ValueStack stack){
    	this.stack = stack;
    }

    @SuppressWarnings("unchecked")
	protected void setParameters(Map parameters){
    	this.parameters = parameters;
    }

    protected String ensureAttributeSafelyNotEscaped(String val) {
        if (val != null) {
            return val.replaceAll("\"", "&#34;");
        } else {
            return "";
        }
    }

    @StrutsTagAttribute(name="hideTopics", description = "A comma delimited list of topics that will hide (display: none) this element", type = "String", defaultValue = "")
	public void setHideTopics(String hideTopics) {
		this.hideTopics = hideTopics;
	}

	@StrutsTagAttribute(name="removeTopics", description = "A comma delimited list of topics that will remove this element from the dom", type = "String", defaultValue = "")
	public void setRemoveTopics(String removeTopics) {
		this.removeTopics = removeTopics;
	}

	@StrutsTagAttribute(name="showTopics", description = "A comma delimited list of topics that will show (display: block) this element", type = "String", defaultValue = "")
	public void setShowTopics(String showTopics) {
		this.showTopics = showTopics;
	}
}
