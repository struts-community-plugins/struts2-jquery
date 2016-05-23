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

import com.jgeppert.struts2.jquery.grid.showcase.dao.OrderDao;
import com.jgeppert.struts2.jquery.grid.showcase.model.Order;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import java.util.List;

@Result(type = "json")
public class JsonOrdersAction extends ActionSupport {

    private static final long serialVersionUID = 5078264277068533593L;
    private static final Logger log = LogManager.getLogger(JsonOrdersAction.class);

    @Inject
    private OrderDao ordersDao;

    private Integer id;

    // Your result List
    private List<Order> gridModel;

    // get how many rows we want to have into the grid - rowNum attribute in the
    // grid
    private Integer rows = 0;

    // Get the requested page. By default grid sets this to 1.
    private Integer page = 0;

    // sorting order - asc or desc
    private String sord = "asc";

    // get index row - i.e. user click to sort.
    private String sidx;

    // Search Field
    private String searchField;

    // The Search String
    private String searchString;

    // he Search Operation
    // ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
    private String searchOper;

    // Your Total Pages
    private Integer total = 0;

    // All Records
    private Integer records = 0;

    public String execute() {
        log.debug("Page " + getPage() + " Rows " + getRows() + " Sorting Order " + getSord() + " Index Row :" + getSidx());
        log.debug("Search :" + searchField + " " + searchOper + " " + searchString);

        // Calculate until rows ware selected
        int to = (rows * page);

        // Calculate the first row to read
        int from = to - rows;

        // Criteria to Build SQL
        DetachedCriteria criteria = DetachedCriteria.forClass(Order.class);

        if (id != null) {
            criteria.createAlias("customer", "c");
            criteria.add(Restrictions.eq("c.customernumber", id));
        }


        // Handle Search
        if (searchField != null) {
            if (searchField.equals("customernumber")) {
                Integer searchValue = Integer.parseInt(searchString);
                switch (searchOper) {
                    case "eq":
                        criteria.add(Restrictions.eq("ordernumber", searchValue));
                        break;
                    case "ne":
                        criteria.add(Restrictions.ne("ordernumber", searchValue));
                        break;
                    case "lt":
                        criteria.add(Restrictions.lt("ordernumber", searchValue));
                        break;
                    case "gt":
                        criteria.add(Restrictions.gt("ordernumber", searchValue));
                        break;
                }
            } else if (searchField.equals("status") || searchField.equals("comments")) {
                switch (searchOper) {
                    case "eq":
                        criteria.add(Restrictions.eq(searchField, searchString));
                        break;
                    case "ne":
                        criteria.add(Restrictions.ne(searchField, searchString));
                        break;
                    case "bw":
                        criteria.add(Restrictions.like(searchField, searchString + "%"));
                        break;
                    case "cn":
                        criteria.add(Restrictions.like(searchField, "%" + searchString + "%"));
                        break;
                }
            }
            if (searchField.equals("customer")) {
                Integer searchValue = Integer.parseInt(searchString);
                criteria.createAlias("customer", "c");

                switch (searchOper) {
                    case "eq":
                        criteria.add(Restrictions.eq("c.customernumber", searchValue));
                        break;
                    case "ne":
                        criteria.add(Restrictions.ne("c.customernumber", searchValue));
                        break;
                    case "lt":
                        criteria.add(Restrictions.lt("c.customernumber", searchValue));
                        break;
                    case "gt":
                        criteria.add(Restrictions.gt("c.customernumber", searchValue));
                        break;
                }
            }
        }

        // Count Orders
        records = ordersDao.countByCriteria(criteria);

        // Reset count Projection
        criteria.setProjection(null);
        criteria.setResultTransformer(Criteria.ROOT_ENTITY);

        // Handle Order By
        if (sidx != null && !sidx.equals("")) {
            if (!sidx.equals("customer")) {
                if (sord.equals("asc")) criteria.addOrder(org.hibernate.criterion.Order.asc(sidx));
                else criteria.addOrder(org.hibernate.criterion.Order.desc(sidx));
            } else {
                if (sord.equals("asc")) criteria.addOrder(org.hibernate.criterion.Order.asc("customer.customernumber"));
                else criteria.addOrder(org.hibernate.criterion.Order.desc("customer.customernumber"));
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
     * table
     */
    public Integer getRecords() {
        return records;
    }

    /**
     * @param records total number of records for the query. e.g. select count(*)
     *                from table
     */
    public void setRecords(Integer records) {

        this.records = records;

        if (this.records > 0 && this.rows > 0) {
            this.total = (int) Math.ceil((double) this.records / (double) this.rows);
        } else {
            this.total = 0;
        }
    }

    /**
     * @return an collection that contains the actual data
     */
    public List<Order> getGridModel() {
        return gridModel;
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

    public void setId(Integer id) {
        this.id = id;
    }
}
