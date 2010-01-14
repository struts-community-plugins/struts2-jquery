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

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.grid.showcase.dao.CustomersDao;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerCountrys extends ActionSupport {
  private List<String>      countrys;
  private CustomersDao customersDao = new CustomersDao();

  private static final long serialVersionUID = 6721064966173343669L;

  @Action(value = "/customer-countrys", results = {
    @Result(location = "customer-countrys.jsp", name = "success")
  })
  public String execute() throws Exception
  {
    countrys = customersDao.findCountrys();
    return SUCCESS;
  }
  
  public List<String> getCountrys()
  {
    return countrys;
  }
}
