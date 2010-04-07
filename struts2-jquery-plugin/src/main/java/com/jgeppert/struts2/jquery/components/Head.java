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

package com.jgeppert.struts2.jquery.components;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: notice --> The "head" tag renders required JavaScript
 * code to configure jQuery and is required in order to use any of the tags
 * included in the jQuery plugin.</p> <!-- END SNIPPET: notice -->
 * 
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * </p>
 * 
 * <p>
 * Some tags like the "datepicker" can use different locales, to use a locale
 * that is different from the request locale.
 * </p>
 * 
 * <p>
 * The "locale" attribute configures jQuery locale for datepicker. Default is
 * "en" you can use all locales that are bundled with jQuery. e.g.
 * "de, "fr", "ja", ...
 * </p>
 * 
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p/>
 * <b>Examples</b>
 * 
 * <pre>
 * &lt;!-- START SNIPPET: example1 --&gt;
 * &lt;%@ taglib prefix=&quot;sj&quot; uri=&quot;/struts-jquery-tags&quot; %&gt;
 * &lt;head&gt;
 *   &lt;title&gt;My page&lt;/title&gt;
 *   &lt;sj:head/&gt;
 * &lt;/head&gt;
 * &lt;!-- END SNIPPET: example1 --&gt;
 * </pre>
 * 
 * <pre>
 * &lt;!-- START SNIPPET: example2 --&gt;
 * &lt;%@ taglib prefix=&quot;sj&quot; uri=&quot;/struts-jquery-tags&quot; %&gt;
 * &lt;head&gt;
 *   &lt;title&gt;My page&lt;/title&gt;
 *   &lt;sj:head compressed=&quot;false&quot; locale=&quot;de&quot; jqueryui=&quot;true&quot; jquerytheme=&quot;cupertino&quot;/&gt;
 * &lt;/head&gt;
 * &lt;!-- END SNIPPET: example2 --&gt;
 * </pre>
 * 
 */
@StrutsTag(name = "head", tldBodyContent = "empty", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.HeadTag", description = "Render a chunk of HEAD for your HTML file", allowDynamicAttributes = true)
@StrutsTagSkipInheritance
public class Head extends org.apache.struts2.components.Head {
  public static final String    TEMPLATE     = "head";

  private static final String[] gridLocals   = {
      "bg", "ca", "cn", "cs", "de", "dk", "el", "en-GB", "en", "fa", "fi", "fr-CH", "fr", "he", "is", "it", "ja", "nl", "no", "pl", "pt-BR", "pt", "ro", "ru", "sp", "sv", "tr", "ua", "zh", "zh-CN"
                                             };
  private static final String[] jqueryLocals = {
      "af",
      "ar",
      "az",
      "bg",
      "bs",
      "ca",
      "cs",
      "da",
      "de",
      "el",
      "en",
      "en-GB",
      "eo",
      "es",
      "et",
      "eu",
      "fa",
      "fi",
      "fo",
      "fr-CH",
      "fr",
      "he",
      "hr",
      "hu",
      "hy",
      "id",
      "is",
      "it",
      "ja",
      "ko",
      "lt",
      "lv",
      "ms",
      "nl",
      "no",
      "pl",
      "pt",
      "pt-BR",
      "ro",
      "ru",
      "sk",
      "sl",
      "sq",
      "sr-SR",
      "sv",
      "ta",
      "th",
      "tr",
      "uk",
      "vi",
      "zh-CN",
      "zh-HK",
      "zh-TW"
                                             };

  protected String              compressed;
  protected String              locale;
  protected String              jquerytheme;
  protected String              jqueryui;
  protected String              customBasepath;
  protected String              loadFromGoogle;
  protected String              ajaxcache;
  protected String              ajaxhistory;
  protected String              defaultIndicator;
  protected String              loadAtOnce;
  protected String              debug;

  private String                defaultLocale;

  public Head(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  protected String getDefaultTemplate()
  {
    return TEMPLATE;
  }

  public void evaluateParams()
  {
    super.evaluateParams();

    if (this.jqueryui != null) addParameter("jqueryui", findValue(this.jqueryui, Boolean.class));
    if (this.compressed != null) addParameter("compressed", findValue(this.compressed, Boolean.class));
    if (this.jquerytheme != null) addParameter("jquerytheme", findString(this.jquerytheme));
    if (this.customBasepath != null) addParameter("customBasepath", findString(this.customBasepath));
    if (this.loadFromGoogle != null) addParameter("loadFromGoogle", findValue(this.loadFromGoogle, Boolean.class));
    if (this.ajaxcache != null) addParameter("ajaxcache", findValue(this.ajaxcache, Boolean.class));
    if (this.ajaxhistory != null) addParameter("ajaxhistory", findValue(this.ajaxhistory, Boolean.class));
    if (this.defaultIndicator != null) addParameter("defaultIndicator", findString(this.defaultIndicator));
    if (this.loadAtOnce != null) addParameter("loadAtOnce", findValue(this.loadAtOnce, Boolean.class));
    if (this.debug != null) addParameter("debug", findValue(this.debug, Boolean.class));

    String loc = null;
    if (this.locale != null) loc = StringUtils.replace(findString(this.locale), "_", "-");
    else if (defaultLocale != null) loc = StringUtils.replace(defaultLocale, "_", "-");

    if (loc != null)
    {
      addParameter("gridLocale", validateLocal(gridLocals, loc));
      addParameter("jqueryLocale", validateLocal(jqueryLocals, loc));
    }
  }

  @Inject(value = StrutsConstants.STRUTS_LOCALE, required = false)
  public void setDefaultLocale(String val)
  {
    defaultLocale = val;
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

  public boolean isJqueryui()
  {
    return jqueryui != null && Boolean.parseBoolean(jqueryui);
  }

  @StrutsTagAttribute(description = "enable jQuery UI Scripts", defaultValue = "true", type = "Boolean")
  public void setJqueryui(String jqueryui)
  {
    this.jqueryui = jqueryui;
  }

  @StrutsTagAttribute(description = "use compressed version of jquery and jquery-ui", defaultValue = "true", type = "Boolean")
  public void setCompressed(String compressed)
  {
    this.compressed = compressed;
  }

  @StrutsTagAttribute(description = "jQuery UI theme", defaultValue = "smoothness")
  public void setJquerytheme(String jquerytheme)
  {
    this.jquerytheme = jquerytheme;
  }

  @StrutsTagAttribute(description = "import jQuery i18n scripts.", defaultValue = "en or struts.local value")
  public void setLocale(String locale)
  {
    this.locale = locale;
  }

  @StrutsTagAttribute(description = "base path for custom jQuery designs")
  public void setCustomBasepath(String customBasepath)
  {
    this.customBasepath = customBasepath;
  }

  @StrutsTagAttribute(description = "Load JavaScript from google content distribution network", defaultValue = "false", type = "Boolean")
  public void setLoadFromGoogle(String loadFromGoogle)
  {
    this.loadFromGoogle = loadFromGoogle;
  }

  @StrutsTagAttribute(description = "If set to false it will force the pages that you request to not be cached by the browser.", defaultValue = "false", type = "Boolean")
  public void setAjaxcache(String ajaxcache)
  {
    this.ajaxcache = ajaxcache;
  }

  @StrutsTagAttribute(description = "If set to true it will enable history and bookmarking for AJAX content and jQuery UI Tabs.", defaultValue = "false", type = "Boolean")
  public void setAjaxhistory(String ajaxhistory)
  {
    this.ajaxhistory = ajaxhistory;
  }

  @StrutsTagAttribute(description = "The default indicator for all AJAX actions")
  public void setDefaultIndicator(String defaultIndicator)
  {
    this.defaultIndicator = defaultIndicator;
  }

  @StrutsTagAttribute(description = "do not use the on demand load for jquery ui resources", defaultValue = "false", type = "Boolean")
  public void setLoadAtOnce(String loadAtOnce)
  {
    this.loadAtOnce = loadAtOnce;
  }

  private static String validateLocal(String[] locals, String local)
  {
    String retString = "en";
    if (Arrays.binarySearch(locals, local) > 0)
    {
      retString = local;
    }
    else if (local.length() > 2 && Arrays.binarySearch(locals, local.substring(0, 2)) > 0)
    {
      retString = local.substring(0, 2);
    }

    return retString;
  }

  @StrutsTagAttribute(description = "enable debug logging", defaultValue = "false", type = "Boolean")
  public void setDebug(String debug)
  {
    this.debug = debug;
  }
}
