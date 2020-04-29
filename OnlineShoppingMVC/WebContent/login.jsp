<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>login</title>
</head>
<body>
	<font style="font-size:40px">welcome to our </font><br/>
	&ensp;&ensp;&ensp;&ensp;<font style="font-size:80px">ONLINE SHOPPING~</font>
		 <form  action="/OnlineShoppingMVC/ALogin" method="post">
		    <label for="fname">User</label><br/>
		    <input type="text" id="fname" name="username" placeholder="please input your username"><br/>		
		    <label for="lname">Password</label><br/>
		    <input type="password" id="lname" name="pwd" placeholder="please input your password"><br/>
		    <label for="lname">Choose a Character for You</label><br/>
		    <a>customer--></a><input type="checkbox" id="choosecustomer" name="customer"><a>businessman--></a><input type="checkbox" id="choosebusinessman" name="businessman"><br/>
		    <input type="submit" value="login">
		    <a href="#">forget password?</a>&ensp;&ensp;&ensp;
		    <a href="register.jsp">regist</a><br/>
  		</form>	
</body>
</html>