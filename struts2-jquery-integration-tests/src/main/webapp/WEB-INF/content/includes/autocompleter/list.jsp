<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<<<<<<< Upstream, based on origin/release/4.0.3
<s:if test="%{selectBox }">
    <sj:autocompleter id="autocompleterMonths" cssClass="extra-class" cssErrorClass="error-class" name="month"
    	list="%{monthsList}" label="Select Month" selectBox="true" selectBoxIcon="true"/>
</s:if>
<s:else>
	<sj:autocompleter id="autocompleterMonths" cssClass="extra-class" cssErrorClass="error-class" name="month"
    list="%{monthsList}" label="Select Month" />
</s:else>
=======
<sj:autocompleter id="autocompleterMonths" cssClass="extra-class" cssErrorClass="error-class" name="month"
    list="%{monthsList}" label="Select Month" selectBox="%{selectBox}" selectBoxIcon="%{selectBox}"/>
>>>>>>> a097000 #140 - Fixes missing JS when loadAtOnce=false #46 #36 - add Test cases for autocompleter in selectBox mode
