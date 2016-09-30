package com.randhier.app;

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ZapposTest {

    public WebDriver driver;

    By menShoesLoc = By.cssSelector("a[class$='Shop-Men-s-Shoes']");
    By menAthleticLoc = By.cssSelector("a[class$='Popular-Men-s-Styles-Athletic']");
    By inov8Loc = By.cssSelector("a[class$='Inov-8 ']");
    By inov8ShoeLoc = By.cssSelector("a[class*='product-8734874 style-3637472']");
    By addToCartLoc = By.id("addToCart");
    By infoLoc = By.cssSelector(".info div");
    By noSizeLoc = By.id("notifyMePopupLink");
    By emailLoc = By.id("email");
    By colorLoc = By.id("styleId");
    By sizeLoc = By.id("dimensionValueIds");
    By cancelLoc = By.cssSelector(".btn.secondary");


    public WebElement getElement(By loc){
        WebElement element = driver.findElement(loc);
        return element;
    }

    public void clickElement(By loc){
        getElement(loc).click();
    }

    public void sendTextToElement(String text, By loc){
        getElement(loc).sendKeys(text);
    }

    public void selectVisableTextOfElement(String text, By loc){
        Select select = new Select(getElement(loc));
        select.selectByVisibleText(text);
    }

    public String getElementText(By loc){
        String text = getElement(loc).getText().trim();
        return text;
    }


    @Test
    public void main() {
        clickElement(menShoesLoc);
        Assert.assertEquals(driver.getTitle(), "Men's Shoes, Shoes For Men | Ships FREE at Zappos.com");
        clickElement(menAthleticLoc);
        Assert.assertEquals(driver.getTitle(), "Shoes, Athletic, Men | Shipped Free at Zappos");
        clickElement(inov8Loc);
        Assert.assertEquals(driver.getTitle(), "Inov-8, Sneakers & Athletic Shoes, Athletic, Men | Shipped Free at Zappos");
        clickElement(inov8ShoeLoc);
        Assert.assertEquals(driver.getTitle(), "inov-8 F-Lite 240 Black/Dark Red/White - Zappos.com Free Shipping BOTH Ways");
        clickElement(addToCartLoc);
        Assert.assertEquals(getElementText(infoLoc), "Please select a size");
        clickElement(noSizeLoc);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);}
        Assert.assertEquals(driver.getTitle(), "Zappos.com - Notify Me!");
        sendTextToElement("Test123", emailLoc);
        selectVisableTextOfElement("Blue/Grey/White", colorLoc);
        selectVisableTextOfElement("UK 10 (US Men's 11)", sizeLoc);
        /**
         * Rather than spam zappos with requests, I decided to just hit the cancel button
         * instead of submitting.  It's their public site so I rather not.
         */
        clickElement(cancelLoc);
    }

    @BeforeClass
    public void setUp() {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://zappos.com");
        }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}