package com.jgeppert.struts2.jquery.grid.showcase.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Embeddable
public class OrderDetailId implements java.io.Serializable {

    private static final long serialVersionUID = 4781499547402790067L;

    @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDERNUMBER", unique = false, nullable = false, insertable = true, updatable = true)
    private Order order;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCTCODE", unique = false, nullable = false, insertable = true, updatable = true)
    private Product product;

    public OrderDetailId() {
    }

    public OrderDetailId(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

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
