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

package com.jgeppert.struts2.jquery.grid.showcase;

import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.jgeppert.struts2.jquery.grid.showcase.dao.CustomersDao;
import com.jgeppert.struts2.jquery.grid.showcase.model.Customers;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "showcase")
public class EditCustomer extends ActionSupport {

  private static final long   serialVersionUID = -3454448309088641394L;
  private static final Log    log              = LogFactory.getLog(EditCustomer.class);

  private CustomersDao customersDao = new CustomersDao();

  private String              oper = "edit";
  private String              id;
  private String              customername;
  private String              country;
  private String              city;
  private double              creditlimit;

    @Action(value = "/edit-customer", results = {
      @Result(location = "empty.jsp", name = "success")
    })
  public String execute() throws Exception
  {
    log.debug("oper :" + oper);
    log.debug("id :" + id);
    log.debug("name :" + customername);
    log.debug("country :" + country);
    log.debug("city :" + city);
    log.debug("creditLimit :" + creditlimit);


    Customers customer;

    if (oper.equalsIgnoreCase("add"))
    {
      log.debug("Add Customer");
      customer = new Customers();

      customer.setCustomername(customername);
      customer.setCountry(country);
      customer.setCity(city);
      customer.setCreditlimit(creditlimit);

      customersDao.save(customer);
    }
    else if (oper.equalsIgnoreCase("edit"))
    {
      log.debug("Edit Customer");

      customer = customersDao.get(Integer.parseInt(id));
      customer.setCustomername(customername);
      customer.setCountry(country);
      customer.setCity(city);
      customer.setCreditlimit(creditlimit);
      
      customersDao.update(customer);
    }
    else if (oper.equalsIgnoreCase("del"))
    {
      StringTokenizer ids = new StringTokenizer(id, ",");
      while (ids.hasMoreTokens())
      {
        int removeId = Integer.parseInt(ids.nextToken());
        log.debug("Delete Customer " + removeId);
        customersDao.delete(removeId);
      }
    }

    return SUCCESS;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public void setOper(String oper)
  {
    this.oper = oper;
  }

  public String getCustomername()
  {
    return customername;
  }

  public void setCustomername(String customername)
  {
    this.customername = customername;
  }

  public double getCreditlimit()
  {
    return creditlimit;
  }

  public void setCreditlimit(double creditlimit)
  {
    this.creditlimit = creditlimit;
  }
  
  
}
