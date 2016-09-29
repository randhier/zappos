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

    @Test
    public void main() {
        WebElement menShoesLink = driver.findElement(By.cssSelector("a[class$='Shop-Men-s-Shoes']"));
        menShoesLink.click();
        Assert.assertEquals(driver.getTitle(), "Men's Shoes, Shoes For Men | Ships FREE at Zappos.com");
        WebElement menAthleticLink = driver.findElement(By.cssSelector("a[class$='Popular-Men-s-Styles-Athletic']"));
        menAthleticLink.click();
        Assert.assertEquals(driver.getTitle(), "Shoes, Athletic, Men | Shipped Free at Zappos");
        WebElement inov8Link = driver.findElement(By.cssSelector("a[class$='Inov-8 ']"));
        inov8Link.click();
        Assert.assertEquals(driver.getTitle(), "Inov-8, Sneakers & Athletic Shoes, Athletic, Men | Shipped Free at Zappos");
        WebElement inov8ShoeLink = driver.findElement(By.cssSelector("a[class*='product-8734874 style-3637472']"));
        inov8ShoeLink.click();
        Assert.assertEquals(driver.getTitle(), "inov-8 F-Lite 240 Black/Dark Red/White - Zappos.com Free Shipping BOTH Ways");
        WebElement addToCartButton = driver.findElement(By.id("addToCart"));
        addToCartButton.click();
        WebElement info = driver.findElement(By.cssSelector(".info div"));
        Assert.assertEquals(info.getText().trim(), "Please select a size");
        WebElement noSizeLink = driver.findElement(By.id("notifyMePopupLink"));
        noSizeLink.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);}
        Assert.assertEquals(driver.getTitle(), "Zappos.com - Notify Me!");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("Test123");
        Select select = new Select(driver.findElement(By.id("styleId")));
        select.selectByVisibleText("Blue/Grey/White");
        Select select1 = new Select(driver.findElement(By.id("dimensionValueIds")));
        select1.selectByVisibleText("UK 10 (US Men's 11)");
        WebElement cancelButton = driver.findElement(By.cssSelector(".btn.secondary"));
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