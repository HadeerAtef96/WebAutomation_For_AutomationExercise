package pages;

import org.openqa.selenium.WebDriver;
import utility.ActionMethods;

public class BasePage {
    //Variables or Objects
    protected ActionMethods action;

    public BasePage(WebDriver driver){
        this.action = new ActionMethods(driver);
    }
}
