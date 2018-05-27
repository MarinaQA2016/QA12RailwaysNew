package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Inka on 27-May-18.
 */
public class TopMenuBarHelper extends Page  {

    @FindBy(xpath = "//a[contains(text(),'Updates')]")
    WebElement menuUpdates;

    @FindBy(xpath = "//ul[@class='nav navbar-nav noindex']")
    WebElement menuBar;

    @FindBy(xpath = "//img[@alt='Israel Railways - Home Page']")
    WebElement logo;

    public TopMenuBarHelper(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public TopMenuBarHelper clickUpdatesMenu(){
        this.menuUpdates.click();
        return this;
    }

    public TopMenuBarHelper waitUntilPageIsLoaded(){
        this.waitUntilIsLoadedCustomTime(menuBar,40);
        this.waitUntilIsLoadedCustomTime(logo,40);
        return this;
    }
}
