<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.List" import="bean.Goods"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Shopping</title>

<link href="css/basic-2.css" rel="stylesheet" type="text/css" />

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
<div class="fixedtop">
<center>
<ul>
		<li><a style="margin-right:200px"><b>Welcome!  <%=username %></b></a></li>
        <li><a style="float:left" href="register.jsp"><b>Regist</b></a></li>		
		<li><a style="float:left" href="login.jsp"><b>Login</b></a></li>
                
		<li><a href="#"><b>My Shopping</b></a>
        <ul>
        <li><a href="#"><b>stuff I've brought</b></a></li>
        <li><a href="#"><b>stuff I've sold out</b></a></li>
        </ul>
        </li>
       
</ul>
</center>
</div>
<h1 style="float:left">Shopping!</h1>

<form  action="/OnlineShopping/SearchGoods" method="post">
<div class="search">

            <input type="text" placeholder="Search for..." name="search"/>
            <button><i><b>Go</b></i></button>
</div>
</form>

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
			List<Goods> list = (List<Goods>)request.getAttribute("searchgoods");
			if(list!=null){
				for(Goods g :list) {					
			%><tr>
				<td><%=g.getGoodid() %></td>
				<td><%=g.getGoodname() %></td>
				<td><%=g.getPrice() %></td>
				<td><%=g.getStock() %></td>
				<td><%=g.getState() %></td>
				<td><%=g.getDescribe() %></td>
				</tr>
			<%
				}
			}else{
				%>
			<tr>
				<td>null</td>
				<td>null</td>
				<td>null</td>
				<td>null</td>
				<td>null</td>
				<td>null</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>