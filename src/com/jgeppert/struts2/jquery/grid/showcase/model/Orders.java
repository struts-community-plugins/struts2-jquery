package com.jgeppert.struts2.jquery.grid.showcase.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ORDERS", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = "ORDERNUMBER"))
public class Orders implements java.io.Serializable
{

	private static final long	serialVersionUID	= 206351521908904760L;
	private Integer				ordernumber;
	private Date				orderdate;
	private Date				requireddate;
	private Date				shippeddate;
	private String				status;
	private String				comments;
	private Customers			customer;

	public Orders()
	{
	}

	public Orders(Integer ordernumber, Date orderdate, Date requireddate, Date shippeddate, String status, String comments, Customers customer)
	{
		this.ordernumber = ordernumber;
		this.orderdate = orderdate;
		this.requireddate = requireddate;
		this.shippeddate = shippeddate;
		this.status = status;
		this.comments = comments;
		this.customer = customer;
	}

	@Id
	@Column(name = "ORDERNUMBER", unique = true)
	public Integer getOrdernumber() {
		return this.ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	@Column(name = "ORDERDATE")
	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@Column(name = "REQUIREDDATE")
	public Date getRequireddate() {
		return this.requireddate;
	}

	public void setRequireddate(Date requireddate) {
		this.requireddate = requireddate;
	}

	@Column(name = "SHIPPEDDATE")
	public Date getShippeddate() {
		return this.shippeddate;
	}

	public void setShippeddate(Date shippeddate) {
		this.shippeddate = shippeddate;
	}

	@Column(name = "STATUS", length = 15)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "COMMENTS", length = 32700)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMERNUMBER", unique = false, nullable = false, insertable = true, updatable = true)
	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other)) return true;
		if ((other == null)) return false;
		if (!(other instanceof Orders)) return false;
		Orders castOther = (Orders) other;

		return ((this.getOrdernumber() == castOther.getOrdernumber()) || (this.getOrdernumber() != null && castOther.getOrdernumber() != null && this.getOrdernumber().equals(castOther.getOrdernumber())))
				&& ((this.getOrderdate() == castOther.getOrderdate()) || (this.getOrderdate() != null && castOther.getOrderdate() != null && this.getOrderdate().equals(castOther.getOrderdate())))
				&& ((this.getRequireddate() == castOther.getRequireddate()) || (this.getRequireddate() != null && castOther.getRequireddate() != null && this.getRequireddate().equals(castOther.getRequireddate())))
				&& ((this.getShippeddate() == castOther.getShippeddate()) || (this.getShippeddate() != null && castOther.getShippeddate() != null && this.getShippeddate().equals(castOther.getShippeddate())))
				&& ((this.getStatus() == castOther.getStatus()) || (this.getStatus() != null && castOther.getStatus() != null && this.getStatus().equals(castOther.getStatus())))
				&& ((this.getComments() == castOther.getComments()) || (this.getComments() != null && castOther.getComments() != null && this.getComments().equals(castOther.getComments())))
				&& ((this.getCustomer() == castOther.getCustomer()) || (this.getCustomer() != null && castOther.getCustomer() != null && this.getCustomer().equals(castOther.getCustomer())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOrdernumber() == null ? 0 : this.getOrdernumber().hashCode());
		result = 37 * result + (getOrderdate() == null ? 0 : this.getOrderdate().hashCode());
		result = 37 * result + (getRequireddate() == null ? 0 : this.getRequireddate().hashCode());
		result = 37 * result + (getShippeddate() == null ? 0 : this.getShippeddate().hashCode());
		result = 37 * result + (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37 * result + (getComments() == null ? 0 : this.getComments().hashCode());
		result = 37 * result + (getCustomer() == null ? 0 : this.getCustomer().hashCode());
		return result;
	}
}
