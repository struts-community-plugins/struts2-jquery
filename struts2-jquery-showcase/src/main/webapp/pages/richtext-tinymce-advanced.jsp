<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlslider" action="slider"/><sj:a id="slidersimplelink" href="%{urlslider}" targets="main">Slider</sj:a></li>
      <li><s:url id="urlsliderform" action="slider-form"/><sj:a id="sliderformlink"  href="%{urlsliderform}" targets="main">Slider in a Form</sj:a></li>
      <li><s:url id="urlsliderrange" action="slider-range"/><sj:a id="sliderrangelink"  href="%{urlsliderrange}" targets="main">Slider with Range and Events</sj:a></li>
      <li><s:url id="urlprogressbar" action="progressbar"/><sj:a id="progressbarsimplelink" href="%{urlprogressbar}" targets="main">Progressbar</sj:a></li>
      <li><s:url id="urlprogressbarchange" action="progressbar-change"/><sj:a id="progressbarchangelink" href="%{urlprogressbarchange}" targets="main">Progressbar with change event</sj:a></li>
      <li><s:url id="urlprogressbarresizeable" action="progressbar-resizeable"/><sj:a id="progressbarresizeablelink" href="%{urlprogressbarresizeable}" targets="main">Resizeable progressbar</sj:a></li>
      <li><s:url id="urlspinner" action="spinner"/><sj:a id="spinnerlink" href="%{urlspinner}" targets="main">Spinner</sj:a></li>
      <li><s:url id="urlrichtexttinymce" action="richtext-tinymce"/><sj:a id="richtexttinymcelink" href="%{urlrichtexttinymce}" targets="main">Richtext - Tinymce</sj:a></li>
      <li><s:url id="urlrichtexttinymceadvanced" action="richtext-tinymce-advanced"/><sj:a id="richtexttinymcelinkadvanced" href="%{urlrichtexttinymceadvanced}" targets="main">Richtext - Tinymce (Advanced)</sj:a></li>
      <li><s:url id="urlrichtext" action="richtext"/><sj:a id="richtextlink" href="%{urlrichtext}" targets="main">Richtext - Ckeditor</sj:a></li>
      <li><s:url id="urlrichtextcustome" action="richtext-custome"/><sj:a id="richtextcustomelink" href="%{urlrichtextcustome}" targets="main">Richtext - Ckeditor (Custome Toolbar)</sj:a></li>
      <li><s:url id="urlmessages" action="messages"/><sj:a id="messageslink" href="%{urlmessages}" targets="main">Action Errors/Messages</sj:a></li>
      <li><s:url id="urlcharts" action="charts"/><sj:a id="chartslink" href="%{urlcharts}" targets="main">Charts</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Richtext</h2>
	<p class="text">
	    A advanced Richtext Editor with German Local . The Richtext Editor is based on <a href="http://tinymce.moxiecode.com">Tinymce</a>.
	</p>
	<p>
	    To enable the Richtext Editor in your Project you need to copy the separate <strong>struts2-jquery-richtext-plugin.jar</strong> into your WEB-INF/lib path.
	</p>
    <s:form id="formRichtext" action="simpleecho" theme="css_xhtml">
    <s:hidden name="escape" value="false"/>
	<s:url id="remoteurl" action="ajax1"/>
		<sjr:tinymce 
			id="richtextTinymceAdvancedEditor" 
			name="echo" 
			rows="10" 
			cols="80" 
			width="700"
			resizable="true"
			href="%{remoteurl}" 
			editorLocal="de"
			editorTheme="advanced"
			editorSkin="o2k7"
			toolbarAlign="left"
			toolbarLocation="top"
			statusbarLocation="bottom"
			resizable="true" 
			pastePlainText="true"
			plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template"
			toolbarButtonsRow1="save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect,fontselect,fontsizeselect"
			toolbarButtonsRow2="cut,copy,pastetext,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor"
			toolbarButtonsRow3="tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen"
			toolbarButtonsRow4="insertlayer,moveforward,movebackward,absolute,|,styleprops,spellchecker,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,blockquote,pagebreak,|,insertfile,insertimage"
			onSaveTopics="submitRichtextForm"
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

    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    

    
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;s:form id=&quot;formRichtext&quot; action=&quot;simpleecho&quot; theme=&quot;css_xhtml&quot;&gt;
    &lt;s:hidden name=&quot;escape&quot; value=&quot;false&quot;/&gt;
	&lt;s:url id=&quot;remoteurl&quot; action=&quot;ajax1&quot;/&gt;
		&lt;sjr:tinymce 
			id=&quot;richtextTinymceAdvancedEditor&quot; 
			name=&quot;echo&quot; 
			rows=&quot;10&quot; 
			cols=&quot;80&quot; 
			width=&quot;800&quot;
			href=&quot;%{remoteurl}&quot; 
			editorLocal=&quot;de&quot;
			editorTheme=&quot;advanced&quot;
			editorSkin=&quot;o2k7&quot;
			toolbarAlign=&quot;left&quot;
			toolbarLocation=&quot;top&quot;
			plugins=&quot;safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template&quot;
			toolbarButtonsRow1=&quot;save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect,fontselect,fontsizeselect&quot;
			toolbarButtonsRow2=&quot;cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor&quot;
			toolbarButtonsRow3=&quot;tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen&quot;
			toolbarButtonsRow4=&quot;insertlayer,moveforward,movebackward,absolute,|,styleprops,spellchecker,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,blockquote,pagebreak,|,insertfile,insertimage&quot;
			onSaveTopics=&quot;submitRichtextForm&quot;
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

    &lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
