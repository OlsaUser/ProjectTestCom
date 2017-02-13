package com.ProjectTestCom.pages;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

//@DefaultUrl("http://synergybeta.devzone.dp.ua/en")
@DefaultUrl("http://mnassa.com/en")

@RunWith(SerenityRunner.class)
public class SearchPage extends PageObject {
    private final By fldSearch = By.xpath("//input[@id='header-search-field']");
    private final By result_Groups = By.xpath("//div[@class='search-dropdown-list search_list js-search-list']/a[3]");
    private final By result_Organization = By.xpath("//div[@class='search-dropdown-list search_list js-search-list']/a[2]");
    private final By result_User = By.xpath("//div[@class='search-dropdown-list search_list js-search-list']/a[1]");
    private final By result_Item_Project = By.xpath("//div[@class='search-dropdown-list js-search-list']/a[4]");
    private final By result_Item_Product = By.xpath("//div[@class='search-dropdown-list js-search-list']/a[1]");
    private final By result_Item_Service = By.xpath("//div[@class='search-dropdown-list js-search-list']/a[2]");
    private final By result_Item_Event = By.xpath("//div[@class='search-dropdown-list js-search-list']/a[3]");

   /* private final By result_Item_Product = By.xpath("//div[@class='search-dropdown-list search_list js-search-list']/a[3]");
    private final By result_Item_Service = By.xpath("//div[@class='search-dropdown-list search_list js-search-list']/a[2]");
    private final By result_Item_Event = By.xpath("//div[@class='search-dropdown-list search_list js-search-list']/a[1]");
    private final By result_Item_Partnership = By.xpath("//div[@class='search-dropdown-list search_list js-search-list']/a[4]");
    private final By result_User = By.xpath("//div[@class='search-dropdown-list1 -users js-search-list']/a[1]/span[1]");
    private final By result_Organization = By.xpath("//div[@class='search-dropdown-list1 -users js-search-list']/a[2]/span[1]");*/

    private final By result_Item_Skill = By.xpath("//");
    private final By result_Item_Interest = By.xpath("//");
    private final By result_Item_Product_Tag = By.xpath("//div[@class='search-dropdown-list js-search-list']/a[1]");
    private final By result_Item_Service_Tag = By.xpath("//div[@class='search-dropdown-list js-search-list']/a[2]");
    private final By result_Item_Event_Tag = By.xpath("//div[@class='search-dropdown-list js-search-list']/a[3]");
    private final By result_Item_Partnership_Tag = By.xpath("//div[@class='search-dropdown-list js-search-list']/a[4]");
    private final By Search_Popup = By.xpath("//form[@id='header-search-form']/div[2]/div/div");
    private final By UserListing = By.xpath("//section[@class='users-list']");
    private final By inListing_Users = By.xpath("//div[@class='user-descr']/a[1]");
    private final By ItemListing = By.xpath("//div[@class='itemslist-wrapper']");
    private final By EmptyResult = By.xpath("//div[@class='filter-results-count']");
    private final By linkService = By.xpath("//div[@class='nav-list-items']/a[3]/span");
    private final By itemTitle = By.xpath("//div[@class='card-name']/h3");
    private final By FullName = By.xpath("//a[@class='user-name']");
    private final By UserName = By.xpath("//span[@class='header-info-username']");
    private final By BriefInfo = By.xpath("//div[@class='break-word']");
    //private final By ListOfSkills = By.xpath("//div[@id='skills-interests']/div[1]");
    private final By ListOfSkills = By.xpath("//span[@class='text-overflow']");

    private final By ItemDescription = By.xpath("//p[@class='item-section-text item-description -user-text']");
    private final By ItemBlock = By.xpath("//a[@class='card-link']");
    private final By ItemTags = By.xpath("//ul[@class='tag-list list-unstyled']");

    //private final By itemTitle = By.xpath("//a[@class='item-link has-shadow']/h3");
    private final By emptySearchPage = By.xpath("//p[@class='users-list-empty-text']");
    private final By switchToOrg = By.xpath("//a[@class='nav-item js-nav-item']");
    private final By switchToUser = By.xpath("//ul[@class='nav navbar-nav navbar-nav-md']/li[2]");
    private final By closeResult = By.xpath("//a[@class='search-row-control btn btn-sm']");

    private final By groupBlock = By.xpath("//div[@class='group-item']");
    private final By groupTitle = By.xpath("//h3[@class='group-item-name']");
    private final By groupDescription = By.xpath("//span[@class='header-info-descr-text']");
    private final By groupSkills = By.xpath("//");
    private final By EmptyGroupSearch = By.xpath("//a[@class='btn btn-blue-primary create-btn']");

    public void clearField() {
        element(fldSearch).clear();
    }

    public void switchToOrg() {
        find(switchToOrg).click();
    }

    public void switchToUser() {
        element(switchToOrg).click();
    }

    public void closeResult(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 300);
        wt.until(ExpectedConditions.presenceOfElementLocated(closeResult));
        find(closeResult).click();
        wt.until(invisibilityOfElementLocated(closeResult));
    }

    public void clickField_searchBy(String text, WebDriver driver) {
        find(fldSearch).clear();
        element(fldSearch).sendKeys(text);
        WebDriverWait wt = new WebDriverWait (driver, 500);
        //wt.until(visibilityOfElementLocated(Search_Popup));
        wt.until(ExpectedConditions.presenceOfElementLocated(Search_Popup));
        wt.until(ExpectedConditions.visibilityOfElementLocated(result_User));
       /* WebElement el = find(Search_Popup);
        Assert.assertTrue(el.isDisplayed());*/
    }

    public void selectSearchResult_byUser(String text, WebDriver driver) {
        WebElement element = driver.findElement(result_User);
        element.click();

        WebDriverWait wt = new WebDriverWait (driver, 600);
        // ждём исчезновения кнопки, то есть "выгрузки" страницы
        wt.until(stalenessOf(element));
        // ждём загрузки следующей страницы
        wt.until(visibilityOfElementLocated(UserListing));

        //find(inListing_Users).containsText(text);
       // wt.until(ExpectedConditions.textToBePresentInElementLocated(inListing_Users,text));
    }

    public void selectSearchResult_byOrganization(String text, WebDriver driver) {
        element(result_Organization).click();
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(visibilityOfElementLocated(UserListing));
        //wt.until(ExpectedConditions.textToBePresentInElementLocated(inListing_Users,text));
    }

    public void checkEmptySearchResult_User(String text, WebDriver driver) {
        element(result_User).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(emptySearchPage,"No users were found"));
    }

    public void checkEmptySearchResult_Item(String text, WebDriver driver) {
        element(result_Item_Product).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(emptySearchPage,"No users were found"));
    }
    public void selectSearchResult_ProductItem(String text, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(visibilityOfElementLocated(result_Item_Product));
        System.out.println(element(result_Item_Product).getText());
        element(result_Item_Product).click();
        //wt.until(visibilityOfElementLocated(ItemListing));
    }

    public boolean checkSearchResult_Item(String text, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 200);
        wt.until(visibilityOfElementLocated(ItemListing));
        wt.until(visibilityOfElementLocated(itemTitle));
        System.out.println("We search: " + text);
        List<WebElement> titles = driver.findElements(itemTitle);
        for (WebElement el : titles) {
            System.out.println(el.getText());
            if (el.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public void checkSearchResult_ItemDescription(String text, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 400);
        wt.until(visibilityOfElementLocated(EmptyResult));
        String counter = find(EmptyResult).getText();
        System.out.println("Counter: " + find(EmptyResult).getText());
        Assert.assertTrue(counter.contains("0"));

        /*find(ItemBlock).click();
        String name = find(ItemDescription).getText();
        System.out.println(find(ItemDescription).getText());
        Assert.assertTrue(name.contains(text));*/
    }

    public void checkSearchResult_ItemTags(String tag, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(visibilityOfElementLocated(ItemListing));

        find(ItemBlock).click();
        String name = find(ItemTags).getText();
        System.out.println(find(ItemTags).getText());
        Assert.assertTrue(name.contains(tag));
    }

    public void checkSearchResult_FullName(String text, WebDriver driver) {
        System.out.println(text);
        WebDriverWait wt = new WebDriverWait (driver, 350);
        wt.until(visibilityOfElementLocated(UserListing));
        wt.until(ExpectedConditions.presenceOfElementLocated(FullName));
        System.out.println(find(FullName).getText());
        String name=find(FullName).getText();
        Assert.assertTrue(text.contains(name));
    }

    public void checkSearchResult_UserName(String username, WebDriver driver) {
        WebDriverWait wt1 = new WebDriverWait (driver, 300);
        wt1.until(visibilityOfElementLocated(UserListing));

            find(FullName).click();
            WebDriverWait wt2 = new WebDriverWait (driver, 600);
            wt2.until(visibilityOfElementLocated(UserName));
            String name = find(UserName).getText();
            System.out.println(find(UserName).getText());
            Assert.assertTrue(name.contains(username));
    }

    public void checkSearchResult_BriefInfo(String info, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 600);
        wt.until(visibilityOfElementLocated(UserListing));

        find(FullName).click();
        wt.until(visibilityOfElementLocated(BriefInfo));
        String i = find(BriefInfo).getText();
        System.out.println(find(BriefInfo).getText());
        Assert.assertTrue(i.contains(info));
    }
    public void checkSearchResult_Skill(String skill, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 400);
        wt.until(visibilityOfElementLocated(UserListing));
        find(FullName).click();

        wt.until(visibilityOfAllElementsLocatedBy(ListOfSkills));
        System.out.println("We search: " + skill);
        List<WebElement> tag = driver.findElements(ListOfSkills);
        for (WebElement el : tag) {
            System.out.println(el.getText());
            if (el.getText().equals(skill))
                break;
            }
    }

    public void checkSearchResult_GroupTitle(String group, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(visibilityOfElementLocated(groupBlock));
        System.out.println("We search: " + group);
        System.out.println(find(groupTitle).getText());
        String name=find(groupTitle).getText();
        System.out.println(find(groupTitle).getText());
        Assert.assertTrue(name.contains(group));
    }

    public void checkSearchResult_GroupDescription(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(visibilityOfAllElementsLocatedBy(EmptyGroupSearch));
        String buttons=find(EmptyGroupSearch).getText();
        System.out.println("Buttons: " + buttons + "and empty search result");

        /*find(groupBlock).click();
        System.out.println(find(groupDescription).getText());
        String name=find(groupDescription).getText();
        Assert.assertTrue(name.contains(group));*/
    }

    public void selectSearchResult_ServiceItem(String text, WebDriver driver) {
        element(result_Item_Service).click();
        WebDriverWait wt = new WebDriverWait (driver, 300);
        wt.until(visibilityOfElementLocated(linkService));
        //wt.until(visibilityOfElementLocated(ItemListing));
    }

    public void selectSearchResult_EventItem(String text, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 300);
        wt.until(visibilityOfElementLocated(result_Item_Event));
        element(result_Item_Event).click();
        //wt.until(visibilityOfElementLocated(ItemListing));
    }

    public void selectSearchResult_PartnershipItem(String text, WebDriver driver) {
        element(result_Item_Project).click();
        WebDriverWait wt = new WebDriverWait (driver, 300);
        wt.until(visibilityOfElementLocated(ItemListing));
    }

    public void selectSearchResult_ProductTag(String text, WebDriver driver) {
        element(result_Item_Product_Tag).click();
        WebDriverWait wt = new WebDriverWait (driver, 400);
        wt.until(visibilityOfElementLocated(ItemListing));
    }

    public void selectSearchResult_ServiceTag(String text, WebDriver driver) {
        element(result_Item_Service_Tag).click();
        WebDriverWait wt = new WebDriverWait (driver, 400);
        wt.until(visibilityOfElementLocated(ItemListing));
    }

    public void selectSearchResult_EventTag(String text, WebDriver driver) {
        element(result_Item_Event_Tag).click();
        WebDriverWait wt = new WebDriverWait (driver, 400);
        wt.until(visibilityOfElementLocated(ItemListing));
    }

    public void selectSearchResult_PartnershipTag(String text, WebDriver driver) {
        element(result_Item_Partnership_Tag).click();
        WebDriverWait wt = new WebDriverWait (driver, 400);
        wt.until(visibilityOfElementLocated(ItemListing));
    }

    public void selectSearchResult_Group(String title, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 500);
        wt.until(visibilityOfElementLocated(result_Groups));
        element(result_Groups).click();
        //wt.until(visibilityOfElementLocated(groupBlock));
    }
    public void GroupExists(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(visibilityOfElementLocated(groupBlock));
        System.out.println("NOTE: Group Exists in listing");
    }
}
