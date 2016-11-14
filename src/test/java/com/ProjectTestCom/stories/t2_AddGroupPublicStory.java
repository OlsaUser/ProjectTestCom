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
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.Statement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by olsa on 4/28/2016.
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t2_AddGroupPublicStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyGroupPath = "src/test/resources/group.properties";
    private String NameGroupEn = PropertyLoader.getProperty(propertyGroupPath, "NameGroupEn");
    private String ShortDescriptionEn = PropertyLoader.getProperty(propertyGroupPath, "ShortDescriptionEn");
    private String NameGroupAr = PropertyLoader.getProperty(propertyGroupPath, "NameGroupAr");
    private String ShortDescriptionAr = PropertyLoader.getProperty(propertyGroupPath, "ShortDescriptionAr");
    private String wrongNameGroup = PropertyLoader.getProperty(propertyGroupPath, "wrongNameGroup");
    private String maxShortDescription = PropertyLoader.getProperty(propertyGroupPath, "maxShortDescription");
    private String maxNameGroup = PropertyLoader.getProperty(propertyGroupPath, "maxNameGroup");
    private String ShortDescriptionNull = PropertyLoader.getProperty(propertyGroupPath, "ShortDescriptionNull");
    private String AddGroup = PropertyLoader.getProperty(propertyGroupPath, "AddGroup");
    private String lblNameGroupError = PropertyLoader.getProperty(propertyGroupPath, "lblNameGroupError");
    private String Skill = PropertyLoader.getProperty(propertyGroupPath, "Skill");
    private String Interest = PropertyLoader.getProperty(propertyGroupPath, "Interest");
    private String Skill_new = PropertyLoader.getProperty(propertyGroupPath, "Skill_new");
    private String Interest_new = PropertyLoader.getProperty(propertyGroupPath, "Interest_new");
    private String dscLimitedGroup = PropertyLoader.getProperty(propertyGroupPath, "dscLimitedGroup");
    private String Group1 = PropertyLoader.getProperty(propertyGroupPath, "Group1");
    private String Group3 = PropertyLoader.getProperty(propertyGroupPath, "Group3");

    private String href_NameGroupEn = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupEn");
    private String href_maxNameGroup = PropertyLoader.getProperty(propertyGroupPath, "href_maxNameGroup");
    private String href_NameGroupAr = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupAr");
    private String href_NameGroupLimitedEn = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupLimitedEn");
    private String href_NameGroupLimitedAr = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupLimitedAr");
    private String href_NameGroupLimitedMax = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupLimitedMax");
    private String href_NameGroupPrivateEn = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupPrivateEn");
    private String href_NameGroupPrivateAr = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupPrivateAr");
    private String href_NameGroupPrivateMax = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupPrivateMax");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    AddGroupSteps addGroupSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    AddItemSteps addItemSteps;

    @Before
    public void setup()throws IOException{
       /* FirefoxProfile myProfile = new FirefoxProfile(new File(BrowserProfile));
        myProfile.setPreference("network.proxy.socks_port",9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);*/

        driver.manage().window().maximize();

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}
    /*************************************************************/
 /*   @Test
    public void addGroupEn() {
        addGroupSteps.clickAddButton();
        addGroupSteps.enterNameGroup(NameGroupEn);
        addGroupSteps.enterShortDescription(ShortDescriptionEn);
        addGroupSteps.clickCreate(driver);
       // loginSteps.Sleep(8000);
        addGroupSteps.openMyGroupsPage();
        addGroupSteps.checkGroupInListing(NameGroupEn);
    }*/

    @Test
    public void stage1_addGroupPublicAr(){
        addItemSteps.clickAddButton(driver);
        addGroupSteps.clickAddGroupButton();
        loginSteps.PageComplete(driver);

        addGroupSteps.enterNameGroup(NameGroupAr, driver);
        addGroupSteps.enterShortDescription(ShortDescriptionAr);
        addGroupSteps.enterGroupInterest(Interest, driver);
        addGroupSteps.enterGroupSkill(Skill, driver);
        addGroupSteps.clickCreate(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkGroupInListing(href_NameGroupAr);
    }

    @Test
    public void stage2_addGroupPublicMax(){
        addItemSteps.clickAddButton(driver);
        addGroupSteps.clickAddGroupButton();
        loginSteps.PageComplete(driver);

        addGroupSteps.enterNameGroup(maxNameGroup,driver);
        addGroupSteps.enterShortDescription(maxShortDescription);
        addGroupSteps.enterGroupInterest(Interest, driver);
        addGroupSteps.enterGroupSkill(Skill, driver);
        addGroupSteps.clickCreate(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.checkGroupInListing(href_maxNameGroup);
    }
    @Test
    public void stage3_addGroupPublicName() {
        addItemSteps.clickAddButton(driver);
        addGroupSteps.clickAddGroupButton();
        loginSteps.PageComplete(driver);

        addGroupSteps.enterNameGroup(NameGroupEn, driver);
        addGroupSteps.enterShortDescription(ShortDescriptionNull);
        addGroupSteps.clickCreate(driver);

        loginSteps.PageComplete(driver);
        headerSteps.openMyMnassaPage(driver);
        //loginSteps.PageComplete(driver);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.checkGroupInListing(href_NameGroupEn);
    }

    @Test
    public void stage4_wrongNameGroupPublic() {
        addItemSteps.clickAddButton(driver);
        addGroupSteps.clickAddGroupButton();
        loginSteps.PageComplete(driver);

        addGroupSteps.enterNameGroup(wrongNameGroup,driver);
        addGroupSteps.clickCreateError();
        addGroupSteps.checkNameGroupErrorPresent(driver, lblNameGroupError);
    }
    @Test
    public void stage5_editGroupPublic() {
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.openGroupWall(driver, Group3);
        addGroupSteps.clickbtnSettingsEdit(driver);
        addGroupSteps.enterNameGroup(NameGroupEn,driver);
        addGroupSteps.enterShortDescription(ShortDescriptionEn);
        addGroupSteps.enterGroupInterest(Interest_new, driver);
        addGroupSteps.enterGroupSkill(Skill_new, driver);
        addGroupSteps.clickCreate(driver);
    }
    @Test
    public void stage6_editDel_Skill_Interest() {
        headerSteps.openMyMnassaPage(driver);
        //loginSteps.PageComplete(driver);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.openGroupWall(driver, Group3);
        //addGroupSteps.clickSettings();
        addGroupSteps.clickbtnSettingsEdit(driver);
        addGroupSteps.deleteGroupInterest(driver);
        addGroupSteps.deleteGroupSkill(driver);
        addGroupSteps.clickCreate(driver);
    }
    @Test
    public void stage7_editPublicToLimited() {
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.openGroupWall(driver, Group3);
        //addGroupSteps.clickSettings();
        addGroupSteps.clickbtnSettingsEdit(driver);
        addGroupSteps.selectTypeLimited(driver, dscLimitedGroup);
        addGroupSteps.clickCreate(driver);
    }
  /*  @Test
    public void blockGroup_Settings_Edit_Public() {
        addGroupSteps.openSettingMenu();
        addGroupSteps.selectEditMenu();
        addGroupSteps.enterNameGroup(AddGroup);
        addGroupSteps.enterShortDescription(ShortDescriptionEn);
        addGroupSteps.clickCreate(driver);
    }*/
}