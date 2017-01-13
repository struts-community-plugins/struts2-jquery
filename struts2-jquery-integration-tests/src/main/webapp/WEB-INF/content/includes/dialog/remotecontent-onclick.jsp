<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
 
<s:url var="simpleTextAjaxUrl" namespace="/ajax" action="simple-text"/>
<sj:dialog id="mydialog" title="Dialog with remote content" modal="true" autoOpen="false" href="%{simpleTextAjaxUrl}"/>
<sj:a id="modalOpenLink" openDialog="mydialog" button="true" buttonIcon="ui-icon-newwin" >
    Open modal dialog
</sj:a>

