package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AddItemSteps;
import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
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
@RunWith(SerenityRunner.class)
public class t4_DeleteProductStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String Title = PropertyLoader.getProperty(propertyItemPath, "Title");
    private String DescriptionNull = PropertyLoader.getProperty(propertyItemPath, "DescriptionNull");
    private String Price = PropertyLoader.getProperty(propertyItemPath, "Price");
    private String PerNull = PropertyLoader.getProperty(propertyItemPath, "PerNull");
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
        loginSteps.PageComplete(driver);

       /* headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyProductListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(Title, DescriptionNull);
        addItemSteps.selectCategory1();

        addItemSteps.collapseBasicInfo();
        addItemSteps.enterPrice(Price, PerNull);

        addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent1(VideoContent1);

        addItemSteps.collapseContent();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);
        */
    }
    @After
    public void tearDown() {driver.quit();
    }
    /*************************************************************/

    @Test
    public void DeleteItemProduct()  {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyProductListing(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectDeleteMenu();
        addItemSteps.clickDeleteButton(driver);
        addItemSteps.checkItemDeleted(driver);
        loginSteps.PageComplete(driver);
    }
}
