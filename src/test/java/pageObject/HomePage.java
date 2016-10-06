package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static By menShoesLink = By.cssSelector("a[class$='Shop-Men-s-Shoes']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickMenShoeLink(){
        clickElement(menShoesLink);
    }
}
