package com.jgeppert.struts2.jquery.grid.showcase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderDetailId implements java.io.Serializable {

    private static final long serialVersionUID = 4781499547402790067L;
    private Order order;
    private Product product;

    public OrderDetailId() {
    }

    public OrderDetailId(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDERNUMBER", unique = false, nullable = false, insertable = true, updatable = true)
    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTCODE", unique = false, nullable = false, insertable = true, updatable = true)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailId other = (OrderDetailId) o;

        return new EqualsBuilder().append(this.order, other.order).append(this.product, other.product).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.order)
                .append(this.product)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.order)
                .append(this.product)
                .toString();
    }
}
