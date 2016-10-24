package com.ProjectTestCom.pages;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.steps.StepEventBus;
import org.joni.exception.ErrorMessages;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

@DefaultUrl("http://synergybeta.devzone.dp.ua/en/#!registration")
//@DefaultUrl("http://mnassa.com/en/#!registration")
@RunWith(SerenityRunner.class)
public class RegisterPage  extends PageObject {
    //for User
    private final By fldUserName = By.xpath("//input[@name='username']");
    private final By fldEmail = By.xpath("//input[@name='reg_email']");
    private final By fldPassword = By.xpath("//input[@name='reg_password']");
    private final By fldFirstName = By.xpath("//input[@name='first_name']");
    private final By fldLastName = By.xpath("//input[@name='last_name']");
    private final By fldGender = By.xpath("//div[@id='s2id_reg-select-2-gender']");
    private final By menuGender = By.xpath("//div[@class='select2-result-label']");
    private final By fldLocation = By.xpath("//div[@id='s2id_reg-cities-google']//input");
    private final By Location = By.xpath("//div[@class='select2-result-label']");
    private final By LocationTag = By.xpath("//ul[@class='tag-list list-unstyled']/li");
    private final By btnNext = By.xpath("//button[@id='do_reg_modal']");
    private final By btnConfirm = By.xpath("//button[@id='do_reg_modal_s2']");
    private final By PopupSuccess = By.xpath("//iframe[@id='submit_frame']");
    private final By btnOK = By.xpath("//button[@can-click='reg_finish']");
    private final By SuccessPopup = By.xpath("//div[@id='step3']//div[@class='step-header text-center']");

    // for Organization
    private final By radiobtnOrganization = By.xpath("//div[@class='modal-body']/div[2]/div[2]//label");
    private final By fldOrganizationFullName = By.xpath("//input[@name='organization_name']");
    private final By menuFounded = By.xpath("//div[@id='s2id_reg-select-2-founded']");
    private final By FoundedYears = By.xpath("//li[@role='presentation']");
    private final By lblError = By.xpath("//div[@class='error_message -full-width']");
    private final By lblErrorAR = By.xpath("//div[@class='error_message_static -full-width']");
    private final By lblErrorPassword = By.xpath("//div[@class='error_message -full-width hidden-xs']");


    public void Step1_selectRadioButton_Organization( ) {
        element(radiobtnOrganization).click();
    }

    public void clearUserName() {find(fldUserName).clear();}

    public void clearPassword() {find(fldPassword).clear();}

    public void clearEmail() {find(fldEmail).clear();}

    public void clearFirstName() {find(fldFirstName).clear();}

    public void clearLastName() {find(fldLastName).clear();}

    public void clearOrganizationFullName() {find(fldOrganizationFullName).clear();}


    public void Step1_UserName(String UserName) {
        find(fldUserName);
        element(fldUserName).sendKeys(UserName);
    }

    public void Step1_Email(String Email) {
        element(fldEmail).sendKeys(Email);
    }

    public void Step1_Password(String Password) {
        element(fldPassword).sendKeys(Password);
    }

    public void Step2_FirstName(String FirstName) {
        //getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        WebDriverWait wt = new WebDriverWait (getDriver(), 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(fldFirstName));
        //find(fldFirstName);
        element(fldFirstName).sendKeys(FirstName);
    }

    public void Step2_OrganizationFullName(String OrganizationFullName) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(fldOrganizationFullName));
        element(fldOrganizationFullName).sendKeys(OrganizationFullName);
    }

    public void Step2_Gender(WebDriver driver, String gender) {
        element(fldGender).click();
        List<WebElement> genderVariant = driver.findElements(menuGender);
        for (WebElement el : genderVariant) {
            if (el.getText().contains(gender)) {
                el.click();
                break;
            }
        }
    }

    public void Step2_LastName(String LastName) {
        element(fldLastName).sendKeys(LastName);
    }

    public void Step2_Founded(String year, WebDriver driver ) {
        element(menuFounded).click();
        List <WebElement> years = driver.findElements(FoundedYears);
        for (WebElement el : years) {
            if (el.getText().contains(year)) {
                System.out.println(el.getText());
                el.click();
                break;
            }
        }
    }

    public void Step2_Location(WebDriver driver, String location) {
        element(fldLocation).click();
        element(fldLocation).sendKeys(location);
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        element(Location).click();
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(LocationTag));
    }

    public void Step1_pressButton_Next( ) {
        element(btnNext).click();
    }

    public void Step2_pressButton_Confirm(WebDriver driver) {
        element(btnConfirm).click();
    }

    public void Step3_Ok(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.elementToBeClickable(btnOK));
        wt.until(ExpectedConditions.textToBePresentInElementLocated(SuccessPopup, "After that you will be redirected to this page - page, where you started registration!"));
        find(btnOK);
        element(btnOK).click();
    }
    public boolean checkValidationMessage(String Message, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(lblError));

        List <WebElement> messages = driver.findElements (lblError);
        for (WebElement el : messages) {
            if (el.getText().contains(Message)) {
                return true;
            }
        }
        return false;
    }

    public void checkValidationMessage_if_UserNameAR(String Message, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(lblErrorAR,Message));
    }

    public void checkValidationMessage_Password(String Message, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(lblErrorPassword,Message));
    }
}
