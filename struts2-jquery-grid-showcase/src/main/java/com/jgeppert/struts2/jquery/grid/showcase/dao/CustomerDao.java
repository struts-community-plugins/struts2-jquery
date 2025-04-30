package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Customer;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Named
public class CustomerDao extends AbstractSimpleGenericDao<Customer, Integer> {

    private static final Logger log = LogManager.getLogger(CustomerDao.class);

    @Transactional
    public List<Customer> findByCriteria(String searchField, String searchValue, String searchOper, String sidx, String sord, int from, int size) {
        log.debug("Return customers from {} to {}", from, size);

        try {
            CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
            Root<Customer> root = query.from(Customer.class);
            query.select(root);
            buildSearchPredictions(builder, query, root, searchField, searchValue, searchOper, sidx, sord);
            return getEntityManager().createQuery(query)
                    .setFirstResult(from)
                    .setMaxResults(size)
                    .getResultList();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Transactional
    public int countByCriteria(String searchField, String searchValue, String searchOper, String sidx, String sord) {
        try {
            CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<Customer> root = query.from(Customer.class);
            query.select(builder.count(root));
            buildSearchPredictions(builder, query, root, searchField, searchValue, searchOper, sidx, sord);
            return getEntityManager().createQuery(query).getSingleResult().intValue();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Transactional
    public List<String> findCountries() {
        if (log.isDebugEnabled()) log.debug("find all country's");

        try {
            String queryString = "SELECT DISTINCT c.country FROM CLASSICMODELS.CUSTOMERS c where c.country is not null";
            Query query = getEntityManager().createNativeQuery(queryString, String.class);
            NativeQuery nativeQuery = query.unwrap(NativeQuery.class);
            nativeQuery.addScalar("country", StandardBasicTypes.STRING);
            nativeQuery.setCacheable(true);
            nativeQuery.setCacheRegion("countries");
            return query.getResultList();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Transactional
    public int nextCustomerNumber() {
        log.debug("find next customer number");

        try {
            CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
            Root<Customer> root = query.from(Customer.class);
            query.select(builder.max(root.get("customernumber")));
            return getEntityManager().createQuery(query).getSingleResult() + 1;
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    private void buildSearchPredictions(CriteriaBuilder builder, CriteriaQuery<?> query, Root<?> root, String searchField, String searchString, String searchOper, String sidx, String sord) {

        List<Predicate> predicates = new ArrayList<>();

        // Handle Search
        if (searchField != null) {
            switch (searchField) {
                case "customernumber":
                    searchInteger(searchOper, builder, predicates, searchString, searchField, root);
                    break;
                case "country":
                case "city":
                case "addressLine1":
                case "contactfirstname":
                case "contactlastname":
                case "customername":
                    switch (searchOper) {
                        case "eq" -> predicates.add(builder.equal(root.get(searchField), searchString));
                        case "ne" -> predicates.add(builder.notEqual(root.get(searchField), searchString));
                        case "bw" -> predicates.add(builder.like(root.get(searchField), searchString + "%"));
                        case "cn" -> predicates.add(builder.like(root.get(searchField), "%" + searchString + "%"));
                    }
                    break;
                case "creditlimit":
                    Double creditLimitValue = Double.parseDouble(searchString);
                    switch (searchOper) {
                        case "eq" -> predicates.add(builder.equal(root.get(searchField), creditLimitValue));
                        case "ne" -> predicates.add(builder.notEqual(root.get(searchField), creditLimitValue));
                        case "lt" -> predicates.add(builder.lessThan(root.get(searchField), creditLimitValue));
                        case "gt" -> predicates.add(builder.greaterThan(root.get(searchField), creditLimitValue));
                    }
                    break;
                case "employeenumber":
                    Integer employeeNumberValue = Integer.parseInt(searchString);
                    root.join("salesemployee");
                    switch (searchOper) {
                        case "eq" ->
                                predicates.add(builder.equal(root.get("salesemployee").get(searchField), employeeNumberValue));
                        case "ne" ->
                                predicates.add(builder.notEqual(root.get("salesemployee").get(searchField), employeeNumberValue));
                        case "lt" ->
                                predicates.add(builder.lessThan(root.get("salesemployee").get(searchField), employeeNumberValue));
                        case "gt" ->
                                predicates.add(builder.greaterThan(root.get("salesemployee").get(searchField), employeeNumberValue));
                    }
                    break;
            }
        }

        query.where(predicates.toArray(new Predicate[0]));

        if (sidx != null && !sidx.isEmpty()) {
            if (!sidx.equals("employeenumber")) {
                if (sord.equals("asc")) query.orderBy(builder.asc(root.get(sidx)));
                else query.orderBy(builder.desc(root.get(sidx)));
            } else {
                if (sord.equals("asc")) query.orderBy(builder.asc(root.get("salesemployee").get("employeenumber")));
                else query.orderBy(builder.desc(root.get("salesemployee").get("employeenumber")));
            }
        }
    }
}
