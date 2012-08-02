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

package com.jgeppert.struts2.jquery.chart.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.chart.components.ChartData;
import com.jgeppert.struts2.jquery.views.jsp.ui.AbstractContainerTag;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */

public class ChartDataTag extends AbstractContainerTag {

	private static final long serialVersionUID = -5967481302404440884L;
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

	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new ChartData(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();

		ChartData chartData = (ChartData) component;
		chartData.setColor(color);
		chartData.setLabel(label);
		chartData.setLines(lines);
		chartData.setBars(bars);
		chartData.setPoints(points);
		chartData.setXaxis(xaxis);
		chartData.setYaxis(yaxis);
		chartData.setClickable(clickable);
		chartData.setHoverable(hoverable);
		chartData.setShadowSize(shadowSize);
		chartData.setFillBetween(fillBetween);
		chartData.setCurvedLines(curvedLines);
		chartData.setCurvedLinesFit(curvedLinesFit);
		chartData.setCurvedLinesFill(curvedLinesFill);
		chartData.setCurvedLinesFillColor(curvedLinesFillColor);
		chartData.setCurvedLinesLineWidth(curvedLinesLineWidth);
		chartData.setStack(stack);
		chartData.setData(data);
		chartData.setList(list);
		chartData.setListKey(listKey);
		chartData.setListValue(listValue);
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setLines(String lines) {
		this.lines = lines;
	}

	public void setBars(String bars) {
		this.bars = bars;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public void setXaxis(String xaxis) {
		this.xaxis = xaxis;
	}

	public void setYaxis(String yaxis) {
		this.yaxis = yaxis;
	}

	public void setClickable(String clickable) {
		this.clickable = clickable;
	}

	public void setHoverable(String hoverable) {
		this.hoverable = hoverable;
	}

	public void setShadowSize(String shadowSize) {
		this.shadowSize = shadowSize;
	}

	public void setFillBetween(String fillBetween) {
		this.fillBetween = fillBetween;
	}

	public void setCurvedLines(String curvedLines) {
		this.curvedLines = curvedLines;
	}

	public void setCurvedLinesFit(String curvedLinesFit) {
		this.curvedLinesFit = curvedLinesFit;
	}

	public void setCurvedLinesFill(String curvedLinesFill) {
		this.curvedLinesFill = curvedLinesFill;
	}

	public void setCurvedLinesFillColor(String curvedLinesFillColor) {
		this.curvedLinesFillColor = curvedLinesFillColor;
	}

	public void setCurvedLinesLineWidth(String curvedLinesLineWidth) {
		this.curvedLinesLineWidth = curvedLinesLineWidth;
	}

	public void setStack(String stack) {
	    this.stack = stack;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public void setListKey(String listKey) {
		this.listKey = listKey;
	}

	public void setListValue(String listValue) {
		this.listValue = listValue;
	}

}
