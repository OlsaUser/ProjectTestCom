package com.ProjectTestCom.steps;

import com.ProjectTestCom.pages.FavoritesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavoritesSteps extends ScenarioSteps {

    FavoritesPage favoritesPage;

    @Step
    public void pressIcon_addToFavorite(WebDriver driver) { favoritesPage.pressIcon_addToFavorite(driver);}

}
