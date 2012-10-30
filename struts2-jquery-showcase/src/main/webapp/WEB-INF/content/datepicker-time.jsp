<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Datepicker - Timepicker</h2>

<p class="text">
	A Datepicker with Timepicker Addon
</p>
<s:form id="form" theme="xhtml">
	<sj:datepicker id="time0" label="Select a Date/Time" value="%{new java.util.Date()}" timepicker="true"/>
	<sj:datepicker id="time1" label="Select a Time" value="%{new java.util.Date()}" timepicker="true"
	               timepickerOnly="true"/>
	<sj:datepicker id="time2" label="With AM/PM" timepicker="true" timepickerAmPm="true"/>
	<sj:datepicker id="time3" label="Show Seconds" timepicker="true" timepickerShowSecond="true"
	               timepickerFormat="hh:mm:ss"/>
	<sj:datepicker id="time4" label="With Steps" timepicker="true" timepickerShowSecond="true" timepickerFormat="h:m:s"
	               timepickerStepHour="2" timepickerStepMinute="10" timepickerStepSecond="15"/>
	<sj:datepicker id="time5" label="With Seperator" timepicker="true" timepickerSeparator=" at "/>
	<sj:datepicker id="time6" label="With Grid" timepicker="true" timepickerOnly="true" timepickerGridHour="4"
	               timepickerGridMinute="10" timepickerStepMinute="10"/>
</s:form>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
    <pre>
    &lt;s:form id=&quot;form&quot; theme=&quot;xhtml&quot;&gt;
      &lt;sj:datepicker id=&quot;time0&quot; label=&quot;Select a Date/Time&quot; value=&quot;%{new java.util.Date()}&quot; timepicker=&quot;true&quot; /&gt;
      &lt;sj:datepicker id=&quot;time1&quot; label=&quot;Select a Time&quot; value=&quot;%{new java.util.Date()}&quot; timepicker=&quot;true&quot; timepickerOnly=&quot;true&quot;/&gt;
      &lt;sj:datepicker id=&quot;time2&quot; label=&quot;With AM/PM&quot; timepicker=&quot;true&quot; timepickerAmPm=&quot;true&quot;/&gt;
      &lt;sj:datepicker id=&quot;time3&quot; label=&quot;Show Seconds&quot; timepicker=&quot;true&quot; timepickerShowSecond=&quot;true&quot; timepickerFormat=&quot;hh:mm:ss&quot;/&gt;
      &lt;sj:datepicker id=&quot;time4&quot; label=&quot;With Steps&quot; timepicker=&quot;true&quot; timepickerShowSecond=&quot;true&quot; timepickerFormat=&quot;h:m:s&quot; timepickerStepHour=&quot;2&quot; timepickerStepMinute=&quot;10&quot; timepickerStepSecond=&quot;15&quot;/&gt;
      &lt;sj:datepicker id=&quot;time5&quot; label=&quot;With Seperator&quot; timepicker=&quot;true&quot; timepickerSeparator=&quot; at &quot;/&gt;
      &lt;sj:datepicker id=&quot;time6&quot; label=&quot;With Grid&quot; timepicker=&quot;true&quot; timepickerOnly=&quot;true&quot; timepickerGridHour=&quot;4&quot; timepickerGridMinute=&quot;10&quot; timepickerStepMinute=&quot;10&quot;/&gt;
    &lt;/s:form&gt;
    </pre>
</div>
