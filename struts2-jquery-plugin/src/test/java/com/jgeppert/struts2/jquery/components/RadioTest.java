package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RadioTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Radio radio = new Radio(valueStack, null, null);

            radio.evaluateParams();

            Map<String, Object> parameters = radio.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "buttonset")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("radio_"));
                    })
                    .doesNotContainKeys("buttonset", "icon", "direction");

        }

        @Test
        void allSet() {
            Radio radio = new Radio(valueStack, null, null);
            radio.setId("myId");

            radio.setButtonset("true");
            radio.setIcon("true");
            radio.setDirection("horizontal");
            
            radio.evaluateParams();

            Map<String, Object> parameters = radio.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "buttonset")
                    .containsEntry("id", "myId")
                    .containsEntry("buttonset", true)
                    .containsEntry("icon", true)
                    .containsEntry("direction", "horizontal");
        }
    }
}
