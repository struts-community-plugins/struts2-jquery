package com.jgeppert.struts2.jquery.grid.showcase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;
import java.sql.Clob;

@Entity
@Table(name = "PRODUCTLINES", schema = "CLASSICMODELS")
public class Productline implements java.io.Serializable {

    private static final long serialVersionUID = 3084285926141265568L;
    private String productline;
    private String textdescription;
    private Clob htmldescription;
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

    @Id
    @Column(name = "PRODUCTLINE", unique = true, length = 50)
    public String getProductline() {
        return this.productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

    @Column(name = "TEXTDESCRIPTION", length = 4000)
    public String getTextdescription() {
        return this.textdescription;
    }

    public void setTextdescription(String textdescription) {
        this.textdescription = textdescription;
    }

    @Column(name = "HTMLDESCRIPTION")
    public Clob getHtmldescription() {
        return this.htmldescription;
    }

    public void setHtmldescription(Clob htmldescription) {
        this.htmldescription = htmldescription;
    }

    @Column(name = "IMAGE")
    public Blob getImage() {
        return this.image;
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
