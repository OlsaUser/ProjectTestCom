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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

@RunWith(SerenityRunner.class)
public class t3_MemberGroupPageStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String propertyFilePath = "src/test/resources/login.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String urlGroupPage = PropertyLoader.getProperty(propertyFilePath, "urlGroupPage");

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
    public void memberOwnGroupPage() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.MyGroupWallforInvate(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.checkTextOnOwnGroupMemberPage( );
        addGroupSteps.checkElementsPresent();
    }

    @Test
    public void memberUserGroupPage() throws IOException {
        driver.get(urlGroupPage);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkTextOnUserGroupMemberPage(driver);
        addGroupSteps.checkElementsAbsent();
    }
}