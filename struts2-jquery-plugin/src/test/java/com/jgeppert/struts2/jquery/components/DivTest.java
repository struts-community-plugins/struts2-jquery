package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DivTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Div div = new Div(valueStack, null, null);

            div.evaluateParams();

            Map<String, Object> parameters = div.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "container")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("div_"));
                    })
                    .doesNotContainKeys("updateFreq", "delay");

        }

        @Test
        void allSet() {
            Div div = new Div(valueStack, null, null);
            div.setId("myId");
            div.setUpdateFreq("300");
            div.setDelay("60");

            div.evaluateParams();

            Map<String, Object> parameters = div.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "container")
                    .containsEntry("id", "myId")
                    .containsEntry("updateFreq", 300)
                    .containsEntry("delay", 60);
        }
    }
}
