package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Employee;
import jakarta.inject.Named;
import org.springframework.stereotype.Repository;

@Repository
@Named
public class EmployeeDao extends AbstractSimpleGenericDao<Employee, Integer> {
}
