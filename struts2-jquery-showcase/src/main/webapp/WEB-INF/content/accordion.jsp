<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Accordion</h2>

<p class="text">
	A simple Accordion.
</p>
<s:url var="urlajax1" action="ajax1"/>
<s:url var="urlajax4" action="ajax4"/>
<sj:accordion id="accordion" heightStyle="content" animate="true">
	<sj:accordionItem title="Mauris mauris ante">
		<sj:div id="divInAccrodionItem1" href="%{urlajax1}"/>
	</sj:accordionItem>
	<sj:accordionItem title="Sed non urna">
		Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.
	</sj:accordionItem>
	<sj:accordionItem title="Nam enim risus">
		Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
	</sj:accordionItem>
	<sj:accordionItem title="Cras dictum" onClickTopics="loadAccordionDiv">
		<sj:div id="divInAccrodionItem4" href="%{urlajax4}" listenTopics="loadAccordionDiv" deferredLoading="true"/>
	</sj:accordionItem>
</sj:accordion>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
    <pre>
    &lt;s:url var=&quot;urlajax1&quot; action=&quot;ajax1&quot;/&gt;
    &lt;s:url var=&quot;urlajax4&quot; action=&quot;ajax4&quot;/&gt;
    &lt;sj:accordion id=&quot;accordion&quot; heightStyle=&quot;content&quot; animate=&quot;true&quot;&gt;
    	&lt;sj:accordionItem title=&quot;Mauris mauris ante&quot;&gt;
    		&lt;sj:div id=&quot;divInAccrodionItem1&quot; href=&quot;%{urlajax1}&quot; /&gt;
    	&lt;/sj:accordionItem&gt;
    	&lt;sj:accordionItem title=&quot;Sed non urna&quot;&gt;
    		Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.
    	&lt;/sj:accordionItem&gt;
    	&lt;sj:accordionItem title=&quot;Nam enim risus&quot;&gt;
    		Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
    	&lt;/sj:accordionItem&gt;
    	&lt;sj:accordionItem title=&quot;Cras dictum&quot; onClickTopics=&quot;loadAccordionDiv&quot;&gt;
    		&lt;sj:div id=&quot;divInAccrodionItem4&quot; href=&quot;%{urlajax4}&quot; listenTopics=&quot;loadAccordionDiv&quot; deferredLoading=&quot;true&quot;/&gt;
    	&lt;/sj:accordionItem&gt;
    &lt;/sj:accordion&gt;
    </pre>
</div>
