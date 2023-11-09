import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;


public class BaseTest
{
    public static WebDriver driver = null;
    public static WebDriverWait wait=null;
    public static Actions action = null;
    @BeforeSuite
    @Parameters({"BaseUrl"})
    static void setupClass(String BaseUrl)
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        String url =BaseUrl;
        driver.get(url);
        action = new Actions(driver);
    }

}
