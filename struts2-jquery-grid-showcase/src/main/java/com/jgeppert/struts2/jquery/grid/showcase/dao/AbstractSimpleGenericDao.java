package com.jgeppert.struts2.jquery.grid.showcase.dao;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractSimpleGenericDao<C, I extends Serializable> {

    private static final Logger log = LogManager.getLogger(AbstractSimpleGenericDao.class);

    @Inject
    protected SessionFactory sessionFactory;

    Class<C> entityClass;

    {
        entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<C> getAll() {
        try {
            CriteriaQuery<C> query = getCurrentSession().getCriteriaBuilder().createQuery(entityClass);
            Root<C> root = query.from(entityClass);
            query.select(root);
            return getCurrentSession().createQuery(query).getResultList();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public C get(I id) {
        return getCurrentSession().get(entityClass, id);
    }

    @Transactional
    public void save(C object) {
        try {
            getCurrentSession().saveOrUpdate(object);
        } catch (RuntimeException e) {
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
    }

    @Transactional
    public void update(C object) {
        try {
            getCurrentSession().update(object);
        } catch (RuntimeException e) {
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
    }

    @Transactional
    public void delete(I id) {
        try {
            C actual = get(id);
            getCurrentSession().delete(actual);
        } catch (RuntimeException e) {
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
    }
}
