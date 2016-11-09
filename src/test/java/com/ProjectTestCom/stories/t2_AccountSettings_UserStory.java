package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AccountSettingsSteps;
import com.ProjectTestCom.steps.AddItemSteps;
import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
import com.ProjectTestCom.utils.PropertyLoader;
import junit.extensions.RepeatedTest;
import mx4j.tools.remote.ConnectionManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.Statement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t2_AccountSettings_UserStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String email_now = PropertyLoader.getProperty(propertyFilePath, "email_now");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String profileFilePath = "src/test/resources/profile.properties";
    private String FirstName_En = PropertyLoader.getProperty(profileFilePath, "FirstName_En");
    private String FirstName_En_now = PropertyLoader.getProperty(profileFilePath, "FirstName_En_now");
    private String FirstName_En_exp = PropertyLoader.getProperty(profileFilePath, "FirstName_En_exp");
    private String FirstName_Ar_exp = PropertyLoader.getProperty(profileFilePath, "FirstName_Ar_exp");
    private String LastName_En = PropertyLoader.getProperty(profileFilePath, "LastName_En");
    private String UserName_En_now = PropertyLoader.getProperty(profileFilePath, "UserName_En_now");
    private String UserName_En = PropertyLoader.getProperty(profileFilePath, "UserName_En");
    private String FirstName_Ar = PropertyLoader.getProperty(profileFilePath, "FirstName_Ar");
    private String LastName_Ar = PropertyLoader.getProperty(profileFilePath, "LastName_Ar");
    private String UserName_AR = PropertyLoader.getProperty(profileFilePath, "UserName_AR");
    private String Symbols = PropertyLoader.getProperty(profileFilePath, "Symbols");
    private String Numbers = PropertyLoader.getProperty(profileFilePath, "Numbers");
    private String Name_51_symbols = PropertyLoader.getProperty(profileFilePath, "Name_51_symbols");
    //private String location = PropertyLoader.getProperty(profileFilePath, "location");
    private String Male = PropertyLoader.getProperty(profileFilePath, "Male");
    private String gender_now = PropertyLoader.getProperty(profileFilePath, "gender_now");
    private String Female = PropertyLoader.getProperty(profileFilePath, "Female");
    private String single = PropertyLoader.getProperty(profileFilePath, "Single");
    private String married = PropertyLoader.getProperty(profileFilePath, "Married");
    private String status_now = PropertyLoader.getProperty(profileFilePath, "status_now");
    private String birth_now = PropertyLoader.getProperty(profileFilePath, "birth_now");
    private String birth_exp = PropertyLoader.getProperty(profileFilePath, "birth_exp");
    private String BriefInfo = PropertyLoader.getProperty(profileFilePath, "BriefInfo");
    private String BriefInfo_now = PropertyLoader.getProperty(profileFilePath, "BriefInfo_now");
    private String mobile_exp = PropertyLoader.getProperty(profileFilePath, "mobile_exp");
    private String landline_exp = PropertyLoader.getProperty(profileFilePath, "landline_exp");
    private String mobile_now = PropertyLoader.getProperty(profileFilePath, "mobile_now");
    private String landline_now = PropertyLoader.getProperty(profileFilePath, "landline_now");
    private String Facebook = PropertyLoader.getProperty(profileFilePath, "Facebook");
    private String Instagram = PropertyLoader.getProperty(profileFilePath, "Instagram");
    private String Twitter = PropertyLoader.getProperty(profileFilePath, "Twitter");
    private String LinkedIn = PropertyLoader.getProperty(profileFilePath, "LinkedIn");
    private String Snapchat = PropertyLoader.getProperty(profileFilePath, "Snapchat");
    private String WebSite_now = PropertyLoader.getProperty(profileFilePath, "WebSite_now");
    private String WebSite_exp = PropertyLoader.getProperty(profileFilePath, "WebSite_exp");
    private String InstitutionName = PropertyLoader.getProperty(profileFilePath, "InstitutionName");
    private String Speciality = PropertyLoader.getProperty(profileFilePath, "Speciality");
    private String About = PropertyLoader.getProperty(profileFilePath, "About");
    private String location = PropertyLoader.getProperty(profileFilePath, "location");
    private String location_now_profile = PropertyLoader.getProperty(profileFilePath, "location_now_profile");
    private String location_exp = PropertyLoader.getProperty(profileFilePath, "location_exp");
    private String location_now1 = PropertyLoader.getProperty(profileFilePath, "location_now1");
    private String location_now2 = PropertyLoader.getProperty(profileFilePath, "location_now2");
    private String location_now1_exp = PropertyLoader.getProperty(profileFilePath, "location_now1_exp");
    private String location_now2_exp = PropertyLoader.getProperty(profileFilePath, "location_now2_exp");
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
    private String NewPassword_change = PropertyLoader.getProperty(profileFilePath, "NewPassword_change");
    private String NewConfirmPassword = PropertyLoader.getProperty(profileFilePath, "NewConfirmPassword");

    private String NoError = PropertyLoader.getProperty(profileFilePath, "NoError");
    private String Error_FirstName = PropertyLoader.getProperty(profileFilePath, "Error_FirstName");
    private String Error_LastName = PropertyLoader.getProperty(profileFilePath, "Error_LastName");
    private String Error_UserName = PropertyLoader.getProperty(profileFilePath, "Error_UserName");
    private String Error_LastName_moreMAX = PropertyLoader.getProperty(profileFilePath, "Error_LastName_moreMAX");

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
    AddItemSteps addItemSteps;

    @Before
    public void setup() throws IOException {
        FirefoxProfile myProfile = new FirefoxProfile(new File(BrowserProfile));
        myProfile.setPreference("network.proxy.socks_port",9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}
    /*-----------------------------------------------*/

    @Test
    public void stage0_changeAvatar() throws AWTException {
        accountSettingsSteps.pressUploadCoverLink();
        loginSteps.Sleep(200);
        addItemSteps.uploadImage();
        accountSettingsSteps.CropPopup_ChooseImage();
    }

    @Test
    public void stage1_changeAccountSettings_User_MainDetails_EN(){
        accountSettingsSteps.enterFirstName(FirstName_En);
        accountSettingsSteps.enterLastName(LastName_En);
        accountSettingsSteps.enterUserName(UserName_En);
       // accountSettingsSteps.selectGenderFeMale();
        accountSettingsSteps.selectGenderMale(Male);
        accountSettingsSteps.selectLanguageArabian();
        accountSettingsSteps.selectLanguageEnglish();
        accountSettingsSteps.selectBirth();
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,100)", "");
        accountSettingsSteps.selectStatusMarried(married);
       // accountSettingsSteps.selectStatusSingle();
        accountSettingsSteps.selectLocation(location);
        accountSettingsSteps.enterBriefInfo(BriefInfo);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate1(driver);
        //loginSteps.PageComplete(driver);
        //User info page
        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.checkInfoExists(FirstName_En_exp, FirstName_En_now);
        accountSettingsSteps.checkInfoExists(UserName_En, UserName_En_now);
        accountSettingsSteps.checkInfoExists(location_now1_exp, location_now_profile);
        accountSettingsSteps.checkInfoExists(location_now1_exp, location_now1);
        accountSettingsSteps.checkInfoExists(location_now2_exp, location_now2);
        accountSettingsSteps.checkInfoExists(BriefInfo, BriefInfo_now);
        accountSettingsSteps.checkInfoExists(Male, gender_now);
        accountSettingsSteps.checkInfoExists(married, status_now);
        accountSettingsSteps.checkInfoExists(birth_exp, birth_now);
    }

    @Test
    public void stage2_changeAccountSettings_User_MainDetails_AR(){
        accountSettingsSteps.enterFirstName(FirstName_Ar);
        accountSettingsSteps.enterLastName(LastName_Ar);
        accountSettingsSteps.enterUserName(UserName_En);
        accountSettingsSteps.selectGenderFeMale(Female);
        accountSettingsSteps.selectLanguageEnglish();
        accountSettingsSteps.selectBirth();
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,80)", "");
        accountSettingsSteps.selectStatusSingle(single);
        accountSettingsSteps.selectLocation(location);
        accountSettingsSteps.enterBriefInfo(BriefInfo);
        //loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate1(driver);
        //loginSteps.PageComplete(driver);

        //User info page
        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.checkInfoExists(FirstName_Ar_exp, FirstName_En_now);
        accountSettingsSteps.checkInfoExists(UserName_En, UserName_En_now);
        accountSettingsSteps.checkInfoExists(location_now1_exp, location_now_profile);
        accountSettingsSteps.checkInfoExists(location_now1_exp, location_now1);
        accountSettingsSteps.checkInfoExists(location_now2_exp, location_now2);
        accountSettingsSteps.checkInfoExists(BriefInfo, BriefInfo_now);
        accountSettingsSteps.checkInfoExists(Female, gender_now);
        accountSettingsSteps.checkInfoExists(single, status_now);
        accountSettingsSteps.checkInfoExists(birth_exp, birth_now);
    }
    @Test
    public void stage3_changeAccountSettings_User_MainDetails_Errors(){
        accountSettingsSteps.enterFirstName(Symbols);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,200)", "");
        accountSettingsSteps.clickUpdateError();
        accountSettingsSteps.checkMessage_if_NameWrong(Error_FirstName, driver);

        accountSettingsSteps.enterLastName(Symbols);
        accountSettingsSteps.clickUpdateError();
        accountSettingsSteps.checkMessage_if_NameWrong(Error_LastName, driver);

        accountSettingsSteps.enterUserName(Symbols);
        accountSettingsSteps.clickUpdateError();
        accountSettingsSteps.checkMessage_if_NameWrong(Error_UserName, driver);

        accountSettingsSteps.enterFirstName(Numbers);
        accountSettingsSteps.clickUpdateError();
        accountSettingsSteps.checkMessage_if_NameWrong(Error_FirstName, driver);

        accountSettingsSteps.enterLastName(Numbers);
        accountSettingsSteps.clickUpdateError();
        accountSettingsSteps.checkMessage_if_NameWrong(Error_LastName, driver);

        accountSettingsSteps.enterUserName(Numbers);
        accountSettingsSteps.clickUpdateError();
        accountSettingsSteps.checkMessage_if_NameWrong(Error_LastName, driver);

        accountSettingsSteps.enterFirstName(Name_51_symbols);
        accountSettingsSteps.clickUpdateError();
        accountSettingsSteps.checkMessage_if_NameWrong(NoError, driver);
//last symbol is cut (appears only max 50 symbols)
        accountSettingsSteps.enterLastName(Name_51_symbols);
        accountSettingsSteps.enterUserName(Name_51_symbols);
        //accountSettingsSteps.clickUpdateError();
        //accountSettingsSteps.checkMessage_if_NameWrong(Error_LastName_moreMAX, driver);
        //accountSettingsSteps.enterUserName(UserName_En);
        /*accountSettingsSteps.clickUpdateError();
        accountSettingsSteps.checkMessage_if_NameWrong(Error_LastName_moreMAX, driver);
        accountSettingsSteps.checkMessage_if_NameWrong(NoError, driver);*/
        accountSettingsSteps.clickUpdate1(driver);
        loginSteps.PageComplete(driver);
        /*accountSettingsSteps.enterFirstName(FirstName_Ar);
        accountSettingsSteps.enterLastName(LastName_Ar);
        accountSettingsSteps.enterUserName(Numbers);
        accountSettingsSteps.clickUpdate1(driver);*/
        //loginSteps.PageComplete(driver);
    }
    @Test
    public void stage4_changeAccountSettings_User_ContactInfo(){
        accountSettingsSteps.pressCollapseContactInfo();
        accountSettingsSteps.enterMobilePhone(mobile_exp);
        accountSettingsSteps.enterLandline(landline_exp);
        accountSettingsSteps.enterFacebook(Facebook);
        accountSettingsSteps.enterInstagram(Instagram);
        accountSettingsSteps.enterTwitter(Twitter);
        accountSettingsSteps.enterLinkedIn(LinkedIn);
        accountSettingsSteps.enterSnapchat(Snapchat);
        accountSettingsSteps.enterWebSite(WebSite_exp);
        //loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate2(driver);

        //User info page
        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkInfoExists(mobile_exp, mobile_now);
        accountSettingsSteps.checkInfoExists(landline_exp, landline_now);
        accountSettingsSteps.checkInfoExists(WebSite_exp, WebSite_now);
        accountSettingsSteps.checkInfoExists(email, email_now);
        accountSettingsSteps.checkNetworkAccounts();
    }
    @Test
    public void stage5_changeAccountSettings_User_EducationInfo(){
        accountSettingsSteps.pressCollapseEducationInfo();
        accountSettingsSteps.pressAddEducationButton();
        accountSettingsSteps.enterInstitutionName(InstitutionName);
        accountSettingsSteps.enterEducFromDate();
        accountSettingsSteps.enterEducTillDate();
        accountSettingsSteps.enterSpeciality(Speciality);
        accountSettingsSteps.enterLocation(location);
        accountSettingsSteps.enterAbout(About);
        accountSettingsSteps.pressSaveNewEduc(driver);
        loginSteps.PageComplete(driver);
        //loginSteps.PageComplete(driver);
        //accountSettingsSteps.clickUpdate3();

        //User info page
        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkEducationInfo(InstitutionName,Speciality,location,About);
    }
    @Test
    public void stage6_changeAccountSettings_User_Education_Edit(){
        accountSettingsSteps.pressCollapseEducationInfo();
        loginSteps.PageComplete(driver);
        accountSettingsSteps.Edit_ed();
        accountSettingsSteps.Ed_EditName(InstitutionName_new);
        accountSettingsSteps.Ed_EditSpeciality(Speciality_new);
        accountSettingsSteps.Ed_EditLocation(Location_new);
        accountSettingsSteps.Ed_EditAbout(About_new);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.Upd_ed(driver);
        loginSteps.Sleep(100);
        accountSettingsSteps.Edit_ed();
        accountSettingsSteps.Del_ed_modal(driver);
        loginSteps.PageComplete(driver);
    }
    @Test
    public void stage7_changeAccountSettings_User_JobInfo(){
        accountSettingsSteps.pressCollapseJobInfo();
        accountSettingsSteps.pressAddJobButton();
        accountSettingsSteps.enterJobName(JobName);
        accountSettingsSteps.enterJobFromDate();
        accountSettingsSteps.enterJobSpeciality(JobSpeciality);
        accountSettingsSteps.enterJobTillDate();

        accountSettingsSteps.enterJobLocation(location);
        accountSettingsSteps.enterJobAbout(About);
        accountSettingsSteps.pressSaveNewJob(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPage(driver);
        headerSteps.viewAccountSettings(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkJobInfo(JobName,JobSpeciality,About);
    }
    @Test
    public void stage8_changeAccountSettings_User_Job_Edit(){
        accountSettingsSteps.pressCollapseJobInfo();
        accountSettingsSteps.Edit_job();
        accountSettingsSteps.Job_EditName(InstitutionName_new);
        accountSettingsSteps.Job_EditSpeciality(JobSpeciality_new);
        accountSettingsSteps.Job_EditLocation(Location_new);
        accountSettingsSteps.Job_EditAbout(About_new);
        //loginSteps.PageComplete(driver);
        accountSettingsSteps.Upd_job(driver);
        loginSteps.Sleep(160);
        accountSettingsSteps.Edit_job();
        accountSettingsSteps.Del_job_modal(driver);
        loginSteps.PageComplete(driver);
    }

    @Test
    public void stage9_accountSettings_Add_Skills_Interests(){
        accountSettingsSteps.pressCollapseSkillsInfo();
        accountSettingsSteps.enterSkill(Skill, driver);
        accountSettingsSteps.enterInterest(Interest,driver);
        accountSettingsSteps.clickUpdate5(driver);
        //loginSteps.PageComplete(driver);
        //User info page
        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkSkillsInfo(Skill,Interest);
    }
    @Test
    public void stageA_accountSettings_Delete_Skills_Interests(){
        accountSettingsSteps.pressCollapseSkillsInfo();
        accountSettingsSteps.deleteInterest();
        accountSettingsSteps.deleteSkill();
        accountSettingsSteps.clickUpdate5(driver);
    }
    @Test
    public void stageB_changeAccountSettings_User_ChangePassword(){
        accountSettingsSteps.pressCollapseChangePassword();
        accountSettingsSteps.enterCurrentPassword(CurrentPassword);
        accountSettingsSteps.enterNewPassword(NewPassword_change);
        accountSettingsSteps.enterNewConfirmPassword(NewConfirmPassword);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate6(driver);
    }
}
