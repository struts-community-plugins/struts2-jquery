<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Form submission with Custome AJAX Validation</h2>

<p class="text">
	A Form submission with Custome AJAX Validation.
</p>
<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<ul id="formerrors" class="errorMessage"></ul>
<s:form id="formValidateCustom" action="login" theme="simple" cssClass="ym-form">
	<fieldset>
		<legend>AJAX Form with Validation</legend>
		<div class="ym-fbox-text">
			<label for="echo">User: <span id="loginuserError"></span></label>
			<s:textfield
					id="loginuser"
					name="loginuser"
					/>
		</div>
		<div class="ym-fbox-text">
			<label for="echo">Password: <span id="loginpasswordError"></span></label>
			<s:password
					id="loginpassword"
					name="loginpassword"
					/>
		</div>
		<div class="ym-fbox-button">
			<sj:submit
					targets="result"
					button="true"
					validate="true"
					validateFunction="customeValidation"
					onBeforeTopics="removeErrors"
					onSuccessTopics="removeErrors"
					value="Submit"
					indicator="indicator"
					/>
		</div>
	</fieldset>
</s:form>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<br/>

<sj:tabbedpanel id="localtabs" cssClass="list">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="java" label="Action Code with Validation"/>
	<sj:tab id="tab2" target="javascript" label="Required JavaScript"/>
	<div id="jsp">
	  <pre>
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
    
    &lt;ul id=&quot;formerrors&quot; class=&quot;errorMessage&quot;&gt;&lt;/ul&gt;
    &lt;s:form id=&quot;formValidateCustom&quot; action=&quot;login&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form with Validation&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;User: &lt;span id=&quot;loginuserError&quot;&gt;&lt;/span&gt;&lt;/label&gt;
			   	&lt;s:textfield 
		     		id=&quot;loginuser&quot; 
		     		name=&quot;loginuser&quot; 
		     	/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Password: &lt;span id=&quot;loginpasswordError&quot;&gt;&lt;/span&gt;&lt;/label&gt;
		     	&lt;s:textfield 
		     		id=&quot;loginpassword&quot; 
		     		name=&quot;loginpassword&quot; 
		     	/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
		    	&lt;sj:submit 
		    		targets=&quot;result&quot; 
		    		button=&quot;true&quot; 
		    		validate=&quot;true&quot; 
		    		validateFunction=&quot;customeValidation&quot;
		    		onBeforeTopics=&quot;removeErrors&quot;
		    		onSuccessTopics=&quot;removeErrors&quot;
		    		value=&quot;Submit&quot; 
		    		indicator=&quot;indicator&quot;
		    	/&gt;
	        &lt;/div&gt;
        &lt;/fieldset&gt;
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
}, expressions = {
  @ExpressionValidator(expression = &quot;loginpassword.trim().equals('test') == true&quot;, message = &quot;Password must be test.&quot;),

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

$(document).ready( function() {
	$.subscribe('removeErrors', function(event,data) {
		$('.errorLabel').html('').removeClass('errorLabel');
		$('#formerrors').html('');
	});
});	

function customeValidation(form, errors) {
	
	//List for errors
	var list = $('#formerrors');
	
	//Handle non field errors 
	if (errors.errors) {
		$.each(errors.errors, function(index, value) { 
			list.append('<li>'+value+'</li>\n');
		});
	}
	
	//Handle field errors 
	if (errors.fieldErrors) {
		$.each(errors.fieldErrors, function(index, value) { 
			var elem = $('#'+index+'Error');
			if(elem)
			{
				elem.html(value[0]);
				elem.addClass('errorLabel');
			}
		});
	}
}
	  </pre>
	</div>
</sj:tabbedpanel>
