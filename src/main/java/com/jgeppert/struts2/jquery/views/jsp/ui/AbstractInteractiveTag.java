/*
 * $Id: AbstractRemoteTag.java 651946 2008-04-27 13:41:38Z apetrelli $
 *
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

import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.jgeppert.struts2.jquery.components.AbstractInteractiveBean;

public abstract class AbstractInteractiveTag extends AbstractClosingTag {

    private static final long serialVersionUID = -704912163849377645L;
    
    protected String onEnableTopics;
    protected String onDisableTopics;
    
    protected void populateParams() {
        super.populateParams();

        AbstractInteractiveBean interactive = (AbstractInteractiveBean) component;
        interactive.setOnDisableTopics(onDisableTopics);
        interactive.setOnEnableTopics(onEnableTopics);
    }

    public void setOnDisableTopics(String onEnableTopics) {
      this.onEnableTopics = onEnableTopics;
    }

    public void setOnEnableTopics(String onDisableTopics) {
      this.onDisableTopics = onDisableTopics;
    }
}
