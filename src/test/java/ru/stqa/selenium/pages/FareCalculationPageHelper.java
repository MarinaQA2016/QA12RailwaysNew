package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FareCalculationPageHelper extends Page {
    @FindBy(xpath = "//h1[contains(text(),'Fare calculation and ticket purchase')]")
    WebElement fareCalculationHader;

    @FindBy(xpath = "//div[@class='enjoy_banner']")
    WebElement fareCalculationBanner;

    public FareCalculationPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageLoaded() {
        this.waitUntilIsLoadedCustomTime(fareCalculationBanner,40);
        this.waitUntilIsLoadedCustomTime(fareCalculationHader, 40);
    }

    public boolean isFareCalculationPageHelper() {
        return exists(fareCalculationHader);
    }
}
