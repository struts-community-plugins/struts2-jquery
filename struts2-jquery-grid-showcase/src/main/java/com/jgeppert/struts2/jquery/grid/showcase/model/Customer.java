package com.jgeppert.struts2.jquery.grid.showcase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "CUSTOMERS", schema = "CLASSICMODELS")
public class Customer implements java.io.Serializable {

    private static final long serialVersionUID = 6222062494710896823L;

    @Id()
    @Column(name = "CUSTOMERNUMBER", unique = true)
    private Integer customernumber;

    @Column(name = "CUSTOMERNAME", length = 50)
    private String customername;

    @Column(name = "CONTACTLASTNAME", length = 50)
    private String contactlastname;

    @Column(name = "CONTACTFIRSTNAME", length = 50)
    private String contactfirstname;

    @Column(name = "PHONE", length = 50)
    private String phone;

    @Column(name = "ADDRESSLINE1", length = 50)
    private String addressline1;

    @Column(name = "ADDRESSLINE2", length = 50)
    private String addressline2;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "STATE", length = 50)
    private String state;

    @Column(name = "POSTALCODE", length = 15)
    private String postalcode;

    @Column(name = "COUNTRY", length = 50)
    private String country;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    @JoinColumn(name = "SALESREPEMPLOYEENUMBER", unique = false, nullable = false, insertable = true, updatable = true)
    private Employee salesemployee;

    @Column(name = "CREDITLIMIT", precision = 52, scale = 0)
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


    public Integer getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(Integer customernumber) {
        this.customernumber = customernumber;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getContactlastname() {
        return contactlastname;
    }

    public void setContactlastname(String contactlastname) {
        this.contactlastname = contactlastname;
    }

    public String getContactfirstname() {
        return contactfirstname;
    }

    public void setContactfirstname(String contactfirstname) {
        this.contactfirstname = contactfirstname;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getSalesemployee() {
        return salesemployee;
    }

    public void setSalesemployee(Employee salesemployee) {
        this.salesemployee = salesemployee;
    }

    public Double getCreditlimit() {
        return creditlimit;
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
