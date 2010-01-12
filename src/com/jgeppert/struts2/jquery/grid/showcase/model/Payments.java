package com.jgeppert.struts2.jquery.grid.showcase.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PAYMENTS", schema = "CLASSICMODELS")
public class Payments implements java.io.Serializable {

  private static final long serialVersionUID = -8839175465382345399L;
  private PaymentsId id;
  private Date       paymentdate;
  private Double     amount;

  public Payments() {
  }

  public Payments(PaymentsId id) {
    this.id = id;
  }

  public Payments(PaymentsId id, Date paymentdate, Double amount) {
    this.id = id;
    this.paymentdate = paymentdate;
    this.amount = amount;
  }

  @EmbeddedId
  @AttributeOverrides( {
      @AttributeOverride(name = "customernumber", column = @Column(name = "CUSTOMERNUMBER")), @AttributeOverride(name = "checknumber", column = @Column(name = "CHECKNUMBER", length = 50))
  })
  public PaymentsId getId()
  {
    return this.id;
  }

  public void setId(PaymentsId id)
  {
    this.id = id;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "PAYMENTDATE")
  public Date getPaymentdate()
  {
    return this.paymentdate;
  }

  public void setPaymentdate(Date paymentdate)
  {
    this.paymentdate = paymentdate;
  }

  @Column(name = "AMOUNT", precision = 52, scale = 0)
  public Double getAmount()
  {
    return this.amount;
  }

  public void setAmount(Double amount)
  {
    this.amount = amount;
  }

}
