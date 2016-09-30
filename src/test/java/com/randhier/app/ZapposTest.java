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

    By menShoesLink = By.cssSelector("a[class$='Shop-Men-s-Shoes']");
    By menAthleticLink = By.cssSelector("a[class$='Popular-Men-s-Styles-Athletic']");
    By inov8BrandLink = By.cssSelector("a[class$='Inov-8 ']");
    By fLite240ShoeLink = By.cssSelector("a[class*='product-8734874 style-3637472']");
    By addToCartButton = By.id("addToCart");
    By infoPopup = By.cssSelector(".info div");
    By noSizeLink = By.id("notifyMePopupLink");
    By emailField = By.id("email");
    By colorDropdown = By.id("styleId");
    By sizeDropdown = By.id("dimensionValueIds");
    By cancelButton = By.cssSelector(".btn.secondary");


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
        clickElement(menShoesLink);
        Assert.assertEquals(driver.getTitle(), "Men's Shoes, Shoes For Men | Ships FREE at Zappos.com");
        clickElement(menAthleticLink);
        Assert.assertEquals(driver.getTitle(), "Shoes, Athletic, Men | Shipped Free at Zappos");
        clickElement(inov8BrandLink);
        Assert.assertEquals(driver.getTitle(), "Inov-8, Sneakers & Athletic Shoes, Athletic, Men | Shipped Free at Zappos");
        clickElement(fLite240ShoeLink);
        Assert.assertEquals(driver.getTitle(), "inov-8 F-Lite 240 Black/Dark Red/White - Zappos.com Free Shipping BOTH Ways");
        clickElement(addToCartButton);
        Assert.assertEquals(getElementText(infoPopup), "Please select a size");
        clickElement(noSizeLink);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);}
        Assert.assertEquals(driver.getTitle(), "Zappos.com - Notify Me!");
        sendTextToElement("Test123", emailField);
        selectVisableTextOfElement("Blue/Grey/White", colorDropdown);
        selectVisableTextOfElement("UK 10 (US Men's 11)", sizeDropdown);
        /**
         * Rather than spam zappos with requests, I decided to just hit the cancel button
         * instead of submitting.  It's their public site so I rather not.
         */
        clickElement(cancelButton);
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