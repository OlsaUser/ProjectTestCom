package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.ItemPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by olsa on 4/29/2016.
 */
public class AddItemSteps extends ScenarioSteps {

    ItemPage itemPage;

    @Step
    public void clickAddButton(WebDriver driver) {itemPage.clickAddButton(driver);}

    @Step
    public void openAddItemPageByClickingOnButtonInListing() {itemPage.openAddItemPageByClickingOnButtonInListing();}

    @Step
    public void openItemSettingsMenu() {itemPage.openItemSettingsMenu();}

    @Step
    public void EditSpecialItem(String itemID) {itemPage.EditSpecialItem(itemID);}

    @Step
    public void checkValueExists(String value_exp, String value_now)
    { assertTrue(itemPage.checkValueExists(value_exp, value_now));}

    @Step
    public void checkElementPresents(String value_now)
    { assertTrue(itemPage.checkElementPresents(value_now));}

    @Step
    public void selectDeleteMenu() {itemPage.selectDeleteMenu();}

    @Step
    public void clickDeleteButton(WebDriver driver) {itemPage.clickDeleteButton(driver);}

    @Step
    public void checkItemDeleted(WebDriver driver) {itemPage.checkItemDeleted(driver);}

    @Step
    public void clickCancelButton() {itemPage.clickCancelButton();}

    @Step
    public void selectViewMenu(WebDriver driver) {itemPage.selectViewMenu(driver);}

    @Step
    public void checkCommentAdded(String comment) {itemPage.checkCommentAdded(comment);}

    @Step
    public void addComment(WebDriver driver, String comment) {itemPage.addComment(driver, comment);}

    @Step
    public void selectEditMenu() {itemPage.selectEditMenu();}

    @Step
    public void selectStatusMenu() {itemPage.selectStatusMenu();}

    @Step
    public void selectItemType(String ItemType, WebDriver driver) {itemPage.selectItemType(ItemType, driver);}

    @Step
    public void selectDemand() {itemPage.selectDemand();}

    @Step
    public void selectSupply() {itemPage.selectSupply();}

    @Step
    public void enterBasicInfo(String Title, String Description) {itemPage.enterBasicInfo(Title, Description);}

    @Step
    public void collapseMainInfo() {itemPage.collapseMainInfo();}

    @Step
    public void collapseMainDetails() {itemPage.collapseMainDetails();}

    @Step
    public void collapseContent() {itemPage.collapseContent();}

    @Step
    public void collapseStatus() {itemPage.collapseStatus();}

    @Step
    public void selectServiceWillBeAvailable() {itemPage.selectServiceWillBeAvailable();}

    @Step
    public void selectServiceWillBeAvailableSoon() {itemPage.selectServiceWillBeAvailableSoon();}

    @Step
    public void selectCategory1( ) {itemPage.selectCategory1();}

    @Step
    public void selectCategory2( ) {itemPage.selectCategory2();}

    @Step
    public void selectCategory3( ) {itemPage.selectCategory3();}

    @Step
    public void enterPrice(String value, String Per) {itemPage.enterPrice(value, Per);}

    @Step
    public void enterPriceFree() {itemPage.enterPriceFree();}

    @Step
    public void enterPriceToBeDiscussed() {itemPage.enterPriceToBeDiscussed();}

    @Step
    public void ItemStatusPeriod() {itemPage.ItemStatusPeriod();}

    @Step
    public void ItemStatusDeactivate() {itemPage.ItemStatusDeactivate();}

    @Step
    public void ItemStatusActivate() {itemPage.ItemStatusActivate();}

    @Step
    public void enterTag(String Tag) {itemPage.enterTag(Tag);}

    @Step
    public void enterLocation(String location) {itemPage.enterLocation(location);}

    @Step
    public void enterAddress(String address) {itemPage.enterAddress(address);}

    @Step
    public void ImageContent() {itemPage.ImageContent();}

    @Step
    public void deleteImage() {itemPage.deleteImage();}

    @Step
    public void changeCoverImage() {itemPage.changeCoverImage();}

    @Step
    public void changeCoverVideo() {itemPage.changeCoverVideo();}

    @Step
    public void checkNewCover() {assertTrue(itemPage.checkNewCover());}

    @Step
    public void selectYearsOfExperienceFew() {itemPage.selectYearsOfExperienceFew();}

    @Step
    public void selectYearsOfExperienceLess() {itemPage.selectYearsOfExperienceLess();}

    @Step
    public void selectYearsOfExperienceMore() {itemPage.selectYearsOfExperienceMore();}

    @Step
    public void selectMethodVisa() {itemPage.selectMethodVisa();}

    @Step
    public void selectMethodMasterCard() {itemPage.selectMethodMasterCard();}

    @Step
    public void selectMethodPayPal() {itemPage.selectMethodPayPal();}

    @Step
    public void selectMethodDebitCard() {itemPage.selectMethodDebitCard();}

    @Step
    public void selectMethodCash() {itemPage.selectMethodCash();}

    @Step
    public void selectDeliveryMethodDHL() {itemPage.selectDeliveryMethodDHL();}

    @Step
    public void selectDeliveryMethodTNT() {itemPage.selectDeliveryMethodTNT();}

    @Step
    public void selectDeliveryMethodAramex() {itemPage.selectDeliveryMethodAramex();}

    @Step
    public void selectDeliveryMethodPickUp() {itemPage.selectDeliveryMethodPickUp();}

    @Step
    public void selectDeliveryMethodHomeDelivery() {itemPage.selectDeliveryMethodHomeDelivery();}

    @Step
    public void selectDeliveryMethodSaudiPost() {itemPage.selectDeliveryMethodSaudiPost();}

    @Step
    public void selectDeliveryMethodOther() {itemPage.selectDeliveryMethodOther();}

    @Step
    public void selectAvailabilityNow() {itemPage.selectAvailabilityNow();}

    @Step
    public void selectAvailabilityOutOfStock() {itemPage.selectAvailabilityOutOfStock();}

    @Step
    public void selectAvailabilitySold() {itemPage.selectAvailabilitySold();}

    @Step
    public void selectConditionNew() {itemPage.selectConditionNew();}

    @Step
    public void selectConditionUsed() {itemPage.selectConditionUsed();}

    @Step
    public void clickServiceOnline() {itemPage.clickServiceOnline();}

    @Step
    public void selectAdvancedPayment10() {itemPage.selectAdvancedPayment10();}

    @Step
    public void selectAdvancedPayment25() {itemPage.selectAdvancedPayment25();}

    @Step
    public void selectAdvancedPayment50() {itemPage.selectAdvancedPayment50();}

    @Step
    public void selectAdvancedPayment100() {itemPage.selectAdvancedPayment100();}

    @Step
    public void selectEventType() {itemPage.selectEventType();}

    @Step
    public void selectAudienceMales() {itemPage.selectAudienceMales();}

    @Step
    public void selectAudienceFemales() {itemPage.selectAudienceFemales();}

    @Step
    public void selectAudienceFamilies() {itemPage.selectAudienceFamilies();}

    @Step
    public void selectAudienceChildren() {itemPage.selectAudienceChildren();}

    @Step
    public void selectAudienceAnyone() {itemPage.selectAudienceAnyone();}

    @Step
    public void selectRegistrationOpen() {itemPage.selectRegistrationOpen();}

    @Step
    public void selectRegistrationClosed() {itemPage.selectRegistrationClosed();}

    @Step
    public void selectEventCanceled() {itemPage.selectEventCanceled();}

    @Step
    public void selectEventEnded() {itemPage.selectEventEnded();}

    @Step
    public void selectTicketTypeFree() {itemPage.selectTicketTypeFree();}

    @Step
    public void selectTicketTypePaid(String ticketPrice) {itemPage.selectTicketTypePaid(ticketPrice);}

    @Step
    public void selectTicketTypePaid_ar(String ticketPrice) {itemPage.selectTicketTypePaid_ar(ticketPrice);}

    @Step
    public void enterOrganizerName(String OrganizerName) {itemPage.enterOrganizerName(OrganizerName);}

    @Step
    public void selectRegisteredYes() {itemPage.selectRegisteredYes();}

    @Step
    public void selectRegisteredNo() {itemPage.selectRegisteredNo();}

    @Step
    public void selectRegisteredInProcess() {itemPage.selectRegisteredInProcess();}

    @Step
    public void selectPartnerNo() {itemPage.selectPartnerNo();}

    @Step
    public void selectPartnerYes() {itemPage.selectPartnerYes();}

    @Step
    public void selectProjectStudy() {itemPage.selectProjectStudy();}

    @Step
    public void FinancialSupport(String financialSupportPrice) {itemPage.FinancialSupport(financialSupportPrice);}

    @Step
    public void ManagementSupport(String txtManagementSupport) {itemPage.ManagementSupport(txtManagementSupport);}

    @Step
    public void VideoContent( ) {itemPage.VideoContent();}

    @Step
    public void VideoContent1(String VideoLink1) {itemPage.VideoContent1(VideoLink1);}

    @Step
    public void VideoContent2(String VideoLink1, String VideoLink2) {itemPage.VideoContent2(VideoLink1, VideoLink2);}

    @Step
    public void VideoContent3(String VideoLink1, String VideoLink2, String VideoLink3) {
        itemPage.VideoContent3(VideoLink1, VideoLink2, VideoLink3);
    }

    @Step
    public void VideoContent4(String VideoLink1, String VideoLink2, String VideoLink3, String VideoLink4) {
        itemPage.VideoContent4(VideoLink1, VideoLink2, VideoLink3, VideoLink4);
    }

    @Step
    public void VideoContent5(String VideoLink1, String VideoLink2, String VideoLink3, String VideoLink4, String VideoLink5) {
        itemPage.VideoContent5(VideoLink1, VideoLink2, VideoLink3, VideoLink4, VideoLink5);
    }

    @Step
    public void AudioContent1(String AudioLink1) {itemPage.AudioContent1(AudioLink1);}

    @Step
    public void AudioContent2(String AudioLink1, String AudioLink2) {itemPage.AudioContent2(AudioLink1, AudioLink2);}

    @Step
    public void AudioContent3(String AudioLink1, String AudioLink2, String AudioLink3) {
        itemPage.AudioContent3(AudioLink1, AudioLink2, AudioLink3);
    }

    @Step
    public void AudioContent4(String AudioLink1, String AudioLink2, String AudioLink3, String AudioLink4) {
        itemPage.AudioContent4(AudioLink1, AudioLink2, AudioLink3, AudioLink4);
    }

    @Step
    public void AudioContent5(String AudioLink1, String AudioLink2, String AudioLink3, String AudioLink4, String AudioLink5) {
        itemPage.AudioContent5(AudioLink1, AudioLink2, AudioLink3, AudioLink4, AudioLink5);
    }

    @Step
    public void clickSave(WebDriver driver) {itemPage.clickSave(driver);}

    @Step
    public void checkItemSaved(WebDriver driver) {itemPage.checkItemSaved(driver);}

    @Step
    public void checkBreadCrumb(String type,String title, WebDriver driver) {assertTrue(itemPage.checkBreadCrumb(type,title,driver));}

    @Step
    public void clickSaveError( ) {itemPage.clickSaveError();}

    @Step
    public void clickSave2(WebDriver driver) {itemPage.clickSave2(driver);}

    @Step
    public void checkItemErrorPresent(String TitleError, String CategoryError, String SubCategoryError, String PhotoError) {
        itemPage.checkItemErrorPresent(TitleError, CategoryError, SubCategoryError, PhotoError);}

    @Step
    public void ViewerItemBlock(WebDriver driver) {itemPage.ViewerItemBlock(driver);}

    @Step
    public void openViewItemPage(WebDriver driver) {itemPage.openViewItemPage(driver);}

    @Step
    public void ViewerItemPage(WebDriver driver) {itemPage.ViewerItemPage(driver);}

    @Step
    public void pressRequestForm(WebDriver driver, String requestTitle, String messageLabel, String attachLabel)
    {itemPage.pressRequestForm(driver, requestTitle, messageLabel, attachLabel);}

    @Step
    public void enterRequestText(WebDriver driver, String text) {itemPage.enterRequestText(driver, text);}

    @Step
    public void pressSendRequestButton(WebDriver driver) {itemPage.pressSendRequestButton(driver);}

    @Step
    public void openViewItemByClickOnBlock(WebDriver driver) {itemPage.openViewItemByClickOnBlock(driver);}

    @Step
    public void pressShareButton(WebDriver driver) {itemPage.pressShareButton(driver);}

    @Step
    public void pressShareToWall(WebDriver driver) {itemPage.pressShareToWall(driver);}

    @Step
    public void pressShareToGroup(WebDriver driver) {itemPage.pressShareToGroup(driver);}

    @Step
    public void selectGroupInDropdown(WebDriver driver) {itemPage.selectGroupInDropdown(driver);}

    @Step
    public void pressPostToGroup(WebDriver driver) {itemPage.pressPostToGroup(driver);}

    @Step
    public void checkShareItemExists(WebDriver driver, String HeaderShare) {itemPage.checkShareItemExists(driver, HeaderShare);}

    @Step
    public void checkInformTextShareItem(WebDriver driver, String placeholderShareItem) {itemPage.checkInformTextShareItem(driver, placeholderShareItem);}

    @Step
    public void selectEventDates(WebDriver driver) {itemPage.selectEventDates(driver);}

    @Step
    public void datePicker( String data, WebDriver driver) {itemPage.datePicker(  data,  driver);}

    @Step
    public void selectRegistrationDates(WebDriver driver) {itemPage.selectRegistrationDates(driver);}
}