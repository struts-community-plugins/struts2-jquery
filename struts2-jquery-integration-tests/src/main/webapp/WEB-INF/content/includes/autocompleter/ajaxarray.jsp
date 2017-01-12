<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<s:url namespace="/ajax" action="months" var="ajaxMonthsArrayUrl"/>
<sj:autocompleter id="autocompleterMonths" name="month" href="%{ajaxMonthsArrayUrl}" label="Select Month" loadMinimumCount="1" delay="50" />

