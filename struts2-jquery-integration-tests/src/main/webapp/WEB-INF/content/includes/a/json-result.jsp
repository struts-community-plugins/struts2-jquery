<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script type="text/javascript">
  jQuery.subscribe("handleJsonResult", function(event, data) {
    jQuery('#result').html('<ul id="lettersList"></ul>');
    var $lettersList = jQuery('#lettersList');
    jQuery.each(event.originalEvent.data, function(index, value) {
      $lettersList.append('<li>' + value + '</li>');
    });
  }); 
</script>

<s:url var="lettersUrl" namespace="/ajax" action="letters"/>

<div id="result" class="result ui-widget-content ui-corner-all">result div</div>
<sj:a id="ajaxjsonlink" href="%{lettersUrl}" dataType="json" onSuccessTopics="handleJsonResult" button="true" buttonIcon="ui-icon-refresh">
  Run AJAX action
</sj:a>

