
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard_Page extends Base_Page {

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboardHeader;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement userDropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	public Dashboard_Page(WebDriver driver) {
	        super(driver);
	    }

	public boolean isDashboardDisplayed() {
		try {
			wait.until(ExpectedConditions.visibilityOf(dashboardHeader));
			return dashboardHeader.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getDashboardHeaderText() {
		wait.until(ExpectedConditions.visibilityOf(dashboardHeader));
		return dashboardHeader.getText();
	}

	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(userDropdown));
		userDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		logoutButton.click();
	}
}
