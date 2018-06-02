package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinesAndStationsHelper extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Lines and Stations')]")
    WebElement linesAndStationsHader;

    @FindBy(xpath = "//img[@id='railMap']")
    WebElement linesAndStationsMap;

    public LinesAndStationsHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageLoaded(){
        this.waitUntilIsLoadedCustomTime(linesAndStationsMap,40);
        this.waitUntilIsLoadedCustomTime(linesAndStationsHader,40);
    }

    public boolean isLinesAndStationsPageHelper() {
        return exists(linesAndStationsHader);
    }
}
