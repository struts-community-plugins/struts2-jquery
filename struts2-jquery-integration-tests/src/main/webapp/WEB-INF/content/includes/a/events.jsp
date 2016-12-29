<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script type="text/javascript">
  jQuery.subscribe("ajaxlinkclick", function(event, data) {
    alert("ajax link clicked");
  }); 

  jQuery.subscribe("ajaxlinkcomplete", function(event, data) {
    alert("ajax link complete");
  }); 
</script>

<s:url var="ajax" namespace="/ajax" action="simple-text"/>

<div id="result" class="result ui-widget-content ui-corner-all">result div</div>
<sj:a id="ajaxlink" href="%{ajax}" targets="result" onClickTopics="ajaxlinkclick" onCompleteTopics="ajaxlinkcomplete" button="true" buttonIcon="ui-icon-refresh">
  Run AJAX action
</sj:a>

