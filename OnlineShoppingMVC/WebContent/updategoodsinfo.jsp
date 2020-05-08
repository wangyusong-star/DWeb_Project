<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/OnlineShoppingMVC/UpdateGoodsInfo" method="post">
				<label for="fname">Update Goods Info</label><br />
				<input type="text" name="name" id="fname" placeholder="please input name"><br />
				<input type="text" name="price" id="fname" placeholder="please input price"><br />
				<input type="text" name="stock" id="fname" placeholder="please input stock"><br />
				<input type="text" name="state" id="fname" placeholder="please input state"><br />
				<input type="text" name="describe" id="fname" placeholder="please input describe"><br />
				<input type="submit" value="UpdateGoods">
	</form>
</body>
</html>