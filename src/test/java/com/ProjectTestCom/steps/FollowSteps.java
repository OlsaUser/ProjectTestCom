package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.FollowUserPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

public class FollowSteps {

    FollowUserPage followUserPage;

    /*@Step
    public void pressFollow_ViewProfile(WebDriver driver) { followUserPage.pressFollow_ViewProfile(driver);}

    @Step
    public void pressFollow_ViewItem(WebDriver driver) { followUserPage.pressFollow_ViewItem(driver);}*/

    @Step
    public void addToFollowing(String xpath, String name, WebDriver driver, String classBtn) { followUserPage.addToFollowing(xpath, name, driver, classBtn);}

    @Step
    public void openMyFollowingsPageAndCheck(WebDriver driver, String name ) { followUserPage.openMyFollowingsPageAndCheck(driver, name);}
}
