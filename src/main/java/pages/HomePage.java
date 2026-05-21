package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import javax.swing.*;

public class HomePage extends BasePage {
    // Constructor
    public HomePage(WebDriver driver){
        super(driver);
    }

    // Locators
    private final By signupLoginButton = By.xpath("//a[@href= '/login' ]");
    private final By test = null;

    // Actions
    public HomePage navigateToSignupLoginPage(){
        action.clickWithExplicitWait(signupLoginButton);
        return this;
    }

}
