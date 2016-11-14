package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.AddPostPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertFalse;

/**
 * Created by olsa on 4/28/2016.
 */
public class AddPostSteps extends ScenarioSteps {

    AddPostPage addPostPage;

    @Step
    public void openGroupWall() { addPostPage.openGroupWall();}

    @Step
    public void AddTextPost(String Text, WebDriver driver) { addPostPage.AddTextPost(Text, driver);}

    @Step
    public void AddMentionPost(String Text, WebDriver driver) { addPostPage.AddMentionPost(Text, driver);}

    @Step
    public void AddTextPost_inGroup(String Text, WebDriver driver) { addPostPage.AddTextPost_inGroup(Text, driver);}

    @Step
    public void openVideoPopup( ) { addPostPage.openVideoPopup();}

    @Step
    public void openAudioPopup( ) { addPostPage.openAudioPopup();}

    @Step
    public void AddVideoLink(String Video) { addPostPage.AddVideoLink(Video);}

    @Step
    public void AddAudioLink(String Audio) { addPostPage.AddAudioLink(Audio);}

    @Step
    public void clickVideoPostButton(WebDriver driver) { addPostPage.clickVideoPostButton(driver);}

    @Step
    public void clickAudioPostButton(WebDriver driver) { addPostPage.clickAudioPostButton(driver);}

    @Step
    public void clickPostButton() {addPostPage.clickPostButton();}

    @Step
    public void clickPostBtn(WebDriver driver) {addPostPage.clickPostBtn(driver);}

    @Step
    public void waitWidgetAudio(WebDriver driver) {addPostPage.waitWidgetAudio(driver);}

    @Step
    public void waitWidgetVideo(WebDriver driver) {addPostPage.waitWidgetVideo(driver);}

    @Step
    public void addComment(String comment, WebDriver driver) { addPostPage.addComment(comment, driver);}

    @Step
    public void deleteComment(WebDriver driver) { addPostPage.deleteComment(driver);}

    @Step
    public void deletePost(WebDriver driver) { addPostPage.deletePost(driver);}

    @Step
    public void checkTextInPost(String textPost, WebDriver driver) { addPostPage.checkTextInPost(textPost, driver);}

    @Step
    public void checkContentInPost(WebDriver driver ) { addPostPage.checkContentInPost(driver);}

    @Step
    public void checkAudioContentInPost(WebDriver driver ) { addPostPage.checkAudioContentInPost(driver);}

    @Step
    public void openPostMenu() { addPostPage.openPostMenu();}

    @Step
    public void openRepostMenu() { addPostPage.openRepostMenu();}

    @Step
    public void selectRepostToGroup(WebDriver driver) { addPostPage.selectRepostToGroup(driver);}

    @Step
    public void selectRepostToWall(WebDriver driver) { addPostPage.selectRepostToWall(driver);}

    @Step
    public void selectGroupInDropdown() { addPostPage.selectGroupInDropdown();}

    @Step
    public void pressPostButton() { addPostPage.pressPostButton();}

    @Step
    public void checkPlaceholderTextAfterRepost(WebDriver driver, String placeholder) { addPostPage.checkPlaceholderTextAfterRepost(driver, placeholder);}

    @Step
    public void checkRepostExists(WebDriver driver, String text, String HeaderRepost) { addPostPage.checkRepostExists(driver, text, HeaderRepost);}

    @Step
    public void checkOwnRepostExists(WebDriver driver, String text, String HeaderRepost) { addPostPage.checkOwnRepostExists(driver, text, HeaderRepost);}

    @Step
    public void checkCounterRepost(WebDriver driver, String counter) { addPostPage.checkCounterRepost(driver, counter);}

    @Step
    public void selectPin() { addPostPage.selectPin( );}

    @Step
    public void checkPinPlaceholder(String placeholder) { addPostPage.checkPinPlaceholder(placeholder );}

    @Step
    public void checkUnPinPlaceholder(String placeholder) { addPostPage.checkUnPinPlaceholder(placeholder );}

    @Step
    public void pressViewNow() { addPostPage.pressViewNow( );}

    @Step
    public void checkPinIconPresent() { addPostPage.checkPinIconPresent( );}

    @Step
    public void checkPinIconAbsent() { assertFalse(addPostPage.checkPinIconAbsent());}
}
