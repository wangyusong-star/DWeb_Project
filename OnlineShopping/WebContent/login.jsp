<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style>
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

form
{
	position:absolute;
	left:1150px;
	top:100px;
}
body
{
	background:url("pic/login/bkd.jpg");
	background-size:1550px 750px;
	background-repeat:no-repeat;
	padding:150px;
}
</style>
</head>
<body>
	<font style="font-size:40px">welcome to our </font><br/>
	&ensp;&ensp;&ensp;&ensp;<font style="font-size:80px">ONLINE SHOPPING~</font>
		 <form  action="/OnlineShopping/ALogin" method="post">
		    <label for="fname">User</label><br/>
		    <input type="text" id="fname" name="username" placeholder="please input your username"><br/>		
		    <label for="lname">Password</label><br/>
		    <input type="password" id="lname" name="pwd" placeholder="please input your password"><br/>
		    <input type="submit" value="login">
		    <a href="#">forget password?</a>&ensp;&ensp;&ensp;
		    <a href="register.jsp">register</a><br/>
  		</form>	
</body>
</html>