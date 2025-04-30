package com.jgeppert.struts2.jquery.grid.showcase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "EMPLOYEES", schema = "CLASSICMODELS")
public class Employee implements java.io.Serializable {

    private static final long serialVersionUID = 6453568010319106998L;

    @Id
    @Column(name = "EMPLOYEENUMBER", unique = true)
    private Integer employeenumber;

    @Column(name = "LASTNAME", length = 50)
    private String lastname;

    @Column(name = "FIRSTNAME", length = 50)
    private String firstname;

    @Column(name = "EXTENSION", length = 10)
    private String extension;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    @JoinColumn(name = "OFFICECODE", unique = false, nullable = false, insertable = true, updatable = true)
    private Office office;

    @Column(name = "REPORTSTO")
    private Integer reportsto;

    @Column(name = "JOBTITLE", length = 50)
    private String jobtitle;

    public Employee() {
    }

    public Employee(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }

    public Employee(Integer employeenumber, String lastname, String firstname, String extension, String email, Office office, Integer reportsto, String jobtitle) {
        this.employeenumber = employeenumber;
        this.lastname = lastname;
        this.firstname = firstname;
        this.extension = extension;
        this.email = email;
        this.office = office;
        this.reportsto = reportsto;
        this.jobtitle = jobtitle;
    }

    public Integer getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Integer getReportsto() {
        return reportsto;
    }

    public void setReportsto(Integer reportsto) {
        this.reportsto = reportsto;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee other = (Employee) o;

        return new EqualsBuilder().append(this.employeenumber, other.employeenumber).append(this.email, other.email).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.employeenumber)
                .append(this.firstname)
                .append(this.lastname)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.employeenumber)
                .append(this.firstname)
                .append(this.lastname)
                .append(this.email)
                .toString();
    }
}
