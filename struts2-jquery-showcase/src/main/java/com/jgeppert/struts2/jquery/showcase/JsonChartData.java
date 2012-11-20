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
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import com.jgeppert.struts2.jquery.showcase.model.ListValue;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class JsonChartData extends ActionSupport {

	private static final long serialVersionUID = -1868891788172934382L;
	private static Random generator = new Random();
	private List<ListValue> objList;
	private Map<Double, Double> doubleMap;

	@Actions({ @Action(value = "/json-chart-data", results = { @Result(name = "success", type = "json") }) })
	public String execute() {

		objList = new ArrayList<ListValue>();
		doubleMap = new TreeMap<Double, Double>();

		for (int i = 1; i <= 24; i++) {
			doubleMap
					.put(Double.valueOf("" + i), generator.nextDouble() * 10.0);
		}

		for (int i = 1; i <= 24; i++) {
			objList.add(new ListValue("" + i, "" + generator.nextInt(30)));
		}

		return SUCCESS;
	}

	public String getJSON() {
		return execute();
	}

	public List<ListValue> getObjList() {
		return objList;
	}

	public void setObjList(List<ListValue> objList) {
		this.objList = objList;
	}

	public Map<Double, Double> getDoubleMap() {
		return doubleMap;
	}

	public void setDoubleMap(Map<Double, Double> doubleMap) {
		this.doubleMap = doubleMap;
	}
}
