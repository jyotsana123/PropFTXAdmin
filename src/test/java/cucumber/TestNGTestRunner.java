package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="PropFTX.stepDefinitions",
monochrome=true,plugin= {"html:target/cucumber.html"})

//feature - we need to give path for feature file, Glue - give location, where is stepDefinitions class availabe
//monochrome is a plugin which gives the report in readable format
//Give the location for your html report in plugin {}
//1. Run all feature file present in the package "src/test/java/cucumber"
//2. To map them with stepDefinitions "PropFTX.stepDefinitions"
//3. Print the result in readable format
//4. And generate the report in html plugin
// these are the helper attribute which we are giving in order to run the test
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
