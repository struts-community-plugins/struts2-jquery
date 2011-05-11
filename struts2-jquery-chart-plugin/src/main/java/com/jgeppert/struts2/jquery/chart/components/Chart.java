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

package com.jgeppert.struts2.jquery.chart.components;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.AbstractContainer;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render a Chart Element based on Flot
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "chart", tldTagClass = "com.jgeppert.struts2.jquery.chart.views.jsp.ui.ChartTag", description = "A Chart Element based on Flot", allowDynamicAttributes = true)
public class Chart extends AbstractContainer {

  public static final String            TEMPLATE       = "chart";
  public static final String            TEMPLATE_CLOSE = "chart-close";
  public static final String            COMPONENT_NAME = Chart.class.getName();
  final private static transient Random RANDOM         = new Random();
  public static final String            JQUERYACTION   = "chart";

  protected String                      xaxisPosition;
  protected String                      xaxisMode;
  protected String                      xaxisColor;
  protected String                      xaxisTick;
  protected String                      xaxisTickSize;
  protected String                      xaxisTickDecimals;
  protected String                      xaxisTickColor;
  protected String                      xaxisMin;
  protected String                      xaxisMax;
  protected String                      xaxisTimeformat;
  protected String                      yaxisPosition;
  protected String                      yaxisMode;
  protected String                      yaxisColor;
  protected String                      yaxisTick;
  protected String                      yaxisTickSize;
  protected String                      yaxisTickDecimals;
  protected String                      yaxisTickColor;
  protected String                      yaxisMin;
  protected String                      yaxisMax;
  protected String                      yaxisTimeformat;
  protected String                      legendShow;
  protected String                      legendPosition;
  protected String                      legendLabelBoxBorderColor;
  protected String                      legendBackgroundColor;
  protected String                      onClickTopics;
  protected String                      onHoverTopics;
  protected String                      crosshair;
  protected String                      crosshairMode;
  protected String                      crosshairColor;
  protected String                      crosshairLineWidth;
  protected String                      pie;
  protected String                      pieRadius;
  protected String                      pieInnerRadius;
  protected String                      pieLabel;
  protected String                      pieLabelFormatter;
  protected String                      pieLabelRadius;
  protected String                      pieLabelBackgroundColor;
  protected String                      pieLabelBackgroundOpacity;

  public Chart(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

    if (xaxisPosition != null) addParameter("xaxisPosition", findString(xaxisPosition));
    if (xaxisMode != null) addParameter("xaxisMode", findString(xaxisMode));
    if (xaxisColor != null) addParameter("xaxisColor", findString(xaxisColor));
    if (xaxisTick != null) addParameter("xaxisTick", findString(xaxisTick));
    if (xaxisTickSize != null) addParameter("xaxisTickSize", findString(xaxisTickSize));
    if (xaxisTickDecimals != null) addParameter("xaxisTickDecimals", findString(xaxisTickDecimals));
    if (xaxisTickColor != null) addParameter("xaxisTickColor", findString(xaxisTickColor));
    if (xaxisMin != null) addParameter("xaxisMin", findString(xaxisMin));
    if (xaxisMax != null) addParameter("xaxisMax", findString(xaxisMax));
    if (xaxisTimeformat != null) addParameter("xaxisTimeformat", findString(xaxisTimeformat));
    if (yaxisPosition != null) addParameter("yaxisPosition", findString(yaxisPosition));
    if (yaxisMode != null) addParameter("yaxisMode", findString(yaxisMode));
    if (yaxisColor != null) addParameter("yaxisColor", findString(yaxisColor));
    if (yaxisTick != null) addParameter("yaxisTick", findString(yaxisTick));
    if (yaxisTickSize != null) addParameter("yaxisTickSize", findString(yaxisTickSize));
    if (yaxisTickDecimals != null) addParameter("yaxisTickDecimals", findString(yaxisTickDecimals));
    if (yaxisTickColor != null) addParameter("yaxisTickColor", findString(yaxisTickColor));
    if (yaxisMin != null) addParameter("yaxisMin", findString(yaxisMin));
    if (yaxisMax != null) addParameter("yaxisMax", findString(yaxisMax));
    if (yaxisTimeformat != null) addParameter("yaxisTimeformat", findString(yaxisTimeformat));
    if (legendShow != null) addParameter("legendShow", findValue(this.legendShow, Boolean.class));
    if (legendPosition != null) addParameter("legendPosition", findString(legendPosition));
    if (legendLabelBoxBorderColor != null) addParameter("legendLabelBoxBorderColor", findString(legendLabelBoxBorderColor));
    if (legendBackgroundColor != null) addParameter("legendBackgroundColor", findString(legendBackgroundColor));
    if (onClickTopics != null) addParameter("onClickTopics", findString(onClickTopics));
    if (onHoverTopics != null) addParameter("onHoverTopics", findString(onHoverTopics));
    if (crosshair != null) addParameter("crosshair", findValue(this.crosshair, Boolean.class));
    if (crosshairMode != null) addParameter("crosshairMode", findString(crosshairMode));
    if (crosshairColor != null) addParameter("crosshairColor", findString(crosshairColor));
    if (crosshairLineWidth != null) addParameter("crosshairLineWidth", findValue(crosshairLineWidth, Number.class));
    if (pie != null) addParameter("pie", findValue(this.pie, Boolean.class));
    if (pieRadius != null) addParameter("pieRadius", findString(pieRadius));
    if (pieInnerRadius != null) addParameter("pieInnerRadius", findString(pieInnerRadius));
    if (pieLabel != null) addParameter("pieLabel", findValue(this.pieLabel, Boolean.class));
    if (pieLabelRadius != null) addParameter("pieLabelRadius", findString(pieLabelRadius));
    if (pieLabelBackgroundOpacity != null) addParameter("pieLabelBackgroundOpacity", findString(pieLabelBackgroundOpacity));
    if (pieLabelBackgroundColor != null) addParameter("pieLabelBackgroundColor", findString(pieLabelBackgroundColor));
    if (pieLabelFormatter != null) addParameter("pieLabelFormatter", findString(pieLabelFormatter));

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "chart" + String.valueOf(nextInt);
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

  @StrutsTagAttribute(description = "bottom, top, left, right")
  public void setXaxisPosition(String xaxisPosition)
  {
    this.xaxisPosition = xaxisPosition;
  }

  @StrutsTagAttribute(description = "null or time", defaultValue = "null")
  public void setXaxisMode(String xaxisMode)
  {
    this.xaxisMode = xaxisMode;
  }

  @StrutsTagAttribute(description = "color value")
  public void setXaxisColor(String xaxisColor)
  {
    this.xaxisColor = xaxisColor;
  }

  @StrutsTagAttribute(description = "color value")
  public void setXaxisTickColor(String xaxisTickColor)
  {
    this.xaxisTickColor = xaxisTickColor;
  }

  @StrutsTagAttribute(description = "format string to use. The following specifiers are supported:   %h: hours,  %H: hours (left-padded with a zero),  %M: minutes (left-padded with a zero),  %S: seconds (left-padded with a zero),  %d: day of month (1-31), use %0d for zero-padding,  %m: month (1-12), use %0m for zero-padding,  %y: year (four digits),  %b: month name (customizable),  %p: am/pm, additionally switches %h/%H to 12 hour instead of 24,  %P: AM/PM (uppercase version of %p)")
  public void setXaxisTimeformat(String xaxisTimeformat)
  {
    this.xaxisTimeformat = xaxisTimeformat;
  }

  @StrutsTagAttribute(description = "minimum value")
  public void setXaxisMin(String xaxisMin)
  {
    this.xaxisMin = xaxisMin;
  }

  @StrutsTagAttribute(description = "maximum value")
  public void setXaxisMax(String xaxisMax)
  {
    this.xaxisMax = xaxisMax;
  }

  @StrutsTagAttribute(description = "bottom, top, left, right")
  public void setYaxisPosition(String yaxisPosition)
  {
    this.yaxisPosition = yaxisPosition;
  }

  @StrutsTagAttribute(description = "null or time", defaultValue = "null")
  public void setYaxisMode(String yaxisMode)
  {
    this.yaxisMode = yaxisMode;
  }

  @StrutsTagAttribute(description = "color value")
  public void setYaxisColor(String yaxisColor)
  {
    this.yaxisColor = yaxisColor;
  }

  @StrutsTagAttribute(description = "color value")
  public void setYaxisTickColor(String yaxisTickColor)
  {
    this.yaxisTickColor = yaxisTickColor;
  }

  @StrutsTagAttribute(description = "minimum value")
  public void setYaxisMin(String yaxisMin)
  {
    this.yaxisMin = yaxisMin;
  }

  @StrutsTagAttribute(description = "maximum value")
  public void setYaxisMax(String yaxisMax)
  {
    this.yaxisMax = yaxisMax;
  }

  @StrutsTagAttribute(description = "format string to use. The following specifiers are supported:   %h: hours,  %H: hours (left-padded with a zero),  %M: minutes (left-padded with a zero),  %S: seconds (left-padded with a zero),  %d: day of month (1-31), use %0d for zero-padding,  %m: month (1-12), use %0m for zero-padding,  %y: year (four digits),  %b: month name (customizable),  %p: am/pm, additionally switches %h/%H to 12 hour instead of 24,  %P: AM/PM (uppercase version of %p)")
  public void setYaxisTimeformat(String yaxisTimeformat)
  {
    this.yaxisTimeformat = yaxisTimeformat;
  }

  @StrutsTagAttribute(description = "show legend", type = "Boolean", defaultValue = "true")
  public void setLegendShow(String legendShow)
  {
    this.legendShow = legendShow;
  }

  @StrutsTagAttribute(description = "position of legend. ne, nw, se, sw", defaultValue = "ne")
  public void setLegendPosition(String legendPosition)
  {
    this.legendPosition = legendPosition;
  }

  @StrutsTagAttribute(description = "color of label box")
  public void setLegendLabelBoxBorderColor(String legendLabelBoxBorderColor)
  {
    this.legendLabelBoxBorderColor = legendLabelBoxBorderColor;
  }

  @StrutsTagAttribute(description = "legend background color")
  public void setLegendBackgroundColor(String legendBackgroundColor)
  {
    this.legendBackgroundColor = legendBackgroundColor;
  }

  @StrutsTagAttribute(description = "number or ticks array. If you want to completely override the tick algorithm, you can specify an array for ticks, either like this: [0, 1.2, 2.4] or like this where the labels are also customized: [[0, 'zero'], [1.2, 'one mark'], [2.4, 'two marks']]")
  public void setXaxisTick(String xaxisTick)
  {
    this.xaxisTick = xaxisTick;
  }

  @StrutsTagAttribute(description = "number or ticks array. If you set it to 2, you'll get ticks at 2, 4, 6, etc. Note that for time series, the format is an array like [2, 'month']")
  public void setXaxisTickSize(String xaxisTickSize)
  {
    this.xaxisTickSize = xaxisTickSize;
  }

  @StrutsTagAttribute(description = "the number of decimals to display (default is auto-detected).", defaultValue = "auto-detected")
  public void setXaxisTickDecimals(String xaxisTickDecimals)
  {
    this.xaxisTickDecimals = xaxisTickDecimals;
  }

  @StrutsTagAttribute(description = "number or ticks array. If you want to completely override the tick algorithm, you can specify an array for ticks, either like this: [0, 1.2, 2.4] or like this where the labels are also customized: [[0, 'zero'], [1.2, 'one mark'], [2.4, 'two marks']]")
  public void setYaxisTick(String yaxisTick)
  {
    this.yaxisTick = yaxisTick;
  }

  @StrutsTagAttribute(description = "number or ticks array. If you set it to 2, you'll get ticks at 2, 4, 6, etc. Note that for time series, the format is an array like [2, 'month']")
  public void setYaxisTickSize(String yaxisTickSize)
  {
    this.yaxisTickSize = yaxisTickSize;
  }

  @StrutsTagAttribute(description = "the number of decimals to display (default is auto-detected).", defaultValue = "auto-detected")
  public void setYaxisTickDecimals(String yaxisTickDecimals)
  {
    this.yaxisTickDecimals = yaxisTickDecimals;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when the grid is clicked", type = "String")
  public void setOnClickTopics(String onClickTopics)
  {
    this.onClickTopics = onClickTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when the grid is hovered", type = "String")
  public void setOnHoverTopics(String onHoverTopics)
  {
    this.onHoverTopics = onHoverTopics;
  }

  @StrutsTagAttribute(description = "showing a crosshair, thin lines, when the mouse hovers over the plot", type = "Boolean", defaultValue = "false")
  public void setCrosshair(String crosshair)
  {
    this.crosshair = crosshair;
  }

  @StrutsTagAttribute(description = "crosshair mode, 'x', 'y' or 'xy'")
  public void setCrosshairMode(String crosshairMode)
  {
    this.crosshairMode = crosshairMode;
  }

  @StrutsTagAttribute(description = "crosshair color")
  public void setCrosshairColor(String crosshairColor)
  {
    this.crosshairColor = crosshairColor;
  }

  @StrutsTagAttribute(description = "crosshair line width", type = "Number")
  public void setCrosshairLineWidth(String crosshairLineWidth)
  {
    this.crosshairLineWidth = crosshairLineWidth;
  }

  @StrutsTagAttribute(description = "Display the Chart as a Pie", type = "Boolean", defaultValue = "false")
  public void setPie(String pie)
  {
    this.pie = pie;
  }

  @StrutsTagAttribute(description = "0-1 for percentage of fullsize, or a specified pixel length", defaultValue = "auto")
  public void setPieRadius(String pieRadius)
  {
    this.pieRadius = pieRadius;
  }

  @StrutsTagAttribute(description = "0-1 for percentage of fullsize or a specified pixel length, for creating a donut effect")
  public void setPieInnerRadius(String pieInnerRadius)
  {
    this.pieInnerRadius = pieInnerRadius;
  }

  @StrutsTagAttribute(description = "Display Pie Labels", type = "Boolean", defaultValue = "false")
  public void setPieLabel(String pieLabel)
  {
    this.pieLabel = pieLabel;
  }

  @StrutsTagAttribute(description = "a user-defined function that modifies the text/style of the label text. eg. name of a function like this function(label, series){ return '<div style=\"font-size:8pt;text-align:center;padding:2px;color:white;\">'+label+'<br/>'+Math.round(series.percent)+'%</div>'; }")
  public void setPieLabelFormatter(String pieLabelFormatter)
  {
    this.pieLabelFormatter = pieLabelFormatter;
  }

  @StrutsTagAttribute(description = "0-1 for percentage of fullsize, or a specified pixel length", defaultValue = "auto")
  public void setPieLabelRadius(String pieLabelRadius)
  {
    this.pieLabelRadius = pieLabelRadius;
  }

  @StrutsTagAttribute(description = "any hexidecimal color value")
  public void setPieLabelBackgroundColor(String pieLabelBackgroundColor)
  {
    this.pieLabelBackgroundColor = pieLabelBackgroundColor;
  }

  @StrutsTagAttribute(description = "0-1")
  public void setPieLabelBackgroundOpacity(String pieLabelBackgroundOpacity)
  {
    this.pieLabelBackgroundOpacity = pieLabelBackgroundOpacity;
  }
}
