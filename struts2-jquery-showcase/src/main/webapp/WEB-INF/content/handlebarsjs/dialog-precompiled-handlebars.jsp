<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjhb" uri="/struts-jquery-handlebarsjs-tags" %>
    <h2>Dialog opened by Links and filled by a precompiled HandlebarsJS template </h2>
    <p class="text">
        A modal Dialog open by click on Link and loads the result as dialog content.
    </p>
    <script>
    /*Destroy previous instances of jQuery Dialogs  */
	$(".ui-dialog-content").each(function(i,elt){
		if ($(elt).dialog){
			  $(this).dialog('destroy').remove();		  
		}
	});
	</script>
    <sj:dialog 
    	id="myremotetemplatedialog" 
    	autoOpen="false" 
    	modal="true" 
    	title="Dialog with Precompiled HandlebarJS Generated content"
    	openTopics="openRemoteDialog"
    />
    
	<s:url var="customerSource" namespace="/handlebarsjs" action="random-customer"  />	
    <sj:a     	
    	href="%{customerSource}"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    	onSuccessTopics="openRemoteDialog,runPrecompiledTemplate"
    	dataType="json"
    >
    	Open Dialog
    </sj:a>
    <s:url value="/handlebarsjs/templates.js"   var="templateurl" />
    <sjhb:handlebars listenTopics="runPrecompiledTemplate"  templateName="customer-template" href="../handlebarsjs/templates.js" 
type="precompiled"  targets="myremotetemplatedialog" />

<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs" cssClass="list">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="pom" label="pom.xml"/>
	<div id="jsp">
	  <pre>
            <code class="html">
&lt;sj:dialog 
    	id=&quot;myremotelinkdialog&quot; 
    	autoOpen=&quot;false&quot;
    	modal=&quot;true&quot; 
    	title=&quot;Dialog with Precompiled HandlebarJS Generated content&quot;
    	openTopics=&quot;openRemoteDialog&quot;
    /&gt;
    
	&lt;s:url var=&quot;customerSource&quot; namespace=&quot;/handlebarsjs&quot; action=&quot;random-customer&quot;  />	
    &lt;sj:a     	
    	href=&quot;%{customerSource}&quot;
    	button=&quot;true&quot;
    	buttonIcon=&quot;ui-icon-newwin&quot;
    	onSuccessTopics=&quot;openRemoteDialog,handleJsonResult&quot;
    	dataType=&quot;json&quot;
    &gt;
    	Open Dialog
    &lt;/sj:a&gt;
    &lt;s:url value=&quot;/handlebarsjs/templates.js&quot;   var=&quot;templateurl&quot; /&gt;
    &lt;sjhb:handlebars listenTopics=&quot;handleJsonResult&quot;  templateName=&quot;customer-template&quot; 
    href=&quot;../handlebarsjs/templates.js&quot; 
    type=&quot;precompiled&quot;  targets=&quot;myremotelinkdialog&quot; /&gt;
    </code>
    </pre>
</div>
<div id="pom">
	  <pre>
            <code class="xml">
&lt;!-- Sample using com.github.jknack.handlebars-maven-plugin for precompilation --&gt;
&lt;plugin&gt;
	&lt;groupId&gt;com.github.jknack&lt;/groupId&gt;
	&lt;artifactId&gt;handlebars-maven-plugin&lt;/artifactId&gt;
	&lt;version&gt;4.0.6&lt;/version&gt;
	&lt;executions&gt;
		&lt;execution&gt;
			&lt;id&gt;precompile&lt;/id&gt;
			&lt;phase&gt;prepare-package&lt;/phase&gt;
			&lt;goals&gt;
				&lt;goal&gt;precompile&lt;/goal&gt;
			&lt;/goals&gt;
			&lt;configuration&gt;
				&lt;output&gt;&dollar;{project.build.directory}/&dollar;{project.build.finalName}/handlebarsjs/templates.js&lt;/output&gt;
				&lt;prefix&gt;&dollar;{basedir}/src/main/webapp/handlebarsjs&lt;/prefix&gt;
				&lt;suffix&gt;.hbs&lt;/suffix&gt;
				&lt;minimize&gt;false&lt;/minimize&gt;							
			&lt;/configuration&gt;
		&lt;/execution&gt;
	&lt;/executions&gt;
&lt;/plugin&gt;
            </code>
           </pre>
         </div>
</sj:tabbedpanel>
