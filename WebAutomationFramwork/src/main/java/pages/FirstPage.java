package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends BasePage {
    public FirstPage(WebDriver driver) {
        super(driver);
    }

    //you can create the selectors here
    @FindBy(css = "css")
    WebElement element;

    public void clickOnElement(){
        //here you can write the event you want this method to do
        element.click();
    }
}