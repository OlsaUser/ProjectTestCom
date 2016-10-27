package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.FacebookPage;
import com.ProjectTestCom.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

import javax.mail.MessagingException;
import javax.xml.bind.ValidationException;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class RegisterSteps extends ScenarioSteps {

    RegisterPage registerPage;

    FacebookPage facebookPage;

    @Step
    public void openRegisterPage() { registerPage.open();}

    @Step
    public void viaFacebook(WebDriver driver) { registerPage.viaFacebook(driver);}

    @Step
    public void Step1_selectRadioButton_Organization() { registerPage.Step1_selectRadioButton_Organization();}

    @Step
    public void clearUserName() { registerPage.clearUserName();}

    @Step
    public void clearPassword() { registerPage.clearPassword();}

    @Step
    public void clearEmail() { registerPage.clearEmail();}

    @Step
    public void clearFirstName() { registerPage.clearFirstName();}

    @Step
    public void clearLastName() { registerPage.clearLastName();}

    @Step
    public void clearOrganizationFullName() { registerPage.clearOrganizationFullName();}

    @Step
    public void Step1_UserName(String UserName) { registerPage.Step1_UserName(UserName);}

    @Step
    public void Step1_Email(String Email) { registerPage.Step1_Email(Email);}

    @Step
    public void Step1_Password(String Password) { registerPage.Step1_Password(Password);}

    @Step
    public void Step2_FirstName(String FirstName) { registerPage.Step2_FirstName(FirstName);}

    @Step
    public void Step2_LastName(String LastName) { registerPage.Step2_LastName(LastName);}

    @Step
    public void Step2_OrganizationFullName(String OrganizationFullName) { registerPage.Step2_OrganizationFullName(OrganizationFullName);}

    @Step
    public void Step2_Gender(WebDriver driver, String gender) { registerPage.Step2_Gender(driver, gender );}

    @Step
    public void Step2_Founded(String year, WebDriver driver) { registerPage.Step2_Founded(year, driver);}

    @Step
    public void Step2_Location(WebDriver driver, String location) { registerPage.Step2_Location(driver, location);}

    @Step
    public void Step1_pressButton_Next( ) { registerPage.Step1_pressButton_Next( );}

    @Step
    public void Step2_pressButton_Confirm(WebDriver driver ) { registerPage.Step2_pressButton_Confirm(driver);}

    @Step
    public void Step3_Ok ( WebDriver driver, String email) { registerPage.Step3_Ok(driver, email) ;}

    @Step
    public void checkValidationMessage(String Message, WebDriver driver) { assertTrue(registerPage.checkValidationMessage(Message, driver));}

    @Step
    public void checkValidationMessage_if_UserNameAR(String Message, WebDriver driver) { registerPage.checkValidationMessage_if_UserNameAR(Message, driver);}

    @Step
    public void checkValidationMessage_Password(String Message, WebDriver driver) { registerPage.checkValidationMessage_Password(Message, driver);}

    @Step
    public String provideCode(String email) { return registerPage.provideCode(email);}

    @Step
    public void goConfirmLink(WebDriver driver, String email) { registerPage.goConfirmLink(driver, email);}

    @Step
    public void checkWelcomeLetter(String email) { registerPage.checkWelcomeLetter(email);}

    @Step
    public void facebookLogin(WebDriver driver) { facebookPage.facebookLogin(driver);}
}
