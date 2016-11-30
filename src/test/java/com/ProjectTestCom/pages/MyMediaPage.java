package com.ProjectTestCom.pages;

import junit.framework.AssertionFailedError;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
public class MyMediaPage extends PageObject {
    private final By linkMyMnassa = By.xpath(".//*[@id='header-top-line']/nav/div[2]/a");
    private final By linkMyMedia = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']//li[7]");
    private final By AlbumBlock = By.xpath("//div[@class='gallery-list']/div[1]");
    private final By SettingsMenu = By.id("gallery-page-settings");
    private final By DeleteMenu = By.xpath("//li[@can-click='delete_album']");
    private final By EditMenu = By.xpath("//li[@can-click='settings_album']");
    private final By btnDelete = By.xpath("//div[@id='delete-album']//div[@class='text-center']/button[2]");
    private final By btnCancel = By.xpath("//div[@id='delete-album']//div[@class='text-center']/button[1]");
    private final By btnAddAlbum = By.xpath("//div[@class='gallery-page-head text-left']/a");
    private final By fieldAlbumName = By.id("album-name");
    private final By btnCreate = By.xpath(".//*[@id='add-album']/div/div/div[2]/div[2]/button");
    private final By lblAlbumNameError = By.xpath(".//*[@id='add-album']/div/div/div[2]/div[1]/div");
    private final By blockAlbum = By.xpath("//div[@class='gallery-list']/div[1]");
    private final By AlbumName = By.xpath("//div[@class='gallery-list']/div[1]//div[@class='gallery-box-info']//h3[@class='gallery-box-name']");
    private final By btnAddPhoto = By.xpath("//button[@can-click='upload_photo_modal']");
    private final By modalContent = By.xpath("//div[@id='alb-container']");
    private final By closeModalContent = By.xpath("//div[@class='modal-header']/button[1]");
    private final By modalEditbtn = By.xpath("//button[@can-click='accept_settings_album']");
    private final By modalEditPopup = By.xpath("//input[@id='album-rename']");

    String parentWindowHandler;

    //Visible elements
    private final By AlbumContent = By.xpath("//div[@class='gallery-list']/div[1]");
    private final By MediaContent = By.xpath("//div[@class='gallery-list']");


    public void openMyMnassaPage() {element(linkMyMnassa).click();}

    public void openMyMediaPage() {
        element(linkMyMedia).click();
    }

    public void openAddAlbumPage() {element(btnAddAlbum).click();}

    public void openViewAlbumPage() {element(AlbumBlock).click();}

    public void openSettingsMenu() {element(SettingsMenu).click();}

    public void selectDeleteMenu() {element(DeleteMenu).click();}

    public void selectEditMenu(WebDriver driver) {
        element(EditMenu).click();
        find(modalEditPopup);

        String PopupHandle = getDriver().getWindowHandle();
        getDriver().switchTo().window(PopupHandle);

        WebDriverWait wt = new WebDriverWait (driver, 99);
        element(modalEditbtn).click();

        getDriver().switchTo().defaultContent();
    }

    public void clickDeleteButton() {
        element(btnDelete).click();
    }

    public void clickAlbumDeleted(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.invisibilityOfElementLocated(btnDelete));
        wt.until(ExpectedConditions.visibilityOfElementLocated(MediaContent));
    }

    public void clickCancelButton(WebDriver driver ) {
        element(btnCancel).click();
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.invisibilityOfElementLocated(btnCancel));
    }

    public void enterAlbumName(String albumName) {
        String myAlbumPopupHandle = getDriver().getWindowHandle();
        getDriver().switchTo().window(myAlbumPopupHandle);
        clearAlbumName();
        find(fieldAlbumName).sendKeys(albumName);
    }

    public void clearAlbumName() {find(fieldAlbumName).clear();}

    public void clickCreate(WebDriver driver) {
        element(btnCreate).click();
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.invisibilityOfElementLocated(btnCreate));
    }

    public void clickCreateError() {element(btnCreate).click();}

    public void checkAlbumNameErrorPresent(String lblError, WebDriver driver) {
        //Проверяем, есть ли на текущей странице текст

        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(lblAlbumNameError,lblError));
      /*  try {
            getDriver().findElement(lblAlbumNameError).getText();
            System.out.println(lblError);
            return true;
        }
        catch (ElementNotFoundAfterTimeoutError e)
        {
            e.printStackTrace();
            return false;
        }*/
    }

    public void checkAlbumInListing(String albName, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(AlbumName,albName));

        //Assert.assertTrue("Text not found!", containsText(albName));
       /*
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.visibilityOfElementLocated(AlbumName));
       String t = getDriver().findElement(AlbumName).getText();
        System.out.println(t);
        System.out.println(albName);

       if (t.equals(albName)){
           getDriver().findElement(blockAlbum);
           System.out.println("NEW album exists");
        }
        else {
           System.out.println("There are no NEW album");
        }*/
    }

    public void switchToModalWindow() {
        String modalWindowHandle = "";
        Set<String> handles = getDriver().getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentWindowHandler))
                modalWindowHandle = handle;
        }
        getDriver().switchTo().window(modalWindowHandle);
    }

    public void pressAddPhotoBtn (WebDriver driver)
    {
        element(btnAddPhoto).click();
        find(modalContent);
        String PopupHandle = getDriver().getWindowHandle();
        getDriver().switchTo().window(PopupHandle);

        WebDriverWait wt = new WebDriverWait (driver, 99);
        element(closeModalContent).click();

        getDriver().switchTo().defaultContent();
    }
}
