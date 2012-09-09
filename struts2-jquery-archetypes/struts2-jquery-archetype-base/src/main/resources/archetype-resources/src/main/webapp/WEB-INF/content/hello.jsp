<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
    <title>Welcome to Struts2 jQuery</title>
    <sj:head jquerytheme="redmond"/>
    <style>
    body{
    	font-size: 10pt;
    } 
    </style>
</head>

<body>

    <s:url var="url" action="dialog-content" />
	<sj:dialog href="%{url}" id="welcomeDialog" title="Welcome to Struts2 jQuery" />
</body>
</html>
