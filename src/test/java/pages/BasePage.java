
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BasePage
{
    WebDriver driver = null;
    WebDriverWait wait = null;
    Actions actions;
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");
    public BasePage(WebDriver givenDriver)
    {
        driver =givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public WebElement findElement(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void click(By locator)
    {
        findElement(locator).click();
    }
    public void doubleClick(By locator)
    {
        actions.doubleClick(findElement(locator)).perform();
    }

    public void provideEmail(String email)
    {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password)
    {
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit()
    {
        click(submitBtn);
    }
}

