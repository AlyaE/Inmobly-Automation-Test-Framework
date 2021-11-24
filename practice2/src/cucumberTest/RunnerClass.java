package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "classpath:Features",
		glue = {"StepDefinition"},
		monochrome = true,
		plugin = { "pretty","json:target/cucumberreports.json" }
)

public class RunnerClass extends cucumber.api.testng.AbstractTestNGCucumberTests{
}
