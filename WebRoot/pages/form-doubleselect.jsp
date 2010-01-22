<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlform" action="form"/><sj:a id="remoteformlink" href="%{urlform}" targets="main">AJAX Forms</sj:a></li>
      <li><s:url id="urlformeffect" action="form-effect"/><sj:a id="remoteformeffectlink" href="%{urlformeffect}" targets="main">AJAX Forms with Effects</sj:a></li>
      <li><s:url id="urlformout" action="form-out"/><sj:a id="remoteformoutlink" href="%{urlformout}" targets="main">AJAX Forms with Outside Button</sj:a></li>
      <li><s:url id="urlformftl" action="form-ftl"/><sj:a id="remoteformftllink" href="%{urlformftl}" targets="main">AJAX Forms with Freemarker</sj:a></li>
      <li><s:url id="urlformvel" action="form-velocity"/><sj:a id="remoteformvellink" href="%{urlformvel}" targets="main">AJAX Forms with Velocity</sj:a></li>
      <li><s:url id="urlformevent" action="form-event"/><sj:a id="remoteformeventlink" href="%{urlformevent}" targets="main">AJAX Forms with Events</sj:a></li>
      <li><s:url id="urlformtextarea" action="form-textarea"/><sj:a id="remoteformtextarealink" href="%{urlformtextarea}" targets="main">AJAX Textarea</sj:a></li>
      <li><s:url id="urlformtextarearesize" action="form-textarea-resizeable"/><sj:a id="remoteformtextarearesizelink" href="%{urlformtextarearesize}" targets="main">AJAX Textarea / Resizable</sj:a></li>
      <li><s:url id="urlformtextfieldresize" action="form-textfield-resizeable"/><sj:a id="remoteformtextfieldresizelink" href="%{urlformtextfieldresize}" targets="main">AJAX Textfield / Resizable</sj:a></li>
      <li><s:url id="urlformselect" action="form-select"/><sj:a id="remoteformselectlink" href="%{urlformselect}" targets="main">AJAX Select</sj:a></li>
      <li><s:url id="urlformdoubleselect" action="form-doubleselect"/><sj:a id="remoteformdoubleselectlink" href="%{urlformdoubleselect}" targets="main">AJAX Select (Doubleselect)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>A AJAX based Double Select Box</h2>
	<p>
	    Two select boxes with remote json content. The second select box content is dependent from the first one.
	</p>
     <s:form id="formSelectReload" action="echo" theme="simple" cssClass="yform">
        <fieldset>
            <legend>AJAX Form</legend>
	        <div class="type-text">
	            <label for="language">Language: </label>
				<s:url id="remoteurl" action="jsonsample"/> 
				<sj:select href="%{remoteurl}" id="language" onChangeTopics="reloadsecondlist" name="language" list="languageObjList" listKey="myKey" listValue="myValue" emptyOption="true" headerKey="-1" headerValue="Please Select a Language"/>
	        </div>
	        <div class="type-text">
	            <label for="echo">Framework: </label>
				<s:url id="remoteurl" action="jsonsample"/> 
				<sj:select href="%{remoteurl}" id="selectWithReloadTopic" formIds="formSelectReload" reloadTopics="reloadsecondlist" name="echo" list="reloadList" emptyOption="true" headerKey="-1" headerValue="Please Select a Framework"/>
	        </div>
	        <div class="type-button">
				<sj:submit targets="result" value="AJAX Submit" indicator="indicator"/><img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
	        </div>
        </fieldset>
    </s:form>

    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit a form.</div>
    

    <sj:tabbedpanel id="localtabs" cssClass="list">
      <sj:tab id="tab1" target="jsp" label="JSP Code"/>
      <sj:tab id="tab2" target="java" label="Java Code"/>
      <sj:tab id="tab2" target="config" label="Configuration"/>
      <div id="jsp">
	  <pre>
     &lt;s:form id=&quot;formSelectReload&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;language&quot;&gt;Language: &lt;/label&gt;
				&lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonsample&quot;/&gt; 
				&lt;sj:select href=&quot;%{remoteurl}&quot; id=&quot;language&quot; onChangeTopics=&quot;reloadsecondlist&quot; name=&quot;language&quot; list=&quot;languageObjList&quot; listKey=&quot;myKey&quot; listValue=&quot;myValue&quot; emptyOption=&quot;true&quot; headerKey=&quot;-1&quot; headerValue=&quot;Please Select a Language&quot;/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Framework: &lt;/label&gt;
				&lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonsample&quot;/&gt; 
				&lt;sj:select href=&quot;%{remoteurl}&quot; id=&quot;selectWithReloadTopic&quot; formIds=&quot;formSelectReload&quot; reloadTopics=&quot;reloadsecondlist&quot; name=&quot;echo&quot; list=&quot;reloadList&quot; emptyOption=&quot;true&quot; headerKey=&quot;-1&quot; headerValue=&quot;Please Select a Framework&quot;/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
				&lt;sj:submit targets=&quot;result&quot; value=&quot;AJAX Submit&quot; indicator=&quot;indicator&quot;/&gt;&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;
	  </pre>
	  </div>
      <div id="java">
	  <pre>
@ParentPackage(value = &quot;showcase&quot;)
public class JsonSample extends ActionSupport {

  private static final long   serialVersionUID = -2223948287805083119L;
  private static final Log    log              = LogFactory.getLog(JsonSample.class);
  private List&lt;String&gt;        languageList;
  private List&lt;ListValue&gt;     languageObjList;
  private Map&lt;String, String&gt; languageMap;
  private List&lt;String&gt;        reloadList;
  private String              language;

  @Actions( {
    @Action(value = &quot;/jsonsample&quot;, results = {
      @Result(name = &quot;success&quot;, type = &quot;json&quot;)
    })
  })
  public String execute()
  {

    log.info(&quot;build json lists language : &quot; + language);

    languageList = new ArrayList&lt;String&gt;();
    languageObjList = new ArrayList&lt;ListValue&gt;();
    languageMap = new HashMap&lt;String, String&gt;();

    languageList.add(&quot;Java&quot;);
    languageList.add(&quot;PHP&quot;);
    languageList.add(&quot;C#&quot;);

    languageMap.put(&quot;J&quot;, &quot;Java&quot;);
    languageMap.put(&quot;P&quot;, &quot;PHP&quot;);
    languageMap.put(&quot;C&quot;, &quot;C#&quot;);

    languageObjList.add(new ListValue(&quot;J&quot;, &quot;Java&quot;));
    languageObjList.add(new ListValue(&quot;P&quot;, &quot;PHP&quot;));
    languageObjList.add(new ListValue(&quot;C&quot;, &quot;C#&quot;));

    reloadList = new ArrayList&lt;String&gt;();
    if (language != null &amp;&amp; language.equalsIgnoreCase(&quot;J&quot;))
    {
      reloadList.add(&quot;Struts2&quot;);
      reloadList.add(&quot;MyFaces&quot;);
      reloadList.add(&quot;Tapestry&quot;);
    }
    else if (language != null &amp;&amp; language.equalsIgnoreCase(&quot;P&quot;))
    {
      reloadList.add(&quot;CakePHP&quot;);
      reloadList.add(&quot;Symfony&quot;);
      reloadList.add(&quot;Zend&quot;);
    }
    else if (language != null &amp;&amp; language.equalsIgnoreCase(&quot;C&quot;))
    {
      reloadList.add(&quot;NStruts&quot;);
      reloadList.add(&quot;ProMesh.NET&quot;);
      reloadList.add(&quot;Websharp&quot;);
    }

    return SUCCESS;
  }

  public String getJSON()
  {
    return execute();
  }

  public List&lt;String&gt; getLanguageList()
  {
    return languageList;
  }

  public Map&lt;String, String&gt; getLanguageMap()
  {
    return languageMap;
  }

  public List&lt;ListValue&gt; getLanguageObjList()
  {
    return languageObjList;
  }

  public List&lt;String&gt; getReloadList()
  {
    return reloadList;
  }

  public void setLanguage(String language)
  {
    this.language = language;
  }
}
	  </pre>
	  </div>
      <div id="config">
	  <pre>
    &lt;package name=&quot;showcase&quot; extends=&quot;struts-default,<strong>json-default</strong>&quot; namespace=&quot;/&quot;&gt;
    &lt;/package&gt;
	  </pre>
	  </div>
    </sj:tabbedpanel>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
