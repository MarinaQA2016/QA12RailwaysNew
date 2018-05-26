package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Inka on 26-May-18.
 */
public class SearchResultPage extends Page {
    @FindBy(xpath = "//a[@onclick='showTabFrom()']")
    WebElement showStationFromLink;

    @FindBy(xpath = "//a[@onclick='showTabTo()']")
    WebElement showStationToLink;

    @FindBy(xpath = "//div[@class='newSearchArea']/button")
    WebElement newSearchButton;

    @FindBy(xpath = "//a[@onclick = 'showTabFrom()']/../h3")
    WebElement fromStationInfo;

    @FindBy(xpath = "//a[@onclick = 'showTabTo()']/../h3")
    WebElement toStationInfo;


    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public SearchResultPage waitUntilPageIsLoaded(){
        this.waitUntilIsLoadedCustomTime(newSearchButton,30);
        this.waitUntilIsLoadedCustomTime(showStationFromLink,30);
        this.waitUntilIsLoadedCustomTime(showStationToLink, 30);
        return this;
    }

    public boolean isFromStationCorrespondsTo(String correctValue){
        return fromStationInfo.getText().replace("station ", "").equals(correctValue);
    }

    public boolean isToStationCorrespondsTo(String correctValue){
        return toStationInfo.getText().replace("station ", "").equals(correctValue);
    }

}
