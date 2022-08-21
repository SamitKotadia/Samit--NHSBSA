package uk.nhs.nhsbsa.services.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.nhs.nhsbsa.services.driver.DriverManager;



public class GetHelpPage extends DriverManager {

    DriverManager driverManager = new DriverManager();

    @FindBy(how = How.CSS, using = "#next-button")
    WebElement startNowButton;

    @FindBy(xpath = "//label[@id='label-wales']")
    WebElement liveInWales;

    @FindBy(xpath = "//h1[@id='question-heading']")
    WebElement countryText;

    @FindBy(how = How.XPATH, using = "//input[@id='next-button']")
    WebElement nextButton;

    @FindBy(css = "#radio-yes")
    WebElement yesRadioButton;

    @FindBy(css = "#radio-no")
    WebElement noRadioButton;

    @FindBy(how = How.XPATH, using = "//input[@id='next-button']")
    WebElement nextOnGPPractice;

    @FindBy(xpath = "//label[@id='label-wales']")
    WebElement walesForDental;

    @FindBy(css = "#dob-day")
    WebElement brithDay;

    @FindBy(how = How.CSS, using = "#dob-month")
    WebElement birthMonth;

    @FindBy(css = "#dob-year")
    WebElement birthYear;

    @FindBy(xpath = "//label[@id='label-yes']")
    WebElement optionYes;

    @FindBy(xpath = "//label[@id='label-no']")
    WebElement optionNo;

    @FindBy(xpath = "//input[@id='yes-universal']")
    WebElement yesUniversalCredit;

    @FindBy(xpath = "//input[@id='not-yet']")
    WebElement notYetUniversalCredit;

    @FindBy(how = How.XPATH, using = "//input[@id='different-benefit']")
    WebElement differentBenefit;

    @FindBy(css = ".heading-xlarge.done-panel")
    WebElement resultText;

    @FindBy(css = "#error-summary-heading")
    WebElement errorMassage;

    public String getErrorMassage(){
        String errorMassg = errorMassage.getText();
        System.out.println(errorMassg);
        return errorMassg;
    }

    public String actualResultText(){
        String actualTextMass;
         actualTextMass = resultText.getText();
        System.out.println(actualTextMass);
        return actualTextMass;
    }

    public void selectDifferentBenefit() {
        differentBenefit.click();
    }

    public void selectNotYetUniversalCredit() {
        notYetUniversalCredit.click();
    }

    public void SelectYesUniversalCredit() {

        yesUniversalCredit.click();
    }

    public void selectYesOption() {
        driverManager.waitUntilElementIsVisible(optionYes,10,"no element found");
        optionYes.click();
    }

    public void selectNoOption() {
        driverManager.waitUntilElementIsVisible(optionNo,10,"no element found");
        optionNo.click();
    }

    public void inputDateOfBirth(String day, String month, String year) throws InterruptedException {
        brithDay.sendKeys(day);
        birthMonth.sendKeys(month);
        birthYear.sendKeys(year);

    }

    public void clickWalesForDental() {
        walesForDental.click();
    }

    public void clickYesRadioButton() {
        yesRadioButton.click();
    }

    public void clickNoRadioButton() {
        noRadioButton.click();
    }

    public void clickNextButton() throws InterruptedException {
        nextButton.click();
      //  Thread.sleep(5000);
    }

    public void selectLiveInWales() {
        driverManager.waitUntilElementIsVisible(liveInWales,10,"no element found");
        liveInWales.click();
    }

    public void clickOnStartNowButton() {
        startNowButton.click();
    }
}
