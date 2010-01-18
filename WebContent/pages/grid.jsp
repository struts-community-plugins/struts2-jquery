<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

    <s:url id="remoteurl" action="json-table" />
    <s:url id="editurl" action="edit-customer" /> 
    <s:url id="selectcountrysurl" action="customer-countrys" /> 
    <s:url id="selectemployeesurl" action="employees" /> 
    <s:url id="empurl" action="grid">
    	<s:param name="id" value=""/>
    </s:url> 

    <h2>Grid</h2>
    <p>
        To enable jqGrid set useJqGridPlugin to true in the head tag.
        <br/>
        &lt;sj:head <strong>useJqGridPlugin=&quot;true&quot;</strong> jqueryui=&quot;true&quot; jquerytheme=&quot;redmond&quot;/&gt;
    </p>
    <p>
		<strong>The Database in this Showcase is per default read-only!</strong><br/>
		Make Samples editable with following <sj:a id="openStepsDialog" openDialog="readWriteSteps" cssStyle="font-weight: bold; text-decoration: underline;">Steps</sj:a>.
		<sj:dialog id="readWriteSteps" modal="true" autoOpen="false" width="600">
		<ol>
			<li>Copy BirtSample.jar from the WEB-INF/lib folder to your Harddrive (e.g. C:\)</li>
			<li>Extract BirtSample.jar to C:\BirtSample)</li>
			<li>Edit WEB-INF/classes/hibernate.cfg.xml</li>
			<li>&lt;property name=&quot;hibernate.connection.url&quot;&gt;jdbc:derby:directory:C:/BirtSample/BirtSample&lt;/property&gt;</li>
		</ol>
		</sj:dialog>
    </p>
    <sj:grid 
    	id="customerstable" 
    	caption="Customers (Editable/Multiselect)" 
    	dataType="json" 
    	href="%{remoteurl}" 
    	pager="true" 
    	navigator="true"
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
    	editinline="false"
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
    		editrules="{ edithidden:false } "
    	/>
    	<sj:gridColumn 
    		name="contactlastname" 
    		index="contactlastname" 
    		title="Last Name" 
    		sortable="true" 
    		hidden="true" 
    		editable="true" 
    		edittype="text" 
    		editrules="{ edithidden:false } "
    		/>
    	<sj:gridColumn 
    		name="contactfirstname" 
    		index="contactfirstname" 
    		title="First Name" 
    		sortable="true" 
    		hidden="true" 
    		editable="true" 
    		edittype="text" 
    		editrules="{ edithidden : false } "
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
    		editoptions="{ dataUrl : '%{selectcountrysurl}' }"
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
    		index="employeenumber" 
    		title="Employee" 
    		formatter="showlink"
    		formatoptions="{ baseLinkUrl : '%{empurl}', target : '_new' }"
    		cssStyle="text-decoration: underline;"
    		sortable="true" 
    		search="true"
    		searchoptions="{sopt:['eq','ne','lt','gt']}"
    		editable="true"
    		edittype="select" 
    		editoptions="{ dataUrl : '%{selectemployeesurl}' }"
    		/>
    </sj:grid>
