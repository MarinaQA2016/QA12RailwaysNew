package ru.stqa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.Page;
import ru.stqa.selenium.pages.TopMenuBarHelper;
import ru.stqa.selenium.pages.UpdatesPageHelper;

/**
 * Created by Inka on 27-May-18.
 */
public class TopMenuBarTests extends TestNgTestBase {
    private TopMenuBarHelper topMenuBarHelper;
    private UpdatesPageHelper updatesPageHelper;

    @BeforeMethod
    public void initPageObjects(){
     topMenuBarHelper = PageFactory.initElements(driver, TopMenuBarHelper.class);
     updatesPageHelper = PageFactory.initElements(driver, UpdatesPageHelper.class);
     driver.get(baseUrl);
     topMenuBarHelper.waitUntilPageIsLoaded();

    }

    @Test
    public void openUpdatesMenuTest(){
        topMenuBarHelper.clickUpdatesMenu();
        updatesPageHelper.waitUntilPageIsLoaded();
        Assert.assertTrue(updatesPageHelper.isUpdatesPage());
    }


}
