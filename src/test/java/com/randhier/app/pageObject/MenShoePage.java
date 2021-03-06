package com.randhier.app.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenShoePage extends BasePage {

    private static By menAthleticLink = By.cssSelector("a[class$='Popular-Men-s-Styles-Athletic']");

    public MenShoePage(WebDriver driver){
        super(driver);
    }

    public void clickMenAthleticLink(){
        clickElement(menAthleticLink);
    }
}
