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

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.util.MakeIterator;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

public abstract class AbstractFormListElement extends AbstractFormElement {

  // indicate if an exception is to be thrown when value attribute is null
  protected boolean throwExceptionOnNullValueAttribute = false;

  protected Object  list;
  protected String  listKey;
  protected String  listValue;

  public AbstractFormListElement(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  public void evaluateExtraParams()
  {
    super.evaluateExtraParams();

    Object value = null;

    if (list == null)
    {
      list = parameters.get("list");
    }

    if (list instanceof String)
    {
      value = findValue((String) list);
    }
    else if (list instanceof Collection)
    {
      value = list;
    }
    else if (MakeIterator.isIterable(list))
    {
      value = MakeIterator.convert(list);
    }
    if (value == null)
    {
      if (throwExceptionOnNullValueAttribute)
      {
        // will throw an exception if not found
        value = findValue((list == null) ? (String) list : list.toString(), "list", "The requested list key '" + list + "' could not be resolved as a collection/array/map/enumeration/iterator type. " + "Example: people or people.{name}");
      }
      else
      {
        // ww-1010, allows value with null value to be compatible with ww
        // 2.1.7 behaviour
        value = findValue((list == null) ? (String) list : list.toString());
      }
    }

    if (value instanceof Collection)
    {
      addParameter("list", value);
    }
    else
    {
      addParameter("list", MakeIterator.convert(value));
    }

    if (value instanceof Collection)
    {
      addParameter("listSize", Integer.valueOf(((Collection) value).size()));
    }
    else if (value instanceof Map)
    {
      addParameter("listSize", Integer.valueOf(((Map) value).size()));
    }
    else if (value != null && value.getClass().isArray())
    {
      addParameter("listSize", Integer.valueOf(Array.getLength(value)));
    }

    if (listKey != null)
    {
      listKey = stripExpressionIfAltSyntax(listKey);
      addParameter("listKey", listKey);
    }
    else if (value instanceof Map)
    {
      addParameter("listKey", "key");
    }

    if (listValue != null)
    {
      listValue = stripExpressionIfAltSyntax(listValue);
      addParameter("listValue", listValue);
    }
    else if (value instanceof Map)
    {
      addParameter("listValue", "value");
    }
  }

  @StrutsTagAttribute(description = "Iterable source to populate from. If the list is a Map (key, value), the Map key will become the option 'value'" + " parameter and the Map value will become the option body.", required = false)
  public void setList(Object list)
  {
    this.list = list;
  }

  @StrutsTagAttribute(description = " Property of list objects to get field value from")
  public void setListKey(String listKey)
  {
    this.listKey = listKey;
  }

  @StrutsTagAttribute(description = "Property of list objects to get field content from")
  public void setListValue(String listValue)
  {
    this.listValue = listValue;
  }

  public void setThrowExceptionOnNullValueAttribute(boolean throwExceptionOnNullValueAttribute)
  {
    this.throwExceptionOnNullValueAttribute = throwExceptionOnNullValueAttribute;
  }
}
