<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script type="text/javascript">
  jQuery.subscribe("beforeformsubmit", function(event, data) {
    document.getElementById("ajaxeventsdiv").appendChild(document.createTextNode("ajax submit clicked"));
  }); 

  jQuery.subscribe("formsubmitcomplete", function(event, data) {
    document.getElementById("ajaxeventsdiv").appendChild(document.createTextNode("ajax submit complete"));
  }); 
</script>

<div id="formResult" class="result ui-widget-content ui-corner-all">formResult div</div>

<s:form id="form" action="echo" namespace="/">
  <s:label for="echo">Echo</s:label>
  <s:textfield id="echo" name="echo" value="something to echo"/>
  <sj:submit id="formsubmit" onBeforeTopics="beforeformsubmit" onCompleteTopics="formsubmitcomplete" targets="formResult" value="Submit Form" button="true"/>
</s:form>
<div id="ajaxeventsdiv"></div>
