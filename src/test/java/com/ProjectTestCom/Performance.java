package com.ProjectTestCom;

import com.ProjectTestCom.steps.*;
import com.ProjectTestCom.utils.PropertyLoader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by olsa on 5/17/2016.
 */
@RunWith(SerenityRunner.class)
public class Performance {
    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String ServiceListing = PropertyLoader.getProperty(propertyFilePath, "ServiceListing");
    private String ProductListing = PropertyLoader.getProperty(propertyFilePath, "ProductListing");
    private String EventListing = PropertyLoader.getProperty(propertyFilePath, "EventListing");
    private String PartnershipListing = PropertyLoader.getProperty(propertyFilePath, "PartnershipListing");
    private String MyServiceListing = PropertyLoader.getProperty(propertyFilePath, "MyServiceListing");
    private String MyProductListing = PropertyLoader.getProperty(propertyFilePath, "MyProductListing");
    private String MyEventListing = PropertyLoader.getProperty(propertyFilePath, "MyEventListing");
    private String MyPartnershipListing = PropertyLoader.getProperty(propertyFilePath, "MyPartnershipListing");
    private String MyMedia = PropertyLoader.getProperty(propertyFilePath, "MyMedia");
    private String ViewAlbum = PropertyLoader.getProperty(propertyFilePath, "ViewAlbum");
    private String MyMnassa = PropertyLoader.getProperty(propertyFilePath, "MyMnassa");
    private String MyWall = PropertyLoader.getProperty(propertyFilePath, "MyWall");
    private String MyGroups = PropertyLoader.getProperty(propertyFilePath, "MyGroups");
    private String Groups = PropertyLoader.getProperty(propertyFilePath, "Groups");
    private String MyGroupWall = PropertyLoader.getProperty(propertyFilePath, "MyGroupWall");
    private String DiscoverPage = PropertyLoader.getProperty(propertyFilePath, "DiscoverPage");
    private String urlUserProfile_Perform = PropertyLoader.getProperty(propertyFilePath, "urlUserProfile_Perform");
    private String urlItem = PropertyLoader.getProperty(propertyFilePath, "urlItem");
    private String urlGroupPage = PropertyLoader.getProperty(propertyFilePath, "urlGroupPage");
    private String viewItem = PropertyLoader.getProperty(propertyFilePath, "viewItem");

    private String DiscoverUserActive = PropertyLoader.getProperty(propertyFilePath, "DiscoverUserActive");
    private String DiscoverUserNew = PropertyLoader.getProperty(propertyFilePath, "DiscoverUserNew");
    private String DiscoverUserPopular = PropertyLoader.getProperty(propertyFilePath, "DiscoverUserPopular");
    private String DiscoverItemPopular = PropertyLoader.getProperty(propertyFilePath, "DiscoverItemPopular");
    private String DiscoverItemNew = PropertyLoader.getProperty(propertyFilePath, "DiscoverItemNew");
    private String DiscoverPostPopular = PropertyLoader.getProperty(propertyFilePath, "DiscoverPostPopular");
    private String DiscoverPostNew = PropertyLoader.getProperty(propertyFilePath, "DiscoverPostNew");
    private String DiscoverGroupsPopular = PropertyLoader.getProperty(propertyFilePath, "DiscoverGroupsPopular");
    private String DiscoverGroupsNew = PropertyLoader.getProperty(propertyFilePath, "DiscoverGroupsNew");

    private String HomePage = PropertyLoader.getProperty(propertyFilePath, "HomePage");
    private String NotificationPage = PropertyLoader.getProperty(propertyFilePath, "NotificationPage");
    private String AccountSettings = PropertyLoader.getProperty(propertyFilePath, "AccountSettings");
    private String Message = PropertyLoader.getProperty(propertyFilePath, "Message");
    private String MyFollowers = PropertyLoader.getProperty(propertyFilePath, "MyFollowers");
    private String MyFollowings = PropertyLoader.getProperty(propertyFilePath, "MyFollowings");
    private String viewAccountSettings = PropertyLoader.getProperty(propertyFilePath, "viewAccountSettings");
    private String Login = PropertyLoader.getProperty(propertyFilePath, "Login");
    private String AddItem = PropertyLoader.getProperty(propertyFilePath, "AddItem");
    private String openUserWallPage = PropertyLoader.getProperty(propertyFilePath, "openUserWallPage");
    private String openUserProductListing = PropertyLoader.getProperty(propertyFilePath, "openUserProductListing");
    private String openUserServiceListing = PropertyLoader.getProperty(propertyFilePath, "openUserServiceListing");
    private String openUserEventListing = PropertyLoader.getProperty(propertyFilePath, "openUserEventListing");

    private String openUserGroupListing = PropertyLoader.getProperty(propertyFilePath, "openUserGroupListing");
    private String openUserPartnershipListing = PropertyLoader.getProperty(propertyFilePath, "openUserPartnershipListing");
    private String openUserMediaPage = PropertyLoader.getProperty(propertyFilePath, "openUserMediaPage");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    HeaderSteps headerSteps;

    @Before
    public void setup() throws IOException {
        /*FirefoxProfile myProfile = new FirefoxProfile(new File("D:/SeleniumProfile"));
        myProfile.setPreference("network.proxy.socks_port", 9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);*/

       /* FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "proxy.corp.isddesign.com");
        profile.setPreference("network.proxy.http_port", 8080);
        profile.setPreference("network.proxy.share_proxy_settings", true);
        profile.setPreference("network.proxy.no_proxies_on", "");
        Serenity.useFirefoxProfile(profile);
        driver = new FirefoxDriver(profile);*/

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);

        loginSteps.openLoginPage();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void PerformanceTest() throws IOException {
        loginSteps.pageLoad(Login);

        headerSteps.openProductListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(ProductListing);

        headerSteps.openEventListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(EventListing);

        headerSteps.openPartnershipListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(PartnershipListing);

        headerSteps.openServiceListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(ServiceListing);

        headerSteps.openMessagePage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(Message);

        headerSteps.openNotificationPage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(NotificationPage);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(HomePage);

//Discover pages
        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverItemNew);
        headerSteps.openDiscoverItemPopular(driver);
        loginSteps.PageComplete(driver);
       // headerSteps.openDiscoverItemNew(driver);
       // loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPostNew(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverPostNew);
        headerSteps.openDiscoverPostTrending(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openDiscoverPostPopular(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverUserPopular(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverUserPopular);
        headerSteps.openDiscoverUserActive(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openDiscoverUserNew(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverGroupsPopular(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverGroupsPopular);
        headerSteps.openDiscoverGroupsNew(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(AccountSettings);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyMnassa);

        headerSteps.openMyMedia(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyMedia);

        headerSteps.openMyWall(driver);
        loginSteps.pageLoad(MyWall);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyGroups);

        headerSteps.MyGroupWall(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyGroupWall);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyServiceListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyServiceListing);

        headerSteps.openMyProductListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyProductListing);

        headerSteps.openMyEventListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyEventListing);

        headerSteps.openMyPartnershipListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyPartnershipListing);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);

//User Info page
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(viewAccountSettings);

        driver.get(urlUserProfile_Perform);
        headerSteps.openUserWallPage(driver);
        headerSteps.openUserProductListing(driver);
        headerSteps.openUserServiceListing(driver);
        headerSteps.openUserEventListing(driver);
        headerSteps.openUserGroupListing(driver);
        headerSteps.openUserPartnershipListing(driver);
        headerSteps.openUserMediaPage(driver);

        headerSteps.openMyFollowers(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyFollowers);

        headerSteps.openMyFollowings(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyFollowings);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openGroupsListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(Groups);

        driver.get(urlItem);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(viewItem);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);
        driver.get(urlGroupPage);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyGroupWall);
    }
}