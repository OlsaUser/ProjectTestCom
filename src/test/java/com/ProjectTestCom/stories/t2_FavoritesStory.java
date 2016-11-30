package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.FavoritesSteps;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.jetty.util.IO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

@RunWith(SerenityRunner.class)
public class t2_FavoritesStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String propertyFilePath = "src/test/resources/login.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

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

    @Before
    public void setup() throws IOException {
        driver.manage().window().maximize();

        loginSteps.openLoginPage();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void addToFavorite() throws IOException{
        headerSteps.openProductListing(driver);
        loginSteps.PageComplete(driver);
        favoritesSteps.pressIcon_addToFavorite(driver);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openServiceListing(driver);
        loginSteps.PageComplete(driver);
        favoritesSteps.pressIcon_addToFavorite(driver);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openEventListing(driver);
        loginSteps.PageComplete(driver);
        favoritesSteps.pressIcon_addToFavorite(driver);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.openPartnershipListing(driver);
        loginSteps.PageComplete(driver);
        favoritesSteps.pressIcon_addToFavorite(driver);
            }

    @Test
    @Ignore
    public void addToFavorite_Service() {
        headerSteps.openServiceListing(driver);
        loginSteps.PageComplete(driver);
        favoritesSteps.pressIcon_addToFavorite(driver);
    }
    @Test
    @Ignore
    public void addToFavorite_Event() {
        headerSteps.openEventListing(driver);
        loginSteps.PageComplete(driver);
        favoritesSteps.pressIcon_addToFavorite(driver);
    }
    @Test
    @Ignore
    public void addToFavorite_Partnership() {
        headerSteps.openPartnershipListing(driver);
        loginSteps.PageComplete(driver);
        favoritesSteps.pressIcon_addToFavorite(driver);
    }
}