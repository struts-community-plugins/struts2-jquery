/**
 * 
 */
package com.jgeppert.struts2.jquery.showcase.handlebarsjs;

import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.showcase.datatables.Datatables;
import com.jgeppert.struts2.jquery.showcase.model.Customer;

/**
 * @author flofourcade
 *
 */
public class RandomCustomer extends Datatables {
	
	private Customer myCustomer;
	
	

	@Action( results = { @Result(type = "json")})
	@Override
	public String execute() throws Exception {
		super.execute();
		List<Customer> customers = this.getMyCustomers();
		this.myCustomer = customers.get(RandomUtils.nextInt(customers.size()));
		return SUCCESS;
	}



	public Customer getMyCustomer() {
		return myCustomer;
	}
	
	
	
	

}
