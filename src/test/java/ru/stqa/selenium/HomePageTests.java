package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.SearchResultHelper;

public class HomePageTests extends TestNgTestBase {

  private HomePageHelper homepage;
  private SearchResultHelper searchresut;

  @BeforeMethod
  public void initPageObjects() {

    homepage = PageFactory.initElements(driver, HomePageHelper.class);
    searchresut = PageFactory.initElements(driver, SearchResultHelper.class);
    driver.get(baseUrl);
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
}
