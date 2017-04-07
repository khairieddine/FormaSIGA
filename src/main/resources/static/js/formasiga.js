var app = angular.module('formasiga',['ngMaterial','ui.router','ngMessages']);

app.config(function($stateProvider, $urlRouterProvider) {

	  $urlRouterProvider.otherwise("login");
 
	  $stateProvider
	  .state('login', {
	      url: "",
	      templateUrl: "/login",
	      controller: "loginController"
	    })
	    .state('inscription', {
	      url: "",
	      templateUrl: "/inscription",
	      controller: "inscriptionController"
	    })
	    .state('images', {
	      url: "",
	      templateUrl: "/images",
	      controller: "imagesController"
	    })
	});

app.controller("imagesController",["$scope","$http",function($scope,$http) {
	
	

}]);

app.controller("menu",["$scope","$http",function($scope,$http) {
	
	$scope.currentNavItem = 'login';

}]);

app.controller("loginController",["$scope","$http",function($scope,$http) {

	console.log("loginController");
	
//	 $http({
//	      method: 'GET',
//	      url: 'http://localhost:8080/employe/listesEmployes'
//	   }).then(function (success){
//		   
//		   $scope.listesEmployes = success.data;
//
//	   },function(error){
//
//	   });
}]);

app.controller("inscriptionController",["$scope","$http",function($scope,$http) {

	$scope.showHints = false;
	$scope.villes = ["Jendouba","Bizerte","Tunis"];
	$scope.etat = ["Célibataire","Marié(e)","Divorcé(e)","Veuf/veuve"]
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
