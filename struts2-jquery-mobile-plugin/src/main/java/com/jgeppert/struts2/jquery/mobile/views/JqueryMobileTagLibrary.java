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

package com.jgeppert.struts2.jquery.mobile.views;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.TagLibrary;

import com.jgeppert.struts2.jquery.mobile.components.Radio;
import com.jgeppert.struts2.jquery.mobile.views.freemarker.tags.JqueryMobileModels;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.AnchorDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.CheckboxDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.CheckboxListDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.DivDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.HeadDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.ListDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.ListItemDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.PasswordDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.SearchfieldDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.SelectDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.SliderDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.TextareaDirective;
import com.jgeppert.struts2.jquery.mobile.views.velocity.components.TextfieldDirective;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class JqueryMobileTagLibrary implements TagLibrary {

	public Object getFreemarkerModels(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new JqueryMobileModels(stack, req, res);
	}

	@SuppressWarnings("rawtypes")
	public List<Class> getVelocityDirectiveClasses() {
		Class[] directives = new Class[] { HeadDirective.class,
				CheckboxListDirective.class, CheckboxDirective.class,
				Radio.class, DivDirective.class, ListDirective.class,
				ListItemDirective.class, AnchorDirective.class,
				TextareaDirective.class, TextfieldDirective.class,
				SearchfieldDirective.class, PasswordDirective.class,
				SelectDirective.class, SliderDirective.class};
		return Arrays.asList(directives);
	}

}
