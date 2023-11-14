package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    // WebDriver instance to interact with the browser
    protected WebDriver driver = null;

    // WebDriverWait instance for explicit waits
    protected WebDriverWait wait = null;

    // Actions instance for performing user actions
    protected Actions actions;

    // WebElements representing common page elements
    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement submitBtn;

    // BasePage constructor to initialize WebDriver, WebDriverWait, and Actions
    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Custom method for waiting until an element is visible
    protected WebElement findElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Method to input email into the email field
    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }

    // Method to input password into the password field
    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }

    // Method to click on the submit button
    public void clickSubmit() {
        submitBtn.click();
    }
}