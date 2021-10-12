package Steps_DeleteLead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	ChromeDriver driver;
	
	String leadID;
	
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
	public void clickLeadbutton() {
		driver.findElement(By.linkText("Leads")).click();
	}



	@Given("Click the FindLeads link")
	public void findLead() {
		driver.findElement(By.linkText("Find Leads")).click();

	}

	@And("Click the phone button")
	public void clickPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

	}

	@And("Enter the phonenumber as {string}")
	public void enterPhone(String pNumber) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNumber);

	}

	@And("Click the FindLeads button")
	public void clickfindlead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}

	@When("Records will be displayed in the table,capture the leadid from the first row")
	public void displayRecord() {
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	}

	@Then("Click the first row leadid")
	public void clickLead() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

	}

	@And("Click the delete button")
	public void deleteLeadid() {
		driver.findElement(By.linkText("Delete")).click();

	}

	@Given("Enter the leadid as captured before")
	public void findDeleteLead() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);

	}

	@Then("Verify the record is deleted")
	public void verifyLeadDelete() throws InterruptedException {
		
	Thread.sleep(2000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Lead is deleted successfully" +text);
		} 
		else {
			System.out.println("Lead is not deleted"+text);
		}
		driver.close();
	}

}
