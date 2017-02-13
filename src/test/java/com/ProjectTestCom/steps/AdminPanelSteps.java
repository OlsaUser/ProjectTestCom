package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.AdminPanelPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;


public class AdminPanelSteps extends ScenarioSteps {

    AdminPanelPage AdminPanelPage;

    @Step
    public void  openAdminPanelPage(){AdminPanelPage.open();}

    @Step
    public void openRoleTab(){AdminPanelPage.RolesOpen( );}

    @Step
    public void OpenPanel(){AdminPanelPage.AdmPanelOpen();}

    @Step
    public void AddName(String roleName){AdminPanelPage.InputName(roleName);}

    @Step
    public void AddDescription(String descriptionName){AdminPanelPage.InputDescription(descriptionName);}

    @Step
    public void AddRole(){AdminPanelPage.AddRole();}

    @Step
    public void CheckAddedRole(WebDriver driver, String NewRole,WebElement element){ assertTrue(AdminPanelPage.CheckRole(driver, NewRole, element));}

    @Step
    public void ScrollToAddedRole(WebDriver driver, WebElement element){AdminPanelPage.ScrollToRole(driver, element);}

    @Step
    public void clickNewRole(){AdminPanelPage.clickRole();}

    @Step
    public void clickPermission(){AdminPanelPage.ClickRadioButton();}

    @Step
    public void SaveChangesButton(){AdminPanelPage.SaveChanges();}

    @Step
    public void CancelCangesButton(){AdminPanelPage.CancelChanges();}

        @Step
    public void InputNewName(String text, WebDriver driver){AdminPanelPage.ChangeName(text, driver);}

    @Step
    public void InputNewDescription(String text, WebDriver driver){AdminPanelPage.ChangeDescription(text, driver);}

    @Step
    public void OpenEditModeAddedRole(){AdminPanelPage.OpenEditMode();}

    @Step
    public void DeleteNewRole(){AdminPanelPage.DeleteRole();}

    @Step
    public void CancelDeleteRole(){AdminPanelPage.CancelDelete();}

    @Step
    public void ClickDeleteButton(){AdminPanelPage.DeleteButtonClick();}

    @Step
    public void DeletedRoleCheck(WebDriver driver){AdminPanelPage.CheckDeletedrole(driver);}

    @Step
    public void DoubleClickAddedRole(WebDriver driver){AdminPanelPage.DoubleClickRole(driver);}

    @Step
    public void getURL(){AdminPanelPage.needURL();}

    @Step
    public void OpenUsersTab(){AdminPanelPage.UsersOpen();}

    @Step
    public void SearchUser(String Username){AdminPanelPage.InputUsername(Username);}

    @Step
    public void clickSearch(){AdminPanelPage.clickSearchButton();
    }

    @Step
    public void OpenRoleList(){AdminPanelPage.clickRolesList();}

    @Step
    public void AssignRole(){AdminPanelPage.clickCheckBox();}

    @Step
    public void CancelAssign(){AdminPanelPage.clickCancelButton();}

    @Step
    public void SaveAssign(){AdminPanelPage.clickSaveButton();}

    @Step
    public void ConfirmAssign(){AdminPanelPage.clickButtonOK();}

    @Step
    public void CheckAssignRole(){AdminPanelPage.checkSelectedCheckbox();}

    @Step
    public void ScrollToCheckbox(WebDriver driver, WebElement element){AdminPanelPage.scrolltoRoleelement(driver, element);}

    @Step
    public void checkRole(WebDriver driver, WebElement element){ assertTrue(AdminPanelPage.SelectedCheck(driver, element));}

    @Step
    public void InputedSelectRole(){AdminPanelPage.InputSelectRole();}

    @Step
    public void RoleSelection(){AdminPanelPage.SelectionFromDropdown();}

    @Step
    public void CheckAddedAddedRole(){AdminPanelPage.CheckAddedRole();}

    @Step
    public void InputRoleName(String text){AdminPanelPage.SendRoleName(text);}

    @Step
    public void CheckRemovedRole_step(){AdminPanelPage.CheckRemovedRole();}

    @Step
    public void RefreshPageU(WebDriver driver){AdminPanelPage.RefreshUsers(driver);}
}