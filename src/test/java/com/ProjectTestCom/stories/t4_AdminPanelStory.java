package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AdminPanelSteps;
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
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class t4_AdminPanelStory {
    private String propertyFilePath = "src/test/resources/admin.properties";
    private String email_a = PropertyLoader.getProperty(propertyFilePath, "email_a");
    private String password_a = PropertyLoader.getProperty(propertyFilePath, "password_a");
    private String RoleNameEN = PropertyLoader.getProperty(propertyFilePath, "RoleNameEN");
    private String DescriptionNameEN = PropertyLoader.getProperty(propertyFilePath, "DescriptionNameEN");
    private String textName= PropertyLoader.getProperty(propertyFilePath, "textName");
    private String textDescription= PropertyLoader.getProperty(propertyFilePath, "textDescription");

    @Managed
    WebDriver driver;
    WebElement element;

    @ManagedPages
    public Pages pages;

    @Steps
    AdminPanelSteps AdminPanelSteps;
    @Steps
    LoginSteps loginSteps;

    @Steps
    HeaderSteps HeaderSteps;

    @Before
    public void setup() throws IOException {

        String dir = System.getProperty("user.dir");
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.gecko.driver", dir + "\\src\\drivers\\geckodriver.exe");

        //driver = new FirefoxDriver();

        driver.manage().window().maximize();
        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);
        loginSteps.pressLoginLink();
        loginSteps.enterLogin(email_a);
        loginSteps.enterPassword(password_a);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
        AdminPanelSteps.getURL();
        AdminPanelSteps.openRoleTab();
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test

    public void stage1_AddNewRole() throws Exception {

       // HeaderSteps.openMenuProfile(driver);
        // Thread.sleep(100);
      //  AdminPanelSteps.OpenPanel();
        AdminPanelSteps.AddName(RoleNameEN);
        AdminPanelSteps.AddDescription(DescriptionNameEN);
        AdminPanelSteps.AddRole();
        AdminPanelSteps.ScrollToAddedRole(driver, element);
        AdminPanelSteps.clickNewRole();
        AdminPanelSteps.CheckAddedRole(driver, RoleNameEN, element);

    }

    @Test
    public void stage2_EditRole() throws Exception {
        //HeaderSteps.openMenuProfile(driver);
       //AdminPanelSteps.OpenPanel();
        AdminPanelSteps.ScrollToAddedRole(driver, element);
        AdminPanelSteps.clickNewRole();
        AdminPanelSteps.clickPermission();

        AdminPanelSteps.ScrollToAddedRole(driver, element);
        AdminPanelSteps.OpenEditModeAddedRole();
        AdminPanelSteps.InputNewName(textName, driver);
        AdminPanelSteps.InputNewDescription(textDescription, driver);
        AdminPanelSteps.CancelCangesButton();
        AdminPanelSteps.CheckAddedRole(driver, RoleNameEN, element);

        AdminPanelSteps.OpenEditModeAddedRole();
        AdminPanelSteps.InputNewName(textName, driver);
        AdminPanelSteps.InputNewDescription(textDescription, driver);
        AdminPanelSteps.SaveChangesButton();
        AdminPanelSteps.CheckEdited(driver, textName, element);

       // AdminPanelSteps.DoubleClickAddedRole(driver);

    }

    @Test
    public void stage3_DeleteRole() throws Exception{
        AdminPanelSteps.ScrollToAddedRole(driver, element);
        AdminPanelSteps.clickNewRole();
        AdminPanelSteps.DeleteNewRole();
        AdminPanelSteps.CancelDeleteRole();

        AdminPanelSteps.DeleteNewRole();
        AdminPanelSteps.ClickDeleteButton();
        AdminPanelSteps.DeletedRoleCheck(driver);

            }
    }
