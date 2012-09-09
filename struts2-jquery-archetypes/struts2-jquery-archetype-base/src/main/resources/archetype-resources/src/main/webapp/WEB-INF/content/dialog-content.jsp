<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2><s:property value="message"/></h2>

<h3>Languages</h3>
 <s:url var="url" action="hello">
     <s:param name="request_locale">en</s:param>
 </s:url>
 <sj:a href="%{url}" targets="welcomeDialog" button="true" buttonIcon="ui-icon-gear">English</sj:a>
 <s:url var="url" action="hello">
     <s:param name="request_locale">es</s:param>
 </s:url>
 <sj:a href="%{url}" targets="welcomeDialog" button="true" buttonIcon="ui-icon-gear">Espanol</sj:a>
