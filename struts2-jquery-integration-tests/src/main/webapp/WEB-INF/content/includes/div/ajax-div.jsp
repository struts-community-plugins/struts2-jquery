<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url var="simpleTextAjaxUrl" namespace="/ajax" action="simple-text"/>

<sj:div id="ajaxdiv" href="%{simpleTextAjaxUrl}" cssClass="ui-widget-content ui-corner-all"/>
<sj:div/>

<sj:div/>
