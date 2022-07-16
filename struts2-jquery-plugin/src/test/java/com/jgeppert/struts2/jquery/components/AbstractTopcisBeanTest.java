package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.opensymphony.xwork2.util.ValueStack;

class AbstractTopcisBeanTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            AbstractTopicsBean abstractTopicsBean = new AbstractTopicsBeanImpl(valueStack);

            abstractTopicsBean.evaluateParams();

            Map<String, Object> parameters = abstractTopicsBean.getParameters();

            assertThat(parameters)
                    .doesNotContainKeys("onBeforeTopics", "onAfterValidationTopics", "onCompleteTopics",
                            "onSuccessTopics", "onErrorTopics", "onChangeTopics", "onAlwaysTopics", "onEnableTopics",
                            "onDisableTopics", "onBlurTopics", "onFocusTopics");
        }

        @Test
        void allSet() {
            AbstractTopicsBean abstractTopicsBean = new AbstractTopicsBeanImpl(valueStack);
            abstractTopicsBean.setOnBeforeTopics("theBeforeTopic");
            abstractTopicsBean.setOnAfterValidationTopics("theAfterValidationTopic");
            abstractTopicsBean.setOnCompleteTopics("theCompleteTopic");
            abstractTopicsBean.setOnSuccessTopics("theSuccessTopic");
            abstractTopicsBean.setOnErrorTopics("theErrorTopic");
            abstractTopicsBean.setOnChangeTopics("theChangeTopics");
            abstractTopicsBean.setOnAlwaysTopics("theAlwaysTopic");
            abstractTopicsBean.setOnEnableTopics("theEnableTopic");
            abstractTopicsBean.setOnDisableTopics("theDisableTopic");
            abstractTopicsBean.setOnBlurTopics("theBlurTopic");
            abstractTopicsBean.setOnFocusTopics("theFocusTopic");

            abstractTopicsBean.evaluateParams();

            Map<String, Object> parameters = abstractTopicsBean.getParameters();

            assertThat(parameters)
                    .containsEntry("onBeforeTopics", "theBeforeTopic")
                    .containsEntry("onAfterValidationTopics", "theAfterValidationTopic")
                    .containsEntry("onCompleteTopics", "theCompleteTopic")
                    .containsEntry("onBeforeTopics", "theBeforeTopic")
                    .containsEntry("onSuccessTopics", "theSuccessTopic")
                    .containsEntry("onErrorTopics", "theErrorTopic")
                    .containsEntry("onChangeTopics", "theChangeTopics")
                    .containsEntry("onAlwaysTopics", "theAlwaysTopic")
                    .containsEntry("onEnableTopics", "theEnableTopic")
                    .containsEntry("onDisableTopics", "theDisableTopic")
                    .containsEntry("onBlurTopics", "theBlurTopic")
                    .containsEntry("onFocusTopics", "theFocusTopic");
        }
    }

    private static class AbstractTopicsBeanImpl extends AbstractTopicsBean {

        public AbstractTopicsBeanImpl(final ValueStack valueStack) {
            super(valueStack, null, null);
        }

        @Override
        public String getDefaultOpenTemplate() {
            return null;
        }

        @Override
        protected String getDefaultTemplate() {
            return null;
        }

    }
}
