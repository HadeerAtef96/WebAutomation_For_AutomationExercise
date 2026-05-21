package testCases;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpLogInPage;
import pages.SignUpPage;
import pages.SignUpSuccessPage;
import utility.ActionMethods;
import utility.BrowserFactory;
import utility.JsonManager;

import java.io.File;
import java.io.IOException;

import static utility.BrowserFactory.openBrowser;
import static utility.DataGenerator.*;
import static utility.DataGenerator.generateStringFromList;
import static utility.PropertiesManager.getPropertiesValue;
import static utility.PropertiesManager.loadPropertiesIntoSystem;

public class TestCaseOfSignUp {
    //Objects and Variables
    WebDriver driver;
    JsonManager json;
    @BeforeMethod
    public void preConditions() {
        try {
            loadPropertiesIntoSystem();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Read Test Data from Json
        json = new JsonManager("src/test/resources/TestData.json");

        //open Browser
        this.driver = openBrowser();

        //navigate to website url
        driver.get(getPropertiesValue("websiteURL"));
    }

    @Test(description = "this test case validate when new user need to register")
    public void signupWithNewUserWithStaticData() {
        //take actions on elements
        new HomePage(driver)
                .navigateToSignupLoginPage();

        new SignUpLogInPage(driver)
                .typingName(json.readTestData("validUser.name"))
                .typingEmail(generateRandomEmail())
                .clickOnSignUpButton();

        new SignUpPage(driver)
                .selectMROption()
                .typingPassword(json.readTestData("validUser.password"))
                .clickDaysDropDown()
                .clickMonthsDropDown()
                .clickYearsDropDown()
                .clickNewsLetterCheckbox()
                .receiveSpecialOffersCheckBox()
                .typingFirstName(json.readTestData("validUser.firstName"))
                .typingLastName(json.readTestData("validUser.lastName"))
                .typingCompanyName(json.readTestData("validUser.companyName"))
                .typingAddress1Field(json.readTestData("validUser.address1"))
                .typingAddress2Field(json.readTestData("validUser.address2"))
                .selectCountryFromDropDown(json.readTestData("validUser.country"))
                .typingState(json.readTestData("validUser.state"))
                .typingCity(json.readTestData("validUser.city"))
                .typingZibCode(json.readTestData("validUser.zipCode"))
                .typingMobile(json.readTestData("validUser.mobile"))
                .clickCreatAccountButton();

        new SignUpSuccessPage(driver)
                .verifySuccessMessageTitle(json.readTestData("successMessages.signUpTitle"))
                .verifySuccessMessageDescription(json.readTestData("successMessages.signUpDescription"));
    }

//    @Test
//    public void signupWithNewUserWithRandomData() {
//        //take actions on elements using ActionsMethods Class
//        action.clickWithExplicitWait(signupLoginButton);
//
//        action.typingWithExplicitWait(nameField, generateRandomFirstName());
//
//        action.typingWithExplicitWait(emailField, generateRandomEmailByTimeStamp() );
//
//        action.clickWithFluentWait(signupButton);
//
//        action.clickWithExplicitWait(mrRadioButton);
//
//        action.typingWithExplicitWait(passwordField, generateRandomPassword() );
//
//        action.selectFromDropDownByText(daysDropDown,generateNumberBetweenMaxAndMin(1,30));
//        action.selectFromDropDownByText(monthsDropDown,generateStringFromList("January", "February","March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
//        action.selectFromDropDownByText(yearsDropDown,generateNumberBetweenMaxAndMin(1900,2021));
//
//        action.clickWithFluentWait(newsLetterCheckbox);
//        action.clickWithExplicitWait(receiveSpecialOffersCheckBox);
//        action.typingWithExplicitWait(first_nameField, generateRandomFirstName());
//        action.typingWithExplicitWait(last_nameField, generateRandomFirstName());
//        action.typingWithFluentWait(companyField, generateCompany());
//        action.typingWithExplicitWait(address1Field,generateAddress());
//        action.typingWithFluentWait(address2Field,generateAddress());
//
//        action.selectFromDropDownByText(countryDropDown,generateStringFromList(   "India", "United States", "Canada", "Australia", "Israel", "New Zealand", "Singapore"));
//
//        action.typingWithExplicitWait(stateField, generateState());
//        action.typingWithFluentWait(cityField, generateCity());
//        action.typingWithExplicitWait(zipCodeField, generateZipCode());
//        action.typingWithFluentWait(mobileNumberField,generateMobile());
//
//        action.clickWithExplicitWait(createAccountButton);
//
//        String actualSuccessMessageTitle = action.readTextFromElement(successMessageTitle);
//        String actualSuccessMessageDescription = action.readTextFromElement(successMessageDescription);
//
//        Assert.assertEquals(actualSuccessMessageTitle,"ACCOUNT CREATED!");
//        Assert.assertEquals(actualSuccessMessageDescription,"Congratulations! Your new account has been successfully created!");
//    }

    @AfterMethod
    public void closeBrowser() {
        //close Browser
        driver.quit();
    }

}
