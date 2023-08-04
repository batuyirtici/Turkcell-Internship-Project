package business.concretes;

import business.abstracts.PageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.drivers.Driver;

import java.util.Set;

public class SalePagesManager extends PageFunctions {
    WebDriver webDriver;

    public SalePagesManager() {
        webDriver = Driver.getDriver();

        PageFactory.initElements(webDriver, this);
    }

    public void clickButton(String clickButtonPath){
        try { Thread.sleep(3000); }
        catch (InterruptedException exception){}

        WebElement clickButtonElement = webDriver.findElement(By.xpath(clickButtonPath));

        clickFunction(clickButtonElement);
    }

    public void sendKeysInput(String elementPath, String value){
        WebElement sendKeysInputElement = webDriver.findElement(By.xpath(elementPath));

        sendKeysFunction(sendKeysInputElement, value);
    }

    public void pageDown(){ pageDownFunction(); }

    public void pageRefresh(){
        try { Thread.sleep(3000); }
        catch (InterruptedException exception) { exception.printStackTrace(); }

        webDriver.navigate().refresh(); }

    public void pageSwitchToNewTab(){
        Set<String> windowHandles = webDriver.getWindowHandles();
        String currentHandle = webDriver.getWindowHandle();
        String newTabHandle = null;

        for (String handle : windowHandles) {
            if (!handle.equals(currentHandle)) {
                newTabHandle = handle;
                break;
            }
        }

        if (newTabHandle != null) { webDriver.switchTo().window(newTabHandle); }
        else { throw new NoSuchElementException("New tab not found!"); }
    }
}
