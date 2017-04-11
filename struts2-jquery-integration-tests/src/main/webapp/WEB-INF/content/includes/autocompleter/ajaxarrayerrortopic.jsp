<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<script type="text/javascript">
    var $errorContainer;
    $(function(){
       $errorContainer = $("#errorContainer");
       $.subscribe("autocompleteErrorTopic",function(){
           appendInErrorContainer("<p>topic1</p>");
       });
       $.subscribe("autocompleteErrorTopic2",function(){
           appendInErrorContainer("<p>topic2</p>");
       });
    });

    function appendInErrorContainer(content){
        $errorContainer.append(content);
    }
</script>
<s:url namespace="/ajax" action="months" var="ajaxMonthsArrayUrl"/>
<sj:autocompleter id="autocompleterMonths" name="month" href="a/wrong/url"
    onErrorTopics="autocompleteErrorTopic,autocompleteErrorTopic2" label="Select Month" loadMinimumCount="1" delay="50" />
<span id="errorContainer"></span>