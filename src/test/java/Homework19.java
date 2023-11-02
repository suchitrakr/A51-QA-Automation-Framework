import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class Homework19 extends BaseTest
{
    String ExpectedMessage = "Deleted playlist \"playlist1.\"";
    @Test
    public void deletePlaylist() throws InterruptedException
    {
        provideEmail();
        providePwd();
        clickSubmit();
        openPlaylist();
        deletePlaylistBtn();
        Assert.assertEquals(ExpectedMessage,actualDisplayedMessage());
        driver.quit();
    }

    private void openPlaylist() throws InterruptedException
    {
       WebElement clickOpenPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
       clickOpenPlaylist.click();
       Thread.sleep(2000);
    }
    public void deletePlaylistBtn() throws InterruptedException
    {
        WebElement clickdeleteBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        clickdeleteBtn.click();
        Thread.sleep(2000);
        WebElement OkBtn = driver.findElement(By.cssSelector("button.ok"));
        OkBtn.click();
     }
    public String actualDisplayedMessage() throws InterruptedException {
        WebElement checkMessage = driver.findElement(By.xpath("//div[@class=\"success show\"]"));
        Thread.sleep(2000);
        return checkMessage.getText();
    }
}
