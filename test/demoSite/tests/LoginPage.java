package demoSite.tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("user");
    private By passwordField = By.id("pass");
    private By rememberMeCheckbox = By.cssSelector("remember");
    private By signInButton = By.cssSelector("button.btn.btn-primary");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        Utils.waitForElement(driver, 5, usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        Utils.waitForElement(driver, 5, passwordField).sendKeys(password);
    }

    public void selectRememberMe() {
        Utils.waitForElement(driver, 5, rememberMeCheckbox).click();
    }

    public void clickSignIn() {
        Utils.waitForElement(driver, 5, signInButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }
}
