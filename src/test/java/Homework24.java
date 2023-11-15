import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
public class Homework24 extends BaseTest
{
    String newPlayListName ="PlaylistNew1";
    String ExpectedMessage = "Updated playlist \"PlaylistNew1.\"";
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