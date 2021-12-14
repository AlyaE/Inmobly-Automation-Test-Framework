package Utility;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
		features = "classpath:Features/DashboardContent.feature",
		glue = {"StepDefinition"},
		monochrome = true,
		plugin = { "pretty","json:target/cucumberreports.json" }
)

public class RunnerClass extends AbstractTestNGCucumberTests{
}
