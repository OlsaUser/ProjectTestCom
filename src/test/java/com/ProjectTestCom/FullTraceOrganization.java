package com.ProjectTestCom;

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
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import javax.xml.bind.ValidationException;
import javax.xml.parsers.FactoryConfigurationError;
import java.io.File;
import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FullTraceOrganization {
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
    //private String NewEmailOrg = PropertyLoader.getProperty(propertyFilePath, "NewEmailOrg");
    private String email_organization_now = PropertyLoader.getProperty(propertyFilePath, "email_organization_now");
    private String password_organization = PropertyLoader.getProperty(propertyFilePath, "password_organization");

    private String registrationFilePath = "src/test/resources/registration.properties";
    private String NewEmailOrg = PropertyLoader.getProperty(registrationFilePath, "NewEmailOrg");
    private String NewPassword = PropertyLoader.getProperty(registrationFilePath, "NewPassword");
    private String UserNameEn = PropertyLoader.getProperty(registrationFilePath, "UserName_En");
    private String FirstNameEn = PropertyLoader.getProperty(registrationFilePath, "FirstName_En");
    private String LastNameEn = PropertyLoader.getProperty(registrationFilePath, "LastName_En");
    private String FirstName_Ar = PropertyLoader.getProperty(registrationFilePath, "FirstName_Ar");
    private String LastName_Ar = PropertyLoader.getProperty(registrationFilePath, "LastName_Ar");

    private String Year_2014 = PropertyLoader.getProperty(registrationFilePath, "Year_2014");
    private String Year_2014_ar = PropertyLoader.getProperty(registrationFilePath, "Year_2014_ar");
    private String Year_1990 = PropertyLoader.getProperty(registrationFilePath, "Year_1990");
    private String gender_male = PropertyLoader.getProperty(registrationFilePath, "gender_man");
    private String gender_female = PropertyLoader.getProperty(registrationFilePath, "gender_female");
    private String LocationEN = PropertyLoader.getProperty(registrationFilePath, "LocationEN");
    private String LocationAR = PropertyLoader.getProperty(registrationFilePath, "LocationAR");

    private String UserName = PropertyLoader.getProperty(registrationFilePath, "UserName");
    private String EmailUser = PropertyLoader.getProperty(registrationFilePath, "EmailUser");

    private String OrganizationFullNameEn = PropertyLoader.getProperty(registrationFilePath, "OrganizationFullName_En");
    private String OrganizationShortNameEn = PropertyLoader.getProperty(registrationFilePath, "OrganizationShortName_En");

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
    private String location_exp = PropertyLoader.getProperty(profileFilePath, "location_exp");
    private String location_exp_ar = PropertyLoader.getProperty(profileFilePath, "location_exp_ar");
    private String location_now1 = PropertyLoader.getProperty(profileFilePath, "location_now1");
    private String location_now2 = PropertyLoader.getProperty(profileFilePath, "location_now2");
    private String location_now1_exp = PropertyLoader.getProperty(profileFilePath, "location_now1_exp");
    private String location_now2_exp = PropertyLoader.getProperty(profileFilePath, "location_now2_exp");
    private String location_now2_exp_ar = PropertyLoader.getProperty(profileFilePath, "location_now2_exp_ar");
    private String location_now_profile = PropertyLoader.getProperty(profileFilePath, "location_now_profile");
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

    private String OrganizationName_En_exp = PropertyLoader.getProperty(profileFilePath, "OrganizationName_En_exp");
    private String OrganizationName_En_now = PropertyLoader.getProperty(profileFilePath, "OrganizationName_En_now");
    private String OrganizationShortName_En_exp = PropertyLoader.getProperty(profileFilePath, "OrganizationShortName_En_exp");
    private String OrganizationShortName_En_now = PropertyLoader.getProperty(profileFilePath, "OrganizationShortName_En_now");
    private String count = PropertyLoader.getProperty(profileFilePath, "count");
    private String count_now = PropertyLoader.getProperty(profileFilePath, "count_now");
    private String YearFounder_now = PropertyLoader.getProperty(profileFilePath, "YearFounder_now");
    private String YearFounder_exp = PropertyLoader.getProperty(profileFilePath, "YearFounder_exp");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String TitleError = PropertyLoader.getProperty(propertyItemPath, "TitleError");
    private String CategoryError = PropertyLoader.getProperty(propertyItemPath, "CategoryError");
    private String SubCategoryError = PropertyLoader.getProperty(propertyItemPath, "SubCategoryError");
    private String PhotoError = PropertyLoader.getProperty(propertyItemPath, "PhotoError");
    private String OrganizerName = PropertyLoader.getProperty(propertyItemPath, "OrganizerName");
    private String Address = PropertyLoader.getProperty(propertyItemPath, "Address");
    private String ticketPrice = PropertyLoader.getProperty(propertyItemPath, "ticketPrice");

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
    private String Event = PropertyLoader.getProperty(propertyItemPath, "Event");

    private String propertyEventPath = "src/test/resources/event_xpath.properties";
    private String price_now = PropertyLoader.getProperty(propertyEventPath, "price_now");
    private String title_now = PropertyLoader.getProperty(propertyEventPath, "title_now");
    private String description_now = PropertyLoader.getProperty(propertyEventPath, "description_now");
    private String location_now = PropertyLoader.getProperty(propertyEventPath, "location_now");
    private String tag_now = PropertyLoader.getProperty(propertyEventPath, "tag_now");
    private String organizerName_now = PropertyLoader.getProperty(propertyEventPath, "organizerName_now");
    private String eventType_now = PropertyLoader.getProperty(propertyEventPath, "eventType_now");
    private String audience_now = PropertyLoader.getProperty(propertyEventPath, "audience_now");
    private String address_now = PropertyLoader.getProperty(propertyEventPath, "address_now");
    private String audio_now = PropertyLoader.getProperty(propertyEventPath, "audio_now");
    private String visa = PropertyLoader.getProperty(propertyEventPath, "visa");
    private String mastercard = PropertyLoader.getProperty(propertyEventPath, "mastercard");
    private String paypal = PropertyLoader.getProperty(propertyEventPath, "paypal");
    private String debitcard = PropertyLoader.getProperty(propertyEventPath, "debitcard");
    private String cash = PropertyLoader.getProperty(propertyEventPath, "cash");

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
       /*FirefoxProfile myProfile = new FirefoxProfile(new File(BrowserProfile));
        myProfile.setPreference("network.proxy.socks_port",9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);*/
    }

    @After
    public void tearDown() throws Exception {driver.quit();}

    @Test
    public void stage1_Register_Organization() throws Exception {
        //registerSteps.openRegisterPage();
        driver.get("http://synergy.devzone.dp.ua/ar/#!registration");
        loginSteps.PageComplete(driver);

        registerSteps.Step1_selectRadioButton_Organization();
        registerSteps.Step1_UserName(OrganizationShortNameEn);
        registerSteps.Step1_Email(NewEmailOrg);
        registerSteps.Step1_Password(NewPassword);
        registerSteps.Step1_pressButton_Next();
        registerSteps.Step2_OrganizationFullName(OrganizationFullNameEn);
        registerSteps.Step2_Founded(Year_2014_ar, driver);
        registerSteps.Step2_Location(driver, LocationEN);
        registerSteps.Step2_pressButton_Confirm(driver);
        registerSteps.Step3_Ok(driver, NewEmailOrg);

        registerSteps.goConfirmLink_AR(driver,NewEmailOrg);
        registerSteps.checkWelcomeLetter_AR(NewEmailOrg);
    }
    @Test
    public void stage2_EditMainDetails(){
        //loginSteps.openLoginPage();
        driver.get("http://synergy.devzone.dp.ua/ar/#!login");
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(NewEmailOrg);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);

        accountSettingsSteps.enterOrganizationName(OrganizationName_En_exp);
        accountSettingsSteps.enterOrganizationShortName(OrganizationShortName_En_exp);
        accountSettingsSteps.selectTypeGovernmental();
        accountSettingsSteps.selectLanguageEnglish_Org();
        accountSettingsSteps.selectLanguageArabian_Org();
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
        accountSettingsSteps.checkInfoExists(location_exp_ar, location_now_profile);
        accountSettingsSteps.checkInfoExists(location_exp_ar, location_now1);
        accountSettingsSteps.checkInfoExists(location_now2_exp_ar, location_now2);
        accountSettingsSteps.checkInfoExists(BriefInfo, BriefInfo_now);
        accountSettingsSteps.checkInfoExists(count, count_now);
        accountSettingsSteps.checkInfoExists(YearFounder_exp, YearFounder_now);
        //accountSettingsSteps.checkMainDetails_Org(OrganizationName_En,OrganizationShortName_En,location,BriefInfo,count);
    }
    @Test
    public void stage3_EditContactInfo(){
        //loginSteps.openLoginPage();
        driver.get("http://synergy.devzone.dp.ua/ar/#!login");
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(NewEmailOrg);
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
        accountSettingsSteps.checkInfoExists(NewEmailOrg, email_organization_now );
        accountSettingsSteps.checkNetworkAccounts();
    }
    @Test
    public void stage4_ChangePassword() {
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(NewEmailOrg);
        loginSteps.enterPassword(NewPassword);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);

        accountSettingsSteps.pressCollapseChangePassword();
        accountSettingsSteps.enterCurrentPassword(CurrentPassword);
        accountSettingsSteps.enterNewPassword(NewPassword);
        accountSettingsSteps.enterNewConfirmPassword(NewConfirmPassword);
        //loginSteps.PageComplete(driver);
        accountSettingsSteps.clickUpdate6(driver);
    }
       @Test
        public void stage5_addEventSupply_AllFields_byButtonInListing() throws Error{
            //loginSteps.openLoginPage();
            driver.get("http://synergy.devzone.dp.ua/ar/#!login");
            loginSteps.PageComplete(driver);

            loginSteps.enterLogin(NewEmailOrg);
            loginSteps.enterPassword(NewPassword);
            loginSteps.clickEnter(driver);
            loginSteps.PageComplete(driver);

            headerSteps.openMyMnassaPage(driver);
            headerSteps.openMyEventListing(driver);
            addItemSteps.openAddItemPageByClickingOnButtonInListing();
            loginSteps.PageComplete(driver);
            addItemSteps.selectSupply();
            //addItemSteps.collapseBasicInfo();
            //addItemSteps.selectEventDates(driver);
            //addItemSteps.datePicker( "26-09-2016 16:41",  driver);

            addItemSteps.enterBasicInfo(TitleMAX, DescriptionMAX);
            addItemSteps.selectCategory2();
            addItemSteps.selectEventType();

            //addItemSteps.selectRegistrationDates(driver);
            //addItemSteps.collapseBasicInfo();
            //addItemSteps.selectAudienceMales();
            //addItemSteps.selectAudienceFemales();
            //addItemSteps.selectAudienceFamilies();
            addItemSteps.selectAudienceChildren();
            // addItemSteps.selectAudienceAnyone();

            addItemSteps.enterTag(tag1);
            addItemSteps.enterOrganizerName(OrganizerName);
            addItemSteps.enterLocation(Location);
            JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
            jse1.executeScript("window.scrollBy(0,500)", "");
            // addItemSteps.selectRegistrationOpen();
            //addItemSteps.selectEventCanceled();
            //addItemSteps.selectEventEnded();
            addItemSteps.enterAddress(Address);
            //addItemSteps.selectRegistrationClosed();
            //addItemSteps.selectTicketTypeFree();
            addItemSteps.selectTicketTypePaid(ticketPrice);
            //jse1.executeScript("window.scrollBy(0,-200)", "");
            addItemSteps.selectMethodMasterCard();
            addItemSteps.selectMethodPayPal();
            addItemSteps.selectMethodCash();
            addItemSteps.selectMethodDebitCard();
            addItemSteps.selectMethodVisa();

            jse1.executeScript("window.scrollBy(0,300)", "");
            //addItemSteps.collapseMainDetails();
            addItemSteps.VideoContent1(VideoContent5);
            addItemSteps.AudioContent1(AudioContent1);
            //addItemSteps.collapseContent();
            addItemSteps.ItemStatusActivate();
            //addItemSteps.ItemStatusDeactivate();
            addItemSteps.clickSave(driver);
            addItemSteps.checkItemSaved(driver);
            loginSteps.PageComplete(driver);
            addItemSteps.openItemSettingsMenu();
            addItemSteps.selectViewMenu(driver);

            //проверяем соответствие введенных и отображаемых значений
            addItemSteps.checkBreadCrumb(Event,TitleMAX,  driver);
            addItemSteps.checkValueExists(TitleMAX, title_now);
            addItemSteps.checkValueExists(DescriptionMAX, description_now);
            addItemSteps.checkValueExists(ticketPrice, price_now);
            addItemSteps.checkValueExists(Location, location_now);
            addItemSteps.checkValueExists(tag1, tag_now);
            addItemSteps.checkValueExists(OrganizerName, organizerName_now);
            addItemSteps.checkValueExists("Attraction", eventType_now);
            addItemSteps.checkValueExists("Children", audience_now);
            addItemSteps.checkValueExists(Address, address_now);
            addItemSteps.checkElementPresents(audio_now);
            addItemSteps.checkElementPresents(visa);
            addItemSteps.checkElementPresents(mastercard);
            addItemSteps.checkElementPresents(paypal);
            addItemSteps.checkElementPresents(debitcard);
            addItemSteps.checkElementPresents(cash);
        }
}
