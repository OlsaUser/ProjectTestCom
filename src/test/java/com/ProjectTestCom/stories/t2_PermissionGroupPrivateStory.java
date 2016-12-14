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
public class t2_PermissionGroupPrivateStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String email_organization = PropertyLoader.getProperty(propertyFilePath, "email_organization");
    private String password_organization = PropertyLoader.getProperty(propertyFilePath, "password_organization");

    private String propertyGroupPath = "src/test/resources/group.properties";
    private String maxShortDescription = PropertyLoader.getProperty(propertyGroupPath, "maxShortDescription");
    private String NameGroupPrivateMax = PropertyLoader.getProperty(propertyGroupPath, "NameGroupPrivateMax");
    private String dscPrivateGroup = PropertyLoader.getProperty(propertyGroupPath, "dscPrivateGroup");
    private String dscPublicGroup = PropertyLoader.getProperty(propertyGroupPath, "dscPublicGroup");
    private String Skill = PropertyLoader.getProperty(propertyGroupPath, "Skill");
    private String Interest = PropertyLoader.getProperty(propertyGroupPath, "Interest");
    private String RequestedPermissionPrivate = PropertyLoader.getProperty(propertyGroupPath, "RequestedPermissionPrivate");
    private String ConfirmedRequestPrivate = PropertyLoader.getProperty(propertyGroupPath, "ConfirmedRequestPrivate");

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
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", dir + "\\src\\drivers\\geckodriver.exe");

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void stage1_addGroupPrivateMax() {
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        addItemSteps.clickAddButton(driver);
        addGroupSteps.clickAddGroupButton();
        loginSteps.PageComplete(driver);

        addGroupSteps.enterNameGroup(NameGroupPrivateMax, driver);
        addGroupSteps.enterShortDescription(maxShortDescription);
        addGroupSteps.selectTypePrivate(driver, dscPrivateGroup);
        addGroupSteps.enterGroupInterest(Interest, driver);
        addGroupSteps.enterGroupSkill(Skill, driver);
        addGroupSteps.clickCreate(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.checkGroupInListing(href_NameGroupPrivateMax);
    }
    @Test
    public void stage2_checkSubscribeGroupPrivate() {
        loginSteps.openLoginPage();
        loginSteps.enterLogin(email_organization);
        loginSteps.enterPassword(password_organization);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverGroupsNew(driver);
        loginSteps.PageComplete(driver);
        loginSteps.Sleep(600);

        addGroupSteps.openGroupWall(driver, href_NameGroupPrivateMax);
        addGroupSteps.viewerGroupPrivate(driver);
        addGroupSteps.pressRequestJoin(driver);
        driver.navigate().refresh();
        loginSteps.PageComplete(driver);
        addGroupSteps.checkPlaceholder_RequestSent(driver);
    }
    @Test
    public void stage3_checkNotificationOwner() {
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openNotificationPage(driver);
        addGroupSteps.checkRequestedPermission(driver, NameGroupPrivateMax, RequestedPermissionPrivate);
        addGroupSteps.pressAccept(driver);
        headerSteps.openMenuProfile(driver);
        loginSteps.clickLogOut();
    }
    @Test
    public void stage4_checkNotificationUser() {
        loginSteps.openLoginPage();
        loginSteps.enterLogin(email_organization);
        loginSteps.enterPassword(password_organization);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openNotificationPage(driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkConfirmedRequest(driver, NameGroupPrivateMax, ConfirmedRequestPrivate);

        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverGroupsNew(driver);
        loginSteps.PageComplete(driver);
        loginSteps.Sleep(600);

        addGroupSteps.openGroupWall(driver, href_NameGroupPrivateMax);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkMemberPri(driver, NameGroupPrivateMax);

        addPostSteps.AddTextPost(textPostMin, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostMin, driver);
    }
    @Test
    public void stage5_checkUnSubscribe() throws IOException{
        loginSteps.openLoginPage();
        loginSteps.enterLogin(email_organization);
        loginSteps.enterPassword(password_organization);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);
        // loginSteps.Sleep(600);

        addGroupSteps.openGroupWall(driver, href_NameGroupPrivateMax);
        loginSteps.PageComplete(driver);
        addPostSteps.deletePost(driver);

        addGroupSteps.pressUnJoin(driver);
        //loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPage(driver);
        headerSteps.openDiscoverGroupsNew(driver);
        loginSteps.PageComplete(driver);
        //loginSteps.Sleep(600);

        addGroupSteps.openGroupWall(driver, href_NameGroupPrivateMax);
        addGroupSteps.viewerGroupPrivate(driver);
    }
}
