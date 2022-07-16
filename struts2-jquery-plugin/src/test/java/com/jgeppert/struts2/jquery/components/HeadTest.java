package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class HeadTest extends AbstractComponentTest{
    @Nested
    class EvaluateParams {
        @Test
        void testNoneSet() {
            Head head = new Head(valueStack, null, null);
            head.setTemplateDir("template");

            head.evaluateParams();

            Map<String, Object> parameters = head.getParameters();
            assertThat(parameters)
                    .containsEntry("templateDir", "template")
                    .containsEntry("theme", "jquery")
                    .hasEntrySatisfying("dynamicAttributes", danymicAttributes -> {
                        assertThat(danymicAttributes)
                                .isInstanceOfSatisfying(Map.class, dynAttrs -> {
                                    assertThat(dynAttrs).isEmpty();
                                });
                    })
                    .doesNotContainKeys("jquery", "jqueryui", "compressed", "jquerytheme", "customBasepath",
                            "loadFromCdn", "ajaxcache", "ajaxhistory", "defaultIndicator", "defaultLoadingText",
                            "defaultErrorText", "debug", "scriptPath", "gridLocale", "timeLocale", "jqueryLocale",
                            "datatablesLocale");
        }
        
        @Test
        void testAllSet() {
            Head head = new Head(valueStack, null, null);
            head.setTemplateDir("template");
            head.setJquery("true");
            head.setJqueryui("true");
            head.setCompressed("false");
            head.setJquerytheme("vader");
            head.setCustomBasepath("/custom");
            head.setLoadFromCdn("true");
            head.setAjaxcache("false");
            head.setAjaxhistory("false");
            head.setDefaultIndicator("indicator");
            head.setDefaultLoadingText("the default loading text");
            head.setDefaultErrorText("Error error!");
            head.setDebug("false");
            head.setScriptPath("/scripts");
            head.setLocale("nl");

            head.evaluateParams();

            Map<String, Object> parameters = head.getParameters();
            assertThat(parameters)
                    .containsEntry("templateDir", "template")
                    .containsEntry("theme", "jquery")
                    .hasEntrySatisfying("dynamicAttributes", danymicAttributes -> {
                        assertThat(danymicAttributes)
                                .isInstanceOfSatisfying(Map.class, dynAttrs -> {
                                    assertThat(dynAttrs).isEmpty();
                                });
                    })
                    .containsEntry("jquery", true)
                    .containsEntry("jqueryui", true)
                    .containsEntry("compressed", false)
                    .containsEntry("jquerytheme", "vader")
                    .containsEntry("customBasepath", "/custom")
                    .containsEntry("loadFromCdn", true)
                    .containsEntry("ajaxcache", false)
                    .containsEntry("ajaxhistory", false)
                    .containsEntry("defaultIndicator", "indicator")
                    .containsEntry("defaultLoadingText", "the default loading text")
                    .containsEntry("defaultErrorText", "Error error!")
                    .containsEntry("debug", false)
                    .containsEntry("gridLocale", "nl")
                    .containsEntry("timeLocale", "nl")
                    .containsEntry("jqueryLocale", "nl")
                    .containsEntry("datatablesLocale", "nl");
        }
    }

}
