package cucumberTest;

//import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;


@io.cucumber.testng.CucumberOptions(
		features = "classpath:Features",
		glue = {"StepDefinition"},
		monochrome = true,
		plugin = { "pretty","json:target/cucumberreports.json" }
)

public class RunnerClass extends io.cucumber.testng.AbstractTestNGCucumberTests{
}
