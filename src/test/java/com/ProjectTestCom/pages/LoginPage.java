package com.ProjectTestCom.pages;

//import static org.junit.Assert.fail;
//import com.ProjectTestCom.utils.DriverScripts;
import com.ProjectTestCom.utils.FileWriterUtil;
import com.gargoylesoftware.htmlunit.WebClient;
import com.sun.net.httpserver.HttpsConfigurator;
import com.thoughtworks.selenium.webdriven.commands.Check;
import groovy.transform.BaseScript;
import jline.internal.Log;
import net.serenitybdd.core.pages.PageUrls;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.sf.cglib.asm.Constants;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.apache.xpath.operations.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Set;
import java.lang.System;
import static java.lang.System.getProperty;
import static java.lang.System.loadLibrary;
import static java.util.concurrent.TimeUnit.SECONDS;
import static junit.framework.TestCase.assertTrue;
import static org.jruby.util.URLUtil.getPath;
import static org.openqa.grid.common.RegistrationRequest.TIME_OUT;

@DefaultUrl("http://synergybeta.devzone.dp.ua/en/#!login")
//@DefaultUrl("http://mnassa.com/en/#!login")
@RunWith(SerenityRunner.class)
public class LoginPage extends PageObject {
    private final By btnForgotPassword = By.xpath("//a[@class='link-forgot-password']");
    private final By fieldEmail = By.id("login_email");
    private final By fieldPassword = By.id("login_password");
    private final By btnEnter = By.id("do_login");
    private final By lblLoginError = By.xpath("//div[@class='error_message']");
    private final By lblPasswordError = By.xpath("//div[@class='error_message']");
    private final By LogOut = By.xpath("//div[@class='header-user']/div[2]/a[3]");

    String parentWindowHandler;

    //Visible elements
    private final By HomeContent = By.xpath("//div[@class='feed container']");
    private final By Counter = By.xpath("//span[@class='wall-post-length']");

    public void openForgotPasswordPage() {
        element(btnForgotPassword).click();
        parentWindowHandler = getDriver().getWindowHandle();
    }

    public void enterLogin(String email) {
        if (find(fieldEmail).isEnabled())
            find(fieldEmail).waitUntilEnabled();
            find(fieldEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        clearPassword();
        find(fieldPassword).sendKeys(password);
    }

    public void clickEnter(WebDriver driver){
        element(btnEnter).click();

        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
      //  wt.until(ExpectedConditions.presenceOfElementLocated(HomeContent));
        //find(Counter).waitUntilVisible();
    }

    public void clickLogOut() {element(LogOut).click();}

    public void clickEnterError() {element(btnEnter).click();}

    public void clearLogin() {
        find(fieldEmail).clear();
    }

    public void clearPassword() {
        find(fieldPassword).clear();
    }

    public void checkPasswordErrorPresent(String text) {
        try {
            System.out.println("Validation message now: " + find(lblPasswordError).getText());
            assertTrue("Wrong validation message for Password!",find(lblPasswordError).getText().contains(text));
        } catch (Error  NameError) {
            NameError :
            System.out.println("Account is going to be Blocked...");
            System.out.println("Validation message now: " + getDriver().findElement(lblPasswordError).getText());
        }
    }

    public void checkLoginErrorPresent(String text) {
        System.out.println("Validation message now: " + find(lblLoginError).getText());
        assertTrue("Wrong validation message for Login!",find(lblLoginError).containsText(text));
    }



    /* Common utils*/

    public void PageComplete(final WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 450);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }

    public void PageInteractive(final WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 200);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("interactive");
            }
        });
    }

    public void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void swithToModalWindow() {
        String modalWindowHandle = "";
        Set<String> handles = getDriver().getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentWindowHandler))
                modalWindowHandle = handle;
        }
        getDriver().switchTo().window(modalWindowHandle);
    }

    public void pageLoad(String args) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        final Long loadEventEnd;
        final Long responseStart;
        final Long responseEnd;
        final Long requestStart;
        final Long indexOfLastResources;
        final Long Request;
        final Long Response;
        final Long fulLoad;

        //http://w3c.github.io/navigation-timing/
        //This attribute must return the time when the load event of the current document is completed
        loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");

        //This attribute must return the time immediately after the user agent receives the first byte of the response from the server
        responseStart = (Long) js.executeScript("return window.performance.timing.responseStart;");

        //This attribute must return the time immediately after the user agent receives the last byte of the current document or immediately before the transport connection is closed, whichever comes first
        responseEnd = (Long) js.executeScript("return window.performance.timing.responseEnd;");

        //This attribute must return the time immediately before the user agent starts requesting the current document from the server
        requestStart = (Long) js.executeScript("return window.performance.timing.requestStart;");

        indexOfLastResources = (Long) js.executeScript("return window.performance.getEntriesByType('resource').length");

        Request = responseStart - requestStart;
        Response = responseEnd - responseStart;
        fulLoad = loadEventEnd - requestStart;

     /*   System.out.println("Load Event End " + loadEventEnd);
        System.out.println("Page Load Time is " + fulLoad + " mseconds.");
        System.out.println("TimeFirstByte " + responseTime + " serverTime " + serverTime);
        System.out.println("Requests " + indexOfLastResources);*/

        String TextRequest =  "Request  : " + Request + "| ";
        String TextResponse = "Response : " + Response + "| ";
        String TextfulLoad =  "Full Load: " + fulLoad + "| ";
        String TotalRequests = "Total Requests:" + indexOfLastResources + " ";
        String page = "Page: " + args + "| ";

        String baseUrl = getDriver().getCurrentUrl();
        //System.out.println("URL is " + baseUrl);
        //System.out.println("URL is " + baseUrl.toString());

        //File file = new File("C:/Users/olsa/IdeaProjects/ProjectTestCom/Report.txt");
        File file = new File("D:/Report.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file, true);
        // FileWriter fr = null;
        try {
            // fr = new FileWriter(file);
            fw.write("\r\n");
            fw.write(baseUrl);
            fw.write("\r\n");
            fw.write(page);
            fw.write(TextRequest);
            fw.write(TextResponse);
            fw.write(TextfulLoad);
            //fw.write(TotalRequests);
            fw.write("\r\n");
            fw.write("\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



