package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
	private WebElement signInButton;

	@FindBy(how = How.NAME, using = "identifier")
	private WebElement emailLocater;

	@FindBy(how = How.ID, using = "identifierNext")
	private WebElement clickNextButton;

	@FindBy(how = How.CSS, using = "input[autocomplete='current-password']")
	private WebElement passwordLocater;

	@FindBy(how = How.CSS, using = "div.o6cuMc")
	private WebElement errorMessage;

	@FindBy(how = How.ID, using = "passwordNext")
	private WebElement clickNextOnPasswordPage;


	public void clickSignInButton() {
		signInButton.click();
	}

	public void enterEmail(String emailAddress) {
		emailLocater.sendKeys(emailAddress);
		clickNextButton.click();
	}

	public void enterPassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(passwordLocater));
		passwordLocater.sendKeys(password);
		clickNextOnPasswordPage.click();
	}

	public void verifyErrorMessage(String expectedErrorText) {
		String errorText = errorMessage.getText();
		Assert.assertEquals(errorText, expectedErrorText);
	}
}
