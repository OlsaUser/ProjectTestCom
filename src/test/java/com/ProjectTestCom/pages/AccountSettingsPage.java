package com.ProjectTestCom.pages;

import com.google.common.collect.Iterables;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@RunWith(SerenityRunner.class)
public class AccountSettingsPage extends PageObject {
    //Main Details
    private final By fieldFirstName = By.id("first_name");
    private final By fieldLastName = By.id("last_name");
    private final By fieldUserName = By.id("username");
    private final By MenuGender = By.id("s2id_select-2-gender");
    private final By GenderMale = By.xpath("//ul[@id='select2-results-7']/li[1]");
    private final By GenderFemale = By.xpath("//ul[@id='select2-results-7']/li[2]");
    private final By MenuLanguage = By.id("s2id_select-2-ud-lang");
    private final By LanguageEnglish = By.xpath("//ul[@id='select2-results-9']/li[1]");
    private final By LanguageArabian = By.xpath("//ul[@id='select2-results-9']/li[2]");
    private final By LanguageEnglish_Org = By.xpath("//ul[@class='select2-results']/li[1]");
    private final By LanguageArabian_Org = By.xpath("//ul[@class='select2-results']/li[2]");
    private final By DayBirth = By.id("s2id_select-2-filter6");
    private final By DayBirth7 = By.xpath("//ul[@id='select2-results-1']/li[7]");
    private final By YearBirth = By.id("s2id_select-2-filter8");
    private final By YearBirth2009 = By.xpath("//ul[@id='select2-results-3']/li[105]");
    private final By MonthBirth = By.id("s2id_select-2-filter7");
    private final By MonthBirthMarch = By.xpath("//ul[@id='select2-results-2']/li[3]");
    private final By MenuStatus = By.id("s2id_select-2-married");
    private final By StatusSingle = By.xpath("//ul[@id='select2-results-8']/li[1]");
    private final By StatusMarried = By.xpath("//ul[@id='select2-results-8']/li[2]");
    private final By Location = By.xpath("//div[@id='s2id_cities-google']//input");
    private final By LocationJeddah = By.xpath("//div[@class='select2-result-label']");
    private final By fieldJeddah1 = By.xpath("//ul[@class='tag-list list-unstyled']/li[1]");
    private final By fieldJeddah = By.xpath("//ul[@class='tag-list list-unstyled']/li[1]");
    private final By BriefInfo = By.id("ud_brief_intro");
    private final By btnUpdate1 = By.xpath("//button[@can-click='update_user']");
    private final By btnUpdate2 = By.xpath("//div[@id='contactInformation']/div/div[2]/div/div/button[2]");
    private final By btnUpdate3 = By.xpath("//div[@id='educationinformation']//button[@can-click='update_user']");
    private final By btnUpdate4 = By.xpath("//div[@id='jobInformation']//button[@can-click='update_user']");
    private final By btnUpdate5 = By.xpath("//div[@id='skillsInterests']//button[@can-click='update_user']");
    private final By btnUpdate6 = By.xpath("//button[@can-click='change_pass']");
    private final By btnOk = By.xpath(".//*[@id='account-update-confirm']/div/div/div[2]/div/button");
    //View user info
    private final By txtFirstLastName = By.xpath("//a[@class='header-info-name-link']/span[1]");
    private final By txtUserName = By.xpath("//a[@class='header-info-name-link']/span[2]");
    private final By headerLocation = By.xpath("//span[@class='header-info-descr-text']");
    private final By profileLocation1 = By.xpath("//ul[@class='tag-list list-unstyled']/li[1]");
    private final By profileLocation2 = By.xpath("//ul[@class='tag-list list-unstyled']/li[2]");
    private final By txtInfo = By.xpath("//div[@class='break-word']");
    private final By txtBirth = By.xpath("//div[@id='mainDetails']/div/div/div[2]/div[1]");
    private final By txtMarried = By.xpath("//div[@id='mainDetails']/div/div/div[2]/div[3]");
    private final By txtMale = By.xpath("//div[@id='mainDetails']/div/div/div[1]/div[2]");
    private final By txtOrganizationName = By.xpath("//h3[@class='header-info-name']/a/span[1]");
    private final By txtOrganizationShortName = By.xpath("//h3[@class='header-info-name']/a/span[2]");
    private final By txtYearFounded = By.xpath("//div[@class='row -has-custom-indent']/div[2]/div");
    private final By txtCount = By.xpath("//div[@class='row -has-custom-indent']/div[2]/div[3]");

    //Contact info
    private final By collapseContactInfo = By.xpath("//a[@aria-controls='contactInformation']");
    private final By MobilePhone = By.id("phone");
    private final By Landline = By.id("landline");
    private final By fieldFacebook = By.name("links_facebook");
    private final By fieldInstagram = By.name("links_instagram");
    private final By fieldTwitter = By.name("links_twitter");
    private final By fieldLinkedIn = By.name("links_linkedin");
    private final By fieldSnapchat = By.name("links_snapchat");
    private final By fieldWebSite = By.id("ud_site");

    private final By txtMobile = By.xpath("//div[@id='contactInformation']/div/div/div[1]/div[1]/div");
    private final By txtLandLine = By.xpath("//div[@class='row -has-custom-indent']/div[1]/div[2]/div");
    private final By txtFacebook = By.xpath("//ul[@class='social-list list-unstyled']/li[1]");
    private final By txtInstagram = By.xpath("//ul[@class='social-list list-unstyled']/li[2]");
    private final By txtTwitter = By.xpath("//ul[@class='social-list list-unstyled']/li[3]");
    private final By txtLinkedIn = By.xpath("//ul[@class='social-list list-unstyled']/li[4]");
    private final By txtSnapchat = By.xpath("//ul[@class='social-list list-unstyled']/li[5]");
    private final By txtWebSite = By.xpath("//div[@class='row -has-custom-indent']/div[2]/div[2]/div");
    private final By txtEmail = By.xpath("//div[@class='row -has-custom-indent']/div[2]/div[1]/div");

    //Education block
    private final By collapseEducationInfo = By.xpath("//a[@aria-controls='educationinformation']");
    private final By btnAdd = By.id("add-ed");
    private final By fieldInstitutionName = By.id("new-ed-name");
    private final By fieldSpeciality = By.id("new-ed-spec");
    private final By fieldAbout = By.id("new-ed-about");
    private final By fieldLocation = By.id("new-ed-loc");
    private final By Edit_Ed_Name = By.xpath("//input[@can-value='name']");
    private final By Edit_Ed_Speciality = By.name("speciality");
    private final By Edit_Ed_About = By.xpath("//textarea[@can-value='about']");
    private final By Edit_Ed_Location = By.name("location");

    private final By Edit_Job_Name = By.xpath("//div[@id='jobInformation']//input[@can-value='name']");
    private final By Edit_Job_Speciality = By.xpath("//div[@id='jobInformation']//input[@name='speciality']");
    private final By Edit_Job_About = By.xpath("//div[@id='jobInformation']//textarea[@can-value='about']");
    private final By Edit_Job_Location = By.xpath("//div[@id='jobInformation']//input[@name='location']");

    private final By EducLocationJeddah = By.xpath("//div[@class='pac-container pac-logo']/div[1]");
    private final By dateFrom = By.id("new-ed-from-val");
    private final By YearFrom_2010 = By.xpath("//div[@class='datetimepicker-years']//table[@class='table-condensed']/tbody/tr/td/span[2]");
    //private final By YearTill_2011 = By.xpath("//body[@class='small-footer-block']/div[5]//div[@class='datetimepicker-years']/table[@class='table-condensed']/tbody/tr/td/span[3]");
    private final By YearTill_2011 = By.xpath("html/body/div[5]/div[5]/table/tbody/tr/td/span[3]");

    private final By dateTill = By.id("new-ed-till-val");
    private final By btnSaveNewEduc = By.xpath("//a[@can-click='add_new_ed']");
    private final By btnOkEd = By.xpath(".//*[@id='account-update-confirm']/div/div/div[2]/div/button");

    private final By txtInstitutionName = By.xpath("//div[@id='educationInformation']/div/div[last()]//header");
    private final By txtSpeciality = By.xpath("//div[@id='educationInformation']/div/div[last()]/div/div[1]");
    private final By txtLocation = By.xpath("//div[@id='educationInformation']/div/div[last()]/div/div[2]");
    private final By txtAbout = By.xpath("//div[@id='educationInformation']/div/div[last()]/div/div[3]");

    private final By btnEditEd = By.xpath("//div[@id='educationinformation']/div/div[1]//a[@can-click='edit_ed']");
    private final By btnDeleteEd = By.xpath("//a[@can-click='del_ed_modal']");
    private final By Ed_del_confirm = By.xpath(".//*[@id='account-education-del-confirm']/div/div/div[2]/div/button[2]");
    private final By Job_del_confirm = By.xpath(".//*[@id='account-job-del-confirm']/div/div/div[2]/div/button[2]");
    private final By btnSaveEd = By.xpath("//div[@id='educationinformation']/div/div[1]//a[@can-click='upd_ed']/span");

    //Job block
    private final By collapseJobInfo = By.xpath("//a[@aria-controls='jobInformation']");
    private final By btnAddJob = By.id("add-job");
    private final By fieldJobName = By.id("new-job-name");
    private final By fieldJobSpeciality = By.id("new-job-spec");
    private final By fieldJobAbout = By.id("new-job-about");
    private final By fieldJobLocation = By.id("new-job-loc");
    private final By JobLocationJeddah = By.xpath("//div[@class='pac-container pac-logo']/div[1]");
    private final By dateFromJob = By.id("new-job-from-val");
    private final By YearFromJob_2010 = By.xpath("//div[@class='datetimepicker-months']//table[@class='table-condensed']/tbody/tr/td/span[2]");
    //private final By YearTillJob_2011 = By.xpath("//body[@class='small-footer-block']/div[5]//div[@class='datetimepicker-months']/table[@class='table-condensed']/tbody/tr/td/span[3]");
    private final By YearTillJob_2011 = By.xpath("html/body/div[5]/div[4]/table/tbody/tr/td/span[3]");

    private final By dateTillJob = By.id("new-job-till-val");
    private final By btnSaveNewJob = By.xpath("//a[@can-click='add_new_job']");

    private final By txtJobName = By.xpath("//div[@id='jobformation']/div/div[last()]//header");
    private final By txtJobSpeciality = By.xpath("//div[@id='jobformation']/div/div[last()]/div/div[1]");
    private final By txtJobLocation = By.xpath("//div[@id='jobformation']/div/div[last()]/div/div[2]");
    private final By txtJobAbout = By.xpath("//div[@id='jobformation']/div/div[last()]/div/div[3]");

    private final By btnEditJob = By.xpath("//a[@can-click='edit_job']");
    private final By btnDeleteJob = By.xpath("//a[@can-click='del_job_modal']");
    private final By btnSaveJob = By.xpath("//a[@can-click='upd_job']");

    //Skills & Interests
    private final By collapseSkillsInfo = By.xpath("//a[@aria-controls='skillsInterests']");
    private final By fieldSkills = By.xpath("//input[@id='s2id_autogen4']");
    private final By Skill_1 = By.xpath("//ul[@class='select2-results']/li[1]/div/span");
    private final By fieldInterests = By.xpath("//input[@id='s2id_autogen5']");
    private final By Interest_1 = By.xpath("//ul[@class='select2-results']/li[1]/div/span");

    private final By RemoveInterest = By.xpath("//div[@can-click='rem_user_ut_interests_tag']");
    private final By RemoveSkill = By.xpath("//div[@can-click='rem_user_ut_skills_tag']");

    private final By txtSkill = By.xpath("//div[@id='skills-interests']/div/div[1]/ul[@class='tag-list list-unstyled']/li[last()]");
    private final By txtInterest = By.xpath("//div[@id='skills-interests']/div/div[2]/ul[@class='tag-list list-unstyled']/li[last()]");

    //Change Password Block
    private final By collapseChangePassword = By.xpath("//a[@aria-controls='password']");
    private final By currentPassword = By.xpath("//input[@can-value='user.password_old']");
    private final By newPassword = By.xpath("//input[@can-value='user.password']");
    private final By newConfirmPassword = By.id("password_confirm");
    private final By lblErrorName = By.xpath("//div[@class='error_message_static']");

    //Organization
    private final By fieldOrganizationName = By.id("organization_name");
    private final By fieldOrganizationShortName = By.id("username");
    private final By radiobuttonTypeOrg = By.xpath("//div[@class='col-sm-6']/div[3]/div[2]/label");
    private final By NumbEmployees = By.id("org_employees");
    private final By menuFounded = By.id("s2id_select-2-org_founded");
    private final By YearFounded = By.xpath("//ul[@class='select2-results']/li[57]");

    private final By mainDetails = By.id("mainDetails");
    private final By inappropriateForm = By.xpath("//div[@id='page-header-info']/div[1]/div[2]/span");
    private final By contactInformation = By.id("contactInformation");
    private final By educationInformation = By.id("educationInformation");
    private final By jobformation = By.id("jobformation");
    private final By skillsInterests = By.id("skills-interests");
    private final By userFollowings = By.xpath(".//*[@id='user_sect']/user_app/div[1]/div/div/div[2]/div[1]/div/div[1]/div[1]");
    private final By userFollowers = By.xpath(".//*[@id='user_sect']/user_app/div[1]/div/div/div[2]/div[1]/div/div[2]/div[1]");
    private final By userGroups = By.xpath(".//*[@id='user_sect']/user_app/div[1]/div/div/div[2]/div[2]/div[1]");

    private final By pressUploadCover = By.id("user-avatar-change");
    private final By btnUpdateCover = By.xpath("//button[@can-click='img_refresh']");
    private final By img_crop_wrap = By.id("preview");

    public void pressUploadCoverLink () {
        WebDriverWait wt1 = new WebDriverWait(getDriver(), 60);
        wt1.until(ExpectedConditions.elementToBeClickable(pressUploadCover));
        find(pressUploadCover).click();
    }
    public void CropPopup_ChooseImage() throws AWTException {
        WebDriverWait wt1 = new WebDriverWait(getDriver(), 60);
        wt1.until(visibilityOfElementLocated(img_crop_wrap));
        wt1.until(ExpectedConditions.presenceOfElementLocated(img_crop_wrap));
        find(btnUpdateCover).click();
        WebDriverWait wt2 = new WebDriverWait (getDriver(), 500);
        wt2.until(ExpectedConditions.elementToBeClickable(btnOk));
        clickOk(getDriver());
    }

    public void selectFounded () {
        find(menuFounded).click();
        find(YearFounded).click();
    }

    public void selectNumbEmployees (String count) {
        find(NumbEmployees).clear();
        find(NumbEmployees).sendKeys(count);
    }

    public void selectTypeGovernmental () {
        find(radiobuttonTypeOrg).click();
    }

    public void enterOrganizationName (String text) {
        find(fieldOrganizationName).clear();
        find(fieldOrganizationName).sendKeys(text);
    }
    public void enterOrganizationShortName (String text) {
        find(fieldOrganizationShortName).clear();
        find(fieldOrganizationShortName).sendKeys(text);
    }

    public void Job_EditName(String value ) {
        find(Edit_Job_Name).clear();
        find(Edit_Job_Name).sendKeys(value);
    }

    public void Job_EditSpeciality(String value ) {
        find(Edit_Job_Speciality).clear();
        find(Edit_Job_Speciality).sendKeys(value);
    }

    public void Job_EditLocation(String value ) {
        find(Edit_Job_Location ).sendKeys(value);
        find(EducLocationJeddah).click();
    }

    public void Job_EditAbout(String value ) {
        find(Edit_Job_About).clear();
        find(Edit_Job_About).sendKeys(value);
    }

    public void Edit_job( ) {find(btnEditJob).click();}

    public void Upd_job(WebDriver driver ) {
        find(btnSaveJob).click();
        clickOkEd(driver);
    }

    public void Del_job_modal(WebDriver driver ) {
        find(btnDeleteJob).click();

        find(Job_del_confirm).waitUntilClickable();
        if (find(Job_del_confirm).isVisible())
            find(Job_del_confirm).click();
            find(Job_del_confirm).waitUntilNotVisible();
        clickOkEd(driver);
    }

    public void Ed_EditName(String value ) {
        find(Edit_Ed_Name).clear();
        find(Edit_Ed_Name).sendKeys(value);
    }

    public void Ed_EditSpeciality(String value ) {
        find(Edit_Ed_Speciality).clear();
        find(Edit_Ed_Speciality).sendKeys(value);
    }

    public void Ed_EditLocation(String value ) {
        find(Edit_Ed_Location ).sendKeys(value);
        find(EducLocationJeddah).click();
    }

    public void Ed_EditAbout(String value ) {
        find(Edit_Ed_About).clear();
        find(Edit_Ed_About).sendKeys(value);
    }

    public void Edit_ed( ) {
        find(btnEditEd).click();
    }

    public void Upd_ed(WebDriver driver) {
        find(btnSaveEd).click();
        clickOkEd(driver);
    }

    public void Del_ed_modal(WebDriver driver) {
        find(btnDeleteEd).click();

        find(Ed_del_confirm).waitUntilClickable();
        if (find(Ed_del_confirm).isVisible())
            find(Ed_del_confirm).click();
        find(Ed_del_confirm).waitUntilNotVisible();
        clickOkEd(driver);
    }

    public boolean checkMessage_if_NameWrong(String Message, WebDriver driver) {
        List<WebElement> messages = driver.findElements (lblErrorName);
        for (WebElement el : messages) {
            if (el.getText().contains(Message)) {
                return true;
            }
        }
        return false;
    }

    public void enterCurrentPassword(String password) {
        find(currentPassword).clear();
        find(currentPassword).sendKeys(password);
    }

    public void enterNewPassword(String password) {
        find(newPassword).clear();
        find(newPassword).sendKeys(password);
    }

    public void enterNewConfirmPassword(String password) {
        find(newConfirmPassword).sendKeys(password);
    }

    public void pressCollapseChangePassword( ) {
        find(collapseChangePassword).click();
    }

    public void enterSkill(String skill, WebDriver driver) {
            find(fieldSkills).sendKeys(skill);
            find(Skill_1).click();
            WebDriverWait wt = new WebDriverWait(driver, 10);
            wt.until(ExpectedConditions.invisibilityOfElementLocated(Skill_1));
    }

    public void enterInterest(String interest, WebDriver driver) {
            find(fieldInterests).sendKeys(interest);
            find(Interest_1).click();
            WebDriverWait wt = new WebDriverWait(driver, 10);
            wt.until(ExpectedConditions.invisibilityOfElementLocated(Interest_1));
    }
    public void deleteSkill() {
        find(RemoveSkill).click();
    }

    public void deleteInterest() {
        find(RemoveInterest).click();
    }

    public void pressCollapseSkillsInfo( ) {
        find(collapseSkillsInfo).click();
    }

    public void enterJobFromDate( ) {
        find(dateFromJob).click();
        find(YearFromJob_2010).click();
    }
    public void enterJobTillDate( ) {
        find(dateTillJob).click();
        find(YearTillJob_2011).click();
    }
    public void enterJobLocation(String location) {
        find(fieldJobLocation).sendKeys(location);
        find(JobLocationJeddah).click();
    }

    public void pressSaveNewJob(WebDriver driver) {
        find(btnSaveNewJob).click();
        clickOkEd(driver);
    }

    public void enterJobName(String text ) {
        find(fieldJobName).sendKeys(text);
    }

    public void enterJobSpeciality(String text ) {
        find(fieldJobSpeciality).sendKeys(text);
    }

    public void enterJobAbout(String text ) {
        find(fieldJobAbout).sendKeys(text);
    }

    public void pressAddJobButton( ) {
        find(btnAddJob).click();
    }

    public void pressCollapseJobInfo( ) {
        find(collapseJobInfo).click();
    }

    public void enterEducFromDate( ) {
        find(dateFrom).click();
        selectYearFromEduc();
    }

    public void enterEducTillDate( ) {
        find(dateTill).click();
        selectYearTillEduc();
    }

    public void selectYearFromEduc( ) {
        find(YearFrom_2010).click();
    }

    public void selectYearTillEduc( ) {
        find(YearTill_2011).click();
    }


    public void enterLocation(String location,WebDriver driver) {
        find(fieldLocation).sendKeys(location);
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(visibilityOfElementLocated(EducLocationJeddah));
        wt.until(ExpectedConditions.elementToBeClickable(EducLocationJeddah));
        find(EducLocationJeddah).click();
        System.out.println("click");
        wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='add-ed-form']/div[1]/div[4]/ul/li")));
    }

    public void pressSaveNewEduc(WebDriver driver) {
        find(btnSaveNewEduc).click();
        clickOkEd(driver);
    }

    public void clickOkEd(WebDriver driver) {
        /*find(btnOk).waitUntilPresent();
        find(btnOk).waitUntilClickable();
        if (find(btnOk).isVisible())
        { find(btnOk).click();
            find(btnOk).waitUntilNotVisible();}*/

        WebDriverWait wt = new WebDriverWait (driver, 800);
        wt.until(visibilityOfElementLocated(btnOkEd));
        find(btnOkEd).waitUntilClickable();
        if (find(btnOkEd).isVisible())
            find(btnOkEd).click();
        //find(btnOkEd).waitUntilNotVisible();
        wt.until(ExpectedConditions.invisibilityOfElementLocated(btnOkEd));
    }

    public void enterInstitutionName(String text ) {
        find(fieldInstitutionName).sendKeys(text);
    }

    public void enterSpeciality(String text ) {
        find(fieldSpeciality).sendKeys(text);
    }

    public void enterAbout(String text ) {
        find(fieldAbout).sendKeys(text);
    }

    public void pressAddEducationButton( ) {
        find(btnAdd).click();
    }

    public void pressCollapseEducationInfo( ) {
        find(collapseEducationInfo).click();
    }

    public void pressCollapseContactInfo( ) {
        find(collapseContactInfo).click();
    }

    public void enterMobilePhone(String mobile) {
        clearMobilePhone();
        WebElement mobileNumber = find(MobilePhone);
        mobileNumber.sendKeys(mobile);
    }

    public void clearMobilePhone() {
        find(MobilePhone).clear();
    }

    public void enterLandline(String landLine) {
        clearLandline();
        WebElement LandlineNumber = find(Landline);
        LandlineNumber.sendKeys(landLine);
    }

    public void clearLandline() {
        find(Landline).clear();
    }

    public void enterFacebook(String link) {
        clearFacebook();
        WebElement linkFacebook = find(fieldFacebook);
        linkFacebook.sendKeys(link);
    }

    public void clearFacebook() {
        find(fieldFacebook).clear();
    }

    public void enterInstagram(String link) {
        clearInstagram();
        WebElement linkInstagram = find(fieldInstagram);
        linkInstagram.sendKeys(link);
    }

    public void clearInstagram() {
        find(fieldInstagram).clear();
    }

    public void enterTwitter(String link) {
        clearTwitter();
        WebElement Link = find(fieldTwitter);
        Link.sendKeys(link);
    }

    public void clearTwitter() {
        find(fieldTwitter).clear();
    }

    public void enterLinkedIn(String link) {
        clearLinkedIn();
        WebElement Link = find(fieldLinkedIn);
        Link.sendKeys(link);
    }

    public void clearLinkedIn() {
        find(fieldLinkedIn).clear();
    }

    public void enterSnapchat(String link) {
        clearSnapchat();
        WebElement Link = find(fieldSnapchat);
        Link.sendKeys(link);
    }

    public void clearSnapchat() {
        find(fieldSnapchat).clear();
    }

    public void enterWebSite(String link) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 150);
        wt.until(ExpectedConditions.presenceOfElementLocated(fieldWebSite));
        clearWebSite();
        WebElement Link = find(fieldWebSite);
        Link.sendKeys(link);
        String s=find(fieldWebSite).getAttribute("value");
        System.out.println(s);
        assertTrue(s.equals(link));
    }

    public void clearWebSite() {
        find(fieldWebSite).clear();
    }

    public void enterFirstName(String FirstName) {
        clearFirstName();
        WebElement firstName = find(fieldFirstName);
        firstName.sendKeys(FirstName);
    }

    public void clearFirstName() {
        find(fieldFirstName).clear();
    }

    public void enterLastName(String LastName) {
        clearLastName();
        element(fieldLastName).sendKeys(LastName);
    }

    public void clearLastName() {
        find(fieldLastName).clear();
    }

    public void enterUserName(String UserName) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 400);
        wt.until(ExpectedConditions.presenceOfElementLocated(fieldUserName));
        wt.until(ExpectedConditions.visibilityOfElementLocated(fieldUserName));
        find(fieldUserName).sendKeys("");
        wt.until(ExpectedConditions.visibilityOfElementLocated(fieldUserName));
        find(fieldUserName).sendKeys(UserName);
    }

    public void clearUserName() {
        find(fieldUserName).clear();
    }

    public void selectGenderMale(String gender) {
        element(MenuGender).click();
        element(GenderMale).click();
    }

    public void selectGenderFeMale(String gender) {
        element(MenuGender).click();
        element(GenderFemale).click();
    }

    public void selectLanguageEnglish() {
        element(MenuLanguage).click();
        element(LanguageEnglish).click();
    }

    public void selectLanguageArabian() {
        element(MenuLanguage).click();
        element(LanguageArabian).click();
    }
    public void selectLanguageEnglish_Org() {
        element(MenuLanguage).click();
        element(LanguageEnglish_Org).click();
    }

    public void selectLanguageArabian_Org() {
        element(MenuLanguage).click();
        element(LanguageArabian_Org).click();
    }

    public void selectBirth() {
        element(DayBirth).click();
        element(DayBirth7).click();
        element(MonthBirth).click();
        element(MonthBirthMarch).click();
        element(YearBirth).click();
        element(YearBirth2009).click();
    }

    public void selectStatusSingle(String status) {
        element(MenuStatus).click();
        element(StatusSingle).click();
    }

    public void selectStatusMarried(String status) {
        element(MenuStatus).click();
        element(StatusMarried).click();
    }

    public void selectLocation(String location) {
        find(Location).sendKeys(location);
        WebDriverWait wt = new WebDriverWait (getDriver(), 900);
        wt.until(visibilityOfElementLocated(LocationJeddah));
        wt.until(presenceOfElementLocated(LocationJeddah));
        find(LocationJeddah).click();
        wt.until(visibilityOfElementLocated(fieldJeddah));
        find(fieldJeddah).waitUntilVisible();
    }
    public void selectLocation1(String location ) {
        find(Location).sendKeys(location);
        WebDriverWait wt = new WebDriverWait (getDriver(), 980);
        wt.until(visibilityOfElementLocated(LocationJeddah));
        find(LocationJeddah).click();
        wt.until(visibilityOfElementLocated(fieldJeddah1));
        wt.until(ExpectedConditions.presenceOfElementLocated(fieldJeddah1));
        find(fieldJeddah1).waitUntilVisible();
    }

    public void enterBriefInfo(String info) {
        clearBriefInfo();
        element(BriefInfo).sendKeys(info);
    }

    public void clearBriefInfo() {
        find(BriefInfo).clear();
    }

    public void clickUpdateError() {
        find(btnUpdate1).waitUntilClickable();
        find(btnUpdate1).click();
    }

    public void clickUpdate1(WebDriver driver) {
        find(btnUpdate1).click();
        WebDriverWait wt1 = new WebDriverWait (getDriver(), 198);
        wt1.until(presenceOfElementLocated(btnOk));
        clickOk(driver);
    }
    public void clickUpdate2(WebDriver driver) {
        find(btnUpdate2).click();
        WebDriverWait wt1 = new WebDriverWait (getDriver(), 198);
        wt1.until(presenceOfElementLocated(btnOk));
        clickOk(driver);
    }
    public void clickUpdate3(WebDriver driver) {
        find(btnUpdate3).waitUntilClickable();
        find(btnUpdate3).click();
        WebDriverWait wt1 = new WebDriverWait (getDriver(), 198);
        wt1.until(presenceOfElementLocated(btnOk));
        clickOk(driver);
    }

    public void clickUpdate4(WebDriver driver) {
        find(btnUpdate4).waitUntilClickable();
        find(btnUpdate4).click();
        WebDriverWait wt1 = new WebDriverWait (getDriver(), 198);
        wt1.until(presenceOfElementLocated(btnOk));
        clickOk(driver);
        //find(btnUpdate4).waitUntilClickable();
    }
    public void clickUpdate5(WebDriver driver) {
        //find(btnUpdate5).waitUntilClickable();
        find(btnUpdate5).click();
        WebDriverWait wt1 = new WebDriverWait (getDriver(), 198);
        wt1.until(presenceOfElementLocated(btnOk));
        clickOk(driver);
    }
    public void clickUpdate6(WebDriver driver) {
        //find(btnUpdate6).waitUntilClickable();
        find(btnUpdate6).click();
        WebDriverWait wt1 = new WebDriverWait (getDriver(), 198);
        wt1.until(presenceOfElementLocated(btnOk));
        clickOk(driver);
    }
    public void clickOk(WebDriver driver) {
        WebDriverWait wt1 = new WebDriverWait(getDriver(), 800);
        wt1.until(presenceOfElementLocated(btnOk));
        wt1.until(elementToBeClickable(btnOk));
        wt1.until(visibilityOfElementLocated(btnOk));
        find(btnOk).click();
        find(btnOk).click();
        wt1.until(ExpectedConditions.invisibilityOfElementLocated(btnOk));
    }

    public boolean checkInfoExists(String info_exp, String info_now) {
        String text_now_value = getDriver().findElement(By.xpath(info_now)).getText();
        System.out.println(text_now_value);
        System.out.println(info_exp);

        if ((text_now_value.contains(info_exp))) {
            System.out.println("Success ");
            return true;
        } else {
            System.out.println("Fail case ");
            return false;
        }
    }

   /* public boolean checkBirth() {
        WebElement birth = find (txtBirth);
       // System.out.println(birth.getText());
            if (birth.getText().contains("07.03.2009")) {
                return true;
            }
        return false;
    }

    public boolean checkStatus(String status) {
        WebElement married = find (txtMarried);
       // System.out.println(married.getText());
        if (married.getText().contains(status)) {
            return true;
        }
        return false;
    }

    public boolean checkGender(String gender) {
        WebElement male = find (txtMale);
       // System.out.println(male.getText());
        if (male.getText().contains(gender)) {
            return true;
        }
        return false;
    }*/

   /* public boolean checkMainDetails(String FirstName,String LastName, String UserName, String location, String info, String gender, String status ) {
        assertTrue(checkBirth());
        System.out.println(checkBirth());
        assertTrue(checkStatus(status));
        System.out.println(checkStatus(status));
        assertTrue(checkGender(gender));
        System.out.println(checkGender(gender));

        String LblFirstLastName = getDriver().findElement(txtFirstLastName).getText();
        String LblUserName = getDriver().findElement(txtUserName).getText();
        String LblLocation = getDriver().findElement(headerLocation).getText();
        String LblLocation1 = getDriver().findElement(profileLocation1).getText();
        String LblLocation11 = "Dnipro, Dnipropetrovsk Oblast, Ukraine";
        String LblLocation2 = getDriver().findElement(profileLocation2).getText();
        String LblLocation22 = "Jeddah Saudi Arabia";
        String LblInfo = getDriver().findElement(txtInfo).getText();
        String fullName = FirstName + " " + LastName;
        String iUserName='@'+UserName;

        System.out.println(LblUserName);
        System.out.println(iUserName);
        System.out.println(LblFirstLastName);
        System.out.println(fullName);

        System.out.println(LblLocation);
        System.out.println(location);
        System.out.println(LblInfo);
        System.out.println(info);

            if ((LblFirstLastName.equals(fullName))&& (LblUserName.matches(iUserName))
                    && (LblLocation.equals("Dnipro, Dnipropetrovsk Oblast, Ukraine"))
                    && (LblLocation1.equals(LblLocation11))&& (LblLocation2.equals(LblLocation22))
                    && (LblInfo.equals(info)))
        {   System.out.println("Success ");
            return true;
        }
        else
        { System.out.println("Fail case ");
            return false;
        }
    }*/

        public void checkNetworkAccounts()
        {
            find(txtFacebook).click();
            find(txtInstagram).click();
            find(txtTwitter).click();
            find(txtLinkedIn).click();
            find(txtSnapchat).click();

      /*  String LblMobile = getDriver().findElement(txtMobile).getText();
        String LblLandline = getDriver().findElement(txtLandLine).getText();
        String LblWebSite = getDriver().findElement(txtWebSite).getText();
        String LblEmail = getDriver().findElement(txtEmail).getText();*/

       /* System.out.println(LblMobile);
        System.out.println(LblLandline);
        System.out.println(LblWebSite);
        System.out.println(LblEmail);

        System.out.println(mobile);
        System.out.println(landline);
        System.out.println(WebSite);
        System.out.println(email);*/

       /* if ((LblMobile.equals(mobile)) && (LblLandline.equals(landline))
                && (LblWebSite.equals(WebSite))&& (LblEmail.equals(email)))
        {   System.out.println("Success ");
            return true;
        }
        else
        {   System.out.println("Fail case ");
            return false;
        }*/
    }

    public boolean checkEducationInfo(String InstitutionName,String Speciality,String Location,String About)
    {
        String LblInstitutionName = getDriver().findElement(txtInstitutionName).getText();
        String LblSpeciality = getDriver().findElement(txtSpeciality).getText();
        String LblLocation = getDriver().findElement(txtLocation).getText();
        String LblAbout = getDriver().findElement(txtAbout).getText();

        String UnionFromAndLocation = "From 2010 to 2011, Jeddah Saudi Arabia";

        System.out.println(LblInstitutionName);
        System.out.println(LblSpeciality);
        System.out.println(LblLocation);
        System.out.println(LblAbout);

        System.out.println(InstitutionName);
        System.out.println(Speciality);
        System.out.println(Location);
        System.out.println(About);

        if ((LblInstitutionName.contains(InstitutionName)) && (LblSpeciality.contains(Speciality))
                && (LblLocation.equals(UnionFromAndLocation))&& (LblAbout.contains(About)))
        {   System.out.println("Success ");
            return true;
        }
        else
        {   System.out.println("Fail case ");
            return false;
        }
    }

    public boolean checkJobInfo(String JobName,String JobSpeciality,String About)
    {
        String LblJobName = getDriver().findElement(txtJobName).getText();
        String LblJobSpeciality = getDriver().findElement(txtJobSpeciality).getText();
        String LblLocation = getDriver().findElement(txtJobLocation).getText();
        String LblJobAbout = getDriver().findElement(txtJobAbout).getText();

        String UnionFromAndLocation = "From 2.2016 to 3.2016, Jeddah Saudi Arabia";

        System.out.println(LblJobName);
        System.out.println(LblJobSpeciality);
        System.out.println(LblJobAbout);

        System.out.println(JobName);
        System.out.println(JobSpeciality);
        System.out.println(About);

        if ((LblJobName.contains(JobName)) && (LblJobSpeciality.contains(JobSpeciality))
                && (LblLocation.equals(UnionFromAndLocation))&& (LblJobAbout.contains(About)))
        {
            System.out.println("Success ");
            return true;
        }
        else
        {
            System.out.println("Fail case ");
            return false;
        }
    }

    public boolean checkSkillsInfo(String Skill,String Interest)
    {
        String LblSkill = getDriver().findElement(txtSkill).getText();
        String LblInterest = getDriver().findElement(txtInterest).getText();

        System.out.println(LblSkill);
        System.out.println(LblInterest);

        System.out.println(Skill);
        System.out.println(Interest);

        if ((LblSkill.matches(Skill)) && (LblInterest.matches(Interest)))
        {
            System.out.println("Success ");
            return true;
        }
        else
        {
            System.out.println("Fail case ");
            return false;
        }
    }
  /*  public boolean checkMainDetails_Org(String OrganizationName,String OrganizationShortName, String location, String info, String count ) {
        assertTrue(checkYearFounded());
        System.out.println(checkYearFounded());

        String LblOrganizationName = getDriver().findElement(txtOrganizationName).getText();
        String LblLocation = getDriver().findElement(headerLocation).getText();
        String LblLocation1 = getDriver().findElement(profileLocation1).getText();
        String LblLocation11 = "Mexico City, Mexico";
        String LblLocation2 = getDriver().findElement(profileLocation2).getText();
        String LblLocation22 = "Jeddah Saudi Arabia";
        String LblInfo = getDriver().findElement(txtInfo).getText();
        String LblCount = getDriver().findElement(txtCount).getText();

        String LblOrganizationShortName=getDriver().findElement(txtOrganizationShortName).getText();
        String iOrganizationShortName = '@'+OrganizationShortName;

        System.out.println(LblOrganizationShortName );
        System.out.println(iOrganizationShortName );
        System.out.println(LblOrganizationName );
        System.out.println(OrganizationName );
        System.out.println(LblCount );
        System.out.println(count);

        if ((LblOrganizationName.equals(OrganizationName))&& (LblOrganizationShortName.equals(iOrganizationShortName))
                && (LblLocation.equals("Mexico City, Mexico"))
                && (LblLocation1.equals(LblLocation11))&& (LblLocation2.equals(LblLocation22))
                && (LblInfo.equals(info))&& (LblCount.contains(count)))
        {
            System.out.println("Success ");
            return true;
        }
        else
        {
            System.out.println("Fail case ");
            return false;
        }
    }*/
  /*  public boolean checkYearFounded() {
        WebElement YearFounded = find (txtYearFounded);
        System.out.println(YearFounded.getText());
        if (YearFounded.getText().contains("1871")) {
            return true;
        }
        System.out.print("Wrong Year of founded");
        return false;
    }*/
   /* public boolean checkNetFacebook(String Facebook) {
        find(txtFacebook).click();
        getDriver().getWindowHandles();
        String Flink = getDriver().getCurrentUrl();
        System.out.println(Flink);
        System.out.println(Facebook);

        if ((Flink.equals(Facebook))){
            return true;
        }
        return false;
    }*/

   public void UserInfo_Viewer(WebDriver driver) {
       find(mainDetails).isDisplayed();
       find(inappropriateForm).isDisplayed();
       find(contactInformation).isDisplayed();
       find(educationInformation).isDisplayed();
       find(jobformation).isDisplayed();
       find(skillsInterests).isDisplayed();

       WebDriverWait wt = new WebDriverWait (driver, 200);

       find(userFollowings);
       wt.until(ExpectedConditions.textToBePresentInElementLocated(userFollowings,"Following"));

       find(userFollowers);
       wt.until(ExpectedConditions.textToBePresentInElementLocated(userFollowers,"Followers"));

       find(userGroups);
       wt.until(ExpectedConditions.textToBePresentInElementLocated(userGroups,"Groups"));
   }
}
