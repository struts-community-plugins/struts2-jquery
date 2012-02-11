<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<jsp:include page="inc.header.jsp" />
		<sjm:div role="page" id="selectpage">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for Select Tag</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content">
				<form>
					<sjm:select
			    		id="select1"
			    		name="echo"
			            label="Choose your Friend"
			            list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
			        />
					<sjm:select
			    		id="select2"
			    		name="echo"
			    		multiple="true"
			    		emptyOption="true"
			            label="Choose your Friends"
			            list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
			        />
				</form>	
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;sjm:select
	id=&quot;select1&quot;
	name=&quot;echo&quot;
	label=&quot;Choose your Friend&quot;
	list=&quot;{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}&quot;
/&gt;
&lt;sjm:select
	id=&quot;select2&quot;
	name=&quot;echo&quot;
	multiple=&quot;true&quot;
	emptyOption=&quot;true&quot;
	label=&quot;Choose your Friend&quot;
	list=&quot;{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}&quot;
/&gt;
					</pre>
	    		</sjm:div>
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>