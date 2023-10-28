import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest
{
    @Test
    public void addSongToPlaylist() throws InterruptedException
    {
        launchBrowser();
        navigateToLoginPage();
        provideEmail();
        providePwd();
        clickSubmit();
        searchASong("Dark days");
        clickViewAll();
        selectFirstSong();
        clickAddTo();
        choosePlayList();
        String expectedMessage = "Added 1 song into \"Playlist1.\"";
        Assert.assertEquals(getAddToSuccessMessage(), expectedMessage);
        driver.quit();
    }
        public void searchASong(String songName) throws InterruptedException
        {
            WebElement songSearch = driver.findElement(By.cssSelector("input[type='search']"));
            songSearch.sendKeys(songName);
            Thread.sleep(2000);
        }
        public void clickViewAll() throws InterruptedException {
            WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
            viewAll.click();
            Thread.sleep(2000);
        }
        public void selectFirstSong () throws InterruptedException
        {
            WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
            firstSong.click();
            Thread.sleep(2000);

        }
        public void clickAddTo () throws InterruptedException
        {
            WebElement addTo =driver.findElement(By.cssSelector("button.btn-add-to"));
            addTo.click();
            Thread.sleep(2000);
        }

        public void choosePlayList () throws InterruptedException
        {
            WebElement playlist =driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Playlist1')]"));
            playlist.click();
            Thread.sleep(2000);

        }
        public String getAddToSuccessMessage () throws InterruptedException
        {
             WebElement successMessage =driver.findElement(By.cssSelector("div.success.show"));
             return successMessage.getText();
        }


    }

