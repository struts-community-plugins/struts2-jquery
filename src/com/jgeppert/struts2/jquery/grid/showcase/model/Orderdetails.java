package com.jgeppert.struts2.jquery.grid.showcase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ORDERDETAILS", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = {
    "ORDERNUMBER", "PRODUCTCODE"
}))
public class Orderdetails implements java.io.Serializable {

  private static final long serialVersionUID = 8579786902541290122L;
  private Integer ordernumber;
  private String  productcode;
  private Integer quantityordered;
  private Double  priceeach;
  private Short   orderlinenumber;

  public Orderdetails() {
  }

  public Orderdetails(Integer ordernumber) {
    this.ordernumber = ordernumber;
  }

  public Orderdetails(Integer ordernumber, String productcode, Integer quantityordered, Double priceeach, Short orderlinenumber) {
    this.ordernumber = ordernumber;
    this.productcode = productcode;
    this.quantityordered = quantityordered;
    this.priceeach = priceeach;
    this.orderlinenumber = orderlinenumber;
  }

  @Id
  @Column(name = "ORDERNUMBER")
  public Integer getOrdernumber()
  {
    return this.ordernumber;
  }

  public void setOrdernumber(Integer ordernumber)
  {
    this.ordernumber = ordernumber;
  }

  @Column(name = "PRODUCTCODE", length = 15)
  public String getProductcode()
  {
    return this.productcode;
  }

  public void setProductcode(String productcode)
  {
    this.productcode = productcode;
  }

  @Column(name = "QUANTITYORDERED")
  public Integer getQuantityordered()
  {
    return this.quantityordered;
  }

  public void setQuantityordered(Integer quantityordered)
  {
    this.quantityordered = quantityordered;
  }

  @Column(name = "PRICEEACH", precision = 52, scale = 0)
  public Double getPriceeach()
  {
    return this.priceeach;
  }

  public void setPriceeach(Double priceeach)
  {
    this.priceeach = priceeach;
  }

  @Column(name = "ORDERLINENUMBER")
  public Short getOrderlinenumber()
  {
    return this.orderlinenumber;
  }

  public void setOrderlinenumber(Short orderlinenumber)
  {
    this.orderlinenumber = orderlinenumber;
  }

}
