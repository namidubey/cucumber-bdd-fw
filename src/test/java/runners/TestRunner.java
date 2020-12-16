package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "com.cucumber/Feature",
		glue="stepDefinition",
		plugin={"json:target/cucumber.json","pretty","html:target/cucumber-reports","usage"},
		monochrome = true,
		dryRun= false
)
public class TestRunner {

}
