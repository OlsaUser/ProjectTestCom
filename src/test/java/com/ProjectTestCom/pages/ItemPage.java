package com.ProjectTestCom.pages;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import javafx.scene.control.ScrollToEvent;
import jnr.constants.Constant;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.components.FileToUpload;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.grid.web.servlet.handler.SeleniumBasedRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.window;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.seleniumhq.jetty7.util.LazyList.add;
import static org.yecht.LevelStatus.end;
import static org.yecht.LevelStatus.pause;

/**
 * Created by olsa on 4/29/2016.
 */
//@DefaultUrl("http://synergy.devzone.dp.ua/en/#!login")
//@DefaultUrl("http://mnassa.com/en/#!login")

@RunWith(SerenityRunner.class)
public class ItemPage extends PageObject {

    private  HashMap<String, String> category = new HashMap();
    private HashMap<String, Integer> ID = new HashMap();

    private final By buttonAdd_Menu = By.xpath("//button[@class='header-btn btn btn-red-primary']");
    private final By buttonAdd_listing = By.xpath("//a[@class='card-add']");
    private final By ItemSettingsMenu = By.xpath("//button[@class='card-edit-toggle']");
    private final By ViewMenu = By.xpath("//ul[@class='dropdown-menu dropdown-card']/li[1]");
    private final By EditMenu = By.xpath("//ul[@class='dropdown-menu dropdown-card']/li[2]");
    private final By StatusMenu = By.xpath("//ul[@class='dropdown-menu dropdown-card']/li[3]");
    private final By DeleteMenu = By.xpath("//ul[@class='dropdown-menu dropdown-card']/li[4]");
    private final By fieldComment = By.xpath("//section[@class='comments white-bg']//textarea");
    private final By btnPost = By.xpath("//section[@class='comments white-bg']//a");
    private final By txtComment = By.xpath("//div[@class='comment-body']");

    private final By btnDelete = By.xpath("//div[@id='del_item_dlg']//div[@class='modal-body']//div[@class='text-center']/button[2]");
    private final By btnCancel = By.xpath("//div[@class='modal-content']//div[@class='text-center']/button[1]");

    private final By EditMenus_items = By.xpath("//div[@class='card-edit']/div");
    private final String editCurrentItem = "..//a[contains(@href, '#!edit/item')]";
    private final By itemsBlocks = By.xpath("//div[@class='card-photo']");
    private final String itemsCovers= "..//img";

    private final By types = By.xpath("//div[@class='header-add dropdown open']/div[@class='header-dropdown']/a");
    private final By Supply = By.xpath("//div[@class='text-center add-item-header-button-block']/button[1]");
    private final By Demand = By.xpath("//div[@class='text-center add-item-header-button-block']/button[2]");

    //Common block
    private final By fieldTitle = By.xpath("//input[@can-value='mi_title']");
    private final By fieldDescription = By.xpath("//textarea[@can-value='mi_descr']");

    private final By fieldTag = By.xpath("//li[@class='select2-search-field']//input");
    private final By Tag1 = By.xpath("//span[@class='select2-match']");

    private final By fieldLocation = By.xpath("//div[@id='s2id_cities-google']//input");
    private final By Location = By.xpath("//div[@class='select2-result-label']");

    private final By menuCategory = By.id("s2id_main_categs");
    private final By Category1 = By.xpath("//ul[@class='select2-results']//li[1]");
    private final By Category2 = By.xpath("//ul[@class='select2-results']//li[2]");
    private final By Category3 = By.xpath("//ul[@class='select2-results']//li[3]");

    private final By menuSubCategory = By.id("s2id_sub_categs");
    private final By SubCategory1 = By.xpath("//ul[@class='select2-results']//li[1]");
    private final By SubCategory2 = By.xpath("//ul[@class='select2-results']//li[2]");
    private final By SubCategory3 = By.xpath("//ul[@class='select2-results']//li[3]");

    //For Service
    private final By fieldYearsOfExperience = By.id("s2id_mi_serv_expirience");
    private final By YearsOfExperienceLess = By.xpath("//ul[@class='select2-results']/li[1]");
    private final By YearsOfExperienceFew = By.xpath("//ul[@class='select2-results']/li[2]");
    private final By YearsOfExperienceMore = By.xpath("//ul[@class='select2-results']/li[3]");

    private final By ServiceAvailableNow = By.xpath("//");
    private final By ServiceWillBeAvailable = By.xpath(".//*[@id='mainDetailes']/div/div/div/div[1]/div[1]/label[2]/span");
    private final By ServiceWillBeAvailableSoon = By.xpath(".//*[@id='mainDetailes']/div/div/div/div[1]/div[1]/label[3]/span");

    private final By serviceOnline = By.xpath("//div[@id='mainDetailes']/div/div/div/div[2]/label/span");

    //For Service and Product
    private final By fieldPrice = By.xpath("//input[@can-value='mi_sr']");
    private final By fieldPer = By.id("mi_sr_type_1");
    private final By Fixed = By.xpath("//span[contains(text(),'Fixed')]");
    private final By fieldFree = By.xpath("//span[contains(text(),'Free')]");
    private final By fieldToBeDiscussed = By.xpath("//span[contains(text(),'To be discussed')]");

    private final By PaymentMethodVisa = By.xpath("//div[@id='mainDetailes']/div/div/div/div[15]/div/label[1]/span/span");
    private final By PaymentMethodMasterCard = By.xpath("//div[@id='mainDetailes']/div/div/div/div[15]/div/label[2]/span/span");
    private final By PaymentMethodPayPal = By.xpath("//div[@id='mainDetailes']/div/div/div/div[15]/div/label[3]/span/span");
    private final By PaymentMethodDebitCard = By.xpath("//div[@id='mainDetailes']/div/div/div/div[15]/div/label[4]/span/span");
    private final By PaymentMethodCash = By.xpath("//div[@id='mainDetailes']/div/div/div/div[15]/div/label[5]/span/span");

    private final By fieldAdvancedPayment = By.id("s2id_mi_pre_pay");
    private final By AdvancedPaymentValue10 = By.xpath("//ul[@class='select2-results']//li[2]");
    private final By AdvancedPaymentValue25 = By.xpath("//ul[@class='select2-results']//li[3]");
    private final By AdvancedPaymentValue50 = By.xpath("//ul[@class='select2-results']//li[4]");
    private final By AdvancedPaymentValue100 = By.xpath("//ul[@class='select2-results']//li[5]");

    //For Product
    private final By DHL = By.xpath("//div[@id='mainDetailes']/div/div/div/div[16]/label[2]/span/span");
    private final By TNT = By.xpath("//div[@id='mainDetailes']/div/div/div/div[16]/label[3]/span/span");
    private final By Aramex = By.xpath("//div[@id='mainDetailes']/div/div/div/div[16]/label[4]/span/span");
    private final By PickUp = By.xpath("//div[@id='mainDetailes']/div/div/div/div[16]/label[5]/span/span");
    private final By HomeDelivery = By.xpath("//div[@id='mainDetailes']/div/div/div/div[16]/label[6]/span/span");
    private final By SaudiPost = By.xpath("//div[@id='mainDetailes']/div/div/div/div[16]/label[7]/span/span");
    private final By Other = By.xpath("//div[@id='mainDetailes']/div/div/div/div[16]/label[8]/span/span");

    private final By AvailabilityNow = By.xpath("//span[contains(text(),'Available now!')]");
    private final By OutOfStock = By.xpath(".//*[@id='mainDetailes']/div/div/div/div[3]/div/label[2]/span");
    private final By Sold = By.xpath("//span[contains(text(),'No longer available')]");

    private final By ConditionNew = By.xpath("//span[@for='mi_prod_cond_1']");
    private final By ConditionUsed = By.xpath("//span[@for='mi_prod_cond_2']");

    //For Event
    private final By EventType = By.xpath("//div[@id='s2id_mi_ev_type']");
    private final By EventTypeAttraction = By.xpath("//ul[@class='select2-results']/li[2]/div");
    private final By AudienceMales = By.xpath("//div[@id='mainDetailes']/div/div/div/div[5]/div/label[2]");
    private final By AudienceFemales = By.xpath("//div[@id='mainDetailes']/div/div/div/div[5]/div/label[3]");
    private final By AudienceFamilies = By.xpath("//div[@id='mainDetailes']/div/div/div/div[5]/div/label[4]");
    private final By AudienceChildren = By.xpath("//div[@id='mainDetailes']/div/div/div/div[5]/div/label[5]");
    private final By AudienceAnyone = By.xpath("//div[@id='mainDetailes']/div/div/div/div[5]/div/label[1]");

    private final By RegistrationOpen = By.xpath("//div[@id='mainDetailes']/div/div/div/div[23]/div/label[1]");
    private final By RegistrationClosed = By.xpath("//div[@id='mainDetailes']/div/div/div/div[23]/div/label[2]");
    private final By EventCanceled = By.xpath("//div[@id='mainDetailes']/div/div/div/div[23]/div/label[3]");
    private final By EventEnded = By.xpath("//div[@id='mainDetailes']/div/div/div/div[23]/div/label[4]");

    private final By Address = By.xpath("//input[@id='pac-input']");
    private final By AddressStreet = By.xpath("//div[@class='pac-container pac-logo']/div[1]//span[@class='pac-item-query']");

    private final By TicketTypeFree = By.xpath("//span[contains(text(),'Free')]");
    private final By TicketTypePaid = By.xpath("//span[contains(text(),'Paid')]");
    private final By TicketTypeFree_ar = By.xpath("//span[contains(text(),'مجانية')]");
    private final By TicketTypePaid_ar = By.xpath("//span[contains(text(),'مدفوع')]");
    private final By TicketPrice = By.xpath("//input[@can-value='mi_ev_tickets_sr']");

    private final By organizerName = By.xpath("//input[@id='mi_ev_organizer']");

    //For Project
    private final By registeredYes = By.xpath("//div[@id='mainDetailes']/div/div/div/div[23]/div/label[1]");
    private final By registeredNo = By.xpath("//div[@id='mainDetailes']/div/div/div/div[23]/div/label[2]");
    private final By registeredInProcess = By.xpath("//div[@id='mainDetailes']/div/div/div/div[23]/div/label[3]/span");

    private final By partnerYes = By.xpath("//div[@id='mainDetailes']/div/div/div/div[24]/div/label[1]");
    private final By partnerNo = By.xpath("//div[@id='mainDetailes']/div/div/div/div[24]/div/label[2]");

    private final By projectIdea = By.xpath("//div[@class='col-sm-8']/div[13]/div[1]/label");
    private final By projectStartingUp = By.xpath("//div[@class='col-sm-8']/div[13]/div[2]/label");
    private final By projectRevenueMaking = By.xpath("//div[@class='col-sm-8']/div[13]/div[3]/label");
    private final By projectStudy = By.xpath("//div[@id='mainDetailes']/div/div/div/div[21]/div/label[4]");
    private final By projectOther = By.xpath("//div[@class='col-sm-8']/div[13]/div[5]/label");
    private final By fldProjectOther = By.xpath("//div[@class='col-sm-8']/div[14]//textarea");

    private final By FinancialSupport = By.xpath("//span[contains(text(),'Financial support')]");
    private final By FinancialSupportPrice = By.xpath("//input[@can-value='mi_prj_partnership_sr']");
    private final By ManagementSupport = By.xpath("//span[contains(text(),'Management support')]");
    private final By fldManagementSupport = By.xpath("//textarea[@can-value='mi_prj_partnership_descr']");

    //Common block
    private final By collapseMainInfo = By.xpath("//a[@aria-controls='basicInfo']");
    private final By collapseMainDetails = By.xpath("//a[@aria-controls='mainDetailes']");
    private final By collapseContent = By.xpath("//a[@aria-controls='content']");
    private final By collapseStatus = By.xpath("//a[@aria-controls='itemStatus']");

    private final By Content = By.id("content");
    private final By ContentText = By.xpath(".//*[@id='content']/div/div[1]/div/ul/li[1]/a");
    private final By fieldText = By.id("ql-editor-1");

    private final By ContentPhoto = By.xpath(".//*[@id='content']/div/div[1]/div/ul/li[1]/a");
    private final By imageLink = By.xpath("//a[@id='pick_item_files']");
    private final By imageDelete = By.xpath("//div[@can-click='remove_item_img']");
    private final By imageCover = By.xpath("//a[@can-click='set_img_main']");
    private final By Cover = By.xpath("//img[@class='card-photo-image']");
    private final By videoListing = By.xpath("//div[@class='added-link-block table-block-xxs']");
    private final String videoCovers= "..//img";
    private final String linkMakeCoverVideo = "..//div[@can-click='set_vid_img_main']";

    private final By ContentVideo = By.xpath("//div[@class='row']//ul[@class='nav nav-tabs nav-justified']//li[2]");
    private final By fieldVideoLink1 = By.xpath(".//*[@id='video']/div[2]/input");
    private final By fieldVideoLink2 = By.xpath("//div[@id='video']//div[3]/input");
    private final By fieldVideoLink3 = By.xpath("//div[@id='video']//div[4]/input");
    private final By fieldVideoLink4 = By.xpath("//div[@id='video']//div[5]/input");
    private final By fieldVideoLink5 = By.xpath("//div[@id='video']//div[6]/input");
    private final By textCoverImage = By.xpath("//div[@id='video']/div[2]/div[1]");
    private final By textMakeCover1 = By.xpath("//div[@id='video']/div[3]/div[1]");
    private final By textMakeCover2 = By.xpath("//div[@id='video']/div[4]/div[1]");
    private final By textMakeCover3 = By.xpath("//div[@id='video']/div[5]/div[1]");
    private final By textMakeCover4 = By.xpath("//div[@id='video']/div[6]/div[1]");

    private final By ContentAudio = By.xpath(".//*[@id='content']/div/div[1]/div/ul/li[3]/a");
    private final By fieldAudioLink1 = By.xpath("//div[@id='audio']//div[2]/input");
    private final By fieldAudioLink2 = By.xpath("//div[@id='audio']//div[4]/input");
    private final By fieldAudioLink3 = By.xpath("//div[@id='audio']//div[6]/input");
    private final By fieldAudioLink4 = By.xpath("//div[@id='audio']//div[8]/input");
    private final By fieldAudioLink5 = By.xpath("//div[@id='audio']//div[10]/input");
    private final By iconDelete1 = By.xpath("//div[@id='audio']/div[2]/div");
    private final By iconDelete2 = By.xpath("//div[@id='audio']/div[4]/div");
    private final By iconDelete3 = By.xpath("//div[@id='audio']/div[6]/div");
    private final By iconDelete4 = By.xpath("//div[@id='audio']/div[8]/div");
    private final By iconDelete5 = By.xpath("//div[@id='audio']/div[10]/div");

    private final By statusActivate = By.xpath("//span[contains(text(),'Activate')]");
    private final By statusPeriod = By.xpath("//span[contains(text(),'Activate from/to')]");
    private final By statusDeactivate = By.xpath("//span[contains(text(),'Inactive')]");

    private final By btnSave = By.xpath("//div[@class='container']//button[@can-click='upd_item']");
    private final By btnSave2 = By.xpath("//div[@class='item-live-preview-bottom container']//button[@can-click='upd_item']");
    private final By SuccessPopup = By.xpath("//div[@id='message_modal']/div");
    private final By SuccessPopupOk = By.xpath(".//*[@id='message_modal']/div/div/div[3]/button");

    private final By lblTitleError = By.xpath("//div[@id='basicInfo']/div/div/div/div[1]/div[2]");
    private final By lblCategoryError = By.xpath("//div[@class='select2-wrapper']/div[2]");
    private final By lblSubCategoryError = By.xpath("//div[@id='basicInfo']/div/div/div/div[3]/div/div");
    private final By lblPriceError = By.xpath(".//*[@id='mainDetailes']/div/div/div/div[11]/div[3]");
    private final By lblPhotoError = By.xpath("//div[@id='content']//div[@class='error_message_static']");

    //Visible elements
    private final By ItemContent = By.xpath("//button[@class='close img-circle']");
    private final By ItemContentListing = By.xpath("//div[@class='itemslist-wrapper']");
    private final By ItemWasSuccessfullyDeleted = By.xpath("//div[@id='message_modal']/div[1]");
    private final By btnOKinSuccessPopup = By.xpath("//div[@class='modal-content']/div[3]/button");

    private final By itemContaner = By.xpath("//div[@class='container']");

    //Elements in Preview
    private final By breadcrumb_ItemType = By.xpath("//div[@class='item-breadcrumbs']/div[1]/a");
    private final By breadcrumb_ItemCategory = By.xpath("//div[@class='item-breadcrumbs']/div[2]/a");
    private final By breadcrumb_ItemSubCategory = By.xpath("//div[@class='item-breadcrumbs']/div[3]/a");
    private final By breadcrumb_ItemTitle = By.xpath("//div[@class='item-breadcrumbs']/div[4]/span[2]");
    private final By inappropriateFormItem = By.id("report_submit_btn");

    private final By UserName_Owner = By.xpath("//div[@class='item-user-name']");
    private final By Location_Owner = By.xpath("//div[@class='item-user-place']");
    private final By FollowButton_Owner = By.xpath("//button[@can-click='handle_follower']");
    private final By MessageButton_Owner = By.xpath("//a[@class='btn btn-blue-primary btn-sm item-user-message']");
    private final By About_Owner = By.xpath("//div[@class='item-user-about']");
    private final By MemberSince_Owner = By.xpath("//div[@class='item-user-member']");

    private final By itemDiscoverPage = By.xpath("//a[@class='card-link']");
    private final By itemBlock = By.xpath("//div[@class='itemslist-wrapper']/div[@class='row']/div[2]");
    private final By filterHeadTitle = By.xpath("//h4[@class='filter-head-title']");
    private final By filterBlockContainer = By.xpath("//div[@class='filter-block-container']");
    private final By filterGroupCategory = By.id("filter-group-category");
    private final By filterGroupPrice = By.id("filter-group-price");
    private final By filterGroupLocation = By.id("filter-group-location");
    private final By filterGroupGender = By.id("filter-group-gender");
    private final By filterResultsCount = By.xpath("//div[@class='filter-results-count -has-results-list']");
    private final By itemSort = By.id("s2id_items_sort");
    private final By itemUserImg = By.xpath("//img[@class='card-user-photo']");
    private final By imgResponsive = By.xpath("//img[@class='img-responsive']");
    //private final By handleFavorite = By.xpath("//a[@can-click='handle_favorite']");
    private final By handleFavorite = By.xpath("//button[@can-click='handle_favorite']");
    //private final By handleLike = By.xpath("//span[@can-click='handle_like']");
    private final By handleLike = By.xpath("//button[@can-click='handle_like']");
    //private final By handleView = By.xpath("//div[@class='inline-block']");
    private final By handleReposts = By.xpath("//div[@can-mouseleave='hide_reposts_popover']/button");
    //private final By itemType = By.xpath("//div[@class='pull-left']");
    private final By itemType = By.xpath("//div[@class='card-name']");
    //private final By priceSpace = By.xpath("//span[@class='price one-space']");
    private final By priceSpace = By.xpath("//div[@class='card-price-in']");

    private final By itemBlockSpace = By.xpath("//a[@class='card-link']");
    private final By ShareItemMenu = By.xpath("//div[@class='pull-right view-item-share rel']");
    private final By ShareItemToWall = By.xpath("//a[@can-click='post_item_on_my_wall']");
    private final By ShareItemToGroup = By.xpath("//a[@data-target='#postItemToMyGroupModal']");
    private final By ShareGroupMenu = By.xpath("//div[@id='s2id_post_item_to_group_list']");
    private final By ShareSelectGroup = By.xpath("//div[contains(text(),'Group Title 1')]");
    private final By ShareItemInformText = By.xpath("//div[@class='user-in']/div");
    private final By ShareRepostHeader = By.xpath("//div[@class='feed-head-reaction-text']");
    private final By SharebtnPost = By.xpath("//button[@can-click='post_item_to_group']");

    private final By Calendar = By.xpath("//div[@class='datetimepicker datetimepicker-dropdown-bottom-left dropdown-menu']");
    private final By EventFrom = By.xpath("//div[@id='mi_ev_date_from']/span[2]");
    private final By EventTo = By.id("mi_ev_date_till");
    private final By FromTodayDay = By.xpath("//div[@class='datetimepicker-days']//tr[4]/td[6]");
    private final By TodayHour = By.xpath("html/body/div[4]/div[2]/table/tbody/tr/td/span[18]");
    private final By TillTodayDay = By.xpath("//td[@class='day active']");
    private final By RegistrationFrom = By.id("mi_ev_reg_date_from");
    private final By RegistrationTo = By.id("mi_ev_reg_date_till");

    //Request Form
    private final By btnRequest = By.xpath("//button[@can-click='init_item_request_message']");
    private final By RequestButton = By.xpath("//button[@can-click='send_request_item']");
    private final By RequestText = By.id("item_request_message");
    private final By RequestPopup = By.xpath("//div[@class='modal-dialog modal-request']");
    private final By RequestTitle = By.id("login-modal-label");
    private final By RequestItemTitle = By.xpath("//div[@class='request-item-name']");
    private final By RequestMessageLabel = By.xpath("//label[@class='request-message-label']");
    private final By RequestMessageAttachList = By.xpath("//div[@class='im-attach-box -request']");
    private final By RequestImgAvatar = By.xpath("//img[@class='request-item-img img-rounded pull-left']");

    //Checking values on Item Priview
    private final By price_event_now = By.xpath("//h3[@class='item-price']");

    String parentWindowHandler;

    private final HashMap<Integer, String> itemUrl = new HashMap();

    public boolean checkValueExists(String value_exp, String value_now) {
        String text_now_value = getDriver().findElement(By.xpath(value_now)).getText();
        System.out.println(text_now_value);
        System.out.println(value_exp);

        if ((text_now_value.contains(value_exp))) {
            System.out.println("Success ");
            return true;
        } else {
            System.out.println("Fail case ");
            return false;
        }
    }

    public boolean checkElementPresents(String elem_now) {
        WebElement el = getDriver().findElement(By.xpath(elem_now));
        if (el.isDisplayed()) {
            return true;
        } else System.out.println("Fail case ");
        return false;
    }

    public void openItemSettingsMenu() {
        element(ItemSettingsMenu).waitUntilClickable();
        element(ItemSettingsMenu).click();}

    public void EditSpecialItem(String itemID) {
        WebElement ed;


        List<WebElement> menus = getDriver().findElements(EditMenus_items);
        for (WebElement el : menus) {
            el.click();
            String tt = el.findElement(By.xpath(editCurrentItem)).getAttribute("href");
            if (tt.contains(itemID))
            {
                ed= el.findElement(By.xpath(editCurrentItem));
                ed.click();
                System.out.println("Item Found!");
                break;
        }
        else
            System.out.println("Item not Found!");
    }
}

    public void selectDeleteMenu() {
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        jse1.executeScript("window.scrollBy(0,-100)", "");
        element(DeleteMenu).click();
    }

    public void selectViewMenu(WebDriver driver) {
        element(ViewMenu).click();
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(itemContaner));

        //String urlI = driver.getCurrentUrl();

        itemUrl.put(1, driver.getCurrentUrl());
    }

    public void checkCommentAdded(String comment) {
        String m = getDriver().findElement(txtComment).getText();
        System.out.println("Real: " + m);
        System.out.println("Exp: " + comment);

       assertEquals("Wrong Comment!", m, comment);
    }

    public void addComment(WebDriver driver, String comment) {
        element(fieldComment).sendKeys(comment);
        element(btnPost).click();
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(txtComment));
    }

    public void selectEditMenu() {
        element(EditMenu).click();
    }

    public void selectStatusMenu() {
        element(StatusMenu).click();
    }

    public void clickDeleteButton(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 200);
        wt.until(ExpectedConditions.elementToBeClickable(btnDelete));
        find(btnDelete);
        find(btnDelete).waitUntilClickable();
        element(btnDelete).click();
        //find(btnDelete).click();
        //wt.until(ExpectedConditions.invisibilityOfElementLocated(btnDelete));
        wt.until(ExpectedConditions.visibilityOfElementLocated(btnOKinSuccessPopup));
    }

    public void checkItemDeleted(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 150);
        wt.until(ExpectedConditions.presenceOfElementLocated(btnOKinSuccessPopup));
        find(btnOKinSuccessPopup);
        element(btnOKinSuccessPopup).click();
        wt.until(ExpectedConditions.invisibilityOfElementLocated(btnOKinSuccessPopup));
    }

    public void clickCancelButton() {
        element(btnCancel).click();
    }

    public void clickAddButton(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 400);
        wt.until(ExpectedConditions.presenceOfElementLocated(buttonAdd_Menu));
        wt.until(ExpectedConditions.elementToBeClickable(buttonAdd_Menu));
        find(buttonAdd_Menu).click();
        wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(types));
    }

    public void openAddItemPageByClickingOnButtonInListing() {
        element(buttonAdd_listing).click();
    }

    public void selectItemType(String ItemType, WebDriver driver) {
       /* WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(types));*/
        if (!find(types).isEnabled())
            find(types).waitUntilEnabled();
        System.out.println(ItemType);

        List<WebElement> type = driver.findElements(types);
        for (WebElement listType : type) {
            if (listType.getText().contains(ItemType)) {
                listType.isDisplayed();
                listType.click();
                find(Supply).waitUntilClickable();
                /*WebDriverWait wt = new WebDriverWait (driver, 99);
                wt.until(ExpectedConditions.presenceOfElementLocated(Supply));*/
                break;
            }
        }
    }

    public void selectDemand() {
        element(Demand).click();
    }

    public void selectSupply() {
        parentWindowHandler = getDriver().getWindowHandle();
        element(Supply).click();
    }

    public void typeIntoField(By locator, String value) {
        find(locator).clear();
        find(locator).sendKeys(value);
    }

    public void enterBasicInfo(String Title, String Description) {
        typeIntoField(fieldTitle, Title);
        typeIntoField(fieldDescription, Description);
    }

    public void enterTag(String Tag) {
        find(fieldTag).sendKeys(Tag);
        find(Tag1).click();
    }

    public void enterLocation(String location) {
        find(fieldLocation).sendKeys(location);
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        find(Location).click();
    }

    public void enterAddress(String address) {
        find(Address).sendKeys(address);
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        find(AddressStreet).click();
    }

    public void clearTitle() {
        find(fieldTitle).clear();
    }

    public void clearDescription() {
        find(fieldDescription).clear();
    }

    public void selectCategory1() {
        find(menuCategory).click();
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        String categoryName = find(Category1).getText();
        find(Category1).click();

        find(menuSubCategory).click();
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        String subcategoryName = find(SubCategory1).getText();
        find(SubCategory1).click();
        category.clear();
        category.put(categoryName, subcategoryName);
    }

    public void selectCategory2() {
        find(menuCategory).click();
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        String categoryName = find(Category2).getText();
        find(Category2).click();

        find(menuSubCategory).click();
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        String subcategoryName = find(SubCategory2).getText();
        find(SubCategory2).click();
        category.clear();
        category.put(categoryName, subcategoryName);
    }

    public void selectCategory3() {
        find(menuCategory).click();
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        String categoryName = find(Category3).getText();
        find(Category3).click();

        find(menuSubCategory).click();
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        String subcategoryName = find(SubCategory3).getText();
        find(SubCategory3).click();
        category.clear();
        category.put(categoryName, subcategoryName);
    }

    public void enterPrice(String value, String Per) {
        find(Fixed).click();
        clearPrice();
        find(fieldPrice).sendKeys(value);
        clearPer();
        find(fieldPer).sendKeys(Per);
    }

    public void clearPrice() {
        find(fieldPrice).clear();
    }

    public void clearPer() {
        find(fieldPer).clear();
    }

    public void enterPriceFree() {
        find(fieldFree).click();
    }

    public void enterPriceToBeDiscussed() {
        find(fieldToBeDiscussed).click();
    }

    public void selectYearsOfExperienceLess() {
        find(fieldYearsOfExperience).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(YearsOfExperienceLess).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
    }

    public void selectYearsOfExperienceFew() {
        find(fieldYearsOfExperience).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(YearsOfExperienceFew).click();
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
    }

    public void selectYearsOfExperienceMore() {
        find(fieldYearsOfExperience).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(YearsOfExperienceMore).click();
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
    }

    public void selectMethodVisa() {find(PaymentMethodVisa).click();}

    public void selectMethodMasterCard() {
        find(PaymentMethodMasterCard).click();
    }

    public void selectMethodPayPal() {find(PaymentMethodPayPal).click();}

    public void selectMethodDebitCard() {find(PaymentMethodDebitCard).click();}

    public void selectMethodCash() {find(PaymentMethodCash).click();}

    public void selectDeliveryMethodDHL() {find(DHL).click();}

    public void selectDeliveryMethodTNT() {find(TNT).click();}

    public void selectDeliveryMethodAramex() {find(Aramex).click();}

    public void selectDeliveryMethodPickUp() {find(PickUp).click();}

    public void selectDeliveryMethodHomeDelivery() {find(HomeDelivery).click();}

    public void selectDeliveryMethodSaudiPost() {find(SaudiPost).click();}

    public void selectDeliveryMethodOther() {find(Other).click();}

    public void selectAvailabilityNow() {find(AvailabilityNow).click();}

    public void selectAvailabilityOutOfStock() {
        find(OutOfStock).waitUntilVisible();
        find(OutOfStock).click();
    }

    public void selectAvailabilitySold() {find(Sold).click();}

    public void selectConditionNew() {find(ConditionNew).click();}

    public void selectConditionUsed() {find(ConditionUsed).click();}

    public void collapseMainInfo() {find(collapseMainInfo).click();}

    public void collapseMainDetails() {find(collapseMainDetails).click();}

    public void collapseContent() {find(collapseContent).click();}

    public void selectServiceWillBeAvailable() {
        find(ServiceWillBeAvailable).click();
    }

    public void selectServiceWillBeAvailableSoon() {
        find(ServiceWillBeAvailableSoon).click();
    }

    public void collapseStatus() {find(collapseStatus).click();}

    public void clickServiceOnline() {find(serviceOnline).click();}

    public void selectAdvancedPayment10() {
        find(fieldAdvancedPayment).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(AdvancedPaymentValue10).click();
    }

    public void selectAdvancedPayment25() {
        find(fieldAdvancedPayment).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(AdvancedPaymentValue25).click();
    }

    public void selectAdvancedPayment50() {
        find(fieldAdvancedPayment).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(AdvancedPaymentValue50).click();
    }

    public void selectAdvancedPayment100() {
        find(fieldAdvancedPayment).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(AdvancedPaymentValue100).click();
    }

    public void selectEventType() {
        find(EventType).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(EventTypeAttraction).click();
    }

    public void selectAudienceMales() {find(AudienceMales).click();}

    public void selectAudienceFemales() {find(AudienceFemales).click();}

    public void selectAudienceFamilies() {find(AudienceFamilies).click();}

    public void selectAudienceChildren() {find(AudienceChildren).click();}

    public void selectAudienceAnyone() {find(AudienceAnyone).click();}

    public void selectRegistrationOpen() {find(RegistrationOpen).click();}

    public void selectRegistrationClosed() {find(RegistrationClosed).click();}

    public void selectEventCanceled() {find(EventCanceled).click();}

    public void selectEventEnded() {find(EventEnded).click();}

    public void selectTicketTypeFree() {find(TicketTypeFree).click();}

    public void selectTicketTypePaid(String ticketPrice) {
        find(TicketTypePaid).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(TicketPrice).sendKeys(ticketPrice);
    }
    public void selectTicketTypePaid_ar(String ticketPrice) {
        find(TicketTypePaid_ar).click();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(TicketPrice).sendKeys(ticketPrice);
    }

    public void enterOrganizerName(String OrganizerName) {find(organizerName).sendKeys(OrganizerName);}

    public void selectRegisteredYes() {find(registeredYes).click();}

    public void selectRegisteredNo() {find(registeredNo).click();}

    public void selectRegisteredInProcess() {find(registeredInProcess).click();}

    public void selectPartnerYes() {find(partnerYes).click();}

    public void selectPartnerNo() {find(partnerNo).click();}

    public void selectProjectStudy() {find(projectStudy).click();}

    public void FinancialSupport(String financialSupportPrice) {
        find(FinancialSupport).click();
        find(FinancialSupportPrice).sendKeys(financialSupportPrice);
    }

    public void ManagementSupport(String txtManagementSupport) {
        find(ManagementSupport).click();
        find(fldManagementSupport).sendKeys(txtManagementSupport);
    }

    public void TextContent(String TextContent) {
        find(Content).click();
        find(ContentText).click();
        clearText();
        find(fieldText).sendKeys(TextContent);
    }

    public void clearText() {
        find(fieldText).clear();
    }

    public void ImageContent() {
        find(ContentPhoto).click();

        /*find(imageLink).click();
        JFrame parentFrame = new JFrame();

        JFileChooser chooser = new JFileChooser("C:/Users/olsa/IdeaProjects/ProjectTestCom/src/test/resources/images");
        chooser.setSelectedFile(new File("music.png"));*/

        //FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
        //chooser.setFileFilter(filter);

      /*  int returnVal = chooser.showOpenDialog(parentFrame);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();

            chooser.approveSelection();
            JOptionPane.showMessageDialog(null, "You selected " + file);
        }
            else if (returnVal == JFileChooser.CANCEL_OPTION)
            {
                JOptionPane.showMessageDialog(null, "You selected nothing.");
            }
            else if (returnVal == JFileChooser.ERROR_OPTION)
            {
                JOptionPane.showMessageDialog(null, "An error occurred.");
            }*/
        }

    public void deleteImage() {
        find(imageDelete).click();
    }

    public void changeCoverImage() {
        String imageID1 = find(imageCover).getAttribute("can-value");
        System.out.println(imageID1);
        ID.put(imageID1, 1);
        Set ks=ID.keySet();
        System.out.println("Key set values are: " + ks);
        find(imageCover).click();
    }

    public void changeCoverVideo() {
        List<WebElement> videos = getDriver().findElements(videoListing);
        for (WebElement el : videos) {
            String itemVideoID = el.findElement(By.xpath(videoCovers)).getAttribute("src");
            System.out.println(itemVideoID);
            ID.put(itemVideoID, 2);
            Set ks = ID.keySet();
            System.out.println("Key set values are: " + ks);
            el.findElement(By.xpath(linkMakeCoverVideo)).click();
            break;
        }
    }

    public boolean checkNewCover() {
        boolean first = true;

        List<WebElement> items = getDriver().findElements(itemsBlocks);
        for (WebElement el : items) {
            String itemImageID = el.findElement(By.xpath(itemsCovers)).getAttribute("src");
            System.out.println(itemImageID);

            for (HashMap.Entry<String, Integer> entry : ID.entrySet()) {
                String key = entry.getKey();
                System.out.println("Key: " + key);

                if(itemImageID.contains(key))
                {
                System.out.println("Cover OK!");
                    first=true;
            }
                else {
                    System.out.println("Cover is wrong!");
                    first = false;
                }
        }
      }
        return first;
    }

    public void VideoContent() {
        find(ContentVideo).click();
    }

    public void VideoContent1(String VideoLink1) {
        find(ContentVideo).click();
        clearVideo();
        find(fieldVideoLink1).sendKeys(VideoLink1);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textCoverImage);
        find(textCoverImage);
        find(fieldVideoLink2);
    }
    public void VideoContent2(String VideoLink1, String VideoLink2) {
        find(ContentVideo).click();
        find(fieldVideoLink1).sendKeys(VideoLink1);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textCoverImage);
        find(textCoverImage);
        find(fieldVideoLink2).sendKeys(VideoLink2);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textMakeCover1);
        find(textMakeCover1);
    }
    public void VideoContent3(String VideoLink1, String VideoLink2, String VideoLink3) {
        find(ContentVideo).click();
        find(fieldVideoLink1).sendKeys(VideoLink1);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textCoverImage);
        find(textCoverImage);
        find(fieldVideoLink2).sendKeys(VideoLink2);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textMakeCover1);
        find(textMakeCover1);
        find(fieldVideoLink3).sendKeys(VideoLink3);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textMakeCover2);
        find(textMakeCover2);
    }
    public void VideoContent4(String VideoLink1, String VideoLink2, String VideoLink3, String VideoLink4) {
        find(ContentVideo).click();
        find(fieldVideoLink1).sendKeys(VideoLink1);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textCoverImage);
        find(textCoverImage);
        find(fieldVideoLink2).sendKeys(VideoLink2);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textMakeCover1);
        find(textMakeCover1);
        find(fieldVideoLink3).sendKeys(VideoLink3);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textMakeCover2);
        find(textMakeCover2);
        find(fieldVideoLink4).sendKeys(VideoLink4);
      /*  getDriver().manage().timeouts().implicitlyWait(1000, SECONDS);
        waitForRenderedElementsToBePresent(textMakeCover3);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");*/
    }
    public void VideoContent5(String VideoLink1, String VideoLink2, String VideoLink3, String VideoLink4, String VideoLink5) {
        find(ContentVideo).click();
        find(fieldVideoLink1).sendKeys(VideoLink1);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textCoverImage);
        find(textCoverImage);
        find(fieldVideoLink2).sendKeys(VideoLink2);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textMakeCover1);
        find(textMakeCover1);
        find(fieldVideoLink3).sendKeys(VideoLink3);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textMakeCover2);
        find(textMakeCover2);
        find(fieldVideoLink4).sendKeys(VideoLink4);
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(textMakeCover3);
        find(textMakeCover3);
        find(fieldVideoLink5).sendKeys(VideoLink5);
        waitForRenderedElementsToBePresent(textMakeCover4);
       /* JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");*/
    }
    public void clearVideo() {
        find(fieldVideoLink1).clear();
    }

    public void AudioContent1(String AudioLink1) {
        find(ContentAudio).click();
        clearAudio();
        find(fieldAudioLink1).sendKeys(AudioLink1);
        waitForRenderedElementsToBePresent(iconDelete1);
        find(iconDelete1).isDisplayed();
        getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        find(fieldAudioLink2);
        //find(fieldAudioLink2).isDisplayed();
    }
    public void AudioContent2(String AudioLink1, String AudioLink2) {
        find(ContentAudio).click();
        clearAudio();
        find(fieldAudioLink1).sendKeys(AudioLink1);
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete1);
        find(iconDelete1);
        find(fieldAudioLink2).sendKeys(AudioLink2);
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete2);
        find(iconDelete2);
    }
    public void AudioContent3(String AudioLink1, String AudioLink2, String AudioLink3) {
        find(ContentAudio).click();
        clearAudio();
        find(fieldAudioLink1).sendKeys(AudioLink1);
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete1);
        find(iconDelete1);
        find(fieldAudioLink2).sendKeys(AudioLink2);
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete2);
        find(iconDelete2);
        find(fieldAudioLink3).sendKeys(AudioLink3);
       /* getDriver().manage().timeouts().implicitlyWait(1000, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete3);
        find(iconDelete3);*/
    }
    public void AudioContent4(String AudioLink1, String AudioLink2, String AudioLink3, String AudioLink4) {
        find(ContentAudio).click();
        clearAudio();
        find(fieldAudioLink1).sendKeys(AudioLink1);
        waitForRenderedElementsToBePresent(iconDelete1);
        find(iconDelete1);
        find(fieldAudioLink2).sendKeys(AudioLink2);
        waitForRenderedElementsToBePresent(iconDelete2);
        find(iconDelete2);
        find(fieldAudioLink3).sendKeys(AudioLink3);
        waitForRenderedElementsToBePresent(iconDelete3);
        find(iconDelete3);
        find(fieldAudioLink4).sendKeys(AudioLink4);
      /*  getDriver().manage().timeouts().implicitlyWait(1000, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete4);*/
       /* JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,700)", "");*/
    }
    public void AudioContent5(String AudioLink1, String AudioLink2, String AudioLink3, String AudioLink4, String AudioLink5) {
        find(ContentAudio).click();
        clearAudio();
        find(fieldAudioLink1).sendKeys(AudioLink1);
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete1);
        find(iconDelete1);
        find(fieldAudioLink2).sendKeys(AudioLink2);
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete2);
        find(iconDelete2);
        find(fieldAudioLink3).sendKeys(AudioLink3);
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete3);
        find(iconDelete3);
        find(fieldAudioLink4).sendKeys(AudioLink4);
        //getDriver().manage().timeouts().implicitlyWait(99, SECONDS);
        waitForRenderedElementsToBePresent(iconDelete4);
        find(iconDelete4);
        find(fieldAudioLink5).sendKeys(AudioLink5);
        waitForRenderedElementsToBePresent(iconDelete5);
        //waitForRenderedElementsToBePresent(btnSave);
      //  JavascriptExecutor jse = (JavascriptExecutor)getDriver();
     //   jse.executeScript("window.scrollBy(0,8000)", "");
       // ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 250)");
      //  ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void clearAudio() {
        find(fieldAudioLink1).clear();
    }

    public void ItemStatusActivate() {
        find(statusActivate).click();
    }

    public void ItemStatusPeriod() {
        find(statusPeriod).click();
    }

    public void ItemStatusDeactivate() {find(statusDeactivate).click();}

    public void checkItemErrorPresent(String TitleError, String CategoryError, String SubCategoryError, String PhotoError) {
        System.out.println("Message for Title: " + find(lblTitleError).getText());
        System.out.println("Message for Category: " + find(lblCategoryError).getText());
        System.out.println("Message for Subcategory: " + find(lblSubCategoryError).getText());
        System.out.println("Message for Image: " + find(lblPhotoError).getText());

        assertTrue("Wrong Title Error", find(lblTitleError).containsText(TitleError));
        assertTrue("Wrong Category Error", find(lblCategoryError).containsText(CategoryError));
        assertTrue("Wrong SubCategory Error", find(lblSubCategoryError).containsText(SubCategoryError));
        assertTrue("Wrong Img Error", find(lblPhotoError).containsText(PhotoError));
       /* try {
            getDriver().findElement(lblTitleError);
            getDriver().findElement(lblCategoryError);
            getDriver().findElement(lblSubCategoryError);
            //getDriver().findElement(lblPriceError);
            getDriver().findElement(lblPhotoError);
            return true;
        } catch (ElementNotFoundAfterTimeoutError e) {
            return false;
        }*/
    }

    public void clickSave(WebDriver driver) {
        parentWindowHandler = getDriver().getWindowHandle();
        find(btnSave).click();
    }

    public void checkItemSaved(WebDriver driver){
        WebDriverWait wt = new WebDriverWait (driver, 900);
        wt.until(ExpectedConditions.presenceOfElementLocated(SuccessPopupOk));
        wt.until(ExpectedConditions.visibilityOfElementLocated(SuccessPopupOk));
        wt.until(ExpectedConditions.elementToBeClickable(SuccessPopupOk));

        WebElement el= find(SuccessPopupOk);
        if (el.isEnabled())
           el.click();
           //find(SuccessPopupOk).waitUntilNotVisible();
        wt.until(ExpectedConditions.visibilityOfElementLocated(ItemContentListing));
    }

    public boolean checkBreadCrumb(String type,String title, WebDriver driver){
        Set keyset=category.keySet();
        System.out.println("Key set values are: " + keyset);

        HashMap<String, String> NEWcategory = new HashMap();

        String iCategory=find(breadcrumb_ItemCategory).getText();
        String iSubcategory=find(breadcrumb_ItemSubCategory).getText();
        System.out.println(iCategory);
        System.out.println(iSubcategory);

        NEWcategory.put(iCategory,iSubcategory);


        String iType=find(breadcrumb_ItemType).getText();
        String iTitle=find(breadcrumb_ItemTitle).getText();
        String iTypeOriginal = type +'s';

        /*System.out.println(iType);
        System.out.println(iTitle);
        System.out.println(iTypeOriginal);
        System.out.println(title);*/

        if ( (iType.equals(iTypeOriginal)) && (title.contains(iTitle)) && category.equals(NEWcategory) )
        {   System.out.println("Success ");
            return true;
        }
        else
        { System.out.println("Fail case ");
            return false;
        }
    }

    public void clickSaveError() {find(btnSave).click();}

    public void WaitForTextPresent(String text)  {
        int waitRetryDelayMs = 20; //шаг итерации (задержка)
        int timeOut = 100;  //время тайм маута
        boolean first = true;

        for (int milliSecond = 0; ; milliSecond += waitRetryDelayMs) {
            if (milliSecond > timeOut * 100) {
                System.out.println("Timeout: Text '" + text + "' is not found Document");
                break; //если время ожидания закончилось (элемент за выделенное время не был найден)
            }

            if (getDriver().getPageSource().contains(text)) {
                if (!first) System.out.println("Text is found: " + text + " Document");
                break; //если элемент найден
            }

            if (first) System.out.println("Waiting for text is present: '" + text + " Document");

            first = false;
            Sleep(waitRetryDelayMs);
        }
    }
    public void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickSave2(WebDriver driver) {
        find(btnSave2).click();
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(SuccessPopup));
    }

    public void swithToModalWindow() {
        String modalWindowHandle = "";
        Set<String> handles = getDriver().getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentWindowHandler))
                modalWindowHandle = handle;
        }
        getDriver().switchTo().window(modalWindowHandle);
    }

    public void ViewerItemBlock(WebDriver driver) {
        find(filterHeadTitle);
        find(filterBlockContainer);
        find(filterGroupCategory);
        find(filterGroupPrice);
        find(filterGroupLocation);
        find(filterGroupGender);

        find(filterResultsCount);
        find(itemSort);

        find(buttonAdd_listing);
        find(itemBlock);

        find(itemUserImg);
        //find(imgResponsive);
        find(handleFavorite);
        find(handleLike);
        find(handleReposts);
        find(itemType);
        find(priceSpace);
    }
    public void openViewItemPage(WebDriver driver) {
        find(itemDiscoverPage).click();
    }

    public void ViewerItemPage(WebDriver driver) {
        find(breadcrumb_ItemCategory);
        find(breadcrumb_ItemSubCategory);
        find(breadcrumb_ItemType);
        find(breadcrumb_ItemTitle);
        find(inappropriateFormItem);

        find(UserName_Owner).isPresent();
        find(Location_Owner).isPresent();
        find(FollowButton_Owner).isPresent();
        find(MessageButton_Owner).isPresent();
        find(About_Owner).isPresent();
        find(MemberSince_Owner).isPresent();
    }

    public void pressRequestForm(WebDriver driver, String requestTitle, String messageLabel, String attachLabel) {
        find(btnRequest).click();
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(RequestTitle));
        wt.until(ExpectedConditions.visibilityOfElementLocated(RequestItemTitle));
        wt.until(ExpectedConditions.visibilityOfElementLocated(RequestMessageLabel));
        wt.until(ExpectedConditions.visibilityOfElementLocated(RequestMessageAttachList));
        wt.until(ExpectedConditions.presenceOfElementLocated(RequestImgAvatar));

        assertTrue("Wrong Request Title", find(RequestTitle).containsText(requestTitle));
        assertTrue("Wrong Message Label", find(RequestMessageLabel).containsText(messageLabel));
        assertTrue("Wrong Attach Label", find(RequestMessageAttachList).containsText(attachLabel));
    }
    public void enterRequestText(WebDriver driver, String text) {
        find(RequestText).sendKeys(text);
    }

    public void pressSendRequestButton(WebDriver driver) {
        find(RequestButton).click();
        WebDriverWait wt = new WebDriverWait(driver, 99);
        wt.until(ExpectedConditions.invisibilityOfElementLocated(RequestPopup));
    }

    /*Share Item*/
    public void openViewItemByClickOnBlock(WebDriver driver) {
        find(itemBlockSpace).click();
    }

    public void pressShareButton(WebDriver driver) {
        find(ShareItemMenu).click();
    }

    public void pressShareToWall(WebDriver driver) {
        find(ShareItemToWall).click();
    }

    public void pressShareToGroup(WebDriver driver) {
        find(ShareItemToGroup).click();
    }

    public void selectGroupInDropdown(WebDriver driver) {
        find(ShareGroupMenu).click();
        find(ShareSelectGroup).click();
    }
    public void pressPostToGroup(WebDriver driver) {
        find(SharebtnPost).click();
    }

    public void checkShareItemExists(WebDriver driver, String HeaderShare) {
        String i = find(ShareRepostHeader ).getText();
        System.out.println("Share item header: " + i);
        assertTrue("No share header", i.contains(HeaderShare));
    }
    public void checkInformTextShareItem(WebDriver driver, String placeholderShareItem) {
        WebDriverWait wt = new WebDriverWait(driver, 150);
        wt.until(ExpectedConditions.presenceOfElementLocated(ShareItemInformText));

        List<WebElement> Owner = driver.findElements(ShareItemInformText);
        for (WebElement el : Owner) {

            if (el.getText().contains(placeholderShareItem)) {
                System.out.println(el.getText());
                break;
            }
        }
    }
    public void selectEventDates(WebDriver driver) {
        find(EventFrom).click();
        parentWindowHandler = getDriver().getWindowHandle();

        /*WebDriverWait wt = new WebDriverWait (driver, 50);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Calendar));*/

      /*  List<WebElement> list = driver.findElements(Calendar);
        for (WebElement el : list) {
            String value = el.getAttribute("style");
            if (value.contains("display: block;")) {
                System.out.println("display: block; :" + value);
                el.click();
                break;
         }
         }*/

           /* JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementByXPath('//td[@class='day today active']').value='23-09-2019 12:00'");
            js.executeScript("arguments[0].click();", FromTodayDay);
            js.executeScript("arguments[0].click();", TodayHour);*/

       /* driver.switchTo().frame(
                driver.findElement(FromTodayDay));
        SetDatepicker(driver, "#datetimepicker-days", "23-09-2019 12:00");*/



       /* find(EventTo).click();
        find(TillTodayDay).click();
        find(TodayHour).click();*/
    }


    public void datePicker( String data, WebDriver driver) {
            //WebElement dateWidget = driver.findElement(By.xpath("html/body/div[4]/div[3]/table/tbody/tr[5]/td"));
            //System.out.println("нашли Календарь");

            //List<WebElement> rows = dateWidget.findElements(By.tagName("tr"));
       /* List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        System.out.println("нашли Дни");
        System.out.println(columns.get(2));*/

            //WebElement fieldFrom = driver.findElement(By.xpath("//input[@can-value='mi_ev_date_from']"));

//Включение JavaScript
        HtmlUnitDriver dr = new HtmlUnitDriver(BrowserVersion.FIREFOX_24, true);
        dr.setJavascriptEnabled(true);

        List<WebElement> columns = dr.findElements(By.xpath("html/body/div[4]/div[3]/table/tbody/tr[5]/td"));
            if(!columns.isEmpty()){
                //THEN CLICK ON THE SUBMIT BUTTON
                for (WebElement cell : columns) {
                    if (cell.isDisplayed()) {
                        System.out.println(cell.getText());

                        if (cell.getText().equals("29")) {
                            System.out.println("попали в цикл проверки");
                            cell.click();
                            break;
                        } else System.out.println("error with Calendar");
                    }
                }
            }else{
                //DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
                System.out.println("error with Calendar");
            }
    }

    public void selectRegistrationDates(WebDriver driver) {
        find(RegistrationFrom).click();
        find(FromTodayDay).click();
        find(TodayHour).click();

        find(RegistrationTo).click();
        find(FromTodayDay).click();
        find(TodayHour).click();
    }
}