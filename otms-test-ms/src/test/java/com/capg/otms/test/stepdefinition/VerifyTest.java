package com.capg.otms.test.stepdefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTest {

	WebDriver driver;

	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Softwares\\SeleniumCucumberSoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/admin-login");
		driver.manage().window().maximize();
	}

	@When("^Admin enters valid username and password$")
	public void admin_enters_valid_username_and_password() throws Throwable {
		driver.findElement(By.id("user.userName")).sendKeys("Meghana");
		driver.findElement(By.id("user.userPassword")).sendKeys("seeram");
	}

	@When("^Admin clicks on Login button$")
	public void admin_clicks_on_Login_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'submit')]")).click();
	}

	@Then("^Admin should be able to see a message\"([^\"]*)\"\\.$")
	public void admin_should_be_able_to_see_a_message(String arg1) throws Throwable {
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();

		Thread.sleep(3000);
		// alert.accept();
		alert.accept();
		alert.accept();
		Thread.sleep(2000);
	}

	@Given("^Admin has logged in to the website$")
	public void admin_has_logged_in_to_the_website() throws Throwable {
		
	
		driver.get("http://localhost:4200/admin");
		driver.findElement(By.xpath("//button[@id='header']")).click();
	}

	@When("^Admin clicks on Add Test button$")
	public void admin_clicks_on_Add_Test_button() throws Throwable {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Add Test')]")).click();
	}

	@When("^Admin fills the Test details$")
	public void admin_fills_the_Test_details() throws Throwable {
		driver.findElement(By.id("testTitle")).sendKeys("SeleniumTest");
		driver.findElement(By.id("startTime")).sendKeys("2020-05-02T14:00:00");
		driver.findElement(By.id("endTime")).sendKeys("2020-05-02T15:00:00");
	}

	@When("^Admin clicks on Add button$")
	public void admin_clicks_on_Add_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Add Test')]")).click();
	}

	
	@Then("^Admin view message as \"([^\"]*)\"\\.$")
	public void admin_view_message_as(String arg1) throws Throwable {
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		Thread.sleep(1000);
	}
	

	@When("^Admin clicks on Logut button$")
	public void admin_clicks_on_Logut_button() throws Throwable {
	  driver.get("http://localhost:4200/header");
	  driver.findElement(By.xpath("//button[@id='logout']")).click();
	}

	@Then("^Browser window must be closed\\.$")
	public void browser_window_must_be_closed() throws Throwable {
	    Thread.sleep(1000);
	    driver.close();
	}

}
