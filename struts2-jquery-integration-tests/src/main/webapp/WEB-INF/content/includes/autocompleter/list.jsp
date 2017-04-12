<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<sj:autocompleter id="autocompleterMonths" cssClass="extra-class" cssErrorClass="error-class" name="month"
    list="%{monthsList}" label="Select Month" selectBox="%{selectBox}" selectBoxIcon="%{selectBox}"/>