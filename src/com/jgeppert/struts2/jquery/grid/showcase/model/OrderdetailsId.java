package com.jgeppert.struts2.jquery.grid.showcase.model;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderdetailsId implements java.io.Serializable {

  private static final long serialVersionUID = 4781499547402790067L;
  private Orders            order;
  private Products          product;

  public OrderdetailsId() {
  }

  public OrderdetailsId(Orders order, Products product) {
    this.order = order;
    this.product = product;
  }

  @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDERNUMBER", unique = false, nullable = false, insertable = true, updatable = true)
  public Orders getOrder()
  {
    return this.order;
  }

  public void setOrder(Orders order)
  {
    this.order = order;
  }

  @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCTCODE", unique = false, nullable = false, insertable = true, updatable = true)
  public Products getProduct()
  {
    return product;
  }

  public void setProduct(Products product)
  {
    this.product = product;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((order == null) ? 0 : order.hashCode());
    result = prime * result + ((product == null) ? 0 : product.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    OrderdetailsId other = (OrderdetailsId) obj;
    if (order == null)
    {
      if (other.order != null) return false;
    }
    else if (!order.equals(other.order)) return false;
    if (product == null)
    {
      if (other.product != null) return false;
    }
    else if (!product.equals(other.product)) return false;
    return true;
  }

}
