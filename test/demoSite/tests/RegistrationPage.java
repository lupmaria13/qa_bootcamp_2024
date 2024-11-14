package demoSite.tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    private By usernameField = By.cssSelector("input[placeholder='Username']");
    private By emailField = By.cssSelector("input[placeholder='Email']");
    private By passwordField = By.cssSelector("input[placeholder='Password']");
    private By registerButton = By.cssSelector("button[type='submit']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        Utils.waitForElement(driver, 5, usernameField).sendKeys(username);
    }

    public void enterEmail(String email) {
        Utils.waitForElement(driver, 5, emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        Utils.waitForElement(driver, 5, passwordField).sendKeys(password);
    }

    public void clickRegister() {
        Utils.waitForElement(driver, 5, registerButton).click();
    }

    public void register(String username, String email, String password) {
        enterUsername(username);
        enterEmail(email);
        enterPassword(password);
        clickRegister();
    }
}
