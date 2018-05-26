package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(xpath = "//input [@role ='combobox']")
  List<WebElement> fromToFieldsList;

  @FindBy(xpath = "//input[@role = 'combobox'][@placeholder = 'To where?']")
  WebElement toWhereField;

  @FindBy(xpath = "//input[@role = 'combobox'][@placeholder = 'From where?']")
  WebElement fromField;

  @FindBy(xpath = "//button[@type='button'][contains(text(),'Search')]")
  WebElement searchButton;


  public HomePage(WebDriver webDriver) {
    super(webDriver);
    PageFactory.initElements(driver, this);
  }

  public void chooseStationFieldFrom(String stationName){
    fromField.clear();
    fromField.click();
    WebElement el = driver.findElement(By.xpath("//ul[@id='ul-solbox-autocomplete-1']//p[contains(text(),\"" + stationName + "\")]"));
    waitUntilIsLoadedCustomTime(el,45);
    el.click();
    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
  }

  public void chooseStationFieldToWhere(String stationName){
    toWhereField.clear();
    toWhereField.click();
    WebElement el = driver.findElement(By.xpath("//ul[@id='ul-solbox-autocomplete-2']//p[contains(text(),\"" + stationName + "\")]"));
    waitUntilIsLoadedCustomTime(el,45);
    el.click();
    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
  }

  public void clickSearch(){
    searchButton.click();
  }


}
