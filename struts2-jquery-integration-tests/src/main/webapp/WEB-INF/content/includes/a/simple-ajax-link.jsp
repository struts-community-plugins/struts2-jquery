<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url var="ajax" namespace="/ajax" action="simple-text"/>

<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
<sj:a id="ajaxlink" href="%{ajax}" targets="result" indicator="indicator" button="true" buttonIcon="ui-icon-refresh">
  Run AJAX action
</sj:a>

