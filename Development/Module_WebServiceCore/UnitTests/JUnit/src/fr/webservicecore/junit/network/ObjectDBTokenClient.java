package fr.webservicecore.junit.network;

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


import java.util.Vector;

import fr.webservicecore.junit.object.ObjectDB;
import fr.webservicecore.error.APIException;

/**
 * Example of WebService client to test NodeJS module named 'WebServiceCore' using the token transmission
 * <p>
 * This class extends the ObjectDBClient to adapt the HTTP address reached by the client
 * </p>
 * @author Zidmann (Emmanuel ZIDEL-CAUFFET)
 * @version 1.1.0
 */
public class ObjectDBTokenClient extends ObjectDBClient
{ 	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//ObjectDB FUNCTIONS
    // HTTP GET requests

	/**
     * Get the list of all the objectDB elements
     * @return The objects found
	 * @throws APIException Exception returned by the application
     */
    public Vector<ObjectDB> getAllObjectDB() throws APIException{
    	String http_address=this.getURL()+"/api/objectToken";
		if(this.getToken()!=null && !this.getToken().equals("")){
			http_address+="?token="+this.getToken();
		}
		return getAllObjectDBAuxi(http_address);
    }

    /**
     * Get information of one specific objectDB element
     * @param id The id of the expected object
     * @return The object found
	 * @throws APIException Exception returned by the application
     */
	public ObjectDB getOneObjectDB(String id) throws APIException{
		if(id==null || id.equals("")){
			return null;
		}
		String http_address=this.getURL()+"/api/objectToken/"+id;
		if(this.getToken()!=null && !this.getToken().equals("")){
			http_address+="?token="+this.getToken();
		}
		return getOneObjectDBAuxi(http_address);
    }


	// HTTP POST request

	/**
     * Create an objectDB element on the Node JS server
     * @return The object created
	 * @throws APIException Exception returned by the application
     */
	public ObjectDB createObjectDB() throws APIException{
		String http_address=this.getURL()+"/api/objectToken";
		if(this.getToken()!=null && !this.getToken().equals("")){
			http_address+="?token="+this.getToken();
		}
		return this.createObjectDBAuxi(http_address);
	}

	/**
     * Update all the objectDB elements on the Node JS server
	 * @throws APIException Exception returned by the application
     */
	public void updateObjectDB() throws APIException{
		String http_address=this.getURL()+"/api/objectToken";
		if(this.getToken()!=null && !this.getToken().equals("")){
			http_address+="?token="+this.getToken();
		}
		this.updateObjectDBAuxi(http_address);
	}


	// HTTP DELETE request

	/**
     * Delete all objectDB elements
	 * @throws APIException Exception returned by the application
     */
	public void deleteObjectDB() throws APIException{
		String http_address=this.getURL()+"/api/objectToken";
		if(this.getToken()!=null && !this.getToken().equals("")){
			http_address+="?token="+this.getToken();
		}
		this.deleteObjectDBAuxi(http_address);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
}