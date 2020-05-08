<%@ page language="java" import="javabean.Goods"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align='center'>Profit</h1>
	<hr />
	<form action="/OnlineShopping/ViewProfit">
		<a><%=request.getAttribute("profit")%></a>
	</form>
</body>
</html>