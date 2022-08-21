package uk.nhs.nhsbsa.services.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.nhs.nhsbsa.services.utility.ReadCongiFile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class DriverManager {

    ReadCongiFile readCongiFile = new ReadCongiFile("Configration.properties");

    public static WebDriver driver;

    String URL = readCongiFile.getApplicationURL();
    String browser = readCongiFile.getApplicationBrowser();


    public DriverManager() {
        PageFactory.initElements(driver, this);
    }

    public void runOnLocalBrowser() throws IllegalAccessException {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalAccessException("Unexpected browser");
        }
    }

    public void goToURL() {
        driver.get(URL);
    }

    public void maxBrowser() {
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void applyImplicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void waitUntilElementIsVisible(WebElement element, int timeOut, String failureMassage) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.withMessage(failureMassage);
    }

    public WebElement waitUntilElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void generateAlert(WebDriver driver, String message){
        ((JavascriptExecutor) driver).executeScript("alert('"+ message+ "')");
    }

    public void reFreshPage(){
        driver.navigate().refresh();
    }

    public void takeScreenshot(Scenario scenario){
        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, "image/png");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("/Users/samit/Desktop//screenShotTest/error.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
