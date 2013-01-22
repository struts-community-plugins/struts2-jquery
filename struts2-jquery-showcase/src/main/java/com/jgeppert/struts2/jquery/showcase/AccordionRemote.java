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

import java.util.LinkedList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.showcase.model.AccordionBean;
import com.opensymphony.xwork2.ActionSupport;

public class AccordionRemote extends ActionSupport {

    private static final long serialVersionUID = -3066791113091431706L;
    private List<AccordionBean> accordion;

    @Action(value = "/accordion-remote", results = { @Result(location = "accordion-remote.jsp", name = "success") })
    public String execute() throws Exception {
	accordion = new LinkedList<AccordionBean>();
	accordion.add(new AccordionBean("My Title 1", "Content One"));
	accordion.add(new AccordionBean("My Title 2", "Content Two"));
	accordion.add(new AccordionBean("My Title 3", "Content Three"));
	accordion.add(new AccordionBean("My Title 4", "Content Four"));
	accordion.add(new AccordionBean("My Title 5", "Content Five"));
	return SUCCESS;
    }

    public List<AccordionBean> getAccordion() {
	return accordion;
    }
}
