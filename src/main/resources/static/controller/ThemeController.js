app.factory("ThemeFactory" , function($http,$q) {
	var factory = {
		
		listes : function() {
			
			var deferred = $q.defer();
			
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/theme'
			   }).then(function (success){
				   factory.res = success.data;
				   deferred.resolve(factory.res);
			   },function(error){
				   deferred.reject("deferred.reject");
			   });
			
			return deferred.promise;
		},
	
		theme : function(id) {
			
			var deferred = $q.defer();
			
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/theme/'+id
			   }).then(function (success){
				   factory.res = success.data;
				   deferred.resolve(factory.res);
			   },function(error){
				   deferred.reject("deferred.reject");
			   });
			
			return deferred.promise;
			
		},
		ajouter : function(theme) {
			
			console.log(theme);
			
			var deferred = $q.defer();
			$http({
			      method: 'POST',
			      headers: {'Content-Type': 'application/json'},
			      url: 'http://localhost:8080/theme',
			      data: theme 
			   }).then(function (success){
				   factory.res = success.data;
				   deferred.resolve(factory.res);
			   },function(error){ 
				   deferred.reject("deferred.reject");
			});
			
			return deferred.promise;
		},
		
		supprimer : function(id) {
			var deferred = $q.defer();
			
			$http({
		  	      method: 'DELETE',
		  	      url: 'http://localhost:8080/theme/'+id
		  	   	}).then(function (success){
		  	   		factory.res = success.data;
				    deferred.resolve(factory.res);
		  	   	},function(error){
		  	   		deferred.reject("deferred.reject");
		  	   	});
			
			return deferred.promise;
		},
		modifier : function(nouveauTheme,id) {
			
			var deferred = $q.defer();
			
			$http({
		  	      method: 'PUT',
		  	      headers: {'Content-Type': 'application/json'},
			      url: 'http://localhost:8080/theme/'+id,
			      data: nouveauTheme
		  	   	}).then(function (success){
		  	   		factory.res = success.data;
				    deferred.resolve(factory.res);
		  	   	},function(error){
		  	   		deferred.reject("deferred.reject");
		  	   	});
			
			return deferred.promise;
		}
			
	}
	return factory;
});
/**********************************************************************************************************************************************************************/
app.controller("ThemeController",["$scope","$http","ThemeFactory",function($scope,$http,ThemeFactory) {
	
}]);