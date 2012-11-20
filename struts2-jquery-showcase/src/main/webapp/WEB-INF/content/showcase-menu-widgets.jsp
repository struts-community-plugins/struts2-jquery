<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

	<sj:menu id="widgetsMenu">
		<sj:menuItem title="Accordion">
			<sj:menu id="subMenuAccordion">
				<s:url var="urlaccordion" action="accordion"/>
				<sj:menuItem id="accordionlink" href="%{urlaccordion}" targets="content" title="Accordion" />

				<s:url var="urlaccordionlist" action="accordion-list"/>
				<sj:menuItem id="accordionlistlink" href="%{urlaccordionlist}" targets="content" title="Accordion from List" />

				<s:url var="urlaccordionremote" action="accordion-remote"/>
				<sj:menuItem id="accordionremotelink" href="%{urlaccordionremote}" targets="content" title="Accordion with remote content" />

				<s:url var="urlaccordionmouseover" action="accordion-mouseover"/>
				<sj:menuItem id="accordionmouseoverlink" href="%{urlaccordionmouseover}" targets="content" title="Accordion Collabsible/MouseOver" />
			</sj:menu>
		</sj:menuItem>
		<sj:menuItem title="Autocompleter">
			<sj:menu id="subMenuAutocompleter">

				<s:url var="urlautocompleter" action="autocompleter"/>
				<sj:menuItem id="autocompletersimple" href="%{urlautocompleter}" targets="content" title="Autocompleter" />

				<s:url var="urlautocompleterjson" action="autocompleter-json"/>
				<sj:menuItem id="autocompleterjson" href="%{urlautocompleterjson}" targets="content" title="Autocompleter JSON" />

				<s:url var="urlautocompleterselect" action="autocompleter-select"/>
				<sj:menuItem id="autocompleterselect" href="%{urlautocompleterselect}" targets="content" title="Autocompleter (Select Box)" />
			</sj:menu>
		</sj:menuItem>

		<s:url var="urlcharts" action="charts"/>
		<sj:menuItem id="chartslink" href="%{urlcharts}" targets="content" title="Charts" />

		<sj:menuItem title="Datepicker">
			<sj:menu id="subMenuDatepicker">

				<s:url var="urldatepicker" action="datepicker"/>
				<sj:menuItem id="datepickerlink" href="%{urldatepicker}" targets="content" title="Datepicker" />

				<s:url var="urldatepickerbuttons" action="datepicker-buttons"/>
				<sj:menuItem id="datepickerbuttonslink" href="%{urldatepickerbuttons}" targets="content" title="Datepicker with more option" />

				<s:url var="urldatepickerinline" action="datepicker-inline"/>
				<sj:menuItem id="datepickerinlinelink" href="%{urldatepickerinline}" targets="content" title="Datepicker (Inline)" />

				<s:url var="urldatepickertime" action="datepicker-time"/>
				<sj:menuItem id="datepickertimelink" href="%{urldatepickertime}" targets="content" title="Timepicker" />
			</sj:menu>
		</sj:menuItem>

		<sj:menuItem title="Dialog">
			<sj:menu id="subMenuDialog">

				<s:url var="urldialog" action="dialog"/>
				<sj:menuItem id="dialolink" href="%{urldialog}" targets="content" title="Dialog" />

				<s:url var="urldialogclick" action="dialog-click"/>
				<sj:menuItem id="dialogclick" href="%{urldialogclick}" targets="content" title="Dialog open on Click" />

				<s:url var="urldialogremote" action="dialog-remote"/>
				<sj:menuItem id="dialogremotelink" href="%{urldialogremote}" targets="content" title="Dialog with AJAX Content" />

				<s:url var="urldialogremotelink" action="dialog-remote-link"/>
				<sj:menuItem id="dialogremotelinklink" href="%{urldialogremotelink}" targets="content" title="More AJAX Dialogs" />

				<s:url var="urldialogmodal" action="dialog-modal"/>
				<sj:menuItem id="dialogmodallink" href="%{urldialogmodal}" targets="content" title="Modal Dialog" />

				<s:url var="urldialogbuttons" action="dialog-buttons"/>
				<sj:menuItem id="dialogbuttonslink" href="%{urldialogbuttons}" targets="content" title="Dialog with Buttons" />

				<s:url var="urldialogeffect" action="dialog-effect"/>
				<sj:menuItem id="dialogeffectlink" href="%{urldialogeffect}" targets="content" title="Dialog with Effect" />

				<s:url var="urldialogtopics" action="dialog-topics"/>
				<sj:menuItem id="dialogtopicslink" href="%{urldialogtopics}" targets="content" title="Dialog with Topics" />
			</sj:menu>
		</sj:menuItem>

		<sj:menuItem title="Grid">
			<sj:menu id="subMenuGrid">

				<s:url var="urlgrid" action="grid" namespace="/grid"/>
				<sj:menuItem id="gridink" href="%{urlgrid}" targets="content" title="Grid" />

				<s:url var="urlgridedit" action="grid-edit" namespace="/grid"/>
				<sj:menuItem id="grideditlink" href="%{urlgridedit}" targets="content" title="Grid (Editable)" />

				<s:url var="urlgridmulti" action="grid-multi" namespace="/grid"/>
				<sj:menuItem id="gridmultilink" href="%{urlgridmulti}" targets="content" title="Grid (Editable/Multiselect)" />

				<s:url var="urlgridloadonce" action="grid-loadonce" namespace="/grid"/>
				<sj:menuItem id="gridloadoncelink" href="%{urlgridloadonce}" targets="content" title="Grid (Local Data)" />

				<s:url var="urlgridgrouping" action="grid-grouping" namespace="/grid"/>
				<sj:menuItem id="gridgroupinglink" href="%{urlgridgrouping}" targets="content" title="Grid (Grouping)" />

			</sj:menu>
		</sj:menuItem>

		<sj:menuItem title="Menu">
			<sj:menu id="subMenuMenu">

				<s:url var="urlmenu" action="menu"/>
				<sj:menuItem id="menulink" href="%{urlmenu}" targets="content" title="Menu with Items" />

				<s:url var="urlmenulist" action="menu-list"/>
				<sj:menuItem id="menulistlink" href="%{urlmenulist}" targets="content" title="Menu from List" />

			</sj:menu>
		</sj:menuItem>

		<s:url var="urlmessages" action="messages"/>
		<sj:menuItem id="messageslink" href="%{urlmessages}" targets="content" title="Action Errors/Messages" />

		<sj:menuItem title="Progressbar">
			<sj:menu id="subMenuProgressbar">

				<s:url var="urlprogressbar" action="progressbar"/>
				<sj:menuItem id="progressbarsimplelink" href="%{urlprogressbar}" targets="content" title="Progressbar" />

				<s:url var="urlprogressbarchange" action="progressbar-change"/>
				<sj:menuItem id="progressbarchangelink" href="%{urlprogressbarchange}" targets="content" title="Progressbar with change event" />

				<s:url var="urlprogressbarresizeable" action="progressbar-resizeable"/>
				<sj:menuItem id="progressbarresizeablelink" href="%{urlprogressbarresizeable}" targets="content" title="Resizeable progressbar" />

			</sj:menu>
		</sj:menuItem>

		<sj:menuItem title="Richtext">
			<sj:menu id="subMenuRichtext">

				<s:url var="urlrichtext" action="richtext"/>
				<sj:menuItem id="richtextlink" href="%{urlrichtext}" targets="content" title="Richtext - Ckeditor" />

				<s:url var="urlrichtextcustome" action="richtext-custome"/>
				<sj:menuItem id="richtextcustomelink" href="%{urlrichtextcustome}" targets="content" title="Richtext - Ckeditor (Custome Toolbar)" />

				<s:url var="urlrichtexttinymce" action="richtext-tinymce"/>
				<sj:menuItem id="richtexttinymcelink" href="%{urlrichtexttinymce}" targets="content" title="Richtext - Tinymce" />

				<s:url var="urlrichtexttinymceadvanced" action="richtext-tinymce-advanced"/>
				<sj:menuItem id="richtexttinymcelinkadvanced" href="%{urlrichtexttinymceadvanced}" targets="content" title="Richtext - Tinymce (Advanced)" />

			</sj:menu>
		</sj:menuItem>

		<sj:menuItem title="Slider">
			<sj:menu id="subMenuSlider">

				<s:url var="urlslider" action="slider"/>
				<sj:menuItem id="slidersimplelink" href="%{urlslider}" targets="content" title="Slider" />

				<s:url var="urlsliderform" action="slider-form"/>
				<sj:menuItem id="sliderformlink" href="%{urlsliderform}" targets="content" title="Slider in a Form" />

				<s:url var="urlsliderrange" action="slider-range"/>
				<sj:menuItem id="sliderrangelink" href="%{urlsliderrange}" targets="content" title="Slider with Range and Events" />

			</sj:menu>
		</sj:menuItem>

		<s:url var="urlspinner" action="spinner"/>
		<sj:menuItem id="spinnerlink" href="%{urlspinner}" targets="content" title="Spinner" />

		<sj:menuItem title="Tabs">
			<sj:menu id="subMenuTabs">

				<s:url var="urltabslocal" action="tabs-local"/>
				<sj:menuItem id="tabslocallink" href="%{urltabslocal}" targets="content" title="Local Tabs" />

				<s:url var="urltabs" action="tabs"/>
				<sj:menuItem id="tabslocalremote" href="%{urltabs}" targets="content" title="Remote Tabs with Topics" />

				<s:url var="urltabspreselect" action="tabs-preselect"/>
				<sj:menuItem id="tabspreselectedlink" href="%{urltabspreselect}" targets="content" title="Preselectet Tabs with Animation" />

			</sj:menu>
		</sj:menuItem>

		<sj:menuItem title="Tree">
			<sj:menu id="subMenuTree">

				<s:url var="urltree" action="tree" namespace="/tree"/>
				<sj:menuItem id="treelink" href="%{urltree}" targets="content" title="Tree" />

				<s:url var="urltreejson" action="tree-json" namespace="/tree"/>
				<sj:menuItem id="treejsonlink" href="%{urltreejson}" targets="content" title="Tree (JSON Data)" />

			</sj:menu>
		</sj:menuItem>
	</sj:menu>
