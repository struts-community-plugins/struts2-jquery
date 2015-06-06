package com.jgeppert.struts2.jquery.grid.showcase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaymentId implements java.io.Serializable {

    private static final long serialVersionUID = 7491499547402790067L;
    private Integer customernumber;
    private String checknumber;

    public PaymentId() {
    }

    public PaymentId(Integer customernumber, String checknumber) {
        this.customernumber = customernumber;
        this.checknumber = checknumber;
    }

    @Column(name = "CUSTOMERNUMBER")
    public Integer getCustomernumber() {
        return this.customernumber;
    }

    public void setCustomernumber(Integer customernumber) {
        this.customernumber = customernumber;
    }

    @Column(name = "CHECKNUMBER", length = 50)
    public String getChecknumber() {
        return this.checknumber;
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
