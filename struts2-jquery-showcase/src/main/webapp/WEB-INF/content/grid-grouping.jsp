<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<h2>Grid</h2>

<p class="text">
	A Grid with local data and grouping.
</p>
<s:url var="remoteurl" action="jsontable">
	<s:param name="loadonce" value="%{true}"/>
</s:url>
<sjg:grid
		id="gridgrouping"
		caption="Customers Examples (Grouping)"
		loadonce="true"
		href="%{remoteurl}"
		gridModel="gridModel"
		groupField="['country']"
		groupColumnShow="[false]"
		groupCollapse="true"
		groupText="['<b>{0} - {1} Customer(s)</b>']"
		navigator="true"
		navigatorAdd="false"
		navigatorEdit="false"
		navigatorDelete="false"
		navigatorView="true"
		rowTotal="70"
		rowNum="-1"
		altRows="true"
		viewrecords="true"
		pager="true"
		pagerButtons="false"
		pagerInput="false"
		>
	<sjg:gridColumn name="id" index="id" title="ID" width="30" formatter="integer" sortable="false"/>
	<sjg:gridColumn name="name" index="name" title="Name" sortable="true"/>
	<sjg:gridColumn name="lastName" index="lastName" title="Last Name" sortable="true"/>
	<sjg:gridColumn name="country" index="country" title="Country" sortable="false"/>
	<sjg:gridColumn name="city" index="city" title="City" sortable="false"/>
	<sjg:gridColumn name="creditLimit" index="creditLimit" title="Credit Limit" align="right" formatter="currency"
	                sortable="false"/>
</sjg:grid>

<br/>
<sj:tabbedpanel id="localtabs" cssClass="list">
<sj:tab id="tab1" target="jsp" label="JSP"/>
<sj:tab id="tab2" target="java" label="Struts2 Action"/>
<div id="jsp">
	  <pre>
    &lt;s:url id=&quot;remoteurl&quot; action=&quot;jsontable&quot;&gt;
    	&lt;s:param name=&quot;loadonce&quot; value=&quot;%{true}&quot; /&gt;
    &lt;/s:url&gt;
    &lt;sjg:grid
    	id=&quot;gridgrouping&quot;
    	caption=&quot;Customers Examples (Grouping)&quot;
    	loadonce=&quot;true&quot;
    	href=&quot;%{remoteurl}&quot;
    	gridModel=&quot;gridModel&quot;
    	groupField=&quot;['country']&quot;
    	groupColumnShow=&quot;[false]&quot;
    	groupCollapse=&quot;true&quot;
    	groupText=&quot;['&lt;b&gt;{0} - {1} Customer(s)&lt;/b&gt;']&quot;
    	navigator=&quot;true&quot;
    	navigatorAdd=&quot;false&quot;
    	navigatorEdit=&quot;false&quot;
    	navigatorDelete=&quot;false&quot;
    	navigatorView=&quot;true&quot;
    	rowTotal=&quot;70&quot;
    	rowNum=&quot;-1&quot;
    	altRows=&quot;true&quot;
    	viewrecords=&quot;true&quot;
    	pager=&quot;true&quot;
    	pagerButtons=&quot;false&quot;
    	pagerInput=&quot;false&quot;
    &gt;
    	&lt;sjg:gridColumn name=&quot;id&quot; index=&quot;id&quot; title=&quot;ID&quot; width=&quot;30&quot; formatter=&quot;integer&quot; sortable=&quot;false&quot;/&gt;
    	&lt;sjg:gridColumn name=&quot;name&quot; index=&quot;name&quot; title=&quot;Name&quot; sortable=&quot;true&quot;/&gt;
		&lt;sjg:gridColumn name=&quot;lastName&quot; index=&quot;lastName&quot; title=&quot;Last Name&quot; sortable=&quot;true&quot;/&gt;
    	&lt;sjg:gridColumn name=&quot;country&quot; index=&quot;country&quot; title=&quot;Country&quot; sortable=&quot;false&quot;/&gt;
    	&lt;sjg:gridColumn name=&quot;city&quot; index=&quot;city&quot; title=&quot;City&quot; sortable=&quot;false&quot;/&gt;
    	&lt;sjg:gridColumn name=&quot;creditLimit&quot; index=&quot;creditLimit&quot; title=&quot;Credit Limit&quot; align=&quot;right&quot; formatter=&quot;currency&quot; sortable=&quot;false&quot;/&gt;
    &lt;/sjg:grid&gt;
	  </pre>
</div>
<div id="java">
<pre>
package com.jgeppert.struts2.jquery.showcase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = &quot;showcase&quot;)
public class JsonTable extends ActionSupport implements SessionAware {

  private static final long   serialVersionUID = 5078264277068533593L;
  private static final Log    log              = LogFactory.getLog(JsonTable.class);

  // Your result List
  private List&lt;Customer&gt;      gridModel;

  // get how many rows we want to have into the grid - rowNum attribute in the
  // grid
  private Integer             rows             = 0;

  // Get the requested page. By default grid sets this to 1.
  private Integer             page             = 0;

  // sorting order - asc or desc
  private String              sord;

  // get index row - i.e. user click to sort.
  private String              sidx;

  // Search Field
  private String              searchField;

  // The Search String
  private String              searchString;

  // Limit the result when using local data, value form attribute rowTotal
  private Integer             totalrows;

  // he Search Operation
  // ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
  private String              searchOper;

  // Your Total Pages
  private Integer             total            = 0;

  // All Records
  private Integer             records          = 0;

  private boolean             loadonce         = false;
  private Map&lt;String, Object&gt; session;
  private List&lt;Customer&gt;      myCustomers;

  @Actions( {
    @Action(value = &quot;/jsontable&quot;, results = {
      @Result(name = &quot;success&quot;, type = &quot;json&quot;)
    })
  })
  public String execute()
  {
    log.debug(&quot;Page &quot; + getPage() + &quot; Rows &quot; + getRows() + &quot; Sorting Order &quot; + getSord() + &quot; Index Row :&quot; + getSidx());
    log.debug(&quot;Search :&quot; + searchField + &quot; &quot; + searchOper + &quot; &quot; + searchString);

    Object list = session.get(&quot;mylist&quot;);
    if (list != null)
    {
      myCustomers = (List&lt;Customer&gt;) list;
    }
    else
    {
      log.debug(&quot;Build new List&quot;);
      myCustomers = CustomerDAO.buildList();
    }

    if (sord != null &amp;&amp; sord.equalsIgnoreCase(&quot;asc&quot;))
    {
      Collections.sort(myCustomers);
    }
    if (sord != null &amp;&amp; sord.equalsIgnoreCase(&quot;desc&quot;))
    {
      Collections.sort(myCustomers);
      Collections.reverse(myCustomers);
    }

    // Count all record (select count(*) from your_custumers)
    records = CustomerDAO.getCustomersCount(myCustomers);

    if (totalrows != null)
    {
      records = totalrows;
    }

    // Calucalate until rows ware selected
    int to = (rows * page);

    // Calculate the first row to read
    int from = to - rows;

    // Set to = max rows
    if (to &gt; records) to = records;

    if (loadonce)
    {
      if (totalrows != null &amp;&amp; totalrows &gt; 0)
      {
        setGridModel(myCustomers.subList(0, totalrows));
      }
      else
      {
        // All Custumer
        setGridModel(myCustomers);
      }
    }
    else
    {
      // Search Custumers
      if (searchString != null &amp;&amp; searchOper != null)
      {
        int id = Integer.parseInt(searchString);
        if (searchOper.equalsIgnoreCase(&quot;eq&quot;))
        {
          log.debug(&quot;search id equals &quot; + id);
          List&lt;Customer&gt; cList = new ArrayList&lt;Customer&gt;();
          Customer customer = CustomerDAO.findById(myCustomers, id);

          if (customer != null) cList.add(customer);

          setGridModel(cList);
        }
        else if (searchOper.equalsIgnoreCase(&quot;ne&quot;))
        {
          log.debug(&quot;search id not &quot; + id);
          setGridModel(CustomerDAO.findNotById(myCustomers, id, from, to));
        }
        else if (searchOper.equalsIgnoreCase(&quot;lt&quot;))
        {
          log.debug(&quot;search id lesser then &quot; + id);
          setGridModel(CustomerDAO.findLesserAsId(myCustomers, id, from, to));
        }
        else if (searchOper.equalsIgnoreCase(&quot;gt&quot;))
        {
          log.debug(&quot;search id greater then &quot; + id);
          setGridModel(CustomerDAO.findGreaterAsId(myCustomers, id, from, to));
        }
      }
      else
      {
        setGridModel(CustomerDAO.getCustomers(myCustomers, from, to));
      }
    }

    // Calculate total Pages
    total = (int) Math.ceil((double) records / (double) rows);

    // only for showcase functionality, don't do this in production
    session.put(&quot;mylist&quot;, myCustomers);

    return SUCCESS;
  }

  public String getJSON()
  {
    return execute();
  }

  /**
   * @return how many rows we want to have into the grid
   */
  public Integer getRows()
  {
    return rows;
  }

  /**
   * @param rows
   *          how many rows we want to have into the grid
   */
  public void setRows(Integer rows)
  {
    this.rows = rows;
  }

  /**
   * @return current page of the query
   */
  public Integer getPage()
  {
    return page;
  }

  /**
   * @param page
   *          current page of the query
   */
  public void setPage(Integer page)
  {
    this.page = page;
  }

  /**
   * @return total pages for the query
   */
  public Integer getTotal()
  {
    return total;
  }

  /**
   * @param total
   *          total pages for the query
   */
  public void setTotal(Integer total)
  {
    this.total = total;
  }

  /**
   * @return total number of records for the query. e.g. select count(*) from
   *         table
   */
  public Integer getRecords()
  {
    return records;
  }

  /**
   * @param record
   *          total number of records for the query. e.g. select count(*) from
   *          table
   */
  public void setRecords(Integer records)
  {

    this.records = records;

    if (this.records &gt; 0 &amp;&amp; this.rows &gt; 0)
    {
      this.total = (int) Math.ceil((double) this.records / (double) this.rows);
    }
    else
    {
      this.total = 0;
    }
  }

  /**
   * @return an collection that contains the actual data
   */
  public List&lt;Customer&gt; getGridModel()
  {
    return gridModel;
  }

  /**
   * @param gridModel
   *          an collection that contains the actual data
   */
  public void setGridModel(List&lt;Customer&gt; gridModel)
  {
    this.gridModel = gridModel;
  }

  /**
   * @return sorting order
   */
  public String getSord()
  {
    return sord;
  }

  /**
   * @param sord
   *          sorting order
   */
  public void setSord(String sord)
  {
    this.sord = sord;
  }

  /**
   * @return get index row - i.e. user click to sort.
   */
  public String getSidx()
  {
    return sidx;
  }

  /**
   * @param sidx
   *          get index row - i.e. user click to sort.
   */
  public void setSidx(String sidx)
  {
    this.sidx = sidx;
  }

  public void setSearchField(String searchField)
  {
    this.searchField = searchField;
  }

  public void setSearchString(String searchString)
  {
    this.searchString = searchString;
  }

  public void setSearchOper(String searchOper)
  {
    this.searchOper = searchOper;
  }

  public void setLoadonce(boolean loadonce)
  {
    this.loadonce = loadonce;
  }

  public void setSession(Map&lt;String, Object&gt; session)
  {
    this.session = session;
  }

  public void setTotalrows(Integer totalrows)
  {
    this.totalrows = totalrows;
  }

}
	  </pre>
</div>
</sj:tabbedpanel>
