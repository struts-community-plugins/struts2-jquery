package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SliderTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Slider slider = new Slider(valueStack, null, null);

            slider.evaluateParams();

            Map<String, Object> parameters = slider.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "slider")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> {
                                    assertThat(idString).startsWith("slider_");
                                    assertThat(idString).endsWith("_widget");
                                    });
                    })
                    .hasEntrySatisfying("widgetid", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                widgetidString -> assertThat(widgetidString).startsWith("slider_"));
                    })
                    .doesNotContainKeys("animate", "max", "min", "orientation", "step", "displayValueElement",
                            "onSlideTopics", "arrayValue", "range", "value");

        }

        @Test
        void allSet() {
            Slider slider = new Slider(valueStack, null, null);
            slider.setId("myId");
            
            slider.setAnimate("true");
            slider.setMax("200");
            slider.setMin("50");
            slider.setOrientation("horizontal");
            slider.setStep("5");
            slider.setDisplayValueElement("resultId");
            slider.setOnSlideTopics("theOnSlideTopic");
            slider.setValue("[65,80]");

            slider.evaluateParams();

            Map<String, Object> parameters = slider.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "slider")
                    .containsEntry("id", "myId_widget")
                    .containsEntry("animate", true)
                    .containsEntry("max", 200)
                    .containsEntry("min", 50)
                    .containsEntry("orientation", "horizontal")
                    .containsEntry("step", 5)
                    .containsEntry("displayValueElement", "resultId")
                    .containsEntry("onSlideTopics", "theOnSlideTopic")
                    .containsEntry("arrayValue", "[65,80]")
                    .containsEntry("range", "true")
                    .containsEntry("widgetid", "myId")
                    .doesNotContainKey("value");
        }
    }
}
