<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>
<h2>DataTables</h2>

<p class="text">
	JQuery DataTables integration Demo : Client-side processing, jquery UI theme, DOM dataset
</p>
<!-- Required third party libs for pdf and excel export-->
<s:script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"/>
<s:script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"/>
<s:script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"/>

<sjdt:datatables datatablesTheme="jqueryui" buttons="['colvis','pdf','excel','csv','print','copy']" dom="Blfrtip" lengthMenu="[5,10,15,20]" pageLength="15"
columnDefs="[{targets:[4],render:$.fn.dataTable.render.number(',','.',2)}]"
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
    <tbody>
       <s:iterator value="myCustomers" >
            <tr>
                <td>${id}</td>
                <td>${name}</td>
                <td>${country}</td>
                <td>${city}</td>
                <td>${creditLimit}</td>
            </tr>
       </s:iterator>
    </tbody>
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
    JQuery DataTables integration Demo : Client-side processing, jquery UI theme, DOM dataset
&lt;/p&gt;
&lt;!-- Required third party libs for pdf and excel export--&gt;
&lt;s:script src=&quot;https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js&quot;/&gt;
&lt;s:script src=&quot;https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js&quot;/&gt;
&lt;s:script src=&quot;https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js&quot;/&gt;

&lt;sjdt:datatables datatablesTheme=&quot;jqueryui&quot; buttons=&quot;['colvis','pdf','excel','csv','print','copy']&quot; dom=&quot;Blfrtip&quot; lengthMenu=&quot;[5,10,15,20]&quot; pageLength=&quot;15&quot;
columnDefs=&quot;[{targets:[4],render:$.fn.dataTable.render.number(',','.',2)}]&quot;
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
    &lt;tbody&gt;
       &lt;s:iterator value=&quot;myCustomers&quot; &gt;
            &lt;tr&gt;
                &lt;td&gt;&#36;{id}&lt;/td&gt;
                &lt;td&gt;&#36;{name}&lt;/td&gt;
                &lt;td&gt;&#36;{country}&lt;/td&gt;
                &lt;td&gt;&#36;{city}&lt;/td&gt;
                &lt;td&gt;&#36;{creditLimit}&lt;/td&gt;
            &lt;/tr&gt;
       &lt;/s:iterator&gt;
    &lt;/tbody&gt;
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
