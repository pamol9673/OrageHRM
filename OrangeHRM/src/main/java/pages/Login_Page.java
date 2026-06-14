
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login_Page extends Base_Page {
	public WebDriver driver;
	
	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//p[contains(@class, 'alert')]")
	private WebElement errorMessage;

	@FindBy(xpath = "//span[contains(@class, 'error-message')]")
	private WebElement emptyFieldError;

	public Login_Page(WebDriver driver) {
		super(driver);
		
	}

	public void enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.clear();
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.getText();
	}

	public String getEmptyFieldErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(emptyFieldError));
		return emptyFieldError.getText();
	}

	public boolean isLoginButtonDisplayed() {
		return loginButton.isDisplayed();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
