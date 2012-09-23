<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<jsp:include page="inc.header.jsp" />
		<sjm:div role="page" id="radiopage">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for Radio Tag</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content">
			<form>
				<sjm:radio
		    		id="radio1"
		    		name="radio1"
		            label="Friends"
		            list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
		        />
			</form>	
			<form>
				<sjm:radio
		    		id="radio2"
		    		name="radio2"
		            label="Friends"
		            required="true"
		            horizontal="true"
		            list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
		        />
			</form>	
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;form&gt;
  &lt;sjm:radio
    id=&quot;radio1&quot;
    name=&quot;radio1&quot;
    label=&quot;Friends&quot;
    list=&quot;{&#39;Patrick&#39;, &#39;Jason&#39;, &#39;Jay&#39;, &#39;Toby&#39;, &#39;Rene&#39;}&quot;
  /&gt;
&lt;/form&gt;
&lt;form&gt;
  &lt;sjm:radio
    id=&quot;radio2&quot;
    name=&quot;radio2&quot;
    label=&quot;Friends&quot;
    required=&quot;true&quot;
    horizontal=&quot;true&quot;
    list=&quot;{&#39;Patrick&#39;, &#39;Jason&#39;, &#39;Jay&#39;, &#39;Toby&#39;, &#39;Rene&#39;}&quot;
  /&gt;
&lt;/form&gt;
					</pre>
	    		</sjm:div>
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>