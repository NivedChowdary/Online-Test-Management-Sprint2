package com.capg.otms.user.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/Login.feature",glue= {"com.capg.otms.user.stepdefinition"})
public class LoginRunner {

}
