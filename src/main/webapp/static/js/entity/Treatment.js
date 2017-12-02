'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'Treatment',
        record :{id:{treatmentId:'',patientId:''} , patientName:'', mttId:'', sttId:'',treatmentDesc:'', treatmentStat:'', treatmentPaidStat:'', treatmentDate:'',treatmentAmount:'',treatmentDiscount:'',treatmentTotal:'',treatmentPaid:'',treatmentImage:null,objid:null},
        emptyRecord :emptyRecord,
        lov :{patientId: 'Patient',mttId:'MainTreatmentType',sttId:'SubTreatmentType'},
        lovRecord:{patientId:{patientId:'',patientName:'',patientAddress:'',patientIdNo:'',patientContactNo:'',patientGender:''}, mttId:{mttId:'',mttName:'',mttDescription:''},sttId:{id:{sttId:'',mttId:''} , treatmentName:'', treatmentAmount:''}},
        lovTitles :{patientId: 'Patient',treatmentId: 'Treatment',mttId: 'Main Treatment Type',sttId: 'Sub Treatment Type'},
        lovHeads :{patientId:{patientId:'Id',patientName:'Name',patientAddress:'Address',patientIdNo:'ID No',patientContactNo:'Contact No',patientGender:'Gender'},mttId:{mttId:'Id',mttName:'Name',mttDescription:'Description'},sttId:{id:{sttId:'Id',mttId:'Main Treatment Type Id'}, treatmentName:'Name', treatmentAmount:'Amount'}}
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{treatmentId:'',patientId:''} ,patientName:'', mttId:'', sttId:'',treatmentDesc:'', treatmentStat:'', treatmentPaidStat:'', treatmentDate:'',treatmentAmount:'',treatmentDiscount:'',treatmentTotal:'',treatmentPaid:'',treatmentImage:null,objid:null};
    }	
}]);

