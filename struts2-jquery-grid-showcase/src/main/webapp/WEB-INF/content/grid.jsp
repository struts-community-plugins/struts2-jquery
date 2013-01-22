<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>


    <s:url var="remoteurl" action="json-table" />
    <s:url var="editurl" action="edit-customer" />
    <s:url var="selectcountrysurl" action="customer-countrys" />
    <s:url var="selectemployeesurl" action="employees" />
    <s:url var="empurl" action="employees-detail" />
	<sj:dialog
		id="employees_details"
		title="Employee Details"
		autoOpen="false"
		modal="true"
		width="400"
	>

	</sj:dialog>
    <h2>Grid</h2>
    <p>
		<strong>The Database in this Showcase is per default read-only!</strong><br/>
		Make Samples editable with following <sj:a id="openStepsDialog" openDialog="readWriteSteps">Steps</sj:a>.
		<sj:dialog
			id="readWriteSteps"
			modal="true"
			autoOpen="false"
			width="600"
			resizable="false"
			draggable="false"
		>
			<ol>
				<li>Copy BirtSample.jar from the WEB-INF/lib folder to your Harddrive (e.g. C:\)</li>
				<li>Extract BirtSample.jar to C:\BirtSample)</li>
				<li>Edit WEB-INF/classes/hibernate.cfg.xml</li>
				<li>&lt;property name=&quot;hibernate.connection.url&quot;&gt;jdbc:derby:directory:C:/BirtSample/BirtSample&lt;/property&gt;</li>
			</ol>
		</sj:dialog>
    </p>
    <sjg:grid
    	id="customerstable"
    	caption="Customers (Editable/Multiselect)"
    	dataType="json"
    	href="%{remoteurl}"
    	pager="true"
    	navigator="true"
    	navigatorAddOptions="{
    		height:280,
    		reloadAfterSubmit:true,
			afterSubmit:function(response, postdata) {
							return isError(response.responseText);
                         }
		}"
    	navigatorEdit="true"
    	navigatorEditOptions="{
    		height:280,
    		reloadAfterSubmit:true,
			afterSubmit:function(response, postdata) {
							return isError(response.responseText);
                         }
		}"
    	navigatorView="true"
    	navigatorDelete="true"
    	navigatorDeleteOptions="{
    		height:280,
    		reloadAfterSubmit:true,
			afterSubmit:function(response, postdata) {
							return isError(response.responseText);
                         }
		}"
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	editurl="%{editurl}"
    	editinline="false"
    	multiselect="true"
    	viewrecords="true"
    	viewsortcols="[true, 'horizontal', true]"
    	resizable="true"
    >
    	<sjg:gridColumn name="customernumber"
    		index="customernumber"
    		key="true"
    		title="ID"
    		width="50"
    		formatter="integer"
    		sortable="true"
    		search="true"
    		searchoptions="{sopt:['eq','ne','lt','gt']}"
    	/>
    	<sjg:gridColumn
    		name="customername"
    		index="customername"
    		title="Company"
    		width="300"
    		sortable="true"
    		editable="true"
    		edittype="text"
    	/>
    	<sjg:gridColumn
    		name="contactlastname"
    		index="contactlastname"
    		title="Last Name"
    		sortable="true"
    		hidden="true"
    		editable="true"
    		edittype="text"
    		editrules="{ edithidden : true } "
    		/>
    	<sjg:gridColumn
    		name="contactfirstname"
    		index="contactfirstname"
    		title="First Name"
    		sortable="true"
    		hidden="true"
    		editable="true"
    		edittype="text"
    		editrules="{ edithidden : true } "
    		/>
    	<sjg:gridColumn
    		name="addressLine1"
    		index="addressLine1"
    		title="Adress"
    		sortable="true"
    		hidden="true"
    		search="true"
    		searchoptions="{sopt:['eq','ne','bw','cn']}"
    		/>
    	<sjg:gridColumn
    		name="country"
    		index="country"
    		title="Country"
    		sortable="true"
    		search="true"
    		surl="%{selectcountrysurl}"
    		searchoptions="{sopt:['eq','ne','bw','cn'], dataUrl : '%{selectcountrysurl}'}"
    		searchtype="select"
    		editable="true"
    		edittype="select"
    		editoptions="{ dataUrl : '%{selectcountrysurl}' }"
    		formoptions="{label:'Select a Country'}"
    		/>
    	<sjg:gridColumn
    		name="city"
    		index="city"
    		title="City"
    		sortable="true"
    		search="true"
    		searchoptions="{sopt:['eq','ne','bw','cn']}"
    		editable="true"
    		edittype="text"/>
    	<sjg:gridColumn
    		name="creditlimit"
    		index="creditlimit"
    		title="Credit Limit"
    		align="right"
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
    	<sjg:gridColumn
    		name="salesemployee.employeenumber"
    		index="employeenumber"
    		title="Employee"
    		align="center"
    		formatter="formatLink"
    		cssClass="link"
    		sortable="true"
    		search="true"
    		searchoptions="{sopt:['eq','ne'], dataUrl : '%{selectemployeesurl}'}"
    		searchtype="select"
    		editable="true"
    		edittype="select"
    		editoptions="{ dataUrl : '%{selectemployeesurl}' }"
    		formoptions="{label:'Select a Employee'}"
    		/>
    </sjg:grid>
