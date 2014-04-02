<%@ page language="java" import="java.util.*,javax.naming.*,com.test.ejb.third.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <%
        InitialContext context = new InitialContext();
            UserManagerRemoteEjb userManager = (UserManagerRemoteEjb) context.lookup("UserManagerEjbImpl/local");
            User user = new User("Jimmy", "Password");
            userManager.addUser(user);
            out.println("The user is" + user + " after added from remote server.");
    %>
  </body>
</html>
