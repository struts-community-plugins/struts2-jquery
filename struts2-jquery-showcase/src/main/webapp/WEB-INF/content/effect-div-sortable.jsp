<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Sortable</h2>

<p class="text">
	A simple sortable div list
</p>
<strong>Div :</strong><br/>
<sj:div id="sortable" sortable="true" sortableOpacity="0.8" sortablePlaceholder="ui-state-highlight"
        sortableForcePlaceholderSize="true" cssStyle="width: 300px;">
	<div id="one" class="sortable ui-widget-content ui-corner-all">One</div>
	<div id="two" class="sortable ui-widget-content ui-corner-all">Two</div>
	<div id="three" class="sortable ui-widget-content ui-corner-all">Three</div>
	<div id="four" class="sortable ui-widget-content ui-corner-all">Four</div>
	<div id="five" class="sortable ui-widget-content ui-corner-all">Five</div>
	<div id="six" class="sortable ui-widget-content ui-corner-all">Six</div>
	<div id="seven" class="sortable ui-widget-content ui-corner-all">Seven</div>
</sj:div>

<div class="code ui-widget-content ui-corner-all" style="clear: left;">
	<strong>Styles:</strong>
      <pre>
.sortable {
border:1px solid #000;
height:20px;
margin:5px;
padding:10px;
text-align: center;
}
      </pre>
	<strong>Code:</strong>
	  <pre>
    &lt;sj:div id=&quot;sortable&quot; sortable=&quot;true&quot; sortableOpacity=&quot;0.8&quot; sortablePlaceholder=&quot;ui-state-highlight&quot; sortableForcePlaceholderSize=&quot;true&quot; cssStyle=&quot;width: 300px;&quot;&gt;
        &lt;div id=&quot;one&quot; class=&quot;sortable ui-widget-content ui-corner-all&quot;&gt;One&lt;/div&gt;
        &lt;div id=&quot;two&quot; class=&quot;sortable ui-widget-content ui-corner-all&quot;&gt;Two&lt;/div&gt;
        &lt;div id=&quot;three&quot; class=&quot;sortable ui-widget-content ui-corner-all&quot;&gt;Three&lt;/div&gt;
        &lt;div id=&quot;four&quot; class=&quot;sortable ui-widget-content ui-corner-all&quot;&gt;Four&lt;/div&gt;
        &lt;div id=&quot;five&quot; class=&quot;sortable ui-widget-content ui-corner-all&quot;&gt;Five&lt;/div&gt;
        &lt;div id=&quot;six&quot; class=&quot;sortable ui-widget-content ui-corner-all&quot;&gt;Six&lt;/div&gt;
        &lt;div id=&quot;seven&quot; class=&quot;sortable ui-widget-content ui-corner-all&quot;&gt;Seven&lt;/div&gt;
    &lt;/sj:div&gt;
	  </pre>
</div>
