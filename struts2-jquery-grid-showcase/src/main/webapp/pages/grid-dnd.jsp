<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>


    <s:url id="remoteurla" action="json-table">
    	<s:param name="searchString">200</s:param>
    	<s:param name="searchOper">lt</s:param>
    	<s:param name="searchField">customernumber</s:param>
    </s:url>
    <s:url id="remoteurlb" action="json-table">
    	<s:param name="searchString">400</s:param>
    	<s:param name="searchOper">gt</s:param>
    	<s:param name="searchField">customernumber</s:param>
    </s:url>
    <h2>Grid with Drag and Drop</h2>
    <sjg:grid 
    	id="customerstablea" 
    	caption="Customers (Editable/Multiselect)" 
    	dataType="json" 
    	href="%{remoteurla}" 
    	pager="true" 
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	viewrecords="true"
    	altRows="true"
    	connectWith="#customerstableb"
    	draggable="true"
    	droppable="true"
    	droppableOnDropTopics="ondrop"
    >
    	<sjg:gridColumn name="customernumber" 
    		index="customernumber" 
    		key="true" 
    		title="ID" 
    		width="50"
    		formatter="integer" 
    	/>
    	<sjg:gridColumn 
    		name="customername" 
    		index="customername" 
    		title="Company" 
    		width="300"
    	/>
    	<sjg:gridColumn 
    		name="country" 
    		index="country" 
    		title="Country" 
    	/>
    	<sjg:gridColumn 
    		name="city" 
    		index="city" 
    		title="City" 
    	/>
    	<sjg:gridColumn 	
    		name="creditlimit" 
    		index="creditlimit" 
    		title="Credit Limit" 
    		align="right"
   		/>
    	<sjg:gridColumn 
    		name="salesemployee.employeenumber" 
    		index="employeenumber" 
    		title="Employee" 
    		align="center"
   		/>
    </sjg:grid>
	<br/>
	<div id="dndmessages"></div>
	<br/>
	<sjg:grid 
    	id="customerstableb" 
    	caption="Customers (Editable/Multiselect)" 
    	dataType="json" 
    	href="%{remoteurlb}" 
    	pager="true" 
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	viewrecords="true"
    	altRows="true"
    	connectWith="#customerstablea"
    	draggable="true"
    	droppable="true"
    	droppableOnDropTopics="ondrop"
    >
    	<sjg:gridColumn name="customernumber" 
    		index="customernumber" 
    		key="true" 
    		title="ID" 
    		width="50"
    		formatter="integer" 
    	/>
    	<sjg:gridColumn 
    		name="customername" 
    		index="customername" 
    		title="Company" 
    		width="300"
    	/>
    	<sjg:gridColumn 
    		name="country" 
    		index="country" 
    		title="Country" 
    	/>
    	<sjg:gridColumn 
    		name="city" 
    		index="city" 
    		title="City" 
    	/>
    	<sjg:gridColumn 	
    		name="creditlimit" 
    		index="creditlimit" 
    		title="Credit Limit" 
    		align="right"
   		/>
    	<sjg:gridColumn 
    		name="salesemployee.employeenumber" 
    		index="employeenumber" 
    		title="Employee" 
    		align="center"
   		/>
    </sjg:grid>
    