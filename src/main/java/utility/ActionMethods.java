package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ActionMethods {
    WebDriver driver;

    public ActionMethods(WebDriver driver){
        this.driver = driver;
    }

    public void clickWithExplicitWait(By locator) {
        //define the wait type and wait configuration
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //wait until the element is present in DOM or HTML
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //wait until the element is visible on page on GUI
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //wait until the element is enabled or clickable on page
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        //take the click action inside wait with lambda function
        wait.until(d -> {
            driver.findElement(locator).click();
            return true;
        });
    }

    public void clickWithFluentWait(By locater ){
        //define the wait type and wait configuration
        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        //wait until the element is present in DOM or HTML
        wait1.until(ExpectedConditions.presenceOfElementLocated(locater));
        //wait until the element is visible on page on GUI
        wait1.until(ExpectedConditions.visibilityOfElementLocated(locater));
        //wait until the element is enabled or clickable on page
        wait1.until(ExpectedConditions.elementToBeClickable(locater));

        //take the click action inside wait with lambda function
        wait1.until(d -> {
            driver.findElement(locater).click();
            return true;
        });

    }

    public void typingWithExplicitWait(By locator, String name ){
        //define the wait type and wait configuration
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait until the element is present in DOM or HTML
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //wait until the element is visible on page on GUI
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //wait until the element is enabled or clickable on page
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        //take the typing action inside wait with lambda function
        wait.until(d -> {
            driver.findElement(locator).sendKeys(name);
            return true;
        });

    }

    public void typingWithFluentWait(By locator, String name ){
        //define the wait type and wait configuration
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        //wait until the element is present in DOM or HTML
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //wait until the element is visible on page on GUI
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //wait until the element is enabled or clickable on page
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        //take the typing action inside wait with lambda function
        wait.until(d -> {
            driver.findElement(locator).sendKeys(name);
            return true;
        });

    }

    public void selectFromDropDownByText(By locator,String text){
        //define the wait type and wait configuration
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //wait until the element is present in DOM or HTML
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //wait until the element is visible on page on GUI
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //wait until the element is enabled or clickable on page
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        Select select = new Select(driver.findElement(locator));

        select.selectByVisibleText(text);

    }

    public String readTextFromElement(By locator){
        //define the wait type and wait configuration
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //wait until the element is present in DOM or HTML
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //wait until the element is visible on page on GUI
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //wait until the element is enabled or clickable on page
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        String text = driver.findElement(locator).getText();

        return text;
    }
}
