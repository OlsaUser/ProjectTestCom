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
public class t2_AddItemProjectStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyItemPath = "src/test/resources/item.properties";
    private String Description = PropertyLoader.getProperty(propertyItemPath, "Description");
    private String TitleMAX = PropertyLoader.getProperty(propertyItemPath, "TitleMAX");
    private String DescriptionMAX = PropertyLoader.getProperty(propertyItemPath, "DescriptionMAX");
    private String TitleAR = PropertyLoader.getProperty(propertyItemPath, "TitleAR");
    private String DescriptionAR = PropertyLoader.getProperty(propertyItemPath, "DescriptionAR");
    private String tag1 = PropertyLoader.getProperty(propertyItemPath, "tag1");
    private String Price = PropertyLoader.getProperty(propertyItemPath, "Price");
    private String Location = PropertyLoader.getProperty(propertyItemPath, "Location");
    private String VideoContent2 = PropertyLoader.getProperty(propertyItemPath, "VideoContent2");
    private String VideoContent3 = PropertyLoader.getProperty(propertyItemPath, "VideoContent3");
    private String AudioContent1 = PropertyLoader.getProperty(propertyItemPath, "AudioContent1");
    private String AudioContent2 = PropertyLoader.getProperty(propertyItemPath, "AudioContent2");
    private String AudioContent3 = PropertyLoader.getProperty(propertyItemPath, "AudioContent3");
    private String Project = PropertyLoader.getProperty(propertyItemPath, "Project");

    private String propertyProjectPath = "src/test/resources/project_xpath.properties";
    private String price_now = PropertyLoader.getProperty(propertyProjectPath, "price_now");
    private String title_now = PropertyLoader.getProperty(propertyProjectPath, "title_now");
    private String description_now = PropertyLoader.getProperty(propertyProjectPath, "description_now");
    private String location_now = PropertyLoader.getProperty(propertyProjectPath, "location_now");
    private String tag_now = PropertyLoader.getProperty(propertyProjectPath, "tag_now");
    private String audio_now = PropertyLoader.getProperty(propertyProjectPath, "audio_now");
    private String stage_study_now = PropertyLoader.getProperty(propertyProjectPath, "stage_study_now");
    private String financial_support_now = PropertyLoader.getProperty(propertyProjectPath, "financial_support_now");
    private String management_support_now = PropertyLoader.getProperty(propertyProjectPath, "management_support_now");
    private String business_partner_now = PropertyLoader.getProperty(propertyProjectPath, "business_partner_now");
    private String project_status_now = PropertyLoader.getProperty(propertyProjectPath, "project_status_now");

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

        driver.manage().window().maximize();

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        loginSteps.pressLoginLink();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();
    }
    /*************************************************************/

  /*  @Test
    public void addPartnershipSupply_MandatoryFields_byButtonFromHeader() throws IOException {
        addItemSteps.openAddItemPage(driver);
        //addItemSteps.selectItemTypePartnership(driver);
        addItemSteps.selectItemType(Partnership, driver);
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(Title, DescriptionNull);

        addItemSteps.collapseBasicInfo();
        addItemSteps.selectCategory1();
        addItemSteps.selectSubCategory1();

        addItemSteps.collapseMainDetails();
        addItemSteps.ImageContent();
        addItemSteps.VideoContent1(VideoContent1);

        addItemSteps.collapseContent();
        addItemSteps.ItemStatusActivate();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.clickSave(driver);
        //loginSteps.Sleep(100);
        addItemSteps.checkItemSaved(driver);*/

       /* addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        addItemSteps.addComment(driver, Comment);
        addItemSteps.checkCommentAdded(Comment);*/
  /*  }*/

    @Test
    public void addProjectDemand_AR_byButtonInListing(){
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyPartnershipListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        addItemSteps.selectDemand();
        addItemSteps.enterBasicInfo(TitleAR, DescriptionAR);
        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        addItemSteps.enterTag(tag1);
        addItemSteps.enterLocation(Location);

        addItemSteps.collapseMainDetails();
        addItemSteps.VideoContent3(VideoContent3, VideoContent2, VideoContent3);
        addItemSteps.AudioContent3(AudioContent1, AudioContent2, AudioContent3);
        //loginSteps.Sleep(100);
        addItemSteps.collapseContent();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.ItemStatusPeriod();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        //проверяем соответствие введенных и отображаемых значений
        addItemSteps.checkBreadCrumb(Project,TitleAR,  driver);
        addItemSteps.checkValueExists(TitleAR, title_now);
        addItemSteps.checkValueExists(DescriptionAR, description_now);
        addItemSteps.checkValueExists(Location, location_now);
        addItemSteps.checkValueExists(tag1, tag_now);
        addItemSteps.checkElementPresents(audio_now);
    }

    @Test
    public void addProjectSupply_AllFields_byButtonInListing() {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyPartnershipListing(driver);
        addItemSteps.openAddItemPageByClickingOnButtonInListing();
        loginSteps.PageComplete(driver);
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(TitleMAX, DescriptionMAX);
        addItemSteps.selectCategory1();

        addItemSteps.collapseMainInfo();
        addItemSteps.enterTag(tag1);
        addItemSteps.enterLocation(Location);

        addItemSteps.FinancialSupport(Price);
        addItemSteps.ManagementSupport(Description);

        addItemSteps.VideoContent1(VideoContent2);
        addItemSteps.AudioContent1(AudioContent1);
        addItemSteps.collapseContent();

        addItemSteps.selectProjectStudy();
        addItemSteps.selectRegisteredInProcess();
        addItemSteps.selectPartnerYes();

        addItemSteps.ItemStatusActivate();
        //addItemSteps.ItemStatusDeactivate();
        addItemSteps.clickSave(driver);
        addItemSteps.checkItemSaved(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.openItemSettingsMenu();
        addItemSteps.selectViewMenu(driver);
        //проверяем соответствие введенных и отображаемых значений
        addItemSteps.checkBreadCrumb(Project,TitleMAX,  driver);
        addItemSteps.checkValueExists(TitleMAX, title_now);
        addItemSteps.checkValueExists(DescriptionMAX, description_now);
        addItemSteps.checkValueExists(Location, location_now);
        addItemSteps.checkValueExists(tag1, tag_now);

        addItemSteps.checkElementPresents(audio_now);
        addItemSteps.checkValueExists("Study",stage_study_now);
        addItemSteps.checkValueExists("2,500",financial_support_now);
        addItemSteps.checkValueExists(Description, management_support_now);
        addItemSteps.checkValueExists("I have business partner now", business_partner_now);
        addItemSteps.checkValueExists("In the process", project_status_now);
    }
}