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

import com.jgeppert.struts2.jquery.components.Slider;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see Slider
 */
public class SliderTag extends AbstractTopicTag {

  private static final long serialVersionUID = 2998110777278172006L;

  protected String          animate;
  protected String          max;
  protected String          min;
  protected String          orientation;
  protected String          range;
  protected String          step;
  protected String          start;
  protected String          slide;
  protected String          change;
  protected String          stop;
  protected String          displayValueElement;
  protected String          onSlideTopics;

  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new Slider(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();

    Slider slider = (Slider) component;
    slider.setAnimate(animate);
    slider.setMax(max);
    slider.setMin(min);
    slider.setOrientation(orientation);
    slider.setRange(range);
    slider.setStep(step);
    slider.setDisplayValueElement(displayValueElement);
    slider.setOnSlideTopics(onSlideTopics);
  }

  public void setAnimate(String animate)
  {
    this.animate = animate;
  }

  public void setMax(String max)
  {
    this.max = max;
  }

  public void setMin(String min)
  {
    this.min = min;
  }

  public void setOrientation(String orientation)
  {
    this.orientation = orientation;
  }

  public void setRange(String range)
  {
    this.range = range;
  }

  public void setStep(String step)
  {
    this.step = step;
  }

  public void setDisplayValueElement(String displayValueElement)
  {
    this.displayValueElement = displayValueElement;
  }

  public void setOnSlideTopics(String onSlideTopics)
  {
    this.onSlideTopics = onSlideTopics;
  }
}
