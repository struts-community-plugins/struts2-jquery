package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TextfieldTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Textfield textfield = new Textfield(valueStack, null, null);

            textfield.evaluateParams();

            Map<String, Object> parameters = textfield.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "container")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("textfield_"));
                    })
                    .doesNotContainKeys("size", "maxlength", "readonly");

        }

        @Test
        void allSet() {
            Textfield textfield = new Textfield(valueStack, null, null);
            textfield.setId("myId");
            
            textfield.setSize("200");
            textfield.setMaxlength("150");
            textfield.setReadonly("false");

            textfield.evaluateParams();

            Map<String, Object> parameters = textfield.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "container")
                    .containsEntry("id", "myId")
                    .containsEntry("size", "200")
                    .containsEntry("maxlength", "150")
                    .containsEntry("readonly", false);
        }
    }
}
