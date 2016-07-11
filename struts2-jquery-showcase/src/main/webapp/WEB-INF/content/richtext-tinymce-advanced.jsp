<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags" %>
<h2>Richtext</h2>

<p class="text">
	A advanced richtext editor example with german localization. The richtext editor is based on <a href="http://tinymce.moxiecode.com">Tinymce</a>.
</p>

<p>
	To enable the richtext editor in your project you need to copy the separate <strong>struts2-jquery-richtext-plugin.jar</strong>
	into your WEB-INF/lib path.
</p>
<s:form id="formRichtext" action="simpleecho" theme="css_xhtml">
	<s:hidden name="escape" value="false"/>
	<s:url var="remoteurl" action="ajax1"/>
	<sjr:tinymce
			id="richtextTinymceAdvancedEditor"
			name="echo"
			rows="10"
			cols="80"
			width="700"
			resizable="true"
			href="%{remoteurl}"
			editorLocal="de"
			editorTheme="modern"
			editorSkin="lightgray"
			toolbarAlign="left"
			toolbarLocation="top"
			statusbarLocation="bottom"
			pastePlainText="true"
			plugins="spellchecker,pagebreak,layer,table,save,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,template,anchor,charmap,hr,image,link,emoticons,code,textcolor"
			toolbarButtonsRow1="save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect,fontselect,fontsizeselect"
			toolbarButtonsRow2="cut,copy,pastetext,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor"
			toolbarButtonsRow3="tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen"
			toolbarButtonsRow4="insertlayer,moveforward,movebackward,absolute,|,styleprops,spellchecker,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,blockquote,pagebreak,|,insertfile,insertimage"
			onSaveTopics="submitRichtextForm"
			onFocusTopics="focusRichtext"
			onBlurTopics="blurRichtext"
			onChangeTopics="highlightRichtext"
	/>
	<sj:submit
			id="formRichtextSubmit"
			targets="result"
			value="AJAX Submit"
			indicator="indicator"
			button="true"
			listenTopics="submitRichtextForm"
	/>
	<img id="indicator"
	     src="images/indicator.gif"
	     alt="Loading..."
	     style="display:none"/>
</s:form>

<strong>Result div:</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>


<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
	  <pre>
            <code class="html">
&lt;s:form id=&quot;formRichtext&quot; action=&quot;simpleecho&quot; theme=&quot;css_xhtml&quot;&gt;
	&lt;s:hidden name=&quot;escape&quot; value=&quot;false&quot;/&gt;
	&lt;s:url var=&quot;remoteurl&quot; action=&quot;ajax1&quot;/&gt;
	&lt;sjr:tinymce
		id=&quot;richtextTinymceAdvancedEditor&quot;
		name=&quot;echo&quot;
		rows=&quot;10&quot;
		cols=&quot;80&quot;
		width=&quot;700&quot;
		resizable=&quot;true&quot;
		href=&quot;%{remoteurl}&quot;
		editorLocal=&quot;de&quot;
		editorTheme=&quot;modern&quot;
		editorSkin=&quot;lightgray&quot;
		toolbarAlign=&quot;left&quot;
		toolbarLocation=&quot;top&quot;
		statusbarLocation=&quot;bottom&quot;
		resizable=&quot;true&quot;
		pastePlainText=&quot;true&quot;
		plugins=&quot;spellchecker,pagebreak,layer,table,save,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,template,anchor,charmap,hr,image,link,emoticons,code,textcolor&quot;
		toolbarButtonsRow1=&quot;save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect,fontselect,fontsizeselect&quot;
		toolbarButtonsRow2=&quot;cut,copy,pastetext,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor&quot;
		toolbarButtonsRow3=&quot;tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen&quot;
		toolbarButtonsRow4=&quot;insertlayer,moveforward,movebackward,absolute,|,styleprops,spellchecker,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,blockquote,pagebreak,|,insertfile,insertimage&quot;
		onSaveTopics=&quot;submitRichtextForm&quot;
		onFocusTopics=&quot;focusRichtext&quot;
		onBlurTopics=&quot;blurRichtext&quot;
		onChangeTopics=&quot;highlightRichtext&quot;
	/&gt;
	&lt;sj:submit
		id=&quot;formRichtextSubmit&quot;
		targets=&quot;result&quot;
		value=&quot;AJAX Submit&quot;
		indicator=&quot;indicator&quot;
		button=&quot;true&quot;
		listenTopics=&quot;submitRichtextForm&quot;
	/&gt;
	&lt;img id=&quot;indicator&quot;
		src=&quot;images/indicator.gif&quot;
		alt=&quot;Loading...&quot;
		style=&quot;display:none&quot;/&gt;
&lt;/s:form&gt;

&lt;strong&gt;Result div:&lt;/strong&gt;

&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
			</code>
	  </pre>
</div>
