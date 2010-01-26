package com.jgeppert.struts2.jquery.grid.showcase.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

@SuppressWarnings("unchecked")
public abstract class AbstractSimpleGenericDao<C, I extends Serializable> {

  private static final Log log = LogFactory.getLog(AbstractSimpleGenericDao.class);
  Class<C>                 entityClass;

  @SessionTarget
  protected Session        hSession;

  @TransactionTarget
  protected Transaction    hTransaction;

  {
    entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  public List<C> getAll()
  {
    try
    {
      return hSession.createCriteria(entityClass).list();
    }
    catch (HibernateException e)
    {
      log.error(e.getMessage(), e);
      throw e;
    }
  }

  public C get(I id)
  {
    try
    {
      return (C) hSession.get(entityClass, id);
    }
    catch (HibernateException e)
    {
      log.error(e.getMessage(), e);
      throw e;
    }
  }

  public void save(C object)
  {
    try
    {
      hSession.save(object);
    }
    catch (HibernateException e)
    {
      hTransaction.rollback();
      log.error(e.getMessage());
      log.error("Be sure your Database is in read-write mode!");
      throw e;
    }
  }

  public void update(C object)
  {
    try
    {
      hSession.update(object);
    }
    catch (HibernateException e)
    {
      hTransaction.rollback();
      log.error(e.getMessage());
      log.error("Be sure your Database is in read-write mode!");
      throw e;
    }
  }

  public void delete(I id)
  {
    try
    {
      C actual = get(id);
      hSession.delete(actual);
    }
    catch (HibernateException e)
    {
      hTransaction.rollback();
      log.error(e.getMessage());
      log.error("Be sure your Database is in read-write mode!");
      throw e;
    }
  }
}
