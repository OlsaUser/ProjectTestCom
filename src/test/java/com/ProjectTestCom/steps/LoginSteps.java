package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.LoginPage;
import com.ProjectTestCom.pages.LoginSucceedPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.mail.MessagingException;
import java.awt.*;
import java.io.IOException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step
    public void openForgotPasswordPage() { loginPage.openForgotPasswordPage();}

    @Step
    public void openLoginPage() { loginPage.open();}

    @Step
    public void enterLogin(String email) {loginPage.enterLogin(email);}

    @Step
    public void pressLoginLink( ) {loginPage.pressLoginLink();}

    @Step
    public void clearLogin() {loginPage.clearLogin();}

    @Step
    public void enterPassword(String password) {loginPage.enterPassword(password);}

    @Step
    public void clearPassword() {loginPage.clearPassword();}

    @Step
    public void clickEnter(WebDriver driver) {loginPage.clickEnter(driver);}

    @Step
    public void clickEnterError() {loginPage.clickEnterError();}

    @Step
    public void clickLogOut() {loginPage.clickLogOut();}

    @Step
    public void Sleep(int time) {loginPage.Sleep(time);}

    @Step
    public void PageComplete(WebDriver driver) {loginPage.PageComplete(driver);}

    @Step
    public void uploadImage(String image) throws AWTException {loginPage.uploadImage(image);}

    @Step
    public void pageLoad(String args) throws IOException {loginPage.pageLoad(args);}

    @Step
    public void checkLoginErrorPresent(String text)throws MessagingException, IOException {loginPage.checkLoginErrorPresent(text);}

    @Step
    public void checkPasswordErrorPresent(String text) throws MessagingException {loginPage.checkPasswordErrorPresent(text);}
}
