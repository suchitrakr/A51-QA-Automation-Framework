package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
       public HomePage(WebDriver givenDriver)
    {
        super(givenDriver);
    }
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement doubleClickPlaylist;

    @FindBy(css = "[name='name']")
    private WebElement changeNamePlaylist;

    @FindBy(css = "div.success.show")
    private WebElement actualDisplayedMessage;

    public void doubleClickPlaylist()
    {
        actions.doubleClick(doubleClickPlaylist).build().perform();
    }
    public void enterNewPlaylistName(String playlistName)
    {
        changeNamePlaylist.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        changeNamePlaylist.sendKeys(playlistName);
        changeNamePlaylist.sendKeys(Keys.ENTER);
    }
    public String actualDisplayedMessage()
    {
        return actualDisplayedMessage.getText();
    }
}

