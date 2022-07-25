package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SpinnerTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Spinner spinner = new Spinner(valueStack, null, null);

            spinner.evaluateParams();

            Map<String, Object> parameters = spinner.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "spinner")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("spinner_"));
                    })
                    .doesNotContainKeys("max", "min", "step", "mouseWheel", "culture", "numberFormat", "page",
                            "incremental");

        }

        @Test
        void allSet() {
            Spinner spinner = new Spinner(valueStack, null, null);
            spinner.setId("myId");
            
            spinner.setMax("50");
            spinner.setMin("0");
            spinner.setStep("2");
            spinner.setMouseWheel("true");
            spinner.setCulture("fr");
            spinner.setNumberFormat("n");
            spinner.setPage("5");
            spinner.setIncremental("false");
            
            spinner.evaluateParams();

            Map<String, Object> parameters = spinner.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "spinner")
                    .containsEntry("id", "myId")
                    .containsEntry("max", 50)
                    .containsEntry("min", 0)
                    .containsEntry("step", 2)
                    .containsEntry("mouseWheel", true)
                    .containsEntry("culture", "fr")
                    .containsEntry("numberFormat", "n")
                    .containsEntry("page", 5)
                    .containsEntry("incremental", "false");
        }
    }
}
