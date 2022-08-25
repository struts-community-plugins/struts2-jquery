package com.jgeppert.struts2.jquery.components;

import com.opensymphony.xwork2.DefaultTextProvider;
import com.opensymphony.xwork2.conversion.impl.XWorkConverter;
import com.opensymphony.xwork2.ognl.DefaultOgnlBeanInfoCacheFactory;
import com.opensymphony.xwork2.ognl.DefaultOgnlExpressionCacheFactory;
import com.opensymphony.xwork2.ognl.OgnlUtil;
import com.opensymphony.xwork2.ognl.OgnlValueStack;
import com.opensymphony.xwork2.ognl.accessor.CompoundRootAccessor;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.conversion.StrutsTypeConverterHolder;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractComponentBaseTest {
    protected ValueStack valueStack;

    @BeforeEach
    void setUpValueStack() {
        valueStack = new TestOgnlValueStack();
    }

    static class TestOgnlValueStack extends OgnlValueStack {
        private static final long serialVersionUID = 1L;

        protected TestOgnlValueStack() {
            super(new TestXworkConverter(), new CompoundRootAccessor(), new DefaultTextProvider(), false);
            TestXworkConverter converter = new TestXworkConverter();
            converter.setTypeConverterHolder(new StrutsTypeConverterHolder());

            setXWorkConverter(converter);
            setOgnlUtil(new OgnlUtil(new DefaultOgnlExpressionCacheFactory<>(), new DefaultOgnlBeanInfoCacheFactory<>()));
        }

    }

    static class TestXworkConverter extends XWorkConverter {
    }
}
