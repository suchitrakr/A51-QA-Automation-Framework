
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class BasePage
{
    protected WebDriver driver = null;
    protected WebDriverWait wait = null;
    protected Actions actions;
    /*private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("button[type='submit']");*/

    @FindBy(css="[type='email']")
    WebElement emailField;

    @FindBy(css="[type='password']")
    WebElement passwordField;

    @FindBy(css="[type='submit']")
    WebElement submitBtn;

    public BasePage(WebDriver givenDriver)
    {
        driver =givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebElement findElement(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void click(By locator)
    {
        findElement(locator).click();
    }

     public void provideEmail(String email)

    {
        emailField.sendKeys(email);
    }
    public void providePassword(String password)
    {
        passwordField.sendKeys(password);
    }
    public void clickSubmit()
    {
        submitBtn.click();
    }
}

