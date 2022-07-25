package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AccordionTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Accordion accordion = new Accordion(valueStack, null, null);

            accordion.evaluateParams();

            Map<String, Object> parameters = accordion.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "accordion")
                    .doesNotContainKeys("active", "animate", "heightStyle", "collapsible", "header", "openOnMouseover",
                            "href", "paramKeys", "paramValues", "onCreateTopics");

        }

        @Test
        void allSet() {
            Accordion accordion = new Accordion(valueStack, null, null);
            accordion.setActive("2");
            accordion.setAnimate("200");
            accordion.setHeightStyle("content");
            accordion.setCollapsible("true");
            accordion.setHeader("h3");
            accordion.setOpenOnMouseover("true");
            accordion.setHref("/some/href");
            accordion.setParamKeys("dataKey");
            accordion.setParamValues("dataValue1,dataValue2");
            accordion.setOnCreateTopics("theOnCreateTopic");

            accordion.evaluateParams();

            Map<String, Object> parameters = accordion.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "accordion")
                    .containsEntry("active", "2")
                    .containsEntry("animate", "200")
                    .containsEntry("heightStyle", "content")
                    .containsEntry("collapsible", true)
                    .containsEntry("header", "h3")
                    .containsEntry("openOnMouseover", true)
                    .containsEntry("href", "/some/href")
                    .containsEntry("paramKeys", "dataKey")
                    .containsEntry("paramValues", "dataValue1,dataValue2")
                    .containsEntry("onCreateTopics", "theOnCreateTopic");
        }
    }

}
