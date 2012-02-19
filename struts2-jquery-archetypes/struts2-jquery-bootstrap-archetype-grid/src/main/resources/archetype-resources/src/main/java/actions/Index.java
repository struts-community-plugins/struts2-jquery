package ${package}.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

public class Index extends ActionSupport {

	public String execute() {
		return Action.SUCCESS;
	}
}
