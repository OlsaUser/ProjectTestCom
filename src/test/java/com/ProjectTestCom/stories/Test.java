package com.ProjectTestCom.stories;


import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runners.model.Statement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class Test {
/***************************************************************************************/
    public void PageComplete(final WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }
    public void ErrorMessage(final WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Error Message');");
    }
/***************************************************************************************/
    public static class FailedRule implements TestRule
    {
        @Override
        public Statement apply(final Statement base, final Description description)
        {
            return new Statement()
            {
                @Override
                public void evaluate() throws Throwable
                {
                    try
                    {
                        base.evaluate();
                    }
                    catch (Throwable t)
                    {
                        System.out.println(description.getDisplayName() + " failed");
                        retry.setNotGood();
                        if (retry.isLastTry())
                        {
                            System.out.println("No more retry !");
                            throw t;
                        }
                        else
                        {
                            System.out.println("Retrying.");
                        }
                    }
                }
            };
        }
    }

    public static class RetryRule implements TestRule
    {
        private int retryCount, currentTry;

        private boolean allGood = false;

        public RetryRule(int retryCount)
        {
            this.retryCount = retryCount;
            this.currentTry = 1;
        }

        public boolean isLastTry()
        {
            return currentTry == retryCount;
        }

        public void setNotGood()
        {
            allGood = false;
        }

        public Statement apply(final Statement base, final Description description)
        {
            return new Statement()
            {
                @Override
                public void evaluate() throws Throwable
                {
                    // implement retry logic here
                    for (; currentTry <= retryCount && !allGood; currentTry++)
                    {
                        allGood = true;
                        System.out.println("Try #" + currentTry);
                        base.evaluate();
                    }
                }
            };
        }
    }
    @ClassRule
    public static RetryRule retry = new RetryRule(3);

    @Rule
    public FailedRule onFailed = new FailedRule();

    @BeforeClass
    public static void before()
    {
        System.out.println("Before...");
    }

    @AfterClass
    public static void after()
    {
        System.out.println("...After\n");
    }
}
