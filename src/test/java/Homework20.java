
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework20 extends BaseTest
    {
        String ExpectedMessage = "Deleted playlist \"playlist4.\"";
        @Test
        public void deletePlaylist()
        {
            provideEmail();
            providePwd();
            clickSubmit();
            openPlaylist();
            deletePlaylistBtn();
            playSong();
            Assert.assertEquals(ExpectedMessage,actualDisplayedMessage());
            driver.quit();
        }
        public void openPlaylist()
        {
            WebElement clickOpenPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(6)")));
            clickOpenPlaylist.click();
        }
        public void deletePlaylistBtn()
        {
            WebElement clickDeleteBtn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
            clickDeleteBtn.click();

            WebElement OkBtn = driver.findElement(By.cssSelector("button.ok"));
            OkBtn.click();
        }
        public String actualDisplayedMessage()
        {
            WebElement checkMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"success show\"]")));
            return checkMessage.getText();
        }
        public void playSong()
        {
            WebElement playSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        }
    }

