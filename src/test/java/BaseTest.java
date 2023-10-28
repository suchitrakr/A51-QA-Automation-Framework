import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest
{
    WebDriver driver = null;
    String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass()
    {
        WebDriverManager.chromedriver().setup();
    }
    public void launchBrowser()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void navigateToLoginPage()
    {
        driver.get(url);
    }
    public void provideEmail()
    {
        WebElement email =driver.findElement(By.cssSelector("input[type='email']"));
        email.clear();
        email.sendKeys("suchitra.kumari@testpro.io");
    }
    public void providePwd()
    {
        WebElement pwd =driver.findElement(By.cssSelector("input[type='password']"));
        pwd.clear();
        pwd.sendKeys("SuchitraKumari1@");
    }
    public void clickSubmit() throws InterruptedException
    {
        WebElement clickSubmit =driver.findElement(By.cssSelector("button[type='submit']"));
        clickSubmit.click();
        Thread.sleep(2000);
    }
}
