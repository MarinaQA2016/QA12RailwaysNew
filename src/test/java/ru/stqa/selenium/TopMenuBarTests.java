package ru.stqa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;

/**
 * Created by Inka on 27-May-18.
 */
public class TopMenuBarTests extends TestNgTestBase {
    private TopMenuBarHelper topMenuBarHelper;
    private UpdatesPageHelper updatesPageHelper;
    private CustomerServiceHelper customerServicePage;
    private EnjoyTheRideHelper enjoyTheRidePage;
    private FareCalculationPageHelper fareCalculationPage;
    private LinesAndStationsHelper linesAndStationsPage;
    private RavKavHelper ravKavPage;


    @BeforeMethod
    public void initPageObjects(){
     topMenuBarHelper = PageFactory.initElements(driver, TopMenuBarHelper.class);
     updatesPageHelper = PageFactory.initElements(driver, UpdatesPageHelper.class);
        customerServicePage=PageFactory.initElements(driver,CustomerServiceHelper.class);
        enjoyTheRidePage=PageFactory.initElements(driver,EnjoyTheRideHelper.class);
        fareCalculationPage = PageFactory.initElements(driver, FareCalculationPageHelper.class);
        linesAndStationsPage = PageFactory.initElements(driver,LinesAndStationsHelper.class);
        ravKavPage = PageFactory.initElements(driver, RavKavHelper.class);
     driver.get(baseUrl);
     topMenuBarHelper.waitUntilPageIsLoaded();

    }

    @Test
    public void openUpdatesMenuTest(){
        topMenuBarHelper.clickUpdatesMenu();
        updatesPageHelper.waitUntilPageIsLoaded();
        Assert.assertTrue(updatesPageHelper.isUpdatesPage());
    }

    @Test
    public void CustomerServiceMenu(){
        topMenuBarHelper.waitUntilPageIsLoaded();
        topMenuBarHelper.clickCustomerServiceMenu();
        customerServicePage.waitUntilPageLoaded();
        Assert.assertTrue(customerServicePage.isCustomerService());
    }

    @Test
    public void EnjoyTheRideMenu(){
        topMenuBarHelper.waitUntilPageIsLoaded();
        topMenuBarHelper.clickEnjoyTheRideMenu();
        enjoyTheRidePage.waitUntilPageLoaded();
        Assert.assertTrue(enjoyTheRidePage.isEnjoyTheRide());
    }

    @Test
    public void testFareCalculationMenu() {
        topMenuBarHelper.waitUntilPageIsLoaded();
        topMenuBarHelper.clickFareCalculationMenu();
        fareCalculationPage.waitUntilPageLoaded();
        Assert.assertTrue(fareCalculationPage.isFareCalculationPageHelper());
    }

    @Test
    public void LinesAndStationsMenu(){
        topMenuBarHelper.waitUntilPageIsLoaded();
        topMenuBarHelper.clickLinesAndStationsMenu();
        linesAndStationsPage.waitUntilPageLoaded();
        Assert.assertTrue(linesAndStationsPage.isLinesAndStationsPageHelper());
    }

    @Test
    public void RavKavMenu(){
        topMenuBarHelper.waitUntilPageIsLoaded();
        topMenuBarHelper.clickRavKavMenu();
        ravKavPage.waitUntilPageLoaded();
        Assert.assertTrue(ravKavPage.isRavKavHelper());
    }


}
