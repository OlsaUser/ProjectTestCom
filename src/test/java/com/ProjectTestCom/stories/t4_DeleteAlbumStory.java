package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AddAlbumSteps;
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

/**
 * Created by olsa on 5/11/2016.
 */
@RunWith(SerenityRunner.class)
public class t4_DeleteAlbumStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    AddAlbumSteps addAlbumSteps;

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
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyMedia(driver);
    }

    @After
    public void tearDown() {driver.quit();
    }
    @Test
    public void viewAlbum_Settings_DeleteAlbum() {
        addAlbumSteps.openViewAlbumPage();
        addAlbumSteps.openSettingsMenu();
        addAlbumSteps.selectDeleteMenu();
        addAlbumSteps.clickDeleteButton();
        addAlbumSteps.clickAlbumDeleted(driver);
    }
    @Test
    public void viewAlbum_Settings_CancelDeleteAlbum() {
        addAlbumSteps.openViewAlbumPage();
        addAlbumSteps.openSettingsMenu();
        addAlbumSteps.selectDeleteMenu();
    }
}
