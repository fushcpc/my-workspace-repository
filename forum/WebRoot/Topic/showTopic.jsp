<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{topic.subject}" /></title>
<link href="../css/forum.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../syntaxhighlighter2.1/scripts/shCore.js"></script>
	<script type="text/javascript" src="../syntaxhighlighter2.1/scripts/shBrushBash.js"></script>
	<script type="text/javascript" src="../syntaxhighlighter2.1/scripts/shBrushCSharp.js"></script>
	<script type="text/javascript" src="../syntaxhighlighter2.1/scripts/shBrushCss.js"></script>
	<script type="text/javascript" src="../syntaxhighlighter2.1/scripts/shBrushJava.js"></script>
	<script type="text/javascript" src="../syntaxhighlighter2.1/scripts/shBrushJScript.js"></script>
	<script type="text/javascript" src="../syntaxhighlighter2.1/scripts/shBrushSql.js"></script>
	<script type="text/javascript" src="../syntaxhighlighter2.1/scripts/shBrushXml.js"></script>
	<link type="text/css" rel="stylesheet" href="../syntaxhighlighter2.1/styles/shCore.css"/>
	<link type="text/css" rel="stylesheet" href="../syntaxhighlighter2.1/styles/shThemeEclipse.css"/>
	<script type="text/javascript">
		SyntaxHighlighter.config.clipboardSwf = '../syntaxhighlighter2.1/scripts/clipboard.swf';
		SyntaxHighlighter.all();
	</script>
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
		<a href="addTopic.jsp?forumId=${param.forumId }">添加文章</a>&nbsp;|&nbsp;<a href="../Forum/listForums.action">版面列表</a>&nbsp;|&nbsp;
		<a href="listTopics.action?forumId=${param.forumId }">文章列表</a><br/>
    </center>	
    	<table border="1" style="border-color: green;background-color: #eeeeee" width="95%">
            <tr>
            	<td colspan="2" align="center" bgcolor="#CCFFFF"><s:property value="%{topic.subject}" /></td>
            </tr>
            <tr>
            	<td height="300px;" valign="top" align="left">${topic.content }</td>         	
            </tr>
        </table>
            <br/>
	            <s:iterator value="replies" id="reply">
	            	<table border="1" style="border-color: green;background-color: #eeeeee" width="95%">
		            	<tr>
		            		<td height="100px;" valign="top" align="left">${reply.content }</td>         	
		            	</tr>
	            	</table>
	            	<br/>
	            </s:iterator>
	            <table border="1" style="border-color: green;background-color: #eeeeee" width="95%">
		            <tr>
		            	<td>
		            		<form action="../Reply/addReply.action" method="post" >
		            			<input  type="hidden" name="topicId" value="${topicId }"/>
		            			<input type="hidden" name="forumId" value="${param.forumId }"/>
		            			<textarea id="editor1" name="content" rows="50" cols="100" class="ckeditor" ></textarea>
		            			<input type="submit"  value="发表"/>
		            		</form>
		            	</td>         	
		            </tr>
	            </table>
</body>
<script type="text/javascript">
	CKEDITOR.replace("content");
</script>
</html>
