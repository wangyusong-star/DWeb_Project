<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/register.css">
<title>register</title>
</head>
<body>
	<form action="/OnlineShopping/ARegist" method="post">
				<label for="fname">UserRegister</label><br />
				<input type="text" name="username" id="fname" placeholder="please set up your username"><br />
				<label for="lname">Password</label><br />
				<input type="password" name="pwd" id="lname" placeholder="please set up your password"><br />
				<label for="passwd">VerificatePassword</label><br />
				<input type="password" name="again_pwd" id="passwd" placeholder="please input your password again"><br />
				<label for="lname">Choose a Character for You</label><br/>
		    	<a>customer--></a><input type="checkbox" id="choosecustomer" name="customer"><a>businessman--></a>
		    	<input type="checkbox" id="choosebusinessman" name="businessman"><br/>
				<input type="submit" value="Regist">
	</form>
</body>
</html>