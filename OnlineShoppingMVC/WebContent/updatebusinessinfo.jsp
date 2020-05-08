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

	<form action="/OnlineShoppingMVC/ChangeCustomerInfo" method="post">
				<label for="fname">Update Your Password</label><br />
				<input type="text" name="pwd" id="fname" placeholder="please input new password you want"><br />
				<input type="text" name="businessname" value=<%=username %>><br />
				<input type="submit" value="UpdatePassword">
	</form>
</body>
</html>