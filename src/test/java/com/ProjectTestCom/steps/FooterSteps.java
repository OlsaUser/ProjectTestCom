package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.FooterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

public class FooterSteps extends ScenarioSteps {

    FooterPage footerPage;

    @Step
    public void openHomePage() { footerPage.open();}

    @Step
    public void openAbout(WebDriver driver, String url) { footerPage.openAbout(driver, url);}

    @Step
    public void openContact(WebDriver driver, String url) { footerPage.openContact(driver, url);}

    @Step
    public void openTermsConditions(WebDriver driver, String url) { footerPage.openTermsConditions(driver, url);}

    @Step
    public void openPrivacyPolicy(WebDriver driver, String url) { footerPage.openPrivacyPolicy(driver, url);}
}
