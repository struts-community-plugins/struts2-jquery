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
import java.util.Collection;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * A tag that creates an Slider.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * 
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * &lt;sj:slider id=&quot;myslider&quot; name=&quot;myslider&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <pre>
 * &lt;sj:slider id=&quot;myslider2&quot; name=&quot;myslider2&quot; value=&quot;40&quot; displayValueElement=&quot;displayvaluespan&quot; min=&quot;20&quot; max=&quot;200&quot; animate=&quot;true&quot; step=&quot;5&quot; cssStyle=&quot;margin: 10px;&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "slider", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.SliderTag", description = "Render a Slider", allowDynamicAttributes = true)
public class Slider extends AbstractTopicsBean {

  public static final String            JQUERYACTION   = "slider";
  public static final String            TEMPLATE       = "slider";
  public static final String            TEMPLATE_CLOSE = "slider-close";
  final private static transient Random RANDOM         = new Random();

  protected String                      animate;
  protected String                      max;
  protected String                      min;
  protected String                      orientation;
  protected String                      range;
  protected String                      step;
  protected String                      displayValueElement;
  protected String                      onSlideTopics;

  public Slider(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

  public void evaluateParams()
  {
    super.evaluateParams();

    addParameter("jqueryaction", JQUERYACTION);

    if (animate != null) addParameter("animate", findValue(animate, Boolean.class));
    if (max != null) addParameter("max", findValue(max, Integer.class));
    if (min != null) addParameter("min", findValue(min, Integer.class));
    if (orientation != null) addParameter("orientation", findString(orientation));
    if (range != null) addParameter("range", findString(range));
    if (step != null) addParameter("step", findValue(step, Integer.class));
    if (displayValueElement != null) addParameter("displayValueElement", findString(displayValueElement));
    if (onSlideTopics != null) addParameter("onSlideTopics", findString(onSlideTopics));

    Object valueObject = null;
    String strValue = null;

    if (value != null)
    {
      strValue = value;
    }
    else
    {
      if (name != null)
      {
        strValue = name;
      }
    }
    if (strValue != null)
    {
      valueObject = findValue(strValue);
    }

    if (valueObject == null && strValue != null)
    {
      valueObject = strValue;
    }

    if (valueObject != null)
    {
      if (valueObject instanceof String && ((String) valueObject).startsWith("["))
      {
        addParameter("arrayValue", findString(strValue));
        addParameter("range", "true");
      }
      else if (valueObject instanceof Collection<?>)
      {
        Collection<Object> col = (Collection<Object>) valueObject;
        if (col.size() >= 2)
        {
          addParameter("arrayValue", Arrays.toString(col.toArray()));
          addParameter("range", "true");
        }
      }
      else if (valueObject instanceof Object[])
      {
        Object[] ary = (Object[]) valueObject;
        if (ary.length >= 2)
        {
          addParameter("arrayValue", Arrays.toString(ary));
          addParameter("range", "true");
        }
      }
      else
      {
        addParameter("value", findString(strValue));
      }
    }

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "slider_" + String.valueOf(nextInt);
      addParameter("id", this.id);
    }
    addParameter("id", this.id + "_widget");
    addParameter("widgetid", this.id);
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

  @StrutsTagAttribute(description = "Whether to slide handle smoothly when user click outside handle on the bar. Default: false", defaultValue = "false", type = "Boolean")
  public void setAnimate(String animate)
  {
    this.animate = animate;
  }

  @StrutsTagAttribute(description = "Initialize a slider with the max option specified. Default: 100", type = "Integer")
  public void setMax(String max)
  {
    this.max = max;
  }

  @StrutsTagAttribute(description = "The minimum value of the slider. Default: 0", type = "Integer")
  public void setMin(String min)
  {
    this.min = min;
  }

  @StrutsTagAttribute(description = "Normally you don't need to set this option because the plugin detects the slider orientation automatically. If the orientation is not correctly detected you can set this option to 'horizontal' or 'vertical'. Default: 'auto'")
  public void setOrientation(String orientation)
  {
    this.orientation = orientation;
  }

  @StrutsTagAttribute(description = "If set to true, the slider will detect if you have two handles and create a stylable range element between these two. Two other possible values are 'min' and 'max'. A min range goes from the slider min to one handle. A max range goes from one handle to the slider max.")
  public void setRange(String range)
  {
    this.range = range;
  }

  @StrutsTagAttribute(description = "Determines the size or amount of each interval or step the slider takes between min and max. The full specified value range of the slider (max - min) needs to be evenly divisible by the step. Default: 1", type = "Integer")
  public void setStep(String step)
  {
    this.step = step;
  }

  @Override
  @StrutsTagAttribute(description = "Determines the value of the slider. Default: 0")
  public void setValue(String value)
  {
    super.setValue(value);
  }

  @StrutsTagAttribute(description = "Element Id to display the value.")
  public void setDisplayValueElement(String displayValueElement)
  {
    this.displayValueElement = displayValueElement;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when slide", type = "String", defaultValue = "")
  public void setOnSlideTopics(String onSlideTopics)
  {
    this.onSlideTopics = onSlideTopics;
  }

}
