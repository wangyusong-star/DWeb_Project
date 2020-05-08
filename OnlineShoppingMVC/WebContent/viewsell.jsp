<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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

	<form action="/OnlineShoppingMVC/ViewSell" method="post">
				<input type="text" name="businessman" value=<%=username %>><br />
				<input type="submit" value="View">
	</form>
</body>
</html>