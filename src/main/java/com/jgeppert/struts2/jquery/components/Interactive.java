package com.jgeppert.struts2.jquery.components;

import org.apache.struts2.views.annotations.StrutsTagAttribute;

public interface Interactive extends Base {

	/**  TOPIC LISTENERS **/
	@StrutsTagAttribute(name="enableTopics", description = "A comma delimited list of topics that will enable this element", type = "String", defaultValue = "")
	public void setEnableTopics(String enableTopics);

	@StrutsTagAttribute(name="disableTopics", description = "A comma delimited list of topics that will disable this element", type = "String", defaultValue = "")
	public void setDisableTopics(String disableTopics);

	/**  TOPIC PUBLISHERS **/
	
	/**  SPECIAL **/
}
