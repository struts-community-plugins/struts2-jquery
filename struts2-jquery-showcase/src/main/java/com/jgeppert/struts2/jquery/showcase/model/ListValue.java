/**
 *
 */
package com.jgeppert.struts2.jquery.showcase.model;

public class ListValue {
    private String myKey;
    private String myTitle;
    private String myValue;

    public ListValue(String myKey, String myValue) {
        this(myKey, myValue, null);
    }

    public ListValue(String myKey, String myValue, String myTitle) {
        super();
        this.myKey = myKey;
        this.myValue = myValue;
        this.myTitle = myTitle;
    }

    public String getMyKey() {
        return myKey;
    }

    public void setMyKey(String myKey) {
        this.myKey = myKey;
    }

    public String getMyTitle() {
        return myTitle;
    }

    public void setMyTitle(String myTitle) {
        this.myTitle = myTitle;
    }

    public String getMyValue() {
        return myValue;
    }

    public void setMyValue(String myValue) {
        this.myValue = myValue;
    }
}
