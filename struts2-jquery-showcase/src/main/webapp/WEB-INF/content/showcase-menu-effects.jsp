<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<div class="ym-g50 ym-gl">
	<sj:menu id="effectsMenu">
		<s:url var="urleffectdiv" action="effect-div"/>
		<sj:menuItem href="%{urleffectdiv}" targets="content" title="Highlight Effect / Click" />

		<s:url var="urleffectdivshake" action="effect-div-shake"/>
		<sj:menuItem href="%{urleffectdivshake}" targets="content" title="Shake Effect / MouseOver" />

		<s:url var="urleffectdivsize" action="effect-div-size"/>
		<sj:menuItem href="%{urleffectdivsize}" targets="content" title="Size Effect / Bind on Link" />

		<s:url var="urleffectdivevents" action="effect-div-events"/>
		<sj:menuItem href="%{urleffectdivevents}" targets="content" title="Fold Effect with Events" />

		<s:url var="urleffectdivresize" action="effect-div-resizeable"/>
		<sj:menuItem href="%{urleffectdivresize}" targets="content" title="A Resizeable Div" />

		<s:url var="urleffectdivdragdrop" action="effect-div-dragdrop"/>
		<sj:menuItem href="%{urleffectdivdragdrop}" targets="content" title="Drag and Drop" />

		<s:url var="urleffectdivselectable" action="effect-div-selectable"/>
		<sj:menuItem href="%{urleffectdivselectable}" targets="content" title="Selectable" />

		<s:url var="urleffectdivsortable" action="effect-div-sortable"/>
		<sj:menuItem href="%{urleffectdivsortable}" targets="content" title="Sortable" />

		<s:url var="urleffectdivportlets" action="effect-div-portlets"/>
		<sj:menuItem href="%{urleffectdivportlets}" targets="content" title="Sortable (Portlets)" />

		<s:url var="urleffectdivextend" action="effect-div-extend"/>
		<sj:menuItem href="%{urleffectdivextend}" targets="content" title="Extend this Plugin" />
	</sj:menu>
</div>
