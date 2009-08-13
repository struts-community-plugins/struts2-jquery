<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlaccordion" action="accordion"/><sj:a href="%{urlaccordion}" targets="main">Accordion</sj:a></li>
      <li><s:url id="urlaccordionremote" action="accordion-remote"/><sj:a href="%{urlaccordionremote}" targets="main">Accordion with remote content</sj:a></li>
      <li><s:url id="urlaccordionmouseover" action="accordion-mouseover"/><sj:a href="%{urlaccordionmouseover}" targets="main">Accordion Collabsible/MouseOver</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Accordion Remote</h2>
    <p>
        A Accordion with remote content.
    </p>
    <s:url id="urlecho" action="echo"/>
    <sj:accordion list="accordion" paramKeys="echo" paramValues="content" href="%{urlecho}" active="false" autoHeight="false" clearStyle="true" listKey="title" listValue="content"/>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code in JSP:</strong>
    <pre>
    &lt;sj:accordion list="accordion" <strong>paramKeys="echo" paramValues="content" href="%{urlecho}" active="false" autoHeight="false" clearStyle="true"</strong> listKey="title" listValue="content"&gt;
    </pre>
    <strong>Code in Action:</strong>
    <pre>
    private List&lt;AccordionBean&gt; accordion;

    @Action(value="/accordion-remote", 
               results={@Result( location = "accordion-remote.jsp", name="success")}
            )
    public String execute() throws Exception {
        accordion = new LinkedList&lt;AccordionBean&gt;();
        accordion.add(new AccordionBean("My Title 1", "Content One"));
        accordion.add(new AccordionBean("My Title 2", "Content Two"));
        accordion.add(new AccordionBean("My Title 3", "Content Three"));
        accordion.add(new AccordionBean("My Title 4", "Content Four"));
        accordion.add(new AccordionBean("My Title 5", "Content Five"));
        return SUCCESS;
    }

    public List&lt;AccordionBean&gt; getAccordion() {
        return accordion;
    }
    </pre>
    <strong>Code in Bean:</strong>
    <pre>
public class AccordionBean {
    String title;
    String content;
    public AccordionBean(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
