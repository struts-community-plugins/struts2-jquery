package com.jgeppert.struts2.jquery.grid.showcase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS", schema = "CLASSICMODELS", uniqueConstraints = @UniqueConstraint(columnNames = "PRODUCTCODE"))
public class Product implements java.io.Serializable {

    private static final long serialVersionUID = -2553404106252086434L;
    private String productcode;
    private String productname;
    private Productline productline;
    private String productscale;
    private String productvendor;
    private String productdescription;
    private Integer quantityinstock;
    private Double buyprice;
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

    @Id
    @Column(name = "PRODUCTCODE", unique = true, length = 15)
    public String getProductcode() {
        return this.productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    @Column(name = "PRODUCTNAME", length = 70)
    public String getProductname() {
        return this.productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTLINE", unique = false, nullable = false, insertable = true, updatable = true)
    public Productline getProductline() {
        return this.productline;
    }

    public void setProductline(Productline productline) {
        this.productline = productline;
    }

    @Column(name = "PRODUCTSCALE", length = 10)
    public String getProductscale() {
        return this.productscale;
    }

    public void setProductscale(String productscale) {
        this.productscale = productscale;
    }

    @Column(name = "PRODUCTVENDOR", length = 50)
    public String getProductvendor() {
        return this.productvendor;
    }

    public void setProductvendor(String productvendor) {
        this.productvendor = productvendor;
    }

    @Column(name = "PRODUCTDESCRIPTION", length = 32700)
    public String getProductdescription() {
        return this.productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    @Column(name = "QUANTITYINSTOCK")
    public Integer getQuantityinstock() {
        return this.quantityinstock;
    }

    public void setQuantityinstock(Integer quantityinstock) {
        this.quantityinstock = quantityinstock;
    }

    @Column(name = "BUYPRICE", precision = 52, scale = 0)
    public Double getBuyprice() {
        return this.buyprice;
    }

    public void setBuyprice(Double buyprice) {
        this.buyprice = buyprice;
    }

    @Column(name = "MSRP", precision = 52, scale = 0)
    public Double getMsrp() {
        return this.msrp;
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
