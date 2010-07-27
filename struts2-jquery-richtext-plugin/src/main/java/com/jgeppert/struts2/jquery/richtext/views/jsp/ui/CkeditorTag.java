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

package com.jgeppert.struts2.jquery.richtext.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.richtext.components.Ckeditor;
import com.jgeppert.struts2.jquery.views.jsp.ui.TextareaTag;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */

public class CkeditorTag extends TextareaTag {

  private static final long serialVersionUID = 3335538405812517654L;

  protected String          cols;
  protected String          readonly;
  protected String          rows;
  protected String          wrap;
  protected String          skin;
  protected String          toolbar;
  protected String          width;
  protected String          height;
  protected String          editorLocal;
  protected String          customConfig;
  protected String          onEditorReadyTopics;

  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new Ckeditor(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();

    Ckeditor editor = (Ckeditor) component;
    editor.setCols(cols);
    editor.setRows(rows);
    editor.setReadonly(readonly);
    editor.setWrap(wrap);
    editor.setSkin(skin);
    editor.setToolbar(toolbar);
    editor.setWidth(width);
    editor.setHeight(height);
    editor.setEditorLocal(editorLocal);
    editor.setCustomConfig(customConfig);
    editor.setOnEditorReadyTopics(onEditorReadyTopics);
  }

  public void setCols(String cols)
  {
    this.cols = cols;
  }

  public void setReadonly(String readonly)
  {
    this.readonly = readonly;
  }

  public void setRows(String rows)
  {
    this.rows = rows;
  }

  public void setWrap(String wrap)
  {
    this.wrap = wrap;
  }

  public void setSkin(String skin)
  {
    this.skin = skin;
  }

  public void setToolbar(String toolbar)
  {
    this.toolbar = toolbar;
  }

  public void setWidth(String width)
  {
    this.width = width;
  }

  public void setHeight(String height)
  {
    this.height = height;
  }

  public void setEditorLocal(String editorLocal)
  {
    this.editorLocal = editorLocal;
  }

  public void setCustomConfig(String customConfig)
  {
    this.customConfig = customConfig;
  }

  public void setOnEditorReadyTopics(String onEditorReadyTopics)
  {
    this.onEditorReadyTopics = onEditorReadyTopics;
  }
}
