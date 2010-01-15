package com.jgeppert.struts2.jquery.grid.showcase.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS", schema = "CLASSICMODELS")
public class Customers implements java.io.Serializable {

  private static final long serialVersionUID = 6222062494710896823L;
  private Integer           customernumber;
  private String            customername;
  private String            contactlastname;
  private String            contactfirstname;
  private String            phone;
  private String            addressline1;
  private String            addressline2;
  private String            city;
  private String            state;
  private String            postalcode;
  private String            country;
  private Employees         salesemployee;
  private Double            creditlimit;
  private Set<Orders>       orders;

  public Customers() {
  }

  public Customers(Integer customernumber) {
    this.customernumber = customernumber;
  }

  public Customers(Integer customernumber, String customername, String contactlastname, String contactfirstname, String phone, String addressline1, String addressline2, String city, String state, String postalcode, String country, Employees salesemployee, Double creditlimit) {
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CUSTOMERNUMBER", unique = true)
  public Integer getCustomernumber()
  {
    return this.customernumber;
  }

  public void setCustomernumber(Integer customernumber)
  {
    this.customernumber = customernumber;
  }

  @Column(name = "CUSTOMERNAME", length = 50)
  public String getCustomername()
  {
    return this.customername;
  }

  public void setCustomername(String customername)
  {
    this.customername = customername;
  }

  @Column(name = "CONTACTLASTNAME", length = 50)
  public String getContactlastname()
  {
    return this.contactlastname;
  }

  public void setContactlastname(String contactlastname)
  {
    this.contactlastname = contactlastname;
  }

  @Column(name = "CONTACTFIRSTNAME", length = 50)
  public String getContactfirstname()
  {
    return this.contactfirstname;
  }

  public void setContactfirstname(String contactfirstname)
  {
    this.contactfirstname = contactfirstname;
  }

  @Column(name = "PHONE", length = 50)
  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  @Column(name = "ADDRESSLINE1", length = 50)
  public String getAddressline1()
  {
    return this.addressline1;
  }

  public void setAddressline1(String addressline1)
  {
    this.addressline1 = addressline1;
  }

  @Column(name = "ADDRESSLINE2", length = 50)
  public String getAddressline2()
  {
    return this.addressline2;
  }

  public void setAddressline2(String addressline2)
  {
    this.addressline2 = addressline2;
  }

  @Column(name = "CITY", length = 50)
  public String getCity()
  {
    return this.city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  @Column(name = "STATE", length = 50)
  public String getState()
  {
    return this.state;
  }

  public void setState(String state)
  {
    this.state = state;
  }

  @Column(name = "POSTALCODE", length = 15)
  public String getPostalcode()
  {
    return this.postalcode;
  }

  public void setPostalcode(String postalcode)
  {
    this.postalcode = postalcode;
  }

  @Column(name = "COUNTRY", length = 50)
  public String getCountry()
  {
    return this.country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
  @JoinColumn(name = "SALESREPEMPLOYEENUMBER", unique = false, nullable = false, insertable = true, updatable = true)
  public Employees getSalesemployee()
  {
    return salesemployee;
  }

  public void setSalesemployee(Employees salesemployee)
  {
    this.salesemployee = salesemployee;
  }

  @Column(name = "CREDITLIMIT", precision = 52, scale = 0)
  public Double getCreditlimit()
  {
    return this.creditlimit;
  }

  public void setCreditlimit(Double creditlimit)
  {
    this.creditlimit = creditlimit;
  }

  /*
   * @JSON(serialize=false)
   * 
   * @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy
   * = "customer")
   * 
   * @OrderBy(value = "orderdate") public Set<Orders> getOrders() { return
   * orders; }
   */

  public void setOrders(Set<Orders> orders)
  {
    this.orders = orders;
  }

}
