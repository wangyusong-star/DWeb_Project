<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户信息</title>
</head>
<body>
<form action="/OnlineShopping/AChangeInfo" method="post">
		<table border="1" align="center" width="0.2">
			<tr
				style="background-color: yellow; color: white; font-size = 20px; font-weight: bold; text-align: center">
				<td colspan="2"><b>InfoChange</b></td>
				
				</tr>
				<tr align="center">
				<td style="background-color: pink">Please print your UserName</td>
				<td><input type="text" name="username" id=""></td>
				</tr>
				
				<tr align="center">
				<td style="background-color: pink">Please print your new Password</td>
				<td><input type="password" name="pwd" id=""></td>
				</tr>

				<tr align="center">
				<td colspan="2"><input type="submit" value="Commit"></td>
				</tr>
				
		</table>
	</form>
</body>
</html>