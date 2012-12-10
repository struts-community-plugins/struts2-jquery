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

package com.jgeppert.struts2.jquery.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.components.Spinner;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @see Spinner
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class SpinnerTag extends TextfieldTag {

    private static final long serialVersionUID = 6678987650660687605L;

    protected String max;
    protected String min;
    protected String step;
    protected String mouseWheel;
    protected String culture;
    protected String numberFormat;
    protected String incremental;
    protected String page;

    public Component getBean(ValueStack stack, HttpServletRequest req,
	    HttpServletResponse res) {
	return new Spinner(stack, req, res);
    }

    protected void populateParams() {
	super.populateParams();

	Spinner spinner = (Spinner) component;
	spinner.setMax(max);
	spinner.setMin(min);
	spinner.setStep(step);
	spinner.setMouseWheel(mouseWheel);
	spinner.setCulture(culture);
	spinner.setNumberFormat(numberFormat);
	spinner.setPage(page);
	spinner.setIncremental(incremental);
    }

    public void setMax(String max) {
	this.max = max;
    }

    public void setMin(String min) {
	this.min = min;
    }

    public void setStep(String step) {
	this.step = step;
    }

    public void setMouseWheel(String mouseWheel) {
	this.mouseWheel = mouseWheel;
    }

    public void setCulture(String culture) {
	this.culture = culture;
    }

    public void setNumberFormat(String numberFormat) {
	this.numberFormat = numberFormat;
    }

    public void setIncremental(String incremental) {
	this.incremental = incremental;
    }

    public void setPage(String page) {
	this.page = page;
    }
}
