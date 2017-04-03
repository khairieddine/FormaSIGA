
<div ng-controller="AppCtrl" layout="column" style="height:500px;" ng-cloak>

  <section layout="row" flex>

    <md-sidenav
        class="md-sidenav-left"
        md-component-id="left"
        md-is-locked-open="$mdMedia('gt-md')"
        md-whiteframe="4">

      <md-toolbar class="md-theme-indigo">
        <h1 class="md-toolbar-tools">Sidenav Left</h1>
      </md-toolbar>
      <md-content layout-padding ng-controller="LeftCtrl">
        <md-button ng-click="close()" class="md-primary" hide-gt-md>
          Close Sidenav Left
        </md-button>
        <div ng-repeat='e in listesEmployes' hide show-gt-md>
			{{e.nom}}
		</div>
      </md-content>

    </md-sidenav>

    <md-content flex layout-padding>

      <div layout="column" layout-align="top center">
        <p>
        The left sidenav will 'lock open' on a medium (>=960px wide) device.
        </p>
        <p>
        The right sidenav will focus on a specific child element.
        </p>

        <div>
          <md-button ng-click="toggleLeft()"
            class="md-primary" hide-gt-md>
            Toggle left
          </md-button>
        </div>

        <div>
          <md-button ng-click="toggleRight()"
            ng-hide="isOpenRight()"
            class="md-primary">
            Toggle right
          </md-button>
        </div>
      </div>

      <div flex></div>

    </md-content>

    <md-sidenav class="md-sidenav-right md-whiteframe-4dp" md-component-id="right">

      <md-toolbar class="md-theme-light">
        <h1 class="md-toolbar-tools">Sidenav Right</h1>
      </md-toolbar>
      <md-content ng-controller="RightCtrl" layout-padding>
        <form>
          <md-input-container>
            <label for="testInput">Test input</label>
            <input type="text" id="testInput"
                   ng-model="data" md-autofocus>
          </md-input-container>
        </form>
        <md-button ng-click="close()" class="md-primary">
          Close Sidenav Right
        </md-button>
      </md-content>

    </md-sidenav>

  </section>

</div>