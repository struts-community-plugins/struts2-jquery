<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlgrid" action="grid"/><sj:a href="%{urlgrid}" targets="main">Grid</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Grid</h2>
    <p>
        A simple Grid
    </p>
    <s:url id="remoteurl" action="jsontable"/> 
    <sj:grid id="gridtable" caption="Grid Example" dataType="json" href="%{remoteurl}" pager="mypager" gridModel="table">
    	<sj:gridColumn name="key" index="key" title="Column One"/>
    	<sj:gridColumn name="value" index="value" title="Column Two"/>
    	<sj:gridColumn name="num" index="num" title="Column Three"/>
    	<sj:gridColumn name="dub" index="dub" title="Column Four"/>
    </sj:grid>
    <div id="mypager"></div>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code in JSP:</strong>
    <pre>
    </pre>
    <strong>Code in Action:</strong>
    <pre>
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
