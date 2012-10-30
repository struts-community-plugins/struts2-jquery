<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjc" uri="/struts-jquery-chart-tags" %>

<h2>Charts</h2>


<h3>Chart with values from a List or a Map</h3>
<sjc:chart id="chartPoints" cssStyle="width: 600px; height: 400px;">
	<sjc:chartData
			label="List -Points-"
			list="points"
			points="{ show: true }"
			lines="{ show: false }"
			curvedLines="true"
			curvedLinesFit="true"
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
		xaxisLabel="Label-X"
		yaxisLabel="Label-Y"
		yaxisLabelFontSizePixels="22"
		yaxisLabelFontFamily="Arial"
		crosshair="true"
		crosshairMode="xy"
		>
	<sjc:chartData
			label="List with Objects"
			list="objList"
			listKey="myKey"
			listValue="myValue"
			points="{ show: true }"
			lines="{ show: false }"
			clickable="true"
			hoverable="true"
			curvedLines="true"
			curvedLinesFill="true"
			curvedLinesFillColor="#ccc"
			curvedLinesLineWidth="3"
			/>
</sjc:chart>

<br/>

<h3>Chart with Date Values</h3>
<sjc:chart
		id="chartDate"
		xaxisMode="time"
		xaxisTimeformat="%m.%Y"
		xaxisMin="%{minTime}"
		xaxisMax="%{maxTime}"
		xaxisColor="#666"
		xaxisTickSize="[3, 'month']"
		xaxisTickColor="#aaa"
		xaxisPosition="top"
		yaxisPosition="right"
		yaxisTickSize="10"
		cssStyle="width: 600px; height: 400px;"
		>
	<sjc:chartData
			id="chartDateData"
			label="Map -Date, Integer-"
			list="dateFromMap"
			color="#990066"
			lines="{ show: true }"
			/>
</sjc:chart>

<br/>

<h3>Chart with AJAX Data and Topics</h3>
<s:url var="chartDataUrl" action="json-chart-data"/>
<sjc:chart
		id="chartAjax"
		legendLabelBoxBorderColor="#990033"
		legendPosition="ne"
		legendShow="#ccc"
		cssStyle="width: 600px; height: 400px;"
		>
	<sjc:chartData
			id="chartAjaxData1"
			label="Map -Double, Double-"
			href="%{chartDataUrl}"
			list="doubleMap"
			deferredLoading="true"
			reloadTopics="reloadMap"
			lines="{show : true}"
			/>
	<sjc:chartData
			id="chartAjaxData2"
			label="List -ListValue-"
			href="%{chartDataUrl}"
			list="objList"
			listKey="myKey"
			listValue="myValue"
			reloadTopics="reloadList"
			lines="{show : true}"
			/>
</sjc:chart>
<sj:a onClickTopics="reloadMap" button="true" buttonIcon="ui-icon-refresh">Load/Reload Map</sj:a>
<sj:a onClickTopics="reloadList" button="true" buttonIcon="ui-icon-refresh">Reload List</sj:a>

<br/>

<h3>Chart with AJAX Data with Stacked Values</h3>
<sjc:chart
		id="chartAjaxTwo"
		cssStyle="width: 600px; height: 400px;"
		>
	<sjc:chartData
			id="chartAjaxTwoData1"
			label="Map -Double, Double-"
			href="%{chartDataUrl}"
			list="doubleMap"
			bars="{show : true, barWidth: 0.7}"
			stack="stack1"
			/>
	<sjc:chartData
			id="chartAjaxTwoData2"
			label="List -ListValue-"
			href="%{chartDataUrl}"
			list="objList"
			listKey="myKey"
			listValue="myValue"
			bars="{show : true, barWidth: 0.7}"
			stack="stack1"
			/>
</sjc:chart>

<br/>
<br/>

<h3>A Pie Chart</h3>
<sjc:chart
		id="chartPie"
		cssStyle="width: 600px; height: 400px;"
		pie="true"
		pieLabel="true"
		>
	<sjc:chartData
			id="pieSerie1"
			label="Serie 1"
			data="10"
			/>
	<sjc:chartData
			id="pieSerie2"
			label="Serie 2"
			data="3"
			/>
	<sjc:chartData
			id="pieSerie3"
			label="Serie 3"
			data="17"
			/>
	<sjc:chartData
			id="pieSerie4"
			label="Serie 4"
			data="37"
			/>
</sjc:chart>

<br/>

<h3>A Pie Donut Chart from a Map </h3>
<sjc:chart
		id="chartPie2"
		cssStyle="width: 600px; height: 400px;"
		legendShow="false"
		pie="true"
		pieLabel="true"
		pieInnerRadius="0.3"
		pieLabelRadius="0.6"
		pieLabelBackgroundColor="#555"
		pieLabelBackgroundOpacity="0.7"
		>
	<s:iterator value="%{pieDataMap}">
		<sjc:chartData
				label="%{key}"
				data="%{value}"
				/>
	</s:iterator>
</sjc:chart>

<br/>

<h3>Fill between two Series</h3>
<sjc:chart id="chartPointsFill" cssStyle="width: 600px; height: 400px;">
	<sjc:chartData
			id="series1"
			label="Series 1"
			data="[[2, 88.0], [3, 93.3], [4, 102.0], [5, 108.5], [6, 115.7], [7, 115.6], [8, 124.6], [9, 130.3], [10, 134.3], [11, 141.4], [12, 146.5], [13, 151.7], [14, 159.9], [15, 165.4], [16, 167.8], [17, 168.7], [18, 169.5], [19, 168.0]]"
			lines="{ show: true }"
			/>
	<sjc:chartData
			id="series2"
			label="Series 2"
			data="[[2, 96.8], [3, 105.2], [4, 113.9], [5, 120.8], [6, 127.0], [7, 133.1], [8, 139.1], [9, 143.9], [10, 151.3], [11, 161.1], [12, 164.8], [13, 173.5], [14, 179.0], [15, 182.0], [16, 186.9], [17, 185.2], [18, 186.3], [19, 186.6]]"
			lines="{ show: true, fill: true }"
			fillBetween="series1"
			/>
</sjc:chart>

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
    		lines=&quot;{ show: false }&quot;
     		curvedLines=&quot;true&quot;
     		curvedLinesFit=&quot;true&quot;
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
    &lt;sjc:chart
    	id=&quot;chartObjects&quot;
    	cssStyle=&quot;width: 600px; height: 400px;&quot;
    	onClickTopics=&quot;chartClick&quot;
    	onHoverTopics=&quot;chartHover&quot;
    	xaxisLabel=&quot;Label-X&quot;
    	yaxisLabel=&quot;Label-Y&quot;
    	yaxisLabelFontSizePixels="22"
    	yaxisLabelFontFamily="Arial"
    	crosshair=&quot;true&quot;
    	crosshairMode=&quot;xy&quot;
    &gt;
    	&lt;sjc:chartData
    		label=&quot;List with Objects&quot;
    		list=&quot;objList&quot;
    		listKey=&quot;myKey&quot;
    		listValue=&quot;myValue&quot;
    		points=&quot;{ show: true }&quot;
    		lines=&quot;{ show: false }&quot;
    		clickable=&quot;true&quot;
    		hoverable=&quot;true&quot;
     		curvedLines=&quot;true&quot;
     		curvedLinesFill=&quot;true&quot;
     		curvedLinesFillColor=&quot;#ccc&quot;
     		curvedLinesLineWidth=&quot;3&quot;
    	/&gt;
    &lt;/sjc:chart&gt;

    &lt;br/&gt;

	&lt;h3&gt;Chart with Date Values&lt;/h3&gt;
    &lt;sjc:chart
    	id=&quot;chartDate&quot;
    	xaxisMode=&quot;time&quot;
    	xaxisTimeformat=&quot;%m.%Y&quot;
    	xaxisMin=&quot;%{minTime}&quot;
    	xaxisMax=&quot;%{maxTime}&quot;
    	xaxisColor=&quot;#666&quot;
    	xaxisTickSize=&quot;[3, 'month']&quot;
    	xaxisTickColor=&quot;#aaa&quot;
    	xaxisPosition=&quot;top&quot;
    	yaxisPosition=&quot;right&quot;
    	yaxisTickSize=&quot;10&quot;
    	cssStyle=&quot;width: 600px; height: 400px;&quot;
    &gt;
    	&lt;sjc:chartData
    		id=&quot;chartDateData&quot;
    		label=&quot;Map -Date, Integer-&quot;
    		list=&quot;dateFromMap&quot;
    		color=&quot;#990066&quot;
    		lines=&quot;{ show: true }&quot;
    	/&gt;
    &lt;/sjc:chart&gt;

    &lt;br/&gt;

	&lt;h3&gt;Chart with AJAX Data and Topics&lt;/h3&gt;
	&lt;s:url id=&quot;chartDataUrl&quot; action=&quot;json-chart-data&quot;/&gt;
    &lt;sjc:chart
    	id=&quot;chartAjax&quot;
    	legendLabelBoxBorderColor=&quot;#990033&quot;
    	legendPosition=&quot;ne&quot;
    	legendShow=&quot;#ccc&quot;
    	cssStyle=&quot;width: 600px; height: 400px;&quot;
    &gt;
    	&lt;sjc:chartData
    		id=&quot;chartAjaxData1&quot;
    		label=&quot;Map -Double, Double-&quot;
    		href=&quot;%{chartDataUrl}&quot;
    		list=&quot;doubleMap&quot;
    		deferredLoading=&quot;true&quot;
    		reloadTopics=&quot;reloadMap&quot;
    		lines=&quot;{show : true}&quot;
    	/&gt;
    	&lt;sjc:chartData
    		id=&quot;chartAjaxData2&quot;
    		label=&quot;List -ListValue-&quot;
    		href=&quot;%{chartDataUrl}&quot;
    		list=&quot;objList&quot;
    		listKey=&quot;myKey&quot;
    		listValue=&quot;myValue&quot;
    		reloadTopics=&quot;reloadList&quot;
    		lines=&quot;{show : true}&quot;
    	/&gt;
    &lt;/sjc:chart&gt;
    &lt;sj:a onClickTopics=&quot;reloadMap&quot; button=&quot;true&quot; buttonIcon=&quot;ui-icon-refresh&quot;&gt;Load/Reload Map&lt;/sj:a&gt;
    &lt;sj:a onClickTopics=&quot;reloadList&quot; button=&quot;true&quot; buttonIcon=&quot;ui-icon-refresh&quot;&gt;Reload List&lt;/sj:a&gt;

    &lt;br/&gt;

	&lt;h3&gt;Chart with AJAX Data with Stacked Values&lt;/h3&gt;
    &lt;sjc:chart
    	id=&quot;chartAjaxTwo&quot;
    	cssStyle=&quot;width: 600px; height: 400px;&quot;
    &gt;
    	&lt;sjc:chartData
    		id=&quot;chartAjaxTwoData1&quot;
    		label=&quot;Map -Double, Double-&quot;
    		href=&quot;%{chartDataUrl}&quot;
    		list=&quot;doubleMap&quot;
    		bars=&quot;{show : true, barWidth: 0.7}&quot;
    		stack=&quot;stack1&quot;
    	/&gt;
    	&lt;sjc:chartData
    		id=&quot;chartAjaxTwoData2&quot;
    		label=&quot;List -ListValue-&quot;
    		href=&quot;%{chartDataUrl}&quot;
    		list=&quot;objList&quot;
    		listKey=&quot;myKey&quot;
    		listValue=&quot;myValue&quot;
    		bars=&quot;{show : true, barWidth: 0.7}&quot;
    		stack=&quot;stack1&quot;
    	/&gt;
    &lt;/sjc:chart&gt;

    &lt;br/&gt;
    &lt;br/&gt;

	&lt;h3&gt;A Pie Chart&lt;/h3&gt;
    &lt;sjc:chart
    	id=&quot;chartPie&quot;
    	cssStyle=&quot;width: 600px; height: 400px;&quot;
    	pie=&quot;true&quot;
    	pieLabel=&quot;true&quot;
    &gt;
    	&lt;sjc:chartData
    		id=&quot;pieSerie1&quot;
    		label=&quot;Serie 1&quot;
    		data=&quot;10&quot;
    	/&gt;
    	&lt;sjc:chartData
    		id=&quot;pieSerie2&quot;
    		label=&quot;Serie 2&quot;
    		data=&quot;3&quot;
    	/&gt;
    	&lt;sjc:chartData
    		id=&quot;pieSerie3&quot;
    		label=&quot;Serie 3&quot;
    		data=&quot;17&quot;
    	/&gt;
    	&lt;sjc:chartData
    		id=&quot;pieSerie4&quot;
    		label=&quot;Serie 4&quot;
    		data=&quot;37&quot;
    	/&gt;
    &lt;/sjc:chart&gt;
    
    &lt;br/&gt;

	&lt;h3&gt;A Pie Donut Chart from a Map &lt;/h3&gt;
    &lt;sjc:chart
    	id=&quot;chartPie2&quot;
    	cssStyle=&quot;width: 600px; height: 400px;&quot;
    	legendShow=&quot;false&quot;
    	pie=&quot;true&quot;
    	pieLabel=&quot;true&quot;
    	pieInnerRadius=&quot;0.3&quot;
    	pieLabelRadius=&quot;0.6&quot;
    	pieLabelBackgroundColor=&quot;#555&quot;
    	pieLabelBackgroundOpacity=&quot;0.7&quot;
    &gt;
    	&lt;s:iterator value=&quot;%{pieDataMap}&quot;&gt;
	    	&lt;sjc:chartData
	    		label=&quot;%{key}&quot;
	    		data=&quot;%{value}&quot;
	    	/&gt;
    	&lt;/s:iterator&gt;
    &lt;/sjc:chart&gt;

    &lt;br/&gt;

	&lt;h3&gt;Fill between two Series&lt;/h3&gt;
    &lt;sjc:chart id=&quot;chartPointsFill&quot; cssStyle=&quot;width: 600px; height: 400px;&quot;&gt;
    	&lt;sjc:chartData
    		id=&quot;series1&quot;
    		label=&quot;Series 1&quot;
    		data=&quot;[[2, 88.0], [3, 93.3], [4, 102.0], [5, 108.5], [6, 115.7], [7, 115.6], [8, 124.6], [9, 130.3], [10, 134.3], [11, 141.4], [12, 146.5], [13, 151.7], [14, 159.9], [15, 165.4], [16, 167.8], [17, 168.7], [18, 169.5], [19, 168.0]]&quot;
    		lines=&quot;{ show: true }&quot;
    	/&gt;
    	&lt;sjc:chartData
    		id=&quot;series2&quot;
    		label=&quot;Series 2&quot;
    		data=&quot;[[2, 96.8], [3, 105.2], [4, 113.9], [5, 120.8], [6, 127.0], [7, 133.1], [8, 139.1], [9, 143.9], [10, 151.3], [11, 161.1], [12, 164.8], [13, 173.5], [14, 179.0], [15, 182.0], [16, 186.9], [17, 185.2], [18, 186.3], [19, 186.6]]&quot;
    		lines=&quot;{ show: true, fill: true }&quot;
    		fillBetween=&quot;series1&quot;
    	/&gt;
    &lt;/sjc:chart&gt;
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
  private Map&lt;String, Integer&gt;  pieDataMap;
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

    pieDataMap = new TreeMap&lt;String, Integer&gt;();
    pieDataMap.put(&quot;Java&quot;, 18);
    pieDataMap.put(&quot;C&quot;, 17);
    pieDataMap.put(&quot;C++&quot;, 10);
    pieDataMap.put(&quot;PHP&quot;, 8);
    pieDataMap.put(&quot;(Visual) Basic&quot;, 6);
    pieDataMap.put(&quot;C#&quot;, 5);

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

  public Map&lt;String, Integer&gt; getPieDataMap()
  {
    return pieDataMap;
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
