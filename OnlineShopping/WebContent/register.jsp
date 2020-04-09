<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面</title>
</head>
<body>
<form action="/OnlineShopping/ARegist" method="post">
		<table border="1" align="center" width="0.2">
			<tr
				style="background-color: lightgreen; color: white; font-size = 20px; font-weight: bold; text-align: center">
				<td colspan="2"><b>UserRegist</b></td>
				
				</tr>
				<tr align="center">
				<td style="background-color: skyblue">UserName</td>
				<td><input type="text" name="username" id=""></td>
				</tr>
				
				<tr align="center">
				<td style="background-color: skyblue">Password</td>
				<td><input type="password" name="pwd" id=""></td>
				</tr>
				
				<tr align="center">
				<td style="background-color: skyblue">ConfirmPassword</td>
				<td><input type="password" name="again_pwd" id=""></td>
				</tr>

				<tr align="center">
				<td colspan="2"><input type="submit" value="Regist"></td>
				</tr>
				
		</table>
	</form>
</body>
</html>