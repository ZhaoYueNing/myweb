<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add-news-success.jsp' starting page</title>
    
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
  <div id="header" style="background-color: black;color: white;text-align: center;padding-top: 10px;font-size: 20px">
  	<h1>后台管理</h1>
  	<a href="/myweb/" style="color:white">回到首页</a>
  	<hr>
  </div>
	<s:form action="add-news.action" method="post">
		<s:textfield cssStyle="color:green;width:900px;" key="标题" name="news.title"></s:textfield>
		<s:textfield cssStyle="color:green;width:900px;" key="作者" name="news.author"></s:textfield>
		<s:textfield cssStyle="color:green;width:900px;" key="日期" name="news.date"></s:textfield>
		
		<s:textarea cssStyle="color:blue;height:300px;width:900px;" key="内容" name="news.content"></s:textarea>
		<s:select list="%{columns}" key="栏目" listValue="otherName" listKey="name" name="news.column.name" headerKey="other" headerValue="====选择发布栏目===="></s:select>

		<s:submit key="添加" cssStyle="float:center;"></s:submit>
	</s:form>  
	<s:property value="%{#addResult}"/>	
	<div id="footer" style="background-color: black;color: white;text-align: center;padding-top: 10px;font-size: 20px">
	<s:debug/>
  	<h1></h1>
  	<hr>
  </div>
  </body>
</html>
