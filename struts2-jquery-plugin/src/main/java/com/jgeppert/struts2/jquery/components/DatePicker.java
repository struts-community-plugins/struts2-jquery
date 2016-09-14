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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Form;
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
 * <p>
 * Examples
 * </p>
 * 
 * <!-- START SNIPPET: example1 -->
 * 
 * <p>A simple Datepicker</p>
 * 
 * <pre>
 * &lt;sj:datepicker id=&quot;birthday&quot; name=&quot;birthday&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <p>A Datepicker with Button Panel and select boxes to change year and
 * month.</p>
 * 
 * <pre>
 * &lt;sj:datepicker showButtonPanel=&quot;true&quot; changeMonth=&quot;true&quot; changeYear=&quot;true&quot; id=&quot;birthday&quot; name=&quot;birthday&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 -->
 * 
 * <p>A Datepicker with different Display Format.</p>
 * 
 * <pre>
 * &lt;sj:datepicker displayFormat=&quot;dd.mm.yy&quot; id=&quot;birthday&quot; name=&quot;birthday&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example3 -->
 * 
 * 
 * <!-- START SNIPPET: example4 -->
 * 
 * <p>A Datepicker with Timepicker.</p>
 * 
 * <pre>
 * &lt;sj:datepicker id=&quot;time0&quot; label=&quot;Select a Date/Time&quot; timepicker=&quot;true&quot; /&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example4 -->
 * 
 * 
 * <!-- START SNIPPET: example5 -->
 * 
 * <p>A Timepicker.</p>
 * 
 * <pre>
 * &lt;sj:datepicker id=&quot;time1&quot; label=&quot;Select a Time&quot; timepicker=&quot;true&quot; timepickerOnly=&quot;true&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example5 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "datepicker", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.DatePickerTag", description = "Render a jQuery UI datepicker", allowDynamicAttributes = true)
public class DatePicker extends AbstractTopicsBean {

	public static final String JQUERYACTION = "datepicker";
	public static final String TEMPLATE = "datepicker-close";
	public static final String OPEN_TEMPLATE = "datepicker";
	// SimpleDateFormat is not thread-safe see:
	// http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6231579
	// http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6178997
	// solution is to use stateless MessageFormat instead:
	// final private static String RFC3339_FORMAT = "yyyy-MM-dd";
	final private static String RFC3339_FORMAT = "yyyy-MM-dd";
	final private static String RFC3339_PATTERN = "{0,date," + RFC3339_FORMAT
			+ "}";
	final protected static Logger LOG = LoggerFactory
			.getLogger(DatePicker.class);
	final private static transient Random RANDOM = new Random();

	protected String displayFormat;
	protected String showButtonPanel;
	protected String changeMonth;
	protected String changeYear;
	protected String buttonImage;
	protected String appendText;
	protected String buttonImageOnly;
	protected String buttonText;
	protected String duration;
	protected String firstDay;
	protected String numberOfMonths;
	protected String showAnim;
	protected String showOn;
	protected String showOptions;
	protected String yearRange;
	protected String zindex;
	protected String onBeforeShowDayTopics;
	protected String onChangeMonthYearTopics;
	protected String minDate;
	protected String maxDate;
	protected String inline;

	protected String maxlength;
	protected String readonly;
	protected String size;

	protected String parentTheme;

	protected String timepicker;
	protected String timepickerOnly;
	protected String timepickerAmPm;
	protected String timepickerShowHour;
	protected String timepickerShowMinute;
	protected String timepickerShowSecond;
	protected String timepickerStepHour;
	protected String timepickerStepMinute;
	protected String timepickerStepSecond;
	protected String timepickerFormat;
	protected String timepickerSeparator;
	protected String timepickerGridHour;
	protected String timepickerGridMinute;
	protected String timepickerGridSecond;
	protected String timepickerTimeOnlyTitle;
	protected String timepickerTimeText;
	protected String timepickerHourText;
	protected String timepickerMinuteText;
	protected String timepickerSecondText;
	protected String timepickerCurrentText;
	protected String timepickerCloseText;

	public DatePicker(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	public String getDefaultOpenTemplate() {
		return OPEN_TEMPLATE;
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void evaluateParams() {
		super.evaluateParams();
		boolean isInline = false;

		addParameter("jqueryaction", JQUERYACTION);

		addOgnlEvaluatedStringParameterIfExists("displayFormat", displayFormat);
		addOgnlEvaluatedStringParameterIfExists("buttonImage", buttonImage);
		addOgnlEvaluatedObjectParameterIfExists("showButtonPanel", showButtonPanel, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("changeMonth", changeMonth, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("changeYear", changeYear, Boolean.class);
		addOgnlEvaluatedStringParameterIfExists("appendText", appendText);
		addOgnlEvaluatedObjectParameterIfExists("buttonImageOnly", buttonImageOnly, Boolean.class);
		addOgnlEvaluatedStringParameterIfExists("buttonText", buttonText);
		addOgnlEvaluatedStringParameterIfExists("duration", duration);
		addOgnlEvaluatedStringParameterIfExists("firstDay", firstDay);
		addOgnlEvaluatedStringParameterIfExists("numberOfMonths", numberOfMonths);
		addOgnlEvaluatedStringParameterIfExists("showAnim", showAnim);
		addOgnlEvaluatedStringParameterIfExists("showOn", showOn);
		addOgnlEvaluatedStringParameterIfExists("showOptions", showOptions);
		addOgnlEvaluatedStringParameterIfExists("yearRange", yearRange);
		addOgnlEvaluatedStringParameterIfExists("zindex", zindex);

		if (inline != null) {
			isInline = (Boolean) findValue(inline, Boolean.class);
			addParameter("inline", isInline);
		}

		addOgnlEvaluatedStringParameterIfExists("onBeforeShowDayTopics", onBeforeShowDayTopics);
		addOgnlEvaluatedStringParameterIfExists("onChangeMonthYearTopics", onChangeMonthYearTopics);
		addOgnlEvaluatedStringParameterIfExists("size", size);
		addOgnlEvaluatedStringParameterIfExists("maxlength", maxlength);
		addOgnlEvaluatedObjectParameterIfExists("readonly", readonly, Boolean.class);

		Form form = (Form) findAncestor(Form.class);
		if (parentTheme != null) {
			addParameter("parentTheme", findString(parentTheme));
		} else if (form != null) {
			addParameter("parentTheme", form.getTheme());
		} else if (isInline == false) {
			addParameter("parentTheme", "simple");
		}

		addOgnlEvaluatedObjectParameterIfExists("timepicker", timepicker, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerOnly", timepickerOnly, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerAmPm", timepickerAmPm, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerShowHour", timepickerShowHour, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerShowMinute", timepickerShowMinute, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerShowSecond", timepickerShowSecond, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerStepHour", timepickerStepHour, Number.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerStepMinute", timepickerStepMinute, Number.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerStepSecond", timepickerStepSecond, Number.class);
		addOgnlEvaluatedStringParameterIfExists("timepickerFormat", timepickerFormat);
		addOgnlEvaluatedStringParameterIfExists("timepickerSeparator", timepickerSeparator);
		addOgnlEvaluatedStringParameterIfExists("timepickerCurrentText", timepickerCurrentText);
		addOgnlEvaluatedObjectParameterIfExists("timepickerGridHour", timepickerGridHour, Number.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerGridMinute", timepickerGridMinute, Number.class);
		addOgnlEvaluatedObjectParameterIfExists("timepickerGridSecond", timepickerGridSecond, Number.class);

		if ((this.id == null || this.id.length() == 0)) {
			// resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
			// http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
			int nextInt = RANDOM.nextInt();
			nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
					.abs(nextInt);
			this.id = "datepicker_" + String.valueOf(nextInt);
			addParameter("id", this.id);
		}

		Object minDateValue = null;
		if (minDate != null) {
			minDateValue = findValue(minDate, Date.class);
			if (minDateValue == null || minDateValue.equals("ognl.NoConversionPossible")) {
				minDateValue = findString(minDate);
			}

			if (minDateValue != null) {
				if (minDateValue instanceof Date) {
					minDateValue = (Date) minDateValue;
					Calendar minCalendar = new GregorianCalendar();
					minCalendar.setTime((Date) minDateValue);
					addParameter("minDayValue",
							"" + minCalendar.get(Calendar.DAY_OF_MONTH));
					addParameter("minMonthValue",
							"" + minCalendar.get(Calendar.MONTH));
					addParameter("minYearValue",
							"" + minCalendar.get(Calendar.YEAR));
					addParameter("minHourValue",
							"" + minCalendar.get(Calendar.HOUR_OF_DAY));
					addParameter("minMinuteValue",
							"" + minCalendar.get(Calendar.MINUTE));
					addParameter("minSecondValue",
							"" + minCalendar.get(Calendar.SECOND));
				} else {
					addParameter("minDate", findString(minDateValue.toString()));
				}

			}
		}

		Object maxDateValue = null;
		if (maxDate != null) {
			//Is maxDate an Java Date Object?
			maxDateValue = findValue(maxDate, Date.class);
			//Is maxDate an Java String Object?
			if (maxDateValue == null || maxDateValue.equals("ognl.NoConversionPossible")) {
				maxDateValue = findString(maxDate);
			}
			
			if (maxDateValue != null) {
				if (maxDateValue instanceof Date) {
					maxDateValue = (Date) maxDateValue;
					Calendar minCalendar = new GregorianCalendar();
					minCalendar.setTime((Date) maxDateValue);
					addParameter("maxDayValue",
							"" + minCalendar.get(Calendar.DAY_OF_MONTH));
					addParameter("maxMonthValue",
							"" + minCalendar.get(Calendar.MONTH));
					addParameter("maxYearValue",
							"" + minCalendar.get(Calendar.YEAR));
					addParameter("maxHourValue",
							"" + minCalendar.get(Calendar.HOUR_OF_DAY));
					addParameter("maxMinuteValue",
							"" + minCalendar.get(Calendar.MINUTE));
					addParameter("maxSecondValue",
							"" + minCalendar.get(Calendar.SECOND));
				} else {
					addParameter("maxDate", findString(maxDateValue.toString()));
				}

			}
		}

		Object nameValue = null;
		if (value != null) {
			nameValue = findValue(value, Date.class);
			if (nameValue == null || nameValue.equals("ognl.NoConversionPossible"))
				nameValue = findString(value);
		} else {
			if (name != null) {
				nameValue = findValue(name, Date.class);
				if (nameValue == null || nameValue.equals("ognl.NoConversionPossible"))
					nameValue = findString(name);
			}
		}

		Date dateValue = null;
		String formatValue = null;
		if (nameValue != null) {
			if (nameValue instanceof Date) {
				dateValue = (Date) nameValue;
			} else {
				formatValue = format(nameValue);
			}

			if (formatValue != null) {
				try {
					dateValue = new SimpleDateFormat(RFC3339_FORMAT)
							.parse(formatValue);
				} catch (ParseException pe) {
					dateValue = null;
					formatValue = null;
				}
			}

			if (formatValue != null)
				addParameter("nameValue", formatValue);

			if (dateValue != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(dateValue);
				addParameter("dayValue",
						"" + calendar.get(Calendar.DAY_OF_MONTH));
				addParameter("monthValue", "" + calendar.get(Calendar.MONTH));
				addParameter("yearValue", "" + calendar.get(Calendar.YEAR));
				addParameter("hourValue", "" + calendar.get(Calendar.HOUR_OF_DAY));
				addParameter("minuteValue", "" + calendar.get(Calendar.MINUTE));
				addParameter("secondValue", "" + calendar.get(Calendar.SECOND));
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

	@StrutsTagAttribute(description = "A pattern used for the visual display of the formatted date, e.g. yy-mm-dd , dd.mm.yy", defaultValue = "yy-mm-dd")
	public void setDisplayFormat(String displayFormat) {
		this.displayFormat = displayFormat;
	}

	@StrutsTagAttribute(description = "Preset the value of input element")
	public void setValue(String value) {
		super.setValue(value);
	}

	@StrutsTagAttribute(description = "Show button panel in the calender. true or false", defaultValue = "false", type = "Boolean")
	public void setShowButtonPanel(String showButtonPanel) {
		this.showButtonPanel = showButtonPanel;
	}

	@StrutsTagAttribute(description = "Show select box for change months. true or false", defaultValue = "false", type = "Boolean")
	public void setChangeMonth(String changeMonth) {
		this.changeMonth = changeMonth;
	}

	@StrutsTagAttribute(description = "Show select box for change years. true or false", defaultValue = "false", type = "Boolean")
	public void setChangeYear(String changeYear) {
		this.changeYear = changeYear;
	}

	@StrutsTagAttribute(description = "Path to image for calender button. e.g. images/calendar.gif")
	public void setButtonImage(String buttonImage) {
		this.buttonImage = buttonImage;
	}

	@StrutsTagAttribute(description = "The text to display after each date field, e.g. to show the required format. Default: ''")
	public void setAppendText(String appendText) {
		this.appendText = appendText;
	}

	@StrutsTagAttribute(description = "Set to true to place an image after the field to use as the trigger without it appearing on a button. Default: false", defaultValue = "false", type = "Boolean")
	public void setButtonImageOnly(String buttonImageOnly) {
		this.buttonImageOnly = buttonImageOnly;
	}

	@StrutsTagAttribute(description = "The text to display on the trigger button. Use in conjunction with showOn equal to 'button' or 'both'. Default: '...'")
	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	@StrutsTagAttribute(description = "Control the speed at which the datepicker appears, it may be a time in milliseconds, a string representing one of the three predefined speeds ('slow', 'normal', 'fast'). Default: 'normal'")
	public void setDuration(String duration) {
		this.duration = duration;
	}

	@StrutsTagAttribute(description = "Set the first day of the week: Sunday is 0, Monday is 1, ... . Default: 0")
	public void setFirstDay(String firstDay) {
		this.firstDay = firstDay;
	}

	@StrutsTagAttribute(description = "Set how many months to show at once. The value can be a straight integer, or can be a two-element array to define the number of rows and columns to display. e.g. 3 or an array like [2, 3]. Default: 1")
	public void setNumberOfMonths(String numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	@StrutsTagAttribute(description = "Set the name of the animation used to show/hide the datepicker. Use 'show' (the default), 'slideDown', 'fadeIn', or any of the show/hide jQuery UI effects. Default: 'show'")
	public void setShowAnim(String showAnim) {
		this.showAnim = showAnim;
	}

	@StrutsTagAttribute(description = "Have the datepicker appear automatically when the field receives focus ('focus'), appear only when a button is clicked ('button'), or appear when either event takes place ('both'). Default: 'both'")
	public void setShowOn(String showOn) {
		this.showOn = showOn;
	}

	@StrutsTagAttribute(description = "If using one of the jQuery UI effects for showAnim, you can provide additional settings for that animation via this option. e.g. {direction: 'up' }. Default: '-10:+10'")
	public void setShowOptions(String showOptions) {
		this.showOptions = showOptions;
	}

	@StrutsTagAttribute(description = "Control the range of years displayed in the year drop-down: either relative to current year (-nn:+nn) or absolute (nnnn:nnnn). Default: '-10:+10'")
	public void setYearRange(String yearRange) {
		this.yearRange = yearRange;
	}

	@StrutsTagAttribute(description = "The z-index for the datepicker, usefull when run in a dialog e.g. 2006.")
	public void setZindex(String zindex) {
		this.zindex = zindex;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published for each day in the datepicker before is it displayed.")
	public void setOnBeforeShowDayTopics(String onBeforeShowDayTopics) {
		this.onBeforeShowDayTopics = onBeforeShowDayTopics;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published when the datepicker moves to a new month and/or year. The function receives the selected year, month (1-12), and the datepicker instance as parameters. this refers to the associated input field.")
	public void setOnChangeMonthYearTopics(String onChangeMonthYearTopics) {
		this.onChangeMonthYearTopics = onChangeMonthYearTopics;
	}

	@StrutsTagAttribute(description = "Set a minimum selectable date via a number of days from today (e.g. +7) or a string of values and periods ('y' for years, 'm' for months, 'w' for weeks, 'd' for days, e.g. '-1y -1m'). Can also be a Java Date Object.")
	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}

	@StrutsTagAttribute(description = "Set a maximum selectable date via a number of days from today (e.g. +7) or a string of values and periods ('y' for years, 'm' for months, 'w' for weeks, 'd' for days, e.g. '+1m +1w'). Can also be a Java Date Object.")
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	@StrutsTagAttribute(description = "Display the Datepicker inline. Default: false", defaultValue = "false", type = "Boolean")
	public void setInline(String inline) {
		this.inline = inline;
	}

	@StrutsTagAttribute(description = "HTML maxlength attribute", type = "Integer")
	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	@StrutsTagAttribute(description = "Whether the input is readonly", type = "Boolean", defaultValue = "false")
	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	@StrutsTagAttribute(description = "HTML size attribute", type = "Integer")
	public void setSize(String size) {
		this.size = size;
	}

	@StrutsTagAttribute(description = "The parent theme. Default: value of parent form tag or simple if no parent form tag is available")
	public void setParentTheme(String parentTheme) {
		this.parentTheme = parentTheme;
	}

	private String format(Object obj) {
		if (obj == null)
			return null;

		if (obj instanceof Date) {
			return MessageFormat.format(RFC3339_PATTERN, (Date) obj);
		} else if (obj instanceof Calendar) {
			return MessageFormat.format(RFC3339_PATTERN,
					((Calendar) obj).getTime());
		} else {
			// try to parse a date
			String dateStr = obj.toString();
			Calendar c = Calendar.getInstance();
			if (dateStr.equalsIgnoreCase("today")) {
				return MessageFormat.format(RFC3339_PATTERN, c.getTime());
			} else if (dateStr.equalsIgnoreCase("yesterday")) {
				c.roll(Calendar.DAY_OF_YEAR, -1);
				return MessageFormat.format(RFC3339_PATTERN, c.getTime());
			} else if (dateStr.equalsIgnoreCase("tomorrow")) {
				c.roll(Calendar.DAY_OF_YEAR, 1);
				return MessageFormat.format(RFC3339_PATTERN, c.getTime());
			}

			Date date = null;
			// formats used to parse the date
			List<DateFormat> formats = new ArrayList<DateFormat>();
			formats.add(new SimpleDateFormat(RFC3339_FORMAT));
			formats.add(SimpleDateFormat.getDateInstance(DateFormat.SHORT));
			formats.add(SimpleDateFormat.getDateInstance(DateFormat.MEDIUM));
			formats.add(SimpleDateFormat.getDateInstance(DateFormat.FULL));
			formats.add(SimpleDateFormat.getDateInstance(DateFormat.LONG));
			if (this.displayFormat != null) {
				try {
					String df = (String) getParameters().get("displayFormat");
					SimpleDateFormat displayFormat = new SimpleDateFormat(df);
					formats.add(displayFormat);

					// jQuery dateFormat is incompatiple with JavaFormat
					String dfr = df.replaceAll("([y]{2})", "yyyy");
					SimpleDateFormat displayFormatReplaced = new SimpleDateFormat(
							dfr);
					formats.add(displayFormatReplaced);
				} catch (Exception e) {
					// don't use it then (this attribute is used by Dojo, not
					// java code)
					LOG.error("Cannot use attribute", e);
				}
			}

			for (DateFormat format : formats) {
				try {
					date = format.parse(dateStr);
					if (date != null) {
						return MessageFormat.format(RFC3339_PATTERN, date);
					}
				} catch (Exception e) {
				}
			}

			// last resource, assume already in correct/default format
			if (LOG.isDebugEnabled())
				LOG.debug("Unable to parse date " + dateStr);
			return dateStr;
		}
	}

	@StrutsTagAttribute(description = "Add Timepicker to the current Datepicker instance", type = "Boolean", defaultValue = "false")
	public void setTimepicker(String timepicker) {
		this.timepicker = timepicker;
	}

	@StrutsTagAttribute(description = "Show only the Timepicker", type = "Boolean", defaultValue = "false")
	public void setTimepickerOnly(String timepickerOnly) {
		this.timepickerOnly = timepickerOnly;
	}

	@StrutsTagAttribute(description = "Show time in AM/PM 12 hour format", type = "Boolean", defaultValue = "false")
	public void setTimepickerAmPm(String timepickerAmPm) {
		this.timepickerAmPm = timepickerAmPm;
	}

	@StrutsTagAttribute(description = "Show the hour", type = "Boolean", defaultValue = "true")
	public void setTimepickerShowHour(String timepickerShowHour) {
		this.timepickerShowHour = timepickerShowHour;
	}

	@StrutsTagAttribute(description = "Show the minute", type = "Boolean", defaultValue = "true")
	public void setTimepickerShowMinute(String timepickerShowMinute) {
		this.timepickerShowMinute = timepickerShowMinute;
	}

	@StrutsTagAttribute(description = "Show the second", type = "Boolean", defaultValue = "false")
	public void setTimepickerShowSecond(String timepickerShowSecond) {
		this.timepickerShowSecond = timepickerShowSecond;
	}

	@StrutsTagAttribute(description = "Hour steps. e.g. 2", type = "Integer")
	public void setTimepickerStepHour(String timepickerStepHour) {
		this.timepickerStepHour = timepickerStepHour;
	}

	@StrutsTagAttribute(description = "Minute steps. e.g. 15 for 15, 30, 45 steps", type = "Integer")
	public void setTimepickerStepMinute(String timepickerStepMinute) {
		this.timepickerStepMinute = timepickerStepMinute;
	}

	@StrutsTagAttribute(description = "Second steps", type = "Integer")
	public void setTimepickerStepSecond(String timepickerStepSecond) {
		this.timepickerStepSecond = timepickerStepSecond;
	}

	@StrutsTagAttribute(description = "Time Format. e.g. hh:mm tt or h:m", defaultValue = "hh:mm tt")
	public void setTimepickerFormat(String timepickerFormat) {
		this.timepickerFormat = timepickerFormat;
	}

	@StrutsTagAttribute(description = "Place holder between date and time.", defaultValue = "SPACE")
	public void setTimepickerSeparator(String timepickerSeparator) {
		this.timepickerSeparator = timepickerSeparator;
	}

	@StrutsTagAttribute(description = "To show numbered grids under the hour slider.", type = "Integer")
	public void setTimepickerGridHour(String timepickerGridHour) {
		this.timepickerGridHour = timepickerGridHour;
	}

	@StrutsTagAttribute(description = "To show numbered grids under the minute slider.", type = "Integer")
	public void setTimepickerGridMinute(String timepickerGridMinute) {
		this.timepickerGridMinute = timepickerGridMinute;
	}

	@StrutsTagAttribute(description = "To show numbered grids under the second slider.", type = "Integer")
	public void setTimepickerGridSecond(String timepickerGridSecond) {
		this.timepickerGridSecond = timepickerGridSecond;
	}

	@StrutsTagAttribute(description = "Localization", defaultValue = "Choose Time")
	public void setTimepickerTimeOnlyTitle(String timepickerTimeOnlyTitle) {
		this.timepickerTimeOnlyTitle = timepickerTimeOnlyTitle;
	}

	@StrutsTagAttribute(description = "Localization", defaultValue = "Time")
	public void setTimepickerTimeText(String timepickerTimeText) {
		this.timepickerTimeText = timepickerTimeText;
	}

	@StrutsTagAttribute(description = "Localization", defaultValue = "Hour")
	public void setTimepickerHourText(String timepickerHourText) {
		this.timepickerHourText = timepickerHourText;
	}

	@StrutsTagAttribute(description = "Localization", defaultValue = "Minute")
	public void setTimepickerMinuteText(String timepickerMinuteText) {
		this.timepickerMinuteText = timepickerMinuteText;
	}

	@StrutsTagAttribute(description = "Localization", defaultValue = "Second")
	public void setTimepickerSecondText(String timepickerSecondText) {
		this.timepickerSecondText = timepickerSecondText;
	}

	@StrutsTagAttribute(description = "Localization", defaultValue = "Now")
	public void setTimepickerCurrentText(String timepickerCurrentText) {
		this.timepickerCurrentText = timepickerCurrentText;
	}

	@StrutsTagAttribute(description = "Localization", defaultValue = "Done")
	public void setTimepickerCloseText(String timepickerCloseText) {
		this.timepickerCloseText = timepickerCloseText;
	}

}
