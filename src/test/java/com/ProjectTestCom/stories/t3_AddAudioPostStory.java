package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AddGroupSteps;
import com.ProjectTestCom.steps.AddPostSteps;
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class t3_AddAudioPostStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyPostPath = "src/test/resources/post.properties";
    private String textPostMin = PropertyLoader.getProperty(propertyPostPath, "textPostMin");
    private String textPost = PropertyLoader.getProperty(propertyPostPath, "textPost");
    private String textPostMaxEn = PropertyLoader.getProperty(propertyPostPath, "textPostMaxEn");
    private String textPostAr = PropertyLoader.getProperty(propertyPostPath, "textPostAr");
    private String addPost = PropertyLoader.getProperty(propertyPostPath, "addPost");
    private String Comment = PropertyLoader.getProperty(propertyPostPath, "Comment");
    private String AudioLink = PropertyLoader.getProperty(propertyPostPath, "AudioLink");

    private String propertyGroupPath = "src/test/resources/group.properties";
    private String Group1 = PropertyLoader.getProperty(propertyGroupPath, "Group1");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    AddPostSteps addPostSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    AddGroupSteps addGroupSteps;

    @Before
    public void setup() throws IOException {
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", dir + "\\src\\drivers\\geckodriver.exe");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        loginSteps.pressLoginLink();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
    }

    @After
    public void tearDown() {driver.quit();}

 /*   @Test
    public void AudioPostHomePage() throws IOException {
        addPostSteps.openAudioPopup(driver);
        addPostSteps.AddAudioLink(AudioLink);
        addPostSteps.clickAudioPostButton(driver);
        addPostSteps.clickPostBtn(driver);
        addPostSteps.checkAudioContentInPost(driver);*/

      /*  addPostSteps.openMyMnassaPage();
        loginSteps.Sleep(100);
        addPostSteps.openMyGroupsPage();
        loginSteps.Sleep(100);
        addPostSteps.openMyGroupWall();
        loginSteps.Sleep(100);
        addPostSteps.AddTextPost(textPost);
        loginSteps.Sleep(900);
        addPostSteps.openAudioPopup();
        loginSteps.Sleep(100);
        addPostSteps.AddAudioLink(AudioLink);
        loginSteps.Sleep(100);
        addPostSteps.clickAudioPostButton(driver);
        loginSteps.Sleep(100);
        addPostSteps.clickPostBtn(driver);
        loginSteps.Sleep(100);
        addPostSteps.checkAudioContentInPost(driver);

        headerSteps.openHomePage(driver);
        loginSteps.Sleep(100);
        addPostSteps.openGroupsPage();
        loginSteps.Sleep(100);
        addPostSteps.openGroupWall();
        loginSteps.Sleep(100);
        addPostSteps.clickPostArea();
        //loginSteps.Sleep(100);
        addPostSteps.openAudioPopup();
        loginSteps.Sleep(100);
        addPostSteps.AddAudioLink(AudioLink);
        loginSteps.Sleep(100);
        addPostSteps.clickAudioPostButton(driver);
        loginSteps.Sleep(100);
        addPostSteps.clickPostBtn(driver);
        loginSteps.Sleep(100);
        addPostSteps.checkAudioContentInPost(driver);

        addPostSteps.openMyMnassaPage();
        loginSteps.Sleep(100);
        addPostSteps.openMyWallPage();
        loginSteps.Sleep(100);
        addPostSteps.AddTextPost(textPostAr);
        loginSteps.Sleep(100);
        addPostSteps.openAudioPopup();
        loginSteps.Sleep(100);
        addPostSteps.AddAudioLink(AudioLink);
        loginSteps.Sleep(100);
        addPostSteps.clickAudioPostButton(driver);
        loginSteps.Sleep(100);
        addPostSteps.clickPostBtn(driver);
        loginSteps.Sleep(100);
        addPostSteps.checkAudioContentInPost(driver);
    }*/

    @Test
    public void AudioPostMyGroupWall() throws IOException{
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.openGroupWall(driver, Group1);
       // driver.get("http://mnassa.com/en/administrator#!group/page=4/name=group-title-1");
        addPostSteps.AddTextPost_inGroup(textPost, driver);
        addPostSteps.openAudioPopup();
        addPostSteps.AddAudioLink(AudioLink);
        addPostSteps.clickAudioPostButton(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.clickPostButton();
        addPostSteps.checkAudioContentInPost(driver);
    }
  /*  @Test
    public void AudioPostGroupWall()  {
        addPostSteps.openGroupsPage();
        loginSteps.Sleep(100);
        addPostSteps.openGroupWall();
        loginSteps.Sleep(100);
        addPostSteps.clickPostArea();
        //loginSteps.Sleep(100);
        addPostSteps.openAudioPopup();
        loginSteps.Sleep(100);
        addPostSteps.AddAudioLink(AudioLink);
        loginSteps.Sleep(100);
        addPostSteps.clickAudioPostButton(driver);
        loginSteps.Sleep(100);
        addPostSteps.clickPostBtn(driver);
        loginSteps.Sleep(100);
        addPostSteps.checkAudioContentInPost(driver);
    }*/
    @Test
    public void AudioPostMyWall() {
        headerSteps.openMyMnassaPage(driver);
       // headerSteps.openMyWall(driver);
        addPostSteps.AddTextPost(textPostAr, driver);
        addPostSteps.openAudioPopup();
        addPostSteps.AddAudioLink(AudioLink);
        addPostSteps.clickAudioPostButton(driver);
        addPostSteps.clickPostButton();
        addPostSteps.checkAudioContentInPost(driver);
    }
}
