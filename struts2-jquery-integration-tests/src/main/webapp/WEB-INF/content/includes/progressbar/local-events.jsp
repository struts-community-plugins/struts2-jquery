<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script type="text/javascript">
  jQuery.subscribe("progressbarChange", function() {
    alert('value changed to : '+ jQuery("#myProgressbar").progressbar('option', 'value'));
  })

  jQuery.subscribe("clickLink", function() {
    jQuery("#myProgressbar").progressbar('value', 84);
  })
</script>
<sj:progressbar id="myProgressbar" value="42" onChangeTopics="progressbarChange"/>
<sj:a id="myButton" href="#" onClickTopics="clickLink" button="true" buttonIcon="ui-icon-gear" >
change value
</sj:a>
