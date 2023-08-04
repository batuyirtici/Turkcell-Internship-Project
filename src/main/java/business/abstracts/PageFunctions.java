package business.abstracts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.drivers.Driver;

import java.time.Duration;

public abstract class PageFunctions {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private Actions actions;

    public PageFunctions() {
        webDriver = Driver.getDriver();
        actions   = new Actions(webDriver);
        wait      = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public void checkVisibleFunciton(WebElement element) { wait.until(ExpectedConditions.visibilityOf(element)); }

    public void clickFunction(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    public String getTextElementFunction(WebElement element){ return element.getText(); }

    public void getUrlDriverFunction(String url){
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }


    public void hoverFunction(WebElement element){ actions.moveToElement(element).perform(); }

    public void pageDownFunction(){ actions.sendKeys(Keys.PAGE_DOWN).build().perform(); }

    public void selectElementFromDropdownFunction(WebElement dropdown, String element){
        Select select = new Select(dropdown);

        select.selectByVisibleText(element);
    }

    public void sendKeysFunction(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element));

        element.sendKeys(value);
    }
}