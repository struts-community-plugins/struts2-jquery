package com.jgeppert.struts2.jquery.grid.showcase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "OFFICES", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = "OFFICECODE"))
public class Office implements java.io.Serializable {

    private static final long serialVersionUID = 7387431755301762826L;

    @Id
    @Column(name = "OFFICECODE", unique = true, length = 10)
    private String officecode;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "PHONE", length = 50)
    private String phone;

    @Column(name = "ADDRESSLINE1", length = 50)
    private String addressline1;

    @Column(name = "ADDRESSLINE2", length = 50)
    private String addressline2;

    @Column(name = "STATE", length = 50)
    private String state;

    @Column(name = "COUNTRY", length = 50)
    private String country;

    @Column(name = "POSTALCODE", length = 15)
    private String postalcode;

    @Column(name = "TERRITORY", length = 10)
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

    public String getOfficecode() {
        return officecode;
    }

    public void setOfficecode(String officecode) {
        this.officecode = officecode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getTerritory() {
        return territory;
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
