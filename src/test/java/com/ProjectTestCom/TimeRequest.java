package com.ProjectTestCom;

import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
import com.ProjectTestCom.utils.PropertyLoader;
import com.gargoylesoftware.htmlunit.javascript.host.xml.XMLHttpRequest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.sourceforge.htmlunit.corejs.javascript.Function;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@RunWith(SerenityRunner.class)
public class TimeRequest {
    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    HeaderSteps headerSteps;

    @Before
    public void setup() throws IOException {
        String dir = System.getProperty("user.dir");
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.gecko.driver", dir + "\\src\\drivers\\geckodriver.exe");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(1800, TimeUnit.SECONDS);

        loginSteps.openLoginPage();
        loginSteps.pressLoginLink();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() throws Exception{
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void TimeRequest() {
        //Declare JavascriptExecutor
        JavascriptExecutor js =(JavascriptExecutor)driver;

        long startTime = System.currentTimeMillis();
        System.out.println ("Start Time: " + startTime);

       String resp = (String) js.executeAsyncScript("var callback = arguments[arguments.length - 1];"+
               "var xhr = new XMLHttpRequest(); " +
                       "xhr.open('POST', 'http://mnassa.com/en/user/xhr_upd_timeline', true); " +
                       "xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); " +
                       "xhr.setRequestHeader('charset', 'UTF-8'); " +
                       "var start_time = new Date().getTime();" +
                       "xhr.onreadystatechange = function () {   " +
                       "if (xhr.readyState == 4) {     " +
                       "var request_time = new Date().getTime() - start_time;" +
                       "callback(xhr.responseText);} " +
                       "}; " +
                       "xhr.send('limits%5Bsort%5D%5Bmcot_created%5D=DESC&limits%5Bpaginate%5D%5Bpage%5D=1&limits%5Bpaginate%5D%5Btimestamp%5D=1486384010&action=select');"        );

        System.out.println("Response: " + resp);
        System.out.println("Passed Time (ms): " + (System.currentTimeMillis() - startTime));

        //  Injecting a XMLHttpRequest and waiting for the result:
        //  http://synergybeta.devzone.dp.ua/_js_files/js/vendor/jquery-2.1.1_min.js?bust=1486124879508
        /*long time = (long) js.executeScript(
                        "var xhr = new XMLHttpRequest();" +
                        "xhr.open('POST', 'http://synergybeta.devzone.dp.ua/en/user/xhr_upd_timeline', false); " +
                        "xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); " +
                        "xhr.setRequestHeader('charset', 'UTF-8'); " +
                        "xhr.send('limits%5Bsort%5D%5Bmcot_created%5D=DESC&limits%5Bpaginate%5D%5Bpage%5D=1&limits%5Bpaginate%5D%5Btimestamp%5D=1486384010&action=select');" +
                        "var start_time = new Date().getTime();" +
                        "if(xhr.status == 200) {"+
                        "console.log(xhr.responseText);" +
                         "}" +
                         "var request_time = new Date().getTime() - start_time;" +
                         "return request_time;");

        System.out.println("readyState: " + time);*/

        //Assert that the time difference is greater than 200 ms
        //assertTrue("Time difference must be less than 8 000 milliseconds", (System.currentTimeMillis() - startTime) < 3000);
    }
}
