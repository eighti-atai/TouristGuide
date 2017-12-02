
'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){
    var entityRec = {
        name   :'AppointmentsDate',
        record :{appointmentId:'',patientId:null,orgAppoinmentId:null,name:'',date:null,time:'',doctor:null,code:'',objid:null},
        emptyRecord :emptyRecord,
    };
    return entityRec;
    
    function emptyRecord() {
        return {appointmentId:'',patientId:null,orgAppoinmentId:null,name:'',date:null,time:'',doctor:null,code:'',objid:null};
    }
    
}]);/**
 * 
 */

