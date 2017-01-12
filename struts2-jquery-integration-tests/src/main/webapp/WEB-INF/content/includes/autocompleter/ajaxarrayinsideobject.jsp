<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<s:url namespace="/ajax" action="monthsinobject" var="ajaxMonthsInObjectUrl"/>
<sj:autocompleter id="autocompleterMonths" name="month" href="%{ajaxMonthsInObjectUrl}" label="Select Month" loadMinimumCount="1" delay="50" list="months" />

