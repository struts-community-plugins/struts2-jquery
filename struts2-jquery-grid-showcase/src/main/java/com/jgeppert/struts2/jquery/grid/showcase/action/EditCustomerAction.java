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

import com.jgeppert.struts2.jquery.grid.showcase.dao.CustomerDao;
import com.jgeppert.struts2.jquery.grid.showcase.dao.EmployeeDao;
import com.jgeppert.struts2.jquery.grid.showcase.model.Customer;
import com.jgeppert.struts2.jquery.grid.showcase.model.Employee;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.inject.Inject;
import java.util.StringTokenizer;

@Results({@Result(name = "error", location = "messages.jsp")})
public class EditCustomerAction extends ActionSupport {

    private static final long serialVersionUID = -3454448309088641394L;
    private static final Logger log = LogManager.getLogger(EditCustomerAction.class);

    @Inject
    private CustomerDao customerDao;

    @Inject
    private EmployeeDao employeeDao;

    private String oper = "edit";
    private String id;
    private String customername;
    private String contactfirstname;
    private String contactlastname;
    private String country;
    private String city;
    private double creditlimit;
    private Employee salesemployee;

    public String execute() throws Exception {
        log.debug("Edit Customer :" + id);

        Customer customer;

        try {
            if (oper.equalsIgnoreCase("add")) {
                log.debug("Add Customer");
                customer = new Customer();

                int nextid = customerDao.nextCustomerNumber();
                log.debug("Id for next customer is: {}", nextid);
                customer.setCustomernumber(nextid);
                customer.setCustomername(customername);
                customer.setCountry(country);
                customer.setCity(city);
                customer.setCreditlimit(creditlimit);
                customer.setContactfirstname(contactfirstname);
                customer.setContactlastname(contactlastname);

                if (salesemployee != null) {
                    customer.setSalesemployee(employeeDao.get(salesemployee
                            .getEmployeenumber()));
                }

                customerDao.save(customer);
            } else if (oper.equalsIgnoreCase("edit")) {
                log.debug("Edit customer: {}", id);

                customer = customerDao.get(Integer.parseInt(id));
                customer.setCustomername(customername);
                customer.setCountry(country);
                customer.setCity(city);
                customer.setCreditlimit(creditlimit);
                customer.setContactfirstname(contactfirstname);
                customer.setContactlastname(contactlastname);

                if (salesemployee != null) {
                    customer.setSalesemployee(employeeDao.get(salesemployee
                            .getEmployeenumber()));
                }
                customerDao.update(customer);
            } else if (oper.equalsIgnoreCase("del")) {
                StringTokenizer ids = new StringTokenizer(id, ",");
                while (ids.hasMoreTokens()) {
                    int removeId = Integer.parseInt(ids.nextToken());
                    log.debug("Delete customer with id: {}", removeId);
                    customerDao.delete(removeId);
                }
            }
        } catch (Exception e) {
            addActionError("ERROR: Is database in read/write mode?");
            //addActionError("ERROR: " + e.getLocalizedMessage());
            return "error";
        }
        return NONE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public double getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(double creditlimit) {
        this.creditlimit = creditlimit;
    }

    public Employee getSalesemployee() {
        return salesemployee;
    }

    public void setSalesemployee(Employee salesemployee) {
        this.salesemployee = salesemployee;
    }

    public String getContactfirstname() {
        return contactfirstname;
    }

    public void setContactfirstname(String contactfirstname) {
        this.contactfirstname = contactfirstname;
    }

    public String getContactlastname() {
        return contactlastname;
    }

    public void setContactlastname(String contactlastname) {
        this.contactlastname = contactlastname;
    }

}
