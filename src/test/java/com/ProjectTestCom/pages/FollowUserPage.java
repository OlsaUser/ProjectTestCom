package com.ProjectTestCom.pages;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

//@DefaultUrl("http://synergy.devzone.dp.ua/en/#!login")
//@DefaultUrl("http://mnassa.com/en/#!login")
@RunWith(SerenityRunner.class)
public class FollowUserPage extends PageObject {
    private final By btnFollow_ViewProfile = By.xpath("//button[@can-click='data.user.handle_follower']");
    private final By btnFollow_ViewItem = By.xpath("//button[@can-click='handle_follower']");
    private final By btnFollow = By.xpath("//button[@can-click='handle_follower']");
    private final By newFollowing = By.xpath("//a[@class='user-name']");
    private final By emptyPlace = By.xpath("//div[@id='page-top']");
    private int count=0;

    public void addToFollowing(String xpath, String name, WebDriver driver, String classBtn) {
        List<WebElement> btnFlw = getDriver().findElements(By.xpath(xpath));
        for (WebElement el : btnFlw) {
            String value = el.getAttribute("class");
            //if (value.equals("btn btn-sm follow-button users-list-follow -pin-right"))
            if (!value.equals(classBtn))
            {
                pressFollowButtonInListing(el, driver, classBtn);
                break;
            }
          }
        }

    public void pressFollowButtonInListing(WebElement el , WebDriver driver, String classBtn) {
        el.click();
        //find(emptyPlace).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.elementToBeClickable(el));
        //find(emptyPlace).click();
        checkFollowButtonWasPressed(el, classBtn);
        System.out.println("Success!");
    }

    public void checkFollowButtonWasPressed(WebElement el, String classBtn ) {
        assertTrue("Favorite icon NOT changed status to 'in favorite'", el.getAttribute("class").equals(classBtn));
    }

    public int openMyFollowingsPageAndCheck(WebDriver driver, String name) {
        String newFlw = find(newFollowing).getText();
        System.out.println(find(newFollowing).getText());
        System.out.println(name);
        assertTrue("Cannot find new Following", name.contains(newFlw));
        count++;
        String lCount = String.valueOf(count);
        System.out.println("Count of Following: " + lCount);
        return count;
    }

   /* public void pressFollow(WebDriver driver) {
        List<WebElement> btnFlw = getDriver().findElements(btnFollow);
        for (WebElement el : btnFlw) {
            String value = el.getAttribute("class");
            if (value.equals("btn btn-sm follow-button users-list-follow -pin-right")) {
                System.out.println("Pressed Follow blue button :" + value);
                el.click();
                break;
            }
            if (value.equals("btn btn-sm following-button users-list-follow -pin-right")) {
                System.out.println("Pressed Follow green button :" + value);
                el.click();
                break;
            }
        }
    }*/
    /* public void pressFollow_ViewProfile(WebDriver driver) {
        WebElement el = driver.findElement(btnFollow_ViewProfile);
        String value = el.getAttribute("class");
            if (value.equals("header-info-controls-btn btn btn-sm follow-button")) {
                System.out.println("Pressed Follow blue button :" + value);
                el.click();
                WebDriverWait wt = new WebDriverWait(driver, 60);
                wt.until(ExpectedConditions.visibilityOf(el));
            }
            if (value.equals("header-info-controls-btn btn btn-sm following-button")) {
                System.out.println("Pressed Follow green button :" + value);
                el.click();
                WebDriverWait wt = new WebDriverWait(driver, 60);
                wt.until(ExpectedConditions.visibilityOf(el));
            }
        }
    public void pressFollow_ViewItem(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 60);
        wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(btnFollow_ViewItem));

        WebElement el = driver.findElement(btnFollow_ViewItem);
        String value = el.getAttribute("class");
        if (value.equals("item-user-follow btn btn-sm follow-button")) {
            System.out.println("Pressed Follow blue button :" + value);
            el.click();
            //WebDriverWait wt = new WebDriverWait(driver, 60);
            wt.until(ExpectedConditions.visibilityOf(el));
        }
        if (value.equals("item-user-follow btn btn-sm following-button")) {
            System.out.println("Pressed Follow green button :" + value);
            el.click();
           // WebDriverWait wt = new WebDriverWait(driver, 60);
            wt.until(ExpectedConditions.visibilityOf(el));
        }
    }*/
}
