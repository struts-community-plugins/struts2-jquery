<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags" %>
<h2>Richtext - Custom Toolbar</h2>

<p class="text">
	This richtext editor use a custom config file to define a custom toolbar.
	Also it loads the initial content via an AJAX request and the editor local is that to french.
</p>
<s:url var="remoteurl" action="ajax1"/>
<s:set var="contextPath" value="#request.get('javax.servlet.forward.context_path')"/>
<s:form id="formRichtextCustom" action="simpleecho" theme="xhtml">
	<s:hidden name="escape" value="false"/>
	<sjr:ckeditor
			label="Your Text"
			href="%{remoteurl}"
			id="richtextCustomEditor"
			name="echo"
			rows="10"
			cols="80"
			loadingText="Loading content of textarea ..."
			width="600"
			toolbar="MyToolbar"
			skin="v2"
			editorLocal="fr"
			customConfig="%{contextPath}/js/ckeditor.config.js"
			/>
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
</s:form>
<br/>
<strong>Result div:</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>


<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
	  <pre>
            <code class="html">
&lt;%@ taglib prefix=&quot;sj&quot; uri=&quot;/struts-jquery-tags&quot;%&gt;
&lt;%@ taglib prefix=&quot;sjr&quot; uri=&quot;/struts-jquery-richtext-tags&quot;%&gt;

&lt;s:url id=&quot;remoteurl&quot; action=&quot;ajax1&quot;/&gt;
&lt;s:set id=&quot;contextPath&quot;  value=&quot;#request.get('javax.servlet.forward.context_path')&quot; /&gt;
&lt;s:form id=&quot;formRichtextCustom&quot; action=&quot;simpleecho&quot; theme=&quot;xhtml&quot;&gt;
	&lt;s:hidden name=&quot;escape&quot; value=&quot;false&quot;/&gt;
	&lt;sjr:ckeditor
		label=&quot;Your Text&quot;
		href=&quot;%{remoteurl}&quot;
		id=&quot;richtextCustomEditor&quot;
		name=&quot;echo&quot;
		rows=&quot;10&quot;
		cols=&quot;80&quot;
		loadingText=&quot;Loading content of textarea ...&quot;
		width=&quot;600&quot;
		toolbar=&quot;MyToolbar&quot;
		skin=&quot;fr&quot;
		editorLocal=&quot;v2&quot;
		customConfig=&quot;%{contextPath}/js/ckeditor.config.js&quot;
	/&gt;
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
&lt;/s:form&gt;
			</code>
	  </pre>
</div>
