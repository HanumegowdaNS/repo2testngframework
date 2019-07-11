var test = require('xml2js');
var test2 = require('lodash');

let run = function (args) {
	
    return new Promise(function (resolve, reject) {
		 
		 
		 var testResult = seleniumFunction();
		 // Environment Status test has 3 resolution paths; If test is rejected for any reason it will be recorded as Unknown status; Alternatively a resolve call with a stringified object containing 'EnvironmentSuccess' as a bool will derive into Online(true) : Offline(false).
		 //The response object can have any other elements for inclusion in the log but will have no other effect.
		 var response = JSON.stringify({EnvironmentSuccess : testResult});
		 
		 //Test Online / Offline path
		 resolve(response);
		 
		 //Test Unknown path
		 // reject();
		 
    });
};


let seleniumFunction = function(){

	return true; //false	
}


module.exports = {
    run: run
};