package com.ProjectTestCom;

import com.ProjectTestCom.steps.*;
import com.ProjectTestCom.utils.PropertyLoader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.ValidationException;
import javax.xml.parsers.FactoryConfigurationError;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FullTraceUser {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String email_now = PropertyLoader.getProperty(propertyFilePath, "email_now");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String fb_Email1 = PropertyLoader.getProperty(propertyFilePath, "fb_Email1");
    private String fb_Password1 = PropertyLoader.getProperty(propertyFilePath, "fb_Password1");

    private String fb_Email2 = PropertyLoader.getProperty(propertyFilePath, "fb_Email2");
    private String fb_Password2 = PropertyLoader.getProperty(propertyFilePath, "fb_Password2");

    private String tw_Email2 = PropertyLoader.getProperty(propertyFilePath, "tw_Email2");
    private String tw_Password2 = PropertyLoader.getProperty(propertyFilePath, "tw_Password2");

    private String gg_Email2 = PropertyLoader.getProperty(propertyFilePath, "gg_Email2");
    private String gg_Password2 = PropertyLoader.getProperty(propertyFilePath, "gg_Password2");

    private String registrationFilePath = "src/test/resources/registration.properties";
    private String NewEmailUser = PropertyLoader.getProperty(registrationFilePath, "NewEmailUser");
    private String NewPassword = PropertyLoader.getProperty(registrationFilePath, "NewPassword");
    private String UserNameEn = PropertyLoader.getProperty(registrationFilePath, "UserName_En");
    private String FirstNameEn = PropertyLoader.getProperty(registrationFilePath, "FirstName_En");
    private String LastNameEn = PropertyLoader.getProperty(registrationFilePath, "LastName_En");
    private String FirstName_Ar = PropertyLoader.getProperty(registrationFilePath, "FirstName_Ar");
    private String LastName_Ar = PropertyLoader.getProperty(registrationFilePath, "LastName_Ar");

    private String Year_2014 = PropertyLoader.getProperty(registrationFilePath, "Year_2014");
    private String Year_2016 = PropertyLoader.getProperty(registrationFilePath, "Year_2016");
    private String Year_1990 = PropertyLoader.getProperty(registrationFilePath, "Year_1990");
    private String gender_male = PropertyLoader.getProperty(registrationFilePath, "gender_man");
    private String gender_female = PropertyLoader.getProperty(registrationFilePath, "gender_female");
    private String LocationEN = PropertyLoader.getProperty(registrationFilePath, "LocationEN");
    private String LocationAR = PropertyLoader.getProperty(registrationFilePath, "LocationAR");

    private String UserName = PropertyLoader.getProperty(registrationFilePath, "UserName");
    private String EmailUser = PropertyLoader.getProperty(registrationFilePath, "EmailUser");

    private String profileFilePath = "src/test/resources/profile.properties";
    private String FirstName_En = PropertyLoader.getProperty(profileFilePath, "FirstName_En");
    private String FirstName_En_now = PropertyLoader.getProperty(profileFilePath, "FirstName_En_now");
    private String FirstName_En_exp = PropertyLoader.getProperty(profileFilePath, "FirstName_En_exp");
    private String FirstName_Ar_exp = PropertyLoader.getProperty(profileFilePath, "FirstName_Ar_exp");
    private String LastName_En = PropertyLoader.getProperty(profileFilePath, "LastName_En");
    private String UserName_En_now = PropertyLoader.getProperty(profileFilePath, "UserName_En_now");
    private String UserName_En = PropertyLoader.getProperty(profileFilePath, "UserName_En");
   // private String FirstName_Ar = PropertyLoader.getProperty(profileFilePath, "FirstName_Ar");
    //private String LastName_Ar = PropertyLoader.getProperty(profileFilePath, "LastName_Ar");
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

    private String propertyItemPath = "src/test/resources/item.properties";
    private String TitleError = PropertyLoader.getProperty(propertyItemPath, "TitleError");
    private String CategoryError = PropertyLoader.getProperty(propertyItemPath, "CategoryError");
    private String SubCategoryError = PropertyLoader.getProperty(propertyItemPath, "SubCategoryError");
    private String PhotoError = PropertyLoader.getProperty(propertyItemPath, "PhotoError");

    private String Title = PropertyLoader.getProperty(propertyItemPath, "Title");
    private String TitleMAX = PropertyLoader.getProperty(propertyItemPath, "TitleMAX");
    private String DescriptionMAX = PropertyLoader.getProperty(propertyItemPath, "DescriptionMAX");
    private String TitleAR = PropertyLoader.getProperty(propertyItemPath, "TitleAR");
    private String DescriptionAR = PropertyLoader.getProperty(propertyItemPath, "DescriptionAR");
    private String DescriptionNull = PropertyLoader.getProperty(propertyItemPath, "DescriptionNull");
    private String tag1 = PropertyLoader.getProperty(propertyItemPath, "tag1");
    private String Price = PropertyLoader.getProperty(propertyItemPath, "Price");
    private String PerNull = PropertyLoader.getProperty(propertyItemPath, "PerNull");
    private String PriceMAX = PropertyLoader.getProperty(propertyItemPath, "PriceMAX");
    private String PerMAX = PropertyLoader.getProperty(propertyItemPath, "PerMAX");
    private String Location = PropertyLoader.getProperty(propertyItemPath, "Location");
    private String VideoContent1 = PropertyLoader.getProperty(propertyItemPath, "VideoContent1");
    private String VideoContent2 = PropertyLoader.getProperty(propertyItemPath, "VideoContent2");
    private String VideoContent3 = PropertyLoader.getProperty(propertyItemPath, "VideoContent3");
    private String VideoContent4 = PropertyLoader.getProperty(propertyItemPath, "VideoContent4");
    private String VideoContent5 = PropertyLoader.getProperty(propertyItemPath, "VideoContent5");
    private String AudioContent1 = PropertyLoader.getProperty(propertyItemPath, "AudioContent1");
    private String AudioContent2 = PropertyLoader.getProperty(propertyItemPath, "AudioContent2");
    private String AudioContent3 = PropertyLoader.getProperty(propertyItemPath, "AudioContent3");
    private String AudioContent4 = PropertyLoader.getProperty(propertyItemPath, "AudioContent4");
    private String AudioContent5 = PropertyLoader.getProperty(propertyItemPath, "AudioContent5");
    private String Comment = PropertyLoader.getProperty(propertyItemPath, "Comment");
    private String Service = PropertyLoader.getProperty(propertyItemPath, "Service");
    private String Product = PropertyLoader.getProperty(propertyItemPath, "Product");

    private String propertyProductPath = "src/test/resources/product_xpath.properties";
    private String price_now = PropertyLoader.getProperty(propertyProductPath, "price_now");
    private String title_now = PropertyLoader.getProperty(propertyProductPath, "title_now");
    private String description_now = PropertyLoader.getProperty(propertyProductPath, "description_now");
    private String location_now = PropertyLoader.getProperty(propertyProductPath, "location_now");
    private String tag_now = PropertyLoader.getProperty(propertyProductPath, "tag_now");
    private String audio_now = PropertyLoader.getProperty(propertyProductPath, "audio_now");
    private String visa = PropertyLoader.getProperty(propertyProductPath, "visa");
    private String mastercard = PropertyLoader.getProperty(propertyProductPath, "mastercard");
    private String paypal = PropertyLoader.getProperty(propertyProductPath, "paypal");
    private String debitcard = PropertyLoader.getProperty(propertyProductPath, "debitcard");
    private String cash = PropertyLoader.getProperty(propertyProductPath, "cash");
    private String adv_payment_now = PropertyLoader.getProperty(propertyProductPath, "adv_payment_now");
    private String available = PropertyLoader.getProperty(propertyProductPath, "available");
    private String service_online = PropertyLoader.getProperty(propertyProductPath, "service_online");
    private String yearsExperience = PropertyLoader.getProperty(propertyProductPath, "yearsExperience");

    private String HomePage = PropertyLoader.getProperty(propertyFilePath, "HomePage");
    private String Login = PropertyLoader.getProperty(propertyFilePath, "Login");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    RegisterSteps registerSteps;

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
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {driver.quit();}

    @Test
    public void stage0_Login_Facebook()  throws Exception {
        registerSteps.facebookLogin(driver, fb_Email2, fb_Password2);
        loginSteps.openLoginPage();
        loginSteps.pressLoginLink();
        registerSteps.viaFacebook_Login(driver);
    }
    @Test
    public void stage1_Reg_Google()  throws Exception {
        registerSteps.GoogleLogin(driver, gg_Email2, gg_Password2);
        loginSteps.openLoginPage();
        loginSteps.pressLoginLink();
        registerSteps.viaGoogle_Login(driver);
        registerSteps.successReg_Google();
    }
    @Test
    public void stage2_Login_Twitter()  throws Exception {
        registerSteps.TwitterLogin(driver, tw_Email2, tw_Password2);
        loginSteps.openLoginPage();
        loginSteps.pressLoginLink();
        registerSteps.viaTwitter_Login(driver);
    }
    @Test
    public void stage3_Reg_User() throws Exception {
        registerSteps.openRegisterPage();
        registerSteps.selectUser();
        registerSteps.selectGenderFemale();
        registerSteps.clickEmailForm();
        registerSteps.enterEmail(NewEmailUser);
        registerSteps.enterName(FirstNameEn);
        registerSteps.enterUserName(UserNameEn);
        registerSteps.enterPassword(NewPassword);
        registerSteps.clickDoneButton();
        loginSteps.Sleep(200);
        registerSteps.checkWelcomeLetter(NewEmailUser);
    }
    @Test
    public void stage4_EditMainDetails1()  throws Exception {
        /*registerSteps.facebookLogin(driver, fb_Email2, fb_Password2);
        loginSteps.PageComplete(driver);
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        registerSteps.viaFacebook_Login(driver);
        loginSteps.PageComplete(driver);
        registerSteps.successLogIn(driver);*/

        loginSteps.openLoginPage();
        driver.get("http://mnassa.com/en");
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);

        accountSettingsSteps.enterFirstName(FirstName_En);
        //accountSettingsSteps.enterLastName(LastName_En);
        accountSettingsSteps.enterUserName(UserName_En);
        // accountSettingsSteps.selectGenderFeMale();
        accountSettingsSteps.selectGenderMale(Male);
        accountSettingsSteps.selectLanguageArabian();
        accountSettingsSteps.selectLanguageEnglish();
        accountSettingsSteps.selectBirth();
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,15)", "");
        accountSettingsSteps.selectStatusMarried(married);
        // accountSettingsSteps.selectStatusSingle();
        accountSettingsSteps.selectLocation1(location);
        accountSettingsSteps.enterBriefInfo(BriefInfo);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate1(driver);
        loginSteps.PageComplete(driver);
        //UserTrace info page
       /* headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.checkInfoExists(FirstName_En_exp, FirstName_En_now);
        accountSettingsSteps.checkInfoExists(UserName_En, UserName_En_now);
        accountSettingsSteps.checkInfoExists(location_now2_exp, location_now_profile);
        accountSettingsSteps.checkInfoExists(location_now2_exp, location_now1);
        //accountSettingsSteps.checkInfoExists(location_now2_exp, location_now2);
        accountSettingsSteps.checkInfoExists(BriefInfo, BriefInfo_now);
        accountSettingsSteps.checkInfoExists(Male, gender_now);
        accountSettingsSteps.checkInfoExists(married, status_now);
        accountSettingsSteps.checkInfoExists(birth_exp, birth_now);*/
    }
    @Test
    public void stage5_EditMainDetails2() throws Exception {
        /*registerSteps.facebookLogin(driver, fb_Email2, fb_Password2);
        loginSteps.PageComplete(driver);
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        registerSteps.viaFacebook_Login(driver);
        loginSteps.PageComplete(driver);
        registerSteps.successLogIn(driver);*/

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.checkInfoExists(FirstName_En_exp, FirstName_En_now);
        accountSettingsSteps.checkInfoExists(UserName_En, UserName_En_now);
        accountSettingsSteps.checkInfoExists(location_now2_exp, location_now_profile);
        accountSettingsSteps.checkInfoExists(location_now2_exp, location_now1);
        //accountSettingsSteps.checkInfoExists(location_now2_exp, location_now2);
        accountSettingsSteps.checkInfoExists(BriefInfo, BriefInfo_now);
        accountSettingsSteps.checkInfoExists(Male, gender_now);
        accountSettingsSteps.checkInfoExists(married, status_now);
        accountSettingsSteps.checkInfoExists(birth_exp, birth_now);
    }
    @Test
    public void stage6_EditContactInfo1() throws IOException{
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);

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

        //UserTrace info page
       /* headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkInfoExists(mobile_exp, mobile_now);
        accountSettingsSteps.checkInfoExists(landline_exp, landline_now);
        accountSettingsSteps.checkInfoExists(WebSite_exp, WebSite_now);
        accountSettingsSteps.checkInfoExists(NewEmailUser, email_now);
        accountSettingsSteps.checkNetworkAccounts();*/
    }
    @Test
    public void stage7_EditContactInfo2() throws IOException{
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkInfoExists(mobile_exp, mobile_now);
        accountSettingsSteps.checkInfoExists(landline_exp, landline_now);
        accountSettingsSteps.checkInfoExists(WebSite_exp, WebSite_now);
        accountSettingsSteps.checkInfoExists(NewEmailUser, email_now);
        accountSettingsSteps.checkNetworkAccounts();
    }
    @Test
    public void stage8_AddEducationInfo() throws IOException{
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);

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

        //UserTrace info page
        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkEducationInfo(InstitutionName,Speciality,location,About);
    }
    @Test
    public void stage9_AddJobInfo() throws IOException{
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);

        accountSettingsSteps.pressCollapseJobInfo();
        accountSettingsSteps.pressAddJobButton();
        accountSettingsSteps.enterJobName(JobName);
        accountSettingsSteps.enterJobFromDate();
        accountSettingsSteps.enterJobTillDate();
        accountSettingsSteps.enterJobSpeciality(JobSpeciality);
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
    public void stage9a_Add_Skills_Interests1() throws Exception{
        /*registerSteps.facebookLogin(driver, fb_Email2, fb_Password2);
        loginSteps.openLoginPage();
        registerSteps.viaFacebook_Login(driver);
        loginSteps.PageComplete(driver);
        registerSteps.successLogIn(driver);*/

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);

        accountSettingsSteps.pressCollapseSkillsInfo();
        accountSettingsSteps.enterSkill(Skill, driver);
        accountSettingsSteps.enterInterest(Interest,driver);
        accountSettingsSteps.clickUpdate5(driver);
        //loginSteps.PageComplete(driver);
        //UserTrace info page
       /* headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkSkillsInfo(Skill,Interest);*/
    }
    @Test
    public void stage9b_Add_Skills_Interests2() throws Exception{
        /*registerSteps.facebookLogin(driver, fb_Email2, fb_Password2);
        loginSteps.openLoginPage();
        registerSteps.viaFacebook_Login(driver);
        loginSteps.PageComplete(driver);
        registerSteps.successLogIn(driver);*/

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        accountSettingsSteps.checkSkillsInfo(Skill,Interest);
    }

    @Test
    public void stage9c_addServiceSupply_MAX_byButtonInListing() throws IOException{
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyServiceListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(TitleMAX, DescriptionMAX);
        addItemSteps.selectCategory2();

        addItemSteps.collapseMainInfo();
        addItemSteps.selectServiceWillBeAvailableSoon();
        //addItemSteps.selectServiceWillBeAvailable();

        addItemSteps.clickServiceOnline();
        addItemSteps.enterTag(tag1);
        addItemSteps.selectYearsOfExperienceMore();
        addItemSteps.enterPrice(PriceMAX, PerMAX);

        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,100)", "");
        addItemSteps.selectAdvancedPayment100();
        addItemSteps.enterLocation(Location);
        addItemSteps.selectMethodVisa();
        addItemSteps.selectMethodMasterCard();
        addItemSteps.selectMethodPayPal();
        addItemSteps.selectMethodDebitCard();
        addItemSteps.selectMethodCash();

        //addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent5(VideoContent5, VideoContent2, VideoContent3, VideoContent4, VideoContent1);
        loginSteps.Sleep(100);
        //Скролим страницу вверх
        addItemSteps.AudioContent5(AudioContent1,AudioContent2, AudioContent3, AudioContent4, AudioContent5);
        jse1.executeScript("window.scrollBy(0,-450)", "");
        addItemSteps.collapseContent();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.ItemStatusActivate();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);

        jse1.executeScript("window.scrollBy(0,-400)", "");
        //сделала больше -200 -> -250
        //сделала меньше -200 -> -180
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        //проверяем соответствие введенных и отображаемых значений
        addItemSteps.checkBreadCrumb(Service,TitleMAX,  driver);
        addItemSteps.checkValueExists(TitleMAX, title_now);
        addItemSteps.checkValueExists(DescriptionMAX, description_now);
        addItemSteps.checkValueExists("999,999,999,999.99", price_now);
        addItemSteps.checkValueExists(PerMAX, price_now);
        addItemSteps.checkValueExists(Location, location_now);
        addItemSteps.checkValueExists(tag1, tag_now);
        addItemSteps.checkValueExists("100%", adv_payment_now);
        addItemSteps.checkValueExists("No longer available", available);
        addItemSteps.checkValueExists("Online", service_online);
        addItemSteps.checkValueExists("10+ years", yearsExperience);

        addItemSteps.checkElementPresents(audio_now);
        addItemSteps.checkElementPresents(visa);
        addItemSteps.checkElementPresents(mastercard);
        addItemSteps.checkElementPresents(paypal);
        addItemSteps.checkElementPresents(debitcard);
        addItemSteps.checkElementPresents(cash);
    }
    @Test
    public void stage9e_addProductDemand_AR_byButtonFromHeader() throws IOException, Exception, AWTException {
        /*registerSteps.facebookLogin(driver, fb_Email2, fb_Password2);
        loginSteps.openLoginPage();
        registerSteps.viaFacebook_Login(driver);
        loginSteps.PageComplete(driver);
        registerSteps.successLogIn(driver);*/

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.clickAddButton(driver);
        addItemSteps.selectItemType(Product, driver);
        loginSteps.PageComplete(driver);

        addItemSteps.selectDemand();
        addItemSteps.enterBasicInfo(TitleAR, DescriptionAR);
        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        addItemSteps.enterTag(tag1);
        addItemSteps.enterLocation(Location);

      /*  addItemSteps.ImageContent();
        addItemSteps.pressUploadImageLink();
        addItemSteps.uploadImage();
        addItemSteps.CropPopup_ChooseImage();*/

        addItemSteps.VideoContent1(VideoContent1);

        /*addItemSteps.collapseContent();

        addItemSteps.collapseContent();
        addItemSteps.FileContent();
        addItemSteps.pressUploadFileLink();
        addItemSteps.uploadImage();*/

        addItemSteps.collapseContent();
        //addItemSteps.ItemStatusActivate();
        addItemSteps.ItemStatusDeactivate();
        loginSteps.PageComplete(driver);
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        //loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyProductListing(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        //проверяем соответствие введенных и отображаемых значений
        addItemSteps.checkBreadCrumb(Product,TitleAR,  driver);
        addItemSteps.checkValueExists(TitleAR, title_now);
        addItemSteps.checkValueExists(DescriptionAR, description_now);
        addItemSteps.checkValueExists(Location, location_now);
        addItemSteps.checkValueExists(tag1, tag_now);
    }
    @Test
    public void stage9i_ChangePassword1() throws IOException{
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);

        accountSettingsSteps.pressCollapseChangePassword();
        accountSettingsSteps.enterCurrentPassword(NewPassword);
        accountSettingsSteps.enterNewPassword(NewPassword_change);
        accountSettingsSteps.enterNewConfirmPassword(NewConfirmPassword);
        loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate6(driver);
    }
    @Test
    public void stage9j_ChangePassword2() throws IOException{
        loginSteps.openLoginPage();
        //loginSteps.PageComplete(driver);
        loginSteps.pressLoginLink();
        loginSteps.enterLogin(NewEmailUser);
        loginSteps.enterPassword(NewPassword_change);
        loginSteps.clickEnter(driver);
    }
    @Test
    @Ignore
    public void stage9c_Register_User()  throws IOException {
        registerSteps.openRegisterPage();
        loginSteps.PageComplete(driver);

        registerSteps.Step1_UserName(UserNameEn);
        registerSteps.Step1_Email(NewEmailUser);
        registerSteps.Step1_Password(NewPassword);
        registerSteps.Step1_pressButton_Next();
        registerSteps.Step2_FirstName(FirstNameEn);
        registerSteps.Step2_LastName(LastNameEn);
        registerSteps.Step2_Gender(driver, gender_female);
        registerSteps.Step2_Location(driver, LocationEN);
        registerSteps.Step2_pressButton_Confirm(driver);
        registerSteps.Step3_Ok(driver, NewEmailUser);

        registerSteps.goConfirmLink(driver,NewEmailUser);
        registerSteps.successRegistration(driver);
        registerSteps.checkWelcomeLetter(NewEmailUser);
        WebDriverWait wt = new WebDriverWait (driver, 50);
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='wall-post-length']")));
        registerSteps.checkWelcomeLetter(NewEmailUser);
    }
}