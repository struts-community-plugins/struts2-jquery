/**
 *
 */
package com.jgeppert.struts2.jquery.datatables.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ServerSideProcessingResponse<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5202484669248502108L;

    private Long draw;

    private Long recordsTotal;

    private Long recordsFiltered;

    private List<T> data = new ArrayList<>();

    private String error;

    /**
     *
     */
    public ServerSideProcessingResponse() {
    }

    public Long getDraw() {
        return this.draw;
    }

    public void setDraw(Long draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return this.recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return this.recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
