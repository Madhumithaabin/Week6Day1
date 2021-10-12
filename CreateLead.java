package Steps_testcase;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateLead{

	ChromeDriver driver;
	
	@Given("Open the chrome browser")
		public void openBrowser() {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					
		}
	@Given("Load the application url as {string}")
	public void loadAppurl(String url) {
			driver.get(url);
			
		}
	@Given("Enter the username as {string}")
	public void enterUsername(String user) {

			driver.findElement(By.id("username")).sendKeys(user);
			
		}
	@Given("Enter the password as {string}")
	public void enterPassword(String pass) {
		driver.findElement(By.id("password")).sendKeys(pass);
			
		}
	@Given("Click the login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
		
	}
	
	@And("Click the CRMSFA link")
	public void clickCRM() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	}
	
	@And("Click the Lead button")
	public void clickLead() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@Given("Click the CreateLead button")
	public void createLead() {

		driver.findElement(By.linkText("Create Lead")).click();
	}

	@And("Enter the companyName as {string}")
	public void companyName(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		
	}
	@Given("Enter the FirstName as {string}")
	public void firstName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		
	}
	@Given("Enter the LastName as {string}")
	public void lastName(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		
	}
	@Given("Enter the Phonenumber as {string}")
	public void phoneNo(String phoneno) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneno);
		
	}
	@When("Click the createlead button")
	public  void leadCreation() {
		driver.findElement(By.name("submitButton")).click();
		
}
	@Then("New lead is created")
	public  void leadCreationsucess() {
	String title = driver.getTitle();
	if(title.equals("View Lead | opentaps CRM")) {
		System.out.println("Sucessfully created the lead");
	driver.close();
	}
	else
	{
		System.out.println("lead is not created");
		driver.close();
		}
}
		
}






