<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlgrid" action="grid"/><sj:a href="%{urlgrid}" targets="main">Grid</sj:a></li>
      <li><s:url id="urlgridedit" action="grid-edit"/><sj:a href="%{urlgridedit}" targets="main">Grid (Editable)</sj:a></li>
      <li><s:url id="urlgridloadonce" action="grid-loadonce"/><sj:a href="%{urlgridloadonce}" targets="main">Grid (Local Data)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <script type="text/javascript">
    $.subscribe('searchgrid', function(event,data) {
        $("#gridloadtable").jqGrid('searchGrid', {sopt:['cn','bw','eq','ne','lt','gt','ew']} );
  	});
    $.subscribe('showcolumns', function(event,data) {
        $("#gridloadtable").jqGrid('setColumns',{});
  	});
    </script>
    <h2>Grid</h2>
    <p>
        A simple Grid
    </p>
    <s:url id="remoteurl" action="jsontable">
    	<s:param name="loadonce" value="%{true}"></s:param>
    </s:url> 
    <sj:grid 
    	id="gridloadtable" 
    	loadonce="true"
    	caption="Customer Examples (Local Data)" 
    	dataType="json" 
    	href="%{remoteurl}" 
    	pager="false" 
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="-1"
    	hidegrid="true"
    	scroll="true"
    >
    	<sj:gridColumn name="id" index="id" key="true" title="ID" formatter="integer" sortable="true"/>
    	<sj:gridColumn name="name" index="name" title="Company" sortable="true"/>
    	<sj:gridColumn name="lastName" index="lastName" title="Last Name" sortable="true" hidden="true"/>
    	<sj:gridColumn name="firstName" index="firstName" title="First Name" sortable="true" hidden="true"/>
    	<sj:gridColumn name="addressLine1" index="addressLine1" title="Adress" sortable="true" hidden="true"/>
    	<sj:gridColumn name="country" index="country" title="Country" sortable="true"/>
    	<sj:gridColumn name="city" index="city" title="City" sortable="true"/>
    	<sj:gridColumn name="creditLimit" index="creditLimit" title="Credit Limit" formatter="currency" sortable="true"/>
    </sj:grid>
	<br/>
    <sj:submit id="searchbutton" value="Search" onClickTopics="searchgrid" cssClass="buttonlink ui-state-default ui-corner-all"/>
    <sj:submit id="colsbutton" value="Show/Hide Columns" onClickTopics="showcolumns" cssClass="buttonlink ui-state-default ui-corner-all"/>
	<br/>
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
