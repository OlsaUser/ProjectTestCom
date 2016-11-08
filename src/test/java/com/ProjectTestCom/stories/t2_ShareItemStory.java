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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
public class t2_ShareItemStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String propertyFilePath = "src/test/resources/login.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String placeholderShareItemToWall = PropertyLoader.getProperty(propertyItemPath, "placeholderShareItemToWall");
    private String placeholderShareItemToGroup = PropertyLoader.getProperty(propertyItemPath, "placeholderShareItemToGroup");
    private String HeaderShareItem = PropertyLoader.getProperty(propertyItemPath, "HeaderShareItem");

    private String propertyPostPath = "src/test/resources/post.properties";
    private String textPostMin = PropertyLoader.getProperty(propertyPostPath, "textPostMin");
    private String textPostMaxEn = PropertyLoader.getProperty(propertyPostPath, "textPostMaxEn");
    private String textPostAr = PropertyLoader.getProperty(propertyPostPath, "textPostAr");
    private String addPost = PropertyLoader.getProperty(propertyPostPath, "addPost");
    private String Comment = PropertyLoader.getProperty(propertyPostPath, "Comment");
    private String placeholderGroup = PropertyLoader.getProperty(propertyPostPath, "placeholderGroup");
    private String placeholderWall = PropertyLoader.getProperty(propertyPostPath, "placeholderWall");
    private String HeaderRepost = PropertyLoader.getProperty(propertyPostPath, "HeaderRepost");
    private String AudioLink = PropertyLoader.getProperty(propertyPostPath, "AudioLink");
    private String VideoLink = PropertyLoader.getProperty(propertyPostPath, "VideoLink");

    private String propertyGroupPath = "src/test/resources/group.properties";
    private String Group1 = PropertyLoader.getProperty(propertyGroupPath, "Group1");
    private String Group2 = PropertyLoader.getProperty(propertyGroupPath, "Group2");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    FavoritesSteps favoritesSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    AddPostSteps addPostSteps;

    @Steps
    AddGroupSteps addGroupSteps;

    @Steps
    AddItemSteps addItemSteps;

    @Before
    public void setup() throws IOException {
        FirefoxProfile myProfile = new FirefoxProfile(new File(BrowserProfile));
        myProfile.setPreference("network.proxy.socks_port",9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);

        loginSteps.openLoginPage();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void shareProductToWall() throws IOException{
        headerSteps.openProductListing(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.openViewItemByClickOnBlock(driver);

        addItemSteps.pressShareButton(driver);
        addItemSteps.pressShareToWall(driver);
        addItemSteps.checkInformTextShareItem(driver, placeholderShareItemToWall);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openMyWall(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.checkShareItemExists(driver, HeaderShareItem);

        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,1100)", "");
        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToGroup(driver);
        addPostSteps.selectGroupInDropdown();
        addPostSteps.pressPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderGroup);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group2);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPostMin, HeaderShareItem);
    }

    @Test
    public void shareServiceToGroup() throws IOException{
        headerSteps.openServiceListing(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.openViewItemByClickOnBlock(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.pressShareButton(driver);
        addItemSteps.pressShareToGroup(driver);
        addItemSteps.selectGroupInDropdown(driver);
        addItemSteps.pressPostToGroup(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.checkInformTextShareItem(driver, placeholderShareItemToGroup);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group2);
        loginSteps.PageComplete(driver);
        addItemSteps.checkShareItemExists(driver, HeaderShareItem);

        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,1100)", "");

        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToWall(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderWall);

        headerSteps.openHomePage(driver);
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyWall(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPostMin, HeaderShareItem);
    }
}