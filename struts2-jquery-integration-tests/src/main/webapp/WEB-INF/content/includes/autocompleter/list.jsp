<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<s:if test="%{selectBox }">
    <sj:autocompleter id="autocompleterMonths" cssClass="extra-class" cssErrorClass="error-class" name="month"
    	list="%{monthsList}" label="Select Month" selectBox="true" selectBoxIcon="true"/>
</s:if>
<s:else>
	<sj:autocompleter id="autocompleterMonths" cssClass="extra-class" cssErrorClass="error-class" name="month"
    list="%{monthsList}" label="Select Month" />
</s:else>