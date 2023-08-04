package stepDefinations;

import business.concretes.LoginPagesManager;
import business.concretes.SalePagesManager;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import utils.drivers.Driver;

public class LoginAndSaleTestSteps {
    private final LoginPagesManager loginPagesManager = new LoginPagesManager();
    private final SalePagesManager salePagesManager   = new SalePagesManager();

    @Given("Go to Website {string}")
    public void goToWebsite(String url){ loginPagesManager.goToWebsite(url); }

    @And("Accept {string} or Reject {string} Cookies")
    public void acceptOrRejectCookies(String cookieAcceptPath, String cookieRejectPath)
    { loginPagesManager.acceptOrRejectCookies("h", cookieAcceptPath, cookieRejectPath); }

    @And("Click Login Button {string}")
    public void clickLoginButton(String buttonPath){ loginPagesManager.clickButton(buttonPath); }

    @And("Fill in Username Field {string} {string}")
    public void fillInUsernameField(String userNamePath, String userName)
    { loginPagesManager.sendKeysInput(userNamePath, userName); }

    @And("Fill in Password Field {string} {string}")
    public void fillInPasswordField(String passwordPath, String password)
    { loginPagesManager.sendKeysInput(passwordPath, password); }

    @And("Select Input Button {string} {string} and Click Search Button {string}")
    public void selectInputButtonAndClickSearchButton
            (String selectInputButtonPath, String inputMessage, String searchButtonPath){
        salePagesManager.pageRefresh();
        salePagesManager.sendKeysInput(selectInputButtonPath, inputMessage);
        salePagesManager.clickButton(searchButtonPath);
    }


//  * * * * * * * * * * * * * JUST AMAZON * * * * * * * * * * * * * * * * * * * * * * *
    @And("Click Shipped by Amazon")
    public void clickShippedByAmazon() {
        String chooseButtonPath = "//li[@id='p_98/21345978031']//i[@class='a-icon a-icon-checkbox']";

        salePagesManager.clickButton(chooseButtonPath);
    }
//  * * * * * * * * * * * * * JUST AMAZON * * * * * * * * * * * * * * * * * * * * * * *


    @And("Choose Brand {string}")
    public void chooseBrand(String chooseBrandButtonPath) {
        salePagesManager.pageRefresh();
        salePagesManager.clickButton(chooseBrandButtonPath);
    }

    @And("Click to Product {string}")
    public void clickToProduct(String productPath) {
        salePagesManager.clickButton(productPath);
    }

    @And("Add {string} and Go to Cart {string}")
    public void addAndGoToCart(String addToCartButtonPath, String goToCartButtonPath) {
        salePagesManager.clickButton(addToCartButtonPath);
        salePagesManager.clickButton(goToCartButtonPath);
    }


//  * * * * * * * * * * * * * JUST TRENDYOL * * * * * * * * * * * * * * * * * * * * * * *
    @And("Add {string} and Go to the Cart {string}")
    public void addAndGoToTheCart(String addToCartButtonPath, String goToCartButtonPath) {
        salePagesManager.pageSwitchToNewTab();
        salePagesManager.clickButton(addToCartButtonPath);
        salePagesManager.pageRefresh();
        salePagesManager.clickButton(goToCartButtonPath);
    }

    @And("Click to Understand Button")
    public void clickToUnderstandButton() {
        String understandButtonPath = "//button[contains(text(),'Anladım')]";

        salePagesManager.clickButton(understandButtonPath);
    }
//  * * * * * * * * * * * * * JUST TRENDYOL * * * * * * * * * * * * * * * * * * * * * * *


    @And("Empty the Basket {string}")
    public void emptyTheBasket(String deleteButtonPath) {
        salePagesManager.clickButton(deleteButtonPath);
    }

    @Then("Check Error Message {string}")
    public void checkErrorMessage(String messagePath) { loginPagesManager.checkErrorMessage(messagePath); }

    @After
    public void waitAndQuitDriver() throws InterruptedException {
        Thread.sleep(3000);

        Driver.restartDriver();
    }
}