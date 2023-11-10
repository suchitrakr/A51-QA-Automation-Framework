package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Homework22Page extends BasePage
{

    public Homework22Page(WebDriver givenDriver)
    {
        super(givenDriver);
    }
    private By doubleClickPlaylist = By.cssSelector(".playlist:nth-child(3)");
    private By changeNamePlaylist = By.cssSelector("[name='name']");
    private By actualDisplayedMessage = By.xpath("//div[@class=\"success show\"]");

    public void doubleClickPlaylist()
    {
        doubleClick(doubleClickPlaylist);
    }
    public void changeNamePlaylist(String PlayListName)
    {
        findElement(changeNamePlaylist).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        findElement(changeNamePlaylist).sendKeys(PlayListName);
        findElement(changeNamePlaylist).sendKeys(Keys.ENTER);
    }
    public String actualDisplayedMessage()
    {
        return findElement(actualDisplayedMessage).getText();
    }
}


