package com.jgeppert.struts2.jquery.showcase;

public class AccordionBean {
  String title;
  String content;

  public AccordionBean(String title, String content) {
    super();
    this.title = title;
    this.content = content;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getContent()
  {
    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }
}
