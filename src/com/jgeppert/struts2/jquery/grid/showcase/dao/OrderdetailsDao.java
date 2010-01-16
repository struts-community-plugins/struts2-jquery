package com.jgeppert.struts2.jquery.grid.showcase.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.jgeppert.struts2.jquery.grid.showcase.model.Employees;
import com.jgeppert.struts2.jquery.grid.showcase.model.Orderdetails;

public class OrderdetailsDao extends AbstractSimpleGenericDao<Employees, Integer>
{

	private static final Log	log	= LogFactory.getLog(OrderdetailsDao.class);

	@SuppressWarnings("unchecked")
	public List<Orderdetails> findByOrder(int order) {
		try
		{
			Query query = hSession.createQuery("from Orderdetails where id.order.ordernumber = ?");
			query.setInteger(0, order);
			return query.list();
		}
		catch (HibernateException e)
		{
			log.error(e.getMessage(), e);
			throw e;
		}
	}
}
