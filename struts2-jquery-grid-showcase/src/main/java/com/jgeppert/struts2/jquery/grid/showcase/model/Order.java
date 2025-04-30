package com.jgeppert.struts2.jquery.grid.showcase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@Entity
@Table(name = "ORDERS", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = "ORDERNUMBER"))
public class Order implements java.io.Serializable {

    private static final long serialVersionUID = 206351521908904760L;

    @Id
    @Column(name = "ORDERNUMBER", unique = true)
    private Integer ordernumber;

    @Column(name = "ORDERDATE")
    private Date orderdate;

    @Column(name = "REQUIREDDATE")
    private Date requireddate;

    @Column(name = "SHIPPEDDATE")
    private Date shippeddate;

    @Column(name = "STATUS", length = 15)
    private String status;

    @Column(name = "COMMENTS", length = 32700)
    private String comments;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMERNUMBER", unique = false, nullable = false, insertable = true, updatable = true)
    private Customer customer;

    public Order() {
    }

    public Order(Integer ordernumber, Date orderdate, Date requireddate, Date shippeddate, String status, String comments, Customer customer) {
        this.ordernumber = ordernumber;
        this.orderdate = orderdate;
        this.requireddate = requireddate;
        this.shippeddate = shippeddate;
        this.status = status;
        this.comments = comments;
        this.customer = customer;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getRequireddate() {
        return requireddate;
    }

    public void setRequireddate(Date requireddate) {
        this.requireddate = requireddate;
    }

    public Date getShippeddate() {
        return shippeddate;
    }

    public void setShippeddate(Date shippeddate) {
        this.shippeddate = shippeddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order other = (Order) o;

        return new EqualsBuilder().append(this.ordernumber, other.ordernumber).append(this.orderdate, other.orderdate).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.ordernumber)
                .append(this.orderdate)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.ordernumber)
                .append(this.orderdate)
                .append(this.requireddate)
                .append(this.shippeddate)
                .append(this.status)
                .toString();
    }
}
