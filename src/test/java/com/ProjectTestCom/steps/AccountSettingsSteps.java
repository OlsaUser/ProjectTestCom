package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.AccountSettingsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static junit.framework.TestCase.assertTrue;

public class AccountSettingsSteps extends ScenarioSteps {

    AccountSettingsPage accountSettingsPage;

    @Step
    public void  pressUploadCoverLink ( ) { accountSettingsPage.pressUploadCoverLink();}

    @Step
    public void  CropPopup_ChooseImage ( ) throws AWTException { accountSettingsPage.CropPopup_ChooseImage();}

    @Step
    public void  selectFounded ( ) { accountSettingsPage.selectFounded();}

    @Step
    public void  selectNumbEmployees (String count) { accountSettingsPage.selectNumbEmployees(count);}

    @Step
    public void  selectTypeGovernmental( ) { accountSettingsPage.selectTypeGovernmental();}

    @Step
    public void  enterOrganizationName(String text) { accountSettingsPage.enterOrganizationName(text);}

    @Step
    public void  enterOrganizationShortName(String text) { accountSettingsPage.enterOrganizationShortName(text);}

    @Step
    public void  Job_EditName(String value) { accountSettingsPage.Job_EditName(value);}

    @Step
    public void  Job_EditSpeciality(String value) { accountSettingsPage.Job_EditSpeciality(value);}

    @Step
    public void  Job_EditLocation(String value) { accountSettingsPage.Job_EditLocation(value);}

    @Step
    public void  Job_EditAbout(String value) { accountSettingsPage.Job_EditAbout(value);}

    @Step
    public void  Ed_EditName(String value) { accountSettingsPage.Ed_EditName(value);}

    @Step
    public void  Ed_EditSpeciality(String value) { accountSettingsPage.Ed_EditSpeciality(value);}

    @Step
    public void  Ed_EditLocation(String value) { accountSettingsPage.Ed_EditLocation(value);}

    @Step
    public void  Ed_EditAbout(String value) { accountSettingsPage.Ed_EditAbout(value);}

    @Step
    public void  Edit_ed() { accountSettingsPage.Edit_ed();}

    @Step
    public void  Upd_ed(WebDriver driver) { accountSettingsPage.Upd_ed(driver);}

    @Step
    public void  Del_ed_modal(WebDriver driver) { accountSettingsPage.Del_ed_modal(driver);}

    @Step
    public void  Edit_job() { accountSettingsPage.Edit_job();}

    @Step
    public void  Upd_job(WebDriver driver) { accountSettingsPage.Upd_job(driver);}

    @Step
    public void  Del_job_modal(WebDriver driver) { accountSettingsPage.Del_job_modal(driver);}

    @Step
    public void  checkMessage_if_NameWrong(String Message, WebDriver driver) { Assert.assertTrue(accountSettingsPage.checkMessage_if_NameWrong(Message,driver));}

    @Step
    public void  enterCurrentPassword(String password) { accountSettingsPage.enterCurrentPassword(password);}

    @Step
    public void  enterNewPassword(String password) { accountSettingsPage.enterNewPassword(password);}

    @Step
    public void  enterNewConfirmPassword(String password) { accountSettingsPage.enterNewConfirmPassword(password);}

    @Step
    public void  pressCollapseChangePassword() { accountSettingsPage.pressCollapseChangePassword();}

    @Step
    public void  enterSkill(String skill, WebDriver driver) { accountSettingsPage.enterSkill(skill, driver);}

    @Step
    public void  enterInterest(String interest, WebDriver driver) { accountSettingsPage.enterInterest(interest, driver);}

    @Step
    public void  deleteSkill() { accountSettingsPage.deleteSkill();}

    @Step
    public void  deleteInterest() { accountSettingsPage.deleteInterest();}

    @Step
    public void  pressCollapseSkillsInfo( ) { accountSettingsPage. pressCollapseSkillsInfo();}

    @Step
    public void  enterWebSite(String link) { accountSettingsPage. enterWebSite(link);}

    @Step
    public void  enterSnapchat(String link) { accountSettingsPage. enterSnapchat(link);}

    @Step
    public void  enterLinkedIn(String link) { accountSettingsPage. enterLinkedIn(link);}

    @Step
    public void  enterTwitter(String link) { accountSettingsPage. enterTwitter(link);}

    @Step
    public void  enterInstagram(String link) { accountSettingsPage. enterInstagram(link);}

    @Step
    public void  enterFacebook(String link) { accountSettingsPage. enterFacebook(link);}

    @Step
    public void  enterLandline(String Landline) { accountSettingsPage. enterLandline(Landline);}

    @Step
    public void  enterMobilePhone(String mobile) { accountSettingsPage. enterMobilePhone(mobile);}

    @Step
    public void pressCollapseContactInfo ( ) { accountSettingsPage.pressCollapseContactInfo();}

    @Step
    public void pressCollapseJobInfo ( ) { accountSettingsPage.pressCollapseJobInfo();}

    @Step
    public void pressAddJobButton ( ) { accountSettingsPage.pressAddJobButton();}

    @Step
    public void enterJobName ( String text) { accountSettingsPage.enterJobName(text);}

    @Step
    public void pressSaveNewJob (WebDriver driver) { accountSettingsPage.pressSaveNewJob(driver);}

    @Step
    public void enterJobLocation (String location) { accountSettingsPage.enterJobLocation(location);}

    @Step
    public void enterJobFromDate ( ) { accountSettingsPage.enterJobFromDate();}

    @Step
    public void enterJobTillDate ( ) { accountSettingsPage.enterJobTillDate();}

    @Step
    public void enterJobSpeciality ( String text) { accountSettingsPage.enterJobSpeciality(text);}

    @Step
    public void enterJobAbout ( String text) { accountSettingsPage.enterJobAbout(text);}

    @Step
    public void pressCollapseEducationInfo ( ) { accountSettingsPage.pressCollapseEducationInfo();}

    @Step
    public void pressAddEducationButton ( ) { accountSettingsPage.pressAddEducationButton();}

    @Step
    public void enterInstitutionName ( String text) { accountSettingsPage.enterInstitutionName(text);}

    @Step
    public void pressSaveNewEduc ( WebDriver driver) { accountSettingsPage.pressSaveNewEduc(driver);}

    @Step
    public void enterLocation (String location) { accountSettingsPage.enterLocation(location);}

    @Step
    public void enterEducFromDate ( ) { accountSettingsPage.enterEducFromDate();}

    @Step
    public void enterEducTillDate ( ) { accountSettingsPage.enterEducTillDate();}

    @Step
    public void enterSpeciality ( String text) { accountSettingsPage.enterSpeciality(text);}

    @Step
    public void enterAbout ( String text) { accountSettingsPage.enterAbout(text);}

    @Step
    public void enterFirstName(String FirstName) { accountSettingsPage.enterFirstName(FirstName);}

    @Step
    public void enterLastName(String LastName) { accountSettingsPage.enterLastName(LastName);}

    @Step
    public void enterUserName(String UserName) { accountSettingsPage.enterUserName(UserName);}

    @Step
    public void selectGenderMale(String gender ) { accountSettingsPage.selectGenderMale(gender);}

    @Step
    public void selectGenderFeMale(String gender  ) { accountSettingsPage.selectGenderFeMale(gender);}

    @Step
    public void selectLanguageEnglish( ) { accountSettingsPage.selectLanguageEnglish();}

    @Step
    public void selectLanguageArabian( ) { accountSettingsPage.selectLanguageArabian();}

    @Step
    public void selectLanguageEnglish_Org( ) { accountSettingsPage.selectLanguageEnglish_Org();}

    @Step
    public void selectLanguageArabian_Org( ) { accountSettingsPage.selectLanguageArabian_Org();}

    @Step
    public void selectBirth( ) { accountSettingsPage.selectBirth();}

    @Step
    public void selectStatusSingle(String status ) { accountSettingsPage.selectStatusSingle(status);}

    @Step
    public void selectStatusMarried(String status ) { accountSettingsPage.selectStatusMarried(status);}

    @Step
    public void selectLocation(String location ) { accountSettingsPage.selectLocation(location);}

    @Step
    public void enterBriefInfo(String info ) { accountSettingsPage.enterBriefInfo(info);}

    @Step
    public void clickUpdateError( ) { accountSettingsPage.clickUpdateError();}

    @Step
    public void clickUpdate1(WebDriver driver ) { accountSettingsPage.clickUpdate1(driver);}

    @Step
    public void clickUpdate2(WebDriver driver ) { accountSettingsPage.clickUpdate2(driver);}

    @Step
    public void clickUpdate3(WebDriver driver ) { accountSettingsPage.clickUpdate3(driver);}

    @Step
    public void clickUpdate4(WebDriver driver ) { accountSettingsPage.clickUpdate4(driver);}

    @Step
    public void clickUpdate5(WebDriver driver ) { accountSettingsPage.clickUpdate5(driver);}

    @Step
    public void clickUpdate6(WebDriver driver ) { accountSettingsPage.clickUpdate6(driver);}

    @Step
    public void checkInfoExists(String info_exp, String info_now) {assertTrue (accountSettingsPage.checkInfoExists(info_exp, info_now));}

    @Step
    public void checkNetworkAccounts() { accountSettingsPage.checkNetworkAccounts();}

   /* @Step
    public void checkMainDetails_Org(String OrganizationName_En,String OrganizationShortName_En,String location,String BriefInfo, String count)
    { assertTrue(accountSettingsPage.checkMainDetails_Org(OrganizationName_En,OrganizationShortName_En,location,BriefInfo, count));}
*/
    @Step
    public void checkEducationInfo(String InstitutionName,String Speciality,String Location,String About)
    { assertTrue (accountSettingsPage.checkEducationInfo(InstitutionName,Speciality,Location,About));}

    @Step
    public void checkJobInfo(String JobName,String JobSpeciality,String About)
    { assertTrue (accountSettingsPage.checkJobInfo(JobName,JobSpeciality,About));}

    @Step
    public void checkSkillsInfo(String Skill,String Interest)
    { assertTrue (accountSettingsPage.checkSkillsInfo(Skill,Interest));}

    @Step
    public void UserInfo_Viewer(WebDriver driver ) {accountSettingsPage.UserInfo_Viewer(driver);}
}
