<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文章列表</title>
<link href="../css/forum.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function changeCount(){
	window.location.href = "listTopics.action?forumId=${forumId}&start=0&range=" + document.getElementById("range").value;
}
</script>
</head>
<body>
	<center>
		<a href="addTopic.jsp?forumId=${param.forumId }">添加文章</a>&nbsp;|&nbsp;<a href="../Forum/listForums.action">版面列表</a>&nbsp;|&nbsp;
		<a href="listTopics.action?forumId=${param.forumId }">文章列表</a><br/>
    </center>
	<table align="right">
			<tr>
				<td>
					<%out.print(request.getAttribute("pageInfo"));%>

					<select name="range" onchange="changeCount();" id="range">
						<option value="5" <s:if test="range == 5">selected="selected"</s:if>>5</option>
						<option value="10" <s:if test="range == 10">selected="selected"</s:if>>10</option>
						<option value="15" <s:if test="range == 15">selected="selected"</s:if>>15</option>
						<option value="20" <s:if test="range == 20">selected="selected"</s:if>>20</option>
					</select>

				</td>
			</tr>
	</table>
	<br/>
	<center>
    	<table border="1" style="border-color: green;background-color: #eeeeee" width="95%">
            <tr align="center">
            	<td width="60%" align="left">标题</td>
                <td>作者</td>
                <td>回复/查看</td>
                <td>最后发表</td>
                <td>操作</td>
            </tr>
            <s:iterator value="list" id="t">
            	 <tr align="center">
	            	<td align="left"><a href="showTopic.action?topicId=${t.id }&forumId=<s:property value='%{forumId}'/>"><s:property value="#t.subject" /></a></td>
	                <td><s:property value="#t.authorName" /></td>
	                <td><s:property value="#t.replyNum" />/<s:property value="#t.viewNum"/></td>
	                <td>
	                	<s:date name="#t.lastPostTopicName" format="yyyy-MM-dd hh:mm:ss" /><br/>
	                	<s:property value="#f.lastPostAuthorName"/>
	                </td>
	                <td>
	                	<a href="deleteTopic.action?id=<s:property value='#t.id'/>&forumId=<s:property value='%{forumId}'/>" onclick="return confirm('警告！此版面及其版面下的所有的帖子和回复都将被删除！！\n你确定要进行删除操作吗？');">删除</a>　｜　
	                	<a href="updatePTopic.action?id=<s:property value='#t.id'/>&forumId=<s:property value='%{forumId}'/>">更新</a>
	                	<s:property value="#t.lastPostAuthorName"/>
	                </td>
           		 </tr>
            </s:iterator>
        </table>
    </center>
</body>
</html>
