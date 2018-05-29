package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Inka on 26-May-18.
 */
public class SearchResultHelper extends Page {
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


    public SearchResultHelper(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public SearchResultHelper waitUntilPageIsLoaded(){
        this.waitUntilIsLoadedCustomTime(newSearchButton,45);
        this.waitUntilIsLoadedCustomTime(showStationFromLink,45);
        this.waitUntilIsLoadedCustomTime(showStationToLink, 45);
        this.waitUntilIsLoadedCustomTime(fromStationInfo,45);
        this.waitUntilIsLoadedCustomTime(toStationInfo,45);
        return this;
    }

    public boolean isFromStationCorrespondsTo(String correctValue){
        return fromStationInfo.getText().replace("station ", "").equals(correctValue);
    }

    public boolean isToStationCorrespondsTo(String correctValue){
        return toStationInfo.getText().replace("station ", "").equals(correctValue);
    }

}
