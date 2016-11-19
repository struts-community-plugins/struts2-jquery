package com.jgeppert.struts2.jquery.showcase.datatables;

import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class DatatablesSave extends ActionSupport implements SessionAware {

    private static final Log log = LogFactory.getLog(DatatablesSave.class);

    private Map<String, Object> session;
    private String id;
    private String name;
    private String country;
    private String city;
    private String creditLimit;
    private Customer customer;

    public DatatablesSave() {
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    @Action(interceptorRefs = @InterceptorRef("jsonValidationWorkflowStack"), results = {
            @Result(name = SUCCESS, type = "json", params = {"includeProperties", "actionMessages.*,customer.*",
                    "ignoreHierarchy", "false"}),
            @Result(name = ERROR, type = "json", params = {"includeProperties", "actionErrors.*", "ignoreHierarchy",
                    "false", "statusCode", "500"})})
    public String execute() throws Exception {
        String ret = SUCCESS;
        try {
            List<Customer> list = (List<Customer>) session.get("mylist");
            Customer customer = null;
            if (this.id != null && !"".equals(id)) {
                customer = CustomerDAO.findById(list, Integer.parseInt(id));
                log.debug("Updating customer");
            } else {
                customer = new Customer();
                customer.setId(new Random().nextInt());
                list.add(customer);
                log.debug("Created customer");
            }
            customer.setName(name);
            customer.setCountry(country);
            customer.setCity(city);
            customer.setCreditLimit(Double.parseDouble(creditLimit));
            this.customer = customer;
        } catch (Exception e) {
            ret = ERROR;
            this.addActionError("Error while saving customer : " + e.getMessage());
        }
        return ret;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @RequiredStringValidator(fieldName = "name", type = ValidatorType.FIELD, message = "Name is required")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequiredStringValidator(fieldName = "country", type = ValidatorType.FIELD, message = "Country is required")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @RequiredStringValidator(fieldName = "city", type = ValidatorType.FIELD, message = "City is required")
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @RequiredStringValidator(fieldName = "creditLimit", type = ValidatorType.FIELD, message = "CreditLimit is required")
    public String getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Map<String, Object> getSession() {
        return this.session;
    }

    public Customer getCustomer() {
        return this.customer;
    }

}
