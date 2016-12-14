package com.ProjectTestCom.stories;

import com.ProjectTestCom.pages.ItemPage;
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
import org.junit.runners.Suite;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by olsa on 5/23/2016.
 */

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t2_AddItemProductStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String Title = PropertyLoader.getProperty(propertyItemPath, "Title");
    private String TitleMAX = PropertyLoader.getProperty(propertyItemPath, "TitleMAX");
    private String DescriptionMAX = PropertyLoader.getProperty(propertyItemPath, "DescriptionMAX");
    private String TitleAR = PropertyLoader.getProperty(propertyItemPath, "TitleAR");
    private String DescriptionAR = PropertyLoader.getProperty(propertyItemPath, "DescriptionAR");
    private String DescriptionNull = PropertyLoader.getProperty(propertyItemPath, "DescriptionNull");
    private String tag1 = PropertyLoader.getProperty(propertyItemPath, "tag1");
    private String Price = PropertyLoader.getProperty(propertyItemPath, "Price");
    private String Per = PropertyLoader.getProperty(propertyItemPath, "Per");
    private String PerNull = PropertyLoader.getProperty(propertyItemPath, "PerNull");
    private String Location = PropertyLoader.getProperty(propertyItemPath, "Location");
    private String VideoContent1 = PropertyLoader.getProperty(propertyItemPath, "VideoContent1");
    private String VideoContent2 = PropertyLoader.getProperty(propertyItemPath, "VideoContent2");
    private String VideoContent4 = PropertyLoader.getProperty(propertyItemPath, "VideoContent4");
    private String AudioContent3 = PropertyLoader.getProperty(propertyItemPath, "AudioContent3");
    private String Comment = PropertyLoader.getProperty(propertyItemPath, "Comment");
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
    private String saudipost = PropertyLoader.getProperty(propertyProductPath, "saudipost");
    private String dhl = PropertyLoader.getProperty(propertyProductPath, "dhl");
    private String tnt = PropertyLoader.getProperty(propertyProductPath, "tnt");
    private String aramex = PropertyLoader.getProperty(propertyProductPath, "aramex");
    private String pickup = PropertyLoader.getProperty(propertyProductPath, "pickup");
    private String homedelivery = PropertyLoader.getProperty(propertyProductPath, "homedelivery");
    private String ServiceAvailability_now = PropertyLoader.getProperty(propertyProductPath, "ServiceAvailability_now");
    private String condition_now = PropertyLoader.getProperty(propertyProductPath, "condition_now");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    AddItemSteps addItemSteps;

    @Steps
    HeaderSteps headerSteps;

    @Before
    public void setup() throws IOException {
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", dir + "\\src\\drivers\\geckodriver.exe");

        driver.manage().window().maximize();;

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        loginSteps.pressLoginLink();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void stage1_addProductSupply_AllFields_byButtonInListing()  {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyProductListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        loginSteps.PageComplete(driver);
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(TitleMAX, DescriptionMAX);
        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        addItemSteps.selectAvailabilityOutOfStock();
        //addItemSteps.selectAvailabilityNow();
        //addItemSteps.selectAvailabilitySold();

        addItemSteps.enterTag(tag1);

        //addItemSteps.selectConditionNew();
        addItemSteps.selectConditionUsed();
        addItemSteps.enterPrice(Price, Per);

        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,300)", "");

        addItemSteps.selectAdvancedPayment25();

        addItemSteps.selectMethodMasterCard();
        addItemSteps.selectMethodPayPal();
        addItemSteps.selectMethodCash();
        addItemSteps.selectMethodDebitCard();
        addItemSteps.selectMethodVisa();

        addItemSteps.enterLocation(Location);

        // jse1.executeScript("window.scrollBy(0,300)", "");
        addItemSteps.selectDeliveryMethodDHL();
        addItemSteps.selectDeliveryMethodTNT();
        addItemSteps.selectDeliveryMethodAramex();
        addItemSteps.selectDeliveryMethodPickUp();
        addItemSteps.selectDeliveryMethodHomeDelivery();
        addItemSteps.selectDeliveryMethodSaudiPost();
        addItemSteps.selectDeliveryMethodOther();

        //addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent1(VideoContent4);
        addItemSteps.AudioContent1(AudioContent3);

        //addItemSteps.collapseContent();
        //addItemSteps.ItemStatusActivate();
        addItemSteps.ItemStatusDeactivate();
        addItemSteps.collapseStatus();

        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        //проверяем соответствие введенных и отображаемых значений
        addItemSteps.checkBreadCrumb(Product,TitleMAX,  driver);
        addItemSteps.checkValueExists(TitleMAX, title_now);
        addItemSteps.checkValueExists(DescriptionMAX, description_now);
        addItemSteps.checkValueExists("2,500", price_now);
        addItemSteps.checkValueExists(Per, price_now);
        addItemSteps.checkValueExists(Location, location_now);
        addItemSteps.checkValueExists(tag1, tag_now);
        addItemSteps.checkValueExists("25%", adv_payment_now);
        addItemSteps.checkValueExists("Will be available", ServiceAvailability_now);
        addItemSteps.checkValueExists("Used", condition_now);

        addItemSteps.checkElementPresents(audio_now);
        addItemSteps.checkElementPresents(visa);
        addItemSteps.checkElementPresents(mastercard);
        addItemSteps.checkElementPresents(paypal);
        addItemSteps.checkElementPresents(debitcard);
        addItemSteps.checkElementPresents(cash);

        addItemSteps.checkElementPresents(saudipost);
        addItemSteps.checkElementPresents(dhl);
        addItemSteps.checkElementPresents(tnt);
        addItemSteps.checkElementPresents(aramex);
        addItemSteps.checkElementPresents(pickup);
        addItemSteps.checkElementPresents(homedelivery);
    }

    @Test
    public void stage2_addProductSupply_MandatoryFields_byButtonFromHeader() {
        addItemSteps.clickAddButton(driver);
        addItemSteps.selectItemType(Product, driver);
        loginSteps.PageComplete(driver);

        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(Title, DescriptionNull);
        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        addItemSteps.enterPrice(Price, PerNull);

        addItemSteps.collapseMainDetails();
        //addItemSteps.ImageContent();
        addItemSteps.VideoContent1(VideoContent1);

        addItemSteps.collapseContent();
        addItemSteps.ItemStatusActivate();
        addItemSteps.collapseStatus();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);

        loginSteps.PageComplete(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectEditMenu();
        addItemSteps.selectCategory1();
        addItemSteps.collapseMainInfo();

        addItemSteps.collapseMainDetails();
        addItemSteps.collapseContent();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);

        //loginSteps.PageComplete(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        addItemSteps.checkBreadCrumb(Product,Title, driver);

        addItemSteps.addComment(driver, Comment);
        addItemSteps.checkCommentAdded(Comment);
    }

    @Test
    public void stage3_addProductDemand_AR_byButtonInListing() {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyProductListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        addItemSteps.selectDemand();
        addItemSteps.enterBasicInfo(TitleAR, DescriptionAR);
        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        addItemSteps.enterTag(tag1);
        addItemSteps.enterLocation(Location);

        addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent1(VideoContent2);
       // addItemSteps.AudioContent3(AudioContent1, AudioContent2, AudioContent3);
        addItemSteps.collapseContent();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.ItemStatusPeriod();
        loginSteps.PageComplete(driver);
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
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
}
