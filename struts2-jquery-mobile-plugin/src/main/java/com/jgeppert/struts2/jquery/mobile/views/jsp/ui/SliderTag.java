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

package com.jgeppert.struts2.jquery.mobile.views.jsp.ui;

import com.jgeppert.struts2.jquery.mobile.components.Searchfield;
import com.jgeppert.struts2.jquery.mobile.components.Slider;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @see com.jgeppert.struts2.jquery.mobile.components.Slider
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 *
 */
public class SliderTag extends
		org.apache.struts2.views.jsp.ui.TextFieldTag {

    protected String                      max;
    protected String                      min;

	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new Slider(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();

		Slider slider = (Slider) component;
        slider.setMax(max);
        slider.setMin(min);
	}

    public void setMax(String max) {
        this.max = max;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
