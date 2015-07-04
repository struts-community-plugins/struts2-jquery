<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Link with form submission.</h2>

<p class="text">
	A remote link that submit a specified form on click.
</p>
<strong>Result div:</strong>

<div id="formResult" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<s:form id="form" action="echo" theme="simple" cssClass="ym-form">
    <div class="ym-fbox">
        <label for="echo">Echo</label>
        <s:textfield id="echo" name="echo" value="Hello World!!!"/>
    </div>
</s:form>

<sj:a
		id="ajaxformlink"
		formIds="form"
		clearForm="true"
		targets="formResult"
		indicator="indicator"
		button="true"
		buttonIcon="ui-icon-gear"
>
	Submit form here
</sj:a>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
	  <pre>
            <code class="html">
&lt;div id=&quot;formResult&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;

&lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;ym-form&quot;&gt;
    &lt;div class=&quot;ym-fbox&quot;&gt;
        &lt;label for=&quot;echo&quot;&gt;Echo&lt;/label&gt;
        &lt;s:textfield id=&quot;echo&quot; name=&quot;echo&quot; value=&quot;Hello World!!!&quot;/&gt;
    &lt;/div&gt;
&lt;/s:form&gt;

&lt;sj:a
    id=&quot;ajaxformlink&quot;
    formIds=&quot;form&quot;
    clearForm=&quot;true&quot;
    targets=&quot;formResult&quot;
    indicator=&quot;indicator&quot;
    button=&quot;true&quot;
    buttonIcon=&quot;ui-icon-gear&quot;
&gt;
    Submit form here
&lt;/sj:a&gt;
&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
            </code>
	  </pre>
</div>

