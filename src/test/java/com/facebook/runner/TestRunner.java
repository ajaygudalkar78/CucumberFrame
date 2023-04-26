package com.facebook.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Feature",
		glue="com.facebook.definations",
		plugin={"pretty", "html:target/cucumber-html-report.html","json:target/cucumber.json"}//to generate report this plugin is used
		,tags="@test"
		,dryRun=false
		
		
		
		
		
		)
public class TestRunner {

}
