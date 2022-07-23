package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MenuItemTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            MenuItem menuItem = new MenuItem(valueStack, null, null);

            menuItem.evaluateParams();

            Map<String, Object> parameters = menuItem.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "menuItem")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("menuItem_"));
                    })
                    .doesNotContainKeys("title", "menuIcon", "onClickTopics");

        }

        @Test
        void allSet() {
            MenuItem menuItem = new MenuItem(valueStack, null, null);
            menuItem.setId("myId");

            menuItem.setTitle("menu item title");
            menuItem.setMenuIcon("ui-icon-disk");
            menuItem.setOnClickTopics("theOnClickTopic");

            menuItem.evaluateParams();

            Map<String, Object> parameters = menuItem.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "menuItem")
                    .containsEntry("id", "myId")
                    .containsEntry("title", "menu item title")
                    .containsEntry("menuIcon", "ui-icon-disk")
                    .containsEntry("onClickTopics", "theOnClickTopic");
        }
    }
}
