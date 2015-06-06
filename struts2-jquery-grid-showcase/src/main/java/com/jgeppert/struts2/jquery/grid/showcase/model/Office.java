package com.jgeppert.struts2.jquery.grid.showcase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "OFFICES", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = "OFFICECODE"))
public class Office implements java.io.Serializable {

    private static final long serialVersionUID = 7387431755301762826L;
    private String officecode;
    private String city;
    private String phone;
    private String addressline1;
    private String addressline2;
    private String state;
    private String country;
    private String postalcode;
    private String territory;

    public Office() {
    }

    public Office(String officecode, String city, String phone, String addressline1, String addressline2, String state, String country, String postalcode, String territory) {
        this.officecode = officecode;
        this.city = city;
        this.phone = phone;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.state = state;
        this.country = country;
        this.postalcode = postalcode;
        this.territory = territory;
    }

    @Id
    @Column(name = "OFFICECODE", unique = true, length = 10)
    public String getOfficecode() {
        return this.officecode;
    }

    public void setOfficecode(String officecode) {
        this.officecode = officecode;
    }

    @Column(name = "CITY", length = 50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "PHONE", length = 50)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "ADDRESSLINE1", length = 50)
    public String getAddressline1() {
        return this.addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    @Column(name = "ADDRESSLINE2", length = 50)
    public String getAddressline2() {
        return this.addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    @Column(name = "STATE", length = 50)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "COUNTRY", length = 50)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "POSTALCODE", length = 15)
    public String getPostalcode() {
        return this.postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Column(name = "TERRITORY", length = 10)
    public String getTerritory() {
        return this.territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office other = (Office) o;

        return new EqualsBuilder().append(this.officecode, other.officecode).append(this.city, other.city).append(this.country, other.country).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.officecode)
                .append(this.country)
                .append(this.city)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.officecode)
                .append(this.country)
                .append(this.city)
                .append(this.state)
                .toString();
    }
}
