<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url var="echoUrl" namespace="/" action="echo"/>
<sj:menu id="myMenu" cssStyle="width:50%" paramName="echo" href="%{echoUrl}" targets="resultDiv" list="#{'Item 1', 'Item 2', 'Item 3'}" />
<div id="resultDiv">
  This is the result div.
</div>
