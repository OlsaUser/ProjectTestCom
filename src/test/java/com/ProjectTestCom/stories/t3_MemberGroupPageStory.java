package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AddGroupSteps;
import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
import com.ProjectTestCom.utils.PropertyLoader;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class t3_MemberGroupPageStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String propertyFilePath = "src/test/resources/login.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String urlGroupPage = PropertyLoader.getProperty(propertyFilePath, "urlGroupPage");

    private String propertyGroupPath = "src/test/resources/group.properties";
    private String Group1 = PropertyLoader.getProperty(propertyGroupPath, "Group1");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    AddGroupSteps addGroupSteps;

    @Before
    public void setup() throws IOException {
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver",dir + "\\src\\drivers\\geckodriver.exe");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(1600, TimeUnit.SECONDS);

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        loginSteps.pressLoginLink();

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void memberOwnGroupPage() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group1);
        loginSteps.PageComplete(driver);

        addGroupSteps.checkTextOnOwnGroupMemberPage( );
        addGroupSteps.checkElementsPresent();
    }

    @Test
    public void memberUserGroupPage() throws IOException {
        driver.get(urlGroupPage);
        loginSteps.PageComplete(driver);
        addGroupSteps.checkTextOnUserGroupMemberPage(driver);
        addGroupSteps.checkElementsAbsent();
    }
}