<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url var="ajax" namespace="/ajax" action="simple-text"/>

<div id="div1" class="result ui-widget-content ui-corner-all">Div 1</div>
<div id="div2" class="result ui-widget-content ui-corner-all">Div 2</div>
<sj:a id="ajaxlink" href="%{ajax}" targets="div1,div2" indicator="indicator" button="true" buttonIcon="ui-icon-refresh">
  Run AJAX action
</sj:a>

