package com.jgeppert.struts2.jquery.grid.showcase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Embeddable
public class PaymentId implements java.io.Serializable {

    private static final long serialVersionUID = 7491499547402790067L;

    @Column(name = "CUSTOMERNUMBER")
    private Integer customernumber;

    @Column(name = "CHECKNUMBER", length = 50)
    private String checknumber;

    public PaymentId() {
    }

    public PaymentId(Integer customernumber, String checknumber) {
        this.customernumber = customernumber;
        this.checknumber = checknumber;
    }

    public Integer getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(Integer customernumber) {
        this.customernumber = customernumber;
    }

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentId other = (PaymentId) o;

        return new EqualsBuilder().append(this.customernumber, other.customernumber).append(this.checknumber, other.checknumber).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.customernumber)
                .append(this.checknumber)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.customernumber)
                .append(this.checknumber)
                .toString();
    }

}
