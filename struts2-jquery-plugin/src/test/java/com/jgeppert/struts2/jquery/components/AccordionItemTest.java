package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AccordionItemTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            AccordionItem accordionItem = new AccordionItem(valueStack, null, null);

            accordionItem.evaluateParams();

            Map<String, Object> parameters = accordionItem.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "accordionItem")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class, idString -> assertThat(idString).startsWith("accordionItem_"));
                    })
                    .doesNotContainKeys("title", "onClickTopics");

        }

        @Test
        void allSet() {
            AccordionItem accordionItem = new AccordionItem(valueStack, null, null);
            accordionItem.setTitle("the title");
            accordionItem.setOnClickTopics("theOnClickTopic");
            accordionItem.setId("myId");
            
            accordionItem.evaluateParams();

            Map<String, Object> parameters = accordionItem.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "accordionItem")
                    .containsEntry("title", "the title")
                    .containsEntry("onClickTopics", "theOnClickTopic")
                    .containsEntry("id", "myId");
        }
    }
}
