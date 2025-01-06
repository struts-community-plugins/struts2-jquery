package com.jgeppert.struts2.jquery.components;

import org.apache.struts2.conversion.impl.XWorkConverter;
import org.apache.struts2.ognl.OgnlCacheFactory;
import org.apache.struts2.ognl.ProviderAllowlist;
import org.apache.struts2.ognl.SecurityMemberAccess;
import org.apache.struts2.ognl.ThreadAllowlist;
import org.apache.struts2.text.DefaultTextProvider;
import org.apache.struts2.ognl.DefaultOgnlBeanInfoCacheFactory;
import org.apache.struts2.ognl.DefaultOgnlExpressionCacheFactory;
import org.apache.struts2.ognl.OgnlUtil;
import org.apache.struts2.ognl.OgnlValueStack;
import org.apache.struts2.ognl.accessor.CompoundRootAccessor;
import org.apache.struts2.util.ValueStack;
import org.apache.struts2.conversion.StrutsTypeConverterHolder;
import org.apache.struts2.ognl.StrutsOgnlGuard;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public abstract class AbstractComponentBaseTest {

    private static final TestXworkConverter converter;

    protected ValueStack valueStack;

    static {
        converter = new TestXworkConverter();
        converter.setTypeConverterHolder(new StrutsTypeConverterHolder());
    }


    @BeforeEach
    void setUpValueStack() {
        valueStack = new TestOgnlValueStack();
        valueStack.getActionContext()
                .withServletRequest(new MockHttpServletRequest())
                .withServletResponse(new MockHttpServletResponse())
                .bind();
    }

    static class TestOgnlValueStack extends OgnlValueStack {
        protected TestOgnlValueStack() {
            super(converter, new CompoundRootAccessor(), new DefaultTextProvider(), new SecurityMemberAccess(new ProviderAllowlist(), new ThreadAllowlist()));

            setOgnlUtil(
                    new OgnlUtil(
                            new DefaultOgnlExpressionCacheFactory<>("1000", OgnlCacheFactory.CacheType.BASIC.name()),
                            new DefaultOgnlBeanInfoCacheFactory<>("1000", OgnlCacheFactory.CacheType.BASIC.name()),
                            new StrutsOgnlGuard()
                    )
            );
        }
    }

    static class TestXworkConverter extends XWorkConverter {
    }
}
