package uk.nhs.nhsbsa.services.step_defination;

import cucumber.api.java.en.*;
import uk.nhs.nhsbsa.services.driver.DriverManager;
import uk.nhs.nhsbsa.services.pages.GetHelpPage;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class GetHelpSteps extends DriverManager {
    DriverManager driverManager = new DriverManager();
    GetHelpPage getHelpPage = new GetHelpPage();

    @Given("^I am on Base URL page$")
    public void i_am_on_Base_URL_page() throws Throwable {
        String actualURL = driverManager.getURL();
        System.out.println(actualURL);
        assertThat(actualURL, is(endsWith("check-for-help-paying-nhs-costs/start")));
    }

    @When("^I Click on \"([^\"]*)\" button$")
    public void i_Click_on_button(String button) throws Throwable {
        switch (button) {
            case "Start Now":
                getHelpPage.clickOnStartNowButton();
                break;
            case "Next":
                getHelpPage.clickNextButton();
                break;
        }
    }

    @When("^I select \"([^\"]*)\" in \"([^\"]*)\" page$")
    public void i_select_in_page(String place, String page) throws Throwable {
        switch (page) {
            case "I Live in country":
                if (place.equals("Wales")) {
                    getHelpPage.selectLiveInWales();
                }
                break;

            case "my dental practice in":
                if (place.equals("Wales")) {
                    getHelpPage.clickWalesForDental();
                }
                break;
        }
    }

    @When("^I select \"([^\"]*)\" for \"([^\"]*)\"$")
    public void i_select_for(String option, String page) throws Throwable {
        switch (page) {
            case "you and your partner have a combined take-home pay":
                if (option.equals("Yes")) {
                    getHelpPage.clickYesRadioButton();
                } else if (option.equals("No")) {
                    getHelpPage.clickNoRadioButton();
                } else
                break;
            case "GP practice in Scotland or Wales":
            case "live with a partner":
            case "As part of your joint Universal Credit":
            case "you or your partner claim any benefits or tax credits":
                if (option.equals("Yes")) {
                    getHelpPage.selectYesOption();
                } else if (option.equals("No")) {
                    getHelpPage.selectNoOption();
                }
                break;

            case "you or your partner get paid Universal Credit":
                if (option.equals("Yes")) {
                    getHelpPage.SelectYesUniversalCredit();
                } else if (option.equals("Not yet")) {
                    getHelpPage.selectNotYetUniversalCredit();
                } else if (option.equals("No")) {
                    getHelpPage.selectDifferentBenefit();
                }
                break;
        }
    }

    @When("^I input my Birth date value as \"([^\"]*)\" day \"([^\"]*)\" month and \"([^\"]*)\" year$")
    public void i_input_my_Birth_date_value_as_day_month_and_year(String day, String month, String year) throws Throwable {
        getHelpPage.inputDateOfBirth(day, month, year);
    }

    @Then("^I should see \"([^\"]*)\" text$")
    public void i_should_see_text(String expectedText) throws Throwable {
    String actualText =getHelpPage.actualResultText();
        assertThat(actualText, is(equalToIgnoringCase(expectedText)));
    }

    @When("^I can see error massage \"([^\"]*)\"$")
    public void i_can_see_error_massage(String expectedMsg) throws Throwable {
    String actualMsg = getHelpPage.getErrorMassage();
        assertThat(actualMsg, is(equalToIgnoringCase(expectedMsg)));
        driverManager.generateAlert(driver,"Please select one option");
    }
}
