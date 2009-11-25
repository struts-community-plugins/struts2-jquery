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

package com.jgeppert.struts2.jquery.showcase;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage( value = "showcase")
public class JsonTable extends ActionSupport{
    
	private static final long serialVersionUID = 5078264277068533593L;
	private static final Log    log               = LogFactory.getLog(JsonTable.class);
    private List<Customer> rows;
	private Integer page; //the number of the requested page
	private Integer total; //the number of the requested page
	private Integer record; //the number of the requested page

    @Actions({@Action(value="/jsontable", results={@Result(name="success",type="json")}) })
    public String execute() {
      
      log.info("build json table");
      
      rows = CustomerDAO.getCustomers();
      
      page = 2;
      record = rows.size();
      total = (record/10)+1;
      return SUCCESS;
    }

    public String getJSON(){
    	return execute();
    }


 	public Integer getPage() {
		return page;
	}

	public List<Customer> getRows() {
		return rows;
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getRecord() {
		return record;
	}

}
