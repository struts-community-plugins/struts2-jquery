package ${package}.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsSpringTestCase;

public class ActionTest extends StrutsSpringTestCase {

	public void testIndexAction() throws Exception {
		Index hello = new Index();
		String result = hello.execute();
		assertTrue("Expected a success result!",
				ActionSupport.SUCCESS.equals(result));
	}
}
