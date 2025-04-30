package com.jgeppert.struts2.jquery.grid.showcase.action;

import com.jgeppert.struts2.jquery.grid.showcase.dao.CustomerDao;
import com.jgeppert.struts2.jquery.grid.showcase.model.Customer;
import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

@Result(type = "json")
public class JsonTableAction extends ActionSupport {

    private static final long serialVersionUID = 5078264277068533593L;
    private static final Logger log = LogManager.getLogger(JsonTableAction.class);

    @Inject
    private CustomerDao customersDao;

    // Your result List
    private List<Customer> gridModel;

    // get how many rows we want to have into the grid - rowNum attribute in the
    // grid
    private int rows;

    // Get the requested page. By default grid sets this to 1.
    private int page;

    // sorting order - asc or desc
    private String sord = "asc";

    // get index row - i.e. user click to sort.
    private String sidx;

    // Search Field
    private String searchField;

    // The Search String
    private String searchString;

    // he Search Operation
    // ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
    private String searchOper;

    // Your Total Pages
    private int total = 0;

    // All Records
    private int records = 0;

    public String execute() {
        log.debug("Page {} Rows {} Sorting Order {} Index Row : {}", page, rows, sord, sidx);
        log.debug("Search: {} {} {}", searchField, searchOper, searchString);


        // Calculate until rows ware selected
        int to = (rows * page);

        // Calculate the first row to read
        int from = to - rows;

        records = customersDao.countByCriteria(searchField, searchString, searchOper, sidx, sord);
        gridModel = customersDao.findByCriteria(searchField, searchString, searchOper, sidx, sord, from, rows);

        if (to > records) to = records;
        total = (int) Math.ceil((double) records / (double) rows);
        return SUCCESS;
    }

    public String getJSON() {
        return execute();
    }

    /**
     * @return how many rows we want to have into the grid
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows how many rows we want to have into the grid
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return current page of the query
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page current page of the query
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return total pages for the query
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total total pages for the query
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return total number of records for the query. e.g. select count(*) from
     * table
     */
    public int getRecords() {
        return records;
    }

    /**
     * @param records total number of records for the query. e.g. select count(*) from
     *                table
     */
    public void setRecords(int records) {
        this.records = records;
        if (this.records > 0 && this.rows > 0) {
            this.total = (int) Math.ceil((double) this.records / (double) this.rows);
        } else {
            this.total = 0;
        }
    }

    /**
     * @return an collection that contains the actual data
     */
    public List<Customer> getGridModel() {
        return gridModel;
    }

    /**
     * @return sorting order
     */
    public String getSord() {
        return sord;
    }

    /**
     * @param sord sorting order
     */
    public void setSord(String sord) {
        this.sord = sord;
    }

    /**
     * @return get index row - i.e. user click to sort.
     */
    public String getSidx() {
        return sidx;
    }

    /**
     * @param sidx get index row - i.e. user click to sort.
     */
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
}
