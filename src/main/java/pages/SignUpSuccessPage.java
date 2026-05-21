package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.ActionMethods;

public class SignUpSuccessPage extends BasePage {
    //variables

    //Constructors
    public SignUpSuccessPage(WebDriver driver) {
        super(driver);
    }

    //Locaters
    private final By successMessageTitle = By.xpath("//*[@data-qa=\"account-created\"]");
    private final By successMessageDescription = By.xpath("(//h2/following-sibling::p)[1]");


    //Actions
    public SignUpSuccessPage verifySuccessMessageTitle (String expectedSuccessMessageTitle){
       String actualTitle = action.readTextFromElement(successMessageTitle);
       Assert.assertEquals(actualTitle,expectedSuccessMessageTitle);
       return this;
    }

    public SignUpSuccessPage verifySuccessMessageDescription (String expectedSuccessMessageDescription){
        String actualTitle = action.readTextFromElement(successMessageDescription);
        Assert.assertEquals(actualTitle,expectedSuccessMessageDescription);
        return this;
    }





}
