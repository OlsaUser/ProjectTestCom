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
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t2_PinPostStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String propertyFilePath = "src/test/resources/login.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

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
    private String PinPlaceholder = PropertyLoader.getProperty(propertyPostPath, "PinPlaceholder");
    private String UnPinPlaceholder = PropertyLoader.getProperty(propertyPostPath, "UnPinPlaceholder");

    private String propertyGroupPath = "src/test/resources/group.properties";
    private String Group1 = PropertyLoader.getProperty(propertyGroupPath, "Group1");

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
    public void stage1_Pin_MyWall() throws IOException{
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        //Add new Post
        addPostSteps.AddTextPost(textPostAr, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostAr, driver);
        addPostSteps.checkCounterRepost(driver, "0");

        //Make pin
        addPostSteps.openPostMenu();
        addPostSteps.selectPin();
        addPostSteps.checkPinPlaceholder(PinPlaceholder);
        addPostSteps.pressViewNow();
        loginSteps.PageComplete(driver);
        addPostSteps.checkPinIconPresent();

        addPostSteps.AddTextPost(textPostMin, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);

        addPostSteps.checkPinIconPresent();
    }
    @Test
    public void stage2_UnPin_MyWall() throws IOException{
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        //Make Unpin
        addPostSteps.openPostMenu();
        addPostSteps.selectPin();
        addPostSteps.checkUnPinPlaceholder(UnPinPlaceholder);
        addPostSteps.pressViewNow();
        loginSteps.PageComplete(driver);
        addPostSteps.checkPinIconAbsent();
    }

    @Test
    public void stage3_Pin_MyGroup() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group1);
        loginSteps.PageComplete(driver);

        addPostSteps.AddTextPost(textPostMin, driver);
        addPostSteps.openVideoPopup();
        addPostSteps.AddVideoLink(VideoLink);
        addPostSteps.clickVideoPostButton(driver);
        addPostSteps.clickPostBtn(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkContentInPost(driver);

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");

        addPostSteps.openPostMenu();
        addPostSteps.selectPin();
        addPostSteps.checkPinPlaceholder(PinPlaceholder);
        addPostSteps.pressViewNow();
        loginSteps.PageComplete(driver);
        addPostSteps.checkPinIconPresent();

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group1);
        loginSteps.PageComplete(driver);

        addPostSteps.AddTextPost(textPostMin, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);

        addPostSteps.checkPinIconPresent();
    }
}