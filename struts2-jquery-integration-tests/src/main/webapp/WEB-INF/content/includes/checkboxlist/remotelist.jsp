<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url namespace="/ajax" action="lettersinobject" var="lettersJsonUrl"/>
<sj:checkboxlist id="checkboxbuttonset" tooltip="Choose your letters" label="letters" href="%{lettersJsonUrl}" list="letters" name="letters"/>

