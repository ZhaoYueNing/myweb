<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>赵岳宁个人站</title>
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
	 
	    overflow:auto;
	    float:left;
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
	<h1>赵岳宁个人站</h1>
	</div>
	
	<div id="nav">
	
	<s:iterator value="%{columns}" var="c">
	
		<a href="/myweb/get-news?column.name=<s:property value="%{#c.name}"/>"><s:property value="%{#c.otherName}"/></a><br>
	</s:iterator>
<!-- 	<a href="/myweb/get-news?column.name=test">test</a><br>
	<a href="/myweb/get-news?column.name=sports">sports</a><br> -->

	</div>
	
	<div id="section">
	<!-- 默认栏目 介绍网站 -->
	<s:if test="column.name=='default'">
		
	</s:if>
	<!-- 指定栏目 资讯列表 -->
	<s:else>
		
	</s:else>
	<!-- 资讯列表  -->
	<h3><s:property value="column.otherName"/></h3>
		<ol>
			<s:iterator  value="%{newsList}" var="news">
				<li><a href="/myweb/get-news!lookNews?newsId=<s:property value="#news.id"/>"><s:property value="#news.title"/></a></li>				
			</s:iterator>
		</ol>
	</div>
	
	<div id="footer">
	Copyright  zhaoyuening.cn <s:debug></s:debug>
	<br><a href="/myweb/admin/">后台管理</a>
	</div>
		
</body>
</html>