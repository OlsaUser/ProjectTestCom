package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AddAlbumSteps;
import com.ProjectTestCom.steps.AddItemSteps;
import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
import com.ProjectTestCom.utils.PropertyLoader;
import com.ProjectTestCom.utils.RetryRule;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by olsa on 5/24/2016.
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t2_AddItemEventsStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String Title = PropertyLoader.getProperty(propertyItemPath, "Title");
    private String Description = PropertyLoader.getProperty(propertyItemPath, "Description");
    private String TitleMAX = PropertyLoader.getProperty(propertyItemPath, "TitleMAX");
    private String DescriptionMAX = PropertyLoader.getProperty(propertyItemPath, "DescriptionMAX");
    private String TitleMIN = PropertyLoader.getProperty(propertyItemPath, "TitleMIN");
    private String DescriptionMIN = PropertyLoader.getProperty(propertyItemPath, "DescriptionMIN");
    private String TitleAR = PropertyLoader.getProperty(propertyItemPath, "TitleAR");
    private String DescriptionAR = PropertyLoader.getProperty(propertyItemPath, "DescriptionAR");
    private String DescriptionNull = PropertyLoader.getProperty(propertyItemPath, "DescriptionNull");

    private String tag1 = PropertyLoader.getProperty(propertyItemPath, "tag1");
    private String Price = PropertyLoader.getProperty(propertyItemPath, "Price");
    private String Per = PropertyLoader.getProperty(propertyItemPath, "Per");
    private String PerNull = PropertyLoader.getProperty(propertyItemPath, "PerNull");
    private String PriceMAX = PropertyLoader.getProperty(propertyItemPath, "PriceMAX");
    private String PerMAX = PropertyLoader.getProperty(propertyItemPath, "PerMAX");
    private String PriceMIN = PropertyLoader.getProperty(propertyItemPath, "PriceMIN");
    private String PerMIN = PropertyLoader.getProperty(propertyItemPath, "PerMIN");

    private String Location = PropertyLoader.getProperty(propertyItemPath, "Location");
    private String textContent = PropertyLoader.getProperty(propertyItemPath, "textContent");
    private String textContentMAX = PropertyLoader.getProperty(propertyItemPath, "textContentMAX");
    private String textContentMIN = PropertyLoader.getProperty(propertyItemPath, "textContentMIN");
    private String textContentAR = PropertyLoader.getProperty(propertyItemPath, "textContentAR");

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

    private String LinksContent1 = PropertyLoader.getProperty(propertyItemPath, "LinksContent1");
    private String LinksContent2 = PropertyLoader.getProperty(propertyItemPath, "LinksContent2");
    private String LinksContent3 = PropertyLoader.getProperty(propertyItemPath, "LinksContent3");
    private String LinksContent4 = PropertyLoader.getProperty(propertyItemPath, "LinksContent4");
    private String LinksContent5 = PropertyLoader.getProperty(propertyItemPath, "LinksContent5");

    private String AddItem = PropertyLoader.getProperty(propertyItemPath, "AddItem");
    private String Comment = PropertyLoader.getProperty(propertyItemPath, "Comment");
    private String Address = PropertyLoader.getProperty(propertyItemPath, "Address");
    private String ticketPrice = PropertyLoader.getProperty(propertyItemPath, "ticketPrice");
    private String OrganizerName = PropertyLoader.getProperty(propertyItemPath, "OrganizerName");
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
    LoginSteps loginSteps;

    @Steps
    AddItemSteps addItemSteps;

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
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();
    }
    @Test
    public void stage1_addEventSupply_AllFields_byButtonInListing() throws Error{
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
    @Test
    public void stage2_addEventSupply_MandatoryFields_byButtonFromHeader() {
        addItemSteps.clickAddButton(driver);
        addItemSteps.selectItemType(Event, driver);
        loginSteps.PageComplete(driver);
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(Title, DescriptionNull);
        addItemSteps.selectCategory1();
        //addItemSteps.collapseBasicInfo();
        addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent1(VideoContent3);
        addItemSteps.collapseContent();
        addItemSteps.ItemStatusActivate();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        //проверяем соответствие введенных и отображаемых значений
        addItemSteps.checkBreadCrumb(Event,Title, driver);
        addItemSteps.addComment(driver, Comment);
        addItemSteps.checkCommentAdded(Comment);
    }

    @Test
    public void stage3_addEventDemand_AR_byButtonInListing(){
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyEventListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        addItemSteps.selectDemand();
        addItemSteps.enterBasicInfo(TitleAR, DescriptionAR);
        addItemSteps.selectCategory1();
        addItemSteps.collapseBasicInfo();
        addItemSteps.enterTag(tag1);
        addItemSteps.enterLocation(Location);
        addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent1(VideoContent3);
       // addItemSteps.AudioContent3(AudioContent1, AudioContent2, AudioContent3);
        addItemSteps.collapseContent();
       // addItemSteps.ItemStatusDeactivate();
        addItemSteps.ItemStatusPeriod();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);

        //проверяем соответствие введенных и отображаемых значений
        addItemSteps.checkBreadCrumb(Event,TitleAR,  driver);
        addItemSteps.checkValueExists(TitleAR, title_now);
        addItemSteps.checkValueExists(DescriptionAR, description_now);
        addItemSteps.checkValueExists(Location, location_now);
        addItemSteps.checkValueExists(tag1, tag_now);
    }


 /*   @Ignore
    @Test
    public void addEventSupply_MandatoryFields_byButtonInListing()  {
        addAlbumSteps.openMyMnassaPage();
        addItemSteps.openEventListing();
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(TitleMAX, DescriptionNull);
        addItemSteps.collapseBasicInfo();
        addItemSteps.selectCategory1();
        addItemSteps.selectSubCategory1();
        addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent1(VideoContent5);
        addItemSteps.collapseContent();
        addItemSteps.ItemStatusActivate();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
    }*/
}
