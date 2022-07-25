package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ProgressbarTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Progressbar progressbar = new Progressbar(valueStack, null, null);

            progressbar.evaluateParams();

            Map<String, Object> parameters = progressbar.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "progressbar")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("progressbar_"));
                    })
                    .doesNotContainKeys("value");

        }

        @Test
        void allSet() {
            Progressbar progressbar = new Progressbar(valueStack, null, null);
            progressbar.setId("myId");

            progressbar.setValue("75");
            
            progressbar.evaluateParams();

            Map<String, Object> parameters = progressbar.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "progressbar")
                    .containsEntry("id", "myId")
                    .containsEntry("value", "75");
        }
    }
}
