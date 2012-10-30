<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags" %>
<h2>Richtext</h2>

<p class="text">
	A simple Richtext Editor with default values. The Richtext Editor is based on <a
		href="http://tinymce.moxiecode.com">Tinymce</a>.
</p>

<p>
	To enable the Richtext Editor in your Project you need to copy the separate <strong>struts2-jquery-richtext-plugin.jar</strong>
	into your WEB-INF/lib path.
</p>
<s:form id="formRichtext" action="simpleecho" theme="css_xhtml">
	<s:hidden name="escape" value="false"/>
	<sjr:tinymce
			id="richtextTinymceEditor"
			name="echo"
			rows="10"
			cols="80"
			width="700"
			editorTheme="simple"
			value="Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
			/>
	<sj:submit
			id="submitSimpleRichtext"
			targets="result"
			value="AJAX Submit"
			indicator="indicator"
			button="true"
			/>
	<img id="indicator"
	     src="images/indicator.gif"
	     alt="Loading..."
	     style="display:none"/>
</s:form>

<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>


<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;s:form id=&quot;formRichtext&quot; action=&quot;simpleecho&quot; theme=&quot;css_xhtml&quot;&gt;
    &lt;s:hidden name=&quot;escape&quot; value=&quot;false&quot;/&gt;
		&lt;sjr:tinymce 
			id=&quot;richtextTinymceEditor&quot; 
			name=&quot;echo&quot; 
			rows=&quot;10&quot; 
			cols=&quot;80&quot; 
			width=&quot;800&quot;
			editorTheme=&quot;simple&quot;
			value=&quot;Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.&quot;
		/&gt;
		&lt;sj:submit 
			id=&quot;submitSimpleRichtext&quot;
			targets=&quot;result&quot; 
			value=&quot;AJAX Submit&quot; 
			indicator=&quot;indicator&quot; 
			button=&quot;true&quot;
		/&gt;
		&lt;img id=&quot;indicator&quot; 
			src=&quot;images/indicator.gif&quot; 
			alt=&quot;Loading...&quot; 
			style=&quot;display:none&quot;/&gt;
    &lt;/s:form&gt;

    &lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
 	  </pre>
</div>
