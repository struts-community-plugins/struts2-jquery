<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<jsp:include page="inc.header.jsp" />
		<sjm:div role="page" id="listviewcounterpage">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for List Tag with Counter</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content">
				<s:url var="url_echo" action="echo" namespace="/"/>
				<sjm:list
				    id="list"
				    inset="true"
				    list="myList"
				    listHref="%{url_echo}"
				    listParam="echo"
				    listKey="key"
				    listValue="title"
				    listCounter="count"
			        dataTheme="b"
		        />
		        <h2>List with different Theme</h2>
				<sjm:list
				    id="list"
				    inset="true"
				    list="myList"
				    listHref="%{url_echo}"
				    listParam="echo"
				    listKey="key"
				    listValue="title"
				    listCounter="count"
			        dataTheme="e"
		        />
		        <h2>A Readonly List</h2>
				<sjm:list
				    id="list"
				    inset="true"
				    list="myList"
				    listValue="title"
				    listCounter="count"
			        dataTheme="a"
		        />
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;s:url id=&quot;url_echo&quot; action=&quot;echo&quot;/&gt;
&lt;sjm:list
    id=&quot;list&quot;
    inset=&quot;true&quot;
    list=&quot;myList&quot;
    listHref=&quot;%{url_echo}&quot;
    listParam=&quot;echo&quot;
    listKey=&quot;key&quot;
    listValue=&quot;title&quot;
    listCounter=&quot;count&quot;
/&gt;
&lt;h2&gt;List with different Theme&lt;/h2&gt;
&lt;sjm:list
	id=&quot;list&quot;
	inset=&quot;true&quot;
	list=&quot;myList&quot;
	listHref=&quot;%{url_echo}&quot;
	listParam=&quot;echo&quot;
	listKey=&quot;key&quot;
	listValue=&quot;title&quot;
	listCounter=&quot;count&quot;
	dataTheme=&quot;e&quot;
/&gt;
					</pre>
	    		</sjm:div>
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>