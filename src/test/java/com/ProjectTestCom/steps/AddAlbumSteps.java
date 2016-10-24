package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.MyMediaPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

public class AddAlbumSteps extends ScenarioSteps {

    MyMediaPage myMediaPage;

    @Step
    public void openAddAlbumPage() { myMediaPage.openAddAlbumPage();}

    @Step
    public void openMyMediaPage() { myMediaPage.openMyMediaPage();}

    @Step
    public void openMyMnassaPage() { myMediaPage.openMyMnassaPage();}

    @Step
    public void openViewAlbumPage() { myMediaPage.openViewAlbumPage();}

    @Step
    public void openSettingsMenu() { myMediaPage.openSettingsMenu();}

    @Step
    public void selectDeleteMenu() { myMediaPage.selectDeleteMenu();}

    @Step
    public void selectEditMenu(WebDriver driver) { myMediaPage.selectEditMenu(driver);}

    @Step
    public void clickDeleteButton() { myMediaPage.clickDeleteButton();}

    @Step
    public void clickAlbumDeleted(WebDriver driver) { myMediaPage.clickAlbumDeleted(driver);}

    @Step
    public void clickCancelButton(WebDriver driver) { myMediaPage.clickCancelButton(driver);}

    @Step
    public void switchToModalWindow() { myMediaPage.switchToModalWindow();}

    @Step
    public void enterAlbumName(String albumName) { myMediaPage.enterAlbumName(albumName);}

    @Step
    public void clearAlbumName() { myMediaPage.clearAlbumName();}

    @Step
    public void clickCreate(WebDriver driver)  { myMediaPage.clickCreate(driver);}

    @Step
    public void clickCreateError() { myMediaPage.clickCreateError();}

    @Step
    public void pressAddPhotoBtn(WebDriver driver) { myMediaPage.pressAddPhotoBtn(driver);}

    @Step
    public void checkAlbumNameErrorPresent(String lblError,  WebDriver driver) {myMediaPage.checkAlbumNameErrorPresent(lblError, driver);}

    @Step
    public void checkAlbumInListing(String albName, WebDriver driver) {myMediaPage.checkAlbumInListing(albName, driver);}

}


