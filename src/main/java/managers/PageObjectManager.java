package managers;

import org.openqa.selenium.WebDriver;

import pageClasses.GmailHomePage;
import pageClasses.LoginPage;

public class PageObjectManager {

	private WebDriver driver;

	private LoginPage loginPage;

	private GmailHomePage gmailHomePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		final LoginPage loginPage = (this.loginPage == null) ? this.loginPage = new LoginPage(driver) : this.loginPage;
		return loginPage;
	}

	public GmailHomePage getGmailHomePage() {
		final GmailHomePage gmailHomePage = (this.gmailHomePage == null) ? this.gmailHomePage = new GmailHomePage(driver) : this.gmailHomePage;
		return gmailHomePage;
	}

}
