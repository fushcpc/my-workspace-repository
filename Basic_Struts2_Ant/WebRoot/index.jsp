<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Struts 2!</title>
</head>
<body>
<h1>Welcome to Struts 2!</h1>

<s:url var="helloLink" action="hello">
	<s:param name="username">Phillips</s:param>
</s:url>

<a href="${helloLink }">HelloWorld</a>

<p>Get your own personal hello by filling out and submitting this form</p>
<s:form action="hello">
	<s:textfield label="You Name" name="userName"></s:textfield>
	<s:submit></s:submit>
</s:form>


</body>
</html>