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

	<form action="/OnlineShoppingMVC/AddGoodsInfo" method="post">
				<label for="fname">Add_Goods</label><br />
				<input type="text" name="name" id="fname" placeholder="please input name you want add"><br />
				<input type="text" name="price" id="fname" placeholder="please input price you want add"><br />
				<input type="text" name="stock" id="fname" placeholder="please input stock you want add"><br />
				<input type="text" name="state" id="fname" placeholder="please input state you want add"><br />
				<input type="text" name="describe" id="fname" placeholder="please input describe you want add"><br />
				<input type="text" name="offer" value=<%=username %>><br />
				<input type="submit" value="Add Goods Info">
	</form>
</body>
</html>