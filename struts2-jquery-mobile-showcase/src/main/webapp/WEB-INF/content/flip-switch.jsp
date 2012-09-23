<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<jsp:include page="inc.header.jsp" />
		<sjm:div role="page" id="flipSwitchPage">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for Flip Switch Tag</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content"  dataTheme="e">
				<form>
					<sjm:flipSwitch
						id="flipSwitch1"
			    		name="flipSwitch1"
			            label="Flip Switch One"
			        />
					<sjm:flipSwitch
						id="flipSwitch2"
			    		name="flipSwitch2"
			            label="Flip Switch Two"
			            required="true"
			            onTitle="An"
			            offTitle="Aus"
			            dataTheme="a"
			        />
				</form>
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;sjm:flipSwitch
	id=&quot;flipSwitch1&quot;
	name=&quot;flipSwitch1&quot;
	label=&quot;Flip Switch One&quot;
/&gt;
&lt;sjm:flipSwitch
	id=&quot;flipSwitch2&quot;
	name=&quot;flipSwitch2&quot;
	label=&quot;Flip Switch Two&quot;
	required=&quot;true&quot;
	onTitle=&quot;An&quot;
	offTitle=&quot;Aus&quot;
/&gt;
					</pre>
	    		</sjm:div>
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>