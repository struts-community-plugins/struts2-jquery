package com.jgeppert.struts2.jquery.grid.showcase.model;

import java.sql.Blob;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTLINES", schema = "CLASSICMODELS")
public class Productlines implements java.io.Serializable {

  private static final long serialVersionUID = 3084285926141265568L;
  private String productline;
  private String textdescription;
  private Clob   htmldescription;
  private Blob   image;

  public Productlines() {
  }

  public Productlines(String productline) {
    this.productline = productline;
  }

  public Productlines(String productline, String textdescription, Clob htmldescription, Blob image) {
    this.productline = productline;
    this.textdescription = textdescription;
    this.htmldescription = htmldescription;
    this.image = image;
  }

  @Id
  @Column(name = "PRODUCTLINE", unique = true, length = 50)
  public String getProductline()
  {
    return this.productline;
  }

  public void setProductline(String productline)
  {
    this.productline = productline;
  }

  @Column(name = "TEXTDESCRIPTION", length = 4000)
  public String getTextdescription()
  {
    return this.textdescription;
  }

  public void setTextdescription(String textdescription)
  {
    this.textdescription = textdescription;
  }

  @Column(name = "HTMLDESCRIPTION")
  public Clob getHtmldescription()
  {
    return this.htmldescription;
  }

  public void setHtmldescription(Clob htmldescription)
  {
    this.htmldescription = htmldescription;
  }

  @Column(name = "IMAGE")
  public Blob getImage()
  {
    return this.image;
  }

  public void setImage(Blob image)
  {
    this.image = image;
  }

}
