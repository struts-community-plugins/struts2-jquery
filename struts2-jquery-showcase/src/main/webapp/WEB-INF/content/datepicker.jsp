<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Datepicker</h2>

<p class="text">
	A simple Datepicker
</p>
<s:form id="form" theme="xhtml">
	<sj:datepicker id="date0" name="date0" maxDate="-1d" label="Select a Date"/>
	<sj:datepicker id="date1" name="date1" value="%{dateValue}" label="Date Value from Action"/>
	<sj:datepicker id="date2" name="nameValue" label="Date Value by Name"/>
	<sj:datepicker id="date3" name="date3" value="today" displayFormat="dd.mm.yy" label="Today"/>
	<sj:datepicker id="date4" name="date4" value="yesterday" displayFormat="mm/dd/yy" label="Yesterday"/>
	<sj:datepicker id="date5" name="date5" value="tomorrow" displayFormat="DD, d MM yy" label="Tomorrow"/>
	<sj:datepicker id="date6" name="date6" value="2004-08-14" displayFormat="d M, yy" label="String Value"/>
	<sj:datepicker id="date7" name="date7" value="today" displayFormat="d M, yy" minDate="minValue" maxDate="maxValue"
	               label="With min and max Date"/>
</s:form>


<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
    <pre>
    &lt;s:form id=&quot;form&quot; theme=&quot;xhtml&quot;&gt;
      &lt;sj:datepicker id=&quot;date0&quot; name=&quot;date0&quot; maxDate=&quot;-1d&quot; label=&quot;Select a Date&quot; /&gt;
      &lt;sj:datepicker value=&quot;%{dateValue}&quot; id=&quot;date1&quot; name=&quot;date1&quot; label=&quot;Date Value from Action&quot; /&gt;
      &lt;sj:datepicker id=&quot;date2&quot; name=&quot;nameValue&quot; label=&quot;Date Value by Name&quot; /&gt;
      &lt;sj:datepicker value=&quot;today&quot; id=&quot;date3&quot; name=&quot;date3&quot; displayFormat=&quot;dd.mm.yy&quot; label=&quot;Today&quot; /&gt;
      &lt;sj:datepicker value=&quot;yesterday&quot; id=&quot;date4&quot; name=&quot;date4&quot; displayFormat=&quot;mm/dd/yy&quot; label=&quot;Yesterday&quot; /&gt;
      &lt;sj:datepicker value=&quot;tomorrow&quot; id=&quot;date5&quot; name=&quot;date5&quot; displayFormat=&quot;DD, d MM yy&quot; label=&quot;Tomorrow&quot; /&gt;
      &lt;sj:datepicker value=&quot;2004-08-14&quot; id=&quot;date6&quot; name=&quot;date6&quot; displayFormat=&quot;d M, yy&quot; label=&quot;String Value&quot; /&gt;
    &lt;/s:form&gt;
    </pre>
</div>
