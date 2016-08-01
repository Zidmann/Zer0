package fr.service_provider.junit.test;

/*
 * Copyright 2015-2016 Emmanuel ZIDEL-CAUFFET
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

/* 
 * Class 	: TestSuite_ServiceProvider
 * Author(s): Zidmann
 * Function : This class is used to define the JUnit test cases for testing Provider service
 * Version  : 1.0.0
 */
public class TestSuite_ServiceProvider extends TestSuite {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestCase_Authentification.class);
		suite.addTestSuite(TestCase_Authentification_NoSecretPublication.class);
		suite.addTestSuite(TestCase_Authentification_RejectForbiddenLetter.class);
		suite.addTestSuite(TestCase_Card.class);
		suite.addTestSuite(TestCase_Card_Cache.class);
		suite.addTestSuite(TestCase_Card_NoSecretPublication.class);
		suite.addTestSuite(TestCase_Card_OfflineRestriction.class);
		suite.addTestSuite(TestCase_Card_RejectForbiddenLetter.class);
		suite.addTestSuite(TestCase_Contributor.class);
		suite.addTestSuite(TestCase_Contributor_Cache.class);
		suite.addTestSuite(TestCase_Contributor_NoSecretPublication.class);
		suite.addTestSuite(TestCase_Contributor_RejectForbiddenLetter.class);
		suite.addTestSuite(TestCase_Group.class);
		suite.addTestSuite(TestCase_Group_Cache.class);
		suite.addTestSuite(TestCase_Group_NoSecretPublication.class);
		suite.addTestSuite(TestCase_Group_RejectForbiddenLetter.class);
		suite.addTestSuite(TestCase_People.class);
		suite.addTestSuite(TestCase_People_Cache.class);
		suite.addTestSuite(TestCase_People_NoSecretPublication.class);
		suite.addTestSuite(TestCase_People_RejectForbiddenLetter.class);
		suite.addTestSuite(TestCase_Picture.class);
		suite.addTestSuite(TestCase_Picture_NoSecretPublication.class);
		suite.addTestSuite(TestCase_Picture_RejectForbiddenLetter.class);
		return suite;
	}
}