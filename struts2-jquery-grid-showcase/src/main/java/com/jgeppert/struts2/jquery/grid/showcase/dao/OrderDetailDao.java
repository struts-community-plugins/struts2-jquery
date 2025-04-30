package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Employee;
import com.jgeppert.struts2.jquery.grid.showcase.model.OrderDetail;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Named
public class OrderDetailDao extends AbstractSimpleGenericDao<Employee, Integer> {

    private static final Logger log = LogManager.getLogger(OrderDetailDao.class);

    @SuppressWarnings("unchecked")
    @Transactional
    public List<OrderDetail> findByOrder(int order) {
        try {
            TypedQuery<OrderDetail> query = getEntityManager().createQuery("from OrderDetail where id.order.ordernumber = ?1", OrderDetail.class);
            query.setParameter(1, order);
            return query.getResultList();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
