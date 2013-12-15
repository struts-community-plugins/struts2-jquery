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

package com.jgeppert.struts2.jquery.views;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgeppert.struts2.jquery.views.freemarker.tags.JqueryModels;
import com.jgeppert.struts2.jquery.views.velocity.components.AccordionDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.AccordionItemDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.AnchorDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.AutocompleterDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.CheckboxListDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.DatePickerDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.DialogDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.DivDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.HeadDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.MenuDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.MenuItemDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.ProgressbarDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.RadioDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.SelectDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.SliderDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.SpinnerDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.SubmitDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.TabDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.TabbedPanelDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.TextareaDirective;
import com.jgeppert.struts2.jquery.views.velocity.components.TextfieldDirective;

import org.apache.struts2.views.TagLibraryDirectiveProvider;
import org.apache.struts2.views.TagLibraryModelProvider;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */

public class JqueryTagLibrary implements TagLibraryDirectiveProvider, TagLibraryModelProvider {

	public Object getModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new JqueryModels(stack, req, res);
	}

	@SuppressWarnings("rawtypes")
	public List<Class> getDirectiveClasses() {
		Class[] directives =
				new Class[]{
						DatePickerDirective.class,
						DivDirective.class,
						AnchorDirective.class,
						AutocompleterDirective.class,
						SubmitDirective.class,
						TabDirective.class,
						TabbedPanelDirective.class,
						HeadDirective.class,
						DialogDirective.class,
						AccordionDirective.class,
						AccordionItemDirective.class,
						ProgressbarDirective.class,
						SliderDirective.class,
						SpinnerDirective.class,
						TextareaDirective.class,
						TextfieldDirective.class,
						SelectDirective.class,
						RadioDirective.class,
						CheckboxListDirective.class,
						MenuDirective.class,
						MenuItemDirective.class,
				};
		return Arrays.asList(directives);
	}

}
