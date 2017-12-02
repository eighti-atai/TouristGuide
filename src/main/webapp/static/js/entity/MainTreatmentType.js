'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'MainTreatmentType',
        record :{mttId:'',mttName:'',mttDescription:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {mttId:'',mttName:'',mttDescription:'',objid:null};
    }	
}]);/**
 * 
 */
