'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'ReportRecInvoicePatientTreatment',
        record :{formName:'', patientId:'', treatmentId:''}
        };
    return entityRec;
    
    function emptyRecord() {
        return {formName:'invoice', patientId:'', treatmentId:''};
    }	
}]);

