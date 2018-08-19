<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>
<h2>DataTables</h2>

<p class="text">
JQuery DataTables integration Demo : Client-side processing, row grouping using new RowGroup plugin
</p>

<script>
function renderTotal( rows, group ) {
    var sum = rows
        .data()
        .pluck('creditLimit')
        .reduce( function (a, b) {     	
            return a + b;
        }, 0);
    return 'Total in '+group+': '+
    $.fn.dataTable.render.number(',', '.', 2).display( sum );
}
</script>
<style>
table.dataTable tr.group-end td {
    text-align: right;
    font-weight: normal;
}
</style>
  
<s:url var="remoteurl" action="datatables-json" namespace="/datatables"/>
<sjdt:datatables id="groupTablePlugin" ajax="{url:'%{remoteurl}',dataSrc:'myCustomers'}" datatablesTheme="jqueryui" style="width:100%;" processing="true" dom="Blfrtip" buttons="true" 
columns="[
            {data:'id',title:'ID',orderable:true},
            {data:'name',title:'Name',orderable:true},
            {data:'country',title:'Country',orderable:true},
            {data:'city',title:'City',orderable:true},
            {data:'creditLimit',title:'Credit Limit',orderable:true,render:$.fn.dataTable.render.number(',','.',2)}
]"
  rowGroup="{dataSrc:'country',endRender:renderTotal}" order="[[2, 'asc']]" >
    <caption class="ui-widget-header">Customers Examples</caption>
</sjdt:datatables>

<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs">
<sj:tab id="tab1" target="jsp" label="JSP"/>
<sj:tab id="tab2" target="css" label="CSS"/>
<sj:tab id="tab3" target="java" label="Struts2 Action"/>
<div id="jsp">
	  <pre>
            <code class="html">
&lt;script&gt;
function renderTotal( rows, group ) {
    var sum = rows
        .data()
        .pluck('creditLimit')
        .reduce( function (a, b) {     	
            return a + b;
        }, 0);
    return 'Total in '+group+': '+
    $.fn.dataTable.render.number(',', '.', 2).display( sum );
}
&lt;/script&gt;
&lt;s:url var=&quot;remoteurl&quot; action=&quot;datatables-json&quot; namespace=&quot;/datatables&quot;/&gt;
&lt;sjdt:datatables id=&quot;groupTable&quot; ajax=&quot;{url:'%{remoteurl}',dataSrc:'myCustomers'}&quot; datatablesTheme=&quot;jqueryui&quot; style=&quot;width:100%;&quot; processing=&quot;true&quot; dom=&quot;Blfrtip&quot; buttons=&quot;true&quot; drawCallback=&quot;window.group&quot;
columns=&quot;[
            {data:'id',title:'ID',orderable:true},
            {data:'name',title:'Name',orderable:true},
            {data:'country',title:'Country',orderable:true},
            {data:'city',title:'City',orderable:true},
            {data:'creditLimit',title:'Credit Limit',orderable:true,render:$.fn.dataTable.render.number(',','.',2)}
]&quot; rowGroup=&quot;{dataSrc:'country',endRender:renderTotal}&quot;
 order=&quot;[[ 2, 'asc' ]]&quot; &gt;
    &lt;caption class=&quot;ui-widget-header&quot;&gt;Customers Examples&lt;/caption&gt;
&lt;/sjdt:datatables&gt;
            </code>
	  </pre>
</div>
<div id="css">
      <pre>
            <code class="css">
table.dataTable tr.group-end td {
    text-align: right;
    font-weight: normal;
}
            </code>
      </pre>
</div>
<div id="java">
      <pre>
            <code class="java">
package com.jgeppert.struts2.jquery.showcase.datatables;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;

public class Datatables extends ActionSupport implements SessionAware {

    private Map&lt;String, Object&gt; session;
    private List&lt;Customer&gt; myCustomers;

    public Datatables() {
    }

    @Override
    public void setSession(Map&amp;lt;String, Object&amp;gt; session) {
        this.session = session;
    }

    @Override
    @Actions({ @Action(results = { @Result(location = &quot;/WEB-INF/content/datatables/datatables.jsp&quot;) }),
            @Action(value = &quot;datatables-json&quot;, results = {
                    @Result(type = &quot;json&quot;, params = { &quot;includeProperties&quot;, &quot;myCustomers.*&quot; }) }) })
    public String execute() throws Exception {

        Object list = session.get(&quot;mylist&quot;);
        if (list != null) {
            myCustomers = (List&lt;Customer&gt;) list;
        } else {
            myCustomers = CustomerDAO.buildList();
        }
        // only for showcase functionality, don't do this in production
        session.put(&quot;mylist&quot;, myCustomers);
        return SUCCESS;
    }

    public List&lt;Customer&gt; getMyCustomers() {
        return this.myCustomers;
    }
}
            </code>
      </pre>
</div>
</sj:tabbedpanel>
