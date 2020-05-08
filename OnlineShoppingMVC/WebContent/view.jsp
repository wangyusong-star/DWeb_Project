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
	<h1 align='center'>All_Goods</h1>
	<hr />
	<form action="/OnlineShopping/ViewSell">
	<table align='center' border='1' width='90%'>
		<thead>
			<tr>
				<th>goodid</th>
				<th>goodname</th>
				<th>price</th>
				<th>stock</th>
				<th>state</th>
				<th>describe</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Goods> list = (List<Goods>)request.getAttribute("goods");
				for(Goods g :list) {					
			%><tr>
				<td><%=g.getGoods_id() %></td>
				<td><%=g.getGoods_name() %></td>
				<td><%=g.getGoods_price()%></td>
				<td><%=g.getGoods_stock()%></td>
				<td><%=g.getGoods_state()%></td>
				<td><%=g.getGoods_describe()%></td>
				</tr>
			<%
				}
			%>
		</tbody>
	</table>
	</form>
</body>
</html>