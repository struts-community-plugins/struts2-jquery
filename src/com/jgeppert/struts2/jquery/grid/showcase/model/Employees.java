package com.jgeppert.struts2.jquery.grid.showcase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES", schema = "CLASSICMODELS")
public class Employees implements java.io.Serializable {

  private static final long serialVersionUID = 6453568010319106998L;
  private Integer           employeenumber;
  private String            lastname;
  private String            firstname;
  private String            extension;
  private String            email;
  private Offices           office;
  private Integer           reportsto;
  private String            jobtitle;

  public Employees() {
  }

  public Employees(Integer employeenumber) {
    this.employeenumber = employeenumber;
  }

  public Employees(Integer employeenumber, String lastname, String firstname, String extension, String email, Offices office, Integer reportsto, String jobtitle) {
    this.employeenumber = employeenumber;
    this.lastname = lastname;
    this.firstname = firstname;
    this.extension = extension;
    this.email = email;
    this.office = office;
    this.reportsto = reportsto;
    this.jobtitle = jobtitle;
  }

  @Id
  @Column(name = "EMPLOYEENUMBER", unique = true)
  public Integer getEmployeenumber()
  {
    return this.employeenumber;
  }

  public void setEmployeenumber(Integer employeenumber)
  {
    this.employeenumber = employeenumber;
  }

  @Column(name = "LASTNAME", length = 50)
  public String getLastname()
  {
    return this.lastname;
  }

  public void setLastname(String lastname)
  {
    this.lastname = lastname;
  }

  @Column(name = "FIRSTNAME", length = 50)
  public String getFirstname()
  {
    return this.firstname;
  }

  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }

  @Column(name = "EXTENSION", length = 10)
  public String getExtension()
  {
    return this.extension;
  }

  public void setExtension(String extension)
  {
    this.extension = extension;
  }

  @Column(name = "EMAIL", length = 100)
  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
  @JoinColumn(name = "OFFICECODE", unique = false, nullable = false, insertable = true, updatable = true)
  public Offices getOffice()
  {
    return office;
  }

  public void setOffice(Offices office)
  {
    this.office = office;
  }

  @Column(name = "REPORTSTO")
  public Integer getReportsto()
  {
    return this.reportsto;
  }

  public void setReportsto(Integer reportsto)
  {
    this.reportsto = reportsto;
  }

  @Column(name = "JOBTITLE", length = 50)
  public String getJobtitle()
  {
    return this.jobtitle;
  }

  public void setJobtitle(String jobtitle)
  {
    this.jobtitle = jobtitle;
  }

  @Override
  public String toString()
  {
    return lastname + ", " + firstname;
  }
}
