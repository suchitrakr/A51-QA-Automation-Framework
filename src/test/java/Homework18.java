import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest
{
    @Test
    public void playSong() throws InterruptedException
    {
        launchBrowser();
        navigateToLoginPage();
        provideEmail();
        providePwd();
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
        driver.quit();
    }

    public void clickPlay()
    {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn =driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextBtn.click();
        playBtn.click();
    }
    public Boolean isSongPlaying()
    {
        WebElement soundBar = driver.findElement(By.xpath("//button[@data-testid='toggle-visualizer-btn']"));
        return soundBar.isDisplayed();
    }
}
