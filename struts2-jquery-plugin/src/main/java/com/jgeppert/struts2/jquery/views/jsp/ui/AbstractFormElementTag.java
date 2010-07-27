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

import com.jgeppert.struts2.jquery.components.AbstractFormElement;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public abstract class AbstractFormElementTag extends AbstractContainerTag {

  private static final long serialVersionUID = -4125616438928920288L;

  protected String          parentTheme;

  protected void populateParams()
  {
    super.populateParams();

    AbstractFormElement formElement = (AbstractFormElement) component;
    formElement.setParentTheme(parentTheme);
  }

  public void setParentTheme(String parentTheme)
  {
    this.parentTheme = parentTheme;
  }

}
