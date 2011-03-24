<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
		<sjm:div role="page" id="listviewpage">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for List Tag</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content">
				<sjm:list
				    id="list"
				    inset="true"
				    list="myList"
				    listKey="key"
				    listValue="title"
		        />
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;sjm:list
    id=&quot;list&quot;
    inset=&quot;true&quot;
    list=&quot;myList&quot;
    listKey=&quot;key&quot;
    listValue=&quot;title&quot;
/&gt;
					</pre>
	    		</sjm:div>
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
