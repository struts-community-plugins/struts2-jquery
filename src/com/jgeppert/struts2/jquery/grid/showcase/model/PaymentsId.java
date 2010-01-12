package com.jgeppert.struts2.jquery.grid.showcase.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaymentsId implements java.io.Serializable {

  private static final long serialVersionUID = 7491499547402790067L;
  private Integer customernumber;
  private String  checknumber;

  public PaymentsId() {
  }

  public PaymentsId(Integer customernumber, String checknumber) {
    this.customernumber = customernumber;
    this.checknumber = checknumber;
  }

  @Column(name = "CUSTOMERNUMBER")
  public Integer getCustomernumber()
  {
    return this.customernumber;
  }

  public void setCustomernumber(Integer customernumber)
  {
    this.customernumber = customernumber;
  }

  @Column(name = "CHECKNUMBER", length = 50)
  public String getChecknumber()
  {
    return this.checknumber;
  }

  public void setChecknumber(String checknumber)
  {
    this.checknumber = checknumber;
  }

  @Override
  public boolean equals(Object other)
  {
    if ((this == other)) return true;
    if ((other == null)) return false;
    if (!(other instanceof PaymentsId)) return false;
    PaymentsId castOther = (PaymentsId) other;

    return ((this.getCustomernumber() == castOther.getCustomernumber()) || (this.getCustomernumber() != null && castOther.getCustomernumber() != null && this.getCustomernumber().equals(castOther.getCustomernumber()))) && ((this.getChecknumber() == castOther.getChecknumber()) || (this.getChecknumber() != null && castOther.getChecknumber() != null && this.getChecknumber().equals(castOther.getChecknumber())));
  }

  @Override
  public int hashCode()
  {
    int result = 17;

    result = 37 * result + (getCustomernumber() == null ? 0 : this.getCustomernumber().hashCode());
    result = 37 * result + (getChecknumber() == null ? 0 : this.getChecknumber().hashCode());
    return result;
  }

}
