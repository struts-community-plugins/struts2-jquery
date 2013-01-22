package com.jgeppert.struts2.jquery.grid.showcase.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.type.StringType;

import com.jgeppert.struts2.jquery.grid.showcase.model.Customers;

public class CustomersDao extends AbstractSimpleGenericDao<Customers, Integer> {

  private static final Log log = LogFactory.getLog(CustomersDao.class);

  @SuppressWarnings("unchecked")
  public List<Customers> findByCriteria(DetachedCriteria dc, int from, int size)
  {
    if (log.isDebugEnabled()) log.debug("Return Customers from " + from + " to " + size);

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

  public int countByCriteria(DetachedCriteria dc)
  {
    if (log.isDebugEnabled()) log.debug("count Customers");

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

  @SuppressWarnings("unchecked")
  public List<String> findCountrys()
  {
    if (log.isDebugEnabled()) log.debug("find all countrys");

    try
    {
      String queryString = "SELECT DISTINCT c.country FROM CLASSICMODELS.CUSTOMERS c where c.country is not null";
      SQLQuery q = hSession.createSQLQuery(queryString);
      q.setCacheable(true);
      q.addScalar("country", StringType.INSTANCE);
      return q.list();
    }
    catch (HibernateException e)
    {
      log.error(e.getMessage(), e);
      throw e;
    }
  }

  public int nextCustomerNumber()
  {
    if (log.isDebugEnabled()) log.debug("find next customer number");

    try
    {
      DetachedCriteria dc = DetachedCriteria.forClass(Customers.class);
      Criteria criteria = dc.getExecutableCriteria(hSession);
      criteria.setProjection(Projections.max("customernumber"));
      return ((Integer) criteria.list().get(0)).intValue() + 1;
    }
    catch (HibernateException e)
    {
      log.error(e.getMessage(), e);
      throw e;
    }
  }
}
