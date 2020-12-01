package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"E:\\SpringProjects\\restAssured_Basic\\src\\test\\java\\Features\\UserScenarios.feature"}, glue = "steps")
public class TestRunner extends AbstractTestNGCucumberTests {

}
