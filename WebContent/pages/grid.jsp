<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

    <s:url id="remoteurl" action="json-table" />
    <s:url id="editurl" action="edit-customer" /> 
    <s:url id="selecturl" action="customer-countrys" /> 
    <s:url id="empurl" action="grid">
    	<s:param name="id" value=""/>
    </s:url> 

    <h2>Grid</h2>
    <p>
        A simple grid with pager. This Grid is sortable by name column.
    </p>
    <p>
        To enable jqGrid set useJqGridPlugin to true in the head tag.
        <br/>
        &lt;sj:head <strong>useJqGridPlugin=&quot;true&quot;</strong> jqueryui=&quot;true&quot; jquerytheme=&quot;redmond&quot;/&gt;
    </p>
    -${gridModel}-
    <sj:grid 
    	id="customerstable" 
    	caption="Customers (Editable/Multiselect)" 
    	dataType="json" 
    	href="%{remoteurl}" 
    	pager="true" 
    	navigator="true"
    	navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
    	navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
    	navigatorEdit="false"
    	navigatorView="true"
    	navigatorDelete="true"
    	navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	editurl="%{editurl}"
    	editinline="true"
    	multiselect="true"
    	viewrecords="true"
    >
    	<sj:gridColumn name="customernumber" 
    		index="customernumber" 
    		key="true" 
    		title="ID" 
    		formatter="integer" 
    		sortable="true" 
    		search="true" 
    		searchoptions="{sopt:['eq','ne','lt','gt']}"
    	/>
    	<sj:gridColumn 
    		name="customername" 
    		index="customername" 
    		title="Company" 
    		sortable="true" 
    		editable="true" 
    		edittype="text" 
    		search="true"
    		searchoptions="{sopt:['eq','ne','bw','cn']}"
    	/>
    	<sj:gridColumn 
    		name="contactlastname" 
    		index="contactlastname" 
    		title="Last Name" 
    		sortable="true" 
    		hidden="true" 
    		search="true"
    		searchoptions="{sopt:['eq','ne','bw','cn']}"
    		/>
    	<sj:gridColumn 
    		name="contactfirstname" 
    		index="contactfirstname" 
    		title="First Name" 
    		sortable="true" 
    		hidden="true" 
    		search="true"
    		searchoptions="{sopt:['eq','ne','bw','cn']}"
    		/>
    	<sj:gridColumn 
    		name="addressLine1" 
    		index="addressLine1" 
    		title="Adress" 
    		sortable="true" 
    		hidden="true" 
    		search="true"
    		searchoptions="{sopt:['eq','ne','bw','cn']}"
    		/>
    	<sj:gridColumn 
    		name="country" 
    		index="country" 
    		title="Country" 
    		sortable="true" 
    		search="true"
    		searchoptions="{sopt:['eq','ne','bw','cn']}"
    		editable="true" 
    		edittype="select" 
    		editoptions="{ dataUrl : '%{selecturl}' }"
    		/>
    	<sj:gridColumn 
    		name="city" 
    		index="city" 
    		title="City" 
    		sortable="true" 
    		search="true"
    		searchoptions="{sopt:['eq','ne','bw','cn']}"
    		editable="true" 
    		edittype="text"/>
    	<sj:gridColumn 	
    		name="creditlimit" 
    		index="creditlimit" 
    		title="Credit Limit" 
    		editable="true" 
    		editrules="{
    					number: true, 
    					required: true, 
    					minValue : 100.0, 
    					maxValue : 1000000.0
    				}" 
    		formatter="currency" 
    		sortable="true" 
    		search="true"
    		searchoptions="{sopt:['eq','ne','lt','gt']}"
    		/>
    	<sj:gridColumn 
    		name="salesemployee.employeenumber" 
    		index="salesemployee.employeenumber" 
    		title="Employee" 
    		formatter="showlink"
    		formatoptions="{ baseLinkUrl : '%{empurl}', showAction : '', addParam : '&action=show', target : '_new' }"
    		sortable="false"
    		search="false"
    		cssStyle="text-decoration: underline;"
    		sortable="true" 
    		search="true"
    		searchoptions="{sopt:['eq','ne','lt','gt']}"
    		/>
    </sj:grid>
