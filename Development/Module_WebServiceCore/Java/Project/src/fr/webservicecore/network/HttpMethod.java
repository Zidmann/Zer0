package fr.webservicecore.network;

/*
 * Copyright 2015-2017 Emmanuel ZIDEL-CAUFFET
 *
 * This class is used in a project designed by some Ecole Centrale de Lille students.
 * This program is distributed in the hope that it will be useful.
 * 
 * It is a free code: you can redistribute it and/or modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation, either Version 3 of the License.
 *
 * However the source code is distributed without any warranty
 * See the GNU General Public License for more details.
 *
 */


/**
 * The different methods of HTTP request (GET, POST, PUT, DELETE)
 * @author Zidmann (Emmanuel ZIDEL-CAUFFET)
 * @version 1.1.0
 */
public enum HttpMethod
{
	/**
	 * The GET method requests a representation of the specified resource
	 */
	GET,

	/**
	 * The POST method requests that the server accept the entity enclosed in the request as a new subordinate of the web resource identified by the URI
	 */
	POST,

	/**
	 * This POST method is used to send a file
	 */
	POSTfile,

	/**
	 * The PUT method requests that the enclosed entity be stored under the supplied URI
	 */
	PUT,

	/**
	 * The DELETE method deletes the specified resource
	 */
	DELETE
}