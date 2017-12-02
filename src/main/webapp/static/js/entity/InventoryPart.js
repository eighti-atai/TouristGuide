'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'InventoryPart',
        record :{invPartNo:'', description:'', uomId:'', reorderLevel:'', safetyStockLevel:'', category:'', objid:null},
        emptyRecord :emptyRecord,
        lov :{category: 'PartCategory'},
        lovTitles :{category: 'Inventory Part Category'} 
    };
    return entityRec;
    
    function emptyRecord() {
        return {invPartNo:'', description:'', uomId:'', reorderLevel:'', safetyStockLevel:'', category:'', objid:null};
    }	
}]);