<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>
<h2>DataTables</h2>

<p class="text">
JQuery DataTables integration Demo : Client-side processing, jquery UI theme, AJAX JSON Datasource
</p>
<s:url var="remoteurl" action="datatables-json" namespace="/datatables"/>
<sjdt:datatables  ajax="{url:'%{remoteurl}',dataSrc:'myCustomers'}" datatablesTheme="jqueryui"
responsive="true"  style="width:100%;" processing="true" dom="Blfrtip" buttons="true"
columns="[
            {data:'id',title:'ID'},
            {data:'name',title:'Name'},
            {data:'country',title:'Country'},
            {data:'city',title:'City'},
            {data:'creditLimit',title:'Credit Limit',render:$.fn.dataTable.render.number(',','.',2)}
]"
>
    <caption class="ui-widget-header">Customers Examples</caption>
</sjdt:datatables>


<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs">
<sj:tab id="tab1" target="jsp" label="JSP"/>
<sj:tab id="tab2" target="java" label="Struts2 Action"/>
<div id="jsp">
	  <pre>
            <code class="html">
&lt;h2&gt;DataTables&lt;/h2&gt;

&lt;p class=&quot;text&quot;&gt;
JQuery DataTables intégration Demo : Client-side processing, jquery UI theme, AJAX JSON Datasource
&lt;/p&gt;
&lt;s:url var=&quot;remoteurl&quot; action=&quot;datatables-json&quot; namespace=&quot;/datatables&quot;/&gt;
&lt;sjdt:datatables  ajax=&quot;{url:'%{remoteurl}',dataSrc:'myCustomers'}&quot; datatablesTheme=&quot;jqueryui&quot;
responsive=&quot;true&quot;  style=&quot;width:100%;&quot; processing=&quot;true&quot; dom=&quot;Blfrtip&quot; buttons=&quot;true&quot;
columns=&quot;[
            {data:'id',title:'ID'},
            {data:'name',title:'Name'},
            {data:'country',title:'Country'},
            {data:'city',title:'City'},
            {data:'creditLimit',title:'Credit Limit',render:$.fn.dataTable.render.number(',','.',2)}
]&quot;
&gt;
    &lt;caption class=&quot;ui-widget-header&quot;&gt;Customers Examples&lt;/caption&gt;
&lt;/sjdt:datatables&gt;
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
