package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SelectTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Select select = new Select(valueStack, null, null);

            select.evaluateParams();

            Map<String, Object> parameters = select.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "select")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("select_"));
                    })
                    .doesNotContainKeys("emptyOption", "headerKey", "headerValue", "listTitle", "size", "multiple",
                            "autocomplete", "selectBoxIcon", "loadMinimumCount", "onSelectTopics");

        }

        @Test
        void allSet() {
            Select select = new Select(valueStack, null, null);
            select.setId("myId");

            select.setEmptyOption("true");
            select.setHeaderKey("theHeaderKey");
            select.setHeaderValue("theHeaderValue");
            select.setListTitle("the list title");
            select.setSize("150");
            select.setMultiple("false");
            select.setAutocomplete("false");
            select.setSelectBoxIcon("false");
            select.setLoadMinimumCount("3");
            select.setOnSelectTopics("theOnSelectTopic");

            select.evaluateParams();

            Map<String, Object> parameters = select.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "select")
                    .containsEntry("id", "myId")
                    .containsEntry("emptyOption", true)
                    .containsEntry("headerKey", "theHeaderKey")
                    .containsEntry("headerValue", "theHeaderValue")
                    .containsEntry("listTitle", "the list title")
                    .containsEntry("size", "150")
                    .containsEntry("multiple", false)
                    .containsEntry("autocomplete", false)
                    .containsEntry("selectBoxIcon", false)
                    .containsEntry("loadMinimumCount", 3)
                    .containsEntry("onSelectTopics", "theOnSelectTopic");
        }
    }
}
