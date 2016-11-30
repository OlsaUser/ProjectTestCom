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

/**
 * Created by olsa on 5/10/2016.
 */
@RunWith(SerenityRunner.class)
public class t2_NewMessageStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyMessagePath = "src/test/resources/message.properties";
    private String MessageMAX = PropertyLoader.getProperty(propertyMessagePath, "MessageMAX");
    private String MessageMIN = PropertyLoader.getProperty(propertyMessagePath, "MessageMIN");
    private String MessageAR = PropertyLoader.getProperty(propertyMessagePath, "MessageAR");
    private String Message = PropertyLoader.getProperty(propertyMessagePath, "Message");
    private String MessageLink = PropertyLoader.getProperty(propertyMessagePath, "MessageLink");
    private String NewMessage = PropertyLoader.getProperty(propertyMessagePath, "NewMessage");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    NewMessageSteps newMessageSteps;

    @Steps
    HeaderSteps headerSteps;

    @Before
    public void setup() throws IOException {
        driver.manage().window().maximize();

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMessagePage(driver);
        newMessageSteps.SelectChatWith();
        loginSteps.PageComplete(driver);
    }
    @After
    public void tearDown() {//driver.quit();
         }

    @Test
    public void SendMessage_MAX() throws IOException{
        newMessageSteps.EnterMessage(MessageMAX);
        newMessageSteps.PressSendButton(driver);
        newMessageSteps.checkMessageExists(MessageMAX, driver);
    }

    @Test
    public void SendMessage_AR() throws IOException{
        newMessageSteps.EnterMessage(MessageAR);
        newMessageSteps.PressSendButton(driver);
        newMessageSteps.checkMessageExists(MessageAR, driver);
    }
    @Test
    public void SendMessage_Link() throws IOException{
        newMessageSteps.EnterMessage(MessageLink);
        newMessageSteps.PressSendButton(driver);
        newMessageSteps.checkMessageExists(MessageLink, driver);
    }
      /*  @Test
    public void SendMessage_MIN() throws IOException{
        newMessageSteps.EnterMessage(MessageMIN);
        newMessageSteps.PressSendButton(driver);
        loginSteps.Sleep(800);
        newMessageSteps.MessageExists(MessageMIN);
    }
        @Test
    public void SendMessage() throws IOException {
        newMessageSteps.EnterMessage(Message);
        newMessageSteps.PressSendButton(driver);
        loginSteps.Sleep(800);
        newMessageSteps.MessageExists(Message);
    }*/
}
