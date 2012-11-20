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

package com.jgeppert.struts2.jquery.showcase;

import java.util.Calendar;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class Datepicker extends ActionSupport {

  private static final long serialVersionUID = 7641453994518254115L;

  private Date              dateValue;
  private Date              nameValue;
  private Date              minValue;
  private Date              maxValue;

  @Action(value = "/datepicker", results = {
    @Result(location = "datepicker.jsp", name = "success")
  })
  public String execute() throws Exception
  {

    Calendar c = Calendar.getInstance();
    c.roll(Calendar.WEEK_OF_YEAR, -1);

    dateValue = c.getTime();

    c.roll(Calendar.MONTH, -1);

    nameValue = c.getTime();

    c.setTime(new Date());
    c.roll(Calendar.MONTH, -1);
    minValue = c.getTime();

    c.roll(Calendar.MONTH, 2);
    maxValue = c.getTime();

    return SUCCESS;
  }

  public Date getDateValue()
  {
    return dateValue;
  }

  public Date getNameValue()
  {
    return nameValue;
  }

  public Date getMinValue()
  {
    return minValue;
  }

  public Date getMaxValue()
  {
    return maxValue;
  }
}
