package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/Feature/Testleaf.feature",glue="Steps_testcase",monochrome = true,publish = true )
public class TesleafRunner extends AbstractTestNGCucumberTests {

}
