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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t2_SearchStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String searchFilePath = "src/test/resources/search.properties";
    //private String searchFilePath = "src/test/resources/search_beta.properties";
    private String FullNameEn = PropertyLoader.getProperty(searchFilePath, "FullNameEn");
    private String FullOrganizationNameEn = PropertyLoader.getProperty(searchFilePath, "FullOrganizationNameEn");
    private String FullNameAr = PropertyLoader.getProperty(searchFilePath, "FullNameAr");
    private String FullOrganizationNameAr = PropertyLoader.getProperty(searchFilePath, "FullOrganizationNameAr");
    private String Number = PropertyLoader.getProperty(searchFilePath, "Number");
    private String NotExistValue = PropertyLoader.getProperty(searchFilePath, "NotExistValue");
    private String ProductTitle = PropertyLoader.getProperty(searchFilePath, "ProductTitle");
    private String ServiceTitle = PropertyLoader.getProperty(searchFilePath, "ServiceTitle");
    private String EventTitle = PropertyLoader.getProperty(searchFilePath, "EventTitle");
    private String ProjectTitle = PropertyLoader.getProperty(searchFilePath, "ProjectTitle");
    private String ProductTitle_Ar = PropertyLoader.getProperty(searchFilePath, "ProductTitle_Ar");
    private String ServiceTitle_Ar = PropertyLoader.getProperty(searchFilePath, "ServiceTitle_Ar");
    private String EventTitle_Ar = PropertyLoader.getProperty(searchFilePath, "EventTitle_Ar");
    private String ProjectTitle_Ar = PropertyLoader.getProperty(searchFilePath, "ProjectTitle_Ar");
    private String ProductTag = PropertyLoader.getProperty(searchFilePath, "ProductTag");
    private String ServiceTag = PropertyLoader.getProperty(searchFilePath, "ServiceTag");
    private String EventTag = PropertyLoader.getProperty(searchFilePath, "EventTag");
    private String PartnershipTag = PropertyLoader.getProperty(searchFilePath, "PartnershipTag");

    private String UserName_User = PropertyLoader.getProperty(searchFilePath, "UserName_User");
    private String UserName_Org = PropertyLoader.getProperty(searchFilePath, "UserName_Org");

    private String BriefInfo_User = PropertyLoader.getProperty(searchFilePath, "BriefInfo_User");
    private String BriefInfo_Org = PropertyLoader.getProperty(searchFilePath, "BriefInfo_Org");

    private String Interest_User = PropertyLoader.getProperty(searchFilePath, "Interest_User");
    private String Skill_User = PropertyLoader.getProperty(searchFilePath, "Skill_User");

    private String ProductDescription = PropertyLoader.getProperty(searchFilePath, "ProductDescription");
    private String ServiceDescription = PropertyLoader.getProperty(searchFilePath, "ServiceDescription");
    private String EventDescription = PropertyLoader.getProperty(searchFilePath, "EventDescription");
    private String ProjectDescription = PropertyLoader.getProperty(searchFilePath, "ProjectDescription");

    private String GroupTitle_En = PropertyLoader.getProperty(searchFilePath, "GroupTitle_En");
    private String GroupTitle_Ar = PropertyLoader.getProperty(searchFilePath, "GroupTitle_Ar");
    private String GroupDescription = PropertyLoader.getProperty(searchFilePath, "GroupDescription");
    private String GroupSkill = PropertyLoader.getProperty(searchFilePath, "GroupSkill");
    private String GroupInterest = PropertyLoader.getProperty(searchFilePath, "GroupInterest");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    FooterSteps footerSteps;

    @Steps
    SearchSteps searchSteps;

    @Steps
    HeaderSteps headerSteps;

    @Before
    public void setup() throws IOException {
        String dir = System.getProperty("user.dir");
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.gecko.driver",dir + "\\src\\drivers\\geckodriver.exe");

        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(1850, TimeUnit.SECONDS);

        footerSteps.openHomePage();
        driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();
    }
    /*************************************************************/

    @Test
    public void stage1_searchBy_FullNameEn() throws IOException {
        searchSteps.clickField_searchBy(FullNameEn, driver);
        searchSteps.selectSearchResult_byUser(FullNameEn, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_FullName(FullNameEn,driver);
        searchSteps.closeResult(driver);
        loginSteps.PageComplete(driver);

        searchSteps.clickField_searchBy(FullOrganizationNameEn, driver);
        searchSteps.selectSearchResult_byOrganization(FullOrganizationNameEn, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_FullName(FullOrganizationNameEn,driver);
        searchSteps.closeResult(driver);
        loginSteps.PageComplete(driver);

        searchSteps.clickField_searchBy(NotExistValue, driver);
        searchSteps.checkEmptySearchResult_User(NotExistValue, driver);
        searchSteps.closeResult(driver);
        loginSteps.PageComplete(driver);

        searchSteps.switchToOrg();
        loginSteps.PageComplete(driver);
    }
    @Test
    public void stage2_searchBy_FullNameAr() throws IOException {

        searchSteps.clickField_searchBy(FullNameAr, driver);
        searchSteps.selectSearchResult_byUser(FullNameAr, driver);
        loginSteps.PageComplete(driver);
        //loginSteps.Sleep(80);
        searchSteps.checkSearchResult_FullName(FullNameAr,driver);
        searchSteps.closeResult(driver);
        loginSteps.PageComplete(driver);

        searchSteps.clickField_searchBy(FullOrganizationNameAr, driver);
        searchSteps.selectSearchResult_byOrganization(FullOrganizationNameAr, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_FullName(FullOrganizationNameAr,driver);
        searchSteps.closeResult(driver);
        loginSteps.PageComplete(driver);

        /*searchSteps.clickField_searchBy(NotExistValue, driver);
        searchSteps.checkEmptySearchResult_User(NotExistValue, driver);
        searchSteps.closeResult(driver);
        loginSteps.PageComplete(driver);

        searchSteps.switchToOrg();
        loginSteps.PageComplete(driver);*/
    }

    @Test
    public void stage3_searchBy_UserName() throws IOException {
        searchSteps.clickField_searchBy(UserName_User, driver);
        searchSteps.selectSearchResult_byUser(UserName_User, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_UserName(UserName_User, driver);

        searchSteps.clickField_searchBy(UserName_Org, driver);
        searchSteps.selectSearchResult_byOrganization(UserName_Org, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_UserName(UserName_Org, driver);
    }

    @Test
    public void stage4_searchBy_BriefInfo() throws IOException {
        searchSteps.clickField_searchBy(BriefInfo_User, driver);
        searchSteps.selectSearchResult_byUser(BriefInfo_User, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_BriefInfo(BriefInfo_User, driver);

        searchSteps.clickField_searchBy(BriefInfo_Org, driver);
        searchSteps.selectSearchResult_byOrganization(BriefInfo_Org, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_BriefInfo(BriefInfo_Org, driver);
    }

    @Test
    public void stage5_searchBy_Skill_Interest() throws IOException {
        searchSteps.clickField_searchBy(Interest_User, driver);
        searchSteps.selectSearchResult_byUser(Interest_User, driver);
        /*loginSteps.PageComplete(driver);
        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,600)", "");*/
        searchSteps.checkSearchResult_Skill(Interest_User, driver);

        searchSteps.clickField_searchBy(Skill_User, driver);
        searchSteps.selectSearchResult_byUser(Skill_User, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_Skill(Skill_User, driver);
    }

    @Test
    public void searchBy_Item_Title() throws IOException {
        searchSteps.clickField_searchBy(ProductTitle, driver);
        searchSteps.selectSearchResult_ProductItem(ProductTitle, driver);
        searchSteps.checkSearchResult_Item(ProductTitle,driver);

        headerSteps.clickLogo();
        loginSteps.PageComplete(driver);
        searchSteps.clickField_searchBy(ServiceTitle, driver);
        searchSteps.selectSearchResult_ServiceItem(ServiceTitle, driver);
        searchSteps.checkSearchResult_Item(ServiceTitle,driver);

        headerSteps.clickLogo();
        loginSteps.PageComplete(driver);
        searchSteps.clickField_searchBy(EventTitle, driver);
        searchSteps.selectSearchResult_EventItem(EventTitle, driver);
        searchSteps.checkSearchResult_Item(EventTitle,driver);

        headerSteps.clickLogo();
        loginSteps.PageComplete(driver);
        searchSteps.clickField_searchBy(ProductTitle_Ar, driver);
        searchSteps.selectSearchResult_ProductItem(ProductTitle_Ar, driver);
        searchSteps.checkSearchResult_Item(ProductTitle_Ar,driver);

        headerSteps.clickLogo();
        loginSteps.PageComplete(driver);
        searchSteps.clickField_searchBy(ServiceTitle_Ar, driver);
        searchSteps.selectSearchResult_ServiceItem(ServiceTitle_Ar, driver);
        searchSteps.checkSearchResult_Item(ServiceTitle_Ar,driver);

        headerSteps.clickLogo();
        loginSteps.PageComplete(driver);
        searchSteps.clickField_searchBy(EventTitle_Ar, driver);
        searchSteps.selectSearchResult_EventItem(EventTitle_Ar, driver);
        searchSteps.checkSearchResult_Item(EventTitle_Ar,driver);
    }
    @Test
    public void searchBy_Item_Description() throws IOException {
        searchSteps.clickField_searchBy(ProductDescription, driver);
        searchSteps.selectSearchResult_ProductItem(ProductDescription, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_ItemDescription(ProductDescription, driver);

       /* headerSteps.clickLogo();
        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);*/
        //loginSteps.PageComplete(driver);
        searchSteps.clickField_searchBy(ServiceDescription, driver);
        searchSteps.selectSearchResult_ServiceItem(ServiceDescription, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_ItemDescription(ServiceDescription, driver);

        /*headerSteps.clickLogo();
        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);*/
        //loginSteps.PageComplete(driver);
        searchSteps.clickField_searchBy(EventDescription, driver);
        searchSteps.selectSearchResult_EventItem(EventDescription, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_ItemDescription(EventDescription, driver);
    }

    @Test
    public void searchBy_Tags() throws IOException {
        searchSteps.clickField_searchBy(ProductTag, driver);
        searchSteps.selectSearchResult_ProductTag(ProductTag, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_ItemTags(ProductTag, driver);

        searchSteps.clickField_searchBy(ServiceTag, driver);
        searchSteps.selectSearchResult_ServiceTag(ServiceTag, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_ItemTags(ServiceTag, driver);

        searchSteps.clickField_searchBy(EventTag, driver);
        searchSteps.selectSearchResult_EventTag(EventTag, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_ItemTags(EventTag, driver);

       /* searchSteps.clickField_searchBy(PartnershipTag, driver);
        searchSteps.selectSearchResult_PartnershipTag(PartnershipTag, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_ItemTags(PartnershipTag, driver);*/
    }
    @Test
    public void searchBy_GroupTitle() throws IOException {
        searchSteps.clickField_searchBy(GroupTitle_En, driver);
        searchSteps.selectSearchResult_Group(GroupTitle_En, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_GroupTitle(GroupTitle_En, driver);

        searchSteps.clickField_searchBy(GroupTitle_Ar, driver);
        searchSteps.selectSearchResult_Group(GroupTitle_Ar, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_GroupTitle(GroupTitle_Ar, driver);
    }

    @Test
    public void searchBy_GroupDescription() throws IOException {
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        loginSteps.pressLoginLink();

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        searchSteps.clickField_searchBy(GroupDescription, driver);
        searchSteps.selectSearchResult_Group(GroupDescription, driver);
        loginSteps.PageComplete(driver);
        searchSteps.checkSearchResult_GroupDescription(driver);
    }

    @Test
    public void searchBy_GroupSkill() throws IOException {
        searchSteps.clickField_searchBy(GroupSkill, driver);
        searchSteps.selectSearchResult_Group(GroupSkill, driver);
        searchSteps.GroupExists(driver);
        //loginSteps.PageComplete(driver);

        searchSteps.clickField_searchBy(GroupInterest, driver);
        searchSteps.selectSearchResult_Group(GroupInterest, driver);
        searchSteps.GroupExists(driver);
    }
}

