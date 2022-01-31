package com.slotegrator.webTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/friday.feature",
        plugin = {"pretty", "html:target/cucumber-html-reports", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "json:target/cucumber-html-reports/cucumber.json", "rerun:target/failed_scenarios.txt"},
        extraGlue = {"com.diff.cucumber"})
public class CucumberRunner {
}
