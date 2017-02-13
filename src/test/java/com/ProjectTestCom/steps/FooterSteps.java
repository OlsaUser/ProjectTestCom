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
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@style='background-image: url(http://mnassa.com/res/timthumb.php?src=/upl/items/559c0a654dafb779020715f2/featured/o_1adq4eis61njvmj5mra19o1c032h.jpg&w=1920)']")));}

    @Step
    public void openAbout(WebDriver driver, String url) { footerPage.openAbout(driver, url);}

    @Step
    public void openContact(WebDriver driver, String url) { footerPage.openContact(driver, url);}

    @Step
    public void openTermsConditions(WebDriver driver, String url) { footerPage.openTermsConditions(driver, url);}

    @Step
    public void openPrivacyPolicy(WebDriver driver, String url) { footerPage.openPrivacyPolicy(driver, url);}
}
