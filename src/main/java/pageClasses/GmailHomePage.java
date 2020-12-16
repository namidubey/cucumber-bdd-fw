package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {
	WebDriver driver;

	public GmailHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchGmail(String url) {
		driver.get(url);
	}
}
