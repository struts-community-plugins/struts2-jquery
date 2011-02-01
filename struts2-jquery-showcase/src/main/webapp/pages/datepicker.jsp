<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urldatepicker" action="datepicker"/><sj:a href="%{urldatepicker}" targets="main">Datepicker</sj:a></li>
      <li><s:url id="urldatepickerbuttons" action="datepicker-buttons"/><sj:a href="%{urldatepickerbuttons}" targets="main">Datepicker with more options</sj:a></li>
      <li><s:url id="urldatepickerinline" action="datepicker-inline"/><sj:a href="%{urldatepickerinline}" targets="main">Datepicker (Inline)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Datepicker</h2>
    <p class="text">
        A simple Datepicker
    </p>
    <s:form id="form" theme="xhtml">
      <sj:datepicker id="date0" label="Select a Date" />
      <sj:datepicker value="%{dateValue}" id="date1" name="date1" label="Date Value from Action" />
      <sj:datepicker id="date2" name="nameValue" label="Date Value by Name" />
      <sj:datepicker value="today" id="date3" name="date3" displayFormat="dd.mm.yy" label="Today" />
      <sj:datepicker value="yesterday" id="date4" name="date4" displayFormat="mm/dd/yy" label="Yesterday" />
      <sj:datepicker value="tomorrow" id="date5" name="date5" displayFormat="DD, d MM yy" label="Tomorrow" />
      <sj:datepicker value="2004-08-14" id="date6" name="date6" displayFormat="d M, yy" label="String Value" />
      <sj:datepicker value="today" id="date7" name="date7" displayFormat="d M, yy" minDate="minValue" maxDate="maxValue" label="With min and max Date" />
    </s:form>
  </div>

  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;s:form id=&quot;form&quot; theme=&quot;xhtml&quot;&gt;
      &lt;sj:datepicker id=&quot;date0&quot; label=&quot;Select a Date&quot; /&gt;
      &lt;sj:datepicker value=&quot;%{dateValue}&quot; id=&quot;date1&quot; name=&quot;date1&quot; label=&quot;Date Value from Action&quot; /&gt;
      &lt;sj:datepicker id=&quot;date2&quot; name=&quot;nameValue&quot; label=&quot;Date Value by Name&quot; /&gt;
      &lt;sj:datepicker value=&quot;today&quot; id=&quot;date3&quot; name=&quot;date3&quot; displayFormat=&quot;dd.mm.yy&quot; label=&quot;Today&quot; /&gt;
      &lt;sj:datepicker value=&quot;yesterday&quot; id=&quot;date4&quot; name=&quot;date4&quot; displayFormat=&quot;mm/dd/yy&quot; label=&quot;Yesterday&quot; /&gt;
      &lt;sj:datepicker value=&quot;tomorrow&quot; id=&quot;date5&quot; name=&quot;date5&quot; displayFormat=&quot;DD, d MM yy&quot; label=&quot;Tomorrow&quot; /&gt;
      &lt;sj:datepicker value=&quot;2004-08-14&quot; id=&quot;date6&quot; name=&quot;date6&quot; displayFormat=&quot;d M, yy&quot; label=&quot;String Value&quot; /&gt;
    &lt;/s:form&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
