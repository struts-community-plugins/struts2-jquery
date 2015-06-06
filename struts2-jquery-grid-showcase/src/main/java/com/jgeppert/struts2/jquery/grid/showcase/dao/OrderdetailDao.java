package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Employee;
import com.jgeppert.struts2.jquery.grid.showcase.model.OrderDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import javax.inject.Named;
import java.util.List;

@Named
public class OrderDetailDao extends AbstractSimpleGenericDao<Employee, Integer> {

    private static final Logger log = LogManager.getLogger(OrderDetailDao.class);

    @SuppressWarnings("unchecked")
    public List<OrderDetail> findByOrder(int order) {
        try {
            Query query = getCurrentSession().createQuery("from OrderDetail where id.order.ordernumber = ?");
            query.setInteger(0, order);
            return query.list();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
