package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Feature/Duplicatelead.feature",glue="Steps_Duplicatelead",monochrome=true,publish=true)
public class DuplicateLeadRunner extends AbstractTestNGCucumberTests{

}
