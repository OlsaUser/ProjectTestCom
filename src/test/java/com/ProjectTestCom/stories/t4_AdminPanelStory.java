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
    private String propertyFilepath_new="src/test/resources/login.properties";
    private String email_a = PropertyLoader.getProperty(propertyFilePath, "email_a");
    private String password_a = PropertyLoader.getProperty(propertyFilePath, "password_a");
    private String RoleNameEN = PropertyLoader.getProperty(propertyFilePath, "RoleNameEN");
    private String DescriptionNameEN = PropertyLoader.getProperty(propertyFilePath, "DescriptionNameEN");
    private String textName= PropertyLoader.getProperty(propertyFilePath, "textName");
    private String textDescription= PropertyLoader.getProperty(propertyFilePath, "textDescription");
    private String email= PropertyLoader.getProperty(propertyFilepath_new, "email");

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
       // AdminPanelSteps.openRoleTab();
        loginSteps.PageComplete(driver);

        AdminPanelSteps.AddName(RoleNameEN);
        AdminPanelSteps.AddDescription(DescriptionNameEN);
        AdminPanelSteps.AddRole();
        AdminPanelSteps.ScrollToAddedRole(driver, element);
        AdminPanelSteps.clickNewRole();
        AdminPanelSteps.CheckAddedRole(driver, RoleNameEN, element);
        //loginSteps.Sleep(1000);
//    }
//
//    @Test
//    public void stage2_EditRole() throws Exception {
        //HeaderSteps.openMenuProfile(driver);
       //AdminPanelSteps.OpenPanel();

//        AdminPanelSteps.openRoleTab();
//        loginSteps.PageComplete(driver);
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
       AdminPanelSteps.CheckAddedRole(driver, textName, element);

       // AdminPanelSteps.DoubleClickAddedRole(driver);

    }



    @Test
    public void stage2_Assign_Remove_Role() throws Exception{
        AdminPanelSteps.OpenUsersTab();
        AdminPanelSteps.SearchUser(email);
        AdminPanelSteps.clickSearch();
        loginSteps.PageComplete(driver);
        AdminPanelSteps.OpenRoleList();
        AdminPanelSteps.ScrollToCheckbox(driver, element);
        AdminPanelSteps.AssignRole();
        AdminPanelSteps.SaveAssign();
        AdminPanelSteps.ConfirmAssign();
//        AdminPanelSteps.clickSearch();
//        loginSteps.PageComplete(driver);
        //    }
//
//        @Test
//        public void stage4_AssignRole() throws Exception {
        AdminPanelSteps.RefreshPageU(driver);
        loginSteps.PageComplete(driver);
        AdminPanelSteps.InputedSelectRole();
        AdminPanelSteps.InputRoleName(textName);
        AdminPanelSteps.RoleSelection();
        AdminPanelSteps.CheckAddedAddedRole();

       // }
//
//    @Test
//    public void stage3_RemoveRole() throws Exception {
        AdminPanelSteps.RefreshPageU(driver);
       // AdminPanelSteps.OpenUsersTab();
        AdminPanelSteps.SearchUser(email);
        AdminPanelSteps.clickSearch();
        loginSteps.PageComplete(driver);
        AdminPanelSteps.OpenRoleList();
        AdminPanelSteps.AssignRole();
        AdminPanelSteps.SaveAssign();
        AdminPanelSteps.ConfirmAssign();
//        AdminPanelSteps.clickSearch();
//        loginSteps.PageComplete(driver);
//    }
//
//     @Test
//    public void stage6_CheckRemove_Role() throws Exception {
        AdminPanelSteps.RefreshPageU(driver);
         AdminPanelSteps.InputedSelectRole();
         AdminPanelSteps.InputRoleName(textName);
         AdminPanelSteps.RoleSelection();
         AdminPanelSteps.CheckRemovedRole_step();

     }
           //  AdminPanelSteps.checkRole(driver,element);
//      AdminPanelSteps.CheckAssignRole();
   //     AdminPanelSteps.fgdfgddg();
              //  loginSteps.PageComplete(driver);

    @Test
    public void stage4_DeleteRole() throws Exception{
        AdminPanelSteps.openRoleTab();
        loginSteps.PageComplete(driver);
        AdminPanelSteps.ScrollToAddedRole(driver, element);
        AdminPanelSteps.clickNewRole();
        AdminPanelSteps.DeleteNewRole();
        AdminPanelSteps.CancelDeleteRole();
        loginSteps.Sleep(500);
        AdminPanelSteps.DeleteNewRole();
        AdminPanelSteps.ClickDeleteButton();
        AdminPanelSteps.DeletedRoleCheck(driver);

 }
}