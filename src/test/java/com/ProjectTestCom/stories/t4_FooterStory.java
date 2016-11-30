package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.FooterSteps;
import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
import com.ProjectTestCom.steps.RegisterSteps;
import com.ProjectTestCom.utils.PropertyLoader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.apache.commons.logging.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
public class t4_FooterStory {
    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    FooterSteps footerSteps;

    @Steps
    LoginSteps loginSteps;

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String About = PropertyLoader.getProperty(propertyFilePath, "About");
    private String ContactUs = PropertyLoader.getProperty(propertyFilePath, "ContactUs");
    private String Terms = PropertyLoader.getProperty(propertyFilePath, "Terms");
    private String PrivacyPolicy = PropertyLoader.getProperty(propertyFilePath, "PrivacyPolicy");

    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    @Before
    public void setup() throws IOException {
        driver.manage().window().maximize();

        footerSteps.openHomePage();
        loginSteps.PageComplete(driver);

    }
    @After
    public void tearDown() {driver.quit();
    }

    @Test
    public void Footer() {
        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,600)", "");
        footerSteps.openAbout(driver, About);

        driver.navigate().back();
        loginSteps.PageComplete(driver);

        footerSteps.openContact(driver, ContactUs);
        driver.navigate().back();
        loginSteps.PageComplete(driver);

        footerSteps.openTermsConditions(driver, Terms);
        driver.navigate().back();
        loginSteps.PageComplete(driver);

        footerSteps.openPrivacyPolicy(driver, PrivacyPolicy);
    }
}
