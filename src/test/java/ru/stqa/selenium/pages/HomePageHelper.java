package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Sample page
 */
public class HomePageHelper extends Page {

  @FindBy(xpath = "//input [@role ='combobox']")
  List<WebElement> fromToFieldsList;

  @FindBy(xpath = "//input[@role = 'combobox'][@placeholder = 'To where?']")
  WebElement toWhereField;

  @FindBy(xpath = "//input[@role = 'combobox'][@placeholder = 'From where?']")
  WebElement fromField;

  @FindBy(xpath = "//button[@type='button'][contains(text(),'Search')]")
  WebElement searchButton;


  public HomePageHelper(WebDriver webDriver) {
    super(webDriver);
    PageFactory.initElements(driver, this);
  }

  Actions builder = new Actions(driver);

  public HomePageHelper waitUntilPageIsLoaded(){
    this.waitUntilIsLoadedCustomTime(fromField, 45);
    this.waitUntilIsLoadedCustomTime(toWhereField,45);
    this.waitUntilIsLoadedCustomTime(searchButton,45);
    return this;
  }

  public void chooseStationFieldFrom(String stationName){
    fromField.clear();
    fromField.click();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    WebElement el = driver.findElement(By.xpath("//ul[@id='ul-solbox-autocomplete-1']//p[contains(text(),\"" + stationName + "\")]"));
    waitUntilIsLoadedCustomTime(el,45);
    el.click();

    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }
  public void chooseStationFieldToWhere(String stationName){

    toWhereField.clear();
    toWhereField.click();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    WebElement el = driver.findElement(By.xpath("//ul[@id='ul-solbox-autocomplete-2']//p[contains(text(),\"" + stationName + "\")]"));
    System.out.println("Value#1 of the element ToWhere : " + el.getText());
    waitUntilIsLoadedCustomTime(el,45);
    System.out.println("Value#2 of the element ToWhere : " + el.getText());
    el.click();

    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

  }

  public void chooseStationFieldFromHoverCursor(String stationName){
    fromField.clear();
    fromField.click();
    this.typeTextToField(fromField, stationName.substring(0,2).toLowerCase());
    WebElement el = driver.findElement(By.xpath("//ul[@id='ul-solbox-autocomplete-1']//p[contains(text(),\"" + stationName + "\")]"));
    waitUntilIsLoadedCustomTime(el,45);
    builder.moveToElement(el).perform();
    el.click();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }

  public void chooseStationFieldToWhereHoverCursor(String stationName){
    toWhereField.clear();
    toWhereField.click();
    this.typeTextToField(toWhereField,stationName.substring(0,2).toLowerCase());
    WebElement el = driver.findElement(By.xpath("//ul[@id='ul-solbox-autocomplete-2']//p[contains(text(),\"" + stationName + "\")]"));

    waitUntilIsLoadedCustomTime(el,45);
    builder.moveToElement(el).perform();
    el.click();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }

  public void clickSearch(){
    searchButton.click();
  }


}
