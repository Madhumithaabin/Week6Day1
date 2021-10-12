package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features ="src/test/java/Feature/Deletelead.feature",glue="Steps_DeleteLead",monochrome = true,publish=true )
public class DeleteLeadRunner extends AbstractTestNGCucumberTests{

}
