/* 
 * File 	: ./tokens/token_objDB.js
 * Author(s)	: Zidmann
 * Function 	: Script to describe a token to test the webservicecore module for normal actions
 * Version  	: 1.0.0
 */

//Define all necessary requirements
var 	jwt	 = require('jwt-simple'),
	Token 	 = require('toolbox')('TOKEN')(jwt);


//Definition of the token and all its properties
var token    = new Token();

//HERE - ADAPT THE DEFINITION IN FUNCTION OF YOUR NEEDS
token.source_ip      = '127.0.0.1';
token.source_service = 'JunitTests';
token.dest_service   = 'Webservicecore_Testing';
token.end_date       = new Date();
token.access         = ['GET', 'GETid', 'POST', 'PUT', 'DELETE'];

module.exports = {name	: 'token_objDB',
		  token : token,
		  action: 'hash'};
