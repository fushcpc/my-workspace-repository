<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加版面</title>
<link href="../css/forum.css" rel="stylesheet" type="text/css" />
</head>
<body>
<br /><br /><br /><br /><br />
	<center>
	<form action="addForum.action" method="post" >
		<input type="hidden" name="parentId" value="${param.forumId }"/>
    	<table>
        	<caption style=" font-size:30px">添加版面</caption><br /><br />
            <tr>
            	<td>版面名:</td>
                <td><input  type="text" name="name" size="80" class="input"/></td>
            </tr>
            <tr>
            	<td>描　述:</td>
                <td><input  type="text" name="description" size="80"/ class="input"></td>
            </tr>
            <tr>
            	<td>
                	<input type="submit" value="添加" />
                </td>
                <td>
                	<input type="reset" value="重置" />
                </td>
            </tr>
        </table>
    </form>
    </center>
</body>
</html>
