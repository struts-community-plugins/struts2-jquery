<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<div id="result1" class="result ui-widget-content ui-corner-all">formResult div 1</div>
<div id="result2" class="result ui-widget-content ui-corner-all">formResult div 2</div>

<s:form id="firstform" action="echo" namespace="/">
  <s:label for="echo">Echo</s:label>
  <s:textfield id="echo1" name="echo" value="firstform"/>
  <sj:submit id="formsubmit1" targets="result1" value="Submit Form" button="true" onClickTopics="clickformsubmit1"/>
</s:form>

<s:form id="secondform" action="echo" namespace="/">
  <s:label for="echo">Echo</s:label>
  <s:textfield id="echo2" name="echo" value="secondform"/>
  <sj:submit id="formsubmit2" targets="result2" value="Submit Form" button="true" listenTopics="clickformsubmit1"/>
</s:form>
