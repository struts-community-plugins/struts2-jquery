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

package com.jgeppert.struts2.jquery.handlebarsjs.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.jgeppert.struts2.jquery.handlebarsjs.components.HandlebarsJs;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */

public class HandlebarsTag extends AbstractClosingTag {

    private static final long serialVersionUID = -6297851020849153739L;
    
    private String href;
    private String type;
    private String targets;
    private String listenTopics;
    private String templateName;

   

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new HandlebarsJs(stack, req, res);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        HandlebarsJs handlebars = (HandlebarsJs) component;
        
        handlebars.setHref(href);
        handlebars.setType(type);
        handlebars.setTargets(targets);
        handlebars.setListenTopics(listenTopics);
        handlebars.setTemplateName(templateName);
        
    }

	public void setHref(String href) {
		this.href = href;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTargets(String targets) {
		this.targets = targets;
	}

	public void setListenTopics(String listenTopics) {
		this.listenTopics = listenTopics;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
     
}
