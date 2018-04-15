var myApp = angular.module("myApp", [ 'ngRoute'])
            myApp.config(function($routeProvider) {
	console.log('I am in routeProvider');
	$routeProvider.when("/", {
		templateUrl : "index.jsp"
	/*}).when("/Login", {
		templateUrl : "C_User/Login.html"
	}).when("/Register", {
		templateUrl : "template/Register.html"
	}).when("/ContactUs", {
		templateUrl : "template/ContactUs.html"
	}).when("/AboutUs", {
		templateUrl : "template/AboutUs.html"*/
	}).when("/blog", {
		templateUrl : "c_blog/blog.html",
		
	}).when("/UpdateBlog", {
		templateUrl : "c_blog/updateblog.html"})
	
});