package com.randhier.app;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by randhier on 9/26/16.
 */
public class ZapposTest {

    public WebDriver driver;

    @Test
    public void main() {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
    }

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
            driver = new FirefoxDriver();
            driver.get("http://zappos.com");
        }

    @AfterClass
    public void tearDown() {
        // Close the driver
        driver.quit();
    }
}