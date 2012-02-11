<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<jsp:include page="inc.header.jsp" />
		<sjm:div role="page" id="checkboxpage">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for Checkbox Tag</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content">
				<form>
					<sjm:checkbox
			    		id="checkbox1"
			    		name="checkbox"
			            label="I Agree"
			        />
					<sjm:checkbox
			    		id="checkbox2"
			    		name="checkbox"
			            label="I love it"
			            required="true"
			        />
				</form>	
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;sjm:checkbox
      id=&quot;checkbox&quot;
      name=&quot;checkbox&quot;
      label=&quot;I Agree&quot;
/&gt;
&lt;sjm:checkbox
      id=&quot;checkbox&quot;
      name=&quot;checkbox&quot;
      label=&quot;I love it&quot;
      required=&quot;true&quot;
/&gt;
					</pre>
	    		</sjm:div>
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>