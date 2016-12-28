<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url var="simpleTextAjaxUrl" namespace="/ajax" action="simple-text"/>

<sj:div id="ajaxdiv" deferredLoading="true" listenTopics="loaddiv" href="%{simpleTextAjaxUrl}" cssClass="ui-widget-content ui-corner-all">ajax div</sj:div>

<sj:a id="topicslink" href="#" onClickTopics="loaddiv" button="true" buttonIcon="ui-icon-gear">Click me!</sj:a>
