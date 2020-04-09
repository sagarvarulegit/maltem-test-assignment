package support.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty","html:TestReport/cucumber-report.html"},
        features = "src/test/features"
        ,glue={"step_definitions"}
        )
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
