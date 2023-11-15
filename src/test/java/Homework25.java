import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
public class Homework25 extends BaseTest
{
    String newPlayListName ="playlist3New";
    String ExpectedMessage = "Updated playlist \"playlist3New.\"";
    @Test
    public void renamePlaylist() {
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);
        basePage.provideEmail("suchitra.kumari@testpro.io");
        basePage.providePassword("SuchitraKumari1@");
        basePage.clickSubmit();

        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlayListName);
        Assert.assertEquals(ExpectedMessage,homePage.actualDisplayedMessage());
        driver.quit();
    }
}