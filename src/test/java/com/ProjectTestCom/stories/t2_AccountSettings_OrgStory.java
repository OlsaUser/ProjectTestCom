package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AccountSettingsSteps;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
public class t2_AccountSettings_OrgStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email_organization = PropertyLoader.getProperty(propertyFilePath, "email_organization");
    private String email_organization_now = PropertyLoader.getProperty(propertyFilePath, "email_organization_now");
    private String password_organization = PropertyLoader.getProperty(propertyFilePath, "password_organization");

    private String profileFilePath = "src/test/resources/profile.properties";
    private String location = PropertyLoader.getProperty(profileFilePath, "location");
    private String location_now = PropertyLoader.getProperty(profileFilePath, "location_now");
    private String location_now1 = PropertyLoader.getProperty(profileFilePath, "location_now1");
    private String location_now2 = PropertyLoader.getProperty(profileFilePath, "location_now2");
    private String location_now1_exp = PropertyLoader.getProperty(profileFilePath, "location_now1_exp");
    private String location_now2_exp = PropertyLoader.getProperty(profileFilePath, "location_now2_exp");
    private String location_exp = PropertyLoader.getProperty(profileFilePath, "location_exp");
    private String BriefInfo = PropertyLoader.getProperty(profileFilePath, "BriefInfo");
    private String BriefInfo_now = PropertyLoader.getProperty(profileFilePath, "BriefInfo_now");
    private String mobile_now = PropertyLoader.getProperty(profileFilePath, "mobile_now");
    private String mobile_exp = PropertyLoader.getProperty(profileFilePath, "mobile_exp");
    private String landline_exp = PropertyLoader.getProperty(profileFilePath, "landline_exp");
    private String landline_now = PropertyLoader.getProperty(profileFilePath, "landline_now");
    private String Facebook = PropertyLoader.getProperty(profileFilePath, "Facebook");
    private String Instagram = PropertyLoader.getProperty(profileFilePath, "Instagram");
    private String Twitter = PropertyLoader.getProperty(profileFilePath, "Twitter");
    private String LinkedIn = PropertyLoader.getProperty(profileFilePath, "LinkedIn");
    private String Snapchat = PropertyLoader.getProperty(profileFilePath, "Snapchat");
    private String WebSite_exp = PropertyLoader.getProperty(profileFilePath, "WebSite_exp");
    private String WebSite_now = PropertyLoader.getProperty(profileFilePath, "WebSite_now");
    private String CurrentPassword = PropertyLoader.getProperty(profileFilePath, "CurrentPassword");
    private String NewPassword = PropertyLoader.getProperty(profileFilePath, "NewPassword");
    private String NewConfirmPassword = PropertyLoader.getProperty(profileFilePath, "NewConfirmPassword");
    private String OrganizationName_En_exp = PropertyLoader.getProperty(profileFilePath, "OrganizationName_En_exp");
    private String OrganizationName_En_now = PropertyLoader.getProperty(profileFilePath, "OrganizationName_En_now");
    private String OrganizationShortName_En_exp = PropertyLoader.getProperty(profileFilePath, "OrganizationShortName_En_exp");
    private String OrganizationShortName_En_now = PropertyLoader.getProperty(profileFilePath, "OrganizationShortName_En_now");
    private String count = PropertyLoader.getProperty(profileFilePath, "count");
    private String count_now = PropertyLoader.getProperty(profileFilePath, "count_now");
    private String YearFounder_now = PropertyLoader.getProperty(profileFilePath, "YearFounder_now");
    private String YearFounder_exp = PropertyLoader.getProperty(profileFilePath, "YearFounder_exp");

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

    @Before
    public void setup() throws IOException {
        FirefoxProfile myProfile = new FirefoxProfile(new File(BrowserProfile));
        myProfile.setPreference("network.proxy.socks_port",9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(email_organization);
        loginSteps.enterPassword(password_organization);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void changeAccountSettings_Org_MainDetails_EN(){
        accountSettingsSteps.enterOrganizationName(OrganizationName_En_exp);
        accountSettingsSteps.enterOrganizationShortName(OrganizationShortName_En_exp);
        accountSettingsSteps.selectTypeGovernmental();
        accountSettingsSteps.selectLanguageArabian_Org();
        accountSettingsSteps.selectLanguageEnglish_Org();
        accountSettingsSteps.selectFounded();
        accountSettingsSteps.selectNumbEmployees(count);
        // accountSettingsSteps.selectStatusSingle();
        accountSettingsSteps.selectLocation(location);
        accountSettingsSteps.enterBriefInfo(BriefInfo);
        accountSettingsSteps.clickUpdate1(driver);
        //User info page
        loginSteps.Sleep(70);
        headerSteps.openDiscoverPage(driver);
        headerSteps.viewAccountSettings(driver);
        accountSettingsSteps.checkInfoExists(OrganizationName_En_exp,OrganizationName_En_now);
        accountSettingsSteps.checkInfoExists(OrganizationShortName_En_exp,OrganizationShortName_En_now);
        accountSettingsSteps.checkInfoExists(location_exp, location_now);
        accountSettingsSteps.checkInfoExists(location_now1_exp, location_now1);
        accountSettingsSteps.checkInfoExists(location_now2_exp, location_now2);
        accountSettingsSteps.checkInfoExists(BriefInfo, BriefInfo_now);
        accountSettingsSteps.checkInfoExists(count, count_now);
        accountSettingsSteps.checkInfoExists(YearFounder_exp, YearFounder_now);
        //accountSettingsSteps.checkMainDetails_Org(OrganizationName_En,OrganizationShortName_En,location,BriefInfo,count);
    }

    @Test
    public void changeAccountSettings_Org_ContactInfo(){
        accountSettingsSteps.pressCollapseContactInfo();
        accountSettingsSteps.enterMobilePhone(mobile_exp);
        accountSettingsSteps.enterLandline(landline_exp);
        accountSettingsSteps.enterFacebook(Facebook);
        accountSettingsSteps.enterInstagram(Instagram);
        accountSettingsSteps.enterTwitter(Twitter);
        accountSettingsSteps.enterLinkedIn(LinkedIn);
        accountSettingsSteps.enterSnapchat(Snapchat);
        accountSettingsSteps.enterWebSite(WebSite_exp);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate2(driver);
        loginSteps.Sleep(70);
        //User info page
        headerSteps.openDiscoverPage(driver);
        headerSteps.viewAccountSettings(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkInfoExists(mobile_exp,mobile_now);
        accountSettingsSteps.checkInfoExists(landline_exp,landline_now);
        accountSettingsSteps.checkInfoExists(WebSite_exp,WebSite_now);
        accountSettingsSteps.checkInfoExists(email_organization, email_organization_now );
        accountSettingsSteps.checkNetworkAccounts();
    }
    @Test
    public void changeAccountSettings_Org_ChangePassword(){
        accountSettingsSteps.pressCollapseChangePassword();
        accountSettingsSteps.enterCurrentPassword(CurrentPassword);
        accountSettingsSteps.enterNewPassword(NewPassword);
        accountSettingsSteps.enterNewConfirmPassword(NewConfirmPassword);
        //loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate6(driver);
    }
}
