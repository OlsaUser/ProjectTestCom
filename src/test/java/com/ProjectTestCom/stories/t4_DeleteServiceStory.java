package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.*;
import com.ProjectTestCom.utils.PropertyLoader;
import com.ProjectTestCom.utils.RetryRule;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by olsa on 5/11/2016.
 */
@RunWith(SerenityRunner.class)
public class t4_DeleteServiceStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String Title = PropertyLoader.getProperty(propertyItemPath, "Title");
    private String DescriptionNull = PropertyLoader.getProperty(propertyItemPath, "DescriptionNull");
    private String VideoContent1 = PropertyLoader.getProperty(propertyItemPath, "VideoContent1");


    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    AddItemSteps addItemSteps;

    @Steps
    HeaderSteps headerSteps;

    @Before
    public void setup() throws IOException {
        FirefoxProfile myProfile = new FirefoxProfile(new File(BrowserProfile));
        myProfile.setPreference("network.proxy.socks_port",9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);

       /* headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyServiceListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        addItemSteps.selectDemand();
        addItemSteps.enterBasicInfo(Title, DescriptionNull);
        addItemSteps.selectCategory1();

        addItemSteps.collapseBasicInfo();
        addItemSteps.collapseMainDetails();

        addItemSteps.VideoContent1(VideoContent1);
        addItemSteps.collapseContent();
        // loginSteps.Sleep(500);
        addItemSteps.clickSave(driver);
        //loginSteps.Sleep(100);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);*/
    }
    @After
    public void tearDown() {driver.quit();
    }
    /*************************************************************/
    @Test
    public void DeleteItemService() {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyServiceListing(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectDeleteMenu();
        addItemSteps.clickCancelButton();
        driver.navigate().refresh();

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectDeleteMenu();
        //loginSteps.PageComplete(driver);
        //loginSteps.Sleep(10);
        addItemSteps.clickDeleteButton(driver);
        addItemSteps.checkItemDeleted(driver);
    }
   /* @Test
    public void DeleteItemProduct()  {
        headerSteps.openMyProductListing(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectDeleteMenu();
        addItemSteps.clickDeleteButton(driver);
       // loginSteps.Sleep(10);
        addItemSteps.checkItemDeleted(driver);
    }
    @Test
    public void DeleteItemEvent()  {
        headerSteps.openMyEventListing(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectDeleteMenu();
        //loginSteps.Sleep(100);
        addItemSteps.clickDeleteButton(driver);
       // loginSteps.Sleep(10);
        addItemSteps.checkItemDeleted(driver);
    }
    @Test
    public void DeleteItemPartnership()  {
        headerSteps.openMyPartnershipListing(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectDeleteMenu();
        addItemSteps.clickDeleteButton(driver);
        addItemSteps.checkItemDeleted(driver);
    }
    @Test
    public void CancelDeleteItemService() {
       //headerSteps.openMyServiceListing(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectDeleteMenu();
        addItemSteps.clickCancelButton();
    }*/
}