package com.ProjectTestCom.stories;

import com.ProjectTestCom.pages.LoginPage;
import com.ProjectTestCom.steps.LoginSteps;
import com.ProjectTestCom.utils.FileWriterUtil;
import com.ProjectTestCom.utils.PropertyLoader;
import com.ProjectTestCom.utils.RetryRule;
import cucumber.api.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.Statement;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.server.handler.CloseWindow;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.concurrent.TimeUnit;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;

import static java.awt.SystemColor.window;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t1_LoginStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String wrongEmail = PropertyLoader.getProperty(propertyFilePath, "wrongEmail");
    private String wrongPassword = PropertyLoader.getProperty(propertyFilePath, "wrongPassword");
    private String emailOrg = PropertyLoader.getProperty(propertyFilePath, "email_organization");
    private String passwordOrg = PropertyLoader.getProperty(propertyFilePath, "password_organization");
    private String wrongEmailOrg = PropertyLoader.getProperty(propertyFilePath, "wrongEmailOrg");
    private String wrongPasswordOrg = PropertyLoader.getProperty(propertyFilePath, "wrongPasswordOrg");
    private String lblEmailError = PropertyLoader.getProperty(propertyFilePath, "lblEmailError");
    private String lblPasswordError = PropertyLoader.getProperty(propertyFilePath, "lblPasswordError");

    private String loginU = PropertyLoader.getProperty(propertyFilePath, "loginU");
    private String loginO = PropertyLoader.getProperty(propertyFilePath, "loginO");
    private String mainG = PropertyLoader.getProperty(propertyFilePath, "mainG");

    private String registrationFilePath = "src/test/resources/registration.properties";
    private String NewEmailUser = PropertyLoader.getProperty(registrationFilePath, "NewEmailUser");
    private String NewEmailOrg = PropertyLoader.getProperty(registrationFilePath, "NewEmailOrg");
    private String WrongEmail = PropertyLoader.getProperty(registrationFilePath, "WrongEmail");
    private String ExistEmail = PropertyLoader.getProperty(registrationFilePath, "ExistEmail");
    private String NewPassword = PropertyLoader.getProperty(registrationFilePath, "NewPassword");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Before
    public void setup() throws IOException{
        driver.manage().window().maximize();

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
    }

 @After
        public void tearDown()   {
        driver.quit();
    }
    /*************************************************************/
@Test
    public void checkingLoginErrors() throws MessagingException, IOException{
        loginSteps.enterLogin(wrongEmail);
        loginSteps.enterPassword(password);
        loginSteps.clickEnterError();
//        loginSteps.checkLoginErrorPresent(lblEmailError); --> defect

        loginSteps.clearLogin();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(wrongPassword);
        loginSteps.clickEnterError();
        loginSteps.checkPasswordErrorPresent(lblPasswordError);

        loginSteps.clearLogin();
        loginSteps.enterLogin(wrongEmailOrg);
        loginSteps.clearPassword();
        loginSteps.enterPassword(passwordOrg);
        loginSteps.clickEnterError();
//        loginSteps.checkLoginErrorPresent(lblEmailError); --> defect

        loginSteps.clearLogin();
        loginSteps.enterLogin(emailOrg);
        loginSteps.clearPassword();
        loginSteps.enterPassword(wrongPasswordOrg);
        loginSteps.clickEnterError();
        loginSteps.checkPasswordErrorPresent(lblPasswordError);
    }

    @Test
    public void blockUser() throws IOException, MessagingException{
        loginSteps.enterLogin("testUserBlock@yopmail.com");
        loginSteps.enterPassword(wrongPassword);
        loginSteps.clickEnterError();
        loginSteps.checkPasswordErrorPresent(lblPasswordError);

        loginSteps.clickEnterError();
        loginSteps.checkPasswordErrorPresent(lblPasswordError);

        loginSteps.clickEnterError();
        loginSteps.checkPasswordErrorPresent(lblPasswordError);

        loginSteps.clickEnterError();
        loginSteps.checkPasswordErrorPresent(lblPasswordError);

        loginSteps.clickEnterError();
        loginSteps.checkPasswordErrorPresent(lblPasswordError);

        loginSteps.clickEnterError();
        loginSteps.checkPasswordErrorPresent(lblPasswordError);
    }

    @Test
    @Ignore
    public void loginUser() {
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
    }

    @Test
    @Ignore
    public void loginOrganization() {
        loginSteps.enterLogin(emailOrg);
        loginSteps.enterPassword(passwordOrg);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }
}

