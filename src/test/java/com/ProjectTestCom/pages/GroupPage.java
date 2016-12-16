package com.ProjectTestCom.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.jetty.html.Break;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.validation.constraints.AssertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.util.Objects.areEqual;
import static org.junit.Assert.assertFalse;

/**
 * Created by olsa on 4/28/2016.
 */
@RunWith(SerenityRunner.class)
public class GroupPage extends PageObject {

    private final By linkMyMnassa = By.xpath(".//*[@id='header-top-line']/nav/div[2]/a");
    private final By linkGroups = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']/li[4]");
    private final By linkMyGroups = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']/li[5]");
    private final By SettingsMenu = By.xpath("//div[@class='gallery-list']/div[1]/div[@class='gallery-box-edit']");
    private final By ViewMenu = By.xpath("//ul[@class='dropdown-menu gallery-box-params-list']//li[1]");
    private final By EditMenu = By.xpath("//ul[@class='dropdown-menu gallery-box-params-list']//li[2]");
    private final By DeleteMenu = By.xpath("//ul[@class='dropdown-menu gallery-box-params-list']//li[3]");
    //private final By btnDelete = By.xpath("//div[@id='group-delete']//div[@class='text-center']/button[2]");
    private final By btnCancel = By.xpath("//div[@id='group-delete']//div[@class='text-center']/button[1]");
    //private final By btnAddGroup = By.xpath("//a[@can-click='ins_group_modal']");
    private final By btnAddGroup = By.xpath("//div[@class='header-dropdown']/a[5]");
    private final By thirdLimeMenu = By.xpath("//div[@id='nav-list-in']");
    private final By headerInfoMembers = By.xpath("//div[@class='header-info-followers']/div[1]");
    private final By headerInfoPosts = By.xpath("//div[@class='header-info-followers']/div[2]");
    private final By headerGroupIcon = By.xpath("//span[@class='header-info-group-icon']");

    private final By btnSave = By.xpath("//button[@can-click='upd_group']");
    private final By CreateandShareInformation = By.xpath("//span[@class='feed-placeholder-title-text']");
    private final By fieldNameGroup = By.xpath("//input[@can-value='mcou_title']");
    private final By TypeLimited = By.xpath("//label[@for='mcou-permission-limited']");
    private final By TypePrivate = By.xpath("//label[@for='mcou-permission-private']");
    private final By TypePublic = By.xpath("//label[@for='mcou-permission-public']");
    private final By fieldShortDescription = By.xpath("//textarea[@can-value='mcou_descr']");
    private final By lblNameGroupError = By.xpath("//div[@class='error_message_static']");
    private final By blockGroup = By.xpath("//a[contains(@href,'#!group/name')]");
    private final By lblOwner = By.xpath("//span[@class='group-item-owner']");
    private final By postValue = By.xpath("//div[@class='group-item-info']/div[1]/span[@class='group-item-info-value']");
    private final By memberValue = By.xpath("//div[@class='group-item-info']/div[2]/span[@class='group-item-info-value']");

    private final By imemberValue = By.xpath("//div[@class='header-info-followers']/div[1]/span");
    private final By ipostValue = By.xpath("//div[@class='header-info-followers']/div[2]/span");

    private final By Group_PlaceholderHeader = By.xpath("//div[@class='introduction-header']");
    private final By Group_PlaceholderText1 = By.xpath("//div[@class='introduction-text']/p[1]");
    private final By Group_PlaceholderText2 = By.xpath("//div[@class='introduction-text']/p[2]");
    private final By Group_PlaceholderText3 = By.xpath("//div[@class='introduction-text']/p[3]");
    private final By btnSubscribe = By.xpath("//button[@can-click='data.group.subscribe']");
    private final By btnRequestJoin = By.xpath("//button[@can-click='data.group.request_to_join']");
    private final By btnCancelSubscribe = By.xpath("//button[@can-click='data.group.cancel_subscribe']");
    private final By btnUnSubscribe = By.xpath("//button[@can-click='data.unsubscribe_group_modal']");
    private final By btnUnJoin = By.xpath("//button[@can-click='data.unjoin_group_modal']");
    private final By btnOKUnSubsc = By.xpath("//button[@can-click='unsubscribe_group']");
    private final By btnOKUnJoin = By.xpath("//button[@can-click='unjoin_group']");
    private final By btnCancelRequestJoin = By.xpath("//button[@can-click='data.group.cancel_request_to_join']");
    private final By btnMemberLim = By.xpath("//button[@can-click='data.unsubscribe_group_modal']");
    private final By btnMemberPri = By.xpath("//button[@can-click='data.unjoin_group_modal']");
    private final By RequestedPermissionNotification = By.xpath("//span[@class='feed-head-action']");
    private final By btnAccept = By.xpath("//div[@class='feed-invitation']/button[1]");
    private final By lblAccepted = By.xpath("//div[@class='feed-head-controls -activity']/button[contains(text(),'Accepted')]");

    private final By btnSettings = By.cssSelector("a[href*='group_edit']");
    //private final By btnSettingsView = By.xpath("//ul[@class='dropdown-menu gallery-box-params-list']/li[1]");
    private final By btnSettingsEdit = By.xpath("//div[@class='header-info-controls']/a[1]");
    private final By btnSettingsInvite = By.xpath("//ul[@class='dropdown-menu gallery-box-params-list']/li[2]");
    //private final By buttonInvite = By.xpath("//div[@class='header-info-controls']/a[2]");
    private final By buttonInvite = By.cssSelector("a[href*='group_invite']");
    //private final By btnSettingsInviteMyFollowers = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']/li[1]/a");
    //private final By btnSettingsInviteMyFollowings = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']/li[2]/a");
    //private final By btnSettingsInviteAllUsers = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']/li[3]/a");
    private final By btnSettingsInviteMyFollowers = By.cssSelector("a[href*='followers']");
    private final By btnSettingsInviteMyFollowings = By.cssSelector("a[href*='followings']");
    private final By btnSettingsInviteAllUsers = By.xpath("//div[@class='nav-list-items']/a[3]");
    private final By btnInviteFirst = By.xpath("//section[@class='users-list']/div[1]//button");
    private final By checkboxInvite = By.xpath("//div[@class='user-in-checkbox-place']");

    private final By buttonSelectAll = By.xpath("//a[@can-click='group_invite.check_all_invite_list']");
    private final By buttonUnSelectAll = By.xpath("//a[@can-click='group_invite.uncheck_all_invite_list']");
    private final By buttonInviteSelected = By.xpath("//a[@can-click='group_invite.show_modal_invite_users']");
    private final By InviteInPopup = By.xpath("//button[@can-click='group_invite.send_invite_all']");
    private final By labelInvited = By.xpath("//span[contains(text(),'Invited')]");
    private final By ListofUser = By.xpath("//section[@class='users-list']");

    private final By fieldUserName = By.xpath("//input[@id='invite-group-all-search']");
    private final By DropdownUserName = By.xpath("//div[@class='search-dropdown-container js-search-dropdown-container group-invite-search-list']");
    private final By DropdownUsers = By.xpath("//div[@class='search-dropdown-container js-search-dropdown-container group-invite-search-list']/div[1]/div[2]/a[1]");
    private final By DropdownOrganizations = By.xpath("//div[@class='search-dropdown-container js-search-dropdown-container group-invite-search-list']/div[1]/div[2]/a[1]");
    private final By DropdownSkills = By.xpath("//div[@class='search-dropdown-container js-search-dropdown-container group-invite-search-list']/div[2]/div[2]/a");
    private final By DropdownInterests = By.xpath("//div[@class='search-dropdown-container js-search-dropdown-container group-invite-search-list']/div[3]/div[2]/a");
    private final By btnInvite = By.xpath("//div[@class='user-in-checkbox-place']");
    private final By lblInvite = By.xpath("//span[@class='btn-text']");

    //private final By btnSettingsDelete = By.xpath("//ul[@class='dropdown-menu gallery-box-params-list']/li[3]");
    private final By btnDelete = By.xpath("//a[@can-click='del_group_modal']");
    private final By btnDelOk = By.xpath("//button[@can-click='del_group']");
    private final By fieldPasswordForDeleteGroup = By.id("del-group-password");
    private final By lblErrorPasswordForDeleteGroup = By.xpath("//div[@class='error_message']");
    private final By btnDeleteInDeletePopup = By.xpath("//button[@can-click='del_group']");
    //private final By btnSettingsDeleteOk = By.xpath("//div[@class='modal-body']//button[2]");
    private final By btnSettingsDeleteCancel = By.xpath("//div[@class='modal-body']//button[1]");
    private final By EditGroupPopup = By.xpath("//div[@class='modal-content']");

    //Visible elements
    private final By GroupContent = By.xpath("//div[@class='group-item']");
    private final By headerWallGroupLink = By.xpath("//div[@class='feed container']");
    private final By firstPostBlock = By.xpath(".//*[@id='user_sect']/user_app/div[1]/div/div/div[3]/div[2]");
    private final By fieldInterests = By.xpath("//div[@id='s2id_group-interests']//li[last()]/input");
    private final By Skill_1 = By.xpath("//ul[@class='select2-results']/li[1]/div/span");
    private final By fieldSkills = By.xpath("//div[@id='s2id_group-skills']//li[last()]/input");
    private final By Interest_1 = By.xpath("//ul[@class='select2-results']/li[1]/div/span");
    private final By btnDeleteSkill = By.xpath("//span[@can-click='rem_group_skill']");
    private final By btnDeleteInterest = By.xpath("//div[@can-click='rem_group_interest']");
    private final By tagList = By.xpath("//ul[@class='tag-list list-unstyled']");

    //Member Page
    private final By linkGroupMembers = By.xpath("//span[contains(text(),'Group Members')]");
    private final By labelOwner = By.xpath("//span[contains(text(),'Owner')]");
    private final By labelAdmin = By.xpath("//button[@can-click='assign_group_admin_modal']");
    private final By btnFollowing = By.xpath("//button[@can-click='handle_follower']");
    private final By btnDeleteMember = By.xpath("//span[@can-click='remove_group_member_modal']");

    public void deleteGroupSkill(WebDriver driver) {
        find(tagList);
        List<WebElement> icons = getDriver().findElements(btnDeleteSkill);
        for (WebElement el : icons) {
                el.click();
            WebDriverWait wt = new WebDriverWait (driver, 80);
            //wt.until(ExpectedConditions.invisibilityOfElementLocated(tagList));
                break;
        }
    }

    public void deleteGroupInterest(WebDriver driver) {
        find(tagList).waitUntilClickable();
        List<WebElement> icons = getDriver().findElements(btnDeleteInterest);
        //System.out.println(icons);
        for (WebElement el : icons) {
            //el.isDisplayed();
            el.click();
            WebDriverWait wt = new WebDriverWait (driver, 80);
            //wt.until(ExpectedConditions.invisibilityOfElementLocated(tagList));
            break;
        }
    }

    public void enterGroupSkill(String skill, WebDriver driver) {
        find(fieldSkills).click();
        find(fieldSkills).sendKeys(skill);

        WebDriverWait wt = new WebDriverWait (driver, 80);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Skill_1));
        find(Skill_1).click();
        wt.until(ExpectedConditions.invisibilityOfElementLocated(Skill_1));
    }

    public void enterGroupInterest(String interest, WebDriver driver) {
        find(fieldInterests).click();
        find(fieldInterests).sendKeys(interest);

        WebDriverWait wt = new WebDriverWait (driver, 80);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Interest_1));
        find(Interest_1).click();
        wt.until(ExpectedConditions.invisibilityOfElementLocated(Interest_1));
    }


    public void clickAddGroupButton() {
        if (find(btnAddGroup).isPresent())
        find(btnAddGroup).click();

        WebDriverWait wt = new WebDriverWait(getDriver(), 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(headerGroupIcon));
        //wt.until(ExpectedConditions.visibilityOfElementLocated(thirdLimeMenu));

        assertTrue("Error! Wrong counter of Members",find(headerInfoMembers).containsText("0 Members"));
        assertTrue("Error! Wrong counter of Posts",find(headerInfoPosts).containsText("0 Posts"));
    }

    public void openSettingMenu() {
        element(SettingsMenu).click();
    }

    public void selectDeleteMenu() {
        element(DeleteMenu).click();
    }

    public void selectViewMenu(WebDriver driver) {
        element(ViewMenu).click();
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.invisibilityOfElementLocated(headerWallGroupLink));
    }

    public void selectEditMenu() {
        element(EditMenu).click();
    }

    public void selectCancelButton(WebDriver driver) {
        element(btnCancel).click();
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.invisibilityOfElementLocated(btnCancel));
    }

   /* public void clickDeleteButton() {
        element(btnDelete).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.elementToBeClickable(GroupContent));
    }*/

    public void enterNameGroup(String NameGroup, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.elementToBeClickable(fieldNameGroup));
              clearNameGroup();
              find(fieldNameGroup).sendKeys(NameGroup);
    }

    public void selectTypeLimited(WebDriver driver, String dscLimitedGroup) throws Error  {
        find(TypeLimited).click();
        assertTrue("Oops! Wrong description about Group Type",
                dscLimitedGroup.equals(driver.findElement(TypeLimited).getText()));
    }
    public void selectTypePublic(WebDriver driver, String dscLimitedGroup) throws Error  {
        find(TypePublic).click();
        assertTrue("Oops! Wrong description about Group Type",
                dscLimitedGroup.equals(driver.findElement(TypePublic).getText()));
    }

    public void selectTypePrivate(WebDriver driver, String dscprivateGroup) {
        find(TypePrivate).click();
        assertTrue("Oops! Wrong description about Group Type",
                dscprivateGroup.equals(driver.findElement(TypePrivate).getText()));
    }

    public void enterShortDescription(String ShortDescription) {
        clearShortDescription();
        find(fieldShortDescription).sendKeys(ShortDescription);
    }

    public void clearNameGroup() {
        find(fieldNameGroup).clear();
    }

    public void clearShortDescription() {
        find(fieldShortDescription).clear();
    }

    public void clickCreate(WebDriver driver) {
        element(btnSave).click();
        find(btnSave).waitUntilNotVisible();

        WebDriverWait wt = new WebDriverWait(driver, 25);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(CreateandShareInformation,
                "Create and share any information with Mnassa community"));
    }

    public void clickCreateError() {element(btnSave).click();}

    public void openGroupWall(WebDriver driver, String name) {
        List<WebElement> Owner = driver.findElements(blockGroup);
        for (WebElement el : Owner) {
            if (el.getAttribute("href").contains(name)) {
                el.click();
                WebDriverWait wt = new WebDriverWait(driver, 800);
                wt.until(ExpectedConditions.presenceOfElementLocated(headerWallGroupLink));
                wt.until(ExpectedConditions.presenceOfElementLocated(firstPostBlock));
                break;
            }
        }
    }

    public void MyGroupWall_forDelete(WebDriver driver, String NameGroup) throws Error {
            List<WebElement> Owner = driver.findElements(blockGroup);
            for (WebElement el : Owner) {
                if (el.getAttribute("href").contains(NameGroup)) {

                    el.click();
                    WebDriverWait wt = new WebDriverWait(driver, 99);
                    wt.until(ExpectedConditions.visibilityOfElementLocated(btnSettingsEdit));
                    break;
                }
                else NameError :  System.out.println("Oops!  There are no group with EN Name");
            }
         }
    public void viewerGroupLimited(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 200);
        wt.until(ExpectedConditions.visibilityOfElementLocated(headerGroupIcon));
        find(headerGroupIcon);
        find(thirdLimeMenu).waitUntilPresent();
        find(headerInfoMembers);
        find(headerInfoPosts);
        find(btnSubscribe);
        //System.out.println(find(LimitedGroup_PlaceholderText1).getText());
        assertTrue("Wrong placeholder1",find(Group_PlaceholderHeader).containsText("You've accessed to a Limited group."));
        assertTrue("Wrong placeholder2",find(Group_PlaceholderText1).containsText("To subscribe on Group updates and request permission to post and comment on group wall click on \"Subscribe\" button above."));
        assertTrue("Wrong placeholder3",find(Group_PlaceholderText2).containsText("You'll have to wait for a group admin to approve the request."));
    }
    public void viewerGroupPrivate(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 200);
        wt.until(ExpectedConditions.visibilityOfElementLocated(headerGroupIcon));
        find(headerGroupIcon);
        find(thirdLimeMenu).waitUntilPresent();
        find(headerInfoMembers);
        find(headerInfoPosts);
        find(btnRequestJoin);
        //System.out.println(find(LimitedGroup_PlaceholderText1).getText());
        assertTrue("Wrong placeholder1",find(Group_PlaceholderHeader).containsText("You've accessed to a Private group."));
        assertTrue("Wrong placeholder2",find(Group_PlaceholderText1).containsText("Only members can see the content, post and comment."));
        assertTrue("Wrong placeholder3",find(Group_PlaceholderText2).containsText("To join the group, click Join button above."));
        assertTrue("Wrong placeholder4",find(Group_PlaceholderText3).containsText("You'll have to wait for a group admin to approve your request."));
    }

    public void pressSubscribe(WebDriver driver) {
        find(btnSubscribe).click();
        find(headerInfoMembers);
        WebDriverWait wt = new WebDriverWait(driver, 200);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Group_PlaceholderHeader));
    }
    public void pressUnSubscribe(WebDriver driver) {
        find(btnUnSubscribe).click();
        pressOkSubs(driver);
    }

    public void pressUnJoin(WebDriver driver) {
        find(btnUnJoin).click();
        pressOKUnJoin(driver);
    }

    public void pressOkSubs(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 250);
        wt.until(ExpectedConditions.visibilityOfElementLocated(btnOKUnSubsc));
        System.out.println("1");
        find(btnOKUnSubsc).click();
        System.out.println("2");
        wt.until(ExpectedConditions.presenceOfElementLocated(Group_PlaceholderHeader));
        //wt.until(ExpectedConditions.visibilityOfElementLocated(Group_PlaceholderHeader));
        //find(btnOKUnSubsc).waitUntilNotVisible();
    }
    public void pressOKUnJoin(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 150);
        wt.until(ExpectedConditions.visibilityOfElementLocated(btnOKUnJoin));

        find(btnOKUnJoin).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(Group_PlaceholderHeader));
        //find(btnOKUnJoin).waitUntilNotVisible();
    }
    public void pressRequestJoin(WebDriver driver) {
        find(btnRequestJoin).click();
        find(headerInfoMembers);
        WebDriverWait wt = new WebDriverWait(driver, 150);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Group_PlaceholderHeader));
    }

    public void checkPlaceholder_Subscribed(WebDriver driver) {
        find(btnCancelSubscribe);
        //System.out.println(find(LimitedGroup_PlaceholderText1).getText());
        assertTrue("Wrong placeholder",find(Group_PlaceholderHeader).containsText("You've subscribed to a Limited group."));
        assertTrue("Wrong placeholder1",find(Group_PlaceholderText1).containsText("Group updates are visible now on your Newsfeed."));
        assertTrue("Wrong placeholder2",find(Group_PlaceholderText2).containsText("Request to post and comment on group wall has been sent on your behalf."));
        assertTrue("Wrong placeholder3",find(Group_PlaceholderText3).containsText("You'll have to wait for a group admin to approve it."));
    }

    public void checkPlaceholder_RequestSent(WebDriver driver) {
        find(btnCancelRequestJoin);
        //System.out.println(find(LimitedGroup_PlaceholderText1).getText());
        assertTrue("Wrong placeholder",find(Group_PlaceholderHeader).containsText("You've accessed to a Private group."));
        assertTrue("Wrong placeholder1",find(Group_PlaceholderText1).containsText("Request to see the content, post and comment has been sent on your behalf."));
        assertTrue("Wrong placeholder2",find(Group_PlaceholderText2).containsText("You'll have to wait for a group admin to approve it."));
    }

    public void checkRequestedPermission(WebDriver driver, String GroupName, String text) {
        //System.out.println(GroupName);
        //System.out.println(text);
        System.out.println(find(RequestedPermissionNotification).getText());
        String header=find(RequestedPermissionNotification).getText();
        Assert.assertTrue("Wrong Requested Permission in notification",header.contains(text + "  " + GroupName + "."));
    }
    public void checkConfirmedRequest(WebDriver driver, String GroupName, String text) {
        //System.out.println(GroupName);
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(RequestedPermissionNotification));
        System.out.println(find(RequestedPermissionNotification).getText());
        String header=find(RequestedPermissionNotification).getText();
      //  assertTrue("Wrong Requested Permission in notification",find(RequestedPermissionNotification).containsText(text + " " + GroupName + "."));
        Assert.assertTrue("Wrong Requested Permission in notification",header.contains(text + " " + GroupName + "."));
    }

    public void checkMemberLim(WebDriver driver, String GroupName) {
        assertTrue(find(btnMemberLim).containsText("Member"));
        System.out.print(find(btnMemberLim).getText());
    }
    public void checkMemberPri(WebDriver driver, String GroupName) {
        assertTrue(find(btnMemberPri).containsText("Member"));
        System.out.print(find(btnMemberPri).getText());
    }

    public void pressAccept(WebDriver driver) {
        find(btnAccept).click();
        WebDriverWait wt = new WebDriverWait(driver, 120);
        wt.until(ExpectedConditions.presenceOfElementLocated(lblAccepted));
    }

    public void clickSettings() {
        element(btnSettings).click();
    }
    //not actual
    public void clickbtnSettingsEdit(WebDriver driver) {
        element(btnSettingsEdit).click();
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.invisibilityOfElementLocated(EditGroupPopup));
    }

    public void clickbtnSettingsInvite() {element(buttonInvite).click();}

    public void clickInviteMyFollowers(WebDriver driver) {
        element(btnSettingsInviteMyFollowers).click();
        WebDriverWait wt = new WebDriverWait(driver, 150);
        wt.until(ExpectedConditions.presenceOfElementLocated(ListofUser));
    }

    public void clickInviteButton(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 100);
        wt.until(ExpectedConditions.visibilityOfElementLocated(ListofUser));

        find(buttonSelectAll).click();
        wt.until(ExpectedConditions.elementToBeClickable(buttonInviteSelected));
        find(buttonInviteSelected).click();
        pressInviteInPopup(driver);

       /* List<WebElement> Invite = getDriver().findElements(checkboxInvite);
        for (WebElement el : Invite)
        {
            el.click();
            wt.until(ExpectedConditions.elementToBeClickable(buttonInviteSelected));
            find(buttonInviteSelected).click();
            pressInviteInPopup(driver);
            break;
        }*/
    }
    public void pressInviteInPopup(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 20);
        wt.until(ExpectedConditions.visibilityOfElementLocated(InviteInPopup));

        find(InviteInPopup).click();
        wt.until(ExpectedConditions.presenceOfElementLocated(ListofUser));
        find(labelInvited);
        //wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelInvited));
    }

    public void clickInviteMyFollowings(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 200);
        wt.until(ExpectedConditions.presenceOfElementLocated(btnSettingsInviteMyFollowings));
        find(btnSettingsInviteMyFollowings).click();
        wt.until(ExpectedConditions.presenceOfElementLocated(ListofUser));
    }

    public void clickInviteAllUsers(WebDriver driver) {
        element(btnSettingsInviteAllUsers).click();
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.presenceOfElementLocated(fieldUserName));
    }

    public void Invite_NameUser(String UserName, WebDriver driver) {
        find(fieldUserName).waitUntilClickable();
        element(fieldUserName).click();
        element(fieldUserName).clear();
        element(fieldUserName).sendKeys(UserName);
        WebDriverWait wt = new WebDriverWait(driver, 150);
        wt.until(ExpectedConditions.presenceOfElementLocated(DropdownUserName));
        find(DropdownUsers).click();
    }

    public void Invite_NameOrganization(String UserName, WebDriver driver) {
        find(fieldUserName).waitUntilClickable();
        element(fieldUserName).click();
        element(fieldUserName).clear();
        element(fieldUserName).sendKeys(UserName);
        WebDriverWait wt = new WebDriverWait(driver, 150);
        wt.until(ExpectedConditions.presenceOfElementLocated(DropdownUserName));
        wt.until(ExpectedConditions.elementToBeClickable(DropdownUserName));
        wt.until(ExpectedConditions.visibilityOfElementLocated(DropdownUserName));
        find(DropdownOrganizations).click();
    }

    public void Invite_Skills(String UserName, WebDriver driver) {
        find(fieldUserName).waitUntilClickable();
        element(fieldUserName).click();
        element(fieldUserName).clear();
        element(fieldUserName).sendKeys(UserName);
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.presenceOfElementLocated(DropdownSkills));
        find(DropdownSkills).click();
    }

    public void Invite_Interests(String UserName, WebDriver driver) {
        find(fieldUserName).waitUntilClickable();
        element(fieldUserName).click();
        element(fieldUserName).clear();
        element(fieldUserName).sendKeys(UserName);
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.presenceOfElementLocated(DropdownInterests));
        find(DropdownInterests).click();
    }

    public void SelectAndInvite(String UserName, WebDriver driver) {
        find(btnInvite).isDisplayed();
        find(buttonSelectAll).click();
        find(buttonInviteSelected).click();
        pressInviteInPopup(driver);
    }
    public void checkInvited(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 200);
        wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelInvited));
        find(labelInvited).isPresent();
        find(labelInvited).isDisplayed();

        System.out.println(find(labelInvited).getText());
    }
    public boolean checkUserInvited(String value, WebDriver driver) {
       if (value.equals("btn btn-green-primary btn-sm width-112px"))
       {
           System.out.println(value);
           return true;
       }
        else return false;
    }

    public void clickBtnDeleteGroup( ) {
        element(btnDelete).click();
        find(btnDelOk).waitUntilClickable();
        find(btnDelOk).click();
        find(btnDelOk).waitUntilNotVisible();
    }

    public void checkNameGroupErrorPresent(WebDriver driver, String lblError) {
        assertTrue("Oops! Wrong validation message",
                lblError.equals(driver.findElement(lblNameGroupError).getText()));
    }

    public void checkGroupInListing(String groupName) {

        List<WebElement> GroupNames = getDriver().findElements(blockGroup);

        WebElement newGroup = null;

        for (WebElement el : GroupNames) {
                if (el.getAttribute("href").contains(groupName)){
                newGroup = el;
                System.out.println("Group exists " + newGroup.getText());
                el.click();
                //assertTrue("Error! There is no label OWNER",find(lblOwner).containsText("Owner"));
                assertTrue("Error! Wrong count of members",find(imemberValue).containsText("1"));
                assertTrue("Error! Wrong count of posts",find(ipostValue).containsText("0"));
                break;
            }
        }

        /*WebDriverWait wt = new WebDriverWait(driver, 300);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(blockGroup, groupName));
        Assert.assertTrue("Text not found!", containsText(groupName));*/

        /*String t = getDriver().findElement(blockGroup).getText();
        System.out.println(t);
        System.out.println(groupName);
        if (t.equals(groupName))
        {
            System.out.println("Group exists " + t);
            return true;
        }
        else
        { System.out.println("Group doesn't exist ");
            return false;
        }*/
    }

    public void checkTextOnOwnGroupMemberPage() {
        find(linkGroupMembers).click();
        find(labelOwner).isDisplayed();
        find(btnFollowing).isDisplayed();
        find(btnDeleteMember).isVisible();
        find(labelAdmin).isDisplayed();
    }

    public void checkElementsPresent()  {
            assertTrue("Admin btn absent for Owner",getDriver().findElement(labelAdmin).isDisplayed());
            assertTrue("Delete Member btn absent for Owner",getDriver().findElement(btnDeleteMember).isDisplayed());
            System.out.println("Elements 'labelAdmin', 'btnDeleteMember' are Present");
        }

    public boolean checkElementsAbsent()  {
        try {
            getDriver().findElement(labelAdmin);
            getDriver().findElement(btnDeleteMember);
            System.out.println("Elements 'labelAdmin', 'btnDeleteMember' are Present");
            return true;

        } catch (NoSuchElementException e) {
            e:
            System.out.println("Elements 'labelAdmin', 'btnDeleteMember' are absent");
            return false;
        }
    }

    public void checkTextOnUserGroupMemberPage(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 300);
        wt.until(ExpectedConditions.visibilityOfElementLocated(linkGroupMembers));
        find(linkGroupMembers).click();
        find(labelOwner).isDisplayed();
        find(btnFollowing).isDisplayed();
    }
}
