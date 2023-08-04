package business.concretes;

import business.abstracts.PageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.drivers.Driver;

import java.util.Set;

public class LoginPagesManager extends PageFunctions {
    WebDriver webDriver;

    public LoginPagesManager() {
        webDriver = Driver.getDriver();

        PageFactory.initElements(webDriver, this);
    }

    public void goToWebsite(String url){ getUrlDriverFunction(url); }

    public void acceptOrRejectCookies(String choose, String cookieAcceptPath, String cookieRejectPath){
        WebElement cookieAcceptButtonElement = webDriver.findElement(By.xpath(cookieAcceptPath));
        WebElement cookieRejectButtonElement = webDriver.findElement(By.xpath(cookieRejectPath));

        if (choose.equalsIgnoreCase("e")){ clickFunction(cookieAcceptButtonElement); }

        else { clickFunction(cookieRejectButtonElement); }
    }

    public void clickButton(String clickButtonPath){
        WebElement clickButtonElement = webDriver.findElement(By.xpath(clickButtonPath));

        clickFunction(clickButtonElement);
    }

    public void sendKeysInput(String elementPath, String value){
        WebElement sendKeysInputElement = webDriver.findElement(By.xpath(elementPath));

        sendKeysFunction(sendKeysInputElement, value);
    }

    public void checkErrorMessage(String messagePath){
        WebElement checkErrorMessageElement = webDriver.findElement(By.xpath(messagePath));

        checkVisibleFunciton(checkErrorMessageElement);
    }

    public void pageDown(){ pageDownFunction(); }

    public void pageRefresh(){
        try { Thread.sleep(3000); }
        catch (InterruptedException exception) { exception.printStackTrace(); }

        webDriver.navigate().refresh(); }
}
