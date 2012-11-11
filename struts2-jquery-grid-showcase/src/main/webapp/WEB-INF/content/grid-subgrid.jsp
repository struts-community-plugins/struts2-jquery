<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

    <s:url var="ordersurl" action="json-orders" />
    <s:url var="orderdetailsurl" action="json-orderdetails" />
    <s:url var="subgridthreelevelurl" action="grid-subgrid-three-level" />

    <h2>Grid with Subgrid</h2>
    
    <p>Try out <sj:a href="%{subgridthreelevelurl}" targets="main_content" cssStyle="font-style:bold;">Subgrid with 3 Level.</sj:a></p>
    
    <sjg:grid 
    	id="orderstable" 
    	caption="Orders with Orderdetails Subgrid" 
    	dataType="json" 
    	href="%{ordersurl}" 
    	pager="true" 
    	toppager="true"
    	navigator="true"
    	navigatorEdit="false"
    	navigatorAdd="false"
    	navigatorView="true"
    	navigatorDelete="false"
    	navigatorCloneToTop="true"
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
