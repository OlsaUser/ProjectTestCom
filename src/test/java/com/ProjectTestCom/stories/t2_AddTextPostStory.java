package com.ProjectTestCom.stories;

import com.ProjectTestCom.steps.AddGroupSteps;
import com.ProjectTestCom.steps.AddPostSteps;
import com.ProjectTestCom.steps.HeaderSteps;
import com.ProjectTestCom.steps.LoginSteps;
import com.ProjectTestCom.utils.PropertyLoader;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

/**
 * Created by olsa on 4/28/2016.
 */
@RunWith(SerenityRunner.class)
public class t2_AddTextPostStory {
    private String browserFilePath = "src/test/resources/browser.properties";
    private String BrowserProfile = PropertyLoader.getProperty(browserFilePath, "BrowserProfile");

    //private String propertyFilePath = "src/test/resources/login.properties";
    private String propertyFilePath = "src/test/resources/login_live.properties";
    private String email = PropertyLoader.getProperty(propertyFilePath, "email");
    private String password = PropertyLoader.getProperty(propertyFilePath, "password");

    private String propertyPostPath = "src/test/resources/post.properties";
    private String textPostMin = PropertyLoader.getProperty(propertyPostPath, "textPostMin");
    private String textPostMaxEn = PropertyLoader.getProperty(propertyPostPath, "textPostMaxEn");
    private String textPostAr = PropertyLoader.getProperty(propertyPostPath, "textPostAr");
    private String addPost = PropertyLoader.getProperty(propertyPostPath, "addPost");
    private String Comment = PropertyLoader.getProperty(propertyPostPath, "Comment");

    private String propertyGroupPath = "src/test/resources/group.properties";
    private String Group1 = PropertyLoader.getProperty(propertyGroupPath, "Group1");

    @Managed
    WebDriver driver;

    @ManagedPages
    public Pages pages;

    @Steps
    LoginSteps loginSteps;

    @Steps
    AddPostSteps addPostSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    AddGroupSteps addGroupSteps;

    @Before
    public void setup() throws IOException {
        FirefoxProfile myProfile = new FirefoxProfile(new File(BrowserProfile));
        myProfile.setPreference("network.proxy.socks_port",9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
        myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);

        loginSteps.openLoginPage();
        loginSteps.PageComplete(driver);

        loginSteps.enterLogin(email);
        loginSteps.enterPassword(password);
        loginSteps.clickEnter(driver);
        loginSteps.PageComplete(driver);
    }

    @After
    public void tearDown() {driver.quit();}

// Adding post with MIN length
    @Test
    public void textPostMinHomePage_DeleteComment() throws IOException {
        addPostSteps.AddTextPost(textPostMin, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostMin,driver);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyWall(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostMin, driver);

        addPostSteps.addComment(Comment, driver);
        addPostSteps.deleteComment(driver);
    }

    @Test
    public void textPostMinMyGroupWall_DeleteComment() throws IOException{
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group1);
        loginSteps.PageComplete(driver);
        //driver.get("http://mnassa.com/en/administrator#!group/page=4/name=group-title-1");
        addPostSteps.AddTextPost(textPostMin, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostMin, driver);

        addPostSteps.addComment(Comment, driver);
        loginSteps.PageComplete(driver);
        addPostSteps.deleteComment(driver);
    }

 /*   @Test
    public void textPostMinGroupWall()  {
        addPostSteps.openGroupsPage();
        loginSteps.Sleep(50000);
        addPostSteps.openGroupWall();
        loginSteps.Sleep(5000);
        addPostSteps.AddTextPost(textPostMin);
        addPostSteps.clickPostButton();
        loginSteps.Sleep(9000);
        addPostSteps.checkTextInPost(textPostMin);
        addPostSteps.addComment(Comment, driver);
        addPostSteps.deleteComment(driver);
    }

    @Test
    public void textPostMinMyWall() {
        addPostSteps.openMyMnassaPage();
        loginSteps.Sleep(5000);
        addPostSteps.openMyWallPage();
        loginSteps.Sleep(5000);
        addPostSteps.AddTextPost(textPostMin);
        addPostSteps.clickPostButton();
        loginSteps.Sleep(9000);
        addPostSteps.checkTextInPost(textPostMin);
        addPostSteps.addComment(Comment, driver);
        addPostSteps.deleteComment(driver);
    }*/

    //Adding post with AR text
  /* @Test
    public void textPostArHomePage_AddComment() throws IOException{
        addPostSteps.AddTextPost(textPostAr, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInNewsFeed(textPostAr,driver);

        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyWall(driver);
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostAr, driver);

        addPostSteps.addComment(Comment, driver);
    }*/

    @Test
    public void textPostArMyGroupWall_AddComment() throws IOException{
        headerSteps.openMyMnassaPage(driver);
        headerSteps.openMyGroupsListing(driver);
        addGroupSteps.openGroupWall(driver, Group1);
        loginSteps.PageComplete(driver);

        //driver.get("http://mnassa.com/en/administrator#!group/page=4/name=group-title-1");
        addPostSteps.AddTextPost_inGroup(textPostAr, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostAr, driver);

        addPostSteps.addComment(Comment, driver);
    }

    @Test
    public void textPostArGroupWall_DeleteComment() throws IOException{
        headerSteps.openGroupsListing(driver);
        addPostSteps.openGroupWall();
        loginSteps.PageComplete(driver);

        addPostSteps.AddTextPost(textPostAr, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostAr, driver);

        addPostSteps.addComment(Comment, driver);
        loginSteps.PageComplete(driver);
        addPostSteps.deleteComment(driver);
    }

    @Test
    public void textPostArMyWall_DeleteCommentiPost() throws IOException{
        headerSteps.openMyMnassaPage(driver);
        loginSteps.PageComplete(driver);

        addPostSteps.AddTextPost(textPostAr, driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        addPostSteps.checkTextInPost(textPostAr, driver);

        addPostSteps.addComment(Comment, driver);
        addPostSteps.deleteComment(driver);
        addPostSteps.deletePost(driver);
    }
//Adding post with MAX lengh
     @Test
     public void textPostMaxEnHomePage() throws IOException{
         addPostSteps.AddTextPost(textPostMaxEn, driver);
         addPostSteps.clickPostButton();
         loginSteps.PageComplete(driver);
         addPostSteps.checkTextInPost(textPostMaxEn, driver);

         headerSteps.openMyMnassaPage(driver);
         headerSteps.openMyWall(driver);
         loginSteps.PageComplete(driver);
         addPostSteps.checkTextInPost(textPostMaxEn, driver);
}

/* @Test
     public void textPostMaxEnMyGroupWall(){
     addPostSteps.openMyMnassaPage();
     addPostSteps.openMyGroupsPage();
     addPostSteps.openMyGroupWall();
     addPostSteps.AddTextPost(textPostMaxEn);
     loginSteps.Sleep(8000);
     addPostSteps.clickPostButton();
     loginSteps.Sleep(8000);
     addPostSteps.checkTextInPost(textPostMaxEn);
 }

 @Test
     public void textPostMaxEnGroupWall() throws IOException{
     addPostSteps.openGroupsPage();
     loginSteps.Sleep(5000);
     addPostSteps.openGroupWall();
     loginSteps.Sleep(5000);
     addPostSteps.AddTextPost(textPostMaxEn);
     addPostSteps.clickPostButton();
     loginSteps.Sleep(9000);
     addPostSteps.checkTextInPost(textPostMaxEn);
 }

 @Test
     public void textPostMaxEnMyWall() throws IOException{
     addPostSteps.openMyMnassaPage();
     loginSteps.Sleep(5000);
     addPostSteps.AddTextPost(textPostMaxEn);
     addPostSteps.clickPostButton();
     loginSteps.Sleep(9000);
     addPostSteps.checkTextInPost(textPostMaxEn);
 }
*/
    @Test
    public void deleteTextPostMyWall(){
        headerSteps.openMyMnassaPage(driver);
        addPostSteps.AddTextPost(textPostMin,driver);
        addPostSteps.clickPostButton();
        loginSteps.PageComplete(driver);
        //loginSteps.Sleep(80);
        addPostSteps.checkTextInPost(textPostMin,driver);
        addPostSteps.deletePost(driver);
        loginSteps.PageComplete(driver);
    }
}
