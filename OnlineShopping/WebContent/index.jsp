<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Shopping</title>

<link href="css/basic-2.css" rel="stylesheet" type="text/css" />

</head>
<body>
<%String username = request.getParameter("name"); %>
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


<div class="search">
            <input type="text" placeholder="Search for..." name="" id="" value="" />
            <button><i><b>Go</b></i></button>
</div>


<div class="top">
	<center> 
	<ul>
		<li><a href="clothes.jsp"><b>Clothes</b></a>
        <ul>
        <li><a href="clothes.jsp"><b>clothes for man</b></a></li>
        <li><a href="clothes.jsp"><b>clothes for woman</b></a></li>
        <li><a href="clothes.jsp"><b>clothes for child</b></a></li>
        </ul>
        </li>
        
		<li><a><b>Electronic product</b></a>
        <ul>
        <li><a href="/OnlineShopping/ShowGoodsView"><b>computer</b></a></li>
        <li><a href="/OnlineShopping/ShowGoodsView"><b>phone</b></a></li>
        <li><a href="/OnlineShopping/ShowGoodsView"><b>TV</b></a></li>
        </ul>
        </li>
		
        <li><a href="#"><b>Foods</b></a>
        <ul>
        <li><a href="#"><b>vegetable</b></a></li>
        <li><a href="#"><b>meat</b></a></li>
        <li><a href="#"><b>sea food</b></a></li>
        </ul>
        </li>
        
		<li><a href="#"><b>Furnitures</b></a>
        <ul>
        <li><a href="#"><b>table</b></a></li>
        <li><a href="#"><b>chair</b></a></li>
        <li><a href="#"><b>sofa</b></a></li>
        </ul>
        </li>
        
		<li><a href="#"><b>Drugs</b></a>
        <ul>
        <li><a href="#"><b>health products</b></a></li>
        <li><a href="#"><b>healing medicine</b></a></li>
        </ul>
        </li>
		
        <li><a href="books.jsp"><b>Books</b></a>	
		<ul>
		<li><a href="#"><b>books for child</b></a></li>
		<li><a href="#"><b>books for literature</b></a></li>
		</ul>
		</li> 
               
	</ul>
	</center>      
</div>


<div>
	<center>
    <img src="pic/index/phone.png"/>
    </center>
</div>
</body>
</html>