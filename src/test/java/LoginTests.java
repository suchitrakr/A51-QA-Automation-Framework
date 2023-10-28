import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException
    {

        launchBrowser();
        navigateToLoginPage();
        provideEmail();
        providePwd();
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();

    }
}
