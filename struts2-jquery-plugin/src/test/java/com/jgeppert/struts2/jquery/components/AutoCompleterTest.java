package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AutoCompleterTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Autocompleter autocompleter = new Autocompleter(valueStack, null, null);

            autocompleter.evaluateParams();

            Map<String, Object> parameters = autocompleter.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "autocompleter")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("autocompleter_"));
                    })
                    .doesNotContainKeys("delay", "loadMinimumCount", "size", "maxlength", "selectBox", "selectBoxIcon",
                            "readonly", "multiple", "onSelectTopics", "onFocusTopics", "onSearchTopics", "listLabel",
                            "forceValidOption", "autoFocus", "widgetname", "valueWidget");

        }

        @Test
        void allSet() {
            Autocompleter autocompleter = new Autocompleter(valueStack, null, null);
            autocompleter.setId("myId");
            autocompleter.setDelay("500");
            autocompleter.setLoadMinimumCount("5");
            autocompleter.setSize("50");
            autocompleter.setMaxlength("50");
            autocompleter.setSelectBox("true");
            autocompleter.setSelectBoxIcon("true");
            autocompleter.setReadonly("true");
            autocompleter.setMultiple("false");
            autocompleter.setOnSelectTopics("theOnSelectTopic");
            autocompleter.setOnFocusTopics("theOnFocusTopic");
            autocompleter.setOnSearchTopics("theOnSearchTopic");
            autocompleter.setForceValidOption("true");
            autocompleter.setAutoFocus("false");
            autocompleter.setName("theName");
            autocompleter.setValueWidget("theValue");
            autocompleter.setListLabel("the label for the list");

            autocompleter.evaluateParams();

            Map<String, Object> parameters = autocompleter.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "autocompleter")
                    .containsEntry("id", "myId_widget")
                    .containsEntry("delay", 500)
                    .containsEntry("loadMinimumCount", 5)
                    .containsEntry("size", "50")
                    .containsEntry("maxlength", "50")
                    .containsEntry("selectBox", true)
                    .containsEntry("selectBoxIcon", true)
                    .containsEntry("readonly", true)
                    .containsEntry("multiple", false)
                    .containsEntry("onSelectTopics", "theOnSelectTopic")
                    .containsEntry("onFocusTopics", "theOnFocusTopic")
                    .containsEntry("onSearchTopics", "theOnSearchTopic")
                    .containsEntry("listLabel", "the label for the list")
                    .containsEntry("forceValidOption", true)
                    .containsEntry("autoFocus", false)
                    .containsEntry("widgetid", "myId")
                    .containsEntry("name", "theName_widget")
                    .containsEntry("widgetname", "theName")
                    .containsEntry("valueWidget", "theValue");
        }
    }
}
