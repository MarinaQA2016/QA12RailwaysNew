package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

  public void putTextToFieldFrom(String text){
    typeTextToField(fromField, text);
  }
  public void putTextToFieldWhere(String text){
    typeTextToField(toWhereField, text);

  }

  public void clickSearch(){
    searchButton.click();
  }

}
