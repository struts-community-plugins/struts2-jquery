package com.jgeppert.struts2.jquery.grid.showcase.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jgeppert.struts2.jquery.grid.showcase.model.Customers;

public class CustomersDao extends AbstractSimpleGenericDao<Customers,Integer> {

	private static final Log log = LogFactory.getLog(CustomersDao.class);
	
	public List<Customers> findFromTo(int from, int to)
	{
	  if(log.isDebugEnabled())
	    log.debug("Return Customers from "+from+" to "+to);
	  
	  return null;
	}
}
