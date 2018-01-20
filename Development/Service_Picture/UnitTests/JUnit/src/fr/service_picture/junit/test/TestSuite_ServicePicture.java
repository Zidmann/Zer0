package fr.service_picture.junit.test;

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


import junit.framework.TestSuite;

/**
 * This class contains the webService client JUnit tests to check if there was no regression in Picture service
 * <p>
 * This Test Case supposes that you started the NodeJS server and removed all the Picture elements in the MongoDB database and on the disk
 * </p>
 * @author Zidmann (Emmanuel ZIDEL-CAUFFET)
 * @version 1.1.0
 */
public class TestSuite_ServicePicture extends TestSuite {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestCase_Picture.class);
		suite.addTestSuite(TestCase_Picture_ErrorMsg.class);
		return suite;
	}
}