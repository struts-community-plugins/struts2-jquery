package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.type.StringType;

import javax.inject.Named;
import java.util.List;

@Named
public class CustomerDao extends AbstractSimpleGenericDao<Customer, Integer> {

    private static final Logger log = LogManager.getLogger(CustomerDao.class);

    @SuppressWarnings("unchecked")
    public List<Customer> findByCriteria(DetachedCriteria dc, int from, int size) {
        log.debug("Return customers from {} to {}", from, size);

        try {
            Criteria criteria = dc.getExecutableCriteria(getCurrentSession());
            criteria.setFirstResult(from);
            criteria.setMaxResults(size);
            return criteria.list();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public int countByCriteria(DetachedCriteria dc) {
        if (log.isDebugEnabled()) log.debug("count Customers");

        try {
            Criteria criteria = dc.getExecutableCriteria(getCurrentSession());
            criteria.setProjection(Projections.rowCount());
            return ((Long) criteria.list().get(0)).intValue();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<String> findCountrys() {
        if (log.isDebugEnabled()) log.debug("find all country's");

        try {
            String queryString = "SELECT DISTINCT c.country FROM CLASSICMODELS.CUSTOMERS c where c.country is not null";
            SQLQuery q = getCurrentSession().createSQLQuery(queryString);
            q.setCacheable(true);
            q.addScalar("country", StringType.INSTANCE);
            return q.list();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public int nextCustomerNumber() {
        log.debug("find next customer number");

        try {
            DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
            Criteria criteria = dc.getExecutableCriteria(getCurrentSession());
            criteria.setProjection(Projections.max("customernumber"));
            return ((Integer) criteria.list().get(0)).intValue() + 1;
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
