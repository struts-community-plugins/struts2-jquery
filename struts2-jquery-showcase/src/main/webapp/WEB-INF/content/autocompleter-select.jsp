<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Autocompleter - Select Box</h2>

<p class="text">
	The first autocompleter handle a List from Action as Select Box. The second can handle a Select Box with JSON Result
	as autocompleter.
</p>

<strong>Result Div :</strong>
<div id="formResult" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
<strong>Topics Div :</strong>
<div id="topics" class="result ui-widget-content ui-corner-all"></div>

<s:form id="form" action="echo" theme="simple" cssClass="yform">
	<fieldset>
		<legend>Select Box as Autocompleter</legend>
		<div class="type-select">
			<label for="echo">Echo: </label>
			<sj:autocompleter
					id="customers"
					name="echo"
					list="%{customers}"
					listValue="name"
					listKey="id"
					selectBox="true"
					selectBoxIcon="true"
					onChangeTopics="autocompleteChange"
					onFocusTopics="autocompleteFocus"
					onSelectTopics="autocompleteSelect"
					/>
		</div>
		<div>
			<sj:submit
					targets="formResult"
					value="AJAX Submit"
					indicator="indicator"
					button="true"
					/>
			<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
		</div>
	</fieldset>
</s:form>

<br/>

<s:form id="form2" action="echo" theme="simple" cssClass="yform">
	<fieldset>
		<legend>Select Box with JSON Result as Autocompleter</legend>
		<div class="type-select">
			<label for="echo">Echo: </label>
			<s:url var="jsoncustomers" action="jsoncustomers"/>
			<sj:select
					id="customersjson"
					name="echo"
					href="%{jsoncustomers}"
					list="customers"
					listValue="name"
					listKey="id"
					autocomplete="true"
					loadMinimumCount="2"
					onChangeTopics="autocompleteChange"
					onFocusTopics="autocompleteFocus"
					onSelectTopics="autocompleteSelect"
					/>
		</div>
		<div>
			<sj:submit
					targets="formResult"
					value="AJAX Submit"
					indicator="indicator2"
					button="true"
					/>
			<img id="indicator2" src="images/indicator.gif" alt="Loading..." style="display:none"/>
		</div>
	</fieldset>
</s:form>

<h4>Source Code</h4>


<sj:tabbedpanel id="showautocompletecode">
    <sj:tab id="tab1" target="jsp1" label="JSP Code Select Box"/>
    <sj:tab id="tab2" target="jsp2" label="JSP Code Select Box with JSON Result"/>
    <sj:tab id="tab3" target="javascript" label="JavaScript Code"/>
    <div id="jsp1">
	  <pre>
            <code class="html">
&lt;strong&gt;Result Div :&lt;/strong&gt;
&lt;div id=&quot;formResult&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
&lt;strong&gt;Topics Div :&lt;/strong&gt;
&lt;div id=&quot;topics&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;&lt;/div&gt;

&lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
	&lt;fieldset&gt;
		&lt;legend&gt;Select Box as Autocompleter&lt;/legend&gt;
		&lt;div class=&quot;type-select&quot;&gt;
			&lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
			&lt;sj:autocompleter
					id=&quot;customers&quot;
					name=&quot;echo&quot;
					list=&quot;%{customers}&quot;
					listValue=&quot;name&quot;
					listKey=&quot;id&quot;
					selectBox=&quot;true&quot;
					selectBoxIcon=&quot;true&quot;
					onChangeTopics=&quot;autocompleteChange&quot;
					onFocusTopics=&quot;autocompleteFocus&quot;
					onSelectTopics=&quot;autocompleteSelect&quot;
					/&gt;
		&lt;/div&gt;
		&lt;div&gt;
			&lt;sj:submit
					targets=&quot;formResult&quot;
					value=&quot;AJAX Submit&quot;
					indicator=&quot;indicator&quot;
					button=&quot;true&quot;
					/&gt;
			&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
		&lt;/div&gt;
	&lt;/fieldset&gt;
&lt;/s:form&gt;
			</code>
      </pre>
    </div>
    <div id="jsp2">
	  <pre>
            <code class="html">
&lt;s:form id=&quot;form2&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
	&lt;fieldset&gt;
		&lt;legend&gt;Select Box with JSON Result as Autocompleter&lt;/legend&gt;
		&lt;div class=&quot;type-select&quot;&gt;
			&lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
			&lt;s:url var=&quot;jsoncustomers&quot; action=&quot;jsoncustomers&quot;/&gt;
			&lt;sj:select
					id=&quot;customersjson&quot;
					name=&quot;echo&quot;
					href=&quot;%{jsoncustomers}&quot;
					list=&quot;customers&quot;
					listValue=&quot;name&quot;
					listKey=&quot;id&quot;
					autocomplete=&quot;true&quot;
					loadMinimumCount=&quot;2&quot;
					onChangeTopics=&quot;autocompleteChange&quot;
					onFocusTopics=&quot;autocompleteFocus&quot;
					onSelectTopics=&quot;autocompleteSelect&quot;
					/&gt;
		&lt;/div&gt;
		&lt;div&gt;
			&lt;sj:submit
					targets=&quot;formResult&quot;
					value=&quot;AJAX Submit&quot;
					indicator=&quot;indicator2&quot;
					button=&quot;true&quot;
					/&gt;
			&lt;img id=&quot;indicator2&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
		&lt;/div&gt;
	&lt;/fieldset&gt;
&lt;/s:form&gt;
			</code>
      </pre>
    </div>
    <div id="javascript">
	  <pre>
            <code class="javascript">
    &lt;script type=&quot;text/javascript&quot;&gt;
    $(document).ready(function() {
      $.subscribe('autocompleteChange', function(event, data) {
        var ui = event.originalEvent.ui;
        if(ui.item) {
            var message = ui.item.value;
            if(ui.item.key) {
                message = '( '+ ui.item.key +' ) '+message;
            }
            $('#topics').html('&lt;b&gt;'+message+'&lt;/b&gt;');
        }
        });

      $.subscribe('autocompleteFocus', function(event, data) {
        var ui = event.originalEvent.ui;
        var message = ui.item.value;
        if(ui.item.key) {
            message = '( '+ ui.item.key +' ) '+message;
        }
            $('#topics').html('&lt;u&gt;'+message+'&lt;/u&gt;');
        });

      $.subscribe('autocompleteSelect', function(event, data) {
        var ui = event.originalEvent.ui;
        var message = ui.item.value;
        if(ui.item.key) {
            message = '( '+ ui.item.key +' ) '+message;
        }
            $('#topics').html('&lt;i&gt;'+message+'&lt;/i&gt;');
        });
    });
    &lt;/script&gt;
			</code>
	  </pre>
    </div>
</sj:tabbedpanel>
