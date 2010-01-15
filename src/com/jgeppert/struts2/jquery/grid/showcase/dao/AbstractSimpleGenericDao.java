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
import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;
import com.jgeppert.struts2.jquery.grid.showcase.model.Employees;
import com.jgeppert.struts2.jquery.grid.showcase.model.Offices;

@SuppressWarnings("unchecked")
public abstract class AbstractSimpleGenericDao<C,I extends Serializable> {

	private static final Log log = LogFactory.getLog(AbstractSimpleGenericDao.class);
	Class<C> entityClass;

	@SessionTarget
	protected Session hSession;

	@TransactionTarget
	protected Transaction hTransaction;


	{
		entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public List<C> getAll() {
		try {
			return hSession.createCriteria(entityClass).list();
		} catch (HibernateException e) {
		  log.error(e.getMessage(),e);
			throw e;
		}
	}

	public C get(I id) {
		try {
			return (C) hSession.get(entityClass, id);
		} catch (HibernateException e) {
      log.error(e.getMessage(),e);
			throw e;
		}
	}

	public void save(C object) {
		try {
			hSession.save(object);
		} catch (HibernateException e) {
			hTransaction.rollback();
      log.error(e.getMessage(),e);
			throw e;
		}
	}

	public void update(C object) {
		try {
			hSession.update(object);
		} catch (HibernateException e) {
			hTransaction.rollback();
      log.error(e.getMessage(),e);
			throw e;
		}
	}

	public void delete(I id) {
		try {
			C actual = get(id);
			hSession.delete(actual);
		} catch (HibernateException e) {
			hTransaction.rollback();
      log.error(e.getMessage(),e);
			throw e;
		}
	}

  public static void main(String[] args)
  {
    Session session = HibernateSessionFactory.getSession();
    
    List<Employees> employees1 = session.createCriteria(Employees.class).list();
    for (Employees employees2 : employees1) {
		System.out.println(employees2.getFirstname()+" "+employees2.getLastname());
	}
    session.getTransaction().begin();
    
 /*   session.createSQLQuery("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" +
    		"'derby.database.defaultConnectionMode'," +
    		"'fullAccess')").executeUpdate();*/
    
    Offices offices = new Offices("codcod","Belem","91222333","addd1","asddd2","para","brazil","667676","norte");
    session.save(offices);
    
    Employees employees = new Employees(1,"Ajisaka","Jose","ext1","email@google.com",offices,0,"none");
    session.save(employees);
    session.getTransaction().commit();
  }
}
