package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DialogTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Dialog dialog = new Dialog(valueStack, null, null);

            dialog.evaluateParams();

            Map<String, Object> parameters = dialog.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "dialog")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("dialog_"));
                    })
                    .doesNotContainKeys("appendTo", "buttons", "draggable", "dialogClass", "height", "modal",
                            "position", "resizable", "title", "width", "autoOpen", "showEffect", "hideEffect",
                            "maxHeight", "maxWidth", "minHeight", "minWidth", "closeOnEscape", "onBeforeCloseTopics",
                            "onCloseTopics", "onOpenTopics", "onFocusTopics", "openTopics", "closeTopics",
                            "destroyTopics");

        }

        @Test
        void allSet() {
            Dialog dialog = new Dialog(valueStack, null, null);
            dialog.setId("myId");
            dialog.setAppendTo("#someElem");
            dialog.setButtons("{text: 'Ok', icon: 'ui-icon-heart', click: function() {$( this ).dialog( 'close' );}");
            dialog.setDraggable("true");
            dialog.setDialogClass("myDialogClass");
            dialog.setHeight("400");
            dialog.setModal("true");
            dialog.setPosition("{ my: \"left top\", at: \"left bottom\", of: button }");
            dialog.setResizable("true");
            dialog.setTitle("my dialog title");
            dialog.setWidth("500");
            dialog.setAutoOpen("false");
            dialog.setShowEffect("{ effect: \"blind\", duration: 800 }");
            dialog.setHideEffect("{ effect: \"explode\", duration: 1000 }");
            dialog.setMaxHeight("600");
            dialog.setMaxWidth("700");
            dialog.setMinHeight("150");
            dialog.setMinWidth("200");
            dialog.setCloseOnEscape("true");
            dialog.setOnBeforeCloseTopics("theOnBeforeCloseTopic");
            dialog.setOnCloseTopics("theOnCloseTopic");
            dialog.setOnOpenTopics("theOnOpenTopic");
            dialog.setOnFocusTopics("theOnFocusTopic");
            dialog.setOpenTopics("theOpenTopic");
            dialog.setCloseTopics("theCloseTopic");
            dialog.setDestroyTopics("theDestroyTopic");

            dialog.evaluateParams();

            Map<String, Object> parameters = dialog.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "dialog")
                    .containsEntry("id", "myId")
                    .containsEntry("appendTo", "#someElem")
                    .containsEntry("buttons",
                            "{text: 'Ok', icon: 'ui-icon-heart', click: function() {$( this ).dialog( 'close' );}")
                    .containsEntry("draggable", true)
                    .containsEntry("dialogClass", "myDialogClass")
                    .containsEntry("height", "400")
                    .containsEntry("modal", "true")
                    .containsEntry("position", "{ my: \"left top\", at: \"left bottom\", of: button }")
                    .containsEntry("resizable", true)
                    .containsEntry("title", "my dialog title")
                    .containsEntry("width", "500")
                    .containsEntry("autoOpen", false)
                    .containsEntry("showEffect", "{ effect: \"blind\", duration: 800 }")
                    .containsEntry("hideEffect", "{ effect: \"explode\", duration: 1000 }")
                    .containsEntry("maxHeight", "600")
                    .containsEntry("maxWidth", "700")
                    .containsEntry("minHeight", "150")
                    .containsEntry("minWidth", "200")
                    .containsEntry("closeOnEscape", true)
                    .containsEntry("onBeforeCloseTopics", "theOnBeforeCloseTopic")
                    .containsEntry("onCloseTopics", "theOnCloseTopic")
                    .containsEntry("onOpenTopics", "theOnOpenTopic")
                    .containsEntry("onFocusTopics", "theOnFocusTopic")
                    .containsEntry("openTopics", "theOpenTopic")
                    .containsEntry("closeTopics", "theCloseTopic")
                    .containsEntry("destroyTopics", "theDestroyTopic");
        }
    }
}
