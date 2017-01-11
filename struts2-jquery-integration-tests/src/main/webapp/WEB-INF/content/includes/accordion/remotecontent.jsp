<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url action="echo" namespace="/" var="echoUrl"/>
<sj:accordion id="accordion" list="accordionItemObjects" listKey="title" listValue="content" paramKeys="echo" paramValues="content" href="%{echoUrl}" heightStyle="content"/>

