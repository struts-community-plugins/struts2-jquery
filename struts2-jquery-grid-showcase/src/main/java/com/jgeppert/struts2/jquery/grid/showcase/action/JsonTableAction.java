package com.jgeppert.struts2.jquery.grid.showcase.action;

import com.jgeppert.struts2.jquery.grid.showcase.dao.CustomerDao;
import com.jgeppert.struts2.jquery.grid.showcase.model.Customer;
import org.apache.struts2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;

import jakarta.inject.Inject;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
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
    private Integer rows = 0;

    // Get the requested page. By default grid sets this to 1.
    private Integer page = 0;

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
    private Integer total = 0;

    // All Records
    private Integer records = 0;

    public String execute() {
        log.debug("Page {} Rows {} Sorting Order {} Index Row : {}", getPage(), getRows(), getSord(), getSidx());
        log.debug("Search: {} {} {}", searchField, searchOper, searchString);

        // Calculate until rows ware selected
        int to = (rows * page);

        // Calculate the first row to read
        int from = to - rows;

        CriteriaBuilder builder = customersDao.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        List<Predicate> predicates = new ArrayList<>();

        // Handle Search
        if (searchField != null) {
            switch (searchField) {
                case "customernumber":
                    Integer searchValue = Integer.parseInt(searchString);
                    switch (searchOper) {
                        case "eq":
                            predicates.add(builder.equal(root.get("customernumber"), searchValue));
                            break;
                        case "ne":
                            predicates.add(builder.notEqual(root.get("customernumber"), searchValue));
                            break;
                        case "lt":
                            predicates.add(builder.lessThan(root.get("customernumber"), searchValue));
                            break;
                        case "gt":
                            predicates.add(builder.greaterThan(root.get("customernumber"), searchValue));
                            break;
                    }
                    break;
                case "country":
                case "city":
                case "addressLine1":
                case "contactfirstname":
                case "contactlastname":
                case "customername":
                    switch (searchOper) {
                        case "eq":
                            predicates.add(builder.equal(root.get(searchField), searchString));
                            break;
                        case "ne":
                            predicates.add(builder.notEqual(root.get(searchField), searchString));
                            break;
                        case "bw":
                            predicates.add(builder.like(root.get(searchField), searchString + "%"));
                            break;
                        case "cn":
                            predicates.add(builder.like(root.get(searchField), "%" + searchString + "%"));
                            break;
                    }
                    break;
                case "creditlimit":
                    Double creditLimitValue = Double.parseDouble(searchString);
                    switch (searchOper) {
                        case "eq":
                            predicates.add(builder.equal(root.get("creditlimit"), creditLimitValue));
                            break;
                        case "ne":
                            predicates.add(builder.notEqual(root.get("creditlimit"), creditLimitValue));
                            break;
                        case "lt":
                            predicates.add(builder.lessThan(root.get("creditlimit"), creditLimitValue));
                            break;
                        case "gt":
                            predicates.add(builder.greaterThan(root.get("creditlimit"), creditLimitValue));
                            break;
                    }
                    break;
                case "employeenumber":
                    Integer employeeNumberValue = Integer.parseInt(searchString);
                    root.join("salesemployee");
                    switch (searchOper) {
                        case "eq":
                            predicates.add(builder.equal(root.get("salesemployee").get("employeenumber"), employeeNumberValue));
                            break;
                        case "ne":
                            predicates.add(builder.notEqual(root.get("salesemployee").get("employeenumber"), employeeNumberValue));
                            break;
                        case "lt":
                            predicates.add(builder.lessThan(root.get("salesemployee").get("employeenumber"), employeeNumberValue));
                            break;
                        case "gt":
                            predicates.add(builder.greaterThan(root.get("salesemployee").get("employeenumber"), employeeNumberValue));
                            break;
                    }
                    break;
            }
        }

        query.where(predicates.toArray(new Predicate[0]));

        if (sidx != null && !sidx.equals("")) {
            if (!sidx.equals("employeenumber")) {
                if (sord.equals("asc")) query.orderBy(builder.asc(root.get(sidx)));
                else query.orderBy(builder.desc(root.get(sidx)));
            } else {
                if (sord.equals("asc")) query.orderBy(builder.asc(root.get("salesemployee").get("employeenumber")));
                else query.orderBy(builder.desc(root.get("salesemployee").get("employeenumber")));
            }
        }

        records = customersDao.countByCriteria(searchField, searchString);
        gridModel = customersDao.findByCriteria(searchField, searchString, from, rows);

        // Set to = max rows
        if (to > records) to = records;

        // Calculate total Pages
        total = (int) Math.ceil((double) records / (double) rows);

        return SUCCESS;
    }

    public String getJSON() {
        return execute();
    }

    /**
     * @return how many rows we want to have into the grid
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * @param rows how many rows we want to have into the grid
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * @return current page of the query
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page current page of the query
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return total pages for the query
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total total pages for the query
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return total number of records for the query. e.g. select count(*) from
     * table
     */
    public Integer getRecords() {
        return records;
    }

    /**
     * @param records total number of records for the query. e.g. select count(*) from
     *                table
     */
    public void setRecords(Integer records) {
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
