<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<s:url namespace="/ajax" action="monthsinobject" var="ajaxMonthsInObjectUrl"/>
<sj:select
id="autocompleterMonths"
name="month"
list="monthObjects" listKey="number" listValue="month"
href="%{ajaxMonthsInObjectUrl}" emptyOption="true"
autocomplete="true" loadMinimumCount="1"
cssClass="extra-class"
/>