<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>
<h2>DataTables</h2>

<p class="text">
JQuery DataTables integration Demo : Server-side processing, jquery UI theme.
Server side processing is useful for large dataset (> 50 000 elements).
</p>
<s:url var="remoteurl" action="datatables-server-side" namespace="/datatables"/>
<%-- To use JSON serialization, use ajax="{url:'%{remoteurl}',type:'POST',contentType:'application/json',data:function(d){return JSON.stringify(d);}}" --%>
<%-- The JSON Interceptor must be used on server-side to deserialize the request --%>
<sjdt:datatables ajax="'%{remoteurl}'" datatablesTheme="jqueryui"  serverSide="true"
responsive="true"  style="width:100%;" processing="true" dom="Blfrtip" buttons="true" order="[[1,'asc']]"
columns="[
            {data:'id',title:'ID',orderable:false},
            {data:'name',title:'Name'},
            {data:'country',title:'Country',orderable:false},
            {data:'city',title:'City',orderable:false},
            {data:'creditLimit',title:'Credit Limit',render:$.fn.dataTable.render.number(',','.',2),orderable:false}
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
&lt;s:url var=&quot;remoteurl&quot; action=&quot;datatables-server-side&quot; namespace=&quot;/datatables&quot;/&gt;
&lt;%-- To use JSON serialization, use ajax=&quot;{url:'%{remoteurl}',type:'POST',contentType:'application/json',data:function(d){return JSON.stringify(d);}}&quot; --%&gt;
&lt;%-- The JSON Interceptor must be used on server-side to deserialize the request --%&gt;
&lt;sjdt:datatables ajax=&quot;'%{remoteurl}'&quot; datatablesTheme=&quot;jqueryui&quot;  serverSide=&quot;true&quot;
responsive=&quot;true&quot;  style=&quot;width:100%;&quot; processing=&quot;true&quot; dom=&quot;Blfrtip&quot; buttons=&quot;true&quot; order=&quot;[[1,'asc']]&quot;
columns=&quot;[
            {data:'id',title:'ID',orderable:false},
            {data:'name',title:'Name'},
            {data:'country',title:'Country',orderable:false},
            {data:'city',title:'City',orderable:false},
            {data:'creditLimit',title:'Credit Limit',render:$.fn.dataTable.render.number(',','.',2),orderable:false}
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.datatables.model.ServerSideProcessingRequest;
import com.jgeppert.struts2.jquery.datatables.model.ServerSideProcessingResponse;
import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 */
public class DatatablesServerSide extends ActionSupport implements ModelDriven&lt;ServerSideProcessingRequest&gt; {

    private HttpSession session;
    private ServerSideProcessingRequest request = new ServerSideProcessingRequest();
    private ServerSideProcessingResponse response = new ServerSideProcessingResponse();

    /**
     * 
     */
    public DatatablesServerSide() {

    }

    /**
     * To Use JSON Deserialization of DataTables' request, use the json
     * interceptor
     * 
     * @Action(interceptorRefs = @InterceptorRef(value = &quot;json&quot;, params = {
     *                         &quot;accept&quot;, &quot;application/json&quot;, &quot;root&quot;, &quot;request&quot;
     *                         }), results = { @Result(name = SUCCESS, type =
     *                         &quot;json&quot;, params = { &quot;root&quot;, &quot;response&quot; }) })
     * 
     * 
     */
    @Override
    @Action(results = { @Result(name = SUCCESS, type = &quot;json&quot;, params = { &quot;root&quot;, &quot;response&quot; }) })
    public String execute() throws Exception {
        this.session = ServletActionContext.getRequest().getSession();
        List&lt;Customer&gt; list = (List&lt;Customer&gt;) session.getAttribute(&quot;mylist&quot;);
        if (list == null) {
            list = CustomerDAO.buildList();
        }

        List&lt;Customer&gt; data = this.applyFilter(list, this.request.getSearch().getValue());
        int to = this.request.getStart().intValue() + this.request.getLength() &gt; data.size() ? data.size()
                : this.request.getStart().intValue() + this.request.getLength();
        this.applySort(data);
        this.response.setData(CustomerDAO.getCustomers(data, this.request.getStart().intValue(), to));
        this.response.setRecordsTotal((long) list.size());
        this.response.setRecordsFiltered(data.size() != list.size() ? (long) data.size() : (long) list.size());
        // only for showcase functionality, don't do this in production
        session.setAttribute(&quot;mylist&quot;, list);
        return SUCCESS;
    }

    // demo filtering method.
    private List&lt;Customer&gt; applyFilter(List&lt;Customer&gt; list, String pattern) {
        List&lt;Customer&gt; ret = new ArrayList&lt;&gt;();
        if (pattern != null && !&quot;&quot;.equals(pattern.trim())) {
            for (Customer c : list) {
                if (c.getName().toLowerCase().contains(pattern.toLowerCase())) {
                    ret.add(c);
                }
            }
        } else {
            ret = list;
        }
        return ret;
    }

    private void applySort(List&lt;Customer&gt; list) {
        String direction = this.request.getOrder().get(0).getDir();
        Collections.sort(list, new Comparator&lt;Customer&gt;() {

            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        if (direction != null && &quot;desc&quot;.equals(direction)) {
            Collections.reverse(list);
        }
    }

    public ServerSideProcessingResponse getResponse() {
        return this.response;
    }

    public void setRequest(ServerSideProcessingRequest request) {
        this.request = request;
    }

    @Override
    public ServerSideProcessingRequest getModel() {
        return this.request;
    }

    public ServerSideProcessingRequest getRequest() {
        return this.request;
    }

}
            
        </code>
    </pre>
</div>
</sj:tabbedpanel>
