<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆界面</title>
</head>
<body>
<form action="/OnlineShopping/ALogin" method="post">
		<table border="1" align="center" width="0.2">
			<tr
				style="background-color: lightred; color: white; font-size = 20px; font-weight: bold; text-align: center">
				<td colspan="2"><b>UserRegist</b></td>
				
				</tr>
				<tr align="center">
				<td>UserName</td>
				<td><input type="text" name="username" id=""></td>
				</tr>
				
				<tr align="center">
				<td>Password</td>
				<td><input type="password" name="again_pwd" id=""></td>
				</tr>

				<tr align="center">
				<td colspan="2"><input type="submit" value="Regist"></td>
				</tr>
				
		</table>
	</form>
</body>
</html>