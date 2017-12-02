'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){
    var entityRec = {
        name   :'TmpAppointment',
        record :{appointmentId:'',patientId:null,orgAppoinmentId:null,name:'',date:'',time:'',doctor:'',code:'',contactNo:'',contactNo2:'',contactNoFo:'',objid:null},
        emptyRecord :emptyRecord,
        lov :{doctor: 'DoctorLov'},
        lovRecord:{doctor:{doctor:'',userName:''}},
        lovTitles :{doctor: 'Doctors'} ,
        blurList : ['date','time','doctor']
    };
    return entityRec;
    
    function emptyRecord() {
        return {appointmentId:'',patientId:null,orgAppoinmentId:null,name:'',date:'',time:'',doctor:'',code:'',contactNo:'',contactNo2:'',contactNoFo:'',objid:null};
    }
    
}]);/**
 * 
 */
