package com.fusion.complaintmodule;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Step_Defination {
	WebDriver driver;
	@Given("^User have opened the browser$")
	public void Open_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@When("^User have opened Fusion website and verify the title$")
	public void Navigating_to_fusion_login() throws Throwable {
		driver.get("http://172.27.16.216/accounts/login/");
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Fusion!";
		driver.manage().window().maximize();
		//Soft assert applied to verify title
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}
	
	@When("^User entered username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void Login(String arg1, String arg2) throws Throwable {
		
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@id=\"id_login\"]")).sendKeys(arg1);
		 driver.findElement(By.xpath("//*[@id=\"id_password\"]")).sendKeys(arg2);
		 driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[4]/button")).click();
		
	}

	@Then("^Pressed Login Button$")
	public void login_button_should_exist() throws Throwable {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Fusion! Dashboard";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	    
	}
	@Then("^Dashboard Must appear and verify the dasboard Title$")
	public void Verify_Dashboard_Title() throws Throwable {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Fusion! Dashboard";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	    
	}
	
	
}
