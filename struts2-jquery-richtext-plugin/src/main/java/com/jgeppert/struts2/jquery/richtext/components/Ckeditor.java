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

package com.jgeppert.struts2.jquery.richtext.components;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.Textarea;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render a Richtext Element based on Ckeditor
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "ckeditor", tldTagClass = "com.jgeppert.struts2.jquery.richtext.views.jsp.ui.CkeditorTag", description = "A Richtext Element based on Ckeditor", allowDynamicAttributes = true)
public class Ckeditor extends Textarea {

  public static final String            TEMPLATE       = "ckeditor";
  public static final String            TEMPLATE_CLOSE = "ckeditor-close";
  public static final String            COMPONENT_NAME = Ckeditor.class.getName();
  final private static transient Random RANDOM         = new Random();
  public static final String            JQUERYACTION   = "ckeditor";

  protected String                      cols;
  protected String                      readonly;
  protected String                      rows;
  protected String                      wrap;
  protected String                      skin;
  protected String                      toolbar;
  protected String                      width;
  protected String                      height;
  protected String                      editorLocal;
  protected String                      customConfig;
  protected String                      onEditorReadyTopics;
  protected String                      uploads;
  protected String                      uploadHref;

  public Ckeditor(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  public String getDefaultOpenTemplate()
  {
    return TEMPLATE;
  }

  protected String getDefaultTemplate()
  {
    return TEMPLATE_CLOSE;
  }

  public void evaluateExtraParams()
  {
    super.evaluateExtraParams();

    addParameter("jqueryaction", JQUERYACTION);

    if (readonly != null)
    {
      addParameter("readonly", findValue(readonly, Boolean.class));
    }

    if (cols != null)
    {
      addParameter("cols", findString(cols));
    }

    if (rows != null)
    {
      addParameter("rows", findString(rows));
    }

    if (wrap != null)
    {
      addParameter("wrap", findString(wrap));
    }

    if (skin != null)
    {
      addParameter("skin", findString(skin));
    }

    if (toolbar != null)
    {
      addParameter("toolbar", findString(toolbar));
    }

    if (height != null)
    {
      addParameter("height", findValue(height, Integer.class));
    }

    if (width != null)
    {
      addParameter("width", findValue(width, Integer.class));
    }

    if (editorLocal != null)
    {
      addParameter("editorLocal", findString(editorLocal));
    }

    if (customConfig != null)
    {
      addParameter("customConfig", findString(customConfig));
    }

    if (onEditorReadyTopics != null)
    {
      addParameter("onEditorReadyTopics", findString(onEditorReadyTopics));
    }

    if (uploads != null)
    {
      addParameter("uploads", findValue(uploads, Boolean.class));
    }

    if (uploadHref != null)
    {
      addParameter("uploadHref", findString(uploadHref));
    }
    if (resizable != null)
    {
      addParameter("editorResizable", findValue(resizable, Boolean.class));
    }

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "ckeditor_" + String.valueOf(nextInt);
      addParameter("id", this.id);
    }
  }

  @Override
  @StrutsTagSkipInheritance
  public void setTheme(String theme)
  {
    super.setTheme(theme);
  }

  @Override
  public String getTheme()
  {
    return "jquery";
  }

  @StrutsTagAttribute(description = "HTML cols attribute", type = "Integer")
  public void setCols(String cols)
  {
    this.cols = cols;
  }

  @StrutsTagAttribute(description = "Whether the textarea is readonly", type = "Boolean", defaultValue = "false")
  public void setReadonly(String readonly)
  {
    this.readonly = readonly;
  }

  @StrutsTagAttribute(description = "HTML rows attribute", type = "Integer")
  public void setRows(String rows)
  {
    this.rows = rows;
  }

  @StrutsTagAttribute(description = "HTML wrap attribute")
  public void setWrap(String wrap)
  {
    this.wrap = wrap;
  }

  @StrutsTagAttribute(description = "the richtext skin. e.g kama, office2003, v2")
  public void setSkin(String skin)
  {
    this.skin = skin;
  }

  @StrutsTagAttribute(description = "Toolbar Configuration. e.g. Basic or Full")
  public void setToolbar(String toolbar)
  {
    this.toolbar = toolbar;
  }

  @StrutsTagAttribute(description = "width attribute", type = "Integer")
  public void setWidth(String width)
  {
    this.width = width;
  }

  @StrutsTagAttribute(description = "height attribute", type = "Integer")
  public void setHeight(String height)
  {
    this.height = height;
  }

  @StrutsTagAttribute(description = "the editor local", defaultValue = "en")
  public void setEditorLocal(String editorLocal)
  {
    this.editorLocal = editorLocal;
  }

  @StrutsTagAttribute(description = "path to custom config file")
  public void setCustomConfig(String customConfig)
  {
    this.customConfig = customConfig;
  }

  @StrutsTagAttribute(description = "Topics that are published when editor instance is ready", type = "String", defaultValue = "")
  public void setOnEditorReadyTopics(String onEditorReadyTopics)
  {
    this.onEditorReadyTopics = onEditorReadyTopics;
  }

  @StrutsTagAttribute(description = "Enable Uploads for this Editor Instance.", type = "Boolean", defaultValue = "false")
  public void setUploads(String uploads)
  {
    this.uploads = uploads;
  }

  @StrutsTagAttribute(description = "Use a custom Upload URL")
  public void setUploadHref(String uploadHref)
  {
    this.uploadHref = uploadHref;
  }
  

  @StrutsTagAttribute(description = "This option gives you the ability to enable/disable the resizing of the ckeditor instance.", defaultValue = "false", type = "Boolean")
  public void setResizable(String resizable)
  {
    this.resizable = resizable;
  }

}
