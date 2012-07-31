<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<jsp:include page="inc.header.jsp" />
		<sjm:div role="page" id="start">
			<sjm:div role="header">
				<h1><s:property value="message"/></h1>
			</sjm:div>
			
			<sjm:div role="content">
				<h2><s:property value="message"/></h2>
				
				<sjm:list inset="true">
					<sjm:listItem divider="true">Languages</sjm:listItem>

				 	<s:url id="url" action="hello">
				    	<s:param name="request_locale">en</s:param>
				 	</s:url>
					<sjm:listItem id="en_link" href="%{url}">English</sjm:listItem>

				 	<s:url id="url" action="hello">
				    	<s:param name="request_locale">es</s:param>
				 	</s:url>
					<sjm:listItem id="es_link" href="%{url}">Espanol</sjm:listItem>
				</sjm:list>
			</sjm:div>
			
			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>
			