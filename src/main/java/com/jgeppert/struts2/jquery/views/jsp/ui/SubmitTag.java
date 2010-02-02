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

import com.jgeppert.struts2.jquery.components.Submit;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see Submit
 */
public class SubmitTag extends AbstractRemoteTag {

  private static final long serialVersionUID = 2179281109958301343L;

  protected String          src;
  protected String          type;
  protected String          clearForm;
  protected String          resetForm;
  protected String          iframe;
  protected String          onClickTopics;
  protected String          openDialog;
  protected String          parentTheme;

  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new Submit(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();

    Submit submit = ((Submit) component);
    submit.setOnClickTopics(onClickTopics);
    submit.setSrc(src);
    submit.setType(type);
    submit.setClearForm(clearForm);
    submit.setResetForm(resetForm);
    submit.setIframe(iframe);
    submit.setOpenDialog(openDialog);
    submit.setParentTheme(parentTheme);
  }

  public void setOnClickTopics(String onClickTopics)
  {
    this.onClickTopics = onClickTopics;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public void setSrc(String src)
  {
    this.src = src;
  }

  public void setClearForm(String clearForm)
  {
    this.clearForm = clearForm;
  }

  public void setResetForm(String resetForm)
  {
    this.resetForm = resetForm;
  }

  public void setIframe(String iframe)
  {
    this.iframe = iframe;
  }

  public void setOpenDialog(String openDialog)
  {
    this.openDialog = openDialog;
  }

  public void setParentTheme(String parentTheme)
  {
    this.parentTheme = parentTheme;
  }
}
