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

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef("execAndWait")
public class LongRunningProcess extends ActionSupport {

    private static final long serialVersionUID = 191303420519684012L;
    private int status = 0;

    @Action(value = "/long-running-process", results = {
	    @Result(location = "long-running-process-success.jsp", name = "success"),
	    @Result(location = "long-running-process-wait.jsp", name = "wait") })
    public String execute() throws Exception {
	Thread.sleep(5000);
	status = 25;

	Thread.sleep(5000);
	status = 50;

	Thread.sleep(5000);
	status = 75;

	Thread.sleep(5000);
	status = 100;

	return SUCCESS;
    }

    public int getStatus() {
	return status;
    }
}
