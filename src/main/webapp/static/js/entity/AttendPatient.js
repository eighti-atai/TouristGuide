'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'AttendPatient',
        record :{id:{attendPatientId:'',patientId:''} ,doctor:'',startTime:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{attendPatientId:'',patientId:''} ,doctor:'',startTime:'',objid:null};
    }	
}]);/**
 * 
 */
