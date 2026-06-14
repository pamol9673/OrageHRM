package tests_orangehrm;

import pages.Login_Page;
import utils_orangehrm.Base_Test;
import pages.Dashboard_Page;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Test extends Base_Test {

	// Positive Test Case
	@Test(priority = 1)
	public void testValidLogin() {
		// WebDriver driver;
		Login_Page loginPage = new Login_Page(driver);

		loginPage.login("Admin", "admin123");

		Dashboard_Page dashboardPage = new Dashboard_Page(driver);

		Assert.assertTrue(dashboardPage.isDashboardDisplayed(),
				"User should be redirected to dashboard after successful login");
		Assert.assertEquals(dashboardPage.getDashboardHeaderText(), "Dashboard",
				"Dashboard header should be displayed");
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "URL should contain 'dashboard'");
	}

	// Negative Test Case - Invalid Password
	@Test(priority = 2)
	public void testInvalidPassword() {
		Login_Page loginPage = new Login_Page(driver);

		loginPage.login("Admin", "wrongPassword123");

		String errorMessage = loginPage.getErrorMessage();
		Assert.assertTrue(errorMessage.contains("Invalid credentials"),
				"Error message should indicate invalid credentials");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "User should remain on login page");
		Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"), "URL should not contain dashboard");
	}

	// Negative Test Case - Empty Username
	@Test(priority = 3)
	public void testEmptyUsername() {
		Login_Page loginPage = new Login_Page(driver);

		loginPage.login("", "admin123");

		String errorMessage = loginPage.getEmptyFieldErrorMessage();
		Assert.assertTrue(errorMessage.contains("Required") || errorMessage.contains("empty"),
				"Error message should indicate username is required");
	}

	// Negative Test Case - Empty Password
	@Test(priority = 4)
	public void testEmptyPassword() {
		Login_Page loginPage = new Login_Page(driver);

		loginPage.login("Admin", "");

		String errorMessage = loginPage.getEmptyFieldErrorMessage();
		Assert.assertTrue(errorMessage.contains("Required") || errorMessage.contains("empty"),
				"Error message should indicate password is required");
	}

	// Negative Test Case - Null Password
	@Test(priority = 5)
	public void testNullPassword() {
		Login_Page loginPage = new Login_Page(driver);

		loginPage.login("Admin", " ");

		String errorMessage = loginPage.getEmptyFieldErrorMessage();
		Assert.assertTrue(errorMessage.contains("Required") || errorMessage.contains("empty"),
				"Error message should indicate password is required");
	}
}
