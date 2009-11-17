<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlprogressbar" action="progressbar"/><sj:a id="progressbarsimplelink" href="%{urlprogressbar}" targets="main">Progressbar</sj:a></li>
      <li><s:url id="urlprogressbarchange" action="progressbar-change"/><sj:a id="progressbarchangelink" href="%{urlprogressbarchange}" targets="main">Progressbar with change event</sj:a></li>
      <li><s:url id="urlprogressbarresizeable" action="progressbar-resizeable"/><sj:a id="progressbarresizeablelink" href="%{urlprogressbarresizeable}" targets="main">Resizeable progressbar</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <script type="text/javascript">
    $.subscribe('mychangetopic', function(event,data) {
        alert('value changed to : '+$("#progressbarchange").progressbar('option', 'value'));
    });
    $.subscribe('myclicktopic', function(event,data) {
         $("#progressbarchange").progressbar( 'value' , parseInt( Math.random() * ( 90 ) ) );
    });
    </script>        
    <h2>Progressbar with change event</h2>
    <p>
        A Progressbar that raise an event when change value.
    </p>
    <sj:progressbar id="progressbarchange" value="21" onChangeTopics="mychangetopic"/>
    <br />
    <sj:a href="#" onClickTopics="myclicktopic" cssClass="buttonlink ui-state-default ui-corner-all"><span class="ui-icon ui-icon-refresh"></span>change value</sj:a>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>JavaScript functions:</strong>
    <pre>
    $.subscribe('mychangetopic', function(event,data) {
        alert('value changed to : '+$(&quot;#progressbarchange&quot;).progressbar('option', 'value'));
    });
    $.subscribe('myclicktopic', function(event,data) {
         $(&quot;#progressbarchange&quot;).progressbar( 'value' , parseInt( Math.random() * ( 90 ) ) );
    });
    </pre>
    <strong>Code:</strong>
    <pre>
    &lt;sj:progressbar id=&quot;progressbarchange&quot; value=&quot;21&quot; onChangeTopics=&quot;mychangetopic&quot;/&gt;
    &lt;br /&gt;
    &lt;sj:a href=&quot;#&quot; onClickTopics=&quot;myclicktopic&quot; cssClass=&quot;buttonlink ui-state-default ui-corner-all&quot;&gt;&lt;span class=&quot;ui-icon ui-icon-refresh&quot;&gt;&lt;/span&gt;change value&lt;/sj:a&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
    $('.buttonlink').hover(
            function() { $(this).addClass('ui-state-hover'); }, 
            function() { $(this).removeClass('ui-state-hover'); }
    );
});
</script>
