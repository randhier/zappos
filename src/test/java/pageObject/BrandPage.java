package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrandPage extends BasePage {

    By addToCartButton = By.id("addToCart");
    By infoPopup = By.cssSelector(".info div");
    By noSizeLink = By.id("notifyMePopupLink");

    public BrandPage(WebDriver driver){
        super(driver);
    }

    public void clickAddToCartButton(){
        clickElement(addToCartButton);
    }

    public String infoPopupText(){
        return getElementText(infoPopup);
    }

    public void clickNoSizeLink(){
        clickElement(noSizeLink);
    }
}
