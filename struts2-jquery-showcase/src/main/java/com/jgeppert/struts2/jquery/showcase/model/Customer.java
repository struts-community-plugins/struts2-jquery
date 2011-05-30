package com.jgeppert.struts2.jquery.showcase.model;

public class Customer implements Comparable<Customer> {
    private int id;
    private String name;
    private String lastName;
    private String firstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private int salesRepEmployeeNumber;
    private double creditLimit;

    public Customer() {
	super();
    }

    public Customer(int id, String name, String lastName, String firstName,
	    String phone, String addressLine1, String addressLine2,
	    String city, String state, String postalCode, String country,
	    int salesRepEmployeeNumber, double creditLimit) {
	super();
	this.id = id;
	this.name = name;
	this.lastName = lastName;
	this.firstName = firstName;
	this.phone = phone;
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.city = city;
	this.state = state;
	this.postalCode = postalCode;
	this.country = country;
	this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	this.creditLimit = creditLimit;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getAddressLine1() {
	return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
	return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getPostalCode() {
	return postalCode;
    }

    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public int getSalesRepEmployeeNumber() {
	return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
	this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public double getCreditLimit() {
	return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
	this.creditLimit = creditLimit;
    }

    public int compareTo(Customer o) {
	return this.name.toLowerCase().compareTo(o.getName().toLowerCase());
    }

    /*
     * This function is used for the Autocompleter example with seperate label element.
     */
    public String getLabel() {
	return this.id + " - " + this.name + " from " + this.country;
    }
}
