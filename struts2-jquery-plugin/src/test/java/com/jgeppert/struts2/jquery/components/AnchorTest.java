package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnchorTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Anchor anchor = new Anchor(valueStack, null, null);

            anchor.evaluateParams();

            Map<String, Object> parameters = anchor.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "anchor")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("anchor_"));
                    })
                    .doesNotContainKeys("openDialog", "openDialogTitle", "onClickTopics", "button", "buttonIcon",
                            "buttonIconSecondary", "buttonText", "validate", "validateFunction", "clearForm",
                            "resetForm", "iframe", "replaceTarget");

        }

        @Test
        void allSet() {
            Anchor anchor = new Anchor(valueStack, null, null);
            anchor.setId("myId");
            anchor.setOpenDialog("theOpenDialog");
            anchor.setOpenDialogTitle("the open dialog title");
            anchor.setOnClickTopics("theOnClickTopic");
            anchor.setButton("true");
            anchor.setButtonIcon("myButtonIcon");
            anchor.setButtonIconSecondary("mySecondaryButtonIcon");
            anchor.setButtonText("true");
            anchor.setValidate("true");
            anchor.setValidateFunction("myValidateFunction");
            anchor.setClearForm("true");
            anchor.setResetForm("true");
            anchor.setIframe("false");
            anchor.setReplaceTarget("true");

            anchor.evaluateParams();

            Map<String, Object> parameters = anchor.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "anchor")
                    .containsEntry("openDialog", "theOpenDialog")
                    .containsEntry("openDialogTitle", "the open dialog title")
                    .containsEntry("onClickTopics", "theOnClickTopic")
                    .containsEntry("button", true)
                    .containsEntry("buttonIcon", "myButtonIcon")
                    .containsEntry("buttonIconSecondary", "mySecondaryButtonIcon")
                    .containsEntry("buttonText", true)
                    .containsEntry("validate", true)
                    .containsEntry("validateFunction", "myValidateFunction")
                    .containsEntry("clearForm", true)
                    .containsEntry("resetForm", true)
                    .containsEntry("iframe", false)
                    .containsEntry("replaceTarget", true);
        }
    }
}
