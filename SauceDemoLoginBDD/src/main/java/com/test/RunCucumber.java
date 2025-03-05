package com.test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags= "@user1", features = "src/test/resources/Features/SauceDemoLogin.feature", glue = "LoginStepDef", plugin = { "pretty", "html:target/htmlreport.html" })
public class RunCucumber{
}
