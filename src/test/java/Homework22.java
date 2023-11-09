import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Homework22Page;

public class Homework22 extends BaseTest
{
    String newPlayListName ="PlaylistNew";

    String ExpectedMessage = "Updated playlist \"PlaylistNew.\"";
    @Test
    public void renamePlaylist()
    {
        BasePage basePage = new BasePage(driver);
        Homework22Page homework22Page = new Homework22Page(driver);
        basePage.provideEmail("suchitra.kumari@testpro.io");
        basePage.providePassword("SuchitraKumari1@");
        basePage.clickSubmit();

        homework22Page.doubleClickPlaylist();
        homework22Page.changeNamePlaylist(newPlayListName);
        Assert.assertEquals(ExpectedMessage,homework22Page.actualDisplayedMessage());
        driver.quit();
    }
}
