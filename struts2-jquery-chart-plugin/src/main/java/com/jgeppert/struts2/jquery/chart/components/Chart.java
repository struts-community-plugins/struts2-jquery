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

import com.jgeppert.struts2.jquery.components.AbstractContainer;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render a Chart Element based on Flot
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "chart", tldTagClass = "com.jgeppert.struts2.jquery.chart.views.jsp.ui.ChartTag", description = "A Chart Element based on Flot", allowDynamicAttributes = true)
public class Chart extends AbstractContainer {

    public static final String TEMPLATE = "chart";
    public static final String TEMPLATE_CLOSE = "chart-close";
    public static final String COMPONENT_NAME = Chart.class.getName();
    public static final String JQUERYACTION = "chart";

    private static final String PARAM_XAXIS_POSITION = "xaxisPosition";
    private static final String PARAM_XAXIS_MODE = "xaxisMode";
    private static final String PARAM_XAXIS_COLOR = "xaxisColor";
    private static final String PARAM_XAXIS_TICK = "xaxisTick";
    private static final String PARAM_XAXIS_TICK_SIZE = "xaxisTickSize";
    private static final String PARAM_XAXIS_TICK_DECIMALS = "xaxisTickDecimals";
    private static final String PARAM_XAXIS_TICK_COLOR = "xaxisTickColor";
    private static final String PARAM_XAXIS_MIN = "xaxisMin";
    private static final String PARAM_XAXIS_MAX = "xaxisMax";
    private static final String PARAM_XAXIS_TIMEFORMAT = "xaxisTimeformat";
    private static final String PARAM_XAXIS_LABEL = "xaxisLabel";
    private static final String PARAM_XAXIS_LABEL_FONT_SIZE_PIXELS = "xaxisLabelFontSizePixels";
    private static final String PARAM_XAXIS_LABEL_FONT_FAMILY = "xaxisLabelFontFamily";
    private static final String PARAM_YAXIS_POSITION = "yaxisPosition";
    private static final String PARAM_YAXIS_MODE = "yaxisMode";
    private static final String PARAM_YAXIS_COLOR = "yaxisColor";
    private static final String PARAM_YAXIS_TICK = "yaxisTick";
    private static final String PARAM_YAXIS_TICK_SIZE = "yaxisTickSize";
    private static final String PARAM_YAXIS_TICK_DECIMALS = "yaxisTickDecimals";
    private static final String PARAM_YAXIS_TICK_COLOR = "yaxisTickColor";
    private static final String PARAM_YAXIS_MIN = "yaxisMin";
    private static final String PARAM_YAXIS_MAX = "yaxisMax";
    private static final String PARAM_YAXIS_TIMEFORMAT = "yaxisTimeformat";
    private static final String PARAM_YAXIS_LABEL = "yaxisLabel";
    private static final String PARAM_YAXIS_LABEL_FONT_SIZE_PIXELS = "yaxisLabelFontSizePixels";
    private static final String PARAM_YAXIS_LABEL_FONT_FAMILY = "yaxisLabelFontFamily";
    private static final String PARAM_LEGEND_SHOW = "legendShow";
    private static final String PARAM_LEGEND_POSITION = "legendPosition";
    private static final String PARAM_LEGEND_LABEL_BOX_BORDER_COLOR = "legendLabelBoxBorderColor";
    private static final String PARAM_LEGEND_BACKGROUND_COLOR = "legendBackgroundColor";
    private static final String PARAM_ON_CLICK_TOPICS = "onClickTopics";
    private static final String PARAM_ON_HOVER_TOPICS = "onHoverTopics";
    private static final String PARAM_CROSSHAIR = "crosshair";
    private static final String PARAM_CROSSHAIR_MODE = "crosshairMode";
    private static final String PARAM_CROSSHAIR_COLOR = "crosshairColor";
    private static final String PARAM_CROSSHAIR_LINE_WIDTH = "crosshairLineWidth";
    private static final String PARAM_PIE = "pie";
    private static final String PARAM_PIE_RADIUS = "pieRadius";
    private static final String PARAM_PIE_INNER_RADIUS = "pieInnerRadius";
    private static final String PARAM_PIE_LABEL = "pieLabel";
    private static final String PARAM_PIE_LABEL_RADIUS = "pieLabelRadius";
    private static final String PARAM_PIE_LABEL_BACKGROUND_OPACITY = "pieLabelBackgroundOpacity";
    private static final String PARAM_PIE_LABEL_BACKGROUND_COLOR = "pieLabelBackgroundColor";
    private static final String PARAM_PIE_LABEL_FORMATTER = "pieLabelFormatter";
    private static final String PARAM_AUTO_RESIZE = "autoResize";

    private static final String ID_PREFIX_CHART = "chart_";

    protected String xaxisPosition;
    protected String xaxisMode;
    protected String xaxisColor;
    protected String xaxisTick;
    protected String xaxisTickSize;
    protected String xaxisTickDecimals;
    protected String xaxisTickColor;
    protected String xaxisMin;
    protected String xaxisMax;
    protected String xaxisTimeformat;
    protected String xaxisLabel;
    protected String xaxisLabelFontSizePixels;
    protected String xaxisLabelFontFamily;
    protected String yaxisPosition;
    protected String yaxisMode;
    protected String yaxisColor;
    protected String yaxisTick;
    protected String yaxisTickSize;
    protected String yaxisTickDecimals;
    protected String yaxisTickColor;
    protected String yaxisMin;
    protected String yaxisMax;
    protected String yaxisTimeformat;
    protected String yaxisLabel;
    protected String yaxisLabelFontSizePixels;
    protected String yaxisLabelFontFamily;
    protected String legendShow;
    protected String legendPosition;
    protected String legendLabelBoxBorderColor;
    protected String legendBackgroundColor;
    protected String onClickTopics;
    protected String onHoverTopics;
    protected String crosshair;
    protected String crosshairMode;
    protected String crosshairColor;
    protected String crosshairLineWidth;
    protected String pie;
    protected String pieRadius;
    protected String pieInnerRadius;
    protected String pieLabel;
    protected String pieLabelFormatter;
    protected String pieLabelRadius;
    protected String pieLabelBackgroundColor;
    protected String pieLabelBackgroundOpacity;
    protected String autoResize;

    public Chart(ValueStack stack, HttpServletRequest request,
                 HttpServletResponse response) {
        super(stack, request, response);
    }

    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_XAXIS_POSITION, this.xaxisPosition);
        addParameterIfPresent(PARAM_XAXIS_MODE, this.xaxisMode);
        addParameterIfPresent(PARAM_XAXIS_COLOR, this.xaxisColor);
        addParameterIfPresent(PARAM_XAXIS_TICK, this.xaxisTick);
        addParameterIfPresent(PARAM_XAXIS_TICK_SIZE, this.xaxisTickSize);
        addParameterIfPresent(PARAM_XAXIS_TICK_DECIMALS, this.xaxisTickDecimals);
        addParameterIfPresent(PARAM_XAXIS_TICK_COLOR, this.xaxisTickColor);
        addParameterIfPresent(PARAM_XAXIS_MIN, this.xaxisMin);
        addParameterIfPresent(PARAM_XAXIS_MAX, this.xaxisMax);
        addParameterIfPresent(PARAM_XAXIS_TIMEFORMAT, this.xaxisTimeformat);
        addParameterIfPresent(PARAM_XAXIS_LABEL, this.xaxisLabel);
        addParameterIfPresent(PARAM_XAXIS_LABEL_FONT_SIZE_PIXELS, this.xaxisLabelFontSizePixels, Number.class);
        addParameterIfPresent(PARAM_XAXIS_LABEL_FONT_FAMILY, this.xaxisLabelFontFamily);
        addParameterIfPresent(PARAM_YAXIS_POSITION, this.yaxisPosition);
        addParameterIfPresent(PARAM_YAXIS_MODE, this.yaxisMode);
        addParameterIfPresent(PARAM_YAXIS_COLOR, this.yaxisColor);
        addParameterIfPresent(PARAM_YAXIS_TICK, this.yaxisTick);
        addParameterIfPresent(PARAM_YAXIS_TICK_SIZE, this.yaxisTickSize);
        addParameterIfPresent(PARAM_YAXIS_TICK_DECIMALS, this.yaxisTickDecimals);
        addParameterIfPresent(PARAM_YAXIS_TICK_COLOR, this.yaxisTickColor);
        addParameterIfPresent(PARAM_YAXIS_MIN, this.yaxisMin);
        addParameterIfPresent(PARAM_YAXIS_MAX, this.yaxisMax);
        addParameterIfPresent(PARAM_YAXIS_TIMEFORMAT, this.yaxisTimeformat);
        addParameterIfPresent(PARAM_YAXIS_LABEL, this.yaxisLabel);
        addParameterIfPresent(PARAM_YAXIS_LABEL_FONT_SIZE_PIXELS, this.yaxisLabelFontSizePixels, Number.class);
        addParameterIfPresent(PARAM_YAXIS_LABEL_FONT_FAMILY, this.yaxisLabelFontFamily);
        addParameterIfPresent(PARAM_LEGEND_SHOW, this.legendShow, Boolean.class);
        addParameterIfPresent(PARAM_LEGEND_POSITION, this.legendPosition);
        addParameterIfPresent(PARAM_LEGEND_LABEL_BOX_BORDER_COLOR, this.legendLabelBoxBorderColor);
        addParameterIfPresent(PARAM_LEGEND_BACKGROUND_COLOR, this.legendBackgroundColor);
        addParameterIfPresent(PARAM_ON_CLICK_TOPICS, this.onClickTopics);
        addParameterIfPresent(PARAM_ON_HOVER_TOPICS, this.onHoverTopics);
        addParameterIfPresent(PARAM_CROSSHAIR, this.crosshair, Boolean.class);
        addParameterIfPresent(PARAM_CROSSHAIR_MODE, this.crosshairMode);
        addParameterIfPresent(PARAM_CROSSHAIR_COLOR, this.crosshairColor);
        addParameterIfPresent(PARAM_CROSSHAIR_LINE_WIDTH, this.crosshairLineWidth, Number.class);
        addParameterIfPresent(PARAM_PIE, this.pie, Boolean.class);
        addParameterIfPresent(PARAM_PIE_RADIUS, this.pieRadius);
        addParameterIfPresent(PARAM_PIE_INNER_RADIUS, this.pieInnerRadius);
        addParameterIfPresent(PARAM_PIE_LABEL, this.pieLabel, Boolean.class);
        addParameterIfPresent(PARAM_PIE_LABEL_RADIUS, this.pieLabelRadius);
        addParameterIfPresent(PARAM_PIE_LABEL_BACKGROUND_OPACITY, this.pieLabelBackgroundOpacity);
        addParameterIfPresent(PARAM_PIE_LABEL_BACKGROUND_COLOR, this.pieLabelBackgroundColor);
        addParameterIfPresent(PARAM_PIE_LABEL_FORMATTER, this.pieLabelFormatter);
        addParameterIfPresent(PARAM_AUTO_RESIZE, this.autoResize, Boolean.class);

        addGeneratedIdParam(ID_PREFIX_CHART);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setTheme(String theme) {
        super.setTheme(theme);
    }

    @Override
    public String getTheme() {
        return "jquery";
    }

    @StrutsTagAttribute(description = "bottom, top, left, right")
    public void setXaxisPosition(String xaxisPosition) {
        this.xaxisPosition = xaxisPosition;
    }

    @StrutsTagAttribute(description = "null or time", defaultValue = "null")
    public void setXaxisMode(String xaxisMode) {
        this.xaxisMode = xaxisMode;
    }

    @StrutsTagAttribute(description = "color value")
    public void setXaxisColor(String xaxisColor) {
        this.xaxisColor = xaxisColor;
    }

    @StrutsTagAttribute(description = "color value")
    public void setXaxisTickColor(String xaxisTickColor) {
        this.xaxisTickColor = xaxisTickColor;
    }

    @StrutsTagAttribute(description = "format string to use. The following specifiers are supported:   %h: hours,  %H: hours (left-padded with a zero),  %M: minutes (left-padded with a zero),  %S: seconds (left-padded with a zero),  %d: day of month (1-31), use %0d for zero-padding,  %m: month (1-12), use %0m for zero-padding,  %y: year (four digits),  %b: month name (customizable),  %p: am/pm, additionally switches %h/%H to 12 hour instead of 24,  %P: AM/PM (uppercase version of %p)")
    public void setXaxisTimeformat(String xaxisTimeformat) {
        this.xaxisTimeformat = xaxisTimeformat;
    }

    @StrutsTagAttribute(description = "minimum value")
    public void setXaxisMin(String xaxisMin) {
        this.xaxisMin = xaxisMin;
    }

    @StrutsTagAttribute(description = "maximum value")
    public void setXaxisMax(String xaxisMax) {
        this.xaxisMax = xaxisMax;
    }

    @StrutsTagAttribute(description = "bottom, top, left, right")
    public void setYaxisPosition(String yaxisPosition) {
        this.yaxisPosition = yaxisPosition;
    }

    @StrutsTagAttribute(description = "null or time", defaultValue = "null")
    public void setYaxisMode(String yaxisMode) {
        this.yaxisMode = yaxisMode;
    }

    @StrutsTagAttribute(description = "color value")
    public void setYaxisColor(String yaxisColor) {
        this.yaxisColor = yaxisColor;
    }

    @StrutsTagAttribute(description = "color value")
    public void setYaxisTickColor(String yaxisTickColor) {
        this.yaxisTickColor = yaxisTickColor;
    }

    @StrutsTagAttribute(description = "minimum value")
    public void setYaxisMin(String yaxisMin) {
        this.yaxisMin = yaxisMin;
    }

    @StrutsTagAttribute(description = "maximum value")
    public void setYaxisMax(String yaxisMax) {
        this.yaxisMax = yaxisMax;
    }

    @StrutsTagAttribute(description = "format string to use. The following specifiers are supported:   %h: hours,  %H: hours (left-padded with a zero),  %M: minutes (left-padded with a zero),  %S: seconds (left-padded with a zero),  %d: day of month (1-31), use %0d for zero-padding,  %m: month (1-12), use %0m for zero-padding,  %y: year (four digits),  %b: month name (customizable),  %p: am/pm, additionally switches %h/%H to 12 hour instead of 24,  %P: AM/PM (uppercase version of %p)")
    public void setYaxisTimeformat(String yaxisTimeformat) {
        this.yaxisTimeformat = yaxisTimeformat;
    }

    @StrutsTagAttribute(description = "show legend", type = "Boolean", defaultValue = "true")
    public void setLegendShow(String legendShow) {
        this.legendShow = legendShow;
    }

    @StrutsTagAttribute(description = "position of legend. ne, nw, se, sw", defaultValue = "ne")
    public void setLegendPosition(String legendPosition) {
        this.legendPosition = legendPosition;
    }

    @StrutsTagAttribute(description = "color of label box")
    public void setLegendLabelBoxBorderColor(String legendLabelBoxBorderColor) {
        this.legendLabelBoxBorderColor = legendLabelBoxBorderColor;
    }

    @StrutsTagAttribute(description = "legend background color")
    public void setLegendBackgroundColor(String legendBackgroundColor) {
        this.legendBackgroundColor = legendBackgroundColor;
    }

    @StrutsTagAttribute(description = "number or ticks array. If you want to completely override the tick algorithm, you can specify an array for ticks, either like this: [0, 1.2, 2.4] or like this where the labels are also customized: [[0, 'zero'], [1.2, 'one mark'], [2.4, 'two marks']]")
    public void setXaxisTick(String xaxisTick) {
        this.xaxisTick = xaxisTick;
    }

    @StrutsTagAttribute(description = "number or ticks array. If you set it to 2, you'll get ticks at 2, 4, 6, etc. Note that for time series, the format is an array like [2, 'month']")
    public void setXaxisTickSize(String xaxisTickSize) {
        this.xaxisTickSize = xaxisTickSize;
    }

    @StrutsTagAttribute(description = "the number of decimals to display (default is auto-detected).", defaultValue = "auto-detected")
    public void setXaxisTickDecimals(String xaxisTickDecimals) {
        this.xaxisTickDecimals = xaxisTickDecimals;
    }

    @StrutsTagAttribute(description = "number or ticks array. If you want to completely override the tick algorithm, you can specify an array for ticks, either like this: [0, 1.2, 2.4] or like this where the labels are also customized: [[0, 'zero'], [1.2, 'one mark'], [2.4, 'two marks']]")
    public void setYaxisTick(String yaxisTick) {
        this.yaxisTick = yaxisTick;
    }

    @StrutsTagAttribute(description = "number or ticks array. If you set it to 2, you'll get ticks at 2, 4, 6, etc. Note that for time series, the format is an array like [2, 'month']")
    public void setYaxisTickSize(String yaxisTickSize) {
        this.yaxisTickSize = yaxisTickSize;
    }

    @StrutsTagAttribute(description = "the number of decimals to display (default is auto-detected).", defaultValue = "auto-detected")
    public void setYaxisTickDecimals(String yaxisTickDecimals) {
        this.yaxisTickDecimals = yaxisTickDecimals;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the grid is clicked")
    public void setOnClickTopics(String onClickTopics) {
        this.onClickTopics = onClickTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the grid is hovered")
    public void setOnHoverTopics(String onHoverTopics) {
        this.onHoverTopics = onHoverTopics;
    }

    @StrutsTagAttribute(description = "showing a crosshair, thin lines, when the mouse hovers over the plot", type = "Boolean", defaultValue = "false")
    public void setCrosshair(String crosshair) {
        this.crosshair = crosshair;
    }

    @StrutsTagAttribute(description = "crosshair mode, 'x', 'y' or 'xy'")
    public void setCrosshairMode(String crosshairMode) {
        this.crosshairMode = crosshairMode;
    }

    @StrutsTagAttribute(description = "crosshair color")
    public void setCrosshairColor(String crosshairColor) {
        this.crosshairColor = crosshairColor;
    }

    @StrutsTagAttribute(description = "crosshair line width", type = "Number")
    public void setCrosshairLineWidth(String crosshairLineWidth) {
        this.crosshairLineWidth = crosshairLineWidth;
    }

    @StrutsTagAttribute(description = "Display the Chart as a Pie", type = "Boolean", defaultValue = "false")
    public void setPie(String pie) {
        this.pie = pie;
    }

    @StrutsTagAttribute(description = "0-1 for percentage of fullsize, or a specified pixel length", defaultValue = "auto")
    public void setPieRadius(String pieRadius) {
        this.pieRadius = pieRadius;
    }

    @StrutsTagAttribute(description = "0-1 for percentage of fullsize or a specified pixel length, for creating a donut effect")
    public void setPieInnerRadius(String pieInnerRadius) {
        this.pieInnerRadius = pieInnerRadius;
    }

    @StrutsTagAttribute(description = "Display Pie Labels", type = "Boolean", defaultValue = "false")
    public void setPieLabel(String pieLabel) {
        this.pieLabel = pieLabel;
    }

    @StrutsTagAttribute(description = "a user-defined function that modifies the text/style of the label text. eg. name of a function like this function(label, series){ return '<div style=\"font-size:8pt;text-align:center;padding:2px;color:white;\">'+label+'<br/>'+Math.round(series.percent)+'%</div>'; }")
    public void setPieLabelFormatter(String pieLabelFormatter) {
        this.pieLabelFormatter = pieLabelFormatter;
    }

    @StrutsTagAttribute(description = "0-1 for percentage of fullsize, or a specified pixel length", defaultValue = "auto")
    public void setPieLabelRadius(String pieLabelRadius) {
        this.pieLabelRadius = pieLabelRadius;
    }

    @StrutsTagAttribute(description = "any hexidecimal color value")
    public void setPieLabelBackgroundColor(String pieLabelBackgroundColor) {
        this.pieLabelBackgroundColor = pieLabelBackgroundColor;
    }

    @StrutsTagAttribute(description = "0-1")
    public void setPieLabelBackgroundOpacity(String pieLabelBackgroundOpacity) {
        this.pieLabelBackgroundOpacity = pieLabelBackgroundOpacity;
    }

    @StrutsTagAttribute(description = "Label for X-Axis")
    public void setXaxisLabel(String xaxisLabel) {
        this.xaxisLabel = xaxisLabel;
    }

    @StrutsTagAttribute(description = "Label for Y-Axis")
    public void setYaxisLabel(String yaxisLabel) {
        this.yaxisLabel = yaxisLabel;
    }

    @StrutsTagAttribute(description = "X-Axis Label Font Size. e.g. 20", type = "Number")
    public void setXaxisLabelFontSizePixels(String xaxisLabelFontSizePixels) {
        this.xaxisLabelFontSizePixels = xaxisLabelFontSizePixels;
    }

    @StrutsTagAttribute(description = "X-Axis Label Font Family. e.g. Arial")
    public void setXaxisLabelFontFamily(String xaxisLabelFontFamily) {
        this.xaxisLabelFontFamily = xaxisLabelFontFamily;
    }

    @StrutsTagAttribute(description = "Y-Axis Label Font Size. e.g. 20", type = "Number")
    public void setYaxisLabelFontSizePixels(String yaxisLabelFontSizePixels) {
        this.yaxisLabelFontSizePixels = yaxisLabelFontSizePixels;
    }

    @StrutsTagAttribute(description = "Y-Axis Label Font Family. e.g. Arial")
    public void setYaxisLabelFontFamily(String yaxisLabelFontFamily) {
        this.yaxisLabelFontFamily = yaxisLabelFontFamily;
    }

    @StrutsTagAttribute(description = "If the size of the Placeholder DIV is changed, it will redraw the plot.", type = "Boolean", defaultValue = "false")
    public void setAutoResize(String autoResize) {
        this.autoResize = autoResize;
    }
}
