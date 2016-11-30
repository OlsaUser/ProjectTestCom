package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
import com.ProjectTestCom.steps.NewMessageSteps;
import com.ProjectTestCom.steps.RegisterSteps;
import com.ProjectTestCom.utils.PropertyLoader;
import groovyjarjarasm.asm.commons.Method;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.steps.StepFailure;
import net.thucydides.core.steps.StepListener;
import net.thucydides.core.util.MockEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.junit.listeners.JUnitStepListener;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.mail.MessagingException;
import javax.xml.bind.ValidationException;
import java.io.File;
import java.io.IOException;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class t0_RegistrationStory {

    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String registrationFilePath = "src/test/resources/registration.properties";
    private String NewEmailUser = PropertyLoader.getProperty(registrationFilePath, "NewEmailUser");
    private String NewEmailOrg = PropertyLoader.getProperty(registrationFilePath, "NewEmailOrg");
    private String WrongEmail = PropertyLoader.getProperty(registrationFilePath, "WrongEmail");
    private String ExistEmail = PropertyLoader.getProperty(registrationFilePath, "ExistEmail");
    private String NewPassword = PropertyLoader.getProperty(registrationFilePath, "NewPassword");
    private String ShortPassword = PropertyLoader.getProperty(registrationFilePath, "ShortPassword");
    private String LongPassword = PropertyLoader.getProperty(registrationFilePath, "LongPassword");
    private String UserNameEn = PropertyLoader.getProperty(registrationFilePath, "UserName_En");
    private String OrganizationShortNameEn = PropertyLoader.getProperty(registrationFilePath, "OrganizationShortName_En");
    private String UserName_AR = PropertyLoader.getProperty(registrationFilePath, "UserName_AR");
    private String Name_51_symbols = PropertyLoader.getProperty(registrationFilePath, "Name_51_symbols");
    private String Name_101_symbols = PropertyLoader.getProperty(registrationFilePath, "Name_101_symbols");
    private String Numbers = PropertyLoader.getProperty(registrationFilePath, "Numbers");
    private String Symbols = PropertyLoader.getProperty(registrationFilePath, "Symbols");
    private String FirstNameEn = PropertyLoader.getProperty(registrationFilePath, "FirstName_En");
    private String LastNameEn = PropertyLoader.getProperty(registrationFilePath, "LastName_En");
    private String FirstName_Ar = PropertyLoader.getProperty(registrationFilePath, "FirstName_Ar");
    private String LastName_Ar = PropertyLoader.getProperty(registrationFilePath, "LastName_Ar");
    private String OrganizationFullNameEn = PropertyLoader.getProperty(registrationFilePath, "OrganizationFullName_En");
    private String OrganizationFullName_Ar = PropertyLoader.getProperty(registrationFilePath, "OrganizationFullName_Ar");
    private String Year_2014 = PropertyLoader.getProperty(registrationFilePath, "Year_2014");
    private String Year_2016 = PropertyLoader.getProperty(registrationFilePath, "Year_2016");
    private String Year_1990 = PropertyLoader.getProperty(registrationFilePath, "Year_1990");
    private String gender_male = PropertyLoader.getProperty(registrationFilePath, "gender_man");
    private String gender_female = PropertyLoader.getProperty(registrationFilePath, "gender_female");
    private String LocationEN = PropertyLoader.getProperty(registrationFilePath, "LocationEN");
    private String LocationAR = PropertyLoader.getProperty(registrationFilePath, "LocationAR");

    private String ErrorUserName_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorUserName_Empty");
    private String ErrorUserName_Ar = PropertyLoader.getProperty(registrationFilePath, "ErrorUserName_Ar");
    private String ErrorUserName_Long = PropertyLoader.getProperty(registrationFilePath, "ErrorUserName_Long");
    private String NoError = PropertyLoader.getProperty(registrationFilePath, "NoError");
    private String ErrorEmail_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorEmail_Empty");
    private String ErrorEmail_Wrong = PropertyLoader.getProperty(registrationFilePath, "ErrorEmail_Wrong");
    private String ErrorEmail_Exist = PropertyLoader.getProperty(registrationFilePath, "ErrorEmail_Exist");
    private String ErrorPassword_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorPassword_Empty");
    private String ErrorPassword_Short = PropertyLoader.getProperty(registrationFilePath, "ErrorPassword_Short");
    private String ErrorPassword_Long = PropertyLoader.getProperty(registrationFilePath, "ErrorPassword_Long");
    private String ErrorFirstName_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorFirstName_Empty");
    private String ErrorLastName_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorLastName_Empty");
    private String ErrorGender_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorGender_Empty");
    private String ErrorLocation_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorLocation_Empty");
    private String ErrorOrganizationShortName_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorOrganizationShortName_Empty");
    private String ErrorOrganizationFullName_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorOrganizationFullName_Empty");
    private String ErrorFounded_Empty = PropertyLoader.getProperty(registrationFilePath, "ErrorFounded_Empty");
    private String UserName = PropertyLoader.getProperty(registrationFilePath, "UserName");
    private String EmailUser = PropertyLoader.getProperty(registrationFilePath, "EmailUser");
    private String OrganizationShortName = PropertyLoader.getProperty(registrationFilePath, "OrganizationShortName");
    private String EmailOrg = PropertyLoader.getProperty(registrationFilePath, "EmailOrg");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    RegisterSteps registerSteps;

    @Steps
    LoginSteps loginSteps;

    @Before
    public void setup() throws IOException {
        driver.manage().window().maximize();

        registerSteps.openRegisterPage();
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() throws Exception {driver.quit();}

    @Test
    public void stage1_Register_User()  throws Exception {
        registerSteps.Step1_UserName(UserNameEn);
        registerSteps.Step1_Email(NewEmailUser);
        registerSteps.Step1_Password(NewPassword);
        registerSteps.Step1_pressButton_Next();
        registerSteps.Step2_FirstName(FirstNameEn);
//        registerSteps.Step2_LastName(LastNameEn);
        registerSteps.Step2_Gender(driver, gender_female);
        registerSteps.Step2_Location(driver, LocationEN);
        registerSteps.Step2_pressButton_Confirm(driver);
        registerSteps.Step3_Ok(driver, NewEmailUser);
        /*loginSteps.Sleep(500);
        registerSteps.goConfirmLink(driver,NewEmailUser);
        registerSteps.checkWelcomeLetter(NewEmailUser);*/
        WebDriverWait wt = new WebDriverWait (driver, 50);
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='wall-post-length']")));
        registerSteps.checkWelcomeLetter(NewEmailUser);
    }

    @Test
    public void stage3_Register_Organization() throws Exception {
        registerSteps.Step1_selectRadioButton_Organization();
        registerSteps.Step1_UserName(OrganizationShortNameEn);
        registerSteps.Step1_Email(NewEmailOrg);
        registerSteps.Step1_Password(NewPassword);
        registerSteps.Step1_pressButton_Next();
        registerSteps.Step2_OrganizationFullName(OrganizationFullNameEn);
        registerSteps.Step2_Founded(Year_2014, driver);
        registerSteps.Step2_Location(driver, LocationAR);
        registerSteps.Step2_pressButton_Confirm(driver);
        registerSteps.Step3_Ok(driver, NewEmailOrg);
       /* loginSteps.Sleep(500);
        registerSteps.goConfirmLink(driver,NewEmailOrg);
        registerSteps.checkWelcomeLetter(NewEmailOrg);*/
        WebDriverWait wt = new WebDriverWait (driver, 50);
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='wall-post-length']")));
        registerSteps.checkWelcomeLetter(NewEmailUser);
        }

    @Test
    public void stage4_ValidationMessages_User() throws Exception {
        registerSteps.Step1_UserName(UserNameEn);
        registerSteps.clearUserName();
        registerSteps.Step1_pressButton_Next();
        System.out.println("1.ErrorUserName_Empty");
        registerSteps.checkValidationMessage(ErrorUserName_Empty, driver);
        registerSteps.clearUserName();

        registerSteps.Step1_UserName(UserName_AR);
        registerSteps.Step1_pressButton_Next();
        System.out.println("2.ErrorUserName_Ar");
        registerSteps.checkValidationMessage_if_UserNameAR(ErrorUserName_Ar, driver);
        registerSteps.clearUserName();

        registerSteps.Step1_UserName(Symbols);
        registerSteps.Step1_pressButton_Next();
        System.out.println("3.ErrorUserName_Symbols");
        registerSteps.checkValidationMessage_if_UserNameAR(ErrorUserName_Ar, driver);
        registerSteps.clearUserName();

        //registerSteps.Step1_UserName(Name_51_symbols);
        registerSteps.Step1_UserName(Name_101_symbols);
        registerSteps.Step1_pressButton_Next();
        System.out.println("4.ErrorUserName_Long");
        registerSteps.checkValidationMessage(ErrorUserName_Long, driver);
        registerSteps.clearUserName();

        registerSteps.Step1_UserName(Numbers);
        registerSteps.Step1_pressButton_Next();
        System.out.println("5.UserName_Numbers");
        //registerSteps.checkValidationMessage(NoError, driver);
        registerSteps.clearUserName();

        registerSteps.Step1_Email(NewEmailUser);
        registerSteps.clearUserName();
        registerSteps.clearEmail();
        registerSteps.Step1_pressButton_Next();
        System.out.println("6.ErrorEmail_Empty");
        registerSteps.checkValidationMessage(ErrorEmail_Empty, driver);

        registerSteps.Step1_Email(WrongEmail);
        registerSteps.Step1_pressButton_Next();
        System.out.println("7.ErrorEmail_Wrong");
        registerSteps.checkValidationMessage(ErrorEmail_Wrong, driver);
        registerSteps.clearEmail();

        registerSteps.Step1_Password(NewPassword);
        registerSteps.clearPassword();
        registerSteps.Step1_pressButton_Next();
        System.out.println("8.ErrorPassword_Empty");
        registerSteps.checkValidationMessage(ErrorPassword_Empty, driver);

        registerSteps.Step1_Password(ShortPassword);
        registerSteps.Step1_pressButton_Next();
        System.out.println("9.ErrorPassword_Short");
        registerSteps.checkValidationMessage_Password(ErrorPassword_Short, driver);

        registerSteps.Step1_Password(LongPassword);
        registerSteps.Step1_pressButton_Next();
        System.out.println("10.ErrorPassword_Long");
        registerSteps.checkValidationMessage_Password(ErrorPassword_Long, driver);

        registerSteps.clearUserName();
        registerSteps.clearEmail();
        registerSteps.clearPassword();

        registerSteps.Step1_UserName(UserName);
        registerSteps.Step1_Email(ExistEmail);
        registerSteps.Step1_Password(NewPassword);
        registerSteps.Step1_pressButton_Next();
        System.out.println("11.ErrorEmail_Exist");
        registerSteps.checkValidationMessage(ErrorEmail_Exist, driver);
        registerSteps.clearEmail();

        registerSteps.Step1_Email(EmailUser);
        registerSteps.Step1_pressButton_Next();

        registerSteps.Step2_FirstName(FirstNameEn);
        registerSteps.clearFirstName();
        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("12.ErrorFirstName_Empty");
        registerSteps.checkValidationMessage(ErrorFirstName_Empty, driver);
        registerSteps.clearFirstName();

        registerSteps.Step2_FirstName(FirstName_Ar);
        registerSteps.Step2_pressButton_Confirm(driver);
        registerSteps.checkValidationMessage(NoError, driver);
        registerSteps.clearFirstName();

        registerSteps.Step2_FirstName(Symbols);
        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("13.FirstName_Symbols");
        registerSteps.checkValidationMessage(NoError, driver);
        registerSteps.clearFirstName();

        registerSteps.Step2_FirstName(Numbers);
        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("14.FirstName_Numbers");
        registerSteps.checkValidationMessage(NoError, driver);
        registerSteps.clearFirstName();

        registerSteps.Step2_LastName(LastNameEn);
        registerSteps.clearLastName();
        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("15.ErrorLastName_Empty");
        registerSteps.checkValidationMessage(ErrorLastName_Empty, driver);
        registerSteps.clearLastName();

        registerSteps.Step2_LastName(LastName_Ar);
        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("16.LastName_Ar");
        registerSteps.checkValidationMessage(NoError, driver);
        registerSteps.clearLastName();

        registerSteps.Step2_LastName(Symbols);
        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("17.LastName_Symbols");
        registerSteps.checkValidationMessage(NoError, driver);
        registerSteps.clearLastName();

        registerSteps.Step2_LastName(Numbers);
        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("18.LastName_Numbers");
        registerSteps.checkValidationMessage(NoError, driver);
        registerSteps.clearLastName();

        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("19.Error Gender & Location_Empty");
        registerSteps.checkValidationMessage(ErrorGender_Empty, driver);
        registerSteps.checkValidationMessage(ErrorLocation_Empty, driver);
    }
    @Test
    public void stage5_ValidationMessages_Organization() throws Exception{
        registerSteps.Step1_selectRadioButton_Organization();
        registerSteps.Step1_UserName(OrganizationShortNameEn);
        registerSteps.clearUserName();
        registerSteps.Step1_pressButton_Next();
        System.out.println("1.ErrorOrganizationShortName_Empty");
        registerSteps.checkValidationMessage(ErrorOrganizationShortName_Empty, driver);
        registerSteps.clearUserName();

        registerSteps.Step1_selectRadioButton_Organization();
        registerSteps.Step1_UserName(OrganizationShortName);
        registerSteps.Step1_Email(EmailOrg);
        registerSteps.Step1_Password(NewPassword);
        registerSteps.Step1_pressButton_Next();
        registerSteps.Step2_OrganizationFullName(OrganizationFullNameEn);
        registerSteps.clearOrganizationFullName();
        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("2.ErrorOrganizationFullName_Empty");
        registerSteps.checkValidationMessage(ErrorOrganizationFullName_Empty, driver);
        System.out.println("3.ErrorFounded_Empty");
        registerSteps.checkValidationMessage(ErrorFounded_Empty, driver);
        System.out.println("4.ErrorLocation_Empty");
        registerSteps.checkValidationMessage(ErrorLocation_Empty, driver);

        registerSteps.Step2_OrganizationFullName(OrganizationFullName_Ar);
        System.out.println("5.OrganizationFullName_Ar");
        registerSteps.Step2_pressButton_Confirm(driver);
        //registerSteps.checkValidationMessage(NoError, driver);

        registerSteps.clearOrganizationFullName();
        registerSteps.Step2_OrganizationFullName(Symbols);
        System.out.println("6.OrganizationFullName_Symbols");
        registerSteps.Step2_pressButton_Confirm(driver);
        //registerSteps.checkValidationMessage(NoError, driver);

        registerSteps.clearOrganizationFullName();
        registerSteps.Step2_OrganizationFullName(Numbers);
        registerSteps.Step2_pressButton_Confirm(driver);
        System.out.println("7.OrganizationFullName_Numbers");
        //registerSteps.checkValidationMessage(NoError, driver);
    }
}
