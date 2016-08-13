<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>
<h2>DataTables</h2>

<p class="text">
JQuery DataTables integration Demo : Client-side processing, row grouping using draw callback
</p>
<style type="text/css" class="init">
    
tr.group,
tr.group:hover {
    background-color: #ddd !important;
}
tr.group.collapsed > td:first-child:before{
 top: 9px;
  left: 4px;
  height: 14px;
  width: 14px;
  display: inline-block;
  color: white;
  border: 2px solid white;
  border-radius: 14px;
  box-shadow: 0 0 3px #444;
  box-sizing: content-box;
  text-align: center;
  font-family: 'Courier New', Courier, monospace;
  line-height: 14px;
  content: '+';
  background-color: #31b131;
}
tr.group > td:first-child:before{
    top: 9px;
  left: 4px;
  height: 14px;
  width: 14px;
  display: inline-block;
  color: white;
  border: 2px solid white;
  border-radius: 14px;
  box-shadow: 0 0 3px #444;
  box-sizing: content-box;
  text-align: center;
  font-family: 'Courier New', Courier, monospace;
  line-height: 14px;
 content: '-';
  background-color: #d33333;
}
</style>
    <script>
    function group(settings){
           var api = this.api();
           var rows = api.rows( {page:'current'} ).nodes();
           var last=null;
           var nb = 0;
           api.column(2, {page:'current'} ).data().each( function ( group, i ) { 	   
               if ( last !== group ) {
            	   nb++;
                   $(rows).eq( i ).before(
                       '<tr data-group="'+nb+'" class="group"><td colspan="5">'+group+'</td></tr>'
                   );
                   last = group;
                   
               }
               $(rows).eq( i ).addClass("child-of-group-" + nb);
           } );
    }
    
</script>
<s:url var="remoteurl" action="datatables-json" namespace="/datatables"/>
<sjdt:datatables id="groupTable" ajax="{url:'%{remoteurl}',dataSrc:'myCustomers'}" datatablesTheme="jqueryui" style="width:100%;" processing="true" dom="Blfrtip" buttons="true" drawCallback="window.group"
columns="[
            {data:'id',title:'ID',orderable:false},
            {data:'name',title:'Name',orderable:false},
            {data:'country',title:'Country',orderable:false,visible:false},
            {data:'city',title:'City',orderable:false},
            {data:'creditLimit',title:'Credit Limit',orderable:false,render:$.fn.dataTable.render.number(',','.',2)}
]"
 order="[[ 2, 'asc' ]]" >
    <caption class="ui-widget-header">Customers Examples</caption>
</sjdt:datatables>
<script>
$('#groupTable tbody').on( 'click', 'tr.group', function () {
	var group = $(this).data("group");
	$(this).toggleClass("collapsed");
	$("tr.child-of-group-"+group).toggle();
 });
</script>

<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs">
<sj:tab id="tab1" target="jsp" label="JSP"/>
<sj:tab id="tab2" target="css" label="CSS"/>
<sj:tab id="tab3" target="java" label="Struts2 Action"/>
<div id="jsp">
	  <pre>
            <code class="html">
&lt;script&gt;
    function group(settings){
           var api = this.api();
           var rows = api.rows( {page:'current'} ).nodes();
           var last=null;
           var nb = 0;
           api.column(2, {page:'current'} ).data().each( function ( group, i ) {       
               if ( last !== group ) {
                   nb++;
                   $(rows).eq( i ).before(
                       '&lt;tr data-group=&quot;'+nb+'&quot; class=&quot;group&quot;&gt;&lt;td colspan=&quot;5&quot;&gt;'+group+'&lt;/td&gt;&lt;/tr&gt;'
                   );
                   last = group;
                   
               }
               $(rows).eq( i ).addClass(&quot;child-of-group-&quot; + nb);
           } );
    }
    
&lt;/script&gt;
&lt;s:url var=&quot;remoteurl&quot; action=&quot;datatables-json&quot; namespace=&quot;/datatables&quot;/&gt;
&lt;sjdt:datatables id=&quot;groupTable&quot; ajax=&quot;{url:'%{remoteurl}',dataSrc:'myCustomers'}&quot; datatablesTheme=&quot;jqueryui&quot; style=&quot;width:100%;&quot; processing=&quot;true&quot; dom=&quot;Blfrtip&quot; buttons=&quot;true&quot; drawCallback=&quot;window.group&quot;
columns=&quot;[
            {data:'id',title:'ID',orderable:false},
            {data:'name',title:'Name',orderable:false},
            {data:'country',title:'Country',orderable:false,visible:false},
            {data:'city',title:'City',orderable:false},
            {data:'creditLimit',title:'Credit Limit',orderable:false,render:$.fn.dataTable.render.number(',','.',2)}
]&quot;
 order=&quot;[[ 2, 'asc' ]]&quot; &gt;
    &lt;caption class=&quot;ui-widget-header&quot;&gt;Customers Examples&lt;/caption&gt;
&lt;/sjdt:datatables&gt;
&lt;script&gt;
$('#groupTable tbody').on( 'click', 'tr.group', function () {
    var group = $(this).data(&quot;group&quot;);
    $(this).toggleClass(&quot;collapsed&quot;);
    $(&quot;tr.child-of-group-&quot;+group).toggle();
 });
&lt;/script&gt;
            </code>
	  </pre>
</div>
<div id="css">
      <pre>
            <code class="css">
tr.group,
tr.group:hover {
    background-color: #ddd !important;
}
tr.group.collapsed > td:first-child:before{
 top: 9px;
  left: 4px;
  height: 14px;
  width: 14px;
  display: inline-block;
  color: white;
  border: 2px solid white;
  border-radius: 14px;
  box-shadow: 0 0 3px #444;
  box-sizing: content-box;
  text-align: center;
  font-family: 'Courier New', Courier, monospace;
  line-height: 14px;
  content: '+';
  background-color: #31b131;
}
tr.group > td:first-child:before{
    top: 9px;
  left: 4px;
  height: 14px;
  width: 14px;
  display: inline-block;
  color: white;
  border: 2px solid white;
  border-radius: 14px;
  box-shadow: 0 0 3px #444;
  box-sizing: content-box;
  text-align: center;
  font-family: 'Courier New', Courier, monospace;
  line-height: 14px;
 content: '-';
  background-color: #d33333;
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
