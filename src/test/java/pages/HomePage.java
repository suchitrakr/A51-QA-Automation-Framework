package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    // WebElements specific to the home page
    @FindBy(css = ".playlist:nth-child(4)")
    private WebElement doubleClickPlaylist;

    @FindBy(css = "[name='name']")
    private WebElement changeNamePlaylist;

    @FindBy(css = "div.success.show")
    private WebElement actualDisplayedMessage;

    // Constructor to initialize the WebDriver through the BasePage constructor
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Method to perform a double click on the playlist element
    public void doubleClickPlaylist() {
        actions.doubleClick(findElement(doubleClickPlaylist)).perform();
    }

    // Method to enter a new playlist name, select the existing text, and submit the changes
    public void enterNewPlaylistName(String namePlayList) {
        WebElement playlistElement = findElement(changeNamePlaylist);

        // Clear existing text, enter new text, select all, and submit
        playlistElement.sendKeys(namePlayList);
        playlistElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistElement.sendKeys(namePlayList);
        playlistElement.sendKeys(Keys.ENTER);
    }

    // Method to retrieve the text of the actual displayed message element
    public String actualDisplayedMessage() {
        return findElement(actualDisplayedMessage).getText();
    }
}