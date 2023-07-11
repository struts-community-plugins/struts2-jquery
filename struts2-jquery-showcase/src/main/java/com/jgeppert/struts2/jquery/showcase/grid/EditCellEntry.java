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

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.action.SessionAware;

import java.util.List;
import java.util.Map;

@Actions({@Action(value = "/edit-cell-entry", results = {
        @Result(location = "../simpleecho.jsp", name = "success"),
        @Result(location = "../simpleecho.jsp", name = "input")})})
public class EditCellEntry extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = -3454448309088641394L;
    private static final Logger log = LogManager.getLogger(EditCellEntry.class);

    private int id;
    private double creditLimit;
    private Map<String, Object> session;

    @SuppressWarnings("unchecked")
    public String execute() throws Exception {
        log.debug("Edit cell entry with id: {} and creditLimit: {}", id, creditLimit);

        List<Customer> myCustomers;
        Object list = session.get("mylist");
        if (list != null) {
            myCustomers = (List<Customer>) list;
        } else {
            myCustomers = CustomerDAO.buildList();
        }

        Customer customer = CustomerDAO.findById(myCustomers, id);
        if (customer != null)
            customer.setCreditLimit(creditLimit);

        session.put("mylist", myCustomers);

        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void withSession(Map<String, Object> session) {
        this.session = session;
    }
}
