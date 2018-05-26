package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.HomePage;
import ru.stqa.selenium.pages.SearchResultPage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;
  private SearchResultPage searchresut;

  @BeforeMethod
  public void initPageObjects() {

    homepage = PageFactory.initElements(driver, HomePage.class);
    searchresut = PageFactory.initElements(driver, SearchResultPage.class);
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveSearchTrains")
  public void testSearchTrainsOneWay(String fromStation, String toStation) {
    driver.get(baseUrl);
    homepage.chooseStationFieldFrom(fromStation);
    homepage.chooseStationFieldToWhere(toStation);
    homepage.clickSearch();
    searchresut.waitUntilPageIsLoaded();

    Assert.assertTrue(searchresut.isFromStationCorrespondsTo(fromStation)
            && searchresut.isToStationCorrespondsTo(toStation));
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "anotherPositiveSearchTrain")
  public void anotherTestSearchTrainsOneWay(String fromStation, String toStation) {
    driver.get(baseUrl);
    homepage.chooseStationFieldFrom(fromStation);
    homepage.chooseStationFieldToWhere(toStation);
    homepage.clickSearch();

    Assert.assertTrue(searchresut.isFromStationCorrespondsTo(fromStation)
            && searchresut.isToStationCorrespondsTo(toStation));
  }
}
