package modules;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.homepage;

import java.util.HashMap;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class SearchFeature {

    public static void Execute(WebDriver driver, List<HashMap<String, String>> map) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        homepage.searchbox.isDisplayed();
        homepage.searchButton.isDisplayed();
    }

    public static void placeholderText(WebDriver driver, String inputText) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String placeholder = homepage.searchBoxplaceholder.getAttribute("placeholder");
        assertEquals(inputText, placeholder);

    }

    public static void enterText(WebDriver driver, String inputText) throws Exception {
        homepage.searchbox.clear();
        homepage.searchbox.sendKeys(inputText);

    }

    public static void clickonSerachbutton(WebDriver driver) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        homepage.searchButton.click();
    }

    public static void verifyResultspage(WebDriver driver, String results) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Search - Additional Pages | Bunnings Warehouse";
        String expectedResult = homepage.searchResultText.getText();
        System.out.println("Testing" + expectedResult);
        assertEquals(expectedResult, results);
    }

    public static void verifylistofResult(WebDriver driver, String results) throws Exception {
        String sResult = null;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //String actualTitle = driver.getTitle().trim();
        //String expectedTitle = "Search - Additional Pages | Bunnings Warehouse";
        Thread.sleep(10000);
        int sResultCount = driver.findElements(By.xpath("//*[@id=\"main\"]/div[6]/div[1]/div/div[2]/div[2]/div/div/section/article")).size();
        if (sResultCount >= 1) {
            for (int i = 1; i <= sResultCount; i++) {
                //  int y = i + 2;
                try {
                    sResult = driver
                            .findElement(
                                    By.xpath("//*[@id=\"main\"]/div[6]/div[1]/div/div[2]/div[2]/div/div/section/article["
                                            + i + "]/a/div/div[2]/div[2]/p/span/span[1]"))
                            .getText();

                } catch (Exception e) {
                    System.out.println("Exception to get sResult" + e);

                }
                System.out.println("Search Result list : " + sResult);
                if (sResult.contains(results)) {
                    Assert.assertTrue("Relevant Search Results Found", true);
                } else {
                    Assert.fail("Search Result is not Relevant");
                }
            }
        } else {
            Assert.fail("No result found");

        }


    }
}

