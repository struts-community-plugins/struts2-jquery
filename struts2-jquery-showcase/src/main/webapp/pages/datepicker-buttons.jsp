<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urldatepicker" action="datepicker"/><sj:a href="%{urldatepicker}" targets="main">Datepicker</sj:a></li>
      <li><s:url id="urldatepickerbuttons" action="datepicker-buttons"/><sj:a href="%{urldatepickerbuttons}" targets="main">Datepicker with more options</sj:a></li>
      <li><s:url id="urldatepickerinline" action="datepicker-inline"/><sj:a href="%{urldatepickerinline}" targets="main">Datepicker (Inline)</sj:a></li>
      <li><s:url id="urldatepickertime" action="datepicker-time"/><sj:a href="%{urldatepickertime}" targets="main">Timepicker</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Datepicker with more options</h2>
    <p class="text">
        A Datepicker with different options and animations.
    </p>
    <s:form id="form" theme="xhtml">
      <sj:datepicker id="date0" name="date0" label="With Button Panel" showButtonPanel="true"/>
      <sj:datepicker id="date1" name="date1" label="Change Month and Year" changeMonth="true" changeYear="true" onChangeMonthYearTopics="onDpChangeMonthAndYear"/>
      <sj:datepicker id="date2" name="date2" label="Custom Button Text" showOn="both" buttonText="Select a Date"/>
      <sj:datepicker id="date3" name="date3" label="Show only on Button Click" showOn="button"/>
      <sj:datepicker id="date4" name="date4" label="Text after selection" appendText=" (dd.MM.yy)" displayFormat="dd.MM.yy"/>
      <sj:datepicker id="date5" name="date5" label="With fast slideDown Animation" showAnim="slideDown" duration="fast"/>
      <sj:datepicker id="date6" name="date6" label="With slow fadeIn Animation" showAnim="fadeIn" showOptions="{direction: 'up' }" duration="slow" />
      <sj:datepicker id="date7" name="date7" label="Show 3 Months" numberOfMonths="3"/>
      <sj:datepicker id="date8" name="date8" label="Show Month Array" numberOfMonths="[2,3]"/>
      <sj:datepicker id="date9" name="date9" label="Show Years only from 2008 until 2012" yearRange="2008:2012" changeYear="true"/>
      <sj:datepicker id="date10" name="date10" label="Button Only" buttonImageOnly="true"/>
      <sj:datepicker id="date11" name="date11" label="Without Button" showOn="focus"/>
      <sj:datepicker id="date12" name="date12" label="With Close Event" onCompleteTopics="onDpClose"/>
      <sj:datepicker id="date13" name="date13" label="With Min and Max Date" minDate="-2" maxDate="+2m"/>
    </s:form>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
      <strong>JavaScript:</strong>
      <pre>
    &lt;script type="text/javascript"&gt;
    $.subscribe('onDpChangeMonthAndYear', function(event,data) {
        alert('Change month to : '+event.originalEvent.month+' and year to '+event.originalEvent.year);
    });
    $.subscribe('onDpClose', function(event,data) {
        alert('Selected Date : '+event.originalEvent.dateText);
    });
    &lt;/script&gt;  
      </pre>
    <strong>Code:</strong>
    <pre>
    &lt;s:form id=&quot;form&quot; theme=&quot;xhtml&quot;&gt;
      &lt;sj:datepicker id=&quot;date0&quot; name=&quot;date0&quot; label=&quot;With Button Panel&quot; showButtonPanel=&quot;true&quot;/&gt;
      &lt;sj:datepicker id=&quot;date1&quot; name=&quot;date1&quot; label=&quot;Change Month and Year&quot; changeMonth=&quot;true&quot; changeYear=&quot;true&quot; onChangeMonthYearTopics=&quot;onDpChangeMonthAndYear&quot;/&gt;
      &lt;sj:datepicker id=&quot;date2&quot; name=&quot;date2&quot; label=&quot;Custom Button Text&quot; showOn=&quot;both&quot; buttonText=&quot;Select a Date&quot;/&gt;
      &lt;sj:datepicker id=&quot;date3&quot; name=&quot;date3&quot; label=&quot;Show only on Button Click&quot; showOn=&quot;button&quot;/&gt;
      &lt;sj:datepicker id=&quot;date4&quot; name=&quot;date4&quot; label=&quot;Text after selection&quot; appendText=&quot; (dd.MM.yy)&quot; displayFormat=&quot;dd.MM.yy&quot;/&gt;
      &lt;sj:datepicker id=&quot;date5&quot; name=&quot;date5&quot; label=&quot;With fast slideDown Animation&quot; showAnim=&quot;slideDown&quot; duration=&quot;fast&quot;/&gt;
      &lt;sj:datepicker id=&quot;date6&quot; name=&quot;date6&quot; label=&quot;With slow fadeIn Animation&quot; showAnim=&quot;fadeIn&quot; showOptions=&quot;{direction: 'up' }&quot; duration=&quot;slow&quot; /&gt;
      &lt;sj:datepicker id=&quot;date7&quot; name=&quot;date7&quot; label=&quot;Show 3 Months&quot; numberOfMonths=&quot;3&quot;/&gt;
      &lt;sj:datepicker id=&quot;date8&quot; name=&quot;date8&quot; label=&quot;Show Month Array&quot; numberOfMonths=&quot;[2,3]&quot;/&gt;
      &lt;sj:datepicker id=&quot;date9&quot; name=&quot;date9&quot; label=&quot;Show Years only from 2008 until 2012&quot; yearRange=&quot;2008:2012&quot; changeYear=&quot;true&quot;/&gt;
      &lt;sj:datepicker id=&quot;date10&quot; name=&quot;date10&quot; label=&quot;Button Only&quot; buttonImageOnly=&quot;true&quot;/&gt;
      &lt;sj:datepicker id=&quot;date11&quot; name=&quot;date11&quot; label=&quot;Without Button&quot; showOn=&quot;focus&quot;/&gt;
      &lt;sj:datepicker id=&quot;date12&quot; name=&quot;date12&quot; label=&quot;With Close Event&quot; onCompleteTopics=&quot;onDpClose&quot;/&gt;
      &lt;sj:datepicker id=&quot;date13&quot; name=&quot;date13&quot; label=&quot;With Min and Max Date&quot; minDate=&quot;-2&quot; maxDate=&quot;+2m&quot;/&gt;
    &lt;/s:form&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
