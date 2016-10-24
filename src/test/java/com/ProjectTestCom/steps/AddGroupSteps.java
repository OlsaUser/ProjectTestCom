package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.GroupPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by olsa on 4/28/2016.
 */
public class AddGroupSteps extends ScenarioSteps {

    GroupPage groupPage;

    @Step
    public void clickAddGroupButton() { groupPage.clickAddGroupButton();}

    @Step
    public void openSettingMenu() { groupPage.openSettingMenu();}

    @Step
    public void selectDeleteMenu() { groupPage.selectDeleteMenu();}

    @Step
    public void selectViewMenu(WebDriver driver) { groupPage.selectViewMenu(driver);}

    @Step
    public void selectEditMenu() { groupPage.selectEditMenu();}

    @Step
    public void selectCancelButton(WebDriver driver) { groupPage.selectCancelButton(driver);}

    @Step
    public void enterNameGroup(String NameGroup, WebDriver driver) { groupPage.enterNameGroup(NameGroup, driver);}

    @Step
    public void selectTypeLimited(WebDriver driver, String dscLimitedGroup) { groupPage.selectTypeLimited(driver, dscLimitedGroup);}

    @Step
    public void selectTypePublic(WebDriver driver, String dscLimitedGroup) { groupPage.selectTypePublic(driver, dscLimitedGroup);}

    @Step
    public void selectTypePrivate(WebDriver driver, String dscprivateGroup) { groupPage.selectTypePrivate(driver, dscprivateGroup);}

    @Step
    public void enterShortDescription(String ShortDescription) { groupPage.enterShortDescription(ShortDescription);}

    @Step
    public void clearNameGroup() { groupPage.clearNameGroup();}

    @Step
    public void clearShortDescription() { groupPage.clearShortDescription();}

    @Step
    public void clickCreate(WebDriver driver)  { groupPage.clickCreate(driver);}

    @Step
    public void clickCreateError()  { groupPage.clickCreateError();}

   /* @Step
    public void MyGroupWallPublic(WebDriver driver)  { groupPage.MyGroupWallPublic(driver);}

    @Step
    public void MyGroupWallLimited(WebDriver driver, String maxNameGroupLimited) { groupPage.MyGroupWallLimited(driver, maxNameGroupLimited);}

    @Step
    public void MyGroupWallPrivate(WebDriver driver, String maxNameGroupLimited) { groupPage.MyGroupWallPrivate(driver, maxNameGroupLimited);}

    @Step
    public void openGroupWallLimited(WebDriver driver, String maxNameGroupLimited) { groupPage.openGroupWallLimited(driver, maxNameGroupLimited);}

    @Step
    public void openGroupWallPrivate(WebDriver driver, String maxNameGroupLimited) { groupPage.openGroupWallPrivate(driver, maxNameGroupLimited);}
*/
    @Step
    public void MyGroupWall_forDelete(WebDriver driver, String NameGroup) { groupPage.MyGroupWall_forDelete(driver, NameGroup);}

    @Step
    public void viewerGroupLimited(WebDriver driver)  { groupPage.viewerGroupLimited(driver);}

    @Step
    public void viewerGroupPrivate(WebDriver driver)  { groupPage.viewerGroupPrivate(driver);}

    @Step
    public void pressSubscribe(WebDriver driver)  { groupPage.pressSubscribe(driver);}

    @Step
    public void pressUnSubscribe(WebDriver driver)  { groupPage.pressUnSubscribe(driver);}

    @Step
    public void pressUnJoin(WebDriver driver)  { groupPage.pressUnJoin(driver);}

    @Step
    public void pressRequestJoin(WebDriver driver)  { groupPage.pressRequestJoin(driver);}

    @Step
    public void pressAccept(WebDriver driver)  { groupPage.pressAccept(driver);}

    @Step
    public void checkPlaceholder_Subscribed(WebDriver driver)  { groupPage.checkPlaceholder_Subscribed(driver);}

    @Step
    public void checkPlaceholder_RequestSent(WebDriver driver)  { groupPage.checkPlaceholder_RequestSent(driver);}

    @Step
    public void checkRequestedPermission(WebDriver driver, String GroupName, String text)  { groupPage.checkRequestedPermission(driver, GroupName, text);}

    @Step
    public void checkConfirmedRequest(WebDriver driver, String GroupName, String text)  { groupPage.checkConfirmedRequest(driver, GroupName, text);}

    @Step
    public void checkMemberLim(WebDriver driver, String GroupName)  { groupPage.checkMemberLim(driver, GroupName);}

    @Step
    public void checkMemberPri(WebDriver driver, String GroupName)  { groupPage.checkMemberPri(driver, GroupName);}

    @Step
    public void openGroupWall(WebDriver driver, String name)  { groupPage.openGroupWall(driver, name);}

    @Step
    public void clickSettings()  { groupPage.clickSettings();}

    @Step
    public void clickbtnSettingsEdit(WebDriver driver)  { groupPage.clickbtnSettingsEdit(driver);}

    @Step
    public void clickBtnDeleteGroup( )  { groupPage.clickBtnDeleteGroup();}

    @Step
    public void clickbtnSettingsInvite()  { groupPage.clickbtnSettingsInvite();}

    @Step
    public void clickInviteAllUsers(WebDriver driver)  { groupPage.clickInviteAllUsers(driver);}

    @Step
    public void Invite_NameUser(String UserName, WebDriver driver)  { groupPage.Invite_NameUser(UserName, driver);}

    @Step
    public void Invite_NameOrganization(String UserName, WebDriver driver)  { groupPage.Invite_NameOrganization(UserName, driver);}

    @Step
    public void Invite_Skills(String UserName, WebDriver driver)  { groupPage.Invite_Skills(UserName, driver);}

    @Step
    public void Invite_Interests(String UserName, WebDriver driver)  { groupPage.Invite_Interests(UserName, driver);}

    @Step
    public void SelectAndInvite(String UserName, WebDriver driver)  { groupPage.SelectAndInvite(UserName, driver);}

    @Step
    public void checkInvited( WebDriver driver)  { groupPage.checkInvited(driver);}

    @Step
    public void clickInviteMyFollowings(WebDriver driver)  { groupPage.clickInviteMyFollowings(driver);}

    @Step
    public void clickInviteMyFollowers(WebDriver driver)  { groupPage.clickInviteMyFollowers(driver);}

    @Step
    public void clickInviteButton(WebDriver driver)  { groupPage.clickInviteButton(driver);}

    @Step
    public void checkNameGroupErrorPresent(WebDriver driver,String lblError) { groupPage.checkNameGroupErrorPresent(driver, lblError);}

    @Step
    public void checkGroupInListing(String groupName) { groupPage.checkGroupInListing(groupName);}

    @Step
    public void enterGroupSkill(String skill, WebDriver driver) { groupPage.enterGroupSkill(skill, driver);}

    @Step
    public void enterGroupInterest(String interest, WebDriver driver) { groupPage.enterGroupInterest(interest, driver);}

    @Step
    public void deleteGroupSkill(WebDriver driver ) { groupPage.deleteGroupSkill(driver);}

    @Step
    public void deleteGroupInterest(WebDriver driver ) { groupPage.deleteGroupInterest(driver);}

    @Step
    public void checkTextOnOwnGroupMemberPage( ) { groupPage.checkTextOnOwnGroupMemberPage();}

    @Step
    public void checkTextOnUserGroupMemberPage(WebDriver driver) { groupPage.checkTextOnUserGroupMemberPage(driver);}

    @Step
    public void checkElementsAbsent() { assertFalse(groupPage.checkElementsAbsent());}

    @Step
    public void checkElementsPresent() { groupPage.checkElementsPresent();}
}