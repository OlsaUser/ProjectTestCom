package com.ProjectTestCom.pages;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.jetty.html.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

/**
 * Created by olsa on 5/10/2016.
 */
//@DefaultUrl("http://synergy.devzone.dp.ua/en/#!login")
//@DefaultUrl("http://mnassa.com/en/#!login")

@RunWith(SerenityRunner.class)
public class NewMessagePage extends PageObject {
    private final By iconMessage = By.xpath("//div[@id='header-top-line']/div/div[1]/div[1]/a[3]");
    //private final By TextArea = By.xpath("//div[@class='messages-reply']//textarea");
    private final By TextArea = By.id("messages-reply-field");
    private final By fieldChatWith = By.cssSelector("a[href*='/cabinet#!thread_view/visavis=1']");
    //private final By fieldChatWith = By.xpath("//section[@id='cabinet_sect']/cabinet/section/div[2]/div/div[1]/div[1]/a");
    //private final By btnSend = By.xpath("//div[@class='messages-reply-in']//button");
    private final By btnSend = By.id("message-send-btn");
    //private final By btnSend = By.xpath("//div[@class='messages-reply-in']//button");
    //private final By placeholder1=By.xpath("//div[@class='messages-box-in']");
    private final By placeholder1=By.xpath("//p[@class='im-select-sign']");
    //private final By placeholderAttach=By.xpath("//div[@class='message-attach-list']");
    private final By placeholderAttach=By.xpath("//span[@class='im-attach-info hidden-sm hidden-xs']");
    private final By iconAttach=By.id("msg-attach-control");
    //private final By messageTitle=By.xpath("//h3[@class='messages-with-title']");
    private final By messageTitle=By.xpath("//a[@class='user_first_last_name']");
    private final By userAvatar=By.xpath("//img[@class='im-reply-avatar hidden-xs hidden-sm']");
    //private final By messageHeader=By.xpath("//span[@class='messages-head-text']");
    private final By messageHeader=By.xpath("//span[@class='im-head-text']");
    //private final By messagesHeadDuplicateCheckbox=By.xpath("//label[@class='messages-head-duplicate checkbox']");
    private final By messages_TreeDots=By.xpath("//button[@class='im-head-controls-toggle']");
    private final By checkbox_DuplicateMsg=By.xpath("//span[@class='checkbox-text']");

    //Visible elements
    //private final By txtMessage = By.xpath("//div[@class='messages-list']/div[last()]//div[@class='messages-item-content']/p");
    private final By txtMessage = By.xpath("//div[@id='messages-list']/div[last()]//div[@class='im-item-content']/p");
    public void PressIconMessage() {
        element(iconMessage).click();
    }

    public void SelectChatWith() {element(fieldChatWith).click();}

    public void EnterMessage(String value) {
        element(TextArea).sendKeys(value);
    }

    public void PressSendButton(WebDriver driver) {
        element(btnSend).click();
    }

    public void checkMessageExists(String message, WebDriver driver) {
        //Проверяем, есть ли на текущей странице текст
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(txtMessage,message));
    }
    public void ViewerPageElements(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 50);

        find(messageHeader);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(messageHeader,"Messages"));
        find(messages_TreeDots).click();
        wt.until(ExpectedConditions.textToBePresentInElementLocated(checkbox_DuplicateMsg,"Duplicate messages to email"));

        find(placeholder1);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(placeholder1,"Select User to view messages"));

        element(fieldChatWith).click();
        String i = find(TextArea).getAttribute("placeholder");
        System.out.print(i);
        assertTrue("Error with header",i.contains("Reply to "));

        find(userAvatar).isDisplayed();

        wt.until(ExpectedConditions.textToBePresentInElementLocated(placeholderAttach,"Attach file"));

        find(iconAttach).isDisplayed();
        find(messageTitle).isDisplayed();
        //wt.until(ExpectedConditions.textToBePresentInElementLocated(messageTitle,"Messages with"));
    }
}
