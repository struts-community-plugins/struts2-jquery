<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

    <s:url id="ordersurl" action="json-orders" />
    <s:url id="orderdetailsurl" action="json-orderdetails" />
	<s:url id="customersurl" action="json-table" escapeAmp="false" />
	
    <h2>Grid with Subgrid - Three Level</h2>
    <sjg:grid 
    	id="customerstable" 
    	caption="Customers" 
    	dataType="json" 
    	href="%{customersurl}" 
    	pager="true" 
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	viewrecords="true"
    	altRows="true"
    >
	     <sjg:grid 
	    	id="orderstable" 
	    	caption="Orders with Orderdetails Subgrid" 
	    	dataType="json" 
	    	subGridUrl="%{ordersurl}" 
	    	pager="true" 
	    	navigator="true"
	    	navigatorEdit="false"
	    	navigatorAdd="false"
	    	navigatorView="true"
	    	navigatorDelete="false"
	    	gridModel="gridModel"
	    	rowList="10,15,20"
	    	rowNum="15"
	    	viewrecords="true"
	    	
	    >
		    <sjg:grid 
		    	id="orderssubgridtable" 
		    	subGridUrl="%{orderdetailsurl}"
		    	gridModel="gridModel"
		    	rowNum="-1"
		    	footerrow="true"
		    	userDataOnFooter="true"
		    >
		    	<sjg:gridColumn name="productcode" key="true" title="Product Code" width="300" hidden="true"/>
		    	<sjg:gridColumn name="productname" title="Product" width="300"/>
		    	<sjg:gridColumn name="quantityordered" title="Quantity" formatter="integer" align="center"/>
		    	<sjg:gridColumn name="priceeach" title="Price" formatter="currency" align="right"/>
		    </sjg:grid>
	    	<sjg:gridColumn name="ordernumber" 
	    		index="ordernumber" 
	    		key="true" 
	    		title="Order" 
	    		formatter="integer" 
	    		sortable="true" 
	    		search="true" 
	    		searchoptions="{sopt:['eq','ne','lt','gt']}"
	    	/>
	    	<sjg:gridColumn 
	    		name="orderdate" 
	    		index="orderdate" 
	    		title="Order Date"
	    		formatter="date" 
	    		sortable="true" 
	    	/>
	    	<sjg:gridColumn 
	    		name="requireddate" 
	    		index="requireddate" 
	    		title="Required Date"
	    		formatter="date" 
	    		sortable="true" 
	    	/>
	    	<sjg:gridColumn 
	    		name="shippeddate" 
	    		index="shippeddate" 
	    		title="Shipped Date"
	    		formatter="date" 
	    		sortable="true" 
	    	/>
	    	<sjg:gridColumn 
	    		name="contactlastname" 
	    		index="contactlastname" 
	    		title="Last Name" 
	    		sortable="true" 
	    		hidden="true" 
	    		search="true"
	    		searchoptions="{sopt:['eq','ne','bw','cn']}"
	    		/>
	    	<sjg:gridColumn 
	    		name="status" 
	    		index="status" 
	    		title="Status" 
	    		sortable="true" 
	    		search="true"
	    		searchoptions="{sopt:['eq','ne']}"
	    		/>
	    	<sjg:gridColumn 
	    		name="comments" 
	    		index="comments" 
	    		title="Comments" 
	    		search="true"
	    		searchoptions="{sopt:['eq','ne','bw','cn']}"
	    		/>
	    	<sjg:gridColumn 
	    		name="customer.customernumber" 
	    		index="customer" 
	    		title="Customer" 
	    		formatter="integer"
	    		sortable="true"
	    		/>
	    </sjg:grid>
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
    