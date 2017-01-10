<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url namespace="/ajax" action="lettersinobject" var="lettersJsonUrl"/>
<sj:radio id="radiobuttonset" tooltip="Choose your letter" label="letter" href="%{lettersJsonUrl}" list="letters" name="letter"/>

