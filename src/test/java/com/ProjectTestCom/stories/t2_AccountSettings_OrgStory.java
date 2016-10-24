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
    private String password_organization = PropertyLoader.getProperty(propertyFilePath, "password_organization");

    private String profileFilePath = "src/test/resources/profile.properties";
    private String FirstName_En = PropertyLoader.getProperty(profileFilePath, "FirstName_En");
    private String LastName_En = PropertyLoader.getProperty(profileFilePath, "LastName_En");
    private String UserName_En = PropertyLoader.getProperty(profileFilePath, "UserName_En");
    private String FirstName_Ar = PropertyLoader.getProperty(profileFilePath, "FirstName_Ar");
    private String LastName_Ar = PropertyLoader.getProperty(profileFilePath, "LastName_Ar");
    private String UserName_AR = PropertyLoader.getProperty(profileFilePath, "UserName_AR");
    private String Symbols = PropertyLoader.getProperty(profileFilePath, "Symbols");
    private String Numbers = PropertyLoader.getProperty(profileFilePath, "Numbers");
    private String Name_51_symbols = PropertyLoader.getProperty(profileFilePath, "Name_51_symbols");
    private String location = PropertyLoader.getProperty(profileFilePath, "location");
    private String Male = PropertyLoader.getProperty(profileFilePath, "Male");
    private String Female = PropertyLoader.getProperty(profileFilePath, "Female");
    private String single = PropertyLoader.getProperty(profileFilePath, "Single");
    private String married = PropertyLoader.getProperty(profileFilePath, "Married");
    private String BriefInfo = PropertyLoader.getProperty(profileFilePath, "BriefInfo");
    private String mobile = PropertyLoader.getProperty(profileFilePath, "mobile");
    private String landline = PropertyLoader.getProperty(profileFilePath, "landline");
    private String Facebook = PropertyLoader.getProperty(profileFilePath, "Facebook");
    private String Instagram = PropertyLoader.getProperty(profileFilePath, "Instagram");
    private String Twitter = PropertyLoader.getProperty(profileFilePath, "Twitter");
    private String LinkedIn = PropertyLoader.getProperty(profileFilePath, "LinkedIn");
    private String Snapchat = PropertyLoader.getProperty(profileFilePath, "Snapchat");
    private String WebSite = PropertyLoader.getProperty(profileFilePath, "WebSite");
    private String InstitutionName = PropertyLoader.getProperty(profileFilePath, "InstitutionName");
    private String Speciality = PropertyLoader.getProperty(profileFilePath, "Speciality");
    private String About = PropertyLoader.getProperty(profileFilePath, "About");
    private String Location = PropertyLoader.getProperty(profileFilePath, "Location");
    private String JobName = PropertyLoader.getProperty(profileFilePath, "JobName");
    private String JobSpeciality = PropertyLoader.getProperty(profileFilePath, "JobSpeciality");
    private String InstitutionName_new = PropertyLoader.getProperty(profileFilePath, "InstitutionName_new");
    private String Speciality_new = PropertyLoader.getProperty(profileFilePath, "Speciality_new");
    private String About_new = PropertyLoader.getProperty(profileFilePath, "About_new");
    private String Location_new = PropertyLoader.getProperty(profileFilePath, "Location_new");
    private String JobName_new = PropertyLoader.getProperty(profileFilePath, "JobName_new");
    private String JobSpeciality_new = PropertyLoader.getProperty(profileFilePath, "JobSpeciality_new");
    private String Skill = PropertyLoader.getProperty(profileFilePath, "Skill");
    private String Interest = PropertyLoader.getProperty(profileFilePath, "Interest");
    private String CurrentPassword = PropertyLoader.getProperty(profileFilePath, "CurrentPassword");
    private String NewPassword = PropertyLoader.getProperty(profileFilePath, "NewPassword");
    private String NewConfirmPassword = PropertyLoader.getProperty(profileFilePath, "NewConfirmPassword");

    private String NoError = PropertyLoader.getProperty(profileFilePath, "NoError");
    private String Error_FirstName = PropertyLoader.getProperty(profileFilePath, "Error_FirstName");
    private String Error_LastName = PropertyLoader.getProperty(profileFilePath, "Error_LastName");
    private String Error_UserName = PropertyLoader.getProperty(profileFilePath, "Error_UserName");
    private String Error_LastName_moreMAX = PropertyLoader.getProperty(profileFilePath, "Error_LastName_moreMAX");

    private String OrganizationName_En = PropertyLoader.getProperty(profileFilePath, "OrganizationName_En");
    private String OrganizationShortName_En = PropertyLoader.getProperty(profileFilePath, "OrganizationShortName_En");
    private String count = PropertyLoader.getProperty(profileFilePath, "count");

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
       /* loginSteps.enterLogin("mav@yopmail.com");
        loginSteps.enterPassword("vfrfhfirf1989");*/

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
        accountSettingsSteps.enterOrganizationName(OrganizationName_En);
        accountSettingsSteps.enterOrganizationShortName(OrganizationShortName_En);
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
        accountSettingsSteps.checkMainDetails_Org(OrganizationName_En,OrganizationShortName_En,location,BriefInfo,count);
    }

    @Test
    public void changeAccountSettings_Org_ContactInfo(){
        accountSettingsSteps.pressCollapseContactInfo();
        accountSettingsSteps.enterMobilePhone(mobile);
        accountSettingsSteps.enterLandline(landline);
        accountSettingsSteps.enterFacebook(Facebook);
        accountSettingsSteps.enterInstagram(Instagram);
        accountSettingsSteps.enterTwitter(Twitter);
        accountSettingsSteps.enterLinkedIn(LinkedIn);
        accountSettingsSteps.enterSnapchat(Snapchat);
        accountSettingsSteps.enterWebSite(WebSite);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate2(driver);
        loginSteps.Sleep(70);
        //User info page

        headerSteps.openDiscoverPage(driver);
        headerSteps.viewAccountSettings(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkContactInfo(mobile,landline,Facebook,Instagram,Twitter,LinkedIn,Snapchat,WebSite,email_organization);
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
