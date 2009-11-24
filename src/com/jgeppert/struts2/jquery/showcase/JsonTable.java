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

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage( value = "showcase")
public class JsonTable extends ActionSupport{
    
	private static final long serialVersionUID = 5078264277068533593L;
	private static final Log    log               = LogFactory.getLog(JsonTable.class);
    private List<TableValue> rows;
	private Integer page; //the number of the requested page
	private Integer total; //the number of the requested page
	private Integer record; //the number of the requested page

    @Actions({@Action(value="/jsontable", results={@Result(name="success",type="json")}) })
    public String execute() {
      
      log.info("build json table");
      
      rows = new ArrayList<TableValue>();
      rows.add(new TableValue("J", "Java", new Integer(1), new Double(1.11)));
      rows.add(new TableValue("P", "PHP", new Integer(2), new Double(2.22)));
      rows.add(new TableValue("C", "C++", new Integer(3), new Double(3.33)));
      
      page = 2;
      record = 4;
      total = 5;
      return SUCCESS;
    }

    public String getJSON(){
    	return execute();
    }


    public class TableValue {
    private String key;
    private String value;
    private Integer num;
    private Double dub;

    public TableValue(String key, String value, Integer num, Double dub) {
      super();
      this.key = key;
      this.value = value;
      this.num = num;
      this.dub = dub;
    }

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getDub() {
		return dub;
	}

	public void setDub(Double dub) {
		this.dub = dub;
	}

  }

	public Integer getPage() {
		return page;
	}

	public List<TableValue> getRows() {
		return rows;
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getRecord() {
		return record;
	}

}
