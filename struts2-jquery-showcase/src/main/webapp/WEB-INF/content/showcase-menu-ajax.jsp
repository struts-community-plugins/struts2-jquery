<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

	<sj:menu id="ajaxMenu">
		<sj:menuItem title="Link">
			<sj:menu id="subMenuAjaxLink">
				<s:url var="urlremotelink" action="remote-link"/>
				<sj:menuItem id="remotesimplelink" href="%{urlremotelink}" targets="content" title="Simple AJAX Link" />

				<s:url var="urlremotelinktargets" action="remote-link-targets"/>
				<sj:menuItem id="remotetargetslink" href="%{urlremotelinktargets}" targets="content" title="Link with 2 Targets" />

				<s:url var="urlremotelinkform" action="remote-link-form"/>
				<sj:menuItem id="remoteformlink" href="%{urlremotelinkform}" targets="content" title="Link with Form submit" />

				<s:url var="urlremotelinkevent" action="remote-link-event"/>
				<sj:menuItem id="remoteeventlink" href="%{urlremotelinkevent}" targets="content" title="Link with Event" />

				<s:url var="urlremotelinkhighlight" action="remote-link-highlight"/>
				<sj:menuItem id="remotehighlightlink" href="%{urlremotelinkhighlight}" targets="content" title="Link with Highlight Effect" />

				<s:url var="urlremotelinkbounce" action="remote-link-bounce"/>
				<sj:menuItem id="remotebouncelink" href="%{urlremotelinkbounce}" targets="content" title="Link with Bounce Effect" />

				<s:url var="urlremotelinkjson" action="remote-link-json"/>
				<sj:menuItem id="remotejsonlink" href="%{urlremotelinkjson}" targets="content" title="JSON Results" />
			</sj:menu>
		</sj:menuItem>
		<sj:menuItem title="Div">
			<sj:menu id="subMenuAjaxDiv">

				<s:url var="urlremotediv" action="remote-div"/>
				<sj:menuItem id="remotedivlink" href="%{urlremotediv}" targets="content" title="AJAX Div" />

				<s:url var="urlremotedivpulasate" action="remote-div-pulsate"/>
				<sj:menuItem id="remotedivpulsatelink" href="%{urlremotedivpulasate}" targets="content" title="Div with Pulsate Effect" />

				<s:url var="urlremotedivresize" action="remote-div-resizable"/>
				<sj:menuItem id="remotedivresizelink" href="%{urlremotedivresize}" targets="content" title="Div - Resizable" />

				<s:url var="urlremotedivevent" action="remote-div-event"/>
				<sj:menuItem id="remotediveventlink" href="%{urlremotedivevent}" targets="content" title="With Events" />

				<s:url var="urlremotedivreload" action="remote-div-reload"/>
				<sj:menuItem id="remotedivreloadlink" href="%{urlremotedivreload}" targets="content" title="Div - Reload" />

				<s:url var="urlremotedivlisten" action="remote-div-listen"/>
				<sj:menuItem id="remotedivlistenlink" href="%{urlremotedivlisten}" targets="content" title="Div - Listen Topics" />

				<s:url var="urleffectdivdragdrop" action="effect-div-dragdrop"/>
				<sj:menuItem id="remotedivdragdroplink" href="%{urleffectdivdragdrop}" targets="content" title="Drag and Drop" />
			</sj:menu>
		</sj:menuItem>
		<sj:menuItem title="Form">
			<sj:menu id="subMenuAjaxForms">

				<s:url var="urlform" action="form"/>
				<sj:menuItem id="remoteform" href="%{urlform}" targets="content" title="AJAX Forms" />

				<s:url var="urlformeffect" action="form-effect"/>
				<sj:menuItem id="remoteformeffectlink" href="%{urlformeffect}" targets="content" title="Forms with Effects" />

				<s:url var="urlformout" action="form-out"/>
				<sj:menuItem id="remoteformoutlink" href="%{urlformout}" targets="content" title="Forms with Outside Button" />

				<s:url var="urlformftl" action="form-ftl"/>
				<sj:menuItem id="remoteformftllink" href="%{urlformftl}" targets="content" title="Forms with Freemarke" />

				<s:url var="urlformvel" action="form-velocity"/>
				<sj:menuItem id="remoteformvellink" href="%{urlformvel}" targets="content" title="Forms with Velocity" />

				<s:url var="urlformevent" action="form-event"/>
				<sj:menuItem id="remoteformeventlink" href="%{urlformevent}" targets="content" title="Forms with Events" />

				<s:url var="urlformlisten" action="form-listen"/>
				<sj:menuItem id="remoteformlistenlink" href="%{urlformlisten}" targets="content" title="Forms with Listen Topics" />

				<s:url var="urlformvalidation" action="form-validation"/>
				<sj:menuItem id="remoteformvalidationlink" href="%{urlformvalidation}" targets="content" title="Forms with Validation" />

				<s:url var="urlformvalidationcust" action="form-validation-custome"/>
				<sj:menuItem id="remoteformvalidationcustlink" href="%{urlformvalidationcust}" targets="content" title="Forms with Custome Validation" />

				<s:url var="urlformtextarea" action="form-textarea"/>
				<sj:menuItem id="remoteformtextarealink" href="%{urlformtextarea}" targets="content" title="AJAX Textarea" />

				<s:url var="urlformtextarearesize" action="form-textarea-resizeable"/>
				<sj:menuItem id="remoteformtextarearesizelink" href="%{urlformtextarearesize}" targets="content" title="AJAX Textarea / Resizable" />

				<s:url var="urlformtextfieldresize" action="form-textfield-resizeable"/>
				<sj:menuItem id="remoteformtextfieldresizelink" href="%{urlformtextfieldresize}" targets="content" title="AJAX Textfield / Resizable" />

				<s:url var="urlformbuttonsetcheckbox" action="form-buttonset-checkbox"/>
				<sj:menuItem id="remoteformbuttonsetcheckboxes" href="%{urlformbuttonsetcheckbox}" targets="content" title="Buttonset / Checkboxes" />

				<s:url var="urlformbuttonsetradio" action="form-buttonset-radio"/>
				<sj:menuItem id="remoteformbuttonsetradio" href="%{urlformbuttonsetradio}" targets="content" title="Buttonset / Radio Buttons" />

				<s:url var="urlformselect" action="form-select"/>
				<sj:menuItem id="remoteformselectlink" href="%{urlformselect}" targets="content" title="AJAX Select" />

				<s:url var="urlformdoubleselect" action="form-doubleselect"/>
				<sj:menuItem id="remoteformdoubleselectlink" href="%{urlformdoubleselect}" targets="content" title="AJAX Select (Doubleselect)" />
			</sj:menu>
		</sj:menuItem>
	</sj:menu>
