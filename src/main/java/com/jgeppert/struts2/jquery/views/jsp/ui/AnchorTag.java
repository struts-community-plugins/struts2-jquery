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

import com.jgeppert.struts2.jquery.components.Anchor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see Anchor
 */
public class AnchorTag extends AbstractRemoteTag {

  private static final long serialVersionUID = -1034616578492431113L;

  protected String          openDialog;
  protected String          onClickTopics;                           // topics
                                                                      // that
                                                                      // are
                                                                      // published
                                                                      // on
                                                                      // click

  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new Anchor(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();

    Anchor link = (Anchor) component;
    link.setOpenDialog(openDialog);
    link.setOnClickTopics(onClickTopics);
  }

  public void setOpenDialog(String openDialog)
  {
    this.openDialog = openDialog;
  }

  public void setOnClickTopics(String onClickTopics)
  {
    this.onClickTopics = onClickTopics;
  }
}
