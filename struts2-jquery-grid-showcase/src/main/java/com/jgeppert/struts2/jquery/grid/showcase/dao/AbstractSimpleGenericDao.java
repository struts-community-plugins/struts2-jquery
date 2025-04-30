package com.jgeppert.struts2.jquery.grid.showcase.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractSimpleGenericDao<C, I extends Serializable> {

    private static final Logger log = LogManager.getLogger(AbstractSimpleGenericDao.class);

    Class<C> entityClass;

    {
        entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    @PersistenceContext
    public EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public List<C> getAll() {
        try {
            CriteriaQuery<C> query = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
            Root<C> root = query.from(entityClass);
            query.select(root);
            return getEntityManager().createQuery(query).getResultList();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Transactional
    public C get(I id) {
        return getEntityManager().find(entityClass, id);
    }

    @Transactional
    public void save(C object) {
        try {
            getEntityManager().persist(object);
        } catch (RuntimeException e) {
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
    }

    @Transactional
    public void update(C object) {
        try {
            getEntityManager().merge(object);
        } catch (RuntimeException e) {
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
    }

    @Transactional
    public void delete(I id) {
        try {
            C actual = get(id);
            getEntityManager().remove(actual);
        } catch (RuntimeException e) {
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
    }

    void searchInteger(String searchOper, CriteriaBuilder builder, List<Predicate> predicates, String searchString, String searchField, Root<?> root) {
        Integer searchValue = Integer.parseInt(searchString);
        switch (searchOper) {
            case "eq" -> predicates.add(builder.equal(root.get(searchField), searchValue));
            case "ne" -> predicates.add(builder.notEqual(root.get(searchField), searchValue));
            case "lt" -> predicates.add(builder.lessThan(root.get(searchField), searchValue));
            case "gt" -> predicates.add(builder.greaterThan(root.get(searchField), searchValue));
        }
    }
}
