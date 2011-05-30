package com.jgeppert.struts2.jquery.grid.showcase.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.jgeppert.struts2.jquery.grid.showcase.model.Orders;

public class OrdersDao extends AbstractSimpleGenericDao<Orders, Integer>
{
	private static final Log	log	= LogFactory.getLog(OrdersDao.class);

	@SuppressWarnings("unchecked")
	public List<Orders> findByCriteria(DetachedCriteria dc, int from, int size) {
		if (log.isDebugEnabled()) log.debug("Return Orders from " + from + " to " + size);

		try
		{
			Criteria criteria = dc.getExecutableCriteria(hSession);
			criteria.setFirstResult(from);
			criteria.setMaxResults(size);
			return criteria.list();
		}
		catch (HibernateException e)
		{
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	public int countByCriteria(DetachedCriteria dc) {
		if (log.isDebugEnabled()) log.debug("count Orders");

		try
		{
			Criteria criteria = dc.getExecutableCriteria(hSession);
			criteria.setProjection(Projections.rowCount());
			return ((Long) criteria.list().get(0)).intValue();
		}
		catch (HibernateException e)
		{
			log.error(e.getMessage(), e);
			throw e;
		}
	}
}
