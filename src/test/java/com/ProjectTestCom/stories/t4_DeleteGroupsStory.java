package com.ProjectTestCom.stories;

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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

/**
 * Created by olsa on 5/11/2016.
 */
@RunWith(SerenityRunner.class)
public class t4_DeleteGroupsStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String wrongPassword = PropertyLoader.getProperty(propertyFilePath, "wrongPassword");

    private String groupFilePath = "src/test/resources/group.properties";
    private String ErrorPasswordMessage = PropertyLoader.getProperty(groupFilePath, "ErrorPasswordMessage");
    private String maxNameGroupLimited = PropertyLoader.getProperty(groupFilePath, "maxNameGroupLimited");
    private String NameGroupLimitedEn = PropertyLoader.getProperty(groupFilePath, "NameGroupLimitedEn");
    private String NameGroupEn = PropertyLoader.getProperty(groupFilePath, "NameGroupEn");
    private String NameGroupPrivateEn = PropertyLoader.getProperty(groupFilePath, "NameGroupPrivateEn");

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
    public void setup() throws IOException {
        //FirefoxProfile myProfile = new FirefoxProfile(new File("D:/SeleniumProfile"));
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
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void deleteGroupPublic() {
        addGroupSteps.MyGroupWall_forDelete(driver, "public");
        addGroupSteps.clickSettings();
        //addGroupSteps.clickbtnSettingsEdit(driver);
        addGroupSteps.clickBtnDeleteGroup();

        /*addGroupSteps.checkGroupDeleted();
        addGroupSteps.enterPasswordForDelete(wrongPassword);
        addGroupSteps.pressConfirmForDelete();
        addGroupSteps.checkPassword(driver,ErrorPasswordMessage);
        addGroupSteps.enterPasswordForDelete(password);
        addGroupSteps.pressConfirmForDelete();*/
    }
    @Test
    public void deleteGroupLimited() {
        addGroupSteps.MyGroupWall_forDelete(driver, "limited");
        addGroupSteps.clickSettings();
        //addGroupSteps.clickbtnSettingsEdit(driver);
        addGroupSteps.clickBtnDeleteGroup();

    }
    @Test
    public void deleteGroupPrivate() {
        addGroupSteps.MyGroupWall_forDelete(driver, "private");
        addGroupSteps.clickSettings();
        //addGroupSteps.clickbtnSettingsEdit(driver);
        addGroupSteps.clickBtnDeleteGroup();

    }
  /*  @Test
    @Ignore
    public void blockGroup_Settings_Delete_PublicGroup() {
        addGroupSteps.openSettingMenu();
        addGroupSteps.selectDeleteMenu();
        addGroupSteps.clickDeleteButton();
        addGroupSteps.checkGroupDeleted(driver);
    }
    @Test
    @Ignore
    public void blockGroup_Settings_CancelDelete() {
        addGroupSteps.openSettingMenu();
        addGroupSteps.selectDeleteMenu();
        addGroupSteps.selectCancelButton(driver);
    }*/
}
