package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MenuTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Menu menu = new Menu(valueStack, null, null);

            menu.evaluateParams();

            Map<String, Object> parameters = menu.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "menu")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("menu_"));
                    })
                    .doesNotContainKeys("disabled", "targets", "href", "paramName", "subMenu", "parentMenu");

        }

        @Test
        void allSet() {
            Menu menu = new Menu(valueStack, null, null);
            menu.setId("myId");

            menu.setDisabled("true");
            menu.setTargets("myTarget");
            menu.setHref("https://www.google.com");
            menu.setParamName("theParam");
            
            menu.evaluateParams();

            Map<String, Object> parameters = menu.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "menu")
                    .containsEntry("id", "myId")
                    .containsEntry("disabled", true)
                    .containsEntry("targets", "myTarget")
                    .containsEntry("href", "https://www.google.com")
                    .containsEntry("paramName", "theParam");
        }
    }
}
