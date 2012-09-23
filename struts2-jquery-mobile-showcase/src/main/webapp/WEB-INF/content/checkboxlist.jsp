<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<jsp:include page="inc.header.jsp" />
		<sjm:div role="page" id="checkboxlistpage" dataTheme="b">
			<sjm:div role="header">
				<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
				<h1>Examples for Checkbox List Tag</h1>
				<sjm:a href="#start" button="true" buttonIcon="home">Back to Start</sjm:a>
			</sjm:div>

			<sjm:div role="content">
			
				<h1>A Checkbox List</h1>
				
			    <s:form id="checkboxlist_form1" action="echo" theme="simple">
			    	<s:hidden name="ajax" value="true"/>
					<sjm:checkboxlist
			    		id="checkboxlist1"
			    		name="echo"
			            label="Friends"
			            list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
			        />
			        <sjm:a 
				    	id="checkboxlist_form_link1" 
				    	formIds="checkboxlist_form1" 
				    	targets="checkboxlist_form_result_1" 
				    	button="true" 
						buttonIcon="gear"
	    			>
	      				Submit
	    			</sjm:a>
			        
				</s:form>	
				
				<div id="checkboxlist_form_result_1">Submit form above.</div>
	    
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;s:form id=&quot;checkboxlist_form1&quot; action=&quot;echo&quot; theme=&quot;simple&quot;&gt;
	&lt;sjm:checkboxlist
   		id=&quot;checkboxlist1&quot;
   		name=&quot;echo&quot;
           label=&quot;Friends&quot;
           list=&quot;{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}&quot;
       /&gt;
       &lt;sjm:a 
    	id=&quot;checkboxlist_form_link1&quot; 
    	formIds=&quot;checkboxlist_form1&quot; 
    	targets=&quot;checkboxlist_form_result_1&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;gear&quot;
 			&gt;
   				Submit
 			&lt;/sjm:a&gt;
       
&lt;/s:form&gt;	

&lt;div id=&quot;checkboxlist_form_result_1&quot;&gt;Submit form above.&lt;/div&gt;
					</pre>
	    		</sjm:div>
	    
				<h1>A horizontal Checkbox List</h1>
				
			    <s:form id="checkboxlist_form2" action="echo" theme="simple">
			    	<s:hidden name="ajax" value="true"/>
					<sjm:checkboxlist
			    		id="checkboxlist2"
			    		name="echo"
			            label="Friends"
			            required="true"
			            horizontal="true"
			            list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
			        />
			        <sjm:a 
				    	id="checkboxlist_form_link2" 
				    	formIds="checkboxlist_form2" 
				    	targets="checkboxlist_form_result_2" 
				    	button="true" 
						buttonIcon="gear"
	    			>
	      				Submit
	    			</sjm:a>
			        
				</s:form>	
				
				<div id="checkboxlist_form_result_2">Submit form above.</div>
	    
	    		<sjm:div role="collapsible" data-collapsed="true">
	    			<h3>Example Code</h3>
					<pre>
&lt;s:form id=&quot;checkboxlist_form2&quot; action=&quot;echo&quot; theme=&quot;simple&quot;&gt;
	&lt;sjm:checkboxlist
   		id=&quot;checkboxlist2&quot;
   		name=&quot;echo&quot;
           label=&quot;Friends&quot;
           required=&quot;true&quot;
           horizontal=&quot;true&quot;
           list=&quot;{&#39;Patrick&#39;, &#39;Jason&#39;, &#39;Jay&#39;, &#39;Toby&#39;, &#39;Rene&#39;}&quot;
       /&gt;
       &lt;sjm:a 
    	id=&quot;checkboxlist_form_link2&quot; 
    	formIds=&quot;checkboxlist_form2&quot; 
    	targets=&quot;checkboxlist_form_result_2&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;gear&quot;
 			&gt;
   				Submit
 			&lt;/sjm:a&gt;
       
&lt;/s:form&gt;	

&lt;div id=&quot;checkboxlist_form_result_2&quot;&gt;Submit form above.&lt;/div&gt;
					</pre>
	    		</sjm:div>
	    
			</sjm:div>

			<jsp:include page="inc.footer.jsp" />
		</sjm:div>
	</body>
</html>