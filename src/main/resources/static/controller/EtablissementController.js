app.factory("EtablissementFactory" , function($http,$q) {
	var factory = {
		
		listes : function() {
			
			var deferred = $q.defer();
			
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/etablissement'
			   }).then(function (success){
				   factory.res = success.data;
				   deferred.resolve(factory.res);
			   },function(error){
				   deferred.reject("deferred.reject");
			   });
			
			return deferred.promise;
		},
	
		etablissement : function(id) {
			
			var deferred = $q.defer();
			
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/etablissement/'+id
			   }).then(function (success){
				   factory.res = success.data;
				   deferred.resolve(factory.res);
			   },function(error){
				   deferred.reject("deferred.reject");
			   });
			
			return deferred.promise;
			
		},
		ajouter : function(etablissement) {
			
			console.log(etablissement);
			
			var deferred = $q.defer();
			$http({
			      method: 'POST',
			      headers: {'Content-Type': 'application/json'},
			      url: 'http://localhost:8080/etablissement',
			      data: etablissement 
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
		  	      url: 'http://localhost:8080/etablissement/'+id
		  	   	}).then(function (success){
		  	   		factory.res = success.data;
				    deferred.resolve(factory.res);
		  	   	},function(error){
		  	   		deferred.reject("deferred.reject");
		  	   	});
			
			return deferred.promise;
		},
		modifier : function(nouveauEtablissement,id) {
			
			var deferred = $q.defer();
			
			$http({
		  	      method: 'PUT',
		  	      headers: {'Content-Type': 'application/json'},
			      url: 'http://localhost:8080/etablissement/'+id,
			      data: nouveauEtablissement
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
app.controller("EtablissementController",["$scope","$mdDialog","EtablissementFactory","GlobalFactory",function($scope,$mdDialog,EtablissementFactory,GlobalFactory) {

	$scope.loading = true;
	$scope.listeEtablissements = EtablissementFactory.listes().then(function(data){
		$scope.listeEtablissements = data;
		$scope.loading = false;
	},function(){
	});
	
	$scope.etablissement = {};
	$scope.ajouter = function() {
		$scope.etb = EtablissementFactory.ajouter($scope.etablissement).then(function(data){
			console.log(data);
		},function(){
		});
	};
	
	$scope.supprimerDialog = function(ev,id,index) {
		var confirm = $mdDialog.confirm()
			.title('Supprimer létablissement')
			.textContent("Souhaitez-vous vraiment supprimer létablissement ?")
			.ariaLabel("Supprimer létablissement")
			.targetEvent(ev)
			.clickOutsideToClose(true)
			.ok('Supprimer')
			.cancel("Annuler");
		$mdDialog.show(confirm).then(function() {
			
			$scope.etb = EtablissementFactory.supprimer(id).then(function(data){
			console.log($scope.listeEtablissements);
			
				$scope.listeEtablissements.splice(index, 1);
				
				},function(){
					
			    });
		    }, function() {
		});
	};

	$scope.modifierDialog = function(ev,id,index) {	

	    $mdDialog.show({
	    	multiple: true,
	    	controller: DialogController,
	    	/*contentElement: "#modifierDialogTemp",*/
	    	templateUrl: "vues/etablissementModifier.html",
	    	parent: angular.element(document.body),
	    	targetEvent: ev,
	    	clickOutsideToClose: true,
	        fullscreen: true,
	        locals: {
	        	id : id,
	        	index : index
	        }
	    })
	    .then(function() {

	    	$scope.nouveauEtablissement = EtablissementFactory.etablissement(id).then(function(data){
	    		$scope.nouveauEtablissement = data;
	    		$scope.listeEtablissements[index] = data;
			},function(){
			});

	      }, function() {

	    });
	    
	    function DialogController($scope, $mdDialog,id,index) {	
	    	
	    	$scope.nouveauEtablissement = EtablissementFactory.etablissement(id).then(function(data){
	    		$scope.nouveauEtablissement = data;
				console.log($scope.etablissementModifier);
			},function(){
			});
	    	
	    	$scope.nouveauEtablissement = {};
	    	$scope.villes = GlobalFactory.villes;;
			console.log("DialogController");
			
			$scope.hide = function() {
				$mdDialog.hide();
			};

			$scope.cancel = function() {
				$mdDialog.cancel();
			};
			
			$scope.modifier = function() {
				console.log($scope.nouveauEtablissement);
				$scope.res = EtablissementFactory.modifier($scope.nouveauEtablissement,id).then(function(data){
		    		$scope.res = data;
					console.log($scope.res);
					console.log($scope);
				},function(){
				});
				
				$mdDialog.hide();
			};
	    }
	};
}]);