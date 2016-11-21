package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AddAlbumSteps;
import com.ProjectTestCom.steps.AddItemSteps;
import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
import com.ProjectTestCom.utils.PropertyLoader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t3_ActionsItemStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String Comment = PropertyLoader.getProperty(propertyItemPath, "Comment");
    private String itemID = PropertyLoader.getProperty(propertyItemPath, "itemID");

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
    }

    @After
    public void tearDown() {driver.quit();
    }

    @Test
    public void stage1_ProductSupply_EditCoverImage() throws AWTException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyProductListing(driver);
        //loginSteps.PageComplete(driver);
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        jse1.executeScript("window.scrollBy(0,550)", "");
        addItemSteps.EditSpecialItem(itemID);
        //addItemSteps.collapseMainInfo();
        addItemSteps.collapseMainDetails();
        addItemSteps.ImageContent();
//        addItemSteps.deleteImage();
        addItemSteps.changeCoverImage();
        addItemSteps.collapseStatus();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.checkNewCover();
    }
    @Test
    public void stage2_ProductSupply_EditCoverVideo() {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyProductListing(driver);
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        jse1.executeScript("window.scrollBy(0,550)", "");
        addItemSteps.EditSpecialItem(itemID);
        //addItemSteps.collapseMainInfo();
        addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent();
//        addItemSteps.deleteVideo();
        addItemSteps.changeCoverVideo();
        addItemSteps.collapseContent();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.checkNewCover();
    }
    @Test
    public void stage3_ServiceSupply_EditStatus() {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyServiceListing(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectStatusMenu();
    }
    @Test
    public void stage4_Items_AddComment() {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyServiceListing(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        addItemSteps.addComment(driver, Comment);
        addItemSteps.checkCommentAdded(Comment);

        //loginSteps.Sleep(80);
        loginSteps.PageComplete(driver);
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyEventListing(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        addItemSteps.addComment(driver, Comment);
        addItemSteps.checkCommentAdded(Comment);

        //loginSteps.Sleep(80);
        loginSteps.PageComplete(driver);
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyPartnershipListing(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        addItemSteps.addComment(driver, Comment);
        addItemSteps.checkCommentAdded(Comment);

        //loginSteps.Sleep(80);
        loginSteps.PageComplete(driver);
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyProductListing(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        // JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        // jse1.executeScript("window.scrollBy(0,-100)", "");
        addItemSteps.addComment(driver, Comment);
        addItemSteps.checkCommentAdded(Comment);
    }

}