package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.ActionMethods;

public class SignUpPage extends BasePage {
    //variables

    //constructor
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By mrRadioButton = By.id("id_gender1");
    private final By mrsRadioButton = By.id("id_gender2");
    private final By passwordField = By.id("password");
    private final By daysDropDown = By.id("days");
    private final By monthsDropDown = By.id("months");
    private final By yearsDropDown = By.id("years");
    private final By newsLetterCheckbox = By.id("newsletter");
    private final By receiveSpecialOffersCheckBox = By.id("optin");
    private final By first_nameField = By.id("first_name");
    private final By last_nameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryDropDown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipCodeField = By.id("zipcode");
    private final By mobileNumberField = By.name("mobile_number");
    private final By createAccountButton = By.xpath("//*[@data-qa=\"create-account\"]");

    //Actions
    public SignUpPage selectMROption() {
        action.clickWithFluentWait(mrRadioButton);
        return this;
    }

    public SignUpPage selectMRSOption() {
        action.clickWithExplicitWait(mrsRadioButton);
        return this;
    }

    public SignUpPage typingPassword(String password) {
        action.typingWithExplicitWait(passwordField, password);
        return this;
    }

    public SignUpPage clickDaysDropDown() {
        action.clickWithExplicitWait(daysDropDown);
        return this;
    }

    public SignUpPage clickMonthsDropDown() {
        action.clickWithExplicitWait(monthsDropDown);
        return this;
    }

    public SignUpPage clickYearsDropDown() {
        action.clickWithExplicitWait(yearsDropDown);
        return this;
    }

    public SignUpPage clickNewsLetterCheckbox() {
        action.clickWithExplicitWait(newsLetterCheckbox);
        return this;
    }

    public SignUpPage receiveSpecialOffersCheckBox() {
        action.clickWithExplicitWait(receiveSpecialOffersCheckBox);
        return this;
    }

    public SignUpPage typingFirstName(String firstName) {
        action.typingWithExplicitWait(first_nameField, firstName);
        return this;
    }

    public SignUpPage typingLastName(String lastName) {
        action.typingWithExplicitWait(last_nameField, lastName);
        return this;
    }

    public SignUpPage typingCompanyName(String company) {
        action.typingWithExplicitWait(companyField, company);
        return this;
    }

    public SignUpPage typingAddress1Field(String address1) {
        action.typingWithExplicitWait(address1Field, address1);
        return this;
    }

    public SignUpPage typingAddress2Field(String address2) {
        action.typingWithExplicitWait(address2Field, address2);
        return this;
    }

    public SignUpPage selectCountryFromDropDown(String country) {
        action.selectFromDropDownByText(countryDropDown, country);
        return this;
    }

    public SignUpPage typingState(String state) {
        action.typingWithExplicitWait(stateField, state);
        return this;
    }

    public SignUpPage typingCity(String city) {
        action.typingWithExplicitWait(cityField, city);
        return this;
    }

    public SignUpPage typingZibCode(String zibCode) {
        action.typingWithExplicitWait(zipCodeField, zibCode);
        return this;
    }

    public SignUpPage typingMobile(String mobile) {
        action.typingWithExplicitWait(mobileNumberField, mobile);
        return this;
    }

    public SignUpPage clickCreatAccountButton() {
        action.clickWithExplicitWait(createAccountButton);
        return this;
    }


}

