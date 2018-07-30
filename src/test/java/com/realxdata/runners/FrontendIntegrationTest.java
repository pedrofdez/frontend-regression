package com.realxdata.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-reports/rxd-bdd/", "json:target/cucumber-reports/rxd-bdd/report.json"},
        features = {"src/test/resources/features"},
        glue = {"com.realxdata.stepdefs"},
        strict = true,
        tags = "@wip")
public class FrontendIntegrationTest {
}
