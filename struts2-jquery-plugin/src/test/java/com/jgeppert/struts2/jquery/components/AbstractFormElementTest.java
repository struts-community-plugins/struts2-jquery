package com.jgeppert.struts2.jquery.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.apache.struts2.util.ValueStack;

class AbstractFormElementTest extends AbstractComponentBaseTest {
    @Nested
    class EvaluateParams {
        @Test
        void noneSet() {
            AbstractFormElement abstractRemoteBean = new AbstractFormElementImpl(valueStack);

            abstractRemoteBean.evaluateParams();

            Map<String, Object> attributes = abstractRemoteBean.getAttributes();

            assertThat(attributes)
                    .containsEntry("parentTheme", "simple")
                    .doesNotContainKeys("formIds");
        }

        @Test
        void allSet() {
            AbstractFormElement abstractFormElement = new AbstractFormElementImpl(valueStack);
            abstractFormElement.setParentTheme("vader");

            abstractFormElement.evaluateParams();

            Map<String, Object> attributes = abstractFormElement.getAttributes();

            assertThat(attributes)
                    .containsEntry("parentTheme", "vader");
        }
    }

    private static class AbstractFormElementImpl extends AbstractFormElement {
        public AbstractFormElementImpl(final ValueStack valueStack) {
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
