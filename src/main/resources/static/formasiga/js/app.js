var app = angular.module('app',['ngMaterial','ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {

	  $urlRouterProvider.otherwise("listes");
 
	  $stateProvider
	  .state('listes', {
	      url: "",
	      templateUrl: "vues/listesEmployes.jsp",
	      controller: "listesEmployesController"
	    })
	    .state('inscription', {
	      url: "",
	      templateUrl: "vues/inscription.jsp",
	      controller: "inscriptionEmployeController"
	    })
	    .state('login', {
	      url: "",
	      templateUrl: "vues/login.jsp",
	      controller: "loginController"
	    });
	});

app.controller("menu",["$scope","$http",function($scope,$http) {
	
	$scope.currentNavItem = 'login';

}]);

app.controller("listesEmployesController",["$scope","$http",function($scope,$http) {
	
	$scope.listesEmployes = null;
	
	 $http({
	      method: 'GET',
	      url: 'http://localhost:8080/employe/listesEmployes'
	   }).then(function (success){
		   
		   $scope.listesEmployes = success.data;

	   },function(error){

	   });
}]);

app.controller("inscriptionEmployeController",["$scope","$http",function($scope,$http) {

//	$scope.prieres = null;
//	$scope.ajouter = function() {
//		console.log($scope.prieres);
//		$http({
//		      method: 'POST',
//		      headers: {'Content-Type': 'application/json'},
//		      url: 'http://localhost:8080/khairieddine/prieres',
//		      data: $scope.prieres
//		   }).then(function (success){
//			   
//			
//		   },function(error){
//
//		});
//		
//	}
	
	 
	 
}]);

app.controller("loginController",["$scope","$http",function($scope,$http) {
}]);
