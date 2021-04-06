package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class homepage extends BaseClass {

    public homepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"headerMainMenu\"]/div[2]/div/div/div/div/input[1]")
    public static WebElement searchbox;

    @FindBy(how = How.CLASS_NAME, using = "search-container_icon-search")
    public static WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"headerMainMenu\"]/div[2]/div/div/div/div/input[1]")
    public static WebElement searchBoxplaceholder;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div[4]/div/h1/span[2]")
    public static WebElement searchResultText;
    //

}
