package com.jgeppert.struts2.jquery.grid.showcase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "OFFICES", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = "OFFICECODE"))
public class Offices implements java.io.Serializable {

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

  public Offices() {
  }

  public Offices(String officecode, String city, String phone, String addressline1, String addressline2, String state, String country, String postalcode, String territory) {
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
  public String getOfficecode()
  {
    return this.officecode;
  }

  public void setOfficecode(String officecode)
  {
    this.officecode = officecode;
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

  @Column(name = "STATE", length = 50)
  public String getState()
  {
    return this.state;
  }

  public void setState(String state)
  {
    this.state = state;
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

  @Column(name = "POSTALCODE", length = 15)
  public String getPostalcode()
  {
    return this.postalcode;
  }

  public void setPostalcode(String postalcode)
  {
    this.postalcode = postalcode;
  }

  @Column(name = "TERRITORY", length = 10)
  public String getTerritory()
  {
    return this.territory;
  }

  public void setTerritory(String territory)
  {
    this.territory = territory;
  }

  @Override
  public boolean equals(Object other)
  {
    if ((this == other)) return true;
    if ((other == null)) return false;
    if (!(other instanceof Offices)) return false;
    Offices castOther = (Offices) other;

    return ((this.getOfficecode() == castOther.getOfficecode()) || (this.getOfficecode() != null && castOther.getOfficecode() != null && this.getOfficecode().equals(castOther.getOfficecode()))) && ((this.getCity() == castOther.getCity()) || (this.getCity() != null && castOther.getCity() != null && this.getCity().equals(castOther.getCity()))) && ((this.getPhone() == castOther.getPhone()) || (this.getPhone() != null && castOther.getPhone() != null && this.getPhone().equals(castOther.getPhone()))) && ((this.getAddressline1() == castOther.getAddressline1()) || (this.getAddressline1() != null && castOther.getAddressline1() != null && this.getAddressline1().equals(castOther.getAddressline1()))) && ((this.getAddressline2() == castOther.getAddressline2()) || (this.getAddressline2() != null && castOther.getAddressline2() != null && this.getAddressline2().equals(castOther.getAddressline2()))) && ((this.getState() == castOther.getState()) || (this.getState() != null && castOther.getState() != null && this.getState().equals(castOther.getState()))) && ((this.getCountry() == castOther.getCountry()) || (this.getCountry() != null && castOther.getCountry() != null && this.getCountry().equals(castOther.getCountry()))) && ((this.getPostalcode() == castOther.getPostalcode()) || (this.getPostalcode() != null && castOther.getPostalcode() != null && this.getPostalcode().equals(castOther.getPostalcode()))) && ((this.getTerritory() == castOther.getTerritory()) || (this.getTerritory() != null && castOther.getTerritory() != null && this.getTerritory().equals(castOther.getTerritory())));
  }

  @Override
  public int hashCode()
  {
    int result = 17;

    result = 37 * result + (getOfficecode() == null ? 0 : this.getOfficecode().hashCode());
    result = 37 * result + (getCity() == null ? 0 : this.getCity().hashCode());
    result = 37 * result + (getPhone() == null ? 0 : this.getPhone().hashCode());
    result = 37 * result + (getAddressline1() == null ? 0 : this.getAddressline1().hashCode());
    result = 37 * result + (getAddressline2() == null ? 0 : this.getAddressline2().hashCode());
    result = 37 * result + (getState() == null ? 0 : this.getState().hashCode());
    result = 37 * result + (getCountry() == null ? 0 : this.getCountry().hashCode());
    result = 37 * result + (getPostalcode() == null ? 0 : this.getPostalcode().hashCode());
    result = 37 * result + (getTerritory() == null ? 0 : this.getTerritory().hashCode());
    return result;
  }
}
