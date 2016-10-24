package com.ProjectTestCom.pages;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertNull;
import static org.openqa.grid.common.SeleniumProtocol.Selenium;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by olsa on 4/28/2016.
 */
//@DefaultUrl("http://synergy.devzone.dp.ua/en/#!login")
//@DefaultUrl("http://mnassa.com/en/#!login")
@RunWith(SerenityRunner.class)
public class AddPostPage extends PageObject {
    private final By iconHome = By.xpath("//div[@class='header-icons']//a[1]");
    private final By linkMyMnassa = By.xpath(".//*[@id='header-top-line']/nav/div[2]/a");
    private final By linkGroups = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']/li[4]");
    private final By linkMyGroups = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']/li[5]");

    private final By GroupWall = By.xpath("//div[@class='gallery-list']/div[1]/div[1]");
    private final By blockGroup = By.xpath("//div[@class='group-item']");
    private final By MyGroupWall = By.xpath("//div[@class='gallery-page-list']/div[@class='gallery-list']/div[1]");
    private final By linkMyWall = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']/li[1]");
    private final By fieldPost = By.xpath("//textarea[@can-input='count_post']");
    private final By txtCounter = By.xpath("//span[@class='wall-post-length']");
    private final By txtPost = By.xpath("//div[@class='wall-post-area-back js-text-back custom-dir-invert-child']");

    private final By iconVideo = By.xpath("//div[@class='wall-post-attaches']/div[2]");
    private final By icondAudio = By.xpath("//div[@class='wall-post-attaches']/div[3]");
    private final By fieldVideo = By.xpath("//div[@id='wall-post-video']//div[@class='wall-post-add-control']/input");
    private final By fieldAudio = By.xpath("//div[@id='wall-post-audio']//div[@class='wall-post-add-control']/input");
    private final By btnAddVideoPost = By.xpath("//div[@id='wall-post-video']//form[@class='wall-post-add-form']/button");
    private final By btnAddAudioPost = By.xpath("//div[@id='wall-post-audio']//form[@class='wall-post-add-form']/button");
    //private final By btnAddPost = By.xpath("//div[@class='wall-post-bottom']/div[2]/button");

    private final By btnPost =By.xpath("//div[@class='wall-post-controls']/button[@can-click='upd_post']");
   // private final By linkComment = By.xpath("//section[@id='user_sect']/user_app/div[1]/div/div/div[3]/div[1]/div[3]/div[1]/span/span[2]");
    private final By linkComment = By.xpath("//span[@can-click='comments_toggle']");
    private final By fieldComment = By.xpath("//div[@id='comment-post-text']/textarea");
    private final By btnPostComment = By.xpath("//div[@id='comment-post-text']/a");
    //private final By txtComment = By.xpath("//section[@id='user_sect']/user_app/div[1]/div/div/div[3]/section/ul/li[2]/div/div[2]/div[2]");
    private final By txtComment = By.xpath("//ul[@class='list-unstyled comments-list']/li[2]//div[@class='comment-body -div-force-ltr']");

    private final By btnDelete = By.xpath("//a[@can-click='del_comment']");
    private final By btnRightMenu = By.xpath("//div[@class='feed-share']/span");
    private final By btnDeletePost = By.xpath("//a[@can-click='del_post_modal']");
    private final By btnDeletePopup = By.xpath("//button[@id='btn-delete-img']");
    private final By RightMenu = By.xpath("//ul[@class='dropdown-three-dots -feed dropdown-menu']");
    //Visible elements
    //private final By PostText = By.xpath("//div[@class='feed-list js-feed-list']/div[1]/div[@class='feed-content']/div");
    private final By PostText = By.xpath("//div[@class='feed-content']/div");
    private final By PostTextNewsFeed = By.xpath("//div[@class='feed-content']/div");
    private final By VideoContent = By.xpath("//div[@class='feed-media-box -video']");
    private final By AudioContent = By.xpath("//div[@class='feed-media js-feed-media']");
    private final By Vidget = By.xpath("//div[@class='wall-post-media-box']");

    private final By mentionDropdown = By.id("mention-dropdown");
    private final By mentionUser = By.xpath("//div[@id='mention-dropdown']/div");

    //Repost elements
    private final By postMenu = By.xpath("//div[@class='feed-share']");
    private final By repostMenu = By.xpath("//div[@can-click='show_do_repost_popover']");

    private final By menuRepostToGroup = By.xpath("//a[@can-click='repost_to_group_modal']");
    private final By dropdownGroup = By.xpath("//div[@id='s2id_post_item_to_group_list']");
    private final By Group1 = By.xpath("//div[contains(text(),'Group Title 1')]");
    private final By buttonPostRepost = By.xpath("//button[@can-click='post_item_to_group']");
    private final By menuRepostToWall = By.xpath("//a[@can-click='post_item_to_wall']");
    private final By menuRepostRemove = By.xpath("//a[@can-click='del_post_modal']");
    private final By placeHolder_To = By.xpath("//div[@class='user-descr']");
    private final By RepostHeaderGroup = By.xpath("//div[@class='feed-head-reaction-text']");
    private final By textRepost = By.xpath("//div[@class='feed-content']/div");
    private final By counterRepost = By.xpath("//span[@data-target='#modal-likes-list']");

    //Pin post
    private final By menuPin = By.xpath("//a[@can-click='pin_modal']");
    private final By PinPlaceholder = By.xpath("//span[@class='post_pinned']");
    private final By UnPinPlaceholder = By.xpath("//span[@class='post_unpinned']");
    private final By linkViewNow = By.xpath("//a[@onclick='window.location.reload();return false;']");
    private final By iconPin = By.xpath("//div[@class='feed-head-icon pin_icon ']");

    public void openHomePage() {element(iconHome).click();}

    public void openMyMnassaPage() {element(linkMyMnassa).click();}

    public void openMyWallPage() {element(linkMyWall).click();}

    public void openMyGroupsPage() {element(linkMyGroups).click();}

    public void openMyGroupWall() {element(MyGroupWall).click();}

    public void openGroupsPage() {element(linkGroups).click();}

    public void openGroupWall() {
        //element(GroupWall).click();
        List<WebElement> Owner = getDriver().findElements(blockGroup);
        for (WebElement el : Owner) {
            if (el.getText().contains("Group Name")) {
                el.click();
                break;
            }
        }
    }

    public void AddTextPost(String Text, WebDriver driver) {

       // wt.until(ExpectedConditions.presenceOfElementLocated(txtCounter));

     /*   WebElement el = find(txtCounter);
        if (el.isDisplayed())
        {
        find(fieldPost).sendKeys(Text);}*/

        WebDriverWait wt = new WebDriverWait (driver, 150);
        wt.until(ExpectedConditions.presenceOfElementLocated(txtCounter));
        //wt.until(ExpectedConditions.presenceOfElementLocated(HomeContent));

        String el = find(txtCounter). getText();
        waitForTextToAppear(el);

        find(fieldPost).sendKeys(Text);

        //Assert.assertTrue("Text not found!", containsText(Text));
      // wt.until(ExpectedConditions.textToBePresentInElementLocated(txtPost,Text));
    }
    public void AddMentionPost(String Text, WebDriver driver) {

        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.presenceOfElementLocated(txtCounter));

        String el = find(txtCounter). getText();
        waitForTextToAppear(el);

        find(fieldPost).sendKeys(Text);
        wt.until(ExpectedConditions.visibilityOfElementLocated(mentionDropdown));
        wt.until(ExpectedConditions.visibilityOfElementLocated(mentionUser));
        find(mentionUser).waitUntilClickable();
        find(mentionUser).click();
        //find(mentionUser).waitUntilNotVisible();
    }

    public void AddTextPost_inGroup(String Text, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.presenceOfElementLocated(txtCounter));
        //wt.until(ExpectedConditions.presenceOfElementLocated(HomeContent));

        String el = find(txtCounter). getText();
        waitForTextToAppear(el);

        wt.until(ExpectedConditions.elementToBeClickable(fieldPost));
        find(fieldPost).sendKeys(Text);
        wt.until(ExpectedConditions.elementToBeClickable(btnPost));
    }
    public void clickPostArea() { find(fieldPost).click(); }

    public void AddVideoLink(String Video) {
        clearFieldVideo();
        find(fieldVideo).sendKeys(Video);
    }

    public void AddAudioLink(String Audio) {find(fieldAudio).sendKeys(Audio);
    }

    public void clickVideoPostButton(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 100);
        wt.until(ExpectedConditions.presenceOfElementLocated(btnAddVideoPost));
        wt.until(ExpectedConditions.visibilityOfElementLocated(btnAddVideoPost));
        find(btnAddVideoPost).click();
        wt.until(ExpectedConditions.invisibilityOfElementLocated(btnAddVideoPost));
    }

    public void clickAudioPostButton(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 110);
        wt.until(ExpectedConditions.presenceOfElementLocated(btnAddAudioPost));
        wt.until(ExpectedConditions.visibilityOfElementLocated(btnAddAudioPost));
        find(btnAddAudioPost).click();
        wt.until(ExpectedConditions.invisibilityOfElementLocated(btnAddAudioPost));

    }

    public void openVideoPopup() {find(iconVideo).click();}

    public void openAudioPopup(WebDriver driver) {
        find(icondAudio).click();}

    public void clearFieldPost() {find(fieldPost).clear();}

    public void clearFieldVideo() {find(fieldVideo).clear();}

    public void clickPostButton() {element(btnPost).click();}

    public void clickPostBtn(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.presenceOfElementLocated(Vidget));
        //find(btnPost);
        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,300)", "");
        find(btnPost).click();
    }

    public void addComment(String comment, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.presenceOfElementLocated(linkComment));
        element(linkComment).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(fieldComment));
        find(fieldComment).sendKeys(comment);
        element(btnPostComment).click();
        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,100)", "");
        wt.until(ExpectedConditions.elementToBeClickable(txtComment));
    }

    public void deleteComment(WebDriver driver) {
        //element(linkComment).click();

        JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
        jse1.executeScript("window.scrollBy(0,150)", "");

        WebElement menu = driver.findElement(txtComment);
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();
        find(btnDelete).click();

        WebDriverWait wt = new WebDriverWait (driver, 150);
        wt.until(invisibilityOfElementLocated(txtComment));
    }

    public void deletePost(WebDriver driver) {
        element(btnRightMenu).click();
        element(btnDeletePost).click();
        element(btnDeletePopup).click();
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(invisibilityOfElementLocated(btnDeletePopup));
    }

    public void checkTextInPost(String textPost, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(PostText,textPost));

        /*WebDriverWait wt = new WebDriverWait (driver, 500);
        wt.until(ExpectedConditions.visibilityOfElementLocated(PostText));
        String t = getDriver().findElement(PostText).getText();
        System.out.println(t);
        System.out.println(textPost);
        if (t.equals(textPost))
        {
            System.out.println("Post exists " + t);
            return true;
        }
        else
        { System.out.println("Post doesn't exist ");
            return false;
        }*/
    }

    public void checkContentInPost(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(VideoContent));
    }

    public void checkAudioContentInPost(WebDriver driver) {
        WebDriverWait ww = new WebDriverWait (driver, 99);
        ww.until(ExpectedConditions.visibilityOfElementLocated(AudioContent));
    }

    public void checkTextInNewsFeed(String textPost, WebDriver driver) {
        WebDriverWait ww = new WebDriverWait (driver, 99);
        ww.until(ExpectedConditions.textToBePresentInElementLocated(PostTextNewsFeed, textPost));

      /*  String t = getDriver().findElement(PostTextNewsFeed).getText();
        System.out.println(t);
        System.out.println(textPost);
        if (t.equals(textPost))
        {
            System.out.println("Post exists " + t);
            return true;
        }
        else
        { System.out.println("Post doesn't exist ");
            return false;
        }*/
    }

   /* public void checkTextInPostMax() {
        //Проверяем, есть ли на текущей странице текст
        Assert.assertTrue("Text not found!", containsText("The National Museum of Natural History (NMNH) in New Delhi was one of two museums focusing on nature in India.Established in 1972 and opened in 1978, the museum functioned under the Ministry of Environment and Forests of the government of India.[1] The museum was situated on Barakhamba Road at Tansen Marg in central New Delhi,[2] across from the Embassy of Nepal, near the Connaught Place metro station.[3] On 26 April 2016, the museum building and its entire collection were destroyed by a fire.The NMNH's mission is to promote environmental education, both at NMNH in the capital and at Regional Museums of Natural History in other parts of the country; to provide resources such as school loan kits for schools to use in their curricula on environmental education; to coordinate natural history projects with other agencies and organisations, both nationally and internationally; and to conduct natural history research.[5] The NMNH's director, B Venugopal, also emphasised intangible natural"));
    }

    public void checkTextInPostAr() {
        //Проверяем, есть ли на текущей странице текст
        Assert.assertTrue("Text not found!", containsText("المتحف الوطني للتاريخ الطبيعي"));
    }*/

    public void openPostMenu() {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        //jse.executeScript("window.scrollBy(0,1500)", "");
        find(postMenu).click();
    }

    public void openRepostMenu() {
        find(repostMenu).click();
    }

    public void selectRepostToGroup(WebDriver driver) {
        element(menuRepostToGroup).click();
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(dropdownGroup));
    }

    public void selectRepostToWall(WebDriver driver) {
        element(menuRepostToWall).click();
    }


    public void selectPin(WebDriver driver) {
        element(menuPin).click();
    }

    public void selectGroupInDropdown() {
        element(dropdownGroup).click();
        element(Group1).click();
    }

    public void pressPostButton() {
        element(buttonPostRepost).click();
    }

    public void checkTextInGroupAfterRepost(WebDriver driver, String placeholderGroup) {

       /* find(placeHolder_ToGroup).containsText("reposted");
        System.out.println(find(placeHolder_ToGroup).getText());
        String text = find(placeHolder_ToGroup).getText();
        Assert.assertTrue("No placeholder",text.contains(placeholderGroup));
        System.out.println(find(placeHolder_ToGroup).getText());*/

        List<WebElement> text = driver.findElements(placeHolder_To);
        String placeholder = text.get(1).getText();
        System.out.println(text.get(1).getText());
        assertTrue("Wrong text after reposting: ", placeholder.contains(placeholderGroup));

        /*for (WebElement el : Owner) {
            if (el.getText().contains(placeholderGroup)) {
                System.out.println(el.getText());
                break;
            }
        }*/
    }

    public void checkCounterRepost(WebDriver driver, String counter) {

        List<WebElement> Owner = driver.findElements(counterRepost);
        for (WebElement el : Owner) {

            if (el.getText().contains(counter)) {
                System.out.println(el.getText());
                break;
            }
        }
    }

    public void checkTextInWallAfterRepost(WebDriver driver, String placeholderWall) {
        /*System.out.println(find(placeHolder_ToGroup).getText());
        String i = find(placeHolder_ToGroup).getText();
        Assert.assertTrue("No placeholder", i.contains(placeholderWall));*/
        List<WebElement> text = driver.findElements(placeHolder_To);
        String placeholder = text.get(1).getText();
        System.out.println(text.get(1).getText());
        assertTrue("Wrong text after reposting: ", placeholder.contains(placeholderWall));

        /*List<WebElement> Owner = driver.findElements(placeHolder_To);
        for (WebElement el : Owner) {

            if (el.getText().contains(placeholderWall)) {
                System.out.println(el.getText());
                break;
            }
        }*/
    }

    public void checkOwnRepostExists(WebDriver driver, String text, String HeaderRepost) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(textRepost,text));
        String i = find(RepostHeaderGroup).getText();
        System.out.println("Repost header: " + i);
        Assert.assertTrue("Wrong repost header", i.contains(HeaderRepost));
    }
    public void checkRepostExists(WebDriver driver, String text, String HeaderRepost) {
        String i = find(RepostHeaderGroup).getText();
        System.out.println("Repost header: " + i);
        Assert.assertTrue("Wrong repost header", i.contains(HeaderRepost));
    }

    public void selectPin() {
        element(menuPin).click();
    }

    public void checkPinPlaceholder() {
        assertTrue("Wrong placeholder",element(PinPlaceholder).containsText("Post has been pinned to the top"));
    }
    public void checkUnPinPlaceholder() {
        assertTrue("Wrong placeholder",element(UnPinPlaceholder).containsText("Post has been unpinned to the top"));
    }

    public void pressViewNow() {
        find(linkViewNow).click();
    }

    public void checkPinIconPresent(){
        assertTrue("Pin icon is absent", find(iconPin).isPresent());
    }

    public boolean checkPinIconAbsent(){
        try {
            find(iconPin).isPresent();
            System.out.println("Pin icon exists");
            return true;
            }
        catch (NoSuchElementException ErrorName) {
            ErrorName:
            System.out.println("Pin icon DOESN'T exist");
            return false;
           }
    }
}
