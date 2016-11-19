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

import com.jgeppert.struts2.jquery.grid.showcase.dao.OrderDetailDao;
import com.jgeppert.struts2.jquery.grid.showcase.model.OrderDetail;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Result(type = "json")
public class JsonOrderDetailsAction extends ActionSupport {

    private static final long serialVersionUID = 1547264277068533593L;
    private static final Logger log = LogManager.getLogger(JsonOrderDetailsAction.class);

    @Inject
    private OrderDetailDao orderdetailDao;

    // for Footerrow
    Map<String, Object> userdata = new HashMap<>();

    private Integer id;

    // Your result List
    private List<OrderDetail> gridModel;

    // get how many rows we want to have into the grid - rowNum attribute in the
    // grid
    private Integer rows = 0;

    // Get the requested page. By default grid sets this to 1.
    private Integer page = 0;

    // sorting order - asc or desc
    private String sord = "asc";

    // get index row - i.e. user click to sort.
    private String sidx;

    // Your Total Pages
    private Integer total = 0;

    // All Records
    private Integer records = 0;

    public String execute() {
        log.debug("Details for order : {}", id);

        // Calculate until rows ware selected
        int to = (rows * page);

        // Criteria to Build SQL

        if (id != null) gridModel = orderdetailDao.findByOrder(id);

        Double priceeach = 0.0;
        for (OrderDetail od : gridModel) {
            priceeach += od.getPriceeach();
        }
        userdata.put("priceeach", priceeach);
        userdata.put("productname", "Total :");

        records = gridModel.size();

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
     * @param records total number of records for the query. e.g. select count(*) from
     *                table
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
    public List<OrderDetail> getGridModel() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, Object> getUserdata() {
        return userdata;
    }
}
