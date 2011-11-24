<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<!DOCTYPE html>
<html>
	<head>
    	<title>Struts2 jQuery Mobile Plugin Showcase</title>
    	<sjm:head jqueryui="false"/>
	</head>
	<body>
		<sjm:div role="page" id="start">
			<sjm:div role="header">
				<h1>Struts2 jQuery Mobile Plugin Showcase</h1>
				<h2>Version <s:text name="showcase.version"/></h2>
			</sjm:div>
			
			<sjm:div role="content">
				<p>All Examples Links here.</p>
				<sjm:list inset="true" filter="true">
					<sjm:listItem divider="true">AJAX</sjm:listItem>
					<s:url id="url_checkboxlist" action="checkboxlist"/>
					<sjm:listItem id="ajaxform_link" href="%{url_checkboxlist}">AJAX Form Examples</sjm:listItem>

					<sjm:listItem divider="true">Form Elements</sjm:listItem>
					<s:url id="url_textfield" action="textfield"/>
					<sjm:listItem id="textfield_link" href="%{url_textfield}">Textfield</sjm:listItem>
					<s:url id="url_textarea" action="textarea"/>
					<sjm:listItem id="textarea_link" href="%{url_textarea}">Textarea</sjm:listItem>
					<s:url id="url_password" action="password"/>
					<sjm:listItem id="password_link" href="%{url_password}">Password</sjm:listItem>
					<s:url id="url_searchfield" action="searchfield"/>
					<sjm:listItem id="searchfield_link" href="%{url_searchfield}">Searchfield</sjm:listItem>
					<s:url id="url_checkbox" action="checkbox"/>
					<sjm:listItem id="checkbox_link" href="%{url_checkbox}">Checkbox</sjm:listItem>
					<s:url id="url_checkboxlist" action="checkboxlist"/>
					<sjm:listItem id="checkboxlist_link" href="%{url_checkboxlist}">Checkbox List</sjm:listItem>
					<s:url id="url_radio" action="radio"/>
					<sjm:listItem id="radio_link" href="%{url_radio}">Radio Buttons</sjm:listItem>
					<s:url id="url_select" action="select"/>
					<sjm:listItem id="select_link" href="%{url_select}">Select</sjm:listItem>
                    <s:url id="url_slider" action="slider"/>
                    <sjm:listItem id="slider_link" href="%{url_slider}">Slider</sjm:listItem>
                    <s:url id="url_flip" action="flip-switch"/>
                    <sjm:listItem id="flip_link" href="%{url_flip}">Flip Switch</sjm:listItem>

					<sjm:listItem divider="true">List View</sjm:listItem>
					<s:url id="url_listview" action="list-view"/>
					<sjm:listItem id="listview_link" href="%{url_listview}">List View</sjm:listItem>
					<s:url id="url_listviewcounter" action="list-view-counter"/>
					<sjm:listItem id="listviewcounter_link" href="%{url_listviewcounter}">List View with Counter</sjm:listItem>
				</sjm:list>
			</sjm:div>
			
			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>
