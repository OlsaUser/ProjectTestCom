package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.*;
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
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.MethodSorters;
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

/**
 * Created by olsa on 4/29/2016.
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t2_AddItemServiceStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String TitleError = PropertyLoader.getProperty(propertyItemPath, "TitleError");
    private String CategoryError = PropertyLoader.getProperty(propertyItemPath, "CategoryError");
    private String SubCategoryError = PropertyLoader.getProperty(propertyItemPath, "SubCategoryError");
    private String PhotoError = PropertyLoader.getProperty(propertyItemPath, "PhotoError");
    private String attach1 = PropertyLoader.getProperty(propertyItemPath, "attach1");
    private String attach2 = PropertyLoader.getProperty(propertyItemPath, "attach2");
    private String attach3 = PropertyLoader.getProperty(propertyItemPath, "attach3");
    private String attach4 = PropertyLoader.getProperty(propertyItemPath, "attach4");
    private String attach5 = PropertyLoader.getProperty(propertyItemPath, "attach5");

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
    public void setup() throws IOException{
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", dir + "\\src\\drivers\\geckodriver.exe");

        driver.manage().window().maximize();

        loginSteps.openLoginPage();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}
    /*************************************************************/

    @Test
    public void stage1_addServiceSupply_MandatoryFields_ImageCover_Attaches_byButtonFromHeader() throws AWTException {
        addItemSteps.clickAddButton(driver);
        addItemSteps.selectItemType(Service, driver);
        loginSteps.PageComplete(driver);
        addItemSteps.selectSupply();
        loginSteps.PageComplete(driver);
        addItemSteps.enterBasicInfo(Title, DescriptionNull);
        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,400)", "");
        addItemSteps.enterPrice(Price, PerNull);

        //addItemSteps.collapseMainDetails();
        addItemSteps.ImageContent();
        addItemSteps.pressUploadImageLink();
        loginSteps.uploadImage("tech7.jpg");
        addItemSteps.CropPopup_ChooseImage();

        addItemSteps.pressUploadImageLink();
        loginSteps.uploadImage("tech2.jpg");
        addItemSteps.CropPopup_ChooseImage();

        addItemSteps.VideoContent1(VideoContent1);

        addItemSteps.FileContent();
        addItemSteps.pressUploadFileLink();
        loginSteps.uploadImage("SYNERGY_TestPlan.xlsx");
       /* addItemSteps.pressUploadFileLink();
        loginSteps.uploadImage("SYNERGY-TestPlan.pdf");
        addItemSteps.checkUploadedFile();
        addItemSteps.pressUploadFileLink();
        loginSteps.uploadImage("Document_node.txt");
        addItemSteps.checkUploadedFile();*/
        loginSteps.uploadImage("test.doc");
        addItemSteps.checkUploadedFile();
        loginSteps.uploadImage("tech2.jpg");
        addItemSteps.checkUploadedFile();

        addItemSteps.collapseContent();
        //addItemSteps.ItemStatusActivate();
        addItemSteps.ItemStatusDeactivate();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyServiceListing(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        addItemSteps.checkElementPresents(attach1);
        addItemSteps.checkElementPresents(attach2);
        addItemSteps.checkElementPresents(attach3);
        //addItemSteps.checkElementPresents(attach4);
        //addItemSteps.checkElementPresents(attach5);
    }

    @Test
    public void stage5_addServiceSupply_MAX_byButtonInListing() {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyServiceListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(TitleMAX, DescriptionMAX);
        addItemSteps.selectCategory1();

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

       /* JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,200)", "");*/

        //addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent5(VideoContent5, VideoContent2, VideoContent3, VideoContent4, VideoContent1);
        loginSteps.Sleep(100);
        //Скролим страницу вверх
        //jse1.executeScript("window.scrollBy(0,-900)", "");
        addItemSteps.AudioContent5(AudioContent1,AudioContent2, AudioContent3, AudioContent4, AudioContent5);
        jse1.executeScript("window.scrollBy(0,-450)", "");
        addItemSteps.collapseContent();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.ItemStatusActivate();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);

        //проверяем соответствие введенных и отображаемых значений
       /* addItemSteps.checkCommonValuesPreview(TitleMAX, DescriptionMAX,tag1,PerMAX, Location);
        addItemSteps.checkServiceValuesPreviewEN();
        addItemSteps.checkServiceValuesPreviewAR();*/

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
    public void stage4_addServiceSupply_AR(){
        addItemSteps.clickAddButton(driver);
        addItemSteps.selectItemType(Service, driver);
        loginSteps.PageComplete(driver);
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(TitleAR, DescriptionAR);

        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        addItemSteps.enterTag(tag1);
        addItemSteps.selectYearsOfExperienceFew();
        addItemSteps.enterPriceFree();
        addItemSteps.enterLocation(Location);

        addItemSteps.VideoContent3(VideoContent5, VideoContent2, VideoContent3);
        addItemSteps.AudioContent3(AudioContent1, AudioContent2, AudioContent3);

        addItemSteps.collapseContent();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.ItemStatusPeriod();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);

        loginSteps.PageComplete(driver);
        loginSteps.PageComplete(driver);
        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        addItemSteps.checkBreadCrumb(Service,TitleAR, driver);

        addItemSteps.addComment(driver, Comment);
        addItemSteps.checkCommentAdded(Comment);
    }

    @Test
    public void stage3_addServiceDemand_MandatoryFields_byButtonInHeader() {
        addItemSteps.clickAddButton(driver);
        addItemSteps.selectItemType(Service, driver);
        loginSteps.PageComplete(driver);
        addItemSteps.selectDemand();
        addItemSteps.enterBasicInfo(Title, DescriptionNull);
        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent1(VideoContent1);
        addItemSteps.collapseContent();
        addItemSteps.ItemStatusDeactivate();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);
    }

    @Test
    public void stage2_addServiceDemand_MAX_byButtonInListing() {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyServiceListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        addItemSteps.selectDemand();
        addItemSteps.enterBasicInfo(TitleAR, DescriptionAR);
        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        addItemSteps.enterTag(tag1);
        addItemSteps.enterLocation(Location);

        addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent5(VideoContent5, VideoContent2, VideoContent3, VideoContent4, VideoContent1);
        loginSteps.Sleep(100);
        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,-1000)", "");
        addItemSteps.AudioContent5(AudioContent1,AudioContent2, AudioContent3, AudioContent4, AudioContent5);
        //addItemSteps.collapseContent();
        addItemSteps.ItemStatusDeactivate();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        //проверяем соответствие введенных и отображаемых значений
        addItemSteps.checkBreadCrumb(Service,TitleAR,  driver);
        addItemSteps.checkValueExists(TitleAR, title_now);
        addItemSteps.checkValueExists(DescriptionAR, description_now);
        addItemSteps.checkValueExists(Location, location_now);
        addItemSteps.checkValueExists(tag1, tag_now);
        addItemSteps.checkElementPresents(audio_now);
    }

    @Test
    public void stage6_checkItemErrorPresent() {
        addItemSteps.clickAddButton(driver);
        addItemSteps.selectItemType(Service, driver);
        loginSteps.PageComplete(driver);
        addItemSteps.selectSupply();

       /* addItemSteps.collapseBasicInfo();
        addItemSteps.collapseMainDetails();
        addItemSteps.collapseContent();*/

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,800)", "");

        addItemSteps.clickSaveError();
        jse.executeScript("window.scrollBy(0,-800)", "");
        addItemSteps.checkItemErrorPresent(TitleError, CategoryError, SubCategoryError, PhotoError);
    }
}
