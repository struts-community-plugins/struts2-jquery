<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url namespace="/ajax" action="lettersinobject" var="lettersJsonUrl"/>
<sj:select id="myselect" tooltip="Choose your letter" label="letter" list="letters" name="letter" href="%{lettersJsonUrl}"/>

