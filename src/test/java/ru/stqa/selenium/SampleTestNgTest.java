package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveSearchTrains")
  public void testSearchTrainsOneWay(String fromStation, String toStation) {
    driver.get(baseUrl);
    homepage.putTextToFieldFrom(fromStation);
    homepage.putTextToFieldWhere(toStation);
    homepage.clickSearch();

    Assert.assertTrue(true);
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "anotherPositiveSearchTrain")
  public void anotherTestSearchTrainsOneWay(String fromStation, String toStation) {
    driver.get(baseUrl);
    homepage.putTextToFieldFrom(fromStation);
    homepage.putTextToFieldWhere(toStation);
    homepage.clickSearch();

    Assert.assertTrue(true);
  }
}
