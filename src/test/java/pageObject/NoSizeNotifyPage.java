package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoSizeNotifyPage extends BasePage {

    WebDriver driver;
    By emailField = By.id("email");
    By colorDropdown = By.id("styleId");
    By sizeDropdown = By.id("dimensionValueIds");
    By cancelButton = By.cssSelector(".btn.secondary");

    public NoSizeNotifyPage(WebDriver driver) {
        super(driver);
    }

    public void fillOutSizeForm() {
        sendTextToElement("Test123", emailField);
        selectVisableTextOfElement("Blue/Grey/White", colorDropdown);
        selectVisableTextOfElement("UK 10 (US Men's 11)", sizeDropdown);
    }

    public void clickCancelButton(){
        clickElement(cancelButton);
    }
}
