<meta charset="utf-8" />
<md-content layout="column" class="md-no-momentum">

    <md-input-container class="md-icon-float md-block">
      <label>Nom</label>
      <md-icon  style="display:inline-block;"><i class="fa fa-camera-retro fa-2x"></i></md-icon>
      <input ng-model="user.name" type="text">
    </md-input-container>
    
    <md-input-container class="md-icon-float md-block">
      <label>Prénom</label>
      <md-icon  style="display:inline-block;"><i class="fa fa-camera-retro fa-2x"></i></md-icon>
      <input ng-model="user.name" type="text">
    </md-input-container>

    <md-input-container md-no-float class="md-block">
      <label>Téléphone</label>
      <input ng-model="user.phone" type="text">
    </md-input-container>

    <md-input-container md-no-float class="md-block">
      <label>Adresse email</label>
      <input ng-model="user.email" type="email" ng-required="true">
    </md-input-container>
    
    <md-input-container md-no-float class="md-block">
      <label>Confirmez votre adresse email</label>
      <md-icon  style="display:inline-block;"><i class="fa fa-camera-retro fa-2x"></i></md-icon>
      <input ng-model="user.email" type="email" ng-required="true">
    </md-input-container>

 </md-content>