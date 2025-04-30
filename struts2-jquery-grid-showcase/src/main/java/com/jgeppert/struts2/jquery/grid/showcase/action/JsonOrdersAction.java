package com.jgeppert.struts2.jquery.grid.showcase.action;

import com.jgeppert.struts2.jquery.grid.showcase.dao.OrderDao;
import com.jgeppert.struts2.jquery.grid.showcase.model.Order;
import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

@Result(type = "json")
public class JsonOrdersAction extends ActionSupport {

    private static final long serialVersionUID = 5078264277068533593L;
    private static final Logger log = LogManager.getLogger(JsonOrdersAction.class);

    @Inject
    private OrderDao ordersDao;

    private Integer id;
    private List<Order> gridModel;
    private Integer rows = 0;
    private Integer page = 0;
    private String sord = "asc";
    private String sidx;
    private String searchField;
    private String searchString;
    private String searchOper;
    private Integer total = 0;
    private Integer records = 0;

    public String execute() {
        log.debug("Page {} Rows {} Sorting Order {} Index Row : {}", getPage(), getRows(), getSord(), getSidx());
        log.debug("Search: {} {} {}", searchField, searchOper, searchString);

        int to = (rows * page);
        int from = to - rows;

        records = ordersDao.countByCriteria(id, searchField, searchString, searchOper, sidx, sord);
        gridModel = ordersDao.findByCriteria(id, searchField, searchString, searchOper, sidx, sord, from, rows);

        if (to > records) to = records;
        total = (int) Math.ceil((double) records / (double) rows);

        return SUCCESS;
    }

    public String getJSON() {
        return execute();
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
        if (this.records > 0 && this.rows > 0) {
            this.total = (int) Math.ceil((double) this.records / (double) this.rows);
        } else {
            this.total = 0;
        }
    }

    public List<Order> getGridModel() {
        return gridModel;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}