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
public class AbstractSimpleGenericDao<C,I extends Serializable> {

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
			e.printStackTrace();
			throw e;
		}
	}

	public C get(I id) {
		try {
			return (C) hSession.get(entityClass, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void save(C object) {
		try {
			hSession.save(object);
		} catch (HibernateException e) {
			hTransaction.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void update(C object) {
		try {
			log.info("UPDATE : "+object);
			hTransaction.begin();
			hSession.update(object);
			hTransaction.commit();

		} catch (HibernateException e) {
			hTransaction.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void delete(I id) {
		try {
			C actual = get(id);
			hSession.delete(actual);
		} catch (HibernateException e) {
			hTransaction.rollback();
			e.printStackTrace();
			throw e;
		}
	}
}
