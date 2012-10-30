<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

	<sj:menu id="effectsMenu">
		<li><s:url var="urleffectdiv" action="effect-div"/><sj:a href="%{urleffectdiv}" targets="content">Highlight Effect / Click</sj:a></li>
		<li><s:url var="urleffectdivshake" action="effect-div-shake"/><sj:a href="%{urleffectdivshake}" targets="content">Shake Effect / MouseOver</sj:a></li>
		<li><s:url var="urleffectdivsize" action="effect-div-size"/><sj:a href="%{urleffectdivsize}" targets="content">Size Effect / Bind on Link</sj:a></li>
		<li><s:url var="urleffectdivevents" action="effect-div-events"/><sj:a href="%{urleffectdivevents}" targets="content">Fold Effect with Events</sj:a></li>
		<li><s:url var="urleffectdivresize" action="effect-div-resizeable"/><sj:a href="%{urleffectdivresize}" targets="content">A Resizeable Div</sj:a></li>
		<li><s:url var="urleffectdivdragdrop" action="effect-div-dragdrop"/><sj:a href="%{urleffectdivdragdrop}" targets="content">Drag and Drop</sj:a></li>
		<li><s:url var="urleffectdivselectable" action="effect-div-selectable"/><sj:a href="%{urleffectdivselectable}" targets="content">Selectable</sj:a></li>
		<li><s:url var="urleffectdivsortable" action="effect-div-sortable"/><sj:a href="%{urleffectdivsortable}" targets="content">Sortable</sj:a></li>
		<li><s:url var="urleffectdivportlets" action="effect-div-portlets"/><sj:a href="%{urleffectdivportlets}" targets="content">Sortable (Portlets)</sj:a></li>
		<li><s:url var="urleffectdivextend" action="effect-div-extend"/><sj:a href="%{urleffectdivextend}" targets="content">Extend this Plugin</sj:a></li>
	</sj:menu>
