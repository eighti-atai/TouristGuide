'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'Payment',
        record :{id:{patientId:'', treatmentId:'', paymentNo:''},paymentDate:null, paymentType:'',paymentMethod:'',amount:'',chequeNo:'',chequeExpDate:'',chequeBank:'',objid:null},
        emptyRecord :emptyRecord,
        lov :{id:{patientId: 'Patient',treatmentId: 'Treatment'}},
        lovRecord:{patientId:{patientId:'',patientName:'',patientAddress:'',patientIdNo:'',patientBirthDate:null,patientContactNo:'',patientGender:'',objid:null}, treatmentId:{id:{treatmentId:'',patientId:''} , mttId:'', sttId:'',treatmentDesc:'', treatmentStat:'', treatmentPaidStat:'', treatmentDate:'',treatmentAmount:'',treatmentDiscount:'',treatmentTotal:'',treatmentPaid:'',treatmentImage:null,objid:null}},
        lovTitles :{patientId: 'Patient',treatmentId: 'Treatment'}
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{patientId:'', treatmentId:'', paymentNo:''},paymentDate:null, paymentType:'',paymentMethod:'',amount:'', chequeNo:'',chequeExpDate:'',chequeBank:'',objid:null};
    }	
}]);/**
 * 
 */