import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class StepDefination {
    WebDriver driver;
    @Before()
    public static void x() {
    	System.out.println("before method");
    }
    
	@Given("User is on Home Page")
	public void user_is_on_Home_Page() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\VINOTH KUMAR\\eclipse-workspace\\Cucumber2\\Driver\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("http://demo.guru99.com/insurance/v1/index.php");  
		}
	@When("User Navigate to Registration Page")
	public void user_Navigate_to_Registration_Page() {
	   driver.findElement(By.xpath("//a[@class='btn btn-default']")).click();
	}
	@When("User fill the form details")
	public void user_fill_the_form_details(DataTable userdetails) throws InterruptedException {
		Map<String, String> Entry = userdetails.asMap(String.class, String.class);
	 driver.findElement(By.id("user_firstname")).sendKeys(Entry.get("FirstName"));
	 driver.findElement(By.id("user_surname")).sendKeys(Entry.get("SureName"));
	 driver.findElement(By.id("user_phone")).sendKeys(Entry.get("PhoneNum"));
	 Thread.sleep(2000);
	 Select Year = new Select (driver.findElement(By.name("year")));
	 Year.selectByVisibleText("1992");
	 Select Month = new Select (driver.findElement(By.name("month")));
	 Month.selectByVisibleText("February");
	 Select date = new Select (driver.findElement(By.name("date")));
	 date.selectByVisibleText("22");
	 driver.findElement(By.id("licencetype_t")).click();
	 Thread.sleep(2000);
	 Select LicencePeriod = new Select (driver.findElement(By.name("licenceperiod")));
	 LicencePeriod.selectByVisibleText("5");
	 Select Occupation = new Select (driver.findElement(By.name("occupation")));
	 Occupation.selectByVisibleText("Engineer");
	 Thread.sleep(2000);
	 driver.findElement(By.name("street")).sendKeys(Entry.get("street"));
	 driver.findElement(By.name("city")).sendKeys(Entry.get("city"));
	 driver.findElement(By.name("county")).sendKeys(Entry.get("county"));
	 driver.findElement(By.name("post_code")).sendKeys(Entry.get("post_code"));
	 driver.findElement(By.name("email")).sendKeys(Entry.get("email"));
	 driver.findElement(By.name("password")).sendKeys(Entry.get("password"));
	 driver.findElement(By.name("c_password")).sendKeys(Entry.get("c_password"));
	 Thread.sleep(2000);
	 driver.findElement(By.name("submit")).click();
	 }
	@Then("User get the Registration Successfully message")
	public void user_get_the_Registration_Successfully_message() {
		System.out.println("Registration Successful");   
	}
}
