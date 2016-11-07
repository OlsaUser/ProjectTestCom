package com.ProjectTestCom.pages;

import jline.internal.Log;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.parser.TokenType.OR;

/**
 * Created by olsa on 5/18/2016.
 */
//@DefaultUrl("http://synergy.devzone.dp.ua/en/#!login")
//@DefaultUrl("http://mnassa.com/en/#!login")
@RunWith(SerenityRunner.class)
public class HeaderPage extends PageObject {
    //First line Menu
    private final By linkMyMnassa = By.xpath("//div[@id='header-top-line']/div[1]/a[2]");
    private final By linkDiscover = By.xpath("//div[@id='header-top-line']/div[1]/a[3]");
    private final By linkDiscoverItems = By.xpath("//nav[@id='page-nav']//div[@class='nav-list-items']/a[1]");
    private final By linkDiscoverItemsPopular = By.xpath("//ul[@class='tabs-labels']/li[2]");
    private final By linkDiscoverItemsNew = By.xpath("//ul[@class='tabs-labels']/li[1]");
    //private final By linkDiscoverUsersNew = By.xpath("//ul[@class='tabs-labels']/li[3]");

    private final By linkDiscoverUsers = By.xpath("//nav[@id='page-nav']//div[@class='nav-list-items']/a[3]");
    private final By linkDiscoverUsersPopular = By.xpath("//ul[@class='tabs-labels']/li[1]");
    private final By linkDiscoverUsersActive = By.xpath("//ul[@class='tabs-labels']/li[2]");
    private final By linkDiscoverUsersNew = By.xpath("//ul[@class='tabs-labels']/li[3]");

    private final By linkDiscoverPosts = By.xpath("//nav[@id='page-nav']//div[@class='nav-list-items']/a[2]");
    private final By linkDiscoverPostsNew = By.xpath("//ul[@class='tabs-labels']/li[1]");
    private final By linkDiscoverPostsPopular = By.xpath("//ul[@class='tabs-labels']/li[3]");
    private final By linkDiscoverPostsTrending = By.xpath("//ul[@class='tabs-labels']/li[2]");

    //private final By linkDiscoverGroupPopular = By.xpath("//div[@class='nav-list -center']/a[4]");

    private final By linkDiscoverGroupPopular = By.xpath("//nav[@id='page-nav']//div[@class='nav-list-items']/a[4]");
    private final By linkDiscoverGroupNew = By.xpath("//ul[@class='tabs-labels']/li[2]");
    private final By DiscoverContentGroup = By.xpath("//div[@class='tabs-pane fade active in']");

    private final By buttonAdd = By.xpath(".//*[@id='header-top-line']/nav/div[1]/button");
    private final By iconHome = By.xpath("//a[@class='header-iconmenu-item']");
    private final By iconNotification = By.cssSelector("a[href*='#!activity']");
    private final By iconMessage = By.cssSelector("a[href*='cabinet#!threads']");
    private final By menuProfile = By.xpath("//div[@class='header-user']");
    private final By menuAccountSettings = By.xpath("//div[@class='header-user']/div[2]/a[2]");
    private final By menuFavorites = By.xpath("//div[@class='header-user']/div[2]/a[@href='http://mnassa.com/en/usernameondevzonebetalensy_tomson_1#!favorites']");

    //Second line Menu
    //private final By linkUserName = By.xpath("//div[@class='user-name']/a");
    //private final By linkFollowers = By.xpath("//div[@class='col-sm-6']//li[1]/a");
    //private final By linkFollowings = By.xpath("//div[@class='col-sm-6']//li[2]/a");
    private final By linkUserName = By.xpath("//h3[@class='header-info-name']/a/span[1]");
    private final By linkFollowers = By.xpath("//div[@class='header-info-followers']/div[2]/a");
    private final By linkFollowings = By.xpath("//div[@class='header-info-followers']/div[1]/a");

    //Third line Menu
    /*private final By linkProduct = By.xpath("//div[@class='nav-list']/a[2]/span");
    private final By linkService = By.xpath("//div[@class='nav-list']/a[3]/span");
    private final By linkEvent = By.xpath("//div[@class='nav-list']/a[4]/span");
    private final By linkGroups = By.xpath("//div[@class='nav-list']/a[5]/span");
    private final By linkPartnership = By.xpath("//div[@class='nav-list']/a[6]/span");
    private final By GroupWall = By.xpath("//div[@class='group-item']");
    private final By linkOwner = By.xpath("//span[@class='group-item-owner']");*/

    private final By linkProduct = By.xpath("//div[@class='nav-list-items']/a[2]/span");
    private final By linkService = By.xpath("//div[@class='nav-list-items']/a[3]/span");
    private final By linkEvent = By.xpath("//div[@class='nav-list-items']/a[4]/span");
    private final By linkGroups = By.xpath("//div[@class='nav-list-items']/a[5]/span");
    private final By linkPartnership = By.xpath("//div[@class='nav-list-items']/a[6]/span");
    private final By GroupWall = By.cssSelector("a[href*='#!group/name']");
    private final By linkOwner = By.xpath("//span[@class='group-item-owner']");

    //Third line Menu (My profile)
    //private final By linkMyWall = By.xpath("//div[@class='nav-list']/a[2]/span");
   /* private final By linkMyWall = By.xpath("//div[@class='nav-list']/a[2]/span");
    private final By MyProductListing = By.xpath("//div[@class='nav-list']/a[3]/span");
    private final By MyServiceListing = By.xpath("//div[@class='nav-list']/a[4]/span");
    private final By MyEventListing = By.xpath("//div[@class='nav-list']/a[5]/span");
    private final By linkMyGroups = By.xpath("//div[@class='nav-list']/a[6]/span");
    private final By MyPartnershipListing = By.xpath("//div[@class='nav-list']/a[7]/span");
    private final By linkMyMedia = By.xpath("//div[@class='nav-list']/a[8]/span");*/

    private final By linkMyWall = By.xpath("//div[@class='nav-list-items']/a[2]/span");
    private final By MyProductListing = By.xpath("//div[@class='nav-list-items']/a[3]/span");
    private final By MyServiceListing = By.xpath("//div[@class='nav-list-items']/a[4]/span");
    private final By MyEventListing = By.xpath("//div[@class='nav-list-items']/a[5]/span");
    private final By linkMyGroups = By.xpath("//div[@class='nav-list-items']/a[6]/span");
    private final By MyPartnershipListing = By.xpath("//div[@class='nav-list-items']/a[7]/span");
    private final By linkMyMedia = By.xpath("//div[@class='nav-list-items']/a[8]/span");
    //Third line Menu (User Profile)
    private final By linkUserWall = By.xpath("//div[@class='nav-list-items']/a[2]");
    private final By UserProductListing = By.xpath("//div[@class='nav-list-items']/a[3]");
    private final By UserServiceListing = By.xpath("//div[@class='nav-list-items']/a[4]");
    private final By UserEventListing = By.xpath("//div[@class='nav-list-items']/a[5]");
    private final By linkUserGroups = By.xpath("//div[@class='nav-list-items']/a[6]");
    private final By UserPartnershipListing = By.xpath("//div[@class='nav-list-items']/a[7]");
    private final By linkUserMedia = By.xpath("//div[@class='nav-list-items']/a[8]");

    /*private final By linkUserWall = By.xpath("//div[@class='nav-list']/a[2]");
    private final By UserProductListing = By.xpath("//div[@class='nav-list']/a[3]");
    private final By UserServiceListing = By.xpath("//div[@class='nav-list']/a[4]");
    private final By UserEventListing = By.xpath("//div[@class='nav-list']/a[5]");
    private final By linkUserGroups = By.xpath("//div[@class='nav-list']/a[6]");
    private final By UserPartnershipListing = By.xpath("//div[@class='nav-list']/a[7]");
    private final By linkUserMedia = By.xpath("//div[@class='nav-list']/a[8]");*/

    //Visible elements
    private final By DiscoverContentPost = By.xpath("//div[@class='row']/div[1]");
    private final By DiscoverContentUser = By.xpath("//div[@class='user-thumbnail-username text-overflow']");
    private final By DiscoverContentItem = By.xpath("//div[@class='tabs-content']");
    private final By Loader = By.xpath("//div[@class='feed-preloader js-feed-preloader show']");

    private final By MyMnassaContent = By.xpath("//div[@class='feed container']");
    //private final By MessageContent = By.xpath("//section[@id='cabinet_sect']/cabinet/section/div[2]/div/div[1]/div[1]/a");
    private final By MessageContent = By.xpath("//div[@class='im-content container']");
    private final By HomeContent = By.xpath("//div[@class='feed-list js-feed-list']");
    private final By NotificationContent = By.xpath("//section[@id='community_sect']");
    private final By ProfileContent = By.xpath("//section[@id='cabinet_sect']");
    //private final By GroupContent = By.xpath("//div[@class='gallery-list']");
    private final By GroupContent = By.xpath("//div[@class='gallery-list']/div");
    private final By ItemContent = By.xpath("//div[@class='itemslist-wrapper']");
    private final By FollowerContent = By.xpath("//section[@class='users-list']");
    private final By FollowingContent = By.xpath("//section[@class='users-list']");
    private final By WallContent = By.xpath("//div[@class='feed container']");
    private final By MediaContent = By.xpath("//div[@class='gallery-list']");
    private final By ViewUserContent = By.xpath("//section[@id='user_sect']");
    private final By GroupWallContent = By.xpath("//div[@class='feed-head']");
    private final By UserWallContent = By.xpath("//div[@class='feed-head']");

    private final By UserBlocks = By.xpath("//div[@class='col-sm-6 col-md-4 col-lg-3 fade in']");
    private final By UserAvatars = By.xpath("//a[@class='user-thumbnail-avatar img-circle']");
    private final By UserUserName = By.xpath("//div[@class='user-thumbnail-username text-overflow']");
    private final By UserAddress = By.xpath("//address[@class='user-thumbnail-address text-overflow']");
    private final By UserBriefInfo = By.xpath("//div[@class='user-thumbnail-brief-info']");
    private final By UserFollowButton = By.xpath("//button[@can-click='handle_follower_all']");
    private final By UserItems = By.xpath("//div[@class='table-block-xxs']/div[1]");
    private final By UserFollowings = By.xpath("//div[@class='table-block-xxs']/div[2]");
    private final By UserFollowers = By.xpath("//div[@class='table-block-xxs']/div[3]");

    private final By FeedTime = By.xpath("//div[@class='feed-time']");
    private final By postHeader = By.xpath("//div[@class='user-descr']");
    private final By userAvatar = By.xpath("//a[@class='user-photo']");
    private final By postContentMedia = By.xpath("//a[@class='feed-content-link']");
    private final By handleLike = By.xpath("//span[@can-click='handle_like']");
    private final By handleComments = By.xpath("//span[@can-click='comments_toggle']");
    private final By iconShare = By.xpath("//div[@class='feed-share']");
    private final By handleCommentsReply_all = By.xpath("//span[@can-click='comments_reply_all']");
    private final By postContent = By.xpath("//div[@class='feed-content']");

    private final By GroupItem = By.xpath("//div[@class='group-item']");
    private final By handleFollow = By.xpath("//button[@can-click='dsc_handle_follow']");
    private final By groupInfoValuePosts = By.xpath("//div[@class='group-item-info']/div[1]/span[@class='group-item-info-value']");
    private final By groupInfoLabelPosts = By.xpath("//div[@class='group-item-info']/div[1]/span[@class='group-item-info-label']");
    private final By groupInfoValueMembers = By.xpath("//div[@class='group-item-info']/div[2]/span[@class='group-item-info-value']");
    private final By groupInfoLabelMembers = By.xpath("//div[@class='group-item-info']/div[2]/span[@class='group-item-info-label']");

    private final By Counter = By.xpath("//span[@class='wall-post-length']");
    private final By PlaceHolderNewsFeed = By.xpath("//textarea[@placeholder='Write something here. Use @ to mention any of your Followings/Followers']");
    private final By PlaceHolderWall = By.xpath("//textarea[@placeholder='Write something here, add media, mention @Users in post']");
    private final By DiscoverUserActiveListing = By.xpath("//div[@class='tabs-pane fade active in']");

    //inappropriate user form
    private final By FreePointMenuProfile = By.xpath("//div[@class='header-info-dropdown']");
    private final By iconInappropriate = By.xpath("//a[@id='report_submit_btn']");
    private final By Spam = By.xpath("//input[@value='Spam or fraud']");
    private final By Outdated = By.xpath("//input[@value='Outdated']");
    private final By Inaccurate = By.xpath("//input[@value='Inaccurate']");
    private final By FormTitle =By.xpath("//h4[contains(text(),'Report inappropriate form')]");



    public void openMyMnassaPage(WebDriver driver) {
       /* if(!find(linkMyMnassa).isCurrentlyEnabled())
            find(linkMyMnassa).waitUntilEnabled();
            find(linkMyMnassa).click();
            find(MyMnassaContent).waitUntilVisible();*/

        WebDriverWait wt = new WebDriverWait (driver, 300);
        wt.until(ExpectedConditions.elementToBeClickable(linkMyMnassa));
        /*wt.until(ExpectedConditions.presenceOfElementLocated(MyMnassaContent));
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkMyMnassa));
        wt.until(ExpectedConditions.visibilityOfElementLocated(linkMyMnassa));
        wt.until(ExpectedConditions.elementToBeClickable(linkMyMnassa));*/
        find(linkMyMnassa).click();
        wt.until(ExpectedConditions.presenceOfElementLocated(MyMnassaContent));
    }

    public void openDiscoverPage (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        find(linkDiscover).waitUntilPresent();
        wt.until(ExpectedConditions.elementToBeClickable(linkDiscover));
        find(linkDiscover).click();
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentItem));
    }

    public void openDiscoverUserActive (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
       // wt.until(ExpectedConditions.presenceOfElementLocated(linkDiscoverUsersActive));
        find(linkDiscoverUsersActive).click();

        wt.until(ExpectedConditions.visibilityOfElementLocated(DiscoverContentUser));
    }

    public void openDiscoverUserNew (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 180);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkDiscoverUsersNew));
        find(linkDiscoverUsersNew).click();
        WebElement el = driver.findElement (DiscoverContentUser);
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentUser));
    }
    public void openDiscoverUserPopular (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkDiscover));
        find(linkDiscoverUsers).click();
        wt.until(ExpectedConditions.presenceOfElementLocated(linkDiscoverUsersPopular));
        find(linkDiscoverUsersPopular).click();
        driver.manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentUser));
    }
    public void openDiscoverItemPopular (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 250);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkDiscover));
        find(linkDiscoverItems).click();
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentItem));
        find(linkDiscoverItemsPopular).isPresent();
        find(linkDiscoverItemsPopular).click();
        wt.until(ExpectedConditions.presenceOfElementLocated(DiscoverContentItem));
        wt.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(DiscoverContentItem)));
    }
    public void openDiscoverItemNew (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.visibilityOfElementLocated(linkDiscover));
        find(linkDiscoverItems).click();
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentItem));
        find(linkDiscoverItemsNew).click();
        driver.manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentItem));
    }
    public void openDiscoverPostPopular (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkDiscover));
        find(linkDiscoverPosts).click();
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentPost));
        find(linkDiscoverPostsPopular).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(DiscoverContentPost));
        wt.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(DiscoverContentPost)));
    }
    public void openDiscoverPostNew (WebDriver driver) {
        //wt.until(ExpectedConditions.visibilityOfElementLocated(linkDiscoverPosts));
        find(linkDiscoverPosts).click();
        //wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentPost));
        //find(linkDiscoverPostsNew).click();
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.visibilityOfElementLocated(DiscoverContentPost));
    }
    public void openDiscoverPostTrending (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkDiscover));
        find(linkDiscoverPosts).click();
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentPost));
        find(linkDiscoverPostsTrending).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(DiscoverContentPost));
        wt.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(DiscoverContentPost)));
    }

    public void openDiscoverGroupsPopular (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkDiscover));
        find(linkDiscoverGroupPopular).click();
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentGroup));
        find(linkDiscoverGroupPopular).click();
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentGroup));
    }

    public void openDiscoverGroupsNew (WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkDiscover));
        find(linkDiscoverGroupPopular).click();
        wt.until(ExpectedConditions.elementToBeClickable(DiscoverContentGroup));
        find(linkDiscoverGroupNew).click();
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
        wt.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(DiscoverContentGroup)));
    }

    public void openMessagePage(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.presenceOfElementLocated(iconMessage));
        find(iconMessage).click();
        wt.until(ExpectedConditions.elementToBeClickable(MessageContent));
    }

    public void openHomePage(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.elementToBeClickable(iconHome));
        find(iconHome).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(HomeContent));
        wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
    }

    public void openNotificationPage(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.elementToBeClickable(iconNotification));
        find(iconNotification).click();
        //driver.manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        wt.until(ExpectedConditions.visibilityOfElementLocated(NotificationContent));
    }

    public void openMenuProfile(WebDriver driver ) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(menuProfile));
        find(menuProfile).click();
    }

    public void openAccountSettings(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 150);
       // wt.until(ExpectedConditions.presenceOfElementLocated(menuAccountSettings));
       // wt.until(ExpectedConditions.visibilityOfElementLocated(menuAccountSettings));
        wt.until(ExpectedConditions.elementToBeClickable(menuAccountSettings));
        find(menuAccountSettings).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(ProfileContent));
    }

    public void openGroupsListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkGroups));
        wt.until(ExpectedConditions.visibilityOfElementLocated(linkGroups));
        wt.until(ExpectedConditions.elementToBeClickable(linkGroups));
        find(linkGroups).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(GroupContent));
    }
    public void MyGroupWall(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(GroupWall));
       // wt.until(ExpectedConditions.textToBePresentInElementLocated(linkOwner,"Owner"));
        find(GroupWall).click();
        //wt.until(ExpectedConditions.visibilityOfElementLocated(GroupWallContent));
        wt.until(ExpectedConditions.visibilityOfElementLocated(PlaceHolderWall));
    }

    public void openProductListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkProduct));
        find(linkProduct).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(ItemContent));
    }

    public void openServiceListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkService));
        //wt.until(ExpectedConditions.visibilityOfElementLocated(linkService));
        //wt.until(ExpectedConditions.elementToBeClickable(linkService));
        //WebElement el = driver.findElement(linkService);
        find(linkService).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(ItemContent));
    }

    public void openEventListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkEvent));
        //driver.manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        //WebElement el = driver.findElement(linkEvent);
      //  wt.until(ExpectedConditions.visibilityOfElementLocated(linkEvent));
        find(linkEvent).click();
      //  WebDriverWait wt = new WebDriverWait (driver, 500);
        wt.until(ExpectedConditions.visibilityOfElementLocated(ItemContent));
    }

    public void openPartnershipListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkPartnership));
        //driver.manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        //WebElement el = driver.findElement(linkPartnership);
        find(linkPartnership).click();
     //  WebDriverWait wt = new WebDriverWait (driver, 500);
       // wt.until(ExpectedConditions.presenceOfElementLocated(linkPartnership));
      //  find(linkPartnership).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(ItemContent));
    }

    public void openMyFollowers(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkFollowers));
        find(linkFollowers).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(FollowerContent));
    }

    public void openMyFollowings(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkFollowings));
        find(linkFollowings).click();
        wt.until(ExpectedConditions.elementToBeClickable(FollowingContent));
    }

    public void viewAccountSettings(WebDriver driver) {
        find(linkUserName).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.elementToBeClickable(ViewUserContent));
    }

    public void openMyWall(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkMyWall));
        find(linkMyWall).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(WallContent));
        wt.until(ExpectedConditions.visibilityOfElementLocated(PlaceHolderWall));
    }

    public void openMyProductListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.presenceOfElementLocated(MyProductListing));
        find(MyProductListing).click();
        wt.until(ExpectedConditions.elementToBeClickable(ItemContent));
    }

    public void openMyServiceListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.presenceOfElementLocated(MyServiceListing));
        //WebElement el = find(MyServiceListing);
        find(MyServiceListing).click();
        wt.until(ExpectedConditions.elementToBeClickable(ItemContent));
    }

    public void openMyEventListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.presenceOfElementLocated(MyEventListing));
        find(MyEventListing).click();
        wt.until(ExpectedConditions.elementToBeClickable(ItemContent));
    }

    public void openMyGroupsListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkMyGroups));
        find(linkMyGroups).click();
        wt.until(ExpectedConditions.elementToBeClickable(GroupContent));
    }

    public void openMyPartnershipListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.presenceOfElementLocated(MyPartnershipListing));
        find(MyPartnershipListing).click();
        wt.until(ExpectedConditions.elementToBeClickable(ItemContent));
    }

    public void openMyMedia(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkMyMedia));
        find(linkMyMedia).click();
        wt.until(ExpectedConditions.elementToBeClickable(MediaContent));
    }

//User Info Page
    public void openUserWallPage(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkUserWall));
        find(linkUserWall).click();
        wt.until(ExpectedConditions.elementToBeClickable(UserWallContent));
    }
    public void openUserProductListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(UserProductListing));
        find(UserProductListing).click();
        wt.until(ExpectedConditions.elementToBeClickable(ItemContent));
    }
    public void openUserServiceListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(UserServiceListing));
        find(UserServiceListing).click();
        wt.until(ExpectedConditions.elementToBeClickable(ItemContent));
    }
    public void openUserEventListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(UserEventListing));
        find(UserEventListing).click();
        wt.until(ExpectedConditions.elementToBeClickable(ItemContent));
    }
    public void openUserGroupListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkUserGroups));
        find(linkUserGroups).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(GroupContent));
    }
    public void openUserPartnershipListing(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(UserPartnershipListing));
        find(UserPartnershipListing).click();
        wt.until(ExpectedConditions.elementToBeClickable(ItemContent));
    }
    public void openUserMediaPage(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkUserMedia));
        find(linkUserMedia).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(MediaContent));
    }
    public void viewUserListing_Discover(WebDriver driver) {
        find(UserBlocks);
        find(UserAvatars);
        find(UserUserName);
        find(UserAddress);
        find(UserBriefInfo);
        find(UserFollowButton);
        find(UserItems);
        find(UserFollowings);
        find(UserFollowers);
    }

    public void viewPost_Discover(WebDriver driver) {
        find(FeedTime);
        find(postHeader);
        find(userAvatar);
        find(postContent);
        find(postContentMedia);
        find(handleComments);
        //find(iconShare);
        find(handleCommentsReply_all);
    }

    public void viewGroup_Discover(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 50);

        find(GroupItem);
        find(handleFollow);

        find(groupInfoValuePosts);
        find(groupInfoLabelPosts);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(groupInfoLabelPosts,"Posts"));

        find(groupInfoValueMembers);
        find(groupInfoLabelMembers);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(groupInfoLabelMembers,"Member"));
    }

    public void checkInappropriateForm(WebDriver driver) {
        find(Spam);
        find(Outdated);
        find(Inaccurate);
        find(FormTitle);
    }

    public void pressMenuProfile() {
        find(FreePointMenuProfile).click();
    }

    public void pressIconInappropriate() {
        find(iconInappropriate).click();
    }
}
