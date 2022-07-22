package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DatePickerTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            DatePicker datePicker = new DatePicker(valueStack, null, null);

            datePicker.evaluateParams();

            Map<String, Object> parameters = datePicker.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "datepicker")
                    .containsEntry("parentTheme", "simple")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("datepicker_"));
                    })
                    .doesNotContainKeys("displayFormat", "buttonImage", "showButtonPanel", "changeMonth", "changeYear",
                            "appendText", "buttonImageOnly", "buttonText", "duration", "firstDay", "numberOfMonths",
                            "showAnim", "showOn", "showOptions", "yearRange", "zindex", "inline",
                            "onBeforeShowDayTopics", "onChangeMonthYearTopics", "size", "maxlength", "readonly",
                            "timepicker", "timepickerOnly", "timepickerAmPm", "timepickerShowHour",
                            "timepickerShowMinute", "timepickerShowSecond", "timepickerStepHour",
                            "timepickerStepMinute", "timepickerStepSecond", "timepickerFormat", "timepickerSeparator",
                            "timepickerCurrentText", "timepickerGridHour", "timepickerGridMinute",
                            "timepickerGridSecond", "minDayValue", "minMonthValue", "minYearValue", "minHourValue",
                            "minMinuteValue", "minSecondValue", "minDate", "maxDayValue", "maxMonthValue",
                            "maxYearValue", "maxHourValue", "maxMinuteValue", "maxSecondValue", "maxDate", "dayValue",
                            "monthValue", "yearValue", "hourValue", "minuteValue", "secondValue");

        }

        @Test
        void allSet() {
            DatePicker datePicker = new DatePicker(valueStack, null, null);
            datePicker.setId("myId");
            datePicker.setParentTheme("vader");
            datePicker.setDisplayFormat("yyyy-mm-dd");
            datePicker.setButtonImage("calendar.gif");
            datePicker.setShowButtonPanel("true");
            datePicker.setChangeMonth("true");
            datePicker.setChangeYear("true");
            datePicker.setAppendText("(yyyy-mm-dd)");
            datePicker.setButtonImageOnly("false");
            datePicker.setButtonText("Pick");
            datePicker.setDuration("slow");
            datePicker.setFirstDay("1");
            datePicker.setNumberOfMonths("3");
            datePicker.setShowAnim("fold");
            datePicker.setShowOn("both");
            datePicker.setShowOptions("{ direction: \"up\" }");
            datePicker.setYearRange("1900:2000");
            datePicker.setZindex("1000");
            datePicker.setOnBeforeShowDayTopics("theOnBeforeShowDayTopic");
            datePicker.setOnChangeMonthYearTopics("theOnChangeMonthYearTopic");
            datePicker.setSize("150");
            datePicker.setMaxlength("50");
            datePicker.setReadonly("false");
            datePicker.setInline("true");
            datePicker.setTimepicker("true");
            datePicker.setTimepickerOnly("false");
            datePicker.setTimepickerAmPm("false");
            datePicker.setTimepickerShowHour("true");
            datePicker.setTimepickerShowMinute("true");
            datePicker.setTimepickerShowSecond("true");
            datePicker.setTimepickerStepHour("1");
            datePicker.setTimepickerStepMinute("1");
            datePicker.setTimepickerStepSecond("1");
            datePicker.setTimepickerFormat("HH:mm:ss");
            datePicker.setTimepickerSeparator(":");
            datePicker.setTimepickerCurrentText("the current text");
            datePicker.setTimepickerGridHour("10");
            datePicker.setTimepickerGridMinute("12");
            datePicker.setTimepickerGridSecond("30");
            datePicker.setMinDate("1900-01-12T10:20:34");
            datePicker.setMaxDate("2020-12-31T14:25:17");
            datePicker.setValue("1900-01-12T10:20:34");

            datePicker.evaluateParams();

            Map<String, Object> parameters = datePicker.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "datepicker")
                    .containsEntry("id", "myId")
                    .containsEntry("parentTheme", "vader")
                    .containsEntry("displayFormat", "yyyy-mm-dd")
                    .containsEntry("buttonImage", "calendar.gif")
                    .containsEntry("showButtonPanel", true)
                    .containsEntry("changeMonth", true)
                    .containsEntry("changeYear", true)
                    .containsEntry("appendText", "(yyyy-mm-dd)")
                    .containsEntry("buttonImageOnly", false)
                    .containsEntry("buttonText", "Pick")
                    .containsEntry("duration", "slow")
                    .containsEntry("firstDay", "1")
                    .containsEntry("numberOfMonths", "3")
                    .containsEntry("showAnim", "fold")
                    .containsEntry("showOn", "both")
                    .containsEntry("showOptions", "{ direction: \"up\" }")
                    .containsEntry("zindex", "1000")
                    .containsEntry("onBeforeShowDayTopics", "theOnBeforeShowDayTopic")
                    .containsEntry("onChangeMonthYearTopics", "theOnChangeMonthYearTopic")
                    .containsEntry("size", "150")
                    .containsEntry("maxlength", "50")
                    .containsEntry("readonly", false)
                    .containsEntry("inline", true)
                    .containsEntry("timepicker", true)
                    .containsEntry("timepickerOnly", false)
                    .containsEntry("timepickerAmPm", false)
                    .containsEntry("timepickerShowHour", true)
                    .containsEntry("timepickerShowMinute", true)
                    .containsEntry("timepickerShowSecond", true)
                    .containsEntry("timepickerStepHour", 1)
                    .containsEntry("timepickerStepMinute", 1)
                    .containsEntry("timepickerStepSecond", 1)
                    .containsEntry("timepickerFormat", "HH:mm:ss")
                    .containsEntry("timepickerSeparator", ":")
                    .containsEntry("timepickerCurrentText", "the current text")
                    .containsEntry("timepickerGridHour", 10)
                    .containsEntry("timepickerGridMinute", 12)
                    .containsEntry("timepickerGridSecond", 30)
                    .containsEntry("minDate", "1900-01-12T10:20:34")
                    .containsEntry("maxDate", "2020-12-31T14:25:17")
                    .containsEntry("nameValue", "1900-01-12")
                    .containsEntry("dayValue", "12")
                    .containsEntry("monthValue", "0")
                    .containsEntry("yearValue", "1900")
                    .containsEntry("hourValue", "0")
                    .containsEntry("minuteValue", "0")
                    .containsEntry("secondValue", "0");
        }
    }
}
