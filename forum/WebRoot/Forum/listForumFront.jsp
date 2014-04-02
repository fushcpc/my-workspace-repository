<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>版面列表</title>
<link href="../css/forum.css" rel="stylesheet" type="text/css" />
</head>
<body>
<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="addForum.jsp">添加版面</a><br/>
	<center>
    	<table border="1" style="border-color: green;background-color: #eeeeee" width="80%">
            <tr align="center">
            	<td>版面名</td>
                <td>主题数目</td>
                <td>总回复数目</td>
                <td>最后发表</td>
                <td>操作</td>
            </tr>
            <s:iterator value="list" id="f">
            	 <tr align="center">
	            	<td align="left"><s:property value="#f.name" /></td>
	                <td></td>
	                <td></td>
	                <td>
	                </td>
	                <td width="200">
	                	<a href="deleteForum.action?id=<s:property value='#f.id'/>" onclick="return confirm('警告！此版面及其版面下的所有的帖子和回复都将被删除！！\n你确定要进行删除操作吗？');">删除</a>｜
	                	<a href="updatePForum.action?id=<s:property value='#f.id'/>">更新</a>| 
	                	<a href="addForum.jsp?forumId=<s:property value='#f.id'/>">添加子版面</a>
	                	<s:property value="#f.lastPostAuthorName"/>
	                </td>
           		 </tr>
           		 <!--  -->
           		 <s:iterator value="#f.children" id="c">
           		 	<tr align="center">
		            	<td align="right"><a href="../Topic/listTopics.action?forumId=<s:property value='#c.id'/>&forumName=<s:property value='#c.name'/>"><s:property value="#c.name" /></a></td>
		                <td><s:property value="#c.topicNum" /></td>
		                <td><s:property value="#c.replyNum" /></td>
		                <td>
		                	<s:date name="#c.lastPostTopicName" format="yyyy-MM-dd hh:mm:ss" /><br/>
		                	<s:property value="#c.lastPostAuthorName"/>
		                </td>
		                <td width="200">
		                	<a href="deleteForum.action?id=<s:property value='#c.id'/>" onclick="return confirm('警告！此版面及其版面下的所有的帖子和回复都将被删除！！\n你确定要进行删除操作吗？');">删除</a>｜
		                	<a href="updatePForum.action?id=<s:property value='#c.id'/>">更新</a>|
		                	<a href="../Topic/addTopic.jsp?forumId=<s:property value='#c.id'/>">发表新文章</a>
		                </td>
	           		 </tr>
           		 </s:iterator>
            </s:iterator>
        </table>
    </center>
</body>
</html>
