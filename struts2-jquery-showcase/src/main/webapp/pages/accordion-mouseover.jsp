<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url var="urlaccordion" action="accordion"/><sj:a href="%{urlaccordion}" targets="main">Accordion</sj:a></li>
      <li><s:url var="urlaccordionlist" action="accordion-list"/><sj:a href="%{urlaccordionlist}" targets="main">Accordion from List</sj:a></li>
      <li><s:url var="urlaccordionremote" action="accordion-remote"/><sj:a href="%{urlaccordionremote}" targets="main">Accordion with remote content</sj:a></li>
      <li><s:url var="urlaccordionmouseover" action="accordion-mouseover"/><sj:a href="%{urlaccordionmouseover}" targets="main">Accordion Collabsible/MouseOver</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Accordion</h2>
    <p class="text">
        A Accordion that opens on mouse over and is collabsible.
    </p>
    <sj:accordion 
    	id="accordionmouseover" 
    	list="accordion" 
    	active="false" 
    	openOnMouseover="true" 
    	collapsible="true"
    />
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code in JSP:</strong>
    <pre>
    &lt;sj:accordion 
    	id=&quot;accordionmouseover&quot; 
    	list=&quot;accordion&quot; 
    	active=&quot;false&quot; 
    	openOnMouseover=&quot;true&quot; 
    	collapsible=&quot;true&quot;
    /&gt;
    </pre>
    <strong>Code in Action:</strong>
    <pre>
    private Map&lt;String, String&gt; accordion;

    public String execute() throws Exception {
        accordion = new HashMap&lt;String, String&gt;();
        accordion.put(&quot;Section 1&quot;, &quot;Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.&quot;);
        accordion.put(&quot;Section 2&quot;, &quot;Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.&quot;);
        accordion.put(&quot;Section 3&quot;, &quot;Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.&quot;);
        accordion.put(&quot;Section 4&quot;, &quot;Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.&quot;);
        return SUCCESS;
    }

    public Map&lt;String, String&gt; getAccordion() {
        return accordion;
    }
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
