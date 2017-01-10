<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url namespace="/ajax" action="lettersinobject" var="lettersJsonUrl"/>
<sj:select id="myselect" list="letterObjects" listKey="numberValue" listValue="letter" name="letter" href="%{lettersJsonUrl}"/>

