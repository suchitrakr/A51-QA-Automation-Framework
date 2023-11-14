import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
public class Homework23 extends BaseTest
{
    String newPlayListName ="PlaylistNew";
    String ExpectedMessage = "Updated playlist \"PlaylistNew.\"";
    @Test
    public void renamePlaylist() {
        BasePage basePage = new BasePage(driver);
        HomePage homework23Page = new HomePage(driver);
        basePage.provideEmail("suchitra.kumari@testpro.io");
        basePage.providePassword("SuchitraKumari1@");
        basePage.clickSubmit();

        homework23Page.doubleClickPlaylist();
        homework23Page.enterNewPlaylistName(newPlayListName);
        Assert.assertEquals(ExpectedMessage,homework23Page.actualDisplayedMessage());
        driver.quit();
    }
}