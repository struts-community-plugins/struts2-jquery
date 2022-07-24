package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TabTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Tab tab = new Tab(valueStack, null, null);

            tab.evaluateParams();

            Map<String, Object> parameters = tab.getParameters();

            assertThat(parameters)
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("tab_"));
                    })
                    .doesNotContainKeys("parentTabbedPanel", "target", "closable");

        }

        @Test
        void allSet() {
            Tab tab = new Tab(valueStack, null, null);
            tab.setId("myId");
            
            tab.setClosable("false");
            tab.setTarget("targetDiv");

            tab.evaluateParams();

            Map<String, Object> parameters = tab.getParameters();

            assertThat(parameters)
                    .containsEntry("id", "myId")
                    .containsEntry("target", "targetDiv")
                    .containsEntry("closable", false);
        }
    }
}
