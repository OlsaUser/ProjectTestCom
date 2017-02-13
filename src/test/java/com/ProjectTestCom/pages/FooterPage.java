package com.ProjectTestCom.pages;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//@DefaultUrl("http://synergy.devzone.dp.ua/en")
@DefaultUrl("http://mnassa.com/en")
@RunWith(SerenityRunner.class)
public class FooterPage extends PageObject {

    private final By About = By.xpath("//nav[@class='footer-nav']/div/div[1]//a");
    private final By Contact = By.xpath("//nav[@class='footer-nav']/div/div[3]//a");
    private final By TermsConditions = By.xpath("//nav[@class='footer-nav']/div/div[2]//a");
    private final By PrivacyPolicy = By.xpath("//nav[@class='footer-nav']/div/div[4]//a");

    public void openAbout(WebDriver driver, String url) {
        find(About).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.urlToBe(url));
    }

    public void openContact(WebDriver driver, String url ) {
        element(Contact).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.urlToBe(url));
    }

    public void openTermsConditions(WebDriver driver, String url ) {
        element(TermsConditions).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.urlToBe(url));
    }

    public void openPrivacyPolicy(WebDriver driver, String url ) {
        element(PrivacyPolicy).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.urlToBe(url));
    }
}
