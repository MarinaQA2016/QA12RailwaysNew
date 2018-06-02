package ru.stqa.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.SearchResultHelper;

public class HomePageTests extends TestNgTestBase {

  private HomePageHelper homepage;
  private SearchResultHelper searchresut;
  private Alert alert;

  @BeforeMethod
  public void initPageObjects() {

    homepage = PageFactory.initElements(driver, HomePageHelper.class);
    searchresut = PageFactory.initElements(driver, SearchResultHelper.class);
    driver.get(baseUrl);
    System.out.println("isAlert:" + isAlertPresent(driver));
    safeAlertDissmiss();
    /*alert = driver.switchTo().alert();
    alert.dismiss();*/
  }

  @Test (dataProviderClass = DataProviders.class, dataProvider = "positiveSearchTrains")
  public void testSearchTrainsOneWay(String fromStation, String toStation) {
    //String fromStation = "Ako";
    //String toStation = "Ashkelon";
    homepage.waitUntilPageIsLoaded();
    homepage.chooseStationFieldFrom(fromStation);
    homepage.chooseStationFieldToWhere(toStation);
    homepage.clickSearch();
    searchresut.waitUntilPageIsLoaded();

    Assert.assertTrue(searchresut.isFromStationCorrespondsTo(fromStation)
            && searchresut.isToStationCorrespondsTo(toStation));
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveSearchTrains")
  public void testSearchTrainsOneWayHoverCursor(String fromStation, String toStation) {
    // String fromStation = "Ako";
    // String toStation = "Ashkelon";
    homepage.waitUntilPageIsLoaded();
    homepage.chooseStationFieldFromHoverCursor(fromStation);
    homepage.chooseStationFieldToWhereHoverCursor(toStation);
    homepage.clickSearch();
    searchresut.waitUntilPageIsLoaded();

    Assert.assertTrue(searchresut.isFromStationCorrespondsTo(fromStation)
            && searchresut.isToStationCorrespondsTo(toStation));
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "anotherPositiveSearchTrain")
  public void anotherTestSearchTrainsOneWay(String fromStation, String toStation) {
    //driver.get(baseUrl);
    homepage.chooseStationFieldFrom(fromStation);
    homepage.chooseStationFieldToWhere(toStation);
    homepage.clickSearch();

    Assert.assertTrue(searchresut.isFromStationCorrespondsTo(fromStation)
            && searchresut.isToStationCorrespondsTo(toStation));
  }

  public boolean isAlertPresent(WebDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected void safeAlertDissmiss() {
    try {
      driver.switchTo().alert().dismiss();
    } catch (NoAlertPresentException e) {
      // ничего не делаем, алерта итак нет
    }
  }
}
