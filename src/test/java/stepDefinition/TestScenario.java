package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageClasses.GmailHomePage;
import pageClasses.LoginPage;

public class TestScenario {

	WebDriver driver;
	PageObjectManager pageObjectManager;
	LoginPage loginPage;
	GmailHomePage gmailHomePage;
	WebDriverManager webDriverManager;
	ConfigFileReader configFileReader;

	@Given("^User is on Home Page$")
	public void openChromeAndStartGmail() {
		webDriverManager = new WebDriverManager();
		driver=webDriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		configFileReader = new ConfigFileReader();
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver.get(configFileReader.getApplicationUrl());
	}

	@When("^User enters UserName and Password$")
	public void userEnterValidCredentials() {
		loginPage = pageObjectManager.getLoginPage();
		loginPage.clickSignInButton();
		loginPage.enterEmail("priyasharma88990077@gmail.com");
		loginPage.enterPassword("Tester@2021");
	}

	@Then("^Login is successful$")
	public void verifyLoginIsSuccessful() throws InterruptedException {
		Thread.sleep(1000);
		String url = "https://mail.google.com/";
		//gmailHomePage = pageObjectManager.getGmailHomePage();
		gmailHomePage = new GmailHomePage(driver);
		gmailHomePage.launchGmail(url);
		Thread.sleep(2000);
		String currentUrl = webDriverManager.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains(url));
	}

	@Then("^Application should be closed$")
	public void closeDriver() {
		webDriverManager.closeDriver();
	}

	@When("^User enters incorrect UserName and Password$")
	public void userEntersIncorrectCreds() {
		loginPage = pageObjectManager.getLoginPage();
		loginPage.clickSignInButton();
		loginPage.enterEmail("xyz@gmail.com");
	}

	@Then("^Error Message Displayed$")
	public void errorMessageDisplayed() throws InterruptedException {
		loginPage.verifyErrorMessage("Couldn't find your Google Account");
	}

	@When("^User enters blank UserName and Password$")
	public void userEntersBlankUsername() {
		loginPage = pageObjectManager.getLoginPage();
		loginPage.clickSignInButton();
		loginPage.enterEmail("");
	}

	@Then("^Error Message For Blank Displayed$")
	public void errorMessageForBlankUserName() {
		loginPage.verifyErrorMessage("Enter an email or phone number");
	}
}
