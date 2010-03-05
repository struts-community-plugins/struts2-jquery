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
      <li><s:url id="urlformvalidation" action="form-validation"/><sj:a id="remoteformvalidationlink" href="%{urlformvalidation}" targets="main">AJAX Forms with Validation</sj:a></li>
      <li><s:url id="urlformvalidationcust" action="form-validation-custome"/><sj:a id="remoteformvalidationcustlink" href="%{urlformvalidationcust}" targets="main">AJAX Forms with Custome Validation</sj:a></li>
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
	<h2>Select Box with AJAX Content</h2>
	<p>
	    A Select Box with remote json content. This Component works together with the Struts2 JSON Plugin.
	</p>
    <s:form id="formSelectOne" action="echo" theme="simple" cssClass="yform">
        <fieldset>
            <legend>AJAX Form</legend>
	        <div class="type-text">
	            <label for="echo">Echo: </label>
				<s:url id="remoteurl" action="jsonsample"/> 
				<sj:select 
					href="%{remoteurl}" 
					id="echo" 
					name="echo" 
					list="languageList" 
					emptyOption="true" 
					headerKey="-1" 
					headerValue="Please Select a Language"
				/>
	        </div>
	        <div class="type-button">
				<sj:submit 
					targets="result" 
					value="AJAX Submit" 
					indicator="indicator" 
					button="true"
				/>
				<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
	        </div>
        </fieldset>
    </s:form>
    <s:form id="formSelectTwo" action="echo" theme="simple" cssClass="yform">
        <fieldset>
            <legend>AJAX Form</legend>
	        <div class="type-text">
	            <label for="echo">Echo: </label>
				<s:url id="remoteurl" action="jsonsample"/> 
				<sj:select 
					href="%{remoteurl}" 
					id="echo2" 
					name="echo" 
					list="languageMap" 
					emptyOption="true" 
					headerKey="-1" 
					headerValue="Please Select a Language"
				/>
	        </div>
	        <div class="type-button">
				<sj:submit 
					targets="result" 
					value="AJAX Submit" 
					indicator="indicator"
					button="true"
				/>
				<img id="indicator" 
					src="images/indicator.gif" 
					alt="Loading..." style="display:none"
				/>
	        </div>
        </fieldset>
    </s:form>
    <s:form id="formSelectThree" action="echo" theme="simple" cssClass="yform">
        <fieldset>
            <legend>AJAX Form</legend>
	        <div class="type-text">
	            <label for="echo">Echo: </label>
				<s:url id="remoteurl" action="jsonsample"/> 
				<sj:select 
					href="%{remoteurl}" 
					id="echo3" 
					name="echo" 
					list="languageObjList" 
					listKey="myKey" 
					listValue="myValue" 
					emptyOption="true" 
					headerKey="-1" 
					headerValue="Please Select a Language"
				/>
	        </div>
	        <div class="type-button">
				<sj:submit 
					targets="result" 
					value="AJAX Submit" 
					indicator="indicator"
					button="true"
				/>
				<img id="indicator" 
					src="images/indicator.gif" 
					alt="Loading..." 
					style="display:none"/>
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
    &lt;s:form id=&quot;formSelectOne&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
				&lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonsample&quot;/&gt; 
				&lt;sj:select 
					href=&quot;%{remoteurl}&quot; 
					id=&quot;echo&quot; 
					name=&quot;echo&quot; 
					list=&quot;languageList&quot; 
					emptyOption=&quot;true&quot; 
					headerKey=&quot;-1&quot; 
					headerValue=&quot;Please Select a Language&quot;
				/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
				&lt;sj:submit 
					targets=&quot;result&quot; 
					value=&quot;AJAX Submit&quot; 
					indicator=&quot;indicator&quot; 
					button=&quot;true&quot;
				/&gt;
				&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;
    &lt;s:form id=&quot;formSelectTwo&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
				&lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonsample&quot;/&gt; 
				&lt;sj:select 
					href=&quot;%{remoteurl}&quot; 
					id=&quot;echo2&quot; 
					name=&quot;echo&quot; 
					list=&quot;languageMap&quot; 
					emptyOption=&quot;true&quot; 
					headerKey=&quot;-1&quot; 
					headerValue=&quot;Please Select a Language&quot;
				/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
				&lt;sj:submit 
					targets=&quot;result&quot; 
					value=&quot;AJAX Submit&quot; 
					indicator=&quot;indicator&quot;
					button=&quot;true&quot;
				/&gt;
				&lt;img id=&quot;indicator&quot; 
					src=&quot;images/indicator.gif&quot; 
					alt=&quot;Loading...&quot; style=&quot;display:none&quot;
				/&gt;
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;
    &lt;s:form id=&quot;formSelectThree&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
				&lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonsample&quot;/&gt; 
				&lt;sj:select 
					href=&quot;%{remoteurl}&quot; 
					id=&quot;echo3&quot; 
					name=&quot;echo&quot; 
					list=&quot;languageObjList&quot; 
					listKey=&quot;myKey&quot; 
					listValue=&quot;myValue&quot; 
					emptyOption=&quot;true&quot; 
					headerKey=&quot;-1&quot; 
					headerValue=&quot;Please Select a Language&quot;
				/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
				&lt;sj:submit 
					targets=&quot;result&quot; 
					value=&quot;AJAX Submit&quot; 
					indicator=&quot;indicator&quot;
					button=&quot;true&quot;
				/&gt;
				&lt;img id=&quot;indicator&quot; 
					src=&quot;images/indicator.gif&quot; 
					alt=&quot;Loading...&quot; 
					style=&quot;display:none&quot;/&gt;
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;

	&lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;
		Submit a form.
	&lt;/div&gt;
	  </pre>
	  </div>
      <div id="java">
	  <pre>
@ParentPackage( value = &quot;showcase&quot;)
public class JsonSample extends ActionSupport{
    
    private static final long serialVersionUID = -2223948287805083119L;
    private List&lt;String&gt; languageList;
    private List&lt;ListValue&gt; languageObjList;
    private Map&lt;String, String&gt; languageMap;

    @Actions({
    	@Action(
    	value=&quot;/jsonsample&quot;, 
    	results={
    	@Result(name=&quot;success&quot;,<strong>type=&quot;json&quot;</strong>)
    	}) 
    })
    public String execute() {
        
      languageList = new ArrayList&lt;String&gt;();
      languageObjList = new ArrayList&lt;ListValue&gt;();
      languageMap = new HashMap&lt;String, String&gt;();
         
      languageList.add(&quot;Java&quot;);
      languageList.add(&quot;PHP&quot;);
      languageList.add(&quot;C++&quot;);
       
      languageMap.put(&quot;J&quot;, &quot;Java&quot;);
      languageMap.put(&quot;P&quot;, &quot;PHP&quot;);
      languageMap.put(&quot;C&quot;, &quot;C++&quot;);

      languageObjList.add(new ListValue(&quot;J&quot;, &quot;Java&quot;));
      languageObjList.add(new ListValue(&quot;P&quot;, &quot;PHP&quot;));
      languageObjList.add(new ListValue(&quot;C&quot;, &quot;C++&quot;));

      return SUCCESS;
    }

    public String getJSON(){
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
