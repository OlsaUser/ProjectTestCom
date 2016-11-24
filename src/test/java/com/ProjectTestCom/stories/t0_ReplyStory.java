package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AccountSettingsSteps;
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
public class t0_ReplyStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email_organization = PropertyLoader.getProperty(propertyFilePath, "email_organization");
    private String password_organization = PropertyLoader.getProperty(propertyFilePath, "password_organization");
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String textPostMention = PropertyLoader.getProperty(propertyFilePath, "textPostMention");

    private String propertyPostPath = "src/test/resources/post.properties";
    private String addPost = PropertyLoader.getProperty(propertyPostPath, "addPost");
    private String Comment = PropertyLoader.getProperty(propertyPostPath, "Comment");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    AccountSettingsSteps accountSettingsSteps;

    @Steps
    AddPostSteps addPostSteps;

    @Before
    public void setup() throws IOException {
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void AddMentionPost()  {
        loginSteps.openLoginPage();
        loginSteps.enterLogin(email_organization);
        loginSteps.enterPassword(password_organization);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        addPostSteps.AddMentionPost(textPostMention, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
    }
    @Test
    public void Check_MentionPost()  throws IOException{
        loginSteps.openLoginPage();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverItemPopular(driver);
        headerSteps.openDiscoverPostNew(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewPost_Discover(driver);
    }
}
