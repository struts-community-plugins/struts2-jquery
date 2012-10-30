<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Select Box with AJAX Content</h2>

<p class="text">
	A Select Box with remote json content. This Component works together with the Struts2 JSON Plugin.
</p>
<s:form id="formSelectOne" action="echo" theme="simple" cssClass="yform">
	<fieldset>
		<legend>AJAX Form populated by a String List</legend>
		<div class="type-text">
			<label for="echo">Echo: </label>
			<s:url var="remoteurl" action="jsonsample"/>
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
					targets="result1"
					value="AJAX Submit"
					indicator="indicator"
					button="true"
					/>
			<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
		</div>
	</fieldset>
</s:form>

<strong>Result Div 1 :</strong>

<div id="result1" class="result ui-widget-content ui-corner-all">Submit form above.</div>

<s:form id="formSelectTwo" action="echo" theme="simple" cssClass="yform">
	<fieldset>
		<legend>AJAX Form populated by a Map</legend>
		<div class="type-text">
			<label for="echo">Echo: </label>
			<s:url var="remoteurl" action="jsonsample"/>
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
					targets="result2"
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

<strong>Result Div 2 :</strong>

<div id="result2" class="result ui-widget-content ui-corner-all">Submit form above.</div>

<s:form id="formSelectThree" action="echo" theme="simple" cssClass="yform">
	<fieldset>
		<legend>AJAX Form populated by a List with Objects</legend>
		<div class="type-text">
			<label for="echo">Echo: </label>
			<s:url var="remoteurl" action="jsonsample"/>
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
					targets="result3"
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

<strong>Result Div 3 :</strong>

<div id="result3" class="result ui-widget-content ui-corner-all">Submit form above.</div>


<sj:tabbedpanel id="localtabs" cssClass="list">
<sj:tab id="tab1" target="jsp" label="JSP Code"/>
<sj:tab id="tab2" target="java" label="Java Code"/>
<sj:tab id="tab2" target="config" label="Configuration"/>
<div id="jsp">
	  <pre>
    &lt;s:form id=&quot;formSelectOne&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form populated by a String List&lt;/legend&gt;
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
					targets=&quot;result1&quot; 
					value=&quot;AJAX Submit&quot; 
					indicator=&quot;indicator&quot; 
					button=&quot;true&quot;
				/&gt;
				&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;
 
    &lt;strong&gt;Result Div 1 :&lt;/strong&gt;
	&lt;div id=&quot;result1&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form above.&lt;/div&gt;
	
    &lt;s:form id=&quot;formSelectTwo&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form populated by a Map&lt;/legend&gt;
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
					targets=&quot;result2&quot; 
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

    &lt;strong&gt;Result Div 2 :&lt;/strong&gt;
	&lt;div id=&quot;result2&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form above.&lt;/div&gt;
	
    &lt;s:form id=&quot;formSelectThree&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form populated by a List with Objects&lt;/legend&gt;
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
					targets=&quot;result3&quot; 
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

    &lt;strong&gt;Result Div 3 :&lt;/strong&gt;
	&lt;div id=&quot;result3&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form above.&lt;/div&gt;
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
