import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;


public class BaseTest
{
    protected static WebDriver driver = null;
    protected static WebDriverWait wait=null;
    protected static Actions action = null;
    @BeforeSuite
    @Parameters({"BaseUrl"})
    static void setupClass(String BaseUrl) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        String url =BaseUrl;
        driver.get(url);
        action = new Actions(driver);
    }
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL ="http://192.168.0.24:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.chromedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(new String[]{"--remote-allow-origins=*", "--disable-notifications", "--start-maximized"});
                return driver = new EdgeDriver();
            case "grid-edge":
                 caps.setCapability("browserName","MicrosoftEdge");
                 return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--remote-allow-origin=*");
                options.addArguments(new String[]{"--remote-allow-origins=*", "--disable-notifications", "--start-maximized"});
                return driver = new ChromeDriver(options);
        }
    }
    public static WebDriver lambdaTest() throws MalformedURLException {
        String username="suchitratoo8";
        String authKey="t2zTez782p332IStCitEfrxwCQpgp5zI2yVpJIPK9NEWQi6JJ5";
        String hub="@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform","Windows 10");
        caps.setCapability("browserName","Chrome");
        caps.setCapability("version","119.0.6045.160");
        caps.setCapability("build","TestNg with Java");
        caps.setCapability("name",BaseTest.class.getName());
        caps.setCapability("plugin","Java-TestNG");

        return new RemoteWebDriver(new URL("https://"+username+":"+authKey + hub), caps);

    }

}