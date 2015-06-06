package com.jgeppert.struts2.jquery.grid.showcase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PAYMENTS", schema = "CLASSICMODELS")
public class Payment implements java.io.Serializable {

    private static final long serialVersionUID = -8839175465382345399L;
    private PaymentId id;
    private Date paymentdate;
    private Double amount;

    public Payment() {
    }

    public Payment(PaymentId id) {
        this.id = id;
    }

    public Payment(PaymentId id, Date paymentdate, Double amount) {
        this.id = id;
        this.paymentdate = paymentdate;
        this.amount = amount;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "customernumber", column = @Column(name = "CUSTOMERNUMBER")), @AttributeOverride(name = "checknumber", column = @Column(name = "CHECKNUMBER", length = 50))
    })
    public PaymentId getId() {
        return this.id;
    }

    public void setId(PaymentId id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "PAYMENTDATE")
    public Date getPaymentdate() {
        return this.paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    @Column(name = "AMOUNT", precision = 52, scale = 0)
    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment other = (Payment) o;

        return new EqualsBuilder().append(this.id, other.id).append(this.paymentdate, other.paymentdate).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.id)
                .append(this.paymentdate)
                .append(this.amount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.id)
                .append(this.paymentdate)
                .append(this.amount)
                .toString();
    }

}
