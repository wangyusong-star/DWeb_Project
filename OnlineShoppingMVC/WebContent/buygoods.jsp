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

	<form action="/OnlineShoppingMVC/BuyGoods" method="post">
				<label for="fname">Update Customer Password</label><br />
				<input type="text" name="goodname" id="fname" placeholder="please input goodname you want"><br />
				<input type="text" name="num" id="fname" placeholder="please input good num you want"><br />
				<input type="text" name="customername" value=<%=username %>><br />
				<input type="submit" value="Buy">
	</form>
</body>
</html>