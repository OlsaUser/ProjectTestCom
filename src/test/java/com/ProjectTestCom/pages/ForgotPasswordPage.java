package com.ProjectTestCom.pages;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.validation.constraints.AssertTrue;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

@RunWith(SerenityRunner.class)
public class ForgotPasswordPage extends PageObject {
    //private final By fieldEmail = By.xpath("//div[@id='forgot-modal']//input[contains(@type, 'email')]");
    private final By fieldEmail = By.xpath("//input[@can-enter='forgot_validate']");
    private final By btnEnter = By.id("do_request");
    //private final By btnEnter = By.xpath("//button[@can-click='forgot_validate']");
    //private final By btnEnter = By.xpath("//button[@can-click='forgot_validate']");
    //private final By lblEmailError = By.xpath("//div[@class='error_message']");
    private final By lblEmailError = By.xpath("//span[@class='auth-form-err']");
    //private final By SuccessPopup = By.xpath("//div[@id='forgot-modal-success']//div[@class='modal-content']//div[@class='text-center narrow-block-text']");
    private final By SuccessPopup = By.xpath(".//*[@id='auth-modal-forgot-success']/div/div/div[2]/p");

    public void enterEmail(String email) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 400);
        wt.until(ExpectedConditions.visibilityOfElementLocated(fieldEmail));
        find(fieldEmail).clear();
        find(fieldEmail).sendKeys(email);
    }

    public void clickConfirm() {
        element(btnEnter).click();
        }

    public void checkIfEmailSucceed() {
        WebDriverWait wt = new WebDriverWait (getDriver(), 400);
        wt.until(ExpectedConditions.presenceOfElementLocated(SuccessPopup));
        wt.until(ExpectedConditions.textToBePresentInElementLocated(SuccessPopup, "The link to enter the site was successfully sent to "));
    }

    public void checkEmailErrorPresent(String text) {
    System.out.println("Validation message now: " + find(lblEmailError).getText());
    assertTrue("Wrong validation message!",find(lblEmailError).containsText(text));
    }
}
