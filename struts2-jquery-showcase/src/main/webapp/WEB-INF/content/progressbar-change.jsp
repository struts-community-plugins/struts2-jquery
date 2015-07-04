<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Progressbar with change event</h2>

<p class="text">
	A Progressbar that raise an event when change value.
</p>
<sj:progressbar id="progressbarchange" value="21" onChangeTopics="progressbarchangetopic"/>
<br/>
<sj:a
		href="#"
		onClickTopics="progressbarclicktopic"
		button="true"
		buttonIcon="ui-icon-gear"
		>
	change value
</sj:a>

<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs" cssClass="list">
    <sj:tab id="tab1" target="jsp" label="JSP Code"/>
    <sj:tab id="tab2" target="java" label="JavaScript"/>
    <div id="jsp">
	  <pre>
            <code class="html">
&lt;sj:progressbar id=&quot;progressbarchange&quot; value=&quot;21&quot; onChangeTopics=&quot;progressbarchangetopic&quot;/&gt;
&lt;br /&gt;
&lt;sj:a
    href=&quot;#&quot;
    onClickTopics=&quot;progressbarclicktopic&quot;
    button=&quot;true&quot;
    buttonIcon=&quot;ui-icon-gear&quot;
&gt;
change value
&lt;/sj:a&gt;
            </code>
	  </pre>
    </div>
    <div id="java">
	  <pre>
            <code class="javascript">
$.subscribe('progressbarchangetopic', function(event,data) {
    alert('value changed to : '+$(&quot;#progressbarchange&quot;).progressbar('option', 'value'));
});
$.subscribe('progressbarclicktopic', function(event,data) {
    $(&quot;#progressbarchange&quot;).progressbar( 'value' , parseInt( Math.random() * ( 90 ) ) );
});

            </code>
	  </pre>
    </div>

</sj:tabbedpanel>
