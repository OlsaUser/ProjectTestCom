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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t1_RepostPostStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String propertyFilePath = "src/test/resources/login.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String urlUserProfile1 = PropertyLoader.getProperty(propertyFilePath, "urlUserProfile1");
    private String urlUserProfile2 = PropertyLoader.getProperty(propertyFilePath, "urlUserProfile2");

    private String propertyPostPath = "src/test/resources/post.properties";
    private String textPostMin = PropertyLoader.getProperty(propertyPostPath, "textPostMin");
    private String textPostMaxEn = PropertyLoader.getProperty(propertyPostPath, "textPostMaxEn");
    private String textPostAr = PropertyLoader.getProperty(propertyPostPath, "textPostAr");
    private String textPost = PropertyLoader.getProperty(propertyPostPath, "textPost");
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
    HeaderSteps headerSteps;

    @Steps
    AddPostSteps addPostSteps;

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
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver.close();}

    @Test
    public void stage6_repostFromMyWallToGroup() throws IOException{
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        //Add new Post
        addPostSteps.AddTextPost(textPostAr, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostAr, driver);
        addPostSteps.checkCounterRepost(driver, "0");

        //Making Repost to Group
        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToGroup(driver);
        addPostSteps.selectGroupInDropdown();
        addPostSteps.pressPostButton();
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderGroup);
        //loginSteps.Sleep(100);
        //Checking repost on Group Wall
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group2);
        loginSteps.PageComplete(driver);
        addPostSteps.checkOwnRepostExists(driver,textPostAr, HeaderRepost);
        addPostSteps.checkCounterRepost(driver, "1");
    }

    @Test
    public void stage2_repostFromNewsFeedToGroup() throws IOException {
        addPostSteps.AddTextPost(textPostMin, driver);
        addPostSteps.openAudioPopup();
        addPostSteps.AddAudioLink(AudioLink);
        addPostSteps.clickAudioPostButton(driver);
        addPostSteps.clickPostBtn(driver);
        addPostSteps.waitWidgetAudio(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkAudioContentInPost(driver);

        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToGroup(driver);
        addPostSteps.selectGroupInDropdown();
        addPostSteps.pressPostButton();
        //loginSteps.PageComplete(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderGroup);

        //Checking repost on Group Wall/
        loginSteps.PageComplete(driver);
        loginSteps.Sleep(1000);
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group2);
        loginSteps.PageComplete(driver);
        addPostSteps.checkOwnRepostExists(driver,textPostMin, HeaderRepost);
    }
    @Test
    public void stage1_repostFromNewsFeedToWall() throws IOException {
        //JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        //jse1.executeScript("window.scrollBy(0,300)", "");

        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToWall(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderWall);
        loginSteps.PageComplete(driver);
        loginSteps.Sleep(700);
        //Checking repost on Wall/
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyWall(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPostMaxEn, HeaderRepost);
    }


    @Test
    public void stage3_repostFromDiscoverToGroup() throws IOException {
        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverPostNew(driver);
        loginSteps.PageComplete(driver);

        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,300)", "");

        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToGroup(driver);
        addPostSteps.selectGroupInDropdown();
        addPostSteps.pressPostButton();
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderGroup);

        //Checking repost on Group Wall/
        loginSteps.PageComplete(driver);
        loginSteps.Sleep(700);
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group2);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPostMin, HeaderRepost);
    }
    @Test
    public void stage4_repostFromDiscoverToWall() throws IOException {
        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverPostNew(driver);
        loginSteps.PageComplete(driver);

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");

        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToWall(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderWall);

        //Checking repost on Wall/
        loginSteps.Sleep(800);
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
        //driver.navigate().refresh();
        headerSteps.openMyWall(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPostMaxEn, HeaderRepost);
    }

    @Test
    public void stage5_repostFromGroupToGroup() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group1);
        loginSteps.PageComplete(driver);

        addPostSteps.AddTextPost(textPostAr, driver);
        addPostSteps.openVideoPopup();
        addPostSteps.AddVideoLink(VideoLink);
        addPostSteps.clickVideoPostButton(driver);
        addPostSteps.waitWidgetVideo(driver);
        addPostSteps.clickPostBtn(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkContentInPost(driver);

        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,300)", "");

        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToGroup(driver);
        addPostSteps.selectGroupInDropdown();
        addPostSteps.pressPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderGroup);
        //Checking repost on Group Wall/
        loginSteps.PageComplete(driver);
        loginSteps.Sleep(700);
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group2);
        loginSteps.PageComplete(driver);
        addPostSteps.checkOwnRepostExists(driver,textPostAr, HeaderRepost);
    }

    @Test
    public void stage8_repostFromUserWallToWall() throws IOException {
        driver.get(urlUserProfile1);
        //driver.get("http://mnassa.com/en/kindasindi");
        headerSteps.openUserWallPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");

        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToWall(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderWall);

        //Checking repost on Wall/
        loginSteps.Sleep(700);
        headerSteps.openMyMnassaPage(driver);
        driver.navigate().refresh();
        headerSteps.openMyWall(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPostMaxEn, HeaderRepost);

        jse.executeScript("window.scrollBy(0,500)", "");
        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToGroup(driver);
        addPostSteps.selectGroupInDropdown();
        addPostSteps.pressPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderGroup);
        loginSteps.PageComplete(driver);

        jse.executeScript("window.scrollBy(0,-500)", "");
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group2);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPostMin, HeaderRepost);
    }

    /* Group1 Wall -> My Wall -> Group2 Wall*/
    @Test
    public void stage9_repostFromGroupToWallToGroupWall() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group1);
        loginSteps.PageComplete(driver);

        //Add new post to Group
        addPostSteps.AddTextPost(textPost, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPost, driver);
        addPostSteps.checkCounterRepost(driver, "0");

        //Making repost to Wall
        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToWall(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderWall);

        //Checking repost on Wall/
        loginSteps.Sleep(700);
        headerSteps.openMyMnassaPage(driver);
        driver.navigate().refresh();
        addPostSteps.checkOwnRepostExists(driver,textPost, HeaderRepost);
        addPostSteps.checkCounterRepost(driver, "1");

        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToGroup(driver);
        addPostSteps.selectGroupInDropdown();
        addPostSteps.pressPostButton();
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderGroup);

        loginSteps.Sleep(600);
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group2);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPost, HeaderRepost);
        addPostSteps.checkCounterRepost(driver, "2");
    }

    /* User1 Wall -> Group Wall -> User2 Wall*/
    @Test
    public void stage99_repostFromUserWallToGroupToMyWall() throws IOException {
        driver.get(urlUserProfile2);
        //driver.get("http://mnassa.com/en/kindasindi");
        headerSteps.openUserWallPage(driver);

        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,300)", "");

        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToGroup(driver);
        addPostSteps.selectGroupInDropdown();
        addPostSteps.pressPostButton();
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderGroup);

        //Checking repost on Group Wall/

        jse1.executeScript("window.scrollBy(0,-500)", "");
        loginSteps.Sleep(700);
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group2);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPostMin, HeaderRepost);

        jse1.executeScript("window.scrollBy(0,300)", "");
        addPostSteps.openRepostMenu();
        addPostSteps.selectRepostToWall(driver);
        addPostSteps.checkPlaceholderTextAfterRepost(driver, placeholderWall);

        loginSteps.Sleep(700);
        //driver.navigate().refresh();
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyWall(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkRepostExists(driver,textPostMin, HeaderRepost);
    }
}