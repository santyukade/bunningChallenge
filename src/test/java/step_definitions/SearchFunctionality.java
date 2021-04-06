package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.homepage;

import java.util.HashMap;
import java.util.List;


public class SearchFunctionality {
    public WebDriver driver;
    public List<HashMap<String, String>> datamap;

    public SearchFunctionality() {
        driver = Hooks.driver;
        //   datamap = DataHelper.data();
    }

    @When("^I open the Bunnings website home page$")
    public void iOpentheBunningsWebsiteHomePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.bunnings.com.au/");

        //  throw new PendingException();
    }

    @And("^I verify home page$")
    public void iVerifyHomePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // WebDriverWait wait = new WebDriverWait(driver,60);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logo-bunnings-warehouse\"]")));

        String actualTitle = driver.getTitle();
        String expectedTitle = "Bunnings Warehouse | Australia's DIY, Garden & Hardware Store";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Pass" + actualTitle);
        } else {
            System.out.println("Test Failed" + actualTitle);
            throw new PendingException();
        }
    }

    @Then("^I verify search box and button on it$")
    public void iVerifySearchBoxAndButtonOnIt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();
        PageFactory.initElements(driver, homepage.class);
        SearchFeature.Execute(driver, datamap);
    }

    @Then("^I verify placeholder text \"([^\"]*)\" present in searchbox$")
    public void iVerifyPlaceholderTextPresentInSearchbox(String inputString) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        PageFactory.initElements(driver, homepage.class);
        SearchFeature.placeholderText(driver, inputString);

    }

    @Then("^I enter the text\"([^\"]*)\" in searchBox$")
    public void iEnterTheTextInSearchBox(String inputText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        PageFactory.initElements(driver, homepage.class);

        SearchFeature.enterText(driver, inputText);
//        throw new PendingException();

    }

    @And("^I click on SearchButton$")
    public void iClickOnSearchButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, homepage.class);
        SearchFeature.clickonSerachbutton(driver);
//        throw new PendingException();
    }

    @Then("^I verify the relevant results \"([^\"]*)\" present on search page$")
    public void iVerifyTheRelevantResultsPresentOnSearchPage(String resultString) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, homepage.class);
        SearchFeature.verifylistofResult(driver, resultString);
    }

    @Then("^I verify the relevant search result \"([^\"]*)\" page displayed$")
    public void iVerifyTheRelevantSearchResultPageDisplayed(String resultString) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, homepage.class);
        SearchFeature.verifylistofResult(driver, resultString);
    }

    @Then("^I close the page$")
    public void iCloseThePage() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }
}