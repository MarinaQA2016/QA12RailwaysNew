package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerServiceHelper extends Page {

    @FindBy(xpath = "//h1[contains(text(),'Customer service')]")
    WebElement customerServiceHader;

    @FindBy(xpath = "//div[@class='content_banner']")
    WebElement customerServiceBanner;

    public CustomerServiceHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageLoaded(){
        this.waitUntilIsLoadedCustomTime(customerServiceBanner,40);
        this.waitUntilIsLoadedCustomTime(customerServiceHader,40);

    }

    public boolean isCustomerService() {
        return exists(customerServiceHader);
    }
}
