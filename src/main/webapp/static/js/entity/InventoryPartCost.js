'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'InventoryPartCost',
        record :{id:{invPartNo:'',invPartCostNo:''},cost:'',quantity:'',objid:null},
        emptyRecord :emptyRecord,
        lov :{id:{invPartNo: 'InventoryPart'}},
        lovRecord:{invPartNo:{invPartNo:'', description:'', uomId:'', reorderLevel:'', safetyStockLevel:'', category:'', objid:null}},
        lovTitles :{invPartNo: 'Inventory Part'}
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{invPartNo:'',invPartCostNo:''},cost:'',quantity:'',objid:null};
    }	
}]);