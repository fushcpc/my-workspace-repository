<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加文章</title>
<link href="../css/forum.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	function beforeSubmit(){
		var data = CKEDITOR.instances.content.getData();
		document.getElementById("editor1").value=data;
		document.forms[0].submit();
	}

</script>
</head>
<body>
	<center>
	<form name="addTopic" action="addTopic.action" method="post" >
	<input type="hidden" name="forumId" value="${param.forumId }"/>
    	<table>
        	<caption style=" font-size:20px">添加文章</caption><br /><br />
            <tr>
            	<td>标题:</td>
                <td><input  type="text" name="subject" size="110" class="input"/></td>
            </tr>
            <tr>
            	<td>内容:</td>
                <td>
                	<textarea id="editor1" name="content" rows="50" cols="100" class="ckeditor" ></textarea>
                </td>
            </tr>
            <tr>
            	<td>
                </td>
                <td>
              	    <input type="submit" value="添加" accesskey="W" />
                	<input type="reset" value="重置" />
                </td>
            </tr>
        </table>
    </form>
    </center>
</body>
<script type="text/javascript">
	CKEDITOR.replace("content");
</script>
</html>
