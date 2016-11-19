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
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.MakeIterator;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Data for the Chart Element
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "chartData", tldTagClass = "com.jgeppert.struts2.jquery.chart.views.jsp.ui.ChartDataTag", description = "Data for the Chart Element", allowDynamicAttributes = true)
public class ChartData extends AbstractContainer {

    private static final Logger LOG = LogManager.getLogger(ChartData.class);

    public static final String TEMPLATE = "chart-data";
    public static final String TEMPLATE_CLOSE = "chart-data-close";
    public static final String COMPONENT_NAME = ChartData.class.getName();

    private static final String PARAM_COLOR = "color";
    private static final String PARAM_LABEL = "label";
    private static final String PARAM_LINES = "lines";
    private static final String PARAM_BARS = "bars";
    private static final String PARAM_POINTS = "points";
    private static final String PARAM_XAXIS = "xaxis";
    private static final String PARAM_YAXIS = "yaxis";
    private static final String PARAM_CLICKABLE = "clickable";
    private static final String PARAM_HOVERABLE = "hoverable";
    private static final String PARAM_SHADOW_SIZE = "shadowSize";
    private static final String PARAM_FILL_BETWEEN = "fillBetween";
    private static final String PARAM_CURVED_LINES = "curvedLines";
    private static final String PARAM_CURVED_LINES_FIT = "curvedLinesFit";
    private static final String PARAM_CURVED_LINES_FILL = "curvedLinesFill";
    private static final String PARAM_CURVED_LINES_FILL_COLOR = "curvedLinesFillColor";
    private static final String PARAM_CURVED_LINES_LINE_WIDTH = "curvedLinesLineWidth";
    private static final String PARAM_STACK = "stack";
    private static final String PARAM_CHART = "chart";
    private static final String PARAM_REMOTE_LIST = "remoteList";
    private static final String PARAM_REMOTE_LIST_KEY = "remoteListKey";
    private static final String PARAM_REMOTE_LIST_VALUE = "remoteListValue";
    private static final String PARAM_DATA = "data";
    private static final String PARAM_LIST = "list";

    private static final String ID_PREFIX_CHARTDATA = "chartdata_";

    protected String color;
    protected String label;
    protected String lines;
    protected String bars;
    protected String points;
    protected String xaxis;
    protected String yaxis;
    protected String clickable;
    protected String hoverable;
    protected String shadowSize;
    protected String fillBetween;
    protected String curvedLines;
    protected String curvedLinesFit;
    protected String curvedLinesFill;
    protected String curvedLinesFillColor;
    protected String curvedLinesLineWidth;
    protected String stack;

    protected String data;
    protected Object list;
    protected String listKey;
    protected String listValue;

    public ChartData(ValueStack stack, HttpServletRequest request,
                     HttpServletResponse response) {
        super(stack, request, response);
    }

    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    @SuppressWarnings("rawtypes")
    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameterIfPresent(PARAM_COLOR, this.color);
        addParameterIfPresent(PARAM_LABEL, this.label);
        addParameterIfPresent(PARAM_LINES, this.lines);
        addParameterIfPresent(PARAM_BARS, this.bars);
        addParameterIfPresent(PARAM_POINTS, this.points);
        addParameterIfPresent(PARAM_XAXIS, this.xaxis, Integer.class);
        addParameterIfPresent(PARAM_YAXIS, this.yaxis, Integer.class);
        addParameterIfPresent(PARAM_CLICKABLE, this.clickable, Boolean.class);
        addParameterIfPresent(PARAM_HOVERABLE, this.hoverable, Boolean.class);
        addParameterIfPresent(PARAM_SHADOW_SIZE, this.shadowSize, Integer.class);
        addParameterIfPresent(PARAM_FILL_BETWEEN, this.fillBetween);
        addParameterIfPresent(PARAM_CURVED_LINES, this.curvedLines, Boolean.class);
        addParameterIfPresent(PARAM_CURVED_LINES_FIT, this.curvedLinesFit, Boolean.class);
        addParameterIfPresent(PARAM_CURVED_LINES_FILL, this.curvedLinesFill, Boolean.class);
        addParameterIfPresent(PARAM_CURVED_LINES_FILL_COLOR, this.curvedLinesFillColor);
        addParameterIfPresent(PARAM_CURVED_LINES_LINE_WIDTH, this.curvedLinesLineWidth, Integer.class);
        addParameterIfPresent(PARAM_STACK, this.stack);

        addGeneratedIdParam(ID_PREFIX_CHARTDATA);

        Chart chart = (Chart) findAncestor(Chart.class);
        if (chart != null) {
            addParameter(PARAM_CHART, chart.getId());
        }

        if (this.href != null && !this.href.equals("#")) {
            addParameterIfPresent(PARAM_REMOTE_LIST, this.list.toString());
            addParameterIfPresent(PARAM_REMOTE_LIST_KEY, this.listKey);
            addParameterIfPresent(PARAM_REMOTE_LIST_VALUE, this.listValue);
        } else if (data != null) {
            addParameter(PARAM_DATA, findString(data));
        } else {
            if (list == null) {
                list = parameters.get(PARAM_LIST);
            }

            Object listObject = findValue(list.toString());

            if (listObject instanceof String) {
                addParameter("data", listObject);
            } else if (listObject instanceof Map) {
                Map map = (Map) listObject;
                Set keySet = map.keySet();

                StringBuilder data = new StringBuilder();
                data.append("[");

                boolean setComma = false;
                for (Object key : keySet) {
                    if (setComma) {
                        data.append(",");
                    }
                    if (!setComma) {
                        setComma = true;
                    }
                    data.append("[");
                    if (key instanceof Date) {
                        data.append(((Date) key).getTime());
                    } else {
                        data.append(key.toString());
                    }
                    data.append(",");
                    data.append(map.get(key));
                    data.append("]");
                }
                data.append("]");
                addParameter("data", data.toString());
            } else {
                Iterator iterator;
                if (listObject instanceof Collection) {
                    iterator = ((Collection) listObject).iterator();
                } else {
                    iterator = MakeIterator.convert(listObject);
                }

                if (iterator != null) {
                    StringBuffer data = new StringBuffer();
                    data.append("[");

                    Object item = iterator.next();
                    boolean iterat = true;
                    int count = 0;
                    while (iterat) {
                        count++;
                        if (item == null) {
                            data.append("null");
                        } else {
                            if (item instanceof Point) {
                                data.append("[");
                                Point point = (Point) item;
                                data.append(point.getX());
                                data.append(",");
                                data.append(point.getY());
                                data.append("]");
                            } else {
                                data.append("[");
                                if (listKey != null) {
                                    String key = findString(listKey);
                                    Object itemKey = null;
                                    try {
                                        itemKey = PropertyUtils.getSimpleProperty(item, key);
                                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                                        LOG.warn("Cannot read listKey", e);
                                    }

                                    if (itemKey != null) {
                                        if (itemKey instanceof Date) {
                                            data.append(((Date) itemKey).getTime());
                                        } else {
                                            data.append(itemKey.toString());
                                        }
                                    } else {
                                        data.append(count);
                                    }
                                } else {
                                    data.append(count);
                                }

                                data.append(",");

                                if (listValue != null) {
                                    String value = findString(listValue);
                                    Object itemValue = null;
                                    try {
                                        itemValue = PropertyUtils.getSimpleProperty(item, value);
                                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                                        LOG.warn("Cannot read listValue", e);
                                    }

                                    if (itemValue != null) {
                                        if (itemValue instanceof Date) {
                                            data.append(((Date) itemValue).getTime());
                                        } else {
                                            data.append(itemValue.toString());
                                        }
                                    } else {
                                        data.append(item.toString());
                                    }
                                } else {
                                    data.append(item.toString());
                                }
                                data.append("]");
                            }
                        }

                        if (iterator.hasNext()) {
                            data.append(",");
                            item = iterator.next();
                        } else {
                            iterat = false;
                        }
                    }

                    data.append("]");
                    addParameter(PARAM_DATA, data.toString());
                }
            }
        }
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

    @StrutsTagAttribute(description = "color or number")
    public void setColor(String color) {
        this.color = color;
    }

    @StrutsTagAttribute(description = "The Data Label")
    public void setLabel(String label) {
        this.label = label;
    }

    @StrutsTagAttribute(description = "specific lines options")
    public void setLines(String lines) {
        this.lines = lines;
    }

    @StrutsTagAttribute(description = "specific bars options")
    public void setBars(String bars) {
        this.bars = bars;
    }

    @StrutsTagAttribute(description = "specific points options")
    public void setPoints(String points) {
        this.points = points;
    }

    @StrutsTagAttribute(description = "1 or 2", type = "Integer")
    public void setXaxis(String xaxis) {
        this.xaxis = xaxis;
    }

    @StrutsTagAttribute(description = "1 or 2", type = "Integer")
    public void setYaxis(String yaxis) {
        this.yaxis = yaxis;
    }

    @StrutsTagAttribute(description = "can be set to false to disable interactivity for specific series if interactivity is turned on in the plot Default: true", defaultValue = "false", type = "Boolean")
    public void setClickable(String clickable) {
        this.clickable = clickable;
    }

    @StrutsTagAttribute(description = "can be set to false to disable interactivity for specific series if interactivity is turned on in the plot Default: true", defaultValue = "true", type = "Boolean")
    public void setHoverable(String hoverable) {
        this.hoverable = hoverable;
    }

    @StrutsTagAttribute(description = "Shadow Size", type = "Integer")
    public void setShadowSize(String shadowSize) {
        this.shadowSize = shadowSize;
    }

    @StrutsTagAttribute(description = "fill the area between two series.")
    public void setFillBetween(String fillBetween) {
        this.fillBetween = fillBetween;
    }

    @StrutsTagAttribute(description = "Chart Data. Don't use list and data attributes together. When using a Pie Chart data can be a numerical value like 10.")
    public void setData(String data) {
        this.data = data;
    }

    @StrutsTagAttribute(description = "Iterable source to populate from. If the list is a Map (key, value), the Map key will become the option 'value'"
            + " parameter and the Map value will become the option body.")
    public void setList(Object list) {
        this.list = list;
    }

    @StrutsTagAttribute(description = " Property of list objects to get field value from")
    public void setListKey(String listKey) {
        this.listKey = listKey;
    }

    @StrutsTagAttribute(description = "Property of list objects to get field content from")
    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    @StrutsTagAttribute(description = "Try to display lines in a smoother way.", type = "Boolean", defaultValue = "false")
    public void setCurvedLines(String curvedLines) {
        this.curvedLines = curvedLines;
    }

    @StrutsTagAttribute(description = "forces the max,mins of the curve to be on the datapoints.", type = "Boolean", defaultValue = "false")
    public void setCurvedLinesFit(String curvedLinesFit) {
        this.curvedLinesFit = curvedLinesFit;
    }

    @StrutsTagAttribute(description = "lines get filled.", type = "Boolean", defaultValue = "false")
    public void setCurvedLinesFill(String curvedLinesFill) {
        this.curvedLinesFill = curvedLinesFill;
    }

    @StrutsTagAttribute(description = "the color that should be used for filling")
    public void setCurvedLinesFillColor(String curvedLinesFillColor) {
        this.curvedLinesFillColor = curvedLinesFillColor;
    }

    @StrutsTagAttribute(description = "the width of the line.", type = "Integer")
    public void setCurvedLinesLineWidth(String curvedLinesLineWidth) {
        this.curvedLinesLineWidth = curvedLinesLineWidth;
    }

    @StrutsTagAttribute(description = "Stacking data sets, i.e. putting them on top of each other, for accumulative graphs")
    public void setStack(String stack) {
        this.stack = stack;
    }
}
