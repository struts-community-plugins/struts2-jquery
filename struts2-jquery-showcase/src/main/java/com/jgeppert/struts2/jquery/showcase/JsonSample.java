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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.showcase.model.ListValue;
import com.opensymphony.xwork2.ActionSupport;

public class JsonSample extends ActionSupport {

    private static final long serialVersionUID = -2223948287805083119L;
    private static final Log log = LogFactory.getLog(JsonSample.class);
    private List<String> languageList;
    private List<ListValue> languageObjList;
    private Map<String, String> languageMap;
    private List<String> reloadList;
    private String language;

    @Actions({ @Action(value = "/jsonsample", results = { @Result(name = "success", type = "json") }) })
    public String execute() {

	log.info("build json lists language : " + language);

	languageList = new ArrayList<String>();
	languageObjList = new ArrayList<ListValue>();
	languageMap = new HashMap<String, String>();

	languageList.add("Java");
	languageList.add("PHP");
	languageList.add("C#");

	languageMap.put("J", "Java");
	languageMap.put("P", "PHP");
	languageMap.put("C", "C#");

	languageObjList.add(new ListValue("J", "Java"));
	languageObjList.add(new ListValue("P", "PHP"));
	languageObjList.add(new ListValue("C", "C#"));

	reloadList = new ArrayList<String>();
	if (language != null && language.equalsIgnoreCase("J")) {
	    reloadList.add("Struts2");
	    reloadList.add("MyFaces");
	    reloadList.add("Tapestry");
	} else if (language != null && language.equalsIgnoreCase("P")) {
	    reloadList.add("CakePHP");
	    reloadList.add("Symfony");
	    reloadList.add("Zend");
	} else if (language != null && language.equalsIgnoreCase("C")) {
	    reloadList.add("NStruts");
	    reloadList.add("ProMesh.NET");
	    reloadList.add("Websharp");
	}

	return SUCCESS;
    }

    public String getJSON() {
	return execute();
    }

    public List<String> getLanguageList() {
	return languageList;
    }

    public Map<String, String> getLanguageMap() {
	return languageMap;
    }

    public List<ListValue> getLanguageObjList() {
	return languageObjList;
    }

    public List<String> getReloadList() {
	return reloadList;
    }

    public void setLanguage(String language) {
	this.language = language;
    }
}
