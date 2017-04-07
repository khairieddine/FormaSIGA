var app = angular.module('app',['ngMaterial','ui.router','ngMessages']);

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
	});

app.controller("menuPage", function ($scope, $timeout, $mdSidenav) {
	
    $scope.toggleLeft = buildToggler('left');
    $scope.toggleRight = buildToggler('right');

    function buildToggler(componentId) {
      return function() {
        $mdSidenav(componentId).toggle();
      };
    }
});

app.controller("lanceur",["$scope","$http",function($scope,$http) {
	
	$scope.changerMenu = function() {
		
	}
	
}]);

app.controller("menuP",["$scope","$http",function($scope,$http) {
	
	$scope.menu = {};
	
	$http({
	      method: 'GET',
	      url: 'http://localhost:8080/menu'
	   }).then(function (success){
		   
		   $scope.menu = success.data.menu;
		   console.log($scope.menu);

	   },function(error){

	   });

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
