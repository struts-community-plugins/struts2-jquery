package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SubmitTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            Submit submit = new Submit(valueStack, null, null);

            submit.evaluateParams();

            Map<String, Object> parameters = submit.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "button")
                    .hasEntrySatisfying("id", id -> {
                        assertThat(id).isInstanceOfSatisfying(String.class,
                                idString -> assertThat(idString).startsWith("submit_"));
                    })
                    .containsEntry("parentTheme", "simple")
                    .doesNotContainKeys("type", "src", "clearForm", "resetForm", "iframe", "onClickTopics",
                            "openDialog", "openDialogTitle", "button", "buttonIcon", "buttonIconSecondary",
                            "buttonText", "validate", "validateFunction", "formFilter", "replaceTarget", "formIds",
                            "body");

        }

        @Test
        void allSet() {
            Submit submit = new Submit(valueStack, null, null);
            submit.setId("myId");

            submit.setType("button");
            submit.setSrc("myButtonImage.jpg");
            submit.setClearForm("true");
            submit.setResetForm("false");
            submit.setIframe("false");
            submit.setOnClickTopics("theOnClickTopic");
            submit.setOpenDialog("theDialogId");
            submit.setOpenDialogTitle("the title of the opened dialog");
            submit.setButton("true");
            submit.setButtonIcon("ui-icon-gear");
            submit.setButtonIconSecondary("ui-icon-suitcase");
            submit.setButtonText("false");
            submit.setValidate("true");
            submit.setValidateFunction("myValidateFunction");
            submit.setFormFilter("myFormFieldFilter");
            submit.setReplaceTarget("true");
            submit.setParentTheme("vader");

            submit.evaluateParams();

            Map<String, Object> parameters = submit.getParameters();

            assertThat(parameters)
                    .containsEntry("jqueryaction", "button")
                    .containsEntry("id", "myId")
                    .containsEntry("type", "button")
                    .containsEntry("src", "myButtonImage.jpg")
                    .containsEntry("clearForm", true)
                    .containsEntry("resetForm", false)
                    .containsEntry("iframe", false)
                    .containsEntry("onClickTopics", "theOnClickTopic")
                    .containsEntry("openDialog", "theDialogId")
                    .containsEntry("openDialogTitle", "the title of the opened dialog")
                    .containsEntry("button", true)
                    .containsEntry("buttonIcon", "ui-icon-gear")
                    .containsEntry("buttonIconSecondary", "ui-icon-suitcase")
                    .containsEntry("buttonText", false)
                    .containsEntry("validate", true)
                    .containsEntry("validateFunction", "myValidateFunction")
                    .containsEntry("formFilter", "myFormFieldFilter")
                    .containsEntry("replaceTarget", true)
                    .containsEntry("parentTheme", "vader");
        }
    }
}
