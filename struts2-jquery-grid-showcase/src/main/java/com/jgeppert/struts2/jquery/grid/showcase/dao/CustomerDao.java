package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

@Named
public class CustomerDao extends AbstractSimpleGenericDao<Customer, Integer> {

    private static final Logger log = LogManager.getLogger(CustomerDao.class);

    public List<Customer> findByCriteria(String someField, Object someValue, int from, int size) {
        log.debug("Return customers from {} to {}", from, size);

        try {
            CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
            Root<Customer> root = query.from(Customer.class);
            query.select(root);
            if (someField != null && someValue != null) {
                query.where(builder.equal(root.get(someField), someValue));
            }
            return getCurrentSession().createQuery(query)
                    .setFirstResult(from)
                    .setMaxResults(size)
                    .getResultList();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public int countByCriteria(String someField, Object someValue) {
        if (log.isDebugEnabled()) log.debug("count Customers");

        try {
            CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<Customer> root = query.from(Customer.class);
            query.select(builder.count(root));
            if (someField != null && someValue != null) {
                query.where(builder.equal(root.get(someField), someValue));
            }
            return getCurrentSession().createQuery(query).getSingleResult().intValue();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public List<String> findCountrys() {
        if (log.isDebugEnabled()) log.debug("find all country's");

        try {
            String queryString = "SELECT DISTINCT c.country FROM CLASSICMODELS.CUSTOMERS c where c.country is not null";
            NativeQuery<String> q = getCurrentSession().createNativeQuery(queryString);
            q.setCacheable(true);
            q.addScalar("country", StandardBasicTypes.STRING);
            return q.list();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public int nextCustomerNumber() {
        log.debug("find next customer number");

        try {
            CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
            Root<Customer> root = query.from(Customer.class);
            query.select(builder.max(root.get("customernumber")));
            return getCurrentSession().createQuery(query).getSingleResult() + 1;
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
