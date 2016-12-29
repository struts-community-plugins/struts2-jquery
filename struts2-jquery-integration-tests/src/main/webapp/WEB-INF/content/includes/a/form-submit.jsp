<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<div id="formResult" class="result ui-widget-content ui-corner-all">formResult div</div>

<s:form id="form" action="echo" namespace="/">
  <s:label for="echo">Echo</s:label>
  <s:textfield id="echo" name="echo" value="something to echo"/>
</s:form>
<sj:a id="ajaxformlink" formIds="form" targets="formResult" clearForm="true" indicator="indicator" button="true" buttonIcon="ui-icon-gear">
  Submit form
</sj:a>

