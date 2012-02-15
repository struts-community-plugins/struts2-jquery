package ${package}.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsTestCase;

public class DialogContentActionTest extends StrutsTestCase {

    public void testDialogContentAction() throws Exception {
        DialogContentAction dialogContent = new DialogContentAction();
        String result = dialogContent.execute();
        assertTrue("Expected a success result!",
                ActionSupport.SUCCESS.equals(result));
        assertTrue("Expected the default message!",
        		dialogContent.getText(DialogContentAction.MESSAGE).equals(dialogContent.getMessage()));
    }
}
