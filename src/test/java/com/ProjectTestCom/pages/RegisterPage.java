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

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@DefaultUrl("http://synergy.devzone.dp.ua/en/#!registration")
@DefaultUrl("http://mnassa.com/en/#!registration")
@RunWith(SerenityRunner.class)
public class RegisterPage  extends PageObject {

    //for User
    private final By fldUserName = By.xpath("//input[@name='username']");
    private final By fldEmail = By.xpath("//input[@name='reg_email']");
    private final By fldPassword = By.xpath("//input[@name='reg_password']");
    private final By fldFirstName = By.xpath("//input[@name='first_name']");
    private final By fldLastName = By.xpath("//input[@name='last_name']");
    private final By fldGender = By.xpath("//div[@id='s2id_reg-select-2-gender']");
    private final By menuGender = By.xpath("//div[@class='select2-result-label']");
    private final By fldLocation = By.xpath("//div[@id='s2id_reg-cities-google']//input");
    private final By Location = By.xpath("//div[@class='select2-result-label']");
    private final By LocationTag = By.xpath("//ul[@class='tag-list list-unstyled']/li");
    private final By btnNext = By.xpath("//button[@id='do_reg_modal']");
    private final By btnConfirm = By.xpath("//button[@id='do_reg_modal_s2']");
    private final By btnOK = By.xpath("//button[@can-click='reg_finish']");
    private final By SuccessPopup = By.xpath("//div[@id='step3']//div[@class='step-header text-center']");

    private final By viaFacebook_SignUp = By.id("fb_btn_login");
    //private final By viaFacebook_Login = By.xpath("//button[@class='btn btn-facebook']");
    private final By viaFacebook_Login = By.id("fb_btn_login");
    private final By viaTwitter_Login = By.cssSelector("a[href*='auth/twitter_authorize']");
    private final By viaGoogle_Login = By.id("go_btn_login");

    // for Organization
    private final By radioBtnOrganization = By.xpath("//div[@class='modal-body']/div[2]/div[2]//label");
    private final By fldOrganizationFullName = By.xpath("//input[@name='organization_name']");
    private final By menuFounded = By.xpath("//div[@id='s2id_reg-select-2-founded']");
    private final By FoundedYears = By.xpath("//li[@role='presentation']");
    private final By lblError = By.xpath("//span[@class='auth-form-err']");
    //private final By lblError = By.xpath("//div[@class='error_message -full-width']");
    private final By lblErrorAR = By.xpath("//div[@class='error_message_static -full-width']");
    private final By lbErrorAR_new = By.xpath("//span[@class='auth-form-err']");
    private final By lblErrorPassword = By.xpath("//div[@class='error_message -full-width hidden-xs']");

    //Check Registration
    private final By welcomeToMnassa = By.xpath("//section[@class='create-list-section']");
    private final By text_emptyNewsFeed = By.xpath("//h1[@class='create-list-info']");
    private final By Counter = By.xpath("//span[@class='wall-post-length']");

    private final By UserClick = By.xpath(".//*[@id='auth-tab-sign-up']/section/div[1]/div/button[1]");
    private final By CompanyClick = By.xpath(".//*[@id='auth-tab-sign-up']/section/div[1]/div/button[2]");

    private final By genderMale = By.xpath(".//*[@id='auth-tab-sign-up']/section/div[2]/div/button[1]");
    private final By genderFemale = By.xpath(".//*[@id='auth-tab-sign-up']/section/div[2]/div/button[2]");

    private final By EmailLink = By.xpath("//a[@can-click='step1_validate']");

    private final By Email = By.id("auth-signup-email");
    private final By Name = By.id("auth-signup-org-name");
    private final By UserName = By.id("auth-signup-username");
    private final By Password = By.id("auth-signup-password");

    private final By DoneButton = By.xpath("//button[@can-click='step2_validate']");
    private final By OkButton = By.xpath(".//*[@id='auth-modal-welcome']/div/div/div[2]/div[2]/button");

    String parentWindowHandler;

    public void viaFacebook_SignUp(WebDriver driver ) {
        //String winHandleBefore = getDriver().getWindowHandle();
        element(viaFacebook_SignUp).click();
        }

    public void viaFacebook_Login(WebDriver driver ) {
        String winHandleBefore = getDriver().getWindowHandle();
        element(viaFacebook_Login).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
    }
    public void viaTwitter_Login(WebDriver driver ) {
        String winHandleBefore = getDriver().getWindowHandle();
        element(viaTwitter_Login).click();
        WebDriverWait wt = new WebDriverWait (driver, 100);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
    }
    public void viaGoogle_Login(WebDriver driver ) {
        String winHandleBefore = getDriver().getWindowHandle();
        element(viaGoogle_Login).click();
        parentWindowHandler = getDriver().getWindowHandle();
        for(String winHandle : getDriver().getWindowHandles())
        {
            getDriver().switchTo().window(winHandle);
            System.out.println("winHandle " + winHandle);
        }
        WebElement continueAs = getDriver().findElement(By.id("submit_approve_access"));
        WebDriverWait wt = new WebDriverWait (driver, 50);
        wt.until(ExpectedConditions.elementToBeClickable(continueAs));
        continueAs.click();
    }

    public void successReg_Google() {
        String modalWindowHandle = "";
        Set<String> handles = getDriver().getWindowHandles();
        System.out.println("handles " + getDriver().getWindowHandles());
        for (String handle : handles) {
            System.out.println("handle " + modalWindowHandle);
            if (handle.equals(parentWindowHandler))
                modalWindowHandle = handle;

            getDriver().switchTo().window(modalWindowHandle);
            System.out.println(getDriver().getCurrentUrl());
            Assert.assertTrue(getDriver().getTitle().contains("Mnassa"));

            WebDriverWait wt = new WebDriverWait (getDriver(), 100);
            wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
        }
    }

    public void selectUser( ) {
        find(UserClick).click();
    }

    public void selectCompany() {
        WebDriverWait wt = new WebDriverWait (getDriver(), 200);
        wt.until(ExpectedConditions.visibilityOfElementLocated(CompanyClick));
        find(CompanyClick).click();
    }

    public void selectGenderMale( ) {
        find(genderMale).click();
    }

    public void selectGenderFemale( ) {
        find(genderFemale).click();
    }

    public void clickEmailForm( ) {
        find(EmailLink).click();
        WebDriverWait wt = new WebDriverWait (getDriver(), 50);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Email));
    }
    public void enterEmail(String email) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 100);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Email));
        wt.until(ExpectedConditions.presenceOfElementLocated(Email));
        find(Email).clear();
        find(Email).sendKeys(email);
    }
    public void enterName(String name) {
        find(Name).clear();
        find(Name).sendKeys(name);
    }
    public void enterUserName(String userName) {
        find(UserName).clear();
        find(UserName).sendKeys(userName);
    }
    public void enterPassword(String password) {
        find(Password).clear();
        find(Password).sendKeys(password);
    }
    public void clickDoneButton( ) {
        find(DoneButton).click();
        WebDriverWait wt = new WebDriverWait (getDriver(), 100);
        wt.until(ExpectedConditions.visibilityOfElementLocated(OkButton));
        find(OkButton).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
    }

    public void clickDoneButton_Ok( ) {
        find(DoneButton).click();
        WebDriverWait wt = new WebDriverWait (getDriver(), 100);
        wt.until(ExpectedConditions.visibilityOfElementLocated(OkButton));
        find(OkButton).click();
    }
    public void clickDoneButton_Error( ) {
        WebDriverWait wt = new WebDriverWait(getDriver(), 300);
        wt.until(ExpectedConditions.visibilityOfElementLocated(DoneButton));
        find(DoneButton).click();}

    public boolean checkValidationMessage(String Message, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait(driver, 300);
        wt.until(ExpectedConditions.visibilityOfElementLocated(lblError));

        boolean r=false;

        List <WebElement> messages = driver.findElements (lblError);
        for (WebElement el : messages) {
            if (el.getText().equals(Message)) {
                System.out.println("Validation message OK! " + el.getText());
                r=true;
                return r;
            }
            else System.out.println("Skip validation message: " + el.getText());
        }
        r=false;
        return r;
    }

    public void successLogIn(WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 200);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
    }

    public void successRegistration(WebDriver driver) {
       WebDriverWait wt = new WebDriverWait (driver, 300);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
        Assert.assertEquals( "Mnassa is a social interactive platform for business communication.",find(text_emptyNewsFeed).getText());
    }
    public void successRegistrationFb(WebDriver driver) {
        /*for( String winHandle2 : driver.getWindowHandles())
        {
            System.out.println(winHandle2);
            driver.switchTo().window(winHandle2);
        }*/
        driver.switchTo().window("4f7b1e7f-a978-42bb-99b6-1c15474acfed");
        WebDriverWait wt = new WebDriverWait (driver, 300);
        wt.until(ExpectedConditions.visibilityOfElementLocated(Counter));
        Assert.assertEquals( "Mnassa is a social interactive platform for business communication.",find(text_emptyNewsFeed).getText());
    }

    public void goConfirmLink(WebDriver driver, String email) {
        String confirmLink = provideCode(email);
        driver.get(confirmLink);
    }

    public void goConfirmLink_AR(WebDriver driver, String email) {
        String confirmLink = provideCode_AR(email);
        driver.get(confirmLink);
    }
    public void goLoginButton(WebDriver driver, String email) {
        String LoginButton = provideLoginButton(email);
        driver.get(LoginButton);
    }
    public static String provideCode(String email) {
        String tempCode = null;
        //String host = "pop.gmail.com";// change accordingly
        //String mailStoreType = "pop3";

        String host = "imap.gmail.com";
        String mailStoreType = "imap";
        String password = "Jk14501450";

        String check = check(host, mailStoreType, email, password); //messages body

        if (check != null) {
            String prefix = "Or copy the link below: ";
            String suffix = "Kind regards, Mnassa Team";
            String substring = check.substring(check.indexOf(prefix) + prefix.length() + 3, check.indexOf(suffix));
            tempCode = substring.trim();
            System.out.println("tempCode: " + tempCode);
            String codePrefix = "url=";
            String encodedUrl = tempCode.substring(tempCode.indexOf(codePrefix) + codePrefix.length());
            try {
                String url = URLDecoder.decode(encodedUrl, "UTF-8");
                String confirmPrefix = "confirm?code=";
                String code = url.substring(url.indexOf(confirmPrefix) + confirmPrefix.length());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        //return code;
        return tempCode;
    }
    public static String provideCode_AR(String email) {
        String tempCode = null;
        //String host = "pop.gmail.com";// change accordingly
        //String mailStoreType = "pop3";

        String host = "imap.gmail.com";
        String mailStoreType = "imap";
        String password = "Jk14501450";

        String check = check(host, mailStoreType, email, password); //messages body

        if (check != null) {
            String prefix = "أو قم بنسخ الرابط أدناه:";
            String suffix = "أطيب التحيات، فريق منصة";
            String substring = check.substring(check.indexOf(prefix) + prefix.length() + 3, check.indexOf(suffix));
            tempCode = substring.trim();
            System.out.println("tempCode: " + tempCode);
            String codePrefix = "url=";
            String encodedUrl = tempCode.substring(tempCode.indexOf(codePrefix) + codePrefix.length());
            try {
                String url = URLDecoder.decode(encodedUrl, "UTF-8");
                String confirmPrefix = "confirm?code=";
                String code = url.substring(url.indexOf(confirmPrefix) + confirmPrefix.length());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        //return code;
        return tempCode;
    }
    public static void checkWelcomeLetter(String email) {
        String host = "imap.gmail.com";
        String mailStoreType = "imap";
        String password = "Jk14501450";

        String check = check(host, mailStoreType, email, password); //messages body

        if (check != null) {
            String header = "Welcome to MNASSA family!";
            Assert.assertTrue(check.contains(header));
        }
    }
    public static void checkWelcomeLetter_AR(String email) {
        String host = "imap.gmail.com";
        String mailStoreType = "imap";
        String password = "Jk14501450";

        String check = check(host, mailStoreType, email, password); //messages body

        if (check != null) {
            String header = "مرحبا بك في عائلة منصّة!";
            Assert.assertTrue(check.contains(header));
        }
    }
    public static String provideLoginButton(String email) {
        String tempCode = null;
        //String host = "pop.gmail.com";// change accordingly
        //String mailStoreType = "pop3";

        String host = "imap.gmail.com";
        String mailStoreType = "imap";
        String password = "Jk14501450";

        String check = check(host, mailStoreType, email, password); //messages body

        if (check != null) {
            String prefix = "efficient and easy to reach.";
            String suffix = "Kind regards, Mnassa Team";
            String substring = check.substring(check.indexOf(prefix) + prefix.length() + 3, check.indexOf(suffix));
            tempCode = substring.trim();
            System.out.println("tempCode: " + tempCode);
            String codePrefix = "url=";
            String encodedUrl = tempCode.substring(tempCode.indexOf(codePrefix) + codePrefix.length());
            try {
                String url = URLDecoder.decode(encodedUrl, "UTF-8");
                String confirmPrefix = "confirm?code=";
                String code = url.substring(url.indexOf(confirmPrefix) + confirmPrefix.length());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        //return code;
        return tempCode;
    }
    public static String check(String host, String storeType, String user,
                               String password) {
        String result = null;
        String result2 = null;
        try {
            //create properties field
            Properties properties = new Properties();

            /*properties.put("mail.pop3.debug", "true");
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");*/

            properties.setProperty("mail.imap.host", "imap.gmail.com");
            properties.setProperty("mail.imap.port", "993");
            properties.setProperty("mail.imap.connectiontimeout", "5000");
            properties.setProperty("mail.imap.timeout", "5000");

           /* System.setProperty("proxySet", "true");
            System.setProperty("https.proxyHost", "proxy.isd.dp.ua");
            System.setProperty("https.proxyPort", "8080");

            System.setProperty("http.proxyHost", "proxy.isd.dp.ua");
            System.setProperty("http.proxyPort", "8080");*/

            //System.setProperty("https.proxyUser", "olsa@design.isd.dp.ua");
           // System.setProperty("https.proxyPassword", "88888888");

           /* System.setProperty("http.proxyUser", "design\\olsa");
            System.setProperty("http.proxyPassword", "********");*/

            //Session emailSession = Session.getDefaultInstance(properties);

             Session emailSession = Session.getDefaultInstance(properties,
                    new Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("lensytosakish.1@gmail.com", "Jk14501450");
                        }});

            //create the POP3 store object and connect with the pop server
            //Store store = emailSession.getStore("pop3s");
            Store store = emailSession.getStore("imaps");
            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            /*Folder[] f = store.getDefaultFolder().list();
            for(Folder emailFolder:f)
                System.out.println(">> "+emailFolder.getName());*/

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                result = getTextFromMessage(message);
                //System.out.println("Text: " + result);
            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public  static String getTextFromMessage(Message message) throws Exception {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }
    public static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws Exception {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + html;
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }

    /**************************************/
    /* Old methods*/

    public void Step1_selectRadioButton_Organization( ) {
        element(radioBtnOrganization).click();
    }

    public void clearUserName() {find(UserName).clear();}

    public void clearPassword() {find(Password).clear();}

    public void clearEmail() {find(fldEmail).clear();}

    public void clearFirstName() {find(fldFirstName).clear();}

    public void clearLastName() {find(fldLastName).clear();}

    public void clearOrganizationFullName() {find(Name).clear();}

    public void Step1_UserName(String UserName) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 100);
        wt.until(ExpectedConditions.visibilityOfElementLocated(fldUserName));
        find(fldUserName).clear();
        element(fldUserName).sendKeys(UserName);
    }

    public void Step1_Email(String Email) {
        find(fldEmail).clear();
        element(fldEmail).sendKeys(Email);
    }

    public void Step1_Password(String Password) {
        element(fldPassword).sendKeys(Password);
    }

    public void Step2_FirstName(String FirstName) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(fldFirstName));
        element(fldFirstName).sendKeys(FirstName);

    }

    public void Step2_OrganizationFullName(String OrganizationFullName) {
        WebDriverWait wt = new WebDriverWait (getDriver(), 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(fldOrganizationFullName));
        element(fldOrganizationFullName).sendKeys(OrganizationFullName);
    }

    public void Step2_Gender(WebDriver driver, String gender) {
        element(fldGender).click();
        List<WebElement> genderVariant = driver.findElements(menuGender);
        for (WebElement el : genderVariant) {
            if (el.getText().contains(gender)) {
                el.click();
                break;
            }
        }
    }

    public void Step2_LastName(String LastName) {
        element(fldLastName).sendKeys(LastName);
    }

    public void Step2_Founded(String year, WebDriver driver ) {
        element(menuFounded).click();
        List <WebElement> years = driver.findElements(FoundedYears);
        for (WebElement el : years) {
            if (el.getText().contains(year)) {
                System.out.println(el.getText());
                el.click();
                break;
            }
        }
    }

    public void Step2_Location(WebDriver driver, String location) {
        element(fldLocation).click();
        element(fldLocation).sendKeys(location);
        getDriver().manage().timeouts().implicitlyWait(99, TimeUnit.SECONDS);
        element(Location).click();
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.visibilityOfElementLocated(LocationTag));
    }

    public void Step1_pressButton_Next( ) {
        element(btnNext).click();
    }

    public void Step2_pressButton_Confirm(WebDriver driver) {element(btnConfirm).click();}

    public void Step3_Ok(WebDriver driver, String email) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
       /* wt.until(ExpectedConditions.elementToBeClickable(btnOK));
        wt.until(ExpectedConditions.textToBePresentInElementLocated(SuccessPopup, "After that you will be redirected to this page - page, where you started registration!"));
        find(btnOK);
        element(btnOK).click();*/
    }

    public void checkValidationMessage_if_UserNameAR(String Message, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(lbErrorAR_new,Message));
        System.out.println("Validation message OK! " + find(lbErrorAR_new).getText());
    }

    public void checkValidationMessage_Password(String Message, WebDriver driver) {
        WebDriverWait wt = new WebDriverWait (driver, 99);
        wt.until(ExpectedConditions.textToBePresentInElementLocated(lblError,Message));
        System.out.println("Validation message OK! " + find(lblError).getText());
    }


}
