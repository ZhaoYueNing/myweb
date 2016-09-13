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
    
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <title><s:property value="%{news.title}"/></title>
<style>
	#header {
	    background-color:black;
	    color:white;
	    text-align:center;
	    padding:5px;
	}
	#nav {
	    line-height:30px;
	    background-color:#eeeeee;
	    height:300px;
	    width:100px;
	    float:left;
	    padding:5px;	      
	}
	#section {
	    
	    
	    padding:10px;	 	 
	}
	#footer {
	    background-color:black;
	    color:white;
	    clear:both;
	    text-align:center;
	   padding:5px;	 	 
	}
	</style>
</head>
	
<body>
	<div id="header">
	<h1><s:property value="%{news.title}"/></h1>
	<a href="/myweb/" style="color:white">回到首页</a>
	</div>
<!--	
	<div id="nav">
	<a href="/myweb/get-news?column.name=test">test</a><br>
	Paris<br>
	Tokyo<br>
	</div>
-->	
	<div id="section">
    <font style=" text-align:left">
	<h5><s:property value="%{news.author}"/> - <s:property value="%{news.date}"/></h5></font><hr />
	<pre>
<s:property value="%{news.content}"/>
    </pre>
	</div>
	
	<div id="footer">
	Copyright  zhaoyuening.cn <s:debug></s:debug>
	</div>
		
</body>
</html>
