<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<jsp:include page="inc.header.jsp" />
		<sjm:div role="page" id="textfieldpage">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for Textfield Tag</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content">
				<form>
					<sjm:textfield
						id="textfield"
			    		name="textfield"
			            label="Enter Your Name"
			        />
				</form>	
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;sjm:textfield
  id=&quot;textfield&quot;
  name=&quot;textfield&quot;
  label=&quot;Enter Your Name&quot;
/&gt;
					</pre>
	    		</sjm:div>
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>