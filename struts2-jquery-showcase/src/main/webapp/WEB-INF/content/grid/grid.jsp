<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<h2>Grid</h2>

<p class="text">
	A grid with pager. This grid is sortable by name column.
</p>
<s:url var="remoteurl" action="grid-data-provider" namespace="/grid"/>
<sjg:grid
		id="gridtable"
		caption="Customers Examples"
		dataType="json"
		href="%{remoteurl}"
		pager="true"
		gridModel="gridModel"
		rowList="10,15,20"
		rowNum="15"
		rownumbers="true"
		resizable="true"
		shrinkToFit="true"
>
	<sjg:gridColumn name="id" index="id" title="ID" width="30" formatter="integer" sortable="false" displayTitle="false"/>
	<sjg:gridColumn name="name" index="name" title="Name" width="290" sortable="true"/>
	<sjg:gridColumn name="country" index="country" width="100" title="Country" sortable="false"/>
	<sjg:gridColumn name="city" index="city" width="100" title="City" sortable="false"/>
	<sjg:gridColumn name="creditLimit" index="creditLimit" width="100" title="Credit Limit" align="right"
	                formatter="currency" sortable="false"/>
</sjg:grid>


<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs">
<sj:tab id="tab1" target="jsp" label="JSP"/>
<sj:tab id="tab2" target="java" label="Struts2 Action"/>
<div id="jsp">
	  <pre>
            <code class="html">
&lt;s:url var=&quot;remoteurl&quot; action=&quot;grid-data-provider&quot; namespace=&quot;/grid&quot;/&gt;
&lt;sjg:grid
  id=&quot;gridtable&quot;
  caption=&quot;Customers Examples&quot;
  dataType=&quot;json&quot;
  href=&quot;%{remoteurl}&quot;
  pager=&quot;true&quot;
  gridModel=&quot;gridModel&quot;
  rowList=&quot;10,15,20&quot;
  rowNum=&quot;15&quot;
  rownumbers=&quot;true&quot;
  resizable=&quot;true&quot;
  width=&quot;700&quot;
  shrinkToFit=&quot;true&quot;
&gt;
  &lt;sjg:gridColumn name=&quot;id&quot; index=&quot;id&quot; title=&quot;ID&quot; width=&quot;30&quot; formatter=&quot;integer&quot; sortable=&quot;false&quot; displayTitle=&quot;false&quot;/&gt;
  &lt;sjg:gridColumn name=&quot;name&quot; index=&quot;name&quot; title=&quot;Name&quot; width=&quot;290&quot; sortable=&quot;true&quot;/&gt;
  &lt;sjg:gridColumn name=&quot;country&quot; index=&quot;country&quot; width=&quot;100&quot; title=&quot;Country&quot; sortable=&quot;false&quot;/&gt;
  &lt;sjg:gridColumn name=&quot;city&quot; index=&quot;city&quot; width=&quot;100&quot; title=&quot;City&quot; sortable=&quot;false&quot;/&gt;
  &lt;sjg:gridColumn name=&quot;creditLimit&quot; index=&quot;creditLimit&quot; width=&quot;100&quot; title=&quot;Credit Limit&quot; align=&quot;right&quot;
  formatter=&quot;currency&quot; sortable=&quot;false&quot;/&gt;
&lt;/sjg:grid&gt;
            </code>
	  </pre>
</div>
<div id="java">
  <pre>
            <code class="java">
package com.jgeppert.struts2.jquery.showcase.grid;

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;

@Result(name = &quot;success&quot;, type = &quot;json&quot;)
public class GridDataProvider extends ActionSupport implements SessionAware {

  private static final long serialVersionUID = 5078264277068533593L;
  private static final Log log = LogFactory.getLog(GridDataProvider.class);

  // Your result List
  private List&lt;Customer&gt; gridModel;

  // get how many rows we want to have into the grid - rowNum attribute in the
  // grid
  private Integer rows = 0;

  // Get the requested page. By default grid sets this to 1.
  private Integer page = 0;

  // sorting order - asc or desc
  private String sord;

  // get index row - i.e. user click to sort.
  private String sidx;

  // Search Field
  private String searchField;

  // The Search String
  private String searchString;

  // Limit the result when using local data, value form attribute rowTotal
  private Integer totalrows;

  // he Search Operation
  // ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
  private String searchOper;

  // Your Total Pages
  private Integer total = 0;

  // All Records
  private Integer records = 0;

  private boolean loadonce = false;
  private Map&lt;String, Object&gt; session;
  private List&lt;Customer&gt; myCustomers;

  public String execute() {
    log.debug(&quot;Page &quot; + getPage() + &quot; Rows &quot; + getRows()
    + &quot; Sorting Order &quot; + getSord() + &quot; Index Row :&quot; + getSidx());
    log.debug(&quot;Search :&quot; + searchField + &quot; &quot; + searchOper + &quot; &quot;
    + searchString);

    Object list = session.get(&quot;mylist&quot;);
    if (list != null) {
      myCustomers = (List&lt;Customer&gt;) list;
    } else {
      log.debug(&quot;Build new List&quot;);
      myCustomers = CustomerDAO.buildList();
    }

    if (sord != null &amp;&amp; sord.equalsIgnoreCase(&quot;asc&quot;)) {
      Collections.sort(myCustomers);
    }
    if (sord != null &amp;&amp; sord.equalsIgnoreCase(&quot;desc&quot;)) {
      Collections.sort(myCustomers);
      Collections.reverse(myCustomers);
    }

    // Count all record (select count(*) from your_custumers)
    records = CustomerDAO.getCustomersCount(myCustomers);

    if (totalrows != null) {
      records = totalrows;
    }

    // Calucalate until rows ware selected
    int to = (rows * page);

    // Calculate the first row to read
    int from = to - rows;

    // Set to = max rows
    if (to &gt; records)
    to = records;

    if (loadonce) {
    if (totalrows != null &amp;&amp; totalrows &gt; 0) {
      Collections.sort(myCustomers, new Comparator&lt;Customer&gt;() {
          public int compare(Customer o1, Customer o2) {
          return o1.getCountry().compareToIgnoreCase(o2.getCountry());
        }
      });
      setGridModel(myCustomers.subList(0, totalrows));
      } else {
        // All Customer
        setGridModel(sortListByCountry(myCustomers));
      }
    } else {
      // Search Customers
      if (searchString != null &amp;&amp; searchOper != null) {
      int id = Integer.parseInt(searchString);
      if (searchOper.equalsIgnoreCase(&quot;eq&quot;)) {
      log.debug(&quot;search id equals &quot; + id);
      List&lt;Customer&gt; cList = new ArrayList&lt;Customer&gt;();
      Customer customer = CustomerDAO.findById(myCustomers, id);

        if (customer != null)
          cList.add(customer);

          setGridModel(cList);
        } else if (searchOper.equalsIgnoreCase(&quot;ne&quot;)) {
          log.debug(&quot;search id not &quot; + id);
          setGridModel(CustomerDAO.findNotById(myCustomers, id, from, to));
        } else if (searchOper.equalsIgnoreCase(&quot;lt&quot;)) {
          log.debug(&quot;search id lesser then &quot; + id);
          setGridModel(CustomerDAO.findLesserAsId(myCustomers, id, from, to));
        } else if (searchOper.equalsIgnoreCase(&quot;gt&quot;)) {
          log.debug(&quot;search id greater then &quot; + id);
          setGridModel(CustomerDAO.findGreaterAsId(myCustomers, id, from, to));
        }
      } else {
        setGridModel(CustomerDAO.getCustomers(myCustomers, from, to));
      }
    }

    // Calculate total Pages
    if(loadonce) {
      total = records;
      rows = records;
    } else{
      total = (int) Math.ceil((double) records / (double) rows);
    }

    // only for showcase functionality, don't do this in production
    session.put(&quot;mylist&quot;, myCustomers);

    return SUCCESS;
  }

  private List&lt;Customer&gt; sortListByCountry(List&lt;Customer&gt; customers) {
    Collections.sort(customers, new Comparator&lt;Customer&gt;(){
      public int compare(Customer o1, Customer o2){
        return o1.getCountry().compareTo(o2.getCountry());
      }
    });

    return customers;
  }

  public String getJSON() {
    return execute();
  }

  /**
  * @return how many rows we want to have into the grid
  */
  public Integer getRows() {
    return rows;
  }

  /**
  * @param rows how many rows we want to have into the grid
  */
  public void setRows(Integer rows) {
    this.rows = rows;
  }

  /**
  * @return current page of the query
  */
  public Integer getPage() {
    return page;
  }

  /**
  * @param page current page of the query
  */
  public void setPage(Integer page) {
    this.page = page;
  }

  /**
  * @return total pages for the query
  */
  public Integer getTotal() {
    return total;
  }

  /**
  * @param total total pages for the query
  */
  public void setTotal(Integer total) {
    this.total = total;
  }

  /**
  * @return total number of records for the query. e.g. select count(*) from
  *         table
  */
  public Integer getRecords() {
    return records;
  }

  /**
  * @param records total number of records for the query. e.g. select count(*)
  *               from table
  */
  public void setRecords(Integer records) {

    this.records = records;

    if (this.records &gt; 0 &amp;&amp; this.rows &gt; 0) {
      this.total = (int) Math.ceil((double) this.records / (double) this.rows);
    } else {
      this.total = 0;
    }
  }

  /**
  * @return an collection that contains the actual data
  */
  public List&lt;Customer&gt; getGridModel() {
    return gridModel;
  }

  /**
  * @param gridModel an collection that contains the actual data
  */
  public void setGridModel(List&lt;Customer&gt; gridModel) {
    this.gridModel = gridModel;
  }

  /**
  * @return sorting order
  */
  public String getSord() {
    return sord;
  }

  /**
  * @param sord sorting order
  */
  public void setSord(String sord) {
    this.sord = sord;
  }

  /**
  * @return get index row - i.e. user click to sort.
  */
  public String getSidx() {
    return sidx;
  }

  /**
  * @param sidx get index row - i.e. user click to sort.
  */
  public void setSidx(String sidx) {
    this.sidx = sidx;
  }

  public void setSearchField(String searchField) {
    this.searchField = searchField;
  }

  public void setSearchString(String searchString) {
    this.searchString = searchString;
  }

  public void setSearchOper(String searchOper) {
    this.searchOper = searchOper;
  }

  public void setLoadonce(boolean loadonce) {
    this.loadonce = loadonce;
  }

  public void setSession(Map&lt;String, Object&gt; session) {
    this.session = session;
  }

  public void setTotalrows(Integer totalrows) {
   this.totalrows = totalrows;
  }

}

            </code>
	  </pre>
</div>
</sj:tabbedpanel>
