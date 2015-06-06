package com.jgeppert.struts2.jquery.grid.showcase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS", schema = "CLASSICMODELS")
public class Customer implements java.io.Serializable {

    private static final long serialVersionUID = 6222062494710896823L;
    private Integer customernumber;
    private String customername;
    private String contactlastname;
    private String contactfirstname;
    private String phone;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String postalcode;
    private String country;
    private Employee salesemployee;
    private Double creditlimit;

    public Customer() {
    }

    public Customer(Integer customernumber) {
        this.customernumber = customernumber;
    }

    public Customer(Integer customernumber, String customername, String contactlastname, String contactfirstname, String phone, String addressline1, String addressline2, String city, String state, String postalcode, String country, Employee salesemployee, Double creditlimit) {
        this.customernumber = customernumber;
        this.customername = customername;
        this.contactlastname = contactlastname;
        this.contactfirstname = contactfirstname;
        this.phone = phone;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.postalcode = postalcode;
        this.country = country;
        this.salesemployee = salesemployee;
        this.creditlimit = creditlimit;
    }

    @Id()
    @Column(name = "CUSTOMERNUMBER", unique = true)
    public Integer getCustomernumber() {
        return this.customernumber;
    }

    public void setCustomernumber(Integer customernumber) {
        this.customernumber = customernumber;
    }

    @Column(name = "CUSTOMERNAME", length = 50)
    public String getCustomername() {
        return this.customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    @Column(name = "CONTACTLASTNAME", length = 50)
    public String getContactlastname() {
        return this.contactlastname;
    }

    public void setContactlastname(String contactlastname) {
        this.contactlastname = contactlastname;
    }

    @Column(name = "CONTACTFIRSTNAME", length = 50)
    public String getContactfirstname() {
        return this.contactfirstname;
    }

    public void setContactfirstname(String contactfirstname) {
        this.contactfirstname = contactfirstname;
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

    @Column(name = "CITY", length = 50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "STATE", length = 50)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "POSTALCODE", length = 15)
    public String getPostalcode() {
        return this.postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Column(name = "COUNTRY", length = 50)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    @JoinColumn(name = "SALESREPEMPLOYEENUMBER", unique = false, nullable = false, insertable = true, updatable = true)
    public Employee getSalesemployee() {
        return salesemployee;
    }

    public void setSalesemployee(Employee salesemployee) {
        this.salesemployee = salesemployee;
    }

    @Column(name = "CREDITLIMIT", precision = 52, scale = 0)
    public Double getCreditlimit() {
        return this.creditlimit;
    }

    public void setCreditlimit(Double creditlimit) {
        this.creditlimit = creditlimit;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer other = (Customer) o;

        return new EqualsBuilder().append(this.customernumber, other.customernumber).append(this.customername, other.customername).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.customernumber)
                .append(this.customername)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.customernumber)
                .append(this.customername)
                .append(this.country)
                .append(this.city)
                .toString();
    }

}
