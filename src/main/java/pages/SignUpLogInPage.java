package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpLogInPage extends BasePage {
    //Variables

    //Locators
    private final By nameField = By.name("name");
    private final By emailField = By.xpath("//form[@action='/signup']//input[@data-qa=\"signup-email\"]");
    private final By signupButton = By.xpath("//button[@data-qa=\"signup-button\"]");


    //Constractor
    public SignUpLogInPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public SignUpLogInPage typingName(String name){
        action.typingWithExplicitWait(nameField,name);
        return this;
    }

    public SignUpLogInPage typingEmail(String email){
        action.typingWithExplicitWait(emailField,email);
        return this;
    }
    public SignUpLogInPage clickOnSignUpButton(){
        action.clickWithExplicitWait(signupButton);
        return this;
    }




}
