<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户信息</title>
</head>
<body>
<form action="/OnlineShopping/ChangeGoodsInfo method="post">
		<table border="1" align="center" width="0.2">
			<tr
				style="background-color: yellow; color: white; font-size = 20px; font-weight: bold; text-align: center">
				<td colspan="2"><b>InfoChange</b></td>
				
				</tr>
				<tr align="center">
				<td style="background-color: pink">goodname</td>
				<td><input type="text" name="goodname" id=""></td>
				</tr>
				
				<tr align="center">
				<td style="background-color: pink">price</td>
				<td><input type="text" name="price" id=""></td>
				</tr>
				
				<tr align="center">
				<td style="background-color: pink">stock</td>
				<td><input type="text" name="stock" id=""></td>
				</tr>
				
				<tr align="center">
				<td style="background-color: pink">state</td>
				<td><input type="text" name="state" id=""></td>
				</tr>
				
				<tr align="center">
				<td style="background-color: pink">describe</td>
				<td><input type="text" name="describe" id=""></td>
				</tr>		
						
				<tr align="center">
				<td colspan="2"><input type="submit" value="Commit"></td>
				</tr>
				
		</table>
	</form>
</body>
</html>