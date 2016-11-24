package com.ProjectTestCom.stories;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t1_PermissionGroupLimitedStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String email_organization = PropertyLoader.getProperty(propertyFilePath, "email_organization");
    private String password_organization = PropertyLoader.getProperty(propertyFilePath, "password_organization");

    private String propertyGroupPath = "src/test/resources/group.properties";
    private String maxShortDescription = PropertyLoader.getProperty(propertyGroupPath, "maxShortDescription");
    private String NameGroupLimitedMax = PropertyLoader.getProperty(propertyGroupPath, "NameGroupLimitedMax");
    private String dscLimitedGroup = PropertyLoader.getProperty(propertyGroupPath, "dscLimitedGroup");
    private String dscPublicGroup = PropertyLoader.getProperty(propertyGroupPath, "dscPublicGroup");
    private String Skill = PropertyLoader.getProperty(propertyGroupPath, "Skill");
    private String Interest = PropertyLoader.getProperty(propertyGroupPath, "Interest");
    private String RequestedPermissionLimited = PropertyLoader.getProperty(propertyGroupPath, "RequestedPermissionLimited");
    private String ConfirmedRequestLimited = PropertyLoader.getProperty(propertyGroupPath, "ConfirmedRequestLimited");

    private String href_NameGroupEn = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupEn");
    private String href_maxNameGroup = PropertyLoader.getProperty(propertyGroupPath, "href_maxNameGroup");
    private String href_NameGroupAr = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupAr");
    private String href_NameGroupLimitedEn = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupLimitedEn");
    private String href_NameGroupLimitedAr = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupLimitedAr");
    private String href_NameGroupLimitedMax = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupLimitedMax");
    private String href_NameGroupPrivateEn = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupPrivateEn");
    private String href_NameGroupPrivateAr = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupPrivateAr");
    private String href_NameGroupPrivateMax = PropertyLoader.getProperty(propertyGroupPath, "href_NameGroupPrivateMax");

    private String propertyPostPath = "src/test/resources/post.properties";
    private String textPostMin = PropertyLoader.getProperty(propertyPostPath, "textPostMin");

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

    @Steps
    AddPostSteps addPostSteps;

    @Before
    public void setup()throws IOException {
        driver.manage().window().maximize();

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void stage1_addGroupLimitedMax() {
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.clickAddButton(driver);
        addGroupSteps.clickAddGroupButton();
        loginSteps.PageComplete(driver);

        addGroupSteps.enterNameGroup(NameGroupLimitedMax, driver);
        addGroupSteps.enterShortDescription(maxShortDescription);
        addGroupSteps.selectTypeLimited(driver, dscLimitedGroup);
        addGroupSteps.enterGroupInterest(Interest, driver);
        addGroupSteps.enterGroupSkill(Skill, driver);
        addGroupSteps.clickCreate(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.checkGroupInListing(href_NameGroupLimitedMax);
    }
    @Test
    public void stage2_checkSubscribeGroupLimited() throws IOException{
        loginSteps.enterLogin(email_organization);
        loginSteps.enterPassword(password_organization);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverGroupsNew(driver);
        loginSteps.PageComplete(driver);
        loginSteps.Sleep(600);

        addGroupSteps.openGroupWall(driver, href_NameGroupLimitedMax);
        addGroupSteps.viewerGroupLimited(driver);
        addGroupSteps.pressSubscribe(driver);
        driver.navigate().refresh();
        loginSteps.PageComplete(driver);
        addGroupSteps.checkPlaceholder_Subscribed(driver);
    }
    @Test
    public void stage3_checkNotificationOwner() {

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openNotificationPage(driver);
        addGroupSteps.checkRequestedPermission(driver, NameGroupLimitedMax, RequestedPermissionLimited);
        addGroupSteps.pressAccept(driver);
        headerSteps.openMenuProfile(driver);
        loginSteps.clickLogOut();
    }
    @Test
    public void stage4_checkNotificationUser() {
        loginSteps.enterLogin(email_organization);
        loginSteps.enterPassword(password_organization);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openNotificationPage(driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkConfirmedRequest(driver, NameGroupLimitedMax, ConfirmedRequestLimited);

        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverGroupsNew(driver);
        loginSteps.PageComplete(driver);
        loginSteps.Sleep(200);

        addGroupSteps.openGroupWall(driver, href_NameGroupLimitedMax);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkMemberLim(driver, NameGroupLimitedMax);

        addPostSteps.AddTextPost(textPostMin, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostMin, driver);
    }
    @Test
    public void stage5_checkUnSubscribe() throws IOException{
        loginSteps.enterLogin(email_organization);
        loginSteps.enterPassword(password_organization);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);
       // loginSteps.Sleep(600);

        addGroupSteps.openGroupWall(driver, href_NameGroupLimitedMax);
        loginSteps.PageComplete(driver);
        addPostSteps.deletePost(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.pressUnSubscribe(driver);
        //loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverGroupsNew(driver);
        loginSteps.PageComplete(driver);
        loginSteps.Sleep(600);

        addGroupSteps.openGroupWall(driver, href_NameGroupLimitedMax);
        addGroupSteps.viewerGroupLimited(driver);
    }
}