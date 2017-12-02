angular.module('generalModule').directive('unterLov', function(){
	return {
		template:   "<div id='myModal'>" +
					"<div class = 'modal-content'>" +
					"<div class='modal-header'>" +
					"<span class='close' id='lovClose' ng-click='ctrl.lovClose()'>&times;</span>" +
					"<h2>{{ctrl.lovTitle}}</h2>"+
					"</div>" +
					//"<div class = 'close modal-header' id='lovSearch' ng-click='ctrl.lovSearch()'>Search</div>"+
					"<table class='table table-hover'>" +
					"<thead>" +
					"<tr>" +
					"<th bg-color='red' ng-repeat='k in ctrl.LovColumsHeads'>" +
					"<span ng-bind='k'></span>" +
					"</th>" +
					"</tr>" +
					"</thead>" +
					"<tbody>" +
					"<tr ng-repeat='u in ctrl.LovRecords' ng-click='ctrl.setLovValue(u)'>" +
					"<td ng-repeat='a in ctrl.lovColumnHeadsOri'>"+
					"<span ng-bind='u[a]'></span>" +
					"</td>" +
					"</tr>" +
                    "</tbody>" +
                   "</table>" +
                   "</div>" +
                   "</div>"
	};
});