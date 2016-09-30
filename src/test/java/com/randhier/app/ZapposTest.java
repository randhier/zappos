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


    @Test
    public void main() {
        WebElement menShoesLink = driver.findElement(menShoesLoc);
        menShoesLink.click();
        Assert.assertEquals(driver.getTitle(), "Men's Shoes, Shoes For Men | Ships FREE at Zappos.com");
        WebElement menAthleticLink = driver.findElement(menAthleticLoc);
        menAthleticLink.click();
        Assert.assertEquals(driver.getTitle(), "Shoes, Athletic, Men | Shipped Free at Zappos");
        WebElement inov8Link = driver.findElement(inov8Loc);
        inov8Link.click();
        Assert.assertEquals(driver.getTitle(), "Inov-8, Sneakers & Athletic Shoes, Athletic, Men | Shipped Free at Zappos");
        WebElement inov8ShoeLink = driver.findElement(inov8ShoeLoc);
        inov8ShoeLink.click();
        Assert.assertEquals(driver.getTitle(), "inov-8 F-Lite 240 Black/Dark Red/White - Zappos.com Free Shipping BOTH Ways");
        WebElement addToCartButton = driver.findElement(addToCartLoc);
        addToCartButton.click();
        WebElement info = driver.findElement(infoLoc);
        Assert.assertEquals(info.getText().trim(), "Please select a size");
        WebElement noSizeLink = driver.findElement(noSizeLoc);
        noSizeLink.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);}
        Assert.assertEquals(driver.getTitle(), "Zappos.com - Notify Me!");
        WebElement emailField = driver.findElement(emailLoc);
        emailField.sendKeys("Test123");
        Select select = new Select(driver.findElement(colorLoc));
        select.selectByVisibleText("Blue/Grey/White");
        Select select1 = new Select(driver.findElement(sizeLoc));
        select1.selectByVisibleText("UK 10 (US Men's 11)");
        /**
         * Rather than spam zappos with request, I decided to just hit the cancel button
         * instead of submitting.  It's their public site so I rather not.
         */
        WebElement cancelButton = driver.findElement(cancelLoc);
        cancelButton.click();
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