package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import javax.inject.Named;
import java.util.List;

@Named
public class OrderDao extends AbstractSimpleGenericDao<Order, Integer> {
    private static final Logger log = LogManager.getLogger(OrderDao.class);

    @SuppressWarnings("unchecked")
    public List<Order> findByCriteria(DetachedCriteria dc, int from, int size) {
        log.debug("Return orders from {} to {}", from, size);

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
        log.debug("Count orders");

        try {
            Criteria criteria = dc.getExecutableCriteria(getCurrentSession());
            criteria.setProjection(Projections.rowCount());
            return ((Long) criteria.list().get(0)).intValue();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
