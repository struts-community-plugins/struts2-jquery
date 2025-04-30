package com.jgeppert.struts2.jquery.grid.showcase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "PRODUCTS", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = "PRODUCTCODE"))
public class Product implements java.io.Serializable {

    private static final long serialVersionUID = -2553404106252086434L;

    @Id
    @Column(name = "PRODUCTCODE", unique = true, length = 15)
    private String productcode;

    @Column(name = "PRODUCTNAME", length = 70)
    private String productname;

    @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTLINE", unique = false, nullable = false, insertable = true, updatable = true)
    private Productline productline;

    @Column(name = "PRODUCTSCALE", length = 10)
    private String productscale;

    @Column(name = "PRODUCTVENDOR", length = 50)
    private String productvendor;

    @Column(name = "PRODUCTDESCRIPTION", length = 32700)
    private String productdescription;

    @Column(name = "QUANTITYINSTOCK")
    private Integer quantityinstock;

    @Column(name = "BUYPRICE", precision = 52, scale = 0)
    private Double buyprice;

    @Column(name = "MSRP", precision = 52, scale = 0)
    private Double msrp;

    public Product() {
    }

    public Product(String productcode, String productname, Productline productline, String productscale, String productvendor, String productdescription, Integer quantityinstock, Double buyprice, Double msrp) {
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

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Productline getProductline() {
        return productline;
    }

    public void setProductline(Productline productline) {
        this.productline = productline;
    }

    public String getProductscale() {
        return productscale;
    }

    public void setProductscale(String productscale) {
        this.productscale = productscale;
    }

    public String getProductvendor() {
        return productvendor;
    }

    public void setProductvendor(String productvendor) {
        this.productvendor = productvendor;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public Integer getQuantityinstock() {
        return quantityinstock;
    }

    public void setQuantityinstock(Integer quantityinstock) {
        this.quantityinstock = quantityinstock;
    }

    public Double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(Double buyprice) {
        this.buyprice = buyprice;
    }

    public Double getMsrp() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product other = (Product) o;

        return new EqualsBuilder().append(this.productcode, other.productcode).append(this.productname, other.productname).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.productcode)
                .append(this.productname)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.productcode)
                .append(this.productname)
                .append(this.productdescription)
                .toString();
    }
}
