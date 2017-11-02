/* 
 * File 	: ./server/http_server.js
 * Author(s)	: Zidmann
 * Function 	: This file defines the main functions of the NodeJS module for managing REST webservice
 * Note		: mongoose - refers to the mongoose module used to communicate with Mongo database
 * Version  	: 1.1.0
 */

var	error_handler    = require('core')('SERVICE_ERROR_HANDLER'),
	http_server      = require('core')('HTTP_SERVER_BASICS'),

	common    = require('./common.js'),
	findError = require('./errors/referential.js');


function dynamicExport(mongoose){

	//Definition of the configuration and the interceptors
	var conf         = null;
	var interceptors = null;

	//Setup function
	function setupFunc(conf_param, routes, interceptors_param){
		conf=conf_param;
		interceptors=interceptors_param;

		// define et return the HTTP server
		return common.setup(conf, mongoose, routes, "HTTP");
	}

	//Start function
	function startFunc(app, callback){
		// if no matching api
		app.use('/api', function(req, res, next){
			next(findError("WSCORE.1.1.1"));
		});

		// error handler
		app.use(function(err, req, res, next){
			error_handler(req, res, err, {name : conf.service.name, version : conf.service.version, interceptors : interceptors});
		});

		http_server.start(app, { host : conf.http.host, port : conf.http.port} , callback);
	}

	//Stop function
	function stopFunc(callback){
		http_server.stop(callback);
	}

	return{
		start : startFunc,
		stop  : stopFunc,
		setup : setupFunc
	};
}


module.exports = dynamicExport;
