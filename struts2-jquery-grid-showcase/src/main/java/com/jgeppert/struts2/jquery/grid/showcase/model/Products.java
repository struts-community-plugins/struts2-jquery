package com.jgeppert.struts2.jquery.grid.showcase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PRODUCTS", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = "PRODUCTCODE"))
public class Products implements java.io.Serializable {

  private static final long serialVersionUID = -2553404106252086434L;
  private String  productcode;
  private String  productname;
  private Productlines  productline;
  private String  productscale;
  private String  productvendor;
  private String  productdescription;
  private Integer quantityinstock;
  private Double  buyprice;
  private Double  msrp;

  public Products() {
  }

  public Products(String productcode, String productname, Productlines productline, String productscale, String productvendor, String productdescription, Integer quantityinstock, Double buyprice, Double msrp) {
    this.productcode = productcode;
    this.productname = productname;
    this.productline = productline;
    this.productscale = productscale;
    this.productvendor = productvendor;
    this.productdescription = productdescription;
    this.quantityinstock = quantityinstock;
    this.buyprice = buyprice;
    this.msrp = msrp;
  }

  @Id
  @Column(name = "PRODUCTCODE", unique = true, length = 15)
  public String getProductcode()
  {
    return this.productcode;
  }

  public void setProductcode(String productcode)
  {
    this.productcode = productcode;
  }

  @Column(name = "PRODUCTNAME", length = 70)
  public String getProductname()
  {
    return this.productname;
  }

  public void setProductname(String productname)
  {
    this.productname = productname;
  }

  @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCTLINE", unique = false, nullable = false, insertable = true, updatable = true)
  public Productlines getProductline()
  {
    return this.productline;
  }

  public void setProductline(Productlines productline)
  {
    this.productline = productline;
  }

  @Column(name = "PRODUCTSCALE", length = 10)
  public String getProductscale()
  {
    return this.productscale;
  }

  public void setProductscale(String productscale)
  {
    this.productscale = productscale;
  }

  @Column(name = "PRODUCTVENDOR", length = 50)
  public String getProductvendor()
  {
    return this.productvendor;
  }

  public void setProductvendor(String productvendor)
  {
    this.productvendor = productvendor;
  }

  @Column(name = "PRODUCTDESCRIPTION", length = 32700)
  public String getProductdescription()
  {
    return this.productdescription;
  }

  public void setProductdescription(String productdescription)
  {
    this.productdescription = productdescription;
  }

  @Column(name = "QUANTITYINSTOCK")
  public Integer getQuantityinstock()
  {
    return this.quantityinstock;
  }

  public void setQuantityinstock(Integer quantityinstock)
  {
    this.quantityinstock = quantityinstock;
  }

  @Column(name = "BUYPRICE", precision = 52, scale = 0)
  public Double getBuyprice()
  {
    return this.buyprice;
  }

  public void setBuyprice(Double buyprice)
  {
    this.buyprice = buyprice;
  }

  @Column(name = "MSRP", precision = 52, scale = 0)
  public Double getMsrp()
  {
    return this.msrp;
  }

  public void setMsrp(Double msrp)
  {
    this.msrp = msrp;
  }

  @Override
  public boolean equals(Object other)
  {
    if ((this == other)) return true;
    if ((other == null)) return false;
    if (!(other instanceof Products)) return false;
    Products castOther = (Products) other;

    return ((this.getProductcode() == castOther.getProductcode()) || (this.getProductcode() != null && castOther.getProductcode() != null && this.getProductcode().equals(castOther.getProductcode()))) && ((this.getProductname() == castOther.getProductname()) || (this.getProductname() != null && castOther.getProductname() != null && this.getProductname().equals(castOther.getProductname()))) && ((this.getProductline() == castOther.getProductline()) || (this.getProductline() != null && castOther.getProductline() != null && this.getProductline().equals(castOther.getProductline()))) && ((this.getProductscale() == castOther.getProductscale()) || (this.getProductscale() != null && castOther.getProductscale() != null && this.getProductscale().equals(castOther.getProductscale()))) && ((this.getProductvendor() == castOther.getProductvendor()) || (this.getProductvendor() != null && castOther.getProductvendor() != null && this.getProductvendor().equals(castOther.getProductvendor()))) && ((this.getProductdescription() == castOther.getProductdescription()) || (this.getProductdescription() != null && castOther.getProductdescription() != null && this.getProductdescription().equals(castOther.getProductdescription()))) && ((this.getQuantityinstock() == castOther.getQuantityinstock()) || (this.getQuantityinstock() != null && castOther.getQuantityinstock() != null && this.getQuantityinstock().equals(castOther.getQuantityinstock()))) && ((this.getBuyprice() == castOther.getBuyprice()) || (this.getBuyprice() != null && castOther.getBuyprice() != null && this.getBuyprice().equals(castOther.getBuyprice()))) && ((this.getMsrp() == castOther.getMsrp()) || (this.getMsrp() != null && castOther.getMsrp() != null && this.getMsrp().equals(castOther.getMsrp())));
  }

  @Override
  public int hashCode()
  {
    int result = 17;

    result = 37 * result + (getProductcode() == null ? 0 : this.getProductcode().hashCode());
    result = 37 * result + (getProductname() == null ? 0 : this.getProductname().hashCode());
    result = 37 * result + (getProductline() == null ? 0 : this.getProductline().hashCode());
    result = 37 * result + (getProductscale() == null ? 0 : this.getProductscale().hashCode());
    result = 37 * result + (getProductvendor() == null ? 0 : this.getProductvendor().hashCode());
    result = 37 * result + (getProductdescription() == null ? 0 : this.getProductdescription().hashCode());
    result = 37 * result + (getQuantityinstock() == null ? 0 : this.getQuantityinstock().hashCode());
    result = 37 * result + (getBuyprice() == null ? 0 : this.getBuyprice().hashCode());
    result = 37 * result + (getMsrp() == null ? 0 : this.getMsrp().hashCode());
    return result;
  }

}
