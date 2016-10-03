package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenAthleticPage extends BasePage {

    WebDriver driver;
    By inov8BrandLink = By.cssSelector("a[class$='Inov-8 ']");
    By fLite240ShoeLink = By.cssSelector("a[class*='product-8734874 style-3637472']");

    public MenAthleticPage(WebDriver driver){
        super(driver);
    }

    public void clickInov8BrandLink(){
        clickElement(inov8BrandLink);
    }

    public void clickFlite240Shoe(){
        clickElement(fLite240ShoeLink);
    }
}
