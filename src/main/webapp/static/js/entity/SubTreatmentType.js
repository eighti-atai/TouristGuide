'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'SubTreatmentType',
        record :{id:{sttId:'',mttId:''} , treatmentName:'', treatmentAmount:'', objid:null},
        emptyRecord :emptyRecord,
        lov :{mttId:'MainTreatmentType'},
        lovRecord:{mttId:{mttId:'',mttName:'',mttDescription:''}},
        lovTitles :{mttId: 'Main Treatment Type'},
        lovHeads :{mttId:{mttId:'Main Treatment ID',mttName:'Name',mttDescription:'Description'}}
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{sttId:'',mttId:''} , treatmentName:'', treatmentAmount:'', objid:null};
    }	
}]);

