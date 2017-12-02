'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'Patient',
        record :{patientId:'',patientName:'',patientAddress:'',patientIdNo:'',patientBirthDate:null,patientContactNo:'',patientGender:'',email:'',contactNo2:'',contactNoFo:'',title:'',objid:null},
        emptyRecord :emptyRecord,
        lov :{doctor: 'DoctorLov'},
        lovRecord:{doctor:{doctor:'',userName:''}},
        lovTitles :{doctor: 'Doctors'}
    };
    return entityRec;
    
    function emptyRecord() {
        return {patientId:'',patientName:'',patientAddress:'',patientIdNo:'',patientBirthDate:null,patientContactNo:'',patientGender:'',email:'',contactNo2:'',contactNoFo:'',title:'',objid:null};
    }	
}]);/**
 * 
 */
