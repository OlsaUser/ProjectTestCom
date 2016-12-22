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
    private final By RolesCont = By.xpath("//div/table/tbody");
    //Roles element
    private final By NameField = By.xpath("//input[@type='text']");
    private final By DescriptionField = By.xpath("//div[@class='form-control']");
    private final By AddRoleButton = By.xpath("//button[@class='btn btn-green-primary pull-right']");
    private final By RoleTable = By.xpath("//div/table/tbody/tr[contains(., 'Autotest')]");
    //private final By RoleTable=By.cssSelector("div.break-word");
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

    //Methods
    public void RolesOpen() {
        element(RolesTAb).click();
        WebDriverWait wt = new WebDriverWait(getDriver(), 700);
        wt.until(ExpectedConditions.presenceOfElementLocated(RolesCont));
        wt.until(ExpectedConditions.visibilityOfElementLocated(RolesCont));
    }

    public void AdmPanelOpen() {
        WebDriverWait wt = new WebDriverWait(getDriver(), 500);
        wt.until(ExpectedConditions.elementToBeClickable(AdminPanel));
        element(AdminPanel).click();
        wt = new WebDriverWait(getDriver(), 300);
        wt.until(ExpectedConditions.visibilityOfElementLocated(UsersTab));
    }

    public void InputName(String roleName) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 700);
        wt.until(ExpectedConditions.elementToBeClickable(NameField));
        wt.until(ExpectedConditions.presenceOfElementLocated(NameField));
        wt.until(ExpectedConditions.visibilityOfElementLocated(NameField));
        element(NameField).clear();
        element(NameField).sendKeys(roleName);
        wt = new WebDriverWait(getDriver(), 200);
        wt.until(ExpectedConditions.elementToBeClickable(AddRoleButton));
    }

    public void InputDescription(String descriptionName) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 700);
        wt.until(ExpectedConditions.elementToBeClickable(DescriptionField));
        element(DescriptionField).clear();
        element(DescriptionField).sendKeys(descriptionName);
        wt = new WebDriverWait(getDriver(), 200);
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
        WebDriverWait wt = new WebDriverWait(getDriver(), 300);
        wt.until(ExpectedConditions.elementToBeClickable(AddRoleButton));
        element = driver.findElement(RoleTable);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void ClickRadioButton() {
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
        getDriver().get("http://synergy.devzone.dp.ua/en/admin/users");
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

    public boolean CheckEditedRole(WebDriver driver, String EditedRole, WebElement element) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 50);
        wt.until(ExpectedConditions.elementToBeClickable(EditButton));
        boolean r = false;
        element = (WebElement) driver.findElement(RoleTable);
        {
            if (element.getText().contains(EditedRole)) {
                System.out.println(element.getText());
                r = true;
                return r;
            } else System.out.println("Role was not found" + element.getText());
            r = false;
            return r;
        }
    }

    public void DeleteRole() {
        getDriver().findElement(DeleteRole).click();
    }

    public void CancelDelete() {
        WebDriverWait wt = new WebDriverWait(getDriver(), 300);
        wt.until(ExpectedConditions.elementToBeClickable(CancelDeleteButton));
        getDriver().findElement(CancelDeleteButton).click();
    }

    public void DeleteButtonClick() {
        WebDriverWait wt = new WebDriverWait(getDriver(), 500);
        wt.until(ExpectedConditions.elementToBeClickable(DeleteButton));
        getDriver().findElement(DeleteButton).click();
    }

    public void CheckDeletedrole(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 500);
        wt.until(ExpectedConditions.elementToBeClickable(AddRoleButton));

       String Role = find(RolesCont).getText();
        Assert.assertFalse("role is presented", Role.contains("Autotest"));
    }
}

