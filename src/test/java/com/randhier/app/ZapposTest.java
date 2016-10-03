package com.randhier.app;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.*;

public class ZapposTest {

    private WebDriver driver;
    private HomePage HomePage;
    private MenShoePage MensPage;
    private MenAthleticPage AthleticPage;
    private BrandPage Inov8Page;
    private NoSizeNotifyPage NotifyMePage;

    @Test
    public void main() {
        System.out.println(driver.getTitle());
        HomePage.clickMenShoeLink();
        Assert.assertEquals(driver.getTitle(), "Men's Shoes, Shoes For Men | Ships FREE at Zappos.com");
        MensPage.clickMenAthleticLink();
        Assert.assertEquals(driver.getTitle(), "Shoes, Athletic, Men | Shipped Free at Zappos");
        AthleticPage.clickInov8BrandLink();
        Assert.assertEquals(driver.getTitle(), "Inov-8, Sneakers & Athletic Shoes, Athletic, Men | Shipped Free at Zappos");
        AthleticPage.clickFlite240Shoe();
        Assert.assertEquals(driver.getTitle(), "inov-8 F-Lite 240 Black/Dark Red/White - Zappos.com Free Shipping BOTH Ways");
        Inov8Page.clickAddToCartButton();
        Assert.assertEquals(Inov8Page.infoPopupText(), "Please select a size");
        Inov8Page.clickNoSizeLink();
        Inov8Page.switchToPopup();
        Assert.assertEquals(driver.getTitle(), "Zappos.com - Notify Me!");
        NotifyMePage.fillOutSizeForm();
        /**
         * Rather than spam zappos with requests, I decided to just hit the cancel button
         * instead of submitting.  It's their public site so I rather not.
         */
        NotifyMePage.clickCancelButton();
    }

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        HomePage = new HomePage(driver);
        MensPage = new MenShoePage(driver);
        AthleticPage = new MenAthleticPage(driver);
        Inov8Page = new BrandPage(driver);
        NotifyMePage = new NoSizeNotifyPage(driver);
        driver.get("http://zappos.com");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}