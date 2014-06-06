# Struts2 jQuery Plugin

A Plugin for the popular java web framework struts2 to provide ajax functionality and UI Widgets based on the jQuery javascript framework.

### [Download] (https://oss.sonatype.org/content/groups/staging/com/jgeppert/struts2/jquery/)
### [News and Developer Blog] (https://www.jgeppert.com)


## Features

### AJAX support
Easy AJAX Form submission and remote call with the anchor and div tag.
Support for AJAX in the Tabs.

```jsp
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
    <sj:head/>
  </head>
  <body>
    <div id="div1">Div 1</div>
    <s:url id="ajaxTest" value="/AjaxTest.action"/>

    <sj:a id="link1" href="%{ajaxTest}" targets="div1">
      Update Content
    </sj:a>
  </body>
</html>
```

### Support for themes
Built in themes from jQuery
  * black-tie
  * blitzer
  * cupertino
  * dot-luv
  * eggplant
  * excite-bike
  * flick
  * hot-sneaks
  * humanity
  * le-frog
  * mint-choc
  * overcast
  * pepper-grinder
  * redmond
  * smoothness
  * start
  * sunny
  * swanky-purse
  * trontastic
  * ui-darkness
  * ui-lightness
  * vader
  * Your custom theme create with [jQuery ThemeRoller](http://jqueryui.com/themeroller/)

More about themes see the [HeadTag Head Tag]

Use of Build in themes:
```jsp
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
    <sj:head jqueryui="true" jquerytheme="cupertino"/>
  </head>
  <body>
  </body>
</html>
```
Use of your costume theme:
```jsp
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
    <sj:head jqueryui="true" jquerytheme="mytheme" customBasepath="template/themes"/>
  </head>
  <body>
  </body>
</html>
```

### UI widgets
  * [Tabbed Panel](https://code.google.com/p/struts2-jquery/wiki/TabbedPanelTag)
  * [Datepicker](https://code.google.com/p/struts2-jquery/wiki/DatePickerTag)
  * [Dialog](https://code.google.com/p/struts2-jquery/wiki/DialogTag)
  * [Menu](https://code.google.com/p/struts2-jquery/wiki/MenuTag)
  * [Accordion](https://code.google.com/p/struts2-jquery/wiki/AccordionTag)
  * [Autocompleter](https://code.google.com/p/struts2-jquery/wiki/AutocompleterTag)
  * [Button](https://code.google.com/p/struts2-jquery/wiki/Button)
  * [Buttonset](https://code.google.com/p/struts2-jquery/wiki/Buttonset)
  * [Progressbar](https://code.google.com/p/struts2-jquery/wiki/ProgressbarTag)
  * [Slider](https://code.google.com/p/struts2-jquery/wiki/SliderTag)
  * [Grid](https://code.google.com/p/struts2-jquery/wiki/GridTag)
  * [Richtext Editor](https://code.google.com/p/struts2-jquery/wiki/RichtextEditor)
  * [Charts](https://code.google.com/p/struts2-jquery/wiki/ChartTag)
  * [Spinner](https://code.google.com/p/struts2-jquery/wiki/SpinnerTag)

### UI interactions
  * [Resizable for Divs](https://code.google.com/p/struts2-jquery/wiki/Resizable)
  * [Drag and Drop for Divs](https://code.google.com/p/struts2-jquery/wiki/DragAndDrop)
  * [Selectable for Divs](https://code.google.com/p/struts2-jquery/wiki/Selectable)
  * [Sortable for Divs](https://code.google.com/p/struts2-jquery/wiki/Sortable)

