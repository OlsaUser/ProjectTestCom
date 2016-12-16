package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.FooterPage;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterSteps extends ScenarioSteps {

    FooterPage footerPage;

    @Step
    public void openHomePage() { footerPage.open();
        WebDriverWait wt = new WebDriverWait (getDriver(), 300);
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='page-body']/section/div[2]/nav/div/button[1]")));}

    @Step
    public void openAbout(WebDriver driver, String url) { footerPage.openAbout(driver, url);}

    @Step
    public void openContact(WebDriver driver, String url) { footerPage.openContact(driver, url);}

    @Step
    public void openTermsConditions(WebDriver driver, String url) { footerPage.openTermsConditions(driver, url);}

    @Step
    public void openPrivacyPolicy(WebDriver driver, String url) { footerPage.openPrivacyPolicy(driver, url);}
}
