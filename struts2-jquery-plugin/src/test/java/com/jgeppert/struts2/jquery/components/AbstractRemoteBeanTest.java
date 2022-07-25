package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.opensymphony.xwork2.util.ValueStack;

class AbstractRemoteBeanTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            AbstractRemoteBean abstractRemoteBean = new AbstractRemoteBeanImpl(valueStack);

            abstractRemoteBean.evaluateParams();

            Map<String, Object> parameters = abstractRemoteBean.getParameters();

            assertThat(parameters)
                    .doesNotContainKeys("href", "hrefUrl", "hrefParameter", "targets", "formIds", "indicator",
                            "loadingText", "errorText", "errorElementId", "dataType", "requestType", "effect",
                            "effectDuration", "effectOptions", "effectMode", "timeout", "listenTopics",
                            "onEffectCompleteTopics");
        }

        @Test
        void allSet() {
            AbstractRemoteBean abstractTopicsBean = new AbstractRemoteBeanImpl(valueStack);
            abstractTopicsBean.setHref("/the-url?paramKey=paramValue");
            abstractTopicsBean.setTargets("theTarget");
            abstractTopicsBean.setFormIds("theFormId");
            abstractTopicsBean.setIndicator("theIndicator");
            abstractTopicsBean.setLoadingText("the loading text");
            abstractTopicsBean.setErrorText("the error text");
            abstractTopicsBean.setErrorElementId("theErrorElementId");
            abstractTopicsBean.setDataType("theDataType");
            abstractTopicsBean.setRequestType("theRequestType");
            abstractTopicsBean.setEffect("theEffect");
            abstractTopicsBean.setEffectDuration("theEffectDuration");
            abstractTopicsBean.setEffectOptions("theEffectOptions");
            abstractTopicsBean.setEffectMode("theEffectMode");
            abstractTopicsBean.setTimeout("100");
            abstractTopicsBean.setListenTopics("theListenTopic");
            abstractTopicsBean.setOnEffectCompleteTopics("theEffectCompleteTopic");

            abstractTopicsBean.evaluateParams();

            Map<String, Object> parameters = abstractTopicsBean.getParameters();

            assertThat(parameters)
                    .containsEntry("href", "/the-url?paramKey=paramValue")
                    .containsEntry("hrefUrl", "/the-url")
                    .containsEntry("hrefParameter", "paramKey=paramValue")
                    .containsEntry("targets", "theTarget")
                    .containsEntry("formIds", "theFormId")
                    .containsEntry("indicator", "theIndicator")
                    .containsEntry("loadingText", "the loading text")
                    .containsEntry("errorText", "the error text")
                    .containsEntry("errorElementId", "theErrorElementId")
                    .containsEntry("dataType", "theDataType")
                    .containsEntry("requestType", "theRequestType")
                    .containsEntry("effect", "theEffect")
                    .containsEntry("effectDuration", "theEffectDuration")
                    .containsEntry("effectOptions", "theEffectOptions")
                    .containsEntry("effectMode", "theEffectMode")
                    .containsEntry("timeout", "100")
                    .containsEntry("listenTopics", "theListenTopic")
                    .containsEntry("onEffectCompleteTopics", "theEffectCompleteTopic");
        }
    }

    private static class AbstractRemoteBeanImpl extends AbstractRemoteBean {
        public AbstractRemoteBeanImpl(final ValueStack valueStack) {
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
