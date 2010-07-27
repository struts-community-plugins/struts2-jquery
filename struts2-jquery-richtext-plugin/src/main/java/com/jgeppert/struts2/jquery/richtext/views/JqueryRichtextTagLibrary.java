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

package com.jgeppert.struts2.jquery.richtext.views;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.TagLibrary;

import com.jgeppert.struts2.jquery.richtext.views.freemarker.tags.JqueryRichtextModels;
import com.jgeppert.struts2.jquery.richtext.views.velocity.components.CkeditorDirective;
import com.jgeppert.struts2.jquery.richtext.views.velocity.components.TinymceDirective;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class JqueryRichtextTagLibrary implements TagLibrary {

  public Object getFreemarkerModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new JqueryRichtextModels(stack, req, res);
  }

  @SuppressWarnings("unchecked")
  public List<Class> getVelocityDirectiveClasses()
  {
    Class[] directives = new Class[] {
        CkeditorDirective.class, TinymceDirective.class
    };
    return Arrays.asList(directives);
  }

}
