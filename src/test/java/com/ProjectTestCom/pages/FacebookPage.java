package com.ProjectTestCom.pages;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;


@RunWith(SerenityRunner.class)
public class FacebookPage  extends PageObject {
    String parentWindowHandler;

    private final By text_emptyNewsFeed = By.xpath("//h1[@class='create-list-info']");

    public void facebookLogin(WebDriver driver, String Email, String Password) {
        driver.get("https://www.facebook.com/");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(Email);
        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys(Password);
        driver.findElement(By.id("registration_container"));

       // driver.findElement(By.id("u_0_l")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e1) {
// TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            driver.findElement(By.xpath("//span[text()='News Feed']"));
        } catch (WebDriverException e) {
            Assert.fail();
        }
    }
    public void TwitterLogin(WebDriver driver, String Email, String Password) {
        driver.get("https://twitter.com/");
        WebElement email = driver.findElement(By.id("signin-email"));
        email.sendKeys(Email);
        WebElement pass = driver.findElement(By.id("signin-password"));
        pass.sendKeys(Password);
        driver.findElement(By.xpath("//button[@class='submit btn primary-btn flex-table-btn js-submit']"));
        driver.findElement(By.xpath("//button[@class='submit btn primary-btn flex-table-btn js-submit']")).click();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e1) {
// TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            driver.findElement(By.id("stream-items-id"));
        } catch (WebDriverException e) {
            Assert.fail();
        }
    }
    public void GoogleLogin(WebDriver driver, String Email, String Password) {
        driver.get("https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=ru&service=mail#identifier");
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys(Email);
        driver.findElement(By.id("next")).click();

        WebElement pass = driver.findElement(By.id("Passwd"));
        pass.sendKeys(Password);
        driver.findElement(By.id("signIn")).click();

        try {
            Thread.sleep(800);
        } catch (InterruptedException e1) {
// TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            driver.findElement(By.id(":5"));
        } catch (WebDriverException e) {
            Assert.fail();
        }
    }
    public void confirmFbReg(WebDriver driver, String Email, String Password) {
        parentWindowHandler = getDriver().getWindowHandle();
        System.out.println("parentWindowHandler " + parentWindowHandler);

        for(String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
            System.out.println("winHandle " + winHandle);
        }
        WebElement continueAs = driver.findElement(By.xpath("//button[@name='__CONFIRM__']"));
        continueAs.click();
    }
    public void successRegistrationFb(WebDriver driver) {
        String modalWindowHandle = "";
        Set<String> handles = getDriver().getWindowHandles();
        System.out.println("handles " + getDriver().getWindowHandles());
        for (String handle : handles) {
            System.out.println("handle " + modalWindowHandle);
            if (handle.equals(parentWindowHandler))
                modalWindowHandle = handle;

            getDriver().switchTo().window(modalWindowHandle);
            System.out.println(getDriver().getCurrentUrl());
            Assert.assertTrue(getDriver().getTitle().contains("Mnassa"));

            WebDriverWait wt = new WebDriverWait (driver, 400);
            wt.until(ExpectedConditions.visibilityOfElementLocated(text_emptyNewsFeed));
            Assert.assertEquals( "Mnassa is a social interactive platform for business communication.",find(text_emptyNewsFeed).getText());
        }
    }
}
