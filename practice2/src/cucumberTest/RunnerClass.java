package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "C:/Users/AlyaE/eclipse-workspace/practice2/Features", 
		glue = {"C:/Users/AlyaE/eclipse-workspace/practice2/src/StepDefinition"},
		monochrome = true,
		plugin = { "pretty","json:target/cucumberreports.json" }
)

public class RunnerClass extends AbstractTestNGCucumberTests{
}
