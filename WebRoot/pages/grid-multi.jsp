<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlgrid" action="grid"/><sj:a href="%{urlgrid}" targets="main">Grid</sj:a></li>
      <li><s:url id="urlgridedit" action="grid-edit"/><sj:a href="%{urlgridedit}" targets="main">Grid (Editable)</sj:a></li>
      <li><s:url id="urlgridmulti" action="grid-multi"/><sj:a href="%{urlgridmulti}" targets="main">Grid (Editable/Multiselect)</sj:a></li>
      <li><s:url id="urlgridloadonce" action="grid-loadonce"/><sj:a href="%{urlgridloadonce}" targets="main">Grid (Local Data)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <script type="text/javascript">
    $.subscribe('getselectedids', function(event,data) {
    	var s; 
    	s = $("#gridmultitable").jqGrid('getGridParam','selarrrow');
    	alert('Selected Rows : '+s); 
  	});
    </script>
    <h2>Grid (Editable/Multiselect)</h2>
    <p>
        A editable Grid with pager and navigator.  
    </p>
    <s:url id="remoteurl" action="jsontable"/> 
    <s:url id="editurl" action="edit-grid-entry"/> 
    <sj:grid 
    	id="gridmultitable" 
    	caption="Customer Examples (Editable/Multiselect)" 
    	dataType="json" 
    	href="%{remoteurl}" 
    	pager="true" 
    	navigator="true"
    	navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
    	navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
    	navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
    	navigatorEdit="true"
    	navigatorView="true"
    	navigatorDelete="true"
    	navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	editurl="%{editurl}"
    	multiselect="true"
    	onSelectRowTopics="rowselect"
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
    <sj:submit id="grid_multi_getselectedbutton" value="Get Selected Rows" onClickTopics="getselectedids" cssClass="buttonlink ui-state-default ui-corner-all"/>
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
