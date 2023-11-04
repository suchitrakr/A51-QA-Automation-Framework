import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class Homework21 extends BaseTest
{
 String newPlayListName ="PlaylistNew";

    String ExpectedMessage = "Updated playlist \"PlaylistNew.\"";
    @Test
    public void renamePlaylist()
    {
        provideEmail();
        providePwd();
        clickSubmit();

        doubleClickPlaylist();
        changeNamePlaylist();
        Assert.assertEquals(ExpectedMessage,actualDisplayedMessage());
        driver.quit();
    }

    public void doubleClickPlaylist()
    {
        WebElement dblClkPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        action.doubleClick(dblClkPlaylist).perform();
    }
    public void changeNamePlaylist()
    {
        WebElement chnNamePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        chnNamePlaylist.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        chnNamePlaylist.sendKeys(newPlayListName);
        chnNamePlaylist.sendKeys(Keys.ENTER);
    }
    public String actualDisplayedMessage()
    {
        WebElement checkMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"success show\"]")));
        return checkMessage.getText();
    }

}
