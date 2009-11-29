<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlgrid" action="grid"/><sj:a href="%{urlgrid}" targets="main">Grid</sj:a></li>
      <li><s:url id="urlgridedit" action="grid-edit"/><sj:a href="%{urlgridedit}" targets="main">Grid (Editable)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <script type="text/javascript">
    $.subscribe('rowselect', function(event,data) {
        alert('Edit : '+event.originalEvent.id);
    });
    </script>
    <h2>Grid</h2>
    <p>
        A editable Grid
    </p>
    <s:url id="remoteurl" action="jsontable"/> 
    <s:url id="editurl" action="editGridEntry"/> 
    <sj:grid 
    	id="gridtable" 
    	caption="Customer Examples" 
    	dataType="json" 
    	href="%{remoteurl}" 
    	pager="mypager" 
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	editurl="%{editurl}"
    	onSelectRow="rowselect"
    >
    	<sj:gridColumn name="id" index="id" title="ID" formatter="integer"/>
    	<sj:gridColumn name="name" index="name" title="Name" editable="true" edittype="text"/>
    	<sj:gridColumn name="country" index="country" title="Country" editable="true" edittype="text"/>
    	<sj:gridColumn name="city" index="city" title="City" editable="true" edittype="text"/>
    	<sj:gridColumn name="creditLimit" index="creditLimit" title="Credit Limit" formatter="currency" editable="true" edittype="text"/>
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
