package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private WebElement getElement(By loc){
        WebElement element = this.driver.findElement(loc);
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

    public void switchToPopup(){
        for (String handle : this.driver.getWindowHandles()) {
            driver.switchTo().window(handle);}
    }

}
