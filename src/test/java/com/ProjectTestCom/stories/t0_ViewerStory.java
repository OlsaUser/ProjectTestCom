package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.*;
import com.ProjectTestCom.utils.PropertyLoader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

@RunWith(SerenityRunner.class)
public class t0_ViewerStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String urlUserProfile_Perform = PropertyLoader.getProperty(propertyFilePath, "urlUserProfile_Perform");
    private String urlItem = PropertyLoader.getProperty(propertyFilePath, "urlItem");
    private String RequestText = PropertyLoader.getProperty(propertyFilePath, "RequestText");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String requestTitle = PropertyLoader.getProperty(propertyItemPath, "requestTitle");
    private String messageLabel = PropertyLoader.getProperty(propertyItemPath, "messageLabel");
    private String attachLabel = PropertyLoader.getProperty(propertyItemPath, "attachLabel");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    NewMessageSteps newMessageSteps;

    @Steps
    AddItemSteps addItemSteps;

    @Steps
    AccountSettingsSteps accountSettingsSteps;

    @Before
    public void setup() throws IOException {
        driver.manage().window().maximize();

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();
    }

    @Test
    public void Message_Viewer() {
        headerSteps.openMessagePage(driver);
        loginSteps.PageComplete(driver);
        newMessageSteps.ViewerPageElements(driver);
    }

    @Test
    public void ItemBlock_Viewer() {
        headerSteps.openHomePage(driver);
        headerSteps.openProductListing(driver);
        addItemSteps.ViewerItemBlock(driver);
    }

    @Test
    public void UserInfo_Viewer() {
        headerSteps.openDiscoverPage(driver);
        driver.get(urlUserProfile_Perform);
        accountSettingsSteps.UserInfo_Viewer(driver);
    }

    @Test
    public void DiscoverUser_Viewer() {
        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverUserPopular(driver);
        headerSteps.viewUserListing_Discover(driver);
    }

    @Test
    public void DiscoverGroup_Viewer() {
        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverGroupsPopular(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewGroup_Discover(driver);
    }

    @Test
    public void DiscoverPost_Viewer() {
        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverPostNew(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewPost_Discover(driver);
    }
    @Test
    public void Item_Viewer() {
        headerSteps.openDiscoverPage(driver);
        driver.get(urlItem);
        loginSteps.PageComplete(driver);

        //addItemSteps.openViewItemPage(driver);
        addItemSteps.ViewerItemPage(driver);

        addItemSteps.pressRequestForm(driver, requestTitle, messageLabel, attachLabel);
        addItemSteps.enterRequestText(driver, RequestText);
        addItemSteps.pressSendRequestButton(driver);
    }
}
