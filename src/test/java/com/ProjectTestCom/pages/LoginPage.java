package com.ProjectTestCom.pages;

//import static org.junit.Assert.fail;
//import com.ProjectTestCom.utils.DriverScripts;
import com.ProjectTestCom.utils.FileWriterUtil;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.sun.net.httpserver.HttpsConfigurator;
//import com.thoughtworks.selenium.webdriven.commands.Check;
import groovy.transform.BaseScript;
import jline.internal.Log;
import net.serenitybdd.core.pages.PageUrls;
import net.serenitybdd.junit.runners.SerenityRunner;
//import net.sf.cglib.asm.Constants;
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
import org.openqa.selenium.support.ui.*;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import static org.junit.Assert.assertFalse;
import static org.openqa.grid.common.RegistrationRequest.TIME_OUT;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

//@DefaultUrl("http://synergy.devzone.dp.ua/en/")
@DefaultUrl("http://mnassa.com/en/")
@RunWith(SerenityRunner.class)
public class LoginPage extends PageObject {
    //private final By btnForgotPassword = By.xpath("//a[@class='link-forgot-password']");
    private final By btnForgotPassword = By.xpath("//button[@can-click='forgot_modal_show']");
    private final By fieldEmail = By.id("login_email");
    private final By fieldPassword = By.id("login_password");
    private final By btnEnter = By.id("do_login");
    private final By lblLoginError = By.xpath("//div[@class='error_message']");
    //private final By lblPasswordError = By.xpath("//div[@class='error_message']");
    private final By lblPasswordError = By.xpath("//span[@class='auth-form-err']");
    private final By LogOut = By.xpath("//div[@class='header-user']/div[2]/a[3]");

    private final By Button = By.xpath("//button[@class='header-control -auth']");
    private final By LoginLink = By.xpath("//button[@data-target='#auth-tab-login']");

    String parentWindowHandler;

    //Visible elements
    private final By HomeContent = By.xpath("//div[@class='feed container']");
    private final By Counter = By.xpath("//span[@class='wall-post-length']");
    private final By Header = By.xpath("//div[@class='nav-back']");

    public void openForgotPasswordPage() {
        element(btnForgotPassword).click();
        parentWindowHandler = getDriver().getWindowHandle();
    }

    public void pressLoginLink( ) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 800);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Button));
        find(Button).click();
        wt.until(ExpectedConditions.elementToBeClickable(LoginLink));
        find(LoginLink).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(fieldEmail));
    }

    public void enterLogin(String email) {

        if (find(fieldEmail).isEnabled())
        {
            find(fieldEmail).waitUntilPresent();
            WebDriverWait wt = new WebDriverWait (getDriver(), 200);
            wt.until(ExpectedConditions.visibilityOfElementLocated(fieldEmail));
            wt.until(ExpectedConditions.presenceOfElementLocated(fieldEmail));
            find(fieldEmail).waitUntilPresent();
            find(fieldEmail).sendKeys(email);
        }
    }

    public void enterPassword(String password) {
        clearPassword();
        find(fieldPassword).sendKeys(password);
    }

    public void clickEnter(WebDriver driver){
        element(btnEnter).click();
        WebDriverWait wt = new WebDriverWait (driver, 800);
        wt.until(visibilityOfElementLocated(Header));
        wt.until(visibilityOfElementLocated(HomeContent));
        wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
    }

    public void clickLogOut() {element(LogOut).click();}

    public void clickEnterError() {element(btnEnter).click();}

    public void clearLogin() {
        find(fieldEmail).clear();
    }

    public void clearPassword() {
        find(fieldPassword).clear();
    }

    public void checkPasswordErrorPresent(String text) throws MessagingException{
        try {
            //System.out.println("Validation message now: " + find(lblPasswordError).getText());
            Assert.assertEquals(text, find(lblPasswordError).getText());
        } catch (Error  NameError) {
            NameError :
            System.out.println("Account is going to be Blocked...");
            System.out.println("Validation message now: " + getDriver().findElement(lblPasswordError).getText());
        }
    }

    public void checkLoginErrorPresent(String text) throws MessagingException, IOException{
        //System.out.println("Validation message now: " + find(lblLoginError).getText());
        Assert.assertEquals(text,find(lblLoginError).getText());
    }

    /* Common utils*/

    public void uploadImage(String image) throws AWTException{
        //String k = "D:\\ProjectTestCom\\src\\test\\resources\\images\\music.png";
        String k = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\" + image;
        System.out.println("Way to image: " + k );

        StringBuffer buf = new StringBuffer();
        buf.delete(0, buf.length());
        buf.insert(0, k);
        System.out.println(buf);

        StringSelection ss = new StringSelection(k);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.delay(20);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(13);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(98);
        robot.keyPress(KeyEvent.VK_ENTER);    // press Enter
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void PageComplete(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 3500);
        wait.until(pageLoadCondition);
    }

   /* public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }*/

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

    public void pageLoadi() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        final Long Prerequest;
        final Long Request;
        final Long Response;
        final Long DOMLoading;
        final Long DOMComplete;
        final Long Load;
        final Long Processing;

        Prerequest = (Long) js.executeScript("return (window.performance.timing.requestStart-window.performance.timing.navigationStart);");

        Request = (Long) js.executeScript("return (window.performance.timing.responseStart - window.performance.timing.requestStart) ;");
        System.out.println("Request " + Request);

        Response = (Long) js.executeScript("return (window.performance.timing.responseEnd - window.performance.timing.responseStart) ;");
        System.out.println("Response " + Response);

        DOMLoading = (Long) js.executeScript("return (window.performance.timing.domInteractive -window.performance.timing.responseEnd) ;");
        System.out.println("DOMLoading " + DOMLoading);

        DOMComplete = (Long) js.executeScript("return (window.performance.timing.domComplete - window.performance.timing.domInteractive) ;");
        System.out.println("DOMComplete " + DOMComplete);

        Load = (Long) js.executeScript("return (window.performance.timing.loadEventEnd - window.performance.timing.domComplete) ;");
        System.out.println("Load " + Load);

        System.out.println("Total " + (Prerequest + Request + Response + DOMLoading + DOMComplete + Load));
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

        /*String TextRequest =  "Request  : " + Request + "| ";
        String TextResponse = "Response : " + Response + "| ";
        String TextfulLoad =  "Full Load: " + fulLoad + "| ";*/

        String TextRequest =  Request + "| ";
        String TextResponse = Response + "| ";
        String TextfulLoad =  fulLoad + "| ";

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
            //fw.write("\r\n");
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

        File f = new File("D:/diagram.txt");
        f.createNewFile();
        FileWriter ff = new FileWriter(f, true);
        try {
            //ff.write(page);
            ff.write(TextfulLoad);
            ff.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ff.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



