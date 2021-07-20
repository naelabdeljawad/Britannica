package com.launcher;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/features/BritannicaTestScenario.feature", plugin = {"pretty",
        "html:target/cucumber/BritannicaTestScenario.html",
        "rerun:target/cucumber/BritannicaTestScenario.txt",
        "json:target/cucumber/BritannicaTestScenario.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"com.definitions"})
public class SOLID_BritannicaTestScenarioLauncher extends AbstractTestNGCucumberTests {
}
