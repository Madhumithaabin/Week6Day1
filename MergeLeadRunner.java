package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/Feature/MergeLead.feature",glue="Steps_MergeLead",monochrome = true,publish = true )
public class MergeLeadRunner extends AbstractTestNGCucumberTests {

}
