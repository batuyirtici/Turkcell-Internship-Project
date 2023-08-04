package runners;


import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import utils.drivers.Driver;

@CucumberOptions(
        plugin = {"com.vimalselvam.cucumber.ExtentCucumberFormatter:target/ExtentReport/ExtentReportRegression.html"},

        features = {"src\\test\\java\\features"},

        glue = {"stepDefinations", "utils"},

        tags = "",

        monochrome = true
)

public class Runner extends AbstractTestNGCucumberTests {
    static WebDriver webDriver = Driver.getDriver();

    @AfterClass
    public static void AfterClass(){
        Reporter.loadXMLConfig("src/main/java/xmlFiles/extendReportSet.xml");

        Reporter.setSystemInfo("QA Tester: ", "Batuhan YIRTICI");
        Reporter.setSystemInfo("Application Name: ", "Shopping Test");
        Reporter.setSystemInfo("Operating System Info: ", System.getProperty("os.name"));
        Reporter.setSystemInfo("Department: ", "QA");

        Reporter.setTestRunnerOutput("Test execution Cucumber Report");
    }
}