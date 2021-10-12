package Steps_MergeLead;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead{

	ChromeDriver driver;
	Set<String> allWindows;
	String leadID;
	List<String> allhandles;
	@Given("Open the chrome browser")
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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
	public void clickLeadbutton() {
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@Given("Click the MergeLeads link")
	public void mergeLead() {
		 driver.findElement(By.linkText("Merge Leads")).click();

	}

	@And("Click the from search button")
	public void clickFrom() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	}
@When("New windows open,switch to new window")
public void swicthWindow() {
	
	  allWindows = driver.getWindowHandles(); 
	  allhandles = new
	  ArrayList<String>(allWindows); driver.switchTo().window(allhandles.get(1));

}

@Then("Enter the firstname as {string}")
	public void enterFName(String fName) {
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fName);
	}


	@And("Click the FindLeadslink button")
	public void clickfindlead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}
	@When("Records will be displayed in the table,capture the leadid from the first row")
	public void caputureLeadid()
	{
		leadID = driver.findElement(By.
				  xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		
	}

	@Then("Click the first row leadid")
	public void clickLead() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

	}
	@When("New windows closes,switch to old window")
	public void swicthcloseWindow() {
		driver.switchTo().window(allhandles.get(0));
		  	
	}

	
	
	
	
	
	@And("Click the to search button")
	public void clickTo() {
		  driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	}

	@And("Click the merge button")
	public void clickMergeButton() {
		  driver.findElement(By.xpath("//a[text()='Merge']")).click();
	}

	@When("Alert appears accept it")
	public void alertHandle() {
		 driver.switchTo().alert().accept();
		 		
	}
	@And("Click the FindLeads button")
	public void clickfindleadId() {
		driver.findElement(By.linkText("Find Leads")).click();

	}
	@Given("Enter the lead as captured before")
	public void searchMergelead() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		  
	}
	@Then("Verify if the data is merged")
	public void verify_Mergeddata()
	{
		String text = driver.findElement(By.className("x-paging-info")).getText(); 
		if(text.equals("No records to display"))
		{
			System.out.println("Leads were merged successfully"+text);
		  } 
		else
		{
			System.out.println("Leads are merged"+text);
			}
		  
	driver.close();
	}



		 }






