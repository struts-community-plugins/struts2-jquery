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
    $.subscribe('rowselect', function(event,data) {
        $("#gridinfo").html('<p>Edit Mode for Row : '+event.originalEvent.id+'</p>');
    });
    $.subscribe('rowadd', function(event,data) {
        $("#gridedittable").jqGrid('editGridRow',"new",{height:280,reloadAfterSubmit:false}); 
  	});
    $.subscribe('searchgrid', function(event,data) {
        $("#gridedittable").jqGrid('searchGrid', {sopt:['cn','bw','eq','ne','lt','gt','ew']} );
  	});
    $.subscribe('showcolumns', function(event,data) {
        $("#gridedittable").jqGrid('setColumns',{});
  	});
    </script>
    <h2>Grid</h2>
    <p>
        A editable Grid with pager and navigator. Entries are editable when a cell is selected.  
    </p>
    <s:url id="remoteurl" action="jsontable"/> 
    <s:url id="editurl" action="edit-grid-entry"/> 
    <sj:grid 
    	id="gridedittable" 
    	caption="Customer Examples (Editable)" 
    	dataType="json" 
    	href="%{remoteurl}" 
    	pager="true" 
    	navigator="true"
    	navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
    	navigatorAddOptions="{height:280,reloadAfterSubmit:false}"
    	navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
    	navigatorEdit="false"
    	navigatorView="true"
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	editurl="%{editurl}"
    	onSelectRow="rowselect"
    >
    	<sj:gridColumn name="id" index="id" title="ID" formatter="integer" editable="false" sortable="false" search="true" searchoptions="{sopt:['eq','ne','lt','gt']}"/>
    	<sj:gridColumn name="name" index="name" title="Name" editable="true" edittype="text" sortable="true" search="false"/>
    	<sj:gridColumn name="lastName" index="lastName" title="Last Name" sortable="false" hidden="true"/>
    	<sj:gridColumn name="firstName" index="firstName" title="First Name" sortable="false" hidden="true"/>
    	<sj:gridColumn name="addressLine1" index="addressLine1" title="Adress" sortable="false" hidden="true"/>
    	<sj:gridColumn name="country" index="country" title="Country" editable="true" edittype="select" editoptions="{value:'France:France;USA:USA;Australia:Australia;Norway:Norway;Poland:Poland;Germany:Germany;Spain:Spain'}" sortable="false" search="false"/>
    	<sj:gridColumn name="city" index="city" title="City" editable="true" edittype="text" sortable="false" search="false"/>
    	<sj:gridColumn name="creditLimit" index="creditLimit" title="Credit Limit" formatter="currency" editable="true" edittype="text" sortable="false" search="false"/>
    </sj:grid>
	<br/>
    <sj:submit id="addbutton" value="Add Row" onClickTopics="rowadd" cssClass="buttonlink ui-state-default ui-corner-all"/>
    <sj:submit id="searchbutton" value="Search" onClickTopics="searchgrid" cssClass="buttonlink ui-state-default ui-corner-all"/>
    <sj:submit id="colsbutton" value="Show/Hide Columns" onClickTopics="showcolumns" cssClass="buttonlink ui-state-default ui-corner-all"/>
	<br/>
	<br/>
    <div id="gridinfo" class="ui-widget-content ui-corner-all"><p>Edit Mode for Row :</p></div>
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
<script type="text/javascript">
$(document).ready(function() {
    $('.buttonlink').hover(
            function() { $(this).addClass('ui-state-hover'); }, 
            function() { $(this).removeClass('ui-state-hover'); }
    );
});
</script>
