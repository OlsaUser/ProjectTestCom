package com.ProjectTestCom;

import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import org.junit.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
     driver = new FirefoxDriver();
     baseUrl = "http://synergy.devzone.dp.ua";
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

      /*FirefoxProfile myProfile = new FirefoxProfile(new File("D:/SeleniumProfile"));
      myProfile.setPreference("network.proxy.socks_port",9999);
      myProfile.setAlwaysLoadNoFocusLib(true);
      myProfile.setEnableNativeEvents(true);
      Serenity.useFirefoxProfile(myProfile);*/
  }

  @Test
  public void testWeb() throws Exception {
    driver.get(baseUrl + "/en");
    driver.findElement(By.xpath(".//*[@id='page-header-top']/div/div[1]/a[2]")).click();
    driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);

    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,1000)", "");

    driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
    driver.findElement(By.xpath(".//*[@id='home-discover-users-tab']/div/a")).click();

    /*driver.findElement(By.cssSelector("section.home-intro")).click();
    driver.findElement(By.cssSelector("div.header-nav-item.-auth > span.header-nav-link")).click();
    driver.findElement(By.linkText("Login")).click();

    driver.findElement(By.id("login_email")).click();
    driver.findElement(By.id("login_email")).clear();
    driver.findElement(By.id("login_email")).sendKeys("admin@admin.com");

    driver.findElement(By.id("login_password")).clear();
    driver.findElement(By.id("login_password")).sendKeys("password");

    driver.findElement(By.id("do_login")).click();*/
    //driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
  }

  @After
  public void tearDown() {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
