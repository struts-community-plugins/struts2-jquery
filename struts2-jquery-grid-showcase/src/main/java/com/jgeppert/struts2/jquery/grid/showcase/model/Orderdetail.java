package com.jgeppert.struts2.jquery.grid.showcase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;

@Entity
@Table(name = "ORDERDETAILS", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = {
        "ORDERNUMBER", "PRODUCTCODE"
}))
public class OrderDetail implements java.io.Serializable {

    private static final long serialVersionUID = 8579786902541290122L;
    private OrderDetailId id;
    private Integer quantityordered;
    private Double priceeach;
    private Short orderlinenumber;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailId id) {
        this.id = id;
    }

    public OrderDetail(OrderDetailId id, Integer quantityordered, Double priceeach, Short orderlinenumber) {
        this.id = id;
        this.quantityordered = quantityordered;
        this.priceeach = priceeach;
        this.orderlinenumber = orderlinenumber;
    }

    @JSON(serialize = false)
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "order", column = @Column(name = "ORDERNUMBER")), @AttributeOverride(name = "product", column = @Column(name = "PRODUCTCODE", length = 15))
    })
    public OrderDetailId getId() {
        return this.id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }

    @Column(name = "QUANTITYORDERED")
    public Integer getQuantityordered() {
        return this.quantityordered;
    }

    public void setQuantityordered(Integer quantityordered) {
        this.quantityordered = quantityordered;
    }

    @Column(name = "PRICEEACH", precision = 52, scale = 0)
    public Double getPriceeach() {
        return this.priceeach;
    }

    public void setPriceeach(Double priceeach) {
        this.priceeach = priceeach;
    }

    @Column(name = "ORDERLINENUMBER")
    public Short getOrderlinenumber() {
        return this.orderlinenumber;
    }

    public void setOrderlinenumber(Short orderlinenumber) {
        this.orderlinenumber = orderlinenumber;
    }

    @Transient
    public String getProductname() {
        if (this.id != null) return this.id.getProduct().getProductname();
        else return "";
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetail other = (OrderDetail) o;

        return new EqualsBuilder().append(this.id, other.id).append(this.quantityordered, other.quantityordered).append(this.priceeach, other.priceeach).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.id)
                .append(this.quantityordered)
                .append(this.priceeach)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.id)
                .append(this.quantityordered)
                .append(this.priceeach)
                .append(this.orderlinenumber)
                .toString();
    }
}
