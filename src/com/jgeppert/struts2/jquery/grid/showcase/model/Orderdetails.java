package com.jgeppert.struts2.jquery.grid.showcase.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.struts2.json.annotations.JSON;

@Entity
@Table(name = "ORDERDETAILS", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = {
    "ORDERNUMBER", "PRODUCTCODE"
}))
public class Orderdetails implements java.io.Serializable {

  private static final long serialVersionUID = 8579786902541290122L;
  private OrderdetailsId    id;
  private Integer           quantityordered;
  private Double            priceeach;
  private Short             orderlinenumber;

  public Orderdetails() {
  }

  public Orderdetails(OrderdetailsId id) {
    this.id = id;
  }

  public Orderdetails(OrderdetailsId id, Integer quantityordered, Double priceeach, Short orderlinenumber) {
    this.id = id;
    this.quantityordered = quantityordered;
    this.priceeach = priceeach;
    this.orderlinenumber = orderlinenumber;
  }

  @JSON(serialize = false)
  @EmbeddedId
  @AttributeOverrides( {
      @AttributeOverride(name = "order", column = @Column(name = "ORDERNUMBER")), @AttributeOverride(name = "product", column = @Column(name = "PRODUCTCODE", length = 15))
  })
  public OrderdetailsId getId()
  {
    return this.id;
  }

  public void setId(OrderdetailsId id)
  {
    this.id = id;
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

  @Transient
  public String getProductname()
  {
    if (this.id != null) return this.id.getProduct().getProductname();
    else return "";
  }
}
