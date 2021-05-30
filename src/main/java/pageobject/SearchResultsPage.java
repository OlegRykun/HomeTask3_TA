package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//div[@class='row js_more_content js_height-block']//div[@class='prod-cart__prise-new']")
    private List<WebElement> searchResultsProductsListText;

    @FindBy(xpath = "//div[@class='row js_more_content js_height-block']")
    private WebElement nothingFound;

    @FindBy(xpath = "//input[@class='form-control form-control-min']")
    private WebElement minInput;

    @FindBy(xpath = "//input[@class='form-control form-control-max']")
    private WebElement maxInput;

    @FindBy(xpath = "//div[@class='form-group filter-group js_filter_parent open-filter-tooltip']//span[@class='filter-tooltip-inner']")
    private WebElement findButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultsCount() {
        return getSearchResultsList().size();
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultsProductsListText;
    }

    public WebElement getNothingFound() {
        return nothingFound;
    }

    public void clearMinInput() {
        minInput.clear();
    }

    public void inputMinPrice(final String keyword) {
        minInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clearMaxInput() {
        maxInput.clear();
    }

    public void inputMaxPrice(final String keyword) {
        maxInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickFindButton() {
        findButton.click();
    }
}
