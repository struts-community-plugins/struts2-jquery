/**
 *
 */
package com.jgeppert.struts2.jquery.showcase.datatables;

import com.jgeppert.struts2.jquery.datatables.model.ServerSideProcessingRequest;
import com.jgeppert.struts2.jquery.datatables.model.ServerSideProcessingResponse;
import com.jgeppert.struts2.jquery.showcase.model.Customer;
import com.jgeppert.struts2.jquery.showcase.model.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.*;

public class DatatablesServerSide extends ActionSupport implements SessionAware, ModelDriven<ServerSideProcessingRequest> {

    private Map<String, Object> session;
    private ServerSideProcessingRequest request = new ServerSideProcessingRequest();
    private ServerSideProcessingResponse<Customer> response = new ServerSideProcessingResponse<>();

    /**
     * <p>
     * To Use JSON Deserialization of DataTables' request, use the json
     * interceptor
     * </p>
     * <pre>
     * {@literal @}Action(interceptorRefs = {@literal @}InterceptorRef(value = "json", params = {
     *                         "accept", "application/json", "root", "request"
     *                         }), results = { {@literal @}Result(name = SUCCESS, type =
     *                         "json", params = { "root", "response" }) })
     * </pre>
     */
    @Override
    @Action(results = {@Result(name = SUCCESS, type = "json", params = {"root", "response"})})
    public String execute() throws Exception {
        List<Customer> list = (List<Customer>) session.get("mylist");
        if (list == null) {
            list = CustomerDAO.buildList();
        }

        List<Customer> data = this.applyFilter(list, this.request.getSearch().getValue());
        int to = this.request.getStart().intValue() + this.request.getLength() > data.size() ? data.size()
                : this.request.getStart().intValue() + this.request.getLength();
        this.applySort(data);
        this.response.setData(CustomerDAO.getCustomers(data, this.request.getStart().intValue(), to));
        this.response.setRecordsTotal((long) list.size());
        this.response.setRecordsFiltered(data.size() != list.size() ? (long) data.size() : (long) list.size());
        // only for showcase functionality, don't do this in production
        session.put("mylist", list);
        return SUCCESS;
    }

    // demo filtering method.
    private List<Customer> applyFilter(List<Customer> list, String pattern) {
        List<Customer> ret = new ArrayList<>();
        if (StringUtils.isNotBlank(pattern)) {
            for (Customer c : list) {
                if (c.getName().toLowerCase().contains(pattern.toLowerCase())) {
                    ret.add(c);
                }
            }
        } else {
            ret = list;
        }
        return ret;
    }

    private void applySort(List<Customer> list) {
        String direction = this.request.getOrder().get(0).getDir();
        Collections.sort(list, new Comparator<Customer>() {

            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        if (StringUtils.equals(direction, "desc")) {
            Collections.reverse(list);
        }
    }

    public ServerSideProcessingResponse getResponse() {
        return this.response;
    }

    public void setRequest(ServerSideProcessingRequest request) {
        this.request = request;
    }

    @Override
    public ServerSideProcessingRequest getModel() {
        return this.request;
    }

    public ServerSideProcessingRequest getRequest() {
        return this.request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
