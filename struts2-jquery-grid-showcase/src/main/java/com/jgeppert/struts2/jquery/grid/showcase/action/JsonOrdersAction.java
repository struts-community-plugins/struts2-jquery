/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jgeppert.struts2.jquery.grid.showcase.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jgeppert.struts2.jquery.grid.showcase.dao.OrdersDao;
import com.jgeppert.struts2.jquery.grid.showcase.model.Orders;
import com.opensymphony.xwork2.ActionSupport;

@Result(type = "json")
public class JsonOrdersAction extends ActionSupport
{

	private static final long	serialVersionUID	= 5078264277068533593L;
	private static final Log	log					= LogFactory.getLog(JsonOrdersAction.class);

	  private Integer            id;

	  // Your result List
	private List<Orders>		gridModel;

	// get how many rows we want to have into the grid - rowNum attribute in the
	// grid
	private Integer				rows				= 0;

	// Get the requested page. By default grid sets this to 1.
	private Integer				page				= 0;

	// sorting order - asc or desc
	private String				sord				= "asc";

	// get index row - i.e. user click to sort.
	private String				sidx;

	// Search Field
	private String				searchField;

	// The Search String
	private String				searchString;

	// he Search Operation
	// ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String				searchOper;

	// Your Total Pages
	private Integer				total				= 0;

	// All Records
	private Integer				records				= 0;

	private OrdersDao			ordersDao			= new OrdersDao();

	public String execute() {
		log.debug("Page " + getPage() + " Rows " + getRows() + " Sorting Order " + getSord() + " Index Row :" + getSidx());
		log.debug("Search :" + searchField + " " + searchOper + " " + searchString);

		// Calcalate until rows ware selected
		int to = (rows * page);

		// Calculate the first row to read
		int from = to - rows;

		// Criteria to Build SQL
		DetachedCriteria criteria = DetachedCriteria.forClass(Orders.class);

	    if (id != null) {
			criteria.createAlias("customer", "c");
			criteria.add(Restrictions.eq("c.customernumber", id));
	    }


		// Handle Search
		if (searchField != null)
		{
			if (searchField.equals("customernumber"))
			{
				Integer searchValue = Integer.parseInt(searchString);
				if (searchOper.equals("eq")) criteria.add(Restrictions.eq("ordernumber", searchValue));
				else if (searchOper.equals("ne")) criteria.add(Restrictions.ne("ordernumber", searchValue));
				else if (searchOper.equals("lt")) criteria.add(Restrictions.lt("ordernumber", searchValue));
				else if (searchOper.equals("gt")) criteria.add(Restrictions.gt("ordernumber", searchValue));
			}
			else if (searchField.equals("status") || searchField.equals("comments"))
			{
				if (searchOper.equals("eq")) criteria.add(Restrictions.eq(searchField, searchString));
				else if (searchOper.equals("ne")) criteria.add(Restrictions.ne(searchField, searchString));
				else if (searchOper.equals("bw")) criteria.add(Restrictions.like(searchField, searchString + "%"));
				else if (searchOper.equals("cn")) criteria.add(Restrictions.like(searchField, "%" + searchString + "%"));
			}
			if (searchField.equals("customer"))
			{
				Integer searchValue = Integer.parseInt(searchString);
				criteria.createAlias("customer", "c");

				if (searchOper.equals("eq")) criteria.add(Restrictions.eq("c.customernumber", searchValue));
				else if (searchOper.equals("ne")) criteria.add(Restrictions.ne("c.customernumber", searchValue));
				else if (searchOper.equals("lt")) criteria.add(Restrictions.lt("c.customernumber", searchValue));
				else if (searchOper.equals("gt")) criteria.add(Restrictions.gt("c.customernumber", searchValue));
			}
		}

		// Count Orders
		records = ordersDao.countByCriteria(criteria);

		// Reset count Projection
		criteria.setProjection(null);
		criteria.setResultTransformer(Criteria.ROOT_ENTITY);

		// Handle Order By
		if (sidx != null && !sidx.equals(""))
		{
			if (!sidx.equals("customer"))
			{
				if (sord.equals("asc")) criteria.addOrder(Order.asc(sidx));
				else criteria.addOrder(Order.desc(sidx));
			}
			else
			{
				if (sord.equals("asc")) criteria.addOrder(Order.asc("customer.customernumber"));
				else criteria.addOrder(Order.desc("customer.customernumber"));
			}
		}

		// Get Customers by Criteria
		gridModel = ordersDao.findByCriteria(criteria, from, rows);

		// Set to = max rows
		if (to > records) to = records;

		// Calculate total Pages
		total = (int) Math.ceil((double) records / (double) rows);

		return SUCCESS;
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
	 * @param rows
	 *            how many rows we want to have into the grid
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
	 * @param page
	 *            current page of the query
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
	 * @param total
	 *            total pages for the query
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
	 * @param records
	 *            total number of records for the query. e.g. select count(*)
	 *            from table
	 */
	public void setRecords(Integer records) {

		this.records = records;

		if (this.records > 0 && this.rows > 0)
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
	public List<Orders> getGridModel() {
		return gridModel;
	}

	/**
	 * @return sorting order
	 */
	public String getSord() {
		return sord;
	}

	/**
	 * @param sord
	 *            sorting order
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
	 * @param sidx
	 *            get index row - i.e. user click to sort.
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

	public void setId(Integer id) {
		this.id = id;
	}
}
