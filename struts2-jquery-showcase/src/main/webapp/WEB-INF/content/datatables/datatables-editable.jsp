<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>
<script
    language="JavaScript"
    src="/struts/utils.js"
    type="text/javascript">
</script>
<script
    language="JavaScript"
    src="/struts/xhtml/validation.js"
    type="text/javascript">
</script>
<script>
    /*Destroy previous instances of jQuery Dialogs  */
	$(".ui-dialog-content").each(function(i,elt){
		if ($(elt).dialog){
			  $(this).dialog('destroy').remove();		  
		}
	});
</script>
<h2>DataTables</h2>

<p class="text">
	JQuery DataTables integration Demo : Custom editor using topics, Buttons plugin, Select plugin, Jquery Dialog and JSON AJAX Validation
</p>
<s:url var="remoteurl" action="datatables-json" namespace="/datatables"/>
<sjdt:datatables id="editableTable" datatablesTheme="jqueryui" ajaxReloadTopics="rowSavedTopic,rowDeletedTopic" pageTopics="testTopic"
buttons="['colvis',
{extend:'selectedSingle',text:'Edit',action:function(){$(this).publish('editTopic');}},
{text:'Create',action:function(){$(this).publish('createTopic');}},
{extend:'selectedSingle',text:'Delete',action:function(){$(this).publish('deleteTopic');}}
]" 
dom="Blfrtip" 
ajax="{url:'%{remoteurl}',dataSrc:'myCustomers'}" select="'single'"
columns="[
            {data:'id',title:'ID'},
            {data:'name',title:'Name'},
            {data:'country',title:'Country'},
            {data:'city',title:'City'},
            {data:'creditLimit',title:'Credit Limit',render:$.fn.dataTable.render.number(',','.',2)}
]"
responsive="true" style="width:100%;" >
    <caption class="ui-widget-header" >Customers Examples</caption>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Country</th>
            <th>City</th>
            <th>Credit Limit</th>
        </tr>
    </thead>
</sjdt:datatables>
<sj:dialog id="editDialog" autoOpen="false" title="Edit Customer" openTopics="editTopic,createTopic" closeTopics="rowSavedTopic">
    <s:form id="editForm" theme="xhtml" namespace="/datatables" action="datatables-save">
            <s:hidden id="idCustomer" name="id" />
            <s:textfield id="name" name="name" label="Name" />
            <s:textfield id="country" name="country" label="Country" />
            <s:textfield id="city" name="city" label="City" />
            <s:textfield id="creditLimit" name="creditLimit" label="Credit Limit" />
        <sj:submit  value="Submit" button="true" buttonText="Submit" validate="true" dataType="json" targets="x"
                onSuccessTopics="rowSavedTopic" onErrorTopics="rowSavedErrorTopic" />
    </s:form>
</sj:dialog>
<sj:dialog id="deleteDialog" autoOpen="false" title="Delete" openTopics="deleteTopic" closeTopics="rowDeletedTopic" modal="true" >
    <s:form id="deleteForm" theme="simple" namespace="/datatables" action="datatables-delete" >
        <s:hidden name="id" />
        Delete the row ?
        <div class="type-button">
            <sj:submit  value="Confirm" button="true" targets="x" dataType="json" buttonText="Confirm" onSuccessTopics="rowDeletedTopic"  onErrorTopics="rowDeletedErrorTopic" /><sj:a onClickTopics="closeDeleteDialogTopic" button="true" >Cancel</sj:a>
        </div>
    </s:form>
</sj:dialog>
<script>
var $editForm = null;
$(function(){
	$editForm = $("#editForm").get(0);
    $("#editableTable").subscribe("editTopic",function(event,ui){ 
    	clearErrorMessages($editForm);
    	clearErrorLabels($editForm);
        var row = $("#editableTable tr.selected");
        if (row.length > 0){
            var rowData = $("#editableTable").DataTable().row(row).data();
            $.each(rowData,function(name,value){
                $("input[name='" + name + "']").val(value);
            });
        }
    });
    $("#editableTable").subscribe("createTopic",function(event,ui){ 
    	clearErrorLabels($editForm);
    	clearErrorMessages($editForm);
    	$editForm.reset();
    });
    $("#editableTable").subscribe("deleteTopic",function(event,ui){  
    	var row = $("#editableTable tr.selected");
    	if (row.length > 0){
            var rowData = $("#editableTable").DataTable().row(row).data();
            $("input[name='id']").val(rowData.id);          
        }
    });
    $("#editableTable").subscribe("rowDeletedErrorTopic",function(event,ui){  
        alert(event.originalEvent.request.responseJSON.actionErrors[0]);
     });
    $("#editableTable").subscribe("rowSavedErrorTopic",function(event,ui){  
        alert(event.originalEvent.request.responseJSON.actionErrors[0]);
     });
});
</script>
<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs">
<sj:tab id="tab1" target="jsp" label="JSP"/>
<sj:tab id="tab2" target="java" label="Struts2 Save Action"/>
<sj:tab id="tab3" target="java2" label="Struts2 Delete Action"/>
<div id="jsp">
	  <pre>
            <code class="html">
&lt;script
    language=&quot;JavaScript&quot;
    src=&quot;/struts/utils.js&quot;
    type=&quot;text/javascript&quot;&gt;
&lt;/script&gt;
&lt;script
    language=&quot;JavaScript&quot;
    src=&quot;/struts/xhtml/validation.js&quot;
    type=&quot;text/javascript&quot;&gt;
&lt;/script&gt;
&lt;h2&gt;DataTables&lt;/h2&gt;

&lt;p class=&quot;text&quot;&gt;
    JQuery DataTables integration Demo : Custom editor using topics, Buttons plugin, Select plugin, Jquery Dialog and JSON AJAX Validation
&lt;/p&gt;
&lt;s:url var=&quot;remoteurl&quot; action=&quot;datatables-json&quot; namespace=&quot;/datatables&quot;/&gt;
&lt;sjdt:datatables id=&quot;editableTable&quot; datatablesTheme=&quot;jqueryui&quot; ajaxReloadTopics=&quot;rowSavedTopic,rowDeletedTopic&quot; pageTopics=&quot;testTopic&quot;
buttons=&quot;['colvis',
{extend:'selectedSingle',text:'Edit',action:function(){$(this).publish('editTopic');}},
{text:'Create',action:function(){$(this).publish('createTopic');}},
{extend:'selectedSingle',text:'Delete',action:function(){$(this).publish('deleteTopic');}}
]&quot; 
dom=&quot;Blfrtip&quot; 
ajax=&quot;{url:'%{remoteurl}',dataSrc:'myCustomers'}&quot; select=&quot;'single'&quot;
columns=&quot;[
            {data:'id',title:'ID'},
            {data:'name',title:'Name'},
            {data:'country',title:'Country'},
            {data:'city',title:'City'},
            {data:'creditLimit',title:'Credit Limit',render:$.fn.dataTable.render.number(',','.',2)}
]&quot;
responsive=&quot;true&quot; style=&quot;width:100%;&quot; &gt;
    &lt;caption class=&quot;ui-widget-header&quot; &gt;Customers Examples&lt;/caption&gt;
    &lt;thead&gt;
        &lt;tr&gt;
            &lt;th&gt;ID&lt;/th&gt;
            &lt;th&gt;Name&lt;/th&gt;
            &lt;th&gt;Country&lt;/th&gt;
            &lt;th&gt;City&lt;/th&gt;
            &lt;th&gt;Credit Limit&lt;/th&gt;
        &lt;/tr&gt;
    &lt;/thead&gt;
&lt;/sjdt:datatables&gt;
&lt;sj:dialog id=&quot;editDialog&quot; autoOpen=&quot;false&quot; title=&quot;Edit Customer&quot; openTopics=&quot;editTopic,createTopic&quot; closeTopics=&quot;rowSavedTopic&quot;&gt;
    &lt;s:form id=&quot;editForm&quot; theme=&quot;xhtml&quot; namespace=&quot;/datatables&quot; action=&quot;datatables-save&quot;&gt;
            &lt;s:hidden id=&quot;idCustomer&quot; name=&quot;id&quot; /&gt;
            &lt;s:textfield id=&quot;name&quot; name=&quot;name&quot; label=&quot;Name&quot; /&gt;
            &lt;s:textfield id=&quot;country&quot; name=&quot;country&quot; label=&quot;Country&quot; /&gt;
            &lt;s:textfield id=&quot;city&quot; name=&quot;city&quot; label=&quot;City&quot; /&gt;
            &lt;s:textfield id=&quot;creditLimit&quot; name=&quot;creditLimit&quot; label=&quot;Credit Limit&quot; /&gt;
        &lt;sj:submit  value=&quot;Submit&quot; button=&quot;true&quot; buttonText=&quot;Submit&quot; validate=&quot;true&quot; dataType=&quot;json&quot; targets=&quot;x&quot;
                onSuccessTopics=&quot;rowSavedTopic&quot; onErrorTopics=&quot;rowSavedErrorTopic&quot; /&gt;
    &lt;/s:form&gt;
&lt;/sj:dialog&gt;
&lt;sj:dialog id=&quot;deleteDialog&quot; autoOpen=&quot;false&quot; title=&quot;Delete&quot; openTopics=&quot;deleteTopic&quot; closeTopics=&quot;rowDeletedTopic&quot; modal=&quot;true&quot; &gt;
    &lt;s:form id=&quot;deleteForm&quot; theme=&quot;simple&quot; namespace=&quot;/datatables&quot; action=&quot;datatables-delete&quot; &gt;
        &lt;s:hidden name=&quot;id&quot; /&gt;
        Delete the row ?
        &lt;div class=&quot;type-button&quot;&gt;
            &lt;sj:submit  value=&quot;Confirm&quot; button=&quot;true&quot; targets=&quot;x&quot; dataType=&quot;json&quot; buttonText=&quot;Confirm&quot; onSuccessTopics=&quot;rowDeletedTopic&quot;  onErrorTopics=&quot;rowDeletedErrorTopic&quot; /&gt;&lt;sj:a onClickTopics=&quot;closeDeleteDialogTopic&quot; button=&quot;true&quot; &gt;Cancel&lt;/sj:a&gt;
        &lt;/div&gt;
    &lt;/s:form&gt;
&lt;/sj:dialog&gt;
&lt;script&gt;
var $editForm = null;
$(function(){
    $editForm = $(&quot;#editForm&quot;).get(0);
    $(&quot;#editableTable&quot;).subscribe(&quot;editTopic&quot;,function(event,ui){ 
        clearErrorMessages($editForm);
        clearErrorLabels($editForm);
        var row = $(&quot;#editableTable tr.selected&quot;);
        if (row.length &gt; 0){
            var rowData = $(&quot;#editableTable&quot;).DataTable().row(row).data();
            $.each(rowData,function(name,value){
                $(&quot;input[name='&quot; + name + &quot;']&quot;).val(value);
            });
        }
    });
    $(&quot;#editableTable&quot;).subscribe(&quot;createTopic&quot;,function(event,ui){ 
        clearErrorLabels($editForm);
        clearErrorMessages($editForm);
        $editForm.reset();
    });
    $(&quot;#editableTable&quot;).subscribe(&quot;deleteTopic&quot;,function(event,ui){  
        var row = $(&quot;#editableTable tr.selected&quot;);
        if (row.length &gt; 0){
            var rowData = $(&quot;#editableTable&quot;).DataTable().row(row).data();
            $(&quot;input[name='id']&quot;).val(rowData.id);          
        }
    });
    $(&quot;#editableTable&quot;).subscribe(&quot;rowDeletedErrorTopic&quot;,function(event,ui){  
        alert(event.originalEvent.request.responseJSON.actionErrors[0]);
     });
    $(&quot;#editableTable&quot;).subscribe(&quot;rowSavedErrorTopic&quot;,function(event,ui){  
        alert(event.originalEvent.request.responseJSON.actionErrors[0]);
     });
});
&lt;/script&gt;
            </code>
	  </pre>
</div>
<div id="java">
      <pre>
            <code class="java">
package com.jgeppert.struts2.jquery.showcase.datatables;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class DatatablesSave extends ActionSupport implements SessionAware {

    private static final Log log = LogFactory.getLog(DatatablesSave.class);

    private Map&lt;String, Object&gt; session;
    private String id;
    private String name;
    private String country;
    private String city;
    private String creditLimit;
    private Customer customer;

    public DatatablesSave() {
    }

    @Override
    public void setSession(Map&lt;String, Object&gt; session) {
        this.session = session;
    }

    @Override
    @Action(interceptorRefs = @InterceptorRef("jsonValidationWorkflowStack"), results = {
            @Result(name = SUCCESS, type = "json", params = { "includeProperties", "actionMessages.*,customer.*",
                    "ignoreHierarchy", "false" }),
            @Result(name = ERROR, type = "json", params = { "includeProperties", "actionErrors.*", "ignoreHierarchy",
                    "false", "statusCode", "500" }) })
    public String execute() throws Exception {
        String ret = SUCCESS;
        try {
            List&lt;Customer&gt; list = (List&lt;Customer&gt;) session.get("mylist");
            Customer customer = null;
            if (this.id != null && !"".equals(id)) {
                customer = CustomerDAO.findById(list, Integer.parseInt(id));
                log.debug("Updating customer");
            } else {
                customer = new Customer();
                customer.setId(new Random().nextInt());
                list.add(customer);
                log.debug("Created customer");
            }
            customer.setName(name);
            customer.setCountry(country);
            customer.setCity(city);
            customer.setCreditLimit(Double.parseDouble(creditLimit));
            this.customer = customer;
        } catch (Exception e) {
            ret = ERROR;
            this.addActionError("Error while saving customer : " + e.getMessage());
        }
        return ret;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @RequiredStringValidator(fieldName = "name", type = ValidatorType.FIELD, message = "Name is required")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequiredStringValidator(fieldName = "country", type = ValidatorType.FIELD, message = "Country is required")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @RequiredStringValidator(fieldName = "city", type = ValidatorType.FIELD, message = "City is required")
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @RequiredStringValidator(fieldName = "creditLimit", type = ValidatorType.FIELD, message = "CreditLimit is required")
    public String getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Map&lt;String, Object&gt; getSession() {
        return this.session;
    }

    public Customer getCustomer() {
        return this.customer;
    }

}
            </code>
      </pre>
</div>
<div id="java2">
      <pre>
            <code class="java">
package com.jgeppert.struts2.jquery.showcase.datatables;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DatatablesDelete extends ActionSupport implements SessionAware {

    private static final Log log = LogFactory.getLog(DatatablesDelete.class);

    private Map&lt;String, Object&gt; session;
    private String id;

    public DatatablesDelete() {
    }

    @Override
    public void setSession(Map&lt;String, Object&gt; session) {
        this.session = session;
    }

    @Override
    @Action(results = {
            @Result(name = SUCCESS, type = "json", params = { "includeProperties", "actionMessages.*",
                    "ignoreHierarchy", "false" }),
            @Result(name = ERROR, type = "json", params = { "includeProperties", "actionErrors.*", "ignoreHierarchy",
                    "false", "statusCode", "500" }) })
    public String execute() throws Exception {
        String ret = SUCCESS;
        try {
            List&lt;Customer&gt; list = (List&lt;Customer&gt;) session.get("mylist");
            int removeId = Integer.parseInt(id);
            log.debug("Delete Customer " + removeId);
            Customer customer = CustomerDAO.findById(list, removeId);
            list.remove(customer);
        } catch (Exception e) {
            ret = ERROR;
            this.addActionError("Error while deleting customer : " + e.getMessage());
        }
        return ret;
    }

    public void setId(String id) {
        this.id = id;
    }

}
            
            </code>
      </pre>
</div>
</sj:tabbedpanel>
