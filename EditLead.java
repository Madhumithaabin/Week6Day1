package Steps_Editlead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	ChromeDriver driver;

	String leadID;

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

	@Then("Click the first row leadid")
	public void clickLead() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

	}

	@And("Click the editlead button")
	public void editLead() {
		driver.findElement(By.linkText("Edit")).click();

	}

	@Given("Enter the company name as 'TCS'")
	public void update_Cmpname() {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");

	}

	@Given("Click the submit link")
	public void clickSubmit() {

		driver.findElement(By.name("submitButton")).click();

	}

	@Then("lead is edited successfully")
	public void editleadsucess() {
		String title = driver.getTitle();
		if (title.equals("View Lead | opentaps CRM")) {
			System.out.println("Sucessfully updated the lead");
			driver.close();
		} else {
			System.out.println("lead is not updated");
			driver.close();
		}
	}

}
