<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urltabslocal" action="tabs-local"/><sj:a id="tabslocallink" href="%{urltabslocal}" targets="main">Local Tabs</sj:a></li>
      <li><s:url id="urltabs" action="tabs"/><sj:a id="tabslocalremote" href="%{urltabs}" targets="main">Remote Tabs with Topics</sj:a></li>
      <li><s:url id="urltabspreselect" action="tabs-preselect"/><sj:a id="tabspreselectedlink" href="%{urltabspreselect}" targets="main">Preselectet Tabs with Animation</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Local Tabs</h2>
    <p>
        A simple Local TabbedPanel
    </p>
    <sj:tabbedpanel id="localtabs" cssClass="list">
      <sj:tab id="tab1" target="tone" label="Local Tab One"/>
      <sj:tab id="tab2" target="ttwo" label="Local Tab Two"/>
      <sj:tab id="tab3" target="tthree" label="Local Tab Three"/>
      <sj:tab id="tab4" target="tfour" label="Local Tab Four"/>
      <div id="tone">Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.</div>
      <div id="ttwo">Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.</div>
      <div id="tthree">Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.</div>
      <div id="tfour">Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</div>
    </sj:tabbedpanel>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;sj:tabbedpanel id="localtabs"&gt;
      &lt;sj:tab id="tab1" target="tone" label="Local Tab One"/&gt;
      &lt;sj:tab id="tab2" target="ttwo" label="Local Tab Two"/&gt;
      &lt;sj:tab id="tab3" target="tthree" label="Local Tab Three"/&gt;
      &lt;sj:tab id="tab4" target="tfour" label="Local Tab Four"/&gt;
      &lt;div id="tone">Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.&lt;/div&gt;
      &lt;div id="ttwo">Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.&lt;/div&gt;
      &lt;div id="tthree">Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.&lt;/div&gt;
      &lt;div id="tfour">Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.&lt;/div&gt;
    &lt;/sj:tabbedpanel&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
