/**
 *
 */
package com.jgeppert.struts2.jquery.datatables.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class ServerSideProcessingRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5202484669248502108L;

    private Long draw;

    private Long start;

    private int length;

    private List<DatatablesOrder> order;

    private DatatablesSearch search;

    private List<DatatablesColumn> columns;

    /**
     *
     */
    public ServerSideProcessingRequest() {
    }

    public Long getDraw() {
        return this.draw;
    }

    public void setDraw(Long draw) {
        this.draw = draw;
    }

    public Long getStart() {
        return this.start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<DatatablesOrder> getOrder() {
        return this.order;
    }

    public void setOrder(List<DatatablesOrder> order) {
        this.order = order;
    }

    public DatatablesSearch getSearch() {
        return this.search;
    }

    public void setSearch(DatatablesSearch search) {
        this.search = search;
    }

    public List<DatatablesColumn> getColumns() {
        return this.columns;
    }

    public void setColumns(List<DatatablesColumn> columns) {
        this.columns = columns;
    }
}
