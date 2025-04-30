package com.jgeppert.struts2.jquery.grid.showcase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Blob;
import java.sql.Clob;

@Entity
@Table(name = "PRODUCTLINES", schema = "CLASSICMODELS")
public class Productline implements java.io.Serializable {

    private static final long serialVersionUID = 3084285926141265568L;

    @Id
    @Column(name = "PRODUCTLINE", unique = true, length = 50)
    private String productline;

    @Column(name = "TEXTDESCRIPTION", length = 4000)
    private String textdescription;

    @Column(name = "HTMLDESCRIPTION")
    private Clob htmldescription;

    @Column(name = "IMAGE")
    private Blob image;

    public Productline() {
    }

    public Productline(String productline) {
        this.productline = productline;
    }

    public Productline(String productline, String textdescription, Clob htmldescription, Blob image) {
        this.productline = productline;
        this.textdescription = textdescription;
        this.htmldescription = htmldescription;
        this.image = image;
    }

    public String getProductline() {
        return productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

    public String getTextdescription() {
        return textdescription;
    }

    public void setTextdescription(String textdescription) {
        this.textdescription = textdescription;
    }

    public Clob getHtmldescription() {
        return htmldescription;
    }

    public void setHtmldescription(Clob htmldescription) {
        this.htmldescription = htmldescription;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Productline other = (Productline) o;

        return new EqualsBuilder().append(this.productline, other.productline).append(this.textdescription, other.textdescription).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.productline)
                .append(this.textdescription)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.productline)
                .append(this.textdescription)
                .toString();
    }
}
