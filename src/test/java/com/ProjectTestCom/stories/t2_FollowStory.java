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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class t2_FollowStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String urlUserProfile1 = PropertyLoader.getProperty(propertyFilePath, "urlUserProfile1");
    private String urlItem = PropertyLoader.getProperty(propertyFilePath, "urlItem");
    private String Item_Owner = PropertyLoader.getProperty(propertyFilePath, "Item_Owner");
    private String Profile_FullName = PropertyLoader.getProperty(propertyFilePath, "Profile_FullName");

    //private String searchFilePath = "src/test/resources/search.properties";
    private String searchFilePath = "src/test/resources/search_beta.properties";
    private String UserForFollow = PropertyLoader.getProperty(searchFilePath, "UserForFollow");
    private String FullOrganizationForFollow = PropertyLoader.getProperty(searchFilePath, "FullOrganizationForFollow");

    private String profileFilePath = "src/test/resources/profile.properties";
    private String classFollowing_Listing = PropertyLoader.getProperty(profileFilePath, "classFollowing_Listing");
    private String classFollowing_UserProfile = PropertyLoader.getProperty(profileFilePath, "classFollowing_UserProfile");
    private String classFollowing_ItemPage = PropertyLoader.getProperty(profileFilePath, "classFollowing_ItemPage");

    private String xpath2 = PropertyLoader.getProperty(profileFilePath, "xpath2");
    private String xpath1 = PropertyLoader.getProperty(profileFilePath, "xpath1");

    @Managed
    WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    @Steps
    FollowSteps followSteps;

    @Steps
    SearchSteps searchSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    AddItemSteps addItemSteps;

    @Before
    public void setup() throws IOException {
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", dir + "\\src\\drivers\\geckodriver.exe");

        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        loginSteps.pressLoginLink();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }
    @After
    public void tearDown() {driver.quit();
    }

    @Test
    public void Search_Follow_User()  {
        searchSteps.clickField_searchBy(UserForFollow, driver);
        searchSteps.selectSearchResult_byUser(UserForFollow, driver);
        loginSteps.PageComplete(driver);

        followSteps.addToFollowing(xpath1, UserForFollow, driver, classFollowing_Listing);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openMyFollowings(driver);
        loginSteps.PageComplete(driver);

        followSteps.openMyFollowingsPageAndCheck(driver, UserForFollow);
    }

    @Test
    public void Search_Follow_Organization()  {
        searchSteps.clickField_searchBy(FullOrganizationForFollow, driver);
        searchSteps.selectSearchResult_byOrganization(FullOrganizationForFollow, driver);
        loginSteps.PageComplete(driver);

        followSteps.addToFollowing(xpath1, FullOrganizationForFollow,driver, classFollowing_Listing);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openMyFollowings(driver);
        loginSteps.PageComplete(driver);

        followSteps.openMyFollowingsPageAndCheck(driver, FullOrganizationForFollow);
    }

    @Test
    public void Profile_Follow()  {
        driver.get(urlUserProfile1);
        loginSteps.PageComplete(driver);

        followSteps.addToFollowing(xpath2, Profile_FullName,driver, classFollowing_UserProfile);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openMyFollowings(driver);
        loginSteps.PageComplete(driver);

        followSteps.openMyFollowingsPageAndCheck(driver, Profile_FullName);
    }

    @Test
    public void viewItem_Follow() {
        driver.get(urlItem);
        loginSteps.PageComplete(driver);

        followSteps.addToFollowing(xpath1,Item_Owner,driver, classFollowing_ItemPage);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openMyFollowings(driver);
        loginSteps.PageComplete(driver);

        followSteps.openMyFollowingsPageAndCheck(driver, Item_Owner);
    }
}
