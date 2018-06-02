package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RavKavHelper extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Rav-Kav')]")
    WebElement ravKavHader;

    @FindBy(xpath = "//div[@class='enjoy_banner']")
    WebElement ravKavBanner;

    public RavKavHelper(WebDriver driver) {
        super(driver);
    }
    public void waitUntilPageLoaded(){
        this.waitUntilIsLoadedCustomTime(ravKavBanner,40);
        this.waitUntilIsLoadedCustomTime(ravKavHader,40);
    }

    public boolean isRavKavHelper() {
        return exists(ravKavHader);
    }
}
