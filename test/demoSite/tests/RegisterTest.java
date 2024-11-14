package demoSite.tests;

import juiceShop.frameworkUtils.Utils;
import juiceShop.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void successfulRegistrationTest() {
        driver.get(baseUrl + "/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register("newUser", "newuser@example.com", "newpassword");

        WebElement successMessage = Utils.waitForElement(driver, 10, By.id("success-message"));
    }

    @Test
    public void unsuccessfulRegistrationTest() {
        driver.get(baseUrl + "/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register("existingUser", "existinguser@example.com", "password123");

        WebElement errorMessage = Utils.waitForElement(driver, 10, By.id("error-message"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Mesajul de eroare ar trebui să fie afișat pentru înregistrare eșuată.");
    }
}
