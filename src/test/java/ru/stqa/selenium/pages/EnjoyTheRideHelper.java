package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnjoyTheRideHelper extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Library at the station')]")
    WebElement customerServiceHader;

    @FindBy(xpath = "//div[@class='content_banner']")
    WebElement customerServiceBanner;

    public EnjoyTheRideHelper(WebDriver driver) {
        super(driver);
    }
    public void waitUntilPageLoaded(){
        this.waitUntilIsLoadedCustomTime(customerServiceBanner,40);
        this.waitUntilIsLoadedCustomTime(customerServiceHader,40);
    }

    public boolean isEnjoyTheRide() {
        return exists(customerServiceHader);
    }
}
