package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SearchSteps extends ScenarioSteps {

    SearchPage searchPage;

    @Step
    public void clearField() {searchPage.clearField();}

    @Step
    public void switchToOrg() {searchPage.switchToOrg();}

    @Step
    public void switchToUser() {searchPage.switchToUser();}

    @Step
    public void closeResult(WebDriver driver) {searchPage.closeResult(driver);}

    @Step
    public void clickField_searchBy(String text, WebDriver driver) {searchPage.clickField_searchBy(text, driver);}

    @Step
    public void selectSearchResult_byUser(String text, WebDriver driver) {searchPage.selectSearchResult_byUser(text, driver);}

    @Step
    public void checkEmptySearchResult_User(String text, WebDriver driver) {searchPage.checkEmptySearchResult_User(text, driver);}

    @Step
    public void checkEmptySearchResult_Item(String text, WebDriver driver) {searchPage.checkEmptySearchResult_Item(text, driver);}

    @Step
    public void selectSearchResult_byOrganization(String text, WebDriver driver) {searchPage.selectSearchResult_byOrganization(text, driver);}

    @Step
    public void selectSearchResult_ProductItem(String text, WebDriver driver) {searchPage.selectSearchResult_ProductItem(text, driver);}

    @Step
    public void selectSearchResult_ServiceItem(String text, WebDriver driver) {searchPage.selectSearchResult_ServiceItem(text, driver);}

    @Step
    public void selectSearchResult_EventItem(String text, WebDriver driver) {searchPage.selectSearchResult_EventItem(text, driver);}

    @Step
    public void selectSearchResult_PartnershipItem(String text, WebDriver driver) {searchPage.selectSearchResult_PartnershipItem(text, driver);}

    @Step
    public void selectSearchResult_ProductTag(String text, WebDriver driver) {searchPage.selectSearchResult_ProductTag(text, driver);}

    @Step
    public void selectSearchResult_ServiceTag(String text, WebDriver driver) {searchPage.selectSearchResult_ServiceTag(text, driver);}

    @Step
    public void selectSearchResult_EventTag(String text, WebDriver driver) {searchPage.selectSearchResult_EventTag(text, driver);}

    @Step
    public void selectSearchResult_PartnershipTag(String text, WebDriver driver) {searchPage.selectSearchResult_PartnershipTag(text, driver);}

    @Step
    public void checkSearchResult_Item(String text, WebDriver driver) {assertTrue (searchPage.checkSearchResult_Item(text, driver));}

    @Step
    public void checkSearchResult_FullName(String text, WebDriver driver) {searchPage.checkSearchResult_FullName(text, driver);}

    @Step
    public void checkSearchResult_UserName(String username, WebDriver driver) {searchPage.checkSearchResult_UserName(username, driver);}

    @Step
    public void checkSearchResult_BriefInfo(String info, WebDriver driver) {searchPage.checkSearchResult_BriefInfo(info, driver);}

    @Step
    public void checkSearchResult_Skill(String skill, WebDriver driver) {searchPage.checkSearchResult_Skill(skill, driver);}

    @Step
    public void checkSearchResult_ItemDescription(String text, WebDriver driver) {searchPage.checkSearchResult_ItemDescription(text, driver);}

    @Step
    public void checkSearchResult_ItemTags(String tag, WebDriver driver) {searchPage.checkSearchResult_ItemTags(tag, driver);}

    @Step
    public void selectSearchResult_Group(String title, WebDriver driver) {searchPage.selectSearchResult_Group(title, driver);}

    @Step
    public void GroupExists(WebDriver driver) {searchPage.GroupExists(driver);}

    @Step
    public void checkSearchResult_GroupTitle(String group, WebDriver driver) {searchPage.checkSearchResult_GroupTitle(group, driver);}

    @Step
    public void checkSearchResult_GroupDescription(WebDriver driver) {searchPage.checkSearchResult_GroupDescription(driver);}
}

