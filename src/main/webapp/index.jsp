<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC JDBCTemplate Tutorial</title>
<script type="text/javascript" src="../SpringMVCJDBCTemplateTutorial/static/angular.min.js""></script>
<link rel="stylesheet" href="../SpringMVCJDBCTemplateTutorial/static/style.css" />
</head>
<body>
	<h2>Spring MVC JDBCTemplate Welcome page222</h2>
	<div ng-app="myApp" ng-controller="myCtrl">

<input type="button" ng-click="submit()" value="add"><br>

</div>
</body>
<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
$scope.submit = function(){
$http({
    method: 'POST',
    url: 'users',
    contentType: "application/json",
    data: [{"firstName": "pavan", "lastName": "kumar", "street": "hyd", "city":"Ny", "state":"nizam", "country": "india"}, {"firstName": "pavan1", "lastName": "kumar1", "street": "hyd1", "city":"Ny1", "state":"nizam1", "country": "india1"}]
}).success(function () {
	alert("success");
});
}
});
</script>
</html>