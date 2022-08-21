package uk.nhs.nhsbsa.services;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import uk.nhs.nhsbsa.services.driver.DriverManager;

public class Hooks {
    DriverManager driverManager = new DriverManager();

    @Before
    public void setUp() throws IllegalAccessException {
        driverManager.runOnLocalBrowser();
        driverManager.goToURL();
        driverManager.maxBrowser();
        driverManager.applyImplicitWait();
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            driverManager.takeScreenshot(scenario);
        }
        driverManager.closeBrowser();
    }
}

