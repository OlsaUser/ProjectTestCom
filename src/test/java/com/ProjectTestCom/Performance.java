package com.ProjectTestCom;

import com.ProjectTestCom.steps.*;
import com.ProjectTestCom.utils.PropertyLoader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

/**
 * Created by olsa on 5/17/2016.
 */
@RunWith(SerenityRunner.class)
public class Performance {
    private String propertyFilePath = "src/test/resources/login.properties";
    //private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");
    private String ServiceListing = PropertyLoader.getProperty(propertyFilePath, "ServiceListing");
    private String ProductListing = PropertyLoader.getProperty(propertyFilePath, "ProductListing");
    private String EventListing = PropertyLoader.getProperty(propertyFilePath, "EventListing");
    private String PartnershipListing = PropertyLoader.getProperty(propertyFilePath, "PartnershipListing");
    private String MyServiceListing = PropertyLoader.getProperty(propertyFilePath, "MyServiceListing");
    private String MyProductListing = PropertyLoader.getProperty(propertyFilePath, "MyProductListing");
    private String MyEventListing = PropertyLoader.getProperty(propertyFilePath, "MyEventListing");
    private String MyPartnershipListing = PropertyLoader.getProperty(propertyFilePath, "MyPartnershipListing");
    private String MyMedia = PropertyLoader.getProperty(propertyFilePath, "MyMedia");
    private String ViewAlbum = PropertyLoader.getProperty(propertyFilePath, "ViewAlbum");
    private String MyMnassa = PropertyLoader.getProperty(propertyFilePath, "MyMnassa");
    private String MyWall = PropertyLoader.getProperty(propertyFilePath, "MyWall");
    private String MyGroups = PropertyLoader.getProperty(propertyFilePath, "MyGroups");
    private String Groups = PropertyLoader.getProperty(propertyFilePath, "Groups");
    private String MyGroupWall = PropertyLoader.getProperty(propertyFilePath, "MyGroupWall");
    private String DiscoverPage = PropertyLoader.getProperty(propertyFilePath, "DiscoverPage");
    private String urlUserProfile_Perform = PropertyLoader.getProperty(propertyFilePath, "urlUserProfile_Perform");
    private String urlItem = PropertyLoader.getProperty(propertyFilePath, "urlItem");
    private String urlGroupPage = PropertyLoader.getProperty(propertyFilePath, "urlGroupPage");
    private String viewItem = PropertyLoader.getProperty(propertyFilePath, "viewItem");

    private String DiscoverUserActive = PropertyLoader.getProperty(propertyFilePath, "DiscoverUserActive");
    private String DiscoverUserNew = PropertyLoader.getProperty(propertyFilePath, "DiscoverUserNew");
    private String DiscoverUserPopular = PropertyLoader.getProperty(propertyFilePath, "DiscoverUserPopular");
    private String DiscoverItemPopular = PropertyLoader.getProperty(propertyFilePath, "DiscoverItemPopular");
    private String DiscoverItemNew = PropertyLoader.getProperty(propertyFilePath, "DiscoverItemNew");
    private String DiscoverPostPopular = PropertyLoader.getProperty(propertyFilePath, "DiscoverPostPopular");
    private String DiscoverPostNew = PropertyLoader.getProperty(propertyFilePath, "DiscoverPostNew");
    private String DiscoverGroupsPopular = PropertyLoader.getProperty(propertyFilePath, "DiscoverGroupsPopular");
    private String DiscoverGroupsNew = PropertyLoader.getProperty(propertyFilePath, "DiscoverGroupsNew");

    private String HomePage = PropertyLoader.getProperty(propertyFilePath, "HomePage");
    private String NotificationPage = PropertyLoader.getProperty(propertyFilePath, "NotificationPage");
    private String AccountSettings = PropertyLoader.getProperty(propertyFilePath, "AccountSettings");
    private String Message = PropertyLoader.getProperty(propertyFilePath, "Message");
    private String MyFollowers = PropertyLoader.getProperty(propertyFilePath, "MyFollowers");
    private String MyFollowings = PropertyLoader.getProperty(propertyFilePath, "MyFollowings");
    private String viewAccountSettings = PropertyLoader.getProperty(propertyFilePath, "viewAccountSettings");
    private String Login = PropertyLoader.getProperty(propertyFilePath, "Login");
    private String AddItem = PropertyLoader.getProperty(propertyFilePath, "AddItem");
    private String openUserWallPage = PropertyLoader.getProperty(propertyFilePath, "openUserWallPage");
    private String openUserProductListing = PropertyLoader.getProperty(propertyFilePath, "openUserProductListing");
    private String openUserServiceListing = PropertyLoader.getProperty(propertyFilePath, "openUserServiceListing");
    private String openUserEventListing = PropertyLoader.getProperty(propertyFilePath, "openUserEventListing");

    private String openUserGroupListing = PropertyLoader.getProperty(propertyFilePath, "openUserGroupListing");
    private String openUserPartnershipListing = PropertyLoader.getProperty(propertyFilePath, "openUserPartnershipListing");
    private String openUserMediaPage = PropertyLoader.getProperty(propertyFilePath, "openUserMediaPage");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    HeaderSteps headerSteps;

    @Before
    public void setup() throws IOException {
        FirefoxProfile myProfile = new FirefoxProfile(new File("D:/SeleniumProfile"));
        myProfile.setPreference("network.proxy.socks_port", 9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);

        loginSteps.openLoginPage();
        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void PerformanceTest() throws IOException {
        loginSteps.pageLoad(Login);

        headerSteps.openProductListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(ProductListing);

        headerSteps.openEventListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(EventListing);

        headerSteps.openPartnershipListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(PartnershipListing);

        headerSteps.openServiceListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(ServiceListing);

        headerSteps.openMessagePage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(Message);

        headerSteps.openNotificationPage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(NotificationPage);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(HomePage);


        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverItemNew);

        headerSteps.openDiscoverItemPopular(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverItemNew(driver);
        loginSteps.PageComplete(driver);


        headerSteps.openDiscoverPostNew(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverPostNew);

        headerSteps.openDiscoverPostTrending(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPostPopular(driver);
        loginSteps.PageComplete(driver);
        // loginSteps.pageLoad(DiscoverPostPopular);


        headerSteps.openDiscoverUserPopular(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverUserPopular);

        headerSteps.openDiscoverUserActive(driver);
        loginSteps.PageComplete(driver);
        // loginSteps.pageLoad(DiscoverUserActive);

        headerSteps.openDiscoverUserNew(driver);
        loginSteps.PageComplete(driver);
        //loginSteps.pageLoad(DiscoverUserNew)


        headerSteps.openDiscoverGroupsPopular(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverGroupsPopular);

        headerSteps.openDiscoverGroupsNew(driver);
        loginSteps.PageComplete(driver);
        //loginSteps.pageLoad(DiscoverGroupsNew);


        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(AccountSettings);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyMnassa);

        headerSteps.openMyMedia(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyMedia);

        headerSteps.openMyWall(driver);
        loginSteps.pageLoad(MyWall);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyGroups);

        headerSteps.MyGroupWall(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyGroups);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
        //loginSteps.PageComplete(driver);

        headerSteps.openMyServiceListing(driver);
        loginSteps.pageLoad(MyServiceListing);

        headerSteps.openMyProductListing(driver);
        loginSteps.pageLoad(MyProductListing);

        headerSteps.openMyEventListing(driver);
        loginSteps.pageLoad(MyEventListing);

        headerSteps.openMyPartnershipListing(driver);
        loginSteps.pageLoad(MyPartnershipListing);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);

//User Info page
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(viewAccountSettings);

        driver.get(urlUserProfile_Perform);
        headerSteps.openUserWallPage(driver);
        headerSteps.openUserProductListing(driver);
        headerSteps.openUserServiceListing(driver);
        headerSteps.openUserEventListing(driver);
        headerSteps.openUserGroupListing(driver);
        headerSteps.openUserPartnershipListing(driver);
        headerSteps.openUserMediaPage(driver);

        headerSteps.openMyFollowers(driver);
        loginSteps.pageLoad(MyFollowers);

        headerSteps.openMyFollowings(driver);
        loginSteps.pageLoad(MyFollowings);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openGroupsListing(driver);
        loginSteps.pageLoad(Groups);

        driver.get(urlItem);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(viewItem);

        //loginSteps.Sleep(100);
        driver.get(urlGroupPage);
        driver.navigate().refresh();
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyGroupWall);
    }
}

        /*****************************************/

      /*  headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openProductListing(driver);
        loginSteps.pageLoad(ProductListing);

        headerSteps.openEventListing(driver);
        loginSteps.pageLoad(EventListing);

        headerSteps.openPartnershipListing(driver);
        loginSteps.pageLoad(PartnershipListing);

        headerSteps.openServiceListing(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(ServiceListing);

        headerSteps.openMessagePage(driver);
        loginSteps.pageLoad(Message);

        headerSteps.openNotificationPage(driver);
        loginSteps.pageLoad(NotificationPage);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(HomePage);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverItemNew);

        headerSteps.openDiscoverItemPopular(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverItemNew(driver);
        loginSteps.PageComplete(driver);



        headerSteps.openDiscoverPostNew(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverPostNew);

        headerSteps.openDiscoverPostTrending(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openDiscoverPostPopular(driver);
        loginSteps.PageComplete(driver);
        // loginSteps.pageLoad(DiscoverPostPopular);



        headerSteps.openDiscoverUserPopular(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverUserPopular);

        headerSteps.openDiscoverUserActive(driver);
        loginSteps.PageComplete(driver);
        // loginSteps.pageLoad(DiscoverUserActive);

        headerSteps.openDiscoverUserNew(driver);
        loginSteps.PageComplete(driver);
        //loginSteps.pageLoad(DiscoverUserNew)



        headerSteps.openDiscoverGroupsPopular(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(DiscoverGroupsPopular);

        headerSteps.openDiscoverGroupsNew(driver);
        loginSteps.PageComplete(driver);
        //loginSteps.pageLoad(DiscoverGroupsNew);


        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(AccountSettings);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyMnassa);

        headerSteps.openMyMedia(driver);
        loginSteps.pageLoad(MyMedia);

        headerSteps.openMyWall(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(MyWall);

        headerSteps.openMyGroupsListing(driver);
        loginSteps.pageLoad(MyGroups);

        headerSteps.MyGroupWall(driver);
        loginSteps.pageLoad(MyGroupWall);

        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openMyServiceListing(driver);
        loginSteps.pageLoad(MyServiceListing);

        headerSteps.openMyProductListing(driver);
        loginSteps.pageLoad(MyProductListing);

        headerSteps.openMyEventListing(driver);
        loginSteps.pageLoad(MyEventListing);

        headerSteps.openMyPartnershipListing(driver);
        loginSteps.pageLoad(MyPartnershipListing);

        headerSteps.openDiscoverPage(driver);
        loginSteps.PageComplete(driver);

//User Info page
        headerSteps.viewAccountSettings(driver);
        loginSteps.PageComplete(driver);
        loginSteps.pageLoad(viewAccountSettings);

        driver.get(urlUserProfile_Perform);


        headerSteps.openMyFollowers(driver);
        loginSteps.pageLoad(MyFollowers);

        headerSteps.openMyFollowings(driver);
        loginSteps.pageLoad(MyFollowings);

        headerSteps.openHomePage(driver);
        loginSteps.PageComplete(driver);

        headerSteps.openGroupsListing(driver);
        loginSteps.pageLoad(Groups);
    }
}*/
/*
   @Test
    public void MyMnassa() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        loginSteps.pageLoad(MyMnassa);
    }

    @Test
    public void MyServiceListing() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyServiceListing(driver);
        loginSteps.pageLoad(MyServiceListing);
    }

    @Test
    public void MyProductListing() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyProductListing(driver);
        loginSteps.pageLoad(MyProductListing);
    }

    @Test
    public void MyEventListing() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyEventListing(driver);
        loginSteps.pageLoad(MyEventListing);
    }

    @Test
    public void MyPartnershipListing() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyPartnershipListing(driver);
        loginSteps.pageLoad(MyPartnershipListing);
    }

    @Test
    public void MyMedia() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyMedia(driver);
        loginSteps.pageLoad(MyMedia);
    }
    @Test
    public void MyWall() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyMedia(driver);
        headerSteps.openMyWall(driver);
        loginSteps.pageLoad(MyWall);
    }
    @Test
    public void MyGroups() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        loginSteps.pageLoad(MyGroups);
    }
    @Test
    public void MyGroupWall() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        headerSteps.MyGroupWall(driver);
        loginSteps.pageLoad(MyGroupWall);
    }

    @Test
    public void Groups() throws IOException {
        headerSteps.openGroupsListing(driver);
        loginSteps.pageLoad(Groups);
    }

    @Test
    public void Message() throws IOException {
        headerSteps.openMessagePage(driver);
        loginSteps.pageLoad(Message);
    }

    @Test
    public void DiscoverPage() throws IOException {
        headerSteps.openDiscoverPage(driver);
        loginSteps.pageLoad(DiscoverPage);
    }

    @Test
    public void HomePage() throws IOException {
        headerSteps.openDiscoverPage(driver);
        headerSteps.openHomePage(driver);
        loginSteps.pageLoad(HomePage);
    }

    @Test
    public void NotificationPage() throws IOException {
        headerSteps.openNotificationPage(driver);
        loginSteps.pageLoad(NotificationPage);
    }

    @Test
    public void AccountSettings() throws IOException {
        headerSteps.openMenuProfile(driver);
        headerSteps.openAccountSettings(driver);
        loginSteps.pageLoad(AccountSettings);
    }

    @Test
    public void ProductListing() throws IOException {
        headerSteps.openProductListing(driver);
        loginSteps.pageLoad(ProductListing);
    }

    @Test
    public void ServiceListing() throws IOException {
        headerSteps.openServiceListing(driver);
        loginSteps.pageLoad(ServiceListing);
    }

    @Test
    public void EventListing() throws IOException {
        headerSteps.openEventListing(driver);
        loginSteps.pageLoad(EventListing);
    }

    @Test
    public void PartnershipListing() throws IOException {
        headerSteps.openPartnershipListing(driver);
        loginSteps.pageLoad(PartnershipListing);
    }

    @Test
    public void MyFollowers() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyFollowers(driver);
        loginSteps.pageLoad(MyFollowers);
    }

    @Test
    public void MyFollowings() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyFollowings(driver);
        loginSteps.pageLoad(MyFollowings);
    }

    @Test
    public void viewAccountSettings() throws IOException {
        headerSteps.openMyMnassaPage(driver);
        headerSteps.viewAccountSettings(driver);
        loginSteps.pageLoad(viewAccountSettings);
    }
    @Test
    public void addServiceSupply_MAX() throws IOException{
        addItemSteps.openAddItemPage();
        loginSteps.Sleep(5000);
        addItemSteps.selectItemTypeService();
        addItemSteps.selectSupply();
        addItemSteps.enterBasicInfo(TitleMAX, DescriptionMAX);
        addItemSteps.collapseBasicInfo();
        addItemSteps.selectCategory1();
        addItemSteps.selectSubCategory2();
        addItemSteps.selectYearsOfExperienceMore();
        addItemSteps.enterPrice(PriceMAX, PerMAX);
        addItemSteps.selectAdvancedPayment100();
        addItemSteps.selectMethodVisa();
        addItemSteps.selectMethodMasterCard();
        addItemSteps.selectMethodPayPal();
        addItemSteps.selectMethodDebitCard();
        addItemSteps.selectMethodCash();
        addItemSteps.clickServiceOnline();
        addItemSteps.collapseMainDetails();
        addItemSteps.TextContent(textContentMAX);
        addItemSteps.VideoContent5(VideoContent5, VideoContent2, VideoContent3, VideoContent4, VideoContent1);
        loginSteps.Sleep(5000);
        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,-1000)", "");
        addItemSteps.AudioContent5(AudioContent1,AudioContent2, AudioContent3, AudioContent4, AudioContent5);
        jse1.executeScript("window.scrollBy(0,-450)", "");
        addItemSteps.LinksContent5(LinksContent1,LinksContent2, LinksContent3, LinksContent4, LinksContent5);
        addItemSteps.collapseContent();
        addItemSteps.ItemStatusDeactivate();
        addItemSteps.clickSave(driver);
        loginSteps.pageLoad(AddItem);
    }
    }*/
