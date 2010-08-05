<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlaccordion" action="accordion"/><sj:a href="%{urlaccordion}" targets="main">Accordion</sj:a></li>
      <li><s:url id="urlaccordionlist" action="accordion-list"/><sj:a href="%{urlaccordionlist}" targets="main">Accordion from List</sj:a></li>
      <li><s:url id="urlaccordionremote" action="accordion-remote"/><sj:a href="%{urlaccordionremote}" targets="main">Accordion with remote content</sj:a></li>
      <li><s:url id="urlaccordionmouseover" action="accordion-mouseover"/><sj:a href="%{urlaccordionmouseover}" targets="main">Accordion Collabsible/MouseOver</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Accordion Remote</h2>
    <p class="text">
        A Accordion with remote content.
    </p>
    <s:url id="urlecho" action="echo"/>
    <sj:accordion 
    	id="accordionremote"
    	list="accordion" 
    	listKey="title" 
    	listValue="content"
    	paramKeys="echo" 
    	paramValues="content" 
    	href="%{urlecho}" 
    	active="false" 
    	autoHeight="false" 
    	clearStyle="true" 
    	/>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code in JSP:</strong>
    <pre>
    &lt;s:url id=&quot;urlecho&quot; action=&quot;echo&quot;/&gt;
    &lt;sj:accordion 
    	id=&quot;accordionremote&quot;
    	list=&quot;accordion&quot; 
    	listKey=&quot;title&quot; 
    	listValue=&quot;content&quot;
    	paramKeys=&quot;echo&quot; 
    	paramValues=&quot;content&quot; 
    	href=&quot;%{urlecho}&quot; 
    	active=&quot;false&quot; 
    	autoHeight=&quot;false&quot; 
    	clearStyle=&quot;true&quot; 
    	/&gt;
    </pre>
    <strong>Code in Action:</strong>
    <pre>
    private List&lt;AccordionBean&gt; accordion;

    @Action(value=&quot;/accordion-remote&quot;, 
               results={@Result( location = &quot;accordion-remote.jsp&quot;, name=&quot;success&quot;)}
            )
    public String execute() throws Exception {
        accordion = new LinkedList&lt;AccordionBean&gt;();
        accordion.add(new AccordionBean(&quot;My Title 1&quot;, &quot;Content One&quot;));
        accordion.add(new AccordionBean(&quot;My Title 2&quot;, &quot;Content Two&quot;));
        accordion.add(new AccordionBean(&quot;My Title 3&quot;, &quot;Content Three&quot;));
        accordion.add(new AccordionBean(&quot;My Title 4&quot;, &quot;Content Four&quot;));
        accordion.add(new AccordionBean(&quot;My Title 5&quot;, &quot;Content Five&quot;));
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
