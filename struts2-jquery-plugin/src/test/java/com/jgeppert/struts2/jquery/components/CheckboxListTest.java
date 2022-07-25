package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CheckboxListTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            CheckboxList checkboxList = new CheckboxList(valueStack, null, null);

            checkboxList.evaluateParams();

            Map<String, Object> parameters = checkboxList.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "buttonset")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("checkbox_"));
                    })
                    .doesNotContainKeys("buttonset", "icon", "direction");

        }

        @Test
        void allSet() {
            CheckboxList checkboxList = new CheckboxList(valueStack, null, null);
            checkboxList.setId("myId");

            checkboxList.setButtonset("true");
            checkboxList.setIcon("true");
            checkboxList.setDirection("horizontal");

            checkboxList.evaluateParams();

            Map<String, Object> parameters = checkboxList.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "buttonset")
                    .containsEntry("id", "myId")
                    .containsEntry("buttonset", true)
                    .containsEntry("icon", true)
                    .containsEntry("direction", "horizontal");
        }
    }
}
