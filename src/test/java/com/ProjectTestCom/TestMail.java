package com.ProjectTestCom;

import com.ProjectTestCom.pages.RegisterPage;

public class TestMail {

    public static void main(String ... arhgs){
        RegisterPage.provideCode("lensytosakish.1@gmail.com");
        RegisterPage.checkWelcomeLetter("lensytosakish.1@gmail.com");
    }
}
