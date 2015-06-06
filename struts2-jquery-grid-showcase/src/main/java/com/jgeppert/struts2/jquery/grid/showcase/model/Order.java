package com.jgeppert.struts2.jquery.grid.showcase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = "ORDERNUMBER"))
public class Order implements java.io.Serializable {

    private static final long serialVersionUID = 206351521908904760L;
    private Integer ordernumber;
    private Date orderdate;
    private Date requireddate;
    private Date shippeddate;
    private String status;
    private String comments;
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
