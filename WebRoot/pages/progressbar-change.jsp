<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlprogressbar" action="progressbar"/><sj:a href="%{urlprogressbar}" targets="main">Progressbar</sj:a></li>
      <li><s:url id="urlprogressbarchange" action="progressbar-change"/><sj:a href="%{urlprogressbarchange}" targets="main">Progressbar with change event</sj:a></li>
      <li><s:url id="urlprogressbarresizeable" action="progressbar-resizeable"/><sj:a href="%{urlprogressbarresizeable}" targets="main">Resizeable progressbar</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <script type="text/javascript">
    $.subscribe('change', function(event,data) {
        alert('value changed to : '+event.originalEvent.ui.value);
    });
     function changeValue(){
         $("#progressbarchange").progressbar( 'value' , parseInt( Math.random() * ( 90 ) ) );
     }
    </script>        
    <h2>Progressbar with change event</h2>
    <p>
        A Progressbar that raise an event when change value.
    </p>
    <sj:progressbar id="progressbarchange" value="21" onChangeTopics="change"/>
    <br />
    <a href="#" onclick="changeValue()" class="buttonlink ui-state-default ui-corner-all"><span class="ui-icon ui-icon-refresh"></span>change value</a>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;script type="text/javascript"&gt;
     function change(event, ui){
         alert('value changed');
     }
     function changeValue(){
         $("#progressbarchange").progressbar( 'value' , parseInt( Math.random() * ( 90 ) ) )
     }
    &lt;/script&gt;        

    &lt;sj:progressbar id="progressbar" value="21" change="change"/&gt;
    &lt;a href="#" onclick="changeValue()"&gt;change value&lt;/a&gt;        
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
