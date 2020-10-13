package com.capg.otms.user.stepdefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyLogin {

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
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
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
