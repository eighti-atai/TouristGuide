
        
        angular.module('generalModule').filter('startFrom', function() {
            return function(input, start) {
            	if (!angular.isArray(input)) {
                    return [];
                }
                start = +start; //parse to int
                return input.slice(start);
            }
        });