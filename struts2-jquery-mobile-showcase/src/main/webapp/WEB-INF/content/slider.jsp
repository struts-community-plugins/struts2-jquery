<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<jsp:include page="inc.header.jsp" />
		<sjm:div role="page" id="sliderpage">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for Slider Tag</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content">
				<form>
					<sjm:slider
						id="slider1"
			    		name="slider1"
			            label="Slider One"
			        />
                    <sjm:slider
                        id="slider2"
                        name="slider2"
                        label="Slider Two"
                        min="100"
                        max="250"
                        value="175"
                    />
				</form>
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;sjm:slider
  id=&quot;slider1&quot;
  name=&quot;slider1&quot;
  label=&quot;Slider One&quot;
/&gt;
&lt;sjm:slider
  id=&quot;slider2&quot;
  name=&quot;slider2&quot;
  label=&quot;Slider Two&quot;
  min=&quot;100&quot;
  max=&quot;250&quot;
  value=&quot;175&quot;
/&gt;
					</pre>
	    		</sjm:div>
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>