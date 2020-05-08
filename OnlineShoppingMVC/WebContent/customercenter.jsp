<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.top{
	height: 35px;
    width:100%;
	margin-top:50px;
    margin-left:0;
    background:#f66;
    top: 0;
    margin-bottom: 5px;
}
.top ul{
    width: auto;
    list-style-type: none;
    white-space:nowrap;
    overflow: hidden;
    margin-left: 20%;
    padding: 0;

}
.top li {
    float:left;  
    margin-right:2%;
    position: relative;
    overflow: hidden;
}

.top li a{
    display: block;
    color:white;
    text-align: center;
    padding: 3px;
    overflow: hidden;
    text-decoration: none;
    
}
.top li a:hover{
	color:#F66;
    background-color: #FC0;
}
.top ul li ul{
    margin-left: -0.2px;
    background:#F99;
    position: relative;
    display: none; 

}
.top ul li ul li{
    float:none;
    text-align: center;
}
.top ul li:hover ul{
    display: block;
}
</style>
</head>
<body>
<div>
	<h1>Customer Home</h1>
</div>
<div class="top">
	<center> 
	<ul>
		<li><a href="clothes.jsp"><b>Customer Options:</b></a>
        </li>
        
		<li><a herf="updatecustomerinfo.jsp"><b>Update my information</b></a>
        </li>
		
        <li><a href="addcustomermoney.jsp"><b>Recharge</b></a>
        </li>
        
		<li><a href="addgoodsintoshoppingcar"><b>My Shopping Car</b></a>
        </li>
               
        <li><a href="buygoods.jsp"><b>Buy</b></a>
        </li>
	</ul>
	</center>      
</div>
<div>
	<center>
	   <img src="pic/customercenter/background.jpg">
	</center>
</div>
</body>
</html>