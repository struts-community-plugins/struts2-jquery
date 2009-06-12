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

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Date;
import org.apache.struts2.components.UIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * A tag that creates an Datepicker. 
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>Examples</p>
 * 
 * <!-- START SNIPPET: example1 -->
 * &lt;sj:datepicker id="birthday" name="birthday"/&gt;
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * &lt;sj:datepicker showButtonPanel="true" changeMonth="true" changeYear="true" id="birthday" name="birthday"/&gt;
 * <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 -->
 * &lt;sj:datepicker displayFormat="dd.mm.yy" id="birthday" name="birthday"/&gt;
 * <!-- END SNIPPET: example3 -->
 */
@StrutsTag(name="datepicker", tldTagClass="com.jgeppert.struts2.jquery.views.jsp.ui.DatePickerTag", description="Render datepicker")
public class DatePicker extends UIBean {

    final public static String TEMPLATE = "datepicker";
    // SimpleDateFormat is not thread-safe see:
    //   http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6231579
    //   http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6178997
    // solution is to use stateless MessageFormat instead:
    final private static String RFC3339_FORMAT = "yyyy-MM-dd";
    final private static String RFC3339_PATTERN = "{0,date," + RFC3339_FORMAT + "}";
    final protected static Logger LOG = LoggerFactory.getLogger(DatePicker.class);
    final private static transient Random RANDOM = new Random();    
    
    protected String displayFormat;
    protected String showButtonPanel;
    protected String changeMonth;
    protected String changeYear;
    protected String buttonImage;
   
    public DatePicker(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    public void evaluateParams() {
        super.evaluateParams();

        if(displayFormat != null)
            addParameter("displayFormat", findString(displayFormat));
        if(buttonImage != null)
            addParameter("buttonImage", findString(buttonImage));

        if(disabled != null)
            addParameter("disabled", findValue(disabled, Boolean.class));
        if(showButtonPanel != null)
            addParameter("showButtonPanel", findValue(showButtonPanel, Boolean.class));
        if(changeMonth != null)
            addParameter("changeMonth", findValue(changeMonth, Boolean.class));
        if(changeYear != null)
            addParameter("changeYear", findValue(changeYear, Boolean.class));
        if(value != null) 
            addParameter("value", format(findValue(value)));
        // format the value to RFC 3399
        if(parameters.containsKey("value")) {
            addParameter("nameValue", parameters.get("value")); 
        } else {
            if(parameters.containsKey("name")) {
                addParameter("nameValue", format(findValue((String)parameters.get("name")))); 
            }
        }
        
        if ((this.id == null || this.id.length() == 0)) {
            // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs 
            // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
            int nextInt = RANDOM.nextInt();
            nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);  
            this.id = "widget_" + String.valueOf(nextInt);
            addParameter("id", this.id);
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
    
    
    @StrutsTagAttribute(description="A pattern used for the visual display of the formatted date, e.g. yy-mm-dd , dd.mm.yy", defaultValue="yy-mm-dd")
    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }

    
    @StrutsTagAttribute(description="Preset the value of input element")
    public void setValue(String arg0) {
        super.setValue(arg0);
    }
    
    @StrutsTagAttribute(description="Show button panel in the calender. true or false", defaultValue="false", type="Boolean")
	public void setShowButtonPanel(String showButtonPanel) {
		this.showButtonPanel = showButtonPanel;
	}

    @StrutsTagAttribute(description="Show select box for change months. true or false", defaultValue="false", type="Boolean")
	public void setChangeMonth(String changeMonth) {
		this.changeMonth = changeMonth;
	}

    @StrutsTagAttribute(description="Show select box for change years. true or false", defaultValue="false", type="Boolean")
	public void setChangeYear(String changeYear) {
		this.changeYear = changeYear;
	}
  
    @StrutsTagAttribute(description="Path to image for calender button. e.g. images/calendar.gif")
	public void setButtonImage(String buttonImage) {
		this.buttonImage = buttonImage;
	}

    private String format(Object obj) {
        if(obj == null)
            return null;

        if(obj instanceof Date) {
            return MessageFormat.format(RFC3339_PATTERN, (Date) obj);
        } else if(obj instanceof Calendar) {
            return MessageFormat.format(RFC3339_PATTERN, ((Calendar) obj).getTime());
        }
        else {
            // try to parse a date
            String dateStr = obj.toString();
            Calendar c = Calendar.getInstance();
            if(dateStr.equalsIgnoreCase("today"))
            {
            	c.roll(Calendar.DAY_OF_YEAR, -1);
                return MessageFormat.format(RFC3339_PATTERN, c.getTime());
            }
            else if (dateStr.equalsIgnoreCase("yesterday")) { 
                return MessageFormat.format(RFC3339_PATTERN, c.getTime());
            }
            else if (dateStr.equalsIgnoreCase("tomorrow")) { 
            	c.roll(Calendar.DAY_OF_YEAR, 1);
                return MessageFormat.format(RFC3339_PATTERN, c.getTime());
            }
            
            java.util.Date date = null;
            //formats used to parse the date
            List<DateFormat> formats = new ArrayList<DateFormat>();
            formats.add(new SimpleDateFormat(RFC3339_FORMAT));
            formats.add(SimpleDateFormat.getDateInstance(DateFormat.SHORT));
            formats.add(SimpleDateFormat.getDateInstance(DateFormat.MEDIUM));
            formats.add(SimpleDateFormat.getDateInstance(DateFormat.FULL));
            formats.add(SimpleDateFormat.getDateInstance(DateFormat.LONG));
//            if (this.displayFormat != null) {
//                try {
//                    SimpleDateFormat displayFormat = new SimpleDateFormat(
//                        (String) getParameters().get("displayFormat"));
//                    formats.add(displayFormat);
//                } catch (Exception e) {
//                    // don't use it then (this attribute is used by Dojo, not java code)
//                    LOG.error("Cannot use attribute", e);
//                }
//            }
            
            for (DateFormat format : formats) {
                try {
                    date = format.parse(dateStr);
                    if (date != null)
                        return MessageFormat.format(RFC3339_PATTERN, date);
                } catch (Exception e) {
                    //keep going
                }
            }
            
           // last resource, assume already in correct/default format
           if (LOG.isDebugEnabled())
               LOG.debug("Unable to parse date " + dateStr);
           return dateStr;
        }
    }


}
