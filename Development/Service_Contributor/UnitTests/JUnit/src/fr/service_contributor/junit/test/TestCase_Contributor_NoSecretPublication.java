package fr.service_contributor.junit.test;

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


import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import fr.service_contributor.Common;
import fr.service_contributor.object.Contributor;
import fr.service_contributor.junit.model.TestCase_Model;
import fr.core.network.HttpCommunication;

/**
 * This class contains the webService client JUnit tests to check if the IP (creatorIP, updatorIP) are not shown when data are extracted from Contributor service
 * <p>
 * This Test Case supposes that you started the NodeJS server and removed all the Contributor elements in the MongoDB database
 * </p>
 * @author Zidmann (Emmanuel ZIDEL-CAUFFET)
 * @version 1.1.0
 */
public class TestCase_Contributor_NoSecretPublication extends TestCase_Model
{
	protected Gson 					gson  	      = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
	protected String 				response  	  = null;

	protected Contributor 	contributor =null;

	@Test
	public void testSecretGetAllContributorsRequest() throws Exception{
		initSettings();

		//Creation of one contributor
		contributor = ws_client.createContributor("login", "creator");

    	String http_address = Common.URL+"/api/contributor";
		@SuppressWarnings("static-access")
		String token 	   = token_list.getToken("token_contributor");
		if(token!=null && !token.equals("")){
			http_address+="?token="+token;
		}
		String response = HttpCommunication.getInstance().sendGet(http_address);

		//Deletion of the contributor
		ws_client.deleteOneContributor(contributor.get_id());

		//Check to see if the JSON response does not contain the IP
		assertEquals(-1, response.indexOf("IP"));
		assertEquals(-1, response.indexOf("error"));
		assertEquals(-1, response.indexOf("CORE"));
	}
	@Test
	public void testSecretGetOneContributorByIdRequest() throws Exception{
		initSettings();

		//Creation of one contributor
		contributor = ws_client.createContributor("login", "creator");

    	String http_address = Common.URL+"/api/contributor/"+contributor.get_id();
		@SuppressWarnings("static-access")
		String token 	   = token_list.getToken("token_contributor");
		if(token!=null && !token.equals("")){
			http_address+="?token="+token;
		}
		String response = HttpCommunication.getInstance().sendGet(http_address);

		//Deletion of the contributor
		ws_client.deleteOneContributor(contributor.get_id());

		//Check to see if the JSON response does not contain the IP
		assertEquals(-1, response.indexOf("IP"));
		assertEquals(-1, response.indexOf("error"));
		assertEquals(-1, response.indexOf("CORE"));
	}
	@Test
	public void testSecretGetOneContributorByLoginRequest() throws Exception{
		initSettings();

		//Creation of one contributor
		contributor = ws_client.createContributor("login", "creator");

    	String http_address = Common.URL+"/api/contributor/login/login";
		@SuppressWarnings("static-access")
		String token 	   = token_list.getToken("token_contributor");
		if(token!=null && !token.equals("")){
			http_address+="?token="+token;
		}
		String response = HttpCommunication.getInstance().sendGet(http_address);

		//Deletion of the contributor
		ws_client.deleteOneContributor(contributor.get_id());

		//Check to see if the JSON response does not contain the IP
		assertEquals(-1, response.indexOf("IP"));
		assertEquals(-1, response.indexOf("error"));
		assertEquals(-1, response.indexOf("CORE"));
	}
	@Test
	public void testSecretPostOneContributorRequest() throws Exception{
		initSettings();

		//Creation of one contributor
    	String http_address = Common.URL+"/api/contributor";
		@SuppressWarnings("static-access")
		String token 	   = token_list.getToken("token_contributor");
		if(token!=null && !token.equals("")){
			http_address+="?token="+token;
		}
		List<NameValuePair> urlParameters=new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("login",    "login"));
		urlParameters.add(new BasicNameValuePair("creator",  "creator"));
		String response = HttpCommunication.getInstance().sendPost(http_address, urlParameters);

		contributor = (Contributor)gson.fromJson(response, Contributor.class);

		//Deletion of the contributor
		ws_client.deleteOneContributor(contributor.get_id());

		//Check to see if the JSON response does not contain the IP
		assertEquals(-1, response.indexOf("IP"));
		assertEquals(-1, response.indexOf("error"));
		assertEquals(-1, response.indexOf("CORE"));
	}
	@Test
	public void testSecretDeleteOneContributorByIdRequest() throws Exception{
		initSettings();

		//Creation of one contributor
		contributor = ws_client.createContributor("login", "creator");

		//Deletion of the contributor
    	String http_address = Common.URL+"/api/contributor/"+contributor.get_id();
		@SuppressWarnings("static-access")
		String token 	   = token_list.getToken("token_contributor");
		if(token!=null && !token.equals("")){
			http_address+="?token="+token;
		}
		String response = HttpCommunication.getInstance().sendDelete(http_address);

		//Check to see if the JSON response does not contain the IP
		assertEquals(-1, response.indexOf("IP"));
		assertEquals(-1, response.indexOf("error"));
		assertEquals(-1, response.indexOf("CORE"));
	}
}