<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url var="simpleTextAjaxUrl" namespace="/ajax" action="simple-text"/>
<sj:dialog id="mydialog" href="%{simpleTextAjaxUrl}" title="Dialog with remote content"/>
