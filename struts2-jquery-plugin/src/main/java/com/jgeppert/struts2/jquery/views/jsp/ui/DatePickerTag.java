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

import com.jgeppert.struts2.jquery.components.DatePicker;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see DatePicker
 */
public class DatePickerTag extends AbstractTopicTag {

  private static final long serialVersionUID = 4054114507143447232L;

  protected String          displayFormat;
  protected String          showButtonPanel;
  protected String          changeMonth;
  protected String          changeYear;
  protected String          buttonImage;
  protected String          appendText;
  protected String          buttonImageOnly;
  protected String          buttonText;
  protected String          duration;
  protected String          firstDay;
  protected String          numberOfMonths;
  protected String          showAnim;
  protected String          showOn;
  protected String          showOptions;
  protected String          yearRange;
  protected String          zindex;
  protected String          onBeforeShowDayTopics;
  protected String          onChangeMonthYearTopics;
  protected String          minDate;
  protected String          maxDate;

  protected String          maxlength;
  protected String          readonly;
  protected String          size;

  protected String          parentTheme;

  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new DatePicker(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();

    DatePicker datePicker = (DatePicker) component;
    datePicker.setDisplayFormat(displayFormat);
    datePicker.setShowButtonPanel(showButtonPanel);
    datePicker.setChangeMonth(changeMonth);
    datePicker.setChangeYear(changeYear);
    datePicker.setButtonImage(buttonImage);

    datePicker.setButtonImageOnly(buttonImageOnly);
    datePicker.setAppendText(appendText);
    datePicker.setButtonText(buttonText);
    datePicker.setDuration(duration);
    datePicker.setFirstDay(firstDay);
    datePicker.setNumberOfMonths(numberOfMonths);
    datePicker.setShowAnim(showAnim);
    datePicker.setShowOn(showOn);
    datePicker.setShowOptions(showOptions);
    datePicker.setYearRange(yearRange);
    datePicker.setZindex(zindex);
    datePicker.setOnBeforeShowDayTopics(onBeforeShowDayTopics);
    datePicker.setOnChangeMonthYearTopics(onChangeMonthYearTopics);
    datePicker.setMinDate(minDate);
    datePicker.setMaxDate(maxDate);
    datePicker.setMaxlength(maxlength);
    datePicker.setSize(size);
    datePicker.setReadonly(readonly);

    datePicker.setParentTheme(parentTheme);
  }

  public void setDisplayFormat(String displayFormat)
  {
    this.displayFormat = displayFormat;
  }

  public void setShowButtonPanel(String showButtonPanel)
  {
    this.showButtonPanel = showButtonPanel;
  }

  public void setChangeMonth(String changeMonth)
  {
    this.changeMonth = changeMonth;
  }

  public void setChangeYear(String changeYear)
  {
    this.changeYear = changeYear;
  }

  public void setButtonImage(String buttonImage)
  {
    this.buttonImage = buttonImage;
  }

  public void setAppendText(String appendText)
  {
    this.appendText = appendText;
  }

  public void setButtonImageOnly(String buttonImageOnly)
  {
    this.buttonImageOnly = buttonImageOnly;
  }

  public void setButtonText(String buttonText)
  {
    this.buttonText = buttonText;
  }

  public void setDuration(String duration)
  {
    this.duration = duration;
  }

  public void setFirstDay(String firstDay)
  {
    this.firstDay = firstDay;
  }

  public void setNumberOfMonths(String numberOfMonths)
  {
    this.numberOfMonths = numberOfMonths;
  }

  public void setShowAnim(String showAnim)
  {
    this.showAnim = showAnim;
  }

  public void setShowOn(String showOn)
  {
    this.showOn = showOn;
  }

  public void setShowOptions(String showOptions)
  {
    this.showOptions = showOptions;
  }

  public void setYearRange(String yearRange)
  {
    this.yearRange = yearRange;
  }

  public void setZindex(String zindex)
  {
    this.zindex = zindex;
  }

  public void setOnBeforeShowDayTopics(String onBeforeShowDayTopics)
  {
    this.onBeforeShowDayTopics = onBeforeShowDayTopics;
  }

  public void setOnChangeMonthYearTopics(String onChangeMonthYearTopics)
  {
    this.onChangeMonthYearTopics = onChangeMonthYearTopics;
  }

  public void setMinDate(String minDate)
  {
    this.minDate = minDate;
  }

  public void setMaxDate(String maxDate)
  {
    this.maxDate = maxDate;
  }

  public void setMaxlength(String maxlength)
  {
    this.maxlength = maxlength;
  }

  public void setReadonly(String readonly)
  {
    this.readonly = readonly;
  }

  public void setSize(String size)
  {
    this.size = size;
  }
  
  public void setParentTheme(String parentTheme)
  {
    this.parentTheme = parentTheme;
  }
}
