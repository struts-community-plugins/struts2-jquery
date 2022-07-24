package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TextareaTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Textarea textarea = new Textarea(valueStack, null, null);

            textarea.evaluateParams();

            Map<String, Object> parameters = textarea.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "container")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("textarea_"));
                    })
                    .doesNotContainKeys("readonly", "cols", "rows", "wrap");

        }

        @Test
        void allSet() {
            Textarea textarea = new Textarea(valueStack, null, null);
            textarea.setId("myId");

            textarea.setReadonly("false");
            textarea.setCols("150");
            textarea.setRows("10");
            textarea.setWrap("hard");

            textarea.evaluateParams();

            Map<String, Object> parameters = textarea.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "container")
                    .containsEntry("id", "myId")
                    .containsEntry("readonly", false)
                    .containsEntry("cols", "150")
                    .containsEntry("rows", "10")
                    .containsEntry("wrap", "hard");
        }
    }
}
