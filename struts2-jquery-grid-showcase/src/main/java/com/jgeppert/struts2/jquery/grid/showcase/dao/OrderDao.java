package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

@Named
public class OrderDao extends AbstractSimpleGenericDao<Order, Integer> {
    private static final Logger log = LogManager.getLogger(OrderDao.class);

    public List<Order> findByCriteria(String someField, Object someValue, int from, int size) {
        log.debug("Return orders from {} to {}", from, size);

        try {
            CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Order> query = builder.createQuery(Order.class);
            Root<Order> root = query.from(Order.class);
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
        log.debug("Count orders");

        try {
            CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<Order> root = query.from(Order.class);
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
}
