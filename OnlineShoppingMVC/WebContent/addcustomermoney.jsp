<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String username = "";
Cookie cookies[] = request.getCookies();
if (cookies != null){
	for(int i = 0; i < cookies.length; i++){
	username = cookies[i].getName();
}
}
%>

	<form action="/OnlineShoppingMVC/AddMoney" method="post">
				<label for="fname">Add_Money</label><br />
				<input type="text" name="money" id="fname" placeholder="please input money you want add"><br />
				<input type="text" name="customername" value=<%=username %>><br />
				<input type="submit" value="AddMoney">
	</form>
</body>
</html>