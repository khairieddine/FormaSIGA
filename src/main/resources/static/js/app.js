var app = angular.module('app',['ngMaterial','ui.router','ngMessages']);

app.config(function($stateProvider, $urlRouterProvider) {

	   //$urlRouterProvider.otherwise("listeEtablissements");
 
	   $stateProvider
	   .state('listeEmployesInformations', {
		      url: "listeEmployesInformations",
		      templateUrl: "vues/informationsEmployesLister.html",
		      controller: "listeEmployesInformationsController"
	    })
	    .state('statistiquesInformations', {
		      url: "statistiquesInformations",
		      templateUrl: "vues/informationsStatistiques.html",
		      controller: "statistiquesInformationsController"
	    })
/***********************************************************************************************************************************************/
	   .state('listeEtablissements', {
	      url: "listeEtablissements",
	      templateUrl: "vues/etablissementsLister.html",
	      controller: "EtablissementController"
	    })
	    .state('ajouterEtablissement', {
	      url: "ajouterEtablissement",
	      templateUrl: "vues/etablissementAjouter.html",
	      controller: "EtablissementController"
	    })
	    .state('gererEtablissements', {
	      url: "gererEtablissements",
	      templateUrl: "vues/etablissementsGerer.html",
	      controller: "EtablissementController"
	    })
/***********************************************************************************************************************************************/
	    .state('listeFormations', {
	      url: "listeFormations",
	      templateUrl: "vues/formationsLister.html",
	      controller: "listeFormationsController"
	    })
	    .state('listeParticipants', {
	      url: "listeParticipants",
	      templateUrl: "vues/formationsParticipantsLister.html",
	      controller: "listeParticipantsController"
	    })
	    .state('nouvelleFormation', {
	      url: "nouvelleFormation",
	      templateUrl: "vues/formationsNouvelle.html",
	      controller: "nouvelleFormationController"
	    })
	    .state('gererFormations', {
	      url: "gererFormations",
	      templateUrl: "vues/formationsGerer.html",
	      controller: "gererFormationsController"
	    })
	    .state('planifierDates', {
	      url: "planifierDates",
	      templateUrl: "vues/formationsPlanifierDates.html",
	      controller: "planifierDatesController"
	    })
	    .state('envoiConvocations', {
	      url: "envoiConvocations",
	      templateUrl: "vues/formationsEnvoiConvocations.html",
	      controller: "envoiConvocationsController"
	    })
	    .state('parametreFormation', {
	      url: "parametreFormation",
	      templateUrl: "vues/formationParametre.html",
	      controller: "parametreFormationController"
	    })
/***********************************************************************************************************************************************/
	    .state('listeThemes', {
	      url: "listeThemes",
	      templateUrl: "vues/themesLister.html",
	      controller: "ThemeController"
	    })
	    .state('nouveauTheme', {
	      url: "nouveauTheme",
	      templateUrl: "vues/themeNouveau.html",
	      controller: "ThemeController"
	    })
	    .state('gererThemes', {
	      url: "gererThemes",
	      templateUrl: "vues/themesGerer.html",
	      controller: "ThemeController"
	    })
/***********************************************************************************************************************************************/
	    .state('listeQuestions', {
	      url: "listeQuestions",
	      templateUrl: "vues/questionsLister.html",
	      controller: "listeQuestionsController"
	    })
	    .state('nouvelleQuestion', {
	      url: "nouvelleQuestion",
	      templateUrl: "vues/questionNouvelle.html",
	      controller: "nouvelleQuestionController"
	    })
	    .state('gererQuestions', {
	      url: "gererQuestions",
	      templateUrl: "vues/questionsGerer.html",
	      controller: "gererQuestionsController"
	    })
	    .state('resultatStatestiqueQestions', {
	      url: "resultatStatestiqueQestions",
	      templateUrl: "vues/questionsResultatStatestique.html",
	      controller: "resultatStatestiqueQestionsController"
	    })
});
/***********************************************************************************************************************************************/
app.factory("GlobalFactory" , function() {
	var factory = {
			villes : ["Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","La Manouba","Le Kef","Mahdia","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan"],
			validation : {
				nom : ""
			}
	}
	return factory;
});
app.controller("lanceur",["$rootScope","$scope","GlobalFactory",function($rootScope,$scope,GlobalFactory) {
	
	$scope.mini = false;
	
	$scope.changerMenu = function() {
		$scope.mini = ($scope.mini) ? false : true;
	}
	
	$rootScope.villes = GlobalFactory.villes;
	$rootScope.validation = GlobalFactory.validation;
	console.log($rootScope.validation);
}]);

app.controller("menu",["$scope","$rootScope","$http","$location",function($scope,$rootScope,$http,$location) {
	
	$rootScope.identifiant = null;
	$rootScope.avatar = null;
	$scope.menu = {};
	
	$http({
	      method: 'GET',
	      url: 'http://localhost:8080/menu'
	   }).then(function (success){
		   $rootScope.identifiant = success.data.identifiant;
		   $rootScope.avatar = success.data.avatar;
		   $scope.menu = success.data.menu;
		   console.log($scope.menu);

	   },function(error){

	   });
	
	$scope.getClass = function (path) {
		return ($location.path().substr(1, path.length) === path) ? 'activeItemSousMenu' : '';
	}
	
}]);

app.controller("itemMenu",["$scope",function($scope) {
	
	$scope.activeItem = true;
	$scope.activeItemMenu = function() {
		$scope.activeItem = ($scope.activeItem) ? false : true;
	}
}]);

app.controller("menuOption", function ($scope, $timeout, $mdSidenav) {
	
    $scope.toggleLeft = buildToggler('left');
    $scope.toggleRight = buildToggler('right');

    function buildToggler(componentId) {
      return function() {
        $mdSidenav(componentId).toggle();
        console.log($mdSidenav);
      };
    }
    
    $scope.close = function () {
        $mdSidenav(componentId).close();
      };
});