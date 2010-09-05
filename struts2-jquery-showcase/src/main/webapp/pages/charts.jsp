<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlslider" action="slider"/><sj:a id="slidersimplelink" href="%{urlslider}" targets="main">Slider</sj:a></li>
      <li><s:url id="urlsliderform" action="slider-form"/><sj:a id="sliderformlink"  href="%{urlsliderform}" targets="main">Slider in a Form</sj:a></li>
      <li><s:url id="urlsliderrange" action="slider-range"/><sj:a id="sliderrangelink"  href="%{urlsliderrange}" targets="main">Slider with Range and Events</sj:a></li>
      <li><s:url id="urlprogressbar" action="progressbar"/><sj:a id="progressbarsimplelink" href="%{urlprogressbar}" targets="main">Progressbar</sj:a></li>
      <li><s:url id="urlprogressbarchange" action="progressbar-change"/><sj:a id="progressbarchangelink" href="%{urlprogressbarchange}" targets="main">Progressbar with change event</sj:a></li>
      <li><s:url id="urlprogressbarresizeable" action="progressbar-resizeable"/><sj:a id="progressbarresizeablelink" href="%{urlprogressbarresizeable}" targets="main">Resizeable progressbar</sj:a></li>
      <li><s:url id="urlspinner" action="spinner"/><sj:a id="spinnerlink" href="%{urlspinner}" targets="main">Spinner</sj:a></li>
      <li><s:url id="urlrichtexttinymce" action="richtext-tinymce"/><sj:a id="richtexttinymcelink" href="%{urlrichtexttinymce}" targets="main">Richtext - Tinymce</sj:a></li>
      <li><s:url id="urlrichtexttinymceadvanced" action="richtext-tinymce-advanced"/><sj:a id="richtexttinymcelinkadvanced" href="%{urlrichtexttinymceadvanced}" targets="main">Richtext - Tinymce (Advanced)</sj:a></li>
      <li><s:url id="urlrichtext" action="richtext"/><sj:a id="richtextlink" href="%{urlrichtext}" targets="main">Richtext - Ckeditor</sj:a></li>
      <li><s:url id="urlrichtextcustome" action="richtext-custome"/><sj:a id="richtextcustomelink" href="%{urlrichtextcustome}" targets="main">Richtext - Ckeditor (Custome Toolbar)</sj:a></li>
      <li><s:url id="urlmessages" action="messages"/><sj:a id="messageslink" href="%{urlmessages}" targets="main">Action Errors/Messages</sj:a></li>
      <li><s:url id="urlcharts" action="charts"/><sj:a id="chartslink" href="%{urlcharts}" targets="main">Charts</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Charts</h2>


	<h3>Chart with values from a List or a Map</h3>
    <sjc:chart id="chartPoints" cssStyle="width: 600px; height: 400px;">
    	<sjc:chartData
    		label="List -Points-"
    		list="points"
    		points="{ show: true }"
    		lines="{ show: true }"
    	/>
    	<sjc:chartData
    		label="List -Points with Null Value-"
    		list="pointsWithNull"
    	/>
    	<sjc:chartData
    		label="Map -Integer, Integer-"
    		list="pointsFromMap"
    	/>
    </sjc:chart>

    <br/>

	<h3>Chart with values from a List with Objects</h3>
	<div id="topicsHover"></div>
	<div id="topicsClick"></div>
    <sjc:chart
    	id="chartObjects"
    	cssStyle="width: 600px; height: 400px;"
    	onClickTopics="chartClick"
    	onHoverTopics="chartHover"
    	crosshair="true"
    	crosshairMode="xy"
    >
    	<sjc:chartData
    		label="List with Objects"
    		list="objList"
    		listKey="myKey"
    		listValue="myValue"
    		points="{ show: true }"
    		lines="{ show: true }"
    		clickable="true"
    		hoverable="true"
    	/>
    </sjc:chart>

    <br/>

	<h3>Chart with Date Values</h3>
    <sjc:chart
    	id="chartDate"
    	xaxisMode="time"
    	xaxisTimeformat="%0m.%y"
    	xaxisMin="%{minTime}"
    	xaxisMax="%{maxTime}"
    	xaxisColor="#666"
    	xaxisTickSize="[2, 'month']"
    	xaxisTickColor="#aaa"
    	xaxisPosition="top"
    	yaxisPosition="right"
    	yaxisTickSize="10"
    	cssStyle="width: 600px; height: 400px;"
    >
    	<sjc:chartData
    		label="Map -Date, Integer-"
    		list="dateFromMap"
    		color="#990066"
    		bars="{ show: true }"
    	/>
    </sjc:chart>

    <br/>

	<h3>Chart with AJAX Data</h3>
	<s:url id="chartDataUrl" action="json-chart-data"/>
    <sjc:chart
    	id="chartAjax"
    	legendLabelBoxBorderColor="#990033"
    	legendPosition="ne"
    	legendShow="#ccc"
    	cssStyle="width: 600px; height: 400px;"
    >
    	<sjc:chartData
    		label="Map -Double, Double-"
    		href="%{chartDataUrl}"
    		list="doubleMap"
    		deferredLoading="true"
    		reloadTopics="reloadMap"
    	/>
    	<sjc:chartData
    		label="List -ListValue-"
    		href="%{chartDataUrl}"
    		list="objList"
    		listKey="myKey"
    		listValue="myValue"
    		reloadTopics="reloadList"
    	/>
    </sjc:chart>
    <sj:a onClickTopics="reloadMap" button="true" buttonIcon="ui-icon-refresh">Load/Reload Map</sj:a>
    <sj:a onClickTopics="reloadList" button="true" buttonIcon="ui-icon-refresh">Reload List</sj:a>
  </div>

    <br/>
    <br/>
    <sj:tabbedpanel id="localtabs" cssClass="list">
      <sj:tab id="tab1" target="jsp" label="JSP Code"/>
      <sj:tab id="tab2" target="javascript" label="JavaScript"/>
      <sj:tab id="tab3" target="action" label="Action"/>
      <sj:tab id="tab4" target="jsonaction" label="JSON Action"/>
      <div id="jsp">
	  <pre>
	&lt;h3&gt;Chart with values from a List or a Map&lt;/h3&gt;
    &lt;sjc:chart id=&quot;chartPoints&quot; cssStyle=&quot;width: 600px; height: 400px;&quot;&gt;
    	&lt;sjc:chartData
    		label=&quot;List -Points-&quot;
    		list=&quot;points&quot;
    		points=&quot;{ show: true }&quot;
    		lines=&quot;{ show: true }&quot;
    	/&gt;
    	&lt;sjc:chartData
    		label=&quot;List -Points with Null Value-&quot;
    		list=&quot;pointsWithNull&quot;
    	/&gt;
    	&lt;sjc:chartData
    		label=&quot;Map -Integer, Integer-&quot;
    		list=&quot;pointsFromMap&quot;
    	/&gt;
    &lt;/sjc:chart&gt;

    &lt;br/&gt;

	&lt;h3&gt;Chart with values from a List with Objects&lt;/h3&gt;
	&lt;div id=&quot;topicsHover&quot;&gt;&lt;/div&gt;
	&lt;div id=&quot;topicsClick&quot;&gt;&lt;/div&gt;
    &lt;sjc:chart id=&quot;chartObjects&quot; cssStyle=&quot;width: 600px; height: 400px;&quot; onClickTopics=&quot;chartClick&quot; onHoverTopics=&quot;chartHover&quot;&gt;
    	&lt;sjc:chartData
    		label=&quot;List with Objects&quot;
    		list=&quot;objList&quot;
    		listKey=&quot;myKey&quot;
    		listValue=&quot;myValue&quot;
    		points=&quot;{ show: true }&quot;
    		lines=&quot;{ show: true }&quot;
    		clickable=&quot;true&quot;
    		hoverable=&quot;true&quot;
    	/&gt;
    &lt;/sjc:chart&gt;

    &lt;br/&gt;

	&lt;h3&gt;Chart with Date Values&lt;/h3&gt;
    &lt;sjc:chart
    	id=&quot;chartDate&quot;
    	xaxisMode=&quot;time&quot;
    	xaxisTimeformat=&quot;%0m.%y&quot;
    	xaxisMin=&quot;%{minTime}&quot;
    	xaxisMax=&quot;%{maxTime}&quot;
    	xaxisColor=&quot;#666&quot;
    	xaxisTickSize=&quot;[2, 'month']&quot;
    	xaxisTickColor=&quot;#aaa&quot;
    	xaxisPosition=&quot;top&quot;
    	yaxisPosition=&quot;right&quot;
    	yaxisTickSize=&quot;10&quot;
    	cssStyle=&quot;width: 600px; height: 400px;&quot;
    &gt;
    	&lt;sjc:chartData
    		label=&quot;Map -Date, Integer-&quot;
    		list=&quot;dateFromMap&quot;
    		color=&quot;#990066&quot;
    		bars=&quot;{ show: true }&quot;
    	/&gt;
    &lt;/sjc:chart&gt;

    &lt;br/&gt;

	&lt;h3&gt;Chart with AJAX Data&lt;/h3&gt;
	&lt;s:url id=&quot;chartDataUrl&quot; action=&quot;json-chart-data&quot;/&gt;
    &lt;sjc:chart
    	id=&quot;chartAjax&quot;
    	legendLabelBoxBorderColor=&quot;#990033&quot;
    	legendPosition=&quot;ne&quot;
    	legendShow=&quot;#ccc&quot;
    	cssStyle=&quot;width: 600px; height: 400px;&quot;
    &gt;
    	&lt;sjc:chartData
    		label=&quot;Map -Double, Double-&quot;
    		href=&quot;%{chartDataUrl}&quot;
    		list=&quot;doubleMap&quot;
    		deferredLoading=&quot;true&quot;
    		reloadTopics=&quot;reloadMap&quot;
    	/&gt;
    	&lt;sjc:chartData
    		label=&quot;List -ListValue-&quot;
    		href=&quot;%{chartDataUrl}&quot;
    		list=&quot;objList&quot;
    		listKey=&quot;myKey&quot;
    		listValue=&quot;myValue&quot;
    		reloadTopics=&quot;reloadList&quot;
    	/&gt;
    &lt;/sjc:chart&gt;
    &lt;sj:a onClickTopics=&quot;reloadMap&quot; button=&quot;true&quot; buttonIcon=&quot;ui-icon-refresh&quot;&gt;Load/Reload Map&lt;/sj:a&gt;
    &lt;sj:a onClickTopics=&quot;reloadList&quot; button=&quot;true&quot; buttonIcon=&quot;ui-icon-refresh&quot;&gt;Reload List&lt;/sj:a&gt;
	  </pre>
	  </div>
      <div id="javascript">
	  <pre>
	$.subscribe('chartHover', function(event, data) {
    $(&quot;#topicsHover&quot;).text(event.originalEvent.pos.x.toFixed(2)+','+event.originalEvent.pos.y.toFixed(2));
	});
	$.subscribe('chartClick', function(event, data) {
		var item = event.originalEvent.item;
    if (item) {
      $(&quot;#topicsClick&quot;).text(&quot;You clicked point &quot; + item.dataIndex + &quot; (&quot;+item.datapoint[0]+&quot;,&quot;+item.datapoint[1]+&quot;) in &quot; + item.series.label + &quot;.&quot;);
      event.originalEvent.plot.highlight(item.series, item.datapoint);
    }
	});
	  </pre>
	  </div>
      <div id="action">
	  <pre>
@ParentPackage(value = &quot;showcase&quot;)
public class Charts extends ActionSupport {

  private static final long     serialVersionUID = 4851863957798371834L;

  private List&lt;Point&gt;           points;
  private List&lt;Point&gt;           pointsWithNull;
  private List&lt;ListValue&gt;       objList;
  private Map&lt;Integer, Integer&gt; pointsFromMap;
  private Map&lt;Date, Integer&gt;    dateFromMap;
  private String                minTime;
  private String                maxTime;

  @Actions( {
      @Action(value = &quot;/charts&quot;, results = {
        @Result(location = &quot;charts.jsp&quot;, name = &quot;success&quot;)
      }), @Action(value = &quot;/jsonchartdata&quot;, results = {
        @Result(location = &quot;charts.jsp&quot;, name = &quot;success&quot;)
      })
  })
  public String execute() throws Exception
  {
    points = new LinkedList&lt;Point&gt;();

    points.add(new Point(0, 3));
    points.add(new Point(4, 8));
    points.add(new Point(8, 5));
    points.add(new Point(9, 13));

    pointsWithNull = new LinkedList&lt;Point&gt;();

    pointsWithNull.add(new Point(0, 12));
    pointsWithNull.add(new Point(7, 12));
    pointsWithNull.add(null);
    pointsWithNull.add(new Point(7, 2));
    pointsWithNull.add(new Point(12, 2));

    pointsFromMap = new HashMap&lt;Integer, Integer&gt;();
    pointsFromMap.put(2, 5);
    pointsFromMap.put(3, 6);
    pointsFromMap.put(4, 7);
    pointsFromMap.put(5, 8);
    pointsFromMap.put(6, 7);
    pointsFromMap.put(7, 6);

    dateFromMap = new TreeMap&lt;Date, Integer&gt;();
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, -2);

    minTime = &quot;&quot; + calendar.getTime().getTime();
    System.out.println(&quot;minTime : &quot; + minTime);

    Random generator = new Random();
    for (int i = 1; i &lt;= 24; i++)
    {
      dateFromMap.put(calendar.getTime(), generator.nextInt(100));
      calendar.add(Calendar.MONTH, +1);
    }
    maxTime = &quot;&quot; + calendar.getTime().getTime();
    System.out.println(&quot;maxTime : &quot; + maxTime);

    objList = new ArrayList&lt;ListValue&gt;();
    for (int i = 1; i &lt;= 24; i++)
    {
      objList.add(new ListValue(&quot;&quot; + i, &quot;&quot; + generator.nextInt(30)));
    }

    return SUCCESS;
  }

  public List&lt;Point&gt; getPoints()
  {
    return points;
  }

  public List&lt;Point&gt; getPointsWithNull()
  {
    return pointsWithNull;
  }

  public Map&lt;Integer, Integer&gt; getPointsFromMap()
  {
    return pointsFromMap;
  }

  public Map&lt;Date, Integer&gt; getDateFromMap()
  {
    return dateFromMap;
  }

  public String getMinTime()
  {
    return minTime;
  }

  public String getMaxTime()
  {
    return maxTime;
  }

  public List&lt;ListValue&gt; getObjList()
  {
    return objList;
  }
}
	  </pre>
	  </div>
      <div id="jsonaction">
	  <pre>
@ParentPackage(value = &quot;showcase&quot;)
public class JsonChartData extends ActionSupport {

  private static final long   serialVersionUID = 6659512910595305843L;
  private List&lt;ListValue&gt;     objList;
  private Map&lt;Double, Double&gt; doubleMap;

  @Actions( {
    @Action(value = &quot;/json-chart-data&quot;, results = {
      @Result(name = &quot;success&quot;, type = &quot;json&quot;)
    })
  })
  public String execute()
  {

    objList = new ArrayList&lt;ListValue&gt;();
    doubleMap = new TreeMap&lt;Double, Double&gt;();

    Random generator = new Random();
    for (int i = 1; i &lt;= 24; i++)
    {
      doubleMap.put(Double.valueOf(&quot;&quot; + i), generator.nextDouble() * 10.0);
    }

    for (int i = 1; i &lt;= 24; i++)
    {
      objList.add(new ListValue(&quot;&quot; + i, &quot;&quot; + generator.nextInt(30)));
    }

    return SUCCESS;
  }

  public String getJSON()
  {
    return execute();
  }

  public List&lt;ListValue&gt; getObjList()
  {
    return objList;
  }

  public void setObjList(List&lt;ListValue&gt; objList)
  {
    this.objList = objList;
  }

  public Map&lt;Double, Double&gt; getDoubleMap()
  {
    return doubleMap;
  }

  public void setDoubleMap(Map&lt;Double, Double&gt; doubleMap)
  {
    this.doubleMap = doubleMap;
  }
}
	  </pre>
	  </div>
	</sj:tabbedpanel>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
