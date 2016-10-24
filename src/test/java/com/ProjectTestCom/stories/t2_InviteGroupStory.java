package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AddAlbumSteps;
import com.ProjectTestCom.steps.AddGroupSteps;
import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
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
public class t2_InviteGroupStory {
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
    private String UserName = PropertyLoader.getProperty(propertyGroupPath, "UserName");
    private String OrgName = PropertyLoader.getProperty(propertyGroupPath, "OrgName");
    private String skill = PropertyLoader.getProperty(propertyGroupPath, "skill");
    private String Interest = PropertyLoader.getProperty(propertyGroupPath, "Interest");

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

    @Before
    public void setup()throws IOException {
        FirefoxProfile myProfile = new FirefoxProfile(new File(BrowserProfile));
        myProfile.setPreference("network.proxy.socks_port",9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);

        loginSteps.openLoginPage();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void stage1_InviteMyFollowers() throws IOException{
        addGroupSteps.MyGroupWallforInvate(driver);
        addGroupSteps.clickbtnSettingsInvite();
        loginSteps.PageComplete(driver);

        addGroupSteps.clickInviteMyFollowers(driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.clickInviteButton(driver);
    }
    @Test
    public void stage2_InviteMyFollowings() {
        addGroupSteps.MyGroupWallforInvate(driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.clickbtnSettingsInvite();
        loginSteps.PageComplete(driver);
        addGroupSteps.clickInviteMyFollowings(driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.clickInviteButton(driver);
    }
    @Test
    public void stage3_InviteAllUsers() {
        addGroupSteps.MyGroupWallforInvate(driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.clickbtnSettingsInvite();
        loginSteps.PageComplete(driver);

        addGroupSteps.clickInviteAllUsers(driver);
        loginSteps.PageComplete(driver);

        addGroupSteps.Invite_NameOrganization(OrgName, driver);
        addGroupSteps.SelectAndInvite(OrgName, driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkInvited(driver);
        loginSteps.PageComplete(driver);



       // loginSteps.PageComplete(driver);
       // loginSteps.Sleep(50);

        addGroupSteps.Invite_Skills(skill, driver);
        addGroupSteps.SelectAndInvite(UserName, driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkInvited(driver);

        addGroupSteps.Invite_Interests(Interest, driver);
        addGroupSteps.SelectAndInvite(Interest, driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkInvited(driver);

        addGroupSteps.Invite_NameUser(UserName, driver);
        addGroupSteps.SelectAndInvite(UserName, driver);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkInvited(driver);
    }
}
