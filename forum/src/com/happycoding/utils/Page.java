package com.happycoding.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DavidChen(陈基明) Email: cjmiou@gmail.com
 * @version 2010-5-1 上午09:43:25
 */
public class Page {
	public static String getPageInfo(HttpServletRequest request, String appendString, int start, int range,//
			long totalCount) {
		if (totalCount <= range) {
			return "";
		}
		String path = request.getRequestURI();
		String requestResourceName = path.substring(path.lastIndexOf("/") + 1);
		long totalPages = totalCount / range + (totalCount % range == 0 ? 0 : 1);
		int currentPage = start / range + 1;
		StringBuffer sb = new StringBuffer();

		sb.append("[&nbsp;");
		// 是否显示左箭头
		 if(start>0){
		//if (currentPage > 1) {
			sb.append("<a href=\"").append(requestResourceName);
			if (appendString == null || "".equals(appendString)) {
				sb.append("?start=");
			} else {
				sb.append(appendString);
				sb.append("&start=");
			}
			sb.append(start - range).append("&range=" + range);
			sb.append("\"><img src=\"../images/prev.gif\" alt=\"上一页\" width=\"10\"" + //
					" height=\"10\" border=\"0\"></a>&nbsp;");
		}
		int prevFive = currentPage - 5;
		if (prevFive <= 0) {
			prevFive = 1;
		}
		// 加上...
		if (prevFive > 2) {
			// 先加 1因为在下面的循环中
			sb.append("<a href=\"").append(requestResourceName);
			if (appendString == null || "".equals(appendString)) {
				sb.append("?start=");
			} else {
				sb.append(appendString);
				sb.append("&start=");
			}
			// ...不是链接
			sb.append("0&range=" + range + "\">1</a>...&nbsp;");
		}

		while (prevFive < currentPage) {
			sb.append("<a href=\"").append(requestResourceName);
			if (appendString == null || "".equals(appendString)) {
				sb.append("?start=");
			} else {
				sb.append(appendString);
				sb.append("&start=");
			}
			// 假设每一页是10条记录，第二页则为10~19条记录，即start为10，也就是 (页码-1)*range
			sb.append((prevFive - 1) * range);
			sb.append("&range=" + range + "\">" + prevFive + "</a>&nbsp;");
			prevFive++;
		}
		// 显示当前页
		sb.append("<b>" + currentPage + "</b>");

		// 处理后五页

		// 后五页的页码
		int nextFive = currentPage + 5;
		int temp = currentPage + 1;
		while (temp <= totalPages && temp<=nextFive) {
			sb.append("<a href=\"").append(requestResourceName);
			if (appendString == null || "".equals(appendString)) {
				sb.append("?start=");
			} else {
				sb.append(appendString);
				sb.append("&start=");
			}
			sb.append((temp-1)*range).append("&range="+range+"\">"+temp+"</a>&nbsp;");
			temp++;
		}
		if(nextFive+1<totalPages){
			sb.append("...");
		}
		if(nextFive+1<=totalPages){
			sb.append("<a href=\"").append(requestResourceName);
			if (appendString == null || "".equals(appendString)) {
				sb.append("?start=");
			} else {
				sb.append(appendString);
				sb.append("&start=");
			}
			sb.append((totalPages-1)*range).append("&range=").append(range);
			sb.append("\">"+totalPages+"</a>&nbsp;");
		}
		//显示下一页的箭头
		if(totalCount>(start+range)){   //某人的做法
		//if(start<(totalPages-1)*range)
		//if(currentPage<totalPages){
			sb.append("<a href=\"").append(requestResourceName);
			if (appendString == null || "".equals(appendString)) {
				sb.append("?start=");
			} else {
				sb.append(appendString);
				sb.append("&start=");
			}
			sb.append(currentPage*range).append("&range="+range);
			sb.append("\"><img src=\"../images/next.gif\" alt=\"上一页\" width=\"10\"" + //
			" height=\"10\" border=\"0\"></a>&nbsp;");
		}
		
		sb.append("&nbsp;]");

		return sb.toString();
	}
	
//	
//	public static String getPageInfo(HttpServletRequest request, String appendString,
//			int start, int range, long count)
//	{
//		String path = request.getRequestURI();
//
//		// 会返回形如：listDocumentCatalog.action的资源名（去掉查询字符串）
//		String requestedResourceName = path
//				.substring(path.lastIndexOf("/") + 1);
//
//		// 总页数
//		long numPages = count / range + (0 == count % range ? 0 : 1);
//
//		if (numPages <= 1)
//		{
//			return "";
//		}
//
//		StringBuffer sb = new StringBuffer();
//
//		sb.append(" [ ");
//
//		// 显示左箭头
//		if (start > 0)
//		{
//			sb.append("<a href=\"").append(requestedResourceName).append("?");
//
//			if ("".equals(appendString))
//			{
//				sb.append("start=");
//			}
//			else
//			{
//				sb.append(appendString);
//				sb.append("&start=");
//			}
//
//			sb.append(start - range);
//			sb.append("&range=");
//			sb.append(range);
//			sb.append("\">");
//			sb
//					.append("<img src=\"../images/prev.gif\" width=\"10\" height=\"10\" border=\"0\">");
//			sb.append("</a>");
//			sb.append("&nbsp;");
//		}
//
//		// 当前处于第几页
//		int currentPage = start / range + 1;
//
//		int low = currentPage - 5;
//
//		if (low <= 0)
//		{
//			low = 1;
//		}
//
//		int high = currentPage + 5;
//
//		// 加上...
//		if (low > 2)
//		{
//			sb.append("<a href=\"").append(requestedResourceName).append("?");
//
//			if ("".equals(appendString))
//			{
//				sb.append("start=0");
//			}
//			else
//			{
//				sb.append(appendString);
//				sb.append("&start=0");
//			}
//
//			sb.append("&range=");
//			sb.append(range);
//			sb.append("\">");
//			sb.append("1");
//			sb.append("</a>");
//			sb.append("...");
//		}
//
//		while (low < currentPage)
//		{
//			sb.append("<a href=\"").append(requestedResourceName).append("?");
//
//			if ("".equals(appendString))
//			{
//				sb.append("start=");
//			}
//			else
//			{
//				sb.append(appendString);
//				sb.append("&start=");
//			}
//
//			sb.append((low - 1) * range);
//			sb.append("&range=");
//			sb.append(range);
//			sb.append("\">");
//			sb.append(low);
//			sb.append("</a>");
//			sb.append("&nbsp;");
//
//			low++;
//		}
//
//		// 打印当前页
//		sb.append("<b>");
//		sb.append(currentPage);
//		sb.append("</b>");
//
//		// 打印当前页的后5页
//
//		currentPage++;
//
//		while ((currentPage <= high) && (currentPage <= numPages))
//		{
//			sb.append("&nbsp;<a href=\"").append(requestedResourceName).append(
//					"?");
//
//			if ("".equals(appendString))
//			{
//				sb.append("start=");
//			}
//			else
//			{
//				sb.append(appendString);
//				sb.append("&start=");
//			}
//
//			sb.append((currentPage - 1) * range);
//			sb.append("&range=");
//			sb.append(range);
//			sb.append("\">");
//			sb.append(currentPage);
//			sb.append("</a>");
//
//			currentPage++;
//		}
//
//		if (high + 1 < numPages)
//		{
//			sb.append("...");
//		}
//
//		if (high + 1 <= numPages)
//		{
//			sb.append("<a href=\"").append(requestedResourceName).append("?");
//
//			if ("".equals(appendString))
//			{
//				sb.append("start=");
//			}
//			else
//			{
//				sb.append(appendString);
//				sb.append("&start=");
//			}
//
//			sb.append((numPages - 1) * range);
//			sb.append("&range=");
//			sb.append(range);
//			sb.append("\">");
//			sb.append(numPages);
//			sb.append("</a>");
//		}
//
//		// 如果不在最后一页，则显示向右箭头
//		if (count > (start + range))
//		{
//			sb.append("&nbsp;<a href=\"").append(requestedResourceName).append(
//					"?");
//
//			if ("".equals(appendString))
//			{
//				sb.append("start=");
//			}
//			else
//			{
//				sb.append(appendString);
//				sb.append("&start=");
//			}
//
//			sb.append(start + range);
//			sb.append("&range=");
//			sb.append(range);
//			sb.append("\">");
//			sb
//					.append("<img src=\"../images/next.gif\" width=\"10\" height=\"10\" border=\"0\">");
//			sb.append("</a>");
//		}
//		
//		sb.append("]");
//
//		return sb.toString();
//	}
}
