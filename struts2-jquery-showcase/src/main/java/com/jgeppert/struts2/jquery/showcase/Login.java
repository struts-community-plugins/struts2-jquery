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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef("jsonValidationWorkflowStack")
@Validations(requiredStrings = {
	@RequiredStringValidator(fieldName = "loginuser", type = ValidatorType.FIELD, message = "Login User is required"),
	@RequiredStringValidator(fieldName = "loginpassword", type = ValidatorType.FIELD, message = "Password is required") }, expressions = { @ExpressionValidator(expression = "loginpassword.trim().equals('test') == true", message = "Password must be test.")

})
public class Login extends ActionSupport {

    private static final long serialVersionUID = 7968544374444173511L;
    private static final Log log = LogFactory.getLog(Login.class);

    private String loginuser;
    private String loginpassword;
    private String echo;

    @Action(value = "/login", results = { @Result(location = "simpleecho.jsp", name = "success") })
    public String execute() throws Exception {
	echo = "Welcome " + loginuser;
	log.info(echo);

	return SUCCESS;
    }

    public String getEcho() {
	return echo;
    }

    public String getLoginuser() {
	return loginuser;
    }

    public void setLoginuser(String loginuser) {
	this.loginuser = loginuser;
    }

    public String getLoginpassword() {
	return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
	this.loginpassword = loginpassword;
    }
}
