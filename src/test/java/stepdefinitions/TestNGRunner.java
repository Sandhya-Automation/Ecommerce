package stepdefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumberfiles", glue="stepdefinitions", monochrome=true, tags= "@SubmitOrder", plugin={"html:target/cucmberreports.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests {


}
