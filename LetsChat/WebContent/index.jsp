<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>
	<script src="MyRouteConfig.js"></script>
<title>Insert title here</title>
</head>
<body ng-app="myApp">
<table width="70%" align="center">
<tr bgcolor="cyan">
<td colspan="2">LetsChat</td></tr>
<tr bgcolor="pink">
<td>
<br><br><br>
<a href="#/Home">Home</a>
<a href="#/Login">Login</a>
<a href="#/Register">Register</a>
<a href="#/blog">Blog</a>
<br><br><br></td>
<td><div ng-view></div></td>
</table>
</body>
</html>