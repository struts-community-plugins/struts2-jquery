package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TabbedPanelTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            TabbedPanel tabbedPanel = new TabbedPanel(valueStack, null, null);

            tabbedPanel.evaluateParams();

            Map<String, Object> parameters = tabbedPanel.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "tabbedpanel")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("tabbedpanel_"));
                    })
                    .doesNotContainKeys("selectedTab", "useSelectedTabCookie", "openOnMouseover", "collapsible", "show",
                            "hide", "cache", "disabledTabs", "onLoadTopics", "onActivateTopics",
                            "onBeforeActivateTopics", "sortable", "heightStyle");

        }

        @Test
        void allSet() {
            TabbedPanel tabbedPanel = new TabbedPanel(valueStack, null, null);
            tabbedPanel.setId("myId");

            tabbedPanel.setSelectedTab("1");
            tabbedPanel.setUseSelectedTabCookie("true");
            tabbedPanel.setOpenOnMouseover("true");
            tabbedPanel.setCollapsible("true");
            tabbedPanel.setShow("true");
            tabbedPanel.setHide("true");
            tabbedPanel.setCache("false");
            tabbedPanel.setDisabledTabs("[0,2]");
            tabbedPanel.setOnLoadTopics("theOnLoadTopic");
            tabbedPanel.setOnActivateTopics("theOnActivateTopic");
            tabbedPanel.setOnBeforeActivateTopics("theOnBeforeActivateTopic");
            tabbedPanel.setSortable("true");
            tabbedPanel.setHeightStyle("fill");

            tabbedPanel.evaluateParams();

            Map<String, Object> parameters = tabbedPanel.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "tabbedpanel")
                    .containsEntry("id", "myId")
                    .containsEntry("selectedTab", 1)
                    .containsEntry("useSelectedTabCookie", true)
                    .containsEntry("openOnMouseover", true)
                    .containsEntry("collapsible", true)
                    .containsEntry("show", "true")
                    .containsEntry("hide", "true")
                    .containsEntry("cache", false)
                    .containsEntry("disabledTabs", "[0,2]")
                    .containsEntry("onLoadTopics", "theOnLoadTopic")
                    .containsEntry("onActivateTopics", "theOnActivateTopic")
                    .containsEntry("onBeforeActivateTopics", "theOnBeforeActivateTopic")
                    .containsEntry("sortable", true)
                    .containsEntry("heightStyle", "fill");
        }
    }
}
