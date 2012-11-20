/**
 * 
 */
package com.jgeppert.struts2.jquery.showcase.model;

public class ListValue {
  private String myKey;
  private String myValue;

  public ListValue(String myKey, String myValue) {
    super();
    this.myKey = myKey;
    this.myValue = myValue;
  }

  public String getMyKey()
  {
    return myKey;
  }

  public void setMyKey(String myKey)
  {
    this.myKey = myKey;
  }

  public String getMyValue()
  {
    return myValue;
  }

  public void setMyValue(String myValue)
  {
    this.myValue = myValue;
  }
}
