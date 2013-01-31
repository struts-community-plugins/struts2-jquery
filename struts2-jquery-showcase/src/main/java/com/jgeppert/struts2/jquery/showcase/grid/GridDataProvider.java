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

package com.jgeppert.struts2.jquery.showcase.grid;

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;

@Result(name = "success", type = "json")
public class GridDataProvider extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 5078264277068533593L;
    private static final Log log = LogFactory.getLog(GridDataProvider.class);

    // Your result List
    private List<Customer> gridModel;

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
    private Map<String, Object> session;
    private List<Customer> myCustomers;

    @SuppressWarnings("unchecked")
    public String execute() {
        log.debug("Page " + getPage() + " Rows " + getRows()
                + " Sorting Order " + getSord() + " Index Row :" + getSidx());
        log.debug("Search :" + searchField + " " + searchOper + " "
                + searchString);

        Object list = session.get("mylist");
        if (list != null) {
            myCustomers = (List<Customer>) list;
        } else {
            log.debug("Build new List");
            myCustomers = CustomerDAO.buildList();
        }

        if (sord != null && sord.equalsIgnoreCase("asc")) {
            Collections.sort(myCustomers);
        }
        if (sord != null && sord.equalsIgnoreCase("desc")) {
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
        if (to > records)
            to = records;

        if (loadonce) {
            if (totalrows != null && totalrows > 0) {
                Collections.sort(myCustomers, new Comparator<Customer>() {
                    public int compare(Customer o1, Customer o2) {
                        return o1.getCountry().compareToIgnoreCase(o2.getCountry());
                    }
                });
                setGridModel(myCustomers.subList(0, totalrows));
            } else {
                // All Custumer
                setGridModel(myCustomers);
            }
        } else {
            // Search Custumers
            if (searchString != null && searchOper != null) {
                int id = Integer.parseInt(searchString);
                if (searchOper.equalsIgnoreCase("eq")) {
                    log.debug("search id equals " + id);
                    List<Customer> cList = new ArrayList<Customer>();
                    Customer customer = CustomerDAO.findById(myCustomers, id);

                    if (customer != null)
                        cList.add(customer);

                    setGridModel(cList);
                } else if (searchOper.equalsIgnoreCase("ne")) {
                    log.debug("search id not " + id);
                    setGridModel(CustomerDAO.findNotById(myCustomers, id, from,
                            to));
                } else if (searchOper.equalsIgnoreCase("lt")) {
                    log.debug("search id lesser then " + id);
                    setGridModel(CustomerDAO.findLesserAsId(myCustomers, id,
                            from, to));
                } else if (searchOper.equalsIgnoreCase("gt")) {
                    log.debug("search id greater then " + id);
                    setGridModel(CustomerDAO.findGreaterAsId(myCustomers, id,
                            from, to));
                }
            } else {
                setGridModel(CustomerDAO.getCustomers(myCustomers, from, to));
            }
        }

        // Calculate total Pages
        total = (int) Math.ceil((double) records / (double) rows);

        // only for showcase functionality, don't do this in production
        session.put("mylist", myCustomers);

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

        if (this.records > 0 && this.rows > 0) {
            this.total = (int) Math.ceil((double) this.records
                    / (double) this.rows);
        } else {
            this.total = 0;
        }
    }

    /**
     * @return an collection that contains the actual data
     */
    public List<Customer> getGridModel() {
        return gridModel;
    }

    /**
     * @param gridModel an collection that contains the actual data
     */
    public void setGridModel(List<Customer> gridModel) {
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

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setTotalrows(Integer totalrows) {
        this.totalrows = totalrows;
    }

}
