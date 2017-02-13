package com.ProjectTestCom.pages;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@DefaultUrl("http://synergy.devzone.dp.ua/en/#!registration")
//@DefaultUrl("http://mnassa.com/en/#!registration")
@RunWith(SerenityRunner.class)


public class AdminPanelPage  extends PageObject {
    private final By AdminPanel = By.xpath("//div[@class='header-user']/div[2]/a[3]");
    //Main tabs
    private final By UsersTab = By.xpath("//div[@class='text-right']/a[1]");
    private final By RolesTAb = By.xpath("//div[@class='text-right']/a[2]");
    //Role elements
    private final By RolesCont = By.xpath("//div/table/tbody");
    private final By NameField = By.xpath("//input[@type='text']");
    private final By DescriptionField = By.xpath("//div[@class='form-control']");
    private final By AddRoleButton = By.xpath("//button[@class='btn btn-green-primary pull-right']");
    private final By RoleTable = By.xpath("//div/table/tbody/tr[contains(., 'Autotest')]");
    private final By EditButton = By.xpath("//div/table/tbody/tr[contains(., 'Autotest')]/td[5]/a[@class='btn btn-default']/span[@class='glyphicon glyphicon-pencil']");
    private final By DeleteRole = By.xpath("//div/table/tbody/tr[contains(., 'Autotest')]/td[5]/a[@class='btn btn-default delete-user']");
    private final By RoleRadioButtonView = By.xpath("//tr[1]/td[3]/input[@value='R']");
    private final By RoleRadioButtonEdit = By.xpath("//tr[2]/td[4]/input[@value='W']");
    private final By SaveChangesButton = By.xpath("//tr[@can-click='set_item_line']/td[5]/button[@class='btn btn-success']");
    private final By EditFieldName = By.xpath("//tr[@can-click='set_item_line']/td[1]/input[@type='text']");
    private final By EditFieldDescription = By.xpath("//td[2]/div[@class='break-word']/input[@type='text']");
    private final By CancelEdit = By.xpath("//tr[@can-click='set_item_line']/td[5]/button[@class='btn btn-default']");
    private final By CancelDeleteButton = By.cssSelector("div.modal-footer > button.btn");
    private final By DeleteButton = By.id("do_delete");
    //Users elements
    private final By SearchField= By.xpath("//input[@class='form-control']");
    private final By SearchButton=By.xpath("//span[@class='glyphicon glyphicon-search']");
    private final By EditRoleLink=By.cssSelector(".middle>td>a");
    private final By ContRolesLink=By.id("modalEditUserRole");
    private final By UsersCont=By.xpath("//table/tbody[2]/tr");
    private final By checkboxRole=By.xpath("//div[@class='checkbox']/label/span[contains(., 'Autotest')]");
    private final By SaveButton=By.xpath("(//button[@type='button'])[15]");
    private final By CancelButton=By.xpath("(//button[@type='button'])[14]");
    private final By ButtonOK=By.xpath("//div[@class='modal-footer']/button[contains(., 'OK')]");
    private final By dropdownRole=By.xpath("//*[@id='s2id_roles-list']/a");
    private final By MyRole=By.xpath("//li[@role='presentation']/div[contains(., 'Autotest')]");
    private final By SearchRole=By.cssSelector("#s2id_autogen1_search");
    private final By UsersTable=By.xpath("//*[@id='adm_users_sect']/adm_users/div[1]/div[2]/div[3]/div/table/tbody[2]/tr/td[3]");
    private final By EmptyUserstable=By.cssSelector(".text-center");

    //Methods
    public void RolesOpen() {
        element(RolesTAb).click();
        WebDriverWait wt = new WebDriverWait(getDriver(),300);
        wt.until(ExpectedConditions.presenceOfElementLocated(RolesCont));
        wt.until(ExpectedConditions.visibilityOfElementLocated(RolesCont));
    }

    public void AdmPanelOpen() {
        WebDriverWait wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.elementToBeClickable(AdminPanel));
        element(AdminPanel).click();
        wt = new WebDriverWait(getDriver(), 1000);
        wt.until(ExpectedConditions.visibilityOfElementLocated(UsersTab));
    }

    public void UsersOpen(){
        element(UsersTab).click();
        WebDriverWait wt = new WebDriverWait(getDriver(),2500);
        wt.until(ExpectedConditions.presenceOfElementLocated(UsersCont));
        wt.until(ExpectedConditions.visibilityOfElementLocated(UsersCont));
    }

    public void InputName(String roleName) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 2500);
        wt.until(ExpectedConditions.elementToBeClickable(NameField));
        wt.until(ExpectedConditions.presenceOfElementLocated(NameField));
        wt.until(ExpectedConditions.visibilityOfElementLocated(NameField));
        element(NameField).clear();
        element(NameField).sendKeys(roleName);
        wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.elementToBeClickable(DescriptionField));
    }

    public void InputDescription(String descriptionName) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.elementToBeClickable(DescriptionField));
        element(DescriptionField).clear();
        element(DescriptionField).sendKeys(descriptionName);
        wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.elementToBeClickable(AddRoleButton));
    }

    public void AddRole() {
        WebDriverWait wt = new WebDriverWait(getDriver(), 200);
        wt.until(ExpectedConditions.elementToBeClickable(AddRoleButton));
        element(AddRoleButton).click();
    }

    public void clickRole() {
        getDriver().findElement(RoleTable).click();
    }

    public void ScrollToRole(WebDriver driver, WebElement element) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.elementToBeClickable(AddRoleButton));
        element = driver.findElement(RoleTable);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void ClickRadioButton() {
        WebDriverWait wt = new WebDriverWait(getDriver(), 700);
        wt.until(ExpectedConditions.elementToBeClickable(RoleRadioButtonView));
        getDriver().findElement(RoleRadioButtonView).click();
        getDriver().findElement(RoleRadioButtonEdit).click();
    }

    public void DoubleClickRole(WebDriver driver) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(RoleTable);
        action.doubleClick(element).perform();
    }

    public void OpenEditMode() {
        getDriver().findElement(EditButton).click();
    }

    public void CancelEditMode() {
        getDriver().findElement(CancelEdit).click();
    }

    public void ChangeName(String text, WebDriver driver) {
        WebElement element = driver.findElement(EditFieldName);
        element.clear();
        element.sendKeys(text);
    }

    public void ChangeDescription(String text, WebDriver driver) {
        WebElement element = driver.findElement(EditFieldDescription);
        element.clear();
        element.sendKeys(text);
    }

    public void SaveChanges() {
        getDriver().findElement(SaveChangesButton).click();
    }

    public void CancelChanges() {
        getDriver().findElement(CancelEdit).click();
    }

    public void needURL() {
        getDriver().get("http://synergy.devzone.dp.ua/en/admin/roles");
        WebDriverWait wt = new WebDriverWait(getDriver(), 300);
        wt.until(ExpectedConditions.elementToBeClickable(UsersTab));
    }

    public boolean CheckRole(WebDriver driver, String NewRole, WebElement element) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 50);
        wt.until(ExpectedConditions.elementToBeClickable(EditButton));
        boolean r = false;
        element = (WebElement) driver.findElement(RoleTable);
        {
            if (element.getText().contains(NewRole)) {
                System.out.println(element.getText());
                r = true;
                return r;
            } else System.out.println("Role was not found" + element.getText());
            r = false;
            return r;
        }
    }

        public void DeleteRole() {
            WebDriverWait wt = new WebDriverWait(getDriver(), 2500);
            wt.until(ExpectedConditions.elementToBeClickable(DeleteRole));
            wt.until(ExpectedConditions.presenceOfElementLocated(DeleteRole));
            wt.until(ExpectedConditions.visibilityOfElementLocated(DeleteRole));
        getDriver().findElement(DeleteRole).click();
    }

    public void CancelDelete() {
        WebDriverWait wt = new WebDriverWait(getDriver(), 700);
        wt.until(ExpectedConditions.elementToBeClickable(CancelDeleteButton));
        getDriver().findElement(CancelDeleteButton).click();
    }

    public void DeleteButtonClick() {
        WebDriverWait wt = new WebDriverWait(getDriver(), 1000);
        wt.until(ExpectedConditions.elementToBeClickable(DeleteButton));
        getDriver().findElement(DeleteButton).click();
    }

    public void CheckDeletedrole(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 1000);
        wt.until(ExpectedConditions.elementToBeClickable(AddRoleButton));
        String Role = find(RolesCont).getText();
        Assert.assertFalse("role is presented", Role.contains("Autotest"));
    }

    public void InputUsername(String Username){
        WebDriverWait wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.presenceOfElementLocated(RolesCont));
        wt.until(ExpectedConditions.visibilityOfElementLocated(RolesCont));
        WebElement element = getDriver().findElement(SearchField);
        element.clear();
        element.sendKeys(Username);
    }

    public void clickSearchButton(){
        WebDriverWait wt = new WebDriverWait(getDriver(), 2500);
        wt.until(ExpectedConditions.presenceOfElementLocated(RolesCont));
        wt.until(ExpectedConditions.visibilityOfElementLocated(RolesCont));
        getDriver().findElement(SearchButton).click();
        wt = new WebDriverWait(getDriver(), 700);
        wt.until(ExpectedConditions.presenceOfElementLocated(RolesCont));
        wt.until(ExpectedConditions.visibilityOfElementLocated(RolesCont));
    }

    public void clickRolesList(){
        WebDriverWait wt = new WebDriverWait(getDriver(), 2500);
        wt.until(ExpectedConditions.presenceOfElementLocated(UsersCont));
        wt.until(ExpectedConditions.visibilityOfElementLocated(UsersCont));
        wt.until(ExpectedConditions.elementToBeClickable(UsersCont));
        getDriver().findElement(EditRoleLink).click();
        wt = new WebDriverWait(getDriver(), 900);
        wt.until(ExpectedConditions.visibilityOfElementLocated(ContRolesLink));
            }

    public void clickCheckBox(){
        getDriver().findElement(checkboxRole).click();
        WebDriverWait wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.elementToBeClickable(SaveButton));}

    public void clickSaveButton(){
        WebDriverWait wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.elementToBeClickable(SaveButton));
        getDriver().findElement(SaveButton).click();
        wt = new WebDriverWait(getDriver(), 1000);
        wt.until(ExpectedConditions.elementToBeClickable(ButtonOK));}

    public void clickCancelButton(){
        WebDriverWait wt = new WebDriverWait(getDriver(), 2500);
        wt.until(ExpectedConditions.elementToBeClickable(CancelButton));
        getDriver().findElement(CancelButton).click();
        wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.elementToBeClickable(UsersCont));
        wt.until(ExpectedConditions.presenceOfElementLocated(UsersCont));
        wt.until(ExpectedConditions.visibilityOfElementLocated(UsersCont));}

    public void clickButtonOK(){
        WebDriverWait wt = new WebDriverWait(getDriver(), 500);
        wt.until(ExpectedConditions.elementToBeClickable(ButtonOK));
        getDriver().findElement(ButtonOK).click();
        wt = new WebDriverWait(getDriver(), 500);
        wt.until(ExpectedConditions.elementToBeClickable(UsersCont));
        wt.until(ExpectedConditions.presenceOfElementLocated(UsersCont));
        wt.until(ExpectedConditions.visibilityOfElementLocated(UsersCont));;}

    public void scrolltoRoleelement(WebDriver driver, WebElement element) {
        WebDriverWait wt = new WebDriverWait(getDriver(),1500);
        wt.until(ExpectedConditions.elementToBeClickable(checkboxRole));
        element = driver.findElement(checkboxRole);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        wt = new WebDriverWait(getDriver(), 700);
        wt.until(ExpectedConditions.elementToBeClickable(checkboxRole));}

    public void checkSelectedCheckbox(){
        boolean hasError = false;
        for (WebElement element: getDriver().findElements(checkboxRole)) {
            if (element.isSelected()) {
                System.out.println("checkbox was selected");
                hasError = true;
                break;
            }
        }
        Assert.assertTrue(hasError);}

    public boolean SelectedCheck(WebDriver driver, WebElement element) {
           WebDriverWait wt = new WebDriverWait(getDriver(), 50);
        wt.until(ExpectedConditions.elementToBeClickable(checkboxRole));
        boolean r = false;
        element = (WebElement) driver.findElement(checkboxRole);
        {
            if (element.isSelected()) {
                System.out.println("checkbox was selected");
                r = true;
                return r;
            } else System.out.println("checkbox was not selected");
            r = false;
            return r;
        }}

public void InputSelectRole(){
    WebDriverWait wt = new WebDriverWait(getDriver(), 4000);
    wt.until(ExpectedConditions.presenceOfElementLocated(UsersTab));
   getDriver().findElement(dropdownRole).click();}

public void SendRoleName(String text){
    WebDriverWait wt = new WebDriverWait(getDriver(), 3000);
   wt.until(ExpectedConditions.visibilityOfElementLocated(SearchRole));
    wt.until(ExpectedConditions.elementToBeClickable(SearchRole));
    wt.until(ExpectedConditions.presenceOfElementLocated(SearchRole));
    getDriver().findElement(SearchRole).clear();
    getDriver().findElement(SearchRole).sendKeys(text);
  }
public void SelectionFromDropdown(){
        WebDriverWait wt = new WebDriverWait(getDriver(), 1500);
        wt.until(ExpectedConditions.elementToBeClickable(MyRole));
        wt.until(ExpectedConditions.presenceOfElementLocated(MyRole));
        wt.until(ExpectedConditions.visibilityOfElementLocated(MyRole));
        getDriver().findElement(MyRole).click();
      }

public void CheckAddedRole(){
    WebDriverWait wt = new WebDriverWait(getDriver(), 3000);
    wt.until(ExpectedConditions.elementToBeClickable(UsersTable));
    wt.until(ExpectedConditions.visibilityOfElementLocated(UsersTable));
    wt.until(ExpectedConditions.presenceOfElementLocated(UsersTable));
    String NeedUser = find(UsersTable).getText();
    wt = new WebDriverWait(getDriver(),1500);
    wt.until(ExpectedConditions.elementToBeClickable(UsersTable));
    wt.until(ExpectedConditions.visibilityOfElementLocated(UsersTable));
    wt.until(ExpectedConditions.presenceOfElementLocated(UsersTable));
    System.out.println(NeedUser);
   Assert.assertTrue("role is not presented", NeedUser.contains("ziva"));

}

public void CheckRemovedRole(){
    WebDriverWait wt = new WebDriverWait(getDriver(), 2000);
    wt.until(ExpectedConditions.elementToBeClickable(EmptyUserstable));
    wt.until(ExpectedConditions.visibilityOfElementLocated(EmptyUserstable));
    wt.until(ExpectedConditions.presenceOfElementLocated(EmptyUserstable));

    String NeedUser = find(EmptyUserstable).getText();
    System.out.println(NeedUser);
    Assert.assertTrue("role is presented", NeedUser.contains("Nothing was found"));

}
public void RefreshUsers(WebDriver driver){driver.navigate().refresh();}

}

