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

@RunWith(SerenityRunner.class)
public class t3_AddVideoPostStory {
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
    private String VideoLink = PropertyLoader.getProperty(propertyPostPath, "VideoLink");

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

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void VideoPostHomePage()  {
        addPostSteps.openVideoPopup();
        addPostSteps.AddVideoLink(VideoLink);
        addPostSteps.clickVideoPostButton(driver);
        addPostSteps.clickPostBtn(driver);
        addPostSteps.checkContentInPost(driver);
    }

  /*  @Test
    public void VideoPostMyGroupWall() throws IOException{
        addPostSteps.openMyMnassaPage();
        addPostSteps.openMyGroupsPage();
        addPostSteps.openMyGroupWall();
        addPostSteps.AddTextPost(textPost);
        addPostSteps.openVideoPopup();
        addPostSteps.AddVideoLink(VideoLink);
        addPostSteps.clickVideoPostButton(driver);
        addPostSteps.clickPostButton();
        addPostSteps.checkContentInPost(driver);
    }*/

 /*   @Test
    public void VideoPostGroupWall()  {
        headerSteps.openGroupsListing(driver);
        addPostSteps.openGroupWall();
        addPostSteps.AddTextPost(textPost, driver);
        addPostSteps.openVideoPopup();
        addPostSteps.AddVideoLink(VideoLink);
        addPostSteps.clickVideoPostButton(driver);
        addPostSteps.clickPostBtn(driver);
        addPostSteps.checkContentInPost(driver);*/

      /*  loginSteps.Sleep(300);
        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,300)", "");
        addPostSteps.addComment(Comment, driver);
    }*/

    @Test
    public void VideoPostMyWall() {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyWall(driver);
        addPostSteps.AddTextPost(textPostAr, driver);
        addPostSteps.openVideoPopup();
        addPostSteps.AddVideoLink(VideoLink);
        addPostSteps.clickVideoPostButton(driver);
        addPostSteps.clickPostBtn(driver);
        addPostSteps.checkContentInPost(driver);
    }
}
