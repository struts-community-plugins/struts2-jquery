package com.jgeppert.struts2.jquery.grid.showcase.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderdetailsId implements java.io.Serializable {

  private static final long serialVersionUID = 4781499547402790067L;
  private Orders order;
  private String  productcode;

  public OrderdetailsId() {
  }

  public OrderdetailsId(Orders order, String productcode) {
    this.order = order;
    this.productcode = productcode;
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

  @Column(name = "PRODUCTCODE", length = 15)
  public String getProductcode()
  {
    return this.productcode;
  }

  public void setProductcode(String productcode)
  {
    this.productcode = productcode;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((order == null) ? 0 : order.hashCode());
    result = prime * result + ((productcode == null) ? 0 : productcode.hashCode());
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
    if (productcode == null)
    {
      if (other.productcode != null) return false;
    }
    else if (!productcode.equals(other.productcode)) return false;
    return true;
  }

}
