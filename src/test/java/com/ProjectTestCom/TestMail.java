package com.ProjectTestCom;

import com.ProjectTestCom.pages.FacebookPage;
import com.ProjectTestCom.pages.RegisterPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

@RunWith(SerenityRunner.class)
public class TestMail {

    @Managed
    WebDriver driver;

    @Before
    public void setup() throws IOException {
        FirefoxProfile myProfile = new FirefoxProfile(new File("D:/SeleniumProfile"));
        myProfile.setPreference("network.proxy.socks_port", 9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /*@Test
        public static void main(String ... arhgs){
            public  void main(){
            RegisterPage.provideCode("lensytosakish.1@gmail.com");
            RegisterPage.checkWelcomeLetter("lensytosakish.1@gmail.com");
    }*/
    @Test
    public void facebook() {
        driver.get("https://www.facebook.com/");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("olgapola2013@yahoo.com");
        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("qazwsx123");
        driver.findElement(By.id("u_0_l")).click();
        try {
            Thread.sleep(10000);
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
}
