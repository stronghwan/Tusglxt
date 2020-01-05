<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content=" Master  Login Form Widget Tab Form,Login Forms,Sign up Forms,Registration Forms,News letter Forms,Elements"/>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Cormorant+SC:300,400,500,600,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
</head>

<body>
	<div class="padding-all">
		<div class="header">
			<h1>图书管理系统</h1>
		</div>

		<div class="design-w3l">
			<div class="mail-form-agile">
				<form action="/login" method="post">
					<input type="text" name="username" placeholder="账号" required=""/>
					<input type="password"  name="password" class="padding" placeholder="密码" required=""/>
					<input type="submit" value="登录">
				</form>
			</div>
		  <div class="clear"> </div>
		</div>
		
		<div class="footer">
		
		</div>
	</div>
</body>
</html>