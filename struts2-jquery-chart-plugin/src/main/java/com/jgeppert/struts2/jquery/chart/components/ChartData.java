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

import java.awt.Point;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts2.util.MakeIterator;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.AbstractContainer;
import com.jgeppert.struts2.jquery.components.DatePicker;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Data for the Chart Element
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "chartData", tldTagClass = "com.jgeppert.struts2.jquery.chart.views.jsp.ui.ChartDataTag", description = "Data for the Chart Element", allowDynamicAttributes = true)
public class ChartData extends AbstractContainer {

    public static final String TEMPLATE = "chart-data";
    public static final String TEMPLATE_CLOSE = "chart-data-close";
    public static final String COMPONENT_NAME = ChartData.class.getName();
    protected final static Logger LOG = LoggerFactory
	    .getLogger(DatePicker.class);
    private final static transient Random RANDOM = new Random();

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

    @SuppressWarnings("unchecked")
    public void evaluateExtraParams() {
	super.evaluateExtraParams();
	if (color != null)
	    addParameter("color", findString(color));
	if (label != null)
	    addParameter("label", findString(label));
	if (lines != null)
	    addParameter("lines", findString(lines));
	if (bars != null)
	    addParameter("bars", findString(bars));
	if (points != null)
	    addParameter("points", findString(points));
	if (xaxis != null)
	    addParameter("xaxis", findValue(xaxis, Integer.class));
	if (yaxis != null)
	    addParameter("yaxis", findValue(yaxis, Integer.class));
	if (clickable != null)
	    addParameter("clickable", findValue(this.clickable, Boolean.class));
	if (hoverable != null)
	    addParameter("hoverable", findValue(this.hoverable, Boolean.class));
	if (shadowSize != null)
	    addParameter("shadowSize", findValue(shadowSize, Integer.class));
	if (fillBetween != null)
	    addParameter("fillBetween", findString(fillBetween));

	if ((this.id == null || this.id.length() == 0)) {
	    // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
	    // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
		    .abs(nextInt);
	    this.id = "chartdata" + String.valueOf(nextInt);
	    addParameter("id", this.id);
	}

	Chart chart = (Chart) findAncestor(Chart.class);
	if (chart != null) {
	    addParameter("chart", chart.getId());
	}

	if (this.href != null && !this.href.equals("#")) {
	    if (list != null) {
		addParameter("remoteList", findString(list.toString()));
	    }
	    if (listKey != null) {
		addParameter("remoteListKey", findString(listKey));
	    }
	    if (listValue != null) {
		addParameter("remoteListValue", findString(listValue));
	    }
	} else if (data != null) {
	    addParameter("data", findString(data));
	} else {
	    if (list == null) {
		list = parameters.get("list");
	    }

	    Object listObject = findValue(list.toString());

	    if (listObject instanceof String) {
		addParameter("data", listObject);
	    } else if (listObject instanceof Map) {
		Map map = (Map) listObject;
		Set keySet = map.keySet();

		StringBuffer data = new StringBuffer();
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
		Iterator iterator = null;
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
				    String itemKey = null;
				    try {
					itemKey = (String) PropertyUtils
						.getSimpleProperty(item, key);
				    } catch (IllegalAccessException e) {
					LOG.warn("Cannot read listKey", e);
				    } catch (InvocationTargetException e) {
					LOG.warn("Cannot read listKey", e);
				    } catch (NoSuchMethodException e) {
					LOG.warn("Cannot read listKey", e);
				    }

				    if (itemKey != null) {
					data.append(itemKey);
				    } else {
					data.append(count);
				    }
				} else {
				    data.append(count);
				}

				data.append(",");

				if (listValue != null) {
				    String value = findString(listValue);
				    String itemValue = null;
				    try {
					itemValue = (String) PropertyUtils
						.getSimpleProperty(item, value);
				    } catch (IllegalAccessException e) {
					LOG.warn("Cannot read listValue", e);
				    } catch (InvocationTargetException e) {
					LOG.warn("Cannot read listValue", e);
				    } catch (NoSuchMethodException e) {
					LOG.warn("Cannot read listValue", e);
				    }

				    if (itemValue != null) {
					data.append(itemValue);
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
		    addParameter("data", data.toString());
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
	    + " parameter and the Map value will become the option body.", required = false)
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
}
