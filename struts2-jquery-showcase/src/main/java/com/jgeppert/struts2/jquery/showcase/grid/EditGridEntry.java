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

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;

@Actions({ @Action(value = "/edit-grid-entry", results = {
	@Result(location = "../simpleecho.jsp", name = "success"),
	@Result(location = "../simpleecho.jsp", name = "input") }) })
public class EditGridEntry extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = -3454448309088641394L;
    private static final Log log = LogFactory.getLog(EditGridEntry.class);

    private String oper = "";
    private String id;
    private String name;
    private String country;
    private String city;
    private double creditLimit;
    private Map<String, Object> session;
    private List<Customer> myCustomers;

    @SuppressWarnings("unchecked")
    public String execute() throws Exception {
	log.debug("id :" + id);
	log.debug("name :" + name);
	log.debug("country :" + country);
	log.debug("city :" + city);
	log.debug("creditLimit :" + creditLimit);

	Object list = session.get("mylist");
	if (list != null) {
	    myCustomers = (List<Customer>) list;
	} else {
	    myCustomers = CustomerDAO.buildList();
	}

	Customer customer;

	if (oper.equalsIgnoreCase("add")) {
	    log.debug("Add Customer");
	    customer = new Customer();

	    customer.setId(new Random().nextInt());
	    customer.setName(name);
	    customer.setCountry(country);
	    customer.setCity(city);
	    customer.setCreditLimit(creditLimit);

	    myCustomers.add(customer);
	} else if (oper.equalsIgnoreCase("edit")) {
	    log.debug("Edit Customer");

	    customer = CustomerDAO.findById(myCustomers, Integer.parseInt(id));
	    customer.setName(name);
	    customer.setCountry(country);
	    customer.setCity(city);
	    customer.setCreditLimit(creditLimit);
	} else if (oper.equalsIgnoreCase("del")) {
	    StringTokenizer ids = new StringTokenizer(id, ",");
	    while (ids.hasMoreTokens()) {
		int removeId = Integer.parseInt(ids.nextToken());
		log.debug("Delete Customer " + removeId);
		customer = CustomerDAO.findById(myCustomers, removeId);
		myCustomers.remove(customer);
	    }
	}

	session.put("mylist", myCustomers);

	return SUCCESS;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public double getCreditLimit() {
	return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
	this.creditLimit = creditLimit;
    }

    public void setSession(Map<String, Object> session) {
	this.session = session;
    }

    public void setOper(String oper) {
	this.oper = oper;
    }
}
