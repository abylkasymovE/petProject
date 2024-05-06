package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
      plugin = {"html:target/reports/cucumber.html","json:target./reports/cucumber.json"},
      glue = "step_definition",
      features = "src/test/resources/features" ,
      tags = "@loginDemo",
      dryRun = false
)

public class RunnerClass {
}
