'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'Appointment',
        record :{id:{appointmentId:'',patientId:''} ,appointmentDate:'',appointmentTime:'',doctor:'',code:'',objid:null},
        emptyRecord :emptyRecord,
        lov :{doctor: 'DoctorLov'},
        lovRecord:{doctor:{doctor:'',userName:''}},
        lovTitles :{doctor: 'Doctors'} ,
        blurList : ['appointmentDate','appointmentTime','doctor']
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{appointmentId:'',patientId:''},appointmentDate:'',appointmentTime:'',doctor:'',code:'',objid:null};
    }
    
}]);/**
 * 
 */
