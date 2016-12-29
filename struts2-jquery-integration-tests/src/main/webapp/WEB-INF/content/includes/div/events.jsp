<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script type="text/javascript">
  jQuery.subscribe('beforeDiv', function(event,data) {
    alert('Before div');
  });

  jQuery.subscribe('completeDiv', function(event,data) {
    alert('Complete div');
  });
</script>

<s:url var="simpleTextAjaxUrl" namespace="/ajax" action="simple-text"/>

<sj:div id="ajaxdiv" href="%{simpleTextAjaxUrl}" onBeforeTopics="beforeDiv" onCompleteTopics="completeDiv" cssClass="ui-widget-content ui-corner-all"/>
