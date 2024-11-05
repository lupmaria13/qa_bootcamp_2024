package juiceShop.tests;

import juiceShop.frameworkUtils.Selectors;
import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterTest {


    static final String baseUrl = Utils.getConfigProperty("baseUrl");

    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        // OLD version !! Do not use unless the server you are testing does not have internet
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\myuser\\Downloads\\chromedirver.exe");

        driver = Utils.getDriver();
    }

    @DataProvider(name = "RegistrationDataProvider")
    public Iterator<Object[]> registerDp () {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"alex@alex.com", "Alex98876%", "alex"});
        return dp.iterator();
    }

    @Test(dataProvider = "RegistrationDataProvider")
    public void loginRegister(String username, String password, String securityAns) {
        driver.get(baseUrl + "/#/login");

        WebElement dismissModalElement = Utils.waitForElement(driver, 5,
                By.cssSelector(Selectors.MODAL_OK_BUTTON)
        );
        dismissModalElement.click();

        WebElement registerLink = driver.findElement(By.cssSelector(Selectors.REGISTER_URL));
        registerLink.click();

        Assert.assertEquals(
                driver.findElement(By.cssSelector(Selectors.REGISTER_HEADER)).getText(),
                "User Registration"
        );

        WebElement usernameElement = driver.findElement(By.id(Selectors.REGISTER_EMAIL));
        usernameElement.clear();
        usernameElement.sendKeys("alex@alex.com");

        WebElement passwordElement = driver.findElement(By.id(Selectors.REGISTER_PASSWORD));
        passwordElement.clear();
        passwordElement.sendKeys("Alex98765$");

        WebElement passwordConfirm = driver.findElement(By.id(Selectors.REGISTER_CONFIRM));
        passwordConfirm.clear();
        passwordConfirm.sendKeys("Alex98765$");

        WebElement securityQuestion = Utils.waitForElement(driver, 5,
                By.cssSelector(Selectors.SECURITY_QUESTION)
        );
        securityQuestion.click();

        WebElement securityQuestionChoice = driver.findElement(By.cssSelector(Selectors.SECURITY_OPTION1));
        securityQuestionChoice.click();

        WebElement securityAnswer = driver.findElement(By.id(Selectors.SECURITY_ANSWER));
        securityAnswer.clear();
        securityAnswer.sendKeys("alex");

        WebElement submitButton = driver.findElement(By.id(Selectors.REGISTER_SUBMIT_BUTTON));
        submitButton.click();

    }

    @AfterMethod
    public void closeBrowser() {
        try {
            driver.close();
        }
        catch (Exception ex) {
            driver.quit();
        }
    }

}
