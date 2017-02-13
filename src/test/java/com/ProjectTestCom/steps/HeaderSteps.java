package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.HeaderPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

/**
 * Created by olsa on 5/18/2016.
 */
public class HeaderSteps {

    HeaderPage headerPage;

    @Step
    public void openMyMnassaPage(WebDriver driver) { headerPage.openMyMnassaPage(driver);}

    @Step
    public void clickLogo( ) { headerPage.clickLogo();}

    @Step
    public void openDiscoverPage(WebDriver driver) { headerPage.openDiscoverPage(driver);}

    @Step
    public void openDiscoverUserActive(WebDriver driver) { headerPage.openDiscoverUserActive(driver);}

    @Step
    public void openDiscoverUserNew(WebDriver driver) { headerPage.openDiscoverUserNew(driver);}

    @Step
    public void openDiscoverUserPopular(WebDriver driver) { headerPage.openDiscoverUserPopular(driver);}

    @Step
    public void openDiscoverItemPopular(WebDriver driver) { headerPage.openDiscoverItemPopular(driver);}

    @Step
    public void openDiscoverItemNew(WebDriver driver) { headerPage.openDiscoverItemNew(driver);}

    @Step
    public void openDiscoverPostPopular(WebDriver driver) { headerPage.openDiscoverPostPopular(driver);}

    @Step
    public void openDiscoverPostNew(WebDriver driver) { headerPage.openDiscoverPostNew(driver);}

    @Step
    public void openDiscoverPostTrending(WebDriver driver) { headerPage.openDiscoverPostTrending(driver);}

    @Step
    public void openDiscoverGroupsPopular(WebDriver driver) { headerPage.openDiscoverGroupsPopular(driver);}

    @Step
    public void openDiscoverGroupsNew(WebDriver driver) { headerPage.openDiscoverGroupsNew(driver);}

    @Step
    public void openHomePage(WebDriver driver) { headerPage.openHomePage(driver);}

    @Step
    public void openViewItemPage(String url) { headerPage.openViewItemPage(url);}

    @Step
    public void openViewUserInfoPage(String url) { headerPage.openViewUserInfoPage(url);}

    @Step
    public void openViewGroupPage(String url) { headerPage.openViewGroupPage(url);}

    @Step
    public void openMessagePage(WebDriver driver) { headerPage.openMessagePage(driver);}

    @Step
    public void openNotificationPage(WebDriver driver) { headerPage.openNotificationPage(driver);}

    @Step
    public void openMenuProfile(WebDriver driver ) { headerPage.openMenuProfile(driver);}

    @Step
    public void openAccountSettings(WebDriver driver) { headerPage.openAccountSettings(driver);}

    @Step
    public void openGroupsListing(WebDriver driver) { headerPage.openGroupsListing(driver);}

    @Step
    public void openProductListing(WebDriver driver) { headerPage.openProductListing(driver);}

    @Step
    public void openServiceListing(WebDriver driver) { headerPage.openServiceListing(driver);}

    @Step
    public void openEventListing(WebDriver driver) { headerPage.openEventListing(driver);}

    @Step
    public void openPartnershipListing(WebDriver driver) { headerPage.openPartnershipListing(driver);}

    @Step
    public void openMyFollowers(WebDriver driver) { headerPage.openMyFollowers(driver);}

    @Step
    public void openMyFollowings(WebDriver driver) { headerPage.openMyFollowings(driver);}

    @Step
    public void openMyMedia(WebDriver driver) { headerPage.openMyMedia(driver);}

    @Step
    public void viewAccountSettings(WebDriver driver) { headerPage.viewAccountSettings(driver);}

    @Step
    public void openMyPartnershipListing(WebDriver driver) { headerPage.openMyPartnershipListing(driver);}

    @Step
    public void openMyGroupsListing(WebDriver driver) { headerPage.openMyGroupsListing(driver);}

    @Step
    public void openMyEventListing(WebDriver driver) { headerPage.openMyEventListing(driver);}

    @Step
    public void openMyServiceListing(WebDriver driver) { headerPage.openMyServiceListing(driver);}

    @Step
    public void openMyProductListing(WebDriver driver) { headerPage.openMyProductListing(driver);}

    @Step
    public void openMyWall(WebDriver driver) { headerPage.openMyWall(driver);}

    @Step
    public void MyGroupWall(WebDriver driver) { headerPage.MyGroupWall(driver);}

    @Step
    public void openUserWallPage(WebDriver driver) { headerPage.openUserWallPage(driver);}

    @Step
    public void openUserProductListing(WebDriver driver) { headerPage.openUserProductListing(driver);}

    @Step
    public void openUserServiceListing(WebDriver driver) { headerPage.openUserServiceListing(driver);}

    @Step
    public void openUserEventListing(WebDriver driver) { headerPage.openUserEventListing(driver);}

    @Step
    public void openUserGroupListing(WebDriver driver) { headerPage.openUserGroupListing(driver);}

    @Step
    public void openUserPartnershipListing(WebDriver driver) { headerPage.openUserPartnershipListing(driver);}

    @Step
    public void openUserMediaPage(WebDriver driver) { headerPage.openUserMediaPage(driver);}

    @Step
    public void viewUserListing_Discover(WebDriver driver) { headerPage.viewUserListing_Discover(driver);}

    @Step
    public void viewPost_Discover(WebDriver driver) { headerPage.viewPost_Discover(driver);}

    @Step
    public void viewGroup_Discover(WebDriver driver) { headerPage.viewGroup_Discover(driver);}

    @Step
    public void checkInappropriateForm(WebDriver driver) { headerPage.checkInappropriateForm(driver);}

    @Step
    public void pressMenuProfile( ) { headerPage.pressMenuProfile();}

    @Step
    public void pressIconInappropriate( ) { headerPage.pressIconInappropriate();}
}
