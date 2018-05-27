package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Inka on 27-May-18.
 */
public class UpdatesPageHelper extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Updates')]")
    WebElement updatesHeader;

    @FindBy(xpath = "//div[@class='updates_banner']")
    WebElement updatesBanner;

    public UpdatesPageHelper(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public UpdatesPageHelper waitUntilPageIsLoaded(){
        this.waitUntilIsLoadedCustomTime(updatesBanner,40);
        return this;
    }

    public boolean isUpdatesPage(){
        return exists(updatesHeader);
    }
}
