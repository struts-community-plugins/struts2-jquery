package com.jgeppert.struts2.jquery.showcase.datatables;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class Datatables extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private List<Customer> myCustomers;

    public Datatables() {
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    @Actions({@Action(results = {
            @Result(location = "/WEB-INF/content/datatables/datatables.jsp")
    }),
            @Action(value = "datatables-json", results = {
                    @Result(type = "json", params = {"includeProperties", "myCustomers.*"})}
            )
    })
    public String execute() throws Exception {

        Object list = session.get("mylist");
        if (list != null) {
            myCustomers = (List<Customer>) list;
        } else {
            myCustomers = CustomerDAO.buildList();
        }
        // only for showcase functionality, don't do this in production
        session.put("mylist", myCustomers);
        return SUCCESS;
    }

    public List<Customer> getMyCustomers() {
        return this.myCustomers;
    }
}
