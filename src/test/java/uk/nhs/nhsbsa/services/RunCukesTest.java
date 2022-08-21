package uk.nhs.nhsbsa.services;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        dryRun = false,
        strict = true,
        tags = "@Regression",
        plugin = "json:target/cucumber-report/cucumber.json")

public class RunCukesTest {
}
