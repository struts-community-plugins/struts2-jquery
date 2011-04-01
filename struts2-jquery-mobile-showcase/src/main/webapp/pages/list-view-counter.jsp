<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
		<sjm:div role="page" id="listviewcounterpage" dataTheme="e">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for List Tag with Counter</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content">
				<s:url id="url_echo" action="echo"/>
				<sjm:list
				    id="list"
				    inset="true"
				    list="myList"
				    listHref="%{url_echo}"
				    listParam="echo"
				    listKey="key"
				    listValue="title"
				    listCounter="count"
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
					</pre>
	    		</sjm:div>
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
