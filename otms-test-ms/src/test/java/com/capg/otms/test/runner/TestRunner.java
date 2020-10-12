package com.capg.otms.test.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/Test.feature",glue= {"com.capg.otms.test.stepdefinition"})
public class TestRunner {

	
	
}
