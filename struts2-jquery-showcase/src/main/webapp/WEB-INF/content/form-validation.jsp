<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Form submission with AJAX Validation</h2>

<p class="text">
	A Form submission with AJAX Validation for Forms with XHTML Theme.
</p>

<h2>Form Submit with AJAX</h2>

<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<s:form id="formValidateAjax" action="login" theme="xhtml">
	<s:textfield
			id="loginuser1"
			name="loginuser"
			label="User"
			required="true"
            requiredLabel="true"
			/>
	<s:textfield
			id="loginpassword1"
			name="loginpassword"
			label="Password (test)"
			required="true"
            requiredLabel="true"
			/>
	<sj:submit
			targets="result"
			button="true"
			validate="true"
			value="AJAX Submit"
			indicator="indicator"
			parentTheme="xhtml"
			/>
	<tr>
		<td colspan="2">
			<sj:a
					formIds="formValidateAjax"
					targets="result"
					button="true"
					buttonIcon="ui-icon-gear"
					validate="true"
					indicator="indicator"
					>AJAX Submit as Link</sj:a>
		</td>
	</tr>
</s:form>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<br/>

<h2>Form Submit without AJAX</h2>

<s:form id="formValidateNoAjax" action="login" theme="xhtml" target="_blank">
	<s:textfield
			id="loginuser2"
			name="loginuser"
			label="User"
			required="true"
			/>
	<s:textfield
			id="loginpassword2"
			name="loginpassword"
			label="Password (test)"
			required="true"
			/>
	<sj:submit
			button="true"
			validate="true"
			value="Submit"
			indicator="indicator"
			parentTheme="xhtml"
			/>
</s:form>

<br/>

<sj:tabbedpanel id="localtabs" cssClass="list">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="java" label="Action Code with Validation"/>
	<sj:tab id="tab2" target="javascript" label="Required JavaScript"/>
	<div id="jsp">
	  <pre>
    &lt;s:form id=&quot;formValidate&quot; action=&quot;login&quot; theme=&quot;xhtml&quot; target=&quot;_blank&quot;&gt;
     	&lt;s:textfield 
     		id=&quot;loginuser&quot; 
     		name=&quot;loginuser&quot; 
     		label=&quot;User&quot; 
     		required=&quot;true&quot;
     	/&gt;
     	&lt;s:textfield 
     		id=&quot;loginpassword&quot; 
     		name=&quot;loginpassword&quot; 
     		label=&quot;Password (test)&quot; 
     		required=&quot;true&quot;
     	/&gt;
    	&lt;sj:submit 
    		button=&quot;true&quot; 
    		validate=&quot;true&quot; 
    		value=&quot;Submit&quot; 
    		indicator=&quot;indicator&quot;
    		/&gt;
    	&lt;sj:submit 
    		targets=&quot;result&quot; 
    		button=&quot;true&quot; 
    		validate=&quot;true&quot; 
    		value=&quot;AJAX Submit&quot; 
    		indicator=&quot;indicator&quot;
    		/&gt;
    	&lt;sj:a
    		formIds=&quot;formValidate&quot; 
    		targets=&quot;result&quot; 
    		button=&quot;true&quot; 
    		buttonIcon=&quot;ui-icon-gear&quot;
    		validate=&quot;true&quot; 
    		indicator=&quot;indicator&quot;
    		&gt;AJAX Submit as Link&lt;/sj:a&gt;
    &lt;/s:form&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	  </pre>
	</div>
	<div id="java">
	  <pre>
@ParentPackage(value = &quot;showcase&quot;)
@InterceptorRef(&quot;jsonValidationWorkflowStack&quot;)
@Validations(requiredStrings = {
    @RequiredStringValidator(fieldName = &quot;loginuser&quot;, type = ValidatorType.FIELD, message = &quot;Login User is required&quot;),
	@RequiredStringValidator(fieldName = &quot;loginpassword&quot;, type = ValidatorType.FIELD, message = &quot;Password is required&quot;)
})
public class Login extends ActionSupport {

  private static final long serialVersionUID = 7968544374444173511L;
  private static final Log  log              = LogFactory.getLog(Login.class);

  private String            loginuser;
  private String            loginpassword;
  private String            echo;

  @Action(value = &quot;/login&quot;, results = {
    @Result(location = &quot;simpleecho.jsp&quot;, name = &quot;success&quot;)
  })
  public String execute() throws Exception
  {
    echo = &quot;Welcome &quot; + loginuser;
    log.info(echo);

    return SUCCESS;
  }

  public String getEcho()
  {
    return echo;
  }

  public String getLoginuser()
  {
    return loginuser;
  }

  public void setLoginuser(String loginuser)
  {
    this.loginuser = loginuser;
  }

  public String getLoginpassword()
  {
    return loginpassword;
  }

  public void setLoginpassword(String loginpassword)
  {
    this.loginpassword = loginpassword;
  }
}
	  </pre>
	</div>
	<div id="javascript">
	  <pre>
	&lt;script 
		language=&quot;JavaScript&quot; 
		src=&quot;${pageContext.request.contextPath}/struts/utils.js&quot; 
		type=&quot;text/javascript&quot;&gt;
	&lt;/script&gt;
	&lt;script 
		language=&quot;JavaScript&quot; 
		src=&quot;${pageContext.request.contextPath}/struts/xhtml/validation.js&quot; 
		type=&quot;text/javascript&quot;&gt;
	&lt;/script&gt;
	  </pre>
	</div>
</sj:tabbedpanel>
