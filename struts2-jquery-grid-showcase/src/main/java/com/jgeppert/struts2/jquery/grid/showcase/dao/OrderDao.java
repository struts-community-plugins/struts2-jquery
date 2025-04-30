package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Order;
import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Named
public class OrderDao extends AbstractSimpleGenericDao<Order, Integer> {
    private static final Logger log = LogManager.getLogger(OrderDao.class);

    public List<Order> findByCriteria(Integer id, String searchField, String searchValue, String searchOper, String sidx, String sord, int from, int size) {
        try {
            CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Order> query = builder.createQuery(Order.class);
            Root<Order> root = query.from(Order.class);
            query.select(root);
            buildSearchPredictions(builder, query, root, id, searchField, searchValue, searchOper, sidx, sord);
            return getEntityManager().createQuery(query)
                    .setFirstResult(from)
                    .setMaxResults(size)
                    .getResultList();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public int countByCriteria(Integer id, String searchField, String searchValue, String searchOper, String sidx, String sord) {
        try {
            CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<Order> root = query.from(Order.class);
            query.select(builder.count(root));
            buildSearchPredictions(builder, query, root, id, searchField, searchValue, searchOper, sidx, sord);
            return getEntityManager().createQuery(query).getSingleResult().intValue();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public void buildSearchPredictions(CriteriaBuilder builder, CriteriaQuery<?> query, Root<?> root, Integer id, String searchField, String searchString, String searchOper, String sidx, String sord) {
        List<Predicate> predicates = new ArrayList<>();

        if (id != null) {
            root.join("customer");
            predicates.add(builder.equal(root.get("customer").get("customernumber"), id));
        }

        if (searchField != null) {
            switch (searchField) {
                case "ordernumber":
                    searchInteger(searchOper, builder, predicates, searchString, searchField, root);
                    break;
                case "status":
                case "comments":
                    switch (searchOper) {
                        case "eq" -> predicates.add(builder.equal(root.get(searchField), searchString));
                        case "ne" -> predicates.add(builder.notEqual(root.get(searchField), searchString));
                        case "bw" -> predicates.add(builder.like(root.get(searchField), searchString + "%"));
                        case "cn" -> predicates.add(builder.like(root.get(searchField), "%" + searchString + "%"));
                    }
                    break;
                case "customer":
                    Integer customerSearchValue = Integer.parseInt(searchString);
                    root.join("customer");
                    switch (searchOper) {
                        case "eq" ->
                                predicates.add(builder.equal(root.get(searchField).get("customernumber"), customerSearchValue));
                        case "ne" ->
                                predicates.add(builder.notEqual(root.get(searchField).get("customernumber"), customerSearchValue));
                        case "lt" ->
                                predicates.add(builder.lessThan(root.get(searchField).get("customernumber"), customerSearchValue));
                        case "gt" ->
                                predicates.add(builder.greaterThan(root.get(searchField).get("customernumber"), customerSearchValue));
                    }
                    break;
            }
        }

        query.where(predicates.toArray(new Predicate[0]));

        if (sidx != null && !sidx.equals("")) {
            if (!sidx.equals("customer")) {
                if (sord.equals("asc")) query.orderBy(builder.asc(root.get(sidx)));
                else query.orderBy(builder.desc(root.get(sidx)));
            } else {
                if (sord.equals("asc")) query.orderBy(builder.asc(root.get("customer").get("customernumber")));
                else query.orderBy(builder.desc(root.get("customer").get("customernumber")));
            }
        }
    }
}